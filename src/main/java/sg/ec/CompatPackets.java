package sg.ec;

import io.netty.buffer.Unpooled;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.network.protocol.game.ServerboundInteractPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;

/** 26.x'teki ServerboundAttackPacket yerine 1.21.11'deki ServerboundInteractPacket (ATTACK) kullanimi. */
public final class CompatPackets {
   private CompatPackets() {
   }

   public static ServerboundInteractPacket attack(Player player, int entityId) {
      if (player == null) {
         return null;
      }

      Entity target = player.level().getEntity(entityId);
      return target == null ? null : ServerboundInteractPacket.createAttackPacket(target, player.isShiftKeyDown());
   }

   public static boolean isAttack(Object packet) {
      if (!(packet instanceof ServerboundInteractPacket interact)) {
         return false;
      }

      boolean[] result = new boolean[1];
      interact.dispatch(new ServerboundInteractPacket.Handler() {
         @Override
         public void onInteraction(InteractionHand hand) {
         }

         @Override
         public void onInteraction(InteractionHand hand, Vec3 location) {
         }

         @Override
         public void onAttack() {
            result[0] = true;
         }
      });
      return result[0];
   }

   public static int entityId(ServerboundInteractPacket packet) {
      FriendlyByteBuf buf = new FriendlyByteBuf(Unpooled.buffer());
      try {
         ServerboundInteractPacket.STREAM_CODEC.encode(buf, packet);
         return buf.readVarInt();
      } finally {
         buf.release();
      }
   }
}
