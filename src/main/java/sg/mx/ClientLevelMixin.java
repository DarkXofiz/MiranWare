// Original binary: sg/mx/UtXH2EjZpoyushXt
package sg.mx;

import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.resources.sounds.SimpleSoundInstance;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.state.BlockState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.Redirect;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import sg.ec.BotClientLevel;
import sg.ec.BlockUpdateEvent;
import sg.ec.WorldSoundEvent;
import sg.ec.WorldTimeTickEvent;

// $VF: Compiled from s
@Mixin(ClientLevel.class)
public abstract class ClientLevelMixin {
   @Inject(method = "tickTime", at = @At("HEAD"), cancellable = true)
   private void tickTime(CallbackInfo var1) {
      WorldTimeTickEvent.field22027.method09736((ClientLevel)(Object)this, var1);
   }

   @Redirect(
      method = "playSound",
      at = @At(
         value = "NEW",
         target = "(Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFLnet/minecraft/util/RandomSource;DDD)Lnet/minecraft/client/resources/sounds/SimpleSoundInstance;"
      )
   )
   private SimpleSoundInstance onPlaySounds(
      SoundEvent var1, SoundSource var2, float var3, float var4, RandomSource var5, double var6, double var8, double var10
   ) {
      return WorldSoundEvent.field20209.method08879(WorldSoundEvent.Nested247.method08882(var1), var1, var2, var3, var4, var5, var6, var8, var10);
   }

   @Inject(method = "setServerVerifiedBlockState", at = @At("TAIL"))
   private void onHandleBlockUpdateTail(BlockPos var1, BlockState var2, int var3, CallbackInfo var4) {
      if (!((Object)this instanceof BotClientLevel)) {
         BlockUpdateEvent.field14952.method06655(var1, var2);
      }
   }
}
