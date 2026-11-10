// Original binary: sg/ec/yC5bPOQqcXFMJ8sc
package sg.ec;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.AnvilBlock;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.ButtonBlock;
import net.minecraft.world.level.block.CartographyTableBlock;
import net.minecraft.world.level.block.CraftingTableBlock;
import net.minecraft.world.level.block.DoorBlock;
import net.minecraft.world.level.block.FenceGateBlock;
import net.minecraft.world.level.block.GrindstoneBlock;
import net.minecraft.world.level.block.LeverBlock;
import net.minecraft.world.level.block.LoomBlock;
import net.minecraft.world.level.block.NoteBlock;
import net.minecraft.world.level.block.StonecutterBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import org.joml.Vector2f;

// $VF: Compiled from s
public class BlockTrapController implements MinecraftAccess {
   private static final float field26407 = 4.5F;
   private static final int field26408 = 0;
   private static final int field26409 = 0;
   private static final int field26410 = 0;
   private static final float field26411 = 0;
   private static final List<Class<? extends Block>> field26412 = List.of(
      DoorBlock.class,
      TrapDoorBlock.class,
      FenceGateBlock.class,
      ButtonBlock.class,
      LeverBlock.class,
      NoteBlock.class,
      CraftingTableBlock.class,
      AnvilBlock.class,
      LoomBlock.class,
      StonecutterBlock.class,
      CartographyTableBlock.class,
      GrindstoneBlock.class
   );
   private static BlockTrapController field26413;
   private final HitResultConstraint field26414 = new HitResultConstraint();
   private final Deque<BlockTrapController.Nested324> field26415 = new ArrayDeque<>();
   private final List<BlockTrapController.Nested324> field26416 = new ArrayList<>();
   private final List<BlockPos> field26417 = new ArrayList<>(4);
   private boolean field26418;
   private boolean field26419;
   private boolean field26420;
   private int field26421;
   private int field26422 = -100;
   private BlockTrapController.Nested324 field26423;
   private BlockTrapController.Nested325 field26424;
   private static final double field26425 = 4.5;
   private static final double field26426 = 4.5;
   private static final float field26427 = 0.5F;
   private static final float field26428 = 9999.0F;
   private static final float field26429 = Float.MAX_VALUE;
   private static final double field26430 = Double.MAX_VALUE;
   private static final double field26431 = 0.5;
   private static final double field26432 = 0.5;
   private static final double field26433 = 0.5;
   private static final double field26434 = 20.25;
   private static final double field26435 = 0.001;
   private static final double field26436 = 0.01;

   private boolean method11568() {
      return !this.field26420;
   }

   private boolean method11569(BlockPos var1) {
      Vec3 var2 = mc.player.getEyePosition();
      Vec3 var3 = var2.add(mc.player.getLookAngle().scale(field26426));
      return new AABB(var1).clip(var2, var3).isPresent();
   }

   public static boolean method11570() {
      return field26413 != null && (!field26413.field26415.isEmpty() || field26413.field26423 != null);
   }

