// Original binary: sg/mx/DLf7l72Ox6O3pVHP
package sg.mx;

import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.ContainerInput;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.ContainerClickEvent;
import sg.ec.MultiPlayerGameModeHooks;
import sg.ec.StopUsingItemEvent;
import sg.ec.BlockBreakStartEvent;
import sg.ec.AttackEntityEvent;

// $VF: Compiled from s
@Mixin(MultiPlayerGameMode.class)
public abstract class MultiPlayerGameModeMixin {
   @Inject(method = "startDestroyBlock", at = @At("HEAD"))
   private void onStartDestroyBlock(BlockPos var1, Direction var2, CallbackInfoReturnable<Boolean> var3) {
      BlockBreakStartEvent.field19164.method08304(var1, var2);
   }

   @Inject(method = "attack", at = @At("HEAD"), cancellable = true)
   public void attackEntityPre(Player var1, Entity var2, CallbackInfo var3) {
      if (var2 != var1 && var2.getId() != var1.getId()) {
         AttackEntityEvent.field21423.method09433(var2, var3);
      } else {
         var3.cancel();
      }
   }

   @Inject(method = "handleContainerInput", at = @At("HEAD"), cancellable = true)
   private void onClickSlot(int var1, int var2, int var3, ContainerInput var4, Player var5, CallbackInfo var6) {
      ContainerClickEvent.field08467.method03769(var1, var2, var3, var4, var5, var6);
   }

   @Inject(method = "attack", at = @At("TAIL"))
   public void attackEntityPost(Player var1, Entity var2, CallbackInfo var3) {
      AttackEntityEvent.field21423.method09430(var2);
   }

   @Inject(method = "releaseUsingItem", at = @At("HEAD"), cancellable = true)
   private void stopUsingItem(Player var1, CallbackInfo var2) {
      StopUsingItemEvent.field18897.method08032(var1, var2);
   }

   @Inject(method = "useItem", at = @At("HEAD"), cancellable = true)
   private void onUseItem(Player var1, InteractionHand var2, CallbackInfoReturnable<InteractionResult> var3) {
      MultiPlayerGameModeHooks.method04003(var1, var2, var3);
   }
}
