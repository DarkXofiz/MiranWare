// Original binary: sg/mx/TuxYOVuc6eDdGyMG
package sg.mx;

import java.util.List;
import net.minecraft.client.gui.screens.multiplayer.ServerSelectionList;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.client.multiplayer.ServerList;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.PromotedServerManager;

// $VF: Compiled from s
@Mixin(ServerSelectionList.class)
public class ServerSelectionListMixin {
   @Redirect(method = "updateOnlineServers", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ServerList;size()I"))
   private int hex$listedCount(ServerList var1) {
      return PromotedServerManager.INSTANCE.method02792().size() + var1.size();
   }

   @Redirect(
      method = "updateOnlineServers",
      at = @At(value = "INVOKE", target = "Lnet/minecraft/client/multiplayer/ServerList;get(I)Lnet/minecraft/client/multiplayer/ServerData;")
   )
   private ServerData hex$listedServer(ServerList var1, int var2) {
      var var3 = PromotedServerManager.INSTANCE.method02792();
      return var2 < var3.size() ? var3.get(var2) : var1.get(var2 - var3.size());
   }
}
