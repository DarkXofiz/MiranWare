// Original binary: hex/api/baritone/command/defaults/BlacklistCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.process.IGetToBlockProcess;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class BlacklistCommand extends Command {
   private static final String _р = "_р";
   private static final String _й = "_й";
   private static final String _к = "_к";
   private static final String _п = "_п";
   private static final String _2 = "_2";
   private static final String _西 = "_西";
   private static final String _т = "_т";
   private static final String _д = "_д";

   public BlacklistCommand(IBaritone var1) {
      super(var1, _р);
   }


   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(_西, "", _т, _д);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      IGetToBlockProcess var3 = this.baritone.getGetToBlockProcess();
      if (!var3.isActive()) {
         throw new CommandInvalidStateException(_й);
      }

      if (var3.blacklistClosest()) {
         this.logDirect(_к);
      } else {
         throw new CommandInvalidStateException(_п);
      }
   }

   @Override
   public String getShortDesc() {
      return _2;
   }
}
