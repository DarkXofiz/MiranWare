// Original binary: sg/ec/FqFB08ckvHngDG8m
package sg.ec;

import hex.script.api.PacketInfo;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundEntityEventPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerChatPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.network.protocol.game.ClientboundSetHealthPacket;
import net.minecraft.network.protocol.game.ClientboundSetHeldSlotPacket;
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket;
import net.minecraft.network.protocol.game.ClientboundTeleportEntityPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public final class ScriptNetworkAdapter implements MinecraftAccess {
   private static final int field07659 = 4;
   private static final ThreadLocal<ScriptNetworkAdapter.Nested98> field07660 = ThreadLocal.withInitial(ScriptNetworkAdapter.Nested98::new);
   private static final ClassValue<String> field07661 = new ClassValue<String>()   // $VF: Compiled from s
 {
      @Override
      protected String computeValue(Class<?> var1) {
         return this.method03447(var1);
      }

      protected String method03447(Class<?> var1) {
         String var2 = var1.getName();
         int sx = var2.lastIndexOf(46);
         return (sx < 0 ? var2 : var2.substring(sx + 1)).replace('$', '.');
      }
   };
   private static final String field07662 = "x";
   private static final String field07663 = "y";
   private static final String field07664 = "z";
   private static final String field07665 = "yaw";
   private static final String field07666 = "pitch";
   private static final String field07667 = "onGround";
   private static final String field07668 = "collision";
   private static final String field07669 = "id";
   private static final String field07670 = "x";
   private static final String field07671 = "y";
   private static final String field07672 = "z";
   private static final String field07673 = "id";
   private static final String field07674 = "onGround";
   private static final String field07675 = "id";
   private static final String field07676 = "eventId";
   private static final String field07677 = "entityId";
   private static final String field07678 = "slot";
   private static final String field07679 = "health";
   private static final String field07680 = "food";
   private static final String field07681 = "saturation";
   private static final String field07682 = "text";
   private static final String field07683 = "overlay";
   private static final String field07684 = "text";
   private static final String field07685 = "overlay";
   private static final String field07686 = "sender";
   private static final String field07687 = "hand";
   private static final String field07688 = "offhand";
   private static final String field07689 = "slot";
   private static final String field07690 = "action";
   private static final String field07691 = "x";
   private static final String field07692 = "y";
   private static final String field07693 = "z";
   private static final String field07694 = "side";
   private static final String field07695 = "sequence";
   private static final String field07696 = "x";
   private static final String field07697 = "y";
   private static final String field07698 = "z";
   private static final String field07699 = "yaw";
   private static final String field07700 = "pitch";
   private static final String field07701 = "This is a utility class and cannot be instantiated";

   private static void method03444(PacketInfo var0, Packet<?> var1) {
      if (var1 instanceof ServerboundMovePlayerPacket var2) {
         var0.put(field07662, var2.getX(0.0));
         var0.put(field07663, var2.getY(0.0));
         var0.put(field07664, var2.getZ(0.0));
         var0.put(field07665, var2.getYRot(0.0F));
         var0.put(field07666, var2.getXRot(0.0F));
         var0.put(field07667, var2.isOnGround());
         var0.put(field07668, var2.horizontalCollision());
      } else if (var1 instanceof ClientboundSetEntityMotionPacket var3) {
         Vec3 sx = var3.movement();
         var0.put(field07669, var3.id());
         var0.put(field07670, sx.x);
         var0.put(field07671, sx.y);
         var0.put(field07672, sx.z);
      } else if (var1 instanceof ClientboundTeleportEntityPacket var4) {
         var0.put(field07673, var4.id());
         method03445(var0, var4.change());
         var0.put(field07674, var4.onGround());
      } else if (var1 instanceof ClientboundPlayerPositionPacket var5) {
         var0.put(field07675, var5.id());
         method03445(var0, var5.change());
      } else if (var1 instanceof ClientboundEntityEventPacket var6) {
         var0.put(field07676, var6.getEventId());
         var0.put(field07677, var6.entityId);
      } else if (var1 instanceof ClientboundSetHeldSlotPacket var7) {
         var0.put(field07678, var7.slot());
      } else if (var1 instanceof ClientboundSetHealthPacket var8) {
         var0.put(field07679, var8.getHealth());
         var0.put(field07680, var8.getFood());
         var0.put(field07681, var8.getSaturation());
      } else if (var1 instanceof ClientboundSystemChatPacket var9) {
         var0.put(field07682, var9.content().getString());
         var0.put(field07683, var9.overlay());
      } else if (var1 instanceof ClientboundPlayerChatPacket var10) {
         Component sx = var10.unsignedContent().orElse(null);
         var0.put(field07684, sx == null ? var10.body().content() : sx.getString());
         var0.put(field07685, false);
         var0.put(field07686, var10.sender().toString());
      } else if (var1 instanceof ServerboundSetCarriedItemPacket var12) {
         var0.put(field07689, var12.getSlot());
      } else if (var1 instanceof ServerboundPlayerActionPacket var13) {
         BlockPos sx = var13.getPos();
         var0.put(field07690, var13.getAction().ordinal());
         var0.put(field07691, sx.getX());
         var0.put(field07692, sx.getY());
         var0.put(field07693, sx.getZ());
         var0.put(field07694, var13.getDirection().ordinal());
         var0.put(field07695, var13.getSequence());
      }
   }

   private static void method03445(PacketInfo var0, PositionMoveRotation var1) {
      Vec3 var2 = var1.position();
      var0.put(field07696, var2.x);
      var0.put(field07697, var2.y);
      var0.put(field07698, var2.z);
      var0.put(field07699, var1.yRot());
      var0.put(field07700, var1.xRot());
   }

   public static PacketInfo method03446(Object var0, boolean var1) {
      PacketInfo var2 = field07660.get().method03448();
      if (var0 instanceof Packet var3) {
         var2.set(field07661.get(var3.getClass()), var1);
         method03444(var2, var3);
      } else {
         var2.set(var0 == null ? "" : field07661.get(var0.getClass()), var1);
      }

      return var2;
   }

   private ScriptNetworkAdapter() {
      throw new UnsupportedOperationException(field07701);
   }

   // $VF: Compiled from s
   private static final class Nested98 {
      private final PacketInfo[] field07702 = new PacketInfo[4];
      private int field07703;

      private PacketInfo method03448() {
         PacketInfo var1 = this.field07702[this.field07703];
         this.field07703 = this.field07703 + 1 == 4 ? 0 : this.field07703 + 1;
         return var1;
      }

      private Nested98() {
         for (int var1 = 0; var1 < 4; var1++) {
            this.field07702[var1] = new PacketInfo();
         }
      }
   }
}
