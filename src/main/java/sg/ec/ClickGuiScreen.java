// Original binary: sg/ec/p5yfzm4nlOUDZs1o
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.resources.Identifier;
import net.minecraft.world.phys.Vec2;
import ru.dreamix.protection.api.impl.profile.ProfileAPI;

// $VF: Compiled from s
public class ClickGuiScreen extends ClientScreen {
   private static final float field22407 = 0.25F;
   private static final float field22408 = 0;
   private static final List<ModuleCategory> field22409 = List.of(ModuleCategory.AutoBuy, ModuleCategory.Friends, ModuleCategory.Bots);
   private static final float field22410 = 0;
   private static final float field22411 = 0;
   private static final float field22412 = 0;
   private ModuleCategory field22413 = ModuleCategory.Combat;
   private ModuleCategory field22414 = this.field22413;
   private final List<CategoryComponent> field22415 = new ArrayList<>();
   private final List<CategoryTab> field22416 = new ArrayList<>();
   private final List<ModuleCategoryColumn> field22417 = new ArrayList<>();
   private final List<ThemeTabComponent> field22418 = new ArrayList<>();
   private final ThemeTabBar field22419;
   private final ModuleContextMenu field22420 = new ModuleContextMenu();
   private final ElapsedTimer field22421 = new ElapsedTimer();
   private final ModuleSearchComponent field22422 = new ModuleSearchComponent(this);
   private final ConfigsPanel field22423 = new ConfigsPanel(this);
   private final SocialOverlayRenderer field22424 = new SocialOverlayRenderer(this);
   private final BotManagerScreen field22425 = new BotManagerScreen();
   private final AutoBuyScreen field22426 = new AutoBuyScreen();
   private final EntityEspSettingsPanel field22427 = new EntityEspSettingsPanel(this);
   private final ScriptsPanel field22428 = new ScriptsPanel(this);
   private final SmoothAnimation field22429 = new SmoothAnimation();
   private GuiOverlay field22430;
   private boolean field22431;
   private boolean field22432;
   private final ScrollController field22433 = new ScrollController();
   private final ScrollController field22434 = new ScrollController();
   private final SmoothAnimation field22435 = new SmoothAnimation();
   private final SmoothAnimation field22436 = new SmoothAnimation();
   private final SmoothAnimation field22437 = new SmoothAnimation();
   private float field22438;
   private float field22439;
   private float field22440;
   private float field22441;
   private final float field22442;
   private final float field22443;
   private float field22444;
   private float field22445;
   private boolean field22446;
   private boolean field22447;
   private float field22448;
   private float field22449;
   private float field22450;
   private float field22451;
   private float field22452;
   private float field22453;
   private float field22454;
   private boolean field22455;
   private boolean field22456;
   private float field22457;
   private float field22458;
   private float field22459;
   private float field22460;
   private float field22461;
   private float field22462;
   private float field22463;
   private float field22464;
   private float field22465;
   private float field22466;
   private float field22467;
   private float field22468;
   private float field22469;
   private float field22470;
   private float field22471;
   private float field22472;
   private float field22473;
   private float field22474;
   private float field22475;
   private float field22476;
   private float field22477;
   private float field22478;
   private float field22479;
   private float field22480;
   private final DraggableElement field22481;
   private final SmoothAnimation field22482;
   private final SmoothAnimation field22483;
   private final NumberSetting<Integer> field22484;
   private final List<Setting<?>> field22485;
   private final SettingsContainer field22486;
   private float field22487;
   private String field22488;
   private List<ModuleCategoryColumn> field22489;
   private float field22490;
   private static final float field22491 = 362.5F;
   private static final float field22492 = 215.5F;
   private static final String field22493 = "menu";
   private static final float field22494 = 362.5F;
   private static final float field22495 = 215.5F;
   private static final String field22496 = "Размер интерфейса";
   private static final float field22497 = 0.5F;
   private static final float field22498 = 0.5F;
   private static final float field22499 = 100.0F;
   private static final float field22500 = 181.25F;
   private static final float field22501 = 107.75F;
   private static final float field22502 = 8.0F;
   private static final float field22503 = 0.825F;
   private static final float field22504 = 181.25F;
   private static final float field22505 = 107.75F;
   private static final float field22506 = 362.5F;
   private static final float field22507 = 215.5F;
   private static final float field22508 = 35.0F;
   private static final float field22509 = 362.5F;
   private static final float field22510 = 215.5F;
   private static final float field22511 = 362.5F;
   private static final float field22512 = 215.5F;
   private static final float field22513 = 15.0F;
   private static final float field22514 = 0.6F;
   private static final float field22515 = 83.5F;
   private static final float field22516 = 25.142857F;
   private static final float field22517 = 362.5F;
   private static final float field22518 = 215.5F;
   private static final float field22519 = 0.05F;
   private static final float field22520 = 5.0F;
   private static final float field22521 = 1.5F;
   private static final float field22522 = 0.75F;
   private static final float field22523 = 212.5F;
   private static final float field22524 = 0.75F;
   private static final float field22525 = 362.5F;
   private static final float field22526 = 0.75F;
   private static final float field22527 = 1.5F;
   private static final float field22528 = 70.0F;
   private static final float field22529 = 14.5F;
   private static final float field22530 = 5.0F;
   private static final float field22531 = 0.75F;
   private static final float field22532 = 30.0F;
   private static final float field22533 = 3.0F;
   private static final float field22534 = 12.5F;
   private static final float field22535 = 0.35F;
   private static final float field22536 = 30.0F;
   private static final float field22537 = 25.0F;
   private static final String field22538 = "N";
   private static final String field22539 = "N";
   private static final float field22540 = 7.5F;
   private static final float field22541 = 55.0F;
   private static final float field22542 = 55.0F;
   private static final float field22543 = 0.001F;
   private static final float field22544 = 0.001F;
   private static final float field22545 = 0.001F;
   private static final float field22546 = 55.0F;
   private static final float field22547 = 0.35F;
   private static final float field22548 = 50.5F;
   private static final float field22549 = 215.5F;
   private static final float field22550 = 5.0F;
   private static final float field22551 = 9.0F;
   private static final float field22552 = 18.0F;
   private static final float field22553 = 17.0F;
   private static final float field22554 = 2.75F;
   private static final double field22555 = 0.15F;
   private static final float field22556 = 2.5F;
   private static final float field22557 = 3.0F;
   private static final float field22558 = 3.0F;
   private static final float field22559 = 12.0F;
   private static final float field22560 = 1.0E-4F;
   private static final float field22561 = 0.55F;
   private static final float field22562 = 0.2F;
   private static final double field22563 = 0.15F;
   private static final float field22564 = 0.1F;
   private static final float field22565 = 0.08F;
   private static final float field22566 = 0.3F;
   private static final float field22567 = 0.45F;
   private static final float field22568 = 1.5F;
   private static final float field22569 = 0.5F;
   private static final float field22570 = 215.5F;
   private static final float field22571 = 16.0F;
   private static final float field22572 = 4.5F;
   private static final float field22573 = 6.0F;
   private static final float field22574 = 4.0F;
   private static final float field22575 = 362.5F;
   private static final float field22576 = 10.0F;
   private static final float field22577 = 6.0F;
   private static final float field22578 = 3.0F;
   private static final String field22579 = "WaterMark1488";
   private static final float field22580 = 7.5F;
   private static final float field22581 = 15.0F;
   private static final float field22582 = 15.0F;
   private static final float field22583 = 15.0F;
   private static final String field22584 = "menu.guiscale";
   private static final double field22585 = 0.15F;
   private static final String field22586 = "5";
   private static final double field22587 = 0.15F;
   private static final float field22588 = 15.0F;
   private static final double field22589 = 0.15F;
   private static final float field22590 = 15.0F;
   private static final String field22591 = "scripts.console";
   private static final String field22592 = "scripts.console";
   private static final float field22593 = 181.25F;
   private static final float field22594 = 107.75F;
   private static final float field22595 = 362.5F;
   private static final float field22596 = 5.0F;
   private static final float field22597 = 5.0F;
   private static final float field22598 = 5.0F;
   private static final String field22599 = "textures/entity/player/slim/steve.png";
   private static final String field22600 = "MCP";
   private static final String field22601 = "menu.mcp";
   private static final float field22602 = 150.0F;
   private static final String field22603 = "menu.theme";
   private static final float field22604 = 5.0F;
   private static final float field22605 = 125.0F;
   private static final String field22606 = "menu.friends";
   private static final float field22607 = 190.0F;
   private static final String field22608 = "modules.bindlist";
   private static final float field22609 = 145.0F;
   private static final float field22610 = 181.25F;
   private static final float field22611 = 181.25F;
   private static final float field22612 = 181.25F;
   private static final float field22613 = 107.75F;
   private static final float field22614 = 107.75F;
   private static final float field22615 = 5.0F;
   private static final float field22616 = 5.0F;
   private static final String field22617 = "menu.guiscale";
   private static final String field22618 = "Настройки";
   private static final String field22619 = "menu.guiscale";
   private static final float field22620 = 5.0F;
   private static final float field22621 = 362.5F;
   private static final float field22622 = 215.5F;
   private static final float field22623 = 5.0F;
   private static final float field22624 = 362.5F;
   private static final float field22625 = 215.5F;
   private static final float field22626 = 362.5F;
   private static final float field22627 = 215.5F;
   private static final double field22628 = 0.25;
   private static final double field22629 = 0.25;
   private static final double field22630 = 0.25;
   private static final float field22631 = 120.57143F;
   private static final float field22632 = 8.5F;
   private static final float field22633 = 362.5F;
   private static final float field22634 = 6.0F;
   private static final float field22635 = 0.001F;
   private static final float field22636 = 6.0F;
   private static final float field22637 = 17.0F;
   private static final float field22638 = 6.0F;
   private static final float field22639 = 6.0F;
   private static final float field22640 = 40.0F;
   private static final float field22641 = 0.001F;
   private static final float field22642 = 17.0F;
   private static final float field22643 = 40.0F;
   private static final float field22644 = 17.0F;
   private static final float field22645 = 6.0F;
   private static final float field22646 = 6.0F;
   private static final float field22647 = 0.001F;
   private static final float field22648 = 6.0F;
   private static final float field22649 = 362.5F;
   private static final double field22650 = 0.15F;
   private static final float field22651 = 3.5F;
   private static final float field22652 = 3.0F;
   private static final float field22653 = 5.0F;
   private static final float field22654 = 13.0F;
   private static final float field22655 = 16.0F;
   private static final float field22656 = 1.0E-4F;
   private static final float field22657 = 0.55F;
   private static final float field22658 = 0.2F;
   private static final double field22659 = 0.15F;
   private static final float field22660 = 0.12F;
   private static final float field22661 = 0.08F;
   private static final float field22662 = 0.35F;
   private static final float field22663 = 0.45F;
   private static final float field22664 = 0.5F;
   private static final float field22665 = 0.5F;
   private static final float field22666 = 362.5F;
   private static final float field22667 = 215.5F;

