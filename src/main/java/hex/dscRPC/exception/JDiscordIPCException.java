// Original binary: hex/dscRPC/exception/JDiscordIPCException
package hex.dscRPC.exception;


// $VF: Compiled from s
public class JDiscordIPCException extends Exception {
   private JDiscordIPCException(String var1, Throwable var2) {
      super(var1, var2);
   }

   // $VF: Compiled from s
   public static class DiscordClientUnavailableException extends JDiscordIPCException {
      private static final String field00065 = "field00065";

      public DiscordClientUnavailableException(Throwable var1) {
         super(field00065, var1);
      }

   }
}
