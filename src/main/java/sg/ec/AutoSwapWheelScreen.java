// Original binary: sg/ec/Hq7hKhBqz7oEDWGo
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.client.input.MouseButtonEvent;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.ItemStack;
import org.joml.Matrix3x2f;

// $VF: Compiled from s
public final class AutoSwapWheelScreen extends Screen {
   private static final float field08584 = 80.0F;
   private static final float field08585 = 0;
   private final AutoSwap field08586;
   private int field08587 = -1;
   private static final String field08588 = "AutoSwap Wheel";
   private static final float field08589 = 360.0F;
   private static final float field08590 = -90.0F;
   private static final float field08591 = -90.0F;
   private static final float field08592 = 80.0F;
   private static final float field08593 = 130.0F;
   private static final float field08594 = 130.0F;
   private static final float field08595 = 130.0F;
   private static final float field08596 = 260.0F;
   private static final float field08597 = 260.0F;
   private static final float field08598 = -90.0F;
   private static final float field08599 = 105.0F;
   private static final float field08600 = 8.0F;
   private static final float field08601 = 8.0F;
   private static final double field08602 = 80.0;
   private static final double field08603 = 450.0;
   private static final double field08604 = 360.0;
   private static final float field08605 = 360.0F;
   private static final float field08606 = 8.0F;

   public int getSelectedIndex() {
      return this.field08587;
   }

   @Override
   public boolean mouseClicked(MouseButtonEvent var1, boolean var2) {
      if (InputCompat.glfwButton(var1.button()) == 0 && this.field08587 != -1) {
         this.field08586.method01526(this.field08587);
         return true;
      } else {
         return super.mouseClicked(var1, var2);
      }
   }

   private void renderWheel(GuiGraphics var1, float var2, float var3, int var4) {
      if (var4 > 0) {
         float var5 = field08589 / var4;
         float var6 = 1.0F;
         ArrayList var7 = new ArrayList();

         for (int var8 = 0; var8 < var4; var8++) {
            AutoSwap.Nested44 var9 = this.field08586.method01511(var8);
            boolean var10 = var8 == this.field08587;
            var9.method01546(var10);
            float var11 = var9.method01548();
            float var12 = field08590 + var8 * var5 + var6;
            float var13 = field08591 + (var8 + 1) * var5 - var6;
            int var14 = ColorUtils.method04627(
               ColorUtils.method04616(ColorUtils.Nested138.method04638(180), 180), ColorUtils.method04592(17, 18, 21, 180), var11
            );
            this.drawSector(var7, var2, var3, field08592, field08593, var12, var13, var14);
         }

         WheelSectorRenderState var15 = new WheelSectorRenderState(
            var7, var2 - field08594, var3 - field08595, field08596, field08597, var1.scissorStack.peek(), new Matrix3x2f(var1.pose())
         );
         ((GuiNodeAccess)((GuiRenderStateAccess)var1.guiRenderState).getCurrentLayer()).IaddSimpleElement(var15);
         this.renderWheelItems(var1, var2, var3, var5, var4);
      }
   }

   @Override
   public boolean isPauseScreen() {
      return false;
   }

   private int resolveSelectedIndex(int var1, int var2, float var3, float var4, int var5) {
      if (var5 <= 0) {
         return -1;
      }

      float var6 = var1 - var3;
      float var7 = var2 - var4;
      double var8 = Math.hypot(var6, var7);
      if (var8 < field08602) {
         return -1;
      }

      double var10 = Math.toDegrees(Math.atan2(var7, var6));
      var10 = (var10 + field08603) % field08604;
      int var12 = (int)(var10 / (field08605 / var5));
      return Math.max(0, Math.min(var12, var5 - 1));
   }

   public AutoSwapWheelScreen(AutoSwap var1) {
      super(Component.literal(field08588));
      this.field08586 = var1;
   }

   @Override
   public void renderBackground(GuiGraphics var1, int var2, int var3, float var4) {
   }

   private void drawSector(List<WheelSectorRenderState.Nested280> var1, float var2, float var3, float var4, float var5, float var6, float var7, int var8) {
      if (!(var7 <= var6)) {
         int var9 = Math.max(6, (int)Math.ceil((var7 - var6) / field08606));
         float var10 = (var7 - var6) / var9;

         for (int var11 = 0; var11 < var9; var11++) {
            float var12 = var6 + var11 * var10;
            float var13 = var12 + var10;
            float var14 = (float)Math.toRadians(var12);
            float var15 = (float)Math.toRadians(var13);
            float var16 = var2 + (float)Math.cos(var14) * var4;
            float var17 = var3 + (float)Math.sin(var14) * var4;
            float var18 = var2 + (float)Math.cos(var14) * var5;
            float var19 = var3 + (float)Math.sin(var14) * var5;
            float var20 = var2 + (float)Math.cos(var15) * var4;
            float var21 = var3 + (float)Math.sin(var15) * var4;
            float var22 = var2 + (float)Math.cos(var15) * var5;
            float var23 = var3 + (float)Math.sin(var15) * var5;
            var1.add(new WheelSectorRenderState.Nested280(var16, var17, var8));
            var1.add(new WheelSectorRenderState.Nested280(var18, var19, var8));
            var1.add(new WheelSectorRenderState.Nested280(var22, var23, var8));
            var1.add(new WheelSectorRenderState.Nested280(var20, var21, var8));
         }
      }
   }

   @Override
   public void removed() {
      this.field08586.method01535(this);
      super.removed();
   }

   @Override
   public void render(GuiGraphics var1, int var2, int var3, float var4) {
      float var5 = this.width / 2.0F;
      float var6 = this.height / 2.0F;
      int var7 = this.field08586.method01516();
      this.field08587 = this.resolveSelectedIndex(var2, var3, var5, var6, var7);
      this.renderWheel(var1, var5, var6, var7);
   }

   private void renderWheelItems(GuiGraphics var1, float var2, float var3, float var4, int var5) {
      for (int var6 = 0; var6 < var5; var6++) {
         float var7 = (float)Math.toRadians(field08598 + var6 * var4 + var4 / 2.0F);
         float var8 = field08599;
         float var9 = var2 + (float)Math.cos(var7) * var8;
         float var10 = var3 + (float)Math.sin(var7) * var8;
         ItemStack var11 = this.field08586.method01537(var6);
         if (!var11.isEmpty()) {
            var1.item(var11, (int)(var9 - field08600), (int)(var10 - field08601));
         }
      }
   }
}
