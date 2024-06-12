package net.jineric.optifine.option;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.optifine.mixin.accessors.GameOptionsAccessors;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class GameOptionsOF {
// private static final Text  = Text.translatable("optifine.options..tooltip");

   private static final Text CLOUD_HEIGHT = Text.translatable("optifine.options.cloudHeight.tooltip");
   private static final SimpleOption<Double> cloudsHeightOF = new SimpleOption<>(
           "optifine.options.cloud_height",
           SimpleOption.constantTooltip(CLOUD_HEIGHT),
           (optionText, value) -> value == 0.0
                   ? GameOptions.getGenericValueText(optionText, ScreenTexts.OFF)
                   : GameOptionsAccessors.getPercentValueText(optionText, value),
           SimpleOption.DoubleSliderCallbacks.INSTANCE.withModifier(MathHelper::square, Math::sqrt),
           0.0, value -> {}
   );
   public static SimpleOption<Double> getCloudsHeightOF() {
      return cloudsHeightOF;
   }

   private static final Text SKY_TOOLTIP = Text.translatable("optifine.options.sky.tooltip");
   private static final SimpleOption<Boolean> skyEnabled = SimpleOption.ofBoolean(SKY_TOOLTIP.getString(), true);
   public static SimpleOption<Boolean> getSkyEnabled() {
      return skyEnabled;
   }


}
