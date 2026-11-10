// Original binary: sg/mx/Rpwbq1CPyY0XmxTl
package sg.mx;

import com.mojang.math.Axis;
import net.minecraft.client.Camera;
import net.minecraft.world.phys.Vec3;
import org.joml.Quaternionf;
import org.joml.Vector3f;
import org.joml.Vector3fc;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.ModelPartTransformAccess;

// $VF: Compiled from s
@Mixin(Camera.class)
public abstract class CameraMixin_1213 implements ModelPartTransformAccess {
   @Shadow
   @Final
   private static Vector3fc FORWARDS;
   @Shadow
   @Final
   private static Vector3fc UP;
   @Shadow
   @Final
   private static Vector3fc LEFT;
   @Shadow
   @Final
   private Quaternionf rotation;
   @Shadow
   @Final
   private Vector3f forwards;
   @Shadow
   @Final
   private Vector3f up;
   @Shadow
   @Final
   private Vector3f left;
   @Shadow
   private int matrixPropertiesDirty;
   @Unique
   private float pitchM;
   @Unique
   private float yawM;
   @Unique
   private float rollM;
   @Unique
   private float field28018;
   @Unique
   private float field28019;
   @Unique
   private float field28020;
   private static final float field28021 = 0.017453292F;
   private static final float field28022 = 3.1415927F;

   @Shadow
   protected abstract void setPosition(Vec3 var1);

   @Override
   public void hMI5_0$applyRotation() {
      this.rotation.add(Axis.XP.rotationDegrees(this.pitchM));
      this.rotation.add(Axis.YP.rotationDegrees(this.yawM));
      this.rotation.add(Axis.ZP.rotationDegrees(this.rollM));
      this.matrixPropertiesDirty |= 3;
   }

   @Override
   public void hMI5_0$setRotationValues(float var1, float var2, float var3) {
      this.pitchM = var1;
      this.yawM = var2;
      this.rollM = var3;
   }

   @Override
   public void hMI5_0$setPosValues(float var1, float var2, float var3) {
      this.field28018 = var1;
      this.field28019 = var2;
      this.field28020 = var3;
   }

   @Inject(method = "setRotation(FF)V", at = @At("TAIL"))
   private void hmiSetRotation(float var1, float var2, CallbackInfo var3) {
      if (this.pitchM != 0.0F || this.yawM != 0.0F || this.rollM != 0.0F) {
         float var4 = field28021;
         this.rotation.rotationYXZ(field28022 - (var1 + this.yawM) * var4, (-var2 + this.pitchM) * var4, this.rollM * var4);
         FORWARDS.rotate(this.rotation, this.forwards);
         UP.rotate(this.rotation, this.up);
         LEFT.rotate(this.rotation, this.left);
         this.matrixPropertiesDirty |= 3;
      }
   }

   @Inject(method = "setPosition(DDD)V", at = @At("HEAD"), cancellable = true)
   private void hmiSetPosition(double var1, double var3, double var5, CallbackInfo var7) {
      if (this.field28018 != 0.0F || this.field28019 != 0.0F || this.field28020 != 0.0F) {
         this.setPosition(new Vec3(var1 + this.field28018, var3 + this.field28019, var5 + this.field28020));
         var7.cancel();
      }
   }

}
