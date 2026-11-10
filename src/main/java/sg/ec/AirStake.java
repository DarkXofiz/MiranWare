// Original binary: sg/ec/yAKJVScaVYWtIzOH
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.game.ServerboundClientTickEndPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.StatusOnly;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class AirStake extends ClientModule {
   private final ModeSetting field26397;
   private int field26398;
   private Vec3 field26399;
   private static final String field26400 = "Режим";
   private static final String field26401 = "Обычный";
   private static final String field26402 = "Обход Funtime";
   private static final String field26403 = "Обычный";
   private static final String field26404 = "Air Stake";
   private static final String field26405 = "Обход Funtime";
   private static final String field26406 = "Обычный";

   @Override
   public void method00276() {
      this.field26399 = null;
      this.field26398 = 0;
      super.method00276();
   }

   @Subscribe
   private void method11562(PreMovementPacketEvent var1) {
      if (this.method11565()) {
         this.field26398++;
         var1.method05696();
      }
   }

   @Subscribe(1)
   private void method11563(PlayerInputEvent var1) {
      if (this.method11565()) {
         var1.method11173(false);
         var1.method11168();
      }
   }

   @Subscribe
   private void method11564(EntityVelocityEvent var1) {
      if (this.method11565()) {
         Entity var2 = var1.method02128();
         if (var2 instanceof LocalPlayer) {
            if (this.field26399 == null) {
               this.field26399 = var1.method02131();
            }

            var1.method02129(Vec3.ZERO);
            var1.method05695(true);
         }
      }
   }

   @Override
   public void method00245() {
      if (mc.player != null) {
         if (this.field26399 != null) {
            mc.player.setDeltaMovement(this.field26399);
         }

         if (this.field26398 > 15) {
            PlayerUtils.method11812(new StatusOnly(true, mc.player.horizontalCollision));
         }
      }

      this.field26398 = 0;
      super.method00245();
   }

   private boolean method11565() {
      return this.field26397.method05600(field26406);
   }

   @Subscribe
   private void method11566(PacketEvent var1) {
      if (this.field26397.method05600(field26405) && var1.method10899() && var1.method10897() instanceof ServerboundClientTickEndPacket) {
         var1.method05696();
      }
   }

   public AirStake() {
      super(ModuleCategory.Movement, ModuleSubCategory.Main);
      this.field26397 = new ModeSetting(field26400).method05597(field26401, field26402).method03017(field26403).method03023(this);
      this.field26398 = 0;
      this.field26399 = null;
      this.method03935(field26404);
   }

   @Subscribe(4)
   private void method11567(EntityMoveEvent var1) {
      if (this.method11565()) {
         var1.method10060(Vec3.ZERO);
      }
   }
}
