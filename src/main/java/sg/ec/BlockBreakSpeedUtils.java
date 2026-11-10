// Original binary: sg/ec/Lr7hD4zoLbBcV3LV
package sg.ec;

import java.util.HashMap;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.item.enchantment.effects.EnchantmentAttributeEffect;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public final class BlockBreakSpeedUtils implements MinecraftAccess {
   private static final int field09957 = 30;
   private static final int field09958 = 0;
   private static final Map<BlockState, Float> field09959 = new HashMap<>();
   private static int field09960 = BlockBreakSpeedUtils.field09965;
   private static ResourceKey<Attribute> field09961;
   private static final float field09962 = Float.MAX_VALUE;
   private static final float field09963 = Float.MAX_VALUE;
   private static final float field09964 = Float.MAX_VALUE;
   private static final int field09965 = Integer.MIN_VALUE;

   public static float method04451(ItemStack var0) {
      if (var0.isEmpty()) {
         return 0.0F;
      }

      if (field09961 == null) {
         field09961 = Attributes.MINING_EFFICIENCY.unwrapKey().orElseThrow();
      }

      ItemEnchantments var1 = var0.getEnchantments();
      if (var1.isEmpty()) {
         return 0.0F;
      }

      float sx = 0.0F;

      for (var sxx : var1.keySet()) {
         for (EnchantmentAttributeEffect sxxx : sxx.value().getEffects(EnchantmentEffectComponents.ATTRIBUTES)) {
            if (sxxx.attribute().is(field09961)) {
               sx += sxxx.amount().calculate(var1.getLevel(sxx));
            }
         }
      }

      return sx;
   }

   private static float method04452(BlockState var0, BlockPos var1) {
      float var2 = var0.getDestroyProgress(mc.player, mc.level, var1);
      if (var2 <= 0.0F) {
         return field09964;
      }

      float var3 = method04455(mc.player.getInventory().getSelectedItem(), var0);
      float var4 = method04455(AutoTool.method08998(var0), var0);
      if (var3 > 0.0F && var4 > 0.0F) {
         var2 *= var4 / var3;
      }

      return 1.0F / var2;
   }

   public static float method04453(ItemStack var0, BlockState var1) {
      float var2 = var0.isEmpty() ? 1.0F : var0.getDestroySpeed(var1);
      if (var2 > 1.0F) {
         var2 += method04451(var0);
      }

      return var2;
   }

   public static int method04454(ItemStack var0, BlockState var1) {
      boolean var2 = !var1.requiresCorrectToolForDrops() || var0.isCorrectToolForDrops(var1);
      return var2 ? 30 : 100;
   }

   public static float method04455(ItemStack var0, BlockState var1) {
      return method04453(var0, var1) / method04454(var0, var1);
   }

   public static float method04456(BlockPos var0) {
      return mc.level == null ? field09962 : method04457(mc.level.getBlockState(var0), var0);
   }

   private BlockBreakSpeedUtils() {
   }

   public static float method04457(BlockState var0, BlockPos var1) {
      if (mc.player != null && mc.level != null) {
         if (field09960 != mc.player.tickCount) {
            field09959.clear();
            field09960 = mc.player.tickCount;
         }

         Float var2 = field09959.get(var0);
         if (var2 != null) {
            return var2;
         }

         float var3 = method04452(var0, var1);
         field09959.put(var0, var3);
         return var3;
      } else {
         return field09963;
      }
   }
}
