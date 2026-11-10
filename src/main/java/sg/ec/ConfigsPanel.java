// Original binary: sg/ec/9iZc59m2tMquz7lo
package sg.ec;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import ru.dreamix.protection.api.impl.profile.ProfileAPI;

// $VF: Compiled from s
public class ConfigsPanel extends GuiPanel {
   private static final float field05465 = 22.0F;
   private static final long field05466 = 0;
   private static final float field05467 = 0;
   private static final float field05468 = 0;
   private static final float field05469 = 0;
   private static final float field05470 = 0;
   private static final float field05471 = 0;
   private static final float field05472 = 0;
   private static final float field05473 = 0;
   private static final float field05474 = 0;
   private static final float field05475 = 0;
   private static final float field05476 = 0;
   private static final float field05477 = 0;
   private static final float field05478 = 0;
   private static final float field05479 = 0;
   private static final float field05480 = 0;
   private static final float field05481 = 0;
   private static final float field05482 = 0;
   private static final float field05483 = 0;
   private static final float field05484 = 0;
   private static final double field05485 = 0;
   private static final double field05486 = 0;
   private static final float field05487 = 0;
   private static final double field05488 = 0;
   private static final float field05489 = 0;
   private static final int field05490 = 0;
   private static final int field05491 = 0;
   private static final String field05492 = "field05492";
   private static final String field05493 = "field05493";
   private final ClickGuiScreen field05494;
   private final SimpleDateFormat field05495;
   private final AnimationUtils field05496;
   private String field05497;
   private ConfigsPanel.Nested65 field05498;
   private ConfigsPanel.Nested61 field05499;
   private final AnimationUtils field05500;
   private ConfigsPanel.Nested65 field05501;
   private int field05502;
   private boolean field05503;
   private boolean field05504;
   private boolean field05505;
   private final TextInputWidget field05506;
   private final List<ConfigsPanel.Nested64> field05507;
   private final List<ConfigsPanel.Nested62> field05508;
   private final List<ConfigsPanel.Nested60> field05509;
   private final List<ConfigsPanel.Nested63> field05510;
   private GuiPanel.Nested283 field05511;
   private GuiPanel.Nested283 field05512;
   private GuiPanel.Nested283 field05513;
   private GuiPanel.Nested283 field05514;
   private GuiPanel.Nested283 field05515;
   private static final float field05516 = 6.0F;
   private static final float field05517 = 6.0F;
   private static final float field05518 = 6.0F;
   private static final float field05519 = 6.0F;
   private static final float field05520 = 10.0F;
   private static final float field05521 = 9.0F;
   private static final float field05522 = 5.0F;
   private static final float field05523 = 7.0F;
   private static final float field05524 = 9.0F;
   private static final float field05525 = 7.0F;
   private static final float field05526 = 6.0F;
   private static final float field05527 = 5.0F;
   private static final float field05528 = 8.0F;
   private static final float field05529 = 4.5F;
   private static final float field05530 = 8.5F;
   private static final float field05531 = 3.0F;
   private static final float field05532 = 4.0F;
   private static final float field05533 = 4.5F;
   private static final float field05534 = 4.25F;
   private static final float field05535 = 5.0F;
   private static final float field05536 = 5.0F;
   private static final float field05537 = 5.0F;
   private static final float field05538 = 7.0F;
   private static final float field05539 = 2.5F;
   private static final String field05540 = "—";
   private static final String field05541 = "никто";
   private static final String field05542 = ", ";
   private static final float field05543 = 6.0F;
   private static final float field05544 = 13.0F;
   private static final float field05545 = 13.0F;
   private static final float field05546 = 6.0F;
   private static final float field05547 = 13.0F;
   private static final float field05548 = 13.0F;
   private static final float field05549 = 13.0F;
   private static final float field05550 = 13.0F;
   private static final String field05551 = "dd.MM.yy HH:mm";
   private static final long field05552 = 260L;
   private static final long field05553 = 260L;
   private static final float field05554 = 6.5F;
   private static final String field05555 = "Название: ";
   private static final float field05556 = 7.0F;
   private static final float field05557 = 22.0F;
   private static final float field05558 = 6.0F;
   private static final float field05559 = 12.0F;
   private static final float field05560 = 31.0F;
   private static final float field05561 = 31.0F;
   private static final float field05562 = 31.0F;
   private static final float field05563 = 26.0F;
   private static final String field05564 = "key:";
   private static final String field05565 = "sale:";
   private static final String field05566 = "mkt:";
   private static final String field05567 = "cfg:";
   private static final float field05568 = 6.0F;
   private static final float field05569 = 12.0F;
   private static final String field05570 = "Пусто";
   private static final String field05571 = "Нет конфигов — нажми «Создать»";
   private static final String field05572 = "cfg:";
   private static final String field05573 = "cfg:";
   private static final float field05574 = 6.0F;
   private static final float field05575 = 12.0F;
   private static final String field05576 = "empty:key";
   private static final String field05577 = "Ключей нет — поделись конфигом";
   private static final String field05578 = "key:";
   private static final String field05579 = "key:";
   private static final float field05580 = 6.0F;
   private static final float field05581 = 12.0F;
   private static final String field05582 = "empty:mkt";
   private static final String field05583 = "Пока пусто — активируй купленный ключ";
   private static final String field05584 = "mkt:";
   private static final String field05585 = "mkt:";
   private static final float field05586 = 6.0F;
   private static final float field05587 = 12.0F;
   private static final String field05588 = "empty:sale";
   private static final String field05589 = "Ничего не продаётся — «Продать» в меню конфига";
   private static final String field05590 = "sale:";
   private static final String field05591 = "sale:";
   private static final float field05592 = 6.5F;
   private static final float field05593 = 6.0F;
   private static final String field05594 = "Ключи";
   private static final float field05595 = 5.0F;
   private static final String field05596 = "Обновить";
   private static final float field05597 = 5.0F;
   private static final float field05598 = 9.0F;
   private static final String field05599 = "Продано:";
   private static final String field05600 = "Активировали:";
   private static final float field05601 = 6.0F;
   private static final float field05602 = 6.5F;
   private static final String field05603 = "Загрузить";
   private static final String field05604 = "—";
   private static final float field05605 = 9.0F;
   private static final String field05606 = "Продавец:";
   private static final String field05607 = "Твой ключ:";
   private static final String field05608 = "Активирован:";
   private static final float field05609 = 9.0F;
   private static final String field05610 = "Тип:";
   private static final String field05611 = "THEME";
   private static final String field05612 = "Тема";
   private static final String field05613 = "Конфиг";
   private static final String field05614 = "Автор:";
   private static final String field05615 = "Обновлён:";
   private static final float field05616 = 15.0F;
   private static final float field05617 = 3.5F;
   private static final float field05618 = 6.0F;
   private static final String field05619 = "Создать";
   private static final float field05620 = 5.0F;
   private static final String field05621 = "Сохранить";
   private static final String field05622 = "headerbtns";
   private static final float field05623 = 0.01F;
   private static final String field05624 = "Создать";
   private static final String field05625 = "create";
   private static final String field05626 = "Сохранить";
   private static final String field05627 = "save";
   private static final String field05628 = "headeract";
   private static final float field05629 = 0.01F;
   private static final String field05630 = "Активировать";
   private static final String field05631 = "Активировать";
   private static final String field05632 = "activate";
   private static final float field05633 = 6.0F;
   private static final float field05634 = 78.0F;
   private static final String field05635 = "sort";
   private static final float field05636 = 3.0F;
   private static final float field05637 = 6.0F;
   private static final float field05638 = 6.0F;
   private static final float field05639 = 4.0F;
   private static final float field05640 = 6.0F;
   private static final float field05641 = 5.0F;
   private static final float field05642 = 5.0F;
   private static final String field05643 = "scripts.menu";
   private static final String field05644 = "pager";
   private static final float field05645 = 3.0F;
   private static final float field05646 = 6.0F;
   private static final float field05647 = 3.0F;
   private static final float field05648 = 6.0F;
   private static final float field05649 = 6.5F;
   private static final double field05650 = 1000.0;
   private static final float field05651 = 6.0F;
   private static final float field05652 = 6.0F;
   private static final float field05653 = 0.45F;
   private static final float field05654 = 0.55F;
   private static final float field05655 = 0.5F;
   private static final float field05656 = 0.5F;
   private static final double field05657 = 2.2;
   private static final float field05658 = 6.5F;
   private static final float field05659 = 0.5F;
   private static final float field05660 = 0.5F;
   private static final double field05661 = 3.0;
   private static final double field05662 = 0.45;
   private static final float field05663 = 0.3F;
   private static final float field05664 = 0.7F;
   private static final float field05665 = 6.5F;
   private static final float field05666 = 6.5F;
   private static final float field05667 = 6.0F;
   private static final String field05668 = "Восстановить";
   private static final String field05669 = "Сохранить";
   private static final String field05670 = "Загрузить";
   private static final float field05671 = 6.0F;
   private static final float field05672 = 6.5F;
   private static final float field05673 = 4.0F;
   private static final float field05674 = 12.0F;
   private static final float field05675 = 12.0F;
   private static final float field05676 = 7.0F;
   private static final float field05677 = 9.0F;
   private static final String field05678 = "Изменён:";
   private static final String field05679 = "Автор:";
   private static final String field05680 = "защищён";
   private static final float field05681 = 6.0F;
   private static final float field05682 = 5.5F;
   private static final float field05683 = 5.5F;
   private static final float field05684 = 5.5F;
   private static final float field05685 = 6.5F;
   private static final float field05686 = 6.0F;
   private static final String field05687 = "Копировать";
   private static final float field05688 = 5.0F;
   private static final String field05689 = "без пересылки";
   private static final String field05690 = "всем";
   private static final float field05691 = 9.0F;
   private static final String field05692 = "Кому:";
   private static final String field05693 = "Ключ:";
   private static final String field05694 = "пустой   ";
   private static final String field05695 = "с этими настройками   ";
   private static final float field05696 = 5.0F;
   private static final float field05697 = 7.0F;
   private static final float field05698 = 5.0F;
   private static final float field05699 = 5.0F;
   private static final float field05700 = 6.0F;
   private static final String field05701 = "[^\\p{L}\\p{N}_.-]";
   private static final String field05702 = "_";
   private static final String field05703 = "Ключ";
   private static final String field05704 = "Продать";
   private static final String field05705 = "Удалить";
   private static final float field05706 = 96.0F;
   private static final float field05707 = 140.0F;
   private static final float field05708 = 84.0F;
   private static final float field05709 = 148.0F;
   private static final float field05710 = 70.0F;
   private static final float field05711 = 196.0F;
   private static final float field05712 = 190.0F;
   private static final float field05713 = 150.0F;
   private static final float field05714 = 70.0F;
   private static final String field05715 = "Cloud";
   private static final String field05716 = "Ключ скопирован в буфер обмена.";
   private static final float field05717 = -1000000.0F;
   private static final float field05718 = -1000000.0F;
   private static final float field05719 = 26.0F;
   private static final float field05720 = -1000000.0F;
   private static final float field05721 = -1000000.0F;
   private static final float field05722 = 26.0F;
   private static final float field05723 = -1000000.0F;
   private static final float field05724 = -1000000.0F;
   private static final float field05725 = 26.0F;
   private static final float field05726 = -1000000.0F;
   private static final float field05727 = -1000000.0F;
   private static final float field05728 = 26.0F;
   private static final float field05729 = 26.0F;
   private static final float field05730 = 26.0F;
   private static final float field05731 = 26.0F;
   private static final float field05732 = 26.0F;

