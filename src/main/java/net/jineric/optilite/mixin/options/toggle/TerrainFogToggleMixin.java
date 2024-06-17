package net.jineric.optilite.mixin.options.toggle;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.jineric.optilite.client.option.GameOptionsOL;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.resource.SynchronousResourceReloader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(WorldRenderer.class)
public abstract class TerrainFogToggleMixin implements SynchronousResourceReloader, AutoCloseable {

//   @WrapWithCondition(
//           method = "render",
//           at = @At(
//                   value = "INVOKE",
//                   target = "Lnet/minecraft/client/render/BackgroundRenderer;applyFog(Lnet/minecraft/client/render/Camera;Lnet/minecraft/client/render/BackgroundRenderer$FogType;FZF)V"
//           )
//   )
//   private boolean canRenderFog(Camera camera, BackgroundRenderer.FogType fogType, float viewDistance, boolean thickFog, float tickDelta) {
//      return !GameOptionsOL.getFog().getValue();
//   }
}
