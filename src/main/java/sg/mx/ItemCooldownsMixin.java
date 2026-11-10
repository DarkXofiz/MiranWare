// Original binary: sg/mx/Ovn2KZWDHFMm7Ihu
package sg.mx;

import java.util.Map;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemCooldowns;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

// $VF: Compiled from s
@Mixin(ItemCooldowns.class)
public interface ItemCooldownsMixin {
   @Accessor("cooldowns")
   Map<Identifier, Object> entries();

   @Accessor("tickCount")
   int getTicks();
}
