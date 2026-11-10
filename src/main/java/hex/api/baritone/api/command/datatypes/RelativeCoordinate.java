// Original binary: hex/api/baritone/api/command/datatypes/RelativeCoordinate
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

// $VF: Compiled from s
public enum RelativeCoordinate implements IDatatypePost<Double, Double> {
   INSTANCE;

   private static String ScalesAliasRegex = "[kKmM]";
   private static Pattern PATTERN = Pattern.compile("^(~?)([+-]?(?:\\d+(?:\\.\\d*)?|\\.\\d+)(" + ScalesAliasRegex + "?)|)$");

   public Double apply(IDatatypeContext var1, Double var2) throws CommandException {
      if (var2 == null) {
         var2 = 0.0;
      }

      Matcher var3 = PATTERN.matcher(var1.getConsumer().getString());
      if (!var3.matches()) {
         throw new IllegalArgumentException("pattern doesn't match");
      }

      boolean sx = !var3.group(1).isEmpty();
      double sxx = var3.group(2).isEmpty() ? 0.0 : Double.parseDouble(var3.group(2).replaceAll(ScalesAliasRegex, ""));
      if (var3.group(2).toLowerCase().contains("k")) {
         sxx *= 1000.0;
      }

      if (var3.group(2).toLowerCase().contains("m")) {
         sxx *= 1000000.0;
      }

      return sx ? var2 + sxx : sxx;
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) throws CommandException {
      IArgConsumer var2 = var1.getConsumer();
      return !var2.has(2) && var2.getString().matches("^(~|$)") ? Stream.of("~") : Stream.empty();
   }
}
