package net.jineric.optilite.mixin;

import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.mojang.serialization.Codec;
import net.jineric.optilite.config.ConfigOL;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gl.Framebuffer;
import net.minecraft.client.gui.tooltip.Tooltip;
import net.minecraft.client.option.CloudRenderMode;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.*;
import org.spongepowered.asm.mixin.injection.*;

import java.util.Arrays;
import java.util.function.Consumer;

@Mixin(GameOptions.class)
public abstract class AddGameOptionTooltipsMixin {

   @WrapOperation(
           method = "<init>",
           slice = @Slice(
                   from = @At(value = "CONSTANT", args = "stringValue=options.entityShadows")
           ),
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/client/option/SimpleOption;ofBoolean(Ljava/lang/String;Z)Lnet/minecraft/client/option/SimpleOption;",
                   ordinal = 0
           )
   )
   private SimpleOption<Boolean> addEntityShadowsTooltip(String key, boolean defaultValue, Operation<SimpleOption<Boolean>> original) {
      if (ConfigOL.isVanillaTooltips()) {
         return SimpleOption.ofBoolean("options.entityShadows", SimpleOption.constantTooltip(Text.translatable("options.tooltip.entityShadows")), true);
      } else {
         return original.call(key, defaultValue);
      }
   }


   @WrapOperation(
           method = "<init>",
           slice = @Slice(
                   from = @At(value = "CONSTANT", args = "stringValue=options.ao")
           ),
           at = @At(
                   value = "INVOKE",
                   target = "Lnet/minecraft/client/option/SimpleOption;ofBoolean(Ljava/lang/String;ZLjava/util/function/Consumer;)Lnet/minecraft/client/option/SimpleOption;",
                   ordinal = 0
           )
   )
   private SimpleOption<Boolean> addSmoothLightingTooltip(String key, boolean defaultValue, Consumer<Boolean> changeCallback, Operation<SimpleOption<Boolean>> original) {
      if (ConfigOL.isVanillaTooltips()) {
         return SimpleOption.ofBoolean("options.ao", SimpleOption.constantTooltip(Text.translatable("options.tooltip.ao")), true);
      } else {
         return original.call(key, defaultValue, changeCallback);
      }
   }


   @WrapOperation(
           method = "<init>",
//           slice = @Slice(
//                   from = @At(
//                           value = "CONSTANT",
//                           args = "stringValue=options.renderClouds",
//                           ordinal = 0
//                   )
//           ),
           at = @At(
                   value = "NEW",
target = "(Ljava/lang/String;Lnet/minecraft/client/option/SimpleOption$TooltipFactory;Lnet/minecraft/client/option/SimpleOption$ValueTextGetter;Lnet/minecraft/client/option/SimpleOption$Callbacks;Ljava/lang/Object;Ljava/util/function/Consumer;)Lnet/minecraft/client/option/SimpleOption;",
                   args = "stringValue=options.renderClouds",
                   ordinal = 3
           )
   )
   private SimpleOption<CloudRenderMode> addCloudRenderModeTooltip(String key, SimpleOption.TooltipFactory<CloudRenderMode> tooltipFactory, SimpleOption.ValueTextGetter<CloudRenderMode> valueTextGetter, SimpleOption.Callbacks<CloudRenderMode> callbacks, Object defaultValue, Consumer<CloudRenderMode> changeCallback, Operation<SimpleOption<CloudRenderMode>> original) {
      if (ConfigOL.isVanillaTooltips()) {
         return new SimpleOption<>(
           "options.renderClouds",
           value -> switch(value) {
              case CloudRenderMode.OFF -> Tooltip.of(Text.translatable("options.tooltip.clouds.off"));
              case CloudRenderMode.FAST -> Tooltip.of(Text.translatable("options.tooltip.clouds.fast"));
              case CloudRenderMode.FANCY -> Tooltip.of(Text.translatable("options.tooltip.clouds.fancy"));
           },
           SimpleOption.enumValueText(),
           new SimpleOption.PotentialValuesBasedCallbacks<>(
                   Arrays.asList(CloudRenderMode.values()),
                   Codec.withAlternative(CloudRenderMode.CODEC, Codec.BOOL, value -> value ? CloudRenderMode.FANCY : CloudRenderMode.OFF)
           ),
           CloudRenderMode.FANCY,
           cloudRenderMode -> {
              if (MinecraftClient.isFabulousGraphicsOrBetter()) {
                 Framebuffer framebuffer = MinecraftClient.getInstance().worldRenderer.getCloudsFramebuffer();
                 if (framebuffer != null) {
                    framebuffer.clear(MinecraftClient.IS_SYSTEM_MAC);
                 }
              }
           });
      } else {
         return original.call(key, tooltipFactory, valueTextGetter, callbacks, defaultValue, changeCallback);
      }
   }


//   @Mutable @Shadow @Final
//   private SimpleOption<Boolean> entityShadows;
//
//   @Inject(method = "<init>", at = @At("TAIL"))
//   private void setOptionTooltipTexts(CallbackInfo ci) {
//      if (ConfigOL.isVanillaTooltips()) {
//         entityShadows = SimpleOption.ofBoolean("options.entityShadows", SimpleOption.constantTooltip(Text.translatable("optilite.options.tooltip.entityShadows")), true);
//      }
//   }
}
