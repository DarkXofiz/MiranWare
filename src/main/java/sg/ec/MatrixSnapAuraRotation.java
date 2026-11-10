// Original binary: sg/ec/xWfK4bnycss2cf3O
package sg.ec;

import java.util.EnumSet;
import java.util.Set;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public final class MatrixSnapAuraRotation implements AuraRotationStrategy {
   private static final float field25897 = 9999.0F;
   private static final float field25898 = 0;
   private static final int field25899 = 0;
   private static final int field25900 = 0;
   private static final String field25901 = "MatrixSnap";
   private static final float field25902 = 9999.0F;
   private static final float field25903 = 9999.0F;
   private static final float field25904 = 9999.0F;
   private static final float field25905 = 9999.0F;
   private static final double field25906 = 3.0;
   private static final double field25907 = 3.0;
   private static final float field25908 = -89.9F;
   private static final float field25909 = 89.9F;
   private static final String field25910 = "Только криты";
   private static final int field25911 = Integer.MAX_VALUE;

   @Override
   public void method02266(AuraRotationController.Nested160 var1, AuraRotationController.Nested161 var2) {
      var2.method05325(field25902, field25903);
      var2.method05337(field25904, field25905);
      AttackAura var3 = var1.aura();
      boolean sx = Math.abs(var3.field00813) <= var3.method00403();
      int sxx = method11321(var3);
      if (sx && sxx <= 5) {
         int sxxx = Math.max(1, sxx - 2);
         var2.method05332(var1.currentYaw() + Mth.wrapDegrees(var1.rawYaw() - var1.currentYaw()) / sxxx);
         var2.method05339(Mth.clamp(var1.currentPitch() + Mth.wrapDegrees(var1.rawPitch() - var1.currentPitch()) / sxxx, field25908, field25909));
      } else {
         Rotation sxxx = Rotation.method09442();
         var2.method05332((float)(sxxx.method09439() + Math.random() * field25906));
         var2.method05339((float)(sxxx.method09443() + Math.random() * field25907));
      }
   }

   @Override
   public String method02258() {
      return field25901;
   }

   @Override
   public Set<AuraRotationUpdateMode> method02264() {
      return EnumSet.of(AuraRotationUpdateMode.TICK);
   }

   private static int method11321(AttackAura var0) {
      int var1 = var0.method00410();
      if (var0.method00401().method04520(field25910) && !var0.method00433()) {
         int var2 = var0.method00439();
         return var2 < 0 ? field25911 : Math.max(var1, var2);
      } else {
         return var1;
      }
   }
}
