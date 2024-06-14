package net.jineric.optilite.mixin.options;

import net.jineric.optilite.option.ParticleOption;
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

   @Shadow @Final private MinecraftClient client;

   @Inject(
           method = "spawnParticle(Lnet/minecraft/particle/ParticleEffect;ZZDDDDDD)Lnet/minecraft/client/particle/Particle;",
           at = @At(value = "INVOKE", target = "Lnet/minecraft/client/render/WorldRenderer;getRandomParticleSpawnChance(Z)Lnet/minecraft/client/option/ParticlesMode;", shift = At.Shift.AFTER),
           cancellable = true
   )
   private void spawnParticlesOnlyIfEnabled(ParticleEffect particleEffect, boolean alwaysSpawn, boolean canSpawnOnMinimal, double x, double y, double z, double velocityX, double velocityY, double velocityZ, CallbackInfoReturnable<Particle> cir) {
      Camera camera = this.client.gameRenderer.getCamera();
      if (this.client != null && camera.isReady() && this.client.particleManager != null) {
         this.showEnabledParticleTypes(particleEffect, cir);
      }
   }

   @Unique
   private void showEnabledParticleTypes(ParticleEffect particleEffect, CallbackInfoReturnable<Particle> cir) {
      Camera camera = this.client.gameRenderer.getCamera();
      if (this.client != null && camera.isReady() && this.client.particleManager != null) {
         //TODO: This code can definitely be improved

         // Sort through all registered particle types
//         for (ParticleType<?> registeredParticleTypes : ParticleOption.getParticleTypes()) {

         // Sort through all particle options
         for (ParticleOption particleOption : ParticleOption.getAllParticleOptions()) {
            ParticleType<?> particleType = particleOption.getParticleType();
            boolean particleOptionValue = particleOption.getParticleOptionValue();
            // If the particle to be displayed is enabled and matches a particle option, show it
            if (particleEffect == particleType && !particleOptionValue) {
               cir.setReturnValue(null);
            }
         }
//         }
      }
   }
}
