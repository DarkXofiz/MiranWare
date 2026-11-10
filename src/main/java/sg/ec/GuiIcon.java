// Original binary: sg/ec/5iP37YiB8MRtNA9w
package sg.ec;

import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public enum GuiIcon {
   PLAY(GuiIcon.Nested36.MENU, "\uea15"),
   CHECK(GuiIcon.Nested36.MENU, "\uea05"),
   DOTS(GuiIcon.Nested36.MENU, "\uea0a"),
   DELETE(GuiIcon.Nested36.MENU, "\uea09"),
   CLOSE(GuiIcon.Nested36.MENU, "\uea1e"),
   SAVE(GuiIcon.Nested36.MENU, "\uea16"),
   PLUS(GuiIcon.Nested36.MENU, "\uea13"),
   COPY(GuiIcon.Nested36.MENU, "\uea08"),
   IMPORT(GuiIcon.Nested36.MENU, "\uea0d"),
   SHARE(GuiIcon.Nested36.MENU, "\uea18"),
   CART(GuiIcon.Nested36.MENU, "\uea03"),
   EXPAND(GuiIcon.Nested36.MENU, "\uea0b"),
   ALERT(GuiIcon.Nested36.BASE, "B"),
   FOLDER(GuiIcon.Nested36.BASE, "P"),
   GEAR(GuiIcon.Nested36.BASE, "5"),
   PIN(GuiIcon.Nested36.BASE, "W"),
   RELOAD(GuiIcon.Nested36.BASE, "b");

   private static final float field02517 = 0.5F;
   private final GuiIcon.Nested36 field02518;
   private final String field02519;

   GuiIcon(GuiIcon.Nested36 var3, String var4) {
      this.field02518 = var3;
      this.field02519 = var4;
   }

   public void method01190(GuiGraphicsExtractor var1, float var2, float var3, float var4, int var5) {
      this.method01191().method09487(var1, this.field02519, var2, var3 - var4 + 0.5F, var4, var5);
   }

   private FontRenderer method01191() {
      return this.field02518 == GuiIcon.Nested36.MENU ? Fonts.field00108 : Fonts.field00107;
   }

   // $VF: Compiled from s
   private enum Nested36 {
      BASE,
      MENU;
   }
}
