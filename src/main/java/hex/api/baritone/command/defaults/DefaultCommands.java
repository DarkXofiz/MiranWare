// Original binary: hex/api/baritone/command/defaults/DefaultCommands
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.ICommand;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

// $VF: Compiled from s
public final class DefaultCommands {
   private static final String б衣7 = "б衣7";
   private static final String б衣У = "б衣У";
   private static final String б衣0 = "б衣0";
   private static final String б衣Г = "б衣Г";
   private static final String б衣ф = "б衣ф";
   private static final String б衣Е = "б衣Е";
   private static final String б衣ч = "б衣ч";
   private static final String б衣衣 = "б衣衣";
   private static final String б衣ц = "б衣ц";
   private static final String б衣М = "б衣М";
   private static final String б衣5 = "б衣5";
   private static final String б衣Ж = "б衣Ж";
   private static final String б衣о = "б衣о";
   private static final String б衣К = "б衣К";
   private static final String б衣Э = "б衣Э";

   private DefaultCommands() {
   }

   public static List<ICommand> createAll(IBaritone var0) {
      Objects.requireNonNull(var0);
      List var1 = new ArrayList<>(
         Arrays.asList(
            new HelpCommand(var0),
            new SetCommand(var0),
            new CommandAlias(var0, Arrays.asList(б衣7, б衣У, б衣0, б衣Г), б衣ф, б衣Е),
            new CommandAlias(var0, б衣ч, б衣衣, б衣ц),
            new GoalCommand(var0),
            new GotoCommand(var0),
            new PathCommand(var0),
            new ProcCommand(var0),
            new ETACommand(var0),
            new VersionCommand(var0),
            new RepackCommand(var0),
            new BuildCommand(var0),
            new LitematicaCommand(var0),
            new ComeCommand(var0),
            new AxisCommand(var0),
            new ForceCancelCommand(var0),
            new GcCommand(var0),
            new InvertCommand(var0),
            new TunnelCommand(var0),
            new RenderCommand(var0),
            new FarmCommand(var0),
            new FollowCommand(var0),
            new PickupCommand(var0),
            new ExploreFilterCommand(var0),
            new ReloadAllCommand(var0),
            new SaveAllCommand(var0),
            new ExploreCommand(var0),
            new BlacklistCommand(var0),
            new FindCommand(var0),
            new MineCommand(var0),
            new ClickCommand(var0),
            new SurfaceCommand(var0),
            new ThisWayCommand(var0),
            new WaypointsCommand(var0),
            new CommandAlias(var0, б衣М, б衣5, б衣Ж),
            new CommandAlias(var0, б衣о, б衣К, б衣Э),
            new SelCommand(var0),
            new ElytraCommand(var0)
         )
      );
      ExecutionControlCommands sx = new ExecutionControlCommands(var0);
      var1.add(sx.pauseCommand);
      var1.add(sx.resumeCommand);
      var1.add(sx.pausedCommand);
      var1.add(sx.cancelCommand);
      return Collections.unmodifiableList(var1);
   }

}
