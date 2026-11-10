// Original binary: sg/ec/YzIKmcq1oL5V8FTL
package sg.ec;

import com.google.common.base.MoreObjects;
import com.google.common.base.Objects;
import com.mojang.brigadier.exceptions.CommandSyntaxException;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtUtils;
import net.minecraft.nbt.TagParser;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class ThemeColorEntry {
   private final BlockState field15214;
   private final RgbColor field15215;
   private final boolean field15216;
   private static final String field15217 = "state";
   private static final String field15218 = "color";
   private static final String field15219 = "isDefault";

   public static String method06788(BlockState var0) {
      return NbtUtils.writeBlockState(var0).toString();
   }

   public static BlockState method06789(String var0) {
      CompoundTag var1;
      try {
         var1 = TagParser.parseCompoundFully(var0);
      } catch (CommandSyntaxException var3) {
         return Blocks.AIR.defaultBlockState();
      }

      return NbtUtils.readBlockState(BuiltInRegistries.BLOCK, var1);
   }

   public ThemeColorEntry(BlockState var1, RgbColor var2, boolean var3) {
      this.field15214 = var1;
      this.field15215 = var2;
      this.field15216 = var3;
   }

   public BlockState method06790() {
      return this.field15214;
   }

   public RgbColor method06791() {
      return this.field15215;
   }

   @Override
   public String toString() {
      return MoreObjects.toStringHelper(this).add(field15217, this.field15214).add(field15218, this.field15215).add(field15219, this.field15216).toString();
   }

   @Override
   public int hashCode() {
      return Objects.hashCode(new Object[]{this.field15214});
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else if (var1 != null && this.getClass() == var1.getClass()) {
         ThemeColorEntry var2 = (ThemeColorEntry)var1;
         return Objects.equal(this.field15214, var2.field15214);
      } else {
         return false;
      }
   }

   public boolean method06792() {
      return this.field15216;
   }
}
