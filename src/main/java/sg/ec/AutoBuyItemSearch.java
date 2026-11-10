// Original binary: sg/ec/jhA51iXCtcCJvPle
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
final class AutoBuyItemSearch {
   private static final int field20555 = 27;
   private static final int field20556 = 0;
   private String field20557 = "";
   private int field20558 = -1;
   private AutoBuyServer field20559;
   private List<AutoBuyItem> field20560 = List.of();
   private List<AutoBuyItemSearch.Nested251> field20561 = List.of();

   List<AutoBuyItem> method09032() {
      return this.field20560;
   }

   private boolean method09033(Item var1, String var2) {
      for (AutoBuyItem var4 : AutoBuyItemRegistry.INSTANCE.method10993(this.field20559, var1)) {
         if (var2.equals(var4.method10673())) {
            return true;
         }
      }

      return false;
   }

   private static List<AutoBuyItem> method09034(String var0) {
      ArrayList var1 = new ArrayList();

      for (AutoBuyItem var3 : AutoBuyItemRegistry.INSTANCE.method10988()) {
         if (var0.isEmpty() || TextRenderUtils.method00672(var3.method10673()).contains(var0)) {
            var1.add(var3);
         }
      }

      return List.copyOf(var1);
   }

   List<AutoBuyItemSearch.Nested251> method09035() {
      return this.field20561;
   }

   private List<AutoBuyItemSearch.Nested251> method09036(String var1) {
      ArrayList var2 = new ArrayList();

      for (Item var4 : BuiltInRegistries.ITEM) {
         if (var2.size() >= 27) {
            break;
         }

         if (var4 != Items.AIR) {
            String var5 = AutoBuyItem.method10670(var4);
            if (TextRenderUtils.method00672(var5).contains(var1) && !this.method09033(var4, var5)) {
               var2.add(new AutoBuyItemSearch.Nested251(var4, AutoBuyItem.method10676(var4), var5));
            }
         }
      }

      return List.copyOf(var2);
   }

   void method09037(String var1) {
      String var2 = TextRenderUtils.method00672(var1);
      int var3 = AutoBuyItemRegistry.INSTANCE.method10999();
      AutoBuyServer var4 = AutoBuyItemRegistry.INSTANCE.method10998();
      if (!var2.equals(this.field20557) || var3 != this.field20558 || var4 != this.field20559) {
         this.field20557 = var2;
         this.field20558 = var3;
         this.field20559 = var4;
         this.field20560 = method09034(var2);
         this.field20561 = var2.length() < 2 ? List.of() : this.method09036(var2);
      }
   }

   // $VF: Compiled from s
   record Nested251(Item item, ItemStack stack, String name) {
   }
}
