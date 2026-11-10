// Original binary: sg/mx/omXf2YVQ6nbUhG4x
package sg.mx;

import hex.api.baritone.utils.accessor.IPalettedContainer;
import net.minecraft.util.BitStorage;
import net.minecraft.world.level.chunk.Palette;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(targets = "net/minecraft/world/level/chunk/PalettedContainer$Data")
public abstract class PalettedContainer$DataMixin<T> implements IPalettedContainer.IData<T> {
   @Accessor
   @Override
   public abstract Palette<T> getPalette();

   @Accessor
   @Override
   public abstract BitStorage getStorage();
}
