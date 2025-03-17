package net.jineric.optilite.mixin.options.toggle;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.jineric.optilite.client.option.GameOptionsOL;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.SynchronousResourceReloader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SkyRendering.class)
public abstract class SunToggleMixin implements SynchronousResourceReloader, AutoCloseable {
	// SUN
	@WrapWithCondition(
			method = "renderCelestialBodies",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/render/SkyRendering;renderSun(FLnet/minecraft/client/render/VertexConsumerProvider;Lnet/minecraft/client/util/math/MatrixStack;)V"
			)
	)
	private boolean canRenderSky(SkyRendering instance, float alpha, VertexConsumerProvider vertexConsumers, MatrixStack matrices) {
		return GameOptionsOL.getSun().getValue();
	}
}
