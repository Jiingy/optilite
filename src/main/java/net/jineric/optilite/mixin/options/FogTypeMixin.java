package net.jineric.optilite.mixin.options;

import net.jineric.optilite.client.option.GameOptionsOL;
import net.jineric.optilite.client.option.fog.FogType;
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
					target = "Lnet/minecraft/client/render/Fog;<init>(FFLnet/minecraft/client/render/FogShape;FFFF)V"
			),
			index = 2
	)
	private static FogShape setFogTypeFromOption(FogShape shaderFogShape) {
		//TODO: VERIFY NEW MIXIN TARGET
		if (GameOptionsOL.getFogType().getValue() == FogType.SPHERE) {
			return FogShape.SPHERE;
		} else if (GameOptionsOL.getFogType().getValue() == FogType.CYLINDER) {
			return FogShape.CYLINDER;
		} else {
			return shaderFogShape;
		}
	}
}
