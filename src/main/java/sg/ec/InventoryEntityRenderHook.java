// Original binary: sg/ec/3h0tzXqVb61jXZbm
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.screens.inventory.InventoryScreen;
import net.minecraft.world.entity.LivingEntity;

// $VF: Compiled from s
public final class InventoryEntityRenderHook {
   public static void method00748(
      GuiGraphicsExtractor var0, int var1, int var2, int var3, int var4, int var5, float var6, float var7, float var8, LivingEntity var9
   ) {
      float var10 = ContainerAnimationEvent.field11706.method05372();
      if (var10 < 1.0F) {
         float sx = var0.guiWidth() / 2.0F;
         float sxx = var0.guiHeight() / 2.0F;
         var1 = Math.round(sx + (var1 - sx) * var10);
         var2 = Math.round(sxx + (var2 - sxx) * var10);
         var3 = Math.round(sx + (var3 - sx) * var10);
         var4 = Math.round(sxx + (var4 - sxx) * var10);
         var5 = Math.round(var5 * var10);
         if (var5 < 1 || var3 - var1 < 1 || var4 - var2 < 1) {
            return;
         }
      }

      InventoryScreen.extractEntityInInventoryFollowsMouse(var0, var1, var2, var3, var4, var5, var6, var7, var8, var9);
   }

   private InventoryEntityRenderHook() {
   }
}
