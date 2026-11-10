// Original binary: sg/ec/KudMqWCLCtUyJ4mf
package sg.ec;

import com.mojang.renderpearl.api.pipeline.PrimitiveTopology;
import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import hex.script.api.Render2D;
import hex.script.api.Text;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix3x2f;
import org.joml.Matrix3x2fStack;

// $VF: Compiled from s
public final class ScriptRender2DAdapter implements MinecraftAccess {
   private static final int field09671 = -1;
   private static final float field09672 = 0;
   private static final float field09673 = 0;
   private final Render2D field09674 = new Render2D(
      this::method04325,
      this::method04328,
      this::method04285,
      this::method04320,
      this::method04292,
      this::method04323,
      this::method04301,
      this::method04294,
      this::method04306,
      this::method04327,
      this::method04313,
      this::method04315,
      this::method04302,
      FontRegistry::method02879,
      this::method04311,
      this::method04287,
      this::method04317,
      this::method04282,
      this::method04291,
      this::method04296,
      this::method04314,
      this::method04308,
      this::method04286,
      this::method04283,
      this::method04290,
      this::method04295,
      this::method04300,
      this::method04289,
      this::method04304,
      this::method04324,
      this::method04319,
      this::method04316,
      this::method04284,
      this::method04293
   );
   private final List<ScriptRender2DAdapter.Nested129> field09675 = new ArrayList<>();
   private GuiGraphicsExtractor field09676;
   private boolean field09677;
   private int field09678;
   private int field09679;
   private int field09680;
   private static final float field09681 = 8.0F;
   private static final float field09682 = 8.0F;
   private static final float field09683 = 256.0F;
   private static final float field09684 = 256.0F;
   private static final float field09685 = 0.0625F;
   private static final float field09686 = -1048576.0F;
   private static final float field09687 = 1048576.0F;
   private static final long field09688 = 1000000000000L;
   private static final float field09689 = 1.0E9F;
   private static final String field09690 = "Render2D is valid only inside onRender2D";
   private static final String field09691 = "basic";
   private static final String field09692 = "basic2";
   private static final String field09693 = "main";
   private static final String field09694 = "text";
   private static final String field09695 = "hudText";
   private static final String field09696 = "headerText";
   private static final String field09697 = "inactiveText";
   private static final String field09698 = "rect";
   private static final String field09699 = "outline";
   private static final String field09700 = "separator";
   private static final String field09701 = "field";
   private static final String field09702 = "inactiveField";
   private static final String field09703 = "button";
   private static final String field09704 = "inactiveButton";
   private static final String field09705 = "slider";
   private static final String field09706 = "sliderCircle";
   private static final String field09707 = "sliderWindow";
   private static final String field09708 = "switcher";
   private static final String field09709 = "inactiveSwitch";
   private static final String field09710 = "window";
   private static final String field09711 = "scrollBar";
   private static final String field09712 = "logo";
   private static final String field09713 = "tooltip";

   private void method04282(
      String var1, String var2, String var3, float var4, float var5, float var6, float var7, int var8, int var9, int var10, int var11, int var12
   ) {
      if (this.field09676 != null) {
         String var13 = var2 != null && !var2.isEmpty()
            ? FontFallbackManager.method07178(var2, var3, var9, var10, var11, var12)
            : FontFallbackManager.method07186(var3, var9, var10, var11, var12);
         FontRegistry.method02886(var1).method09490(this.field09676, var13, var4, var5, var8, var6, var7);
      }
   }

   private void method04283(String var1, float var2, float var3, float var4, float var5, int var6) {
      if (this.field09676 != null && var1 != null && !var1.isEmpty() && !(var4 <= 0.0F) && !(var5 <= 0.0F)) {
         Identifier var7 = ScriptRenderResources.method08786(var1);
         if (var7 != null) {
            GuiTextureRenderer.method10253(
               this.field09676, var7, 0.0F, 0.0F, 1.0F, 1.0F, var2, var3, var4, var5, new CornerRadii(0.0F), 1.0F, new CornerColors(var6)
            );
         }
      }
   }

