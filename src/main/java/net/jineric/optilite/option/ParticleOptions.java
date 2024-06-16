package net.jineric.optilite.option;

import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;

public class ParticleOptions {
//   public static ParticleOption  = new ParticleOption(GameOptionsOL.get.ParticlesEnabled();
   public static ParticleOption ANGRY_VILLAGER = new ParticleOption(GameOptionsOL.getAngryVillagerParticlesEnabled(), ParticleTypes.ANGRY_VILLAGER);
   public static ParticleOption BLOCK = new ParticleOption(GameOptionsOL.getBlockParticlesEnabled(), ParticleTypes.BLOCK);
   public static ParticleOption BLOCK_MARKER = new ParticleOption(GameOptionsOL.getBlockMarkerParticlesEnabled(), ParticleTypes.BLOCK_MARKER);
   public static ParticleOption BUBBLE = new ParticleOption(GameOptionsOL.getBubbleParticlesEnabled(), ParticleTypes.BUBBLE);
   public static ParticleOption CLOUD = new ParticleOption(GameOptionsOL.getCloudParticlesEnabled(), ParticleTypes.CLOUD);
   public static ParticleOption CRIT = new ParticleOption(GameOptionsOL.getCritParticlesEnabled(), ParticleTypes.CRIT);
   public static ParticleOption DAMAGE_INDICATOR = new ParticleOption(GameOptionsOL.getDamageIndicatorParticlesEnabled(), ParticleTypes.DAMAGE_INDICATOR);
   public static ParticleOption DRAGON_BREATH = new ParticleOption(GameOptionsOL.getDragonsBreathParticlesEnabled(), ParticleTypes.DRAGON_BREATH);
   public static ParticleOption DRIPPING_LAVA = new ParticleOption(GameOptionsOL.getDrippingLavaParticlesEnabled(), ParticleTypes.DRIPPING_LAVA);
   public static ParticleOption LANDING_LAVA = new ParticleOption(GameOptionsOL.getLandingLavaParticlesEnabled(), ParticleTypes.LANDING_LAVA);
   public static ParticleOption FALLING_LAVA = new ParticleOption(GameOptionsOL.getFallingLavaParticlesEnabled(), ParticleTypes.FALLING_LAVA);
//   public static ParticleOption DUST_COLOR_TRANSITION = new ParticleOption(GameOptionsOL.get);
//   public static ParticleOption EFFECT = new ParticleOption(GameOptionsOL.get);
//   public static ParticleOption ELDER_GUARDIAN = new ParticleOption(GameOptionsOL.get);
//   public static ParticleOption ENCHANTED_HIT = new ParticleOption(GameOptionsOL.get);
//   public static ParticleOption ENCHANT = new ParticleOption(GameOptionsOL.get);
//   public static ParticleOption END_ROD = new ParticleOption(GameOptionsOL.get);
//   public static ParticleOption ENTITY_EFFECT = new ParticleOption(GameOptionsOL.get);
   //   public static ParticleOption EXPLOSION_EMITTER = new ParticleOption(GameOptionsOL.get.ParticlesEnabled());

   public static ParticleOption EXPLOSION = new ParticleOption(GameOptionsOL.getExplosionParticlesEnabled(), ParticleTypes.EXPLOSION);

   public static ParticleOption SMOKE = new ParticleOption(GameOptionsOL.getSmokeParticlesEnabled(), ParticleTypes.SMOKE);
}
