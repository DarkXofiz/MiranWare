// Original binary: hex/api/baritone/process/BuilderProcess
package hex.api.baritone.process;

import com.google.common.collect.ImmutableSet;
import hex.api.baritone.Baritone;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalBlock;
import hex.api.baritone.api.pathing.goals.GoalComposite;
import hex.api.baritone.api.pathing.goals.GoalGetToBlock;
import hex.api.baritone.api.process.IBuilderProcess;
import hex.api.baritone.api.process.PathingCommand;
import hex.api.baritone.api.process.PathingCommandType;
import hex.api.baritone.api.schematic.FillSchematic;
import hex.api.baritone.api.schematic.ISchematic;
import hex.api.baritone.api.schematic.IStaticSchematic;
import hex.api.baritone.api.schematic.MaskSchematic;
import hex.api.baritone.api.schematic.MirroredSchematic;
import hex.api.baritone.api.schematic.RotatedSchematic;
import hex.api.baritone.api.schematic.SubstituteSchematic;
import hex.api.baritone.api.schematic.format.ISchematicFormat;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.RayTraceUtils;
import hex.api.baritone.api.utils.Rotation;
import hex.api.baritone.api.utils.RotationUtils;
import hex.api.baritone.api.utils.SettingsUtil;
import hex.api.baritone.api.utils.Tuple;
import hex.api.baritone.api.utils.input.Input;
import hex.api.baritone.pathing.movement.CalculationContext;
import hex.api.baritone.pathing.movement.Movement;
import hex.api.baritone.pathing.movement.MovementHelper;
import hex.api.baritone.utils.BaritoneProcessHelper;
import hex.api.baritone.utils.BlockStateInterface;
import hex.api.baritone.utils.PathingCommandContext;
import hex.api.baritone.utils.schematic.MapArtSchematic;
import hex.api.baritone.utils.schematic.SchematicSystem;
import hex.api.baritone.utils.schematic.SelectionSchematic;
import it.unimi.dsi.fastutil.longs.LongOpenHashSet;
import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.block.AirBlock;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.PipeBlock;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.StairBlock;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import net.minecraft.world.phys.shapes.VoxelShape;

// $VF: Compiled from s
public final class BuilderProcess extends BaritoneProcessHelper implements IBuilderProcess {
   private static final Set<Property<?>> ORIENTATION_PROPS = ImmutableSet.of(
      RotatedPillarBlock.AXIS,
      HorizontalDirectionalBlock.FACING,
      StairBlock.FACING,
      StairBlock.HALF,
      StairBlock.SHAPE,
      PipeBlock.NORTH,
      new Property[]{PipeBlock.EAST, PipeBlock.SOUTH, PipeBlock.WEST, PipeBlock.UP, TrapDoorBlock.OPEN, TrapDoorBlock.HALF}
   );
   private HashSet<BetterBlockPos> incorrectPositions;
   private LongOpenHashSet observedCompleted;
   private String name;
   private ISchematic realSchematic;
   private ISchematic schematic;
   private Vec3i origin;
   private int ticks;
   private boolean paused;
   private int layer;
   private int numRepeats;
   private List<BlockState> approxPlaceable;
   public int stopAtHeight = 0;
   private static final String м衣 = "м衣";
   private static final String мц = "мц";
   private static final String мМ = "мМ";
   private static final String м5 = "м5";
   private static final String мЖ = "мЖ";
   private static final String мо = "мо";
   private static final String мК = "мК";
   private static final double мЭ = 0;
   private static final double мЪ = 0;
   private static final double мЧ = 0;
   private static final double мЩ = 0;
   private static final double мм = 0;
   private static final double мФ = 0;
   private static final double м3 = 0;
   private static final double мЬ = 0;
   private static final double м1 = 0;
   private static final double мя = 0;
   private static final double мI = 0;
   private static final double мы = 0;
   private static final double му = 0;
   private static final double мг = 0;
   private static final double мю = 0;
   private static final double м4 = 0;
   private static final double мС = 0;
   private static final double мъ = 0;
   private static final double мБ = 0;
   private static final double мв = 0;
   private static final double мр = 0;
   private static final double мй = 1.0;
   private static final double мк = 0;
   private static final double мп = 1.0;
   private static final double м2 = 0;
   private static final double м西 = 0;
   private static final String мт = "мт";
   private static final String мд = "мд";
   private static final String ме = "ме";
   private static final String м6 = "м6";
   private static final String мl = "мl";
   private static final String м必 = "м必";
   private static final String мЗ = "мЗ";
   private static final String мн = "мн";
   private static final String мД = "мД";
   private static final String мН = "мН";
   private static final double мш = 0;

   @Override
   public List<BlockState> getApproxPlaceable() {
      return new ArrayList<>(this.approxPlaceable);
   }

   private static boolean sameBlockstate(BlockState var0, BlockState var1) {
      if (var0.getBlock() != var1.getBlock()) {
         return false;
      }

      boolean var2 = Baritone.settings().buildIgnoreDirection.value;
      var sx = Baritone.settings().buildIgnoreProperties.value;
      if (!var2 && sx.isEmpty()) {
         return var0.equals(var1);
      }

      for (Property sxx : var0.getProperties()) {
         if (var0.getValue(sxx) != var1.getValue(sxx) && (!var2 || !ORIENTATION_PROPS.contains(sxx)) && !sx.contains(sxx.getName())) {
            return false;
         }
      }

      return true;
   }

   private OptionalInt hasAnyItemThatWouldPlace(BlockState var1, HitResult var2, Rotation var3) {
      for (int var4 = 0; var4 < 9; var4++) {
         ItemStack sx = this.ctx.player().getInventory().getNonEquipmentItems().get(var4);
         if (!sx.isEmpty() && sx.getItem() instanceof BlockItem) {
            float sxx = this.ctx.player().getYRot();
            float sxxx = this.ctx.player().getXRot();
            this.ctx.player().setYRot(var3.getYaw());
            this.ctx.player().setXRot(var3.getPitch());
            BlockPlaceContext sxxxx = new BlockPlaceContext(
               new UseOnContext(this.ctx.world(), this.ctx.player(), InteractionHand.MAIN_HAND, sx, (BlockHitResult)var2)            // $VF: Compiled from s
    {}
            );
            BlockState sxxxxx = ((BlockItem)sx.getItem()).getBlock().getStateForPlacement(sxxxx);
            this.ctx.player().setYRot(sxx);
            this.ctx.player().setXRot(sxxx);
            if (sxxxxx != null && sxxxx.canPlace() && valid(sxxxxx, var1, true)) {
               return OptionalInt.of(var4);
            }
         }
      }

      return OptionalInt.empty();
   }

