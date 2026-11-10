// Original binary: hex/api/baritone/utils/PathRenderer
package hex.api.baritone.utils;

import com.mojang.blaze3d.vertex.PoseStack;
import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.event.events.RenderEvent;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalComposite;
import hex.api.baritone.api.pathing.goals.GoalGetToBlock;
import hex.api.baritone.api.pathing.goals.GoalInverted;
import hex.api.baritone.api.pathing.goals.GoalTwoBlocks;
import hex.api.baritone.api.pathing.goals.GoalXZ;
import hex.api.baritone.api.pathing.goals.GoalYLevel;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.IPlayerContext;
import hex.api.baritone.api.utils.interfaces.IGoalRenderPos;
import hex.api.baritone.behavior.PathingBehavior;
import hex.api.baritone.pathing.path.PathExecutor;
import java.awt.Color;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.shapes.Shapes;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.Nullable;
import sg.ec.BaritoneVertexConsumerAccess;

// $VF: Compiled from s
public final class PathRenderer implements IRenderer {
   private static final float GOAL_BEACON_INNER_RADIUS = 0.2F;
   private static final float GOAL_BEACON_GLOW_RADIUS = 0.25F;
   private static final int GOAL_BEACON_GLOW_ALPHA = 32;
   private static final double АВ5 = 0;
   private static final float АВЖ = 0;
   private static final float АВо = 0;
   private static final double АВК = 0;
   private static final String АВЭ = "АВЭ";
   private static final double АВЪ = 0;
   private static final long АВЧ = 1L;
   private static final long АВЩ = 1L;
   private static final float АВм = 1.0F;
   private static final double АВФ = 0;
   private static final double АВ3 = 0;
   private static final double АВЬ = 0;
   private static final double АВ1 = 0;
   private static final double АВя = 0;
   private static final double АВI = 0;
   private static final double АВы = 1.0;
   private static final double АВу = 0;
   private static final double АВг = 0;
   private static final double АВю = 0;
   private static final double АВ4 = 0;
   private static final double АВС = 0;
   private static final double АВъ = 0;
   private static final double АВБ = 0;
   private static final double АВв = 0;
   private static final double АВр = 0;
   private static final double АВй = 0;
   private static final double АВк = 0;
   private static final double АВп = 0;
   private static final double АВ2 = 0;

   public static double posX() {
      return renderManager.renderPosX();
   }

   public static double posY() {
      return renderManager.renderPosY();
   }

   private static void renderHorizontalQuad(
      BaritoneVertexConsumerAccess var0, PoseStack var1, double var2, double var4, double var6, double var8, double var10, float var12
   ) {
      if (var10 != 0.0) {
         IRenderer.emitLine(var0, var1, var2, var10, var6, var4, var10, var6, 1.0, 0.0, 0.0, var12);
         IRenderer.emitLine(var0, var1, var4, var10, var6, var4, var10, var8, 0.0, 0.0, 1.0, var12);
         IRenderer.emitLine(var0, var1, var4, var10, var8, var2, var10, var8, АВк, 0.0, 0.0, var12);
         IRenderer.emitLine(var0, var1, var2, var10, var8, var2, var10, var6, 0.0, 0.0, АВп, var12);
      }
   }

   private static void emitPathLine(
      BaritoneVertexConsumerAccess var0, PoseStack var1, double var2, double var4, double var6, double var8, double var10, double var12, double var14
   ) {
      double var16 = var14 + АВК;
      double sx = posX();
      double sxx = posY();
      double sxxx = posZ();
      boolean sxxxx = !settings.renderPathAsLine.value;
      IRenderer.emitLine(
         var0,
         var1,
         var2 + var14 - sx,
         var4 + var14 - sxx,
         var6 + var14 - sxxx,
         var8 + var14 - sx,
         var10 + var14 - sxx,
         var12 + var14 - sxxx,
         settings.pathRenderLineWidthPixels.value
      );
      if (sxxxx) {
         IRenderer.emitLine(
            var0,
            var1,
            var8 + var14 - sx,
            var10 + var14 - sxx,
            var12 + var14 - sxxx,
            var8 + var14 - sx,
            var10 + var16 - sxx,
            var12 + var14 - sxxx,
            settings.pathRenderLineWidthPixels.value
         );
         IRenderer.emitLine(
            var0,
            var1,
            var8 + var14 - sx,
            var10 + var16 - sxx,
            var12 + var14 - sxxx,
            var2 + var14 - sx,
            var4 + var16 - sxx,
            var6 + var14 - sxxx,
            settings.pathRenderLineWidthPixels.value
         );
         IRenderer.emitLine(
            var0,
            var1,
            var2 + var14 - sx,
            var4 + var16 - sxx,
            var6 + var14 - sxxx,
            var2 + var14 - sx,
            var4 + var14 - sxx,
            var6 + var14 - sxxx,
            settings.pathRenderLineWidthPixels.value
         );
      }
   }

