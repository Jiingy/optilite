package net.jineric.optilite.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

public class OtherOptionsScreen extends GameOptionsScreen {
   public static final Text OTHER_TEXT = Text.translatable("optilite.options.otherTitle");

   public OtherOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, OTHER_TEXT);
   }

   @Override
   protected void addOptions() {

   }


}
