// Original binary: hex/api/baritone/api/command/datatypes/ItemById
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import java.util.stream.Stream;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;

// $VF: Compiled from s
public enum ItemById implements IDatatypeFor<Item> {
   INSTANCE;

   public Item get(IDatatypeContext var1) throws CommandException {
      Identifier var2 = Identifier.parse(var1.getConsumer().getString());
      Item sx;
      if ((sx = BuiltInRegistries.ITEM.getOptional(var2).orElse(null)) == null) {
         throw new IllegalArgumentException("No item found by that id");
      } else {
         return sx;
      }
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) throws CommandException {
      return new TabCompleteHelper()
         .append(BuiltInRegistries.ITEM.keySet().stream().map(Identifier::toString))
         .filterPrefixNamespaced(var1.getConsumer().getString())
         .sortAlphabetically()
         .stream();
   }
}
