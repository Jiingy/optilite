package net.jineric.optilite.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricLanguageProvider;
import net.jineric.optilite.client.option.ParticleOption;
import net.jineric.optilite.util.StringUtilsOL;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;

import java.nio.file.Path;
import java.util.concurrent.CompletableFuture;

public class LanguageProviderOL extends FabricLanguageProvider {
	private TranslationBuilder builder;
	
	public LanguageProviderOL(FabricDataOutput dataOutput, CompletableFuture<RegistryWrapper.WrapperLookup> registryLookup) {
		super(dataOutput, registryLookup);
	}
	
	@Override
	public void generateTranslations(RegistryWrapper.WrapperLookup registryLookup, TranslationBuilder builder) {
		this.builder = builder;
		this.tryExisting(builder);
		this.addParticleOptionTranslations();
	}
	
	private void addParticleOptionTranslations() {
		ParticleOption.PARTICLE_OPTIONS_MAP.forEach((particleType, particleOption) -> {
			String particleTypePath = Registries.PARTICLE_TYPE.getId(particleType).getPath();
			String translationPrefix = "optilite.options.particle.";
			System.out.println(translationPrefix + StringUtilsOL.snakeToCamelCase(particleTypePath));
			builder.add(
					translationPrefix + StringUtilsOL.snakeToCamelCase(particleTypePath),
					StringUtilsOL.snakeCaseToCapitalized(particleTypePath)
			);
		});
	}
	
	public void tryExisting(TranslationBuilder builder) {
		try {
			Path existingPath;
			if (dataOutput.getModContainer().findPath("assets/optilite/lang/en_us_existing.json").isPresent()) {
				existingPath = dataOutput.getModContainer().findPath("assets/optilite/lang/en_us_existing.json").get();
				builder.add(existingPath);
			}
		} catch (Exception e) {
			throw new RuntimeException("Failed to find existing language file!", e);
		}
	}
	
	@Override
	public String getName() {
		return "Language Provider";
	}
}