   private void method02279() {
      GlobalRequestSender.method09378(var0 -> {
         var0.method01844();
         var0.method01873();
         var0.method01851();
         var0.method01856();
         var0.method01812();
      });
   }

   public boolean method02280(double var1) {
      return this.method10181(var1);
   }

   private void method02281(String var1, GuiPanel.Nested283 var2, boolean var3) {
      ArrayList var4 = new ArrayList();
      if (!var3) {
         var4.add(new ScriptsWindow.Nested34(GuiIcon.SHARE, field05703, () -> this.method02285(var1)));
         var4.add(new ScriptsWindow.Nested34(GuiIcon.CART, field05704, () -> this.method02295(var1)));
      }

      var4.add(new ScriptsWindow.Nested34(GuiIcon.DELETE, field05705, () -> this.method02313(var1)));
      ScriptsWindow var5 = new ScriptsWindow(var4);
      this.field05503 = false;
      float var6 = this.field05494.method09986() + this.field05494.method10015();
      float var7 = this.field05494.method09963() + this.field05494.method10026();
      float var8 = Math.min(var2.field23010(), var6 - var5.method09568() - 2.0F);
      float var9 = var2.field23011() + var2.field23013() + 2.0F;
      if (var9 + var5.method09574() > var7) {
         var9 = var2.field23011() - var5.method09574() - 2.0F;
      }

      this.field05494.method09983().method09652(var5, var8, var9);
   }

   private static String method02283(List<String> var0) {
      if (var0 != null && !var0.isEmpty()) {
         int var1 = Math.min(2, var0.size());
         String var2 = String.join(field05542, var0.subList(0, var1));
         return var0.size() > var1 ? var2 + " +" + (var0.size() - var1) : var2;
      } else {
         return field05541;
      }
   }

   private void method02285(String var1) {
      this.method02359(new ConfigKeyWindow(var1), field05707, field05708);
   }

