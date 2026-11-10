// Original binary: sg/ec/qFh0B54CL87Tct1I
package sg.ec;

import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public interface AutoBuyExecutor {
   boolean method02870();

   void method02873(String var1);

   boolean method02864();

   int method02869(Item var1);

   static int method10160(Inventory var0, Item var1) {
      if (var0 == null) {
         return 0;
      }

      int var2 = 0;

      for (int sx = 0; sx < var0.getContainerSize(); sx++) {
         ItemStack sxx = var0.getItem(sx);
         if (sxx != null && !sxx.isEmpty() && sxx.getItem() == var1) {
            var2 += sxx.getCount();
         }
      }

      return var2;
   }

   boolean method02868();

   AbstractContainerMenu method02862();

   String method02865();

   void method02861();

   boolean method02872();

   void method02863(AbstractContainerMenu var1, int var2, ContainerInput var3);

   Long method02871();

   void method02867(String var1);

   void method02866(ItemStack var1, String var2, long var3, long var5);

   default boolean method10161(String var1) {
      return this.method02865().contains(var1);
   }
}
