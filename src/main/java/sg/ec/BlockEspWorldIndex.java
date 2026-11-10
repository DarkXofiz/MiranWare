// Original binary: sg/ec/jdmsHtAXv8iP9Dzu
package sg.ec;

import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import it.unimi.dsi.fastutil.longs.LongArrayList;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.BlockPos;
import net.minecraft.core.SectionPos;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.material.LavaFluid;

// $VF: Compiled from s
public final class BlockEspWorldIndex {
   private static final int field20482 = new RgbColor(210, 10, 10).toInt();
   private static final int field20483 = 4;
   private static final LongArrayList field20484 = new LongArrayList();
   private static Long2IntOpenHashMap field20485 = new Long2IntOpenHashMap();
   private static int field20486;
   private static boolean field20487;
   private static double field20488;
   private static double field20489;

   private static void method09025(ChunkPos var0) {
      int var1 = BlockESP.method03406();
      field20484.clear();
      field20485.clear();
      field20486 = 0;
      field20487 = true;
      field20488 = SectionPos.sectionToBlockCoord(var0.x);
      field20489 = SectionPos.sectionToBlockCoord(var0.z);

      for (int sx = var0.x - var1; sx <= var0.x + var1; sx++) {
         for (int sxx = var0.z - var1; sxx <= var0.z + var1; sxx++) {
            field20484.add(ChunkPos.asLong(sx, sxx));
         }
      }
   }

   public static void method09026() {
      field20484.clear();
      field20485.clear();
      field20486 = 0;
      field20487 = false;
      BlockEspOutlineRenderer.method09160();
   }

   public static void method09027() {
      Minecraft var0 = Minecraft.getInstance();
      ClientLevel var1 = var0.level;
      if (var0.player != null && var1 != null) {
         BlockESP var2 = ModuleManager.INSTANCE.method08249();
         var var3 = var2.method03407().method11175();
         boolean var4 = var2.field07593.method03022();
         if (var3.isEmpty() && !var4) {
            method09026();
         } else {
            if (!field20487) {
               method09025(var0.player.chunkPosition());
            }

            for (int var5 = 0; var5 < 4 && field20486 < field20484.size(); var5++) {
               long var6 = field20484.getLong(field20486++);
               method09028(var1, ChunkPos.getX(var6), ChunkPos.getZ(var6), var3, var4);
            }

            if (field20486 >= field20484.size()) {
               if (BlockEspMeshWorker.method00048(field20485, field20488, 0.0, field20489)) {
                  field20485 = new Long2IntOpenHashMap();
               }

               field20487 = false;
            }
         }
      } else {
         method09026();
      }
   }

   private static void method09028(ClientLevel var0, int var1, int var2, Set<ThemeColorEntry> var3, boolean var4) {
      LevelChunk var5 = var0.getChunkSource().getChunk(var1, var2, ChunkStatus.FULL, false);
      if (var5 != null) {
         LevelChunkSection[] var6 = var5.getSections();
         int var7 = SectionPos.sectionToBlockCoord(var1);
         int var8 = SectionPos.sectionToBlockCoord(var2);

         for (int var9 = 0; var9 < var6.length; var9++) {
            LevelChunkSection var10 = var6[var9];
            if (!var10.hasOnlyAir()) {
               int var11 = SectionPos.sectionToBlockCoord(var5.getSectionYFromSectionIndex(var9));

               for (int var12 = 0; var12 < 16; var12++) {
                  for (int var13 = 0; var13 < 16; var13++) {
                     for (int var14 = 0; var14 < 16; var14++) {
                        BlockState var15 = var10.getBlockState(var14, var12, var13);
                        if (!var15.isAir()) {
                           int var16 = method09029(var15, var3, var4);
                           if (var16 != 0) {
                              field20485.put(BlockPos.asLong(var7 + var14, var11 + var12, var8 + var13), var16);
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private BlockEspWorldIndex() {
   }

   private static int method09029(BlockState var0, Set<ThemeColorEntry> var1, boolean var2) {
      if (var2 && var0.getFluidState().getType() instanceof LavaFluid) {
         return field20482;
      }

      BlockState var3 = var0.getBlock().defaultBlockState();

      for (ThemeColorEntry var5 : var1) {
         if (var5.method06792() ? var3 == var5.method06790() : var0 == var5.method06790()) {
            return var5.method06791().toInt();
         }
      }

      return 0;
   }
}
