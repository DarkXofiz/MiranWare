// Original binary: sg/mx/zpeMinw1SUb1NvDA
package sg.mx;

import net.minecraft.client.gui.Hud;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(Hud.class)
public interface HudMixin_1316 {
   @Invoker("getCameraPlayer")
   Player IgetCameraPlayer();

   @Accessor("HOTBAR_ATTACK_INDICATOR_BACKGROUND_SPRITE")
   static Identifier HOTBAR_ATTACK_INDICATOR_BACKGROUND_TEXTURE() {
      throw new AssertionError();
   }

   @Accessor("HOTBAR_ATTACK_INDICATOR_PROGRESS_SPRITE")
   static Identifier HOTBAR_ATTACK_INDICATOR_PROGRESS_TEXTURE() {
      throw new AssertionError();
   }

   @Accessor("overlayMessageString")
   Component overlayMessage();
}
