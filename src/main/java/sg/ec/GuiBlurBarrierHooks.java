// Original binary: sg/ec/FShkokVi97MTUPcI
package sg.ec;

import com.mojang.blaze3d.pipeline.RenderTarget;
import it.unimi.dsi.fastutil.ints.IntArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import net.minecraft.client.renderer.state.gui.GuiRenderState;

// $VF: Compiled from s
public final class GuiBlurBarrierHooks {
   private static final RenderBarrierState field07598 = new RenderBarrierState();
   private static final IntArrayList field07599 = new IntArrayList();

   public static boolean method03408(GuiElementRenderState var0) {
      return var0 instanceof RenderBarrierState;
   }

   public static int method03409(int var0) {
      return field07599.getInt(var0);
   }

   public static void method03410(GuiRenderState var0) {
      GuiRenderBatch.method05187(var0, field07598);
   }

   public static void method03411(int var0) {
      int var1 = field07599.size();
      if (var1 <= 0 || field07599.getInt(var1 - 1) != var0) {
         field07599.add(var0);
      }
   }

   private GuiBlurBarrierHooks() {
   }

   public static void method03412() {
      field07599.clear();
   }

   public static void method03413(RenderTarget var0) {
      RenderTarget var1 = HudBlitRenderer.method10068() ? Minecraft.getInstance().gameRenderer.mainRenderTarget() : var0;
      GuiBlurRenderer.method11252(var1, true);
   }

   public static int method03414() {
      return field07599.size();
   }
}
