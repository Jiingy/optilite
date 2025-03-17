package net.jineric.optilite.mixin;

import net.minecraft.client.option.GameOptions;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(GameOptions.class)
public abstract class ModifyFrameRateOption {
	
	// Mixin intention is to change the slider from an integer to also allow it to set FPS to vsync when all the way to the left
//   @WrapOperation(
//           slice = @Slice(
//                   from = @At(
//                           value = "CONSTANT",
//                           args = "stringValue=")
//           ),
//           method = "<init>",
//           at = @At(
//                   value = "INVOKE",
//                   target = "Lnet/minecraft/client/option/SimpleOption;<init>(Ljava/lang/String;Lnet/minecraft/client/option/SimpleOption$TooltipFactory;Lnet/minecraft/client/option/SimpleOption$ValueTextGetter;Lnet/minecraft/client/option/SimpleOption$Callbacks;Ljava/lang/Object;Ljava/util/function/Consumer;)V",
//           )
//   )
}
