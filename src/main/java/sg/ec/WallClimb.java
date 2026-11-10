// Original binary: sg/ec/AQIJPpR1m06aOajl
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Direction.Axis;
import net.minecraft.network.protocol.game.ServerboundUseItemPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.AbstractSkullBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.joml.Vector2f;
import sg.mx.LivingEntityMixin_1248;
import sg.mx.MultiPlayerGameModeMixin_1262;

// $VF: Compiled from s
public class WallClimb extends ClientModule {
   private static final float field06076 = 0.35F;
   private static final float field06077 = 0;
   private static final double field06078 = 0;
   private static final double field06079 = 0;
   private static final double field06080 = 0;
   private static final double field06081 = 0;
   private static final double field06082 = 0;
   private static final float field06083 = 0;
   private static final float field06084 = 0;
   private static final int field06085 = 0;
   private static final int field06086 = 0;
   private static final Direction[] field06087 = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
   private final ModeSetting field06088;
   private int field06089;
   private boolean field06090;
   private WallClimb.Nested70 field06091;
   private boolean field06092;
   private boolean field06093;
   private static final String field06094 = "Режим";
   private static final String field06095 = "Ванильный";
   private static final String field06096 = "Вода";
   private static final String field06097 = "Блоки";
   private static final String field06098 = "Ванильный";
   private static final String field06099 = "Wall Climb";
   private static final String field06100 = "Вода";
   private static final String field06101 = "Блоки";
   private static final double field06102 = 0.35F;
   private static final String field06103 = "Вода";
   private static final String field06104 = "Блоки";
   private static final float field06105 = 9999.0F;
   private static final int field06106 = Integer.MAX_VALUE;
   private static final double field06107 = Double.MAX_VALUE;
   private static final double field06108 = -0.25;
   private static final double field06109 = Double.MAX_VALUE;
   private static final float field06110 = 50.0F;
   private static final float field06111 = 1.5F;
   private static final float field06112 = 1.5F;
   private static final double field06113 = 0.1;
   private static final double field06114 = 0.35;
   private static final double field06115 = 0.35;
   private static final double field06116 = Double.MAX_VALUE;
   private static final double field06117 = 0.1;
   private static final double field06118 = 0.5;
   private static final float field06119 = 360.0F;
   private static final double field06120 = 0.3F;
   private static final String field06121 = "Блоки";
   private static final String field06122 = "Вода";
   private static final String field06123 = "У вас нет ведра с водой.";
   private static final String field06124 = "Блоки";
   private static final String field06125 = "У вас нет блоков.";

   @Override
   public void method00245() {
      this.field06091 = null;
      this.field06092 = false;
      this.field06093 = false;
      this.method02552();
      super.method00245();
   }

   @Subscribe
   private void method02543(PreMovementPacketEvent var1) {
      this.field06091 = null;
      if (mc.player != null && mc.level != null) {
         this.method02553();
         if (this.method02547()) {
            switch ((String)this.field06088.method03022()) {
               case field06100:
                  Vector2f var4 = this.method02551();
                  if (var4 == null) {
                     return;
                  }

                  this.method02556();
                  if (!this.field06090) {
                     return;
                  }

                  this.method02557(var4);
                  break;
               case field06101:
                  this.method02562();
                  break;
               default:
                  ((LivingEntityMixin_1248)(Object)mc.player).setjumpingCooldown(0);
                  mc.player.setOnGround(true);
                  mc.player.setDeltaMovement(mc.player.getDeltaMovement().x(), field06102, mc.player.getDeltaMovement().z());
            }
         }
      }
   }

   private WallClimb.Nested69 method02544() {
      BlockState var1 = this.method02563(mc.player.getOffhandItem());
      return var1 == null ? null : new WallClimb.Nested69(InteractionHand.OFF_HAND, -1, var1, true);
   }

   public WallClimb() {
      super(ModuleCategory.Movement, ModuleSubCategory.Main);
      this.field06088 = new ModeSetting(field06094).method05597(field06095, field06096, field06097).method03017(field06098).method03023(this);
      this.field06089 = -1;
      this.method03935(field06099);
   }

