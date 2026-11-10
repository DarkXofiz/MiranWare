// Original binary: sg/mx/hzWl6ckL14UusceR
package sg.mx;

import hex.api.baritone.utils.accessor.IChunkArray;
import java.util.concurrent.atomic.AtomicReferenceArray;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.chunk.LevelChunk;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;

// $VF: Compiled from s
@Mixin(targets = "net.minecraft.client.multiplayer.ClientChunkCache$Storage")
public abstract class ClientChunkCache$StorageMixin implements IChunkArray {
   @Final
   @Shadow
   AtomicReferenceArray<LevelChunk> chunks;
   @Final
   @Shadow
   int chunkRadius;
   @Final
   @Shadow
   private int viewRange;
   @Shadow
   int viewCenterX;
   @Shadow
   int viewCenterZ;
   @Shadow
   int chunkCount;
   private static final String field28034 = "field28034";

   @Shadow
   abstract boolean inRange(int var1, int var2);

   @Shadow
   abstract int getIndex(int var1, int var2);

   @Shadow
   protected abstract void replace(int var1, LevelChunk var2);

   @Override
   public int centerX() {
      return this.viewCenterX;
   }

   @Override
   public int centerZ() {
      return this.viewCenterZ;
   }

   @Override
   public int viewDistance() {
      return this.chunkRadius;
   }

   @Override
   public AtomicReferenceArray<LevelChunk> getChunks() {
      return this.chunks;
   }

   @Override
   public void copyFrom(IChunkArray var1) {
      this.viewCenterX = var1.centerX();
      this.viewCenterZ = var1.centerZ();
      AtomicReferenceArray var2 = var1.getChunks();

      for (int var3 = 0; var3 < var2.length(); var3++) {
         LevelChunk var4 = (LevelChunk) var2.get(var3);
         if (var4 != null) {
            ChunkPos var5 = var4.getPos();
            if (this.inRange(var5.x, var5.z)) {
               int var6 = this.getIndex(var5.x, var5.z);
               if (this.chunks.get(var6) != null) {
                  throw new IllegalStateException(field28034);
               }

               this.replace(var6, var4);
            }
         }
      }
   }

}
