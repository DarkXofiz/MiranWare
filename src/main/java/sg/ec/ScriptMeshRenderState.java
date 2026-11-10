// Original binary: sg/ec/LRpM61BzZXZU3BTR
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;

// $VF: Compiled from s
record ScriptMeshRenderState(TextureGuiRenderState quad, int sampler) implements GuiElementRenderState {
   @Override
   public void buildVertices(VertexConsumer var1) {
      this.quad.buildVertices(var1);
   }

   @Override
   public ScreenRectangle bounds() {
      return this.quad.bounds();
   }

   @Override
   public TextureSetup textureSetup() {
      return ScriptRenderResources.method08791(this.quad.texture(), this.sampler);
   }

   @Override
   public ScreenRectangle scissorArea() {
      return this.quad.scissorArea();
   }

   @Override
   public RenderPipeline pipeline() {
      return this.quad.pipeline();
   }
}
