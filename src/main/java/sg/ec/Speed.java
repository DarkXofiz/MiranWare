// Original binary: sg/ec/38oH8B2Y9SWQGiBi
package sg.ec;

import java.util.List;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerCommandPacket.Action;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.ambient.Bat;
import net.minecraft.world.entity.animal.parrot.Parrot;
import net.minecraft.world.entity.decoration.ArmorStand;
import net.minecraft.world.entity.vehicle.boat.AbstractBoat;
import net.minecraft.world.entity.vehicle.minecart.AbstractMinecart;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec2;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.PlayerTeam;
import net.minecraft.world.scores.Team;
import net.minecraft.world.scores.Team.CollisionRule;

// $VF: Compiled from s
public class Speed extends ClientModule {
   private static final String field01126 = "Коллизия";
   private static final String field01127 = "field01127";
   private static final float field01128 = 0;
   private static final float field01129 = 0;
   private static final float field01130 = 0;
   private static final double field01131 = 0;
   private static final double field01132 = 0;
   private static final double field01133 = 0;
   private static final double field01134 = 0;
   private static final double field01135 = 0;
   private static final double field01136 = 0;
   private static final double field01137 = 0;
   private static final double field01138 = 0;
   private static final double field01139 = 0;
   private static final int field01140 = 0;
   private static final double field01141 = 0;
   private static final double field01142 = 0;
   private static final double field01143 = 0;
   private static final int field01144 = 0;
   private final ModeSetting field01145;
   private final ToggleSetting field01146;
   private final NumberSetting<Float> field01147;
   private final NumberSetting<Float> field01148;
   private final ToggleSetting field01149;
   private float field01150;
   private int field01151;
   private int field01152;
   private int field01153;
   private int field01154;
   private Entity field01155;
   private static final String field01156 = "Режим ускорения";
   private static final String field01157 = "Коллизия";
   private static final String field01158 = "Grim Flag";
   private static final String field01159 = "Коллизия";
   private static final String field01160 = "Адаптированная скорость";
   private static final String field01161 = "Скорость";
   private static final float field01162 = 0.01F;
   private static final float field01163 = 0.15F;
   private static final float field01164 = 0.01F;
   private static final float field01165 = 0.05F;
   private static final String field01166 = "Таймер";
   private static final float field01167 = 3.5F;
   private static final float field01168 = 0.05F;
   private static final float field01169 = 1.7F;
   private static final String field01170 = "Авто прыжок";
   private static final String field01171 = "Speed";
   private static final String field01172 = "Grim Flag";
   private static final double field01173 = 2.0;
   private static final double field01174 = 2.0;
   private static final double field01175 = 0.6;
   private static final double field01176 = 0.5;
   private static final double field01177 = 0.2;
   private static final double field01178 = 0.9;
   private static final double field01179 = 1.1;
   private static final double field01180 = 0.08;
   private static final double field01181 = 0.98;
   private static final double field01182 = 0.05;
   private static final double field01183 = 0.5;
   private static final double field01184 = 0.5;
   private static final double field01185 = 0.5;
   private static final double field01186 = 0.5;
   private static final double field01187 = 1.0E-4;
   private static final double field01188 = Double.MAX_VALUE;
   private static final double field01189 = Double.MAX_VALUE;
   private static final double field01190 = 2.0E-4;
   private static final double field01191 = 0.2;
   private static final double field01192 = 2.0;
   private static final double field01193 = 2.0;
   private static final double field01194 = 0.03F;
   private static final double field01195 = 0.065F;
   private static final double field01196 = 0.029F;
   private static final float field01197 = 0.2F;
   private static final String field01198 = "Коллизия";
   private static final double field01199 = 1.25;
   private static final double field01200 = 2.0;
   private static final String field01201 = "Grim Flag";
   private static final double field01202 = 0.3;
   private static final double field01203 = 1.8;
   private static final String field01204 = "Grim Flag";
   private static final String field01205 = "Коллизия";
   private static final String field01206 = "Коллизия";

   private Entity method00614() {
      LivingEntity var1 = this.method00629();
      return var1 != null ? var1 : this.field01155;
   }

