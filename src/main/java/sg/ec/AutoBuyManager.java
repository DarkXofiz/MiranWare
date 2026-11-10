// Original binary: sg/ec/oEsU2XxmvSi68HDq
package sg.ec;

import net.minecraft.network.protocol.game.ClientboundSetTimePacket;
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket;
import net.minecraft.network.protocol.game.ServerboundChatCommandPacket;
import net.minecraft.network.protocol.game.ServerboundCommandSuggestionPacket;

// $VF: Compiled from s
public enum AutoBuyManager implements MinecraftAccess {
   INSTANCE;

   private static final long field22076 = 5000L;
   private final ConfirmScreenAuctionScanner field22077 = new ConfirmScreenAuctionScanner(AutoBuyLocalExecutor.field06677);
   private final QuickMoveAuctionScanner field22078 = new QuickMoveAuctionScanner(AutoBuyLocalExecutor.field06677);
   private final AutoBuyPotionController field22079 = new AutoBuyPotionController();
   private final AutoBuyRefreshController field22080 = new AutoBuyRefreshController();
   private final AutoBuyConfirmController field22081 = new AutoBuyConfirmController();
   private final AutoBuySellController field22082 = new AutoBuySellController();
   private final AutoBuyAuctionRefresh field22083 = new AutoBuyAuctionRefresh();
   private final AutoBuyPurchaseController field22084 = new AutoBuyPurchaseController(AutoBuyLocalExecutor.field06677, false, AutoBuySessionHistory.field27854::method11708);
   private final AutoBuyInputController field22085 = new AutoBuyInputController(this.field22084);
   private final AuctionSellingController field22086 = new AuctionSellingController();
   private boolean field22087;
   private long field22088;
   private long field22089;
   private long field22090;
   private long field22091;
   private AbstractAuctionScanner field22092;
   private boolean field22093;

   public void method09756() {
      if (!this.field22093) {
         this.field22093 = true;
         EventBus.method00263(this);
         AutoBuyLogRenderer.field08878.method04050();
         EventBus.method00263(this.field22085);
         AutoBuyItemRegistry.INSTANCE.method10986(AutoBuyCleanup::method08813, () -> CustomResourceManager.INSTANCE.method02464("AutoBuy"));
      }
   }

   public void method09757(boolean var1) {
      AutoBuySettings.field19624.method08581(var1);
      if (!var1) {
         this.field22084.method09142();
      }

      AutoBuyItemRegistry.INSTANCE.method10994();
   }

   public void method09758(boolean var1) {
      AutoBuySettings.field19624.method08584(var1);
      AutoBuyItemRegistry.INSTANCE.method10994();
   }

   public boolean method09759() {
      return this.field22087 || this.field22084.method09139() || this.field22086.method05008() || this.field22086.method05013() > 0;
   }

   public void method09760(boolean var1) {
      if (this.field22087 != var1) {
         this.field22087 = var1;
         method09762(var1);
         if (var1) {
            this.field22088 = System.currentTimeMillis();
            this.field22091 = this.field22088 + AutoBuySettings.field19624.method08540();
         } else {
            this.field22089 = this.field22089 + this.method09765();
            this.field22088 = 0L;
            this.method09769();
            this.field22079.method05112();
            this.field22080.method09388();
            this.field22081.method10055();
            this.field22086.method04993();
            PurchaseHistory.field06969.method03146();
         }
      }
   }

   public boolean method09761() {
      this.method09760(!this.field22087);
      return this.field22087;
   }

   private static void method09762(boolean var0) {
      AutoBuy var1 = ModuleManager.INSTANCE.method05142(AutoBuy.class);
      if (var1 != null) {
         var1.method03939(var0);
      }
   }

   public void method09763(AutoBuyServer var1) {
      if (var1 != AutoBuyItemRegistry.INSTANCE.method10998()) {
         this.method09769();
         this.field22084.method09142();
         this.field22079.method05112();
         AutoBuyItemRegistry.INSTANCE.method10989(var1);
      }
   }

   public long method09764() {
      return this.field22089 + this.method09765();
   }

   private long method09765() {
      return this.field22088 == 0L ? 0L : System.currentTimeMillis() - this.field22088;
   }

