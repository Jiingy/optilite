package net.jineric.optilite.config;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import net.fabricmc.loader.api.FabricLoader;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

public class ConfigOL {
	
	private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
	private static boolean MODIFY_OPTION_SCREENS = true;
	private static boolean OLD_OPTIONS_LAYOUT = false;
	private static boolean NEW_OPTIONS_LAYOUT = true;
	private static boolean VANILLA_TOOLTIPS = true;
	
	private final Path configDir = FabricLoader.getInstance().getConfigDir();
	private final File file = new File("optilite-options.json");
	private final boolean value;
	private final boolean defaultValue;
	
	public ConfigOL(boolean value, boolean defaultValue) {
		this.value = value;
		this.defaultValue = defaultValue;
	}
	
	public static boolean isModifyOptionScreens() {
		return MODIFY_OPTION_SCREENS;
	}
	
	public static void setModifyOptionScreens(boolean modifyOptionScreens) {
		MODIFY_OPTION_SCREENS = modifyOptionScreens;
	}
	
	public static boolean isOldOptionsLayout() {
		return OLD_OPTIONS_LAYOUT;
	}
	
	public static void setOldOptionsLayout(boolean oldOptionsLayout) {
		OLD_OPTIONS_LAYOUT = oldOptionsLayout;
	}
	
	public static boolean isNewOptionsLayout() {
		return NEW_OPTIONS_LAYOUT;
	}
	
	public static void setNewOptionsLayout(boolean newOptionsLayout) {
		NEW_OPTIONS_LAYOUT = newOptionsLayout;
	}
	
	public static boolean isVanillaTooltips() {
		return VANILLA_TOOLTIPS;
	}
	
	public static void setVanillaTooltips(boolean vanillaTooltips) {
		VANILLA_TOOLTIPS = vanillaTooltips;
	}
	
	public void load() {
	
	}
	
	public void save() throws IOException {
		JsonArray jsonArray = new JsonArray();
		FileWriter fileWriter = new FileWriter(this.file.getName());
		GSON.toJson(jsonArray, fileWriter);

//      try () {
//
//      }
	}
}
