// Original binary: sg/mx/YJsoqhElBg3TAYZF
package sg.mx;

import net.minecraft.client.sounds.SoundEngine;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(SoundEngine.class)
public interface SoundEngineMixin {
   @Accessor("loaded")
   boolean isStarted();
}
