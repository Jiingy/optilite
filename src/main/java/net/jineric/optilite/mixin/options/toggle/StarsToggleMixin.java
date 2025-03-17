package net.jineric.optilite.mixin.options.toggle;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.jineric.optilite.client.option.GameOptionsOL;
import net.minecraft.client.gl.ShaderProgram;
import net.minecraft.client.gl.VertexBuffer;
import net.minecraft.client.render.Fog;
import net.minecraft.client.render.SkyRendering;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.SynchronousResourceReloader;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(SkyRendering.class)
public abstract class StarsToggleMixin implements SynchronousResourceReloader, AutoCloseable {
	
	@WrapWithCondition(
			method = "renderCelestialBodies",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/render/SkyRendering;renderStars(Lnet/minecraft/client/render/Fog;FLnet/minecraft/client/util/math/MatrixStack;)V"
			)
	)
	private boolean canShowStars(SkyRendering instance, Fog fog, float color, MatrixStack matrices) {
		return GameOptionsOL.getStars().getValue();
	}
}
