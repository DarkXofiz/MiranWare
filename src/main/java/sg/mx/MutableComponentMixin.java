// Original binary: sg/mx/6lJRr4Ur6bqiJ9De
package sg.mx;

import net.minecraft.locale.Language;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.util.FormattedCharSequence;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(MutableComponent.class)
public interface MutableComponentMixin {
   @Accessor("visualOrderText")
   void hex$setVisualOrderText(FormattedCharSequence var1);

   @Accessor("decomposedWith")
   Language hex$getDecomposedWith();

   @Accessor("decomposedWith")
   void hex$setDecomposedWith(Language var1);
}
