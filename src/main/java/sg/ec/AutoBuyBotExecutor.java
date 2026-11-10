// Original binary: sg/ec/vwy2Km7UxFjFT4JR
package sg.ec;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public final class AutoBuyBotExecutor implements AutoBuyExecutor {
   private static final String field24976 = "AUTOBUY";
   private final BotClient field24977;
   private final AuctionSearchController field24978 = new AuctionSearchController();
   private final BotCommandQueue field24979;
   private AutoBuyBotExecutor.Nested319 field24980;
   private static final String field24981 = "AUTOBUY";

   @Override
   public String method02865() {
      return this.field24977.method00135().method03054().getString();
   }

   void method11154(long var1) {
      this.field24979.method01889(var1);
   }

   @Override
   public void method02867(String var1) {
      this.field24979.method01890(var1);
   }

   boolean method11155() {
      return this.field24980 != null;
   }

   void method11156() {
      this.field24979.method01888();
      this.field24980 = null;
   }

   @Override
   public int method02869(Item var1) {
      BotLocalPlayer var2 = this.field24977.method00090().method07688();
      return var2 == null ? 0 : AutoBuyExecutor.method10160(var2.getInventory(), var1);
   }

   AutoBuyBotExecutor.Nested319 method11157() {
      AutoBuyBotExecutor.Nested319 var1 = this.field24980;
      this.field24980 = null;
      return var1;
   }

   @Override
   public void method02866(ItemStack var1, String var2, long var3, long var5) {
      if (var1 != null && !var1.isEmpty()) {
         this.field24980 = new AutoBuyBotExecutor.Nested319(var1.copy(), var2 == null ? "" : var2.trim(), Math.max(0L, var3), Math.max(0L, var5));
      } else {
         this.field24980 = null;
      }
   }

   @Override
   public boolean method02870() {
      return this.field24978.method06894(this.method02862(), this.method02865());
   }

   @Override
   public Long method02871() {
      return this.field24977.method00090().method07790(CoinBalanceReader::method00046);
   }

   @Override
   public boolean method02864() {
      return this.field24977.method00135().method03048();
   }

   @Override
   public void method02873(String var1) {
   }

   @Override
   public AbstractContainerMenu method02862() {
      return this.field24977.method00135().method03050();
   }

   public AutoBuyBotExecutor(BotClient var1) {
      this.field24977 = var1;
      this.field24979 = new BotCommandQueue(var1);
   }

   @Override
   public boolean method02868() {
      return this.field24979.method01886();
   }

   @Override
   public void method02863(AbstractContainerMenu var1, int var2, ContainerInput var3) {
      if (var1 != null && var2 >= 0 && var2 < var1.slots.size()) {
         this.field24977.method00135().method03053(var2, 0, var3);
      }
   }

   @Override
   public boolean method02872() {
      return this.field24977.method00146() == BotConnectionState.PLAYING
         && this.field24977.method00090().method07688() != null
         && this.field24977.method00090().method07636() != null;
   }

   @Override
   public void method02861() {
      this.field24977.method00135().method03041();
   }

   // $VF: Compiled from s
   record Nested319(ItemStack stack, String seller, long priceCeiling, long marketPrice) {
   }
}
