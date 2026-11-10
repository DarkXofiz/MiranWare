// Original binary: sg/ec/rbsUK9TviU27nC9w
package sg.ec;

import net.minecraft.world.entity.LivingEntity;

// $VF: Compiled from s
public class ElytraMotyaon extends ClientModule {
   private final NumberSetting<Float> field23379;
   private final ToggleSetting field23380;
   private final ToggleSetting field23381;
   private final NumberSetting<Float> field23382;
   private final ElapsedTimer field23383;
   private boolean field23384;
   private static final String field23385 = "Дистанция";
   private static final float field23386 = 3.0F;
   private static final float field23387 = 0.1F;
   private static final float field23388 = 1.5F;
   private static final String field23389 = "Улучшить фриз";
   private static final String field23390 = "Авто фейерверк";
   private static final String field23391 = "Сила замедления";
   private static final float field23392 = 0.3F;
   private static final float field23393 = 0.01F;
   private static final String field23394 = "Elytra Motyaon";
   private static final long field23395 = 1000L;

   private boolean method10426(LivingEntity var1) {
      return RaycastUtils.method09502(mc.player.getYRot(), mc.player.getXRot(), ModuleManager.INSTANCE.method08219().method00403(), var1);
   }

   public boolean method10427() {
      return this.field23384;
   }

   @Subscribe
   private void method10428(EntityMoveEvent var1) {
      if (mc.player != null && mc.level != null) {
         this.method10430(false);
         LivingEntity var2 = AttackAura.method00456();
         float var3 = this.field23382.method03022();
         boolean var4 = var2 != null
            && mc.player.isFallFlying()
            && ((EntityExtensionAccess)mc.player).getDistanceEyePos(var2) < this.field23379.method03022().floatValue()
            && !ModuleManager.INSTANCE.method08219().field00787;
         if (this.field23380.method05999()) {
            var3 = 0.0F;
            var4 = var4 && this.method10426(var2);
            PlayerVelocityTracker.INSTANCE.method02571(var4);
         }

         if (var4) {
            if (this.field23383.method04699(field23395) && this.field23381.method05999()) {
               InventoryUtils.method06119();
               this.field23383.method04694();
            }

            this.method10430(true);
            var1.method10060(var1.method10059().scale(var3));
         }
      }
   }

   public void method10430(boolean var1) {
      this.field23384 = var1;
   }

   @Override
   public void method00382() {
      this.method10430(false);
      super.method00382();
   }

   public ElytraMotyaon() {
      super(ModuleCategory.Movement, ModuleSubCategory.Main);
      this.field23379 = new NumberSetting<Float>(field23385)
         .method10835(1.0F)
         .method10838(field23386)
         .method10834(field23387)
         .method03017(field23388)
         .method03023(this);
      this.field23380 = new ToggleSetting(field23389).method03017(false).method03023(this);
      this.field23381 = new ToggleSetting(field23390).method03014(true).method03025(() -> !this.field23380.method05999()).method03023(this);
      this.field23382 = new NumberSetting<Float>(field23391)
         .method10835(0.0F)
         .method10838(field23392)
         .method10834(field23393)
         .method03017(0.0F)
         .method03025(() -> !this.field23380.method05999())
         .method03023(this);
      this.field23383 = new ElapsedTimer();
      this.field23384 = false;
      this.method03935(field23394);
   }

   @Override
   public void method00245() {
      PlayerVelocityTracker.INSTANCE.method02571(false);
      super.method00245();
   }
}
