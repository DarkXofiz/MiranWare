// Original binary: sg/ec/XdNrnWLmxmlibLk2
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class HudElement implements GuiElement, SettingsContainer {
   private final List<Setting<?>> field14599 = new ArrayList<>();
   private final NumberSetting<Float> field14600;
   public static FontRenderer field14601;
   private boolean field14602;
   public static final byte field14603 = 15;
   public static final byte field14604 = 0;
   public static final byte field14605 = 0;
   public static final byte field14606 = 0;
   public static float field14607 = HudElement.field14642;
   public static float field14608 = HudElement.field14643;
   public static float field14609 = HudElement.field14644;
   public static float field14610 = HudElement.field14645;
   private static final CornerRadii field14611 = new CornerRadii(HudElement.field14646, 0.0F, 0.0F, HudElement.field14647);
   protected String field14612;
   private boolean field14613;
   private float field14614;
   private float field14615;
   private float field14616;
   private float field14617;
   private static final String field14618 = "Размер";
   private static final float field14619 = 0.5F;
   private static final float field14620 = 1.5F;
   private static final float field14621 = 0.01F;
   private static final float field14622 = 60.0F;
   private static final float field14623 = 2.5F;
   private static final String field14624 = "d";
   private static final float field14625 = 4.0F;
   private static final float field14626 = 4.0F;
   private static final float field14627 = 1.5F;
   private static final float field14628 = 0.5F;
   private static final float field14629 = 16.0F;
   private static final float field14630 = 4.0F;
   private static final float field14631 = 0.5F;
   private static final float field14632 = 7.0F;
   private static final float field14633 = 15.0F;
   private static final float field14634 = 2.5F;
   private static final float field14635 = 0.5F;
   private static final float field14636 = 0.5F;
   private static final float field14637 = 4.0F;
   private static final float field14638 = 4.0F;
   private static final float field14639 = 0.5F;
   private static final float field14640 = 1.5F;
   private static final float field14641 = 35.0F;
   private static final float field14642 = 8.5F;
   private static final float field14643 = 0.05F;
   private static final float field14644 = 17.5F;
   private static final float field14645 = 0.59F;
   private static final float field14646 = 4.0F;
   private static final float field14647 = 4.0F;

   public float method06435() {
      return this.field14617;
   }

   public float method06436() {
      return this.field14614;
   }

   public void method06437(String var1) {
      this.field14612 = var1;
   }

   public int method06438() {
      Hud var1 = ModuleManager.INSTANCE.method08274();
      return var1.method04942();
   }

   public HudElement(String var1) {
      this.field14600 = new NumberSetting<Float>(field14618)
         .method10835(field14619)
         .method10838(field14620)
         .method10834(field14621)
         .method10839(false)
         .method03017(1.0F)
         .method03023(this);
      this.field14613 = true;
      this.field14614 = 0.0F;
      this.field14615 = 0.0F;
      this.field14616 = field14622;
      this.field14617 = field14623;
      this.field14612 = var1;
   }

   public void method06439(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      Hud var9 = ModuleManager.INSTANCE.method08274();
      if (var9.method04948()) {
         GuiClipStack.method00341(var1, var2, var3, var4, var5, var6, var7, field14641, var8);
      }
   }

   public float method06440(float var1) {
      float var2 = this.method06446();
      return var2 == 0.0F ? var1 : var1 / var2;
   }

   public void method06441(GuiGraphicsExtractor var1, String var2) {
      boolean var3 = this.method06447();
      int var4 = ColorUtils.method04611(this.method06460(), this.method06455());
      int var5 = this.method06438();
      String var6 = this.method06462();
      float var7 = field14609;
      boolean var8 = var2.equals(field14624);
      Fonts.field00107
         .method09490(
            var1,
            var2,
            this.method06436() + field14625 + (var8 ? 1 : 0),
            this.method06464() + field14626 + (var8 ? field14627 : field14628),
            var5,
            field14607 + (var8 ? 0 : 2),
            field14608
         );
      if (var3) {
         RoundedRectRenderer.method01276(var1, this.method06436(), this.method06464(), this.method06458(), var7, field14611, this.method06466(), var4);
      } else {
         float var9 = this.method06464() + field14629;
         GuiShadowRenderer.method10984(
            var1, this.method06436(), this.method06464(), this.method06458(), this.method06435(), field14630, field14631, field14632, var4
         );
      }

      Fonts.field00109
         .method09490(
            var1,
            var6,
            this.method06436() + field14633 + field14634,
            this.method06464() + (field14607 + field14635) / 2.0F,
            var5,
            field14607 + field14636,
            -field14608
         );
      this.method06439(var1, this.method06436(), this.method06464(), this.method06458(), this.method06435(), field14637, this.method06466(), 1.0F);
      RoundedRectRenderer.method01272(var1, this.method06436(), this.method06464(), this.method06458(), this.method06435(), field14638, this.method06466(), var4);
   }

   public void method06442(boolean var1) {
      this.field14602 = var1;
   }

   public double method06443(double var1) {
      float var3 = this.method06446();
      return var3 == 0.0F ? var1 : var1 / var3;
   }

   public boolean method06444(float var1, float var2) {
      return GuiHitTestUtils.method05625(var1, var2, this.method06436(), this.method06464(), this.method06458(), this.method06435());
   }

   public boolean method06445() {
      return this.method06463(this.method06436(), this.method06458());
   }

   public float method06446() {
      return GuiHitTestUtils.method05615(field14639, field14640, this.field14600.method03022());
   }

   public boolean method06447() {
      Hud var1 = ModuleManager.INSTANCE.method08274();
      return var1.field10884;
   }

   @Override
   public List<Setting<?>> method03026() {
      return this.field14599;
   }

   public void method06448(float var1) {
      this.field14616 = var1;
   }

   public DraggableElement method06449(HudElement var1, float var2, float var3) {
      String var4 = this.method06462();
      DragManager.INSTANCE.field11288.put(var4, new DraggableElement(var1, var4, var2, var3));
      return DragManager.INSTANCE.field11288.get(var4);
   }

   public float method06450() {
      float var1 = this.method06446();
      float var2 = GuiScaleUtils.method06754();
      return var1 == 0.0F ? var2 : var2 / var1;
   }

   public void method06451(boolean var1) {
      this.field14613 = var1;
   }

   public boolean method06452() {
      return this.field14602;
   }

   public void method06453(float var1) {
      this.field14615 = var1;
   }

   public float method06454() {
      float var1 = this.method06446();
      float var2 = GuiScaleUtils.method06753();
      return var1 == 0.0F ? var2 : var2 / var1;
   }

   public float method06455() {
      Hud var1 = ModuleManager.INSTANCE.method08274();
      return ColorUtils.method04609(var1.method04950());
   }

   public void method06456(float var1) {
      this.field14617 = var1;
   }

   public boolean method06457() {
      return this.field14613;
   }

   public float method06458() {
      return this.field14616;
   }

   public void method06459(DraggableElement var1, float var2, float var3) {
      float var4 = var1.method02687();
      if (var4 > 0.0F && this.method06463(var1.method02685(), var4)) {
         var1.method02707(var1.method02685() + var4 - var2);
      }

      var1.method02676(var2);
      var1.method02696(var3);
      this.method06465(var1.method02685());
      this.method06453(var1.method02669());
      this.method06448(var2);
      this.method06456(var3);
   }

   public int method06460() {
      Hud var1 = ModuleManager.INSTANCE.method08274();
      return var1.method04950();
   }

   public NumberSetting<Float> method06461() {
      return this.field14600;
   }

   public String method06462() {
      return this.field14612;
   }

   private boolean method06463(float var1, float var2) {
      return var1 + var2 / 2.0F > this.method06454() / 2.0F;
   }

   public float method06464() {
      return this.field14615;
   }

   public void method06465(float var1) {
      this.field14614 = var1;
   }

   public float method06466() {
      Hud var1 = ModuleManager.INSTANCE.method08274();
      return var1.method04938();
   }
}
