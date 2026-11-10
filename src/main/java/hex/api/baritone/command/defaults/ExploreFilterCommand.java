// Original binary: hex/api/baritone/command/defaults/ExploreFilterCommand
package hex.api.baritone.command.defaults;

import com.google.gson.JsonSyntaxException;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.RelativeFile;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.command.exception.CommandInvalidTypeException;
import java.io.File;
import java.nio.file.NoSuchFileException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class ExploreFilterCommand extends Command {
   private static final String АаЫ = "АаЫ";
   private static final String Ааз = "Ааз";
   private static final String АаР = "АаР";
   private static final String Аах = "Аах";
   private static final String АаЦ = "АаЦ";
   private static final String Аа9 = "Аа9";
   private static final String АаЮ = "АаЮ";
   private static final String АаO = "АаO";
   private static final String Аа弟 = "Аа弟";
   private static final String АаВ = "АаВ";
   private static final String Ааж = "Ааж";
   private static final String Аа8 = "Аа8";

   public ExploreFilterCommand(IBaritone var1) {
      super(var1, АаЫ);
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(АаO, "", Аа弟, "", АаВ, "", Ааж, Аа8);
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMax(2);
      File var3 = var2.getDatatypePost(RelativeFile.INSTANCE, this.ctx.minecraft().gameDirectory.getAbsoluteFile().getParentFile());
      boolean sx = false;
      if (var2.hasAny()) {
         if (!var2.getString().equalsIgnoreCase(Ааз)) {
            throw new CommandInvalidTypeException(var2.consumed(), АаР);
         }

         sx = true;
      }

      try {
         this.baritone.getExploreProcess().applyJsonFilter(var3.toPath().toAbsolutePath(), sx);
      } catch (NoSuchFileException sxx) {
         throw new CommandInvalidStateException(Аах);
      } catch (JsonSyntaxException sxx) {
         throw new CommandInvalidStateException(АаЦ);
      } catch (Exception sxx) {
         throw new IllegalStateException(sxx);
      }

      this.logDirect(String.format(Аа9, Boolean.toString(sx)));
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      return var2.hasExactlyOne() ? RelativeFile.tabComplete(var2, RelativeFile.gameDir(this.ctx.minecraft())) : Stream.empty();
   }


   @Override
   public String getShortDesc() {
      return АаЮ;
   }
}
