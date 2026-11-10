// Original binary: sg/ec/6V7msTkQsyR1s3DG
package sg.ec;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.core.component.DataComponents;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.chat.TextColor;
import net.minecraft.network.protocol.game.ClientboundTakeItemEntityPacket;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemUseAnimation;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import org.joml.Vector4f;

// $VF: Compiled from s
public class NotificationHud extends HudElement {
   private static final long field03483 = 0L;
   private static final long field03484 = 0;
   private final Map<Long, Long> field03485 = new HashMap<>();
   private final BooleanSetting field03486;
   private final BooleanSetting field03487;
   private final BooleanSetting field03488;
   private final BooleanSetting field03489;
   private final BooleanSetting field03490;
   private final BooleanSetting field03491;
   private final BooleanSetting field03492;
   private final MultiToggleSetting field03493;
   private final DraggableElement field03494;
   private static final String field03495 = "Notification";
   private static final String field03496 = "Включение/Выключение модулей";
   private static final String field03497 = "Подбор донат предметов";
   private static final String field03498 = "Использование предмета";
   private static final String field03499 = "Окончание эффекта";
   private static final String field03500 = "Получение (Splash эффектов)";
   private static final String field03501 = "Снос тотема";
   private static final String field03502 = "Статус Staff";
   private static final String field03503 = "Компоненты Staff";
   private static final String field03504 = "Заход на сервер";
   private static final String field03505 = "Выход с сервера";
   private static final String field03506 = "Изменение статуса";
   private static final float field03507 = 0.546F;
   private static final long field03508 = 4294967295L;
   private static final long field03509 = 80L;
   private static final double field03510 = 100.0;
   private static final String field03511 = " получил эффекты из ";
   private static final String field03512 = " ";
   private static final long field03513 = 2000L;
   private static final String field03514 = " Подобрал уникальный предмет: ";
   private static final long field03515 = 2000L;
   private static final int field03516 = 16777215;
   private static final int field03517 = 16777215;
   private static final String field03518 = "Эффект ";
   private static final String field03519 = " больше не активен.";
   private static final long field03520 = 2000L;
   private static final String field03521 = " Использовал предмет: ";
   private static final long field03522 = 2000L;
   private static final String field03523 = " Потерял ";
   private static final long field03524 = 3000L;
   private static final String field03525 = "●";
   private static final String field03526 = " Зачарован: ";
   private static final long field03527 = 3000L;

   @Override
   public void method00032(PacketEvent var1) {
      super.method00032(var1);
      if (this.field03487.method03022()) {
         ClientLevel var2 = mc.level;
         if (var2 != null) {
            if (var1.method10897() instanceof ClientboundTakeItemEntityPacket sx) {
               Entity sxx = var2.getEntity(sx.getItemId());
               LivingEntity sxxx = var2.getEntity(sx.getPlayerId()) instanceof LivingEntity sxxxx ? sxxxx : mc.player;
               if (sxxx == null) {
                  return;
               }

               if (sxx instanceof ItemEntity sxxxx) {
                  ItemStack sxxxxx = sxxxx.getItem().copy();
                  if (!sxxxxx.isEmpty() && this.method01421(sxxxxx)) {
                     Component sxxxxxx = PlayerUtils.method11813(sxxx).copy().append(field03514).append(sxxxxx.getStyledHoverName());
                     NotificationManager.method08598(sxxxxxx, field03515, sxxxxx);
                  }
               }
            }
         }
      }
   }

   public BooleanSetting method01416() {
      return this.field03487;
   }

   @Override
   public void method00027(GuiGraphicsExtractor var1) {
      super.method00027(var1);
      Vector4f var2 = NotificationManager.method08616(var1, this, this.field03494.method02669());
      this.method06465(var2.x);
      this.method06453(var2.y);
      this.method06448(var2.z);
      this.method06456(var2.w);
      this.field03494.method02707(var2.x);
      this.field03494.method02676(var2.z);
      this.field03494.method02696(var2.w);
   }

   public BooleanSetting method01417() {
      return this.field03490;
   }

   @Override
   public void method00033(ItemUseStartEvent var1) {
      super.method00033(var1);
      if (this.field03488.method03022()) {
         LivingEntity var2 = var1.method08456();
         ItemStack var3 = var1.method08459().copy();
         ItemUseAnimation var4 = var3.getUseAnimation();
         if (var4 == ItemUseAnimation.EAT || var4 == ItemUseAnimation.DRINK) {
            if (!var3.isEmpty()) {
               MutableComponent var5 = PlayerUtils.method11813(var2).copy().append(field03521).append(var3.getStyledHoverName());
               NotificationManager.method08598(var5, field03522, var3);
            }
         }
      }
   }

   public MultiToggleSetting method01418() {
      return this.field03493;
   }

   public BooleanSetting method01419() {
      return this.field03488;
   }

