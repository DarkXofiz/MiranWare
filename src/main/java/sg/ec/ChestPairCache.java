// Original binary: sg/ec/4naC7eMCLkpblxCy
package sg.ec;

import it.unimi.dsi.fastutil.floats.Float2FloatFunction;
import it.unimi.dsi.fastutil.ints.Int2IntFunction;
import net.minecraft.client.renderer.blockentity.BrightnessCombiner;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.ChestBlock;
import net.minecraft.world.level.block.DoubleBlockCombiner.BlockType;
import net.minecraft.world.level.block.DoubleBlockCombiner.Combiner;
import net.minecraft.world.level.block.DoubleBlockCombiner.NeighborCombineResult;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.entity.ChestBlockEntity;
import net.minecraft.world.level.block.entity.LidBlockEntity;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public final class ChestPairCache {
   private static final ChestPairCache.Nested31 field02072 = new ChestPairCache.Nested31();
   private static final ChestPairCache.Nested33 field02073 = new ChestPairCache.Nested33();
   private static final ChestPairCache.Nested32 field02074 = new ChestPairCache.Nested32();

   public static NeighborCombineResult<? extends ChestBlockEntity> method00893(BlockEntity var0, ChestBlock var1, BlockState var2, Level var3, BlockPos var4) {
      if (var0 instanceof ChestBlockEntity var5) {
         ChestPairCacheAccess var6 = (ChestPairCacheAccess)var5;
         int var7 = BlockEntityLightCache.method05924();
         if (var6.hex$pairStamp() == var7 && var6.hex$pairState() == var2) {
            ChestBlockEntity sx = var6.hex$pairFirst();
            ChestBlockEntity sxx = var6.hex$pairSecond();
            if (method00897(sx) && method00897(sxx)) {
               return field02072.set(sx, sxx);
            }
         }

         ChestPairCache.Nested31 sx = method00894(var1, var2, var3, var4);
         var6.hex$pair(var7, var2, sx.field02075, sx.field02076);
         return sx;
      } else {
         return method00894(var1, var2, var3, var4);
      }
   }

   private static ChestPairCache.Nested31 method00894(ChestBlock var0, BlockState var1, Level var2, BlockPos var3) {
      BlockEntityType var4 = var0.blockEntityType();
      ChestBlockEntity var5 = (ChestBlockEntity)var4.getBlockEntity(var2, var3);
      if (var5 == null) {
         return field02072.set(null, null);
      }

      BlockType var6 = ChestBlock.getBlockType(var1);
      if (var6 == BlockType.SINGLE) {
         return field02072.set(var5, null);
      }

      BlockPos var7 = var3.relative(ChestBlock.getConnectedDirection(var1));
      BlockState var8 = var2.getBlockState(var7);
      if (var8.is(var1.getBlock())) {
         BlockType var9 = ChestBlock.getBlockType(var8);
         if (var9 != BlockType.SINGLE && var6 != var9 && var8.getValue(ChestBlock.FACING) == var1.getValue(ChestBlock.FACING)) {
            ChestBlockEntity var10 = (ChestBlockEntity)var4.getBlockEntity(var2, var7);
            if (var10 != null) {
               boolean var11 = var6 == BlockType.FIRST;
               return field02072.set(var11 ? var5 : var10, var11 ? var10 : var5);
            }
         }
      }

      return field02072.set(var5, null);
   }

   public static Combiner<ChestBlockEntity, Float2FloatFunction> method00895(LidBlockEntity var0) {
      return field02073.fallback(var0);
   }

   public static BrightnessCombiner<BlockEntity> method00896() {
      return field02074;
   }

   private ChestPairCache() {
   }

   private static boolean method00897(ChestBlockEntity var0) {
      return var0 == null || !var0.isRemoved();
   }

   // $VF: Compiled from s
   private static final class Nested31 implements NeighborCombineResult<ChestBlockEntity> {
      private ChestBlockEntity field02075;
      private ChestBlockEntity field02076;

      private ChestPairCache.Nested31 set(ChestBlockEntity var1, ChestBlockEntity var2) {
         this.field02075 = var1;
         this.field02076 = var2;
         return this;
      }

      @Override
      public <T> T apply(Combiner<? super ChestBlockEntity, T> var1) {
         if (this.field02076 != null) {
            return (T)(Object)var1.acceptDouble(this.field02075, this.field02076);
         } else {
            return (T)(Object)(this.field02075 != null ? var1.acceptSingle(this.field02075) : var1.acceptNone());
         }
      }
   }

   // $VF: Compiled from s
   private static final class Nested32 extends BrightnessCombiner<BlockEntity> implements Int2IntFunction {
      private BlockEntity field02077;
      private BlockEntity field02078;

      @Override
      public Int2IntFunction acceptDouble(BlockEntity var1, BlockEntity var2) {
         this.field02077 = var1;
         this.field02078 = var2;
         return this;
      }

      @Override
      public Int2IntFunction acceptNone() {
         this.field02077 = null;
         this.field02078 = null;
         return this;
      }

      @Override
      public Int2IntFunction acceptSingle(BlockEntity var1) {
         this.field02077 = null;
         this.field02078 = null;
         return this;
      }

      public int get(int var1) {
         return this.field02078 == null
            ? var1
            : BlockEntityLightCache.maxLight(
               BlockEntityLightCache.method05926(this.field02077.getLevel(), this.field02077.getBlockPos(), this.field02077),
               BlockEntityLightCache.method05926(this.field02078.getLevel(), this.field02078.getBlockPos(), this.field02078)
            );
      }
   }

   // $VF: Compiled from s
   private static final class Nested33 implements Float2FloatFunction, Combiner<ChestBlockEntity, Float2FloatFunction> {
      private LidBlockEntity field02079;
      private ChestBlockEntity field02080;
      private ChestBlockEntity field02081;

      public Float2FloatFunction acceptDouble(ChestBlockEntity var1, ChestBlockEntity var2) {
         this.field02080 = var1;
         this.field02081 = var2;
         return this;
      }

      public Float2FloatFunction acceptSingle(ChestBlockEntity var1) {
         this.field02080 = var1;
         this.field02081 = null;
         return this;
      }

      public float get(float var1) {
         if (this.field02081 != null) {
            return Math.max(this.field02080.getOpenNess(var1), this.field02081.getOpenNess(var1));
         } else {
            return this.field02080 != null ? this.field02080.getOpenNess(var1) : this.field02079.getOpenNess(var1);
         }
      }

      public Float2FloatFunction acceptNone() {
         this.field02080 = null;
         this.field02081 = null;
         return this;
      }

      private ChestPairCache.Nested33 fallback(LidBlockEntity var1) {
         this.field02079 = var1;
         return this;
      }
   }
}
