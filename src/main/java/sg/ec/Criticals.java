// Original binary: sg/ec/fPmo1OD3yPCQLAWf
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.common.ServerboundPongPacket;
import net.minecraft.network.protocol.game.ClientboundExplodePacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityMotionPacket;
import net.minecraft.network.protocol.game.ServerboundClientTickEndPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.network.protocol.game.ServerboundUseItemPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.Pos;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.PosRot;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.level.block.Blocks;
import sg.mx.LocalPlayerMixin_1170;

// $VF: Compiled from s
public class Criticals extends ClientModule {
   private static final long field18969 = 150L;
   private static final double field18970 = 0;
   private static final double field18971 = 0;
   private static final double field18972 = 0;
   private static final int field18973 = 0;
   private static final double field18974 = 0;
   private static final double field18975 = 0;
   private final ToggleSetting field18976;
   private final MultiToggleSetting field18977;
   private final ToggleSetting field18978;
   private final List<Packet<?>> field18979;
   private boolean field18980;
   private boolean field18981;
   private int field18982;
   private double field18983;
   private int field18984;
   private long field18985;
   private final List<Packet<?>> field18986;
   private final List<Packet<?>> field18987;
   private final Object field18988;
   private double field18989;
   private double field18990;
   private double field18991;
   private int field18992;
   private boolean field18993;
   private volatile boolean field18994;
   private static final String field18995 = "Старый GrimAC";
   private static final String field18996 = "Работать если";
   private static final String field18997 = "В паутине";
   private static final String field18998 = "С плавным падением";
   private static final String field18999 = "Ускорение ударов при плавном падении";
   private static final int field19000 = Integer.MIN_VALUE;
   private static final String field19001 = "Criticals";
   private static final double field19002 = 1.0E-9;
   private static final double field19003 = 1.0E-9;
   private static final String field19004 = "В паутине";
   private static final long field19005 = 150L;
   private static final double field19006 = 0.1;
   private static final String field19007 = "В паутине";
   private static final double field19008 = 1.0E-9;
   private static final double field19009 = 1.0E-9;
   private static final double field19010 = 9.0E-4;
   private static final int field19011 = Integer.MIN_VALUE;
   private static final double field19012 = 0.6;
   private static final double field19013 = 0.6;
   private static final String field19014 = "С плавным падением";
   private static final double field19015 = -0.003;
   private static final double field19016 = 2.5;
   private static final float field19017 = 0.6F;
   private static final double field19018 = -0.085F;
   private static final double field19019 = -0.15F;
   private static final String field19020 = "С плавным падением";
   private static final int field19021 = Integer.MIN_VALUE;
   private static final String field19022 = "С плавным падением";

   @Subscribe
   private void method08115(PlayerMovementActionEvent var1) {
      if (var1.method06804() == PlayerMovementActionEvent.Nested199.VELOCITY) {
         synchronized (this.field18988) {
            if (this.field18986.isEmpty()) {
               return;
            }
         }

         this.field18993 = true;
         var1.method05695(true);
      }
   }

   private void method08116() {
      this.method08140(this.field18987);
      this.method08140(this.field18986);
      this.method08146();
   }

   private void method08117(Packet<?> var1, PacketEvent var2) {
      if (!this.field18980 && this.field18979.isEmpty() && !this.field18994) {
         if (this.method08119()) {
            if (!((LocalPlayerMixin_1170)(Object)mc.player).wasSprinting()) {
               synchronized (this.field18988) {
                  if (false && this.field18986.isEmpty()) {
                     return;
                  }

                  this.field18986.add(var1);
               }

               var2.method05696();
            }
         }
      }
   }

   private ServerboundMovePlayerPacket method08118(ServerboundMovePlayerPacket var1) {
      double var2 = mc.player.getX();
      double var4 = mc.player.getY() - this.field18983;
      double var6 = mc.player.getZ();
      boolean var8 = var1.isOnGround();
      boolean var9 = var1.horizontalCollision();
      return var1.hasRotation() ? new PosRot(var2, var4, var6, var1.getYRot(0.0F), var1.getXRot(0.0F), var8, var9) : new Pos(var2, var4, var6, var8, var9);
   }

