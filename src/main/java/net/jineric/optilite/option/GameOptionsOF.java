package net.jineric.optilite.option;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.optilite.mixin.accessors.GameOptionsAccessors;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

@Environment(EnvType.CLIENT)
public class GameOptionsOF {
// private static final Text  = Text.translatable("optilite.options..tooltip");

   private static final Text CLOUD_HEIGHT = Text.translatable("optilite.options.cloudHeight");
   private static final SimpleOption<Double> cloudsHeightOF = new SimpleOption<>(
           "optilite.options.cloud_height",
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

   private static final Text SKY_TOOLTIP = Text.translatable("optilite.options.sky");
   private static final SimpleOption<Boolean> skyEnabled = SimpleOption.ofBoolean(SKY_TOOLTIP.getString(), true);
   public static SimpleOption<Boolean> getSkyEnabled() {
      return skyEnabled;
   }



// PARTICLE OPTIONS
   private static final Text ANGRY_VILLAGER_PARTICLE_TOOLTIP = Text.translatable("optilite.options.particle.angryVillager");
   private static final SimpleOption<Boolean> angryVillagerParticlesEnabled = SimpleOption.ofBoolean(ANGRY_VILLAGER_PARTICLE_TOOLTIP.getString(), true);
   public static SimpleOption<Boolean> getAngryVillagerParticlesEnabled() {
      return angryVillagerParticlesEnabled;
   }

   private static final Text BLOCK_PARTICLE_TOOLTIP = Text.translatable("optilite.options.particle.block");
   private static final SimpleOption<Boolean> blockParticlesEnabled = SimpleOption.ofBoolean(BLOCK_PARTICLE_TOOLTIP.getString(), true);
   public static SimpleOption<Boolean> getBlockParticlesEnabled() {
      return blockParticlesEnabled;
   }

   private static final Text BUBBLE_PARTICLE_TOOLTIP = Text.translatable("optilite.options.particle.bubble");
   private static final SimpleOption<Boolean> bubbleParticlesEnabled = SimpleOption.ofBoolean(BUBBLE_PARTICLE_TOOLTIP.getString(), true);
   public static SimpleOption<Boolean> getBubbleParticlesEnabled() {
      return bubbleParticlesEnabled;
   }

   private static final Text EXPLOSION_PARTICLE_TOOLTIP = Text.translatable("optilite.options.particle.explosion");
   private static final SimpleOption<Boolean> explosionParticlesEnabled = SimpleOption.ofBoolean(EXPLOSION_PARTICLE_TOOLTIP.getString(), true);
   public static SimpleOption<Boolean> getExplosionParticlesEnabled() {
      return explosionParticlesEnabled;
   }

   private static final Text SMOKE_PARTICLE_TOOLTIP = Text.translatable("optilite.options.particle.smoke");
   private static final SimpleOption<Boolean> smokeParticlesEnabled = SimpleOption.ofBoolean(SMOKE_PARTICLE_TOOLTIP.getString(), true);
   public static SimpleOption<Boolean> getSmokeParticlesEnabled() {
      return smokeParticlesEnabled;
   }



   private static final Text TEMP = Text.translatable("Temp Button...");
   private static final SimpleOption<Boolean> tempButton = SimpleOption.ofBoolean(TEMP.getString(), true);
   public static SimpleOption<Boolean> getTempButton() {
      return tempButton;
   }
}