// Original binary: hex/api/baritone/command/defaults/BuildCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.RelativeBlockPos;
import hex.api.baritone.api.command.datatypes.RelativeFile;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.utils.schematic.SchematicSystem;
import java.io.File;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Stream;
import org.apache.commons.io.FilenameUtils;

// $VF: Compiled from s
public class BuildCommand extends Command {
   private final File schematicsDir;
   private static final String Фу = "Фу";
   private static final String Фг = "Фг";
   private static final String Фю = "Фю";
   private static final String Ф4 = "Ф4";
   private static final String ФС = "ФС";
   private static final String Фъ = "Фъ";
   private static final String ФБ = "ФБ";
   private static final String Фв = "Фв";
   private static final String Фр = "Фр";
   private static final String Фй = "Фй";
   private static final String Фк = "Фк";
   private static final String Фп = "Фп";

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      File var3 = var2.getDatatypePost(RelativeFile.INSTANCE, this.schematicsDir).getAbsoluteFile();
      File sx = var3;
      if (FilenameUtils.getExtension(sx.getAbsolutePath()).isEmpty()) {
         sx = new File(sx.getAbsolutePath() + "." + Baritone.settings().schematicFallbackExtension.value);
      }

      if (!sx.exists()) {
         if (var3.exists()) {
            throw new CommandInvalidStateException(String.format(Фю, sx));
         } else {
            throw new CommandInvalidStateException("Cannot find " + sx);
         }
      } else {
         if (!SchematicSystem.INSTANCE.getByFile(sx).isPresent()) {
            StringJoiner sxx = new StringJoiner(Ф4);
            SchematicSystem.INSTANCE.getFileExtensions().forEach(sxx::add);
            throw new CommandInvalidStateException(String.format(ФС, sxx));
         }

         BetterBlockPos sxx = this.ctx.playerFeet();
         BetterBlockPos sxxx;
         if (var2.hasAny()) {
            var2.requireMax(3);
            sxxx = var2.getDatatypePost(RelativeBlockPos.INSTANCE, sxx);
         } else {
            var2.requireMax(0);
            sxxx = sxx;
         }

         boolean sxxxx = this.baritone.getBuilderProcess().build(sx.getName(), sx, sxxx);
         if (!sxxxx) {
            throw new CommandInvalidStateException(Фъ);
         }

         this.logDirect(String.format(ФБ, sxxx));
      }
   }

   public BuildCommand(IBaritone var1) {
      super(var1, Фу);
      this.schematicsDir = new File(var1.getPlayerContext().minecraft().gameDirectory, Фг);
   }

   @Override
   public String getShortDesc() {
      return Фв;
   }


   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(Фр, "", Фй, Фк, Фп);
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      if (var2.hasExactlyOne()) {
         return RelativeFile.tabComplete(var2, this.schematicsDir);
      } else if (var2.has(2)) {
         var2.get();
         return var2.tabCompleteDatatype(RelativeBlockPos.INSTANCE);
      } else {
         return Stream.empty();
      }
   }
}
