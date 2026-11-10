// Original binary: sg/ec/p6FWcqoY90XAriul
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import java.util.List;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import org.joml.Matrix3x2f;
import org.jspecify.annotations.Nullable;

// $VF: Compiled from s
public record WheelSectorRenderState(
   List<WheelSectorRenderState.Nested280> vertices,
   float field22669,
   float field22670,
   float width,
   float height,
   ScreenRectangle scissorArea,
   Matrix3x2f matrix3x2f
) implements ExtendedGuiRenderState {
   @Override
   public RenderPipeline pipeline() {
      return ScriptDrawCommandDispatcher.field21441;
   }

   @Override
   public void buildVertices(VertexConsumer var1) {
      for (WheelSectorRenderState.Nested280 var3 : this.vertices) {
         var1.addVertexWith2DPose(this.matrix3x2f, var3.field22671(), var3.field22672()).setColor(var3.color());
      }
   }

   @Override
   public @Nullable ScreenRectangle bounds() {
      return GuiRectangleUtils.method08621(
         this.field22669, this.field22670, this.field22669 + this.width, this.field22670 + this.height, this.matrix3x2f, this.scissorArea
      );
   }

   // $VF: Compiled from s
   public record Nested280(float field22671, float field22672, int color) {
   }
}
