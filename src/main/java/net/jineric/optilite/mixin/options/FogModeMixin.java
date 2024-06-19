package net.jineric.optilite.mixin.options;

import net.jineric.optilite.client.option.FogMode;
import net.jineric.optilite.client.option.GameOptionsOL;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.resource.SynchronousResourceReloader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(BackgroundRenderer.class)
public abstract class FogModeMixin implements SynchronousResourceReloader, AutoCloseable {

   @Inject(
           method = "applyFog",
           at = @At("HEAD"),
           cancellable = true
   )
   private static void canRenderFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci) {
      if (GameOptionsOL.getFogMode().getValue() == FogMode.OFF) {
         ci.cancel();
      }
      if (fogType == BackgroundRenderer.FogType.FOG_SKY) {
         if (GameOptionsOL.getFogMode().getValue() == FogMode.TERRAIN) {
            ci.cancel();
         }
      }
      if (fogType == BackgroundRenderer.FogType.FOG_TERRAIN) {
         if (GameOptionsOL.getFogMode().getValue() == FogMode.SKY) {
            BackgroundRenderer.clearFog();
            ci.cancel();
         }
      }
   }
}
