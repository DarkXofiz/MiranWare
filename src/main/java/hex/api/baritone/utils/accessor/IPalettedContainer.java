// Original binary: hex/api/baritone/utils/accessor/IPalettedContainer
package hex.api.baritone.utils.accessor;

import net.minecraft.util.BitStorage;
import net.minecraft.world.level.chunk.Palette;

// $VF: Compiled from s
public interface IPalettedContainer<T> {
   Palette<T> getPalette();

   BitStorage getStorage();

   // $VF: Compiled from s
   interface IData<T> {
      Palette<T> getPalette();

      BitStorage getStorage();
   }
}