   private boolean method08119() {
      return this.method08147() && this.method08145() ? this.method08134() && !ModuleManager.INSTANCE.method08219().method00378() : false;
   }

   private static boolean method08120(double var0, double var2, double var4) {
      return var0 * var0 + var2 * var2 + var4 * var4 < field19010;
   }

   private void method08121() {
      this.field18980 = false;
      if (!this.field18979.isEmpty()) {
         for (Packet var2 : this.field18979) {
            PlayerUtils.method11812(var2);
         }

         this.field18979.clear();
      }
   }

   @Subscribe(0)
   private void method08122(PlayerInputEvent var1) {
      if (!this.method08152()) {
         boolean var2 = var1.method11161() != 0.0F || var1.method11166() != 0.0F;
         if (!var2) {
            if (this.field18982 == 2) {
               var1.method11173(true);
               this.field18982--;
            } else if (this.field18982 == 1) {
               var1.method11169(true);
               this.field18982--;
            }
         } else {
            this.field18982 = 0;
         }
      }
   }

   @Override
   public void method00276() {
      this.method08138();
      super.method00276();
   }

   @Subscribe(3)
   private void method08123(PacketEvent var1) {
      if (!this.method08152() && var1.method10899() && !var1.method05697()) {
         if (mc.player != null) {
            Packet var2 = var1.method10897();
            if (var2 instanceof ServerboundPongPacket) {
               this.method08129(var2, var1);
            } else if (var2 instanceof ServerboundMovePlayerPacket var3) {
               this.method08126(var3);
            } else if (!CompatPackets.isAttack(var2)) {
               if (var2 instanceof ServerboundClientTickEndPacket) {
                  this.method08143(var1);
                  this.field18994 = false;
               }
            } else {
               this.method08117(var2, var1);
            }
         }
      }
   }

   private void method08124() {
      this.field18984 = TickEvent.method03209();
      this.field18983 = this.field18983 + field19009;
      PlayerUtils.method11812(
         new Pos(mc.player.getX(), mc.player.getY() - this.field18983, mc.player.getZ(), mc.player.onGround(), mc.player.horizontalCollision)
      );
   }

   @Subscribe
   private void method08125(PlayerUpdateEvent var1) {
      if (this.method08152()) {
         this.method08138();
      } else {
         if (!this.method08119()) {
            this.method08116();
         }
      }
   }

   private void method08126(ServerboundMovePlayerPacket var1) {
      if (var1.hasPosition()) {
         double var2 = var1.getX(Double.NaN);
         double var4 = var1.getY(Double.NaN);
         double var6 = var1.getZ(Double.NaN);
         if (!Double.isNaN(this.field18990) && method08120(var2 - this.field18989, var4 - this.field18990, var6 - this.field18991)) {
            this.field18992 = TickEvent.method03209();
         }

         this.field18989 = var2;
         this.field18990 = var4;
         this.field18991 = var6;
      }
   }

   public boolean method08127() {
      return this.method03937() && !this.field18976.method03022() && this.field18977.method04520(field19020);
   }

   private static boolean method08128(double var0) {
      return var0 <= field19018 && var0 >= field19019;
   }

   private void method08129(Packet<?> var1, PacketEvent var2) {
      if (!this.field18994) {
         synchronized (this.field18988) {
            boolean var4 = !this.field18987.isEmpty();
            if (!var4 && !this.method08119()) {
               return;
            }

            this.field18987.add(var1);
         }

         var2.method05696();
      }
   }

   @Subscribe
   private void method08131(PacketEvent var1) {
      if (!this.method08152() && var1.method10904() && mc.player != null) {
         if (this.method08132(var1.method10897())) {
            this.field18994 = true;
            this.method08116();
         }
      }
   }

   private boolean method08132(Packet<?> var1) {
      return var1 instanceof ClientboundSetEntityMotionPacket var3
         ? var3.getId() == mc.player.getId()
         : var1 instanceof ClientboundExplodePacket var2 && var2.playerKnockback().isPresent();
   }

   private boolean method08133() {
      return mc.options.keyJump.isDown()
         || mc.options.keyShift.isDown()
         || mc.options.keyUp.isDown()
         || mc.options.keyDown.isDown()
         || mc.options.keyLeft.isDown()
         || mc.options.keyRight.isDown();
   }

