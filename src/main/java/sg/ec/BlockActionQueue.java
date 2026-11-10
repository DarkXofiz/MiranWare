// Original binary: sg/ec/xzsQdwYk0ErD2BtD
package sg.ec;

import org.joml.Vector2f;

// $VF: Compiled from s
public final class BlockActionQueue implements MinecraftAccess {
   private static final int field26328 = 62;
   private static final float field26329 = 0;
   private static final int field26330 = 0;
   private static final int field26331 = 0;
   private static final int field26332 = 0;
   private static BlockActionQueue field26333;
   private final Object[] field26334 = new Object[2];
   private final int[] field26335 = new int[]{-100, -100};
   private final int[] field26336 = new int[]{0, 0};
   private int field26337 = -1;
   private int field26338;
   private int field26339 = -1;
   private Object field26340;
   private static final float field26341 = 180.0F;

   private void method11509(Object var1) {
      int var2 = this.method11515(var1);
      if (var2 != -1) {
         this.field26334[var2] = null;
         this.field26335[var2] = -100;
         this.field26336[var2] = 0;
      }

      if (this.field26340 == var1) {
         this.field26340 = null;
      }
   }

   private Object method11510(int var1) {
      return var1 == -1 ? null : this.field26334[1 - var1];
   }

   private int method11511(Object var1) {
      int var2 = this.method11515(var1);
      if (var2 != -1) {
         return var2;
      }

      for (int var3 = 0; var3 < 2; var3++) {
         if (this.field26334[var3] == null) {
            this.field26334[var3] = var1;
            return var3;
         }
      }

      return -1;
   }

   public static boolean method11512(Object var0, Vector2f var1) {
      return field26333 != null && field26333.method11513(var0, var1, 62);
   }

   private boolean method11513(Object var1, Vector2f var2, int var3) {
      if (mc.player == null) {
         return false;
      }

      int var4 = mc.player.tickCount;
      if (var4 < this.field26339) {
         this.method11518();
      }

      this.field26339 = var4;
      int var5 = this.method11511(var1);
      if (var5 != -1) {
         this.field26335[var5] = var4;
         this.field26336[var5] = var3;
      }

      if (this.field26337 == var4 && var3 <= this.field26338) {
         return false;
      }

      if (RotationManager.method06562(var3)) {
         return false;
      }

      Object var6 = this.method11510(var5);
      if (var6 != null && this.method11516(var5, var4) && this.field26340 != null && this.field26340 != var1 && var3 <= this.field26336[1 - var5]) {
         return false;
      }

      this.field26337 = var4;
      this.field26338 = var3;
      this.field26340 = var6;
      RotationManager.method06547(
         new Rotation(var2.x + BlockPlacementManager.method07891(var2.x), var2.y + BlockPlacementManager.method07892()), field26341, var3, false
      );
      RotationManager.field14787 = true;
      return true;
   }

   public BlockActionQueue() {
      EventBus.method00263(this);
      field26333 = this;
   }

   public static void method11514(Object var0) {
      if (field26333 != null) {
         field26333.method11509(var0);
      }
   }

   private int method11515(Object var1) {
      for (int var2 = 0; var2 < 2; var2++) {
         if (this.field26334[var2] == var1) {
            return var2;
         }
      }

      return -1;
   }

   private boolean method11516(int var1, int var2) {
      int var3 = var2 - this.field26335[1 - var1];
      return var3 >= 0 && var3 <= 1;
   }

   public static boolean method11517(Object var0, Vector2f var1, int var2) {
      return field26333 != null && field26333.method11513(var0, var1, var2);
   }

   private void method11518() {
      this.field26335[0] = -100;
      this.field26335[1] = -100;
      this.field26336[0] = 0;
      this.field26336[1] = 0;
      this.field26337 = -1;
      this.field26338 = 0;
      this.field26340 = null;
   }
}
