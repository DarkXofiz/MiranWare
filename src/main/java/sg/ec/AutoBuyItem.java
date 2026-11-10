// Original binary: sg/ec/sguDeeqNyPVdkI5l
package sg.ec;

import com.mojang.authlib.properties.Property;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.Tag;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.item.enchantment.ItemEnchantments;

// $VF: Compiled from s
public final class AutoBuyItem {
   private static final Pattern field23598 = Pattern.compile(AutoBuyItem.field23677);
   private static final Pattern field23599 = Pattern.compile(AutoBuyItem.field23678);
   private static final float field23600 = 80.0F;
   private static final float field23601 = 0;
   private final AutoBuyServer field23602;
   private final Item field23603;
   private final String field23604;
   private final Component field23605;
   private final CompoundTag field23606;
   private final Map<Identifier, Integer> field23607;
   private final List<String> field23608;
   private final Map<String, Integer> field23609;
   private final String field23610;
   private final String field23611;
   private Set<Item> field23612 = Set.of();
   private boolean field23613;
   private boolean field23614;
   private int field23615;
   private int field23616;
   private float field23617;
   private boolean field23618;
   private float field23619;
   private int field23620;
   private ItemStack field23621;
   private static volatile boolean field23622;
   private static final String[] field23623 = new String[]{
      AutoBuyItem.field23679,
      AutoBuyItem.field23680,
      AutoBuyItem.field23681,
      AutoBuyItem.field23682,
      AutoBuyItem.field23683,
      AutoBuyItem.field23684
   };
   private static final float field23624 = 80.0F;
   private static final float field23625 = 100.0F;
   private static final String field23626 = "item";
   private static final String field23627 = "stack";
   private static final float field23628 = 100.0F;
   private static final float field23629 = 200.0F;
   private static final String field23630 = "_helmet";
   private static final String field23631 = "_chestplate";
   private static final String field23632 = "_leggings";
   private static final String field23633 = "_boots";
   private static final String field23634 = "elytra";
   private static final String field23635 = "предмет пуст";
   private static final String field23636 = "не тот тип предмета";
   private static final String field23637 = "не найдена нужная строка описания";
   private static final String field23638 = "не совпадают эффекты зелья";
   private static final String field23639 = "не совпадают NBT-параметры";
   private static final String field23640 = "не совпадает текстура головы";
   private static final float field23641 = 100.0F;
   private static final float field23642 = 100.0F;
   private static final float field23643 = 100.0F;
   private static final String field23644 = "hiddenagui";
   private static final String field23645 = "minecraft:";
   private static final String field23646 = "Enchantments";
   private static final String field23647 = "id";
   private static final String field23648 = "lvl";
   private static final String field23649 = "custom-enchantments";
   private static final String field23650 = "type";
   private static final String field23651 = "level";
   private static final String field23652 = "custom_potion_effects";
   private static final String field23653 = "custom_potion_effects";
   private static final String field23654 = "id";
   private static final String field23655 = "amplifier";
   private static final String field23656 = "custom_potion_effects";
   private static final String field23657 = "sphereEffect";
   private static final String field23658 = "custom_potion_effects";
   private static final String field23659 = "{";
   private static final String field23660 = "[";
   private static final String field23661 = ".*\".*\".*";
   private static final String field23662 = "textures";
   private static final String field23663 = "SkullOwner";
   private static final String field23664 = "VV|Protocol";
   private static final String field23665 = "HideFlags";
   private static final String field23666 = "Enchantments";
   private static final String field23667 = "custom-enchantments";
   private static final String field23668 = "\"";
   private static final String field23669 = "\"";
   private static final String field23670 = ",?UUID:\\[I;[-0-9]+,[-0-9]+,[-0-9]+,[-0-9]+]";
   private static final String field23671 = ",?\"?minecraft:s\"?:\\[B;[^\\]]*\\]";
   private static final String field23672 = ",?\"?VV\\|Protocol[^\":,]*\"?:1b";
   private static final String field23673 = " ";
   private static final String field23674 = "\\s+";
   private static final String field23675 = " ";
   private static final String field23676 = ":";
   private static final String field23677 = "\\\\?\"?lvl\\\\?\"?\\s*:\\s*(\\d+).*?\\\\?\"?nbtName\\\\?\"?\\s*:\\s*\\\\?\"([^\"\\\\]+)\\\\?\"";
   private static final String field23678 = "(?i)§[0-9A-FK-OR]";
   private static final String field23679 = "invisibility";
   private static final String field23680 = "slowness";
   private static final String field23681 = "weakness";
   private static final String field23682 = "poison";
   private static final String field23683 = "harming";
   private static final String field23684 = "wither";

