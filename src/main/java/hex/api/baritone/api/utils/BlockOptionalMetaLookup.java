// Original binary: hex/api/baritone/api/utils/BlockOptionalMetaLookup
package hex.api.baritone.api.utils;

import com.google.common.collect.ImmutableSet;
import hex.api.baritone.api.utils.accessor.IItemStack;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class BlockOptionalMetaLookup {
   private final ImmutableSet<Block> blockSet;
   private final ImmutableSet<BlockState> blockStateSet;
   private final ImmutableSet<Integer> stackHashes;
   private final BlockOptionalMeta[] boms;
   private static final String А必ж = "А必ж";

   public BlockOptionalMetaLookup(BlockOptionalMeta... var1) {
      this.boms = var1;
      Set var2 = new HashSet<>();
      Set sx = new HashSet<>();
      Set sxx = new HashSet<>();

      for (BlockOptionalMeta sxxx : var1) {
         var2.add(sxxx.getBlock());
         sx.addAll(sxxx.getAllBlockStates());
         sxx.addAll(sxxx.stackHashes());
      }

      this.blockSet = ImmutableSet.copyOf(var2);
      this.blockStateSet = ImmutableSet.copyOf(sx);
      this.stackHashes = ImmutableSet.copyOf(sxx);
   }


   public boolean has(ItemStack var1) {
      int var2 = ((IItemStack)(Object)var1).getBaritoneHash();
      var2 -= var1.getDamageValue();
      return this.stackHashes.contains(var2);
   }

   public boolean has(BlockState var1) {
      return this.blockStateSet.contains(var1);
   }

   public BlockOptionalMetaLookup(String... var1) {
      this(Stream.of(var1).map(BlockOptionalMeta::new).toArray(BlockOptionalMeta[]::new));
   }

   public boolean has(Block var1) {
      return this.blockSet.contains(var1);
   }

   @Override
   public String toString() {
      return String.format(А必ж, Arrays.toString(this.boms));
   }

   public BlockOptionalMetaLookup(Block... var1) {
      this(Stream.of(var1).map(BlockOptionalMeta::new).toArray(BlockOptionalMeta[]::new));
   }

   public BlockOptionalMetaLookup(List<Block> var1) {
      this(var1.stream().map(BlockOptionalMeta::new).toArray(BlockOptionalMeta[]::new));
   }

   public List<BlockOptionalMeta> blocks() {
      return Arrays.asList(this.boms);
   }
}
