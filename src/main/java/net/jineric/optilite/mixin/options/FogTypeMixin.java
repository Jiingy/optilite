package net.jineric.optilite.mixin.options;

import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.FogShape;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BackgroundRenderer.class)
public abstract class FogTypeMixin {

   @ModifyArg(
           method = "applyFog",
           at = @At(
                   value = "INVOKE",
                   target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderFogShape(Lnet/minecraft/client/render/FogShape;)V"
           )
   )
   private static FogShape setFogTypeFromOption(FogShape shaderFogShape) {

      return shaderFogShape;
   }
}
