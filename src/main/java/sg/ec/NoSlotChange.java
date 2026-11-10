// Original binary: sg/ec/5KqU557PisLIlbYF
package sg.ec;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundSetHeldSlotPacket;

// $VF: Compiled from s
public class NoSlotChange extends ClientModule {
   private static final int field02193 = 100;
   private static final String field02194 = "No Slot Change";

   @Subscribe
   private void method00957(PacketEvent var1) {
      if (mc.player != null && !mc.isLocalServer()) {
         if (mc.player.tickCount >= 100) {
            Packet var2 = var1.method10897();
            if (var2 instanceof ClientboundSetHeldSlotPacket) {
               var1.method05696();
            }
         }
      }
   }

   public NoSlotChange() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.method03935(field02194);
   }
}