   private void method04284(
      String var1,
      String var2,
      int var3,
      float var4,
      float var5,
      float var6,
      float var7,
      float var8,
      float var9,
      float var10,
      float var11,
      int var12,
      int var13,
      int var14,
      int var15,
      float var16,
      int var17,
      int var18,
      int var19,
      int var20,
      int var21
   ) {
      if (this.field09676 != null && !(var6 <= 0.0F) && !(var7 <= 0.0F) && !this.method04288(var17, var18, var19, var20)) {
         Identifier var22 = ScriptRenderResources.method08786(var2);
         RenderPipeline var23 = var22 == null
            ? ScriptShaderManager.method10951(var1, var21)
            : ScriptRenderResources.method08793(var1, PrimitiveTopology.QUADS, var21);
         if (ScriptShaderManager.method10952(var1, var23)) {
            GuiRenderBatch.method05186(
               this.field09676.guiRenderState,
               new ScriptLineRenderState(
                  new Matrix3x2f(this.field09676.pose()),
                  var23,
                  var4,
                  var5,
                  var6,
                  var7,
                  var8,
                  var9,
                  var10,
                  var11,
                  var17,
                  var18,
                  var19,
                  var20,
                  var12,
                  var13,
                  var14,
                  var15,
                  var16,
                  var22,
                  var3,
                  this.field09676.scissorStack.peek()
               )
            );
         }
      }
   }

   private float method04285(String var1, float var2) {
      return Fonts.field00111.method09486(var1, var2);
   }

   private void method04286(String var1, float var2, float var3, float var4, float var5, int var6, float var7, float var8, int var9) {
      if (this.field09676 != null && !(var4 <= 0.0F) && !(var5 <= 0.0F) && ScriptShaderManager.method10928(var1)) {
         GuiRenderBatch.method05186(
            this.field09676.guiRenderState,
            new ScriptLineRenderState(
               new Matrix3x2f(this.field09676.pose()),
               ScriptShaderManager.method10951(var1, var9),
               var2,
               var3,
               var4,
               var5,
               0.0F,
               0.0F,
               1.0F,
               1.0F,
               var6,
               var6,
               var6,
               var6,
               Math.round(var4 * field09681),
               Math.round(var5 * field09682),
               Math.round(var7 * field09683),
               Math.round(var8 * field09684),
               this.method04297(),
               null,
               -1,
               this.field09676.scissorStack.peek()
            )
         );
      }
   }

   private float method04287(String var1, Object var2, float var3, float var4) {
      FontRenderer var5 = FontRegistry.method02886(var1);
      return var2 instanceof Text var6
         ? var5.method09476(ScriptTextAdapter.method09250(var6), var3, var4)
         : var5.method09478(String.valueOf(var2), var3, var4);
   }

   private boolean method04288(int var1, int var2, int var3, int var4) {
      return ColorUtils.method04625(var1) == 0
         && ColorUtils.method04625(var2) == 0
         && ColorUtils.method04625(var3) == 0
         && ColorUtils.method04625(var4) == 0;
   }

   private void method04289() {
      if (this.field09676 != null && this.field09680 != 0) {
         this.field09680--;
         this.field09676.disableScissor();
      }
   }

   private void method04290(String var1, String var2, String var3, int var4, float var5, float var6, float var7, int var8, int var9) {
      float[] var10 = MeshBufferUtils.method07839(var1);
      if (this.field09676 != null && MeshBufferUtils.method07837(var10) != 0) {
         Identifier var11 = ScriptRenderResources.method08786(var3);
         RenderPipeline var12 = var11 == null
            ? ScriptShaderManager.method10932(var2, var9)
            : ScriptRenderResources.method08793(var2, PrimitiveTopology.TRIANGLES, var9);
         if (ScriptShaderManager.method10952(var2, var12)) {
            GuiRenderBatch.method05186(
               this.field09676.guiRenderState,
               new MeshGuiRenderState(
                  new Matrix3x2f(this.field09676.pose()),
                  var12,
                  var10,
                  MeshBufferUtils.method07831(var1),
                  var5,
                  var6,
                  var7,
                  var8,
                  this.method04297(),
                  var11,
                  var4,
                  this.field09676.scissorStack.peek()
               )
            );
         }
      }
   }

   private float method04291(String var1, float var2) {
      return FontRegistry.method02886(var1).method09485(var2);
   }

