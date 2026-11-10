// Original binary: hex/api/baritone/api/command/datatypes/ForBlockOptionalMeta
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import hex.api.baritone.api.utils.BlockOptionalMeta;
import java.util.Set;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.Property;

// $VF: Compiled from s
public enum ForBlockOptionalMeta implements IDatatypeFor<BlockOptionalMeta> {
   INSTANCE;

   private static Pattern PATTERN = Pattern.compile(
      "(?:[a-z0-9_.-]+:)?(?:[a-z0-9/_.-]+(?:\\[(?:(?:[a-z0-9_.-]+=[a-z0-9_.-]+,)*(?:[a-z0-9_.-]+(?:=(?:[a-z0-9_.-]+(?:\\])?)?)?)?|\\])?)?)?"
   );

   public BlockOptionalMeta get(IDatatypeContext var1) throws CommandException {
      return new BlockOptionalMeta(var1.getConsumer().getString());
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) throws CommandException {
      String var2 = var1.getConsumer().peekString();
      if (!PATTERN.matcher(var2).matches()) {
         var1.getConsumer().getString();
         return Stream.empty();
      } else if (var2.endsWith("]")) {
         var1.getConsumer().getString();
         return Stream.empty();
      } else if (!var2.contains("[")) {
         return var1.getConsumer().tabCompleteDatatype(BlockById.INSTANCE);
      } else {
         var1.getConsumer().getString();
         String[] sx = splitLast(var2, '[');
         String sxx = sx[0];
         String sxxx = sx[1];
         Block sxxxx = BuiltInRegistries.BLOCK.getOptional(Identifier.parse(sxx)).orElse(null);
         if (sxxxx == null) {
            return Stream.empty();
         } else {
            String[] sxxxxx = splitLast(sxxx, ',');
            String sxxxxxx = sxxxxx[0];
            String sxxxxxxx = sxxxxx[1];
            if (!sxxxxxxx.contains("=")) {
               var sxxxxxxxx = Stream.of(sxxxxxx.split(",")).map(var0 -> var0.split("=")[0]).collect(Collectors.toSet());
               String sxxxxxxxxx = var2.substring(0, var2.length() - sxxxxxxx.length());
               return new TabCompleteHelper()
                  .append(sxxxx.getStateDefinition().getProperties().stream().map(Property::getName))
                  .filter(var1x -> !sxxxxxxxx.contains(var1x))
                  .filterPrefix(sxxxxxxx)
                  .sortAlphabetically()
                  .map(var1x -> sxxxxxxxxx + var1x)
                  .stream();
            } else {
               String[] sxxxxxxxx = splitLast(sxxxxxxx, '=');
               String sxxxxxxxxx = sxxxxxxxx[0];
               String sxxxxxxxxxx = sxxxxxxxx[1];
               String sxxxxxxxxxxx = var2.substring(0, var2.length() - sxxxxxxxxxx.length());
               var sxxxxxxxxxxxx = sxxxx.getStateDefinition().getProperty(sxxxxxxxxx);
               return sxxxxxxxxxxxx == null
                  ? Stream.empty()
                  : new TabCompleteHelper()
                     .append(getValues(sxxxxxxxxxxxx))
                     .filterPrefix(sxxxxxxxxxx)
                     .sortAlphabetically()
                     .map(var1x -> sxxxxxxxxxxx + var1x)
                     .stream();
            }
         }
      }
   }

   private static String[] splitLast(String var0, char var1) {
      int var2 = var0.lastIndexOf(var1);
      return var2 == -1 ? new String[]{"", var0} : new String[]{var0.substring(0, var2), var0.substring(var2 + 1)};
   }

   private static <T extends Comparable<T>> Stream<String> getValues(Property<T> var0) {
      return var0.getPossibleValues().stream().map(var0::getName);
   }
}
