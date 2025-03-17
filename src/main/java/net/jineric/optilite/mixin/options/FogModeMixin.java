package net.jineric.optilite.mixin.options;

import net.jineric.optilite.client.option.GameOptionsOL;
import net.jineric.optilite.client.option.fog.FogMode;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.Fog;
import net.minecraft.resource.SynchronousResourceReloader;
import org.joml.Vector4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(BackgroundRenderer.class)
public abstract class FogModeMixin implements SynchronousResourceReloader, AutoCloseable {
	
	@Inject(
			method = "applyFog",
			at = @At("HEAD"),
			cancellable = true
	)
	private static void canRenderFog(Camera camera, BackgroundRenderer.FogType fogType, Vector4f color, float viewDistance, boolean thickenFog, float tickDelta, CallbackInfoReturnable<Fog> cir) {
		if (GameOptionsOL.getFogMode().getValue() == FogMode.OFF) {
			cir.setReturnValue(Fog.DUMMY);
		}
		if (fogType == BackgroundRenderer.FogType.FOG_SKY) {
			if (GameOptionsOL.getFogMode().getValue() == FogMode.TERRAIN) {
				cir.setReturnValue(Fog.DUMMY);
				
			}
		}
		if (fogType == BackgroundRenderer.FogType.FOG_TERRAIN) {
			if (GameOptionsOL.getFogMode().getValue() == FogMode.SKY) {
				//TODO: VERIFY BEHAVIOR
				BackgroundRenderer.toggleFog();
				cir.setReturnValue(Fog.DUMMY);
			}
		}
	}
}

//@Mixin(BackgroundRenderer.class)
//public abstract class FogModeMixin implements SynchronousResourceReloader, AutoCloseable {
//
//   @Inject(
//           method = "applyFog",
//           at = @At("TAIL")
//   )
//   private static void canRenderFog(
//           Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta, CallbackInfo ci,
//           @Local(index = 7) BackgroundRenderer.FogData fogData
//   ) {
//      if (GameOptionsOL.getFogMode().getValue() != FogMode.OFF) {
//         switch (fogType) {
//            case FOG_SKY -> {
//               if (GameOptionsOL.getFogMode().getValue() == FogMode.TERRAIN) {
//                  fogData.fogStart = Float.MAX_VALUE;
//                  fogData.fogEnd = Float.MAX_VALUE;
//               }
//            }
//            case FOG_TERRAIN -> {
//               if (GameOptionsOL.getFogMode().getValue() == FogMode.SKY) {
//                  BackgroundRenderer.clearFog();
//                  fogData.fogStart = Float.MAX_VALUE;
//                  fogData.fogEnd = Float.MAX_VALUE;
//               }
//            }
//         }
//      } else {
//         fogData.fogStart = Float.MAX_VALUE;
//         fogData.fogEnd = Float.MAX_VALUE;
//      }
//   }
//}
//
/// /         if (fogType == BackgroundRenderer.FogType.FOG_SKY) {
/// /            if (GameOptionsOL.getFogMode().getValue() == FogMode.TERRAIN) {
/// /               fogData.fogStart = Float.MAX_VALUE;
/// /               fogData.fogEnd = Float.MAX_VALUE;
/// /            }
/// /         } else if (GameOptionsOL.getFogMode().getValue() == FogMode.SKY) {
/// /            BackgroundRenderer.clearFog();
/// /            fogData.fogStart = Float.MAX_VALUE;
/// /            fogData.fogEnd = Float.MAX_VALUE;
/// /         }