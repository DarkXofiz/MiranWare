// Original binary: sg/mx/D8XuFphvj7MJOs7x
package sg.mx;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.Entity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.EntityNameTagCacheAccess;

// $VF: Compiled from s
@Mixin(Entity.class)
public class EntityMixin_1148 implements EntityNameTagCacheAccess {
   @Unique
   private Component hex$name;
   @Unique
   private long hex$stamp;

   @Override
   public Component hex$nameTag() {
      return this.hex$name;
   }

   @Override
   public long hex$nameTagStamp() {
      return this.hex$stamp;
   }

   @Override
   public void hex$nameTag(Component var1, long var2) {
      this.hex$name = var1;
      this.hex$stamp = var2;
   }
}
