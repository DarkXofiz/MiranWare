// Original binary: hex/api/baritone/utils/schematic/format/defaults/LitematicaSchematic
package hex.api.baritone.utils.schematic.format.defaults;

import hex.api.baritone.api.schematic.CompositeSchematic;
import hex.api.baritone.api.schematic.IStaticSchematic;
import hex.api.baritone.utils.schematic.StaticSchematic;
import java.util.Collections;
import java.util.Optional;
import net.minecraft.core.Vec3i;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import org.apache.commons.lang3.Validate;
import org.jetbrains.annotations.Nullable;

// $VF: Compiled from s
public final class LitematicaSchematic extends CompositeSchematic implements IStaticSchematic {
   private static final String ШЫ = "ШЫ";
   private static final String Шз = "Шз";
   private static final String ШР = "ШР";
   private static final String Шх = "Шх";
   private static final String ШЦ = "ШЦ";
   private static final double Ш9 = 0;
   private static final double ШЮ = 0;
   private static final String ШO = "ШO";
   private static final String Ш弟 = "Ш弟";
   private static final String ШВ = "ШВ";
   private static final String Шж = "Шж";
   private static final int Ш8 = 0;
   private static final String ШТ = "ШТ";
   private static final String ШЙ = "ШЙ";
   private static final String Шэ = "Шэ";
   private static final String ШО = "ШО";
   private static final String ШИ = "ШИ";
   private static final String ШП = "ШП";
   private static final String Ш_ = "Ш_";
   private static final String Шс = "Шс";
   private static final String ШЛ = "ШЛ";
   private static final String Шь = "Шь";
   private static final String ШЯ = "ШЯ";
   private static final String ШХ = "ШХ";


   @Override
   public BlockState getDirect(int var1, int var2, int var3) {
      return this.desiredState(var1, var2, var3, null, Collections.emptyList());
   }

   private void fillInSchematic(CompoundTag var1) {
      Vec3i var2 = new Vec3i(getMinOfSchematic(var1, ШТ), getMinOfSchematic(var1, ШЙ), getMinOfSchematic(var1, Шэ));

      for (CompoundTag sx : getRegions(var1)) {
         ListTag sxx = sx.getListOrEmpty(ШО);
         BlockState[] sxxx = getBlockList(sxx);
         int sxxxx = getBitsPerBlock(sxx.size());
         long sxxxxx = getVolume(sx);
         long[] sxxxxxx = sx.getLongArray(ШИ).orElse(new long[0]);
         LitematicaSchematic.LitematicaBitArray sxxxxxxx = new LitematicaSchematic.LitematicaBitArray(sxxxx, sxxxxx, sxxxxxx);
         this.writeSubregionIntoSchematic(sx, var2, sxxx, sxxxxxxx);
      }
   }

   private static CompoundTag[] getRegions(CompoundTag var0) {
      return var0.getCompound(ШЫ)
         .map(CompoundTag::values)
         .map(var0x -> var0x.stream().filter(var0xx -> var0xx instanceof CompoundTag).map(CompoundTag.class::cast).toArray(CompoundTag[]::new))
         .orElse(new CompoundTag[0]);
   }

   private static BlockState[] getBlockList(ListTag var0) {
      BlockState[] var1 = new BlockState[var0.size()];

      for (int sx = 0; sx < var0.size(); sx++) {
         CompoundTag sxx = (CompoundTag)var0.get(sx);
         Identifier sxxx = Identifier.tryParse(sxx.getString(Шх).orElse(""));
         Block sxxxx = sxxx == null ? Blocks.AIR : BuiltInRegistries.BLOCK.get(sxxx).map(Reference::value).orElse(Blocks.AIR);
         CompoundTag sxxxxx = sxx.getCompound(ШЦ).orElse(new CompoundTag());
         var1[sx] = getBlockState(sxxxx, sxxxxx);
      }

      return var1;
   }

   private static int getBitsPerBlock(int var0) {
      return (int)Math.max(Ш9, Math.ceil(Math.log(var0) / Math.log(ШЮ)));
   }

   private static int getMinOfSubregion(CompoundTag var0, String var1) {
      int var2 = var0.getCompound(Шз).flatMap(var1x -> var1x.getInt(var1)).orElse(0);
      int sx = var0.getCompound(ШР).flatMap(var1x -> var1x.getInt(var1)).orElse(0);
      return Math.min(var2, var2 + sx + 1);
   }

   private static BlockState getBlockState(Block var0, CompoundTag var1) {
      BlockState var2 = var0.defaultBlockState();

      for (String sx : var1.keySet()) {
         var sxx = var0.getStateDefinition().getProperty(sx);
         String sxxx = var1.getString(sx).orElse(null);
         if (sxx != null) {
            var2 = setPropertyValue(var2, sxx, sxxx);
         }
      }

      return var2;
   }

