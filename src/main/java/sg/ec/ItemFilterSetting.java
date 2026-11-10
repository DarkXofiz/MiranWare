// Original binary: sg/ec/4agTTpQgYtSImPvw
package sg.ec;

import java.util.function.Predicate;
import net.minecraft.ChatFormatting;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public class ItemFilterSetting extends Setting<ItemFilterSetting.Nested29> {
   private static final int field02046 = 1;
   private static final int field02047 = 0;
   private Predicate<ItemStack> field02048 = var0 -> !var0.isEmpty();
   private ItemStack field02049 = ItemStack.EMPTY;

   public int method00864(ItemStack var1) {
      ItemFilterSetting.Nested29 var2 = this.method03022();
      return var2 == null ? 0 : var2.score(var1);
   }

   protected void method00865(ItemFilterSetting.Nested29 var1) {
      super.method00870(var1);
      this.field02049 = ItemStack.EMPTY;
   }

   public Predicate<ItemStack> method00866() {
      return this.field02048;
   }

   public boolean method00867(ItemStack var1) {
      return this.method00864(var1) > 0;
   }

   public ItemFilterSetting method00868(Predicate<ItemStack> var1) {
      this.field02048 = var1;
      return this;
   }

   public ItemFilterSetting(String var1) {
      super(var1);
   }

   @Override
   public void method00869() {
      this.method00865(null);
   }

   public void method00871(ItemFilterSetting.Nested29 var1) {
      this.method00865(var1);
   }

   public boolean method00872() {
      return this.method03022() != null;
   }

   public ItemStack method00874() {
      ItemFilterSetting.Nested29 var1 = this.method03022();
      if (var1 == null) {
         return ItemStack.EMPTY;
      }

      if (this.field02049.isEmpty()) {
         this.field02049 = var1.buildStack();
      }

      return this.field02049;
   }

   // $VF: Compiled from s
   public record Nested29(Item item, String skin, String name) {
      private ItemStack buildStack() {
         ItemStack var1 = AutoBuyItem.method10676(this.item);
         if (!var1.isEmpty() && this.skin != null) {
            PlayerHeadUtils.method09243(var1, PlayerHeadUtils.method09240(this.skin));
         }

         return var1;
      }

      private static String nameOf(ItemStack var0) {
         String var1 = ChatFormatting.stripFormatting(RawTextScope.method04525(() -> var0.getHoverName().getString()));
         return var1 == null ? "" : var1.trim();
      }

      public String itemId() {
         return BuiltInRegistries.ITEM.getKey(this.item).toString();
      }

      public int score(ItemStack var1) {
         if (!var1.isEmpty() && var1.getItem() == this.item) {
            if (this.skin != null) {
               String var2 = PlayerHeadUtils.method09244(var1);
               if (var2 != null) {
                  if (!this.skin.equals(var2)) {
                     return 0;
                  }

                  return this.name.equals(nameOf(var1)) ? 3 : 2;
               }
            }

            return this.name.equals(nameOf(var1)) ? 1 : 0;
         } else {
            return 0;
         }
      }

      public static ItemFilterSetting.Nested29 method00875(ItemStack var0) {
         return new ItemFilterSetting.Nested29(var0.getItem(), PlayerHeadUtils.method09244(var0), nameOf(var0));
      }

      public static ItemFilterSetting.Nested29 parse(String var0, String var1, String var2) {
         Identifier var3 = var0 == null ? null : Identifier.tryParse(var0);
         Item var4 = var3 == null ? Items.AIR : BuiltInRegistries.ITEM.getValue(var3);
         return var4 == Items.AIR ? null : new ItemFilterSetting.Nested29(var4, var1 != null && !var1.isBlank() ? var1 : null, var2 == null ? "" : var2);
      }
   }
}
