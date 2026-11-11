// Original binary: sg/mx/hNlrQtWAsCd4jzTx
package sg.mx;

import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.renderer.LevelEventHandler;
import net.minecraft.core.BlockPos;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.phys.Vec3;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Redirect;
import sg.ec.WorldSoundEvent;

// $VF: Compiled from s
@Mixin(LevelEventHandler.class)
public abstract class LevelEventHandlerMixin {
   private static final int EXPERIENCE_BOTTLE_EVENT = 2002;
   private static final int EXPERIENCE_BOTTLE_COLOR = -13083194;
   private static final int field28033 = -13083194;

   @WrapOperation(
      method = "levelEvent",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/client/multiplayer/ClientLevel;playLocalSound(Lnet/minecraft/core/BlockPos;Lnet/minecraft/sounds/SoundEvent;Lnet/minecraft/sounds/SoundSource;FFZ)V"
      )
   )
   private void redirectExperienceBottleSound(
      ClientLevel var1, BlockPos var2, SoundEvent var3, SoundSource var4, float var5, float var6, boolean var7, int var8, BlockPos var9, int var10, Operation<Void> hex$original) {
      if (var8 == 2002 && var10 == field28033 && var3.equals(SoundEvents.SPLASH_POTION_BREAK)) {
         var5 = WorldSoundEvent.field20209.method08875(WorldSoundEvent.Nested247.EXPERIENCE_BOTTLE, var5, Vec3.atCenterOf(var2));
      }

      var1.playLocalSound(var2, var3, var4, var5, var6, var7);
   }

}