   public float method09911() {
      Objects.requireNonNull(this);
      return field22666;
   }

   private boolean method09912(double var1, double var3) {
      return !this.field22447 ? false : GuiHitTestUtils.method05609(var1, var3, this.field22449, this.field22450, this.field22451, this.field22452);
   }

   private void method09913(GuiGraphicsExtractor var1, int var2, int var3) {
      this.field22456 = this.field22466 > this.field22465 + 1.0F;
      this.field22436.method06162();
      if (!this.field22456) {
         this.field22455 = false;
         this.field22436.method06156(0.0, field22555, true);
      } else {
         this.field22460 = field22556;
         this.field22458 = this.field22444 + this.field22440 - this.field22460 - field22557;
         this.field22459 = this.field22464;
         this.field22461 = this.field22465 - field22558;
         float var4 = GuiHitTestUtils.method05615(0.0F, 1.0F, this.field22465 / Math.max(this.field22465, this.field22466));
         this.field22463 = GuiHitTestUtils.method05615(field22559, this.field22461, this.field22461 * var4);
         float var5 = Math.max(field22560, this.field22466 - this.field22465);
         float var6 = GuiHitTestUtils.method05621(-this.field22434.method01136() / var5);
         this.field22462 = this.field22459 + Math.max(0.0F, this.field22461 - this.field22463) * var6;
         boolean var7 = GuiHitTestUtils.method05624(var2, var3, this.field22458, this.field22462, this.field22460, this.field22463);
         boolean var8 = GuiHitTestUtils.method05624(var2, var3, this.field22458, this.field22459, this.field22460, this.field22461);
         this.field22436.method06156(!var7 && !this.field22455 ? (var8 ? field22561 : field22562) : 1.0, field22563, true);
         float var9 = this.field22436.method06173();
         int var10 = ColorUtils.method04611(
            ThemeManager.INSTANCE.method09611().field22117.method11676(), (field22564 + field22565 * var9) * this.field22490
         );
         int var11 = ColorUtils.method04611(
            ThemeManager.INSTANCE.method09611().field22124.method11676(), (field22566 + field22567 * var9) * this.field22490
         );
         float var12 = GuiSize.method04763(field22568).method04764(field22569).method04761();
         RoundedRectRenderer.method01272(var1, this.field22458, this.field22459, this.field22460, this.field22461, var12, 1.0F, var10);
         RoundedRectRenderer.method01272(var1, this.field22458, this.field22462, this.field22460, this.field22463, var12, 1.0F, var11);
      }
   }

   public float method09914() {
      return this.field22474;
   }

   public List<ThemeTabComponent> method09915() {
      return this.field22418;
   }

   public SmoothAnimation method09916() {
      return this.field22482;
   }

   public SocialOverlayRenderer method09917() {
      return this.field22424;
   }

   @Override
   public boolean method01476(char var1, int var2) {
      this.field22420.method09662(var1, var2);
      if (this.field22420.method09665()) {
         return true;
      }

      if (this.field22413 == ModuleCategory.Configs && this.field22423.method02376()) {
         this.field22423.method02332(var1, var2);
         return true;
      }

      if (TextAreaSettingComponent.method08859()) {
         ClickGuiScreen.Nested279 var6 = this.method09919();

         for (ModuleCategoryColumn var5 : var6.list()) {
            var5.method03946(var1, var2);
         }

         return true;
      } else {
         this.field22422.method07530(var1);
         if (this.field22413 == ModuleCategory.Themes) {
            for (ThemeTabComponent var4 : this.field22418) {
               var4.method03946(var1, var2);
            }
         }

         return true;
      }
   }

