// Original binary: hex/api/baritone/api/command/datatypes/RelativeBlockPos
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.utils.BetterBlockPos;
import java.util.stream.Stream;

// $VF: Compiled from s
public enum RelativeBlockPos implements IDatatypePost<BetterBlockPos, BetterBlockPos> {
   INSTANCE;

   public BetterBlockPos apply(IDatatypeContext var1, BetterBlockPos var2) throws CommandException {
      if (var2 == null) {
         var2 = BetterBlockPos.ORIGIN;
      }

      IArgConsumer var3 = var1.getConsumer();
      return new BetterBlockPos(
         var3.getDatatypePost(RelativeCoordinate.INSTANCE, (double)var2.x),
         var3.getDatatypePost(RelativeCoordinate.INSTANCE, (double)var2.y),
         var3.getDatatypePost(RelativeCoordinate.INSTANCE, (double)var2.z)
      );
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) throws CommandException {
      IArgConsumer var2 = var1.getConsumer();
      if (var2.hasAny() && !var2.has(4)) {
         while (var2.has(2) && var2.peekDatatypeOrNull(RelativeCoordinate.INSTANCE) != null) {
            var2.get();
         }

         return var2.tabCompleteDatatype(RelativeCoordinate.INSTANCE);
      } else {
         return Stream.empty();
      }
   }
}
