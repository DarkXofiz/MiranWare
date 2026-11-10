// Original binary: sg/ec/hkQ676mmwkwXI39t
package sg.ec;

import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.LivingEntity;

// $VF: Compiled from s
public class MobEffectEvent extends Event {
   public static final MobEffectEvent field19880 = new MobEffectEvent();
   private MobEffectInstance field19881;
   private MobEffectEvent.Nested241 field19882;

   public MobEffectInstance method08685() {
      return this.field19881;
   }

   public void method08686(MobEffectEvent.Nested241 var1) {
      this.field19882 = var1;
   }

   public void method08687(MobEffectInstance var1) {
      this.field19881 = var1;
   }

   public MobEffectEvent.Nested241 method08688() {
      return this.field19882;
   }

   public void method08689(MobEffectInstance var1, LivingEntity var2) {
      if (var2 instanceof LocalPlayer) {
         this.field19882 = MobEffectEvent.Nested241.ADD;
         this.field19881 = var1;
         super.method03208();
      }
   }

   public void method08690(MobEffectInstance var1, LivingEntity var2) {
      if (var1 != null) {
         if (var2 instanceof LocalPlayer) {
            this.field19882 = MobEffectEvent.Nested241.REMOVE;
            this.field19881 = var1;
            super.method03208();
         }
      }
   }

   // $VF: Compiled from s
   public enum Nested241 {
      ADD,
      REMOVE;
   }
}
