// Original binary: sg/ec/6xSZ6xnUr0GG4c44
package sg.ec;

import net.minecraft.util.Mth;

// $VF: Compiled from s
public final class RotationModelFeatures {
   public static final int field03713 = 13;
   private static final float field03714 = 30.0F;
   private static final float field03715 = -1.0F;
   private static final float field03716 = 30.0F;
   private static final float field03717 = -1.0F;
   private static final double field03718 = 2.0;
   private static final double field03719 = 8.0;
   private static final float field03720 = 30.0F;
   private static final float field03721 = -1.0F;
   private static final float field03722 = 30.0F;
   private static final float field03723 = -1.0F;
   private static final float field03724 = 30.0F;
   private static final float field03725 = -1.0F;
   private static final float field03726 = 30.0F;
   private static final float field03727 = -1.0F;
   private static final float field03728 = 30.0F;
   private static final float field03729 = -1.0F;
   private static final float field03730 = 30.0F;
   private static final float field03731 = -1.0F;
   private static final float field03732 = 180.0F;
   private static final float field03733 = -1.0F;
   private static final float field03734 = 90.0F;
   private static final float field03735 = -1.0F;

   public static float method01549(float var0) {
      return Mth.clamp(var0 / field03732, field03733, 1.0F);
   }

   private RotationModelFeatures() {
   }

   public static float[] method01550(
      float var0,
      float var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      double var10,
      double var12,
      double var14,
      boolean var16,
      float var17,
      float var18
   ) {
      float var19 = Mth.wrapDegrees(var2 - var0);
      float var20 = var3 - var1;
      return new float[]{
         method01549(var19),
         method01551(var20),
         Mth.clamp(var4 / field03714, field03715, 1.0F),
         Mth.clamp(var5 / field03716, field03717, 1.0F),
         Mth.clamp((float)((var10 + var12) / field03718), 0.0F, 1.0F),
         Mth.clamp((float)(var14 / field03719), 0.0F, 1.0F),
         Mth.clamp(var6 / field03720, field03721, 1.0F),
         Mth.clamp(var7 / field03722, field03723, 1.0F),
         Mth.clamp(var8 / field03724, field03725, 1.0F),
         Mth.clamp(var9 / field03726, field03727, 1.0F),
         var16 ? 1.0F : 0.0F,
         Mth.clamp(var17 / field03728, field03729, 1.0F),
         Mth.clamp(var18 / field03730, field03731, 1.0F)
      };
   }

   public static float method01551(float var0) {
      return Mth.clamp(var0 / field03734, field03735, 1.0F);
   }
}
