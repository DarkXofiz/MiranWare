// Original binary: sg/ec/JfPH6SAQ0rPmopRp
package sg.ec;

import net.minecraft.tags.ItemTags;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public class AutoDropper extends ClientModule {
   private final ModeSetting field09195;
   private final MultiToggleSetting field09196;
   private static final String field09197 = "Выкидывать в";
   private static final String field09198 = "Сундуках/шалкерах";
   private static final String field09199 = "Инвентарь";
   private static final String field09200 = "Вместе";
   private static final String field09201 = "Сундуках/шалкерах";
   private static final String field09202 = "Что выкидывать";
   private static final String field09203 = "Ботинки";
   private static final String field09204 = "Поножи";
   private static final String field09205 = "Нагрудники";
   private static final String field09206 = "Шлемы";
   private static final String field09207 = "Мечи";
   private static final String field09208 = "Лопаты";
   private static final String field09209 = "Кирки";
   private static final String field09210 = "Головы";
   private static final String field09211 = "Элитры";
   private static final String field09212 = "Фейерверки";
   private static final String field09213 = "Тотемы";
   private static final String field09214 = "Стрелы";
   private static final String field09215 = "Луки-Арбалеты";
   private static final String field09216 = "Кристалы";
   private static final String field09217 = "Обсидиан";
   private static final String field09218 = "Золотые яблоки";
   private static final String field09219 = "Зачарованные золотые яблоки";
   private static final String field09220 = "Auto Dropper";
   private static final String field09221 = "Сундуках/шалкерах";
   private static final String field09222 = "Вместе";
   private static final String field09223 = "Инвентарь";
   private static final String field09224 = "Вместе";
   private static final String field09225 = "Ботинки";
   private static final String field09226 = "boots";
   private static final String field09227 = "Поножи";
   private static final String field09228 = "leggings";
   private static final String field09229 = "Нагрудники";
   private static final String field09230 = "chestplate";
   private static final String field09231 = "Шлемы";
   private static final String field09232 = "helmet";
   private static final String field09233 = "Мечи";
   private static final String field09234 = "Лопаты";
   private static final String field09235 = "Кирки";
   private static final String field09236 = "Головы";
   private static final String field09237 = "Элитры";
   private static final String field09238 = "Фейерверки";
   private static final String field09239 = "Тотемы";
   private static final String field09240 = "Стрелы";
   private static final String field09241 = "Луки-Арбалеты";
   private static final String field09242 = "Кристалы";
   private static final String field09243 = "Обсидиан";
   private static final String field09244 = "Золотые яблоки";
   private static final String field09245 = "Зачарованные золотые яблоки";

   private static boolean method04067(String var0, String var1) {
      return var0.contains(var1) && var0.endsWith(var1);
   }

   private boolean method04068(ItemStack var1) {
      Item var2 = var1.getItem();
      if (this.field09196.method04520(field09225) && this.method04072(var2, field09226)) {
         return true;
      }

      if (this.field09196.method04520(field09227) && this.method04072(var2, field09228)) {
         return true;
      }

      if (this.field09196.method04520(field09229) && this.method04072(var2, field09230)) {
         return true;
      }

      if (this.field09196.method04520(field09231) && this.method04072(var2, field09232)) {
         return true;
      }

      if (this.field09196.method04520(field09233) && InventoryUtils.method06087(var1)) {
         return true;
      }

      if (this.field09196.method04520(field09234) && new ItemStack(var2).is(net.minecraft.tags.ItemTags.SHOVELS)) {
         return true;
      }

      if (this.field09196.method04520(field09235) && var1.is(ItemTags.PICKAXES)) {
         return true;
      }

      if (this.field09196.method04520(field09236) && this.method04071(var2)) {
         return true;
      }

      if (this.field09196.method04520(field09237) && var2 == Items.ELYTRA) {
         return true;
      }

      if (this.field09196.method04520(field09238) && var2 == Items.FIREWORK_ROCKET) {
         return true;
      }

      if (this.field09196.method04520(field09239) && var2 == Items.TOTEM_OF_UNDYING) {
         return true;
      }

      if (this.field09196.method04520(field09240) && var2 instanceof ArrowItem) {
         return true;
      }

      if (!this.field09196.method04520(field09241) || !(var2 instanceof BowItem) && !(var2 instanceof CrossbowItem)) {
         if (this.field09196.method04520(field09242) && var2 == Items.END_CRYSTAL) {
            return true;
         } else if (!this.field09196.method04520(field09243) || var2 != Items.OBSIDIAN && var2 != Items.CRYING_OBSIDIAN) {
            return this.field09196.method04520(field09244) && var2 == Items.GOLDEN_APPLE
               ? true
               : this.field09196.method04520(field09245) && var2 == Items.ENCHANTED_GOLDEN_APPLE;
         } else {
            return true;
         }
      } else {
         return true;
      }
   }

   public AutoDropper() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field09195 = new ModeSetting(field09197).method05597(field09198, field09199, field09200).method03017(field09201).method03023(this);
      this.field09196 = new MultiToggleSetting(field09202)
         .method04517(NamedOption.method08077(field09203, false))
         .method04517(NamedOption.method08077(field09204, false))
         .method04517(NamedOption.method08077(field09205, false))
         .method04517(NamedOption.method08077(field09206, false))
         .method04517(NamedOption.method08077(field09207, false))
         .method04517(NamedOption.method08077(field09208, false))
         .method04517(NamedOption.method08077(field09209, false))
         .method04517(NamedOption.method08077(field09210, false))
         .method04517(NamedOption.method08077(field09211, false))
         .method04517(NamedOption.method08077(field09212, false))
         .method04517(NamedOption.method08077(field09213, false))
         .method04517(NamedOption.method08077(field09214, false))
         .method04517(NamedOption.method08077(field09215, false))
         .method04517(NamedOption.method08077(field09216, false))
         .method04517(NamedOption.method08077(field09217, false))
         .method04517(NamedOption.method08077(field09218, false))
         .method04517(NamedOption.method08077(field09219, false))
         .method03023(this);
      this.method03935(field09220);
   }

   @Subscribe
   private void method04069(PlayerUpdateEvent var1) {
      if (mc.player != null && mc.player.containerMenu != null && mc.gameMode != null) {
         boolean var2 = this.field09195.method05600(field09221) || this.field09195.method05600(field09222);
         boolean var3 = this.field09195.method05600(field09223) || this.field09195.method05600(field09224);
         boolean var4 = mc.player.containerMenu instanceof ChestMenu;

         for (Slot var6 : mc.player.containerMenu.slots) {
            if (var6.hasItem() && this.method04070(var6, var2, var3, var4) && this.method04068(var6.getItem())) {
               mc.gameMode.handleContainerInput(mc.player.containerMenu.containerId, var6.index, 1, ClickType.THROW, mc.player);
            }
         }
      }
   }

   private boolean method04070(Slot var1, boolean var2, boolean var3, boolean var4) {
      boolean var5 = var1.container == mc.player.getInventory();
      return var5 ? var3 : var2 && var4;
   }

   private boolean method04071(Item var1) {
      return var1 == Items.SKELETON_SKULL
         || var1 == Items.WITHER_SKELETON_SKULL
         || var1 == Items.ZOMBIE_HEAD
         || var1 == Items.CREEPER_HEAD
         || var1 == Items.DRAGON_HEAD
         || var1 == Items.PIGLIN_HEAD
         || var1 == Items.PLAYER_HEAD;
   }

   private boolean method04072(Item var1, String var2) {
      return method04067(var1.getDescriptionId(), var2);
   }
}
