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
public class GameOptionsOL {
// private static final Text  = Text.translatable("optilite.options..tooltip");

   // TODO: Tie-in with GameOptions.getAdvancedTooltips
   private static final Text ADVANCED_TOOLTIPS_TEXT = Text.translatable("optilite.options.advancedTooltips");
   private static final SimpleOption<Boolean> ADVANCED_TOOLTIPS = SimpleOption.ofBoolean(ADVANCED_TOOLTIPS_TEXT.getString(), false);
   public static SimpleOption<Boolean> getAdvancedTooltips() {
      return ADVANCED_TOOLTIPS;
   }

   private static final Text FOG_TEXT = Text.translatable("optilite.options.fog");
   private static final SimpleOption<Boolean> FOG = SimpleOption.ofBoolean(FOG_TEXT.getString(), true);
   public static SimpleOption<Boolean> getFog() {
      return FOG;
   }

   private static final Text CLOUD_HEIGHT_TEXT = Text.translatable("optilite.options.cloudHeight");
   private static final SimpleOption<Double> CLOUD_HEIGHT = new SimpleOption<>(
           "optilite.options.cloudHeight",
           SimpleOption.constantTooltip(CLOUD_HEIGHT_TEXT),
           (optionText, value) -> value == 0.0
                   ? GameOptions.getGenericValueText(optionText, ScreenTexts.OFF)
                   : GameOptionsAccessors.getPercentValueText(optionText, value),
           SimpleOption.DoubleSliderCallbacks.INSTANCE.withModifier(MathHelper::square, Math::sqrt),
           0.0, value -> {}
   );
   public static SimpleOption<Double> getCloudsHeight() {
      return CLOUD_HEIGHT;
   }

   private static final Text SKY_TEXT = Text.translatable("optilite.options.sky");
   private static final SimpleOption<Boolean> SKY = SimpleOption.ofBoolean(SKY_TEXT.getString(), true);
   public static SimpleOption<Boolean> getSky() {
      return SKY;
   }

   // TODO: SPLIT INTO SEPARATE SETTINGS?
   private static final Text SUN_MOON_TEXT = Text.translatable("optilite.options.sunMoon");
   private static final SimpleOption<Boolean> SUN_MOON = SimpleOption.ofBoolean(SUN_MOON_TEXT.getString(), true);
   public static SimpleOption<Boolean> getSunMoon() {
      return SUN_MOON;
   }

