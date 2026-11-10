// Original binary: sg/mx/p1i1TQEwaF8PbabO
package sg.mx;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(targets = "net.minecraft.world.item.ItemCooldowns$CooldownInstance")
public interface ItemCooldowns$CooldownInstanceMixin {
   @Accessor("startTime")
   int getStartTick();

   @Accessor("endTime")
   int getEndTick();
}
