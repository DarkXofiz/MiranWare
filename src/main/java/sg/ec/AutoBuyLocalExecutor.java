// Original binary: sg/ec/C7PZt0FRYsrqjHuC
package sg.ec;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class AutoBuyLocalExecutor implements AutoBuyExecutor, MinecraftAccess {
   public static final AutoBuyLocalExecutor field06677 = new AutoBuyLocalExecutor();
   private static final String field06678 = "AutoBuy";
   private static final String field06679 = "AutoBuy";

   private AutoBuyLocalExecutor() {
   }

   @Override
   public void method02861() {
      AuctionContainerUtils.method02623();
   }

   @Override
   public AbstractContainerMenu method02862() {
      return AuctionContainerUtils.method02612();
   }

   @Override
   public void method02863(AbstractContainerMenu var1, int var2, ClickType var3) {
      AuctionContainerUtils.method02614(var1, var2, var3);
   }

   @Override
   public boolean method02864() {
      return AuctionContainerUtils.method02624() || mc.player != null && mc.player.containerMenu != mc.player.inventoryMenu;
   }

   @Override
   public String method02865() {
      return AuctionContainerUtils.method02619();
   }

   @Override
   public void method02866(ItemStack var1, String var2, long var3, long var5) {
      PurchaseHistory.field06969.method03141(var1, var2, var3, var5);
   }

   @Override
   public void method02867(String var1) {
      AuctionCommandSender.field08741.method03893(var1);
   }

   @Override
   public boolean method02868() {
      return AuctionCommandSender.field08741.method03892();
   }

   @Override
   public int method02869(Item var1) {
      return mc.player == null ? 0 : AutoBuyExecutor.method10160(mc.player.getInventory(), var1);
   }

   @Override
   public boolean method02870() {
      return AuctionContainerUtils.method02626();
   }

   @Override
   public Long method02871() {
      return CoinBalanceReader.method00045();
   }

   @Override
   public boolean method02872() {
      return mc.player != null && mc.level != null && mc.player.connection != null;
   }

   @Override
   public void method02873(String var1) {
      ChatTextUtils.method05101(field06679, var1);
   }
}
