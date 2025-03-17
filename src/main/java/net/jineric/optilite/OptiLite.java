package net.jineric.optilite;

import net.fabricmc.api.ModInitializer;
import net.minecraft.util.Identifier;

public class OptiLite implements ModInitializer {
	public static final String MOD_ID = "optilite";
	
	public static Identifier ofJineric(String path) {
		return Identifier.of(MOD_ID, path);
	}
	
	@Override
	public void onInitialize() {
	}
}
