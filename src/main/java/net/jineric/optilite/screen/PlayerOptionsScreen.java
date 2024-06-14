package net.jineric.optilite.screen;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

public class PlayerOptionsScreen extends GameOptionsScreen {
   public static final Text TITLE_TEXT = Text.translatable("optilite.options.playerTitle");

   public PlayerOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, TITLE_TEXT);
   }

   private static SimpleOption<?>[] getOptions(GameOptions gameOptions) {
      return new SimpleOption[] {
              gameOptions.getGuiScale(),
              // vignette
              // dynamic fov
              gameOptions.getFovEffectScale(),
              // TODO: Add a check for Iris' view bobbing mod and change entries if applicable
              gameOptions.getBobView(),
              gameOptions.getDistortionEffectScale(),
              // dynamic lights
              // gamma (?) -- maybe more of a world thing
              gameOptions.getAttackIndicator(),
              // tooltips

              // TODO: Add any newer settings within recent versions that are missing. Both vanilla and OF
      };
   }

   @Override
   protected void addOptions() {
      if (this.body != null) {
         this.body.addAll(getOptions(this.gameOptions));
      }
   }
}
