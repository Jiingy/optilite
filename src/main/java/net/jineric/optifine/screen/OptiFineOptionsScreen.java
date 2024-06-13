package net.jineric.optifine.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.optifine.option.GameOptionsOF;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class OptiFineOptionsScreen extends GameOptionsScreen {
   private static final Text OPTIFINE_TITLE = Text.translatable("optifine.options.optifine_options.title");

   public OptiFineOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, OPTIFINE_TITLE);
   }

   @Override
   protected void init() {
      this.addDrawableChild(GameOptionsOF.getCloudsHeightOF().createWidget(this.gameOptions, this.width / 2, this.height / 2, 150));
      this.addDrawableChild(GameOptionsOF.getSkyEnabled().createWidget(this.gameOptions, this.width / 2 , this.height / 2 + 30, 150));
   }
}
