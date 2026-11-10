// Original binary: sg/ec/b09YToVxRf2clhxy
package sg.ec;

import com.mojang.renderpearl.api.textures.GpuSampler;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.render.TextureSetup;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public final class TextureSetupHooks {
   private static final TextureSetup[] field16896 = new TextureSetup[8];
   private static int field16897;
   private static final TextureSetup[] field16898 = new TextureSetup[8];
   private static int field16899;

   public static void method07074(GpuTextureView var0, GpuSampler var1, CallbackInfoReturnable<TextureSetup> var2) {
      Minecraft var3 = Minecraft.getInstance();
      if (var3 != null && var3.gameRenderer != null) {
         GpuTextureView sx = var3.gameRenderer.lightmap();

         for (TextureSetup sxx : field16896) {
            if (sxx != null && sxx.texure0() == var0 && sxx.sampler0() == var1 && sxx.texure2() == sx) {
               var2.setReturnValue(sxx);
               return;
            }
         }
      }
   }

   public static void method07075(TextureSetup var0) {
      field16896[field16897] = var0;
      field16897 = field16897 + 1 & 7;
   }

   public static void method07076(GpuTextureView var0, GpuSampler var1, CallbackInfoReturnable<TextureSetup> var2) {
      for (TextureSetup var6 : field16898) {
         if (var6 != null && var6.texure0() == var0 && var6.sampler0() == var1) {
            var2.setReturnValue(var6);
            return;
         }
      }
   }

   public static void method07077(TextureSetup var0) {
      field16898[field16899] = var0;
      field16899 = field16899 + 1 & 7;
   }

   private TextureSetupHooks() {
   }
}
