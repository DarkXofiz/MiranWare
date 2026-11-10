// Original binary: sg/ec/Oi1fxmg9u8BqahsW
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.player.Input;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.joml.Vector2f;

// $VF: Compiled from s
public class Scaffold extends ClientModule {
   private final NumberSetting<Float> field10664;
   private final NumberSetting<Integer> field10665;
   private final ToggleSetting field10666;
   private final ToggleSetting field10667;
   private final ToggleSetting field10668;
   private final ToggleSetting field10669;
   private final ToggleSetting field10670;
   private static final Direction[] field10671 = new Direction[]{
      Direction.DOWN, Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST, Direction.UP
   };
   private static final Direction[] field10672 = new Direction[]{Direction.NORTH, Direction.SOUTH, Direction.WEST, Direction.EAST};
   private static final double field10673 = 0.3;
   private static final double field10674 = 0;
   private static final double field10675 = 0;
   private static final double field10676 = 0;
   private static final double field10677 = 0;
   private static final double field10678 = 0;
   private static final double field10679 = 0;
   private static final double field10680 = 0;
   private static final int field10681 = 0;
   private static final int field10682 = 0;
   private static final int field10683 = 0;
   private static final int field10684 = 0;
   private static final int field10685 = 0;
   private static final int field10686 = 0;
   private static final int field10687 = 0;
   private static final int field10688 = 0;
   private static final int field10689 = 0;
   private static final int field10690 = 0;
   private static final int field10691 = 0;
   private static final int field10692 = 0;
   private static final int field10693 = 0;
   private static final int field10694 = 0;
   private static final float field10695 = 0;
   private static final float field10696 = 0;
   private static final float field10697 = 0;
   private static final double field10698 = 0;
   private static final int field10699 = 0;
   private static final int field10700 = 0;
   private static final int field10701 = 0;
   private static final int field10702 = 0;
   private static final long field10703 = 0;
   private static final int field10704 = ColorUtils.method04604(90, 200, 255);
   private static final int field10705 = ColorUtils.method04604(255, 190, 80);
   private final List<Scaffold.Nested146> field10706;
   private final List<Scaffold.Nested144> field10707;
   private Scaffold.Nested145 field10708;
   private Scaffold.Nested145 field10709;
   private BlockPos field10710;
   private Vector2f field10711;
   private Item field10712;
   private Vec3 field10713;
   private Vec3 field10714;
   private Vec3 field10715;
   private int field10716;
   private int field10717;
   private boolean field10718;
   private int field10719;
   private boolean field10720;
   private boolean field10721;
   private boolean field10722;
   private int field10723;
   private int field10724;
   private int field10725;
   private int field10726;
   private int field10727;
   private int field10728;
   private int field10729;
   private int field10730;
   private int field10731;
   private boolean field10732;
   private boolean field10733;
   private boolean field10734;
   private float field10735;
   private float field10736;
   private final int[] field10737;
   private int field10738;
   private int field10739;
   private int field10740;
   private Direction field10741;
   private static final String field10742 = "Дальность установки";
   private static final float field10743 = 3.0F;
   private static final float field10744 = 4.5F;
   private static final float field10745 = 0.1F;
   private static final float field10746 = 4.2F;
   private static final String field10747 = "Предикт тиков";
   private static final String field10748 = "Насколько далеко вперёд симулируется траектория движения";
   private static final String field10749 = "Приседать у края";
   private static final String field10750 = "Тормозит у края, пока блок не поставлен";
   private static final String field10751 = "Подъём при прыжке";
   private static final String field10752 = "При прыжке лесенка поднимается на уровень выше";
   private static final String field10753 = "Широкий мост";
   private static final String field10754 = "Заполняет все колонки под игроком, а не только путь";
   private static final String field10755 = "Аварийный приоритет";
   private static final String field10756 = "При риске падения перебивает ротацию других модулей";
   private static final String field10757 = "Визуализация";
   private static final String field10758 = "Scaffold";
   private static final String field10759 = "Строит опору под игроком по предсказанной траектории движения.";
   private static final int field10760 = Integer.MAX_VALUE;
   private static final double field10761 = 0.001;
   private static final double field10762 = 0.001;
   private static final double field10763 = 0.001;
   private static final double field10764 = 0.001;
   private static final double field10765 = 0.001;
   private static final double field10766 = 0.001;
   private static final double field10767 = -0.06;
   private static final double field10768 = 0.3;
   private static final double field10769 = 0.3;
   private static final double field10770 = 0.3;
   private static final double field10771 = 1.8;
   private static final double field10772 = 0.3;
   private static final double field10773 = 0.7;
   private static final double field10774 = 0.001;
   private static final double field10775 = 0.001;
   private static final double field10776 = 0.001;
   private static final double field10777 = 0.001;
   private static final double field10778 = 0.001;
   private static final double field10779 = 0.5;
   private static final double field10780 = 0.5;
   private static final double field10781 = 0.5;
   private static final double field10782 = 0.5;
   private static final double field10783 = -0.35;
   private static final double field10784 = Double.MAX_VALUE;
   private static final float field10785 = Float.MAX_VALUE;
   private static final double field10786 = 120.0;
   private static final float field10787 = 45.0F;
   private static final float field10788 = 45.0F;
   private static final float field10789 = -0.75F;
   private static final float field10790 = 0.75F;
   private static final double field10791 = 1.0E-4;
   private static final double field10792 = 1.0E-4;
   private static final double field10793 = 1.0E-4;
   private static final float field10794 = -90.0F;
   private static final float field10795 = 90.0F;
   private static final double field10796 = 0.1;
   private static final double field10797 = 0.25;
   private static final double field10798 = 0.1;
   private static final double field10799 = 0.25;
   private static final double field10800 = 0.1;
   private static final double field10801 = 0.25;
   private static final double field10802 = 0.5;
   private static final double field10803 = 0.35;
   private static final double field10804 = 0.5;
   private static final double field10805 = 0.35;
   private static final double field10806 = 0.5;
   private static final double field10807 = 0.35;
   private static final double field10808 = 0.5;
   private static final double field10809 = 0.5;
   private static final float field10810 = 0.5F;
   private static final float field10811 = 9999.0F;
   private static final double field10812 = 1.0E-4;
   private static final float field10813 = 0.9F;
   private static final float field10814 = 300.0F;
   private static final float field10815 = 0.4F;
   private static final float field10816 = 0.6F;
   private static final float field10817 = 180.0F;
   private static final double field10818 = 0.5;
   private static final float field10819 = 0.05F;
   private static final double field10820 = 0.5;
   private static final double field10821 = 0.5;
   private static final double field10822 = 0.5;
   private static final int field10823 = Integer.MAX_VALUE;