   private static String method10668(String var0) {
      return var0 != null && !var0.isEmpty()
         ? field23599.matcher(var0).replaceAll(field23673).toLowerCase(Locale.ROOT).replaceAll(field23674, field23675).trim()
         : "";
   }

   public void method10669(int var1) {
      this.field23615 = Math.max(0, var1);
      if (this.field23616 >= this.field23615) {
         this.field23616 = 0;
      }
   }

   public static String method10670(Item var0) {
      ItemStack var1 = method10676(var0);
      return var1.isEmpty() ? BuiltInRegistries.ITEM.getKey(var0).getPath() : var1.getHoverName().getString();
   }

   private static Map<String, Integer> method10671(ItemStack var0) {
      LinkedHashMap<String, Integer> var1 = new LinkedHashMap<>();
      PotionContents var2 = var0.get(DataComponents.POTION_CONTENTS);
      if (var2 != null) {
         for (MobEffectInstance var4 : var2.getAllEffects()) {
            method10696(var1, var4);
         }

         var2.potion().ifPresent(var1x -> {
            for (MobEffectInstance var3 : var1x.value().getEffects()) {
               method10696(var1, var3);
            }
         });
      }

      CustomData var8 = var0.get(DataComponents.CUSTOM_DATA);
      if (var8 != null && var8.copyTag().contains(field23652)) {
         ListTag var9 = var8.copyTag().getListOrEmpty(field23653);

         for (int var5 = 0; var5 < var9.size(); var5++) {
            CompoundTag var6 = var9.getCompoundOrEmpty(var5);
            String var7 = method10708(var6.getStringOr(field23654, ""));
            if (!var7.isEmpty()) {
               var1.merge(var7, Math.max(1, var6.getIntOr(field23655, 0) + 1), Math::max);
            }
         }
      }

      return var1;
   }

   public boolean method10672() {
      return this.field23614;
   }

   public String method10673() {
      return this.field23604;
   }

   public void method10674(int var1) {
      this.field23620 = Math.max(0, var1);
   }

   private static Map<String, Integer> method10675(Map<String, Integer> var0) {
      if (var0 != null && !var0.isEmpty()) {
         LinkedHashMap<String, Integer> var1 = new LinkedHashMap<>();
         var0.forEach((var1x, var2) -> {
            String var3 = method10708(var1x);
            if (!var3.isEmpty() && var2 != null && var2 > 0) {
               var1.put(var3, var2);
            }
         });
         return var1.isEmpty() ? Map.of() : Collections.unmodifiableMap(var1);
      } else {
         return Map.of();
      }
   }

   public static ItemStack method10676(Item var0) {
      try {
         return new ItemStack(var0);
      } catch (Throwable var4) {
         method10738();

         try {
            return new ItemStack(var0);
         } catch (Throwable var3) {
            return ItemStack.EMPTY;
         }
      }
   }

   private static boolean method10677(String var0, String var1) {
      var var2 = method10727(var1);
      if (var2.isEmpty()) {
         return var0.contains(var1);
      }

      var var3 = method10727(var0);

      for (var var5 : var2.entrySet()) {
         if (!((Integer)var5.getValue()).equals(var3.get(var5.getKey()))) {
            return false;
         }
      }

      return true;
   }

