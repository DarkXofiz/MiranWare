// Original binary: sg/mx/WgSP8YIDkhRu2TKi
package sg.mx;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(MultiPlayerGameMode.class)
public interface MultiPlayerGameModeMixin_1233 {
   @Accessor("carriedIndex")
   void setCarriedIndex(int var1);

   @Accessor("carriedIndex")
   int getCarriedIndex();
}