   @Override
   public void buildOpenLitematic(int var1) {
      this.logDirect(мо);
   }

   private boolean recalc(BuilderProcess.BuilderCalculationContext var1) {
      if (this.incorrectPositions == null) {
         this.incorrectPositions = new HashSet<>();
         this.fullRecalc(var1);
         if (this.incorrectPositions.isEmpty()) {
            return false;
         }
      }

      this.recalcNearby(var1);
      if (this.incorrectPositions.isEmpty()) {
         this.fullRecalc(var1);
      }

      return !this.incorrectPositions.isEmpty();
   }

   @Override
   public void build(String var1, ISchematic var2, Vec3i var3) {
      this.name = var1;
      this.schematic = var2;
      this.realSchematic = null;
      boolean var4 = var2 instanceof SelectionSchematic;
      if (!Baritone.settings().buildSubstitutes.value.isEmpty()) {
         this.schematic = new SubstituteSchematic(this.schematic, Baritone.settings().buildSubstitutes.value);
      }

      if (Baritone.settings().buildSchematicMirror.value != Mirror.NONE) {
         this.schematic = new MirroredSchematic(this.schematic, Baritone.settings().buildSchematicMirror.value);
      }

      if (Baritone.settings().buildSchematicRotation.value != net.minecraft.world.level.block.Rotation.NONE) {
         this.schematic = new RotatedSchematic(this.schematic, Baritone.settings().buildSchematicRotation.value);
      }

      this.schematic = new MaskSchematic(this.schematic)      // $VF: Compiled from s
 {
         @Override
         public boolean partOfMask(int var1, int var2x, int var3x, BlockState var4) {
            return !Baritone.settings().buildSkipBlocks.value.contains(this.desiredState(var1, var2x, var3x, var4, Collections.emptyList()).getBlock());
         }
      };
      int sx = var3.getX();
      int sxx = var3.getY();
      int sxxx = var3.getZ();
      if (Baritone.settings().schematicOrientationX.value) {
         sx += var2.widthX();
      }

      if (Baritone.settings().schematicOrientationY.value) {
         sxx += var2.heightY();
      }

      if (Baritone.settings().schematicOrientationZ.value) {
         sxxx += var2.lengthZ();
      }

      this.origin = new Vec3i(sx, sxx, sxxx);
      this.paused = false;
      this.layer = Baritone.settings().startAtLayer.value;
      this.stopAtHeight = var2.heightY();
      if (Baritone.settings().buildOnlySelection.value && var4) {
         if (this.baritone.getSelectionManager().getSelections().length == 0) {
            this.logDirect(м衣);
            this.stopAtHeight = 0;
         } else if (Baritone.settings().buildInLayers.value) {
            OptionalInt sxxxx = Stream.of(this.baritone.getSelectionManager().getSelections()).mapToInt(var0 -> var0.min().y).min();
            OptionalInt sxxxxx = Stream.of(this.baritone.getSelectionManager().getSelections()).mapToInt(var0 -> var0.max().y).max();
            if (sxxxx.isPresent() && sxxxxx.isPresent()) {
               int sxxxxxx = Baritone.settings().layerOrder.value ? sxx + var2.heightY() - sxxxxx.getAsInt() : sxxxx.getAsInt() - sxx;
               this.stopAtHeight = (Baritone.settings().layerOrder.value ? sxx + var2.heightY() - sxxxx.getAsInt() : sxxxxx.getAsInt() - sxx) + 1;
               this.layer = Math.max(this.layer, sxxxxxx / Baritone.settings().layerHeight.value);
               this.logDebug(String.format(мц, sxx, var2.heightY()));
               this.logDebug(String.format(мМ, sxxxx.getAsInt(), sxxxxx.getAsInt()));
               this.logDebug(String.format(м5, sxxxxxx, this.stopAtHeight));
            }
         }
      }

      this.numRepeats = 0;
      this.observedCompleted = new LongOpenHashSet();
      this.incorrectPositions = null;
   }

   @Override
   public Optional<Integer> getMinLayer() {
      return Baritone.settings().buildInLayers.value ? Optional.of(this.layer) : Optional.empty();
   }

   private Optional<Tuple<BetterBlockPos, Rotation>> toBreakNearPlayer(BuilderProcess.BuilderCalculationContext var1) {
      BetterBlockPos var2 = this.ctx.playerFeet();
      BetterBlockPos sx = this.baritone.getPathingBehavior().pathStart();

      for (int sxx = -5; sxx <= 5; sxx++) {
         for (int sxxx = Baritone.settings().breakFromAbove.value ? -1 : 0; sxxx <= 5; sxxx++) {
            for (int sxxxx = -5; sxxxx <= 5; sxxxx++) {
               int sxxxxx = var2.x + sxx;
               int sxxxxxx = var2.y + sxxx;
               int sxxxxxxx = var2.z + sxxxx;
               if (sxxx != -1 || sxxxxx != sx.x || sxxxxxxx != sx.z) {
                  BlockState sxxxxxxxx = var1.getSchematic(sxxxxx, sxxxxxx, sxxxxxxx, var1.bsi.get0(sxxxxx, sxxxxxx, sxxxxxxx));
                  if (sxxxxxxxx != null) {
                     BlockState sxxxxxxxxx = var1.bsi.get0(sxxxxx, sxxxxxx, sxxxxxxx);
                     if (!(sxxxxxxxxx.getBlock() instanceof AirBlock)
                        && sxxxxxxxxx.getBlock() != Blocks.WATER
                        && sxxxxxxxxx.getBlock() != Blocks.LAVA
                        && !valid(sxxxxxxxxx, sxxxxxxxx, false)) {
                        BetterBlockPos sxxxxxxxxxx = new BetterBlockPos(sxxxxx, sxxxxxx, sxxxxxxx);
                        Optional<Rotation> sxxxxxxxxxxx = RotationUtils.reachable(this.ctx, sxxxxxxxxxx, this.ctx.playerController().getBlockReachDistance());
                        if (sxxxxxxxxxxx.isPresent()) {
                           return Optional.of(new Tuple<>(sxxxxxxxxxx, sxxxxxxxxxxx.get()));
                        }
                     }
                  }
               }
            }
         }
      }

      return Optional.empty();
   }

