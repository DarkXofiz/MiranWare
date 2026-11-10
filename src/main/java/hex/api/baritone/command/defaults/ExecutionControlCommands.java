// Original binary: hex/api/baritone/command/defaults/ExecutionControlCommands
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.process.IBaritoneProcess;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.process.PathingCommandType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

// $VF: Compiled from s
public class ExecutionControlCommands {
   Command pauseCommand;
   Command resumeCommand;
   Command pausedCommand;
   Command cancelCommand;
   private static final String field00035 = "field00035";
   private static final String field00036 = "field00036";
   private static final String field00037 = "field00037";
   private static final String field00038 = "field00038";
   private static final String field00039 = "field00039";
   private static final String field00040 = "field00040";
   private static final String field00041 = "field00041";
   private static final String field00042 = "field00042";
   private static final String field00043 = "field00043";
   private static final String field00044 = "field00044";
   private static final String field00045 = "field00045";


   public ExecutionControlCommands(final IBaritone var1) {
      final boolean[] var2 = new boolean[]{false};
      var1.getPathingControlManager().registerProcess(new IBaritoneProcess()      // $VF: Compiled from s
 {
         private static final String А61 = "А61";

         @Override
         public String displayName0() {
            return А61;
         }

         @Override
         public boolean isActive() {
            return var2[0];
         }

         @Override
         public void onLostControl() {
         }

         @Override
         public boolean isTemporary() {
            return true;
         }


         @Override
         public double priority() {
            return 0.0;
         }

         @Override
         public PathingCommand onTick(boolean var1x, boolean var2x) {
            var1.getInputOverrideHandler().clearAllKeys();
            return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
         }
      });
      this.pauseCommand = new Command(var1, new String[]{field00035, field00036, field00037})      // $VF: Compiled from s
 {
         private static final String ААо = "ААо";
         private static final String ААК = "ААК";
         private static final String ААЭ = "ААЭ";
         private static final String ААЪ = "ААЪ";
         private static final String ААЧ = "ААЧ";
         private static final String ААЩ = "ААЩ";
         private static final String ААм = "ААм";

         @Override
         public List<String> getLongDesc() {
            return Arrays.asList(ААЪ, "", ААЧ, "", ААЩ, ААм);
         }

         @Override
         public void execute(String var1, IArgConsumer var2x) throws CommandException {
            var2x.requireMax(0);
            if (var2[0]) {
               throw new CommandInvalidStateException(ААо);
            }

            var2[0] = true;
            this.logDirect(ААК);
         }

         @Override
         public String getShortDesc() {
            return ААЭ;
         }


         @Override
         public Stream<String> tabComplete(String var1, IArgConsumer var2x) {
            return Stream.empty();
         }
      };
      this.resumeCommand = new Command(var1, new String[]{field00038, field00039, field00040, field00041})      // $VF: Compiled from s
 {
         private static final String УЛ = "УЛ";
         private static final String Уь = "Уь";
         private static final String УЯ = "УЯ";
         private static final String УХ = "УХ";
         private static final String УШ = "УШ";
         private static final String Уа = "Уа";

         @Override
         public void execute(String var1, IArgConsumer var2x) throws CommandException {
            var2x.requireMax(0);
            this.baritone.getBuilderProcess().resume();
            if (!var2[0]) {
               throw new CommandInvalidStateException(УЛ);
            }

            var2[0] = false;
            this.logDirect(Уь);
         }

         @Override
         public Stream<String> tabComplete(String var1, IArgConsumer var2x) {
            return Stream.empty();
         }

         @Override
         public List<String> getLongDesc() {
            return Arrays.asList(УХ, "", УШ, Уа);
         }


         @Override
         public String getShortDesc() {
            return УЯ;
         }
      };
      this.pausedCommand = new Command(var1, new String[]{field00042})      // $VF: Compiled from s
 {
         private static final String 诶ЫБ = "诶ЫБ";
         private static final String 诶Ыв = "诶Ыв";
         private static final String 诶Ыр = "诶Ыр";
         private static final String 诶Ый = "诶Ый";
         private static final String 诶Ык = "诶Ык";
         private static final String 诶Ып = "诶Ып";

         @Override
         public Stream<String> tabComplete(String var1, IArgConsumer var2x) {
            return Stream.empty();
         }

         @Override
         public String getShortDesc() {
            return 诶Ыр;
         }


         @Override
         public List<String> getLongDesc() {
            return Arrays.asList(诶Ый, "", 诶Ык, 诶Ып);
         }

         @Override
         public void execute(String var1, IArgConsumer var2x) throws CommandException {
            var2x.requireMax(0);
            this.logDirect(String.format(诶ЫБ, var2[0] ? "" : 诶Ыв));
         }
      };
      this.cancelCommand = new Command(var1, new String[]{field00043, field00044, field00045})      // $VF: Compiled from s
 {
         private static final String АЬ西 = "АЬ西";
         private static final String АЬт = "АЬт";
         private static final String АЬд = "АЬд";
         private static final String АЬе = "АЬе";
         private static final String АЬ6 = "АЬ6";

         @Override
         public String getShortDesc() {
            return АЬт;
         }

         @Override
         public List<String> getLongDesc() {
            return Arrays.asList(АЬд, "", АЬе, АЬ6);
         }


         @Override
         public Stream<String> tabComplete(String var1, IArgConsumer var2x) {
            return Stream.empty();
         }

         @Override
         public void execute(String var1, IArgConsumer var2x) throws CommandException {
            var2x.requireMax(0);
            if (var2[0]) {
               var2[0] = false;
            }

            this.baritone.getPathingBehavior().cancelEverything();
            this.logDirect(АЬ西);
         }
      };
   }
}
