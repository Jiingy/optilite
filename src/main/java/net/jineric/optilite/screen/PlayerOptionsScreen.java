package net.jineric.optilite.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

public class PlayerOptionsScreen extends GameOptionsScreen {
   public static final Text TITLE_TEXT = Text.translatable("optilite.options.playerTitle");

   public PlayerOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, TITLE_TEXT);
   }

   @Override
   protected void addOptions() {

   }
}
