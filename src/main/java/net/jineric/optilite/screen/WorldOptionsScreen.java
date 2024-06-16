package net.jineric.optilite.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.optilite.option.GameOptionsOL;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

import java.lang.reflect.Array;

@Environment(EnvType.CLIENT)
public class WorldOptionsScreen extends GameOptionsScreen {
   public static final Text TITLE_TEXT = Text.translatable("optilite.options.worldTitle");

   public WorldOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, TITLE_TEXT);
   }

   private static SimpleOption<?>[] getOptions(GameOptions gameOptions) {
      return new SimpleOption[] {
              gameOptions.getCloudRenderMode(),
              // TODO: Add variable fog level
              GameOptionsOL.getFog(),
              GameOptionsOL.getCloudsHeight(),
              // fog start
              GameOptionsOL.getSunMoon(),
              GameOptionsOL.getStars(),
              GameOptionsOL.getSky(),
              // swamp colors
              // rain & snow
              // better snow
              // alternate blocks
              gameOptions.getEntityShadows()
              // trees
              // better grass
              // translucent blocks
              // connected textures --- possibly move
//            gameOptions.getBiomeBlendRadius()
      };
   }

   @Override
   protected void addOptions() {
      if (this.body != null) {
         this.body.addSingleOptionEntry(this.gameOptions.getBiomeBlendRadius());
         this.body.addAll(getOptions(this.gameOptions));
      }
   }
}