   private float method09918(
      GuiGraphicsExtractor var1,
      int var2,
      int var3,
      List<ModuleCategoryColumn> var4,
      boolean var5,
      String var6,
      ModuleCategory var7,
      float var8,
      float var9,
      float var10,
      float var11,
      float var12,
      float var13
   ) {
      float var14 = field22631;
      float var15 = field22632;
      if (var7 == ModuleCategory.Configs) {
         this.field22423.method02346(var1, var2, var3, var8);
         return 0.0F;
      }

      if (var7 == ModuleCategory.Scripts) {
         this.field22428.method00811(var1, var2, var3, var8);
         return 0.0F;
      }

      if (var7 == ModuleCategory.Themes) {
         float var30 = 0.0F;
         float var31 = 0.0F;

         for (ThemeTabComponent var33 : this.field22418) {
            if (var30 > var33.method09784() + field22637) {
               var30 = 0.0F;
               var31 += var33.method09785() + field22638;
            }

            var33.method09789(this.field22444 + this.field22440 + var15 + var30);
            var33.method09788(this.field22445 + this.field22441 + field22639 + var31 + var9);
            var33.method09781(var14);
            var33.method09786(field22640);
            var33.method09783(1.0F);
            if (var8 > field22641
               && this.method09949(var33.method09780(), var33.method09782(), var33.method09784(), var33.method09785(), var10, var11, var12, var13)) {
               var33.method00042(var1, var2, var3, var8);
            }

            var30 += var33.method09784() + field22642;
         }

         this.field22419.method09781(var14);
         this.field22419.method09786(field22643);
         if (var30 > this.field22419.method09784() + field22644) {
            var30 = 0.0F;
            var31 += this.field22419.method09785() + field22645;
         }

         this.field22419.method09789(this.field22444 + this.field22440 + var15 + var30);
         this.field22419.method09788(this.field22445 + this.field22441 + field22646 + var31 + var9);
         this.field22419.method09783(1.0F);
         if (var8 > field22647
            && this.method09949(
               this.field22419.method09780(),
               this.field22419.method09782(),
               this.field22419.method09784(),
               this.field22419.method09785(),
               var10,
               var11,
               var12,
               var13
            )) {
            this.field22419.method00042(var1, var2, var3, var8);
         }

         return var31 + this.field22419.method09785() + field22648;
      } else {
         float var16 = field22633 - this.field22440 - var15;
         int var17 = Math.max(1, (int)Math.floor(var16 / (var14 + var15)));
         ArrayList var18 = new ArrayList(var17);
         ArrayList var19 = new ArrayList(var17);

         for (int var20 = 0; var20 < var17; var20++) {
            var18.add(0.0F);
            var19.add(this.field22444 + this.field22440 + var15 + var20 * (var14 + var15));
         }

         float var34 = 0.0F;
         ArrayList var21 = new ArrayList();

         for (ModuleCategoryColumn var23 : var4) {
            if (var5 || var23.method03963() == var7) {
               int var24 = 0;
               float var25 = (Float)var18.get(0);

               for (int var26 = 1; var26 < var18.size(); var26++) {
                  if ((Float)var18.get(var26) < var25) {
                     var25 = (Float)var18.get(var26);
                     var24 = var26;
                  }
               }

               float var37 = (Float)var19.get(var24);
               float var27 = this.field22445 + this.field22441 + field22634 + var25 + var9;
               var23.method09789(var37);
               var23.method09788(var27);
               var23.method09781(var14);
               float var28 = var23.method03962(var6);
               var23.method09786(var28);
               if (var8 > field22635 && this.method09949(var37, var27, var14, var28, var10, var11, var12, var13)) {
                  var23.method03948(var1, var8);
                  var21.add(var23);
               }

               float var29 = var28 + field22636;
               var18.set(var24, var25 + var29);
               var34 = Math.max(var34, var25 + var29);
            }
         }

         GuiRenderBatch.method05183();

         for (ModuleCategoryColumn var36 : (Iterable<ModuleCategoryColumn>) (Iterable) var21) {
            var36.method03959(var1, var2, var3, var8);
         }

         return var34;
      }
   }

   private ClickGuiScreen.Nested279 method09919() {
      String var1 = this.method09960();
      return new ClickGuiScreen.Nested279(var1, this.method09920(var1));
   }

   private List<ModuleCategoryColumn> method09920(String var1) {
      if (var1.isEmpty()) {
         return this.field22417;
      }

      if (!var1.equals(this.field22488)) {
         this.field22488 = var1;
         this.field22489 = this.field22417.stream().filter(var1x -> var1x.method03952(var1)).toList();
      }

      return this.field22489;
   }

