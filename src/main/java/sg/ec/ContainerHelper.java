// Original binary: sg/ec/EICl5M4D42XKgjV5
package sg.ec;

import java.util.List;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.platform.InputConstants;
import com.mojang.blaze3d.platform.Window;
import java.util.ArrayList;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.mx.AbstractContainerScreenMixin;

// $VF: Compiled from s
public class ContainerHelper extends ClientModule {
   public final MultiToggleSetting field07046;
   public final NumberSetting<Integer> field07047;
   private double field07048;
   private double field07049;
   private final ElapsedTimer field07050;
   private static final String field07051 = "Моды";
   private static final String field07052 = "ItemScroller";
   private static final String field07053 = "InventoryTweaker";
   private static final String field07054 = "Задержка";
   private static final String field07055 = "Container Helper";
   private static final String field07056 = "ItemScroller";
   private static final double field07057 = 4.0;
   private static final String field07058 = "InventoryTweaker";
   private static final String field07059 = "ItemScroller";

   public static boolean method03211() {
      return InputCompat.isGlfwKeyDown(340) || InputCompat.isGlfwKeyDown(344);
   }

   public static boolean method03214() {
      return InputCompat.isGlfwKeyDown(341) || InputCompat.isGlfwKeyDown(345);
   }

   private boolean method03215(AbstractContainerScreen<?> var1, Slot var2, double var3, double var5) {
      if (((AbstractContainerScreenMixin)(Object)var1).IisPointOverSlot(var2, var3, var5)) {
         return true;
      }

      if (!Double.isNaN(this.field07048) && !Double.isNaN(this.field07049)) {
         double var7 = var3 - this.field07048;
         double var9 = var5 - this.field07049;
         int var11 = method03217(var7, var9);

         for (int var12 = 1; var12 < var11; var12++) {
            double var13 = (double)var12 / var11;
            double var15 = this.field07048 + var7 * var13;
            double var17 = this.field07049 + var9 * var13;
            if (((AbstractContainerScreenMixin)(Object)var1).IisPointOverSlot(var2, var15, var17)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   @Subscribe
   private void method03216(ContainerKeyEvent var1) {
      AbstractContainerScreen var2 = var1.method11618();
      CallbackInfoReturnable var3 = var1.method11620();
      boolean var4 = method03214();
      Slot var5 = ((AbstractContainerScreenMixin)(Object)var2).getFocusedSlot();
      if (this.field07046.method04520(field07058) && 81 == var1.method11624() && method03211() && var4) {
         ItemStack var6 = var5.getItem();
         List<Integer> var7 = Lists.newArrayList();

         for (int var8 = 0; var8 < var2.getMenu().slots.size(); var8++) {
            ItemStack var9 = var2.getMenu().slots.get(var8).getItem();
            if (var9.getItem().getName(var6).equals(var6.getItem().getName(var9)) && var9.getDamageValue() == var6.getDamageValue()) {
               var7.add(var8);
            }
         }

         var7.forEach(var1x -> mc.gameMode.handleContainerInput(var2.getMenu().containerId, var1x, 1, ClickType.THROW, mc.player));
         var3.setReturnValue(true);
      }
   }

   private static int method03217(double var0, double var2) {
      return Math.max(1, (int)Math.ceil(Math.max(Math.abs(var0), Math.abs(var2)) / field07057));
   }

   @Subscribe
   private void method03218(ContainerRenderEvent var1) {
      float var2 = var1.method10117();
      float var3 = var1.method10104();
      AbstractContainerScreen var4 = var1.method10114();
      if (this.field07046.method04520(field07056)) {
         Window var5 = mc.getWindow();
         boolean var6 = mc.gui.screen() != null && InputCompat.isMouseDown(0) && InputCompat.isShiftDown();
         if (var6) {
            for (Slot var8 : var4.getMenu().slots) {
               if (var8.isActive() && var8.hasItem() && this.method03215(var4, var8, var2, var3)) {
                  int var9 = this.field07047.method03022();
                  if (var9 == 0 || this.field07050.method04690(var9)) {
                     ((AbstractContainerScreenMixin)(Object)var4).IonMouseClick(var8, var8.index, 0, ClickType.QUICK_MOVE);
                     this.field07050.method04694();
                  }
               }
            }
         }
      }

      this.field07048 = var2;
      this.field07049 = var3;
   }

   public ContainerHelper() {
      super(ModuleCategory.Misc, ModuleSubCategory.Utility);
      this.field07046 = new MultiToggleSetting(field07051)
         .method04517(NamedOption.method08077(field07052, true))
         .method04517(NamedOption.method08077(field07053, true))
         .method03023(this);
      this.field07047 = new NumberSetting<Integer>(field07054)
         .method10835(0)
         .method10838(100)
         .method10834(10)
         .method03017(0)
         .method03025(() -> this.field07046.method04520(field07059))
         .method03023(this);
      this.field07048 = Double.NaN;
      this.field07049 = Double.NaN;
      this.field07050 = new ElapsedTimer();
      this.method03935(field07055);
   }
}
