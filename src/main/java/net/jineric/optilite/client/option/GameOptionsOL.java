package net.jineric.optilite.client.option;

import com.mojang.serialization.Codec;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.jineric.optilite.client.option.fog.FogDistance;
import net.jineric.optilite.client.option.fog.FogMode;
import net.jineric.optilite.client.option.fog.FogType;
import net.jineric.optilite.mixin.accessors.GameOptionsAccessors;
import net.minecraft.client.option.GameOptions;
import net.minecraft.client.option.SimpleOption;
import net.minecraft.screen.ScreenTexts;
import net.minecraft.text.Text;
import net.minecraft.util.math.MathHelper;

import java.util.Arrays;

import static net.jineric.optilite.client.option.GameOptionTooltips.*;

@Environment(EnvType.CLIENT)
public class GameOptionsOL {
	// TODO: Tie-in with GameOptions.getAdvancedTooltips
	
	private static final Text ADVANCED_TOOLTIPS_TEXT = Text.translatable("optilite.options.advancedTooltips");
	private static final SimpleOption<Boolean> ADVANCED_TOOLTIPS = SimpleOption.ofBoolean(ADVANCED_TOOLTIPS_TEXT.getString(), false);
	public static SimpleOption<Boolean> getAdvancedTooltips() {
		return ADVANCED_TOOLTIPS;
	}
	
	private static final Text FOG_MODE_TEXT = Text.translatable("optilite.options.fogMode");
	private static final SimpleOption<FogMode> FOG_MODE = new SimpleOption<>(
            FOG_MODE_TEXT.getString(),
			SimpleOption.constantTooltip(FOG_MODE_TOOLTIP),
			SimpleOption.enumValueText(),
			new SimpleOption.PotentialValuesBasedCallbacks<>(Arrays.asList(FogMode.values()), Codec.INT.xmap(FogMode::byId, FogMode::getId)),
			FogMode.ON,
			fogMode -> {
			}
	);
	
	public static SimpleOption<FogMode> getFogMode() {
		return FOG_MODE;
	}
	
	// FOG TYPE -- DEFAULT / CYL / SPHERE
	private static final Text FOG_TYPE_TEXT = Text.translatable("optilite.options.fogShape");
	private static final SimpleOption<FogType> FOG_TYPE = new SimpleOption<>(
			FOG_TYPE_TEXT.getString(),
			SimpleOption.constantTooltip(FOG_TYPE_TOOLTIP),
			SimpleOption.enumValueText(),
			new SimpleOption.PotentialValuesBasedCallbacks<>(Arrays.asList(FogType.values()), Codec.INT.xmap(FogType::byId, FogType::getId)),
			FogType.DEFAULT,
			consumer -> {
			}
	);
	public static SimpleOption<FogType> getFogType() {
		return FOG_TYPE;
	}
	
	// FOG -- ON / OFF / SKY / TERRAIN
	private static final Text FOG_DISTANCE_TEXT = Text.translatable("optilite.options.fogDistance");
	private static final SimpleOption<FogDistance> FOG_DISTANCE = new SimpleOption<>(
			FOG_DISTANCE_TEXT.getString(),
			SimpleOption.constantTooltip(FOG_DISTANCE_TOOLTIP),
			SimpleOption.enumValueText(),
			new SimpleOption.PotentialValuesBasedCallbacks<>(Arrays.asList(FogDistance.values()), Codec.INT.xmap(FogDistance::byId, FogDistance::getId)),
			FogDistance.DEFAULT,
			consumer -> {
			}
	);
	public static SimpleOption<FogDistance> getFogDistance() {
		return FOG_DISTANCE;
	}
	
	private static final Text CLOUD_HEIGHT_TEXT = Text.translatable("optilite.options.cloudHeight");
	private static final SimpleOption<Double> CLOUD_HEIGHT = new SimpleOption<>(
			CLOUD_HEIGHT_TEXT.getString(),
			SimpleOption.constantTooltip(CLOUD_HEIGHT_TOOLTIP),
			(optionText, value) -> value == 0.0
					? GameOptions.getGenericValueText(optionText, ScreenTexts.OFF)
					: GameOptionsAccessors.getPercentValueText(optionText, value),
			SimpleOption.DoubleSliderCallbacks.INSTANCE.withModifier(MathHelper::square, Math::sqrt),
			0.0, value -> {
	}
	);
	public static SimpleOption<Double> getCloudsHeight() {
		return CLOUD_HEIGHT;
	}
	
	private static final Text SKY_TEXT = Text.translatable("optilite.options.sky");
	private static final SimpleOption<Boolean> SKY = SimpleOption.ofBoolean(
			SKY_TEXT.getString(), SimpleOption.constantTooltip(SKY_TOOLTIP), true
	);
	public static SimpleOption<Boolean> getSky() {
		return SKY;
	}
	
	private static final Text SUN_TEXT = Text.translatable("optilite.options.sun");
	private static final SimpleOption<Boolean> SUN = SimpleOption.ofBoolean(
			SUN_TEXT.getString(), SimpleOption.constantTooltip(SUN_TOOLTIP), true
	);
	public static SimpleOption<Boolean> getSun() {
		return SUN;
	}
	
	private static final Text MOON_TEXT = Text.translatable("optilite.options.moon");
	private static final SimpleOption<Boolean> MOON = SimpleOption.ofBoolean(
			MOON_TEXT.getString(), SimpleOption.constantTooltip(MOON_TOOLTIP), true
	);
	public static SimpleOption<Boolean> getMoon() {
		return MOON;
	}
	
	private static final Text STARS_TEXT = Text.translatable("optilite.options.stars");
	private static final SimpleOption<Boolean> STARS = SimpleOption.ofBoolean(STARS_TEXT.getString(), SimpleOption.constantTooltip(STARS_TOOLTIP), true);
	public static SimpleOption<Boolean> getStars() {
		return STARS;
	}
	
	private static final Text TEMP = Text.translatable("Temp Button...");
	private static final SimpleOption<Boolean> tempButton = SimpleOption.ofBoolean(TEMP.getString(), true);
	public static SimpleOption<Boolean> getTempButton() {
		return tempButton;
	}
}