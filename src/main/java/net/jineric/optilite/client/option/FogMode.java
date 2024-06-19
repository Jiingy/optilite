package net.jineric.optilite.client.option;

import net.minecraft.util.TranslatableOption;
import net.minecraft.util.function.ValueLists;

import java.util.function.IntFunction;

public enum FogMode implements TranslatableOption {
   ON(0, "optilite.options.fogMode.on"),
   SKY(1, "optilite.options.fogMode.sky"),
   TERRAIN(2, "optilite.options.fogMode.terrain"),
   OFF(3, "optilite.options.fogMode.off");

   private static final IntFunction<FogMode> BY_ID = ValueLists.createIdToValueFunction(
           FogMode::getId,
           values(),
           ValueLists.OutOfBoundsHandling.WRAP
   );
   private final int id;
   private final String translationKey;

   FogMode(final int id, String translationKey) {
      this.id = id;
      this.translationKey = translationKey;
   }

   @Override
   public int getId() {
      return this.id;
   }

   @Override
   public String getTranslationKey() {
      return this.translationKey;
   }

   public static FogMode byId(int id) {
      return (FogMode)BY_ID.apply(id);
   }
}
