package net.jineric.optilite.client.gui.screen.animations;

import com.google.common.collect.Comparators;
import net.jineric.optilite.client.option.ParticleOption;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.gui.screen.option.GameOptionsScreen;
import net.minecraft.client.gui.widget.ClickableWidget;
import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;
import org.apache.logging.log4j.util.PropertySource;

import java.util.*;

public class AnimationOptionsScreen extends GameOptionsScreen {
	private static final Text TITLE_TEXT = Text.translatable("optilite.options.animationsTitle");
	
	public AnimationOptionsScreen(Screen parent, GameOptions gameOptions) {
		super(parent, gameOptions, TITLE_TEXT);
	}
	
	@Override
	protected void addOptions() {
		if (this.body != null) {
			// Adds the global particle toggle setting
			this.body.addSingleOptionEntry(gameOptions.getParticles());
//			this.body.addAll(SimpleOption.ofBoolean());
			List<ClickableWidget> simpleOptions = new ArrayList<>();
			ParticleOption.PARTICLE_OPTIONS_MAP.forEach((particleType, particleOption) -> simpleOptions.add(particleOption.getSimpleOption().createWidget(this.gameOptions)));
			this.body.addAll(simpleOptions);
		}
	}
}