   private PathingCommand onTick(boolean var1, boolean var2, int var3) {
      if (var3 > 100) {
         return new PathingCommand(null, PathingCommandType.SET_GOAL_AND_PATH);
      }

      this.approxPlaceable = this.approxPlaceable(36);
      if (this.baritone.getInputOverrideHandler().isInputForcedDown(Input.CLICK_LEFT)) {
         this.ticks = 5;
      } else {
         this.ticks--;
      }

      this.baritone.getInputOverrideHandler().clearAllKeys();
      if (this.paused) {
         return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
      }

      if (Baritone.settings().buildInLayers.value) {
         if (this.realSchematic == null) {
            this.realSchematic = this.schematic;
         }

         final ISchematic var4 = this.realSchematic;
         final int sx;
         final int sxx;
         if (Baritone.settings().layerOrder.value) {
            sxx = var4.heightY() - 1;
            sx = var4.heightY() - this.layer * Baritone.settings().layerHeight.value;
         } else {
            sxx = this.layer * Baritone.settings().layerHeight.value - 1;
            sx = 0;
         }

         this.schematic = new ISchematic()         // $VF: Compiled from s
 {
            @Override
            public int heightY() {
               return var4.heightY();
            }

            @Override
            public int lengthZ() {
               return var4.lengthZ();
            }

            @Override
            public BlockState desiredState(int var1, int var2x, int var3x, BlockState var4x, List<BlockState> var5x) {
               return var4.desiredState(var1, var2x, var3x, var4x, BuilderProcess.this.approxPlaceable);
            }

            @Override
            public int widthX() {
               return var4.widthX();
            }

            @Override
            public boolean inSchematic(int var1, int var2x, int var3x, BlockState var4x) {
               return ISchematic.super.inSchematic(var1, var2x, var3x, var4x) && var2x >= sx && var2x <= sxx && var4.inSchematic(var1, var2x, var3x, var4x);
            }

            @Override
            public void reset() {
               var4.reset();
            }
         };
      }

      BuilderProcess.BuilderCalculationContext var13 = new BuilderProcess.BuilderCalculationContext();
      if (!this.recalc(var13)) {
         if (Baritone.settings().buildInLayers.value && this.layer * Baritone.settings().layerHeight.value < this.stopAtHeight) {
            this.logDirect("Starting layer " + this.layer);
            this.layer++;
            return this.onTick(var1, var2, var3 + 1);
         }

         Vec3i sx = Baritone.settings().buildRepeat.value;
         int sxx = Baritone.settings().buildRepeatCount.value;
         this.numRepeats++;
         if (sx.equals(new Vec3i(0, 0, 0)) || sxx != -1 && this.numRepeats >= sxx) {
            this.logDirect(мт);
            if (Baritone.settings().notificationOnBuildFinished.value) {
               this.logNotification(мд, false);
            }

            this.onLostControl();
            return null;
         } else {
            this.layer = 0;
            this.origin = new BlockPos(this.origin.getX(), this.origin.getY(), this.origin.getZ()).offset(sx);
            if (!Baritone.settings().buildRepeatSneaky.value) {
               this.schematic.reset();
            }

            this.logDirect("Repeating build in vector " + sx + ", new origin is " + this.origin);
            return this.onTick(var1, var2, var3 + 1);
         }
      } else {
         if (Baritone.settings().distanceTrim.value) {
            this.trim();
         }

         var sx = this.toBreakNearPlayer(var13);
         if (sx.isPresent() && var2 && this.ctx.player().onGround()) {
            Rotation sxx = sx.get().getB();
            BetterBlockPos sxxx = sx.get().getA();
            this.baritone.getLookBehavior().updateTarget(sxx, true);
            MovementHelper.switchToBestToolFor(this.ctx, var13.get(sxxx));
            if (this.ctx.player().isCrouching()) {
               this.baritone.getInputOverrideHandler().setInputForceState(Input.SNEAK, true);
            }

            if (this.ctx.isLookingAt(sxxx) || this.ctx.playerRotations().isReallyCloseTo(sxx)) {
               this.baritone.getInputOverrideHandler().setInputForceState(Input.CLICK_LEFT, true);
            }

            return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
         } else {
            List<BlockState> sxx = new ArrayList<>();
            Optional<BuilderProcess.Placement> sxxx = this.searchForPlacables(var13, sxx);
            if (sxxx.isPresent() && var2 && this.ctx.player().onGround() && this.ticks <= 0) {
               Rotation sxxxx = sxxx.get().rot;
               this.baritone.getLookBehavior().updateTarget(sxxxx, true);
               this.ctx.player().getInventory().setSelectedSlot(sxxx.get().hotbarSelection);
               this.baritone.getInputOverrideHandler().setInputForceState(Input.SNEAK, true);
               if (this.ctx.isLookingAt(sxxx.get().placeAgainst) && ((BlockHitResult)this.ctx.objectMouseOver()).getDirection().equals(sxxx.get().side)
                  || this.ctx.playerRotations().isReallyCloseTo(sxxxx)) {
                  this.baritone.getInputOverrideHandler().setInputForceState(Input.CLICK_RIGHT, true);
               }

               return new PathingCommand(null, PathingCommandType.CANCEL_AND_SET_GOAL);
            } else {
               if (Baritone.settings().allowInventory.value) {
                  ArrayList sxxxx = new ArrayList<>();
                  List sxxxxx = new ArrayList<>();

                  label155:
                  for (BlockState sxxxxxx : sxx) {
                     for (int sxxxxxxx = 0; sxxxxxxx < 9; sxxxxxxx++) {
                        if (valid(this.approxPlaceable.get(sxxxxxxx), sxxxxxx, true)) {
                           sxxxx.add(sxxxxxxx);
                           continue label155;
                        }
                     }

                     sxxxxx.add(sxxxxxx);
                  }

                  label141:
                  for (int sxxxxxx = 9; sxxxxxx < 36; sxxxxxx++) {
                     for (BlockState sxxxxxxx : (Iterable<BlockState>) (Iterable) sxxxxx) {
                        if (valid(this.approxPlaceable.get(sxxxxxx), sxxxxxxx, true)) {
                           if (!this.baritone.getInventoryBehavior().attemptToPutOnHotbar(sxxxxxx, sxxxx::contains)) {
                              return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
                           }
                           break label141;
                        }
                     }
                  }
               }

               Goal sxxxx = this.assemble(var13, this.approxPlaceable.subList(0, 9));
               if (sxxxx == null) {
                  sxxxx = this.assemble(var13, this.approxPlaceable, true);
                  if (sxxxx == null) {
                     if (Baritone.settings().skipFailedLayers.value
                        && Baritone.settings().buildInLayers.value
                        && this.layer * Baritone.settings().layerHeight.value < this.realSchematic.heightY()) {
                        this.logDirect("Skipping layer that I cannot construct! Layer #" + this.layer);
                        this.layer++;
                        return this.onTick(var1, var2, var3 + 1);
                     }

                     this.logDirect(ме);
                     this.paused = true;
                     return new PathingCommand(null, PathingCommandType.REQUEST_PAUSE);
                  }
               }

               return new PathingCommandContext(sxxxx, PathingCommandType.FORCE_REVALIDATE_GOAL_AND_PATH, var13);
            }
         }
      }
   }

