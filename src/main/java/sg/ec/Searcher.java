// Original binary: sg/ec/fPRo1TzVQmtJq7Hg
package sg.ec;

import com.mojang.brigadier.ParseResults;
import com.mojang.brigadier.StringReader;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.core.Holder;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.component.ItemAttributeModifiers;
import net.minecraft.world.item.component.ItemLore;
import net.minecraft.world.item.component.ItemAttributeModifiers.Entry;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.ItemEnchantments;

// $VF: Compiled from s
public class Searcher extends ClientModule {
   private static final String field18932 = "ah search ";
   private final KeyBindSetting field18933;
   private final Map<String, String> field18934;
   private final Map<String, String> field18935;
   private static final String field18936 = "Кнопка поиска";
   private static final String field18937 = "Searcher";
   private static final String field18938 = "item.minecraft.maceminecraft:bane_of_arthropods7minecraft:unbreaking5minecraft:density5minecraft:sharpness7minecraft:fire_aspect2minecraft:sweeping_edge3minecraft:looting5minecraft:breach3minecraft:mending1minecraft:smite75.0attribute.name.attack_damage-3.4000000953674316attribute.name.attack_speed";
   private static final String field18939 = "Булава крушителя";
   private static final String field18940 = "item.minecraft.netherite_helmetminecraft:unbreaking5minecraft:aqua_affinity1minecraft:protection5minecraft:respiration3minecraft:fire_protection5minecraft:projectile_protection5minecraft:mending1minecraft:blast_protection53.0attribute.name.armor3.0attribute.name.armor_toughness0.10000000149011612attribute.name.knockback_resistance";
   private static final String field18941 = "Шлем Крушителя";
   private static final String field18942 = "item.minecraft.netherite_chestplateminecraft:unbreaking5minecraft:projectile_protection5minecraft:protection5minecraft:fire_protection5minecraft:mending1minecraft:blast_protection58.0attribute.name.armor3.0attribute.name.armor_toughness0.10000000149011612attribute.name.knockback_resistance";
   private static final String field18943 = "Нагрудник Крушителя";
   private static final String field18944 = "item.minecraft.netherite_leggingsminecraft:unbreaking5minecraft:projectile_protection5minecraft:protection5minecraft:fire_protection5minecraft:mending1minecraft:blast_protection56.0attribute.name.armor3.0attribute.name.armor_toughness0.10000000149011612attribute.name.knockback_resistance";
   private static final String field18945 = "Поножи Крушителя";
   private static final String field18946 = "item.minecraft.netherite_bootsminecraft:unbreaking5minecraft:feather_falling4minecraft:protection5minecraft:soul_speed3minecraft:fire_protection5minecraft:thorns3minecraft:projectile_protection5minecraft:mending1minecraft:depth_strider3minecraft:blast_protection53.0attribute.name.armor3.0attribute.name.armor_toughness0.10000000149011612attribute.name.knockback_resistance";
   private static final String field18947 = "Ботинки Крушителя";
   private static final String field18948 = "item.minecraft.crossbowminecraft:unbreaking3minecraft:quick_charge3minecraft:mending1minecraft:piercing5minecraft:multishot1";
   private static final String field18949 = "Арбалет Крушителя";
   private static final String field18950 = "item.minecraft.experience_bottle[★] Пузырёк опыта [15 Ур.]";
   private static final String field18951 = "Бутылка с уровнем 15";
   private static final String field18952 = "item.minecraft.experience_bottle[★] Пузырёк опыта [30 Ур.]";
   private static final String field18953 = "Бутылка с уровнем 30";
   private static final String field18954 = "item.minecraft.experience_bottle[★] Пузырёк опыта [45 Ур.]";
   private static final String field18955 = "Бутылка с уровнем 45";
   private static final String field18956 = "item.minecraft.experience_bottle[★] Пузырёк опыта [60 Ур.]";
   private static final String field18957 = "Бутылка с уровнем 60";
   private static final String field18958 = "item.minecraft.netherite_pickaxeminecraft:unbreaking5minecraft:fortune5minecraft:mending1minecraft:efficiency105.0attribute.name.attack_damage-2.799999952316284attribute.name.attack_speed";
   private static final String field18959 = "кирка Крушителя";
   private static final String field18960 = "item.minecraft.netherite_swordminecraft:sharpness7minecraft:mending1minecraft:fire_aspect2minecraft:unbreaking5minecraft:looting5minecraft:bane_of_arthropods7minecraft:sweeping_edge3minecraft:smite77.0attribute.name.attack_damage-2.4000000953674316attribute.name.attack_speedОпытный IIIВампиризм IIОкисление IIЯд IIIДетекция III[★] Оригинальный предмет";
   private static final String field18961 = "Меч Крушителя";
   private static final String field18962 = "item.minecraft.totem_of_undying7.0attribute.name.attack_damage-4.0attribute.name.max_health0.1attribute.name.movement_speed";
   private static final String field18963 = "Талисман Карателя";
   private static final String field18964 = "item.minecraft.totem_of_undying4.0attribute.name.max_health3.0attribute.name.attack_damage2.0attribute.name.armor_toughness2.0attribute.name.armor";
   private static final String field18965 = "Талисман Крушителя";
   private static final String field18966 = "§[0-9A-FK-ORa-fk-or]";
   private static final String field18967 = "\\[[^\\]]*\\]";
   private static final String field18968 = "xxx";