   private static final Text STARS_TEXT = Text.translatable("optilite.options.stars");
   private static final SimpleOption<Boolean> STARS = SimpleOption.ofBoolean(STARS_TEXT.getString(), true);
   public static SimpleOption<Boolean> getStars() {
      return STARS;
   }

//   private static final Text _PARTICLE = Text.translatable("optilite.options.particle.");
//   private static final SimpleOption<Boolean> ParticlesEnabled = SimpleOption.ofBoolean(_PARTICLE.getString(), true);
// PARTICLE OPTIONS
   private static final Text ANGRY_VILLAGER_PARTICLE = Text.translatable("optilite.options.particle.angryVillager");
   private static final SimpleOption<Boolean> angryVillagerParticlesEnabled = SimpleOption.ofBoolean(ANGRY_VILLAGER_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getAngryVillagerParticlesEnabled() {
      return angryVillagerParticlesEnabled;
   }

   private static final Text BLOCK_PARTICLE = Text.translatable("optilite.options.particle.block");
   private static final SimpleOption<Boolean> blockParticlesEnabled = SimpleOption.ofBoolean(BLOCK_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getBlockParticlesEnabled() {
      return blockParticlesEnabled;
   }

   private static final Text BLOCK_MARKER_PARTICLE = Text.translatable("optilite.options.particle.blockMarker");
   private static final SimpleOption<Boolean> blockMarkerParticlesEnabled = SimpleOption.ofBoolean(BLOCK_MARKER_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getBlockMarkerParticlesEnabled() {
      return blockMarkerParticlesEnabled;
   }

   private static final Text BUBBLE_PARTICLE = Text.translatable("optilite.options.particle.bubble");
   private static final SimpleOption<Boolean> bubbleParticlesEnabled = SimpleOption.ofBoolean(BUBBLE_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getBubbleParticlesEnabled() {
      return bubbleParticlesEnabled;
   }

   private static final Text CLOUD_PARTICLE = Text.translatable("optilite.options.particle.cloud");
   private static final SimpleOption<Boolean> cloudParticlesEnabled = SimpleOption.ofBoolean(CLOUD_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getCloudParticlesEnabled() {
      return cloudParticlesEnabled;
   }

   private static final Text CRIT_PARTICLE = Text.translatable("optilite.options.particle.crit");
   private static final SimpleOption<Boolean> critParticlesEnabled = SimpleOption.ofBoolean(CRIT_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getCritParticlesEnabled() {
      return critParticlesEnabled;
   }

   private static final Text DAMAGE_INDICATOR_PARTICLE = Text.translatable("optilite.options.particle.damageIndicator");
   private static final SimpleOption<Boolean> damageIndicatorParticlesEnabled = SimpleOption.ofBoolean(DAMAGE_INDICATOR_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getDamageIndicatorParticlesEnabled() {
      return damageIndicatorParticlesEnabled;
   }

   private static final Text DRAGONS_BREATH_PARTICLE = Text.translatable("optilite.options.particle.dragonsBreath");
   private static final SimpleOption<Boolean> dragonsBreathParticlesEnabled = SimpleOption.ofBoolean(DRAGONS_BREATH_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getDragonsBreathParticlesEnabled() {
      return dragonsBreathParticlesEnabled;
   }

   // CAN MAYBE CONDENSE LAVA / WATER PARTICLES INTO ONE OPTION
   private static final Text DRIPPING_LAVA_PARTICLE = Text.translatable("optilite.options.particle.drippingLava");
   private static final SimpleOption<Boolean> drippingLavaParticlesEnabled = SimpleOption.ofBoolean(DRIPPING_LAVA_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getDrippingLavaParticlesEnabled() {
      return drippingLavaParticlesEnabled;
   }

   private static final Text FALLING_LAVA_PARTICLE = Text.translatable("optilite.options.particle.fallingLava");
   private static final SimpleOption<Boolean> fallingLavaParticlesEnabled = SimpleOption.ofBoolean(FALLING_LAVA_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getFallingLavaParticlesEnabled() {
      return fallingLavaParticlesEnabled;
   }

   private static final Text LANDING_LAVA_PARTICLE = Text.translatable("optilite.options.particle.landingLava");
   private static final SimpleOption<Boolean> landingLavaParticlesEnabled = SimpleOption.ofBoolean(LANDING_LAVA_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getLandingLavaParticlesEnabled() {
      return landingLavaParticlesEnabled;
   }

   private static final Text EXPLOSION_PARTICLE = Text.translatable("optilite.options.particle.explosion");
   private static final SimpleOption<Boolean> explosionParticlesEnabled = SimpleOption.ofBoolean(EXPLOSION_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getExplosionParticlesEnabled() {
      return explosionParticlesEnabled;
   }

   private static final Text SMOKE_PARTICLE = Text.translatable("optilite.options.particle.smoke");
   private static final SimpleOption<Boolean> smokeParticlesEnabled = SimpleOption.ofBoolean(SMOKE_PARTICLE.getString(), true);
   public static SimpleOption<Boolean> getSmokeParticlesEnabled() {
      return smokeParticlesEnabled;
   }


   private static final Text TEMP = Text.translatable("Temp Button...");
   private static final SimpleOption<Boolean> tempButton = SimpleOption.ofBoolean(TEMP.getString(), true);
   public static SimpleOption<Boolean> getTempButton() {
      return tempButton;
   }
}