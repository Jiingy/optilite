package net.jineric.optilite.screen;

import net.jineric.optilite.client.option.ParticleOption;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

public class AnimationsOptionsScreen extends GameOptionsScreen {
   public static final Text TITLE_TEXT = Text.translatable("optilite.options.animationsTitle");

   public AnimationsOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, TITLE_TEXT);
   }

   @Override
   protected void addOptions() {
      for (ParticleOption particleOption : ParticleOption.getAllParticleOptions()) {
         if (this.body != null) {
            this.body.addSingleOptionEntry(particleOption.getParticleOption());
         }
      }
   }
}