   @Override
   public Optional<Integer> getMaxLayer() {
      return Baritone.settings().buildInLayers.value ? Optional.of(this.stopAtHeight) : Optional.empty();
   }

   @Override
   public void onLostControl() {
      this.incorrectPositions = null;
      this.name = null;
      this.schematic = null;
      this.realSchematic = null;
      this.layer = Baritone.settings().startAtLayer.value;
      this.numRepeats = 0;
      this.paused = false;
      this.observedCompleted = null;
   }

   private void trim() {
      HashSet<BetterBlockPos> var1 = new HashSet<>(this.incorrectPositions);
      var1.removeIf(var1x -> var1x.distSqr(this.ctx.player().blockPosition()) > мш);
      if (!var1.isEmpty()) {
         this.incorrectPositions = var1;
      }
   }

   public BuilderProcess(Baritone var1) {
      super(var1);
   }

   private Goal assemble(BuilderProcess.BuilderCalculationContext var1, List<BlockState> var2) {
      return this.assemble(var1, var2, false);
   }

   @Override
   public boolean isActive() {
      return this.schematic != null;
   }

   private Goal breakGoal(BlockPos var1, BuilderProcess.BuilderCalculationContext var2) {
      return Baritone.settings().goalBreakFromAbove.value
            && var2.bsi.get0(var1.above()).getBlock() instanceof AirBlock
            && var2.bsi.get0(var1.above(2)).getBlock() instanceof AirBlock
         ? new BuilderProcess.JankyGoalComposite(new BuilderProcess.GoalBreak(var1), new GoalGetToBlock(var1.above())      // $VF: Compiled from s
    {
            @Override
            public boolean isInGoal(int var1, int var2x, int var3) {
               return var2x <= this.y && (var1 != this.x || var2x != this.y || var3 != this.z) ? super.isInGoal(var1, var2x, var3) : false;
            }
         })
         : new BuilderProcess.GoalBreak(var1);
   }


   private void fullRecalc(BuilderProcess.BuilderCalculationContext var1) {
      this.incorrectPositions = new HashSet<>();

      for (int var2 = 0; var2 < this.schematic.heightY(); var2++) {
         for (int sx = 0; sx < this.schematic.lengthZ(); sx++) {
            for (int sxx = 0; sxx < this.schematic.widthX(); sxx++) {
               int sxxx = sxx + this.origin.getX();
               int sxxxx = var2 + this.origin.getY();
               int sxxxxx = sx + this.origin.getZ();
               BlockState sxxxxxx = var1.bsi.get0(sxxx, sxxxx, sxxxxx);
               if (this.schematic.inSchematic(sxx, var2, sx, sxxxxxx)) {
                  if (var1.bsi.worldContainsLoadedChunk(sxxx, sxxxxx)) {
                     if (valid(var1.bsi.get0(sxxx, sxxxx, sxxxxx), this.schematic.desiredState(sxx, var2, sx, sxxxxxx, this.approxPlaceable), false)) {
                        this.observedCompleted.add(BetterBlockPos.longHash(sxxx, sxxxx, sxxxxx));
                     } else {
                        this.incorrectPositions.add(new BetterBlockPos(sxxx, sxxxx, sxxxxx));
                        this.observedCompleted.remove(BetterBlockPos.longHash(sxxx, sxxxx, sxxxxx));
                        if (this.incorrectPositions.size() > Baritone.settings().incorrectSize.value) {
                           return;
                        }
                     }
                  } else if (!this.observedCompleted.contains(BetterBlockPos.longHash(sxxx, sxxxx, sxxxxx))) {
                     this.incorrectPositions.add(new BetterBlockPos(sxxx, sxxxx, sxxxxx));
                     if (this.incorrectPositions.size() > Baritone.settings().incorrectSize.value) {
                        return;
                     }
                  }
               }
            }
         }
      }
   }

