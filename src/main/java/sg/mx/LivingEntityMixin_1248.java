// Original binary: sg/mx/duXglozpg9Nlv4wH
package sg.mx;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;
import org.spongepowered.asm.mixin.gen.Invoker;

// $VF: Compiled from s
@Mixin(LivingEntity.class)
public interface LivingEntityMixin_1248 {
   @Accessor("fallFlyTicks")
   int glidingtick();

   @Accessor("attackStrengthTicker")
   int getAttackStrengthTicker();

   @Accessor("noJumpDelay")
   int getJumpDelay();

   @Accessor("jumping")
   boolean isJumping_();

   @Invoker("getEffectiveGravity")
   double IgetEffectiveGravity();

   @Accessor("noJumpDelay")
   void setjumpingCooldown(int var1);

   @Accessor("useItem")
   ItemStack activeItemStack();
}
