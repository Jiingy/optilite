package net.jineric.optilite.screen;

import net.jineric.optilite.option.ParticleOption;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.OptionListWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

public class AnimationsOptionsScreen extends GameOptionsScreen {
   public static final Text TITLE_TEXT = Text.translatable("optilite.options.animationsTitle");
   private OptionListWidget list;

   public AnimationsOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, TITLE_TEXT);
   }

   @Override
   protected void addOptions() {
      this.list = (OptionListWidget)this.addDrawableChild(new OptionListWidget(this.client, this.width, this));
      for (ParticleOption particleOption : ParticleOption.getAllParticleOptions()) {
         this.list.addSingleOptionEntry(particleOption.getParticleOption());
      }
   }
}
