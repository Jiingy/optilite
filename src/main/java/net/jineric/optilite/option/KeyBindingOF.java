package net.jineric.optilite.option;

import net.minecraft.client.option.KeyBinding;
import org.lwjgl.glfw.GLFW;

public class KeyBindingOF {
   public static KeyBinding keyZoomOF = new KeyBinding("optilite.key.zoom", GLFW.GLFW_KEY_C, KeyBinding.MISC_CATEGORY);

   public KeyBinding getFOV() {
      return keyZoomOF;
   }
}