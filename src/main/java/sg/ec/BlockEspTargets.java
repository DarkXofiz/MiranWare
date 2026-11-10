// Original binary: sg/ec/vzkgx99OChN9TfSz
package sg.ec;

import it.unimi.dsi.fastutil.objects.Reference2IntMap;
import it.unimi.dsi.fastutil.objects.Reference2IntOpenHashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;

// $VF: Compiled from s
public class BlockEspTargets {
   private volatile Set<ThemeColorEntry> field24988 = new HashSet<>();
   private volatile Reference2IntMap<EntityType<?>> field24989 = new Reference2IntOpenHashMap();

   public Set<ThemeColorEntry> method11175() {
      return this.field24988;
   }

   public void method11176(List<BlockEspConfigCodec> var1) {
      HashSet var2 = new HashSet();
      Reference2IntOpenHashMap var3 = new Reference2IntOpenHashMap();
      if (var1 != null) {
         for (BlockEspConfigCodec var5 : var1) {
            if (var5 != null && var5.method10520() != null) {
               for (BlockEspEntry var7 : var5.method10520()) {
                  if (var7 != null && var7.method03984()) {
                     this.method11178(var7, var2, var3);
                  }
               }
            }
         }
      }

      this.field24988 = var2;
      this.field24989 = var3;
   }

   public Reference2IntMap<EntityType<?>> method11177() {
      return this.field24989;
   }

   private void method11178(BlockEspEntry var1, Set<ThemeColorEntry> var2, Reference2IntOpenHashMap<EntityType<?>> var3) {
      if (var1.method03980() != null) {
         var3.put(var1.method03980(), var1.method03979().toInt());
      } else if (var1.method03989() == null) {
         if (var1.method03983() != null) {
            var2.add(new ThemeColorEntry(var1.method03983(), var1.method03979(), var1.method03993()));
         }
      } else {
         for (Block var5 : BlockNameUtils.method03813(var1.method03989())) {
            var2.add(new ThemeColorEntry(var5.defaultBlockState(), var1.method03979(), true));
         }
      }
   }
}