   private float method02287(GuiGraphicsExtractor var1, String var2, float var3, float var4, int var5) {
      FontRenderer var6 = Fonts.field00110;
      var6.method09480(var1, var2, var3 + field05521, var4 + field05522, var5, field05523);
      return var3 + field05524 + var6.method09486(var2, field05525) + field05526;
   }

   private float method02289(ConfigsPanel.Nested65 var1) {
      int var2 = switch (var1) {
         case KEYS -> this.method02321().size();
         case SALES -> this.method02349().size();
         case BOUGHT -> this.method02336().size();
         default -> this.method02294(var1).size();
      };
      float var3 = var1 == ConfigsPanel.Nested65.CONFIGS && this.field05504 ? field05560 : 0.0F;
      return var3 + var2 * field05561;
   }

   private void method02290() {
      if (this.field05511 != null) {
         boolean var1 = ConfigMarketState.field13926.method06283();
         float var2 = ConfigCreateWindow.method06865(var1);
         float var3 = this.field05494.method09986() + this.field05494.method10015();
         float var4 = this.field05494.method09963() + this.field05494.method10026();
         float var5 = Math.min(this.field05511.field23010(), var3 - field05706 - 2.0F);
         float var6 = this.field05511.field23011() + this.field05511.field23013() + 2.0F;
         if (var6 + var2 > var4) {
            var6 = this.field05511.field23011() - var2 - 2.0F;
         }

         this.field05494.method09983().method09652(new ConfigCreateWindow(var1, () -> this.method02370(true), () -> this.method02370(false)), var5, var6);
      }
   }

   private static String method02291(int var0) {
      int var1 = var0 % 10;
      int var2 = var0 % 100;
      if (var1 == 1 && var2 != 11) {
         return var0 + " конфиг активен";
      } else {
         return var1 < 2 || var1 > 4 || var2 >= 12 && var2 <= 14 ? var0 + " конфигов активно" : var0 + " конфига активно";
      }
   }

   private static void method02292(
      GuiGraphicsExtractor var0, FontRenderer var1, ConfigsPanel.Nested65 var2, float var3, float var4, double var5, float var7
   ) {
      float var8 = field05653 + field05654 * (field05655 + field05656 * (float)Math.sin(var5 * field05657));
      float var9 = var3 - var1.method09486(var2.field05734, field05658) / 2.0F;

      for (int var10 = 0; var10 < var2.field05735.length; var10++) {
         float var11 = field05659 + field05660 * (float)Math.sin(var5 * field05661 - var10 * field05662);
         float var12 = field05663 + field05664 * var11;
         var1.method09480(var0, var2.field05735[var10], var9, var4, ConfigPanelRenderer.method03126(var12 * var8 * var7), field05665);
         var9 += var1.method09486(var2.field05735[var10], field05666);
      }
   }

   private List<StoredContentInfo> method02294(ConfigsPanel.Nested65 var1) {
      GlobalWebSocketClient var2 = MiranWare.getInstance().getClient();
      if (var2 == null) {
         return List.of();
      }

      var var3 = var1 == ConfigsPanel.Nested65.DELETED ? var2.getManager().method01876() : var2.getManager().method01830();
      String var4 = this.field05494.method09960().toLowerCase();
      ArrayList var5 = new ArrayList();

      for (StoredContentInfo var7 : var3) {
         if (var7.category() == StorageCategory.CONFIG && (var4.isEmpty() || var7.name().toLowerCase().contains(var4))) {
            var5.add(var7);
         }
      }
      var5.sort(switch (this.field05499) {
         case NEWEST -> Comparator.comparingLong(StoredContentInfo::modified).reversed();
         case OLDEST -> Comparator.comparingLong(StoredContentInfo::modified);
         case NAME -> Comparator.comparing((StoredContentInfo var0) -> var0.name().toLowerCase());
      });
      return var5;
   }

   private void method02295(String var1) {
      this.method02359(new ConfigSellWindow(var1, var2 -> this.method02338(var1, var2)), field05709, field05710);
   }

   private void method02296(ConfigsPanel.Nested65 var1) {
      this.field05503 = false;
      if (var1 != this.field05498) {
         this.method10172(this.field05498.ordinal(), var1.ordinal());
         this.field05501 = this.field05498;
         this.field05502 = Integer.signum(var1.ordinal() - this.field05498.ordinal());
         method10182(this.field05500);
         this.field05498 = var1;
         this.method02309();
         GlobalRequestSender.method09378(var1x -> {
            switch (var1) {
               case KEYS:
                  var1x.method01851();
                  break;
               case SALES:
                  var1x.method01812();
                  break;
               case BOUGHT:
                  var1x.method01856();
                  break;
               case DELETED:
                  var1x.method01873();
            }
         });
      }
   }

   private GuiPanel.Nested283 method02297(
      GuiGraphicsExtractor var1, float var2, float var3, AnimationUtils var4, float var5, float var6, float var7
   ) {
      GuiPanel.Nested283 var8 = new GuiPanel.Nested283(var2 - field05547, var3, field05548, field05549);
      ConfigPanelRenderer.method03109(
         var1,
         var8.field23010(),
         var8.field23011(),
         field05550,
         GuiIcon.DELETE,
         ConfigPanelRenderer.method03127(-29813, var7),
         method10201(var4, var8.has(var5, var6)),
         var7
      );
      return var8;
   }

   private void method02298(String var1) {
      byte[] var2 = ModuleConfigStorage.method04444();
      if (var2.length != 0) {
         GlobalRequestSender.method09378(var2x -> {
            var2x.method01880(var1, var2);
            StoredContentCache.method05219(StorageCategory.CONFIG, var1, var2);
            ConfigMarketState.field13926.method06278();
            StoredContentImporter.method07240(StorageCategory.CONFIG, var1, ModuleConfigStorage.method04444());
         });
      }
   }

   private void method02299(
      GuiGraphicsExtractor var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      boolean var11,
      List<MarketListS2CPacket.Nested327> var12
   ) {
      this.method10164(
         var1, var4, var5 - field05580, var7, var6 + field05581, var8 - var7, field05582, field05583, var12.isEmpty() && !this.method10171(field05584)
      );
      if (!var12.isEmpty()) {
         this.method10170(
            field05585,
            var12.size(),
            var1x -> ((MarketListS2CPacket.Nested327)var12.get(var1x)).name(),
            var7 + var9 + var10,
            var7,
            var8,
            var5,
            var6,
            var4,
            var11,
            (var5x, var6x, var7x, var8x, var9x, var10x) -> this.method02335(
               var1, var2, var3, var5x, var6x, var7x, var8x, field05730, (MarketListS2CPacket.Nested327)var12.get(var10x), var9x
            )
         );
      }
   }

