// Original binary: sg/ec/Ft3Y4WycuwiD78WP
package sg.ec;

import hex.script.api.PacketInfo;
import hex.script.api.Packets;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ServerboundAttackPacket;
import net.minecraft.network.protocol.game.ServerboundClientCommandPacket;
import net.minecraft.network.protocol.game.ServerboundContainerClosePacket;
import net.minecraft.network.protocol.game.ServerboundInteractPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.network.protocol.game.ServerboundUseItemPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.Pos;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.PosRot;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.Rot;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.StatusOnly;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class ScriptPacketsAdapter implements MinecraftAccess {
   private static final Action[] field07704 = new Action[]{
      Action.START_DESTROY_BLOCK,
      Action.ABORT_DESTROY_BLOCK,
      Action.STOP_DESTROY_BLOCK,
      Action.DROP_ALL_ITEMS,
      Action.DROP_ITEM,
      Action.RELEASE_USE_ITEM,
      Action.SWAP_ITEM_WITH_OFFHAND
   };
   private static final net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action[] field07705 = new net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action[]{
      net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action.START_SPRINTING,
      net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action.STOP_SPRINTING,
      net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action.START_FALL_FLYING,
      net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action.STOP_SLEEPING,
      net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action.OPEN_INVENTORY
   };
   private static final Packets field07706 = new Packets(
      ScriptPacketsAdapter::method03450,
      ScriptPacketsAdapter::method03452,
      ScriptPacketsAdapter::method03449,
      ScriptPacketsAdapter::method03455,
      ScriptPacketsAdapter::method03454
   );
   private static final String field07707 = "This is a utility class and cannot be instantiated";

   private static Object method03449(int var0, Object var1, double var2, double var4, double var6, boolean var8, boolean var9) {
      Entity var10 = ScriptEntitiesAdapter.method09073(var1);
      if (var10 == null) {
         return null;
      }

      if (var0 == 0) {
         return new ServerboundAttackPacket(var10.getId());
      }

      Vec3 sx = var0 == 2 ? new Vec3(var2, var4, var6) : Vec3.ZERO;
      return new ServerboundInteractPacket(var10.getId(), method03451(var8), sx, var9);
   }

   private static boolean method03450(Object var0) {
      if (mc.player != null && mc.getConnection() != null && var0 instanceof Packet var1) {
         mc.getConnection().send(var1);
         return true;
      } else {
         return false;
      }
   }

   private static InteractionHand method03451(boolean var0) {
      return var0 ? InteractionHand.OFF_HAND : InteractionHand.MAIN_HAND;
   }

   private static Object method03452(int var0, double var1, double var3, double var5, float var7, float var8, boolean var9, boolean var10) {
      return switch (var0) {
         case 1 -> new Rot(var7, var8, var9, var10);
         case 2 -> new PosRot(var1, var3, var5, var7, var8, var9, var10);
         case 3 -> new StatusOnly(var9, var10);
         default -> new Pos(var1, var3, var5, var9, var10);
      };
   }

   public static Packets method03453() {
      return field07706;
   }

   private static String method03454(Object var0) {
      if (var0 instanceof PacketInfo var1) {
         return var1.type();
      } else {
         return var0 == null ? "" : var0.getClass().getSimpleName();
      }
   }

   private static Object method03455(int var0, int var1, int var2, int var3, int var4, int var5) {
      return switch (var0) {
         case 1 -> null;
         case 2 -> new ServerboundPlayerActionPacket(
            field07704[Math.max(0, Math.min(field07704.length - 1, var1))], new BlockPos(var2, var3, var4), Direction.values()[Math.max(0, Math.min(5, var5))]
         );
         case 3 -> mc.player == null ? null : new ServerboundPlayerCommandPacket(mc.player, field07705[Math.max(0, Math.min(field07705.length - 1, var1))]);
         case 4 -> new ServerboundContainerClosePacket(var1);
         case 5 -> new ServerboundClientCommandPacket(net.minecraft.network.protocol.game.ServerboundClientCommandPacket.Action.PERFORM_RESPAWN);
         case 6 -> new ServerboundUseItemPacket(method03451(var1 != 0), var2, Float.intBitsToFloat(var3), Float.intBitsToFloat(var4));
         default -> var1 >= 0 && var1 <= 8 ? new ServerboundSetCarriedItemPacket(var1) : null;
      };
   }

   private ScriptPacketsAdapter() {
      throw new UnsupportedOperationException(field07707);
   }
}
