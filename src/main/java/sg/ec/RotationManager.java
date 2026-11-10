// Original binary: sg/ec/YRtt3oN5ykmV0uNl
package sg.ec;

import net.minecraft.util.Mth;

// $VF: Compiled from s
public class RotationManager implements MinecraftAccess {
   private static final long field14746 = 120L;
   private static final float field14747 = 0;
   private static final float field14748 = 0;
   private static final float field14749 = 0;
   private static final float field14750 = 0;
   private static final float field14751 = 0;
   private static final float field14752 = 0;
   private static final float field14753 = 0;
   private static final float field14754 = 0;
   private static final int field14755 = 0;
   private static final int field14756 = 0;
   private static final float field14757 = 0;
   private static final float field14758 = 0;
   private static final int field14759 = 0;
   private static int field14760 = RotationManager.field14817;
   private static int field14761 = RotationManager.field14818;
   private static float field14762;
   private static float field14763;
   private static int field14764 = RotationManager.field14819;
   private static float field14765;
   private static RotationManager.Nested190 field14766 = RotationManager.Nested190.IDLE;
   private static int field14767;
   private static long field14768;
   private static long field14769;
   private static int field14770;
   private static boolean field14771;
   private static float field14772;
   private static float field14773;
   private static Rotation field14774;
   private static Rotation field14775;
   private static Rotation field14776;
   private static Rotation field14777;
   private static float field14778;
   private static float field14779;
   private static float field14780;
   private static float field14781;
   private static int field14782;
   private static boolean field14783;
   private static int field14784;
   private static float field14785 = Float.NaN;
   private static float field14786 = Float.NaN;
   public static boolean field14787;
   private static boolean field14788;
   private static int field14789;
   private static RotationManager.Nested191 field14790;
   private static RotationManager.Nested191 field14791;
   private static final double field14792 = Double.MAX_VALUE;
   private static final float field14793 = -1.0F;
   private static final float field14794 = -1.0F;
   private static final int field14795 = -1073741824;
   private static final long field14796 = 120L;
   private static final float field14797 = 180.0F;
   private static final float field14798 = 180.0F;
   private static final float field14799 = 9999.0F;
   private static final float field14800 = 9999.0F;
   private static final float field14801 = 5.0F;
   private static final float field14802 = 5.0F;
   private static final float field14803 = 5.0F;
   private static final float field14804 = 5.0F;
   private static final float field14805 = 180.0F;
   private static final float field14806 = 180.0F;
   private static final float field14807 = 1.0E-4F;
   private static final float field14808 = 1.0E-4F;
   private static final float field14809 = 19.5F;
   private static final float field14810 = 180.0F;
   private static final float field14811 = 20.0F;
   private static final float field14812 = 20.0F;
   private static final float field14813 = 4.0F;
   private static final float field14814 = 19.7F;
   private static final float field14815 = -90.0F;
   private static final float field14816 = 90.0F;
   private static final int field14817 = -1073741824;
   private static final int field14818 = Integer.MIN_VALUE;
   private static final int field14819 = Integer.MIN_VALUE;

   public static void method06537(int var0) {
      if (var0 >= field14770) {
         field14769 = 0L;
      }
   }

   private static void method06538() {
      if (field14791 == null) {
         if (!(field14772 > field14797) || !(field14773 > field14798)) {
            AttackAura var0 = ModuleManager.INSTANCE.method08219();
            if (var0 != null) {
               Rotation var1 = var0.method00453();
               if (var1 != null) {
                  field14774 = var1;
               }
            }
         }
      }
   }

   private static void method06539() {
      field14766 = RotationManager.Nested190.IDLE;
      field14767 = 0;
      field14771 = false;
      field14787 = false;
      field14788 = false;
      field14790 = null;
      field14791 = null;
      field14774 = null;
      field14775 = null;
      FreeLookController.method10127(false);
   }

   private static void method06540(PlayerInputEvent var0) {
      float var1 = var0.method11161();
      float var2 = var0.method11166();
      if (var1 != 0.0F || var2 != 0.0F) {
         float var3 = mc.player.getYRot();
         double var4 = Mth.wrapDegrees(Math.toDegrees(MovementUtils.method05725(FreeLookController.method10131(), var1, var2)));
         float var6 = 0.0F;
         float var7 = 0.0F;
         double var8 = field14792;

         for (float var10 = field14793; var10 <= 1.0F; var10++) {
            for (float var11 = field14794; var11 <= 1.0F; var11++) {
               if (var10 != 0.0F || var11 != 0.0F) {
                  double var12 = Mth.wrapDegrees(Math.toDegrees(MovementUtils.method05725(var3, var10, var11)));
                  double var14 = Math.abs(Mth.wrapDegrees(var4 - var12));
                  if (var14 < var8) {
                     var8 = var14;
                     var6 = var10;
                     var7 = var11;
                  }
               }
            }
         }

         var0.method11167(var6);
         var0.method11158(var7);
      }
   }