   @Override
   public void method00015(SplashPotionEffectsEvent var1) {
      super.method00015(var1);
      if (this.field03490.method04706()) {
         Entity var2 = var1.method01642();
         AbstractThrownPotion var3 = var1.method01641();
         var var4 = var1.method01646();
         if (!this.method01428(var1.method01640(), var3, var2)) {
            if (var4 != null) {
               if (var2 instanceof Player var5) {
                  if (!var5.isAlive() || ModuleManager.INSTANCE.method08260().method00605(var5)) {
                     return;
                  }

                  double var6 = Math.max(0.0, Math.min(1.0, var1.method01644()));
                  int var8 = (int)Math.round(var6 * field03510);
                  MutableComponent var9 = Component.literal(var8 + "%")
                     .copy()
                     .setStyle(Style.EMPTY.withColor(ColorUtils.method04601((float)var6, 1.0F, false)));
                  ItemStack var10 = var3.getItem();
                  MutableComponent var11 = PlayerUtils.method11813(var5)
                     .copy()
                     .append(field03511)
                     .append(var10.getStyledHoverName())
                     .append(field03512)
                     .append(var9);
                  NotificationManager.method08598(var11, field03513, var10);
               }
            }
         }
      }
   }

   public Map<Long, Long> method01420() {
      return this.field03485;
   }

   @Override
   public void method00036(TotemPopEvent var1) {
      super.method00036(var1);
      if (this.field03491.method03022()) {
         if (var1.method01501() instanceof LivingEntity var3) {
            ItemStack var4 = var1.method01507();
            MutableComponent var5 = PlayerUtils.method11813(var3).copy().append(field03523);
            if (var4.isEmpty()) {
               ItemStack var7 = new ItemStack(Items.TOTEM_OF_UNDYING);
               var5.append(var7.getStyledHoverName());
               NotificationManager.method08598(var5, field03524, var7);
               return;
            }

            MutableComponent var6 = Component.literal(field03525)
               .copy()
               .setStyle(
                  Style.EMPTY.withColor(var4.isEnchanted() ? ColorUtils.method04604(100, 255, 100) : ColorUtils.method04604(255, 100, 100))
               );
            var5.append(var4.getStyledHoverName()).append(field03526).append(var6);
            NotificationManager.method08598(var5, field03527, var4);
         }
      }
   }

   private boolean method01421(ItemStack var1) {
      Component var2 = var1.get(DataComponents.CUSTOM_NAME);
      return var2 == null ? false : this.method01429(var2);
   }

   public DraggableElement method01422() {
      return this.field03494;
   }

   public BooleanSetting method01423() {
      return this.field03492;
   }

   @Override
   public void method00034(TickEvent var1) {
      super.method00034(var1);
      NotificationManager.method08594();
   }

   public BooleanSetting method01424() {
      return this.field03486;
   }

   public BooleanSetting method01425() {
      return this.field03491;
   }

   @Override
   public void method00012(MobEffectEvent var1) {
      super.method00012(var1);
      if (this.field03489.method03022()) {
         if (var1.method08688() == MobEffectEvent.Nested241.REMOVE) {
            MutableComponent var2 = Component.literal(field03518)
               .copy()
               .append(Component.translatable(var1.method08685().getDescriptionId()))
               .copy()
               .append(field03519);
            NotificationManager.method08619(var2, field03520, NotificationType.WARNING);
         }
      }
   }

   private void method01426(long var1) {
      var var3 = this.field03485.entrySet().iterator();

      while (var3.hasNext()) {
         Entry var4 = (Entry)var3.next();
         long var5 = (Long)var4.getValue();
         if (var1 < var5 || var1 - var5 > field03509) {
            var3.remove();
         }
      }
   }

   public NotificationHud() {
      super(field03495);
      this.field03486 = new BooleanSetting(field03496).method03017(true).method03023(this);
      this.field03487 = new BooleanSetting(field03497).method03017(false).method03023(this);
      this.field03488 = new BooleanSetting(field03498).method03017(false).method03023(this);
      this.field03489 = new BooleanSetting(field03499).method03017(false).method03023(this);
      this.field03490 = new BooleanSetting(field03500).method03017(false).method03023(this);
      this.field03491 = new BooleanSetting(field03501).method03017(false).method03023(this);
      this.field03492 = new BooleanSetting(field03502).method03017(false).method03023(this);
      this.field03493 = new MultiToggleSetting(field03503)
         .method04517(NamedOption.method08077(field03504, false))
         .method04517(NamedOption.method08077(field03505, false))
         .method04517(NamedOption.method08077(field03506, false))
         .method03025(this.field03492::method03022)
         .method03023(this);
      this.field03494 = this.method06449(this, 0.0F, field03507);
      this.field03494.method02682(true);
   }

   public BooleanSetting method01427() {
      return this.field03489;
   }

   private boolean method01428(Level var1, AbstractThrownPotion var2, Entity var3) {
      if (var1 != null && var2 != null && var3 != null) {
         long var4 = var1.getGameTime();
         this.method01426(var4);
         long var6 = (long)var2.getId() << 32 ^ var3.getId() & field03508;
         Long var8 = this.field03485.get(var6);
         if (var8 != null && var4 >= var8 && var4 - var8 <= 0L) {
            return true;
         }

         this.field03485.put(var6, var4);
         return false;
      } else {
         return false;
      }
   }

   private boolean method01429(Component var1) {
      TextColor var2 = var1.getStyle().getColor();
      if (var2 != null && (var2.getValue() & field03516) != field03517) {
         return true;
      }

      for (Component var4 : var1.getSiblings()) {
         if (this.method01429(var4)) {
            return true;
         }
      }

      return false;
   }
}
