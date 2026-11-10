// Original binary: sg/ec/lg2o5SitJldobbKX
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.blaze3d.vertex.PoseStack.Pose;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.geom.builders.UVPair;
import net.minecraft.client.model.object.crystal.EndCrystalModel;
import net.minecraft.client.renderer.block.dispatch.BlockStateModelPart;
import net.minecraft.client.renderer.entity.state.EndCrystalRenderState;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.texture.OverlayTexture;
import net.minecraft.client.resources.model.geometry.BakedQuad;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.EntityTypes;
import net.minecraft.world.entity.Entity.RemovalReason;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.level.block.RenderShape;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Vector3f;
import org.joml.Vector3fc;

// $VF: Compiled from s
public class CrystalPlacementRenderer implements MinecraftAccess {
   private static final Identifier field21325 = Identifier.withDefaultNamespace(CrystalPlacementRenderer.field21365);
   private static final Direction[] field21326 = Direction.values();
   private static final int field21327 = 15728880;
   private static final float[][] field21328 = new float[][]{
      {1.0F, CrystalPlacementRenderer.field21366},
      {CrystalPlacementRenderer.field21367, CrystalPlacementRenderer.field21368},
      {CrystalPlacementRenderer.field21369, CrystalPlacementRenderer.field21370}
   };
   private static final float field21329 = 0;
   private static final float field21330 = 0;
   private static final int field21331 = 0;
   private static final int field21332 = 0;
   private static final double field21333 = 0;
   private static final double field21334 = 0;
   private static final float field21335 = 0;
   private static final float field21336 = 0;
   private static final float field21337 = 0;
   private static final long field21338 = 0;
   private static final int field21339 = 0;
   private final List<CrystalPlacementRenderer.Nested262> field21340 = new ArrayList<>();
   private final List<EndCrystal> field21341 = new ArrayList<>();
   private final List<BlockStateModelPart> field21342 = new ArrayList<>();
   private final RandomSource field21343 = RandomSource.create();
   private final EndCrystalRenderState field21344 = new EndCrystalRenderState();
   private final Vector3f field21345 = new Vector3f();
   private final Vector3f field21346 = new Vector3f();
   private final Vector3f field21347 = new Vector3f();
   private final CrystalPlacementRenderer.Nested263 field21348 = new CrystalPlacementRenderer.Nested263();
   private EndCrystalModel field21349;
   private static final double field21350 = 0.95;
   private static final float field21351 = 0.01F;
   private static final float field21352 = 0.2F;
   private static final float field21353 = 0.6F;
   private static final double field21354 = 0.5;
   private static final double field21355 = 0.5;
   private static final long field21356 = 42L;
   private static final float field21357 = 1.2F;
   private static final float field21358 = -0.5F;
   private static final int field21359 = 15728880;
   private static final float field21360 = 1.2F;
   private static final float field21361 = 0.5F;
   private static final float field21362 = -0.5F;
   private static final float field21363 = -0.5F;
   private static final int field21364 = 15728880;
   private static final String field21365 = "textures/entity/end_crystal/end_crystal.png";
   private static final float field21366 = 0.55F;
   private static final float field21367 = 1.08F;
   private static final float field21368 = 0.22F;
   private static final float field21369 = 1.18F;
   private static final float field21370 = 0.1F;

   public void method09389(BlockPos var1, BlockState var2) {
      this.method09390(var1, var2, false);
   }

   private void method09390(BlockPos var1, BlockState var2, boolean var3) {
      if (var2 != null && var2.getRenderShape() == RenderShape.MODEL) {
         var var4 = this.method09392(var2);
         if (!var4.isEmpty()) {
            Identifier var5 = ((BakedQuad)var4.getFirst()).materialInfo().sprite().atlasLocation();
            this.field21340
               .add(new CrystalPlacementRenderer.Nested262(var4, var5, var1.getX() + field21354, var1.getY(), var1.getZ() + field21355, 0.0F, false, var3));
         }
      }
   }

   private EndCrystalModel method09391() {
      if (this.field21349 == null) {
         this.field21349 = new EndCrystalModel(mc.getEntityModels().bakeLayer(ModelLayers.END_CRYSTAL));
      }

      return this.field21349;
   }

   private List<BakedQuad> method09392(BlockState var1) {
      this.field21342.clear();
      this.field21343.setSeed(field21356);
      mc.getModelManager().getBlockStateModelSet().get(var1).collectParts(this.field21343, this.field21342);
      ArrayList var2 = new ArrayList();

      for (BlockStateModelPart var4 : this.field21342) {
         var2.addAll(var4.getQuads(null));

         for (Direction var8 : field21326) {
            var2.addAll(var4.getQuads(var8));
         }
      }

      this.field21342.clear();
      return var2;
   }

   public void method09393() {
      this.field21340.clear();
      this.field21341.clear();
   }