   @Override
   public boolean equals(Object var1) {
      if (this == var1) {
         return true;
      } else {
         return !(var1 instanceof AutoBuyItem var2)
            ? false
            : this.field23602 == var2.field23602
               && this.field23603 == var2.field23603
               && Objects.equals(this.field23604, var2.field23604)
               && Objects.equals(this.field23606, var2.field23606)
               && this.field23607.equals(var2.field23607)
               && this.field23608.equals(var2.field23608)
               && this.field23609.equals(var2.field23609)
               && Objects.equals(this.field23610, var2.field23610);
      }
   }

   private String method10678(ItemStack var1) {
      for (var var3 : this.field23607.entrySet()) {
         if (!method10690(var1, (Identifier)var3.getKey(), (Integer)var3.getValue())) {
            return "нет зачарования " + ((Identifier)var3.getKey()).getPath() + " " + var3.getValue() + " ур.";
         }
      }

      return null;
   }

   public static float method10679(ItemStack var0) {
      if (var0 != null && var0.isDamageableItem()) {
         int var1 = var0.getMaxDamage();
         return var1 <= 0 ? field23642 : Math.max(0, var1 - var0.getDamageValue()) * field23643 / var1;
      } else {
         return field23641;
      }
   }

   private static String method10680(ItemStack var0) {
      CustomData var1 = var0.get(DataComponents.CUSTOM_DATA);
      if (var1 == null) {
         return "";
      }

      CompoundTag var2 = var1.copyTag();
      Tag var3 = var2.get(field23656);
      return var3 == null ? "" : var3.toString().toLowerCase(Locale.ROOT);
   }

   public String method10681() {
      return this.field23611;
   }

   public int method10682() {
      return this.field23615;
   }

   public Map<String, Integer> method10683() {
      return this.field23609;
   }

   public ItemStack method10684() {
      return this.field23621;
   }

   private static List<String> method10685(List<String> var0) {
      if (var0 != null && !var0.isEmpty()) {
         var var1 = new ArrayList(var0.size());

         for (String var3 : var0) {
            String var4 = method10668(var3);
            if (!var4.isEmpty() && !var1.contains(var4)) {
               var1.add(var4);
            }
         }

         return var1.isEmpty() ? List.of() : Collections.unmodifiableList(var1);
      } else {
         return List.of();
      }
   }

   public AutoBuyServer method10687() {
      return this.field23602;
   }

   private boolean method10688(ItemStack var1) {
      if (this.field23610 == null) {
         return true;
      }

      ResolvableProfile var2 = var1.get(DataComponents.PROFILE);
      if (var2 != null && var2.partialProfile() != null) {
         for (Property var4 : var2.partialProfile().properties().get(field23662)) {
            if (this.method10719(var4.value())) {
               return true;
            }
         }
      }

      CustomData var6 = var1.get(DataComponents.CUSTOM_DATA);
      if (var6 != null) {
         Tag var7 = var6.copyTag().get(field23663);
         if (var7 != null) {
            String var5 = var7.toString();
            return var5.contains(this.field23610) || this.field23611 != null && var5.contains(this.field23611);
         }
      }

      return false;
   }

   public Component method10689() {
      return this.field23605;
   }

   private static boolean method10690(ItemStack var0, Identifier var1, int var2) {
      String var3 = var1.toString();
      if (var3.toLowerCase(Locale.ROOT).contains(field23644)) {
         return true;
      }

      if (!var3.startsWith(field23645)) {
         return method10692(var0, var3, var2);
      }

      ItemEnchantments var4 = var0.getEnchantments();

      for (var var6 : var4.keySet()) {
         String var7 = var6.unwrapKey().map(ResourceKey::identifier).map(Object::toString).orElse("");
         if (var7.contains(var3) && var4.getLevel(var6) >= var2) {
            return true;
         }
      }

      return false;
   }

