// Original binary: sg/ec/JNphsBz2kXV9M0BY
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import org.joml.Matrix3x2f;
import org.jspecify.annotations.Nullable;

// $VF: Compiled from s
public record RoundedRectRenderState(
   float field08873,
   float field08874,
   float width,
   float height,
   CornerRadii radius,
   float smoothnessStart,
   float smoothnessEnd,
   CornerColors color,
   ScreenRectangle scissorArea,
   Matrix3x2f matrix3x2f
) implements ExtendedGuiRenderState {
   @Override
   public RenderPipeline pipeline() {
      return ScriptDrawCommandDispatcher.field21438;
   }

   @Override
   public @Nullable ScreenRectangle bounds() {
      return GuiRectangleUtils.method08621(this.field08873, this.field08874, this.width, this.height, this.matrix3x2f, this.scissorArea);
   }

   @Override
   public void buildVertices(VertexConsumer var1) {
      RoundedRectMeshBuilder.method11742(
         var1,
         this.matrix3x2f,
         this.field08873,
         this.field08874,
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
         0.0F,
         this.smoothnessStart,
         this.smoothnessEnd
      );
   }
}