   private boolean method04828(Block var1) {
      if (var1 instanceof FallingBlock) {
         return false;
      } else {
         BlockState var2 = var1.defaultBlockState();
         if (var2.hasBlockEntity()) {
            return false;
         } else if (var2.is(BlockTags.ICE)) {
            return false;
         } else if (var2.is(Blocks.TNT) || var2.is(Blocks.SLIME_BLOCK) || var2.is(Blocks.HONEY_BLOCK)) {
            return false;
         } else {
            return !var2.is(Blocks.MAGMA_BLOCK) && !var2.is(Blocks.CRAFTING_TABLE) && !var2.is(Blocks.POWDER_SNOW)
               ? Block.isShapeFullBlock(var2.getCollisionShape(mc.level, mc.player.blockPosition()))
               : false;
         }
      }
   }

   private boolean method04829() {
      double var1 = this.field10664.method03022().floatValue();
      double var3 = var1 * var1;
      Vec3 var5 = mc.player.getEyePosition();
      HitResult var6 = mc.player.pick(var1, 1.0F, false);
      if (var6 instanceof BlockHitResult var7 && var6.getType() == Type.BLOCK) {
         BlockPos var8 = var7.getBlockPos();
         BlockPos var9 = var8.relative(var7.getDirection());
         if (mc.level.getBlockState(var8).canBeReplaced()) {
            return false;
         } else if (var5.distanceToSqr(var7.getLocation()) > var3) {
            return false;
         } else if (ExplosionDamageUtils.method04381(var5, var8) > var3) {
            return false;
         } else if (!this.method04856(var5, var7.getLocation(), var7.getDirection())) {
            return false;
         } else if (!this.method04843(var9)) {
            return false;
         } else if (!this.method04858(var9)) {
            return false;
         } else {
            return this.method04830(var9, var7.getDirection().getOpposite()) ? false : this.method04836(var7, var9);
         }
      } else {
         return false;
      }
   }

   private boolean method04830(BlockPos var1, Direction var2) {
      if (this.method04876()) {
         return false;
      }

      if (this.method04866(var1) > 1) {
         return false;
      }

      int var3 = var2 == this.field10741 ? 7 : 4;
      return mc.player.tickCount - this.field10740 < var3;
   }

   @Subscribe
   private void method04831(PlayerUpdateEvent var1) {
      if (this.field10709 != null && this.field10712 != null) {
         if (this.method04859()) {
            this.method04850();
         }
      }
   }

   @Override
   public void method00245() {
      this.method04884();
      this.field10707.clear();
      super.method00245();
   }

   private double method04832() {
      return mc.player.getEyeHeight(this.field10733 ? Pose.CROUCHING : Pose.STANDING);
   }