   private int method04292(String var1) {
      if (var1 == null) {
         return -1;
      }

      ThemeSettings var2 = ThemeManager.INSTANCE.method09611();
      if (var2 == null) {
         return -1;
      }

      return switch (var1) {
         case field09691 -> var2.field22104.method11676();
         case field09692 -> var2.field22105.method11676();
         case field09693 -> var2.field22122.method11676();
         case field09694 -> var2.field22109.method11676();
         case field09695 -> var2.field22107.method11676();
         case field09696 -> var2.field22108.method11676();
         case field09697 -> var2.field22110.method11676();
         case field09698 -> var2.field22106.method11676();
         case field09699 -> var2.field22117.method11676();
         case field09700 -> var2.field22118.method11676();
         case field09701 -> var2.field22119.method11676();
         case field09702 -> var2.field22120.method11676();
         case field09703 -> var2.field22115.method11676();
         case field09704 -> var2.field22116.method11676();
         case field09705 -> var2.field22111.method11676();
         case field09706 -> var2.field22112.method11676();
         case field09707 -> var2.field22123.method11676();
         case field09708 -> var2.field22113.method11676();
         case field09709 -> var2.field22114.method11676();
         case field09710 -> var2.field22121.method11676();
         case field09711 -> var2.field22124.method11676();
         case field09712 -> var2.field22125.method11676();
         case field09713 -> var2.field22126.method11676();
         default -> -1;
      };
   }

   private void method04293(float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9) {
      if (this.field09676 != null) {
         GuiClipStack.method00345(
            this.field09676, var1, var2, var3, var4, new CornerRadii(var5), var6, var7, Math.max(0.0F, Math.min(1.0F, var8)), var9
         );
      }
   }

   private void method04294(String var1, float var2, float var3, float var4, int var5, int var6) {
      if (var1 != null && !var1.isEmpty()) {
         Fonts.field00111.method09481(this.method04322(), var1, var2, var3, var5, var6, var4, 0.0F);
      }
   }

   private boolean method04295(String var1, long var2, float var4, float var5, float var6, int var7, int var8, int var9) {
      if (this.field09676 != null && !(var6 <= 0.0F)) {
         ItemStack var10 = ScriptItemSnapshotCache.method11755(var2);
         ItemStack var11 = var10.isEmpty() ? ScriptRenderResources.method08787(var1) : var10;
         if (var11.isEmpty()) {
            return false;
         }

         boolean var12 = var7 > 1 || var8 > 0 && var9 > 0;
         ScriptRender2DAdapter.Nested129 var13 = this.method04305();
         var13.field09714.set(this.field09676.pose());
         var13.field09715 = var10.isEmpty() && var12 ? this.method04309(var11, var7, var8, var9) : var11;
         var13.field09717 = var12;
         var13.field09718 = var4;
         var13.field09719 = var5;
         var13.field09720 = var6 * field09685;
         var13.field09716 = this.field09676.scissorStack.peek();
         return true;
      } else {
         return false;
      }
   }

   private float method04296(String var1, float var2) {
      return FontRegistry.method02886(var1).field21527.method07006().method00837() * var2;
   }

   private float method04297() {
      return (float)(System.nanoTime() % field09688) / field09689;
   }

   GuiGraphicsExtractor method04298() {
      return this.field09676;
   }

   private int method04299(float var1) {
      return (int)Math.max(field09686, Math.min(field09687, var1));
   }

   private void method04300(float var1, float var2, float var3, float var4) {
      if (this.field09676 != null) {
         int var5 = this.method04299(var1);
         int var6 = this.method04299(var2);
         this.field09676
            .enableScissor(
               var5, var6, Math.max(var5, this.method04299(var1 + Math.max(0.0F, var3))), Math.max(var6, this.method04299(var2 + Math.max(0.0F, var4)))
            );
         this.field09680++;
      }
   }

   private void method04301(float var1, float var2, float var3, float var4, float var5, float var6, int var7, int var8, int var9, int var10) {
      GuiShapeRenderer.method09702(
         this.method04322(), var1, var2, var3, var4, new CornerRadii(var5), var6, new CornerColors(var7, var8, var9, var10)
      );
   }