   private BlockTrapController.Nested325 method11571(BlockPos var1, boolean var2) {
      if (var1 != null && mc.player != null && mc.level != null) {
         if (!mc.level.getBlockState(var1).canBeReplaced()) {
            return null;
         }

         Vec3 var3 = mc.player.getEyePosition();
         float var4 = mc.player.getYRot();
         BlockTrapController.Nested325 var5 = null;
         float var6 = field26429;
         double var7 = field26430;

         for (Direction var12 : Direction.values()) {
            BlockPos var13 = var1.relative(var12.getOpposite());
            if (method11586(var13)) {
               Vec3 var14 = ExplosionDamageUtils.method04395(
                  Vec3.atCenterOf(var13).add(var12.getStepX() * field26431, var12.getStepY() * field26432, var12.getStepZ() * field26433), var12
               );
               double var15 = var3.distanceToSqr(var14);
               if (!(var15 > field26434)) {
                  Vector2f var17;
                  if (this.field26420) {
                     var17 = BlockPlacementManager.method07901(var13, var12, var14);
                     if (var17 == null) {
                        if (!var2 || !ExplosionDamageUtils.method04422(var3, var14, var12)) {
                           continue;
                        }

                        var17 = BlockPlacementManager.method07910(PlayerUtils.method11816(var3, var14));
                        if (var17 == null) {
                           continue;
                        }
                     }
                  } else {
                     if (!this.method11587(var3, var13, var14, var12, var2)) {
                        continue;
                     }

                     var17 = PlayerUtils.method11816(var3, var14);
                  }

                  var17.x = var4 + Mth.wrapDegrees(var17.x - var4);
                  float var18 = this.method11590(var17);
                  if (var18 < var6 || Math.abs(var18 - var6) < field26435 && var15 < var7) {
                     var6 = var18;
                     var7 = var15;
                     var5 = new BlockTrapController.Nested325(var13, var14, var12, var17);
                  }
               }
            }
         }

         return var5;
      } else {
         return null;
      }
   }

   public static boolean method11572(BlockPos var0) {
      if (mc.level == null) {
         return false;
      }

      for (Direction var4 : Direction.values()) {
         if (method11586(var0.relative(var4))) {
            return true;
         }
      }

      return false;
   }

   private boolean method11573(List<BlockTrapController.Nested324> var1, boolean var2, boolean var3, int var4, boolean var5, boolean var6) {
      if (mc.player != null && mc.level != null && var1 != null && !var1.isEmpty()) {
         if (method11570() && var4 < this.field26421) {
            return false;
         }

         this.field26415.clear();

         for (BlockTrapController.Nested324 var8 : var1) {
            if (var8 != null && var8.field26437 != null && var8.field26438 != null) {
               this.field26415.addLast(var8);
            }
         }

         if (this.field26415.isEmpty()) {
            return false;
         }

         this.field26418 = var2;
         this.field26419 = var3;
         this.field26420 = var6;
         this.field26421 = var4;
         this.field26422 = mc.player.tickCount;
         if (var5) {
            this.method11584();
         }

         return true;
      } else {
         return false;
      }
   }

   private int method11574(BlockTrapController.Nested324 var1, BlockTrapController.Nested324 var2) {
      Vec3 var3 = mc.player.getEyePosition();
      return Float.compare(
         this.method11590(PlayerUtils.method11816(var3, Vec3.atCenterOf(var1.field26437))),
         this.method11590(PlayerUtils.method11816(var3, Vec3.atCenterOf(var2.field26437)))
      );
   }

   @Subscribe
   private void method11575(PlayerUpdateEvent var1) {
      if (mc.player == null || mc.level == null || mc.gameMode == null) {
         this.field26414.method02876();
         this.field26417.clear();
         this.method11589();
      } else if (!this.field26415.isEmpty() && this.method11591()) {
         this.method11589();
      } else {
         this.method11584();
      }
   }

