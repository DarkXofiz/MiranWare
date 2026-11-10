// Original binary: sg/mx/UjNXPqWoz7FRAYL0
package sg.mx;

import net.minecraft.client.renderer.state.gui.GuiItemRenderState;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.CustomAlphaAccess;

// $VF: Compiled from s
@Mixin(GuiItemRenderState.class)
public abstract class GuiItemRenderStateMixin implements CustomAlphaAccess {
   @Unique
   private boolean customAlphaSet;
   @Unique
   private float customAlpha;

   @Override
   public float getCustomAlpha() {
      return this.customAlphaSet ? this.customAlpha : 1.0F;
   }

   @Override
   public void setCustomAlpha(float var1) {
      this.customAlpha = var1;
      this.customAlphaSet = true;
   }
}
