package net.jineric.optilite.screen.animations;

import net.jineric.optilite.client.option.ParticleOption;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.DirectionalLayoutWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

public class AnimationOptionsScreen extends GameOptionsScreen {
   public static final Text TITLE_TEXT = Text.translatable("optilite.options.animationsTitle");

   public AnimationOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, TITLE_TEXT);
   }

   @Override
   protected void addOptions() {
      if (this.body != null) {
         this.body.addSingleOptionEntry(gameOptions.getParticles());
         for (ParticleOption particleOption : ParticleOption.getAllParticleOptions()) {
            this.body.addSingleOptionEntry(particleOption.getParticleOption());
         }
      }
   }
}
