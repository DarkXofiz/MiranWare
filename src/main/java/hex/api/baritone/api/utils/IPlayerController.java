// Original binary: hex/api/baritone/api/utils/IPlayerController
package hex.api.baritone.api.utils;

import hex.api.baritone.api.BaritoneAPI;
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
public interface IPlayerController {
   void setDestroyDelay(int var1);

   void syncHeldItem();

   void setHittingBlock(boolean var1);

   default double getBlockReachDistance() {
      return this.getGameType().isCreative() ? 5.0 : BaritoneAPI.getSettings().blockReachDistance.value.floatValue();
   }

   boolean hasBrokenBlock();

   boolean clickBlock(BlockPos var1, Direction var2);

   void windowClick(int var1, int var2, int var3, ContainerInput var4, Player var5);

   void resetBlockRemoving();

   InteractionResult processRightClickBlock(LocalPlayer var1, Level var2, InteractionHand var3, BlockHitResult var4);

   GameType getGameType();

   boolean onPlayerDamageBlock(BlockPos var1, Direction var2);

   InteractionResult processRightClick(LocalPlayer var1, Level var2, InteractionHand var3);
}
