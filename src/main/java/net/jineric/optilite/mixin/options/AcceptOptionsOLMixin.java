package net.jineric.optilite.mixin.options;

import net.jineric.optilite.client.option.GameOptionsOL;
import net.jineric.optilite.client.option.ParticleOption;
import net.jineric.optilite.util.StringUtilsOL;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(GameOptions.class)
public abstract class AcceptOptionsOLMixin {
	
	@Inject(
			method = "acceptProfiledOptions",
			at = @At("HEAD")
	)
	private void acceptOptionsOL(GameOptions.OptionVisitor visitor, CallbackInfo ci) {
		// TODO: Should ideally not be adding to the vanilla config file, but rather a custom modded one.
		for (ParticleType<?> particleType : Registries.PARTICLE_TYPE) {
			String path = Registries.PARTICLE_TYPE.getId(particleType).getPath();
			SimpleOption<Boolean> simpleOption = ParticleOption.PARTICLE_OPTIONS_MAP.get(particleType).getSimpleOption();
			visitor.accept("optilite.options." + StringUtilsOL.snakeToCamelCase(path), simpleOption);
		}
		visitor.accept("optilite.options.sun", GameOptionsOL.getSun());
		visitor.accept("optilite.options.moon", GameOptionsOL.getMoon());
	}
}
