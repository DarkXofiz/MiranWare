// Original binary: sg/ec/CFpi9ajE3gAAUoya
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.LivingEntity;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

// $VF: Compiled from s
public class EntityCollisionPolicyEvent extends Event {
   public static final EntityCollisionPolicyEvent field06700 = new EntityCollisionPolicyEvent();
   private EntityCollisionPolicyEvent.Nested73 field06701;

   public EntityCollisionPolicyEvent.Nested73 method02897() {
      return this.field06701;
   }

   public void method02898(LivingEntity var1, EntityCollisionPolicyEvent.Nested73 var2, CallbackInfoReturnable<Boolean> var3) {
      if (var1 instanceof LocalPlayer) {
         if (this.method02901(var2)) {
            var3.setReturnValue(false);
         }
      }
   }

   public void method02899(EntityCollisionPolicyEvent.Nested73 var1, CallbackInfoReturnable<Boolean> var2) {
      if (this.method02901(var1)) {
         var2.setReturnValue(false);
      }
   }

   public void method02900(EntityCollisionPolicyEvent.Nested73 var1) {
      this.field06701 = var1;
   }

   public boolean method02901(EntityCollisionPolicyEvent.Nested73 var1) {
      this.field06701 = var1;
      super.method03208();
      return this.method05694();
   }

   // $VF: Compiled from s
   public enum Nested73 {
      BLOCK,
      WATER,
      PLAYER,
      LIANA;
   }
}