   private Optional<BuilderProcess.Placement> possibleToPlace(BlockState var1, int var2, int var3, int var4, BlockStateInterface var5) {
      for (Direction var9 : Direction.values()) {
         BetterBlockPos sx = new BetterBlockPos(var2, var3, var4).relative(var9);
         BlockState sxx = var5.get0(sx);
         if (!MovementHelper.isReplaceable(sx.x, sx.y, sx.z, sxx, var5)
            && var1.canSurvive(this.ctx.world(), new BetterBlockPos(var2, var3, var4))
            && this.placementPlausible(new BetterBlockPos(var2, var3, var4), var1)) {
            VoxelShape sxxx = sxx.getShape(this.ctx.world(), sx);
            if (!sxxx.isEmpty()) {
               AABB sxxxx = sxxx.bounds();

               for (Vec3 sxxxxx : aabbSideMultipliers(var9)) {
                  double sxxxxxx = sx.x + sxxxx.minX * sxxxxx.x + sxxxx.maxX * (1.0 - sxxxxx.x);
                  double sxxxxxxx = sx.y + sxxxx.minY * sxxxxx.y + sxxxx.maxY * (1.0 - sxxxxx.y);
                  double sxxxxxxxx = sx.z + sxxxx.minZ * sxxxxx.z + sxxxx.maxZ * (1.0 - sxxxxx.z);
                  Rotation sxxxxxxxxx = RotationUtils.calcRotationFromVec3d(
                     RayTraceUtils.inferSneakingEyePosition(this.ctx.player()), new Vec3(sxxxxxx, sxxxxxxx, sxxxxxxxx), this.ctx.playerRotations()
                  );
                  Rotation sxxxxxxxxxx = this.baritone.getLookBehavior().getAimProcessor().peekRotation(sxxxxxxxxx);
                  HitResult sxxxxxxxxxxx = RayTraceUtils.rayTraceTowards(
                     this.ctx.player(), sxxxxxxxxxx, this.ctx.playerController().getBlockReachDistance(), true
                  );
                  if (sxxxxxxxxxxx != null
                     && sxxxxxxxxxxx.getType() == Type.BLOCK
                     && ((BlockHitResult)sxxxxxxxxxxx).getBlockPos().equals(sx)
                     && ((BlockHitResult)sxxxxxxxxxxx).getDirection() == var9.getOpposite()) {
                     OptionalInt sxxxxxxxxxxxx = this.hasAnyItemThatWouldPlace(var1, sxxxxxxxxxxx, sxxxxxxxxxx);
                     if (sxxxxxxxxxxxx.isPresent()) {
                        return Optional.of(new BuilderProcess.Placement(sxxxxxxxxxxxx.getAsInt(), sx, var9.getOpposite(), sxxxxxxxxx));
                     }
                  }
               }
            }
         }
      }

      return Optional.empty();
   }

   private Optional<BuilderProcess.Placement> searchForPlacables(BuilderProcess.BuilderCalculationContext var1, List<BlockState> var2) {
      BetterBlockPos var3 = this.ctx.playerFeet();

      for (int sx = -5; sx <= 5; sx++) {
         for (int sxx = -5; sxx <= 1; sxx++) {
            for (int sxxx = -5; sxxx <= 5; sxxx++) {
               int sxxxx = var3.x + sx;
               int sxxxxx = var3.y + sxx;
               int sxxxxxx = var3.z + sxxx;
               BlockState sxxxxxxx = var1.getSchematic(sxxxx, sxxxxx, sxxxxxx, var1.bsi.get0(sxxxx, sxxxxx, sxxxxxx));
               if (sxxxxxxx != null) {
                  BlockState sxxxxxxxx = var1.bsi.get0(sxxxx, sxxxxx, sxxxxxx);
                  if (MovementHelper.isReplaceable(sxxxx, sxxxxx, sxxxxxx, sxxxxxxxx, var1.bsi)
                     && !valid(sxxxxxxxx, sxxxxxxx, false)
                     && (sxx != 1 || !(var1.bsi.get0(sxxxx, sxxxxx + 1, sxxxxxx).getBlock() instanceof AirBlock))) {
                     var2.add(sxxxxxxx);
                     var sxxxxxxxxx = this.possibleToPlace(sxxxxxxx, sxxxx, sxxxxx, sxxxxxx, var1.bsi);
                     if (sxxxxxxxxx.isPresent()) {
                        return sxxxxxxxxx;
                     }
                  }
               }
            }
         }
      }

      return Optional.empty();
   }

   @Override
   public void buildOpenSchematic() {
      this.logDirect(мЖ);
   }

   private Goal assemble(BuilderProcess.BuilderCalculationContext var1, List<BlockState> var2, boolean var3) {
      List<BetterBlockPos> var4 = new ArrayList<>();
      List<BetterBlockPos> sx = new ArrayList<>();
      List<BetterBlockPos> sxx = new ArrayList<>();
      List<BetterBlockPos> sxxx = new ArrayList<>();
      Map<BlockState, Integer> sxxxx = new HashMap<>();
      List<BetterBlockPos> sxxxxx = new ArrayList<>();
      this.incorrectPositions.forEach(var8x -> {
         BlockState sxxxxxx = var1.bsi.get0(var8x);
         if (sxxxxxx.getBlock() instanceof AirBlock) {
            BlockState desired = var1.getSchematic(var8x.x, var8x.y, var8x.z, sxxxxxx);
            if (desired == null) {
               sxxxxx.add(var8x);
            } else if (containsBlockState(var2, desired)) {
               var4.add(var8x);
            } else {
               sxxxx.put(desired, 1 + sxxxx.getOrDefault(desired, 0));
            }
         } else if (sxxxxxx.getBlock() instanceof LiquidBlock) {
            if (!MovementHelper.possiblyFlowing(sxxxxxx)) {
               sxx.add(var8x);
            } else {
               sxxx.add(var8x);
            }
         } else {
            sx.add(var8x);
         }
      });
      this.incorrectPositions.removeAll(sxxxxx);
      List<Goal> sxxxxxx = new ArrayList<>();
      sx.forEach(var3x -> sxxxxxx.add(this.breakGoal(var3x, var1)));
      List<Goal> sxxxxxxx = new ArrayList<>();
      var4.forEach(var4x -> {
         if (!var4.contains(var4x.below()) && !var4.contains(var4x.below(2))) {
            sxxxxxxx.add(this.placementGoal(var4x, var1));
         }
      });
      sxx.forEach(var1x -> sxxxxxxx.add(new GoalBlock(var1x.above())));
      if (!sxxxxxxx.isEmpty()) {
         return new BuilderProcess.JankyGoalComposite(new GoalComposite((Goal[]) sxxxxxxx.toArray(new Goal[0])), new GoalComposite((Goal[]) sxxxxxx.toArray(new Goal[0])));
      }

      if (sxxxxxx.isEmpty()) {
         if (var3 && !sxxxx.isEmpty()) {
            this.logDirect(м6);
            this.logDirect(sxxxx.entrySet().stream().map(var0 -> String.format(мН, var0.getValue(), var0.getKey())).collect(Collectors.joining(мl)));
         }

         if (var3 && !sxxx.isEmpty()) {
            this.logDirect(м必);
            this.logDirect(sxxx.stream().map(var0 -> String.format(мД, var0.x, var0.y, var0.z)).collect(Collectors.joining(мЗ)));
         }

         return null;
      } else {
         return new GoalComposite((Goal[]) sxxxxxx.toArray(new Goal[0]));
      }
   }

