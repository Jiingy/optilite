package net.jineric.optifine.mixin;

import net.jineric.optifine.screen.OptiFineOptionsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.OptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(OptionsScreen.class)
public abstract class GameOptionsScreen extends Screen {
   @Shadow @Final private GameOptions settings;
   protected GameOptionsScreen(Text title) {
      super(title);
   }

   @Unique
   private static final Text OPTIFINE_TEXT = Text.translatable("optifine.options.optifine_options");

   @Inject(
           method = "init",
           at = @At("HEAD")
   )
   private void addOptiFineButton(CallbackInfo ci) {
      this.addDrawableChild(ButtonWidget.builder(OPTIFINE_TEXT, button -> this.client.setScreen(new OptiFineOptionsScreen(this, this.settings)))
              .dimensions((this.width / 2), (this.height / 2) + 80, 150, 20)
              .build()
      );
   }
}
