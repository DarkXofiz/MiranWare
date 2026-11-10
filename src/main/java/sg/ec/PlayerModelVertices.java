// Original binary: sg/ec/ALYD4TMvOW7IhLxS
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.math.Axis;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelPart.Cube;
import net.minecraft.client.model.geom.ModelPart.Visitor;
import net.minecraft.client.model.player.PlayerModel;
import org.joml.Matrix4f;
import org.joml.Vector3f;

// $VF: Compiled from s
public final class PlayerModelVertices {
   private static final float field06018 = 180.0F;
   private static final float field06019 = -1.0F;
   private static final float field06020 = -1.0F;
   private static final float field06021 = 0.8F;
   private static final float field06022 = 0.9F;
   private static final float field06023 = 0.8F;
   private static final float field06024 = -1.5F;
   private static final float field06025 = 16.0F;
   private static final float field06026 = 16.0F;
   private static final float field06027 = 16.0F;

   private PlayerModelVertices() {
   }

   public static List<Vector3f> method02510(CapturedPlayer var0, int var1) {
      var var2 = new ArrayList(Math.max(0, var1));
      if (var1 > 0 && var0.field06963 != null) {
         ArrayList var3 = new ArrayList();
         ArrayList var4 = new ArrayList();
         ArrayList<Float> var5 = new ArrayList<>();
         float[] var6 = new float[]{0.0F};
         PoseStack var7 = new PoseStack();
         var7.translate(var0.getX(), var0.getY(), var0.getZ());
         var7.mulPose(Axis.YP.rotationDegrees(field06018 - var0.yBodyRot));
         var7.scale(field06019, field06020, 1.0F);
         var7.scale(field06021, field06022, field06023);
         var7.translate(0.0F, field06024, 0.0F);
         Visitor var8 = (var4x, var5x, var6x, var7x) -> {
            float var8x = Math.abs((var7x.maxX - var7x.minX) * (var7x.maxY - var7x.minY) * (var7x.maxZ - var7x.minZ));
            if (!(var8x <= 0.0F)) {
               var6[0] += var8x;
               var3.add(new Matrix4f(var4x.pose()));
               var4.add(var7x);
               var5.add(var6[0]);
            }
         };
         PlayerModel var9 = var0.field06963;
         ModelPart[] var10 = new ModelPart[]{var9.head, var9.body, var9.leftArm, var9.rightArm, var9.leftLeg, var9.rightLeg};

         for (ModelPart var14 : var10) {
            var7.pushPose();
            var14.visit(var7, var8);
            var7.popPose();
         }

         int var21 = var4.size();
         if (var21 != 0 && !(var6[0] <= 0.0F)) {
            ThreadLocalRandom var22 = ThreadLocalRandom.current();

            for (int var23 = 0; var23 < var1; var23++) {
               float var24 = var22.nextFloat() * var6[0];
               int var15 = 0;

               while (var15 < var21 - 1 && var5.get(var15) < var24) {
                  var15++;
               }

               Cube var16 = (Cube)var4.get(var15);
               float var17 = var16.minX + var22.nextFloat() * (var16.maxX - var16.minX);
               float var18 = var16.minY + var22.nextFloat() * (var16.maxY - var16.minY);
               float var19 = var16.minZ + var22.nextFloat() * (var16.maxZ - var16.minZ);
               Vector3f var20 = new Vector3f(var17 / field06025, var18 / field06026, var19 / field06027);
               ((Matrix4f)var3.get(var15)).transformPosition(var20);
               var2.add(var20);
            }

            return var2;
         } else {
            return var2;
         }
      } else {
         return var2;
      }
   }
}
