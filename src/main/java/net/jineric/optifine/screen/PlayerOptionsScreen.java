package net.jineric.optifine.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

public class PlayerOptionsScreen extends GameOptionsScreen {
   private static final Text PLAYER_SCREEN_TITLE = Text.translatable("optifine.options.player_options.title");

   public PlayerOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, PLAYER_SCREEN_TITLE);
   }

   @Override
   protected void init() {

   }
}
