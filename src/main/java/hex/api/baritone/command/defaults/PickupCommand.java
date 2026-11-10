// Original binary: hex/api/baritone/command/defaults/PickupCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.ItemById;
import hex.api.baritone.api.command.exception.CommandException;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Stream;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

// $VF: Compiled from s
public class PickupCommand extends Command {
   private static final String ФУ = "ФУ";
   private static final String Ф0 = "Ф0";
   private static final String ФГ = "ФГ";
   private static final String Фф = "Фф";
   private static final String ФЕ = "ФЕ";
   private static final String Фч = "Фч";
   private static final String Ф衣 = "Ф衣";


   @Override
   public String getShortDesc() {
      return Фф;
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      Set<Item> var3 = new HashSet<>();

      while (var2.hasAny()) {
         Item sx = var2.getDatatypeFor(ItemById.INSTANCE);
         var3.add(sx);
      }

      if (var3.isEmpty()) {
         this.baritone.getFollowProcess().pickup(var0 -> true);
         this.logDirect(Ф0);
      } else {
         this.baritone.getFollowProcess().pickup(var1x -> var3.contains(var1x.getItem()));
         this.logDirect(ФГ);
         var3.stream().map(BuiltInRegistries.ITEM::getKey).map(Identifier::toString).forEach(this::logDirect);
      }
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      while (var2.has(2)) {
         if (var2.peekDatatypeOrNull(ItemById.INSTANCE) == null) {
            return Stream.empty();
         }

         var2.get();
      }

      return var2.tabCompleteDatatype(ItemById.INSTANCE);
   }

   public PickupCommand(IBaritone var1) {
      super(var1, ФУ);
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(ФЕ, Фч, Ф衣);
   }
}
