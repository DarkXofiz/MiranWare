// Original binary: sg/ec/p7OIstXS33TIvUdF
package sg.ec;

import java.util.HashMap;
import java.util.LinkedHashSet;

// $VF: Compiled from s
public abstract class AbstractGlobalPacketHandler implements GlobalPacketHandler {
   private static final int field22673 = 3;
   private final GlobalWebSocketClient field22674;
   private static final String field22675 = "friends";
   private static final String field22676 = "pending";

   public void method04356(VoiceS2CPacket var1) {
   }

   private void method10036(GlobalPlayer var1, float var2, float var3, float var4) {
      var1.method07611(var2, var3, var4, 3);
   }

   public abstract void method04362(ServerMessageS2CPacket var1);

   public void method10037(NeuroRotationS2CPacket var1) {
      if (var1 != null) {
         CloudRotationRegistry.INSTANCE.method08496(var1.method10887(), var1.method10881(), var1.method10884(), var1.method10886(), var1.method10883());
      }
   }

   public void method10038(SaleKeyListS2CPacket var1) {
      if (var1 != null && var1.method05366() != null) {
         if (var1.method05366().method07566(this.field22674.getClientPlayer())) {
            this.field22674.getManager().method01821(var1);
         }
      }
   }

   public void method04357(CloudDataS2CPacket var1) {
      if (var1 != null && var1.method03837() != null) {
         if (var1.method03837().method07566(this.field22674.getClientPlayer())) {
            if (var1.method03841() && var1.method03843().length > 0) {
               StoredContentImporter.method07240(StorageCategory.method00554(var1.method03839()), var1.method03838(), var1.method03843());
            }
         }
      }
   }

   public void method10039(PromotedServersS2CPacket var1) {
      if (var1 != null && var1.method06897() != null) {
         if (var1.method06897().method07566(this.field22674.getClientPlayer())) {
            PromotedServerManager.INSTANCE.method02791(var1.method06899());
         }
      }
   }

   public void method10040(SaleListS2CPacket var1) {
      if (var1 != null && var1.method04098() != null) {
         if (var1.method04098().method07566(this.field22674.getClientPlayer())) {
            this.field22674.getManager().method01875(var1.method04095());
         }
      }
   }

   public void method10041(CloudKeysS2CPacket var1) {
      if (var1 != null && var1.method03458() != null) {
         if (var1.method03458().method07566(this.field22674.getClientPlayer())) {
            this.field22674.getManager().method01791(var1.method03459());
         }
      }
   }

   public void method10042(CloudProfileS2CPacket var1) {
      if (var1 != null && var1.method00905() != null) {
         if (var1.method00905().method07566(this.field22674.getClientPlayer())) {
            if (!GlobalConnectionManager.method03845()) {
               StoredContentImporter.method07242(var1.method00904());
               GlobalConnectionManager.method03850();
            }
         }
      }
   }

   public void method10043(PrefixListS2CPacket var1) {
      if (var1 != null && var1.method05387() != null) {
         if (var1.method05387().method07566(this.field22674.getClientPlayer())) {
            this.field22674.getManager().method01822(var1.method05386());
            this.field22674.getManager().method01816(var1.method05389());
         }
      }
   }

   public AbstractGlobalPacketHandler(GlobalWebSocketClient var1) {
      this.field22674 = var1;
   }

   public void method10044(ForumAuthS2CPacket var1) {
      if (var1 != null && var1.method04434() != null) {
         if (var1.method04434().method07566(this.field22674.getClientPlayer())) {
            ConfigSharePromptManager.INSTANCE
               .method02651(new ConfigSharePromptManager.Nested72(var1.method04432(), var1.method04429(), var1.method04431(), var1.method04435(), var1.method04436()));
         }
      }
   }

