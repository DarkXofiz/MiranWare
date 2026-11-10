// Original binary: hex/api/baritone/command/manager/CommandManager
package hex.api.baritone.command.manager;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.ICommand;
import hex.api.baritone.api.command.argument.ICommandArgument;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandUnhandledException;
import hex.api.baritone.api.command.exception.ICommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import hex.api.baritone.api.command.manager.ICommandManager;
import hex.api.baritone.api.command.registry.Registry;
import hex.api.baritone.api.utils.Tuple;
import hex.api.baritone.command.argument.ArgConsumer;
import hex.api.baritone.command.argument.CommandArguments;
import hex.api.baritone.command.defaults.DefaultCommands;
import java.util.List;
import java.util.Locale;
import java.util.stream.Stream;

// $VF: Compiled from s
public class CommandManager implements ICommandManager {
   private final Registry<ICommand> registry = new Registry<>();
   private final Baritone baritone;
   private static final String бКА = "бКА";


   @Override
   public ICommand getCommand(String var1) {
      for (ICommand var3 : this.registry.entries) {
         if (var3.getNames().contains(var1.toLowerCase(Locale.US))) {
            return var3;
         }
      }

      return null;
   }

   private CommandManager.ExecutionWrapper from(Tuple<String, List<ICommandArgument>> var1) {
      String var2 = var1.getA();
      ArgConsumer sx = new ArgConsumer(this, var1.getB());
      ICommand sxx = this.getCommand(var2);
      return sxx == null ? null : new CommandManager.ExecutionWrapper(sxx, var2, sx);
   }

   private static Tuple<String, List<ICommandArgument>> expand(String var0, boolean var1) {
      String var2 = var0.split(бКА, 2)[0];
      var sx = CommandArguments.from(var0.substring(var2.length()), var1);
      return new Tuple<>(var2, sx);
   }

   @Override
   public boolean execute(Tuple<String, List<ICommandArgument>> var1) {
      CommandManager.ExecutionWrapper var2 = this.from(var1);
      if (var2 != null) {
         var2.execute();
      }

      return var2 != null;
   }

   public CommandManager(Baritone var1) {
      this.baritone = var1;
      DefaultCommands.createAll(var1).forEach(this.registry::register);
   }

   public static Tuple<String, List<ICommandArgument>> expand(String var0) {
      return expand(var0, false);
   }

   @Override
   public Stream<String> tabComplete(String var1) {
      var var2 = expand(var1, true);
      String sx = var2.getA();
      var sxx = var2.getB();
      return sxx.isEmpty() ? new TabCompleteHelper().addCommands(this.baritone.getCommandManager()).filterPrefix(sx).stream() : this.tabComplete(var2);
   }

   @Override
   public Stream<String> tabComplete(Tuple<String, List<ICommandArgument>> var1) {
      CommandManager.ExecutionWrapper var2 = this.from(var1);
      return var2 == null ? Stream.empty() : var2.tabComplete();
   }

   @Override
   public IBaritone getBaritone() {
      return this.baritone;
   }

   @Override
   public boolean execute(String var1) {
      return this.execute(expand(var1));
   }

   @Override
   public Registry<ICommand> getRegistry() {
      return this.registry;
   }

   // $VF: Compiled from s
   private static final class ExecutionWrapper {
      private ICommand command;
      private String label;
      private ArgConsumer args;

      private Stream<String> tabComplete() {
         try {
            return this.command.tabComplete(this.label, this.args);
         } catch (CommandException var2) {
         } catch (Throwable var3) {
         }

         return Stream.empty();
      }

      private void execute() {
         try {
            this.command.execute(this.label, this.args);
         } catch (Throwable var3) {
            ICommandException sx = var3 instanceof ICommandException ? (ICommandException)var3 : new CommandUnhandledException(var3);
            sx.handle(this.command, this.args.getArgs());
         }
      }

      private ExecutionWrapper(ICommand var1, String var2, ArgConsumer var3) {
         this.command = var1;
         this.label = var2;
         this.args = var3;
      }
   }
}
