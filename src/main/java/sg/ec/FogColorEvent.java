// Original binary: sg/ec/2hS9BU7mMPDC1HvH
package sg.ec;

import net.minecraft.client.Camera;
import net.minecraft.client.renderer.fog.FogData;
import net.minecraft.world.level.material.FogType;
import org.joml.Vector4f;

// $VF: Compiled from s
public class FogColorEvent extends Event {
   public static final FogColorEvent field01083 = new FogColorEvent();
   private int field01084 = -1;
   private float field01085 = 0.0F;
   private float field01086 = 0.0F;
   private boolean field01087 = false;
   private static final float field01088 = 255.0F;
   private static final float field01089 = 255.0F;
   private static final float field01090 = 255.0F;
   private static final float field01091 = 255.0F;
   private static final float field01092 = 255.0F;
   private static final float field01093 = 255.0F;
   private static final float field01094 = 255.0F;
   private static final float field01095 = 255.0F;

   public void method00570(int var1) {
      this.method00572(var1);
      super.method03208();
   }

   public int method00571() {
      return this.field01084;
   }

   public void method00572(int var1) {
      this.field01084 = var1;
      this.field01087 = true;
   }

   public float method00573() {
      return this.field01086;
   }

   public void method00574(float var1) {
      this.field01085 = var1;
   }

   public boolean method00575() {
      return this.field01087;
   }

   public void method00576(float var1) {
      this.field01086 = var1;
   }

   public float method00577() {
      return this.field01085;
   }

   public void method00578(boolean var1) {
      this.field01087 = var1;
   }

   public void method00579(Camera var1, Vector4f var2, FogData var3) {
      this.field01087 = false;
      if (var2 == null) {
         this.field01084 = -1;
      } else {
         this.field01084 = ColorUtils.method04618(var2.x, var2.y, var2.z, var2.w);
      }

      super.method03208();
      if (this.method05694()) {
         FogType var4 = var1.getFluidInCamera();
         if (var4 != FogType.WATER && var4 != FogType.LAVA && var4 != FogType.POWDER_SNOW) {
            if (var3 != null) {
               float var5 = var3.renderDistanceEnd;
               float var6 = var5 * this.field01085;
               float var7 = var5 * this.field01086;
               if (var7 < var6 + 1.0F) {
                  var7 = var6 + 1.0F;
               }

               var3.environmentalStart = var6;
               var3.renderDistanceStart = var6;
               var3.environmentalEnd = var7;
               var3.renderDistanceEnd = var7;
               var3.skyEnd = var7;
            }

            if (this.field01087 && var2 != null) {
               var2.x = ColorUtils.method04588(this.field01084) / field01088;
               var2.y = ColorUtils.method04589(this.field01084) / field01089;
               var2.z = ColorUtils.method04587(this.field01084) / field01090;
               var2.w = ColorUtils.method04625(this.field01084) / field01091;
            }
         }
      }
   }

   public Vector4f method00580(Camera var1, Vector4f var2) {
      this.field01087 = false;
      super.method03208();
      FogType var3 = var1.getFluidInCamera();
      if (this.method05694() && this.field01087 && var3 != FogType.WATER && var3 != FogType.LAVA && var3 != FogType.POWDER_SNOW) {
         var2.x = ColorUtils.method04588(this.field01084) / field01092;
         var2.y = ColorUtils.method04589(this.field01084) / field01093;
         var2.z = ColorUtils.method04587(this.field01084) / field01094;
         var2.w = ColorUtils.method04625(this.field01084) / field01095;
      }

      return var2;
   }
}
