// Original binary: sg/ec/7CsRWDC2CQ3unAcB
package sg.ec;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.AbstractThrownPotion;
import net.minecraft.world.level.Level;

// $VF: Compiled from s
public class SplashPotionEffectsEvent extends Event {
   public static final SplashPotionEffectsEvent field03977 = new SplashPotionEffectsEvent();
   private Level field03978;
   private Iterable<MobEffectInstance> field03979;
   private AbstractThrownPotion field03980;
   private Entity field03981;
   private double field03982 = 1.0;

   public void method01636(AbstractThrownPotion var1) {
      this.field03980 = var1;
   }

   public void method01637(double var1) {
      this.field03982 = var1;
   }

   public void method01638(Entity var1) {
      this.field03981 = var1;
   }

   public void method01639(Iterable<MobEffectInstance> var1) {
      this.field03979 = var1;
   }

   public Level method01640() {
      return this.field03978;
   }

   public AbstractThrownPotion method01641() {
      return this.field03980;
   }

   public Entity method01642() {
      return this.field03981;
   }

   public void method01643(Level var1, Iterable<MobEffectInstance> var2, AbstractThrownPotion var3, Entity var4, double var5) {
      this.field03978 = var1;
      this.field03979 = var2;
      this.field03980 = var3;
      this.field03981 = var4;
      this.field03982 = var5;
      super.method03208();
   }

   public double method01644() {
      return this.field03982;
   }

   public void method01645(Level var1) {
      this.field03978 = var1;
   }

   public Iterable<MobEffectInstance> method01646() {
      return this.field03979;
   }
}