   private Input method04833() {
      Input var1 = mc.player.input.keyPresses;
      return new Input(var1.forward(), var1.backward(), var1.left(), var1.right(), var1.jump(), mc.options.keyShift.isDown(), var1.sprint());
   }

   private Scaffold.Nested145 method04834(BlockPos var1, Vec3 var2, Vec3 var3) {
      Scaffold.Nested145 var4 = null;
      double var5 = field10784;

      for (int var7 = 0; var7 < field10672.length; var7++) {
         BlockPos var8 = var1.relative(field10672[var7]);
         if (!this.method04862(var8) && this.method04858(var8)) {
            Scaffold.Nested145 var9 = this.method04841(var8, var2, var3);
            if (var9 != null) {
               double var10 = var2.distanceToSqr(Vec3.atCenterOf(var8));
               if (var10 < var5) {
                  var5 = var10;
                  var4 = var9;
               }
            }
         }
      }

      return var4;
   }

   private boolean method04835(AABB var1) {
      return !mc.level.noCollision(mc.player, var1.deflate(field10766).move(0.0, field10767, 0.0));
   }

   private boolean method04836(BlockHitResult var1, BlockPos var2) {
      int var3 = InventoryUtils.method06111(this.field10712, true);
      if (var3 == -1) {
         return false;
      }

      if (var3 != mc.player.getInventory().getSelectedSlot()) {
         mc.player.getInventory().setSelectedSlot(var3);
      }

      mc.gameMode.useItemOn(mc.player, InteractionHand.MAIN_HAND, var1);
      if (mc.level.getBlockState(var2).canBeReplaced()) {
         return false;
      }

      mc.player.swing(InteractionHand.MAIN_HAND);
      RotationChangeTracker.method02903();
      this.field10723++;
      this.method04861();
      Direction var4 = var1.getDirection().getOpposite();
      if (this.method04866(var2) <= 1) {
         this.field10740 = mc.player.tickCount;
      }

      this.field10741 = var4;
      this.field10728 = mc.player.tickCount;
      this.method04878(var2);
      if (this.field10670.method05999()) {
         this.field10707.add(new Scaffold.Nested144(var2, System.currentTimeMillis()));
      }

      return true;
   }

   @Subscribe
   private void method04837(TickEvent var1) {
      this.method04852();
      if (!this.method04859()) {
         this.method04868();
      } else {
         this.field10735 = mc.player.getYRot();
         this.field10736 = mc.player.getXRot();
         this.method04869();
         this.method04846();
         this.field10712 = this.method04854();
         this.field10720 = !this.field10706.isEmpty() && this.field10719 <= 2;
         Vec3 var2 = mc.player.getEyePosition();
         if (this.method04863()) {
            Scaffold.Nested145 var3 = this.method04841(this.field10708.target(), var2, this.method04873());
            if (var3 == null) {
               var3 = this.method04834(this.field10708.target(), var2, this.method04873());
            }

            this.field10708 = var3;
            this.field10731 = var3 == null ? 0 : this.field10731 + 1;
         } else {
            this.field10708 = null;
            this.field10731 = 0;
         }

         if (this.field10708 == null && !this.field10706.isEmpty() && this.field10712 != null) {
            this.field10708 = this.method04870(var2, this.method04873());
         }

         this.field10709 = this.field10708;
         if (this.field10709 == null && !this.field10706.isEmpty() && this.field10712 != null) {
            this.field10709 = this.method04870(this.method04879(), this.method04865());
         }

         this.method04872();
         if (!this.field10706.isEmpty()) {
            this.field10724 = mc.player.tickCount;
         }

         this.field10710 = this.field10709 == null ? null : this.field10709.target();
         if (this.field10709 != null) {
            this.field10711 = this.field10709.rotation();
         }

         if (this.field10711 != null && mc.player.tickCount - this.field10724 <= 20) {
            this.method04881(this.field10711);
         } else {
            this.field10711 = null;
         }
      }
   }

   private void method04838(AABB var1, int var2, double var3) {
      if (!(var1.minY > this.field10716 + 1.0 + field10773)) {
         boolean var5 = this.method04835(var1) || this.method04871(var1);
         if (!var5 || this.field10668.method05999()) {
            boolean var6 = var3 > 0.0 && var1.minY > this.field10716 + 1.0 + field10774;
            int var7 = var5 ? var2 + 32 : (var6 ? var2 + 8 : var2);
            int var8 = Mth.floor(var1.minX + field10775);
            int var9 = Mth.floor(var1.maxX - field10776);
            int var10 = Mth.floor(var1.minZ + field10777);
            int var11 = Mth.floor(var1.maxZ - field10778);
            double var12 = (var1.minX + var1.maxX) * field10779;
            double var14 = (var1.minZ + var1.maxZ) * field10780;

            for (int var16 = var8; var16 <= var9; var16++) {
               for (int var17 = var10; var17 <= var11; var17++) {
                  BlockPos var18 = new BlockPos(var16, this.field10716, var17);
                  if (!this.method04862(var18) && this.method04858(var18)) {
                     double var19 = var16 + field10781 - var12;
                     double var21 = var17 + field10782 - var14;
                     this.method04855(var18, var7, var19 * var19 + var21 * var21);
                  }
               }
            }
         }
      }
   }

