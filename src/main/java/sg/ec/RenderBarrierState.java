// Original binary: sg/ec/HXDp68XmPnlDNwMh
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import org.jspecify.annotations.Nullable;

// $VF: Compiled from s
public record RenderBarrierState() implements GuiElementRenderState {
   @Override
   public TextureSetup textureSetup() {
      return TextureSetup.noTexture();
   }

   @Override
   public @Nullable ScreenRectangle bounds() {
      return null;
   }

   @Override
   public RenderPipeline pipeline() {
      return ScriptDrawCommandDispatcher.field21440;
   }

   @Override
   public @Nullable ScreenRectangle scissorArea() {
      return null;
   }

   @Override
   public void buildVertices(VertexConsumer var1) {
   }
}
