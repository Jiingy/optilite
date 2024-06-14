package net.jineric.optilite.option;

import net.minecraft.client.option.SimpleOption;
import net.minecraft.particle.ParticleType;
import net.minecraft.particle.ParticleTypes;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ParticleOption extends GameOptionsOF {
   private final SimpleOption<Boolean> simpleOption;
   private final ParticleType<?> particleType;

// public static ParticleOption  = new ParticleOption(GameOptionsOF.get.ParticlesEnabled(), ParticleTypes.);

   public static ParticleOption ANGRY_VILLAGER = new ParticleOption(GameOptionsOF.getAngryVillagerParticlesEnabled(), ParticleTypes.ANGRY_VILLAGER);
   public static ParticleOption BLOCK = new ParticleOption(GameOptionsOF.getBlockParticlesEnabled(), ParticleTypes.BLOCK);
//   public static ParticleOption BLOCK_MARKER = new ParticleOption(GameOptionsOF.getBlockMarkerParticlesEnabled(), ParticleTypes.BLOCK_MARKER);
   public static ParticleOption BUBBLE = new ParticleOption(GameOptionsOF.getBubbleParticlesEnabled(), ParticleTypes.BUBBLE);
   public static ParticleOption EXPLOSION = new ParticleOption(GameOptionsOF.getExplosionParticlesEnabled(), ParticleTypes.EXPLOSION);
   public static ParticleOption SMOKE = new ParticleOption(GameOptionsOF.getSmokeParticlesEnabled(), ParticleTypes.SMOKE);


   public ParticleOption(SimpleOption<Boolean> booleanSimpleOption, ParticleType<?> particleTypes) {
      this.simpleOption = booleanSimpleOption;
      this.particleType = particleTypes;
   }

   public ParticleType<?> getParticleType() {
      return this.particleType;
   }

   public SimpleOption<?> getParticleOption() {
      return this.simpleOption;
   }

   public boolean getParticleOptionValue() {
      return this.simpleOption.getValue();
   }

   public static List<ParticleOption> getAllParticleOptions() {
      List<ParticleOption> particleOptions = new ArrayList<>();
      Class<ParticleOption> particleOptionClass = ParticleOption.class;
      Field[] classFields = particleOptionClass.getDeclaredFields();

      for (Field field : classFields) {
         if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && field.getType() == particleOptionClass) {
            try {
               particleOptions.add((ParticleOption) field.get(null));
            } catch (IllegalAccessException e) {
               throw new RuntimeException(e);
            }
         }
      }
      return particleOptions;
   }

//   private static final List<ParticleType<?>> PARTICLE_TYPE_FIELDS = new ArrayList<>();
//   public static List<ParticleType<?>> getParticleTypeFields() {
//      return PARTICLE_TYPE_FIELDS;
//   }
//   static {
//      Class<ParticleTypes> particleTypesClass = ParticleTypes.class;
//      Class<ParticleType> particleTypeClass = ParticleType.class;
//      Field[] declaredFields = particleTypesClass.getDeclaredFields();
//      for (Field field : declaredFields) {
//         if (java.lang.reflect.Modifier.isStatic(field.getModifiers())) {
//            if (field.getType() == particleTypeClass) {
//               try {
//                  PARTICLE_TYPE_FIELDS.add((ParticleType<?>) field.get(null));
//               } catch (IllegalAccessException exception) {
//                  exception.printStackTrace();
//               }
//            }
//         }
//      }
//   }
}