   private Vec3 method04839() {
      Input var1 = mc.player.input.keyPresses;
      boolean var2 = this.field10733 || mc.options.keyShift.isDown();
      boolean var3 = this.field10734;
      Input var4 = new Input(
         !var3 && var1.forward(), !var3 && var1.backward(), !var3 && var1.left(), !var3 && var1.right(), var1.jump(), var2, var1.sprint() && !var2
      );
      SimulatedPlayerInput var5 = SimulatedPlayerInput.method08894(SimulatedPlayerInput.Nested248.fromClientPlayer(var4));
      var5.method08897();
      return var5.field20218;
   }

   private Vec3 method04840(Vec3 var1) {
      return var1 == null ? mc.player.getEyePosition() : new Vec3(var1.x, var1.y + this.method04832(), var1.z);
   }

   private Scaffold.Nested145 method04841(BlockPos var1, Vec3 var2, Vec3 var3) {
      double var4 = this.field10664.method03022().floatValue();
      double var6 = var4 * var4;
      Scaffold.Nested145 var8 = null;
      float var9 = field10785;

      for (int var10 = 0; var10 < field10671.length; var10++) {
         BlockPos var11 = var1.relative(field10671[var10]);
         BlockState var12 = mc.level.getBlockState(var11);
         if (!var12.canBeReplaced()) {
            VoxelShape var13 = var12.getShape(mc.level, var11);
            if (!var13.isEmpty()) {
               Direction var14 = field10671[var10].getOpposite();
               Vec3 var15 = this.method04874(var13.bounds().move(var11), var14, var2);
               if (!(var2.distanceToSqr(var15) > var6) && !(ExplosionDamageUtils.method04381(var2, var11) > var6) && this.method04856(var2, var15, var14)) {
                  Vector2f var16 = PlayerUtils.method11816(var2, var15);
                  if (this.method04847(var2, var15, var16, var11, var14)) {
                     Vector2f var17 = this.method04883(var2, var15, var16, var11, var14);
                     if (var17 != null) {
                        var16 = var17;
                     }

                     if (this.method04860(var3, var16, var11, var4)) {
                        float var18 = this.method04864(var16) - (float)(this.method04851(var2, var15, var14) * field10786);
                        if (var18 < var9) {
                           var9 = var18;
                           var8 = new Scaffold.Nested145(var1, var11, var14, var15, var16);
                        }
                     }
                  }
               }
            }
         }
      }

      return var8;
   }

   private Vec3 method04842(Vec3 var1) {
      if (var1 == null) {
         var1 = mc.player.position();
      }

      return new Vec3(var1.x, var1.y + mc.player.getEyeHeight(Pose.STANDING), var1.z);
   }

   private boolean method04843(BlockPos var1) {
      if (this.field10708 != null && this.field10708.target().equals(var1)) {
         return true;
      } else {
         return this.field10709 != null && this.field10709.target().equals(var1) ? true : this.method04862(var1);
      }
   }

   private boolean method04844(Scaffold.Nested145 var1) {
      return var1 == null
         ? false
         : this.method04857(mc.player.getEyePosition(), this.field10735, this.field10736, var1.support(), this.field10664.method03022().floatValue());
   }

   private boolean method04845() {
      return this.field10739 < 8 ? true : mc.player.tickCount - this.field10737[this.field10738] >= 20;
   }

   private void method04846() {
      this.method04838(mc.player.getBoundingBox(), 0, mc.player.getDeltaMovement().y);
      if (mc.player.input != null) {
         this.field10715 = this.method04839();
         SimulatedPlayerInput var1 = SimulatedPlayerInput.method08894(SimulatedPlayerInput.Nested248.fromClientPlayer(this.method04833()));
         int var2 = this.field10665.method03022();

         for (int var3 = 1; var3 <= var2; var3++) {
            var1.method08897();
            if (var1.field20218 == null) {
               break;
            }

            if (this.field10713 == null) {
               this.field10713 = var1.field20218;
            } else if (this.field10714 == null) {
               this.field10714 = var1.field20218;
            }

            if (var1.field20218.y < this.field10716 - 4) {
               break;
            }

            this.method04838(this.method04875(var1.field20218), var3, var1.field20219.y);
            if (this.field10706.size() >= 12) {
               break;
            }
         }
      }
   }