   private void method09921(GuiGraphicsExtractor var1, int var2, int var3) {
      this.field22440 = field22515;
      this.field22441 = field22516;
      this.field22467 = this.field22444 + this.field22440;
      this.field22468 = this.field22445 + this.field22441 + 1.0F;
      this.field22469 = field22517 - this.field22440;
      this.field22470 = field22518 - this.field22441 - 2.0F;
      float var4 = field22519 * this.field22490;
      int var5 = ColorUtils.method04605(ThemeManager.INSTANCE.method09611().field22118.method11676(), var4);
      this.field22433.method01152(true);
      this.field22433.method01145();
      this.field22433.method01134(this.field22439, this.method09958() - this.field22441 - field22520);
      if (this.field22446) {
         this.method09957(var3);
      }

      RoundedRectRenderer.method01272(var1, this.field22444 + this.field22440, this.field22445 + field22521, field22522, field22523, 0.0F, 0.0F, var5);
      RoundedRectRenderer.method01272(
         var1,
         this.field22444 + this.field22440 + field22524,
         this.field22445 + this.field22441,
         field22525 - this.field22440 - field22526 - field22527,
         1.0F,
         0.0F,
         0.0F,
         var5
      );
      this.field22422.method09781(field22528);
      this.field22422.method09786(field22529);
      this.field22422.method09789(this.field22444 + this.field22440 + field22530);
      this.field22422.method09788(this.field22445 + this.field22441 / 2.0F - this.field22422.method09785() / 2.0F);
      this.field22422.method09783(field22531 * this.field22490);
      this.field22422.method00042(var1, var2, var3, this.field22490);
      this.method09937(var1, var2, var3);
      ClickGuiScreen.Nested279 var6 = this.method09919();
      boolean var7 = var6.active();
      float var8 = field22532;
      float var9 = this.field22444 + this.field22440 / 2.0F - var8 / 2.0F - field22533;
      float var10 = this.field22445 + field22534;
      float var11 = this.field22490 * field22535;
      RoundedRectRenderer.method01275(
         var1,
         var9 - var8 / 2.0F,
         var10 - var8 / 2.0F,
         var8 * 2.0F,
         var8 * 2.0F,
         field22536,
         field22537,
         new CornerColors(
            ColorUtils.Nested138.method04635(0, var11),
            ColorUtils.Nested138.method04635(90, var11),
            ColorUtils.Nested138.method04635(180, var11),
            ColorUtils.Nested138.method04635(270, var11)
         )
      );
      Fonts.field00107
         .method09482(
            var1,
            field22538,
            var9,
            var10,
            new CornerColors(
               ColorUtils.Nested138.method04635(0, this.field22490),
               ColorUtils.Nested138.method04635(90, this.field22490),
               ColorUtils.Nested138.method04635(180, this.field22490),
               ColorUtils.Nested138.method04635(270, this.field22490)
            ),
            var8,
            0.0F
         );
      this.field22477 = var9;
      this.field22478 = var10;
      this.field22479 = Fonts.field00107.method09486(field22539, var8);
      this.field22480 = Fonts.field00107.method09485(var8);
      this.field22481.method02673(this.field22477, this.field22478, this.field22479, this.field22480);
      FontRenderer var12 = Fonts.field00110;
      float var13 = field22540;
      String var14 = ProfileAPI.get().getModel().getName();
      this.method09925(var1, var12, var14, var13, var2, var3);
      var var15 = var6.list();
      this.field22437.method06162();
      if (!this.field22437.method06152()) {
         this.field22414 = this.field22413;
      }

      boolean var16 = this.field22437.method06152() && this.field22414 != this.field22413 && !var7;
      float var17 = var16 ? GuiHitTestUtils.method05621(this.field22437.method06173()) : 1.0F;
      this.field22429.method06162();
      float var18 = GuiHitTestUtils.method05621(this.field22429.method06173());
      float var19 = 1.0F - var18;
      int var20 = Integer.signum(this.field22413.ordinal() - this.field22414.ordinal());
      if (var20 == 0) {
         var20 = 1;
      }

      float var21 = var16 ? -var20 * field22541 * var17 : 0.0F;
      float var22 = var16 ? var20 * field22542 * (1.0F - var17) : 0.0F;
      float var23 = 0.0F;
      float var24 = this.field22490 * var19;
      if (var16) {
         var23 = this.field22490 * (1.0F - var17) * var19;
         var24 = this.field22490 * var17 * var19;
      }

      float var25 = this.field22467;
      float var26 = this.field22468;
      float var27 = this.field22469;
      float var28 = this.field22470;
      var1.enableScissor((int)var25, (int)var26, (int)(var25 + var27), (int)(var26 + var28));
      if (var19 > field22543) {
         if (var16 && var23 > field22544) {
            var1.pose().pushMatrix();
            var1.pose().translate(0.0F, var21);
            this.method09918(var1, var2, var3, var15, var7, var6.query(), this.field22414, var23, this.field22438, var25, var26, var27, var28);
            var1.pose().popMatrix();
         }

         var1.pose().pushMatrix();
         var1.pose().translate(0.0F, var22);
         this.field22439 = this.method09918(
            var1, var2, var3, var15, var7, var6.query(), this.field22413, var24, this.field22433.method01136(), var25, var26, var27, var28
         );
         var1.pose().popMatrix();
      } else {
         this.field22439 = 0.0F;
      }

      if (var18 > field22545 && this.field22430 != null) {
         var1.pose().pushMatrix();
         var1.pose().translate(0.0F, field22546 * (1.0F - var18) * field22547);
         this.field22430.method02847(var1, var2, var3, this.field22490 * var18);
         var1.pose().popMatrix();
      }

      var1.disableScissor();
      this.method10029(var1, var2, var3);
   }

   public float method09922() {
      return this.field22462;
   }

   public float method09923() {
      return this.field22440;
   }

   private boolean method09924(ModuleCategoryColumn var1, boolean var2) {
      return var2 || var1.method03963() == this.field22413;
   }

   private void method09925(GuiGraphicsExtractor var1, FontRenderer var2, String var3, float var4, float var5, float var6) {
      float var7 = field22571;
      float var8 = field22572;
      float var9 = var7 - field22573;
      float var10 = field22574;
      float var11 = var8 + var9 + var10 + var2.method09486(var3, var4) + var8;
      float var12 = this.field22444 + field22575 - field22576 - var11;
      float var13 = this.field22445 + this.field22441 / 2.0F - var7 / 2.0F;
      this.method10000(var1, var12 - field22577, var5, var6);
      RoundedRectRenderer.method01272(var1, var12, var13, var11, var7, field22578, 1.0F, ClickGuiDecorationRenderer.method08407(this.field22490));
      float var14 = var12 + var8;
      float var15 = var13 + var7 / 2.0F - var9 / 2.0F;
      int var16 = ColorUtils.method04611(-1, this.field22490);
      Identifier var17 = this.method09971();
      CornerRadii var18 = new CornerRadii(var9 / 2.0F);
      GuiTextureRenderer.method10260(var1, var17, false, var14, var15, var9, var9, var18, 1.0F, new CornerColors(var16));
      GuiTextureRenderer.method10260(var1, var17, true, var14, var15, var9, var9, var18, 1.0F, new CornerColors(var16));
      var2.method09480(
         var1,
         FontFallbackManager.method07178(field22579, var3, ColorUtils.Nested138.method04636(), ColorUtils.Nested138.method04637(), 30, 5),
         var14 + var9 + var10,
         var13 + var7 / 2.0F - var2.method09485(var4) / 2.0F,
         var16,
         var4
      );
   }

   public float method09926() {
      return this.field22487;
   }

   public float method09927() {
      return this.field22463;
   }

   private void method09928(int var1, int var2) {
      this.field22481.method02686(0);
      this.field22481.method02661(this.method09926());
      this.field22481.method02663(field22497);
      this.field22481.method02689(field22498);
      this.field22444 = this.field22481.method02685();
      this.field22445 = this.field22481.method02669();
   }

   private void method09929(float var1, float var2) {
      if (this.field22447) {
         if (GuiHitTestUtils.method05625(var1, var2, this.field22449, this.field22453, this.field22451, this.field22454)) {
            this.field22448 = var2 - this.field22453;
         } else {
            this.field22448 = this.field22454 / 2.0F;
            this.method09957(var2);
         }

         this.field22446 = true;
      }
   }

   public float method09930() {
      return this.field22478;
   }

   @Override
   protected void method01472(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      this.field22490 = this.method01470();
      float var5 = field22502;
      float var6 = field22503 * this.field22490;
      Vec2 var7 = GuiScaleUtils.method06746(var2, var3);
      this.field22481.method02661(this.method09926());
      this.field22481.method02690(var2, var3, mc.getWindow());
      this.field22444 = this.field22481.method02685();
      this.field22445 = this.field22481.method02669();
      Vec2 var8 = this.method09954(var2, var3);
      int var9 = (int)var8.x;
      int var10 = (int)var8.y;
      int var11 = (int)var7.x;
      int var12 = (int)var7.y;
      float var13 = this.method09926();
      float var14 = this.field22444 + field22504;
      float var15 = this.field22445 + field22505;
      this.method10007();
      var1.pose().pushMatrix();
      var1.pose().translate(var14, var15);
      var1.pose().scale(var13, var13);
      var1.pose().translate(-var14, -var15);
      this.method01467(var1, var14, this.field22445);
      int var16 = ColorUtils.method04605(
         ThemeManager.INSTANCE.method09611().field22119.method11676(), var6 * ThemeManager.INSTANCE.method09611().field22119.method11680()
      );
      GuiClipStack.method00341(var1, this.field22444, this.field22445, field22506, field22507, var5, 1.0F, field22508, this.field22490);
      RoundedRectRenderer.method01272(var1, this.field22444, this.field22445, field22509, field22510, var5, 1.0F, var16);
      GuiShadowRenderer.method10984(
         var1, this.field22444, this.field22445, field22511, field22512, var5, 1.0F, field22513, ColorUtils.method04611(var16, field22514)
      );
      this.method09921(var1, var9, var10);
      GuiRenderBatch.method05183();
      this.field22420.method09649(var1, var9, var10, this.field22490, false, true);
      this.field22424.method10287(var1, var9, var10, this.field22490);
      var1.pose().popMatrix();
      var1.pose().popMatrix();
      GuiRenderBatch.method05183();
      this.field22420.method09649(var1, var11, var12, this.field22490, true, true);
   }

