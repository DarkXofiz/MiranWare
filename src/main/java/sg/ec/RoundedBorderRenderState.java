// Original binary: sg/ec/ZlYoaxXlRKipeNZm
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.List;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import org.joml.Matrix3x2f;
import org.jspecify.annotations.Nullable;

// $VF: Compiled from s
public record RoundedBorderRenderState(
   List<RoundedBorderRenderState.Nested202> vertices,
   float field15580,
   float field15581,
   float width,
   float height,
   ScreenRectangle scissorArea,
   Matrix3x2f matrix3x2f
) implements ExtendedGuiRenderState {
   @Override
   public RenderPipeline pipeline() {
      return ScriptDrawCommandDispatcher.field21442;
   }

   @Override
   public @Nullable ScreenRectangle bounds() {
      return GuiRectangleUtils.method08621(
         this.field15580, this.field15581, this.field15580 + this.width, this.field15581 + this.height, this.matrix3x2f, this.scissorArea
      );
   }

   @Override
   public void buildVertices(VertexConsumer var1) {
      for (RoundedBorderRenderState.Nested202 var3 : this.vertices) {
         ((ExtendedVertexConsumer)var1.addVertexWith2DPose(this.matrix3x2f, var3.field15582(), var3.field15583()).setColor(var3.color())).coord(var3.edge(), 0.0F);
      }
   }

   // $VF: Compiled from s
   public record Nested202(float field15582, float field15583, int color, float edge) {
   }
}