   private String method02300(long var1) {
      return var1 > 0L ? this.field05495.format(new Date(var1)) : field05540;
   }

   private void method02303(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      FontRenderer var8 = Fonts.field00110;
      this.method10224(var1, var7, var3, var4, var5, var6, 1.0F);
      this.field05506.method06700(var3, var4, var5, var6).method06670(var1, var2, var7);
      String var9 = (this.field05505 ? field05694 : field05695) + "Enter — создать, Esc — отмена";
      var8.method09480(
         var1,
         var9,
         var3 + var5 - var8.method09486(var9, field05696) - field05697,
         var4 + var6 / 2.0F - var8.method09485(field05698) / 2.0F,
         ConfigPanelRenderer.method03118(var7),
         field05699
      );
   }

   private void method02304(ConfigsPanel.Nested65 var1) {
      String var2 = switch (var1) {
         case KEYS -> field05564;
         case SALES -> field05565;
         case BOUGHT -> field05566;
         default -> field05567;
      };
      this.field22874.keySet().removeIf(var1x -> !var1x.startsWith(var2));
   }

   private void method02305(
      GuiGraphicsExtractor var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      boolean var11,
      List<SaleListS2CPacket.Nested122> var12
   ) {
      this.method10164(
         var1, var4, var5 - field05586, var7, var6 + field05587, var8 - var7, field05588, field05589, var12.isEmpty() && !this.method10171(field05590)
      );
      if (!var12.isEmpty()) {
         this.method10170(
            field05591,
            var12.size(),
            var1x -> ((SaleListS2CPacket.Nested122)var12.get(var1x)).field09299(),
            var7 + var9 + var10,
            var7,
            var8,
            var5,
            var6,
            var4,
            var11,
            (var5x, var6x, var7x, var8x, var9x, var10x) -> this.method02374(
               var1, var2, var3, var5x, var6x, var7x, var8x, field05729, (SaleListS2CPacket.Nested122)var12.get(var10x), var9x
            )
         );
      }
   }

   public ConfigsPanel(ClickGuiScreen var1) {
      this.field05495 = new SimpleDateFormat(field05551);
      this.field05496 = method10166(field05552);
      this.field05497 = "";
      this.field05498 = ConfigsPanel.Nested65.CONFIGS;
      this.field05499 = ConfigsPanel.Nested61.NEWEST;
      this.field05500 = method10166(field05553);
      this.field05501 = ConfigsPanel.Nested65.CONFIGS;
      this.field05502 = 1;
      this.field05506 = new TextInputWidget().method06678(Fonts.field00110, field05554);
      this.field05507 = new ArrayList<>();
      this.field05508 = new ArrayList<>();
      this.field05509 = new ArrayList<>();
      this.field05510 = new ArrayList<>();
      this.field05494 = var1;
      method10205(this.field05496, 1.0F);
      method10205(this.field05500, 1.0F);
      this.field05497 = this.field05499.field05733;
      this.field05506.method06712(field05555);
      this.field05506.method06681(false);
      this.field05506.method06669(32);
      this.field05506.method06734(field05556);
      this.field05506.method06689(this::method02371);
      this.field05506.method06705(this::method02309);
   }

   private void method02306(String var1) {
      if (mc != null) {
         mc.keyboardHandler.setClipboard(var1);
         ChatTextUtils.method05101(field05715, field05716);
      }
   }

   private void method02307(String var1) {
      if (GlobalRequestSender.method09378(var1x -> var1x.method01817(StorageCategory.CONFIG, var1))) {
         ActiveConfigTracker.field06857.method03062(var1);
      }
   }

   private void method02309() {
      this.field05504 = false;
      this.field05506.method06702();
   }

   private void method02310(
      GuiGraphicsExtractor var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      boolean var11,
      ConfigsPanel.Nested65 var12,
      List<StoredContentInfo> var13
   ) {
      this.method10164(
         var1,
         var4,
         var5 - field05568,
         var7,
         var6 + field05569,
         var8 - var7,
         "empty:cfg:" + var12,
         var12 == ConfigsPanel.Nested65.DELETED ? field05570 : field05571,
         var13.isEmpty() && !this.method10171(field05572)
      );
      if (!var13.isEmpty()) {
         this.method10214(
            field05573,
            var13.size(),
            var1x -> ((StoredContentInfo)var13.get(var1x)).name(),
            var7,
            var8,
            var9,
            var10,
            var5,
            var6,
            var4,
            var11,
            (var6x, var7x, var8x, var9x, var10x, var11x) -> this.method02340(
               var1, var2, var3, var6x, var7x, var8x, var9x, field05732, (StoredContentInfo)var13.get(var11x), var10x, var12
            )
         );
      }
   }

   private static GuiPanel.Nested283 method02311(float var0, float var1, float var2, String var3) {
      float var4 = ConfigPanelRenderer.method03106(Fonts.field00111, var3, field05667, var2);
      return new GuiPanel.Nested283(var0 - var4, var1, var4, var2);
   }

   private void method02312(String var1) {
      this.method02325(var1, ModuleConfigStorage.method04447());
   }

   private void method02313(String var1) {
      if (GlobalRequestSender.method09378(var1x -> var1x.method01782(StorageCategory.CONFIG, var1)) && ActiveConfigTracker.field06857.method03059(var1)) {
         ActiveConfigTracker.field06857.method03061();
      }
   }

   public void method02317(int var1, int var2, int var3) {
      this.field05506.method06733(var1);
   }

   private void method02320(GuiGraphicsExtractor var1, float var2, float var3, float var4, String... var5) {
      FontRenderer var6 = Fonts.field00111;
      float var7 = var2;

      for (byte var8 = 0; var8 + 1 < var5.length; var8 += 2) {
         String var9 = var5[var8];
         String var10 = var5[var8 + 1];
         var6.method09480(var1, var9, var7, var3, ConfigPanelRenderer.method03104(var4), field05516);
         var7 += var6.method09486(var9, field05517) + 2.0F;
         var6.method09480(var1, var10, var7, var3, ConfigPanelRenderer.method03126(var4), field05518);
         var7 += var6.method09486(var10, field05519) + field05520;
      }
   }

   private List<ConfigShareRequest> method02321() {
      GlobalWebSocketClient var1 = MiranWare.getInstance().getClient();
      if (var1 == null) {
         return List.of();
      }

      String var2 = this.field05494.method09960().toLowerCase();
      ArrayList var3 = new ArrayList();

      for (ConfigShareRequest var5 : var1.getManager().method01807()) {
         if (var2.isEmpty() || var5.config().toLowerCase().contains(var2)) {
            var3.add(var5);
         }
      }

      return var3;
   }