   private int method04302() {
      return this.field09676 == null ? 0 : this.field09676.guiHeight();
   }

   private void method04303() {
      if (this.field09676 == null) {
         this.field09680 = 0;
         this.field09678 = 0;
         this.field09679 = 0;
         this.field09677 = false;
      } else {
         while (this.field09680 > 0) {
            this.field09680--;
            this.field09676.disableScissor();
         }

         while (this.field09678 > 0) {
            this.field09678--;
            this.field09676.pose().popMatrix();
         }

         if (this.field09677) {
            GuiRenderBatch.method05181();
         }

         this.method04310();
         if (this.field09677) {
            ItemRenderUtils.method08420();
            this.field09677 = false;
         }

         this.method04318();
      }
   }

   private void method04304() {
      if (this.field09676 != null) {
         if (this.field09677) {
            GuiRenderBatch.method05183();
         } else {
            GuiRenderBatch.method05190(this.field09676.guiRenderState);
         }
      }
   }

   private ScriptRender2DAdapter.Nested129 method04305() {
      if (this.field09679 == this.field09675.size()) {
         this.field09675.add(new ScriptRender2DAdapter.Nested129());
      }

      return this.field09675.get(this.field09679++);
   }

   private int method04306(int var1) {
      return ColorUtils.method04621(var1);
   }

   void method04307(GuiGraphicsExtractor var1) {
      this.method04303();
      this.field09676 = var1;
      this.field09677 = !GuiRenderBatch.method05191();
      if (this.field09677) {
         GuiRenderBatch.method05188(true);
         ItemRenderUtils.method08410();
      }
   }

   private float method04308(String var1, float var2) {
      return -FontRegistry.method02886(var1).field21527.method07006().method00835() * var2;
   }

   private ItemStack method04309(ItemStack var1, int var2, int var3, int var4) {
      ItemStack var5 = var1.copyWithCount(Math.max(1, var2));
      if (var3 > 0 && var4 > 0 && var5.isDamageableItem()) {
         var5.setDamageValue(Math.min(var3, var4));
      }

      return var5;
   }

   private void method04310() {
      Matrix3x2fStack var1 = this.field09676.pose();

      for (int var2 = 0; var2 < this.field09679; var2++) {
         ScriptRender2DAdapter.Nested129 var3 = this.field09675.get(var2);
         var1.pushMatrix();
         var1.set(var3.field09714);
         if (var3.field09716 != null) {
            this.field09676.scissorStack.push(var3.field09716);
         }

         ItemRenderUtils.method08415(this.field09676, var3.field09715, var3.field09718, var3.field09719, 1.0F, 1.0F, var3.field09720);
         if (var3.field09716 != null) {
            this.field09676.scissorStack.pop();
         }

         var1.popMatrix();
      }
   }

   private float method04311(String var1, Object var2, float var3, float var4, float var5, float var6, int var7) {
      if (this.field09676 == null) {
         return 0.0F;
      }

      FontRenderer var8 = FontRegistry.method02886(var1);
      return var2 instanceof Text var9
         ? var8.method09477(this.field09676, ScriptTextAdapter.method09250(var9), var3, var4, var7, var5, var6)
         : var8.method09490(this.field09676, String.valueOf(var2), var3, var4, var7, var5, var6);
   }

   Render2D method04312() {
      return this.field09674;
   }

   private Object method04313() {
      return this.method04322().guiRenderState;
   }

   private float method04314(String var1, float var2) {
      return FontRegistry.method02886(var1).field21527.method07006().method00836() * var2 - 1.0F;
   }

   private int method04315() {
      return this.field09676 == null ? 0 : this.field09676.guiWidth();
   }

   private float method04316() {
      return mc.getDeltaTracker().getGameTimeDeltaPartialTick(true);
   }

   private void method04317(String var1, String var2, float var3, float var4, float var5, float var6, int var7, float var8, float var9) {
      if (this.field09676 != null) {
         TextRenderUtils.method00669(this.field09676, FontRegistry.method02886(var1), var2, var3, var4, var8, var7, var5, var6, var9);
      }
   }

