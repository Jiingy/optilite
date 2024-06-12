package net.jineric.optifine.mixin;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.render.GameRenderer;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

@Mixin(GameRenderer.class)
public abstract class ZoomMixin implements AutoCloseable {
   @Shadow @Final MinecraftClient client;
   @Shadow private float fovMultiplier;

//   @Inject(method = "getFov",
//           at = @At(value = "INVOKE",
//                   target = "Lnet/minecraft/client/render/Camera;getFocusedEntity()Lnet/minecraft/entity/Entity;",
//                   ordinal = 0, shift = At.Shift.BEFORE
//           ), locals = LocalCapture.CAPTURE_FAILHARD
//   )
//   private void setZoomActiveIfKeypress(Camera camera, float tickDelta, boolean changingFov, CallbackInfoReturnable<Double> cir) {
//      boolean zoomActive = false;
//      if (this.client.currentScreen == null) {
//         zoomActive = GameOptionsOF.keyZoomOF.isPressed();
//      }
//
//      if (zoomActive) {
//         if (!ConfigOF.IS_ZOOM) {
//            ConfigOF.IS_ZOOM = true;
////            Config.zoomSmoothCamera = this.minecraft.options.smoothCamera;
////            this.minecraft.options.smoothCamera = true;
////            this.client.gameRenderer.;
//         }
//
//         if (ConfigOF.IS_ZOOM) {
////            d0 /= 4.0;
//            float fov = this.client.options.getFov().getValue();
//            this.fovMultiplier /= 4.0;
//         }
//      } else if (ConfigOF.IS_ZOOM) {
//         ConfigOF.IS_ZOOM = false;
////         this.minecraft.options.smoothCamera = Config.zoomSmoothCamera;
////         this.client.gameRenderer.needsUpdate();
//      }
//   }
}