   private void method02323(SaleListS2CPacket.Nested122 var1) {
      byte[] var2 = ActiveConfigTracker.field06857.method03059(var1.config()) ? ModuleConfigStorage.method04447() : new byte[0];
      if (var2.length > 0) {
         this.method02325(var1.config(), var2);
      }

      GlobalRequestSender.method09378(var2x -> var2x.method01787(var1.field09299(), var2));
   }

   private GuiPanel.Nested283 method02324(
      GuiGraphicsExtractor var1, float var2, float var3, String var4, GuiIcon var5, AnimationUtils var6, float var7, float var8, float var9
   ) {
      FontRenderer var10 = Fonts.field00111;
      float var11 = ConfigPanelRenderer.method03106(var10, var4, field05543, field05544);
      GuiPanel.Nested283 var12 = new GuiPanel.Nested283(var2 - var11, var3, var11, field05545);
      ConfigPanelRenderer.method03121(
         var1,
         var10,
         var12.field23010(),
         var12.field23011(),
         var12.field23012(),
         var12.field23013(),
         var5,
         ConfigPanelRenderer.method03115(var9),
         var4,
         field05546,
         method10201(var6, var12.has(var7, var8)),
         var9
      );
      return var12;
   }

   private void method02325(String var1, byte[] var2) {
      if (var2.length != 0) {
         GlobalRequestSender.method09378(var2x -> {
            var2x.method01779(var1, var2);
            StoredContentCache.method05219(StorageCategory.CONFIG, var1, var2);
         });
      }
   }

   private void method02326(String var1) {
      GlobalRequestSender.method09378(var1x -> var1x.method01864(StorageCategory.CONFIG, var1));
   }

   private void method02329(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      FontRenderer var8 = Fonts.field00111;
      float var9 = field05616;
      float var10 = var6 + field05617;
      float var11 = var5 + var7 - field05618;
      GuiPanel.Nested283 var12 = method02311(var11, var10, var9, field05619);
      GuiPanel.Nested283 var13 = method02311(var12.field23010() - field05620, var10, var9, field05621);
      float var14 = this.method10168(field05622, this.field05498 == ConfigsPanel.Nested65.CONFIGS);
      if (var14 > field05623) {
         this.method02377(var1, var12, field05624, GuiIcon.PLUS, field05625, var2, var3, var4 * var14);
         this.method02377(var1, var13, field05626, GuiIcon.SAVE, field05627, var2, var3, var4 * var14);
         this.field05511 = this.field05498 == ConfigsPanel.Nested65.CONFIGS ? var12 : null;
         this.field05512 = this.field05498 == ConfigsPanel.Nested65.CONFIGS ? var13 : null;
      } else {
         this.field05511 = null;
         this.field05512 = null;
      }

      boolean var15 = this.field05498 == ConfigsPanel.Nested65.BOUGHT;
      float var16 = this.method10168(field05628, var15);
      if (var16 > field05629) {
         GuiPanel.Nested283 var17 = method02311(var11, var10, var9, field05630);
         this.method02377(var1, var17, field05631, GuiIcon.CHECK, field05632, var2, var3, var4 * var16);
         this.field05513 = var15 ? var17 : null;
      } else {
         this.field05513 = null;
      }

      this.field05514 = new GuiPanel.Nested283(var5 + field05633, var10, field05634, var9);
      float var18 = this.method10168(field05635, this.field05514.has(var2, var3));
      ConfigPanelRenderer.method03116(
         var1,
         this.field05514.field23010(),
         this.field05514.field23011(),
         this.field05514.field23012(),
         this.field05514.field23013(),
         field05636,
         var18,
         0.0F,
         var4
      );
      this.field05496.method03375(1.0);
      TextRenderUtils.method00671(
         var1,
         var8,
         this.field05497,
         this.field05499.field05733,
         this.field05496.method03377(),
         this.field05514.field23010() + field05637,
         this.field05514.field23011() + this.field05514.field23013() / 2.0F - var8.method09485(field05638) / 2.0F,
         this.field05514.field23010() + this.field05514.field23012() - field05639,
         ConfigPanelRenderer.method03120(var18, var4),
         field05640
      );
      this.method02330(
         var1, var2, var3, var4, this.field05514.field23010() + this.field05514.field23012() + field05641, var13.field23010() - field05642, var10, var9
      );
   }

   private void method02330(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      this.field05515 = new GuiPanel.Nested283(var5, var7, var6 - var5, var8);
      boolean var9 = this.field05494.method09983().method09669(field05643) != null && this.field05503;
      float var10 = this.method10168(field05644, this.field05515.has(var2, var3) || var9);
      ConfigPanelRenderer.method03116(
         var1,
         this.field05515.field23010(),
         this.field05515.field23011(),
         this.field05515.field23012(),
         this.field05515.field23013(),
         field05645,
         var10,
         0.0F,
         var4
      );
      GuiIcon.EXPAND
         .method01190(
            var1,
            this.field05515.field23010() + this.field05515.field23012() - field05646 - field05647,
            var7 + var8 / 2.0F,
            field05648,
            ConfigPanelRenderer.method03120(var10, var4)
         );
      FontRenderer var11 = Fonts.field00111;
      this.field05500.method03375(1.0);
      float var12 = this.field05500.method03377();
      float var13 = this.field05515.field23010() + this.field05515.field23012() / 2.0F;
      float var14 = var7 + var8 / 2.0F - var11.method09485(field05649) / 2.0F;
      double var15 = System.currentTimeMillis() / field05650;
      if (var12 < 1.0F) {
         method02292(var1, var11, this.field05501, var13 - this.field05502 * field05651 * var12, var14, var15, (1.0F - var12) * var4);
      }

      method02292(var1, var11, this.field05498, var13 + this.field05502 * field05652 * (1.0F - var12), var14, var15, var12 * var4);
   }

   public void method02332(char var1, int var2) {
      this.field05506.method06730(var1);
   }

   private static float method02333(float var0) {
      return var0 + field05537 + Fonts.field00110.method09485(field05538) + field05539;
   }

   private void method02334(String var1) {
      GlobalRequestSender.method09378(var1x -> var1x.method01820(var1));
   }