   public String method10691() {
      StringBuilder var1 = new StringBuilder(BuiltInRegistries.ITEM.getKey(this.field23603).toString());
      var1.append('|').append(this.field23604);
      if (this.field23606 != null) {
         var1.append('|').append(this.field23606);
      }

      if (!this.field23607.isEmpty()) {
         var1.append('|').append(this.field23607);
      }

      if (!this.field23608.isEmpty()) {
         var1.append('|').append(this.field23608);
      }

      if (!this.field23609.isEmpty()) {
         var1.append('|').append(this.field23609);
      }

      if (this.field23610 != null) {
         var1.append('|').append(this.field23610.hashCode());
      }

      return var1.toString();
   }

   private static boolean method10692(ItemStack var0, String var1, int var2) {
      CustomData var3 = var0.get(DataComponents.CUSTOM_DATA);
      if (var3 == null) {
         return false;
      }

      CompoundTag var4 = var3.copyTag();
      return method10728(var4, field23646, field23647, field23648, var1, var2) || method10728(var4, field23649, field23650, field23651, var1, var2);
   }

   public Item method10693() {
      return this.field23603;
   }

   public void method10694(boolean var1) {
      this.field23613 = var1;
   }

   private static boolean method10695(String var0, String var1) {
      String var2 = var0.toLowerCase(Locale.ROOT);

      for (String var6 : field23623) {
         if (!var1.contains(var6) && var2.contains(var6)) {
            return true;
         }
      }

      return false;
   }

   private static void method10696(Map<String, Integer> var0, MobEffectInstance var1) {
      Identifier var2 = BuiltInRegistries.MOB_EFFECT.getKey(var1.getEffect().value());
      if (var2 != null) {
         var0.merge(method10708(var2.toString()), Math.max(1, var1.getAmplifier() + 1), Math::max);
      }
   }

   public List<String> method10697() {
      return this.field23608;
   }

   private static boolean method10698(String var0) {
      return var0 == null || var0.isEmpty() || var0.startsWith(field23664) || field23665.equals(var0) || field23666.equals(var0) || field23667.equals(var0);
   }

   public int method10699() {
      return this.field23616;
   }

   @Override
   public String toString() {
      return "BuyEntry{" + this.field23602 + ", " + this.field23604 + ", max=" + this.field23615 + "}";
   }

   public static AutoBuyItem method10700(AutoBuyServer var0, ItemStack var1) {
      Objects.requireNonNull(var1, field23627);
      CustomData var2 = var1.get(DataComponents.CUSTOM_DATA);
      return method10730(var0, var1.getItem())
         .method10749(var1.getHoverName())
         .method10744(var2 == null ? null : var2.copyTag())
         .method10750(method10711(var1))
         .method10748(PlayerHeadUtils.method09239(var1))
         .method10743();
   }

   private static String method10702(String var0) {
      return var0 != null && !var0.isEmpty() ? var0.replaceAll(field23670, "").replaceAll(field23671, "").replaceAll(field23672, "") : "";
   }

   public void method10703(boolean var1) {
      this.field23614 = var1;
   }

   private boolean method10704(ItemStack var1) {
      if (this.field23609.isEmpty()) {
         return true;
      }

      var var2 = method10671(var1);
      String var3 = method10680(var1);

      for (var var5 : this.field23609.entrySet()) {
         Integer var6 = (Integer)var2.get(var5.getKey());
         if (var6 != null) {
            if (!var6.equals(var5.getValue())) {
               return false;
            }
         } else if (!var3.contains((CharSequence)var5.getKey())) {
            return false;
         }
      }

      return true;
   }