   @Subscribe
   private void method02545(PostMovementPacketEvent var1) {
      WallClimb.Nested70 var2 = this.field06091;
      this.field06091 = null;
      if (var2 != null && mc.player != null && mc.level != null && mc.gameMode != null) {
         this.method02550(var2);
      }
   }

   @Subscribe
   private void method02546(PlayerInputEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (this.field06088.method05600(field06103)) {
            if (mc.player.onClimbable()) {
               var1.method11169(true);
            }
         } else {
            if (this.field06088.method05600(field06104) && this.method02547() && mc.player.onGround()) {
               ((LivingEntityMixin_1248)(Object)mc.player).setjumpingCooldown(0);
               var1.method11173(true);
            }
         }
      }
   }

   private boolean method02547() {
      return mc.player.horizontalCollision || mc.player.onClimbable();
   }

   private BlockState method02548(ItemStack var1) {
      if (!var1.isEmpty() && var1.getItem() instanceof BlockItem var2) {
         BlockState var4 = var2.getBlock().defaultBlockState();
         return var4.getCollisionShape(mc.level, mc.player.blockPosition()).isEmpty() ? null : var4;
      } else {
         return null;
      }
   }

   private BlockPos method02549(BlockState var1) {
      AABB var2 = mc.player.getBoundingBox();
      Vec3 var3 = var2.getCenter();
      BlockPos var4 = BlockPos.containing(var3.x, var2.minY, var3.z);
      if (!mc.level.getBlockState(var4).canBeReplaced()) {
         return null;
      }

      if (this.method02560(var1, var4)) {
         return var4;
      }

      BlockPos var5 = var4.below();
      return this.method02560(var1, var5) ? var5 : null;
   }

   private void method02550(WallClimb.Nested70 var1) {
      Vector2f var2 = var1.rotation();
      float var3 = Math.abs(Mth.wrapDegrees(var2.x - mc.player.getYRot()));
      float var4 = Math.abs(var2.y - mc.player.getXRot());
      if (!(var3 > field06111) && !(var4 > field06112)) {
         if (var1.hand() == InteractionHand.MAIN_HAND) {
            this.method02566(var1.slot());
         }

         BlockHitResult var5 = new BlockHitResult(var1.aim(), var1.face(), var1.support(), false);
         this.field06092 = true;
         if (mc.gameMode.useItemOn(mc.player, var1.hand(), var5) == InteractionResult.SUCCESS) {
            mc.player.swing(var1.hand());
         }
      }
   }

   private Vector2f method02551() {
      Vec3 var1 = mc.player.getEyePosition();
      AABB var2 = mc.player.getBoundingBox();
      Vec3 var3 = var2.getCenter();
      Vec3 var4 = new Vec3(var3.x, var2.minY + field06113, var3.z);
      AABB var5 = var2.inflate(field06114, 0.0, field06115);
      Vector2f var6 = null;
      double var7 = field06116;

      for (int var9 = Mth.floor(var5.minX); var9 <= Mth.floor(var5.maxX); var9++) {
         for (int var10 = Mth.floor(var2.minY); var10 <= Mth.floor(var2.maxY); var10++) {
            for (int var11 = Mth.floor(var5.minZ); var11 <= Mth.floor(var5.maxZ); var11++) {
               BlockPos var12 = new BlockPos(var9, var10, var11);
               VoxelShape var13 = mc.level.getBlockState(var12).getShape(mc.level, var12);
               if (!var13.isEmpty()) {
                  for (AABB var15 : var13.toAabbs()) {
                     AABB var16 = var15.move(var12);
                     if (var16.intersects(var5)) {
                        Vec3 var17 = this.method02554(var4, var16);
                        double var18 = var17.distanceToSqr(var4);
                        if (!(var18 >= var7)) {
                           Vector2f var20 = PlayerUtils.method11816(var1, var17);
                           if (this.method02564(var1, var17, var20, var12, null)) {
                              var7 = var18;
                              var6 = var20;
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var6;
   }

   private void method02552() {
      if (this.field06090 && this.field06089 != -1) {
         if (mc.player != null && mc.gameMode != null) {
            if (this.field06088.method05600(field06121)) {
               mc.player.getInventory().setSelectedSlot(this.field06089);
               ((MultiPlayerGameModeMixin_1262)(Object)mc.gameMode).hookEnsureHasSentCarriedItem();
            } else {
               InventoryUtils.method06091(this.field06089);
            }
         }

         this.field06089 = -1;
         this.field06090 = false;
      }
   }

   private void method02553() {
      boolean var1 = mc.player.onGround();
      if (var1 && !this.field06093) {
         this.field06092 = false;
      }

      this.field06093 = var1;
   }

   private Vec3 method02554(Vec3 var1, AABB var2) {
      Vec3 var3 = new Vec3(Mth.clamp(var1.x, var2.minX, var2.maxX), Mth.clamp(var1.y, var2.minY, var2.maxY), Mth.clamp(var1.z, var2.minZ, var2.maxZ));
      return var3.add(var2.getCenter().subtract(var3).scale(field06117));
   }

   private WallClimb.Nested70 method02555(BlockPos var1, Vec3 var2, WallClimb.Nested69 var3) {
      WallClimb.Nested70 var4 = null;
      double var5 = field06107;

      for (Direction var10 : field06087) {
         WallClimb.Nested70 var11 = this.method02561(var1, var2, var3, var10);
         if (var11 != null) {
            double var12 = var11.aim().distanceToSqr(var2);
            if (!(var12 >= var5)) {
               var5 = var12;
               var4 = var11;
            }
         }
      }

      return var4 != null ? var4 : this.method02561(var1, var2, var3, Direction.DOWN);
   }

   private void method02556() {
      int var1 = InventoryUtils.method06111(Items.WATER_BUCKET, true);
      if (var1 == -1) {
         this.method02552();
      } else {
         int var2 = mc.player.getInventory().getSelectedSlot();
         if (!this.field06090) {
            this.field06089 = var2;
         }

         if (var2 != var1) {
            InventoryUtils.method06091(var1);
         }

         this.field06090 = true;
      }
   }

   private void method02557(Vector2f var1) {
      float var2 = var1.x;
      float var3 = var1.y;
      RotationManager.method06547(new Rotation(var2, var3), field06119, 1, false);
      mc.player.getCooldowns().addCooldown(new ItemStack(Items.WATER_BUCKET), 10);
      ((MultiPlayerGameModeMixin_1262)(Object)mc.gameMode)
         .sendSequencedPacketAccessor(mc.level, var2x -> new ServerboundUseItemPacket(InteractionHand.MAIN_HAND, var2x, var2, var3));
      ((LivingEntityMixin_1248)(Object)mc.player).setjumpingCooldown(0);
      mc.player.setDeltaMovement(mc.player.getDeltaMovement().x(), field06120, mc.player.getDeltaMovement().z());
   }

   @Override
   public void method00276() {
      super.method00276();
      this.field06091 = null;
      this.field06092 = false;
      this.field06093 = false;
      if (mc.player != null && mc.level != null) {
         if (this.field06088.method05600(field06122) && InventoryUtils.method06111(Items.WATER_BUCKET, true) == -1) {
            ChatTextUtils.method05086(field06123);
            this.method00382();
         } else {
            if (this.field06088.method05600(field06124) && this.method02544() == null && this.method02567() == null) {
               ChatTextUtils.method05086(field06125);
               this.method00382();
            }
         }
      }
   }

   private boolean method02559(BlockPos var1, BlockState var2) {
      if (mc.player.input == null) {
         return false;
      }

      double var3 = var1.getY() + var2.getCollisionShape(mc.level, var1).max(Axis.Y);
      return SimulatedPlayerInput.method08931(3).field20218.y <= var3;
   }

   private boolean method02560(BlockState var1, BlockPos var2) {
      return !mc.level.getBlockState(var2).canBeReplaced() ? false : mc.level.isUnobstructed(var1, var2, CollisionContext.of(mc.player));
   }

   private WallClimb.Nested70 method02561(BlockPos var1, Vec3 var2, WallClimb.Nested69 var3, Direction var4) {
      BlockPos var5 = var1.relative(var4);
      BlockState var6 = mc.level.getBlockState(var5);
      if (var6.canBeReplaced()) {
         return null;
      }

      VoxelShape var7 = var6.getShape(mc.level, var5);
      if (var7.isEmpty()) {
         return null;
      }

      Vec3 var8 = Vec3.atCenterOf(var1).add(0.0, field06108, 0.0);
      Direction var9 = var4.getOpposite();
      WallClimb.Nested70 var10 = null;
      double var11 = field06109;

      for (AABB var14 : var7.toAabbs()) {
         AABB var15 = var14.move(var5);
         Vec3 var16 = this.method02554(var8, var15);
         double var17 = var16.distanceToSqr(var2);
         if (!(var17 >= var11)) {
            Vector2f var19 = PlayerUtils.method11816(var2, var16);
            if ((!var3.head() || !(var19.y < field06110)) && this.method02564(var2, var16, var19, var5, var9)) {
               var11 = var17;
               var10 = new WallClimb.Nested70(var5, var9, var16, var3.hand(), var3.slot(), var19);
            }
         }
      }

      return var10;
   }

   private void method02562() {
      if (!this.field06092) {
         Vec3 var1 = mc.player.getEyePosition();
         WallClimb.Nested70 var2 = this.method02565(this.method02544(), var1);
         if (var2 == null) {
            var2 = this.method02565(this.method02567(), var1);
         }

         if (var2 != null) {
            RotationManager.method06547(new Rotation(var2.rotation().x, var2.rotation().y), field06105, 1, false);
            this.field06091 = var2;
         }
      }
   }

   private BlockState method02563(ItemStack var1) {
      BlockState var2 = this.method02548(var1);
      return var2 != null && var2.getBlock() instanceof AbstractSkullBlock ? var2 : null;
   }

   private boolean method02564(Vec3 var1, Vec3 var2, Vector2f var3, BlockPos var4, Direction var5) {
      double var6 = var1.distanceTo(var2) + field06118;
      Vec3 var8 = var1.add(RaycastUtils.method09509(var3.y, var3.x).scale(var6));
      HitResult var9 = RaycastUtils.method09498(var1, var8, Block.OUTLINE, Fluid.NONE);
      if (var9.getType() != Type.BLOCK) {
         return false;
      }

      BlockHitResult var10 = (BlockHitResult)var9;
      return var10.getBlockPos().equals(var4) && (var5 == null || var10.getDirection() == var5);
   }

   private WallClimb.Nested70 method02565(WallClimb.Nested69 var1, Vec3 var2) {
      if (var1 == null) {
         return null;
      } else {
         BlockPos var3 = this.method02549(var1.state());
         if (var3 == null) {
            return null;
         } else {
            return !this.method02559(var3, var1.state()) ? null : this.method02555(var3, var2, var1);
         }
      }
   }

   private void method02566(int var1) {
      if (mc.player.getInventory().getSelectedSlot() != var1) {
         if (!this.field06090) {
            this.field06089 = mc.player.getInventory().getSelectedSlot();
            this.field06090 = true;
         }

         mc.player.getInventory().setSelectedSlot(var1);
      }
   }

   private WallClimb.Nested69 method02567() {
      int var1 = mc.player.getInventory().getSelectedSlot();
      int var2 = -1;
      int var3 = field06106;
      BlockState var4 = null;

      for (int var5 = 0; var5 < 9; var5++) {
         BlockState var6 = this.method02548(mc.player.getInventory().getItem(var5));
         if (var6 != null) {
            int var7 = Math.abs(var5 - var1);
            if (var7 < var3) {
               var3 = var7;
               var2 = var5;
               var4 = var6;
            }
         }
      }

      return var2 == -1 ? null : new WallClimb.Nested69(InteractionHand.MAIN_HAND, var2, var4, var4.getBlock() instanceof AbstractSkullBlock);
   }

   // $VF: Compiled from s
   private record Nested69(InteractionHand hand, int slot, BlockState state, boolean head) {
   }

   // $VF: Compiled from s
   private record Nested70(BlockPos support, Direction face, Vec3 aim, InteractionHand hand, int slot, Vector2f rotation) {
   }
}
