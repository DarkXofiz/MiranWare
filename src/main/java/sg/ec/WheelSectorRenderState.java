package sg.ec;

import java.util.List;
import net.minecraft.client.gui.navigation.ScreenRectangle;
import org.joml.Matrix3x2f;
import org.jspecify.annotations.Nullable;

// TODO(port 1.21.11): ExtendedGuiRenderState / RenderPipeline bagi 26.x'e ozel, yeni GUI render hattinda yeniden yazilacak.
public record WheelSectorRenderState(
   List<WheelSectorRenderState.Nested280> vertices,
   float field22669,
   float field22670,
   float width,
   float height,
   ScreenRectangle scissorArea,
   Matrix3x2f matrix3x2f
) {
   public @Nullable ScreenRectangle bounds() {
      return GuiRectangleUtils.method08621(
         this.field22669, this.field22670, this.field22669 + this.width, this.field22670 + this.height, this.matrix3x2f, this.scissorArea
      );
   }

   public record Nested280(float field22671, float field22672, int color) {
   }
}
