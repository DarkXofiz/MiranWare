// Original binary: sg/ec/uOmHILBOzcJBT5w0
package sg.ec;

import it.unimi.dsi.fastutil.objects.Object2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.objects.Reference2ObjectOpenHashMap;
import java.util.Arrays;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.SectionPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.chunk.LevelChunk;
import net.minecraft.world.level.chunk.LevelChunkSection;
import net.minecraft.world.level.chunk.status.ChunkStatus;
import net.minecraft.world.level.levelgen.Heightmap.Types;

// $VF: Compiled from s
final class ScriptBlockQuery implements MinecraftAccess {
   private static final int[] field24593 = new int[0];
   private static final int field24594 = 256;
   private static final int field24595 = 0;
   private final MutableBlockPos field24596 = new MutableBlockPos();
   private final Reference2ObjectOpenHashMap<Block, String> field24597 = new Reference2ObjectOpenHashMap();
   private final Object2ObjectOpenHashMap<String, Block> field24598 = new Object2ObjectOpenHashMap();
   private int[] field24599 = field24593;
   private static final int field24600 = 65536;

   int[] method10953(int var1, int var2, int var3, int var4, String var5, int var6) {
      ClientLevel var7 = mc.level;
      Block sx = this.method10961(var5);
      int sxx = Math.min(var6, field24600);
      if (var7 != null && sx != null && sxx > 0) {
         int sxxx = var4 < 0 ? 0 : Math.min(var4, 64);
         int sxxxx = var1 - sxxx;
         int sxxxxx = var1 + sxxx;
         int sxxxxxx = var3 - sxxx;
         int sxxxxxxx = var3 + sxxx;
         int sxxxxxxxx = Math.max(var7.getMinY(), var2 - sxxx);
         int sxxxxxxxxx = Math.min(var7.getMaxY(), var2 + sxxx);
         if (sxxxxxxxx > sxxxxxxxxx) {
            return field24593;
         }

         int sxxxxxxxxxx = 0;

         for (int sxxxxxxxxxxx = SectionPos.blockToSectionCoord(sxxxx); sxxxxxxxxxxx <= SectionPos.blockToSectionCoord(sxxxxx); sxxxxxxxxxxx++) {
            int sxxxxxxxxxxxx = SectionPos.sectionToBlockCoord(sxxxxxxxxxxx);
            int sxxxxxxxxxxxxx = Math.max(sxxxx, sxxxxxxxxxxxx);
            int sxxxxxxxxxxxxxx = Math.min(sxxxxx, sxxxxxxxxxxxx + 15);

            for (int sxxxxxxxxxxxxxxx = SectionPos.blockToSectionCoord(sxxxxxx);
               sxxxxxxxxxxxxxxx <= SectionPos.blockToSectionCoord(sxxxxxxx);
               sxxxxxxxxxxxxxxx++
            ) {
               LevelChunk sxxxxxxxxxxxxxxxx = var7.getChunkSource().getChunk(sxxxxxxxxxxx, sxxxxxxxxxxxxxxx, ChunkStatus.FULL, false);
               if (sxxxxxxxxxxxxxxxx != null) {
                  int sxxxxxxxxxxxxxxxxx = SectionPos.sectionToBlockCoord(sxxxxxxxxxxxxxxx);
                  int sxxxxxxxxxxxxxxxxxx = Math.max(sxxxxxx, sxxxxxxxxxxxxxxxxx);
                  int sxxxxxxxxxxxxxxxxxxx = Math.min(sxxxxxxx, sxxxxxxxxxxxxxxxxx + 15);
                  LevelChunkSection[] sxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxx.getSections();
                  int sxxxxxxxxxxxxxxxxxxxxx = Math.max(0, sxxxxxxxxxxxxxxxx.getSectionIndex(sxxxxxxxx));
                  int sxxxxxxxxxxxxxxxxxxxxxx = Math.min(sxxxxxxxxxxxxxxxxxxxx.length - 1, sxxxxxxxxxxxxxxxx.getSectionIndex(sxxxxxxxxx));

                  for (int sxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxx; sxxxxxxxxxxxxxxxxxxxxxxx <= sxxxxxxxxxxxxxxxxxxxxxx; sxxxxxxxxxxxxxxxxxxxxxxx++) {
                     LevelChunkSection sxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxx[sxxxxxxxxxxxxxxxxxxxxxxx];
                     if (sxxxxxxxxxxxxxxxxxxxxxxxx != null && !sxxxxxxxxxxxxxxxxxxxxxxxx.hasOnlyAir()) {
                        int sxxxxxxxxxxxxxxxxxxxxxxxxx = SectionPos.sectionToBlockCoord(sxxxxxxxxxxxxxxxx.getSectionYFromSectionIndex(sxxxxxxxxxxxxxxxxxxxxxxx));
                        int sxxxxxxxxxxxxxxxxxxxxxxxxxx = Math.max(sxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxxxxx);
                        int sxxxxxxxxxxxxxxxxxxxxxxxxxxx = Math.min(sxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxxxxx + 15);

                        for (int sxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxxxxxxxxxx <= sxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                           sxxxxxxxxxxxxxxxxxxxxxxxxxxxx++
                        ) {
                           for (int sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxx;
                              sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx <= sxxxxxxxxxxxxxxxxxxx;
                              sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx++
                           ) {
                              for (int sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxx;
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx <= sxxxxxxxxxxxxxx;
                                 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx++
                              ) {
                                 if (sxxxxxxxxxxxxxxxxxxxxxxxx.getBlockState(
                                          sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx & 15, sxxxxxxxxxxxxxxxxxxxxxxxxxxxx & 15, sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx & 15
                                       )
                                       .getBlock()
                                    == sx) {
                                    int sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxx * 3;
                                    this.method10954(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx + 3);
                                    this.field24599[sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx] = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                                    this.field24599[sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx + 1] = sxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                                    this.field24599[sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx + 2] = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx;
                                    if (++sxxxxxxxxxx >= sxx) {
                                       return sxxxxxxxxxx == 0 ? field24593 : Arrays.copyOf(this.field24599, sxxxxxxxxxx * 3);
                                    }
                                 }
                              }
                           }
                        }
                     }
                  }
               }
            }
         }

         return sxxxxxxxxxx == 0 ? field24593 : Arrays.copyOf(this.field24599, sxxxxxxxxxx * 3);
      } else {
         return field24593;
      }
   }