   private static float method06541(float var0) {
      if (method06545() && !BlockPlacementManager.method07893()) {
         int var1 = mc.player.tickCount;
         if (var1 != field14764) {
            field14764 = var1;
            field14765 = 0.0F;
         }

         float var2 = field14814 - field14765;
         if (var2 <= 0.0F) {
            return 0.0F;
         }

         float var3 = Mth.clamp(var0, -var2, var2);
         field14765 = field14765 + Math.abs(var3);
         return var3;
      } else {
         return var0;
      }
   }

   private static boolean method06542(Rotation var0, float var1, float var2) {
      return method06567(var0, var1, var2, field14807, field14808);
   }

   public static void method06543() {
      field14791 = null;
   }

   private static float method06544(float var0) {
      int var1 = mc.player.tickCount;
      if (var1 != field14761) {
         field14761 = var1;
         field14763 = field14762;
         field14762 = 0.0F;
      }

      float var2 = method06549(Math.abs(var0) + field14762) ? field14809 : field14810;
      float var3 = var2 - field14762;
      if (var3 <= 0.0F) {
         return 0.0F;
      }

      float var4 = Mth.clamp(var0, -var3, var3);
      field14762 = field14762 + Math.abs(var4);
      return var4;
   }

   private static boolean method06545() {
      return method06575(7);
   }

   private static boolean method06546(
      Rotation var0, Rotation var1, float var2, float var3, float var4, float var5, int var6, boolean var7, boolean var8
   ) {
      if (field14766 == RotationManager.Nested190.IDLE) {
         field14788 = false;
      }

      if (var7) {
         FreeLookController.method10127(false);
      } else if (field14766 == RotationManager.Nested190.IDLE || var8 || field14771) {
         FreeLookController.method10127(true);
      }

      field14771 = var7;
      field14772 = var4;
      field14773 = var5;
      field14767 = var6;
      field14768 = System.currentTimeMillis();
      field14766 = RotationManager.Nested190.AIM;
      field14775 = var1;
      return method06542(var0, var2, var3);
   }

   public static boolean method06547(Rotation var0, float var1, int var2, boolean var3) {
      return method06570(var0, null, var1, var2, var3);
   }

   @Subscribe
   private void method06548(FrameDeltaEvent var1) {
      if (var1.method09793() == 1.0F) {
         if (field14766 == RotationManager.Nested190.RESET) {
            if (field14791 != null) {
               if (!method06561()) {
                  if (field14791.method06577()) {
                     method06539();
                  }
               }
            }
         }
      }
   }

   private static boolean method06549(float var0) {
      return !method06556() ? false : var0 > field14811 && field14763 > field14812 && Math.abs(var0 - field14763) < field14813;
   }

   public static void method06550() {
      field14790 = null;
   }

   public static boolean method06551(Rotation var0, Rotation var1, float var2, float var3, int var4, boolean var5) {
      return method06566(var0, var1, var2, var3, var2, var3, var4, var5);
   }

   public static boolean method06552(Rotation var0, float var1, float var2, int var3, boolean var4) {
      return method06551(var0, null, var1, var2, var3, var4);
   }

   @Subscribe(4)
   private void method06553(PlayerInputEvent var1) {
      boolean var2 = field14787;
      field14787 = false;
      if (mc.player != null && field14766 != RotationManager.Nested190.IDLE) {
         if (var2) {
            field14788 = true;
            field14789 = field14767;
         } else if (field14766 == RotationManager.Nested190.AIM && field14767 != field14789) {
            field14788 = false;
         }

         if (field14788) {
            method06540(var1);
         }
      } else {
         field14788 = false;
      }
   }

   public static boolean method06554(Rotation var0, float var1, float var2, float var3, float var4, int var5, boolean var6) {
      return method06566(var0, null, var1, var2, var3, var4, var5, var6);
   }

   public static void method06555() {
      if (mc.player != null) {
         field14760 = mc.player.tickCount;
      }
   }

   private static boolean method06556() {
      return method06575(2);
   }

   public static float method06557() {
      return field14786;
   }

   public static int method06558() {
      return field14767;
   }

   private static boolean method06559() {
      return field14772 <= field14805 || field14773 <= field14806;
   }

   @Subscribe
   private void method06560(PostMovementPacketEvent var1) {
      if (mc.player == null) {
         field14785 = Float.NaN;
         field14786 = Float.NaN;
      } else {
         field14785 = mc.player.getYRot();
         field14786 = mc.player.getXRot();
      }
   }

   private static boolean method06561() {
      return field14776 != null && field14782 > 0 && field14784 <= 1;
   }

   public static boolean method06562(int var0) {
      return field14767 > var0;
   }

   public static float method06563() {
      return field14785;
   }

   public RotationManager() {
      EventBus.method00263(this);
   }

