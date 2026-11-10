// Original binary: sg/ec/kxq51prDBTDZyFYm
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.StatusOnly;
import net.minecraft.util.Mth;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.phys.Vec3;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public class GrimGlide extends ClientModule {
   private final ModeSetting field21134;
   private int field21135;
   private boolean field21136;
   private static final String field21137 = "Режим";
   private static final String field21138 = "Старый";
   private static final String field21139 = "Новый";
   private static final String field21140 = "Новый";
   private static final String field21141 = "Grim Glide";
   private static final float field21142 = (float) (Math.PI / 180.0);
   private static final double field21143 = 0.01;
   private static final double field21144 = 0.04F;
   private static final double field21145 = 3.2;
   private static final double field21146 = 0.1;
   private static final double field21147 = 0.1;
   private static final double field21148 = 0.09F;
   private static final double field21149 = 0.99F;
   private static final double field21150 = 0.98F;
   private static final double field21151 = 0.99F;
   private static final double field21152 = 0.03F;
   private static final double field21153 = -1.0;
   private static final double field21154 = 0.75;
   private static final double field21155 = -0.1;
   private static final String field21156 = "Старый";

   @Subscribe
   private void method09293(PacketEvent var1) {
      if (this.field21134.method05600(field21156)) {
         if (mc.player != null) {
            Packet var2 = var1.method10897();
            if (var2 instanceof ClientboundPlayerPositionPacket) {
               this.field21135 = 2;
               this.field21136 = true;
            }

            if (var2 instanceof ServerboundMovePlayerPacket && !mc.player.onGround()) {
               if (mc.player.isFallFlying() && this.field21135 == 0 && !this.field21136) {
                  PlayerUtils.method11812(new StatusOnly(true, true));
                  var1.method05696();
               }

               this.field21136 = false;
            }
         }
      }
   }

   @Subscribe
   private void method09294(ElytraVelocityEvent var1) {
      LivingEntity var2 = var1.method06492();
      if (var2 instanceof LocalPlayer) {
         if (!var2.onGround()) {
            float var3 = var2.getXRot();
            Vec3 var4 = var2.getDeltaMovement();
            Vec3 var5 = var2.getLookAngle();
            float var6 = var3 * field21142;
            double var7 = Math.sqrt(var5.x * var5.x + var5.z * var5.z);
            double var9 = var4.horizontalDistance();
            boolean var11 = var2.getDeltaMovement().y <= 0.0;
            double var12 = var11 && var2.hasEffect(MobEffects.SLOW_FALLING)
               ? Math.min(((LivingEntityMixin_1248)(Object)var2).IgetEffectiveGravity(), field21143)
               : ((LivingEntityMixin_1248)(Object)var2).IgetEffectiveGravity();
            var4 = method09295(var4, var5, var6, var7, var12);
            if (var6 < 0.0F && var7 > 0.0) {
               double var14 = var9 * -Mth.sin(var6) * field21144;
               var4 = var4.add(-var5.x * var14 / var7, var14 * field21145, -var5.z * var14 / var7);
            }

            if (var7 > 0.0) {
               var4 = var4.add((var5.x / var7 * var9 - var4.x) * field21146, 0.0, (var5.z / var7 * var9 - var4.z) * field21147);
            }

            double var16 = Math.toRadians(var2.getYRot());
            double var18 = -Math.sin(var16);
            double var20 = Math.cos(var16);
            double var22 = field21148;
            var1.method06494(var4.multiply(field21149, field21150, field21151).add(var18 * var22, field21152, var20 * var22));
         }
      }
   }

   static Vec3 method09295(Vec3 var0, Vec3 var1, double var2, double var4, double var6) {
      double var8 = Mth.square(Math.cos(var2));
      var0 = var0.add(0.0, var6 * (field21153 + var8 * field21154), 0.0);
      if (var0.y < 0.0 && var4 > 0.0) {
         double var10 = var0.y * field21155 * var8;
         var0 = var0.add(var1.x * var10 / var4, var10, var1.z * var10 / var4);
      }

      return var0;
   }

   @Subscribe
   private void method09296(PostPlayerInputEvent var1) {
      if (this.field21135 > 0) {
         this.field21135--;
      }
   }

   public GrimGlide() {
      super(ModuleCategory.Movement, ModuleSubCategory.Other);
      this.field21134 = new ModeSetting(field21137).method05597(field21138, field21139).method03017(field21140).method03023(this);
      this.method03935(field21141);
   }
}