   private void method10954(int var1) {
      if (this.field24599.length < var1) {
         int var2 = Math.max(768, this.field24599.length * 2);

         while (var2 < var1) {
            var2 *= 2;
         }

         this.field24599 = Arrays.copyOf(this.field24599, var2);
      }
   }

   private boolean method10955(BlockState var1, int var2, int var3, int var4, int var5) {
      return switch (var2) {
         case 1 -> !var1.getCollisionShape(mc.level, this.field24596.set(var3, var4, var5)).isEmpty();
         case 2 -> !var1.getFluidState().isEmpty();
         case 3 -> var1.canBeReplaced();
         default -> var1.isAir();
      };
   }

   int method10956(int var1, int var2, int var3) {
      ClientLevel var4 = mc.level;
      if (var4 == null) {
         return 0;
      } else {
         LevelChunk var5 = var4.getChunkSource().getChunk(SectionPos.blockToSectionCoord(var1), SectionPos.blockToSectionCoord(var2), ChunkStatus.FULL, false);
         if (var3 == 1) {
            return var5 == null ? 0 : 1;
         } else {
            return var5 == null ? var4.getMinY() : var5.getHeight(Types.MOTION_BLOCKING, var1 & 15, var2 & 15);
         }
      }
   }

   boolean[] method10957(int var1, int var2, int var3, int var4, int var5, boolean[] var6) {
      int var7 = var4 < 0 ? 0 : Math.min(var4, 32);
      int var8 = var7 * 2 + 1;
      int var9 = var8 * var8 * var8;
      boolean[] var10 = var6 != null && var6.length >= var9 ? var6 : new boolean[var9];
      ClientLevel var11 = mc.level;
      Arrays.fill(var10, 0, var9, var11 != null && this.method10955(Blocks.AIR.defaultBlockState(), var5, var1, var2, var3));
      if (var11 == null) {
         return var10;
      }

      int var12 = var1 - var7;
      int var13 = var2 - var7;
      int var14 = var3 - var7;
      int var15 = var1 + var7;
      int var16 = var3 + var7;
      int var17 = Math.max(var11.getMinY(), var13);
      int var18 = Math.min(var11.getMaxY(), var2 + var7);
      if (var17 > var18) {
         return var10;
      }

      for (int var19 = SectionPos.blockToSectionCoord(var12); var19 <= SectionPos.blockToSectionCoord(var15); var19++) {
         int var20 = SectionPos.sectionToBlockCoord(var19);
         int var21 = Math.max(var12, var20);
         int var22 = Math.min(var15, var20 + 15);

         for (int var23 = SectionPos.blockToSectionCoord(var14); var23 <= SectionPos.blockToSectionCoord(var16); var23++) {
            LevelChunk var24 = var11.getChunkSource().getChunk(var19, var23, ChunkStatus.FULL, false);
            if (var24 != null) {
               int var25 = SectionPos.sectionToBlockCoord(var23);
               int var26 = Math.max(var14, var25);
               int var27 = Math.min(var16, var25 + 15);
               LevelChunkSection[] var28 = var24.getSections();
               int var29 = Math.max(0, var24.getSectionIndex(var17));
               int var30 = Math.min(var28.length - 1, var24.getSectionIndex(var18));

               for (int var31 = var29; var31 <= var30; var31++) {
                  LevelChunkSection var32 = var28[var31];
                  if (var32 != null && !var32.hasOnlyAir()) {
                     int var33 = SectionPos.sectionToBlockCoord(var24.getSectionYFromSectionIndex(var31));
                     int var34 = Math.max(var17, var33);
                     int var35 = Math.min(var18, var33 + 15);

                     for (int var36 = var34; var36 <= var35; var36++) {
                        int var37 = (var36 - var13) * var8;

                        for (int var38 = var26; var38 <= var27; var38++) {
                           int var39 = (var37 + var38 - var14) * var8 - var12;

                           for (int var40 = var21; var40 <= var22; var40++) {
                              var10[var39 + var40] = this.method10955(var32.getBlockState(var40 & 15, var36 & 15, var38 & 15), var5, var40, var36, var38);
                           }
                        }
                     }
                  }
               }
            }
         }
      }

      return var10;
   }

