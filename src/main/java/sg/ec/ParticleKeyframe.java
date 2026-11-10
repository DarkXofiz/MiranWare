// Original binary: sg/ec/OdLJbxsFHD8xarGI
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import java.util.function.Consumer;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;

// $VF: Compiled from s
public class ParticleKeyframe {
   private static final String field10653 = "KEYFRAME";

   public static void method04810(
      List<ParticleAnimationConfig> var0,
      boolean var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22,
      double var24,
      double var26,
      Identifier var28,
      String var29,
      InteractionHand var30,
      String var31,
      String var32,
      double var33,
      double var35
   ) {
      method04811(
         var0,
         var1,
         var2,
         var4,
         var6,
         var8,
         var10,
         var12,
         var14,
         var16,
         var18,
         var20,
         var22,
         var24,
         var26,
         var28,
         var29,
         var30,
         var31,
         var32,
         var33,
         var35,
         null
      );
   }

   public static void method04811(
      List<ParticleAnimationConfig> var0,
      boolean var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22,
      double var24,
      double var26,
      Identifier var28,
      String var29,
      InteractionHand var30,
      String var31,
      String var32,
      double var33,
      double var35,
      Consumer<ParticleAnimationConfig> var37
   ) {
      var0.add(
         new ParticleAnimationConfig(
            var1, var2, var4, var6, var8, var10, var12, var14, var16, var18, var20, var22, var24, var26, var28, var29, var30, var31, var32, var33, var35, var37
         )
      );
   }

   public static void method04812(
      List<ParticleAnimationConfig> var0,
      boolean var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22,
      double var24,
      double var26,
      Identifier var28,
      String var29,
      InteractionHand var30,
      String var31,
      String var32,
      double var33,
      double var35,
      Consumer<ParticleAnimationConfig> var37,
      PoseStack var38
   ) {
      var0.add(
         new ParticleAnimationConfig(
            var1,
            var2,
            var4,
            var6,
            var8,
            var10,
            var12,
            var14,
            var16,
            var18,
            var20,
            var22,
            var24,
            var26,
            var28,
            var29,
            var30,
            var31,
            var32,
            var33,
            var35,
            var37,
            var38
         )
      );
   }

   public static void method04813(
      List<ParticleAnimationConfig> var0,
      boolean var1,
      double var2,
      double var4,
      double var6,
      double var8,
      double var10,
      double var12,
      double var14,
      double var16,
      double var18,
      double var20,
      double var22,
      double var24,
      double var26,
      Identifier var28,
      List<Identifier> var29,
      String var30,
      InteractionHand var31,
      String var32,
      String var33,
      double var34,
      double var36,
      Consumer<ParticleAnimationConfig> var38
   ) {
      for (ParticleAnimationConfig var40 : var0) {
         if (field10653.equals(var40.field08000) && var40.field08023 == var31) {
            return;
         }
      }

      var0.add(
         new ParticleAnimationConfig(
            var1,
            var2,
            var4,
            var6,
            var8,
            var10,
            var12,
            var14,
            var16,
            var18,
            var20,
            var22,
            var24,
            var26,
            var28,
            var29,
            var30,
            var31,
            var32,
            var33,
            var34,
            var36,
            var38
         )
      );
   }
}
