// Original binary: sg/ec/9GueyPcFkEy7T6WZ
package sg.ec;

// $VF: Compiled from s
public enum ChatChannel {
   PERSONAL,
   PARTY,
   GLOBAL,
   IRC;

   public static ChatChannel method02177(String var0) {
      if (var0 == null) {
         return GLOBAL;
      }

      try {
         return valueOf(var0.trim().toUpperCase());
      } catch (IllegalArgumentException var2) {
         return GLOBAL;
      }
   }
}
