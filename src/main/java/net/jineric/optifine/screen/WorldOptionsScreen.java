package net.jineric.optifine.screen;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;

@Environment(EnvType.CLIENT)
public class WorldOptionsScreen extends GameOptionsScreen {
   private static final Text WORLD_SCREEN_TITLE = Text.translatable("optifine.options.world_options.title");

   public WorldOptionsScreen(Screen parent, GameOptions gameOptions) {
      super(parent, gameOptions, WORLD_SCREEN_TITLE);
   }

   @Override
   protected void init() {

   }
}
