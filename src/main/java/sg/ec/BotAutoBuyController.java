// Original binary: sg/ec/jMP18y3p27uqS6tF
package sg.ec;

// $VF: Compiled from s
final class BotAutoBuyController {
   private static final String field20378 = "отдыхает";
   private static final String field20379 = "field20379";
   private static final String field20380 = "field20380";
   private static final String field20381 = "field20381";
   private final BotClient field20382;
   private final AutoBuyBotExecutor field20383;
   private final AutoBuyPurchaseController field20384;
   private final Object field20385 = new Object();
   private AbstractAuctionScanner field20386;
   private AutoBuyServer field20387;
   private volatile boolean field20388;
   private volatile String field20389;
   private static final String field20390 = "не в игре";
   private static final String field20391 = "не в игре";
   private static final String field20392 = "скупает";
   private static final String field20393 = "не в игре";
   private static final String field20394 = "отдыхает";

   void method08956() {
      synchronized (this.field20385) {
         if (this.field20388) {
            this.field20388 = false;
            this.method08959();
            this.field20384.method09142();
            this.field20383.method11156();
            this.field20389 = field20393;
         }
      }
   }

   String method08957() {
      return this.field20388 ? this.field20389 : field20391;
   }

   private AbstractAuctionScanner method08958(AutoBuyServer var1) {
      if (this.field20386 == null || this.field20387 != var1) {
         this.method08959();
         this.field20386 = var1.method06428() ? new QuickMoveAuctionScanner(this.field20383) : new ConfirmScreenAuctionScanner(this.field20383);
         this.field20387 = var1;
      }

      return this.field20386;
   }

   private void method08959() {
      if (this.field20386 != null) {
         this.field20386.method04343();
      }
   }

   void method08960(boolean var1) {
      synchronized (this.field20385) {
         long var3 = System.currentTimeMillis();
         this.field20388 = true;
         this.field20383.method11154(var3);
         if (!this.field20383.method02868()) {
            if (this.field20382.method00137().method00498() == AutoBuyBotRole.SCOUT) {
               this.method08959();
               if (!this.field20384.method09139()) {
                  this.field20384.method09149();
               }

               this.field20384.method09143(var3);
               this.field20389 = "разведка: " + this.field20384.method09150();
            } else {
               this.field20384.method09142();
               if (!var1) {
                  this.method08962();
               } else {
                  this.method08958(AutoBuyItemRegistry.INSTANCE.method10998()).method04339(var3);
                  this.field20389 = field20392;
               }
            }
         }
      }
   }

   void method08961(String var1) {
      synchronized (this.field20385) {
         if (this.field20388 && var1 != null) {
            String var3 = ItemTooltipUtils.method02659(var1).trim();
            this.field20384.method09153(var3);
            if (this.field20383.method11155()) {
               if (AuctionChatParser.method06526(var3)) {
                  this.field20383.method11157();
               } else if (AuctionChatParser.method06527(var3)) {
                  AutoBuyBotExecutor.Nested319 var4 = this.field20383.method11157();
                  String var5 = AuctionChatParser.method06524(var3) ? AuctionChatParser.method06525(var3) : var4.seller();
                  PurchaseHistory.Nested87 var6 = PurchaseHistory.field06969
                     .method03136(
                        var4.stack(),
                        AuctionChatParser.method06523(var3),
                        var4.priceCeiling(),
                        var4.marketPrice(),
                        var5,
                        AutoBuyItemRegistry.INSTANCE.method10998()
                     );
                  this.field20383.method02873("куплено: " + var6.name() + " за " + var6.paidPrice() + "$");
               }
            }
         }
      }
   }

   BotAutoBuyController(BotClient var1) {
      this.field20389 = field20390;
      this.field20382 = var1;
      this.field20383 = new AutoBuyBotExecutor(var1);
      this.field20384 = new AutoBuyPurchaseController(this.field20383, true, this.field20383::method02873);
   }

   private void method08962() {
      this.method08959();
      if (this.field20383.method02864()) {
         this.field20383.method02861();
      }

      this.field20389 = field20394;
   }
}