   @Override
   public void resume() {
      this.paused = false;
   }

   private ISchematic applyMapArtAndSelection(Vec3i var1, IStaticSchematic var2) {
      ISchematic var3 = var2;
      if (Baritone.settings().mapArtMode.value) {
         var3 = new MapArtSchematic(var2);
      }

      if (Baritone.settings().buildOnlySelection.value) {
         var3 = new SelectionSchematic(var3, var1, this.baritone.getSelectionManager().getSelections());
      }

      return var3;
   }

   @Override
   public String displayName0() {
      return this.paused ? мн : "Building " + this.name;
   }

   @Override
   public void pause() {
      this.paused = true;
   }

   @Override
   public PathingCommand onTick(boolean var1, boolean var2) {
      return this.onTick(var1, var2, 0);
   }

   private Goal placementGoal(BlockPos var1, BuilderProcess.BuilderCalculationContext var2) {
      if (!(this.ctx.world().getBlockState(var1).getBlock() instanceof AirBlock)) {
         return new BuilderProcess.GoalPlace(var1);
      }

      boolean var3 = !(this.ctx.world().getBlockState(var1.above()).getBlock() instanceof AirBlock);
      BlockState sx = this.ctx.world().getBlockState(var1);

      for (Direction sxx : Movement.HORIZONTALS_BUT_ALSO_DOWN_____SO_EVERY_DIRECTION_EXCEPT_UP) {
         if (MovementHelper.canPlaceAgainst(this.ctx, var1.relative(sxx))
            && this.placementPlausible(var1, var2.getSchematic(var1.getX(), var1.getY(), var1.getZ(), sx))) {
            return new BuilderProcess.GoalAdjacent(var1, var1.relative(sxx), var3);
         }
      }

      return new BuilderProcess.GoalPlace(var1);
   }

   @Override
   public boolean build(String var1, File var2, Vec3i var3) {
      Optional<ISchematicFormat> var4 = SchematicSystem.INSTANCE.getByFile(var2);
      if (!var4.isPresent()) {
         return false;
      }

      IStaticSchematic sx;
      try {
         sx = var4.get().parse(new FileInputStream(var2));
      } catch (Exception sxx) {
         return false;
      }

      ISchematic sxx = this.applyMapArtAndSelection(var3, sx);
      this.build(var1, sxx, var3);
      return true;
   }

   private static boolean valid(BlockState var0, BlockState var1, boolean var2) {
      if (var1 == null) {
         return true;
      } else if (var0.getBlock() instanceof LiquidBlock && Baritone.settings().okIfWater.value) {
         return true;
      } else if (var0.getBlock() instanceof AirBlock && var1.getBlock() instanceof AirBlock) {
         return true;
      } else if (var0.getBlock() instanceof AirBlock && Baritone.settings().okIfAir.value.contains(var1.getBlock())) {
         return true;
      } else if (var1.getBlock() instanceof AirBlock && Baritone.settings().buildIgnoreBlocks.value.contains(var0.getBlock())) {
         return true;
      } else if (!(var0.getBlock() instanceof AirBlock) && Baritone.settings().buildIgnoreExisting.value && !var2) {
         return true;
      } else if (Baritone.settings().buildValidSubstitutes.value.getOrDefault(var1.getBlock(), Collections.emptyList()).contains(var0.getBlock()) && !var2) {
         return true;
      } else {
         return var0.equals(var1) ? true : sameBlockstate(var0, var1);
      }
   }

   public boolean placementPlausible(BlockPos var1, BlockState var2) {
      VoxelShape var3 = var2.getCollisionShape(this.ctx.world(), var1);
      return var3.isEmpty() || this.ctx.world().isUnobstructed(null, var3.move(var1.getX(), var1.getY(), var1.getZ()));
   }

   public BlockState placeAt(int var1, int var2, int var3, BlockState var4) {
      if (!this.isActive()) {
         return null;
      }

      if (!this.schematic.inSchematic(var1 - this.origin.getX(), var2 - this.origin.getY(), var3 - this.origin.getZ(), var4)) {
         return null;
      }

      BlockState var5 = this.schematic
         .desiredState(var1 - this.origin.getX(), var2 - this.origin.getY(), var3 - this.origin.getZ(), var4, this.approxPlaceable);
      return var5.getBlock() instanceof AirBlock ? null : var5;
   }

   @Override
   public void clearArea(BlockPos var1, BlockPos var2) {
      BlockPos var3 = new BlockPos(Math.min(var1.getX(), var2.getX()), Math.min(var1.getY(), var2.getY()), Math.min(var1.getZ(), var2.getZ()));
      int sx = Math.abs(var1.getX() - var2.getX()) + 1;
      int sxx = Math.abs(var1.getY() - var2.getY()) + 1;
      int sxxx = Math.abs(var1.getZ() - var2.getZ()) + 1;
      this.build(мК, new FillSchematic(sx, sxx, sxxx, Blocks.AIR.defaultBlockState()), var3);
   }

