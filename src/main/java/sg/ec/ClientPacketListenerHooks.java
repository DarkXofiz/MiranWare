// Original binary: sg/ec/QpLqYjezovZZfby8
package sg.ec;

import net.minecraft.network.protocol.game.ClientboundMoveEntityPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class ClientPacketListenerHooks {
   private static final double field11366 = 0.3333333333333333;

   public static void method05245(ClientboundMoveEntityPacket var0, Entity var1, Vec3 var2) {
      if (var1 instanceof Player && var1 instanceof EntityExtensionAccess var3) {
         var3.setVec2f(new Vec2(var0.getYRot(), var0.getXRot()));
         var3.setVec3d(var2.subtract(var1.getPosition(1.0F)).scale(field11366));
      }
   }

   private ClientPacketListenerHooks() {
   }
}