   private boolean method04847(Vec3 var1, Vec3 var2, Vector2f var3, BlockPos var4, Direction var5) {
      double var6 = var1.distanceTo(var2) + field10809;
      Vec3 var8 = var1.add(RaycastUtils.method09509(var3.y, var3.x).scale(var6));
      HitResult var9 = RaycastUtils.method09498(var1, var8, net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE);
      if (var9.getType() != Type.BLOCK) {
         return false;
      }

      BlockHitResult var10 = (BlockHitResult)var9;
      return var10.getBlockPos().equals(var4) && var10.getDirection() == var5;
   }

   private boolean method04848() {
      return this.field10667.method05999() && mc.player.input != null ? mc.player.input.keyPresses.jump() || mc.player.getDeltaMovement().y > 0.0 : false;
   }

   @Subscribe
   private void method04849(PlayerInputEvent var1) {
      if (mc.player != null) {
         if (this.method04882()) {
            RotationManager.field14787 = true;
         }

         if (this.field10721) {
            var1.method11169(true);
         }

         if (this.field10732) {
            var1.method11168();
         }
      }
   }

   private void method04850() {
      if (this.field10723 <= 0) {
         if (this.method04845() || this.method04876()) {
            if (!this.method04829()) {
               if (this.field10708 != null) {
                  this.field10729 = mc.player.tickCount;
               }
            } else {
               this.field10708 = null;
               this.field10731 = 0;
            }
         }
      }
   }

   private double method04851(Vec3 var1, Vec3 var2, Direction var3) {
      Vec3 var4 = var1.subtract(var2);
      double var5 = var4.length();
      if (var5 < field10812) {
         return 0.0;
      }

      Vec3 var7 = new Vec3(var3.getStepX(), var3.getStepY(), var3.getStepZ());
      return Math.abs(var4.scale(1.0 / var5).dot(var7));
   }

   private void method04852() {
      this.field10733 = this.field10721;
      this.field10734 = this.field10732;
      this.field10732 = false;
      this.field10706.clear();
      this.field10712 = null;
      this.field10722 = false;
      this.field10723 = 0;
      this.field10720 = false;
      this.field10719 = field10760;
      this.field10713 = null;
      this.field10714 = null;
      this.field10715 = null;
   }

   private AABB method04853(BlockPos var1, float var2) {
      double var3 = field10818 * Mth.clamp(var2, field10819, 1.0F);
      double var5 = var1.getX() + field10820;
      double var7 = var1.getY() + field10821;
      double var9 = var1.getZ() + field10822;
      return new AABB(var5 - var3, var7 - var3, var9 - var3, var5 + var3, var7 + var3, var9 + var3);
   }

   private Item method04854() {
      Item var1 = null;
      int var2 = -1;
      int var3 = mc.player.getInventory().getSelectedSlot();

      for (int var4 = 0; var4 < 9; var4++) {
         ItemStack var5 = mc.player.getInventory().getItem(var4);
         if (!var5.isEmpty() && var5.getItem() instanceof BlockItem var6 && this.method04828(var6.getBlock())) {
            int var8 = var5.getCount() + (var4 == var3 ? 16 : 0);
            if (var8 > var2) {
               var2 = var8;
               var1 = var5.getItem();
            }
         }
      }

      return var1;
   }

   private void method04855(BlockPos var1, int var2, double var3) {
      int var5 = this.field10706.size();

      for (int var6 = 0; var6 < this.field10706.size(); var6++) {
         Scaffold.Nested146 var7 = this.field10706.get(var6);
         if (var2 < var7.deadline() || var2 == var7.deadline() && var3 < var7.distance()) {
            var5 = var6;
            break;
         }
      }

      this.field10706.add(var5, new Scaffold.Nested146(var1, var2, var3));
      if (var2 < this.field10719) {
         this.field10719 = var2;
      }
   }

   public Scaffold() {
      super(ModuleCategory.Movement, ModuleSubCategory.Main);
      this.field10664 = new NumberSetting<Float>(field10742)
         .method10835(field10743)
         .method10838(field10744)
         .method10834(field10745)
         .method03017(field10746)
         .method03023(this);
      this.field10665 = new NumberSetting<Integer>(field10747)
         .method10835(1)
         .method10838(10)
         .method10834(1)
         .method03017(5)
         .method03018(field10748)
         .method03023(this);
      this.field10666 = new ToggleSetting(field10749).method03017(true).method03018(field10750).method03023(this);
      this.field10667 = new ToggleSetting(field10751).method03017(true).method03018(field10752).method03023(this);
      this.field10668 = new ToggleSetting(field10753).method03017(false).method03018(field10754).method03023(this);
      this.field10669 = new ToggleSetting(field10755).method03017(true).method03018(field10756).method03023(this);
      this.field10670 = new ToggleSetting(field10757).method03017(true).method03023(this);
      this.field10706 = new ArrayList<>(12);
      this.field10707 = new ArrayList<>();
      this.field10724 = -100;
      this.field10726 = -100;
      this.field10728 = -100;
      this.field10729 = -100;
      this.field10737 = new int[8];
      this.field10740 = -100;
      this.method03935(field10758);
      this.method03931(field10759);
   }

