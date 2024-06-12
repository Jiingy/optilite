package net.jineric.optifine.mixin;

import com.llamalad7.mixinextras.injector.v2.WrapWithCondition;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.jineric.optifine.config.ConfigOF;
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
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

import java.util.function.Supplier;

@Mixin(VideoOptionsScreen.class)
public abstract class ModifyVideoOptionsScreenMixin extends GameOptionsScreen {
   public ModifyVideoOptionsScreenMixin(Screen parent, GameOptions gameOptions, Text title) {
      super(parent, gameOptions, title);
   }

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
           // shaders screen
           // performance screen
           // world screen
           // player screen
           // animations screen
           // other screen
   };

   @WrapWithCondition(
           method = "init",
           at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/OptionListWidget;addSingleOptionEntry(Lnet/minecraft/client/option/SimpleOption;)V",
           ordinal = 1)
   )
   private boolean removeBiomeBlendButtonIfDisabled(OptionListWidget instance, SimpleOption<?> option) {
      return !ConfigOF.MODIFY_OPTION_SCREENS;
   }

   @WrapOperation(
           method = "init",
           at = @At(value = "INVOKE", target = "Lnet/minecraft/client/gui/widget/OptionListWidget;addAll([Lnet/minecraft/client/option/SimpleOption;)V")
   )
   protected void replaceVideoOptionsWithOptiFineLayout(OptionListWidget instance, SimpleOption<?>[] options, Operation<Void> original) {
      if (ConfigOF.MODIFY_OPTION_SCREENS) {
         if (ConfigOF.NEW_OPTIONS_LAYOUT) {
            instance.addAll(this.newVideoOptionsLayoutOF);
         }
//         else if (ConfigOF.OLD_OPTIONS_LAYOUT) {
            // Add old OptiFine layout, replace 'options' here
//            instance.addAll(options);
//         }
      } else {
         original.call(instance, options);
      }
   }

   private static final Text REPLACE_ME = Text.translatable("Replace Me");

   @Inject(
           method = "init",
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/client/gui/screen/option/GameOptionsScreen;init()V",
                   shift = At.Shift.BEFORE
           )
   )
   private void addOptiFineOptionScreenButtons(CallbackInfo ci) {
//      GridWidget gridWidget = new GridWidget();
//      gridWidget.getMainPositioner().marginX(4).marginBottom(1).alignHorizontalCenter();
//      GridWidget.Adder adder = gridWidget.createAdder(2);
//
//      adder.add(this.createButton(REPLACE_ME, () -> new WorldOptionsScreen((VideoOptionsScreen)(Object)this, this.gameOptions)));
//      adder.add(this.createButton(REPLACE_ME, () -> new PlayerOptionsScreen((VideoOptionsScreen)(Object)this, this.gameOptions)));
//      adder.add(this.createButton(REPLACE_ME, () -> new AnimationsOptionsScreen((VideoOptionsScreen)(Object)this, this.gameOptions)));
//      adder.add(this.createButton(REPLACE_ME, () -> new OtherOptionsScreen((VideoOptionsScreen)(Object)this, this.gameOptions)));
//
//      this.layout.addBody(gridWidget);
//      this.layout.forEachChild(this::addDrawableChild);
   }

   @Unique
   private ButtonWidget createButton(Text message, Supplier<Screen> screenSupplier) {
      return ButtonWidget.builder(message, button -> this.client.setScreen((Screen)screenSupplier.get())).build();
   }
}
