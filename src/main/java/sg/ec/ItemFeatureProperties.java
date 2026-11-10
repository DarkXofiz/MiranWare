// Original binary: sg/ec/SAN69RGwd2Hn7dsQ
package sg.ec;

import java.util.IdentityHashMap;
import java.util.Map;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalItemTags;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.FishingRodItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.ProjectileItem;
import net.minecraft.world.item.SplashPotionItem;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemAttributeModifiers.Entry;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.LanternBlock;

// $VF: Compiled from s
public final class ItemFeatureProperties {
   private static final Map<Item, String> field11738 = new IdentityHashMap<>();
   private static final ItemFeatureFlags field11739 = new ItemFeatureFlags(true, false, false, false);

   public static void method05403(ItemStack var0, double var1) {
      ((ItemStackAccess)(Object)var0).hMI5_0$setSwingSpeed((int)var1);
   }

   public static boolean method05404(ItemStack var0, Item var1) {
      return var0.is(var1);
   }

   public static ItemFeatureFlags method05405(ItemStack var0) {
      return field11739;
   }

   private ItemFeatureProperties() {
   }

   public static String method05406(ItemStack var0) {
      return var0.getUseAnimation().getSerializedName();
   }

   public static boolean method05407(ItemStack var0) {
      if (Block.byItem(var0.getItem()) == Blocks.AIR) {
         return false;
      }

      int var1 = ((ItemStackAccess)(Object)var0).hMI5_0$getRenderAsBlock();
      return var1 == 1 || var1 == -1;
   }

   public static boolean method05408(ItemStack var0) {
      return Block.byItem(var0.getItem()) instanceof LanternBlock;
   }

   public static boolean method05409(ItemStack var0) {
      return Block.byItem(var0.getItem()) != Blocks.AIR;
   }

   private static boolean method05410(ItemStack var0) {
      boolean var1 = var0.getItem() instanceof FishingRodItem
         || var0.is(ConventionalItemTags.RODS)
         || var0.is(ConventionalItemTags.TOOLS)
         || var0.is(ItemTags.SWORDS)
         || var0.is(ConventionalItemTags.MACE_TOOLS)
         || var0.getUseAnimation() == ItemUseAnimation.BLOCK;
      return !var1 && method05411(var0) <= 0.0F
         ? true
         : var0.getUseAnimation() == ItemUseAnimation.EAT
            || var0.getUseAnimation() == ItemUseAnimation.DRINK
            || var0.getUseAnimation() == ItemUseAnimation.SPYGLASS;
   }

   public static float method05411(ItemStack var0) {
      ItemAttributeModifiers var1 = var0.get(DataComponents.ATTRIBUTE_MODIFIERS);
      if (var1 == null) {
         return 0.0F;
      }

      float var2 = 0.0F;

      for (var var4 : var1.modifiers()) {
         if (var4.attribute().value() == Attributes.ATTACK_DAMAGE.value()) {
            var2 += (float)var4.modifier().amount();
         }
      }

      return var2;
   }

   public static String method05412(ItemStack var0) {
      Item var1 = var0.getItem();
      String var2 = field11738.get(var1);
      if (var2 == null) {
         var2 = BuiltInRegistries.ITEM.getKey(var1).toString();
         field11738.put(var1, var2);
      }

      return var2;
   }

   public static void method05413(ItemStack var0, boolean var1) {
      ((ItemStackAccess)(Object)var0).hMI5_0$setTransform(var1);
   }

   public static boolean method05414(ItemStack var0) {
      int var1 = ((ItemStackAccess)(Object)var0).hMI5_0$getTransform();
      return var1 == 0 ? false : method05410(var0);
   }

   public static boolean method05415(ItemStack var0) {
      return ItemFeatureVariables.field24990.field25111.getOrDefault(method05412(var0), Boolean.FALSE);
   }

   public static boolean method05416(ItemStack var0) {
      return var0.getItem() instanceof SplashPotionItem || var0.getItem() instanceof ProjectileItem;
   }

   public static boolean method05417(ItemStack var0) {
      return CrossbowItem.isCharged(var0);
   }

   public static void method05418(ItemStack var0, boolean var1) {
      if (Block.byItem(var0.getItem()) != Blocks.AIR) {
         ((ItemStackAccess)(Object)var0).hMI5_0$setRenderAsBlock(var1);
      }
   }

   public static boolean method05419(ItemStack var0) {
      return var0.isEmpty();
   }

   public static boolean method05420(ItemStack var0, TagKey<Item> var1) {
      return var0.is(var1);
   }
}
