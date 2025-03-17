package net.jineric.optilite.client.option.fog;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.util.TranslatableOption;
import net.minecraft.util.function.ValueLists;

import java.util.function.IntFunction;

@Environment(EnvType.CLIENT)
public enum FogType implements TranslatableOption {
	DEFAULT(0, "optilite.options.fogShape.default"),
	CYLINDER(1, "optilite.options.fogShape.cylinder"),
	SPHERE(2, "optilite.options.fogShape.sphere");
	
	private static final IntFunction<FogType> BY_ID = ValueLists.createIdToValueFunction(
			FogType::getId,
			values(),
			ValueLists.OutOfBoundsHandling.WRAP
	);
	private final int id;
	private final String translationKey;
	
	FogType(final int id, String translationKey) {
		this.id = id;
		this.translationKey = translationKey;
	}
	
	@Override
	public int getId() {
		return this.id;
	}
	
	@Override
	public String getTranslationKey() {
		return this.translationKey;
	}
	
	public static FogType byId(int id) {
		return (FogType) BY_ID.apply(id);
	}
}
