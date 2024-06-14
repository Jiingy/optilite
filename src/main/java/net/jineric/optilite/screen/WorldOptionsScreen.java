package net.jineric.optilite.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.optilite.option.GameOptionsOF;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class WorldOptionsScreen extends GameOptionsScreen {
   public static final Text TITLE_TEXT = Text.translatable("optilite.options.worldTitle");

   public WorldOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, TITLE_TEXT);
   }

   private static SimpleOption<?>[] getOptions(GameOptions gameOptions) {
      return new SimpleOption[] {
              gameOptions.getCloudRenderMode(),
              // fog
              GameOptionsOF.getCloudsHeightOF(),
              // fog start
              // sun & moon
              // stars
              // sky
              // swamp colors
              // rain & snow
              // better snow
              // alternate blocks
              // entity shadows
              // trees
              // better grass
              // translucent blocks
              // connected textures --- possibly move
//            gameOptions.getBiomeBlendRadius()
      };
   }

   @Override
   protected void addOptions() {

      this.body.addAll(getOptions(this.gameOptions));
      this.body.addSingleOptionEntry(this.gameOptions.getBiomeBlendRadius());
   }
}
