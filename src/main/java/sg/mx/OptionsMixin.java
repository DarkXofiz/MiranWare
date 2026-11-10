// Original binary: sg/mx/NcSqbUCkSesAwZ0U
package sg.mx;

import net.minecraft.client.Options;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.Constant;
import org.spongepowered.asm.mixin.injection.ModifyConstant;

// $VF: Compiled from s
@Mixin(Options.class)
public abstract class OptionsMixin {
   @ModifyConstant(method = "<init>", constant = @Constant(intValue = 110), require = 1)
   private int replace110With150(int var1) {
      return 150;
   }
}
