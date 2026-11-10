// Original binary: hex/api/baritone/api/command/datatypes/ForWaypoints
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.cache.IWaypoint;
import hex.api.baritone.api.cache.IWaypointCollection;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import java.util.Comparator;
import java.util.stream.Stream;

// $VF: Compiled from s
public enum ForWaypoints implements IDatatypeFor<IWaypoint[]> {
   INSTANCE;

   public IWaypoint[] get(IDatatypeContext var1) throws CommandException {
      String var2 = var1.getConsumer().getString();
      IWaypoint.Tag sx = IWaypoint.Tag.getByName(var2);
      return sx == null ? getWaypointsByName(var1.getBaritone(), var2) : getWaypointsByTag(var1.getBaritone(), sx);
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) throws CommandException {
      return new TabCompleteHelper()
         .append(getWaypointNames(var1.getBaritone()))
         .sortAlphabetically()
         .prepend(IWaypoint.Tag.getAllNames())
         .filterPrefix(var1.getConsumer().getString())
         .stream();
   }

   public static IWaypointCollection waypoints(IBaritone var0) {
      return var0.getWorldProvider().getCurrentWorld().getWaypoints();
   }

   public static IWaypoint[] getWaypoints(IBaritone var0) {
      return waypoints(var0).getAllWaypoints().stream().sorted(Comparator.comparingLong(IWaypoint::getCreationTimestamp).reversed()).toArray(IWaypoint[]::new);
   }

   public static String[] getWaypointNames(IBaritone var0) {
      return Stream.of(getWaypoints(var0)).map(IWaypoint::getName).filter(var0x -> !var0x.isEmpty()).toArray(String[]::new);
   }

   public static IWaypoint[] getWaypointsByTag(IBaritone var0, IWaypoint.Tag var1) {
      return waypoints(var0).getByTag(var1).stream().sorted(Comparator.comparingLong(IWaypoint::getCreationTimestamp).reversed()).toArray(IWaypoint[]::new);
   }

   public static IWaypoint[] getWaypointsByName(IBaritone var0, String var1) {
      return Stream.of(getWaypoints(var0)).filter(var1x -> var1x.getName().equalsIgnoreCase(var1)).toArray(IWaypoint[]::new);
   }
}