   private void method00615() {
      this.field01153 = this.field01152;
      this.field01152 = 0;
      this.field01154 = 0;
      var var1 = this.method00622();
      if (var1.isEmpty()) {
         this.field01155 = null;
         boolean var10002 = false;
      } else {
         AABB var2 = method00625(mc.player.xo, mc.player.yo, mc.player.zo, mc.player.getX(), mc.player.getY(), mc.player.getZ());
         this.field01152 = this.method00623(var1, var2);
         this.field01155 = this.method00641(var1, var2);
         int var3 = Math.max(this.field01153, this.field01152);
         Vec3 var4 = this.method00626(var3);
         this.field01154 = this.method00623(var1, this.method00624(var4));
         if (this.field01154 > var3) {
            Vec3 var5 = this.method00626(this.field01154);
            if (this.method00623(var1, this.method00624(var5)) >= this.field01154) {
               var3 = this.field01154;
               var4 = var5;
            }
         }

         if (var3 != 0) {
            method00619(var3);
            this.method00629();
            MovementUtils.method05727(var4.x, var4.z);
         }
      }
   }

   @Subscribe
   private void method00616(TimerSpeedEvent var1) {
      if (this.field01150 != 1.0F) {
         var1.method01450(this.field01150);
         var1.method05696();
      }
   }

   private Vec3 method00618(Entity var1, double var2, double var4) {
      Vec3 var6 = mc.player.getDeltaMovement();
      Vec3 var7 = MovementUtils.method05718(var1);
      double var8 = var7.x - var6.x - var2;
      double var10 = var7.z - var6.z - var4;
      return new Vec3(var1.getX() - mc.player.getX() + var8 * field01192, 0.0, var1.getZ() - mc.player.getZ() + var10 * field01193);
   }

   public Speed() {
      super(ModuleCategory.Movement, ModuleSubCategory.Main);
      this.field01145 = new ModeSetting(field01156).method05597(field01157, field01158).method03017(field01159).method03023(this);
      this.field01146 = new ToggleSetting(field01160).method03017(true).method03025(() -> this.field01145.method05600(field01206)).method03023(this);
      this.field01147 = new NumberSetting<Float>(field01161)
         .method10835(field01162)
         .method10838(field01163)
         .method10834(field01164)
         .method03017(field01165)
         .method03025(() -> this.field01145.method05600(field01205) && !this.field01146.method03022())
         .method03023(this);
      this.field01148 = new NumberSetting<Float>(field01166)
         .method10835(1.0F)
         .method10838(field01167)
         .method10834(field01168)
         .method03017(field01169)
         .method03025(() -> this.field01145.method05600(field01204))
         .method03023(this);
      this.field01149 = new ToggleSetting(field01170).method03017(true).method03023(this);
      Object var10001 = null;
      var10001 = -1;
      this.field01150 = 1.0F;
      this.method03935(field01171);
   }

   private static double method00619(int var0) {
      return field01180 * var0 * field01181;
   }

   private boolean method00620(Entity var1) {
      PlayerTeam var2 = var1.getTeam();
      PlayerTeam var3 = mc.player.getTeam();
      CollisionRule var4 = method00640(var2);
      CollisionRule var5 = method00640(var3);
      if (var4 == CollisionRule.NEVER || var5 == CollisionRule.NEVER) {
         return false;
      } else {
         return var2 != null && var2.equals(var3)
            ? var4 != CollisionRule.PUSH_OWN_TEAM && var5 != CollisionRule.PUSH_OWN_TEAM
            : var4 != CollisionRule.PUSH_OTHER_TEAMS && var5 != CollisionRule.PUSH_OTHER_TEAMS;
      }
   }

   private void method00621() {
      this.field01150 = 1.0F;
      this.field01151 = 0;
      this.field01152 = 0;
      this.field01153 = 0;
      this.field01154 = 0;
      this.field01155 = null;
   }