   private static void method06564(Rotation var0, Rotation var1, float var2, float var3, float var4, float var5, int var6, boolean var7) {
      boolean var8 = field14776 == null || field14784 > 1 || var6 >= field14782;
      if (var8) {
         field14776 = var0;
         field14777 = var1;
         field14778 = var2;
         field14779 = var3;
         field14780 = var4;
         field14781 = var5;
         field14782 = var6;
         field14783 = var7;
         field14784 = 0;
      }
   }

   public static void method06565(RotationManager.Nested191 var0) {
      field14791 = var0;
   }

   public static boolean method06566(Rotation var0, Rotation var1, float var2, float var3, float var4, float var5, int var6, boolean var7) {
      if (field14767 > var6) {
         method06564(var0, var1, var2, var3, var4, var5, var6, var7);
         return false;
      } else {
         return method06546(var0, var1, var2, var3, var4, var5, var6, var7, false);
      }
   }

   private static boolean method06567(Rotation var0, float var1, float var2, float var3, float var4) {
      if (mc.player == null) {
         return false;
      }

      Rotation var5 = new Rotation(mc.player);
      float var6 = Mth.wrapDegrees(var0.method09439() - var5.method09439());
      float var7 = var0.method09443() - var5.method09443();
      float var8 = Math.abs(var6) + Math.abs(var7);
      float var9 = var8 == 0.0F ? 0.0F : Math.abs(var6 / var8) * var1;
      float var10 = var8 == 0.0F ? 0.0F : Math.abs(var7 / var8) * var2;
      float var11 = Mth.clamp(mc.player.getXRot() + method06541(RotationMath.method11343(Mth.clamp(var7, -var10, var10))), field14815, field14816);
      float var12 = mc.player.getYRot() + method06544(RotationMath.method11343(Mth.clamp(var6, -var9, var9)));
      mc.player.setYRot(var12);
      mc.player.setXRot(var11);
      float var13 = Math.abs(Mth.wrapDegrees(var0.method09439() - var12));
      float var14 = Math.abs(var0.method09443() - var11);
      return var13 <= var3 && var14 <= var4;
   }

   public static void method06568(int var0) {
      if (field14767 == var0) {
         field14767 = 0;
      }
   }

   public static void method06569(RotationManager.Nested191 var0) {
      field14790 = var0;
   }

   public static boolean method06570(Rotation var0, Rotation var1, float var2, int var3, boolean var4) {
      return method06551(var0, var1, var2, var2, var3, var4);
   }

   public static void method06571(int var0, long var1) {
      if (var0 >= field14767) {
         field14769 = System.currentTimeMillis() + var1;
         field14770 = var0;
      }
   }

   private static void method06572() {
      if (mc.player != null) {
         if (method06561()) {
            method06546(field14776, field14777, field14778, field14779, field14780, field14781, field14782, field14783, true);
            method06576();
         } else if (field14791 == null) {
            if (field14790 != null) {
               if (field14790.method06577()) {
                  method06539();
               }
            } else if (field14774 != null && method06559()) {
               method06542(field14774, field14799, field14800);
               Rotation var4 = Rotation.method09442();
               Rotation var1 = new Rotation(mc.player);
               float var2 = Math.abs(Mth.wrapDegrees(var4.method09439() - var1.method09439()));
               float var3 = Math.abs(var4.method09443() - var1.method09443());
               if (var2 <= field14801 && var3 <= field14802) {
                  method06539();
               }
            } else {
               boolean var0 = method06567(Rotation.method09442(), field14772, field14773, field14803, field14804);
               if (var0) {
                  method06539();
               }
            }
         }
      }
   }

   public static String method06573() {
      int var0 = mc.player == null ? -1 : mc.player.tickCount - field14760;
      return "prio="
         + field14767
         + " snapCap="
         + method06556()
         + "/"
         + Math.round(field14763)
         + " shakeCap="
         + method06545()
         + " послеУдара="
         + var0
         + "т task="
         + field14766;
   }

   @Subscribe(4)
   private void method06574(TickEvent var1) {
      RotationRenderHooks.method05686(field14775);
      if (field14776 != null) {
         field14784++;
      }

      if (field14766 == RotationManager.Nested190.AIM && System.currentTimeMillis() - field14768 >= field14796 && System.currentTimeMillis() >= field14769) {
         field14766 = RotationManager.Nested190.RESET;
         field14774 = null;
         field14775 = null;
      }

      if (field14766 == RotationManager.Nested190.RESET) {
         method06538();
         method06572();
      }
   }

   private static boolean method06575(int var0) {
      if (mc.player == null) {
         return false;
      } else {
         int var1 = mc.player.tickCount - field14760;
         if (var1 < 0) {
            field14760 = field14795;
            return false;
         } else {
            return var1 <= var0;
         }
      }
   }

   private static void method06576() {
      field14776 = null;
      field14777 = null;
      field14782 = 0;
      field14784 = 0;
   }

   // $VF: Compiled from s
   private enum Nested190 {
      AIM,
      RESET,
      IDLE;
   }

   // $VF: Compiled from s
   @FunctionalInterface
   public interface Nested191 {
      boolean method06577();
   }
}
