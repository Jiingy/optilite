package net.jineric.optilite.config;

import net.jineric.optilite.client.option.GameOptionsOL;

public class ConfigOL {
   private static boolean MODIFY_OPTION_SCREENS = true;
   private static boolean OLD_OPTIONS_LAYOUT = false;
   private static boolean NEW_OPTIONS_LAYOUT = true;
   private static boolean VANILLA_TOOLTIPS = true;

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
}