   private void method09395(Pose var1, VertexConsumer var2, List<BakedQuad> var3, int var4) {
      Matrix4f var5 = var1.pose();

      for (BakedQuad var7 : var3) {
         var1.transformNormal(var7.direction().getUnitVec3f(), this.field21346);

         for (int var8 = 0; var8 < 4; var8++) {
            Vector3fc var9 = var7.position(var8);
            var5.transformPosition(var9.x(), var9.y(), var9.z(), this.field21345);
            long var10 = var7.packedUV(var8);
            var2.addVertex(
               this.field21345.x,
               this.field21345.y,
               this.field21345.z,
               var4,
               UVPair.unpackU(var10),
               UVPair.unpackV(var10),
               OverlayTexture.NO_OVERLAY,
               field21364,
               this.field21346.x,
               this.field21346.y,
               this.field21346.z
            );
         }
      }
   }

   private void method09396(PoseStack var1, WorldVertexCollector var2, float var3, boolean var4, float var5, int var6, float var7, boolean var8) {
      this.field21344.ageInTicks = var3;
      this.field21344.showsBottom = var4;
      EndCrystalModel var9 = this.method09391();
      var9.setupAnim(this.field21344);
      var1.pushPose();
      this.method09400(var1, field21357, var5 * field21328[0][0]);
      var1.scale(2.0F, 2.0F, 2.0F);
      var1.translate(0.0F, field21358, 0.0F);
      this.field21348.reset();
      var9.renderToBuffer(var1, this.field21348, field21359, OverlayTexture.NO_OVERLAY, ColorUtils.method04605(var6, var7 * field21328[0][1]));
      var1.popPose();
      var1.last().pose().transformPosition(0.0F, field21360, 0.0F, this.field21347);
      VertexConsumer var10 = var2.method07407(method09401(field21325, var8));

      for (float[] var14 : field21328) {
         this.field21348.emit(var10, this.field21347, var14[0] / field21328[0][0], ColorUtils.method04605(var6, var7 * var14[1]));
      }
   }

   private void method09397(PoseStack var1, VertexConsumer var2, List<BakedQuad> var3, float var4, int var5, float var6) {
      for (float[] var10 : field21328) {
         var1.pushPose();
         this.method09400(var1, field21361, var4 * var10[0]);
         var1.translate(field21362, 0.0F, field21363);
         this.method09395(var1.last(), var2, var3, ColorUtils.method04605(var5, var6 * var10[1]));
         var1.popPose();
      }
   }

   public void method09398(double var1, boolean var3) {
      var var4 = this.field21340.iterator();

      while (var4.hasNext()) {
         CrystalPlacementRenderer.Nested262 var5 = (CrystalPlacementRenderer.Nested262)var4.next();
         var5.field21382++;
         var5.field21380 = var5.field21379;
         var5.field21379 = var5.field21379 + var5.field21381;
         var5.field21381 = var5.field21381 * field21350;
         if (var5.field21382 >= var5.field21378) {
            var4.remove();
         }
      }

      for (EndCrystal var6 : this.field21341) {
         RemovalReason var7 = var6.getRemovalReason();
         if (var7 != null && var7.shouldDestroy()) {
            this.field21340.add(new CrystalPlacementRenderer.Nested262(null, null, var6.getX(), var6.getY(), var6.getZ(), var6.time, var6.showsBottom(), true));
         }
      }

      this.field21341.clear();
      if (var3) {
         mc.level.getEntities(EntityTypes.END_CRYSTAL, mc.player.getBoundingBox().inflate(var1), var0 -> !var0.isRemoved(), this.field21341);
      }
   }

   public void method09399(Render3DEvent var1, int var2, int var3) {
      if (!this.field21340.isEmpty()) {
         float var4 = var1.method00984().getGameTimeDeltaPartialTick(true);
         Vec3 var5 = var1.method00994().position();
         PoseStack var6 = var1.method00996();
         WorldVertexCollector var7 = var1.method00985();

         for (CrystalPlacementRenderer.Nested262 var9 : this.field21340) {
            float var10 = Math.min(1.0F, (var9.field21382 + var4) / var9.field21378);
            float var11 = var9.field21377 ? 1.0F - (float)Easings.field19395.method07086(var10) : 1.0F - var10;
            if (!(var11 <= field21351)) {
               float var12 = var9.field21377 ? 1.0F - field21352 * var10 : Mth.lerp((float)Easings.field19400.method07086(var10), field21353, 1.0F);
               var6.pushPose();
               var6.translate(var9.field21373 - var5.x, Mth.lerp(var4, var9.field21380, var9.field21379) - var5.y, var9.field21374 - var5.z);
               if (var9.field21371 == null) {
                  this.method09396(var6, var7, var9.field21375 + var9.field21382 + var4, var9.field21376, var12, var2, var11, var9.field21377);
               } else {
                  this.method09397(var6, var7.method07407(method09401(var9.field21372, var9.field21377)), var9.field21371, var12, var3, var11);
               }

               var6.popPose();
            }
         }
      }
   }

