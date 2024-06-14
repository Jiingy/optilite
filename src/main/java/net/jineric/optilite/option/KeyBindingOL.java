package net.jineric.optilite.option;

import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class KeyBindingOL {
   public static KeyBinding ZOOM_KEY = new KeyBinding("optilite.key.zoom", GLFW.GLFW_KEY_C, KeyBinding.MISC_CATEGORY);

   public KeyBinding getZoomKey() {
      return ZOOM_KEY;
   }
}