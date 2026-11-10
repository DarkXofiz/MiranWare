// Original binary: sg/ec/uciloqA2zL7uocyT
package sg.ec;

import it.unimi.dsi.fastutil.ints.Int2ObjectLinkedOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectMap;
import net.minecraft.client.Minecraft;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public final class EntityTickListHooks {
   private EntityTickListHooks() {
   }

   public static void method10963(Int2ObjectMap<Entity> var0) {
      LocalPlayer var1 = Minecraft.getInstance().player;
      if (var1 != null) {
         if (var0 instanceof Int2ObjectLinkedOpenHashMap var2) {
            if (var0.get(var1.getId()) == var1) {
               var2.getAndMoveToLast(var1.getId());
            }
         }
      }
   }
}
