// Original binary: hex/api/baritone/utils/BlockBreakHelper
package hex.api.baritone.utils;

import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.utils.IPlayerContext;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.HitResult.Type;

// $VF: Compiled from s
public final class BlockBreakHelper {
   private static final int BASE_BREAK_DELAY = 1;
   private final IPlayerContext ctx;
   private boolean wasHitting;
   private int breakDelayTimer = 0;

   public void stopBreakingBlock() {
      if (this.ctx.player() != null && this.wasHitting) {
         this.ctx.playerController().setHittingBlock(false);
         this.ctx.playerController().resetBlockRemoving();
         this.wasHitting = false;
      }
   }

   public boolean isBreaking() {
      return this.wasHitting;
   }

   BlockBreakHelper(IPlayerContext var1) {
      this.ctx = var1;
   }

   public void tick(boolean var1) {
      if (this.breakDelayTimer > 0) {
         this.breakDelayTimer--;
      } else {
         HitResult var2 = this.ctx.objectMouseOver();
         boolean sx = var2 != null && var2.getType() == Type.BLOCK;
         if (var1 && sx) {
            this.ctx.playerController().setHittingBlock(this.wasHitting);
            if (this.ctx.playerController().hasBrokenBlock()) {
               this.ctx.playerController().syncHeldItem();
               this.ctx.playerController().clickBlock(((BlockHitResult)var2).getBlockPos(), ((BlockHitResult)var2).getDirection());
               this.ctx.player().swing(InteractionHand.MAIN_HAND);
            } else {
               if (this.ctx.playerController().onPlayerDamageBlock(((BlockHitResult)var2).getBlockPos(), ((BlockHitResult)var2).getDirection())) {
                  this.ctx.player().swing(InteractionHand.MAIN_HAND);
               }

               if (this.ctx.playerController().hasBrokenBlock()) {
                  this.breakDelayTimer = BaritoneAPI.getSettings().blockBreakSpeed.value - 1;
                  this.ctx.playerController().setDestroyDelay(0);
               }
            }

            this.wasHitting = !this.ctx.playerController().hasBrokenBlock();
            this.ctx.playerController().setHittingBlock(false);
         } else {
            this.wasHitting = false;
         }
      }
   }
}
