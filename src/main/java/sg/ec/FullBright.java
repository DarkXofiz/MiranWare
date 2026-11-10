// Original binary: sg/ec/c4Gu2aNTDEk2sQCm
package sg.ec;

import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import org.joml.Vector3f;

// $VF: Compiled from s
public class FullBright extends ClientModule {
   private static final String field17625 = "Яркость игры";
   private static final String field17626 = "field17626";
   private final ModeSetting field17627;
   private final NumberSetting<Float> field17628;
   private final ToggleSetting field17629;
   private static final String field17630 = "Режим";
   private static final String field17631 = "Яркость игры";
   private static final String field17632 = "Зелье";
   private static final String field17633 = "Яркость игры";
   private static final String field17634 = "Яркость";
   private static final float field17635 = 10.0F;
   private static final float field17636 = 0.1F;
   private static final float field17637 = 5.0F;
   private static final String field17638 = "Убрать цвет тумана";
   private static final String field17639 = "Full Bright";
   private static final String field17640 = "Зелье";
   private static final String field17641 = "Яркость игры";
   private static final float field17642 = 10.0F;
   private static final String field17643 = "Зелье";
   private static final String field17644 = "Зелье";
   private static final String field17645 = "Яркость игры";

   @Subscribe
   private void method07229(VisualRemovalEvent var1) {
      if (var1.method08694() == VisualRemovalEvent.Nested242.NIGHT_VISION_FOG && this.field17627.method05600(field17643) && this.field17629.method05999()) {
         var1.method05695(true);
      }
   }

   public FullBright() {
      super(ModuleCategory.Render, ModuleSubCategory.Other);
      this.field17627 = new ModeSetting(field17630).method05597(field17631, field17632).method03017(field17633).method03023(this);
      this.field17628 = new NumberSetting<Float>(field17634)
         .method10835(1.0F)
         .method10838(field17635)
         .method10834(field17636)
         .method03017(field17637)
         .method03025(() -> this.field17627.method05600(field17645))
         .method03023(this);
      this.field17629 = new ToggleSetting(field17638).method03017(false).method03025(() -> this.field17627.method05600(field17644)).method03023(this);
      this.method03935(field17639);
   }

   private void method07230() {
      if (mc.player != null) {
         MobEffectInstance var1 = mc.player.getEffect(MobEffects.NIGHT_VISION);
         if (var1 != null && var1.isInfiniteDuration()) {
            mc.player.removeEffect(MobEffects.NIGHT_VISION);
         }
      }
   }

   @Subscribe
   private void method07231(WorldBrightnessEvent var1) {
      if (this.field17627.method05600(field17641)) {
         float var2 = this.field17628.method03022() / field17642;
         Vector3f var3 = var1.method01301();
         var3.set(Math.max(var3.x, var2), Math.max(var3.y, var2), Math.max(var3.z, var2));
      }
   }

   @Subscribe
   private void method07232(PlayerUpdateEvent var1) {
      if (mc.player != null) {
         if (this.field17627.method05600(field17640)) {
            if (!mc.player.hasEffect(MobEffects.NIGHT_VISION)) {
               mc.player.addEffect(new MobEffectInstance(MobEffects.NIGHT_VISION, -1));
            }
         } else {
            this.method07230();
         }
      }
   }

   @Override
   public void method00245() {
      this.method07230();
      super.method00245();
   }
}