   hex.script.api.Block method10958(int var1, int var2, int var3) {
      hex.script.api.Block var4 = new hex.script.api.Block();
      ClientLevel var5 = mc.level;
      if (var5 == null) {
         return var4;
      }

      MutableBlockPos var6 = this.field24596.set(var1, var2, var3);
      BlockState var7 = var5.getBlockState(var6);
      var4.set(
         this.method10960(var7.getBlock()),
         var1,
         var2,
         var3,
         var7.getDestroySpeed(var5, var6),
         var7.isAir(),
         !var7.getCollisionShape(var5, var6).isEmpty(),
         !var7.getFluidState().isEmpty(),
         var7.canBeReplaced()
      );
      return var4;
   }

   boolean method10959(int var1, int var2, int var3, String var4) {
      ClientLevel var5 = mc.level;
      Block var6 = this.method10961(var4);
      return var5 != null && var6 != null && var5.getBlockState(this.field24596.set(var1, var2, var3)).getBlock() == var6;
   }

   private String method10960(Block var1) {
      String var2 = (String)this.field24597.get(var1);
      if (var2 != null) {
         return var2;
      }

      String var3 = String.valueOf(BuiltInRegistries.BLOCK.getKey(var1));
      this.field24597.put(var1, var3);
      return var3;
   }

   private Block method10961(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         Block var2 = (Block)this.field24598.get(var1);
         if (var2 == null && !this.field24598.containsKey(var1)) {
            Identifier var3 = Identifier.tryParse(var1.indexOf(58) < 0 ? "minecraft:" + var1 : var1);
            Block var4 = var3 == null ? null : BuiltInRegistries.BLOCK.getOptional(var3).orElse(null);
            if (this.field24598.size() < 256) {
               this.field24598.put(var1, var4);
            }

            return var4;
         } else {
            return var2;
         }
      } else {
         return null;
      }
   }

   boolean method10962(int var1, int var2, int var3, int var4) {
      ClientLevel var5 = mc.level;
      return var5 != null && this.method10955(var5.getBlockState(this.field24596.set(var1, var2, var3)), var4, var1, var2, var3);
   }
}
