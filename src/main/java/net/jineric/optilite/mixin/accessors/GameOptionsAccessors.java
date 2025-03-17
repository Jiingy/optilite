package net.jineric.optilite.mixin.accessors;

import net.minecraft.client.option.GameOptions;
import net.minecraft.text.Text;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

@Mixin(GameOptions.class)
public interface GameOptionsAccessors {
	
	@Invoker("getPercentValueText")
	static Text getPercentValueText(Text prefix, double value) {
		throw new AssertionError();
	}
}
