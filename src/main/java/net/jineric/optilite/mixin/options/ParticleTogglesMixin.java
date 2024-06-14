package net.jineric.optilite.mixin.options;

import net.jineric.optilite.option.ParticleOption;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.option.ParticlesMode;
import net.minecraft.client.particle.Particle;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.particle.ParticleEffect;
import net.minecraft.particle.ParticleType;
import net.minecraft.resource.SynchronousResourceReloader;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(WorldRenderer.class)
public abstract class ParticleTogglesMixin implements SynchronousResourceReloader, AutoCloseable {

   @Shadow @Final private MinecraftClient client;
   @Shadow protected abstract ParticlesMode getRandomParticleSpawnChance(boolean canSpawnOnMinimal);

   @Inject(
           method = "spawnParticle(Lnet/minecraft/particle/ParticleEffect;ZZDDDDDD)Lnet/minecraft/client/particle/Particle;",
           at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/WorldRenderer;getRandomParticleSpawnChance(Z)Lnet/minecraft/client/option/ParticlesMode;", shift = At.Shift.AFTER),
           cancellable = true
   )
   private void spawnParticlesOnlyIfEnabled(ParticleEffect particleEffect, boolean alwaysSpawn, boolean canSpawnOnMinimal, double x, double y, double z, double velocityX, double velocityY, double velocityZ, CallbackInfoReturnable<Particle> cir) {
      Camera camera = this.client.gameRenderer.getCamera();
      if (this.client != null && camera.isReady() && this.client.particleManager != null) {
         for (ParticleType<?> particleType : ParticleOption.getParticleTypes()) {
            boolean particleOptionValue = true;
            for (ParticleOption particleOption : ParticleOption.getAllParticleOptions()) {
               particleOptionValue = particleOption.getParticleOptionValue();
            }
            if (particleEffect == particleType && !particleOptionValue) {
               cir.setReturnValue(null);
            }
         }
      }
   }
}
