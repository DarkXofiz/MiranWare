// Original binary: hex/api/baritone/utils/schematic/format/defaults/MCEditSchematic
package hex.api.baritone.utils.schematic.format.defaults;

import hex.api.baritone.utils.schematic.StaticSchematic;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.util.datafix.fixes.ItemIdFix;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public final class MCEditSchematic extends StaticSchematic {
   private static final String лй = "лй";
   private static final String лк = "лк";
   private static final String лп = "лп";
   private static final String л2 = "л2";
   private static final String л西 = "л西";
   private static final String лт = "лт";
   private static final String лд = "лд";
   private static final String ле = "ле";

   public MCEditSchematic(CompoundTag var1) {
      String var2 = var1.getString(лй).orElseThrow();
      if (!var2.equals(лк)) {
         throw new IllegalStateException("bad schematic " + var2);
      }

      this.x = var1.getInt(лп).orElse(0);
      this.y = var1.getInt(л2).orElse(0);
      this.z = var1.getInt(л西).orElse(0);
      byte[] sx = var1.getByteArray(лт).orElseThrow();
      byte[] sxx = null;
      if (var1.contains(лд)) {
         byte[] sxxx = var1.getByteArray(ле).orElseThrow();
         sxx = new byte[sxxx.length * 2];

         for (int sxxxx = 0; sxxxx < sxxx.length; sxxxx++) {
            sxx[sxxxx * 2 + 0] = (byte)(sxxx[sxxxx] >> 4 & 15);
            sxx[sxxxx * 2 + 1] = (byte)(sxxx[sxxxx] >> 0 & 15);
         }
      }

      this.states = new BlockState[this.x][this.z][this.y];

      for (int sxxx = 0; sxxx < this.y; sxxx++) {
         for (int sxxxx = 0; sxxxx < this.z; sxxxx++) {
            for (int sxxxxx = 0; sxxxxx < this.x; sxxxxx++) {
               int sxxxxxx = (sxxx * this.z + sxxxx) * this.x + sxxxxx;
               int sxxxxxxx = sx[sxxxxxx] & 255;
               if (sxx != null) {
                  sxxxxxxx |= sxx[sxxxxxx] << 8;
               }

               Identifier sxxxxxxxx = Identifier.tryParse(ItemIdFix.getItem(sxxxxxxx));
               Block sxxxxxxxxx = sxxxxxxxx == null ? Blocks.AIR : BuiltInRegistries.BLOCK.get(sxxxxxxxx).map(Reference::value).orElse(Blocks.AIR);
               this.states[sxxxxx][sxxxx][sxxx] = sxxxxxxxxx.defaultBlockState();
            }
         }
      }
   }

}
