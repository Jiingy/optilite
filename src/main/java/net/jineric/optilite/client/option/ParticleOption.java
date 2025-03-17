package net.jineric.optilite.client.option;

import com.google.common.collect.Maps;
import net.jineric.optilite.util.StringUtilsOL;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;
import net.minecraft.text.Text;
import net.minecraft.util.Util;

import java.util.Map;

public class ParticleOption {
	private final SimpleOption<Boolean> simpleOption;
	private final ParticleType<?> particleType;
	public static Map<ParticleType<?>, ParticleOption> PARTICLE_OPTIONS_MAP = Util.make(
			Maps.newHashMap(), particleTypeParticleOptionHashMap -> {
				for (ParticleType<?> particleType : Registries.PARTICLE_TYPE) {
					String particleTypePath = Registries.PARTICLE_TYPE.getId(particleType).getPath();
					Text translation = Text.translatable("optilite.options.particle." + StringUtilsOL.snakeToCamelCase(particleTypePath));
					particleTypeParticleOptionHashMap.put(particleType, register(translation, particleType));
				}
			});
	
	public ParticleOption(SimpleOption<Boolean> booleanSimpleOption, ParticleType<?> particleType) {
		this.simpleOption = booleanSimpleOption;
		this.particleType = particleType;
	}
	
	public ParticleType<?> getParticleType() {
		return particleType;
	}
	
	public SimpleOption<Boolean> getSimpleOption() {
		return this.simpleOption;
	}
	
	public boolean particleTypeMatch(ParticleType<?> particleType) {
		return this.particleType == particleType;
	}
	
	public boolean particleDisabled() {
		return !this.simpleOption.getValue();
	}
	
	private static ParticleOption register(Text translation, ParticleType<?> particleType) {
		return new ParticleOption(SimpleOption.ofBoolean(translation.getString(), true), particleType);
	}
}
