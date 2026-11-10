// Original binary: sg/ec/74ajVVo2jyDQOjXP
package sg.ec;

import com.mojang.blaze3d.platform.NativeImage;
import net.minecraft.client.renderer.texture.MissingTextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureContents;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public final class TextureImageUtils {
   private static final int field03945 = 6;
   private static final int field03946 = 0;
   private static final int field03947 = 0;
   private static final String field03948 = "This is a utility class and cannot be instantiated";

   public static TextureContents method01620(Identifier var0, TextureContents var1) {
      NativeImage var2 = var1.image();
      if (var2 == null) {
         return var1;
      }

      int sx = var2.getWidth();
      int sxx = var2.getHeight() / 6;
      if (sxx > 0 && sx != sxx) {
         int sxxx = Math.min(Math.min(sx, sxx), 2048);

         try {
            NativeImage sxxxx = method01622(var2, sx, sxx, sxxx);
            return new TextureContents(sxxxx, var1.metadata());
         } catch (Exception sxxxx) {
            return method01623();
         } finally {
            var1.close();
         }
      } else {
         return var1;
      }
   }

   private static TextureContents method01621() {
      NativeImage var0 = new NativeImage(16, 96, false);
      NativeImage var1 = MissingTextureAtlasSprite.generateMissingImage(16, 16);

      try {
         for (int var2 = 0; var2 < 6; var2++) {
            var1.copyRect(var0, 0, 0, 0, var2 * 16, 16, 16, false, false);
         }
      } finally {
         var1.close();
      }

      return new TextureContents(var0, null);
   }

   private static NativeImage method01622(NativeImage var0, int var1, int var2, int var3) {
      NativeImage var4 = new NativeImage(var3, var3 * 6, false);
      NativeImage var5 = new NativeImage(var3, var3, false);

      try {
         for (int var6 = 0; var6 < 6; var6++) {
            var0.resizeSubRectTo(0, var6 * var2, var1, var2, var5);
            var5.copyRect(var4, 0, 0, 0, var6 * var3, var3, var3, false, false);
         }
      } finally {
         var5.close();
      }

      return var4;
   }

   public static TextureContents method01623() {
      return method01621();
   }

   private TextureImageUtils() {
      throw new UnsupportedOperationException(field03948);
   }
}
