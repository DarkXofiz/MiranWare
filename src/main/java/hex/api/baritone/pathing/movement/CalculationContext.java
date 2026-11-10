// Original binary: hex/api/baritone/pathing/movement/CalculationContext
package hex.api.baritone.pathing.movement;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.cache.WorldData;
import hex.api.baritone.pathing.precompute.PrecomputedData;
import hex.api.baritone.utils.BlockStateInterface;
import hex.api.baritone.utils.ToolSet;
import hex.api.baritone.utils.pathing.BetterWorldBorder;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.enchantment.effects.EnchantmentAttributeEffect;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class CalculationContext {
   private static final ItemStack STACK_BUCKET_WATER = new ItemStack(Items.WATER_BUCKET);
   public final boolean safeForThreadedUse;
   public final IBaritone baritone;
   public final Level world;
   public final WorldData worldData;
   public final BlockStateInterface bsi;
   public final ToolSet toolSet;
   public final boolean hasWaterBucket;
   public final boolean hasThrowaway;
   public final boolean canSprint;
   protected final double placeBlockCost;
   public final boolean allowBreak;
   public final List<Block> allowBreakAnyway;
   public final boolean allowParkour;
   public final boolean allowParkourPlace;
   public final boolean allowJumpAtBuildLimit;
   public final boolean allowParkourAscend;
   public final boolean assumeWalkOnWater;
   public boolean allowFallIntoLava;
   public final int frostWalker;
   public final boolean allowDiagonalDescend;
   public final boolean allowDiagonalAscend;
   public final boolean allowDownward;
   public int minFallHeight;
   public int maxFallHeightNoWater;
   public final int maxFallHeightBucket;
   public final double waterWalkSpeed;
   public final double breakBlockAdditionalCost;
   public double backtrackCostFavoringCoefficient;
   public double jumpPenalty;
   public final double walkOnWaterOnePenalty;
   public final boolean allowWalkOnMagmaBlocks;
   public final BetterWorldBorder worldBorder;
   public final PrecomputedData precomputedData = new PrecomputedData();
   private static final double оЫ = 0;
   private static final double оз = 0;
   private static final double оР = 0;
   private static final double ох = 0;
   private static final double оЦ = 0;
   private static final double о9 = 0;
   private static final double оЮ = 0;
   private static final double оO = 0;
   private static final double о弟 = 0;

   public double costOfPlacingAt(int var1, int var2, int var3, BlockState var4) {
      if (!this.hasThrowaway) {
         return оР;
      } else if (this.isPossiblyProtected(var1, var2, var3)) {
         return ох;
      } else if (!this.worldBorder.canPlaceAt(var1, var3)) {
         return оЦ;
      } else if (!Baritone.settings().allowPlaceInFluidsSource.value && var4.getFluidState().isSource()) {
         return о9;
      } else {
         return !Baritone.settings().allowPlaceInFluidsFlow.value && !var4.getFluidState().isEmpty() && !var4.getFluidState().isSource()
            ? оЮ
            : this.placeBlockCost;
      }
   }

   public double placeBucketCost() {
      return this.placeBlockCost;
   }

   public BlockState get(int var1, int var2, int var3) {
      return this.bsi.get0(var1, var2, var3);
   }

   public boolean isLoaded(int var1, int var2) {
      return this.bsi.isLoaded(var1, var2);
   }

   public boolean isPossiblyProtected(int var1, int var2, int var3) {
      return false;
   }

   public CalculationContext(IBaritone var1) {
      this(var1, false);
   }


   public Block getBlock(int var1, int var2, int var3) {
      return this.get(var1, var2, var3).getBlock();
   }

   public final IBaritone getBaritone() {
      return this.baritone;
   }

   public double breakCostMultiplierAt(int var1, int var2, int var3, BlockState var4) {
      if (!this.allowBreak && !this.allowBreakAnyway.contains(var4.getBlock())) {
         return оO;
      } else {
         return this.isPossiblyProtected(var1, var2, var3) ? о弟 : 1.0;
      }
   }

   public BlockState get(BlockPos var1) {
      return this.get(var1.getX(), var1.getY(), var1.getZ());
   }

   public CalculationContext(IBaritone var1, boolean var2) {
      this.safeForThreadedUse = var2;
      this.baritone = var1;
      LocalPlayer var3 = var1.getPlayerContext().player();
      this.world = var1.getPlayerContext().world();
      this.worldData = (WorldData)var1.getPlayerContext().worldData();
      this.bsi = new BlockStateInterface(var1.getPlayerContext(), var2);
      this.toolSet = new ToolSet(var3);
      this.hasThrowaway = Baritone.settings().allowPlace.value && ((Baritone)var1).getInventoryBehavior().hasGenericThrowaway();
      this.hasWaterBucket = Baritone.settings().allowWaterBucketFall.value
         && Inventory.isHotbarSlot(var3.getInventory().findSlotMatchingItem(STACK_BUCKET_WATER))
         && this.world.dimension() != Level.NETHER;
      this.canSprint = Baritone.settings().allowSprint.value && var3.getFoodData().getFoodLevel() > 6;
      this.placeBlockCost = Baritone.settings().blockPlacementPenalty.value;
      this.allowBreak = Baritone.settings().allowBreak.value;
      this.allowBreakAnyway = new ArrayList<>(Baritone.settings().allowBreakAnyway.value);
      this.allowParkour = Baritone.settings().allowParkour.value;
      this.allowParkourPlace = Baritone.settings().allowParkourPlace.value;
      this.allowJumpAtBuildLimit = Baritone.settings().allowJumpAtBuildLimit.value;
      this.allowParkourAscend = Baritone.settings().allowParkourAscend.value;
      this.assumeWalkOnWater = Baritone.settings().assumeWalkOnWater.value;
      this.allowFallIntoLava = false;
      int sx = 0;

      for (EquipmentSlot sxx : EquipmentSlot.values()) {
         ItemEnchantments sxxx = var1.getPlayerContext().player().getItemBySlot(sxx).getEnchantments();

         for (var sxxxx : sxxx.keySet()) {
            if (sxxxx.is(Enchantments.FROST_WALKER)) {
               sx = sxxx.getLevel(sxxxx);
            }
         }
      }

      this.frostWalker = sx;
      this.allowDiagonalDescend = Baritone.settings().allowDiagonalDescend.value;
      this.allowDiagonalAscend = Baritone.settings().allowDiagonalAscend.value;
      this.allowDownward = Baritone.settings().allowDownward.value;
      this.minFallHeight = 3;
      this.maxFallHeightNoWater = Baritone.settings().maxFallHeightNoWater.value;
      this.maxFallHeightBucket = Baritone.settings().maxFallHeightBucket.value;
      float sxx = 1.0F;

      label51:
      for (EquipmentSlot sxxx : EquipmentSlot.values()) {
         ItemEnchantments sxxxx = var1.getPlayerContext().player().getItemBySlot(sxxx).getEnchantments();

         for (var sxxxxx : sxxxx.keySet()) {
            for (EnchantmentAttributeEffect sxxxxxx : sxxxxx.value().getEffects(EnchantmentEffectComponents.ATTRIBUTES)) {
               if (sxxxxxx.attribute().is(Attributes.WATER_MOVEMENT_EFFICIENCY.unwrapKey().get())) {
                  sxx = sxxxxxx.amount().calculate(sxxxx.getLevel(sxxxxx));
                  break label51;
               }
            }
         }
      }

      this.waterWalkSpeed = оЫ * (1.0F - sxx) + оз * sxx;
      this.breakBlockAdditionalCost = Baritone.settings().blockBreakAdditionalPenalty.value;
      this.backtrackCostFavoringCoefficient = Baritone.settings().backtrackCostFavoringCoefficient.value;
      this.jumpPenalty = Baritone.settings().jumpPenalty.value;
      this.walkOnWaterOnePenalty = Baritone.settings().walkOnWaterOnePenalty.value;
      this.allowWalkOnMagmaBlocks = Baritone.settings().allowWalkOnMagmaBlocks.value;
      this.worldBorder = new BetterWorldBorder(this.world.getWorldBorder());
   }
}
