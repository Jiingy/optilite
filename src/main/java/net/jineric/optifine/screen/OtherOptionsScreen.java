package net.jineric.optifine.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

public class OtherOptionsScreen extends GameOptionsScreen {
   private static final Text OTHER_SCREEN_TITLE = Text.translatable("optifine.options.other_options.title");

   public OtherOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, OTHER_SCREEN_TITLE);
   }

   @Override
   protected void init() {

   }
}
