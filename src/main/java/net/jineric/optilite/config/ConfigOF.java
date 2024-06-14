package net.jineric.optilite.config;

public class ConfigOF {
   // Options
   private static boolean SKY_ENABLED = true;
   // Particles
   private static final boolean EXPLOSION_PARTICLES = true;

   private static boolean MODIFY_OPTION_SCREENS = true;
   private static boolean OLD_OPTIONS_LAYOUT = false;
   private static boolean NEW_OPTIONS_LAYOUT = true;

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

   public static boolean isSkyEnabled() {
      return SKY_ENABLED;
   }

   public static void setSkyEnabled(boolean skyEnabled) {
      SKY_ENABLED = skyEnabled;
   }

//   public static void setDefaultValues() {
//      SKY_ENABLED = ;
//   }
}