   private void method08103(String var1, String var2) {
      this.method08108(var1, var2, false);
   }

   private void method08104(String var1) {
      ChatTextUtils.method05093("/" + var1, () -> this.method08113(var1));
   }

   @Subscribe
   public void method08105(MouseButtonEvent var1) {
      if (var1.method06919() != InputAction.RELEASE) {
         this.method08110(var1.method06914());
      }
   }

   public Searcher() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field18933 = new KeyBindSetting(field18936).method03017(new KeyBinding()).method03023(this);
      this.field18934 = new HashMap<>();
      this.field18935 = new HashMap<>();
      this.method03935(field18937);
      this.method08109();
   }

   @Subscribe
   public void method08106(KeyInputEvent var1) {
      if (var1.method05884() != InputAction.RELEASE) {
         this.method08110(var1.method05887());
      }
   }

   private static String method08107(String var0) {
      var0 = var0.replaceAll(field18966, "");
      var0 = var0.replaceAll(field18967, "");
      var0 = var0.replaceAll(field18968, "");
      return var0.trim();
   }

   private void method08108(String var1, String var2, boolean var3) {
      if (var3) {
         this.field18935.put(var1, var2);
      } else {
         this.field18934.put(var1, var2);
      }
   }

   private void method08109() {
      this.method08103(field18938, field18939);
      this.method08103(field18940, field18941);
      this.method08103(field18942, field18943);
      this.method08103(field18944, field18945);
      this.method08103(field18946, field18947);
      this.method08103(field18948, field18949);
      this.method08108(field18950, field18951, true);
      this.method08108(field18952, field18953, true);
      this.method08108(field18954, field18955, true);
      this.method08108(field18956, field18957, true);
      this.method08103(field18958, field18959);
      this.method08103(field18960, field18961);
      this.method08103(field18962, field18963);
      this.method08103(field18964, field18965);
   }

   private void method08110(int var1) {
      if (var1 == this.field18933.method03022().method05871()) {
         if (mc.player != null) {
            ItemStack var2 = mc.player.getMainHandItem();
            if (!var2.isEmpty()) {
               String var3 = var2.getStyledHoverName().getString();
               String var4 = this.field18934.get(this.method08111(var2, false));
               if (var4 == null) {
                  var4 = this.field18935.get(this.method08111(var2, true));
               }

               if (var4 != null) {
                  var3 = var4;
               }

               String var5 = method08107(var3);
               if (!var5.isEmpty()) {
                  this.method08104("ah search " + var5);
               }
            }
         }
      }
   }

   private String method08111(ItemStack var1, boolean var2) {
      ItemAttributeModifiers var3 = var1.get(DataComponents.ATTRIBUTE_MODIFIERS);
      ItemEnchantments var4 = var1.getEnchantments();
      StringBuilder var5 = new StringBuilder();
      var5.append(var1.getItem().getDescriptionId());

      for (var var7 : var4.keySet()) {
         int var8 = var4.getLevel(var7);
         String var9 = var7.unwrapKey().map(ResourceKey::identifier).map(Object::toString).orElse(((Enchantment)var7.value()).description().getString());
         var5.append(var9);
         var5.append(var8);
      }

      for (var var12 : var3.modifiers()) {
         var5.append(var12.modifier().amount());
         var5.append(var12.attribute().value().getDescriptionId());
      }

      ItemLore var11 = var1.get(DataComponents.LORE);
      if (var11 != null) {
         for (Component var14 : var11.lines()) {
            var5.append(var14.getString());
         }
      }

      if (var2) {
         var5.append(var1.getStyledHoverName().getString());
      }

      return var5.toString();
   }

   private void method08113(String var1) {
      String var2 = "/" + var1;
      StringReader var3 = new StringReader(var2);
      var3.skip();
      ClientSuggestionProvider var4 = mc.player.connection.getSuggestionsProvider();
      ParseResults var5 = mc.player.connection.getCommands().parse(var3, var4);
      var4.customSuggestion(var5.getContext().build(var2));
   }
}
