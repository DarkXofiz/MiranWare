// Original binary: sg/mx/b3okyGgqqnIWDuF6
package sg.mx;

import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import net.minecraft.client.renderer.state.gui.GuiItemRenderState;
import net.minecraft.client.renderer.state.gui.GuiRenderState.Node;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import sg.ec.GuiNodeClipHooks;
import sg.ec.GuiNodeAccess;

// $VF: Compiled from s
@Mixin(targets = "net.minecraft.client.renderer.state.gui.GuiRenderState$Node")
public abstract class GuiRenderState$NodeMixin_1242 implements GuiNodeAccess {
   @Shadow
   @Final
   public Node parent;

   @Shadow
   public abstract void addGuiElement(GuiElementRenderState var1);

   @Shadow
   public abstract void addItem(GuiItemRenderState var1);

   @Override
   public Object getParentLayer() {
      return this.parent;
   }

   @Override
   public void IaddSimpleElement(GuiElementRenderState var1) {
      GuiNodeClipHooks.method11203((Node)(Object)this, var1);
   }

   @Override
   public void IaddItem(GuiItemRenderState var1) {
      this.addItem(var1);
   }
}
