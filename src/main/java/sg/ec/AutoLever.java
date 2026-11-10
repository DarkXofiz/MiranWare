// Original binary: sg/ec/ss19JdOwvpqeqZYo
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

// $VF: Compiled from s
public class AutoLever extends ClientModule {
   private final NumberSetting<Float> field23748;
   private final NumberSetting<Float> field23749;
   private final ElapsedTimer field23750;
   private BlockPos field23751;
   private boolean field23752;
   int field23753;
   private static final String field23754 = "Скорость в секундах. 1 раз";
   private static final float field23755 = 0.1F;
   private static final float field23756 = 30.0F;
   private static final float field23757 = 0.1F;
   private static final float field23758 = 6.0F;
   private static final String field23759 = "Скорость в секундах. 2 раз";
   private static final float field23760 = 0.1F;
   private static final float field23761 = 30.0F;
   private static final float field23762 = 0.1F;
   private static final float field23763 = 25.0F;
   private static final String field23764 = "Auto Lever";
   private static final long field23765 = 1000L;
   private static final float field23766 = 5.0F;
   private static final float field23767 = 0.5F;
   private static final float field23768 = 0.5F;
   private static final float field23769 = 0.5F;
   private static final double field23770 = 3.0;
   private static final float field23771 = 9999.0F;
   private static final String field23772 = "Подойдите к рычагу.";

   @Subscribe
   private void method10775(PlayerUpdateEvent var1) {
      if (mc.player != null && mc.level != null) {
         this.field23751 = null;
         if (this.field23753 > 2) {
            this.field23753 = 1;
         }

         long var2 = (this.field23753 != 0 && this.field23753 != 1 ? this.field23749 : this.field23748).method03022().longValue() * field23765;
         this.field23751 = PlayerUtils.method11830(field23766, Blocks.LEVER);
         if (this.field23751 != null) {
            Vec3 sx = mc.player.getEyePosition();
            Vec3 sxx = new Vec3(this.field23751.getX() + field23767, this.field23751.getY() + field23768, this.field23751.getZ() + field23769);
            if (this.field23750.method04699(var2) && !this.field23752) {
               this.field23752 = true;
               this.field23750.method04694();
            }

            if (this.field23752) {
               this.method10777(sx, sxx);
               if (RaycastUtils.method09498(sx, sxx, Block.COLLIDER, Fluid.NONE) instanceof BlockHitResult sxxx && sx.distanceTo(sxx) <= field23770) {
                  this.method10776(sxxx);
                  this.field23753++;
                  this.field23752 = false;
               }
            }
         }
      }
   }

   public AutoLever() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field23748 = new NumberSetting<Float>(field23754)
         .method10835(field23755)
         .method10838(field23756)
         .method10834(field23757)
         .method03017(field23758)
         .method03023(this);
      this.field23749 = new NumberSetting<Float>(field23759)
         .method10835(field23760)
         .method10838(field23761)
         .method10834(field23762)
         .method03017(field23763)
         .method03023(this);
      this.field23750 = new ElapsedTimer();
      this.field23751 = null;
      this.field23752 = false;
      this.field23753 = 0;
      this.method03935(field23764);
   }

   private void method10776(BlockHitResult var1) {
      if (mc.player != null && mc.gameMode != null) {
         if (mc.gameMode.useItemOn(mc.player, InteractionHand.MAIN_HAND, var1) == InteractionResult.SUCCESS) {
            mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
         }
      }
   }

   @Override
   public void method00245() {
      this.field23750.method04694();
      this.field23751 = null;
      this.field23752 = false;
      this.field23753 = 0;
      super.method00245();
   }

   private void method10777(Vec3 var1, Vec3 var2) {
      Vector2f var3 = PlayerUtils.method11816(var1, var2);
      RotationManager.method06547(new Rotation(var3.x, var3.y), field23771, 1, false);
   }

   @Override
   public void method00276() {
      this.field23750.method04694();
      ChatTextUtils.method05086(field23772);
      this.field23753 = 0;
      this.field23752 = false;
      super.method00276();
   }
}
