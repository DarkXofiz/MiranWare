// Original binary: sg/ec/gKPzWSRzgJrqUcwx
package sg.ec;

import net.minecraft.resources.Identifier;
import net.minecraft.sounds.SoundEvent;

// $VF: Compiled from s
public class ItemAnimationSoundPlayer implements MinecraftAccess {
   public static void method08452(String var0, float var1) {
      if (mc.player != null) {
         mc.player.playSound(SoundEvent.createVariableRangeEvent(Identifier.parse(var0)), var1, 1.0F);
      }
   }
}
