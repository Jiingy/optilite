package net.jineric.optilite.mixin.options.toggle;

import net.jineric.optilite.client.option.ParticleOption;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.resource.SynchronousResourceReloader;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldRenderer.class)
public abstract class ParticleTogglesMixin implements SynchronousResourceReloader, AutoCloseable {
	
	@Shadow
	@Final
	private MinecraftClient client;
	
	@Inject(
			method = "spawnParticle(Lnet/minecraft/particle/ParticleEffect;ZZDDDDDD)Lnet/minecraft/client/particle/Particle;",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/render/WorldRenderer;getRandomParticleSpawnChance(Z)Lnet/minecraft/particle/ParticlesMode;",
					shift = At.Shift.AFTER
			),
			cancellable = true
	)
	private void spawnParticlesOnlyIfEnabled(ParticleEffect particleEffectIn, boolean alwaysSpawn, boolean canSpawnOnMinimal, double x, double y, double z, double velocityX, double velocityY, double velocityZ, CallbackInfoReturnable<Particle> cir) {
		Camera camera = this.client.gameRenderer.getCamera();
		if (this.client != null && camera.isReady() && this.client.particleManager != null) {
			this.showEnabledParticleTypes(particleEffectIn, cir);
		}
	}
	
	@Unique
	private void showEnabledParticleTypes(ParticleEffect particleEffectIn, CallbackInfoReturnable<Particle> cir) {
		ParticleType<?> particleTypeIn = particleEffectIn.getType();
		ParticleOption particleOption = ParticleOption.PARTICLE_OPTIONS_MAP.get(particleTypeIn);
		if (particleOption.particleDisabled()) {
			cir.cancel();
		}
	}
}
