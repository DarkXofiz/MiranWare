// Original binary: sg/ec/so3icAETCFCLYFL0
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ServerboundUseItemPacket;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import sg.mx.MultiPlayerGameModeMixin_1262;

// $VF: Compiled from s
public class NoClip extends ClientModule {
   private static final String field23698 = "Вскапывание";
   private static final String field23699 = "field23699";
   private static final String field23700 = "field23700";
   private static final RgbColor field23701 = new RgbColor(255, 255, 255);
   private static final float field23702 = 0;
   private static final int field23703 = 0;
   private static final int field23704 = 0;
   private static final int field23705 = 0;
   private static final double field23706 = 0;
   private static final int field23707 = 0;
   private static final int field23708 = 0;
   private final ModeSetting field23709;
   private final ToggleSetting field23710;
   private final ToggleSetting field23711;
   private final BlockBreakManager field23712;
   private Direction field23713;
   private BlockPos field23714;
   private BlockPos field23715;
   private BlockPos field23716;
   private int field23717;
   private boolean field23718;
   private int field23719;
   private int field23720;
   private static final String field23721 = "Режим";
   private static final String field23722 = "Вскапывание";
   private static final String field23723 = "VanillaFly";
   private static final String field23724 = "Вскапывание";
   private static final String field23725 = "Прыгать перед отпусканием";
   private static final String field23726 = "ПКМ пакетом после прыжка";
   private static final String field23727 = "No Clip";
   private static final String field23728 = "VanillaFly";
   private static final String field23729 = "noclip";
   private static final double field23730 = 0.5;
   private static final double field23731 = 0.05;
   private static final String field23732 = "noclip";
   private static final String field23733 = "Вскапывание";
   private static final String field23734 = "Вскапывание";

   @Subscribe
   private void method10751(PlayerInputEvent var1) {
      if (mc.player == null || mc.level == null) {
         this.method10765();
      } else if (this.field23709.method05600(field23728)) {
         this.method10765();
         this.method10760(var1);
      } else {
         this.method10757();
         this.method10766();
         Direction var2 = this.method10763(var1);
         if (var2 == null) {
            this.method10762(var1);
         } else {
            this.method10761(var2);
            if (this.method10771()) {
               this.method10762(var1);
            } else {
               BlockPos sx = this.method10769();
               if (sx != null && this.field23712.method04893(this, sx, BlockBreakManager.Nested147.UTILITY, this.method10764(sx))) {
                  this.field23719 = 0;
                  this.field23716 = sx;
                  PacketBufferManager.INSTNCE.method03604(field23729);
                  RotationManager.field14787 = true;
               } else {
                  this.method10762(var1);
               }
            }
         }
      }
   }

   private boolean method10752(BlockPos var1) {
      return mc.level.getBlockState(var1).isAir();
   }

   private void method10754() {
      MultiPlayerGameModeMixin_1262 var1 = (MultiPlayerGameModeMixin_1262)(Object)mc.gameMode;
      var1.hookEnsureHasSentCarriedItem();
      var1.sendSequencedPacketAccessor(
         mc.level, var0 -> new ServerboundUseItemPacket(InteractionHand.MAIN_HAND, var0, RotationManager.method06563(), RotationManager.method06557())
      );
   }

   @Override
   public void method00245() {
      this.method10765();
      super.method00245();
   }

   private void method10757() {
      if (this.field23719 > 0 && --this.field23719 == 0) {
         this.method10759();
      }
   }

   private BlockPos method10758(int var1) {
      return switch (var1) {
         case 0 -> this.field23714.above();
         case 2 -> this.field23714.below();
         default -> this.field23714;
      };
   }

   private void method10759() {
      this.field23719 = 0;
      PacketBufferManager.INSTNCE.method03606(field23732);
   }

   public void method10760(PlayerInputEvent var1) {
      NoClipMovementController.INSTANCE.method06467(var1, new Rotation(FreeLookController.method10131(), FreeLookController.method10134()));
   }

   private void method10761(Direction var1) {
      BlockPos var2 = mc.player.blockPosition().relative(var1);
      if (var1 != this.field23713 || !var2.equals(this.field23714)) {
         this.field23713 = var1;
         this.field23714 = var2;
         this.field23717 = this.method10768() ? 0 : 1;
         this.field23718 = false;
      }
   }