   @Override
   public boolean isPaused() {
      return this.paused;
   }

   private void recalcNearby(BuilderProcess.BuilderCalculationContext var1) {
      BetterBlockPos var2 = this.ctx.playerFeet();
      int sx = Baritone.settings().builderTickScanRadius.value;

      for (int sxx = -sx; sxx <= sx; sxx++) {
         for (int sxxx = -sx; sxxx <= sx; sxxx++) {
            for (int sxxxx = -sx; sxxxx <= sx; sxxxx++) {
               int sxxxxx = var2.x + sxx;
               int sxxxxxx = var2.y + sxxx;
               int sxxxxxxx = var2.z + sxxxx;
               BlockState sxxxxxxxx = var1.getSchematic(sxxxxx, sxxxxxx, sxxxxxxx, var1.bsi.get0(sxxxxx, sxxxxxx, sxxxxxxx));
               if (sxxxxxxxx != null) {
                  BetterBlockPos sxxxxxxxxx = new BetterBlockPos(sxxxxx, sxxxxxx, sxxxxxxx);
                  if (valid(var1.bsi.get0(sxxxxx, sxxxxxx, sxxxxxxx), sxxxxxxxx, false)) {
                     this.incorrectPositions.remove(sxxxxxxxxx);
                     this.observedCompleted.add(BetterBlockPos.longHash(sxxxxxxxxx));
                  } else {
                     this.incorrectPositions.add(sxxxxxxxxx);
                     this.observedCompleted.remove(BetterBlockPos.longHash(sxxxxxxxxx));
                  }
               }
            }
         }
      }
   }

   private List<BlockState> approxPlaceable(int var1) {
      List var2 = new ArrayList<>();

      for (int sx = 0; sx < var1; sx++) {
         final ItemStack sxx = this.ctx.player().getInventory().getNonEquipmentItems().get(sx);
         if (!sxx.isEmpty() && sxx.getItem() instanceof BlockItem) {
            BlockState sxxx = ((BlockItem)sxx.getItem())
               .getBlock()
               .getStateForPlacement(
                  new BlockPlaceContext(
                     new UseOnContext(
                        this.ctx.world(),
                        this.ctx.player(),
                        InteractionHand.MAIN_HAND,
                        sxx,
                        new BlockHitResult(
                           new Vec3(this.ctx.player().position().x, this.ctx.player().position().y, this.ctx.player().position().z),
                           Direction.UP,
                           this.ctx.playerFeet(),
                           false
                        )
                     )            // $VF: Compiled from s
          {}
                  )
               );
            if (sxxx != null) {
               var2.add(sxxx);
            } else {
               var2.add(Blocks.AIR.defaultBlockState());
            }
         } else {
            var2.add(Blocks.AIR.defaultBlockState());
         }
      }

      return var2;
   }

   private static Vec3[] aabbSideMultipliers(Direction var0) {
      switch (var0) {
         case UP:
            return new Vec3[]{new Vec3(мЭ, 1.0, мЪ), new Vec3(мЧ, 1.0, мЩ), new Vec3(мм, 1.0, мФ), new Vec3(м3, 1.0, мЬ), new Vec3(м1, 1.0, мя)};
         case DOWN:
            return new Vec3[]{new Vec3(мI, 0.0, мы), new Vec3(му, 0.0, мг), new Vec3(мю, 0.0, м4), new Vec3(мС, 0.0, мъ), new Vec3(мБ, 0.0, мв)};
         case NORTH:
         case SOUTH:
         case EAST:
         case WEST:
            double var1 = var0.getStepX() == 0 ? мр : (1 + var0.getStepX()) / мй;
            double sx = var0.getStepZ() == 0 ? мк : (1 + var0.getStepZ()) / мп;
            return new Vec3[]{new Vec3(var1, м2, sx), new Vec3(var1, м西, sx)};
         default:
            throw new IllegalStateException("Unexpected side " + var0);
      }
   }

   private static boolean containsBlockState(Collection<BlockState> var0, BlockState var1) {
      for (BlockState var3 : var0) {
         if (sameBlockstate(var3, var1)) {
            return true;
         }
      }

      return false;
   }

   // $VF: Compiled from s
   public class BuilderCalculationContext extends CalculationContext {
      private final List<BlockState> placeable = BuilderProcess.this.approxPlaceable(9);
      private final ISchematic schematic;
      private final int originX;
      private final int originY;
      private final int originZ;
      private static final double 诶Ы必 = 0;
      private static final double 诶ЫЗ = 0;
      private static final double 诶Ын = 0;
      private static final double 诶ЫД = 0;
      private static final double 诶ЫН = 0;
      private static final double 诶Ыш = 0;

      @Override
      public double costOfPlacingAt(int var1, int var2, int var3, BlockState var4) {
         if (!this.isPossiblyProtected(var1, var2, var3) && this.worldBorder.canPlaceAt(var1, var3)) {
            BlockState var5 = this.getSchematic(var1, var2, var3, var4);
            if (var5 != null) {
               if (var5.getBlock() instanceof AirBlock) {
                  return this.placeBlockCost * Baritone.settings().placeIncorrectBlockPenaltyMultiplier.value;
               } else if (this.placeable.contains(var5)) {
                  return 0.0;
               } else {
                  return !this.hasThrowaway ? 诶Ын : this.placeBlockCost * 诶ЫД * Baritone.settings().placeIncorrectBlockPenaltyMultiplier.value;
               }
            } else {
               return this.hasThrowaway ? this.placeBlockCost : 诶ЫН;
            }
         } else {
            return 诶ЫЗ;
         }
      }

      public BuilderCalculationContext() {
         super(BuilderProcess.this.baritone, true);
         this.schematic = BuilderProcess.this.schematic;
         this.originX = BuilderProcess.this.origin.getX();
         this.originY = BuilderProcess.this.origin.getY();
         this.originZ = BuilderProcess.this.origin.getZ();
         this.jumpPenalty = this.jumpPenalty + 诶Ы必;
         this.backtrackCostFavoringCoefficient = 1.0;
      }

