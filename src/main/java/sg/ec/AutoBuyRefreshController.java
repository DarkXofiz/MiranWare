// Original binary: sg/ec/lXXO1uV7PmWVlRuj
package sg.ec;

import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;

// $VF: Compiled from s
public final class AutoBuyRefreshController implements MinecraftAccess {
   private static final long field21317 = 700L;
   private static final int field21318 = 0;
   private boolean field21319;
   private boolean field21320;
   private int field21321;
   private long field21322;
   private static final String field21323 = "AutoBuy";
   private static final long field21324 = 700L;

   public void method09386(long var1) {
      AutoBuySettings.Nested239 var3 = AutoBuySettings.field19624.method08576();
      if (var3 != AutoBuySettings.Nested239.KEEP && AuctionContainerUtils.method02626()) {
         AbstractContainerMenu sx = AuctionContainerUtils.method02612();
         int sxx = AuctionContainerUtils.method02613(sx);
         if (sxx < 0) {
            this.field21319 = false;
         } else if (AuctionContainerUtils.method02611(AuctionContainerUtils.method02618(sx, sxx), var3.field19664)) {
            this.method09388();
         } else if (!this.field21320 && var1 >= this.field21322) {
            if (this.field21321 >= 4) {
               this.field21320 = true;
               this.field21319 = false;
               ChatTextUtils.method05101(field21323, "Режим «" + var3.field19664 + "» на аукционе не найден.");
            } else {
               this.field21321++;
               this.field21319 = true;
               this.field21322 = var1 + field21324;
               AuctionContainerUtils.method02614(sx, sxx, ContainerInput.PICKUP);
            }
         }
      } else {
         this.method09388();
      }
   }

   public boolean method09387() {
      return this.field21319;
   }

   public void method09388() {
      this.field21319 = false;
      this.field21320 = false;
      this.field21321 = 0;
      this.field21322 = 0L;
   }
}
