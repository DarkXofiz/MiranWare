// Original binary: sg/ec/5mcxqJeE17LX01Va
package sg.ec;

import java.util.List;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.data.AtlasIds;
import net.minecraft.util.RandomSource;

// $VF: Compiled from s
public final class ParticleSpriteSelector implements MinecraftAccess {
   private static TextureAtlasSprite field02678;

   public static TextureAtlasSprite method01247(List<TextureAtlasSprite> var0, RandomSource var1) {
      return var0 != null && !var0.isEmpty() ? var0.get(var1.nextInt(var0.size())) : method01249();
   }

   public static TextureAtlasSprite method01248(List<TextureAtlasSprite> var0, int var1, int var2) {
      if (var0 != null && !var0.isEmpty()) {
         int var3 = var0.size() - 1;
         return var3 != 0 && var2 > 0 ? (TextureAtlasSprite)var0.get(Math.clamp((long)var1 * var3 / var2, 0, var3)) : (TextureAtlasSprite)var0.getFirst();
      } else {
         return method01249();
      }
   }

   private ParticleSpriteSelector() {
   }

   private static TextureAtlasSprite method01249() {
      try {
         field02678 = mc.getAtlasManager().getAtlasOrThrow(AtlasIds.PARTICLES).missingSprite();
      } catch (Throwable var1) {
      }

      return field02678;
   }

   public static TextureAtlasSprite method01250(List<TextureAtlasSprite> var0) {
      return var0 != null && !var0.isEmpty() ? (TextureAtlasSprite)var0.getFirst() : method01249();
   }
}
