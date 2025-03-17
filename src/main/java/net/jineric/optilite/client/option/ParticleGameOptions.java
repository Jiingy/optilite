package net.jineric.optilite.client.option;

import net.minecraft.client.option.SimpleOption;
import net.minecraft.text.Text;

public class ParticleGameOptions {
	private static final Text ANGRY_VILLAGER_PARTICLES_TEXT = Text.translatable("optilite.options.particle.angryVillager");
	private static final SimpleOption<Boolean> ANGRY_VILLAGER_PARTICLES = SimpleOption.ofBoolean(ANGRY_VILLAGER_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getAngryVillagerParticles() {
		return ANGRY_VILLAGER_PARTICLES;
	}
	
	private static final Text BLOCK_PARTICLES_TEXT = Text.translatable("optilite.options.particle.block");
	private static final SimpleOption<Boolean> BLOCK_PARTICLES = SimpleOption.ofBoolean(BLOCK_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getBlockParticles() {
		return BLOCK_PARTICLES;
	}
	
	private static final Text BLOCK_MARKER_PARTICLES_TEXT = Text.translatable("optilite.options.particle.blockMarker");
	private static final SimpleOption<Boolean> BLOCK_MARKER_PARTICLES = SimpleOption.ofBoolean(BLOCK_MARKER_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getBlockMarkerParticles() {
		return BLOCK_MARKER_PARTICLES;
	}
	
	private static final Text BUBBLE_PARTICLES_TEXT = Text.translatable("optilite.options.particle.bubble");
	private static final SimpleOption<Boolean> BUBBLE_PARTICLES = SimpleOption.ofBoolean(BUBBLE_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getBubbleParticles() {
		return BUBBLE_PARTICLES;
	}
	
	private static final Text CLOUD_PARTICLES_TEXT = Text.translatable("optilite.options.particle.cloud");
	private static final SimpleOption<Boolean> CLOUD_PARTICLES = SimpleOption.ofBoolean(CLOUD_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getCloudParticles() {
		return CLOUD_PARTICLES;
	}
	
	private static final Text CRIT_PARTICLES_TEXT = Text.translatable("optilite.options.particle.crit");
	private static final SimpleOption<Boolean> CRIT_PARTICLES = SimpleOption.ofBoolean(CRIT_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getCritParticles() {
		return CRIT_PARTICLES;
	}
	
	private static final Text DAMAGE_INDICATOR_PARTICLES_TEXT = Text.translatable("optilite.options.particle.damageIndicator");
	private static final SimpleOption<Boolean> DAMAGE_INDICATOR_PARTICLES = SimpleOption.ofBoolean(DAMAGE_INDICATOR_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getDamageIndicatorParticles() {
		return DAMAGE_INDICATOR_PARTICLES;
	}
	
	private static final Text DRAGONS_BREATH_PARTICLES_TEXT = Text.translatable("optilite.options.particle.dragonsBreath");
	private static final SimpleOption<Boolean> DRAGONS_BREATH_PARTICLES = SimpleOption.ofBoolean(DRAGONS_BREATH_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getDragonsBreathParticles() {
		return DRAGONS_BREATH_PARTICLES;
	}
	
	// CAN MAYBE CONDENSE LAVA / WATER PARTICLES INTO ONE OPTION
	private static final Text DRIPPING_LAVA_PARTICLES_TEXT = Text.translatable("optilite.options.particle.drippingLava");
	private static final SimpleOption<Boolean> DRIPPING_LAVA_PARTICLES = SimpleOption.ofBoolean(DRIPPING_LAVA_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getDrippingLavaParticles() {
		return DRIPPING_LAVA_PARTICLES;
	}
	
	private static final Text FALLING_LAVA_PARTICLES_TEXT = Text.translatable("optilite.options.particle.fallingLava");
	private static final SimpleOption<Boolean> FALLING_LAVA_PARTICLES = SimpleOption.ofBoolean(FALLING_LAVA_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getFallingLavaParticles() {
		return FALLING_LAVA_PARTICLES;
	}
	
	private static final Text LANDING_LAVA_PARTICLES_TEXT = Text.translatable("optilite.options.particle.landingLava");
	private static final SimpleOption<Boolean> LANDING_LAVA_PARTICLES = SimpleOption.ofBoolean(LANDING_LAVA_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getLandingLavaParticles() {
		return LANDING_LAVA_PARTICLES;
	}
	
	private static final Text EXPLOSION_PARTICLES_TEXT = Text.translatable("optilite.options.particle.explosion");
	private static final SimpleOption<Boolean> EXPLOSION_PARTICLES = SimpleOption.ofBoolean(EXPLOSION_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getExplosionParticles() {
		return EXPLOSION_PARTICLES;
	}
	
	private static final Text SMOKE_PARTICLES_TEXT = Text.translatable("optilite.options.particle.smoke");
	private static final SimpleOption<Boolean> SMOKE_PARTICLES = SimpleOption.ofBoolean(SMOKE_PARTICLES_TEXT.getString(), true);
	public static SimpleOption<Boolean> getSmokeParticles() {
		return SMOKE_PARTICLES;
	}
	
}
