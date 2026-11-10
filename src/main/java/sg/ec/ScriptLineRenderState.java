// Original binary: sg/ec/TPw4cxK8GSlCTFiv
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import net.minecraft.resources.Identifier;
import org.joml.Matrix3x2f;
import org.joml.Vector2f;

// $VF: Compiled from s
record ScriptLineRenderState(
   Matrix3x2f pose,
   RenderPipeline pipeline,
   float field12011,
   float field12012,
   float width,
   float height,
   float field12013,
   float field12014,
   float uWidth,
   float vHeight,
   int color1,
   int color2,
   int color3,
   int color4,
   int uv1x,
   int uv1y,
   int uv2x,
   int uv2y,
   float lineWidth,
   Identifier texture,
   int sampler,
   ScreenRectangle clip
) implements GuiElementRenderState {
   private static final Vector2f POINT = new Vector2f();
   private static final Vector2f EDGE = new Vector2f();

   @Override
   public ScreenRectangle bounds() {
      this.pose.transformPosition(this.field12011, this.field12012, POINT);
      this.pose.transformPosition(this.field12011 + this.width, this.field12012 + this.height, EDGE);
      return new ScreenRectangle((int)Math.floor(POINT.x), (int)Math.floor(POINT.y), (int)Math.ceil(EDGE.x - POINT.x), (int)Math.ceil(EDGE.y - POINT.y));
   }

   @Override
   public void buildVertices(VertexConsumer var1) {
      this.corner(var1, 0.0F, 0.0F, this.color1);
      this.corner(var1, 0.0F, 1.0F, this.color2);
      this.corner(var1, 1.0F, 1.0F, this.color3);
      this.corner(var1, 1.0F, 0.0F, this.color4);
   }

   @Override
   public ScreenRectangle scissorArea() {
      return this.clip;
   }

   @Override
   public TextureSetup textureSetup() {
      return ScriptRenderResources.method08791(this.texture, this.sampler);
   }

   private void corner(VertexConsumer var1, float var2, float var3, int var4) {
      this.pose.transformPosition(this.field12011 + this.width * var2, this.field12012 + this.height * var3, POINT);
      var1.addVertex(POINT.x, POINT.y, 0.0F)
         .setColor(var4)
         .setUv(this.field12013 + this.uWidth * var2, this.field12014 + this.vHeight * var3)
         .setUv1(this.uv1x, this.uv1y)
         .setUv2(this.uv2x, this.uv2y)
         .setLineWidth(this.lineWidth);
   }
}
