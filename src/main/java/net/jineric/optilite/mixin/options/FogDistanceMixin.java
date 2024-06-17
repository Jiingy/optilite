package net.jineric.optilite.mixin.options;

import net.jineric.optilite.client.option.FogDistance;
import net.jineric.optilite.client.option.GameOptionsOL;
import net.minecraft.client.render.BackgroundRenderer;
import net.minecraft.client.render.Camera;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryKey;
import net.minecraft.world.World;
import net.minecraft.world.dimension.DimensionType;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BackgroundRenderer.class)
public abstract class FogDistanceMixin {

   @ModifyArg(
           method = "applyFog",
           at = @At(
                   value = "INVOKE",
                   target = "Lcom/mojang/blaze3d/systems/RenderSystem;setShaderFogStart(F)V"
           )
   )
   private static float setFogDistanceFromOption(float shaderFogStart) {
      if (GameOptionsOL.getFogDistance().getValue() == FogDistance.NEARBY) {
         return shaderFogStart * 0.1f;
      } else if (GameOptionsOL.getFogDistance().getValue() == FogDistance.CLOSE) {
         return shaderFogStart * 0.2f;
      } else if (GameOptionsOL.getFogDistance().getValue() == FogDistance.FAR) {
         return shaderFogStart * 0.4f;
      } else if (GameOptionsOL.getFogDistance().getValue() == FogDistance.DISTANT) {
         return shaderFogStart * 0.8f;
      } else {
         return shaderFogStart;
      }
   }
}
