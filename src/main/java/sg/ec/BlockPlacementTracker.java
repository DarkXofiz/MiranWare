// Original binary: sg/ec/TWGYKIoveTDfzYlH
package sg.ec;

import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2ObjectOpenHashMap;
import net.minecraft.core.BlockPos;

// $VF: Compiled from s
public final class BlockPlacementTracker implements MinecraftAccess {
   private static final int field12015 = 4;
   private static final int field12016 = 0;
   private static final Long2IntOpenHashMap field12017 = new Long2IntOpenHashMap();
   private static final Long2ObjectOpenHashMap<Object> field12018 = new Long2ObjectOpenHashMap();
   private static int field12019 = BlockPlacementTracker.field12022;
   private static final int field12020 = Integer.MIN_VALUE;
   private static final int field12021 = Integer.MIN_VALUE;
   private static final int field12022 = Integer.MIN_VALUE;
   private static final int field12023 = Integer.MIN_VALUE;

   public static boolean method05646(Object var0, BlockPos var1) {
      return method05650(var1) && field12018.get(var1.asLong()) != var0;
   }

   public static boolean method05647(int var0) {
      if (mc.player != null && field12019 != field12020) {
         int var1 = mc.player.tickCount - field12019;
         return var1 >= 0 && var1 <= var0;
      } else {
         return false;
      }
   }

   private BlockPlacementTracker() {
   }

   static {
      field12017.defaultReturnValue(field12023);
   }

   public static void method05649(Object var0, BlockPos var1) {
      if (var1 != null && mc.player != null) {
         if (field12017.size() > 64) {
            method05651();
         }

         long var2 = var1.asLong();
         field12017.put(var2, mc.player.tickCount + 4);
         field12018.put(var2, var0);
      }
   }

   public static boolean method05650(BlockPos var0) {
      if (var0 != null && mc.player != null) {
         long var1 = var0.asLong();
         int var3 = field12017.get(var1);
         if (var3 == field12021) {
            return false;
         } else if (mc.player.tickCount > var3) {
            field12017.remove(var1);
            field12018.remove(var1);
            return false;
         } else {
            return true;
         }
      } else {
         return false;
      }
   }

   private static void method05651() {
      int var0 = mc.player.tickCount;
      field12017.long2IntEntrySet().removeIf(var1 -> {
         if (var0 <= var1.getIntValue()) {
            return false;
         }

         field12018.remove(var1.getLongKey());
         return true;
      });
   }

   public static void method05652() {
      if (mc.player != null) {
         field12019 = mc.player.tickCount;
      }
   }
}