   private boolean method04856(Vec3 var1, Vec3 var2, Direction var3) {
      Vec3 var4 = new Vec3(var3.getStepX(), var3.getStepY(), var3.getStepZ());
      return var1.subtract(var2).dot(var4) > 0.0;
   }

   private boolean method04857(Vec3 var1, float var2, float var3, BlockPos var4, double var5) {
      AABB var7 = new AABB(var4);
      Vec3 var8 = RaycastUtils.method09509(var3, var2).scale(var5);
      if (var7.clip(var1, var1.add(var8)).isPresent()) {
         return true;
      }

      Vec3 var9 = var1.add(0.0, field10783, 0.0);
      return var7.clip(var9, var9.add(var8)).isPresent();
   }

   private boolean method04858(BlockPos var1) {
      if (var1.getY() < mc.level.getMinY() || var1.getY() >= mc.level.getMaxY()) {
         return false;
      } else {
         return !mc.level.getBlockState(var1).canBeReplaced() ? false : !ExplosionDamageUtils.method04374(var1);
      }
   }

   private boolean method04859() {
      if (mc.player == null || mc.level == null || mc.gameMode == null) {
         return false;
      } else if (mc.player.isSpectator() || mc.player.getAbilities().flying) {
         return false;
      } else if (mc.player.isFallFlying() || mc.player.isPassenger()) {
         return false;
      } else {
         return mc.player.onClimbable() ? false : !mc.player.isInWater() && !mc.player.isInLava();
      }
   }

   private boolean method04860(Vec3 var1, Vector2f var2, BlockPos var3, double var4) {
      if (this.method04857(var1, var2.x, var2.y, var3, var4)) {
         return true;
      }

      if (this.method04857(var1, this.field10735, this.field10736, var3, var4)) {
         return true;
      }

      Vec3 var6 = this.method04842(mc.player.position());
      return this.method04857(var6, var2.x, var2.y, var3, var4);
   }

   private void method04861() {
      this.field10737[this.field10738] = mc.player.tickCount;
      this.field10738 = (this.field10738 + 1) % 8;
      if (this.field10739 < 8) {
         this.field10739++;
      }
   }

   private boolean method04862(BlockPos var1) {
      for (int var2 = 0; var2 < this.field10706.size(); var2++) {
         if (this.field10706.get(var2).pos().equals(var1)) {
            return true;
         }
      }

      return false;
   }

   private boolean method04863() {
      if (this.field10708 == null || this.field10731 >= 3 || this.field10706.isEmpty()) {
         return false;
      } else {
         return !this.method04858(this.field10708.target()) ? false : !mc.level.getBlockState(this.field10708.support()).canBeReplaced();
      }
   }

   private float method04864(Vector2f var1) {
      float var2 = Math.abs(Mth.wrapDegrees(var1.x - mc.player.getYRot()));
      float var3 = Math.abs(var1.y - mc.player.getXRot());
      return var2 + var3 * field10810;
   }

   private Vec3 method04865() {
      return this.method04842(this.field10714 != null ? this.field10714 : this.field10713);
   }

   private int method04866(BlockPos var1) {
      int var2 = 0;

      for (int var3 = 0; var3 < field10672.length; var3++) {
         BlockPos var4 = var1.relative(field10672[var3]);
         if (mc.level.getBlockState(var4).getCollisionShape(mc.level, var4).isEmpty()) {
            var2++;
         }
      }

      return var2;
   }

   private int method04867() {
      if (!this.field10669.method05999()) {
         return 2;
      } else if (this.field10719 <= 0) {
         return 65;
      } else {
         return this.field10719 <= 2 ? 30 : 2;
      }
   }

   private void method04868() {
      this.field10708 = null;
      this.field10709 = null;
      this.field10710 = null;
      this.field10711 = null;
      this.field10724 = -100;
   }

   private void method04869() {
      double var1 = mc.player.getY();
      int var3 = this.method04877(var1);
      this.field10717 = this.field10718 ? this.field10716 : var3;
      if (!this.field10718) {
         this.field10716 = var3;
         this.field10718 = true;
      } else if (this.method04835(mc.player.getBoundingBox())) {
         this.field10716 = var3;
      } else if (var3 > this.field10716 && this.method04848()) {
         this.field10716 = var3;
      } else {
         if (var1 < this.field10716 + 1.0 - field10761) {
            this.field10716 = var3;
         }
      }
   }

