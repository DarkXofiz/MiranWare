// Original binary: sg/ec/Ci3AfCeiqR04wPkS
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
record MeshGuiRenderState(
   Matrix3x2f pose,
   RenderPipeline pipeline,
   float[] data,
   boolean extended,
   float field06831,
   float field06832,
   float scale,
   int tint,
   float time,
   Identifier texture,
   int sampler,
   ScreenRectangle clip
) implements GuiElementRenderState {
   private static final Vector2f POINT = new Vector2f();

   @Override
   public ScreenRectangle bounds() {
      float var1 = Math.abs(this.scale) * 64.0F;
      this.pose.transformPosition(this.field06831 - var1, this.field06832 - var1, POINT);
      return new ScreenRectangle((int)Math.floor(POINT.x), (int)Math.floor(POINT.y), (int)Math.ceil(var1 * 2.0F), (int)Math.ceil(var1 * 2.0F));
   }

   @Override
   public TextureSetup textureSetup() {
      return ScriptRenderResources.method08791(this.texture, this.sampler);
   }

   @Override
   public void buildVertices(VertexConsumer var1) {
      int var2 = MeshBufferUtils.method07837(this.data);
      int var3 = Math.round(this.scale * 8.0F);

      for (int var4 = 0; var4 < var2; var4++) {
         int var5 = var4 * 11;
         this.pose.transformPosition(this.field06831 + this.data[var5] * this.scale, this.field06832 + this.data[var5 + 1] * this.scale, POINT);
         var1.addVertex(POINT.x, POINT.y, 0.0F)
            .setColor(MeshBufferUtils.method07836(Float.floatToRawIntBits(this.data[var5 + 3]), this.tint))
            .setUv(this.data[var5 + 4], this.data[var5 + 5])
            .setUv1(this.extended ? Math.round(this.data[var5 + 6]) : var3, this.extended ? Math.round(this.data[var5 + 7]) : 0)
            .setUv2(this.extended ? Math.round(this.data[var5 + 8]) : 0, this.extended ? Math.round(this.data[var5 + 9]) : 0)
            .setLineWidth(this.extended ? this.data[var5 + 10] : this.time);
      }
   }

   @Override
   public ScreenRectangle scissorArea() {
      return this.clip;
   }
}
