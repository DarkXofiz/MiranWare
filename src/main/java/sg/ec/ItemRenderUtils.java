// Original binary: sg/ec/g8O3Hq342vKlAoi7
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import net.minecraft.CrashReport;
import net.minecraft.CrashReportCategory;
import net.minecraft.ReportedException;
import net.minecraft.client.DeltaTracker;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.item.TrackingItemStackRenderState;
import net.minecraft.client.renderer.state.gui.GuiItemRenderState;
import net.minecraft.client.renderer.state.gui.GuiRenderState;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;
import org.jspecify.annotations.Nullable;

// $VF: Compiled from s
public final class ItemRenderUtils implements MinecraftAccess {
   private static boolean field19378 = false;
   private static final List<GuiItemRenderState> field19379 = new ArrayList<>();
   private static GuiRenderState field19380 = null;
   private static final float field19381 = 8.0F;
   private static final float field19382 = 5.0F;
   private static final String field19383 = "Rendering item";
   private static final String field19384 = "Item being rendered";
   private static final String field19385 = "Item Type";
   private static final String field19386 = "Item Components";
   private static final String field19387 = "Item Foil";
   private static final String field19388 = "This is a utility class and cannot be instantiated";

   private static void method08408(
      GuiGraphicsExtractor var0,
      @Nullable LivingEntity var1,
      @Nullable Level var2,
      ItemStack var3,
      float var4,
      float var5,
      float var6,
      int var7,
      float var8,
      float var9
   ) {
      if (!var3.isEmpty()) {
         TrackingItemStackRenderState var10 = new TrackingItemStackRenderState();
         mc.getItemModelResolver().updateForTopItem(var10, var3, ItemDisplayContext.GUI, var2, var1, var7);

         try {
            method08414(var0.pose(), var4, var5, var9 * var6);
            GuiItemRenderState sx = new GuiItemRenderState(new Matrix3x2f(var0.pose()), var10, 0, 0, var0.scissorStack.peek());
            ((CustomAlphaAccess)(Object)sx).setCustomAlpha(var8);
            if (field19378) {
               if (field19380 == null) {
                  field19380 = var0.guiRenderState;
               }

               field19379.add(sx);
            } else {
               var0.guiRenderState.addItem(sx);
            }

            var0.pose().popMatrix();
         } catch (Throwable sx) {
            CrashReport sxx = CrashReport.forThrowable(sx, field19383);
            CrashReportCategory sxxx = sxx.addCategory(field19384);
            sxxx.setDetail(field19385, () -> String.valueOf(var3.getItem()));
            sxxx.setDetail(field19386, () -> String.valueOf(var3.getComponents()));
            sxxx.setDetail(field19387, () -> String.valueOf(var3.hasFoil()));
            throw new ReportedException(sxx);
         }
      }
   }

   public static void method08409(GuiGraphicsExtractor var0, int var1, int var2, DeltaTracker var3, Player var4, ItemStack var5, int var6) {
      if (!var5.isEmpty()) {
         float var7 = var5.getPopTime() - var3.getGameTimeDeltaPartialTick(true);
         if (var7 > 0.0F) {
            float var8 = 1.0F + var7 / field19382;
            var0.pose().pushMatrix();
            var0.pose().translate(var1 + 8, var2 + 12);
            var0.pose().scale(1.0F / var8, (var8 + 1.0F) / 2.0F);
            var0.pose().translate(-(var1 + 8), -(var2 + 12));
         }

         var0.item(var4, var5, var1, var2, var6);
         if (var7 > 0.0F) {
            var0.pose().popMatrix();
         }

         var0.itemDecorations(mc.font, var5, var1, var2);
      }
   }

   public static void method08410() {
      field19378 = true;
      field19379.clear();
      field19380 = null;
   }

   public static void method08411() {
      if (field19378 && !field19379.isEmpty() && field19380 != null) {
         var var0 = field19380.getItemModelIdentities();
         GuiNodeAccess var1 = (GuiNodeAccess)((GuiRenderStateAccess)field19380).getCurrentLayer();

         for (GuiItemRenderState var3 : field19379) {
            if (var3.bounds() != null) {
               var0.add(var3.itemStackRenderState().getModelIdentity());
               var1.IaddItem(var3);
            }
         }

         field19380.nextStratum();
         field19379.clear();
      }
   }

   public static void method08413(GuiGraphicsExtractor var0, ItemStack var1, float var2, float var3, float var4) {
      method08418(var0, var1, var2, var3, var4, 1.0F, 1.0F);
   }

   private static void method08414(Matrix3x2fStack var0, float var1, float var2, float var3) {
      var0.pushMatrix();
      var0.translate(var1, var2);
      var0.scale(var3, var3);
   }

   public static void method08415(GuiGraphicsExtractor var0, ItemStack var1, float var2, float var3, float var4, float var5, float var6) {
      method08408(var0, mc.player, mc.level, var1, var2, var3, var4, 0, var5, var6);
   }

   public static void method08416(GuiGraphicsExtractor var0, ItemStack var1, float var2, float var3, float var4, float var5) {
      method08415(var0, var1, var2, var3, var4, var5, 1.0F);
   }

   private ItemRenderUtils() {
      throw new UnsupportedOperationException(field19388);
   }

   public static void method08418(GuiGraphicsExtractor var0, ItemStack var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = field19381 * var6 * var4;
      method08415(var0, var1, var2 - var7, var3 - var7, var4, var5, var6);
   }

   public static void method08419(GuiGraphicsExtractor var0, ItemStack var1, float var2, float var3, float var4) {
      method08415(var0, var1, var2, var3, var4, 1.0F, 1.0F);
   }

   public static void method08420() {
      if (field19378) {
         method08411();
         field19378 = false;
         field19380 = null;
      }
   }

   public static void method08422(GuiGraphicsExtractor var0, ItemStack var1, float var2, float var3) {
      method08415(var0, var1, var2, var3, 1.0F, 1.0F, 1.0F);
   }
}
