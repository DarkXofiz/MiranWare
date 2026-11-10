// Original binary: sg/mx/gxWnUaz7UiAd6xbr
package sg.mx;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.multiplayer.prediction.PredictiveAction;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(MultiPlayerGameMode.class)
public interface MultiPlayerGameModeMixin_1262 {
   @Invoker("startPrediction")
   void sendSequencedPacketAccessor(ClientLevel var1, PredictiveAction var2);

   @Invoker("ensureHasSentCarriedItem")
   void hookEnsureHasSentCarriedItem();

   @Accessor("destroyProgress")
   float getDestroyProgress();

   @Accessor("destroyProgress")
   void setDestroyProgress(float var1);

   @Accessor("destroyBlockPos")
   BlockPos getDestroyBlockPos();

   @Accessor("destroyBlockPos")
   void setDestroyBlockPos(BlockPos var1);

   @Accessor("destroyingItem")
   void setDestroyingItem(ItemStack var1);

   @Accessor("destroyingItem")
   ItemStack getDestroyingItem();

   @Accessor("destroyDelay")
   int getDestroyDelay();

   @Accessor("isDestroying")
   boolean getIsDestroying();
}