   public String method10705(ItemStack var1) {
      if (var1 != null && !var1.isEmpty()) {
         if (var1.getItem() != this.field23603 && !this.field23612.contains(var1.getItem())) {
            return field23636;
         } else {
            String var2 = this.method10678(var1);
            if (var2 != null) {
               return var2;
            } else if (!this.method10714(var1)) {
               return field23637;
            } else if (!this.method10704(var1)) {
               return field23638;
            } else if (this.field23606 != null) {
               CustomData var3 = var1.get(DataComponents.CUSTOM_DATA);
               return var3 != null && this.method10734(var3.copyTag()) ? null : field23639;
            } else {
               return this.method10688(var1) ? null : field23640;
            }
         }
      } else {
         return field23635;
      }
   }

   public boolean method10706() {
      return this.field23614 && this.field23615 > 0;
   }

   public void method10707(boolean var1) {
      this.field23618 = var1;
   }

   private static String method10708(String var0) {
      if (var0 == null) {
         return "";
      } else {
         String var1 = var0.trim().toLowerCase(Locale.ROOT);
         if (var1.isEmpty()) {
            return "";
         } else {
            return var1.contains(field23676) ? var1 : "minecraft:" + var1;
         }
      }
   }

   public Map<Identifier, Integer> method10710() {
      return this.field23607;
   }

   private static Map<Identifier, Integer> method10711(ItemStack var0) {
      ItemEnchantments var1 = var0.get(DataComponents.ENCHANTMENTS);
      if (var1 != null && !var1.isEmpty()) {
         LinkedHashMap var2 = new LinkedHashMap();

         for (var var4 : var1.keySet()) {
            int var5 = var1.getLevel(var4);
            var4.unwrapKey().ifPresent(var2x -> var2.put(var2x.identifier(), var5));
         }

         return var2;
      } else {
         return Map.of();
      }
   }

   private ItemStack method10712() {
      ItemStack var1 = method10676(this.field23603);
      if (var1.isEmpty()) {
         return ItemStack.EMPTY;
      }

      if (this.field23606 != null) {
         var1.set(DataComponents.CUSTOM_DATA, CustomData.of(this.field23606));
      }

      if (this.field23610 != null) {
         PlayerHeadUtils.method09243(var1, this.field23610);
      }

      return var1;
   }

   public void method10713(float var1) {
      this.field23619 = Math.min(field23629, Math.max(1.0F, var1));
   }

   @Override
   public int hashCode() {
      return Objects.hash(
         this.field23602, this.field23603, this.field23604, this.field23606, this.field23607, this.field23608, this.field23609, this.field23610
      );
   }

   private boolean method10714(ItemStack var1) {
      if (this.field23608.isEmpty()) {
         return true;
      }

      ItemLore var2 = var1.get(DataComponents.LORE);
      if (var2 != null && !var2.lines().isEmpty()) {
         var var3 = new ArrayList(var2.lines().size());

         for (Component var5 : var2.lines()) {
            String var6 = method10668(var5.getString());
            if (!var6.isEmpty()) {
               var3.add(var6);
            }
         }

         for (String var10 : this.field23608) {
            boolean var11 = false;

            for (String var8 : (Iterable<String>) (Iterable) var3) {
               if (var8.contains(var10)) {
                  var11 = true;
                  break;
               }
            }

            if (!var11) {
               return false;
            }
         }

         return true;
      } else {
         return false;
      }
   }

   public boolean method10715() {
      return this.field23618;
   }

   public ItemStack method10716() {
      if (this.field23621 == null || this.field23621.isEmpty()) {
         this.field23621 = this.method10712();
      }

      return this.field23621;
   }

   public String method10717() {
      return this.field23610;
   }

   public float method10718() {
      return this.field23619;
   }

   private boolean method10719(String var1) {
      if (var1 == null || var1.isBlank()) {
         return false;
      } else {
         return var1.contains(this.field23610) ? true : this.field23611 != null && this.field23611.equals(PlayerHeadUtils.method09241(var1));
      }
   }

   public CompoundTag method10720() {
      return this.field23606;
   }

   public boolean method10721(ItemStack var1) {
      return this.method10705(var1) == null;
   }

