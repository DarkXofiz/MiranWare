// Original binary: sg/ec/kreKcBgEJIkA70A6
package sg.ec;

import hex.script.api.Text;
import java.util.Optional;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;

// $VF: Compiled from s
public final class ScriptTextAdapter {
   private static final int field20922 = -16777216;
   private static final int field20923 = 16777215;
   private static final String field20924 = "This is a utility class and cannot be instantiated";

   private static Style method09248(int var0, int var1) {
      Style var2 = Style.EMPTY;
      if (var1 != 0) {
         var2 = var2.withColor(var1 & field20923);
      }

      if ((var0 & 1) != 0) {
         var2 = var2.withBold(true);
      }

      if ((var0 & 2) != 0) {
         var2 = var2.withItalic(true);
      }

      if ((var0 & 4) != 0) {
         var2 = var2.withUnderlined(true);
      }

      if ((var0 & 8) != 0) {
         var2 = var2.withStrikethrough(true);
      }

      if ((var0 & 16) != 0) {
         var2 = var2.withObfuscated(true);
      }

      return var2;
   }

   public static Component method09250(Object var0) {
      return var0 instanceof Text var1 ? method09253(var1) : Component.literal(String.valueOf(var0));
   }

   public static Text method09251(Component var0) {
      return method09255(var0, false);
   }

   private ScriptTextAdapter() {
      throw new UnsupportedOperationException(field20924);
   }

   private static void method09252(Text var0, Style var1) {
      if (var1.isBold()) {
         var0.bold();
      }

      if (var1.isItalic()) {
         var0.italic();
      }

      if (var1.isUnderlined()) {
         var0.underline();
      }

      if (var1.isStrikethrough()) {
         var0.strike();
      }

      if (var1.isObfuscated()) {
         var0.magic();
      }
   }

   private static Component method09253(Text var0) {
      if (!var0.animated() && var0.cached() instanceof Component var3) {
         return var3;
      }

      MutableComponent var1 = Component.empty();

      for (int var4 = 0; var4 < var0.parts(); var4++) {
         var1.append(method09256(var0, var4));
      }

      if (!var0.animated()) {
         var0.cached(var1);
      }

      return var1;
   }

   public static Text method09254(Component var0) {
      return method09255(var0, true);
   }

   private static Text method09255(Component var0, boolean var1) {
      Text var2 = Text.empty();
      if (var0 == null) {
         return var2;
      }

      var0.visit((var2x, var3) -> {
         String var4 = var1 ? StreamerTextHook.method03280(var3) : var3;
         if (!var4.isEmpty()) {
            var2.append(var4).color(method09257(var2x));
            method09252(var2, var2x);
         }

         return Optional.empty();
      }, Style.EMPTY);
      return var2;
   }

   private static Component method09256(Text var0, int var1) {
      String var2 = var0.partText(var1);
      int var3 = var0.partColor(var1);
      int var4 = var0.partGradient(var1);
      int var5 = var0.partFlags(var1);
      if (var4 == 0) {
         return Component.literal(var2).setStyle(method09248(var5, var3));
      }

      int var6 = var0.partPower(var1);
      int var7 = var0.partSpeed(var1);
      boolean var8 = (var5 & 1) != 0;
      MutableComponent var9 = var8
         ? ChatTextUtils.method05100(var2, var3, var4, var6, var7, true)
         : FontFallbackManager.method07183(var2, var3, var4, var6, var7).copy();
      return var9.setStyle(method09248(var5 & -2, 0));
   }

   private static int method09257(Style var0) {
      return var0.getColor() == null ? -1 : field20922 | var0.getColor().getValue();
   }
}
