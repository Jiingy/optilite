package net.jineric.optilite.mixin.options.toggle;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import net.jineric.optilite.client.option.GameOptionsOL;
import net.minecraft.client.render.*;
import net.minecraft.client.util.math.MatrixStack;
import net.minecraft.resource.SynchronousResourceReloader;
import org.joml.Matrix4f;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(WorldRenderer.class)
public abstract class SkyToggleMixin implements SynchronousResourceReloader, AutoCloseable {
	
	@Inject(
			method = "renderSky",
			at = @At(value = "HEAD"),
			cancellable = true
	)
	private void renderSkyIfEnabled(FrameGraphBuilder frameGraphBuilder, Camera camera, float tickDelta, Fog fog, CallbackInfo ci) {
		// Poor implementation currently. Method is entirely canceled which is bad on its own, but also disables other sky rendering like fog.
		//TODO: MIXIN METHOD TARGET CHANGED, VERIFY
		if (!GameOptionsOL.getSky().getValue()) {
			ci.cancel();
		}
	}
}
