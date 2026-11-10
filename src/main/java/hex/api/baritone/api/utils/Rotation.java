// Original binary: hex/api/baritone/api/utils/Rotation
package hex.api.baritone.api.utils;


// $VF: Compiled from s
public class Rotation {
   private final float yaw;
   private final float pitch;
   private static final double ук = 0;
   private static final double уп = 0;
   private static final double у2 = 0;
   private static final float у西 = 0;
   private static final float ут = 0;
   private static final float уд = 1.0F;
   private static final float уе = 0;
   private static final float у6 = 0;
   private static final float уl = 0;
   private static final float у必 = 0;
   private static final float уЗ = 0;
   private static final float ун = 0;
   private static final float уД = 0;
   private static final float уН = 0;
   private static final float уш = 0;
   private static final float ул = 0;

   public boolean yawIsReallyClose(Rotation var1) {
      float var2 = Math.abs(normalizeYaw(this.yaw) - normalizeYaw(var1.yaw));
      return var2 < уп || var2 > у2;
   }

   public Rotation subtract(Rotation var1) {
      return new Rotation(this.yaw - var1.yaw, this.pitch - var1.pitch);
   }

   public static float yawDistanceFromOffset(float var0, float var1) {
      if (!(var0 > 0.0F ^ var1 > 0.0F) || !((var0 > уЗ || var0 < ун) ^ (var1 > уД || var1 < уН))) {
         return var0 - var1;
      } else {
         return var0 < 0.0F ? уш + (var0 - var1) : ул - (var0 - var1);
      }
   }

   public Rotation(float var1, float var2) {
      this.yaw = var1;
      this.pitch = var2;
      if (Float.isInfinite(var1) || Float.isNaN(var1) || Float.isInfinite(var2) || Float.isNaN(var2)) {
         throw new IllegalStateException(var1 + " " + var2);
      }
   }

   public float getPitch() {
      return this.pitch;
   }


   public static float clampPitch(float var0) {
      return Math.max(у西, Math.min(ут, var0));
   }

   @Override
   public String toString() {
      return "Yaw: " + this.yaw + ", Pitch: " + this.pitch;
   }

   public Rotation clamp() {
      return new Rotation(this.yaw, clampPitch(this.pitch));
   }

   public Rotation normalize() {
      return new Rotation(normalizeYaw(this.yaw), this.pitch);
   }

   public Rotation normalizeAndClamp() {
      return new Rotation(normalizeYaw(this.yaw), clampPitch(this.pitch));
   }

   public boolean isReallyCloseTo(Rotation var1) {
      return this.yawIsReallyClose(var1) && Math.abs(this.pitch - var1.pitch) < ук;
   }

   public Rotation add(Rotation var1) {
      return new Rotation(this.yaw + var1.yaw, this.pitch + var1.pitch);
   }

   public float getYaw() {
      return this.yaw;
   }

   public Rotation withPitch(float var1) {
      return new Rotation(this.yaw, var1);
   }

   public static float normalizeYaw(float var0) {
      float var1 = var0 % уд;
      if (var1 < уе) {
         var1 += у6;
      }

      if (var1 > уl) {
         var1 -= у必;
      }

      return var1;
   }
}
