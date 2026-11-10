// Original binary: sg/ec/XVWjZbtTIoWrHGgY
package sg.ec;

import java.util.Locale;

// $VF: Compiled from s
public enum AutoBuyServer {
   HOLY_WORLD("HolyWorld", "holyworld", AutoBuyServer.Nested187.CONFIRM_SCREEN, true, true),
   SPOOKY_TIME("SpookyTime", "spookytime", AutoBuyServer.Nested187.CONFIRM_SCREEN, true, true),
   FUN_TIME("FunTime", "funtime", AutoBuyServer.Nested187.QUICK_MOVE, true, true),
   REALLY_WORLD("ReallyWorld", "reallyworld", AutoBuyServer.Nested187.CONFIRM_SCREEN, false, false);

   private final String field14594;
   private final String field14595;
   private final AutoBuyServer.Nested187 field14596;
   private final boolean field14597;
   private final boolean field14598;

   AutoBuyServer(String var3, String var4, AutoBuyServer.Nested187 var5, boolean var6, boolean var7) {
      this.field14594 = var3;
      this.field14595 = var4;
      this.field14596 = var5;
      this.field14597 = var6;
      this.field14598 = var7;
   }

   public boolean method06428() {
      return this.field14596 == AutoBuyServer.Nested187.QUICK_MOVE;
   }

   public static AutoBuyServer method06429(String var0) {
      if (var0 != null && !var0.isBlank()) {
         String var1 = var0.toLowerCase(Locale.ROOT);

         for (AutoBuyServer var5 : values()) {
            if (var1.contains(var5.field14595)) {
               return var5;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public String method06430() {
      return this.field14594;
   }

   public String method06431() {
      return this.field14595;
   }

   public AutoBuyServer.Nested187 method06432() {
      return this.field14596;
   }

   public boolean method06433() {
      return this.field14597;
   }

   public boolean method06434() {
      return this.field14598;
   }

   // $VF: Compiled from s
   public enum Nested187 {
      CONFIRM_SCREEN,
      QUICK_MOVE;
   }
}
