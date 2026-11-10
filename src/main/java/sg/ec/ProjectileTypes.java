// Original binary: sg/ec/qd5mdRJdrJexh8jK
package sg.ec;

import hex.script.api.Prediction;
import java.util.ArrayList;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class ProjectileTypes implements MinecraftAccess {
   private static final int field23099 = 100;
   private static final int field23100 = 0;
   private final Prediction field23101 = new Prediction(this::method10265, this::method10264);
   private static final String field23102 = "arrow";
   private static final double field23103 = 0.99;
   private static final String field23104 = "trident";
   private static final double field23105 = 0.99;
   private static final double field23106 = 0.6;
   private static final String field23107 = "pearl";
   private static final String field23108 = "snowball";
   private static final String field23109 = "egg";
   private static final String field23110 = "potion";
   private static final String field23111 = "trident";
   private static final double field23112 = 1.5;
   private static final double field23113 = 0.5;
   private static final double field23114 = 2.5;
   private static final double field23115 = 3.0;
   private static final String field23116 = "pearl";
   private static final String field23117 = "snowball";
   private static final String field23118 = "egg";
   private static final String field23119 = "potion";
   private static final double field23120 = 0.03;
   private static final double field23121 = 0.05;
   private static final double field23122 = 0.05;

   private double method10263(String var1) {
      return switch (var1) {
         case field23116, field23117, field23118 -> field23120;
         case field23119 -> field23121;
         default -> field23122;
      };
   }

   private double[] method10264(String var1, float var2, float var3, float var4) {
      if (mc.player != null && mc.level != null) {
         String var5 = var1 == null ? field23102 : var1.toLowerCase();
         float var6 = Float.isNaN(var2) ? RotationManager.method06563() : var2;
         float var7 = Float.isNaN(var3) ? RotationManager.method06557() : var3;
         double var8 = var4 > 0.0F ? var4 : this.method10267(var5);
         double var10 = this.method10263(var5);
         double var12 = field23103;
         double var14 = var5.equals(field23104) ? field23105 : field23106;
         Vec3 var16 = ProjectilePhysics.method03999(mc.player, 1.0F);
         Vec3 var17 = RaycastUtils.method09509(var7, var6);
         ArrayList var18 = new ArrayList();

         ProjectilePhysics.Nested117 var19;
         try {
            var19 = ProjectilePhysics.method03996(var16, var17, var8, Vec3.ZERO, var10, var12, var14, null, Vec3.ZERO, 0, 120, var18);
         } catch (Throwable var25) {
            return null;
         }

         boolean var20 = var19 != null && var19.hitPos() != null;
         Vec3 var21 = var20 ? var19.hitPos() : Vec3.ZERO;
         double[] var22 = new double[4 + var18.size() * 3];
         var22[0] = var20 ? 1.0 : 0.0;
         var22[1] = var21.x;
         var22[2] = var21.y;
         var22[3] = var21.z;

         for (int var23 = 0; var23 < var18.size(); var23++) {
            Vec3 var24 = (Vec3)var18.get(var23);
            var22[4 + var23 * 3] = var24.x;
            var22[5 + var23 * 3] = var24.y;
            var22[6 + var23 * 3] = var24.z;
         }

         return var22;
      } else {
         return null;
      }
   }

   private double[] method10265(int var1) {
      if (mc.player != null && mc.level != null) {
         int var2 = Math.max(1, Math.min(100, var1));

         SimulatedPlayerInput var3;
         try {
            var3 = SimulatedPlayerInput.method08894(SimulatedPlayerInput.Nested248.fromClientPlayer(mc.player.input.keyPresses));
         } catch (Throwable var7) {
            return null;
         }

         double[] var4 = new double[var2 * 9];

         for (int var5 = 0; var5 < var2; var5++) {
            var3.method08897();
            int var6 = var5 * 9;
            var4[var6] = var3.field20218.x;
            var4[var6 + 1] = var3.field20218.y;
            var4[var6 + 2] = var3.field20218.z;
            var4[var6 + 3] = var3.field20219.x;
            var4[var6 + 4] = var3.field20219.y;
            var4[var6 + 5] = var3.field20219.z;
            var4[var6 + 6] = var3.field20229 ? 1.0 : 0.0;
            var4[var6 + 7] = var3.field20232 ? 1.0 : 0.0;
            var4[var6 + 8] = var3.field20224 ? 1.0 : 0.0;
         }

         return var4;
      } else {
         return null;
      }
   }

   Prediction method10266() {
      return this.field23101;
   }

   private double method10267(String var1) {
      return switch (var1) {
         case field23107, field23108, field23109 -> field23112;
         case field23110 -> field23113;
         case field23111 -> field23114;
         default -> field23115;
      };
   }
}