   private void method10762(PlayerInputEvent var1) {
      if (this.field23714 != null) {
         boolean var2 = this.field23710.method05999() && this.method10768() && mc.player.onGround();
         this.method10767();
         var1.method11173(true);
         if (this.field23711.method05999()) {
            this.field23720 = 1;
         }

         if (!var2) {
            this.method10759();
         } else {
            this.field23719 = 1;
         }
      }
   }

   private Direction method10763(PlayerInputEvent var1) {
      if (var1.method11162() != var1.method11160()) {
         return var1.method11162() ? Direction.UP : Direction.DOWN;
      } else {
         float var2 = var1.method11161();
         float var3 = var1.method11166();
         if (var2 == 0.0F && var3 == 0.0F) {
            return null;
         } else {
            Direction var4 = Direction.fromYRot(Rotation.method09442().method09439());
            if (var2 > 0.0F) {
               return var4;
            } else if (var2 < 0.0F) {
               return var4.getOpposite();
            } else {
               return var3 > 0.0F ? var4.getCounterClockWise() : var4.getClockWise();
            }
         }
      }
   }

   private Vec3 method10764(BlockPos var1) {
      if (!this.method10768()) {
         return null;
      }

      Vec3 var2 = Vec3.atBottomCenterOf(this.field23714.above()).relative(this.field23713.getOpposite(), field23730).add(0.0, field23731, 0.0);
      Vec3 var3 = mc.player.getEyePosition();
      Vec3 var4 = var3.add(var2.subtract(var3).normalize().scale(mc.player.blockInteractionRange()));
      return new AABB(var1).clip(var3, var4).isPresent() ? var2 : null;
   }

   private void method10765() {
      this.method10767();
      this.method10759();
      this.field23720 = 0;
   }

   private void method10766() {
      if (this.field23720 > 0 && --this.field23720 == 0) {
         this.method10754();
      }
   }

   private void method10767() {
      if (this.field23714 != null) {
         this.field23712.method04904(this);
         this.field23714 = null;
         this.field23715 = null;
         this.field23716 = null;
         this.field23717 = 1;
         this.field23718 = false;
      }
   }

   private boolean method10768() {
      return this.field23713.getAxis().isHorizontal();
   }

   private BlockPos method10769() {
      int var1 = this.method10768() ? 2 : 1;
      if (!this.field23718) {
         if (this.method10752(this.method10758(1))) {
            return null;
         }

         this.field23718 = true;
      }

      for (; this.field23717 <= var1; this.field23717++) {
         BlockPos var2 = this.method10758(this.field23717);
         if (!this.method10752(var2)) {
            return var2;
         }

         if (this.field23717 == 1 && var1 != 1) {
            this.field23715 = this.field23714;
         }
      }

      return null;
   }

   @Subscribe
   private void method10770(Render3DEvent var1) {
      BlockPos var2 = this.field23716;
      if (var2 != null) {
         PoseStack var3 = var1.method00996();
         Vec3 var4 = var1.method00994().position();
         WorldLineRenderer.method06534(
            var1.method00985().method07407(EffectRenderPipelines.method05562()),
            var3.last().pose(),
            var4,
            new ColoredBlockPos(var2, field23701),
            var1.method00986(),
            1.0F
         );
      }
   }

   private boolean method10771() {
      return this.method10768() && mc.player.blockPosition().equals(this.field23715);
   }

   public NoClip() {
      super(ModuleCategory.Movement, ModuleSubCategory.Other);
      this.field23709 = new ModeSetting(field23721).method05597(field23722, field23723).method03017(field23724).method03023(this);
      this.field23710 = new ToggleSetting(field23725).method03014(false).method03025(() -> this.field23709.method05600(field23734)).method03023(this);
      this.field23711 = new ToggleSetting(field23726).method03014(false).method03025(() -> this.field23709.method05600(field23733)).method03023(this);
      this.field23712 = BlockBreakManager.INSTANCE;
      this.field23713 = Direction.UP;
      this.method03935(field23727);
   }
}