   private static Map<Identifier, Integer> method10722(Map<Identifier, Integer> var0) {
      if (var0 != null && !var0.isEmpty()) {
         LinkedHashMap<Identifier, Integer> var1 = new LinkedHashMap<>();
         var0.forEach((var1x, var2) -> {
            if (var1x != null && var2 != null && var2 > 0) {
               var1.merge(var1x, var2, Math::max);
            }
         });
         return Collections.unmodifiableMap(var1);
      } else {
         return Map.of();
      }
   }

   public boolean method10723(long var1) {
      return var1 > this.field23616 && var1 < this.field23615;
   }

   public void method10724(int var1) {
      this.field23616 = Math.max(0, var1);
   }

   public Set<Item> method10725() {
      return this.field23612;
   }

   public boolean method10726(ItemStack var1) {
      return this.method10736() && var1 != null && var1.isDamageableItem() ? method10679(var1) >= this.field23617 : true;
   }

   private static Map<String, Integer> method10727(String var0) {
      LinkedHashMap<String, Integer> var1 = new LinkedHashMap<>();
      if (var0 != null && !var0.isEmpty()) {
         Matcher var2 = field23598.matcher(var0);

         while (var2.find()) {
            try {
               var1.put(var2.group(2), Integer.parseInt(var2.group(1)));
            } catch (NumberFormatException var4) {
            }
         }

         return var1;
      } else {
         return var1;
      }
   }

   private static boolean method10728(CompoundTag var0, String var1, String var2, String var3, String var4, int var5) {
      ListTag var6 = var0.getListOrEmpty(var1);

      for (int var7 = 0; var7 < var6.size(); var7++) {
         CompoundTag var8 = var6.getCompoundOrEmpty(var7);
         if (var8.getStringOr(var2, "").equals(var4)) {
            return var8.getIntOr(var3, 0) >= var5;
         }
      }

      return false;
   }

   private AutoBuyItem(AutoBuyItem.Nested312 var1) {
      this.field23617 = field23624;
      this.field23619 = field23625;
      this.field23602 = var1.field23685;
      this.field23603 = Objects.requireNonNull(var1.field23686, field23626);
      this.field23604 = var1.field23687 != null && !var1.field23687.isBlank() ? var1.field23687 : method10670(var1.field23686);
      this.field23605 = var1.field23688 != null ? var1.field23688 : Component.literal(this.field23604);
      this.field23606 = var1.field23689 != null && !var1.field23689.isEmpty() ? var1.field23689.copy() : null;
      this.field23607 = method10722(var1.field23690);
      this.field23608 = method10685(var1.field23691);
      this.field23609 = method10675(var1.field23692);
      this.field23610 = var1.field23693 != null && !var1.field23693.isBlank() ? var1.field23693 : null;
      this.field23611 = PlayerHeadUtils.method09241(this.field23610);
      this.field23612 = var1.field23694;
      this.field23613 = var1.field23695;
   }

   public static AutoBuyItem.Nested312 method10730(AutoBuyServer var0, Item var1) {
      return new AutoBuyItem.Nested312(var0, var1);
   }

   public int method10731() {
      return this.field23620;
   }

   private static String method10732(String var0) {
      return var0.length() >= 2 && var0.startsWith(field23668) && var0.endsWith(field23669) ? var0.substring(1, var0.length() - 1) : var0;
   }

   public float method10733() {
      return this.field23617;
   }

   private boolean method10734(CompoundTag var1) {
      boolean var2 = false;

      for (String var4 : this.field23606.keySet()) {
         if (!method10698(var4)) {
            var2 = true;
            Tag var5 = var1.get(var4);
            if (var5 == null) {
               return false;
            }

            String var6 = method10702(var5.toString());
            String var7 = method10702(method10732(this.field23606.get(var4).toString()));
            if (!field23657.equals(var4)) {
               if (field23658.equals(var4)) {
                  if (!var6.contains(var7) || method10695(var6, var7)) {
                     return false;
                  }
               } else {
                  if (!var6.contains(var7)) {
                     return false;
                  }

                  boolean var8 = var7.startsWith(field23659) || var7.startsWith(field23660);
                  if (!var8 && var6.matches(field23661) && !var6.contains("\"" + var7 + "\"")) {
                     return false;
                  }
               }
            } else if (!method10677(var6, var7)) {
               return false;
            }
         }
      }

      return var2 || this.field23606.isEmpty();
   }

