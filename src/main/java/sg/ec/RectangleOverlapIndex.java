// Original binary: sg/ec/SxzPp7ESHbYuS4mA
package sg.ec;

import net.minecraft.client.gui.navigation.ScreenRectangle;

// $VF: Compiled from s
public final class RectangleOverlapIndex {
   private static final int field11976 = 4;
   private static final int field11977 = 0;
   private static final int field11978 = 0;
   private final ScreenRectangle[][] field11979 = new ScreenRectangle[64][];
   private final int[] field11980 = new int[64];

   public boolean method05579(ScreenRectangle var1) {
      if (var1 == null) {
         return false;
      }

      int var2 = method05582(var1);
      int sx = method05580(var1);
      if (sx - var2 >= 64) {
         sx = var2 + 64 - 1;
      }

      for (int sxx = var2; sxx <= sx; sxx++) {
         int sxxx = sxx & 63;
         ScreenRectangle[] sxxxx = this.field11979[sxxx];
         int sxxxxx = this.field11980[sxxx];

         for (int sxxxxxx = 0; sxxxxxx < sxxxxx; sxxxxxx++) {
            if (sxxxx[sxxxxxx].intersects(var1)) {
               return true;
            }
         }
      }

      return false;
   }

   private static int method05580(ScreenRectangle var0) {
      int var1 = var0.top();
      int var2 = var0.bottom() - 1;
      return (var2 < var1 ? var1 : var2) >> 4;
   }

   public void method05581(ScreenRectangle var1) {
      if (var1 != null) {
         int var2 = method05582(var1);
         int var3 = method05580(var1);
         if (var3 - var2 >= 64) {
            var3 = var2 + 64 - 1;
         }

         for (int var4 = var2; var4 <= var3; var4++) {
            this.method05583(var4 & 63, var1);
         }
      }
   }

   private static int method05582(ScreenRectangle var0) {
      int var1 = var0.top();
      int var2 = var0.bottom() - 1;
      return (var2 < var1 ? var2 : var1) >> 4;
   }

   private void method05583(int var1, ScreenRectangle var2) {
      ScreenRectangle[] var3 = this.field11979[var1];
      int var4 = this.field11980[var1];
      if (var3 == null) {
         var3 = new ScreenRectangle[8];
         this.field11979[var1] = var3;
      } else if (var4 == var3.length) {
         ScreenRectangle[] var5 = new ScreenRectangle[var4 << 1];
         System.arraycopy(var3, 0, var5, 0, var4);
         this.field11979[var1] = var5;
         var3 = var5;
      }

      var3[var4] = var2;
      this.field11980[var1] = var4 + 1;
   }
}