   public void method10045(GlobalsPongS2CPacket var1) {
      if (var1 != null) {
         String var2 = var1.method10850();
         if (var2 == null || var2.isEmpty() || var2.equalsIgnoreCase(this.field22674.getClientPlayer().method07590())) {
            this.field22674.getManager().method01868(var1.method10853(), var1.method10852());
         }
      }
   }

   public void method10046(SocialS2CPacket var1) {
      if (var1 != null && var1.method02144() != null) {
         if (var1.method02144().method07566(this.field22674.getClientPlayer())) {
            if (field22675.equals(var1.method02145())) {
               this.field22674.getManager().method01878(var1.method02141());
            } else if (field22676.equals(var1.method02145())) {
               OfflineAccountUtils.field07854.method03524(var1.method02140(), var1.method02150());
            } else {
               SocialNotificationSounds.method05507(var1.method02148(), var1.method02143(), var1.method02138(), var1.method02139());
            }
         }
      }
   }

   public GlobalWebSocketClient method10047() {
      return this.field22674;
   }

   public abstract void method04354(ChatS2CPacket var1);

   public void method04361(PartyCreateS2CPacket var1) {
      if (var1.method08681().method07566(this.field22674.getClientPlayer())) {
         this.method10036(
            this.field22674.getClientPlayer(),
            var1.method08681().method07582().field03984,
            var1.method08681().method07582().field03985,
            var1.method08681().method07582().field03986
         );
         Party var2 = var1.method08683();
         if (var2 == null) {
            this.field22674.getManager().method01785(null);
         } else {
            Party var3 = this.field22674.getManager().method01805();
            HashMap var4 = new HashMap();
            if (var3 != null) {
               for (PartyMember var6 : var3.method10148()) {
                  var4.put(var6.method07590(), var6);
               }
            }

            LinkedHashSet var10 = new LinkedHashSet();

            for (PartyMember var7 : var2.method10148()) {
               PartyMember var8 = (PartyMember)var4.get(var7.method07590());
               PartyMember var9 = var8 != null && var8.method05943() == var7.method05943() ? var8 : var7;
               if (var9 == var8) {
                  var8.method07568(var7.method07586());
                  var8.method07567(var7.method07580());
                  var8.method07577(var7.method07584());
               }

               this.method10036(var9, var7.method07582().field03984, var7.method07582().field03985, var7.method07582().field03986);
               var10.add(var9);
            }

            var2.method10148().clear();
            var2.method10148().addAll(var10);
            this.field22674.getManager().method01785(var2);
         }
      }
   }

   public void method10048(MarketListS2CPacket var1) {
      if (var1 != null && var1.method11660() != null) {
         if (var1.method11660().method07566(this.field22674.getClientPlayer())) {
            this.field22674.getManager().method01786(var1.method11662());
         }
      }
   }

   public void method10049(SaleKeysS2CPacket var1) {
      if (var1 != null && var1.method07621() != null) {
         if (var1.method07621().method07566(this.field22674.getClientPlayer())) {
            ConfigMarketManager.method04673(var1.method07626(), var1.method07622());
         }
      }
   }

   public void method10050(PartyTeleportS2CPacket var1) {
   }

   public void method10051(FunTimeDataS2CPacket var1) {
      if (var1 != null) {
         GlobalConnectionManager.method03846(var1.method02503(), var1.method02502());
      }
   }

   public abstract void method04363(WaypointSendS2CPacket var1);

   @Deprecated
   public void method10052(NeuroConfigS2CPacket var1) {
      if (var1 != null) {
         OnnxRotationSettingsCodec.field12508.method05881(var1.method02136());
      }
   }

   public void method10053(CloudListS2CPacket var1) {
      if (var1 != null && var1.method06529() != null) {
         if (var1.method06529().method07566(this.field22674.getClientPlayer())) {
            if (var1.method06530()) {
               this.field22674.getManager().method01840(var1.method06528());
            } else {
               this.field22674.getManager().method01852(var1.method06528());
            }
         }
      }
   }

   public void method04358(ClientCommandS2CPacket var1) {
   }
}