   private Scaffold.Nested145 method04870(Vec3 var1, Vec3 var2) {
      if (this.field10710 != null && this.method04858(this.field10710) && this.method04843(this.field10710)) {
         Scaffold.Nested145 var3 = this.method04841(this.field10710, var1, var2);
         if (var3 != null) {
            return var3;
         }
      }

      int var8 = Math.min(this.field10706.size(), 6);

      for (int var4 = 0; var4 < var8; var4++) {
         Scaffold.Nested146 var5 = this.field10706.get(var4);
         Scaffold.Nested145 var6 = this.method04841(var5.pos(), var1, var2);
         if (var6 != null) {
            return var6;
         }

         Scaffold.Nested145 var7 = this.method04834(var5.pos(), var1, var2);
         if (var7 != null) {
            return var7;
         }
      }

      return null;
   }

   private boolean method04871(AABB var1) {
      int var2 = Mth.floor(var1.minX + field10762);
      int var3 = Mth.floor(var1.maxX - field10763);
      int var4 = Mth.floor(var1.minZ + field10764);
      int var5 = Mth.floor(var1.maxZ - field10765);

      for (int var6 = var2; var6 <= var3; var6++) {
         for (int var7 = var4; var7 <= var5; var7++) {
            BlockPos var8 = new BlockPos(var6, this.field10716, var7);
            BlockState var9 = mc.level.getBlockState(var8);
            if (!var9.canBeReplaced() && !var9.getCollisionShape(mc.level, var8).isEmpty()) {
               return true;
            }
         }
      }

      return false;
   }

   private void method04872() {
      if (this.field10727 > 0) {
         this.field10727--;
      }

      if (this.field10708 != null) {
         this.field10730 = 0;
      } else if (this.field10709 != null) {
         this.field10730++;
      } else {
         this.field10730 = 3;
      }

      boolean var1 = mc.player.onGround() && mc.player.tickCount - this.field10728 <= 1;
      boolean var2 = this.field10708 != null && mc.player.tickCount - this.field10729 > 1 || var1 || this.field10730 <= 2;
      if (this.field10720 && !var2 && this.field10666.method05999() && !this.method04848() && mc.player.onGround()) {
         this.field10727 = 3;
      }

      this.field10721 = this.field10727 > 0 && mc.player.onGround();
      this.field10732 = !var2 && this.field10666.method05999() && !mc.player.onGround() && !this.field10706.isEmpty() && this.field10719 <= 1;
   }

   private Vec3 method04873() {
      return this.method04842(this.field10715);
   }

   private Vec3 method04874(AABB var1, Direction var2, Vec3 var3) {
      double var4 = Math.min(field10796, (var1.maxX - var1.minX) * field10797);
      double var6 = Math.min(field10798, (var1.maxY - var1.minY) * field10799);
      double var8 = Math.min(field10800, (var1.maxZ - var1.minZ) * field10801);
      double var10 = Mth.clamp(var3.x, var1.minX + var4, var1.maxX - var4);
      double var12 = Mth.clamp(var3.y, var1.minY + var6, var1.maxY - var6);
      double var14 = Mth.clamp(var3.z, var1.minZ + var8, var1.maxZ - var8);
      var10 += ((var1.minX + var1.maxX) * field10802 - var10) * field10803;
      var12 += ((var1.minY + var1.maxY) * field10804 - var12) * field10805;
      var14 += ((var1.minZ + var1.maxZ) * field10806 - var14) * field10807;
      if (var2.getStepY() == 0 && var3.y > var1.maxY) {
         var12 = (var1.minY + var1.maxY) * field10808;
      }

      if (var2.getStepY() > 0) {
         var12 = var1.maxY;
      }

      if (var2.getStepY() < 0) {
         var12 = var1.minY;
      }

      if (var2.getStepX() > 0) {
         var10 = var1.maxX;
      }

      if (var2.getStepX() < 0) {
         var10 = var1.minX;
      }

      if (var2.getStepZ() > 0) {
         var14 = var1.maxZ;
      }

      if (var2.getStepZ() < 0) {
         var14 = var1.minZ;
      }

      return new Vec3(var10, var12, var14);
   }

   private AABB method04875(Vec3 var1) {
      return new AABB(var1.x - field10768, var1.y, var1.z - field10769, var1.x + field10770, var1.y + field10771, var1.z + field10772);
   }

   private boolean method04876() {
      return this.field10719 <= 0 && !mc.player.onGround() && !this.method04835(mc.player.getBoundingBox());
   }

   private int method04877(double var1) {
      return Mth.floor(var1) - 1;
   }

   private void method04878(BlockPos var1) {
      for (int var2 = 0; var2 < this.field10706.size(); var2++) {
         if (this.field10706.get(var2).pos().equals(var1)) {
            this.field10706.remove(var2);
            return;
         }
      }
   }