   private boolean method08134() {
      return mc.player.getDeltaMovement().y <= field19015;
   }

   private void method08136(TimerSpeedEvent var1) {
      if (this.method08127() && this.field18978.method05999()) {
         if (!mc.player.onGround()) {
            if (!(ModuleManager.INSTANCE.method08219().field00813 > field19016)) {
               double var2 = mc.player.getDeltaMovement().y();
               if (method08128(var2)) {
                  var1.method01450(field19017);
                  var1.method05696();
               }
            }
         }
      }
   }

   @Subscribe
   private void method08137(TimerSpeedEvent var1) {
      if (!this.method08152()) {
         if (mc.player != null) {
            if (!mc.player.isFallFlying() && !mc.player.isInWater() && !mc.player.isInLava()) {
               if (AttackAura.method00456() != null) {
                  this.method08136(var1);
               }
            }
         }
      }
   }

   private void method08138() {
      this.method08121();
      this.field18981 = false;
      this.field18982 = 0;
      this.field18983 = 0.0;
      this.field18984 = -1;
      this.field18985 = 0L;
      this.field18992 = field19021;
      this.method08116();
   }

   public boolean method08139() {
      return this.method03937() && !this.field18976.method03022() && System.currentTimeMillis() < this.field18985;
   }

   private void method08140(List<Packet<?>> var1) {
      Packet[] var2;
      synchronized (this.field18988) {
         if (var1.isEmpty()) {
            return;
         }

         var2 = var1.toArray(new Packet[0]);
         var1.clear();
      }

      for (Packet var6 : var2) {
         PlayerUtils.method11812(var6);
      }
   }

   private boolean method08141() {
      return this.field18992 != field19011 && TickEvent.method03209() - this.field18992 <= 2;
   }

   @Subscribe
   public void method08142(AttackEntityEvent var1) {
      if (mc.player != null) {
         if (var1.method09434() instanceof LivingEntity) {
            if (!this.method08151()) {
               if (!mc.player.onGround() && !mc.player.isFallFlying() && !mc.player.isInWater() && !mc.player.isInLava()) {
                  if (var1.method09431() == AttackEntityEvent.Nested264.PRE) {
                     double var2 = field19003;
                     double var4 = mc.player.getX();
                     double var6 = mc.player.getY();
                     double var8 = mc.player.getZ();
                     if (this.field18977.method04520(field19004) && this.method08154(var2, var4, var6, var8)) {
                        return;
                     }
                  }
               }
            }
         }
      }
   }

   private void method08143(PacketEvent var1) {
      synchronized (this.field18988) {
         if (this.field18986.isEmpty() && this.field18987.isEmpty()) {
            return;
         }
      }

      var1.method05696();
      PlayerUtils.method11812(var1.method10897());
      this.method08116();
   }

   private boolean method08144() {
      return mc.options.keyUp.isDown() || mc.options.keyDown.isDown() || mc.options.keyLeft.isDown() || mc.options.keyRight.isDown();
   }

   private boolean method08145() {
      return !mc.player.onGround() && !mc.player.isFallFlying() && !mc.player.isInWater() && !mc.player.isInLava();
   }

   @Override
   public void method00245() {
      this.method08138();
      super.method00245();
   }

   private void method08146() {
      if (this.field18993) {
         this.field18993 = false;
         mc.player.setDeltaMovement(mc.player.getDeltaMovement().multiply(field19012, 1.0, field19013));
      }
   }

   public boolean method08147() {
      if (!this.method08150() || mc.player.connection == null) {
         return false;
      } else if (AttackAura.method00456() == null) {
         return false;
      } else {
         return !this.method08144() && !this.method08141() ? false : !this.method08149();
      }
   }