   private List<Entity> method00622() {
      if (!mc.player.isPassenger() && !mc.player.isSpectator()) {
         Vec3 var1 = mc.player.getDeltaMovement();
         AABB var2 = method00625(mc.player.xo, mc.player.yo, mc.player.zo, mc.player.getX(), mc.player.getY(), mc.player.getZ())
            .inflate(1.0 + Math.hypot(var1.x, var1.z));
         return mc.level.getEntities(mc.player, var2, this::method00638);
      } else {
         return List.of();
      }
   }

   private int method00623(List<Entity> var1, AABB var2) {
      int var3 = 0;

      for (Entity var5 : var1) {
         if (var2.intersects(method00635(var5))) {
            var3++;
         }
      }

      return var3;
   }

   private AABB method00624(Vec3 var1) {
      Vec3 var2 = mc.player.getDeltaMovement().add(var1);
      double var3 = mc.player.getX();
      double var5 = mc.player.getY();
      double var7 = mc.player.getZ();
      return method00625(var3, var5, var7, var3 + var2.x, var5 + var2.y, var7 + var2.z);
   }

   private static AABB method00625(double var0, double var2, double var4, double var6, double var8, double var10) {
      return method00627(var0, var2, var4).minmax(method00627(var6, var8, var10).inflate(field01190)).inflate(field01191);
   }

   private Vec3 method00626(int var1) {
      if (var1 == 0) {
         return Vec3.ZERO;
      }

      double var2 = method00619(var1);
      double[] var4 = this.method00628();
      double var5 = var4[0];
      double var7 = var4[1];
      double var9 = 0.0;
      double var11 = 0.0;
      if (var5 != 0.0 || var7 != 0.0) {
         double var13 = this.field01146.method03022() ? var2 / Math.max(Math.abs(var5), Math.abs(var7)) : this.field01147.method03022().floatValue();
         var9 = var5 * var13;
         var11 = var7 * var13;
      }

      LivingEntity var18 = this.method00629();
      Entity var14 = var18 != null ? var18 : this.field01155;
      if (var14 == null) {
         return new Vec3(GuiHitTestUtils.method05610(-var2, var2, var9), 0.0, GuiHitTestUtils.method05610(-var2, var2, var11));
      }

      Vec3 var15 = this.method00618(var14, 0.0, 0.0);
      double var16 = method00632(var14, var18 != null);
      return new Vec3(method00642(var9, var15.x, var16, var2), 0.0, method00642(var11, var15.z, var16, var2));
   }

   private static AABB method00627(double var0, double var2, double var4) {
      double var6 = field01202;
      return new AABB(var0 - var6, var2, var4 - var6, var0 + var6, var2 + field01203, var4 + var6);
   }

   private double[] method00628() {
      Vec3 var1 = mc.player.getDeltaMovement();
      double var2 = Math.hypot(var1.x, var1.z);
      boolean var4 = var2 >= field01182;
      Vec2 var5 = mc.player.input.getMoveVector();
      if (var5.x == 0.0F && var5.y == 0.0F) {
         return var4 ? new double[]{var1.x / var2, var1.z / var2} : new double[]{0.0, 0.0};
      }

      double var6 = MovementUtils.method05725(mc.player.getYRot(), var5.y, var5.x);
      double var8 = -Math.sin(var6);
      double var10 = Math.cos(var6);
      if (!var4) {
         return new double[]{var8, var10};
      }

      double var12 = var1.x / var2 * field01183 + var8 * field01184;
      double var14 = var1.z / var2 * field01185 + var10 * field01186;
      double var16 = Math.hypot(var12, var14);
      return var16 < field01187 ? new double[]{var8, var10} : new double[]{var12 / var16, var14 / var16};
   }

   private LivingEntity method00629() {
      LivingEntity var1 = AttackAura.method00456();
      if (var1 != null && var1 != mc.player && var1.isAlive()) {
         return ModuleManager.INSTANCE.method08219().method03937() ? var1 : null;
      } else {
         return null;
      }
   }

   private double method00630(Entity var1) {
      double var2 = var1.getX() - mc.player.getX();
      double var4 = var1.getZ() - mc.player.getZ();
      return Math.sqrt(var2 * var2 + var4 * var4);
   }

