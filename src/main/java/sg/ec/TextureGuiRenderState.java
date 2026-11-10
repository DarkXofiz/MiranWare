// Original binary: sg/ec/LJWUklDKiBBwDiA3
package sg.ec;

import com.mojang.renderpearl.api.pipeline.RenderPipeline;
import com.mojang.blaze3d.vertex.VertexConsumer;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import net.minecraft.client.gui.render.TextureSetup;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import net.minecraft.client.renderer.texture.AbstractTexture;
import net.minecraft.resources.Identifier;
import org.joml.Matrix3x2f;
import org.jspecify.annotations.Nullable;

// $VF: Compiled from s
public record TextureGuiRenderState(
   Identifier texture,
   float field09890,
   float field09891,
   float texWidth,
   float texHeight,
   float field09892,
   float field09893,
   float width,
   float height,
   CornerRadii radius,
   float smoothness,
   CornerColors color,
   ScreenRectangle scissorArea,
   Matrix3x2f matrix
) implements GuiElementRenderState {
   @Override
   public RenderPipeline pipeline() {
      return ScriptDrawCommandDispatcher.field21437;
   }

   @Override
   public TextureSetup textureSetup() {
      AbstractTexture var1 = MinecraftAccess.mc.getTextureManager().getTexture(this.texture);
      return TextureSetup.singleTexture(var1.getTextureView(), var1.getSampler());
   }

   @Override
   public void buildVertices(VertexConsumer var1) {
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(this.matrix, this.field09892, this.field09893)
            .setUv(this.field09890, this.field09891)
            .setColor(this.color.color1()))
         .size(this.width, this.height)
         .radius(this.radius.radius1(), this.radius.radius2(), this.radius.radius3(), this.radius.radius4())
         .smooth(this.smoothness)
         .coord(0.0F, 0.0F);
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(this.matrix, this.field09892, this.field09893 + this.height)
            .setUv(this.field09890, this.field09891 + this.texHeight)
            .setColor(this.color.color2()))
         .size(this.width, this.height)
         .radius(this.radius.radius1(), this.radius.radius2(), this.radius.radius3(), this.radius.radius4())
         .smooth(this.smoothness)
         .coord(0.0F, 1.0F);
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(this.matrix, this.field09892 + this.width, this.field09893 + this.height)
            .setUv(this.field09890 + this.texWidth, this.field09891 + this.texHeight)
            .setColor(this.color.color3()))
         .size(this.width, this.height)
         .radius(this.radius.radius1(), this.radius.radius2(), this.radius.radius3(), this.radius.radius4())
         .smooth(this.smoothness)
         .coord(1.0F, 1.0F);
      ((ExtendedVertexConsumer)var1.addVertexWith2DPose(this.matrix, this.field09892 + this.width, this.field09893)
            .setUv(this.field09890 + this.texWidth, this.field09891)
            .setColor(this.color.color4()))
         .size(this.width, this.height)
         .radius(this.radius.radius1(), this.radius.radius2(), this.radius.radius3(), this.radius.radius4())
         .smooth(this.smoothness)
         .coord(1.0F, 0.0F);
   }

   @Override
   public @Nullable ScreenRectangle bounds() {
      return GuiRectangleUtils.method08621(this.field09892, this.field09893, this.width, this.height, this.matrix, this.scissorArea);
   }
}
