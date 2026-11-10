// Original binary: sg/ec/sBtn5hiTIom5VdAz
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.model.HeadedModel;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.ArmorStandRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.LivingEntity;

// $VF: Compiled from s
public final class LivingEntityRendererHooks {
   public static float method10654(LivingEntity var0, float var1, float var2) {
      return RotationRenderHooks.method05678(var0) ? RotationRenderHooks.method05684(var1) : var2;
   }

   public static float method10655(LivingEntity var0, float var1) {
      return RotationRenderHooks.method05678(var0) ? RotationRenderHooks.method05680(var1) : var0.getXRot(var1);
   }

   public static float method10656(LivingEntity var0, float var1, float var2) {
      float var3 = RotationRenderHooks.method05678(var0) ? RotationRenderHooks.method05682(var1) - RotationRenderHooks.method05684(var1) : var2;
      return Mth.wrapDegrees(var3);
   }

   public static void method10657(LivingEntityRenderState var0, PoseStack var1, SubmitNodeCollector var2, Object var3) {
      ChinaHat var4 = ModuleManager.INSTANCE.method08196();
      if (var4 != null && var4.method03937()) {
         if (var3 instanceof HeadedModel var5) {
            var4.method05069(var0, var1, var2, var5.getHead());
         }
      }
   }

   public static boolean method10658(LivingEntityRenderState var0, boolean var1) {
      return var0 instanceof ArmorStandRenderState ? var1 : InvisibleEntityRenderEvent.field06162.method02606(var1, var0.isInvisible);
   }

   public static int method10659(LivingEntityRenderState var0, int var1) {
      return var0 instanceof ArmorStandRenderState ? var1 : InvisibleEntityRenderEvent.field06162.method02609(var1, var0.isInvisible);
   }

   private LivingEntityRendererHooks() {
   }
}
