// Original binary: sg/ec/oKniEk45TEk7JRrz
package sg.ec;

import net.minecraft.network.chat.Style;

// $VF: Compiled from s
public class TextDecorationEvent extends Event {
   public static final TextDecorationEvent field22150 = new TextDecorationEvent();
   private TextDecorationEvent.Nested275 field22151;

   public TextDecorationEvent.Nested275 method09827() {
      return this.field22151;
   }

   public TextDecorationEvent.Nested275 method09828() {
      if (!this.method05698()) {
         return null;
      }

      this.field22151 = null;
      super.method03208();
      return this.field22151;
   }

   public void method09829(TextDecorationEvent.Nested275 var1) {
      this.field22151 = var1;
   }

   // $VF: Compiled from s
   public record Nested274(int[] codepoints, Style[] styles) {
   }

   // $VF: Compiled from s
   public interface Nested275 {
      TextDecorationEvent.Nested274 method07290(int var1);
   }
}
