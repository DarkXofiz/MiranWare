// Original binary: sg/ec/r1bDeWcfENG2N517
package sg.ec;

import it.unimi.dsi.fastutil.longs.Long2IntMaps;
import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.Long2IntMap.Entry;
import it.unimi.dsi.fastutil.objects.ObjectIterator;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import net.minecraft.core.BlockPos;
import net.minecraft.util.ARGB;

// $VF: Compiled from s
public final class BlockEspMeshBuilder {
   private static final int field23123 = 0;
   private static final int field23124 = 0;
   private static final int field23125 = 0;
   private static final int field23126 = 0;
   private static final int field23127 = 0;
   private static final int field23128 = 0;
   private static final int field23129 = 0;
   private static final int field23130 = 0;
   private final double field23131;
   private final double field23132;
   private final double field23133;
   private ByteBuffer field23134;
   private int field23135;
   private static final int field23136 = 65536;

   public static BlockEspMesh method10268(Long2IntOpenHashMap var0, double var1, double var3, double var5) {
      BlockEspMeshBuilder var7 = new BlockEspMeshBuilder(var1, var3, var5);
      var7.method10276(var0);
      var7.field23134.flip();
      return new BlockEspMesh(var7.field23134, var7.field23135, var1, var3, var5);
   }

   private void method10269(Long2IntOpenHashMap var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      int var8 = method10273(var1, var2, var4, var5, var6, var7);
      if (method10270(var8) && method10272(var8) == var3) {
         int var9 = var4 == 0 ? 1 : 0;
         int var10 = var4 == 1 ? 1 : 0;
         int var11 = var4 == 2 ? 1 : 0;
         if (!method10270(method10273(var1, var2, var4, var5 - var9, var6 - var10, var7 - var11))) {
            int var12 = 1;

            while (method10270(method10273(var1, var2, var4, var5 + var9 * var12, var6 + var10 * var12, var7 + var11 * var12))) {
               var12++;
            }

            this.method10275(var5, var6, var7, var2);
            this.method10275(var5 + var9 * var12, var6 + var10 * var12, var7 + var11 * var12, var2);
         }
      }
   }

   private static boolean method10270(int var0) {
      if (var0 != 0 && var0 != 15) {
         return Integer.bitCount(var0) != 2 ? true : var0 == 9 || var0 == 6;
      } else {
         return false;
      }
   }

   private void method10271() {
      ByteBuffer var1 = ByteBuffer.allocateDirect(this.field23134.capacity() << 1).order(ByteOrder.nativeOrder());
      this.field23134.flip();
      var1.put(this.field23134);
      this.field23134 = var1;
   }

   private static int method10272(int var0) {
      return 31 - Integer.numberOfLeadingZeros(var0);
   }

   private static int method10273(Long2IntOpenHashMap var0, int var1, int var2, int var3, int var4, int var5) {
      int var6 = 0;

      for (int var7 = -1; var7 <= 0; var7++) {
         for (int var8 = -1; var8 <= 0; var8++) {
            long var9;
            if (var2 == 0) {
               var9 = BlockPos.asLong(var3, var4 + var7, var5 + var8);
            } else if (var2 == 1) {
               var9 = BlockPos.asLong(var3 + var7, var4, var5 + var8);
            } else {
               var9 = BlockPos.asLong(var3 + var7, var4 + var8, var5);
            }

            if (var0.get(var9) == var1) {
               var6 |= 1 << (var7 + 1 << 1 | var8 + 1);
            }
         }
      }

      return var6;
   }

   private static boolean method10274(Long2IntOpenHashMap var0, int var1, int var2, int var3, int var4) {
      for (int var5 = -1; var5 <= 1; var5++) {
         for (int var6 = -1; var6 <= 1; var6++) {
            for (int var7 = -1; var7 <= 1; var7++) {
               if (Math.abs(var5) + Math.abs(var6) + Math.abs(var7) != 3 && var0.get(BlockPos.asLong(var2 + var5, var3 + var6, var4 + var7)) != var1) {
                  return false;
               }
            }
         }
      }

      return true;
   }

   private void method10275(int var1, int var2, int var3, int var4) {
      if (this.field23134.remaining() < 16) {
         this.method10271();
      }

      this.field23134.putFloat((float)(var1 - this.field23131));
      this.field23134.putFloat((float)(var2 - this.field23132));
      this.field23134.putFloat((float)(var3 - this.field23133));
      this.field23134.putInt(ARGB.toABGR(var4));
      this.field23135++;
   }

   private BlockEspMeshBuilder(double var1, double var3, double var5) {
      this.field23134 = ByteBuffer.allocateDirect(field23136).order(ByteOrder.nativeOrder());
      this.field23131 = var1;
      this.field23132 = var3;
      this.field23133 = var5;
   }

   private void method10276(Long2IntOpenHashMap var1) {
      ObjectIterator var2 = Long2IntMaps.fastIterator(var1);

      while (var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         long var4 = var3.getLongKey();
         int var6 = var3.getIntValue();
         int var7 = BlockPos.getX(var4);
         int var8 = BlockPos.getY(var4);
         int var9 = BlockPos.getZ(var4);
         if (!method10274(var1, var6, var7, var8, var9)) {
            for (int var10 = 0; var10 < 2; var10++) {
               for (int var11 = 0; var11 < 2; var11++) {
                  int var12 = 1 - var10 << 1 | 1 - var11;
                  this.method10269(var1, var6, var12, 0, var7, var8 + var10, var9 + var11);
                  this.method10269(var1, var6, var12, 1, var7 + var10, var8, var9 + var11);
                  this.method10269(var1, var6, var12, 2, var7 + var10, var8 + var11, var9);
               }
            }
         }
      }
   }
}
