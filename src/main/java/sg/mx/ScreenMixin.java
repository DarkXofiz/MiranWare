// Original binary: sg/mx/J89z9bB5XxN79Ugf
package sg.mx;

import net.minecraft.client.gui.components.Renderable;
import net.minecraft.client.gui.components.events.GuiEventListener;
import net.minecraft.client.gui.narration.NarratableEntry;
import net.minecraft.client.gui.screens.Screen;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(Screen.class)
public interface ScreenMixin {
   @Invoker("addRenderableWidget")
   <T extends GuiEventListener & Renderable & NarratableEntry> T IaddDrawableChild(T var1);
}