   public float method09931() {
      return this.field22466;
   }

   private boolean method09932() {
      return this.field22420.method09669(field22591) != null;
   }

   public float method09933() {
      return this.field22480;
   }

   private void method09934(double var1) {
      float var3 = Math.max(1.0F, this.field22461 - this.field22463);
      float var4 = GuiHitTestUtils.method05615(this.field22459, this.field22459 + var3, (float)var1 - this.field22457);
      float var5 = GuiHitTestUtils.method05621((var4 - this.field22459) / var3);
      float var6 = -Math.max(0.0F, this.field22466 - this.field22465) * var5;
      this.field22434.method01140(var6);
      this.field22434.method01151(var6);
      this.field22434.method01137().method06157(var6);
   }

   public float method09935() {
      return this.field22464;
   }

   public float method09936() {
      return this.field22471;
   }

   private void method09937(GuiGraphicsExtractor var1, int var2, int var3) {
      this.field22464 = this.field22445 + field22548;
      this.field22465 = field22549 - (this.field22464 - this.field22445) - field22550;
      this.field22434.method01152(true);
      this.field22434.method01145();
      this.field22434.method01134(this.field22466, this.field22465);
      if (this.field22455) {
         this.method09934(var3);
      }

      var1.enableScissor((int)this.field22444, (int)this.field22464, (int)(this.field22444 + this.field22440), (int)(this.field22464 + this.field22465));
      float var4 = this.field22434.method01136();

      for (CategoryComponent var6 : this.field22415) {
         var6.method09789(this.field22444 + field22551);
         var6.method09788(this.field22464 + var4);
         var6.method09781(this.field22440 - field22552);
         var6.method09786(field22553);
         var6.method00042(var1, var2, var3, this.field22490);
         var4 += var6.method09785() + field22554;
      }

      this.field22466 = var4 - this.field22434.method01136();
      var1.disableScissor();
      this.method09913(var1, var2, var3);
   }

   public ThemeTabBar method09938() {
      return this.field22419;
   }

   public ModuleCategory method09939() {
      return this.field22413;
   }

   public boolean method09940() {
      return this.field22432;
   }

   public SettingsContainer method09941() {
      return this.field22486;
   }

   public float method09942() {
      return this.field22473;
   }

   public NumberSetting<Integer> method09943() {
      return this.field22484;
   }

   public float method09945() {
      return this.field22452;
   }

   private List<Setting<?>> method09946() {
      ArrayList var1 = new ArrayList();
      var1.add(this.field22484);
      var1.add(new ActionSetting(field22600).method03017(this::method09990));
      return var1;
   }

   public float method09947() {
      return this.field22439;
   }

   public float method09948() {
      return this.field22465;
   }

   private boolean method09949(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = var1 + var3;
      float var10 = var2 + var4;
      float var11 = var5 + var7;
      float var12 = var6 + var8;
      return var9 > var5 && var1 < var11 && var10 > var6 && var2 < var12;
   }

   private void method09950(FloatingWindow var1, String var2, float var3) {
      if (this.field22420.method09669(var2) == null) {
         float var4 = this.method09926();
         float var5 = this.field22444 + field22610;
         float var6 = var5 - field22611 * var4;
         float var7 = var5 + field22612 * var4;
         float var8 = this.field22445 + field22613 - field22614 * var4;
         float var9 = var7 + field22615;
         if (var9 + var3 > GuiScaleUtils.method06753()) {
            var9 = var6 - field22616 - var3;
         }

         this.field22420.method09652(var1, var9, var8);
      }
   }

   public boolean method09951() {
      return this.field22447;
   }

   public SmoothAnimation method09952() {
      return this.field22436;
   }

   public float method09953() {
      return this.field22441;
   }

   private Vec2 method09954(double var1, double var3) {
      Vec2 var5 = GuiScaleUtils.method06746(var1, var3);
      float var6 = this.method09926();
      if (var6 == 1.0F) {
         return var5;
      }

      float var7 = this.field22444 + field22500;
      float var8 = this.field22445 + field22501;
      return new Vec2(var7 + (var5.x - var7) / var6, var8 + (var5.y - var8) / var6);
   }

   public ModuleCategory method09955() {
      return this.field22414;
   }

   public ScriptsPanel method09956() {
      return this.field22428;
   }

   private void method09957(double var1) {
      if (this.field22447) {
         float var3 = Math.max(1.0F, this.field22452 - this.field22454);
         float var4 = GuiHitTestUtils.method05615(this.field22450, this.field22450 + var3, (float)var1 - this.field22448);
         float var5 = GuiHitTestUtils.method05621((var4 - this.field22450) / var3);
         float var6 = Math.max(0.0F, this.field22439 - this.field22470);
         float var7 = -var6 * var5;
         this.field22433.method01140(var7);
         this.field22433.method01151(var7);
         this.field22433.method01137().method06157(var7);
      }
   }

   public float method09958() {
      Objects.requireNonNull(this);
      return field22667;
   }

   public float method09959() {
      return this.field22487;
   }

   public String method09960() {
      return TextRenderUtils.method00672(this.field22422.method07532());
   }

   public void method09961(ModuleCategory var1) {
      this.field22417.removeIf(var1x -> var1x.method03963() == var1);
      this.field22488 = "";
      this.field22489 = List.of();
      this.method10027(var1);
   }

   public SmoothAnimation method09962() {
      return this.field22429;
   }

   public float method09963() {
      return this.field22468;
   }

   public ModuleSearchComponent method09964() {
      return this.field22422;
   }

   public EntityEspSettingsPanel method09965() {
      return this.field22427;
   }

   private void method09966() {
      this.field22487 = this.field22484.method03022().floatValue() / field22499;
      this.field22481.method02661(this.field22487);
   }

   @Override
   protected void method01466() {
      this.method01465(mc.mouseHandler.getScaledXPos(mc.getWindow()), mc.mouseHandler.getScaledYPos(mc.getWindow()), 0);

      for (FloatingWindow var2 : this.field22420.method09655()) {
         if (!var2.method01698()) {
            this.field22420.method09654(var2);
         }
      }

      this.field22422.method07531();
      this.field22432 = true;
      this.field22421.method04694();
   }

   public void method09967(ModuleCategory var1) {
      this.method09993();
      if (this.field22413 != var1) {
         this.field22414 = this.field22413;
         this.field22438 = this.field22433.method01136();
         this.field22433.method01144();
         this.field22432 = true;
         this.field22413 = var1;
         this.field22421.method04694();
         this.field22437.method06157(0.0);
         this.field22437.method06168(1.0, field22630, Easings.field19400, false);
         if (var1 == ModuleCategory.Configs) {
            this.field22423.method02337();
         } else if (var1 == ModuleCategory.Scripts) {
            this.field22428.method00804();
         }
      }
   }

