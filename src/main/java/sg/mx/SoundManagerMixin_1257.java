// Original binary: sg/mx/g8J99yUF2O4WTap3
package sg.mx;

import net.minecraft.client.sounds.SoundEngine;
import net.minecraft.client.sounds.SoundManager;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(SoundManager.class)
public interface SoundManagerMixin_1257 {
   @Accessor("soundEngine")
   SoundEngine getSoundSystem();
}
