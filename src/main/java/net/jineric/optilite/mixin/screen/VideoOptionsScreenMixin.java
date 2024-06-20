package net.jineric.optilite.mixin.screen;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.jineric.optilite.config.ConfigOL;
import net.jineric.optilite.screen.animations.AnimationOptionsScreen;
import net.jineric.optilite.screen.OtherOptionsScreen;
import net.jineric.optilite.screen.PlayerOptionsScreen;
import net.jineric.optilite.screen.WorldOptionsScreen;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.screen.option.VideoOptionsScreen;
import net.minecraft.client.gui.widget.ButtonWidget;
import net.minecraft.client.gui.widget.OptionListWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;

@Mixin(VideoOptionsScreen.class)
public abstract class VideoOptionsScreenMixin extends GameOptionsScreen {
   private static final Text TEMP_BUTTON_TEXT = Text.translatable("Temp...");

   @Unique private static final Text ANIMATIONS_TEXT = Text.translatable("optilite.options.animations");
   @Unique private static final Text OTHER_TEXT = Text.translatable("optilite.options.other");
   @Unique private static final Text PLAYER_TEXT = Text.translatable("optilite.options.player");
   @Unique private static final Text WORLD_TEXT = Text.translatable("optilite.options.world");


   public VideoOptionsScreenMixin(Screen parent, GameOptions gameOptions, Text title) {
      super(parent, gameOptions, title);
   }

   @Unique
   private final SimpleOption<?>[] oldVideoOptionsLayoutOF = new SimpleOption<?>[] {
           this.gameOptions.getGraphicsMode(),
           this.gameOptions.getViewDistance(),
           this.gameOptions.getAo(),
           this.gameOptions.getMaxFps(), // This is vanilla, it does not change to "VSync" when slid to the left-most side
           // get smooth lighting level
           this.gameOptions.getBobView(),
           this.gameOptions.getGuiScale(),
           this.gameOptions.getEntityShadows(),
           this.gameOptions.getGamma(),
           this.gameOptions.getAttackIndicator(),
           // dynamic lights
           // dynamic FOV
           // shaders...
           // quality...
           // details...
           // performance...
           // animations...
           // other...
   };

   @Unique
   private final SimpleOption<?>[] newVideoOptionsLayoutOF = new SimpleOption<?>[] {
           this.gameOptions.getFullscreen(),
           this.gameOptions.getMaxFps(),
           this.gameOptions.getGraphicsMode(),
           this.gameOptions.getEntityDistanceScaling(),
           this.gameOptions.getAo(),
           this.gameOptions.getViewDistance(),
           // get smooth lighting level
           this.gameOptions.getSimulationDistance(),
           this.gameOptions.getMipmapLevels(),
           // get mipmap type
           // get anisotropic filtering
           // get anti-aliasing
   };


   @WrapWithCondition(
           method = "addOptions",
           at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/OptionListWidget;addSingleOptionEntry(Lnet/minecraft/client/option/SimpleOption;)V",
           ordinal = 1)
   )
   private boolean removeBiomeBlendButtonIfDisabled(OptionListWidget instance, SimpleOption<?> option) {
      return !ConfigOL.isModifyOptionScreens();
   }

   @WrapOperation(
           method = "addOptions",
           at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/OptionListWidget;addAll([Lnet/minecraft/client/option/SimpleOption;)V")
   )
   protected void replaceVideoOptionsWithOptiFineLayout(OptionListWidget instance, SimpleOption<?>[] options, Operation<Void> original) {
      if (ConfigOL.isModifyOptionScreens()) {
         if (ConfigOL.isNewOptionsLayout()) {
            instance.addAll(this.newVideoOptionsLayoutOF);
            instance.addWidgetEntry(
                    ButtonWidget.builder(WORLD_TEXT, _ -> this.client.setScreen(new WorldOptionsScreen((VideoOptionsScreen)(Object)this, this.gameOptions))).build(),
                    ButtonWidget.builder(PLAYER_TEXT, _ -> this.client.setScreen(new PlayerOptionsScreen((VideoOptionsScreen)(Object)this, this.gameOptions))).build()
            );
            instance.addWidgetEntry(
                    ButtonWidget.builder(ANIMATIONS_TEXT, _ -> this.client.setScreen(new AnimationOptionsScreen((VideoOptionsScreen)(Object)this, this.gameOptions))).build(),
                    ButtonWidget.builder(OTHER_TEXT, _ -> this.client.setScreen(new OtherOptionsScreen((VideoOptionsScreen)(Object)this, this.gameOptions))).build()
            );
//            instance.addWidgetEntry(
//                    ButtonWidget.builder(TEMP_BUTTON_TEXT, button -> this.client.setScreen(new SHADER((VideoOptionsScreen)(Object)this, this.gameOptions))).build(),
//                    ButtonWidget.builder(TEMP_BUTTON_TEXT, button -> this.client.setScreen(new PERFORMANCE((VideoOptionsScreen)(Object)this, this.gameOptions))).build()
//            );
         }
         else if (ConfigOL.isOldOptionsLayout()) {
            instance.addAll(this.oldVideoOptionsLayoutOF);
//            instance.addWidgetEntry(
//                    ButtonWidget.builder(TEMP_BUTTON_TEXT, button -> this.client.setScreen(new SHADER((VideoOptionsScreen)(Object)this, this.gameOptions))).build(),
//                    ButtonWidget.builder(TEMP_BUTTON_TEXT, button -> this.client.setScreen(new QUALITY((VideoOptionsScreen)(Object)this, this.gameOptions))).build()
//            );
//            instance.addWidgetEntry(
//                    ButtonWidget.builder(TEMP_BUTTON_TEXT, button -> this.client.setScreen(new DETAILS((VideoOptionsScreen)(Object)this, this.gameOptions))).build(),
//                    ButtonWidget.builder(TEMP_BUTTON_TEXT, button -> this.client.setScreen(new PERFORMANCE((VideoOptionsScreen)(Object)this, this.gameOptions))).build()
//            );
            instance.addWidgetEntry(
                    ButtonWidget.builder(ANIMATIONS_TEXT, _ -> this.client.setScreen(new AnimationOptionsScreen((VideoOptionsScreen)(Object)this, this.gameOptions))).build(),
                    ButtonWidget.builder(TEMP_BUTTON_TEXT, _ -> this.client.setScreen(new AnimationOptionsScreen((VideoOptionsScreen)(Object)this, this.gameOptions))).build()
            );
         }
      } else {
         original.call(instance, options);
      }
   }
}