   private void method11576() {
      BlockTrapController.Nested324 var1 = this.field26423;
      BlockTrapController.Nested325 var2 = this.field26424;
      this.field26423 = null;
      this.field26424 = null;
      if (var1 != null && var2 != null) {
         if (mc.level.getBlockState(var1.field26437).canBeReplaced()) {
            if (this.method11569(var2.field26439)) {
               BlockHitResult var3 = this.method11578(var2);
               if (var3 != null) {
                  if (this.method11577(var3, var1.field26438, var2.field26439)) {
                     this.method11579(var1.field26437);
                     if (this.method11568()) {
                        int var4 = 0;

                        while (var4 < 3 && this.method11596()) {
                           var4++;
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private boolean method11577(BlockHitResult var1, Item var2, BlockPos var3) {
      int var4 = InventoryUtils.method06111(var2, true);
      if (var4 == -1) {
         return false;
      }

      boolean var5 = this.field26420;
      int var6 = mc.player.getInventory().getSelectedSlot();
      mc.player.getInventory().setSelectedSlot(var4);
      if (this.field26419) {
         this.field26414.method02874(var3);
      }

      try {
         boolean var7 = mc.gameMode.useItemOn(mc.player, InteractionHand.MAIN_HAND, var1) == InteractionResult.SUCCESS;
         if (var7) {
            if (var5) {
               mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
            }

            RotationChangeTracker.method02903();
         }

         return var7;
      } finally {
         this.field26414.method02876();
         mc.player.getInventory().setSelectedSlot(var6);
      }
   }

   private BlockHitResult method11578(BlockTrapController.Nested325 var1) {
      if (this.field26419) {
         return new BlockHitResult(var1.field26440, var1.field26441, var1.field26439, false);
      } else {
         return this.field26420
            ? BlockPlacementManager.method07898(var1.field26439, var1.field26441)
            : this.method11588(mc.player.getEyePosition(), var1.field26440, var1.field26439, var1.field26441);
      }
   }

   private void method11579(BlockPos var1) {
      this.field26415.removeIf(var1x -> var1.equals(var1x.field26437));
      this.field26417.add(var1);
   }

   public static void method11581(int var0) {
      if (field26413 != null && field26413.field26421 == var0) {
         field26413.method11589();
      }
   }

   private boolean method11582(BlockPos var1) {
      if (var1 != null && mc.level != null) {
         BlockState var2 = mc.level.getBlockState(var1);
         if (var2.isAir()) {
            return false;
         }

         if (var2.hasBlockEntity()) {
            return true;
         }

         Block var3 = var2.getBlock();

         for (Class var5 : field26412) {
            if (var5.isInstance(var3)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   @Subscribe
   private void method11583(HitResultEvent var1) {
      this.field26414.method02875(var1);
   }

   private void method11584() {
      this.field26415.removeIf(this::method11592);
      if (this.field26415.isEmpty()) {
         this.field26421 = 0;
      } else {
         this.field26416.clear();
         this.field26416.addAll(this.field26415);
         this.field26416.sort(this::method11574);
         BlockTrapController.Nested324 var1 = null;
         BlockTrapController.Nested325 var2 = null;

         for (BlockTrapController.Nested324 var4 : this.field26416) {
            BlockTrapController.Nested325 var5 = this.method11571(var4.field26437, this.field26419);
            if (var5 != null) {
               var1 = var4;
               var2 = var5;
               break;
            }
         }

         this.field26416.clear();
         if (var1 == null) {
            this.field26421 = 0;
         } else {
            if (this.field26418) {
               this.method11593(var2);
            }

            this.field26423 = var1;
            this.field26424 = var2;
         }
      }
   }

   public BlockTrapController() {
      EventBus.method00263(this);
      field26413 = this;
   }

   @Subscribe
   private void method11585(PlayerInputEvent var1) {
      if (mc.player != null && mc.level != null && this.field26424 != null) {
         if (this.field26418) {
            RotationManager.field14787 = true;
         }

         if (this.method11582(this.field26424.field26439)) {
            var1.method11169(true);
         }
      }
   }

   private static boolean method11586(BlockPos var0) {
      BlockState var1 = mc.level.getBlockState(var0);
      return var1.is(Blocks.COBWEB) || !var1.canBeReplaced() && var1.isRedstoneConductor(mc.level, var0);
   }

   private boolean method11587(Vec3 var1, BlockPos var2, Vec3 var3, Direction var4, boolean var5) {
      Vec3 var6 = var1.subtract(var3);
      Vec3 var7 = new Vec3(var4.getStepX(), var4.getStepY(), var4.getStepZ());
      if (var6.dot(var7) <= field26436) {
         return false;
      } else {
         return var5 ? true : this.method11588(var1, var3, var2, var4) != null;
      }
   }

   private BlockHitResult method11588(Vec3 var1, Vec3 var2, BlockPos var3, Direction var4) {
      BlockHitResult var5 = mc.level.clip(new ClipContext(var1, var2, net.minecraft.world.level.ClipContext.Block.OUTLINE, Fluid.NONE, mc.player));
      if (var5.getType() != Type.BLOCK) {
         return null;
      } else {
         return var5.getBlockPos().equals(var3) && var5.getDirection() == var4 ? var5 : null;
      }
   }

   private void method11589() {
      this.field26415.clear();
      this.field26416.clear();
      this.field26423 = null;
      this.field26424 = null;
      this.field26421 = 0;
   }

   private float method11590(Vector2f var1) {
      float var2 = Math.abs(Mth.wrapDegrees(var1.x - mc.player.getYRot()));
      float var3 = Math.abs(var1.y - mc.player.getXRot());
      return var2 + var3 * field26427;
   }

   private boolean method11591() {
      int var1 = mc.player.tickCount - this.field26422;
      return var1 < 0 || var1 > 2;
   }

   private boolean method11592(BlockTrapController.Nested324 var1) {
      return !mc.level.getBlockState(var1.field26437).canBeReplaced();
   }

   private void method11593(BlockTrapController.Nested325 var1) {
      RotationManager.method06547(new Rotation(Mth.wrapDegrees(var1.field26442.x), var1.field26442.y), field26428, 63, false);
   }

   @Subscribe
   private void method11594(FrameUpdateEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (this.field26423 != null && this.field26418) {
            BlockTrapController.Nested325 var2 = this.method11571(this.field26423.field26437, this.field26419);
            if (var2 != null) {
               this.field26424 = var2;
               this.method11593(var2);
            }
         }
      }
   }

   public static boolean method11595(List<BlockTrapController.Nested324> var0, boolean var1, boolean var2, int var3, boolean var4, boolean var5) {
      return field26413 == null ? false : field26413.method11573(var0, var1, var2, var3, var4, var5);
   }

   private boolean method11596() {
      if (this.field26415.isEmpty()) {
         return false;
      } else if (!(mc.player.pick(field26425, 1.0F, false) instanceof BlockHitResult var2 && var2.getType() == Type.BLOCK)) {
         return false;
      } else {
         if (this.field26417.contains(var2.getBlockPos())) {
            return false;
         }

         BlockPos var3 = var2.getBlockPos().relative(var2.getDirection());
         if (!mc.level.getBlockState(var3).canBeReplaced()) {
            return false;
         }

         BlockTrapController.Nested324 var4 = this.method11598(var3);
         if (var4 == null) {
            return false;
         }

         if (!this.method11577(var2, var4.field26438, var2.getBlockPos())) {
            return false;
         }

         this.method11579(var3);
         return true;
      }
   }

   @Subscribe
   private void method11597(PostPlayerInputEvent var1) {
      if (mc.player != null && mc.level != null && mc.gameMode != null) {
         this.field26417.clear();
         this.method11576();
      }
   }

   private BlockTrapController.Nested324 method11598(BlockPos var1) {
      for (BlockTrapController.Nested324 var3 : this.field26415) {
         if (var1.equals(var3.field26437)) {
            return var3;
         }
      }

      return null;
   }

   // $VF: Compiled from s
   public static class Nested324 {
      private final BlockPos field26437;
      private final Item field26438;

      public Nested324(BlockPos var1, Item var2) {
         this.field26437 = var1;
         this.field26438 = var2;
      }
   }

   // $VF: Compiled from s
   private static class Nested325 {
      private final BlockPos field26439;
      private final Vec3 field26440;
      private final Direction field26441;
      private final Vector2f field26442;

      private Nested325(BlockPos var1, Vec3 var2, Direction var3, Vector2f var4) {
         this.field26439 = var1;
         this.field26440 = var2;
         this.field26441 = var3;
         this.field26442 = var4;
      }
   }
}