      @Override
      public double breakCostMultiplierAt(int var1, int var2, int var3, BlockState var4) {
         if ((this.allowBreak || this.allowBreakAnyway.contains(var4.getBlock())) && !this.isPossiblyProtected(var1, var2, var3)) {
            BlockState var5 = this.getSchematic(var1, var2, var3, var4);
            if (var5 == null) {
               return 1.0;
            } else if (var5.getBlock() instanceof AirBlock) {
               return 1.0;
            } else {
               return BuilderProcess.valid(this.bsi.get0(var1, var2, var3), var5, false) ? Baritone.settings().breakCorrectBlockPenaltyMultiplier.value : 1.0;
            }
         } else {
            return 诶Ыш;
         }
      }

      private BlockState getSchematic(int var1, int var2, int var3, BlockState var4) {
         return this.schematic.inSchematic(var1 - this.originX, var2 - this.originY, var3 - this.originZ, var4)
            ? this.schematic.desiredState(var1 - this.originX, var2 - this.originY, var3 - this.originZ, var4, BuilderProcess.this.approxPlaceable)
            : null;
      }

   }

   // $VF: Compiled from s
   public static class GoalAdjacent extends GoalGetToBlock {
      private boolean allowSameLevel;
      private BlockPos no;
      private static final int бщп = 0;
      private static final int бщ2 = 0;
      private static final int бщ西 = 0;
      private static final int бщт = 0;
      private static final int бщд = 0;
      private static final int бще = 0;
      private static final String бщ6 = "бщ6";

      @Override
      public double heuristic(int var1, int var2, int var3) {
         return this.y * 100 + super.heuristic(var1, var2, var3);
      }

      @Override
      public String toString() {
         return String.format(бщ6, SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
      }


      @Override
      public boolean isInGoal(int var1, int var2, int var3) {
         if (var1 == this.x && var2 == this.y && var3 == this.z) {
            return false;
         } else if (var1 == this.no.getX() && var2 == this.no.getY() && var3 == this.no.getZ()) {
            return false;
         } else if (!this.allowSameLevel && var2 == this.y - 1) {
            return false;
         } else {
            return var2 < this.y - 1 ? false : super.isInGoal(var1, var2, var3);
         }
      }

      @Override
      public boolean equals(Object var1) {
         if (!super.equals(var1)) {
            return false;
         }

         BuilderProcess.GoalAdjacent var2 = (BuilderProcess.GoalAdjacent)var1;
         return this.allowSameLevel == var2.allowSameLevel && Objects.equals(this.no, var2.no);
      }

      public GoalAdjacent(BlockPos var1, BlockPos var2, boolean var3) {
         super(var1);
         this.no = var2;
         this.allowSameLevel = var3;
      }

      @Override
      public int hashCode() {
         int var1 = бщп;
         var1 = var1 * бщ2 + super.hashCode();
         var1 = var1 * бщ西 + (int)BetterBlockPos.longHash(this.no.getX(), this.no.getY(), this.no.getZ());
         return var1 * бщт + (this.allowSameLevel ? бщд : бще);
      }
   }

   // $VF: Compiled from s
   public static class GoalBreak extends GoalGetToBlock {
      private static final String 诶Р7 = "诶Р7";
      private static final int 诶РУ = 0;

      @Override
      public String toString() {
         return String.format(诶Р7, SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
      }

      public GoalBreak(BlockPos var1) {
         super(var1);
      }

      @Override
      public int hashCode() {
         return super.hashCode() * 诶РУ;
      }

      @Override
      public boolean isInGoal(int var1, int var2, int var3) {
         return var2 > this.y ? false : super.isInGoal(var1, var2, var3);
      }

   }

   // $VF: Compiled from s
   public static class GoalPlace extends GoalBlock {
      private static final int бь西 = 0;
      private static final String бьт = "бьт";

      public GoalPlace(BlockPos var1) {
         super(var1.above());
      }

      @Override
      public int hashCode() {
         return super.hashCode() * бь西;
      }

      @Override
      public double heuristic(int var1, int var2, int var3) {
         return this.y * 100 + super.heuristic(var1, var2, var3);
      }

      @Override
      public String toString() {
         return String.format(бьт, SettingsUtil.maybeCensor(this.x), SettingsUtil.maybeCensor(this.y), SettingsUtil.maybeCensor(this.z));
      }

   }

   // $VF: Compiled from s
   public static class JankyGoalComposite implements Goal {
      private final Goal primary;
      private final Goal fallback;
      private static final int шЗ = 0;
      private static final int шн = 0;
      private static final int шД = 0;

      @Override
      public int hashCode() {
         int var1 = шЗ;
         var1 = var1 * шн + this.primary.hashCode();
         return var1 * шД + this.fallback.hashCode();
      }

      @Override
      public boolean equals(Object var1) {
         if (this == var1) {
            return true;
         } else if (var1 != null && this.getClass() == var1.getClass()) {
            BuilderProcess.JankyGoalComposite var2 = (BuilderProcess.JankyGoalComposite)var1;
            return Objects.equals(this.primary, var2.primary) && Objects.equals(this.fallback, var2.fallback);
         } else {
            return false;
         }
      }

      @Override
      public boolean isInGoal(int var1, int var2, int var3) {
         return this.primary.isInGoal(var1, var2, var3) || this.fallback.isInGoal(var1, var2, var3);
      }

      @Override
      public double heuristic(int var1, int var2, int var3) {
         return this.primary.heuristic(var1, var2, var3);
      }


      public JankyGoalComposite(Goal var1, Goal var2) {
         this.primary = var1;
         this.fallback = var2;
      }

      @Override
      public String toString() {
         return "JankyComposite Primary: " + this.primary + " Fallback: " + this.fallback;
      }
   }

   // $VF: Compiled from s
   public static class Placement {
      private final int hotbarSelection;
      private final BlockPos placeAgainst;
      private final Direction side;
      private final Rotation rot;

      public Placement(int var1, BlockPos var2, Direction var3, Rotation var4) {
         this.hotbarSelection = var1;
         this.placeAgainst = var2;
         this.side = var3;
         this.rot = var4;
      }
   }
}
