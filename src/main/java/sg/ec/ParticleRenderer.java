package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.resources.Identifier;
import net.minecraft.world.InteractionHand;

// TODO(port 1.21.11): hmi_particle pipeline / RenderType tanimlari yeni render hattinda yeniden yazilacak.
public class ParticleRenderer {
   public static float field24961 = 0.016666668F;

   public static void method11149(
      List<ParticleAnimationConfig> var0,
      PoseStack var1,
      SubmitNodeCollector var2,
      String var3,
      InteractionHand var4,
      int var5,
      AbstractClientPlayer var6,
      float var7
   ) {
      var var8 = var0.iterator();

      while (var8.hasNext()) {
         ParticleAnimationConfig var9 = (ParticleAnimationConfig)var8.next();
         if (var9.field08002) {
            var8.remove();
         } else if (var3.equals(var9.field08001) && var9.field08023 == var4) {
            if (var9.field08026 != null) {
               var9.method03621(var9.field08026, var2, var5, var6, var7);
            } else {
               var9.method03621(var1, var2, var5, var6, var7);
            }

            var9.method03623();
         }
      }
   }

   public static RenderType method11151(Identifier var0) {
      return null;
   }

   public static RenderType method11152(Identifier var0) {
      return null;
   }
}
