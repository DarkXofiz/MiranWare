// Original binary: hex/api/baritone/utils/player/BaritonePlayerController
package hex.api.baritone.utils.player;

import hex.api.baritone.api.utils.IPlayerController;
import hex.api.baritone.utils.accessor.IPlayerControllerMP;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.level.GameType;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.BlockHitResult;

// $VF: Compiled from s
public final class BaritonePlayerController implements IPlayerController {
   private final Minecraft mc;

   @Override
   public void windowClick(int var1, int var2, int var3, ContainerInput var4, Player var5) {
      this.mc.gameMode.handleContainerInput(var1, var2, var3, var4, var5);
   }

   public BaritonePlayerController(Minecraft var1) {
      this.mc = var1;
   }

   @Override
   public boolean onPlayerDamageBlock(BlockPos var1, Direction var2) {
      return this.mc.gameMode.continueDestroyBlock(var1, var2);
   }

   @Override
   public void setDestroyDelay(int var1) {
      ((IPlayerControllerMP)this.mc.gameMode).setDestroyDelay(var1);
   }

   @Override
   public void syncHeldItem() {
      ((IPlayerControllerMP)this.mc.gameMode).callSyncCurrentPlayItem();
   }

   @Override
   public boolean clickBlock(BlockPos var1, Direction var2) {
      return this.mc.gameMode.startDestroyBlock(var1, var2);
   }

   @Override
   public InteractionResult processRightClickBlock(LocalPlayer var1, Level var2, InteractionHand var3, BlockHitResult var4) {
      return this.mc.gameMode.useItemOn(var1, var3, var4);
   }

   @Override
   public void setHittingBlock(boolean var1) {
      ((IPlayerControllerMP)this.mc.gameMode).setIsHittingBlock(var1);
   }

   @Override
   public void resetBlockRemoving() {
      this.mc.gameMode.stopDestroyBlock();
   }

   @Override
   public InteractionResult processRightClick(LocalPlayer var1, Level var2, InteractionHand var3) {
      return this.mc.gameMode.useItem(var1, var3);
   }

   @Override
   public boolean hasBrokenBlock() {
      return !((IPlayerControllerMP)this.mc.gameMode).isHittingBlock();
   }

   @Override
   public GameType getGameType() {
      return this.mc.gameMode.getPlayerMode();
   }
}
