// Original binary: sg/ec/d0tRR9lRRLO5HeAV
package sg.ec;

import java.util.IdentityHashMap;
import java.util.Map;
import net.minecraft.core.ClientAsset.ResourceTexture;
import net.minecraft.core.ClientAsset.Texture;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.PlayerSkin;

// $VF: Compiled from s
public final class CapeTextureUtils {
   public static boolean field17855 = true;
   private static final String field17856 = "minecraft/cape.png";
   private static final int field17857 = 0;
   private static final Map<PlayerSkin, PlayerSkin> field17858 = new IdentityHashMap<>();
   private static Identifier field17859;
   private static Texture field17860;
   private static final String field17861 = "hex";
   private static final String field17862 = "minecraft/cape.png";
   private static final String field17863 = "This is a utility class and cannot be instantiated";

   private static Texture method07322() {
      Texture var0 = field17860;
      if (var0 != null) {
         return var0;
      }

      Identifier sx = method07323();
      Texture sxx = new ResourceTexture(sx, sx);
      field17860 = sxx;
      return sxx;
   }

   public static Identifier method07323() {
      Identifier var0 = field17859;
      if (var0 != null) {
         return var0;
      }

      Identifier var1 = TextureLoader.method07218(field17861, field17862);
      field17859 = var1;
      return var1;
   }

   private CapeTextureUtils() {
      throw new UnsupportedOperationException(field17863);
   }

   public static PlayerSkin method07324(PlayerSkin var0) {
      if (var0 == null) {
         return null;
      }

      synchronized (field17858) {
         PlayerSkin var2 = field17858.get(var0);
         if (var2 != null) {
            return var2;
         }

         if (field17858.size() >= 64) {
            field17858.clear();
         }

         Texture var3 = method07322();
         PlayerSkin var4 = new PlayerSkin(var0.body(), var3, var3, var0.model(), var0.secure());
         field17858.put(var0, var4);
         return var4;
      }
   }
}