   private Vec3 method04879() {
      return this.method04840(this.field10713);
   }

   @Subscribe
   private void method04880(Render3DEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (!this.field10670.method05999()) {
            this.field10707.clear();
         } else {
            PoseStack var2 = var1.method00996();
            Camera var3 = var1.method00994();
            Frustum var4 = var1.method00986();
            WorldVertexCollector var5 = var1.method00985();
            Scaffold.Nested145 var6 = this.field10709;
            if (var6 != null) {
               WorldBoxRenderer.method06958(
                  this.method04853(var6.target(), field10813), var2, var3, var4, var5, ColorUtils.method04616(field10705, 70)
               );
            }

            long var7 = System.currentTimeMillis();

            for (int var9 = this.field10707.size() - 1; var9 >= 0; var9--) {
               Scaffold.Nested144 var10 = this.field10707.get(var9);
               float var11 = (float)(var7 - var10.start()) / field10814;
               if (var11 >= 1.0F) {
                  this.field10707.remove(var9);
               } else {
                  WorldBoxRenderer.method06958(
                     this.method04853(var10.pos(), field10815 + field10816 * var11),
                     var2,
                     var3,
                     var4,
                     var5,
                     ColorUtils.method04616(field10704, (int)((1.0F - var11) * field10817))
                  );
               }
            }
         }
      }
   }

   private void method04881(Vector2f var1) {
      int var2 = this.method04867();
      boolean var3 = !RotationManager.method06562(var2);
      RotationManager.method06547(new Rotation(var1.x, var1.y), field10811, var2, false);
      if (var3) {
         this.field10725 = var2;
         this.field10726 = mc.player.tickCount;
         this.field10722 = true;
      }
   }

   @Override
   public void method00276() {
      super.method00276();
      this.method04884();
   }

   private boolean method04882() {
      if (mc.player.tickCount - this.field10726 > 8) {
         return false;
      } else if (RotationManager.method06562(this.field10725)) {
         return false;
      } else {
         return this.field10722 ? true : Math.abs(Mth.wrapDegrees(mc.player.getYRot() - FreeLookController.method10131())) > 1.0F;
      }
   }

   private Vector2f method04883(Vec3 var1, Vec3 var2, Vector2f var3, BlockPos var4, Direction var5) {
      float var6 = FreeLookController.method10131();
      float var7 = Mth.wrapDegrees(var6 + Math.round(Mth.wrapDegrees(var3.x - var6) / field10787) * field10788);
      var7 = Mth.wrapDegrees(var7 + GuiHitTestUtils.method05613(field10789, field10790));
      double var8 = Math.toRadians(var7);
      double var10 = -Math.sin(var8);
      double var12 = Math.cos(var8);
      double var14;
      if (var5.getStepX() != 0) {
         if (Math.abs(var10) < field10791) {
            return null;
         }

         var14 = (var2.x - var1.x) / var10;
      } else if (var5.getStepZ() != 0) {
         if (Math.abs(var12) < field10792) {
            return null;
         }

         var14 = (var2.z - var1.z) / var12;
      } else {
         var14 = Math.hypot(var2.x - var1.x, var2.z - var1.z);
      }

      if (var14 <= field10793) {
         return null;
      }

      float var16 = (float)(-Math.toDegrees(Math.atan2(var2.y - var1.y, var14)));
      Vector2f var17 = new Vector2f(var7, Mth.clamp(var16, field10794, field10795));
      return this.method04847(var1, var2, var17, var4, var5) ? var17 : null;
   }

   private void method04884() {
      this.field10706.clear();
      this.field10708 = null;
      this.field10709 = null;
      this.field10710 = null;
      this.field10711 = null;
      this.field10712 = null;
      this.field10713 = null;
      this.field10714 = null;
      this.field10715 = null;
      this.field10731 = 0;
      this.field10718 = false;
      this.field10720 = false;
      this.field10721 = false;
      this.field10722 = false;
      this.field10723 = 0;
      this.field10724 = -100;
      this.field10725 = 0;
      this.field10726 = -100;
      this.field10727 = 0;
      this.field10728 = -100;
      this.field10729 = -100;
      this.field10730 = 0;
      this.field10719 = field10823;
      this.field10738 = 0;
      this.field10739 = 0;
      this.field10740 = -100;
      this.field10741 = null;
   }

   // $VF: Compiled from s
   private record Nested144(BlockPos pos, long start) {
   }

   // $VF: Compiled from s
   private record Nested145(BlockPos target, BlockPos support, Direction face, Vec3 aim, Vector2f rotation) {
   }

   // $VF: Compiled from s
   private record Nested146(BlockPos pos, int deadline, double distance) {
   }
}
