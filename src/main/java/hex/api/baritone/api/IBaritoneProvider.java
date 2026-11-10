// Original binary: hex/api/baritone/api/IBaritoneProvider
package hex.api.baritone.api;

import hex.api.baritone.api.cache.IWorldScanner;
import hex.api.baritone.api.command.ICommandSystem;
import hex.api.baritone.api.schematic.ISchematicSystem;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;

// $VF: Compiled from s
public interface IBaritoneProvider {
   default IBaritone getBaritoneForMinecraft(Minecraft var1) {
      for (IBaritone var3 : this.getAllBaritones()) {
         if (Objects.equals(var1, var3.getPlayerContext().minecraft())) {
            return var3;
         }
      }

      return null;
   }

   IWorldScanner getWorldScanner();

   default IBaritone getBaritoneForPlayer(LocalPlayer var1) {
      for (IBaritone var3 : this.getAllBaritones()) {
         if (Objects.equals(var1, var3.getPlayerContext().player())) {
            return var3;
         }
      }

      return null;
   }

   ISchematicSystem getSchematicSystem();

   boolean destroyBaritone(IBaritone var1);

   IBaritone getPrimaryBaritone();

   List<IBaritone> getAllBaritones();

   default IBaritone getBaritoneForConnection(ClientPacketListener var1) {
      for (IBaritone var3 : this.getAllBaritones()) {
         LocalPlayer sx = var3.getPlayerContext().player();
         if (sx != null && sx.connection == var1) {
            return var3;
         }
      }

      return null;
   }

   ICommandSystem getCommandSystem();

   IBaritone createBaritone(Minecraft var1);
}