   @Subscribe
   private void method09766(TickEvent var1) {
      long var2 = System.currentTimeMillis();
      this.method09771(var2);
      if (mc.player != null && mc.level != null && mc.player.connection != null) {
         AuctionCommandSender.field08741.method03895(var2);
         if (!AuctionCommandSender.field08741.method03892()) {
            this.field22081.method10057(var2);
            this.field22079.method05126(var2);
            if (this.field22079.method05125()) {
               this.method09769();
            } else {
               this.field22080.method09386(var2);
               if (this.field22080.method09387()) {
                  this.method09769();
               } else {
                  if (AutoBuySettings.field19624.method08579() && !this.field22084.method09139()) {
                     AutoBuySessionHistory.field27854.method11709(var2);
                     if (!this.field22084.method09149()) {
                        this.method09757(false);
                     }
                  }

                  this.field22084.method09143(var2);
                  if (this.field22084.method09132()) {
                     this.method09769();
                  } else {
                     this.field22086.method04992(var2);
                     if (this.field22086.method05008()) {
                        this.method09769();
                     } else {
                        this.field22082.method11018(var2);
                        if (this.field22082.method11017()) {
                           this.method09769();
                        } else if (!this.field22087) {
                           this.method09769();
                           this.field22083.method09553();
                        } else {
                           this.method09770(var2);
                           if (!AutoBuySettings.field19624.method08569() || this.field22083.method09552(var2)) {
                              this.method09768(AutoBuyItemRegistry.INSTANCE.method10998()).method04339(var2);
                           }
                        }
                     }
                  }
               }
            }
         }
      } else {
         AuctionCommandSender.field08741.method03889();
         this.method09769();
         this.field22079.method05112();
         this.field22080.method09388();
         this.field22081.method10055();
         this.field22082.method11012();
         this.field22086.method04993();
         this.field22083.method09556();
      }
   }

   @Subscribe
   private void method09767(PacketEvent var1) {
      if (!var1.method10904()) {
         method09772(var1);
      } else if (var1.method10897() instanceof ClientboundSetTimePacket var4) {
         this.field22083.method09555(var4);
      } else {
         if (var1.method10897() instanceof ClientboundSystemChatPacket var2 && var2.content() != null) {
            this.method09773(var2.content().getString());
         }
      }
   }

   private AbstractAuctionScanner method09768(AutoBuyServer var1) {
      AbstractAuctionScanner var2 = var1.method06428() ? this.field22078 : this.field22077;
      if (this.field22092 != var2) {
         this.method09769();
         this.field22092 = var2;
      }

      return var2;
   }

   private void method09769() {
      if (this.field22092 != null) {
         this.field22092.method04343();
         this.field22092 = null;
      }
   }

   private void method09770(long var1) {
      AutoBuySettings var3 = AutoBuySettings.field19624;
      if (!var3.method08536()) {
         this.field22091 = var1 + var3.method08540();
      } else if (var1 >= this.field22091) {
         AuctionCommandSender.field08741.method03893(var3.method08544());
         this.field22091 = var1 + var3.method08540();
      }
   }

   private void method09771(long var1) {
      if (var1 >= this.field22090) {
         this.field22090 = var1 + 5000L;
         if (AutoBuyItemRegistry.INSTANCE.method10995()) {
            CustomResourceManager.INSTANCE.method02462();
         }
      }
   }

   private static void method09772(PacketEvent var0) {
      if (AutoBuySessionHistory.field27854.method11705()) {
         if (var0.method10897() instanceof ServerboundCommandSuggestionPacket var3) {
            AutoBuySessionHistory.field27854.method11708("  → подсказка: \"" + var3.command() + "\"");
         } else {
            if (var0.method10897() instanceof ServerboundChatCommandPacket var1) {
               AutoBuySessionHistory.field27854.method11708("  → команда: /" + var1.command());
            }
         }
      }
   }

   private void method09773(String var1) {
      if (var1 != null && !var1.isBlank()) {
         String var2 = ItemTooltipUtils.method02659(var1).trim();
         this.field22084.method09153(var2);
         this.field22086.method05002(var2);
         this.field22082.method11010(var2);
         AuctionSaleHistory.field07563.method03354(AuctionSaleParser.method04756(var2));
         if (PurchaseHistory.field06969.method03137()) {
            if (AuctionChatParser.method06526(var2)) {
               PurchaseHistory.field06969.method03146();
            } else if (AuctionChatParser.method06527(var2)) {
               PurchaseHistory.Nested87 var3 = PurchaseHistory.field06969
                  .method03140(AuctionChatParser.method06523(var2), AuctionChatParser.method06525(var2));
               if (var3 != null) {
                  ChatTextUtils.method05101("AutoBuy", "Куплено: " + var3.name() + " за " + var3.paidPrice() + "$.");
                  AutoBuyItemMatcher.method11547(AutoBuyItemRegistry.INSTANCE.method10998(), var3.stack())
                     .ifPresent(var2x -> this.field22086.method05010(var2x, var3.paidPrice()));
               }
            }
         }
      }
   }

   public AutoBuyPurchaseController method09774() {
      return this.field22084;
   }

   public AuctionSellingController method09775() {
      return this.field22086;
   }

   public boolean method09776() {
      return this.field22087;
   }

   public long method09777() {
      return this.field22088;
   }
}
