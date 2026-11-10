// Original binary: sg/ec/JiUjdviqzLP43o64
package sg.ec;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class FireworkBoostEvent extends Event {
   public static final FireworkBoostEvent field09279 = new FireworkBoostEvent();
   private Entity field09280;
   private float field09281;
   private float field09282;
   private Vec3 field09283;
   private double field09284;
   private static final float field09285 = 1.5F;
   private static final float field09286 = 1.5F;
   private static final double field09287 = 0.5;
   private static final float field09288 = 1.5F;
   private static final float field09289 = 1.5F;
   private static final double field09290 = 0.5;
   private static final double field09291 = 0.1;
   private static final double field09292 = 0.1;
   private static final double field09293 = 0.1;

   public float method04084() {
      return this.field09281;
   }

   public FireworkBoostEvent() {
      this.field09281 = field09285;
      this.field09282 = field09286;
      this.field09283 = Vec3.ZERO;
      this.field09284 = field09287;
   }

   public void method04085(double var1) {
      this.field09284 = var1;
   }

   public void method04086(Entity var1) {
      this.field09280 = var1;
   }

   public void method04087(Vec3 var1) {
      this.field09283 = var1;
   }

   public float method04088() {
      return this.field09282;
   }

   public Entity method04089() {
      return this.field09280;
   }

   public Vec3 method04090() {
      return this.field09283;
   }

   public void method04091(float var1) {
      this.field09282 = var1;
   }

   public double method04092() {
      return this.field09284;
   }

   public void method04093(float var1) {
      this.field09281 = var1;
   }

   public void method04094(Entity var1) {
      this.field09280 = var1;
      this.field09281 = field09288;
      this.field09282 = field09289;
      this.field09284 = field09290;
      Vec3 var2 = var1.getDeltaMovement();
      this.field09283 = var1.getLookAngle();
      super.method03208();
      Vec3 var3 = this.field09283;
      var1.setDeltaMovement(
         var2.add(
            var3.x * field09291 + (var3.x * this.field09281 - var2.x) * this.field09284,
            var3.y * field09292 + (var3.y * this.field09282 - var2.y) * this.field09284,
            var3.z * field09293 + (var3.z * this.field09281 - var2.z) * this.field09284
         )
      );
   }
}
