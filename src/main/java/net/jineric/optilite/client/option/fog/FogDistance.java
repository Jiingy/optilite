package net.jineric.optilite.client.option.fog;


import net.minecraft.util.TranslatableOption;
import net.minecraft.util.function.ValueLists;

import java.util.function.IntFunction;

public enum FogDistance implements TranslatableOption {
	DEFAULT(0, "optilite.options.fogDistance.default"),
	DISTANT(1, "optilite.options.fogDistance.distant"),
	FAR(2, "optilite.options.fogDistance.far"),
	CLOSE(3, "optilite.options.fogDistance.close"),
	NEARBY(4, "optilite.options.fogDistance.nearby");
	
	private static final IntFunction<FogDistance> BY_ID = ValueLists.createIdToValueFunction(
			FogDistance::getId,
			values(),
			ValueLists.OutOfBoundsHandling.WRAP
	);
	private final int id;
	private final String translationKey;
	
	FogDistance(final int id, String translationKey) {
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
	
	public static FogDistance byId(int id) {
		return BY_ID.apply(id);
	}
}
