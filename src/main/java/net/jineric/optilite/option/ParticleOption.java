package net.jineric.optilite.option;

import net.minecraft.client.option.SimpleOption;
import net.minecraft.particle.ParticleType;
import net.minecraft.registry.Registries;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class ParticleOption {
   private final SimpleOption<Boolean> simpleOption;

   public ParticleOption(SimpleOption<Boolean> booleanSimpleOption) {
      this.simpleOption = booleanSimpleOption;
   }

   public SimpleOption<?> getParticleOption() {
      return this.simpleOption;
   }

   public boolean getParticleOptionValue() {
      return this.simpleOption.getValue();
   }

   public static List<ParticleType<?>> getParticleTypes() {
      return Registries.PARTICLE_TYPE.stream().toList();
   }

   public static List<ParticleOption> getAllParticleOptions() {
      List<ParticleOption> particleOptions = new ArrayList<>();
      Class<ParticleOptions> particleOptionsClass = ParticleOptions.class;
      Field[] classFields = particleOptionsClass.getDeclaredFields();

      for (Field field : classFields) {
         if (java.lang.reflect.Modifier.isStatic(field.getModifiers()) && field.getType() == ParticleOption.class) {
            try {
               particleOptions.add((ParticleOption) field.get(null));
            } catch (IllegalAccessException e) {
               throw new RuntimeException(e);
            }
         }
      }
      return particleOptions;
   }
}
