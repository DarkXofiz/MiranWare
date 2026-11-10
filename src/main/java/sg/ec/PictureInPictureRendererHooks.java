// Original binary: sg/ec/e2gxfwjJjRH6Y7oA
package sg.ec;

import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.lang.ref.WeakReference;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.state.gui.pip.GuiEntityRenderState;
import net.minecraft.client.renderer.state.gui.pip.PictureInPictureRenderState;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class PictureInPictureRendererHooks {
   private static WeakReference<EntityRenderState> field18453 = new WeakReference<>(null);
   private static float field18454 = 1.0F;
   private static boolean field18455;
   private static boolean field18456;
   private static boolean field18457;
   private static float field18458;
   private static int field18459;
   private static float field18460;
   private static boolean field18461;
   private static float field18462;
   private static int field18463;
   private static int field18464 = PictureInPictureRendererHooks.field18467;
   private static final float field18465 = 0.999F;
   private static final float field18466 = 255.0F;
   private static final int field18467 = Integer.MAX_VALUE;

   public static void method07559(PictureInPictureRenderState var0, CallbackInfoReturnable<Boolean> var1) {
      if (method07560(var0)) {
         var1.setReturnValue(true);
      }
   }

   public static boolean method07560(PictureInPictureRenderState var0) {
      return field18455 && field18463 == field18464 && var0 instanceof GuiEntityRenderState var1 && var1.renderState() == field18453.get();
   }

   public static int method07561(PictureInPictureRenderState var0, int var1) {
      if (!(field18454 >= field18465) && var0 instanceof GuiEntityRenderState var2 && var2.renderState() == field18453.get()) {
         int var3 = (int)(GuiHitTestUtils.method05621(field18454) * field18466);
         return ColorUtils.method04597(var3, var3, var3, var3);
      } else {
         return var1;
      }
   }

   public static void method07562(boolean var0, boolean var1, float var2, int var3, float var4, boolean var5, float var6) {
      field18456 = var0;
      field18457 = var1;
      field18458 = var2;
      field18459 = var3;
      field18460 = var4;
      field18461 = var5;
      field18462 = var6;
      int var7 = (var0 ? 1 : 0) | (var1 ? 2 : 0) | (var5 ? 4 : 0);
      var7 = var7 * 31 + Float.floatToIntBits(var2);
      var7 = var7 * 31 + var3;
      var7 = var7 * 31 + Float.floatToIntBits(var4);
      var7 = var7 * 31 + Float.floatToIntBits(var6);
      field18463 = var7;
   }

   public static void method07563(EntityRenderState var0, float var1, boolean var2) {
      if (field18453.get() != var0) {
         field18453 = new WeakReference<>(var0);
      }

      field18454 = var1;
      field18455 = var2;
   }

   public static void method07564(PictureInPictureRenderState var0, GpuTextureView var1, int var2) {
      if (var0 instanceof GuiEntityRenderState var3 && var3.renderState() == field18453.get()) {
         field18464 = field18463;
         if (field18456 && var1 != null) {
            int var4 = (var3.x1() - var3.x0()) * var2;
            int var5 = (var3.y1() - var3.y0()) * var2;
            GuiGlowRenderer.method00787(var1, var4, var5, field18457, field18458, field18459, field18460, field18461, field18462);
         }
      }
   }

   private PictureInPictureRendererHooks() {
   }
}
