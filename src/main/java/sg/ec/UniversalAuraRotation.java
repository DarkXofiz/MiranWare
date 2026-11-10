// Original binary: sg/ec/awqFafY6uKtF0tzn
package sg.ec;

import java.util.EnumSet;
import java.util.Set;
import java.util.function.Supplier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class UniversalAuraRotation implements AuraRotationStrategy {
   private static final float field16841 = 180.0F;
   private static final float field16842 = 0;
   private static final float field16843 = 0;
   private static final float field16844 = 0;
   private static final float field16845 = 0;
   private static final float field16846 = 0;
   private static final float field16847 = 0;
   private static final float field16848 = 0;
   private static final int field16849 = 0;
   private static final float field16850 = 0;
   private static final float field16851 = 0;
   private static final float field16852 = 0;
   private final RotationDerivativeHistory field16853 = new RotationDerivativeHistory();
   private final String field16854;
   private final Supplier<OnnxRotationModel> field16855;
   private AttackAura field16856;
   private LivingEntity field16857;
   private float[] field16858;
   private boolean field16859;
   private int field16860;
   private float field16861 = 1.0F;
   private double field16862;
   private boolean field16863;
   private boolean field16864;
   private boolean field16865;
   private static final String field16866 = "Universal";
   private static final double field16867 = 3.0;
   private static final float field16868 = 0.55F;
   private static final float field16869 = 0.3F;
   private static final float field16870 = 9999.0F;
   private static final float field16871 = 9999.0F;
   private static final float field16872 = 180.0F;
   private static final float field16873 = 180.0F;
   private static final float field16874 = 5.0F;
   private static final float field16875 = 5.0F;
   private static final float field16876 = -89.9F;
   private static final float field16877 = 89.9F;
   private static final float field16878 = 180.0F;
   private static final float field16879 = 90.0F;
   private static final float field16880 = -60.0F;
   private static final float field16881 = 60.0F;
   private static final float field16882 = -60.0F;
   private static final float field16883 = 60.0F;
   private static final float field16884 = -89.9F;
   private static final float field16885 = 89.9F;
   private static final float field16886 = -180.0F;
   private static final float field16887 = 180.0F;
   private static final float field16888 = -90.0F;
   private static final float field16889 = 90.0F;

   private float[] method07054() {
      OnnxRotationModel var1 = this.method07065();
      if (mc.player != null && var1 != null && var1.method00710()) {
         float sx = mc.player.getYRot();
         float sxx = mc.player.getXRot();
         float sxxx = FreeLookController.method10131();
         float sxxxx = FreeLookController.method10134();
         float sxxxxx = Mth.wrapDegrees(sxxx - sx);
         float sxxxxxx = sxxxx - sxx;
         if (Math.abs(sxxxxx) <= field16874 && Math.abs(sxxxxxx) <= field16875) {
            this.field16863 = false;
            var1.method00691();
            this.field16853.method02506();
            return null;
         }

         if (!this.field16863) {
            this.field16863 = true;
            var1.method00691();
            this.field16853.method02506();
         }

         RotationDerivativeHistory.Nested68 sxxxxxxx = this.field16853.method02507(sx, sxx, sxxxxx, sxxxxxx);
         Vec3 sxxxxxxxx = mc.player.getDeltaMovement();
         double sxxxxxxxxx = Math.hypot(sxxxxxxxx.x, sxxxxxxxx.z);
         float[] sxxxxxxxxxx = RotationModelFeatures.method01550(
            sx,
            sxx,
            sxxx,
            sxxxx,
            sxxxxxxx.velYaw(),
            sxxxxxxx.velPitch(),
            sxxxxxxx.accelYaw(),
            sxxxxxxx.accelPitch(),
            sxxxxxxx.jerkYaw(),
            sxxxxxxx.jerkPitch(),
            0.0,
            sxxxxxxxxx,
            this.field16862,
            false,
            sxxxxxxx.errVelYaw(),
            sxxxxxxx.errVelPitch()
         );
         float[] sxxxxxxxxxxx = this.method07060(sxxxxxxxxxx, sxxxxx, sxxxxxx, sxx, false, true, false);
         float sxxxxxxxxxxxx = sx + RotationMath.method11343(sxxxxxxxxxxx[0]);
         float sxxxxxxxxxxxxx = Mth.clamp(sxx + RotationMath.method11343(sxxxxxxxxxxx[1]), field16876, field16877);
         this.field16853.method02508(sxxxxxxx, sx, sxx, sxxxxx, sxxxxxx);
         return new float[]{sxxxxxxxxxxxx, sxxxxxxxxxxxxx};
      } else {
         this.field16863 = false;
         this.field16853.method02506();
         return null;
      }
   }

   @Override
   public String method02258() {
      return this.field16854;
   }

   private static float method07055(float[] var0) {
      return Float.isFinite(var0[0]) ? Mth.clamp(var0[0], field16886, field16887) : 0.0F;
   }

   @Override
   public void method02268() {
      if (this.field16856 != null) {
         this.method07059();
      }

      this.field16857 = null;
      this.field16863 = false;
      this.field16864 = false;
      this.field16865 = false;
      RotationManager.method06543();
      this.method07063();
      this.method07067();
   }

   private static float method07056(float var0, float var1, float var2, float var3) {
      float var4 = Mth.clamp(var1, -var2, var2);
      return var0 + (var4 - var0) * var3;
   }

   private void method07057() {
      this.field16864 = false;
      this.method07059();
      this.method07063();
      this.method07067();
   }

   public UniversalAuraRotation(String var1, Supplier<OnnxRotationModel> var2) {
      this.field16862 = field16867;
      this.field16854 = var1;
      this.field16855 = var2;
   }

   private boolean method07058() {
      float[] var1 = this.method07054();
      if (var1 != null && mc.player != null) {
         mc.player.setYRot(var1[0]);
         mc.player.setXRot(var1[1]);
         return false;
      } else {
         return true;
      }
   }

   private void method07059() {
      OnnxRotationModel var1 = this.method07065();
      if (var1 != null) {
         var1.method00691();
      }
   }

   private float[] method07060(float[] var1, float var2, float var3, float var4, boolean var5, boolean var6, boolean var7) {
      float[] var8 = this.method07065().method00690(var1);
      float var9 = method07055(var8);
      float var10 = method07064(var8);
      float var11 = var9;
      float var12 = var10;
      if (this.field16856.method00387() && !var5 && var6) {
         var11 = method07056(var11, var2, field16878, this.field16856.method00445());
         var12 = method07056(var12, var3, field16879, this.field16856.method00405());
      }

      if (var7 && !var5 && this.field16856.method00437()) {
         var11 = Mth.clamp(var2, field16880, field16881);
         var12 = Mth.clamp(var3, field16882, field16883);
      }

      var12 = Mth.clamp(var12, field16884 - var4, field16885 - var4);
      return new float[]{var11, var12, var9, var10};
   }

   private void method07061(LivingEntity var1) {
      this.field16857 = var1;
      this.method07059();
      this.method07063();
      this.method07067();
   }

   @Override
   public Rotation method02265(AttackAura var1) {
      if (this.field16856 == null) {
         this.field16856 = var1;
      }

      RotationManager.method06565(this::method07058);
      return null;
   }

   private static void method07062(AuraRotationController.Nested161 var0, float var1, float var2) {
      var0.method05332(var1);
      var0.method05339(var2);
      var0.method05325(0.0F, 0.0F);
      var0.method05337(0.0F, 0.0F);
      var0.method05335(false);
   }

   private void method07063() {
      this.field16858 = null;
      this.field16859 = false;
      this.field16860 = 0;
   }

   @Override
   public void method02266(AuraRotationController.Nested160 var1, AuraRotationController.Nested161 var2) {
      if (var1.pass() == AuraRotationUpdateMode.FIXED_60) {
         if (mc.player != null) {
            this.field16856 = var1.aura();
            LivingEntity var3 = var1.target();
            if (var3 != null) {
               if (var3 != this.field16857) {
                  this.method07061(var3);
               }

               if (this.field16864) {
                  this.method07057();
               }

               float var4 = mc.player.getYRot();
               float var5 = mc.player.getXRot();
               float var6 = Mth.wrapDegrees(var1.rawYaw() - var4);
               float var7 = var1.rawPitch() - var5;
               boolean var8 = this.field16853.method02505();
               RotationDerivativeHistory.Nested68 var9 = this.field16853.method02507(var4, var5, var6, var7);
               Vec3 var10 = ModuleManager.INSTANCE.method08188().method10427() ? Vec3.ZERO : mc.player.getDeltaMovement();
               Vec3 var11 = var3.getDeltaMovement();
               double var12 = Math.hypot(var10.x, var10.z);
               double var14 = Math.hypot(var11.x, var11.z);
               this.field16862 = this.field16856.method00419(var3);
               float var16 = mc.player.getAttackStrengthScale(0.0F);
               if (var8 && this.field16861 - var16 > field16868 && var16 < field16869) {
                  boolean var20 = true;
               } else {
                  boolean var10000 = false;
               }

               float[] var18 = RotationModelFeatures.method01550(
                  var4,
                  var5,
                  var1.rawYaw(),
                  var1.rawPitch(),
                  var9.velYaw(),
                  var9.velPitch(),
                  var9.accelYaw(),
                  var9.accelPitch(),
                  var9.jerkYaw(),
                  var9.jerkPitch(),
                  var14,
                  var12,
                  this.field16862,
                  var1.rayTrace(),
                  var9.errVelYaw(),
                  var9.errVelPitch()
               );
               if (false) {
                  var9.velYaw();
                  var9.velPitch();
               } else {
                  float[] var19 = this.method07068(var2, var18, var4, var5, var6, var7, var1.rayTrace());
                  if (var19 != null) {
                     var1.rayTrace();
                  }
               }

               this.field16853.method02508(var9, var4, var5, var6, var7);
               this.field16861 = var16;
            }
         }
      }
   }

   private static float method07064(float[] var0) {
      return Float.isFinite(var0[1]) ? Mth.clamp(var0[1], field16888, field16889) : 0.0F;
   }

   private OnnxRotationModel method07065() {
      if (this.field16855 != null) {
         return this.field16855.get();
      } else {
         return this.field16856 == null ? null : this.field16856.method00446();
      }
   }

   @Override
   public Set<AuraRotationUpdateMode> method02264() {
      return EnumSet.of(AuraRotationUpdateMode.FIXED_60);
   }

   @Override
   public void method07066() {
      this.field16864 = true;
   }

   private void method07067() {
      this.field16853.method02506();
      this.field16861 = 1.0F;
   }

   public UniversalAuraRotation() {
      this(field16866, null);
   }

   private float[] method07068(AuraRotationController.Nested161 var1, float[] var2, float var3, float var4, float var5, float var6, boolean var7) {
      OnnxRotationModel var8 = this.method07065();
      if (var8 != null && var8.method00710()) {
         RotationManager.method06565(this::method07058);
         this.field16863 = false;
         float[] var9 = this.method07060(var2, var5, var6, var4, var7, this.field16856.method00451(), true);
         var1.method05332(var3 + var9[0]);
         var1.method05339(var4 + var9[1]);
         var1.method05325(field16870, field16871);
         var1.method05337(field16872, field16873);
         var1.method05335(false);
         return var9;
      } else {
         method07062(var1, var3, var4);
         return null;
      }
   }

   public boolean method07069() {
      return this.field16865;
   }

   @Override
   public void method07070(boolean var1) {
      this.field16865 = var1;
   }
}
