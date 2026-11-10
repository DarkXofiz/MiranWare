// Original binary: sg/ec/XtENSOSAclxFuA5S
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import org.joml.Matrix3x2f;
import org.jspecify.annotations.Nullable;

// $VF: Compiled from s
public record RoundedOutlineRenderState(
   float field14684,
   float field14685,
   float width,
   float height,
   CornerRadii radius,
   float smoothness,
   CornerColors color,
   ScreenRectangle scissorArea,
   Matrix3x2f matrix3x2f
) implements ExtendedGuiRenderState {
   @Override
   public RenderPipeline pipeline() {
      return ScriptDrawCommandDispatcher.field21436;
   }

   @Override
   public void buildVertices(VertexConsumer var1) {
      RoundedRectMeshBuilder.method11743(
         var1,
         this.matrix3x2f,
         this.field14684,
         this.field14685,
         this.width,
         this.height,
         this.color.color1(),
         this.color.color2(),
         this.color.color3(),
         this.color.color4(),
         this.radius.radius1(),
         this.radius.radius2(),
         this.radius.radius3(),
         this.radius.radius4(),
         this.smoothness
      );
   }

   @Override
   public @Nullable ScreenRectangle bounds() {
      return GuiRectangleUtils.method08621(this.field14684, this.field14685, this.width, this.height, this.matrix3x2f, this.scissorArea);
   }
}
