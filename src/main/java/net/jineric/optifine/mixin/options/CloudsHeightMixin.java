package net.jineric.optifine.mixin.options;

import com.llamalad7.mixinextras.injector.ModifyExpressionValue;
import net.jineric.optifine.option.GameOptionsOF;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.resource.SynchronousResourceReloader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(WorldRenderer.class)
public abstract class CloudsHeightMixin implements SynchronousResourceReloader, AutoCloseable {

   @ModifyVariable(
           method = "renderClouds(Lnet/minecraft/client/util/math/MatrixStack;Lorg/joml/Matrix4f;Lorg/joml/Matrix4f;FDDD)V",
           at = @At(value = "STORE"), ordinal = 6
   )
   private double renderSkyIfEnabled(double original) {
      original += GameOptionsOF.getCloudsHeightOF().getValue() * 128;
      return original;
   }
}
