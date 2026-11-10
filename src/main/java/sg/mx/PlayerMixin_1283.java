// Original binary: sg/mx/mJjAB32MuHdiFJC3
package sg.mx;

import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(Player.class)
public interface PlayerMixin_1283 {
   @Invoker("isEquipped")
   boolean isEquip(Item var1);
}
