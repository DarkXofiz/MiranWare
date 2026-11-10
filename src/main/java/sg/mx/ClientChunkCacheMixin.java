// Original binary: sg/mx/1OJNqtftLMSbsquk
package sg.mx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientChunkCache;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.LightLayer;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;
import sg.ec.BotEntityUtils;

// $VF: Compiled from s
@Mixin(ClientChunkCache.class)
public class ClientChunkCacheMixin {
   @Shadow
   @Final
   private LevelChunk emptyChunk;
   @Shadow
   @Final
   private ClientLevel level;
   private LevelChunk hex$lastChunk;

   @Inject(method = "onLightUpdate", at = @At("HEAD"), cancellable = true)
   private void hex$skipSimulatedLight(LightLayer var1, SectionPos var2, CallbackInfo var3) {
      if (BotEntityUtils.method03836(this.level)) {
         var3.cancel();
      }
   }

   @Inject(
      method = "getChunk(IILnet/minecraft/world/level/chunk/status/ChunkStatus;Z)Lnet/minecraft/world/level/chunk/LevelChunk;",
      at = @At("HEAD"),
      cancellable = true
   )
   private void hex$fastGetChunk(int var1, int var2, ChunkStatus var3, boolean var4, CallbackInfoReturnable<LevelChunk> var5) {
      LevelChunk var6 = this.hex$lastChunk;
      if (var6 != null && Minecraft.getInstance().isSameThread() && var6.getPos().x() == var1 && var6.getPos().z() == var2) {
         var5.setReturnValue(var6);
      }
   }

   @Inject(method = "getChunk(IILnet/minecraft/world/level/chunk/status/ChunkStatus;Z)Lnet/minecraft/world/level/chunk/LevelChunk;", at = @At("RETURN"))
   private void hex$storeChunk(int var1, int var2, ChunkStatus var3, boolean var4, CallbackInfoReturnable<LevelChunk> var5) {
      if (Minecraft.getInstance().isSameThread()) {
         LevelChunk var6 = (LevelChunk)var5.getReturnValue();
         if (var6 != null && var6 != this.emptyChunk) {
            this.hex$lastChunk = var6;
         }
      }
   }

   @Inject(method = {"drop", "updateViewCenter", "updateViewRadius"}, at = @At("HEAD"))
   private void hex$invalidate(CallbackInfo var1) {
      this.hex$lastChunk = null;
   }

   @Inject(method = "replaceWithPacketData", at = @At("HEAD"))
   private void hex$invalidateReplace(CallbackInfoReturnable<LevelChunk> var1) {
      this.hex$lastChunk = null;
   }
}
