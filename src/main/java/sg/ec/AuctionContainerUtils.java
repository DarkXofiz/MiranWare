// Original binary: sg/ec/AprY17jekdVoP16X
package sg.ec;

import java.util.Locale;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public final class AuctionContainerUtils implements MinecraftAccess {
   public static final int field06165 = 44;
   public static final int field06166 = 0;
   public static final int field06167 = 0;
   public static final int field06168 = 0;
   public static final String field06169 = "field06169";
   public static final String field06170 = "field06170";
   public static final String field06171 = "field06171";
   public static final String field06172 = "field06172";
   private static final int[] field06173 = new int[]{49, 51, 50, 45};
   private static final String[] field06174 = new String[]{AuctionContainerUtils.field06182, AuctionContainerUtils.field06183};
   private static final int field06175 = 0;
   private static final int field06176 = 0;
   private static final String field06177 = "field06177";
   private static final int field06178 = 0;
   private static final AuctionSearchController field06179 = new AuctionSearchController();
   private static final String field06180 = "выбрать режим";
   private static final String field06181 = "обновить";
   private static final String field06182 = "Обновить";
   private static final String field06183 = "⟲";

   public static boolean method02610() {
      return field06179.method06892(method02620(), method02619());
   }

   public static boolean method02611(ItemStack var0, String var1) {
      if (var0 != null && !var0.isEmpty()) {
         Component var2 = var0.get(DataComponents.CUSTOM_NAME);
         return var2 != null && var2.getString().contains(var1);
      } else {
         return false;
      }
   }

   public static AbstractContainerMenu method02612() {
      return mc.player == null ? null : mc.player.containerMenu;
   }

   public static int method02613(AbstractContainerMenu var0) {
      if (var0 == null) {
         return -1;
      }

      for (int var1 = 45; var1 <= 53; var1++) {
         if (method02617(method02618(var0, var1))) {
            return var1;
         }
      }

      return -1;
   }

   public static void method02614(AbstractContainerMenu var0, int var1, ClickType var2) {
      if (var0 != null && mc.player != null && mc.gameMode != null && var1 >= 0 && var1 < var0.slots.size()) {
         mc.gameMode.handleInventoryMouseClick(var0.containerId, var1, 0, var2, mc.player);
      }
   }

   private AuctionContainerUtils() {
   }

   public static int method02615(AbstractContainerMenu var0) {
      if (var0 == null) {
         return -1;
      }

      for (int var4 : field06173) {
         ItemStack var5 = method02618(var0, var4);
         if (!var5.isEmpty() && !method02617(var5) && method02625(var5)) {
            return var4;
         }
      }

      for (int var9 : field06173) {
         ItemStack var10 = method02618(var0, var9);
         if (var10.getItem() == Items.NETHER_STAR && !method02617(var10)) {
            return var9;
         }
      }

      return -1;
   }

   public static boolean method02616(String var0) {
      return method02619().contains(var0);
   }

   public static boolean method02617(ItemStack var0) {
      if (var0 != null && !var0.isEmpty()) {
         for (Component var2 : ItemTooltipUtils.method02660(var0)) {
            if (ItemTooltipUtils.method02659(var2.getString()).toLowerCase(Locale.ROOT).contains(field06180)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public static ItemStack method02618(AbstractContainerMenu var0, int var1) {
      if (var0 != null && var1 >= 0 && var1 < var0.slots.size()) {
         ItemStack var2 = var0.getSlot(var1).getItem();
         return var2 == null ? ItemStack.EMPTY : var2;
      } else {
         return ItemStack.EMPTY;
      }
   }

   public static String method02619() {
      return mc.gui != null && mc.screen != null && mc.screen.getTitle() != null ? mc.screen.getTitle().getString() : "";
   }

   private static AbstractContainerMenu method02620() {
      AbstractContainerMenu var0 = method02612();
      return var0 != null && mc.player != null && var0 != mc.player.inventoryMenu ? var0 : null;
   }

   public static boolean method02621(AbstractContainerMenu var0) {
      return method02618(var0, 47).getItem() == Items.EMERALD;
   }

   public static int method02622(AbstractContainerMenu var0, String var1) {
      if (var0 != null && var1 != null && !var1.isEmpty()) {
         String var2 = UnicodeTextNormalizer.method09496(var1);
         int var3 = var0.slots.size() - 36 - 1;

         for (int var4 = 0; var4 <= var3; var4++) {
            ItemStack var5 = method02618(var0, var4);
            if (!var5.isEmpty() && UnicodeTextNormalizer.method09496(var5.getHoverName().getString()).contains(var2)) {
               return var4;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   public static void method02623() {
      if (mc.player != null) {
         if (mc.gui != null && mc.screen != null) {
            mc.setScreen(null);
         }

         if (mc.player.containerMenu != mc.player.inventoryMenu) {
            mc.player.closeContainer();
         }
      }
   }

   public static boolean method02624() {
      return mc.gui != null && mc.screen != null;
   }

   private static boolean method02625(ItemStack var0) {
      Component var1 = var0.get(DataComponents.CUSTOM_NAME);
      if (var1 == null) {
         return false;
      }

      String var2 = var1.getString();

      for (String var6 : field06174) {
         if (var2.contains(var6)) {
            return true;
         }
      }

      return var2.toLowerCase(Locale.ROOT).contains(field06181);
   }

   public static boolean method02626() {
      return field06179.method06894(method02620(), method02619());
   }
}