   private void method02335(
      GuiGraphicsExtractor var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      MarketListS2CPacket.Nested327 var9,
      GuiPanel.Nested291 var10
   ) {
      this.method10224(var1, var4, var5, var6, var7, var8, method10201(var10.field23070, GuiHitTestUtils.method05625(var2, var3, var5, var6, var7, var8)));
      var10.field23078 = (var3x, var4x, var5x, var6x, var7x, var8x) -> this.method02335(
         var3x, field05723, field05724, var4x, var5x + var8x, var6x, var7x - var8x * 2.0F, field05725, var9, var10
      );
      GuiPanel.Nested283 var11 = this.method02324(
         var1, var5 + var7 - field05601, var6 + var8 / 2.0F - field05602, field05603, GuiIcon.PLAY, var10.field23071, var2, var3, var4
      );
      this.method02287(var1, var9.name(), var5, var6, ConfigPanelRenderer.method03126(var4));
      String var12 = var9.author() != null && !var9.author().isBlank() ? var9.author() : field05604;
      if (var9.activated()) {
         this.method02320(
            var1,
            var5 + field05605,
            method02333(var6),
            var4,
            field05606,
            var12,
            field05607,
            method02341(var9.key()),
            field05608,
            this.method02300(var9.redeemedAt())
         );
      } else {
         this.method02320(
            var1,
            var5 + field05609,
            method02333(var6),
            var4,
            field05610,
            field05611.equalsIgnoreCase(var9.category()) ? field05612 : field05613,
            field05614,
            var12,
            field05615,
            this.method02300(var9.updatedAt())
         );
      }

      if (this.field22882) {
         String var13 = var9.field27812() != null && !var9.field27812().isBlank() ? var9.field27812() : var9.name();
         this.field05509.add(new ConfigsPanel.Nested60(var13, var11));
      }
   }

   private List<MarketListS2CPacket.Nested327> method02336() {
      GlobalWebSocketClient var1 = MiranWare.getInstance().getClient();
      if (var1 == null) {
         return List.of();
      }

      String var2 = this.field05494.method09960().toLowerCase();
      ArrayList var3 = new ArrayList();

      for (MarketListS2CPacket.Nested327 var5 : var1.getManager().method01797()) {
         if (var5 != null && var5.name() != null && (var2.isEmpty() || var5.name().toLowerCase().contains(var2))) {
            var3.add(var5);
         }
      }
      var3.sort(switch (this.field05499) {
         case NEWEST -> Comparator.comparingLong(MarketListS2CPacket.Nested327::updatedAt).reversed();
         case OLDEST -> Comparator.comparingLong(MarketListS2CPacket.Nested327::updatedAt);
         case NAME -> Comparator.comparing((MarketListS2CPacket.Nested327 var0) -> var0.name().toLowerCase());
      });
      return var3;
   }

   public void method02337() {
      this.method02309();
      this.method10203();
      this.method02279();
   }

   private void method02338(String var1, int var2) {
      byte[] var3 = ActiveConfigTracker.field06857.method03059(var1) ? ModuleConfigStorage.method04447() : new byte[0];
      GlobalRequestSender.method09378(var3x -> var3x.method01860(var1, var2, var3));
   }

   private void method02340(
      GuiGraphicsExtractor var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      StoredContentInfo var9,
      GuiPanel.Nested291 var10,
      ConfigsPanel.Nested65 var11
   ) {
      boolean var12 = var11 == ConfigsPanel.Nested65.CONFIGS && ActiveConfigTracker.field06857.method03059(var9.name());
      float var13 = method10201(var10.field23070, GuiHitTestUtils.method05625(var2, var3, var5, var6, var7, var8));
      float var14 = method10201(var10.field23074, var12);
      this.method10224(var1, var4, var5, var6, var7, var8, var13);
      var10.field23078 = (var4x, var5x, var6x, var7x, var8x, var9x) -> this.method02340(
         var4x, field05720, field05721, var5x, var6x + var9x, var7x, var8x - var9x * 2.0F, field05722, var9, var10, var11
      );
      boolean var15 = var11 == ConfigsPanel.Nested65.DELETED;
      String var16 = var15 ? field05668 : (var12 ? field05669 : field05670);
      GuiIcon var17 = var15 ? GuiIcon.IMPORT : (var12 ? GuiIcon.SAVE : GuiIcon.PLAY);
      GuiPanel.Nested283 var18 = this.method02324(
         var1, var5 + var7 - field05671, var6 + var8 / 2.0F - field05672, var16, var17, var10.field23071, var2, var3, var4
      );
      GuiPanel.Nested283 var19 = null;
      if (var11 == ConfigsPanel.Nested65.CONFIGS) {
         var19 = new GuiPanel.Nested283(var18.field23010() - field05673 - field05674, var6, field05675, var8);
         GuiIcon.DOTS
            .method01190(
               var1,
               var19.field23010() + var19.field23012() / 2.0F,
               var6 + var8 / 2.0F,
               field05676,
               ConfigPanelRenderer.method03120(method10201(var10.field23072, var19.has(var2, var3)), var4)
            );
      }

      this.method02287(
         var1,
         var9.name(),
         var5,
         var6,
         ConfigPanelRenderer.method03122(ConfigPanelRenderer.method03120(var13, var4), ConfigPanelRenderer.method03115(var4), var14)
      );
      this.method02320(
         var1, var5 + field05677, method02333(var6), var4, field05678, this.method02300(var9.modified()), field05679, ProfileAPI.get().getModel().getName()
      );
      if (var9.locked()) {
         FontRenderer var20 = Fonts.field00110;
         String var21 = field05680;
         float var22 = (var19 != null ? var19.field23010() : var18.field23010()) - field05681 - var20.method09486(var21, field05682);
         var20.method09480(var1, var21, var22, var6 + var8 / 2.0F - var20.method09485(field05683) / 2.0F, ConfigPanelRenderer.method03118(var4), field05684);
      }

      if (this.field22882) {
         this.field05507.add(new ConfigsPanel.Nested64(var9.name(), var18, var19, var15, var9.locked()));
      }
   }

   private static String method02341(String var0) {
      return var0.length() > 14 ? var0.substring(0, 14) + "…" : var0;
   }

   private void method02342(
      GuiGraphicsExtractor var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      boolean var10,
      ConfigsPanel.Nested65 var11
   ) {
      float var12 = var11 == ConfigsPanel.Nested65.CONFIGS && this.field05504 ? field05562 : 0.0F;
      if (var11 == ConfigsPanel.Nested65.CONFIGS && this.field05504) {
         this.method02303(var1, var2, var5, var7 + var9, var6, field05563, var4);
      }

      switch (var11) {
         case KEYS:
            this.method02362(var1, var2, var3, var4, var5, var6, var7, var8, var9, var12, var10, this.method02321());
            break;
         case SALES:
            this.method02305(var1, var2, var3, var4, var5, var6, var7, var8, var9, var12, var10, this.method02349());
            break;
         case BOUGHT:
            this.method02299(var1, var2, var3, var4, var5, var6, var7, var8, var9, var12, var10, this.method02336());
            break;
         default:
            this.method02310(var1, var2, var3, var4, var5, var6, var7, var8, var9, var12, var10, var11, this.method02294(var11));
      }
   }

