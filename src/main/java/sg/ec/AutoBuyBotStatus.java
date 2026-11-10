// Original binary: sg/ec/Mr1b0IYEUd9y8Hn9
package sg.ec;

// $VF: Compiled from s
public enum AutoBuyBotStatus {
   AFK("Афк"),
   WARDEN("Авто варден"),
   AUTOBUY("Авто скупка");

   private final String field10238;

   AutoBuyBotStatus(String var3) {
      this.field10238 = var3;
   }

   public AutoBuyBotStatus method04675() {
      return values()[(this.ordinal() + 1) % values().length];
   }

   public static AutoBuyBotStatus method04676(String var0) {
      for (AutoBuyBotStatus var4 : values()) {
         if (var4.name().equalsIgnoreCase(var0)) {
            return var4;
         }
      }

      return AFK;
   }

   public String method04677() {
      return this.field10238;
   }
}
