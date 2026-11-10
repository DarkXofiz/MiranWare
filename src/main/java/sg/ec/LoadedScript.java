// Original binary: sg/ec/FQecYq1VzdsrWn6R
package sg.ec;

import hex.script.api.Script;

// $VF: Compiled from s
public final class LoadedScript {
   private final Script field07583;
   private final String field07584;
   private final boolean field07585;
   private boolean field07586;
   private boolean field07587;
   private ScriptModule field07588;
   private static final String field07589 = "unnamed";
   private static final String field07590 = "unnamed";

   public boolean method03391() {
      return this.field07587;
   }

   public boolean method03392() {
      return this.field07586;
   }

   public Script method03393() {
      return this.field07583;
   }

   void method03394() {
      this.field07587 = true;
      this.field07586 = false;
   }

   private static String method03395(Script var0) {
      try {
         String var1 = var0.name();
         return var1 != null && !var1.isEmpty() ? var1 : field07589;
      } catch (Throwable var2) {
         return field07590;
      }
   }

   public boolean method03396() {
      return this.field07585;
   }

   void method03397(boolean var1) {
      this.field07586 = var1;
   }

   public ScriptModule method03398() {
      return this.field07588;
   }

   void method03399(ScriptModule var1) {
      this.field07588 = var1;
   }

   public String method03400() {
      return this.field07584;
   }

   LoadedScript(Script var1, boolean var2) {
      this.field07583 = var1;
      this.field07585 = var2;
      this.field07584 = method03395(var1);
   }
}
