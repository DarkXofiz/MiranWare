// Original binary: sg/ec/KJuPM3kvDe3IBf0Q
package sg.ec;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public class FriendsWindow extends FloatingWindow {
   public static final String field09443 = "menu.friends";
   public static final float field09444 = 0;
   private static final float field09445 = 0;
   private static final float field09446 = 0;
   private static final float field09447 = 0;
   private static final float field09448 = 0;
   private static final float field09449 = 0;
   private static final float field09450 = 0;
   private static final float field09451 = 0;
   private static final float field09452 = 0;
   private static final float field09453 = 0;
   private static final float field09454 = 0;
   private static final float field09455 = 0;
   private static final float field09456 = 0;
   private static final float field09457 = 0;
   private static final float field09458 = 0;
   private static final float field09459 = 0;
   private static final float field09460 = 0;
   private static final float field09461 = 0;
   private static final float field09462 = 0;
   private static final float field09463 = 0;
   private static final float field09464 = 0;
   private static final float field09465 = 0;
   private static final float field09466 = 0;
   private static final float field09467 = 0;
   private static final float field09468 = 0;
   private static final float field09469 = GuiSize.method04763(FriendsWindow.field09654)
      .method04764(FriendsWindow.field09655)
      .method04768();
   private static final int field09470 = 0;
   private static final String field09471 = "field09471";
   private static final String[] field09472 = new String[]{
      FriendsWindow.field09656, FriendsWindow.field09657, FriendsWindow.field09658, FriendsWindow.field09659
   };
   private static final String[] field09473 = method04218();
   private static final String field09474 = "field09474";
   private static final String field09475 = "field09475";
   private static final String field09476 = "field09476";
   private static final String field09477 = "field09477";
   private static final String field09478 = "field09478";
   private static final String field09479 = "field09479";
   private static final String field09480 = "field09480";
   private static final String field09481 = "field09481";
   private static final String field09482 = "field09482";
   private static final String field09483 = "field09483";
   private static final String field09484 = "field09484";
   private static final String field09485 = "field09485";
   private static final String field09486 = "field09486";
   private static final String field09487 = "field09487";
   private static final String field09488 = "field09488";
   private static final String field09489 = "field09489";
   private static final String field09490 = "field09490";
   private static final String field09491 = "field09491";
   private static final String field09492 = "field09492";
   private static final String field09493 = "field09493";
   private static final String field09494 = "field09494";
   private static final String field09495 = "field09495";
   private static final String field09496 = "field09496";
   private final FontRenderer field09497 = GuiThemeStyle.field03544;
   private final TooltipRenderer field09498 = new TooltipRenderer(field09472, 0);
   private final TooltipRenderer field09499 = new TooltipRenderer(field09473, FriendRequestState.field11201.field11204.ordinal());
   private final ScrollController field09500 = new ScrollController();
   private final GuiClickRegions field09501 = new GuiClickRegions();
   private final GuiBounds field09502 = new GuiBounds();
   private final GuiBounds field09503 = new GuiBounds();
   private final GuiBounds field09504 = new GuiBounds();
   private final Map<Object, SmoothAnimation> field09505 = new HashMap<>();
   private final Map<String, SmoothAnimation> field09506 = new HashMap<>();
   private final TextInputWidget field09507;
   private final List<Runnable> field09508;
   private FriendsWindow.Nested127 field09509;
   private Set<String> field09510;
   private Set<String> field09511;
   private float field09512;
   private boolean field09513;
   private float field09514;
   private float field09515;
   private static final String field09516 = "menu.friends";
   private static final float field09517 = 6.5F;
   private static final float field09518 = 190.0F;
   private static final String field09519 = "Ник игрока";
   private static final float field09520 = 4.0F;
   private static final float field09521 = 5.5F;
   private static final float field09522 = 3.0F;
   private static final float field09523 = 0.9F;
   private static final float field09524 = 0.100000024F;
   private static final float field09525 = 16.0F;
   private static final float field09526 = 16.5F;
   private static final float field09527 = 16.5F;
   private static final float field09528 = 30.5F;
   private static final float field09529 = 5.0F;
   private static final float field09530 = 14.0F;
   private static final float field09531 = 90.0F;
   private static final float field09532 = 215.0F;
   private static final float field09533 = 10.0F;
   private static final float field09534 = 10.0F;
   private static final float field09535 = 5.0F;
   private static final float field09536 = 10.0F;
   private static final float field09537 = 3.0F;
   private static final float field09538 = 5.0F;
   private static final float field09539 = 16.0F;
   private static final float field09540 = 10.0F;
   private static final float field09541 = 12.0F;
   private static final float field09542 = 16.0F;
   private static final float field09543 = 12.0F;
   private static final float field09544 = 2.5F;
   private static final float field09545 = 16.0F;
   private static final float field09546 = 12.0F;
   private static final float field09547 = 2.5F;
   private static final float field09548 = 5.0F;
   private static final float field09549 = 16.0F;
   private static final float field09550 = 7.0F;
   private static final float field09551 = 7.0F;
   private static final float field09552 = 7.0F;
   private static final String field09553 = "x";
   private static final int field09554 = -1750963;
   private static final float field09555 = 7.0F;
   private static final float field09556 = 14.0F;
   private static final float field09557 = 16.5F;
   private static final String field09558 = "друзей нет";
   private static final String field09559 = "друзей с сайта нет";
   private static final String field09560 = "заявок нет";
   private static final float field09561 = 0.15F;
   private static final float field09562 = 0.5F;
   private static final float field09563 = 5.0F;
   private static final float field09564 = 10.0F;
   private static final float field09565 = 14.0F;
   private static final float field09566 = 2.5F;
   private static final float field09567 = 5.0F;
   private static final float field09568 = 4.0F;
   private static final float field09569 = 5.0F;
   private static final float field09570 = 4.0F;
   private static final float field09571 = 1.8F;
   private static final float field09572 = 7.0F;
   private static final float field09573 = 1.8F;
   private static final float field09574 = 3.6F;
   private static final float field09575 = 5.0F;
   private static final float field09576 = 3.0F;
   private static final float field09577 = 7.0F;
   private static final float field09578 = 7.0F;
   private static final float field09579 = 14.0F;
   private static final float field09580 = 7.0F;
   private static final float field09581 = 7.0F;
   private static final float field09582 = 5.5F;
   private static final float field09583 = 5.0F;
   private static final float field09584 = 5.0F;
   private static final float field09585 = 0.85F;
   private static final float field09586 = 5.5F;
   private static final float field09587 = 1.75F;
   private static final float field09588 = 10.5F;
   private static final float field09589 = 10.5F;
   private static final float field09590 = 3.0F;
   private static final float field09591 = 10.0F;
   private static final float field09592 = 10.0F;
   private static final float field09593 = 10.0F;
   private static final float field09594 = 10.0F;
   private static final float field09595 = 10.0F;
   private static final float field09596 = 3.0F;
   private static final float field09597 = 15.333333F;
   private static final float field09598 = 9.333333F;
   private static final float field09599 = 15.333333F;
   private static final float field09600 = 2.3333335F;
   private static final float field09601 = 3.0F;
   private static final float field09602 = 5.5F;
   private static final float field09603 = 3.5F;
   private static final float field09604 = 10.5F;
   private static final float field09605 = 1.75F;
   private static final float field09606 = 5.5F;
   private static final String field09607 = "Статус";
   private static final float field09608 = 3.0F;
   private static final float field09609 = 5.0F;
   private static final float field09610 = 4.0F;
   private static final float field09611 = 7.0F;
   private static final float field09612 = 14.0F;
   private static final float field09613 = 7.0F;
   private static final float field09614 = 7.0F;
   private static final float field09615 = 5.0F;
   private static final float field09616 = 14.0F;
   private static final float field09617 = 5.0F;
   private static final float field09618 = 5.0F;
   private static final float field09619 = 46.0F;
   private static final float field09620 = 3.0F;
   private static final float field09621 = 14.0F;
   private static final float field09622 = 14.0F;
   private static final String field09623 = "Добавить";
   private static final float field09624 = 46.0F;
   private static final float field09625 = 14.0F;
   private static final float field09626 = 46.0F;
   private static final float field09627 = 14.0F;
   private static final String field09628 = "Добавить";
   private static final float field09629 = 46.0F;
   private static final float field09630 = 14.0F;
   private static final double field09631 = 0.15F;
   private static final String field09632 = "afk";
   private static final float field09633 = 0.999F;
   private static final String field09634 = "Покупка конфига";
   private static final String field09635 = "Заявка в друзья";
   private static final String field09636 = "Инвайт на сервер";
   private static final String field09637 = "Автодобавлять сайтовых";
   private static final String field09638 = "Делиться активностью";
   private static final String field09639 = "Принять";
   private static final String field09640 = "Отменить";
   private static final String field09641 = "входящая";
   private static final String field09642 = "исходящая";
   private static final String field09643 = "Позвать";
   private static final String field09644 = "Зайти";
   private static final String field09645 = "afk";
   private static final String field09646 = "афк";
   private static final String field09647 = "в сети";
   private static final String field09648 = "ТП";
   private static final String field09649 = "на сервере";
   private static final String field09650 = "в сети";
   private static final float field09651 = 5.0F;
   private static final float field09652 = 3.0F;
   private static final float field09653 = 5.5F;
   private static final float field09654 = 10.0F;
   private static final float field09655 = 0.5F;
   private static final String field09656 = "Клиент";
   private static final String field09657 = "Сайт";
   private static final String field09658 = "Заявки";
   private static final String field09659 = "Опции";

   private float method04202(GuiGraphicsExtractor var1, float var2, float var3, Runnable var4) {
      float var5 = var2 - field09591;
      float var6 = this.field09512 + 2.0F;
      GuiBounds var7 = new GuiBounds();
      var7.method02801(var5);
      var7.method02806(var6);
      var7.method02803(field09592);
      var7.method02798(field09593);
      this.method04239(var1, var7, var3);
      this.field09501.method03442(var5, var6, field09594, field09595, var4);
      return var5 - field09596;
   }

   private int method04204(Friend var1) {
      String var2 = var1.method03787().toLowerCase(Locale.ROOT);
      if (this.field09510.contains(var2)) {
         return 0;
      } else {
         return this.field09511.contains(var2) ? 1 : 2;
      }
   }

   private void method04205(FriendsWindow.Nested127 var1) {
      if (this.field09509 != var1) {
         this.field09509 = var1;
         this.field09500.method01144();
         this.field09507.method06702();
         if (var1 == FriendsWindow.Nested127.SITE || var1 == FriendsWindow.Nested127.REQUESTS) {
            method04229();
         }
      }
   }

   private void method04206(int var1, int var2) {
      if (this.field09513) {
         this.method09571(Mth.clamp(var1 - this.field09514, 0.0F, GuiScaleUtils.method06753() - this.method09568()));
         this.method09563(Mth.clamp(var2 - this.field09515, 0.0F, GuiScaleUtils.method06754() - this.method09574()));
      }
   }

   private void method04208(GuiGraphicsExtractor var1, float var2) {
      float var3 = this.method04227(var1, var2);
      GuiBounds var4 = this.field09499.method02647();
      float var5 = this.field09499.method02649(this.field09497, field09602, field09603);
      var4.method02803(var5);
      var4.method02798(field09604);
      var4.method02801(var3 - var5);
      var4.method02806(this.field09512 + field09605);
      this.field09499.method02646(var1, this.field09497, field09606, FriendRequestState.field11201.field11204.ordinal(), var2);
      this.method04246(var1, field09607, var4.method02809() - field09608, var2);
   }

   @Override
   public boolean method01686() {
      return false;
   }

   @Override
   public boolean method01698() {
      return true;
   }

   private void method04209(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      for (FriendsWindow.Nested128 var6 : method04256()) {
         this.field09508.add(() -> {
            float var6x = this.method04227(var1, var4);
            if (var6.incoming()) {
               var6x = this.method04202(var1, var6x, var4, () -> OfflineAccountUtils.field07854.method03530(var6.username()));
               var6x = this.method04243(var1, field09639, var6x, var2, var3, var4, () -> OfflineAccountUtils.field07854.method03528(var6.username()));
            } else {
               var6x = this.method04243(var1, field09640, var6x, var2, var3, var4, () -> OfflineAccountUtils.field07854.method03526(var6.username()));
            }

            int var7 = var6.online() ? GuiThemeStyle.field03546 : GuiThemeStyle.method01441().field22110.method11676();
            this.method04210(var1, var6.username(), var6.incoming() ? field09641 : field09642, var7, var6x, var4);
         });
      }
   }

   private void method04210(GuiGraphicsExtractor var1, String var2, String var3, int var4, float var5, float var6) {
      float var7 = this.method09576() + field09569 + field09570;
      GuiThemeStyle.method01447(var1, var7 + field09571, this.field09512 + field09572, field09573, var4, var6);
      float var8 = var7 + field09574 + field09575;
      float var9 = var5 - field09576 - var8;
      String var10 = GuiThemeStyle.method01438(this.field09497, var2, field09577, var9);
      float var11 = this.field09497.method09486(var10, field09578);
      float var12 = this.field09512 + (field09579 - this.field09497.method09485(field09580)) / 2.0F;
      this.field09497.method09480(var1, var10, var8, var12, GuiThemeStyle.method01437(var6), field09581);
      if (var3 != null) {
         String var13 = GuiThemeStyle.method01438(this.field09497, var3, field09582, var9 - var11 - field09583);
         this.field09497.method09480(var1, var13, var8 + var11 + field09584, var12 + 1.0F, GuiThemeStyle.method01445(field09585 * var6), field09586);
      }
   }

   private List<Friend> method04214() {
      ArrayList var1 = new ArrayList();

      for (String var3 : FriendManager.INSTANCE.method00173()) {
         Friend var4 = FriendManager.INSTANCE.method00174(var3);
         if (var4 != null) {
            var1.add(var4);
         }
      }

      var1.sort(Comparator.comparingInt(this::method04204).thenComparing(Comparator.comparingLong(Friend::method03785).reversed()));
      return var1;
   }

   private void method04216(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      for (Friend var6 : this.method04214()) {
         int var7 = this.method04204(var6);
         this.field09508.add(() -> {
            float var7x = this.method04227(var1, var4);
            var7x = this.method04202(var1, var7x, var4, () -> FriendManager.INSTANCE.method00180(var6.method03787()));
            if (var7 < 2) {
               var7x = this.method04243(var1, field09648, var7x, var2, var3, var4, () -> ChatTextUtils.method05080("/tpa " + var6.method03787()));
            }

            String var8 = var7 == 0 ? field09649 : (var7 == 1 ? field09650 : (var6.method03786() ? var6.method03787() : null));
            this.method04210(var1, var6.method03786() ? var6.method03788() : var6.method03787(), var8, method04247(var7), var7x, var4);
         });
      }
   }

   @Override
   public void method00613(double var1, double var3, int var5) {
      if (!(this.method09573().method06173() < field09633)) {
         if (!this.field09507.method06703(var1, var3, var5)) {
            if (var5 == 0) {
               if (this.field09502.method02799(var1, var3)) {
                  this.method09580().method09654(this);
               } else if (this.method04253(var1, var3)) {
                  this.field09513 = true;
                  this.field09514 = (float)var1 - this.method09576();
                  this.field09515 = (float)var3 - this.method09560();
               } else if (this.field09498.method02645(var1, var3)) {
                  this.method04205(FriendsWindow.Nested127.values()[this.field09498.method02648(var1)]);
               } else if (this.field09509 == FriendsWindow.Nested127.SETTINGS
                  && this.field09503.method02799(var1, var3)
                  && this.field09499.method02645(var1, var3)) {
                  this.method04217(this.field09499.method02648(var1));
               } else {
                  this.field09501.method03441(var1, var3);
               }
            }
         }
      }
   }

   @Override
   public void method01685(double var1, double var3, double var5) {
      if (this.field09503.method02799(var1, var3)) {
         this.field09500.method01133(var5);
      }
   }

   @Override
   public void method00612(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      super.method00612(var1, var2, var3, var4);
      this.method09557(this.method09569() && this.field09507.method06726());
      this.method04206(var2, var3);
      this.field09501.method03440();
      this.method04258();
      float var5 = this.method09573().method06173() * GuiHitTestUtils.method05621(var4);
      this.method04255(var1, var2, var3, var5);
      this.method04249();
      GuiRenderBatch.method05183();
      this.method04230(var1, var5);
      WindowFrameRenderer.method03057(var1, this, field09469, var5);
      this.method04252(var1, var5);
      this.field09498.method02646(var1, this.field09497, field09521, this.field09509.ordinal(), var5);
      this.method04236(var1);
      if (this.field09509 != FriendsWindow.Nested127.SETTINGS) {
         this.method04222(var1, var2, var3, var5);
      }

      var1.pose().popMatrix();
   }

   private void method04217(int var1) {
      FriendRequestState.Nested155 var2 = FriendRequestState.Nested155.values()[var1];
      FriendRequestState.field11201.field11204 = var2;
      GlobalRequestSender.method09378(var1x -> var1x.method01866(var2.name().toLowerCase(Locale.ROOT)));
   }

   private static String[] method04218() {
      FriendRequestState.Nested155[] var0 = FriendRequestState.Nested155.values();
      String[] var1 = new String[var0.length];

      for (int var2 = 0; var2 < var0.length; var2++) {
         var1[var2] = var0[var2].field11208;
      }

      return var1;
   }

   private static int method04219(SocialS2CPacket.Nested57 var0) {
      if (!var0.online()) {
         return GuiThemeStyle.method01441().field22110.method11676();
      } else {
         return field09632.equalsIgnoreCase(var0.status()) ? GuiThemeStyle.field03547 : GuiThemeStyle.field03546;
      }
   }

   @Override
   public void method04220() {
      super.method04220();
      method04229();
   }

   private static List<SocialS2CPacket.Nested57> method04221() {
      GlobalWebSocketClient var0 = MiranWare.getInstance().getClient();
      if (var0 == null) {
         return List.of();
      }

      ArrayList var1 = new ArrayList();

      for (SocialS2CPacket.Nested57 var3 : var0.getManager().method01799()) {
         if (var3 != null && var3.username() != null) {
            var1.add(var3);
         }
      }

      var1.sort(
         Comparator.<SocialS2CPacket.Nested57, Boolean>comparing(var0x -> !var0x.online()).thenComparing(var0x -> var0x.username().toLowerCase(Locale.ROOT))
      );
      return var1;
   }

   private void method04222(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      float var5 = this.method09560() + this.method09574() - field09615 - field09616;
      float var6 = this.method09576() + field09617;
      float var7 = this.method09576() + this.method09568() - field09618 - field09619;
      float var8 = var7 - field09620 - var6;
      GuiInputRenderer.method08816(var1, var6, var5, var8, field09621, method04259(this.field09505, this.field09507, this.field09507.method06726()), var4);
      this.field09507.method06700(var6, var5, var8, field09622).method06670(var1, var2, var4);
      boolean var9 = !this.field09507.method06685();
      float var10 = method04259(this.field09505, field09623, var9 && GuiHitTestUtils.method05625(var2, var3, var7, var5, field09624, field09625));
      GuiThemeStyle.method01444(
         var1, var7, var5, field09626, field09627, field09628, var10, var9 ? GuiThemeStyle.Nested40.NORMAL : GuiThemeStyle.Nested40.DISABLED, var4
      );
      if (var9) {
         this.field09501.method03442(var7, var5, field09629, field09630, this::method04245);
      }
   }

   private void method04224(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      FriendRequestState var5 = FriendRequestState.field11201;
      this.field09508.add(() -> this.method04231(var1, field09638, var5.field11203, var4, () -> {
         var5.field11203 = !var5.field11203;
         GlobalRequestSender.method09378(var1x -> var1x.method01836(var5.field11203));
      }));
      this.field09508.add(() -> this.method04208(var1, var4));
      this.field09508.add(() -> this.method04231(var1, field09637, var5.field11202, var4, () -> var5.field11202 = !var5.field11202));
      this.field09508.add(() -> this.method04231(var1, field09636, var5.field11205, var4, () -> var5.field11205 = !var5.field11205));
      this.field09508.add(() -> this.method04231(var1, field09635, var5.field11206, var4, () -> var5.field11206 = !var5.field11206));
      this.field09508.add(() -> this.method04231(var1, field09634, var5.field11207, var4, () -> var5.field11207 = !var5.field11207));
   }

   @Override
   public void method01898(char var1, int var2) {
      if (this.field09507.method06726()) {
         this.field09507.method06730(var1);
      }
   }

   private float method04227(GuiGraphicsExtractor var1, float var2) {
      ThemeSettings var3 = GuiThemeStyle.method01441();
      int var4 = ColorUtils.method04611(
         ColorUtils.method04583(var3.field22121.method11676(), ColorUtils.field10170, field09561), field09562 * var2
      );
      RoundedRectRenderer.method01272(
         var1, this.method09576() + field09563, this.field09512, this.method09568() - field09564, field09565, field09566, 1.0F, var4
      );
      return this.method09576() + this.method09568() - field09567 - field09568;
   }

   private static void method04229() {
      GlobalRequestSender.method09378(var0 -> {
         var0.method01781();
         var0.method01818();
      });
   }

   private void method04230(GuiGraphicsExtractor var1, float var2) {
      float var3 = var2 * var2 * (field09522 - 2.0F * var2);
      float var4 = field09523 + field09524 * var3;
      float var5 = this.method09576() + this.method09568() / 2.0F;
      var1.pose().pushMatrix();
      var1.pose().translate(var5, this.method09560());
      var1.pose().scale(1.0F, var4);
      var1.pose().translate(-var5, -this.method09560());
   }

   private void method04231(GuiGraphicsExtractor var1, String var2, boolean var3, float var4, Runnable var5) {
      float var6 = this.method04227(var1, var4);
      this.field09504.method02803(field09597);
      this.field09504.method02798(field09598);
      this.field09504.method02801(var6 - field09599);
      this.field09504.method02806(this.field09512 + field09600);
      ToggleSwitchRenderer.method03323(var1, this.field09504, method04259(this.field09506, var2, var3), var4);
      this.field09501
         .method03442(this.field09504.method02809(), this.field09504.method02808(), this.field09504.method02804(), this.field09504.method02802(), var5);
      this.method04246(var1, var2, this.field09504.method02809() - field09601, var4);
   }

   private static String method04233(String var0) {
      if (var0 == null) {
         return "";
      }

      int var1 = var0.indexOf(58);
      return var1 > 0 ? var0.substring(0, var1) : var0;
   }

   private void method04236(GuiGraphicsExtractor var1) {
      float var2 = this.field09503.method02808();
      float var3 = var2 + this.field09503.method02802();
      var1.enableScissor(
         (int)this.field09503.method02809(), (int)var2, (int)Math.ceil(this.field09503.method02809() + this.field09503.method02804()), (int)Math.ceil(var3)
      );
      this.field09512 = var2 + this.field09500.method01136();

      for (Runnable var5 : this.field09508) {
         if (this.field09512 + field09556 >= var2 && this.field09512 <= var3) {
            var5.run();
         }

         this.field09512 = this.field09512 + field09557;
      }

      var1.disableScissor();
   }

   public FriendsWindow() {
      super(field09516);
      this.field09507 = new TextInputWidget().method06678(GuiThemeStyle.field03544, field09517);
      this.field09508 = new ArrayList<>();
      this.field09509 = FriendsWindow.Nested127.CLIENT;
      this.field09510 = Set.of();
      this.field09511 = Set.of();
      this.method08971(field09518);
      this.field09507.method06717(field09519);
      this.field09507.method06669(24);
      this.field09507.method06734(field09520);
      this.field09507.method06689(this::method04245);
   }

   @Override
   public boolean method01682() {
      return true;
   }

   private void method04239(GuiGraphicsExtractor var1, GuiBounds var2, float var3) {
      float var4 = var2.method02808() + (var2.method02802() - this.field09497.method09485(field09552)) / 2.0F;
      this.field09497
         .method09473(var1, field09553, var2.method02809() + var2.method02804() / 2.0F, var4, ColorUtils.method04611(field09554, var3), field09555);
   }

   @Override
   public void method01689(double var1, double var3, int var5) {
      this.field09507.method06673(var1, var3, var5);
      if (var5 == 0) {
         this.field09513 = false;
      }
   }

   private float method04243(GuiGraphicsExtractor var1, String var2, float var3, float var4, float var5, float var6, Runnable var7) {
      float var8 = GuiInputRenderer.method08819(var2);
      float var9 = var3 - var8;
      float var10 = this.field09512 + field09587;
      boolean var11 = this.field09503.method02799(var4, var5);
      float var12 = method04259(this.field09505, var2 + var7.hashCode(), var11 && GuiHitTestUtils.method05625(var4, var5, var9, var10, var8, field09588));
      GuiInputRenderer.method08817(var1, var2, GuiThemeStyle.Nested40.NORMAL, var9, var10, var8, var12, var6);
      this.field09501.method03442(var9, var10, var8, field09589, var7);
      return var9 - field09590;
   }

   private void method04245() {
      String var1 = this.field09507.method06672();
      if (!var1.isEmpty()) {
         if (this.field09509 == FriendsWindow.Nested127.CLIENT) {
            FriendManager.INSTANCE.method00177(var1);
         } else {
            OfflineAccountUtils.field07854.method03536(var1);
         }

         this.field09507.method06702();
      }
   }

   private void method04246(GuiGraphicsExtractor var1, String var2, float var3, float var4) {
      float var5 = this.method09576() + field09609 + field09610;
      String var6 = GuiThemeStyle.method01438(this.field09497, var2, field09611, var3 - var5);
      this.field09497
         .method09480(
            var1, var6, var5, this.field09512 + (field09612 - this.field09497.method09485(field09613)) / 2.0F, GuiThemeStyle.method01437(var4), field09614
         );
   }

   private static int method04247(int var0) {
      return var0 == 2 ? GuiThemeStyle.method01441().field22110.method11676() : GuiThemeStyle.field03546;
   }

   private void method04249() {
      float var1 = this.field09509 == FriendsWindow.Nested127.SETTINGS ? 0.0F : field09526;
      float var2 = this.field09508.size() * field09527;
      float var3 = field09528 + var1 + field09529;
      this.method09561(Mth.clamp(var3 + Math.max(var2, field09530), field09531, field09532));
      this.field09502.method02803(field09533);
      this.field09502.method02798(field09534);
      this.field09502.method02801(this.method09576() + this.method09568() - field09535 - field09536);
      this.field09502.method02806(this.method09560() + field09537);
      GuiBounds var4 = this.field09498.method02647();
      var4.method02801(this.method09576() + field09538);
      var4.method02806(this.method09560() + field09539);
      var4.method02803(this.method09568() - field09540);
      var4.method02798(field09541);
      this.field09503.method02801(this.method09576());
      this.field09503.method02806(this.method09560() + field09542 + field09543 + field09544);
      this.field09503.method02803(this.method09568());
      this.field09503.method02798(this.method09574() - field09545 - field09546 - field09547 - var1 - field09548);
      this.field09500.method01152(var2 > this.field09503.method02802());
      this.field09500.method01145();
      this.field09500.method01134(var2, this.field09503.method02802());
   }

   private void method04250(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      for (SocialS2CPacket.Nested57 var6 : method04221()) {
         boolean var7 = var6.online() && var6.server() != null && !var6.server().isBlank();
         this.field09508
            .add(
               () -> {
                  float var7x = this.method04227(var1, var4);
                  var7x = this.method04243(
                     var1,
                     field09643,
                     var7x,
                     var2,
                     var3,
                     var4,
                     () -> GlobalRequestSender.method09378(var1xx -> var1xx.method01838(var6.username(), method04264()))
                  );
                  if (var7) {
                     var7x = this.method04243(var1, field09644, var7x, var2, var3, var4, () -> SocialNotificationSounds.method05503(var6.server()));
                  }

                  String var8 = !var6.online()
                     ? null
                     : (field09645.equalsIgnoreCase(var6.status()) ? field09646 : (var7 ? "в игре · " + method04233(var6.server()) : field09647));
                  this.method04210(var1, var6.username(), var8, method04219(var6), var7x, var4);
               }
            );
      }
   }

   private void method04252(GuiGraphicsExtractor var1, float var2) {
      ThemeSettings var3 = GuiThemeStyle.method01441();
      float var4 = this.method09560() + (field09549 - this.field09497.method09485(field09550)) / 2.0F;
      this.field09497
         .method09473(
            var1,
            this.method09566(),
            this.method09576() + this.method09568() / 2.0F,
            var4,
            ColorUtils.method04611(var3.field22108.method11679(), var2),
            field09551
         );
      this.method04239(var1, this.field09502, var2);
   }

   private boolean method04253(double var1, double var3) {
      return GuiHitTestUtils.method05609(var1, var3, this.method09576(), this.method09560(), this.method09568(), field09525)
         && !this.field09502.method02799(var1, var3);
   }

   private void method04255(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      this.field09508.clear();
      switch (this.field09509) {
         case CLIENT:
            this.method04216(var1, var2, var3, var4);
            break;
         case SITE:
            this.method04250(var1, var2, var3, var4);
            break;
         case REQUESTS:
            this.method04209(var1, var2, var3, var4);
            break;
         case SETTINGS:
            this.method04224(var1, var2, var3, var4);
      }

      if (this.field09508.isEmpty()) {
         String var5 = switch (this.field09509) {
            case CLIENT -> field09558;
            case SITE -> field09559;
            case REQUESTS -> field09560;
            case SETTINGS -> "";
         };
         this.field09508
            .add(
               () -> this.field09497
                  .method09480(
                     var1, var5, this.method09576() + field09651 + 2.0F, this.field09512 + field09652, GuiThemeStyle.method01445(var4), field09653
                  )
            );
      }
   }

   private static List<FriendsWindow.Nested128> method04256() {
      ArrayList var0 = new ArrayList();

      for (SocialS2CPacket.Nested57 var2 : OfflineAccountUtils.field07854.method03532()) {
         if (var2 != null) {
            var0.add(new FriendsWindow.Nested128(true, var2.username(), var2.online()));
         }
      }

      for (SocialS2CPacket.Nested57 var4 : OfflineAccountUtils.field07854.method03529()) {
         if (var4 != null) {
            var0.add(new FriendsWindow.Nested128(false, var4.username(), var4.online()));
         }
      }

      var0.sort(
         Comparator.<FriendsWindow.Nested128, Boolean>comparing(var0x -> !var0x.incoming())
            .thenComparing(var0x -> !var0x.online())
            .thenComparing(var0x -> var0x.username().toLowerCase(Locale.ROOT))
      );
      return var0;
   }

   private void method04258() {
      HashSet var1 = new HashSet();
      Minecraft var2 = Minecraft.getInstance();
      if (var2.player != null && var2.player.connection != null) {
         for (PlayerInfo var4 : var2.player.connection.getOnlinePlayers()) {
            String var5 = var4.getProfile().name();
            if (var5 != null) {
               var1.add(var5.toLowerCase(Locale.ROOT));
            }
         }
      }

      this.field09510 = var1;
      HashSet var7 = new HashSet();
      GlobalWebSocketClient var8 = MiranWare.getInstance().getClient();
      if (var8 != null) {
         for (SocialS2CPacket.Nested57 var6 : var8.getManager().method01799()) {
            if (var6 != null && var6.online() && var6.username() != null) {
               var7.add(var6.username().toLowerCase(Locale.ROOT));
            }
         }
      }

      this.field09511 = var7;
   }

   private static <K> float method04259(Map<K, SmoothAnimation> var0, K var1, boolean var2) {
      SmoothAnimation var3 = var0.computeIfAbsent(var1, var0x -> new SmoothAnimation());
      var3.method06162();
      var3.method06158(var2 ? 1.0 : 0.0, field09631, Easings.field19400);
      return var3.method06173();
   }

   @Override
   public void method00611(int var1, int var2, int var3) {
      if (this.field09507.method06726()) {
         this.field09507.method06733(var1);
      }
   }

   private static String method04264() {
      ServerData var0 = Minecraft.getInstance().getCurrentServer();
      return var0 != null && var0.ip != null ? var0.ip : "";
   }

   // $VF: Compiled from s
   private enum Nested127 {
      CLIENT,
      SITE,
      REQUESTS,
      SETTINGS;
   }

   // $VF: Compiled from s
   private record Nested128(boolean incoming, String username, boolean online) {
   }
}
