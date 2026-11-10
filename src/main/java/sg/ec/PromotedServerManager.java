// Original binary: sg/ec/BYgWPxhZd15Tw6q5
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerData.Type;

// $VF: Compiled from s
public enum PromotedServerManager {
   INSTANCE;

   private final Map<String, ServerData> field06533 = new HashMap<>();
   private volatile List<ServerData> field06534 = List.of();
   private volatile long field06535 = Long.MAX_VALUE;
   private List<PromotedServer> field06536 = List.of();

   public synchronized void method02791(List<PromotedServer> var1) {
      this.field06536 = var1 == null ? List.of() : List.copyOf(var1);
      this.field06533.clear();
      this.method02795();
   }

   public List<ServerData> method02792() {
      if (System.currentTimeMillis() >= this.field06535) {
         this.method02794();
      }

      return this.field06534;
   }

   public static boolean method02793(ServerData var0) {
      return var0 instanceof PromotedServerAccess var1 && var1.hex$promotedColor() != 0;
   }

   private synchronized void method02794() {
      if (System.currentTimeMillis() >= this.field06535) {
         this.method02795();
      }
   }

   private void method02795() {
      long var1 = System.currentTimeMillis();
      long var3 = Long.MAX_VALUE;
      var var5 = new ArrayList(this.field06536.size());

      for (PromotedServer var7 : this.field06536) {
         if (var7.expiresAt() > 0L) {
            if (var7.expiresAt() <= var1) {
               continue;
            }

            var3 = Math.min(var3, var7.expiresAt());
         }

         var5.add(this.field06533.computeIfAbsent(var7.field20793(), var1x -> method02796(var7)));
      }

      this.field06534 = List.copyOf(var5);
      this.field06535 = var3;
   }

   private static ServerData method02796(PromotedServer var0) {
      ServerData var1 = new ServerData(var0.name(), var0.field20793(), Type.OTHER);
      ((PromotedServerAccess)var1).hex$promotedColor(var0.color());
      return var1;
   }
}
