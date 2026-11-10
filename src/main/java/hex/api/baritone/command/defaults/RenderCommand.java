// Original binary: hex/api/baritone/command/defaults/RenderCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class RenderCommand extends Command {
   private static final String АиЕ = "АиЕ";
   private static final String Аич = "Аич";
   private static final String Аи衣 = "Аи衣";
   private static final String Аиц = "Аиц";
   private static final String АиМ = "АиМ";
   private static final String Аи5 = "Аи5";

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(Аиц, "", АиМ, Аи5);
   }


   @Override
   public String getShortDesc() {
      return Аи衣;
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(0);
      BetterBlockPos var3 = this.ctx.playerFeet();
      int sx = (this.ctx.minecraft().options.renderDistance().get() + 1) * 16;
      this.ctx.minecraft().levelRenderer.allChanged();
      this.logDirect(Аич);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) {
      return Stream.empty();
   }

   public RenderCommand(IBaritone var1) {
      super(var1, АиЕ);
   }
}
