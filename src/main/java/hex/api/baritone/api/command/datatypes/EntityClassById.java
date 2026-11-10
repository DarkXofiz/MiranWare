// Original binary: hex/api/baritone/api/command/datatypes/EntityClassById
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import java.util.stream.Stream;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.EntityType;

// $VF: Compiled from s
public enum EntityClassById implements IDatatypeFor<EntityType> {
   INSTANCE;

   public EntityType get(IDatatypeContext var1) throws CommandException {
      Identifier var2 = Identifier.parse(var1.getConsumer().getString());
      EntityType sx;
      if ((sx = BuiltInRegistries.ENTITY_TYPE.getOptional(var2).orElse(null)) == null) {
         throw new IllegalArgumentException("no entity found by that id");
      } else {
         return sx;
      }
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) throws CommandException {
      return new TabCompleteHelper()
         .append(BuiltInRegistries.ENTITY_TYPE.stream().map(Object::toString))
         .filterPrefixNamespaced(var1.getConsumer().getString())
         .sortAlphabetically()
         .stream();
   }
}
