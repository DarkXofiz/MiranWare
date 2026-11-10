// Original binary: sg/ec/dldyNCE8JsQbnG1e
package sg.ec;

import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class ViewModel extends ClientModule {
   private final NumberSetting<Float> field18353;
   private final NumberSetting<Float> field18354;
   private final NumberSetting<Float> field18355;
   private final NumberSetting<Float> field18356;
   private final NumberSetting<Float> field18357;
   private final NumberSetting<Float> field18358;
   private final ModeSetting field18359;
   private boolean field18360;
   private static final String field18361 = "Правая X";
   private static final float field18362 = -3.0F;
   private static final float field18363 = 3.0F;
   private static final float field18364 = 0.01F;
   private static final String field18365 = "Правая Y";
   private static final float field18366 = -3.0F;
   private static final float field18367 = 3.0F;
   private static final float field18368 = 0.01F;
   private static final String field18369 = "Правая Z";
   private static final float field18370 = -3.0F;
   private static final float field18371 = 3.0F;
   private static final float field18372 = 0.01F;
   private static final String field18373 = "Левая X";
   private static final float field18374 = -3.0F;
   private static final float field18375 = 3.0F;
   private static final float field18376 = 0.01F;
   private static final String field18377 = "Левая Y";
   private static final float field18378 = -3.0F;
   private static final float field18379 = 3.0F;
   private static final float field18380 = 0.01F;
   private static final String field18381 = "Левая Z";
   private static final float field18382 = -3.0F;
   private static final float field18383 = 3.0F;
   private static final float field18384 = 0.01F;
   private static final String field18385 = "Работать";
   private static final String field18386 = "С аурой";
   private static final String field18387 = "При взмахе";
   private static final String field18388 = "Всегда";
   private static final String field18389 = "Всегда";
   private static final String field18390 = "View Model";
   private static final String field18391 = "Всегда";
   private static final String field18392 = "При взмахе";
   private static final String field18393 = "С аурой";

   @Subscribe
   private void method07504(TickEvent var1) {
      this.field18360 = this.method07506();
   }

   @Subscribe
   private void method07505(ViewModelOffsetEvent var1) {
      if (!this.field18360) {
         var1.method04139(
            new Vec3(this.field18353.method03022().floatValue(), this.field18354.method03022().floatValue(), this.field18355.method03022().floatValue())
         );
         var1.method04140(
            new Vec3(this.field18356.method03022().floatValue(), this.field18357.method03022().floatValue(), this.field18358.method03022().floatValue())
         );
         var1.method05695(true);
      }
   }

   public boolean method07506() {
      if (this.field18359.method05600(field18391)) {
         return false;
      } else if (!this.method03937()) {
         return true;
      } else if (!this.field18359.method05600(field18392)) {
         return !this.field18359.method05600(field18393) ? false : AttackAura.method00456() == null;
      } else {
         return mc.player == null || !mc.player.swinging;
      }
   }

   public ViewModel() {
      super(ModuleCategory.Render, ModuleSubCategory.Interface);
      this.field18353 = new NumberSetting<Float>(field18361)
         .method10835(field18362)
         .method10838(field18363)
         .method10834(field18364)
         .method03017(0.0F)
         .method03023(this);
      this.field18354 = new NumberSetting<Float>(field18365)
         .method10835(field18366)
         .method10838(field18367)
         .method10834(field18368)
         .method03017(0.0F)
         .method03023(this);
      this.field18355 = new NumberSetting<Float>(field18369)
         .method10835(field18370)
         .method10838(field18371)
         .method10834(field18372)
         .method03017(0.0F)
         .method03023(this);
      this.field18356 = new NumberSetting<Float>(field18373)
         .method10835(field18374)
         .method10838(field18375)
         .method10834(field18376)
         .method03017(0.0F)
         .method03023(this);
      this.field18357 = new NumberSetting<Float>(field18377)
         .method10835(field18378)
         .method10838(field18379)
         .method10834(field18380)
         .method03017(0.0F)
         .method03023(this);
      this.field18358 = new NumberSetting<Float>(field18381)
         .method10835(field18382)
         .method10838(field18383)
         .method10834(field18384)
         .method03017(0.0F)
         .method03023(this);
      this.field18359 = new ModeSetting(field18385).method05597(field18386, field18387, field18388).method03017(field18389).method03023(this);
      this.method03935(field18390);
   }
}
