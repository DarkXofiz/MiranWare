// Original binary: sg/ec/XOw48kcBmIPpkJQY
package sg.ec;

// $VF: Compiled from s
public final class ConfigMarketState {
   public static final ConfigMarketState field13926 = new ConfigMarketState();
   public static final String field13927 = "market#";
   public static final String field13928 = "field13928";
   private static final String field13929 = "field13929";
   private volatile boolean field13930;
   private volatile String field13931 = "";
   private static final String field13932 = "LOCK:";
   private static final String field13933 = "LOCK:";
   private static final String field13934 = "market#";

   public String method06276() {
      return this.field13931;
   }

   private ConfigMarketState() {
   }

   public boolean method06277() {
      return this.field13930;
   }

   public void method06278() {
      this.field13930 = false;
      this.field13931 = "";
   }

   public void method06279(String var1) {
      this.field13931 = var1 != null && !var1.equals(field13934) ? var1.trim() : "";
      this.field13930 = true;
   }

   public void method06280(String var1) {
      if (var1 != null && var1.startsWith(field13932)) {
         this.method06279(var1.substring(field13933.length()));
      } else {
         this.method06278();
      }
   }

   public boolean method06281(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         GlobalWebSocketClient var2 = MiranWare.getInstance().getClient();
         if (var2 == null) {
            return false;
         }

         for (StoredContentInfo var4 : var2.getManager().method01830()) {
            if (var4.category() == StorageCategory.CONFIG && var4.name().equalsIgnoreCase(var1)) {
               return var4.locked();
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public String method06282() {
      return this.field13930 && !this.field13931.isEmpty() ? this.field13931 : "";
   }

   public boolean method06283() {
      return this.field13930 || this.method06281(ActiveConfigTracker.field06857.method03060());
   }
}
