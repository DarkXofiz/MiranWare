// Original binary: sg/ec/m3NpKq5wMtOXmiCQ
package sg.ec;

import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class Rotation implements MinecraftAccess {
   private float field21426;
   private float field21427;
   private static final double field21428 = 90.0;

   public Rotation(float var1, float var2) {
      this.field21426 = var1;
      this.field21427 = var2;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + Float.floatToIntBits(this.method09439());
      return var2 * 59 + Float.floatToIntBits(this.method09443());
   }

   public double method09436(Rotation var1) {
      double var2 = Mth.wrapDegrees(var1.method09439() - this.field21426);
      double var4 = Mth.wrapDegrees(var1.method09443() - this.field21427);
      return Math.hypot(Math.abs(var2), Math.abs(var4));
   }

   public Rotation method09437(Rotation var1) {
      return new Rotation(method09445(var1.field21426, this.field21426), method09445(var1.field21427, this.field21427));
   }

   public static Rotation method09438(Vec3 var0) {
      float var1 = (float)var0.x;
      float var2 = (float)var0.y;
      float var3 = (float)var0.z;
      return new Rotation(
         (float)Mth.wrapDegrees(Math.toDegrees(Mth.atan2(var3, var1)) - field21428),
         (float)Mth.wrapDegrees(-Math.toDegrees(Mth.atan2(var2, Math.hypot(var1, var3))))
      );
   }

   public Rotation(Entity var1) {
      this.field21426 = var1.getYRot();
      this.field21427 = var1.getXRot();
   }

   public float method09439() {
      return this.field21426;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof Rotation var2)) {
         return false;
      } else if (!var2.method09444(this)) {
         return false;
      } else {
         return Float.compare(this.method09439(), var2.method09439()) != 0 ? false : Float.compare(this.method09443(), var2.method09443()) == 0;
      }
   }

   public void method09440(float var1) {
      this.field21426 = var1;
   }

   public void method09441(float var1) {
      this.field21427 = var1;
   }

   public static Rotation method09442() {
      return new Rotation(FreeLookController.method10131(), FreeLookController.method10134());
   }

   public Rotation() {
   }

   public float method09443() {
      return this.field21427;
   }

   protected boolean method09444(Object var1) {
      return var1 instanceof Rotation;
   }

   @Override
   public String toString() {
      return "Rotation(yaw=" + this.method09439() + ", pitch=" + this.method09443() + ")";
   }

   public static float method09445(float var0, float var1) {
      return Mth.wrapDegrees(var0 - var1);
   }
}