   public void method09968(ScrollableWindow var1) {
      if (this.field22420.method09669(var1.method09562()) == null) {
         float var2 = this.method09926();
         float var3 = this.field22444 + field22593;
         float var4 = this.field22445 + field22594;
         float var5 = var3 + (GuiScaleUtils.method06753() - var3) / var2;
         float var6 = var4 + (GuiScaleUtils.method06754() - var4) / var2;
         float var7 = this.field22444 + field22595 + field22596;
         if (var7 + var1.method09568() > var5) {
            var7 = this.field22444 - field22597 - var1.method09568();
         }

         float var8 = this.field22445;

         for (FloatingWindow var10 : this.field22420.method09655()) {
            boolean var11 = var10.method09576() < var7 + var1.method09568() && var10.method09576() + var10.method09568() > var7;
            if (var10 instanceof ScrollableWindow && var10.method09569() && var11) {
               var8 = Math.max(var8, var10.method09560() + var10.method09574() + field22598);
            }
         }

         if (var8 + var1.method09574() > var6) {
            var8 = this.field22445;
         }

         this.field22420.method09652(var1, var7, var8);
      }
   }

   @Override
   protected void method01474() {
      this.method09928(mc.getWindow().getGuiScaledWidth(), mc.getWindow().getGuiScaledHeight());
   }

   public ScrollController method09969() {
      return this.field22434;
   }

   public GuiOverlay method09970() {
      return this.field22430;
   }

   private Identifier method09971() {
      return mc.player != null ? mc.player.getSkin().body().texturePath() : Identifier.withDefaultNamespace(field22599);
   }

   @Override
   public boolean method01465(double var1, double var3, int var5) {
      Vec2 var6 = this.method09954(var1, var3);
      Vec2 var7 = GuiScaleUtils.method06746(var1, var3);
      double var8 = var6.x;
      double var10 = var6.y;
      double var12 = var7.x;
      double var14 = var7.y;
      this.field22420.method09663(var8, var10, var12, var14, var5);
      this.method09966();
      this.field22422.method02632(var8, var10, var5);
      if (var5 == 0) {
         this.field22446 = false;
         this.field22455 = false;
      }

      this.field22481.method02686(var5);
      this.field22423.method02352(var8, var10, var5);

      for (ThemeTabComponent var17 : this.field22418) {
         var17.method02632(var8, var10, var5);
      }

      if (this.field22431) {
         this.field22430.method02840(var8, var10, var5);
      } else if (!this.field22420.method09661(var8, var10, var12, var14) && this.field22413 != ModuleCategory.Themes) {
         ClickGuiScreen.Nested279 var21 = this.method09919();
         boolean var22 = var21.active();

         for (ModuleCategoryColumn var20 : var21.list()) {
            if (this.method09924(var20, var22)) {
               var20.method02632(var8, var10, var5);
            }
         }
      }

      return true;
   }

   public AutoBuyScreen method09972() {
      return this.field22426;
   }

   public List<ModuleCategoryColumn> method09973() {
      return this.field22489;
   }

   public float method09974() {
      return this.field22476;
   }

   public SmoothAnimation method09975() {
      return this.field22437;
   }

   public float method09976() {
      return this.field22461;
   }

   public BotManagerScreen method09977() {
      return this.field22425;
   }

   public float method09978() {
      return this.field22451;
   }

   public void method09979() {
      FloatingWindow var1 = this.field22420.method09669(field22603);
      if (var1 != null) {
         this.field22420.method09654(var1);
      } else {
         this.field22420.method09652(new ThemeEditorWindow(), field22604, GuiScaleUtils.method06754() / 2.0F - field22605);
      }
   }

   public boolean method09980() {
      return this.field22456;
   }

   public float method09981() {
      return this.field22448;
   }

   private float method09982(GuiGraphicsExtractor var1, float var2, float var3, boolean var4, float var5, float var6) {
      this.field22483.method06162();
      if (!var4) {
         this.field22476 = 0.0F;
         this.field22483.method06156(0.0, field22587, true);
         return var2;
      } else {
         this.field22476 = field22588;
         this.field22474 = var2;
         this.field22475 = var3;
         boolean var7 = GuiHitTestUtils.method05625(var5, var6, this.field22474, this.field22475, this.field22476, this.field22476);
         this.field22483.method06156(!var7 && !this.method09932() ? 0.0 : 1.0, field22589, true);
         ClickGuiDecorationRenderer.method08404(
            var1, this.field22474, this.field22475, ModuleCategory.Scripts.method00307(), this.field22483.method06173(), this.field22490
         );
         ClickGuiDecorationRenderer.method08405(var1, this.field22474, this.field22475, this.field22490);
         return var2 + field22590;
      }
   }

   public ModuleContextMenu method09983() {
      return this.field22420;
   }

   public ClickGuiScreen() {
      this.field22442 = field22491;
      this.field22443 = field22492;
      this.field22481 = new DraggableElement(field22493, field22494, field22495, GuiViewport.field10078);
      this.field22482 = new SmoothAnimation();
      this.field22483 = new SmoothAnimation();
      this.field22484 = new NumberSetting<Integer>(field22496).method10835(50).method10838(150).method10834(1).method03017(100);
      this.field22485 = this.method09946();
      this.field22486 = () -> this.field22485;
      this.field22487 = 1.0F;
      this.field22488 = "";
      this.field22489 = List.of();
      this.field22490 = 1.0F;
      this.field22481.method02677(true);

      for (ModuleCategory var4 : ModuleCategory.values()) {
         if (var4.method00305()) {
            this.field22415.add(new CategoryComponent(this, var4));
            this.method10027(var4);
         }
      }

      for (ThemeSettings var7 : ThemeManager.INSTANCE.method09636()) {
         this.field22418.add(new ThemeTabComponent(var7, this.field22420));
      }

      this.field22419 = new ThemeTabBar(this.field22420, this.field22418);

      for (ModuleCategory var8 : field22409) {
         this.field22416.add(new CategoryTab(this, var8));
      }

      this.field22437.method06155(1.0);
      this.field22437.method06175(1.0);
   }

   public float method09984() {
      return this.field22454;
   }

   public String method09985() {
      return this.field22488;
   }

   public float method09986() {
      return this.field22467;
   }

   public float method09987() {
      return this.field22457;
   }

   public void method09988(ModuleCategory var1) {
      switch (var1) {
         case AutoBuy:
            ClientScreenManager.INSTANCE.method08320(this.field22426);
            break;
         case Bots:
            ClientScreenManager.INSTANCE.method08320(this.field22425);
            break;
         case Friends:
            this.method09950(new FriendsWindow(), field22606, field22607);
            break;
         default:
            this.method09967(var1);
      }
   }

