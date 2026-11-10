// Original binary: sg/ec/hvyjaiKEIck3xONh
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import org.joml.Matrix3x2f;
import org.jspecify.annotations.Nullable;

// $VF: Compiled from s
public record GuiShadowRenderState(
   float field19961,
   float field19962,
   float width,
   float height,
   CornerRadii radius,
   float strength,
   float spread,
   CornerColors color,
   ScreenRectangle scissorArea,
   Matrix3x2f matrix3x2f
) implements ExtendedGuiRenderState {
   private static final float PAD = 2.0F;

   @Override
   public void buildVertices(VertexConsumer var1) {
      float var2 = this.spread + 2.0F;
      float sx = this.field19961 - var2;
      float sxx = this.field19962 - var2;
      float sxxx = this.field19961 + this.width + var2;
      float sxxxx = this.field19962 + this.height + var2;
      float sxxxxx = this.width * 0.5F + var2;
      float sxxxxxx = this.height * 0.5F + var2;
      float sxxxxxxx = this.radius.radius1();
      float sxxxxxxxx = this.radius.radius2();
      float sxxxxxxxxx = this.radius.radius3();
      float sxxxxxxxxxx = this.radius.radius4();
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(this.matrix3x2f, sx, sxx).setColor(this.color.color1()))
         .size(this.width, this.height)
         .radius(sxxxxxxx, sxxxxxxxx, sxxxxxxxxx, sxxxxxxxxxx)
         .smooth(this.strength)
         .range(this.spread)
         .coord(sxxxxx, sxxxxxx);
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(this.matrix3x2f, sx, sxxxx).setColor(this.color.color2()))
         .size(this.width, this.height)
         .radius(sxxxxxxx, sxxxxxxxx, sxxxxxxxxx, sxxxxxxxxxx)
         .smooth(this.strength)
         .range(this.spread)
         .coord(sxxxxx, -sxxxxxx);
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(this.matrix3x2f, sxxx, sxxxx).setColor(this.color.color3()))
         .size(this.width, this.height)
         .radius(sxxxxxxx, sxxxxxxxx, sxxxxxxxxx, sxxxxxxxxxx)
         .smooth(this.strength)
         .range(this.spread)
         .coord(-sxxxxx, -sxxxxxx);
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(this.matrix3x2f, sxxx, sxx).setColor(this.color.color4()))
         .size(this.width, this.height)
         .radius(sxxxxxxx, sxxxxxxxx, sxxxxxxxxx, sxxxxxxxxxx)
         .smooth(this.strength)
         .range(this.spread)
         .coord(-sxxxxx, sxxxxxx);
   }

   @Override
   public RenderPipeline pipeline() {
      return ScriptDrawCommandDispatcher.field21443;
   }

   @Override
   public @Nullable ScreenRectangle bounds() {
      float var1 = this.spread + 2.0F;
      return GuiRectangleUtils.method08621(
         this.field19961 - var1, this.field19962 - var1, this.width + var1 * 2.0F, this.height + var1 * 2.0F, this.matrix3x2f, this.scissorArea
      );
   }
}
