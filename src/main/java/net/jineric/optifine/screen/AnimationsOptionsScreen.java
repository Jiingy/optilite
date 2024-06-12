package net.jineric.optifine.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

public class AnimationsOptionsScreen extends GameOptionsScreen {
   private static final Text ANIMATIONS_SCREEN_TITLE = Text.translatable("optifine.options.animations_options.title");

   public AnimationsOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, ANIMATIONS_SCREEN_TITLE);
   }

   @Override
   protected void init() {

   }
}
