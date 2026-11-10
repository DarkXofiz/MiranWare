// Original binary: sg/ec/IKBCuhwz2Rnxxrbl
package sg.ec;

import com.mojang.blaze3d.vertex.VertexConsumer;
import it.unimi.dsi.fastutil.objects.Reference2IntMap;
import net.minecraft.client.Minecraft;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

// $VF: Compiled from s
public final class BlockEspWorldRenderer {
   public static void method03878(Render3DEvent var0) {
      Minecraft var1 = Minecraft.getInstance();
      if (var1.player != null && var1.level != null) {
         BlockESP sx = ModuleManager.INSTANCE.method08249();
         Reference2IntMap sxx = sx.method03407().method11177();
         if (!sxx.isEmpty()) {
            VertexConsumer sxxx = var0.method00985().method07407(EffectRenderPipelines.method05562());
            Matrix4f sxxxx = var0.method00996().last().pose();
            Vec3 sxxxxx = var0.method00994().position();
            float sxxxxxx = var0.method00984().getGameTimeDeltaPartialTick(true);
            ChunkPos sxxxxxxx = var1.player.chunkPosition();
            int sxxxxxxxx = BlockESP.method03406();

            for (Entity sxxxxxxxxx : var1.level.entitiesForRendering()) {
               int sxxxxxxxxxx = sxx.getInt(sxxxxxxxxx.getType());
               if (sxxxxxxxxxx != 0) {
                  ChunkPos sxxxxxxxxxxx = sxxxxxxxxx.chunkPosition();
                  if (Math.abs(sxxxxxxxxxxx.x - sxxxxxxx.x) <= sxxxxxxxx && Math.abs(sxxxxxxxxxxx.z - sxxxxxxx.z) <= sxxxxxxxx) {
                     Vec3 sxxxxxxxxxxxx = sxxxxxxxxx.getPosition(sxxxxxx).subtract(sxxxxxxxxx.position());
                     WorldLineRenderer.method06535(sxxx, sxxxx, sxxxxx, sxxxxxxxxx.getBoundingBox().move(sxxxxxxxxxxxx), sxxxxxxxxxx, 1.0F);
                  }
               }
            }
         }
      }
   }

   private BlockEspWorldRenderer() {
   }
}
