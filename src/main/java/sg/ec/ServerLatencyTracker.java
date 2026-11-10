// Original binary: sg/ec/7Ni6zMll48Bqh20o
package sg.ec;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.network.protocol.game.ClientboundDamageEventPacket;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundSectionBlocksUpdatePacket;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundUseItemOnPacket;
import net.minecraft.network.protocol.game.ServerboundUseItemPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Action;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Entry;
import net.minecraft.world.phys.BlockHitResult;

// $VF: Compiled from s
public enum ServerLatencyTracker implements MinecraftAccess {
   INSTANCE;

   private static final int field03987 = 64;
   private static final long field03988 = 0;
   private static final long field03989 = 0;
   private static final int field03990 = 0;
   private static final int field03991 = 0;
   private final Map<Long, Long> field03992 = new ConcurrentHashMap<>();
   private final Map<Integer, Long> field03993 = new ConcurrentHashMap<>();
   private final Map<Integer, Long> field03994 = new ConcurrentHashMap<>();
   private final int[] field03995 = new int[]{0, 0, 0};
   private volatile long field03996;
   private volatile long field03997;
   private volatile long field03998;
   private volatile int field03999;
   private int field04000;
   private boolean field04001;

   public void method01665() {
      EventBus.method00263(this);
   }

   public long method01666() {
      if (mc.isLocalServer()) {
         return 0L;
      }

      long var1 = this.field03997;
      if (var1 > 0L && System.currentTimeMillis() - this.field03998 <= 10000L) {
         return var1;
      }

      int var3 = this.field03999;
      return var3 > 0 ? var3 : var1;
   }

   public int method01667() {
      return (int)(this.method01666() / 50L);
   }

   @Subscribe
   public void method01668(PacketEvent var1) {
      if (var1.method10899()) {
         this.method01669(var1.method10897());
      } else {
         this.method01672(var1.method10897());
      }
   }

   private void method01669(Packet<?> var1) {
      if (var1 instanceof ServerboundUseItemOnPacket var2) {
         BlockHitResult var5 = var2.getHitResult();
         BlockPos var6 = var5.getBlockPos();
         method01675(this.field03992, var6.asLong());
         method01675(this.field03992, var6.relative(var5.getDirection()).asLong());
      } else if (var1 instanceof ServerboundPlayerActionPacket var3) {
         this.method01670(var3);
      } else if (var1 instanceof ServerboundUseItemPacket) {
         this.field03996 = System.currentTimeMillis();
      } else if (var1 instanceof net.minecraft.network.protocol.game.ServerboundInteractPacket var4 && CompatPackets.isAttack(var4)) {
         method01675(this.field03993, CompatPackets.entityId(var4));
      }
   }

   private void method01670(ServerboundPlayerActionPacket var1) {
      switch (var1.getAction()) {
         case START_DESTROY_BLOCK:
         case STOP_DESTROY_BLOCK:
            method01675(this.field03992, var1.getPos().asLong());
            break;
         case DROP_ITEM:
         case DROP_ALL_ITEMS:
            this.method01671();
            break;
         case SWAP_ITEM_WITH_OFFHAND:
            method01675(this.field03994, 45);
      }
   }

   private void method01671() {
      LocalPlayer var1 = mc.player;
      if (var1 != null) {
         method01675(this.field03994, 36 + var1.getInventory().getSelectedSlot());
      }
   }

   private void method01672(Packet<?> var1) {
      if (var1 instanceof ClientboundBlockUpdatePacket var2) {
         this.method01676(this.field03992, var2.getPos().asLong());
      } else if (var1 instanceof ClientboundSectionBlocksUpdatePacket var3) {
         if (!this.field03992.isEmpty()) {
            var3.runUpdates((var1x, var2x) -> this.method01676(this.field03992, var1x.asLong()));
         }
      } else if (var1 instanceof ClientboundDamageEventPacket var4) {
         this.method01676(this.field03993, var4.entityId());
      } else if (var1 instanceof ClientboundContainerSetSlotPacket var5) {
         if (var5.getContainerId() == 0) {
            this.method01676(this.field03994, var5.getSlot());
         }
      } else if (var1 instanceof ClientboundAddEntityPacket var6) {
         this.method01673(var6);
      } else if (var1 instanceof ClientboundPlayerInfoUpdatePacket var7) {
         this.method01674(var7);
      } else if (var1 instanceof ClientboundLoginPacket) {
         this.method01678();
      }
   }

   private void method01673(ClientboundAddEntityPacket var1) {
      long var2 = this.field03996;
      if (var2 != 0L) {
         LocalPlayer var4 = mc.player;
         if (var4 != null && var1.getData() == var4.getId()) {
            this.field03996 = 0L;
            this.method01677(System.currentTimeMillis() - var2);
         }
      }
   }

   private void method01674(ClientboundPlayerInfoUpdatePacket var1) {
      if (var1.actions().contains(Action.UPDATE_LATENCY)) {
         UUID var2 = mc.getUser().getProfileId();

         for (var var4 : var1.entries()) {
            if (var4.profileId().equals(var2)) {
               if (var4.latency() > 0) {
                  this.field03999 = var4.latency();
               }

               return;
            }
         }
      }
   }

   private static <K> void method01675(Map<K, Long> var0, K var1) {
      if (var0.size() > 64) {
         var0.clear();
      }

      var0.put(var1, System.currentTimeMillis());
   }

   private <K> void method01676(Map<K, Long> var1, K var2) {
      Long var3 = (Long)var1.remove(var2);
      if (var3 != null) {
         this.method01677(System.currentTimeMillis() - var3);
      }
   }

   private void method01677(long var1) {
      if (var1 >= 0L && var1 <= 1000L) {
         int var3 = (int)var1;
         if (!this.field04001) {
            this.field03995[0] = var3;
            this.field03995[1] = var3;
            this.field03995[2] = var3;
            this.field04001 = true;
         } else {
            this.field03995[this.field04000] = var3;
            this.field04000 = (this.field04000 + 1) % this.field03995.length;
         }

         this.field03997 = method01679(this.field03995[0], this.field03995[1], this.field03995[2]);
         this.field03998 = System.currentTimeMillis();
      }
   }

   private void method01678() {
      this.field03992.clear();
      this.field03993.clear();
      this.field03994.clear();
      this.field03996 = 0L;
      this.field03997 = 0L;
      this.field03998 = 0L;
      this.field03999 = 0;
      this.field04000 = 0;
      this.field04001 = false;
   }

   private static int method01679(int var0, int var1, int var2) {
      return Math.max(Math.min(var0, var1), Math.min(Math.max(var0, var1), var2));
   }
}
