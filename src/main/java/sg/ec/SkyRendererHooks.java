// Original binary: sg/ec/mRH1aogV5OMxmUWI
package sg.ec;

import com.mojang.renderpearl.api.commands.CommandEncoder;
import com.mojang.renderpearl.api.commands.RenderPass;
import com.mojang.renderpearl.api.textures.GpuTextureView;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.function.Supplier;
import org.joml.Vector4fc;

// $VF: Compiled from s
public final class SkyRendererHooks {
   private static final GuiGpuRenderer field21534 = new GuiGpuRenderer();

   private SkyRendererHooks() {
   }

   public static RenderPass method09491(
      CommandEncoder var0, Supplier<String> var1, GpuTextureView var2, Optional<Vector4fc> var3, GpuTextureView var4, OptionalDouble var5
   ) {
      return field21534.method00369(var0, var1, var2, var3, var4, var5);
   }

   public static void method09492() {
      field21534.method00367();
   }

   public static void method09493(RenderPass var0) {
      field21534.method00370(var0);
   }

   public static void method09494() {
      field21534.method00366();
   }
}
