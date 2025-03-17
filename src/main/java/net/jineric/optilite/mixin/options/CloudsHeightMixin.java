package net.jineric.optilite.mixin.options;

import net.jineric.optilite.client.option.GameOptionsOL;
import net.minecraft.client.render.CloudRenderer;
import net.minecraft.client.render.WorldRenderer;
import net.minecraft.resource.SynchronousResourceReloader;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;

@Mixin(CloudRenderer.class)
public abstract class CloudsHeightMixin implements SynchronousResourceReloader, AutoCloseable {
	
	@ModifyVariable(
			method = "renderClouds(ILnet/minecraft/client/option/CloudRenderMode;FLorg/joml/Matrix4f;Lorg/joml/Matrix4f;Lnet/minecraft/util/math/Vec3d;F)V",
			at = @At("STORE"),
			ordinal = 2
	)
	private float renderSkyIfEnabled(float original) {
		original += (float) (GameOptionsOL.getCloudsHeight().getValue() * 128);
		return original;
	}
}