   private void method09400(PoseStack var1, float var2, float var3) {
      if (var3 != 1.0F) {
         var1.translate(0.0F, var2, 0.0F);
         var1.scale(var3, var3, var3);
         var1.translate(0.0F, -var2, 0.0F);
      }
   }

   private static RenderType method09401(Identifier var0, boolean var1) {
      return var1 ? EffectRenderPipelines.method05535(var0) : EffectRenderPipelines.method05561(var0);
   }

   public void method09402(BlockPos var1, BlockState var2) {
      this.method09390(var1, var2, true);
   }

   // $VF: Compiled from s
   private static final class Nested262 {
      private final List<BakedQuad> field21371;
      private final Identifier field21372;
      private final double field21373;
      private final double field21374;
      private final float field21375;
      private final boolean field21376;
      private final boolean field21377;
      private final int field21378;
      private double field21379;
      private double field21380;
      private double field21381;
      private int field21382;
      private static final double field21383 = 0.16;

      private Nested262(List<BakedQuad> var1, Identifier var2, double var3, double var5, double var7, float var9, boolean var10, boolean var11) {
         this.field21371 = var1;
         this.field21372 = var2;
         this.field21373 = var3;
         this.field21379 = var5;
         this.field21380 = var5;
         this.field21374 = var7;
         this.field21375 = var9;
         this.field21376 = var10;
         this.field21377 = var11;
         this.field21378 = var11 ? 20 : 8;
         this.field21381 = var11 ? field21383 : 0.0;
      }
   }

   // $VF: Compiled from s
   private static final class Nested263 implements VertexConsumer {
      @Override
      public com.mojang.blaze3d.vertex.VertexConsumer setUv3(float u, float v) {
         return this;
      }

      private float[] field21384 = new float[384];
      private float[] field21385 = new float[256];
      private float[] field21386 = new float[384];
      private int field21387;
      private static final int field21388 = 15728880;

      private void emit(VertexConsumer var1, Vector3f var2, float var3, int var4) {
         int var5 = 0;
         int sx = 0;

         for (int sxx = 0; var5 < this.field21387; sxx += 2) {
            float sxxx = this.field21384[sx];
            float sxxxx = this.field21384[sx + 1];
            float sxxxxx = this.field21384[sx + 2];
            if (var3 != 1.0F) {
               sxxx = var2.x + (sxxx - var2.x) * var3;
               sxxxx = var2.y + (sxxxx - var2.y) * var3;
               sxxxxx = var2.z + (sxxxxx - var2.z) * var3;
            }

            var1.addVertex(
               sxxx,
               sxxxx,
               sxxxxx,
               var4,
               this.field21385[sxx],
               this.field21385[sxx + 1],
               OverlayTexture.NO_OVERLAY,
               field21388,
               this.field21386[sx],
               this.field21386[sx + 1],
               this.field21386[sx + 2]
            );
            var5++;
            sx += 3;
         }
      }

      @Override
      public VertexConsumer setNormal(float var1, float var2, float var3) {
         return this;
      }

      @Override
      public VertexConsumer setLineWidth(float var1) {
         return this;
      }

      private void reset() {
         this.field21387 = 0;
      }

      @Override
      public VertexConsumer setColor(int var1) {
         return this;
      }

      @Override
      public VertexConsumer setUv2(int var1, int var2) {
         return this;
      }

      @Override
      public void addVertex(float var1, float var2, float var3, int var4, float var5, float var6, int var7, int var8, float var9, float var10, float var11) {
         if (this.field21387 * 3 == this.field21384.length) {
            this.field21384 = Arrays.copyOf(this.field21384, this.field21384.length << 1);
            this.field21385 = Arrays.copyOf(this.field21385, this.field21385.length << 1);
            this.field21386 = Arrays.copyOf(this.field21386, this.field21386.length << 1);
         }

         int var12 = this.field21387 * 3;
         int var13 = this.field21387 * 2;
         this.field21384[var12] = var1;
         this.field21384[var12 + 1] = var2;
         this.field21384[var12 + 2] = var3;
         this.field21385[var13] = var5;
         this.field21385[var13 + 1] = var6;
         this.field21386[var12] = var9;
         this.field21386[var12 + 1] = var10;
         this.field21386[var12 + 2] = var11;
         this.field21387++;
      }

      @Override
      public VertexConsumer setUv(float var1, float var2) {
         return this;
      }

      @Override
      public VertexConsumer addVertex(float var1, float var2, float var3) {
         return this;
      }

      @Override
      public VertexConsumer setColor(int var1, int var2, int var3, int var4) {
         return this;
      }

      @Override
      public VertexConsumer setUv1(int var1, int var2) {
         return this;
      }
   }
}
