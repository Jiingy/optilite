package net.jineric.optilite.mixin.options;

import net.jineric.optilite.client.option.GameOptionsOL;
import net.jineric.optilite.client.option.fog.FogDistance;
import net.minecraft.client.render.BackgroundRenderer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyArg;

@Mixin(BackgroundRenderer.class)
public abstract class FogDistanceMixin {
	
	@ModifyArg(
			method = "applyFog",
			at = @At(
					value = "INVOKE",
					target = "Lnet/minecraft/client/render/Fog;<init>(FFLnet/minecraft/client/render/FogShape;FFFF)V"
			),
			index = 0
	)
	private static float setFogDistanceFromOption(float shaderFogStart) {
		if (GameOptionsOL.getFogDistance().getValue() == FogDistance.NEARBY) {
			return shaderFogStart * 0.025f;
		} else if (GameOptionsOL.getFogDistance().getValue() == FogDistance.CLOSE) {
			return shaderFogStart * 0.2f;
		} else if (GameOptionsOL.getFogDistance().getValue() == FogDistance.FAR) {
			return shaderFogStart * 0.35f;
		} else if (GameOptionsOL.getFogDistance().getValue() == FogDistance.DISTANT) {
			return shaderFogStart * 0.6f;
		} else {
			return shaderFogStart;
		}
	}
}