   private static <T extends Comparable<T>> BlockState setPropertyValue(BlockState var0, Property<T> var1, String var2) {
      var var3 = var1.getValue(var2);
      if (var3.isPresent()) {
         return var0.setValue(var1, var3.get());
      } else {
         throw new IllegalArgumentException("Invalid value for property " + var1);
      }
   }

   private static long getVolume(CompoundTag var0) {
      CompoundTag var1 = var0.getCompound(ШO).orElse(new CompoundTag());
      return Math.abs(var1.getInt(Ш弟).orElse(0) * var1.getInt(ШВ).orElse(0) * var1.getInt(Шж).orElse(0));
   }

   private void writeSubregionIntoSchematic(CompoundTag var1, Vec3i var2, BlockState[] var3, LitematicaSchematic.LitematicaBitArray var4) {
      int var5 = getMinOfSubregion(var1, ШП) - var2.getX();
      int sx = getMinOfSubregion(var1, Ш_) - var2.getY();
      int sxx = getMinOfSubregion(var1, Шс) - var2.getZ();
      CompoundTag sxxx = var1.getCompound(ШЛ).orElse(new CompoundTag());
      int sxxxx = Math.abs(sxxx.getInt(Шь).orElse(0));
      int sxxxxx = Math.abs(sxxx.getInt(ШЯ).orElse(0));
      int sxxxxxx = Math.abs(sxxx.getInt(ШХ).orElse(0));
      BlockState[][][] sxxxxxxx = new BlockState[sxxxx][sxxxxxx][sxxxxx];
      int sxxxxxxxx = 0;

      for (int sxxxxxxxxx = 0; sxxxxxxxxx < sxxxxx; sxxxxxxxxx++) {
         for (int sxxxxxxxxxx = 0; sxxxxxxxxxx < sxxxxxx; sxxxxxxxxxx++) {
            for (int sxxxxxxxxxxx = 0; sxxxxxxxxxxx < sxxxx; sxxxxxxxxxxx++) {
               sxxxxxxx[sxxxxxxxxxxx][sxxxxxxxxxx][sxxxxxxxxx] = var3[var4.getAt(sxxxxxxxx)];
               sxxxxxxxx++;
            }
         }
      }

      this.put(new StaticSchematic(sxxxxxxx), var5, sx, sxx);
   }

   public LitematicaSchematic(CompoundTag var1) {
      super(0, 0, 0);
      this.fillInSchematic(var1);
   }

   private static int getMinOfSchematic(CompoundTag var0, String var1) {
      int var2 = Ш8;

      for (CompoundTag sx : getRegions(var0)) {
         var2 = Math.min(var2, getMinOfSubregion(sx, var1));
      }

      return var2;
   }

   // $VF: Compiled from s
   private static class LitematicaBitArray {
      private final long[] longArray;
      private final int bitsPerEntry;
      private final long maxEntryValue;
      private final long arraySize;
      private static final long 诶Oч = 0;
      private static final long 诶O衣 = 0;
      private static final long 诶Oц = 1L;
      private static final long 诶OМ = 0;

      public LitematicaBitArray(int var1, long var2, @Nullable long[] var4) {
         Validate.inclusiveBetween(1L, 诶Oч, var1);
         this.arraySize = var2;
         this.bitsPerEntry = var1;
         this.maxEntryValue = (1L << var1) - 1L;
         if (var4 != null) {
            this.longArray = var4;
         } else {
            this.longArray = new long[(int)(roundUp(var2 * var1, 诶O衣) / 诶Oц)];
         }
      }

      public long size() {
         return this.arraySize;
      }


      public int getAt(long var1) {
         Validate.inclusiveBetween(0L, this.arraySize - 1L, var1);
         long var3 = var1 * this.bitsPerEntry;
         int sx = (int)(var3 >> 6);
         int sxx = (int)((var1 + 1L) * this.bitsPerEntry - 1L >> 6);
         int sxxx = (int)(var3 & 诶OМ);
         if (sx == sxx) {
            return (int)(this.longArray[sx] >>> sxxx & this.maxEntryValue);
         }

         int sxxxx = 64 - sxxx;
         return (int)((this.longArray[sx] >>> sxxx | this.longArray[sxx] << sxxxx) & this.maxEntryValue);
      }

      public static long roundUp(long var0, long var2) {
         int var4 = 1;
         if (var2 == 0L) {
            return 0L;
         }

         if (var0 == 0L) {
            return var2;
         }

         if (var0 < 0L) {
            var4 = -1;
         }

         long sx = var0 % (var2 * var4);
         return sx == 0L ? var0 : var0 + var2 * var4 - sx;
      }
   }
}