   public boolean method10735() {
      return this.field23613;
   }

   public boolean method10736() {
      Identifier var1 = BuiltInRegistries.ITEM.getKey(this.field23603);
      String var2 = var1 == null ? "" : var1.getPath();
      return var2.endsWith(field23630) || var2.endsWith(field23631) || var2.endsWith(field23632) || var2.endsWith(field23633) || var2.equals(field23634);
   }

   public void method10737(float var1) {
      this.field23617 = Math.min(field23628, Math.max(0.0F, var1));
   }

   private static void method10738() {
      if (!field23622) {
         field23622 = true;

         try {
            RegistryDataMerger.method08039();
         } catch (Throwable var1) {
         }
      }
   }

   public boolean method10739() {
      return this.field23606 != null || !this.field23607.isEmpty() || !this.field23608.isEmpty() || !this.field23609.isEmpty() || this.field23610 != null;
   }

   // $VF: Compiled from s
   public static final class Nested312 {
      private final AutoBuyServer field23685;
      private final Item field23686;
      private String field23687;
      private Component field23688;
      private CompoundTag field23689;
      private Map<Identifier, Integer> field23690 = Map.of();
      private List<String> field23691 = List.of();
      private Map<String, Integer> field23692 = Map.of();
      private String field23693;
      private Set<Item> field23694 = Set.of();
      private boolean field23695;
      private static final String field23696 = "server";
      private static final String field23697 = "item";

      public AutoBuyItem.Nested312 method10740() {
         this.field23695 = true;
         return this;
      }

      public AutoBuyItem.Nested312 method10741(String var1, String var2) {
         CompoundTag var3 = this.field23689 == null ? new CompoundTag() : this.field23689;
         var3.putString(var1, var2);
         this.field23689 = var3;
         return this;
      }

      public AutoBuyItem.Nested312 method10742(List<String> var1) {
         this.field23691 = var1;
         return this;
      }

      public AutoBuyItem method10743() {
         return new AutoBuyItem(this);
      }

      private Nested312(AutoBuyServer var1, Item var2) {
         this.field23685 = Objects.requireNonNull(var1, field23696);
         this.field23686 = Objects.requireNonNull(var2, field23697);
      }

      public AutoBuyItem.Nested312 method10744(CompoundTag var1) {
         this.field23689 = var1;
         return this;
      }

      public AutoBuyItem.Nested312 method10745(String var1) {
         this.field23687 = var1;
         return this;
      }

      public AutoBuyItem.Nested312 method10746(Item... var1) {
         if (var1 != null && var1.length != 0) {
            LinkedHashSet var2 = new LinkedHashSet();

            for (Item var6 : var1) {
               if (var6 != null && var6 != this.field23686) {
                  var2.add(var6);
               }
            }

            this.field23694 = var2.isEmpty() ? Set.of() : Collections.unmodifiableSet(var2);
            return this;
         } else {
            return this;
         }
      }

      public AutoBuyItem.Nested312 method10747(Map<String, Integer> var1) {
         this.field23692 = var1;
         return this;
      }

      public AutoBuyItem.Nested312 method10748(String var1) {
         this.field23693 = var1;
         return this;
      }

      public AutoBuyItem.Nested312 method10749(Component var1) {
         this.field23688 = var1;
         this.field23687 = var1 == null ? null : var1.getString();
         return this;
      }

      public AutoBuyItem.Nested312 method10750(Map<Identifier, Integer> var1) {
         this.field23690 = var1;
         return this;
      }
   }
}
