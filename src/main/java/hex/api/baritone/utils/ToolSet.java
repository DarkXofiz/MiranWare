// Original binary: hex/api/baritone/utils/ToolSet
package hex.api.baritone.utils;

import hex.api.baritone.Baritone;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.enchantment.effects.EnchantmentAttributeEffect;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class ToolSet {
   private final Map<Block, Double> breakStrengthCache = new HashMap<>();
   private final Function<Block, Double> backendCalculation;
   private final LocalPlayer player;
   private static final List<TagKey<Item>> materialTagsPriorityList = List.of(
      ItemTags.WOODEN_TOOL_MATERIALS,
      ItemTags.STONE_TOOL_MATERIALS,
      ItemTags.IRON_TOOL_MATERIALS,
      ItemTags.GOLD_TOOL_MATERIALS,
      ItemTags.DIAMOND_TOOL_MATERIALS,
      ItemTags.NETHERITE_TOOL_MATERIALS
   );
   private static final int 诶хц = 0;
   private static final double 诶хМ = 0;
   private static final double 诶х5 = 0;
   private static final float 诶хЖ = 1.0F;
   private static final float 诶хо = 1.0F;
   private static final double 诶хК = 0;
   private static final double 诶хЭ = 0;
   private static final double 诶хЪ = 0;
   private static final double 诶хЧ = 0;
   private static final double 诶хЩ = 0;

   public int getBestSlot(Block var1, boolean var2) {
      return this.getBestSlot(var1, var2, false);
   }

   public ToolSet(LocalPlayer var1) {
      this.player = var1;
      if (Baritone.settings().considerPotionEffects.value) {
         double var2 = this.potionAmplifier();
         Function<Double, Double> sx = var2x -> var2 * var2x;
         this.backendCalculation = sx.compose(this::getBestDestructionTime);
      } else {
         this.backendCalculation = this::getBestDestructionTime;
      }
   }

   public int getBestSlot(Block var1, boolean var2, boolean var3) {
      if (!Baritone.settings().autoTool.value && var3) {
         return this.player.getInventory().getSelectedSlot();
      }

      int var4 = 0;
      double sx = Double.NEGATIVE_INFINITY;
      int sxx = 诶хц;
      boolean sxxx = false;
      BlockState sxxxx = var1.defaultBlockState();

      for (int sxxxxx = 0; sxxxxx < 9; sxxxxx++) {
         ItemStack sxxxxxx = this.player.getInventory().getItem(sxxxxx);
         if ((Baritone.settings().useSwordToMine.value || !sxxxxxx.is(ItemTags.SWORDS))
            && (
               !Baritone.settings().itemSaver.value
                  || sxxxxxx.getDamageValue() + Baritone.settings().itemSaverThreshold.value < sxxxxxx.getMaxDamage()
                  || sxxxxxx.getMaxDamage() <= 1
            )) {
            double sxxxxxxx = calculateSpeedVsBlock(sxxxxxx, sxxxx);
            boolean sxxxxxxxx = this.hasSilkTouch(sxxxxxx);
            if (sxxxxxxx > sx) {
               sx = sxxxxxxx;
               var4 = sxxxxx;
               sxx = this.getMaterialCost(sxxxxxx);
               sxxx = sxxxxxxxx;
            } else if (sxxxxxxx == sx) {
               int sxxxxxxxxx = this.getMaterialCost(sxxxxxx);
               if (sxxxxxxxxx < sxx && (sxxxxxxxx || !sxxx) || var2 && !sxxx && sxxxxxxxx) {
                  sx = sxxxxxxx;
                  var4 = sxxxxx;
                  sxx = sxxxxxxxxx;
                  sxxx = sxxxxxxxx;
               }
            }
         }
      }

      return var4;
   }

   private double potionAmplifier() {
      double var1 = 1.0;
      if (this.player.hasEffect(MobEffects.HASTE)) {
         var1 *= 1.0 + (this.player.getEffect(MobEffects.HASTE).getAmplifier() + 1) * 诶хК;
      }

      if (this.player.hasEffect(MobEffects.MINING_FATIGUE)) {
         switch (this.player.getEffect(MobEffects.MINING_FATIGUE).getAmplifier()) {
            case 0:
               var1 *= 诶хЭ;
               break;
            case 1:
               var1 *= 诶хЪ;
               break;
            case 2:
               var1 *= 诶хЧ;
               break;
            default:
               var1 *= 诶хЩ;
         }
      }

      return var1;
   }

   private double getBestDestructionTime(Block var1) {
      ItemStack var2 = this.player.getInventory().getItem(this.getBestSlot(var1, false, true));
      return calculateSpeedVsBlock(var2, var1.defaultBlockState()) * this.avoidanceMultiplier(var1);
   }

   private double avoidanceMultiplier(Block var1) {
      return Baritone.settings().blocksToAvoidBreaking.value.contains(var1) ? Baritone.settings().avoidBreakingMultiplier.value : 1.0;
   }

   public double getStrVsBlock(BlockState var1) {
      return this.breakStrengthCache.computeIfAbsent(var1.getBlock(), this.backendCalculation);
   }


   private int getMaterialCost(ItemStack var1) {
      for (int var2 = 0; var2 < materialTagsPriorityList.size(); var2++) {
         var sx = materialTagsPriorityList.get(var2);
         if (var1.is(sx)) {
            return var2;
         }
      }

      return -1;
   }

   public boolean hasSilkTouch(ItemStack var1) {
      ItemEnchantments var2 = var1.getEnchantments();

      for (var sx : var2.keySet()) {
         if (sx.is(Enchantments.SILK_TOUCH) && var2.getLevel(sx) > 0) {
            return true;
         }
      }

      return false;
   }

   public static double calculateSpeedVsBlock(ItemStack var0, BlockState var1) {
      float var2;
      try {
         var2 = var1.getDestroySpeed(null, null);
      } catch (NullPointerException sx) {
         return 诶хМ;
      }

      if (var2 < 0.0F) {
         return 诶х5;
      }

      float sx = var0.getDestroySpeed(var1);
      if (sx > 1.0F) {
         ItemEnchantments sxx = var0.getEnchantments();

         label45:
         for (var sxxx : sxx.keySet()) {
            for (EnchantmentAttributeEffect sxxxx : sxxx.value().getEffects(EnchantmentEffectComponents.ATTRIBUTES)) {
               if (sxxxx.attribute().is(Attributes.MINING_EFFICIENCY.unwrapKey().get())) {
                  sx += sxxxx.amount().calculate(sxx.getLevel(sxxx));
                  break label45;
               }
            }
         }
      }

      sx /= var2;
      return var1.requiresCorrectToolForDrops() && (var0.isEmpty() || !var0.isCorrectToolForDrops(var1)) ? sx / 诶хо : sx / 诶хЖ;
   }
}