   public static void drawPath(PoseStack var0, List<BetterBlockPos> var1, int var2, Color var3, boolean var4, int var5, int var6, double var7) {
      BaritoneVertexConsumerAccess var9 = IRenderer.startLines(var3);
      int sx = var5 + var2;
      int sxx = var6 + var2;
      int sxxx = var2;

      while (sxxx < var1.size() - 1) {
         BetterBlockPos sxxxx = var1.get(sxxx);
         int sxxxxx;
         BetterBlockPos sxxxxxx = var1.get(sxxxxx = sxxx + 1);
         int sxxxxxxx = sxxxxxx.x - sxxxx.x;
         int sxxxxxxxx = sxxxxxx.y - sxxxx.y;
         int sxxxxxxxxx = sxxxxxx.z - sxxxx.z;

         while (
            sxxxxx + 1 < var1.size()
               && (!var4 || sxxxxx + 1 < sx)
               && sxxxxxxx == var1.get(sxxxxx + 1).x - sxxxxxx.x
               && sxxxxxxxx == var1.get(sxxxxx + 1).y - sxxxxxx.y
               && sxxxxxxxxx == var1.get(sxxxxx + 1).z - sxxxxxx.z
         ) {
            sxxxxxx = var1.get(++sxxxxx);
         }

         if (var4) {
            float sxxxxxxxxxx;
            if (sxxx <= sx) {
               sxxxxxxxxxx = АВЖ;
            } else {
               if (sxxx > sxx) {
                  break;
               }

               sxxxxxxxxxx = АВо * (1.0F - (float)(sxxx - sx) / (sxx - sx));
            }

            IRenderer.glColor(var3, sxxxxxxxxxx);
         }

         emitPathLine(var9, var0, sxxxx.x, sxxxx.y, sxxxx.z, sxxxxxx.x, sxxxxxx.y, sxxxxxx.z, var7);
         sxxx = sxxxxx;
      }

      IRenderer.endLines(var9, settings.renderPathIgnoreDepth.value);
   }

   public static void drawGoal(PoseStack var0, IPlayerContext var1, Goal var2, float var3, Color var4) {
      drawGoal(null, var0, var1, var2, var3, var4, true);
   }

   public static double posZ() {
      return renderManager.renderPosZ();
   }

   private PathRenderer() {
   }

   public static void drawManySelectionBoxes(PoseStack var0, Entity var1, Collection<BlockPos> var2, Color var3) {
      BaritoneVertexConsumerAccess var4 = IRenderer.startLines(var3);
      BlockStateInterface sx = new BlockStateInterface(BaritoneAPI.getProvider().getPrimaryBaritone().getPlayerContext());
      var2.forEach(var4x -> {
         BlockState sxx = sx.get0(var4x);
         VoxelShape sxxx = sxx.getShape(var1.level(), var4x);
         AABB sxxxx = sxxx.isEmpty() ? Shapes.block().bounds() : sxxx.bounds();
         sxxxx = sxxxx.move(var4x);
         IRenderer.emitAABB(var4, var0, sxxxx, АВ2, settings.pathRenderLineWidthPixels.value);
      });
      IRenderer.endLines(var4, settings.renderSelectionBoxesIgnoreDepth.value);
   }