   @Subscribe
   private void method00631(PacketEvent var1) {
      if (mc.player != null) {
         if (var1.method10904()
            && var1.method10897() instanceof ClientboundPlayerPositionPacket var2
            && this.field01145.method05600(field01201)
            && !mc.player.getAbilities().flying) {
            if (this.field01151 % 2 == 1) {
               this.field01151++;
            }

            this.field01150 = 1.0F;
         }
      }
   }

   private static double method00632(Entity var0, boolean var1) {
      return ((field01175 + var0.getBbWidth()) * field01176 + field01177) * (var1 ? field01178 : field01179);
   }

   private void method00633() {
      this.field01150 = this.field01148.method03022();
      if (this.field01151 > 3) {
         if (this.field01151 % 2 == 0) {
            MovementUtils.method05709(field01194);
         }

         double[] var1 = this.method00628();
         if (var1[0] != 0.0 || var1[1] != 0.0) {
            double var2 = this.field01151 % 2 == 0 && mc.player.onGround() ? field01195 : field01196;
            MovementUtils.method05727(var1[0] * var2, var1[1] * var2);
         }
      }

      this.field01151++;
      if (this.field01151 % 2 == 0) {
         this.field01150 = field01197;
         PlayerUtils.method11812(new ServerboundPlayerCommandPacket(mc.player, Action.START_FALL_FLYING));
      }
   }

   private static AABB method00635(Entity var0) {
      AABB var1 = var0.getBoundingBox();
      return var1.minmax(var1.move(var0.xo - var0.getX(), var0.yo - var0.getY(), var0.zo - var0.getZ()));
   }

   private boolean method00636() {
      Entity var1 = this.method00614();
      return var1 != null && this.field01152 != 0 ? mc.player.getY() + field01199 - var1.getY() >= field01200 : false;
   }

   @Subscribe
   private void method00637(PlayerInputEvent var1) {
      if (mc.player != null && !mc.player.getAbilities().flying && this.field01149.method03022()) {
         boolean var2 = var1.method11161() != 0.0F || var1.method11166() != 0.0F;
         if (var2 && mc.player.onGround() && !var1.method11162()) {
            if (!this.field01145.method05600(field01198) || !this.method00636()) {
               var1.method11173(true);
            }
         }
      }
   }

   private boolean method00638(Entity var1) {
      if (var1 instanceof ArmorStand || var1 instanceof Bat || var1 instanceof Parrot) {
         return false;
      } else {
         return !(var1 instanceof LivingEntity) && !(var1 instanceof AbstractBoat) && !(var1 instanceof AbstractMinecart) ? false : this.method00620(var1);
      }
   }

   @Override
   public void method00276() {
      this.method00621();
      super.method00276();
   }

   @Override
   public void method00245() {
      this.method00621();
      super.method00245();
   }

   @Subscribe
   private void method00639(PostPlayerInputEvent var1) {
      if (mc.player != null && mc.level != null && !mc.player.getAbilities().flying) {
         if (this.field01145.method05600(field01172)) {
            this.method00633();
         } else {
            this.method00615();
         }
      }
   }

   private static CollisionRule method00640(Team var0) {
      return var0 == null ? CollisionRule.ALWAYS : var0.getCollisionRule();
   }

   private Entity method00641(List<Entity> var1, AABB var2) {
      Entity var3 = null;
      Entity var4 = null;
      double var5 = field01188;
      double var7 = field01189;

      for (Entity var10 : var1) {
         double var11 = var10.distanceToSqr(mc.player.position());
         if (var11 < var7) {
            var7 = var11;
            var4 = var10;
         }

         if (var2.intersects(method00635(var10))) {
            Vec3 var13 = this.method00618(var10, 0.0, 0.0);
            double var14 = Math.hypot(var13.x, var13.z);
            if (var14 < var5) {
               var5 = var14;
               var3 = var10;
            }
         }
      }

      return var3 != null ? var3 : var4;
   }

   private static double method00642(double var0, double var2, double var4, double var6) {
      double var8 = GuiHitTestUtils.method05610(-var6, var6, (var2 - var4) / field01173);
      double var10 = GuiHitTestUtils.method05610(-var6, var6, (var2 + var4) / field01174);
      return GuiHitTestUtils.method05610(var8, var10, var0);
   }
}
