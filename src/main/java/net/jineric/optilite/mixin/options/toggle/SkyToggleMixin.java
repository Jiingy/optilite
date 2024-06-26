package net.jineric.optilite.mixin.options.toggle;

import net.jineric.optilite.client.option.GameOptionsOL;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.resource.SynchronousResourceReloader;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public abstract class SkyToggleMixin implements SynchronousResourceReloader, AutoCloseable {

   @Inject(
           method = "renderSky(Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FLnet/minecraft/client/render/Camera;ZLjava/lang/Runnable;)V",
           at = @At(value = "HEAD"),
           cancellable = true
   )
   private void renderSkyIfEnabled(Matrix4f matrix4f, Matrix4f projectionMatrix, float tickDelta, Camera camera, boolean thickFog, Runnable fogCallback, CallbackInfo ci) {
      // Poor implementation currently. Method is entirely canceled which is bad on its own, but also disables other sky rendering like fog.
      if (!GameOptionsOL.getSky().getValue()) {
         ci.cancel();
      }
   }
}