   @Override
   public boolean method01477(double var1, double var3, int var5, boolean var6) {
      Vec2 var7 = this.method09954(var1, var3);
      Vec2 var8 = GuiScaleUtils.method06746(var1, var3);
      double var9 = var7.x;
      double var11 = var7.y;
      double var13 = var8.x;
      double var15 = var8.y;
      boolean var17 = this.field22420.method09666();
      this.field22420.method09658(var9, var11, var13, var15, var5);
      if (var17) {
         return true;
      }

      if (var5 == 0
         && this.field22476 > 0.0F
         && GuiHitTestUtils.method05609(var9, var11, this.field22474, this.field22475, this.field22476, this.field22476)) {
         this.method10019();
         return true;
      }

      if (var5 == 0 && GuiHitTestUtils.method05609(var9, var11, this.field22471, this.field22472, this.field22473, this.field22473)) {
         this.method10035();
         return true;
      }

      if (var5 == 0 && this.field22481.method02674(var13, var15, var9, var11, var5)) {
         return true;
      }

      if (!this.field22420.method09661(var9, var11, var13, var15) && var5 == 0 && this.method09912(var9, var11)) {
         this.method09929((float)var9, (float)var11);
         return true;
      }

      if (!this.field22420.method09661(var9, var11, var13, var15) && var5 == 0 && this.method10017(var9, var11)) {
         this.method10013((float)var11);
         return true;
      }

      if (!this.field22420.method09661(var9, var11, var13, var15)) {
         ClickGuiScreen.Nested279 var18 = this.method09919();
         boolean var19 = var18.active();
         var var20 = var18.list();
         if (this.field22424.method10280(var9, var11, var5)) {
            return true;
         }

         for (CategoryTab var22 : this.field22416) {
            if (var22.method00039(var9, var11, var5)) {
               this.field22422.method07528();
               var20.forEach(ModuleCategoryColumn::method03957);
               return true;
            }
         }

         if (GuiHitTestUtils.method05609(var9, var11, this.field22444, this.field22464, this.field22440, this.field22465)) {
            for (CategoryComponent var26 : this.field22415) {
               if (var26.method09595(var9, var11, var5)) {
                  this.field22422.method07528();
                  var20.forEach(ModuleCategoryColumn::method03957);
               }
            }
         }

         if (this.field22431) {
            this.field22430.method02839(var9, var11, var5);
         } else if (this.field22413 != ModuleCategory.Themes) {
            if (this.field22413 == ModuleCategory.Configs) {
               this.field22423.method02368(var9, var11, var5);
            } else if (this.field22413 == ModuleCategory.Scripts) {
               this.field22428.method00805(var9, var11, var5);
            } else {
               for (ModuleCategoryColumn var28 : var20) {
                  if (GuiHitTestUtils.method05609(
                        var9,
                        var11,
                        this.field22444 + this.field22440,
                        this.field22445 + this.field22441,
                        field22624 - this.field22440,
                        field22625 - this.field22441
                     )
                     && this.method09924(var28, var19)) {
                     var28.method03964(var9, var11, var5);
                  }
               }
            }
         } else {
            for (ThemeTabComponent var27 : this.field22418) {
               var27.method00040(var9, var11, var5);
            }

            this.field22419.method00040(var9, var11, var5);
         }

         this.field22422.method00040(var9, var11, var5);
      }

      return true;
   }

   public SmoothAnimation method09989() {
      return this.field22483;
   }

   public void method09990() {
      this.method09950(new McpSettingsWindow(), field22601, field22602);
   }

   public float method09991() {
      return this.field22490;
   }

   public float method09992() {
      return this.field22445;
   }

   private void method09993() {
      if (this.field22431) {
         this.field22431 = false;
         this.field22429.method06168(0.0, field22629, Easings.field19400, false);
      }
   }

   public List<CategoryTab> method09994() {
      return this.field22416;
   }

   @Override
   public boolean method01463(double var1, double var3, double var5, double var7) {
      Vec2 var9 = this.method09954(var1, var3);
      Vec2 var10 = GuiScaleUtils.method06746(var1, var3);
      double var11 = var10.x;
      double var13 = var10.y;
      var1 = var9.x;
      var3 = var9.y;
      this.field22420.method09650(var1, var3, var11, var13, var7);
      this.method09966();
      if (!this.field22420.method09661(var1, var3, var11, var13)) {
         if (this.method10028(var1, var3)) {
            this.field22434.method01133(var7);
            return true;
         }

         if (this.field22431) {
            this.field22430.method02844(var1, var3, var7);
            return true;
         }

         if (this.field22413 == ModuleCategory.Configs) {
            this.field22423.method02280(var7);
            return true;
         }

         if (this.field22413 == ModuleCategory.Scripts) {
            this.field22428.method00813(var7);
            return true;
         }

         boolean var15 = false;
         if (this.field22413 != ModuleCategory.Themes) {
            ClickGuiScreen.Nested279 var16 = this.method09919();
            boolean var17 = var16.active();

            for (ModuleCategoryColumn var20 : var16.list()) {
               if (GuiHitTestUtils.method05609(
                     var1,
                     var3,
                     this.field22444 + this.field22440,
                     this.field22445 + this.field22441,
                     field22626 - this.field22440,
                     field22627 - this.field22441
                  )
                  && this.method09924(var20, var17)
                  && var20.method03958(var1, var3, var7)) {
                  var15 = true;
                  break;
               }
            }
         }

         if (!var15) {
            this.field22433.method01133(var7);
         }
      }

      return true;
   }

   public float method09995() {
      return this.field22450;
   }

   public float method09996() {
      return this.field22458;
   }

   public float method09997() {
      return this.field22477;
   }

   public float method09998() {
      return this.field22444;
   }

   public float method09999() {
      return this.field22459;
   }

   private void method10000(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      boolean var5 = this.field22413 == ModuleCategory.Scripts;
      float var6 = this.field22445 + this.field22441 / 2.0F - field22580;
      int var7 = this.field22416.size() + (var5 ? 2 : 1);
      float var8 = var2 - var7 * field22581;
      ClickGuiDecorationRenderer.method08406(var1, var8, var6, var7, this.field22490);

      for (CategoryTab var10 : this.field22416) {
         var10.method09789(var8);
         var10.method09788(var6);
         var10.method00042(var1, (int)var3, (int)var4, this.field22490);
         ClickGuiDecorationRenderer.method08405(var1, var8, var6, this.field22490);
         var8 += field22582;
      }

      var8 = this.method09982(var1, var8, var6, var5, var3, var4);
      this.field22473 = field22583;
      this.field22471 = var8;
      this.field22472 = var6;
      boolean var12 = this.field22420.method09669(field22584) != null;
      boolean var13 = GuiHitTestUtils.method05625(var3, var4, this.field22471, this.field22472, this.field22473, this.field22473);
      this.field22482.method06162();
      this.field22482.method06156(!var13 && !var12 ? 0.0 : 1.0, field22585, true);
      ClickGuiDecorationRenderer.method08404(var1, this.field22471, this.field22472, field22586, this.field22482.method06173(), this.field22490);
   }

   public List<ModuleCategoryColumn> method10002() {
      return this.field22417;
   }

   public float method10003() {
      return this.field22460;
   }

   public boolean method10004() {
      return this.field22446;
   }

   public List<Setting<?>> method10005() {
      return this.field22485;
   }

   public ConfigsPanel method10006() {
      return this.field22423;
   }

   private void method10007() {
      int var1 = ThemeManager.INSTANCE.method09636().size();
      if (this.field22418.size() != var1) {
         this.field22418.clear();

         for (ThemeSettings var3 : ThemeManager.INSTANCE.method09636()) {
            this.field22418.add(new ThemeTabComponent(var3, this.field22420));
         }
      }
   }

   @Override
   public boolean method01471() {
      if (!ClientScreenManager.INSTANCE.method08317(this)) {
         return false;
      }

      if (this.field22422.method07529() || this.field22420.method09665()) {
         return true;
      }

      if (this.field22413 == ModuleCategory.Configs && this.field22423.method02376()) {
         return true;
      }

      if (this.field22413 == ModuleCategory.Themes) {
         for (ThemeTabComponent var2 : this.field22418) {
            if (var2.method10830()) {
               return true;
            }
         }
      }

      return false;
   }