   private void method02343(
      GuiGraphicsExtractor var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      ConfigShareRequest var9,
      GuiPanel.Nested291 var10
   ) {
      this.method10224(var1, var4, var5, var6, var7, var8, method10201(var10.field23070, GuiHitTestUtils.method05625(var2, var3, var5, var6, var7, var8)));
      var10.field23078 = (var3x, var4x, var5x, var6x, var7x, var8x) -> this.method02343(
         var3x, field05717, field05718, var4x, var5x + var8x, var6x, var7x - var8x * 2.0F, field05719, var9, var10
      );
      float var11 = var6 + var8 / 2.0F - field05685;
      GuiPanel.Nested283 var12 = this.method02324(
         var1, var5 + var7 - field05686, var11, field05687, GuiIcon.COPY, var10.field23071, var2, var3, var4
      );
      GuiPanel.Nested283 var13 = this.method02297(var1, var12.field23010() - field05688, var11, var10.field23073, var2, var3, var4);
      float var14 = this.method02287(var1, var9.config(), var5, var6, ConfigPanelRenderer.method03126(var4));
      if (var9.noShare()) {
         this.method02347(var1, field05689, var14, var6, var4);
      }

      String var15 = var9.target() != null && !var9.target().isEmpty() ? var9.target() : field05690;
      String var16 = method02341(var9.key());
      this.method02320(var1, var5 + field05691, method02333(var6), var4, field05692, var15, field05693, var16);
      if (this.field22882) {
         this.field05508.add(new ConfigsPanel.Nested62(var9.key(), var12, var13));
      }
   }

   private void method02345() {
      ArrayList var1 = new ArrayList();

      for (ConfigsPanel.Nested65 var5 : ConfigsPanel.Nested65.values()) {
         var1.add(new ScriptsWindow.Nested34(var5.field05736, var5.field05734, () -> this.method02296(var5)));
      }

      ScriptsWindow var6 = new ScriptsWindow(var1);
      float var7 = this.field05515.field23010() + this.field05515.field23012() / 2.0F - var6.method09568() / 2.0F;
      float var8 = this.field05515.field23011() + this.field05515.field23013() + 2.0F;
      this.field05494.method09983().method09652(var6, var7, var8);
      this.field05503 = true;
   }

   public void method02346(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      this.field05507.clear();
      this.field05508.clear();
      this.field05509.clear();
      this.field05510.clear();
      float var5 = var2;
      float var6 = var3;
      float var7 = this.field05494.method09986();
      float var8 = this.field05494.method09963();
      float var9 = this.field05494.method10015();
      float var10 = this.field05494.method10026();
      this.method02329(var1, var5, var6, var4, var7, var8, var9);
      float var11 = var8 + field05557;
      float var12 = var8 + var10;
      float var13 = var7 + field05558;
      float var14 = var9 - field05559;
      float var15 = this.method10226(this.method02289(this.field05498), var12 - var11);
      this.method10211(
         var1,
         var4,
         var13,
         var14,
         var11,
         var12,
         this.field05498.ordinal(),
         var15,
         (var8x, var9x, var10x, var11x) -> this.method02342(
            var1, var5, var6, var8x, var13, var14, var11, var12, var9x, var10x, ConfigsPanel.Nested65.values()[var11x]
         )
      );
   }

   private void method02347(GuiGraphicsExtractor var1, String var2, float var3, float var4, float var5) {
      FontRenderer var6 = Fonts.field00111;
      float var7 = var6.method09486(var2, field05527) + field05528;
      ConfigPanelRenderer.method03111(
         var1, var3, var4 + field05529, var7, field05530, field05531, ConfigPanelRenderer.method03128(var5), ConfigPanelRenderer.method03119(var5)
      );
      var6.method09480(
         var1, var2, var3 + field05532, var4 + field05533 + field05534 - var6.method09485(field05535) / 2.0F, ConfigPanelRenderer.method03104(var5), field05536
      );
   }

   private List<SaleListS2CPacket.Nested122> method02349() {
      GlobalWebSocketClient var1 = MiranWare.getInstance().getClient();
      if (var1 == null) {
         return List.of();
      }

      String var2 = this.field05494.method09960().toLowerCase();
      ArrayList var3 = new ArrayList();

      for (SaleListS2CPacket.Nested122 var5 : var1.getManager().method01870()) {
         if (var5 != null && var5.config() != null && (var2.isEmpty() || var5.config().toLowerCase().contains(var2))) {
            var3.add(var5);
         }
      }
      var3.sort(switch (this.field05499) {
         case NEWEST -> Comparator.comparingLong(SaleListS2CPacket.Nested122::updated).reversed();
         case OLDEST -> Comparator.comparingLong(SaleListS2CPacket.Nested122::updated);
         case NAME -> Comparator.comparing((SaleListS2CPacket.Nested122 var0) -> var0.config().toLowerCase());
      });
      return var3;
   }

   @Override
   protected void method02351(int var1) {
      this.method02304(ConfigsPanel.Nested65.values()[var1]);
   }

   public void method02352(double var1, double var3, int var5) {
      this.field05506.method06673(var1, var3, var5);
   }

   private void method02353(String var1) {
      GlobalRequestSender.method09378(var1x -> var1x.method01833(var1));
   }

   private void method02355() {
      String var1 = ActiveConfigTracker.field06857.method03060();
      if (var1.isEmpty()) {
         this.method02370(false);
      } else {
         this.method02312(var1);
      }
   }

   private void method02359(FloatingWindow var1, float var2, float var3) {
      float var4 = this.field05494.method09986() + this.field05494.method10015() / 2.0F - var2 / 2.0F;
      float var5 = this.field05494.method09963() + this.field05494.method10026() / 2.0F - var3 / 2.0F;
      this.field05494.method09983().method09652(var1, var4, var5);
   }

   private void method02362(
      GuiGraphicsExtractor var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      boolean var11,
      List<ConfigShareRequest> var12
   ) {
      this.method10164(
         var1, var4, var5 - field05574, var7, var6 + field05575, var8 - var7, field05576, field05577, var12.isEmpty() && !this.method10171(field05578)
      );
      if (!var12.isEmpty()) {
         this.method10170(
            field05579,
            var12.size(),
            var1x -> ((ConfigShareRequest)var12.get(var1x)).key(),
            var7 + var9 + var10,
            var7,
            var8,
            var5,
            var6,
            var4,
            var11,
            (var5x, var6x, var7x, var8x, var9x, var10x) -> this.method02343(
               var1, var2, var3, var5x, var6x, var7x, var8x, field05731, (ConfigShareRequest)var12.get(var10x), var9x
            )
         );
      }
   }

