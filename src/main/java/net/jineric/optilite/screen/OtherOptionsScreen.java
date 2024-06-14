package net.jineric.optilite.screen;

import net.jineric.optilite.option.GameOptionsOL;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

public class OtherOptionsScreen extends GameOptionsScreen {
   public static final Text OTHER_TEXT = Text.translatable("optilite.options.otherTitle");

   public OtherOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, OTHER_TEXT);
   }

   private static SimpleOption<?>[] getOptions(GameOptions gameOptions) {
      return new SimpleOption[] {
              // OF quick display (fps and whatnot) (?) -- maybe player setting
              // debug profiler
              // show GL errors
              // autosave interval
              gameOptions.getShowAutosaveIndicator(),
              // lagometer
              GameOptionsOL.getAdvancedTooltips()
      };
   }

   @Override
   protected void addOptions() {
      if (this.body != null) {
         this.body.addAll(getOptions(this.gameOptions));
      }
   }
}
