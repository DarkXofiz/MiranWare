// Original binary: sg/ec/ixg1nsZxiFbUBLX6
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import org.joml.Matrix3x2f;
import org.jspecify.annotations.Nullable;

// $VF: Compiled from s
public record ClipGuiRenderState(
   float field20143,
   float field20144,
   float width,
   float height,
   CornerRadii radius,
   float smoothness,
   float blurRadius,
   CornerColors color,
   ScreenRectangle scissorArea,
   Matrix3x2f matrix3x2f
) implements GuiElementRenderState {
   @Override
   public void buildVertices(VertexConsumer var1) {
      Matrix3x2f var2 = this.matrix3x2f;
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(var2, this.field20143, this.field20144).setColor(this.color.color1()))
         .size(this.width, this.height)
         .radius(this.radius.radius1(), this.radius.radius2(), this.radius.radius3(), this.radius.radius4())
         .smooth(this.smoothness)
         .range(this.blurRadius)
         .coord(0.0F, 0.0F);
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(var2, this.field20143, this.field20144 + this.height).setColor(this.color.color2()))
         .size(this.width, this.height)
         .radius(this.radius.radius1(), this.radius.radius2(), this.radius.radius3(), this.radius.radius4())
         .smooth(this.smoothness)
         .range(this.blurRadius)
         .coord(0.0F, 1.0F);
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(var2, this.field20143 + this.width, this.field20144 + this.height).setColor(this.color.color3()))
         .size(this.width, this.height)
         .radius(this.radius.radius1(), this.radius.radius2(), this.radius.radius3(), this.radius.radius4())
         .smooth(this.smoothness)
         .range(this.blurRadius)
         .coord(1.0F, 1.0F);
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(var2, this.field20143 + this.width, this.field20144).setColor(this.color.color4()))
         .size(this.width, this.height)
         .radius(this.radius.radius1(), this.radius.radius2(), this.radius.radius3(), this.radius.radius4())
         .smooth(this.smoothness)
         .range(this.blurRadius)
         .coord(1.0F, 0.0F);
   }

   @Override
   public TextureSetup textureSetup() {
      return TextureSetup.doubleTexture(
         GuiBlurRenderer.method11250(), GuiBlurRenderer.method11249(), GuiBlurRenderer.method11254(), GuiBlurRenderer.method11249()
      );
   }

   @Override
   public @Nullable ScreenRectangle bounds() {
      return GuiRectangleUtils.method08621(this.field20143, this.field20144, this.width, this.height, this.matrix3x2f, this.scissorArea);
   }

   @Override
   public RenderPipeline pipeline() {
      return ScriptDrawCommandDispatcher.field21440;
   }
}