   public static void render(RenderEvent var0, PathingBehavior var1) {
      IPlayerContext var2 = var1.ctx;
      if (var2.world() != null) {
         if (var2.minecraft().gui.screen() instanceof GuiClick) {
            ((GuiClick)var2.minecraft().gui.screen()).onRender(var0.getModelViewStack(), var0.getProjectionMatrix());
         }

         float sx = var0.getPartialTicks();
         Goal sxx = var1.getGoal();
         Level sxxx = BaritoneAPI.getProvider().getPrimaryBaritone().getPlayerContext().world();
         if (sxxx != null) {
            DimensionType sxxxx = var2.world().dimensionType();
            DimensionType sxxxxx = sxxx.dimensionType();
            if (sxxxx == sxxxxx) {
               if (sxx != null && settings.renderGoal.value) {
                  drawGoal(var0.getModelViewStack(), var2, sxx, sx, settings.colorGoalBox.value);
               }

               if (settings.renderPath.value) {
                  PathExecutor sxxxxxx = var1.getCurrent();
                  PathExecutor sxxxxxxx = var1.getNext();
                  if (sxxxxxx != null && settings.renderSelectionBoxes.value) {
                     drawManySelectionBoxes(var0.getModelViewStack(), var2.player(), sxxxxxx.toBreak(), settings.colorBlocksToBreak.value);
                     drawManySelectionBoxes(var0.getModelViewStack(), var2.player(), sxxxxxx.toPlace(), settings.colorBlocksToPlace.value);
                     drawManySelectionBoxes(var0.getModelViewStack(), var2.player(), sxxxxxx.toWalkInto(), settings.colorBlocksToWalkInto.value);
                  }

                  if (sxxxxxx != null && sxxxxxx.getPath() != null) {
                     int sxxxxxxxx = Math.max(sxxxxxx.getPosition() - 3, 0);
                     drawPath(
                        var0.getModelViewStack(), sxxxxxx.getPath().positions(), sxxxxxxxx, settings.colorCurrentPath.value, settings.fadePath.value, 10, 20
                     );
                  }

                  if (sxxxxxxx != null && sxxxxxxx.getPath() != null) {
                     drawPath(var0.getModelViewStack(), sxxxxxxx.getPath().positions(), 0, settings.colorNextPath.value, settings.fadePath.value, 10, 20);
                  }

                  var1.getInProgress()
                     .ifPresent(
                        var2x -> {
                           var2x.bestPathSoFar()
                              .ifPresent(
                                 var1x -> drawPath(
                                    var0.getModelViewStack(), var1x.positions(), 0, settings.colorBestPathSoFar.value, settings.fadePath.value, 10, 20
                                 )
                              );
                           var2x.pathToMostRecentNodeConsidered()
                              .ifPresent(
                                 var2xx -> {
                                    drawPath(
                                       var0.getModelViewStack(),
                                       var2xx.positions(),
                                       0,
                                       settings.colorMostRecentConsidered.value,
                                       settings.fadePath.value,
                                       10,
                                       20
                                    );
                                    drawManySelectionBoxes(
                                       var0.getModelViewStack(),
                                       var2.player(),
                                       Collections.singletonList(var2xx.getDest()),
                                       settings.colorMostRecentConsidered.value
                                    );
                                 }
                              );
                        }
                     );
               }
            }
         }
      }
   }

   private static void drawDankLitGoalBox(
      BaritoneVertexConsumerAccess var0,
      PoseStack var1,
      Color var2,
      double var3,
      double var5,
      double var7,
      double var9,
      double var11,
      double var13,
      double var15,
      double var17,
      boolean var19
   ) {
      if (var19) {
         var0 = IRenderer.startLines(var2);
      }

      renderHorizontalQuad(var0, var1, var3, var5, var7, var9, var15, settings.goalRenderLineWidthPixels.value);
      renderHorizontalQuad(var0, var1, var3, var5, var7, var9, var17, settings.goalRenderLineWidthPixels.value);

      for (double var20 = var11; var20 < var13; var20 += АВй) {
         double sx = Math.min(var13, var20 + АВр);
         IRenderer.emitLine(var0, var1, var3, var20, var7, var3, sx, var7, 0.0, 1.0, 0.0, settings.goalRenderLineWidthPixels.value);
         IRenderer.emitLine(var0, var1, var5, var20, var7, var5, sx, var7, 0.0, 1.0, 0.0, settings.goalRenderLineWidthPixels.value);
         IRenderer.emitLine(var0, var1, var5, var20, var9, var5, sx, var9, 0.0, 1.0, 0.0, settings.goalRenderLineWidthPixels.value);
         IRenderer.emitLine(var0, var1, var3, var20, var9, var3, sx, var9, 0.0, 1.0, 0.0, settings.goalRenderLineWidthPixels.value);
      }

      if (var19) {
         IRenderer.endLines(var0, settings.renderGoalIgnoreDepth.value);
      }
   }

