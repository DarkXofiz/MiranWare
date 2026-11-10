// Original binary: hex/dscRPC/exception/JDiscordIPCBuilderException
package hex.dscRPC.exception;


// $VF: Compiled from s
public class JDiscordIPCBuilderException extends RuntimeException {
   private JDiscordIPCBuilderException(String var1, Throwable var2) {
      super(var1, var2);
   }

   // $VF: Compiled from s
   public static class MissingSystemSocketFactoryException extends JDiscordIPCBuilderException {
      private static final String Акр = "Акр";

      public MissingSystemSocketFactoryException() {
         super(Акр, null);
      }

   }
}
