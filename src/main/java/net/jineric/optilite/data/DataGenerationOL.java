package net.jineric.optilite.data;

import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.jineric.optilite.OptiLite;
import net.minecraft.registry.RegistryBuilder;

public class DataGenerationOL implements DataGeneratorEntrypoint {
	
	@Override
	public void onInitializeDataGenerator(FabricDataGenerator generator) {
		FabricDataGenerator.Pack fabricDataGenPack = generator.createPack();
		fabricDataGenPack.addProvider(LanguageProviderOL::new);
	}
	
	@Override
	public void buildRegistry(RegistryBuilder registryBuilder) {
		DataGeneratorEntrypoint.super.buildRegistry(registryBuilder);
	}
	
	@Override
	public String getEffectiveModId() {
		return OptiLite.MOD_ID;
	}
}