   private static void drawGoal(@Nullable BaritoneVertexConsumerAccess var0, PoseStack var1, IPlayerContext var2, Goal var3, float var4, Color var5, boolean var6) {
      if (!var6 && var0 == null) {
         throw new RuntimeException(АВЭ);
      }

      double var7 = posX();
      double sx = posY();
      double sxx = posZ();
      double sxxx;
      if (!settings.renderGoalAnimated.value) {
         sxxx = АВЪ;
      } else {
         sxxx = Mth.cos((float)((float)(System.nanoTime() / АВЧ % АВЩ) / АВм * АВФ * АВ3));
      }

      if (var3 instanceof IGoalRenderPos) {
         BlockPos sxxxx = ((IGoalRenderPos)var3).getGoalPos();
         double sxxxxx = sxxxx.getX() + АВЬ - var7;
         double sxxxxxx = sxxxx.getX() + 1 - АВ1 - var7;
         double sxxxxxxx = sxxxx.getZ() + АВя - sxx;
         double sxxxxxxxx = sxxxx.getZ() + 1 - АВI - sxx;
         if (var3 instanceof GoalGetToBlock || var3 instanceof GoalTwoBlocks) {
            sxxx /= АВы;
         }

         double sxxxxxxxxx = 1.0 + sxxx + sxxxx.getY() - sx;
         double sxxxxxxxxxx = 1.0 - sxxx + sxxxx.getY() - sx;
         double sxxxxxxxxxxx = sxxxx.getY() - sx;
         double sxxxxxxxxxxxx = sxxxxxxxxxxx + АВу;
         if (var3 instanceof GoalGetToBlock || var3 instanceof GoalTwoBlocks) {
            sxxxxxxxxx -= АВг;
            sxxxxxxxxxx -= АВю;
            sxxxxxxxxxxxx--;
         }

         drawDankLitGoalBox(var0, var1, var5, sxxxxx, sxxxxxx, sxxxxxxx, sxxxxxxxx, sxxxxxxxxxxx, sxxxxxxxxxxxx, sxxxxxxxxx, sxxxxxxxxxx, var6);
      } else if (var3 instanceof GoalXZ sxxxx) {
         double sxxxxx = var2.world().getMinY();
         double sxxxxxx = var2.world().getMaxY();
         double sxxxxxxx = sxxxx.getX() + АВ4 - var7;
         double sxxxxxxxx = sxxxx.getX() + 1 - АВС - var7;
         double sxxxxxxxxx = sxxxx.getZ() + АВъ - sxx;
         double sxxxxxxxxxx = sxxxx.getZ() + 1 - АВБ - sxx;
         double sxxxxxxxxxxx = 0.0;
         double sxxxxxxxxxxxx = 0.0;
         sxxxxx -= sx;
         sxxxxxx -= sx;
         drawDankLitGoalBox(var0, var1, var5, sxxxxxxx, sxxxxxxxx, sxxxxxxxxx, sxxxxxxxxxx, sxxxxx, sxxxxxx, sxxxxxxxxxxx, sxxxxxxxxxxxx, var6);
      } else if (var3 instanceof GoalComposite) {
         boolean sxxxx = Arrays.stream(((GoalComposite)var3).goals()).allMatch(IGoalRenderPos.class::isInstance);
         BaritoneVertexConsumerAccess sxxxxx = var0;
         if (sxxxx) {
            sxxxxx = IRenderer.startLines(var5, settings.goalRenderLineWidthPixels.value);
         }

         for (Goal sxxxxxx : ((GoalComposite)var3).goals()) {
            drawGoal(sxxxxx, var1, var2, sxxxxxx, var4, var5, !sxxxx);
         }

         if (sxxxx) {
            IRenderer.endLines(sxxxxx, settings.renderGoalIgnoreDepth.value);
         }
      } else if (var3 instanceof GoalInverted) {
         drawGoal(var1, var2, ((GoalInverted)var3).origin, var4, settings.colorInvertedGoalBox.value);
      } else if (var3 instanceof GoalYLevel sxxxx) {
         double sxxxxx = var2.player().position().x - settings.yLevelBoxSize.value - var7;
         double sxxxxxx = var2.player().position().z - settings.yLevelBoxSize.value - sxx;
         double sxxxxxxx = var2.player().position().x + settings.yLevelBoxSize.value - var7;
         double sxxxxxxxx = var2.player().position().z + settings.yLevelBoxSize.value - sxx;
         double sxxxxxxxxx = ((GoalYLevel)var3).level - sx;
         double sxxxxxxxxxx = sxxxxxxxxx + АВв;
         double sxxxxxxxxxxx = 1.0 + sxxx + sxxxx.level - sx;
         double sxxxxxxxxxxxx = 1.0 - sxxx + sxxxx.level - sx;
         drawDankLitGoalBox(var0, var1, var5, sxxxxx, sxxxxxxx, sxxxxxx, sxxxxxxxx, sxxxxxxxxx, sxxxxxxxxxx, sxxxxxxxxxxx, sxxxxxxxxxxxx, var6);
      }
   }

   public static void drawPath(PoseStack var0, List<BetterBlockPos> var1, int var2, Color var3, boolean var4, int var5, int var6) {
      drawPath(var0, var1, var2, var3, var4, var5, var6, АВ5);
   }
}
