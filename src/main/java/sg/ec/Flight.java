// Original binary: sg/ec/txl6thTa6tGHhx0T
package sg.ec;

import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class Flight extends ClientModule {
   private final NumberSetting<Float> field24191;
   private final NumberSetting<Float> field24192;
   private static final String field24193 = "Скорость по XZ";
   private static final float field24194 = 0.1F;
   private static final float field24195 = 10.0F;
   private static final float field24196 = 0.1F;
   private static final float field24197 = 1.5F;
   private static final String field24198 = "Скорость по Y";
   private static final float field24199 = 0.1F;
   private static final float field24200 = 10.0F;
   private static final float field24201 = 0.1F;
   private static final float field24202 = 1.5F;
   private static final String field24203 = "Flight";

   @Subscribe
   private void method10888(EntityMoveEvent var1) {
      this.method10889(var1);
   }

   private void method10889(EntityMoveEvent var1) {
      Vec3 var2 = var1.method10059();
      float var3 = this.field24191.method03022();
      float var4 = this.field24192.method03022();
      double var5 = MovementUtils.method05723(mc.options.keyJump.isDown(), mc.options.keyShift.isDown(), var4);
      var1.method10060(new Vec3(var2.x(), var5, var2.z()));
      MovementUtils.method05720(var1, var3, var4);
   }

   public Flight() {
      super(ModuleCategory.Movement, ModuleSubCategory.Main);
      this.field24191 = new NumberSetting<Float>(field24193)
         .method10835(field24194)
         .method10838(field24195)
         .method10834(field24196)
         .method03017(field24197)
         .method03023(this);
      this.field24192 = new NumberSetting<Float>(field24198)
         .method10835(field24199)
         .method10838(field24200)
         .method10834(field24201)
         .method03017(field24202)
         .method03023(this);
      this.method03935(field24203);
   }
}