   private void method04318() {
      Matrix3x2fStack var1 = this.field09676.pose();

      for (int var2 = 0; var2 < this.field09679; var2++) {
         ScriptRender2DAdapter.Nested129 var3 = this.field09675.get(var2);
         if (var3.field09717) {
            var1.pushMatrix();
            var1.set(var3.field09714);
            if (var3.field09716 != null) {
               this.field09676.scissorStack.push(var3.field09716);
            }

            this.method04321(var3);
            if (var3.field09716 != null) {
               this.field09676.scissorStack.pop();
            }

            var1.popMatrix();
         }

         var3.field09715 = null;
         var3.field09716 = null;
         var3.field09717 = false;
      }

      this.field09679 = 0;
   }

   private void method04319(
      String var1, int var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10, float var11, int var12
   ) {
      Identifier var13 = ScriptRenderResources.method08786(var1);
      if (this.field09676 != null && var13 != null && !(var5 <= 0.0F) && !(var6 <= 0.0F) && ColorUtils.method04625(var12) != 0) {
         if (var2 < 0) {
            GuiTextureRenderer.method10253(
               this.field09676, var13, var7, var8, var9, var10, var3, var4, var5, var6, new CornerRadii(var11), 1.0F, new CornerColors(var12)
            );
         } else {
            GuiRenderBatch.method05186(
               this.field09676.guiRenderState,
               new ScriptMeshRenderState(
                  new TextureGuiRenderState(
                     var13,
                     var7,
                     var8,
                     var9,
                     var10,
                     var3,
                     var4,
                     var5,
                     var6,
                     new CornerRadii(var11),
                     1.0F,
                     new CornerColors(var12),
                     this.field09676.scissorStack.peek(),
                     new Matrix3x2f(this.field09676.pose())
                  ),
                  var2
               )
            );
         }
      }
   }

   private float method04320(float var1) {
      return Fonts.field00111.method09485(var1);
   }

   private void method04321(ScriptRender2DAdapter.Nested129 var1) {
      Matrix3x2fStack var2 = this.field09676.pose();
      var2.pushMatrix();
      var2.translate(var1.field09718, var1.field09719);
      var2.scale(var1.field09720, var1.field09720);
      this.field09676.itemDecorations(mc.font, var1.field09715, 0, 0);
      var2.popMatrix();
   }

   private GuiGraphicsExtractor method04322() {
      GuiGraphicsExtractor var1 = this.field09676;
      if (var1 == null) {
         throw new IllegalStateException(field09690);
      } else {
         return var1;
      }
   }

   private void method04323(
      float var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8, int var9, int var10, int var11, int var12
   ) {
      RoundedRectRenderer.method01273(
         this.method04322(), var1, var2, var3, var4, new CornerRadii(var5, var6, var7, var8), 1.0F, new CornerColors(var9, var10, var11, var12)
      );
   }

   private void method04324(int var1, float var2, float var3) {
      if (this.field09676 != null) {
         Matrix3x2fStack var4 = this.field09676.pose();
         switch (var1) {
            case 0:
               var4.pushMatrix();
               this.field09678++;
               break;
            case 1:
               if (this.field09678 > 0) {
                  var4.popMatrix();
                  this.field09678--;
               }
               break;
            case 2:
               var4.translate(var2, var3);
               break;
            case 3:
               var4.scale(var2, var3);
               break;
            default:
               var4.rotate((float)Math.toRadians(var2));
         }
      }
   }

   private void method04325(float var1, float var2, float var3, float var4, float var5, int var6) {
      RoundedRectRenderer.method01272(this.method04322(), var1, var2, var3, var4, var5, 1.0F, var6);
   }

   void method04326() {
      this.method04303();
      this.field09676 = null;
   }

   private Object method04327() {
      return this.method04322();
   }

   private void method04328(String var1, float var2, float var3, float var4, int var5) {
      if (var1 != null && !var1.isEmpty()) {
         Fonts.field00111.method09480(this.method04322(), var1, var2, var3, var5, var4);
      }
   }

   // $VF: Compiled from s
   private static final class Nested129 {
      private final Matrix3x2f field09714 = new Matrix3x2f();
      private ItemStack field09715;
      private ScreenRectangle field09716;
      private boolean field09717;
      private float field09718;
      private float field09719;
      private float field09720;
   }
}
