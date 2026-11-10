// Original binary: sg/ec/Derpt24n5GtJVjIg
package sg.ec;

import net.minecraft.network.chat.Style;
import net.minecraft.util.FormattedCharSink;

// $VF: Compiled from s
public final class TextWidthSink implements FormattedCharSink {
   private final FormattedCharSink field06958;
   private final TextDecorationEvent.Nested275 field06959;

   @Override
   public boolean accept(int var1, Style var2, int var3) {
      TextDecorationEvent.Nested274 var4 = this.field06959.method07290(var3);
      if (var4 == null) {
         return this.field06958.accept(var1, var2, var3);
      }

      int[] sx = var4.codepoints();
      Style[] sxx = var4.styles();

      for (int sxxx = 0; sxxx < sx.length; sxxx++) {
         if (!this.field06958.accept(var1, sxx[sxxx], sx[sxxx])) {
            return false;
         }
      }

      return true;
   }

   private TextWidthSink(FormattedCharSink var1, TextDecorationEvent.Nested275 var2) {
      this.field06958 = var1;
      this.field06959 = var2;
   }

   public static FormattedCharSink wrap(FormattedCharSink var0) {
      TextDecorationEvent.Nested275 var1 = TextDecorationEvent.field22150.method09828();
      return var1 == null ? var0 : new TextWidthSink(var0, var1);
   }
}