   public SmoothAnimation method10008() {
      return this.field22435;
   }

   public List<CategoryComponent> method10009() {
      return this.field22415;
   }

   public ElapsedTimer method10010() {
      return this.field22421;
   }

   public DraggableElement method10011() {
      return this.field22481;
   }

   public void method10012() {
      this.method10020(this.field22427);
   }

   @Override
   public void method01479(int var1, int var2) {
      this.method09928(var1, var2);
   }

   private void method10013(float var1) {
      if (GuiHitTestUtils.method05625(this.field22458 + this.field22460 / 2.0F, var1, this.field22458, this.field22462, this.field22460, this.field22463)) {
         this.field22457 = var1 - this.field22462;
      } else {
         this.field22457 = this.field22463 / 2.0F;
         this.method09934(var1);
      }

      this.field22455 = true;
   }

   public float method10014() {
      return this.field22449;
   }

   public float method10015() {
      return this.field22469;
   }

   public float method10016() {
      return this.field22475;
   }

   private boolean method10017(double var1, double var3) {
      return this.field22456 && GuiHitTestUtils.method05609(var1, var3, this.field22458, this.field22459, this.field22460, this.field22461);
   }

   public float method10018() {
      return this.field22453;
   }

   private void method10019() {
      FloatingWindow var1 = this.field22420.method09669(field22592);
      if (var1 != null) {
         this.field22420.method09654(var1);
      } else {
         this.method09968(new ScriptConsoleWindow());
      }
   }

   private void method10020(GuiOverlay var1) {
      if (!this.field22431 || this.field22430 != var1) {
         this.field22430 = var1;
         this.field22431 = true;
         var1.method02852();
         this.field22429.method06168(1.0, field22628, Easings.field19400, false);
      }
   }

   public ScrollController method10021() {
      return this.field22433;
   }

   public float method10023() {
      return this.field22438;
   }

   public boolean method10024() {
      return this.field22455;
   }

   public float method10025() {
      return this.field22472;
   }

   public float method10026() {
      return this.field22470;
   }

   @Override
   public boolean method01464(int var1, int var2, int var3) {
      this.field22420.method09670(var1, var2, var3);
      if (this.field22420.method09665()) {
         return true;
      }

      if (this.field22413 == ModuleCategory.Configs && this.field22423.method02376()) {
         this.field22423.method02317(var1, var2, var3);
         return true;
      }

      this.field22422.method00250(var1, var2, var3);
      if (this.field22413 == ModuleCategory.Themes) {
         for (ThemeTabComponent var5 : this.field22418) {
            var5.method00250(var1, var2, var3);
         }
      } else if (!this.field22420.method09665()) {
         ClickGuiScreen.Nested279 var9 = this.method09919();
         boolean var10 = var9.active();

         for (ModuleCategoryColumn var8 : var9.list()) {
            if (this.method09924(var8, var10)) {
               var8.method00250(var1, var2, var3);
            }
         }
      }

      return false;
   }

   private void method10027(ModuleCategory var1) {
      if (var1 != ModuleCategory.Scripts) {
         for (ModuleSubCategory var3 : var1.method00306()) {
            this.field22417
               .add(
                  new ModuleCategoryColumn(
                     this,
                     var3,
                     var1,
                     ModuleManager.INSTANCE.method05138().stream().filter(var2 -> var2.method03938() == var1 && var2.method03940() == var3).toList()
                  )
               );
         }
      }
   }

   private boolean method10028(double var1, double var3) {
      return GuiHitTestUtils.method05609(var1, var3, this.field22444, this.field22445, this.field22440, field22570);
   }

   private void method10029(GuiGraphicsExtractor var1, int var2, int var3) {
      this.field22447 = this.field22439 > this.field22470 + 1.0F;
      if (!this.field22447) {
         this.field22446 = false;
         this.field22435.method06162();
         this.field22435.method06156(0.0, field22650, true);
      } else {
         float var4 = GuiHitTestUtils.method05615(0.0F, 1.0F, this.field22470 / Math.max(this.field22470, this.field22439));
         this.field22451 = field22651;
         this.field22449 = this.field22467 + this.field22469 - this.field22451 - field22652;
         this.field22450 = this.field22468 + field22653;
         this.field22452 = this.field22470 - field22654;
         this.field22454 = GuiHitTestUtils.method05615(field22655, this.field22452, this.field22452 * var4);
         float var5 = Math.max(field22656, this.field22439 - this.field22470);
         float var6 = GuiHitTestUtils.method05621(-this.field22433.method01136() / var5);
         float var7 = Math.max(0.0F, this.field22452 - this.field22454);
         this.field22453 = this.field22450 + var7 * var6;
         boolean var8 = GuiHitTestUtils.method05624(var2, var3, this.field22449, this.field22453, this.field22451, this.field22454);
         boolean var9 = GuiHitTestUtils.method05624(var2, var3, this.field22449, this.field22450, this.field22451, this.field22452);
         this.field22435.method06162();
         this.field22435.method06156(!var8 && !this.field22446 ? (var9 ? field22657 : field22658) : 1.0, field22659, true);
         float var10 = (field22660 + field22661 * this.field22435.method06173()) * this.field22490;
         float var11 = (field22662 + field22663 * this.field22435.method06173()) * this.field22490;
         int var12 = ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22117.method11676(), var10);
         int var13 = ColorUtils.method04611(ThemeManager.INSTANCE.method09611().field22124.method11676(), var11);
         RoundedRectRenderer.method01272(
            var1,
            this.field22449,
            this.field22450,
            this.field22451,
            this.field22452,
            GuiSize.method04763(2.0F).method04764(field22664).method04761(),
            1.0F,
            var12
         );
         RoundedRectRenderer.method01272(
            var1,
            this.field22449,
            this.field22453,
            this.field22451,
            this.field22454,
            GuiSize.method04763(2.0F).method04764(field22665).method04761(),
            1.0F,
            var13
         );
      }
   }

   public boolean method10031() {
      return this.field22431;
   }

   public void method10032() {
      this.method09950(new BindListWindow(), field22608, field22609);
   }

   public float method10033() {
      return 2.0F * this.field22444 + field22649;
   }

   public float method10034() {
      return this.field22479;
   }

   private void method10035() {
      FloatingWindow var1 = this.field22420.method09669(field22617);
      if (var1 != null) {
         this.field22420.method09654(var1);
      } else {
         SettingsWindow var2 = new SettingsWindow(field22618, field22619, this.field22486);
         float var3 = var2.method09568();
         float var4 = var2.method04683();
         float var5 = this.field22471 + this.field22473 / 2.0F - var3 / 2.0F;
         float var6 = this.field22472 + this.field22473 + field22620;
         var5 = GuiHitTestUtils.method05615(this.field22444 + 2.0F, this.field22444 + field22621 - var3 - 2.0F, var5);
         if (var6 + var4 > this.field22445 + field22622 - 2.0F) {
            var6 = this.field22472 - var4 - field22623;
         }

         this.field22420.method09652(var2, var5, var6);
      }
   }

   // $VF: Compiled from s
   private record Nested279(String query, List<ModuleCategoryColumn> list) {
      public boolean active() {
         return !this.query.isEmpty();
      }
   }
}