   public Criticals() {
      super(ModuleCategory.Combat, ModuleSubCategory.Utility);
      this.field18976 = new ToggleSetting(field18995).method03017(false).method03023(this);
      this.field18977 = new MultiToggleSetting(field18996)
         .method04517(NamedOption.method08077(field18997, true))
         .method04517(NamedOption.method08077(field18998, true))
         .method03025(() -> !this.field18976.method05999())
         .method03023(this);
      this.field18978 = new ToggleSetting(field18999)
         .method03017(false)
         .method03025(() -> this.field18977.method04520(field19022))
         .method03025(() -> !this.field18976.method05999())
         .method03023(this);
      this.field18979 = new ArrayList<>();
      this.field18980 = false;
      this.field18981 = false;
      this.field18982 = 0;
      this.field18983 = 0.0;
      this.field18984 = -1;
      this.field18985 = 0L;
      this.field18986 = new ArrayList<>();
      this.field18987 = new ArrayList<>();
      this.field18988 = new Object();
      this.field18989 = Double.NaN;
      this.field18990 = Double.NaN;
      this.field18991 = Double.NaN;
      this.field18992 = field19000;
      this.field18993 = false;
      this.field18994 = false;
      this.method03935(field19001);
   }

   public boolean method08148() {
      if (!this.method03937() || this.field18976.method03022() || mc.player == null) {
         return false;
      } else {
         return this.field18977.method04520(field19007) && this.method08145() && this.method08149() ? true : this.method08119();
      }
   }

   private boolean method08149() {
      if (mc.player != null && mc.level != null) {
         boolean var1 = WorldCollisionUtils.method02821(mc.player.getBoundingBox(), Blocks.COBWEB);
         return var1 && !WorldCollisionUtils.method02820(var1, field19006);
      } else {
         return false;
      }
   }

   public boolean method08150() {
      return this.method03937()
         && !this.field18976.method03022()
         && this.field18977.method04520(field19014)
         && mc.player != null
         && mc.player.hasEffect(MobEffects.SLOW_FALLING);
   }

   private boolean method08151() {
      if (!this.method08152()) {
         return false;
      }

      if (!mc.player.isInWater() && !mc.player.isFallFlying() && !mc.player.onGround()) {
         PlayerUtils.method11812(
            new PosRot(
               mc.player.getX(),
               mc.player.getY() - field19002,
               mc.player.getZ(),
               mc.player.getXRot(),
               mc.player.getYRot(),
               false,
               mc.player.horizontalCollision
            )
         );
         if (!mc.player.isUsingItem()) {
            PlayerUtils.method11812(new ServerboundUseItemPacket(InteractionHand.OFF_HAND, 0, mc.player.getXRot(), mc.player.getYRot()));
            mc.gameMode.releaseUsingItem(mc.player);
         }

         return true;
      } else {
         return true;
      }
   }

   public boolean method08152() {
      return this.method03937() && this.field18976.method03022();
   }

   @Subscribe
   private void method08153(PacketEvent var1) {
      if (!this.method08152() && var1.method10899()) {
         Packet var2 = var1.method10897();
         if (!CompatPackets.isAttack(var2)) {
            if (var2 instanceof ServerboundMovePlayerPacket var3) {
               if (this.field18981) {
                  this.field18981 = false;
                  var1.method05696();
               } else if (!this.field18980) {
                  this.field18983 = 0.0;
               } else {
                  this.field18984 = TickEvent.method03209();
                  this.field18983 = this.field18983 + field19008;
                  var1.method05696();
                  PlayerUtils.method11812(this.method08118(var3));
                  this.method08121();
               }
            } else {
               if (var2 instanceof ServerboundClientTickEndPacket) {
                  if (this.field18979.isEmpty()) {
                     return;
                  }

                  if (this.field18984 != TickEvent.method03209()) {
                     this.method08124();
                  }

                  this.method08121();
               }
            }
         } else if (this.field18980) {
            this.field18979.add(var2);
            var1.method05696();
         }
      }
   }

   private boolean method08154(double var1, double var3, double var5, double var7) {
      if (mc.player == null || mc.player.connection == null) {
         return false;
      }

      if (!this.method08149()) {
         return false;
      }

      this.field18985 = System.currentTimeMillis() + field19005;
      if (this.method08133()) {
         this.field18980 = true;
      } else {
         mc.player.connection.send(new Pos(var3, var5 - var1, var7, false, mc.player.horizontalCollision));
         this.field18981 = true;
         this.field18982 = 2;
      }

      return true;
   }
}
