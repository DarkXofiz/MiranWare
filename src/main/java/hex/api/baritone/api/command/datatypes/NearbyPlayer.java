// Original binary: hex/api/baritone/api/command/datatypes/NearbyPlayer
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.player.Player;

// $VF: Compiled from s
public enum NearbyPlayer implements IDatatypeFor<Player> {
   INSTANCE;

   public Player get(IDatatypeContext var1) throws CommandException {
      String var2 = var1.getConsumer().getString();
      return getPlayers(var1).stream().filter(var1x -> var1x.getName().getString().equalsIgnoreCase(var2)).findFirst().orElse(null);
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) throws CommandException {
      return new TabCompleteHelper()
         .append(getPlayers(var1).stream().map(Player::getName).map(Component::getString))
         .filterPrefix(var1.getConsumer().getString())
         .sortAlphabetically()
         .stream();
   }

   private static List<? extends Player> getPlayers(IDatatypeContext var0) {
      return var0.getBaritone().getPlayerContext().world().players();
   }
}
