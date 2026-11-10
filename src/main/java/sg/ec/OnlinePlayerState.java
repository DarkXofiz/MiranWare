// Original binary: sg/ec/kurZT84s5JogkBmO
package sg.ec;

import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public enum OnlinePlayerState {
   INSTANCE;

   public static final String field21127 = "staffList";
   public static final String field21128 = "field21128";
   public static final String field21129 = "field21129";
   private static final String field21130 = TextRenderUtils.method00672("ЖУКИ В ТЕЛЕФОНЕ");
   private volatile boolean field21131;
   private volatile boolean field21132;
   private volatile String field21133 = "";

   public void method09289(Component var1, String var2) {
      if (!this.field21131 && var1 != null) {
         this.method09290(var1.getString(), var2);
      }
   }

   public void method09290(String var1, String var2) {
      if (!this.field21131 && var1 != null && !var1.isEmpty()) {
         if (TextRenderUtils.method00672(var1).contains(field21130)) {
            this.field21133 = var2;
            this.field21131 = true;
            this.field21132 = true;
            this.method09291();
         }
      }
   }

   public void method09291() {
      if (this.field21132) {
         GlobalWebSocketClient var1 = MiranWare.getInstance().getClient();
         if (var1 != null) {
            var1.getManager().method01814(this.field21133);
            this.field21132 = false;
         }
      }
   }

   public boolean method09292() {
      return this.field21131;
   }
}
