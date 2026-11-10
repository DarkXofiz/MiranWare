// Original binary: sg/ec/BLpm37Dp5Pgz1iLJ
package sg.ec;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public enum BotStatusManager {
   INSTANCE;

   private static final String field06253 = "—";
   private final Map<String, BotAutoBuyController> field06254 = new ConcurrentHashMap<>();
   private final BotAuctionPresenceTracker field06255 = new BotAuctionPresenceTracker();

   public void method02728(BotClient var1) {
      if (method02734(var1)) {
         this.method02733(var1).method08960(this.field06255.method02198(var1));
      }
   }

   public void method02729() {
      long var1 = System.currentTimeMillis();
      ArrayList<BotClient> var3 = new ArrayList<>();
      HashSet var4 = new HashSet();

      for (BotClient var6 : BotManager.INSTANCE.method03092()) {
         if (method02734(var6)) {
            var4.add(var6.method00137().method00497());
            if (var6.method00137().method00498() == AutoBuyBotRole.BUYER) {
               var3.add(var6);
            }
         }
      }

      var3.sort(Comparator.comparing(var0 -> var0.method00137().method00491()));
      this.field06255.method02196(var3, var1);
      var var7 = this.field06254.entrySet().iterator();

      while (var7.hasNext()) {
         Entry var8 = (Entry)var7.next();
         if (!var4.contains(var8.getKey())) {
            ((BotAutoBuyController)var8.getValue()).method08956();
            var7.remove();
         }
      }
   }

   public void method02730(BotClient var1, Component var2) {
      BotAutoBuyController var3 = this.field06254.get(var1.method00137().method00497());
      if (var3 != null) {
         var3.method08961(var2.getString());
      }
   }

   public void method02731(BotClient var1) {
      BotAutoBuyController var2 = this.field06254.remove(var1.method00137().method00497());
      if (var2 != null) {
         var2.method08956();
      }
   }

   public String method02732(BotClient var1) {
      BotAutoBuyController var2 = this.field06254.get(var1.method00137().method00497());
      return var2 == null ? "—" : var2.method08957();
   }

   private BotAutoBuyController method02733(BotClient var1) {
      return this.field06254.computeIfAbsent(var1.method00137().method00497(), var1x -> new BotAutoBuyController(var1));
   }

   private static boolean method02734(BotClient var0) {
      if (var0.method00137().method00475() != AutoBuyBotStatus.AUTOBUY) {
         return false;
      } else {
         return BotSessionManager.INSTANCE.method08733(var0)
            ? false
            : var0.method00146() == BotConnectionState.PLAYING && var0.method00090().method07688() != null && var0.method00090().method07636() != null;
      }
   }
}
