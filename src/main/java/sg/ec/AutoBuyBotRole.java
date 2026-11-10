// Original binary: sg/ec/MiAIZ9B7EWooDIkl
package sg.ec;

// $VF: Compiled from s
public enum AutoBuyBotRole {
   BUYER("Скупщик"),
   SCOUT("Разведчик");

   private final String field10213;

   AutoBuyBotRole(String var3) {
      this.field10213 = var3;
   }

   public static AutoBuyBotRole method04641(String var0) {
      for (AutoBuyBotRole var4 : values()) {
         if (var4.name().equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return BUYER;
   }

   public String method04642() {
      return this.field10213;
   }
}
