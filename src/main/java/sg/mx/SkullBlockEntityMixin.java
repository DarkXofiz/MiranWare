// Original binary: sg/mx/81mcJ9FnkLkaqXaT
package sg.mx;

import net.minecraft.client.renderer.PlayerSkinRenderCache.RenderInfo;
import net.minecraft.world.item.component.ResolvableProfile;
import net.minecraft.world.level.block.entity.SkullBlockEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.SkullRenderInfoAccess;

// $VF: Compiled from s
@Mixin(SkullBlockEntity.class)
public class SkullBlockEntityMixin implements SkullRenderInfoAccess {
   @Unique
   private ResolvableProfile hex$profile;
   @Unique
   private RenderInfo hex$info;
   @Unique
   private int hex$slot;

   @Override
   public ResolvableProfile hex$skullProfile() {
      return this.hex$profile;
   }

   @Override
   public RenderInfo hex$skullInfo() {
      return this.hex$info;
   }

   @Override
   public void hex$skullInfo(ResolvableProfile var1, RenderInfo var2) {
      this.hex$profile = var1;
      this.hex$info = var2;
   }

   @Override
   public int hex$skullSlot() {
      return this.hex$slot;
   }

   @Override
   public void hex$skullSlot(int var1) {
      this.hex$slot = var1;
   }
}
