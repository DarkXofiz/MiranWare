// Original binary: hex/api/baritone/api/command/datatypes/BlockById
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import java.util.stream.Stream;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;

// $VF: Compiled from s
public enum BlockById implements IDatatypeFor<Block> {
   INSTANCE;

   public Block get(IDatatypeContext var1) throws CommandException {
      Identifier var2 = Identifier.parse(var1.getConsumer().getString());
      Block sx;
      if ((sx = BuiltInRegistries.BLOCK.getOptional(var2).orElse(null)) == null) {
         throw new IllegalArgumentException("no block found by that id");
      } else {
         return sx;
      }
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) throws CommandException {
      String var2 = var1.getConsumer().getString();
      return new TabCompleteHelper()
         .append(BuiltInRegistries.BLOCK.keySet().stream().map(Object::toString))
         .filterPrefixNamespaced(var2)
         .sortAlphabetically()
         .stream();
   }
}
