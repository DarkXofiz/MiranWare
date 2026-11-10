// Original binary: sg/mx/rIKffqO76fmpcKxU
package sg.mx;

import net.minecraft.util.FormattedCharSink;
import net.minecraft.util.StringDecomposer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.ModifyVariable;
import sg.ec.TextWidthSink;
import sg.ec.StreamerTextHook;

// $VF: Compiled from s
@Mixin(StringDecomposer.class)
public class StringDecomposerMixin {
   @ModifyVariable(
      method = {
            "iterateFormatted(Ljava/lang/String;Lnet/minecraft/network/chat/Style;Lnet/minecraft/util/FormattedCharSink;)Z",
            "iterateFormatted(Ljava/lang/String;Lnet/minecraft/network/chat/Style;Lnet/minecraft/util/FormattedCharSink;)Z",
            "iterateBackwards"
      },
      at = @At("HEAD"),
      argsOnly = true,
      name = "string"
   )
   private static String adjustText(String var0) {
      return StreamerTextHook.method03280(var0);
   }

   @ModifyVariable(
      method = "iterateFormatted(Ljava/lang/String;ILnet/minecraft/network/chat/Style;Lnet/minecraft/network/chat/Style;Lnet/minecraft/util/FormattedCharSink;)Z",
      at = @At("HEAD"),
      argsOnly = true,
      ordinal = 0
   )
   private static FormattedCharSink replaceSymbols(FormattedCharSink var0) {
      return TextWidthSink.wrap(var0);
   }
}
