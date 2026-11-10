// Original binary: hex/api/baritone/utils/player/BotBaritonePlayerController
package hex.api.baritone.utils.player;

import hex.api.baritone.api.utils.IPlayerController;
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
import sg.ec.BotClient;
import sg.ec.BotInteractionController;

// $VF: Compiled from s
public final class BotBaritonePlayerController implements IPlayerController {
   private final BotClient bot;

   @Override
   public void setDestroyDelay(int var1) {
      this.gameMode().method06247(var1);
   }

   @Override
   public void syncHeldItem() {
   }

   @Override
   public InteractionResult processRightClick(LocalPlayer var1, Level var2, InteractionHand var3) {
      this.gameMode().method06269(var3);
      return InteractionResult.SUCCESS;
   }

   @Override
   public GameType getGameType() {
      return this.bot.method00070().method07950();
   }

   @Override
   public void resetBlockRemoving() {
      this.gameMode().method06266();
   }

   @Override
   public void setHittingBlock(boolean var1) {
      this.gameMode().method06250(var1);
   }

   public BotBaritonePlayerController(BotClient var1) {
      this.bot = var1;
   }

   @Override
   public boolean clickBlock(BlockPos var1, Direction var2) {
      return this.gameMode().method06249(var1, var2);
   }

   @Override
   public void windowClick(int var1, int var2, int var3, ContainerInput var4, Player var5) {
   }

   @Override
   public InteractionResult processRightClickBlock(LocalPlayer var1, Level var2, InteractionHand var3, BlockHitResult var4) {
      this.gameMode().method06246(var4, var3);
      return InteractionResult.SUCCESS;
   }

   @Override
   public boolean hasBrokenBlock() {
      return !this.gameMode().method06255();
   }

   private BotInteractionController gameMode() {
      return this.bot.method00082();
   }

   @Override
   public boolean onPlayerDamageBlock(BlockPos var1, Direction var2) {
      return this.gameMode().method06257(var1, var2);
   }
}