   public boolean method02368(double var1, double var3, int var5) {
      if (var5 != 0) {
         return false;
      }

      float var6 = (float)var1;
      float var7 = (float)var3;
      if (method10179(this.field05515, var6, var7)) {
         this.method02345();
         return true;
      }

      if (this.field05504 && this.field05506.method06703(var6, var7, var5)) {
         return true;
      }

      if (method10179(this.field05514, var6, var7)) {
         this.field05497 = this.field05499.field05733;
         this.field05499 = ConfigsPanel.Nested61.values()[(this.field05499.ordinal() + 1) % ConfigsPanel.Nested61.values().length];
         method10182(this.field05496);
         return true;
      }

      if (method10179(this.field05511, var6, var7)) {
         this.method02290();
         return true;
      }

      if (method10179(this.field05512, var6, var7)) {
         this.method02355();
         return true;
      }

      if (method10179(this.field05513, var6, var7)) {
         this.method02372();
         return true;
      }

      for (ConfigsPanel.Nested62 var9 : this.field05508) {
         if (method10179(var9.copy(), var6, var7)) {
            this.method02306(var9.key());
            return true;
         }

         if (method10179(var9.delete(), var6, var7)) {
            this.method02353(var9.key());
            return true;
         }
      }

      for (ConfigsPanel.Nested63 var13 : this.field05510) {
         if (method10179(var13.keys(), var6, var7)) {
            this.method02375(var13.sale());
            return true;
         }

         if (method10179(var13.update(), var6, var7)) {
            this.method02323(var13.sale());
            return true;
         }

         if (method10179(var13.delete(), var6, var7)) {
            GlobalRequestSender.method09378(var1x -> var1x.method01871(var13.sale().field09299()));
            return true;
         }
      }

      for (ConfigsPanel.Nested60 var14 : this.field05509) {
         if (method10179(var14.install(), var6, var7)) {
            this.method02334(var14.target());
            return true;
         }
      }

      for (ConfigsPanel.Nested64 var15 : this.field05507) {
         if (method10179(var15.menu(), var6, var7)) {
            this.method02281(var15.name(), var15.menu(), var15.locked());
            return true;
         }

         if (method10179(var15.primary(), var6, var7)) {
            if (var15.trash()) {
               this.method02326(var15.name());
            } else if (ActiveConfigTracker.field06857.method03059(var15.name())) {
               this.method02312(var15.name());
            } else {
               this.method02307(var15.name());
            }

            return true;
         }
      }

      return false;
   }

   private void method02370(boolean var1) {
      this.field05504 = true;
      this.field05505 = var1;
      this.field05506.method06692();
      this.field05506.method06716();
      this.field22880 = 0.0F;
   }

   private void method02371() {
      String var1 = this.field05506.method06672().replaceAll(field05701, field05702);
      boolean var2 = this.field05505;
      this.method02309();
      if (!var1.isEmpty()) {
         if (var2) {
            this.method02298(var1);
         } else {
            this.method02312(var1);
         }

         ActiveConfigTracker.field06857.method03062(var1);
      }
   }

   private void method02372() {
      this.method02359(new ConfigRedeemWindow(), field05713, field05714);
   }

   private void method02374(
      GuiGraphicsExtractor var1,
      float var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      SaleListS2CPacket.Nested122 var9,
      GuiPanel.Nested291 var10
   ) {
      this.method10224(var1, var4, var5, var6, var7, var8, method10201(var10.field23070, GuiHitTestUtils.method05625(var2, var3, var5, var6, var7, var8)));
      var10.field23078 = (var3x, var4x, var5x, var6x, var7x, var8x) -> this.method02374(
         var3x, field05726, field05727, var4x, var5x + var8x, var6x, var7x - var8x * 2.0F, field05728, var9, var10
      );
      float var11 = var6 + var8 / 2.0F - field05592;
      GuiPanel.Nested283 var12 = this.method02324(
         var1, var5 + var7 - field05593, var11, field05594, GuiIcon.SHARE, var10.field23071, var2, var3, var4
      );
      GuiPanel.Nested283 var13 = this.method02324(
         var1, var12.field23010() - field05595, var11, field05596, GuiIcon.SAVE, var10.field23074, var2, var3, var4
      );
      GuiPanel.Nested283 var14 = this.method02297(var1, var13.field23010() - field05597, var11, var10.field23073, var2, var3, var4);
      float var15 = this.method02287(var1, var9.config(), var5, var6, ConfigPanelRenderer.method03126(var4));
      this.method02347(var1, method02291(var9.active()), var15, var6, var4);
      this.method02320(
         var1,
         var5 + field05598,
         method02333(var6),
         var4,
         field05599,
         var9.total() - var9.active() + " из " + var9.total(),
         field05600,
         method02283(var9.buyers())
      );
      if (this.field22882) {
         this.field05510.add(new ConfigsPanel.Nested63(var9, var12, var13, var14));
      }
   }

   private void method02375(SaleListS2CPacket.Nested122 var1) {
      this.method02359(new ConfigSaleKeysWindow(var1.field09299(), var1.config()), field05711, field05712);
   }

   public boolean method02376() {
      return this.field05504;
   }

   private void method02377(
      GuiGraphicsExtractor var1, GuiPanel.Nested283 var2, String var3, GuiIcon var4, Object var5, float var6, float var7, float var8
   ) {
      float var9 = this.method10168(var5, var2.has(var6, var7));
      ConfigPanelRenderer.method03121(
         var1,
         Fonts.field00111,
         var2.field23010(),
         var2.field23011(),
         var2.field23012(),
         var2.field23013(),
         var4,
         ConfigPanelRenderer.method03120(var9, var8),
         var3,
         field05700,
         var9,
         var8
      );
   }

   // $VF: Compiled from s
   private record Nested60(String target, GuiPanel.Nested283 install) {
   }

   // $VF: Compiled from s
   private enum Nested61 {
      NEWEST("Сначала новые"),
      OLDEST("Сначала старые"),
      NAME("По имени");

      final String field05733;

      Nested61(String var3) {
         this.field05733 = var3;
      }
   }

   // $VF: Compiled from s
   private record Nested62(String key, GuiPanel.Nested283 copy, GuiPanel.Nested283 delete) {
   }

   // $VF: Compiled from s
   private record Nested63(
      SaleListS2CPacket.Nested122 sale, GuiPanel.Nested283 keys, GuiPanel.Nested283 update, GuiPanel.Nested283 delete
   ) {
   }

   // $VF: Compiled from s
   private record Nested64(String name, GuiPanel.Nested283 primary, GuiPanel.Nested283 menu, boolean trash, boolean locked) {
   }

   // $VF: Compiled from s
   private enum Nested65 {
      CONFIGS("Конфиги", GuiIcon.FOLDER),
      KEYS("Ключи", GuiIcon.SHARE),
      SALES("Продажа", GuiIcon.CART),
      BOUGHT("Купленные", GuiIcon.IMPORT),
      DELETED("Недавно удалённые", GuiIcon.DELETE);

      final String field05734;
      final String[] field05735;
      final GuiIcon field05736;

      Nested65(String var3, GuiIcon var4) {
         this.field05734 = var3;
         this.field05735 = var3.split("");
         this.field05736 = var4;
      }
   }
}
