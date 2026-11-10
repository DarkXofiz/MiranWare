// Original binary: sg/ec/C3GLHcMIe8fUpB8A
package sg.ec;

// $VF: Compiled from s
public enum ScriptSourceType {
   CODE("java/"),
   MIXIN("mixin/");

   private final String field06657;

   ScriptSourceType(String var3) {
      this.field06657 = var3;
   }

   public String method02856() {
      return this.field06657;
   }

   public static ScriptSourceType method02857(String var0) {
      for (ScriptSourceType var4 : values()) {
         if (var0.startsWith(var4.field06657)) {
            return var4;
         }
      }

      return null;
   }
}
