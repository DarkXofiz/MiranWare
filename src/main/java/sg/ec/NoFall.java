// Original binary: sg/ec/WIHPIXy2o64kSJQf
package sg.ec;

import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ClientboundDisconnectPacket;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.network.protocol.game.ClientboundRespawnPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.Pos;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.PosRot;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.Rot;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.StatusOnly;

// $VF: Compiled from s
public class NoFall extends ClientModule {
   private final ModeSetting field13549;
   private final NumberSetting<Float> field13550;
   public int field13551;
   public boolean field13552;
   private boolean field13553;
   private float field13554;
   private double field13555;
   private double field13556;
   private final ElapsedTimer field13557;
   private static final String field13558 = "Мод";
   private static final String field13559 = "Vanilla";
   private static final String field13560 = "Grim";
   private static final String field13561 = "Grim";
   private static final String field13562 = "Высота";
   private static final float field13563 = 20.0F;
   private static final float field13564 = 0.5F;
   private static final float field13565 = 3.0F;
   private static final String field13566 = "No Fall";
   private static final String field13567 = "Vanilla";
   private static final String field13568 = "Vanilla";
   private static final float field13569 = 0.5F;
   private static final long field13570 = 300L;
   private static final String field13571 = "Vanilla";
   private static final String field13572 = "LonyGrief";

   private boolean method05987() {
      return mc.getConnection() != null && mc.getConnection().serverBrand() != null && mc.getConnection().serverBrand().equals(field13572);
   }

   @Subscribe
   private void method05988(PlayerInputEvent var1) {
      if (mc.player != null && !this.method05987()) {
         if (!this.field13549.method05600(field13571)) {
            if (this.field13553) {
               var1.method11173(false);
            }

            if (this.field13551 == 2) {
               var1.method11173(false);
            }

            if (this.field13551 == 1) {
               var1.method11173(true);
            }
         }
      }
   }

   @Override
   public void method00245() {
      super.method00245();
      this.field13553 = false;
      this.field13554 = 1.0F;
      this.method05991();
   }

   @Subscribe
   private void method05989(TimerSpeedEvent var1) {
      if (this.field13554 != 1.0F) {
         var1.method01450(this.field13554);
         var1.method05696();
      }
   }

   private static ServerboundMovePlayerPacket method05990(ServerboundMovePlayerPacket var0) {
      double var1 = var0.getX(mc.player.getX());
      double var3 = var0.getY(mc.player.getY());
      double var5 = var0.getZ(mc.player.getZ());
      float var7 = var0.getYRot(mc.player.getYRot());
      float var8 = var0.getXRot(mc.player.getXRot());
      boolean var9 = var0.horizontalCollision();
      if (var0.hasPosition() && var0.hasRotation()) {
         return new PosRot(var1, var3, var5, var7, var8, true, var9);
      } else if (var0.hasPosition()) {
         return new Pos(var1, var3, var5, true, var9);
      } else {
         return var0.hasRotation() ? new Rot(var7, var8, true, var9) : new StatusOnly(true, var9);
      }
   }

   public void method05991() {
      this.field13551 = 0;
      this.field13552 = false;
      this.field13553 = false;
      this.field13555 = 0.0;
      this.field13556 = Double.NaN;
   }

   @Subscribe
   private void method05992(PlayerUpdateEvent var1) {
      if (mc.player != null && !this.method05987()) {
         this.method05994();
         this.field13552 = this.field13555 > this.field13550.method03022().floatValue();
         if (!this.field13549.method05600(field13568)) {
            if (this.field13551 == 2) {
               this.field13554 = field13569;
            }

            if (this.field13551 <= 1) {
               this.field13554 = 1.0F;
            }

            if (this.field13551 > 0) {
               this.field13551--;
            }

            if (this.field13557.method04699(field13570)) {
               this.field13553 = false;
               this.field13551 = 0;
            }
         }
      }
   }

   private boolean method05993() {
      return mc.player.onGround()
         || mc.player.isInWater()
         || mc.player.isInLava()
         || mc.player.isInPowderSnow
         || mc.player.onClimbable()
         || mc.player.isFallFlying()
         || mc.player.getAbilities().flying
         || mc.player.isPassenger();
   }

   public NoFall() {
      super(ModuleCategory.Player, ModuleSubCategory.Main);
      this.field13549 = new ModeSetting(field13558).method05597(field13559, field13560).method03017(field13561).method03023(this);
      this.field13550 = new NumberSetting<Float>(field13562)
         .method10835(1.0F)
         .method10838(field13563)
         .method10834(field13564)
         .method03017(field13565)
         .method03023(this);
      this.field13554 = 1.0F;
      this.field13556 = Double.NaN;
      this.field13557 = new ElapsedTimer();
      this.method03935(field13566);
   }

   private void method05994() {
      double var1 = mc.player.getY();
      double var3 = Double.isNaN(this.field13556) ? 0.0 : this.field13556 - var1;
      this.field13556 = var1;
      if (this.method05993()) {
         this.field13555 = 0.0;
      } else {
         if (var3 > 0.0) {
            this.field13555 += var3;
         }
      }
   }

   @Subscribe
   private void method05995(PacketEvent var1) {
      Packet var2 = var1.method10897();
      if (var1.method10904()
         && (var2 instanceof ClientboundLoginPacket || var2 instanceof ClientboundDisconnectPacket || var2 instanceof ClientboundRespawnPacket)) {
         this.method05991();
      }

      if (mc.player != null) {
         if (!this.method05987()) {
            if (this.field13549.method05600(field13567)) {
               if (var1.method10899() && this.field13552 && var2 instanceof ServerboundMovePlayerPacket var4 && !var4.isOnGround()) {
                  var1.method05696();
                  PlayerUtils.method11812(method05990(var4));
               }
            } else {
               if (var1.method10899() && var2 instanceof ServerboundMovePlayerPacket var3 && this.field13552 && var3.isOnGround() && this.field13551 == 0) {
                  PlayerUtils.method11812(new StatusOnly(true, false));
                  this.field13557.method04694();
                  this.field13553 = true;
               }

               if (var1.method10904() && var2 instanceof ClientboundPlayerPositionPacket && this.field13553) {
                  this.field13551 = 2;
                  this.field13553 = false;
               }
            }
         }
      }
   }
}
