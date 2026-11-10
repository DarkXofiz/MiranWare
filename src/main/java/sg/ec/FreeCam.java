// Original binary: sg/ec/noqF4W2tQxX8BoOm
package sg.ec;

import net.minecraft.client.CameraType;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.util.Mth;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

// $VF: Compiled from s
public class FreeCam extends ClientModule {
   private final ToggleSetting field22029;
   private final NumberSetting<Float> field22030;
   private final NumberSetting<Float> field22031;
   public final ToggleSetting field22032;
   public Vec3 field22033;
   private final Vector2f field22034;
   private CameraType field22035;
   private static final String field22036 = "Отображать позицию";
   private static final String field22037 = "Скорость по xz";
   private static final float field22038 = 0.1F;
   private static final float field22039 = 1.5F;
   private static final float field22040 = 0.05F;
   private static final float field22041 = 0.5F;
   private static final String field22042 = "Скорость по y";
   private static final float field22043 = 0.1F;
   private static final float field22044 = 1.5F;
   private static final float field22045 = 0.05F;
   private static final float field22046 = 0.5F;
   private static final String field22047 = "Замораживать пакеты";
   private static final String field22048 = "Free Cam";
   private static final float field22049 = 5.5F;
   private static final float field22050 = 7.5F;
   private static final double field22051 = -1.0;
   private static final float field22052 = 90.0F;
   private static final float field22053 = 90.0F;
   private static final float field22054 = 90.0F;
   private static final float field22055 = 90.0F;
   private static final float field22056 = -45.0F;
   private static final float field22057 = 45.0F;
   private static final float field22058 = 45.0F;
   private static final float field22059 = -45.0F;

   @Override
   public void method00276() {
      super.method00276();
      if (mc.player != null && mc.level != null) {
         this.field22034.x = mc.player.getYRot();
         this.field22034.y = mc.player.getXRot();
         this.field22035 = mc.options.getCameraType();
      }
   }

   @Subscribe
   private void method09739(FrameUpdateEvent var1) {
      this.method09741(var1.method03782().getRealtimeDeltaTicks());
   }

   public FreeCam() {
      super(ModuleCategory.Player, ModuleSubCategory.Main);
      this.field22029 = new ToggleSetting(field22036).method03017(false).method03023(this);
      this.field22030 = new NumberSetting<Float>(field22037)
         .method10835(field22038)
         .method10838(field22039)
         .method10834(field22040)
         .method03017(field22041)
         .method03023(this);
      this.field22031 = new NumberSetting<Float>(field22042)
         .method10835(field22043)
         .method10838(field22044)
         .method10834(field22045)
         .method03017(field22046)
         .method03023(this);
      this.field22032 = new ToggleSetting(field22047).method03017(true).method03023(this);
      this.field22033 = null;
      this.field22034 = new Vector2f(0.0F, 0.0F);
      this.method03935(field22048);
   }

   private boolean method09740() {
      ElytraHelper var1 = ModuleManager.INSTANCE.method08187();
      return var1.method06047();
   }

   private void method09741(float var1) {
      if (mc.player != null && mc.level != null) {
         CameraType var2 = mc.options.getCameraType();
         Vec3 var3 = mc.getEntityRenderDispatcher().camera.position();
         if (this.field22033 == null) {
            this.field22033 = var3;
         }

         if (var2 == CameraType.THIRD_PERSON_FRONT) {
            FreeLookController.method10125(mc.getEntityRenderDispatcher().camera.yRot());
            FreeLookController.method10129(mc.getEntityRenderDispatcher().camera.xRot());
         }

         if (var2 != CameraType.FIRST_PERSON) {
            mc.options.setCameraType(CameraType.FIRST_PERSON);
         }

         double var4 = this.field22030.method03022() * var1;
         double var6 = this.field22031.method03022() * var1;
         float var8 = FreeLookController.method10131();
         double var9 = 0.0;
         double var11 = 0.0;
         if (mc.options.keyUp.isDown()) {
            var9++;
         }

         if (mc.options.keyDown.isDown()) {
            var9--;
         }

         if (mc.options.keyLeft.isDown()) {
            var11++;
         }

         if (mc.options.keyRight.isDown()) {
            var11--;
         }

         double var13 = 0.0;
         double var15 = 0.0;
         if (var9 != 0.0 || var11 != 0.0) {
            if (var9 != 0.0) {
               var8 = method09746(var8, var9, var11);
               var11 = 0.0;
               if (var9 > 0.0) {
                  var9 = 1.0;
               } else {
                  var9 = field22051;
               }
            }

            var13 = var9 * var4 * Mth.cos((float)Math.toRadians(var8 + field22052)) + var11 * var4 * Mth.sin((float)Math.toRadians(var8 + field22053));
            var15 = var9 * var4 * Mth.sin((float)Math.toRadians(var8 + field22054)) - var11 * var4 * Mth.cos((float)Math.toRadians(var8 + field22055));
         }

         this.field22033 = this.field22033.add(var13, 0.0, var15);
         if (mc.options.keyJump.isDown()) {
            this.field22033 = this.field22033.add(0.0, var6, 0.0);
         }

         if (mc.options.keyShift.isDown()) {
            this.field22033 = this.field22033.add(0.0, -var6, 0.0);
         }
      }
   }

   @Override
   public void method00245() {
      super.method00245();
      if (mc.player != null && mc.level != null) {
         mc.player.setYRot(this.field22034.x);
         mc.player.setXRot(this.field22034.y);
         if (this.field22035 != null) {
            mc.options.setCameraType(this.field22035);
         }

         this.field22033 = null;
         mc.player.fallDistance = 0.0;
      }
   }

   @Subscribe
   private void method09742(CameraPositionEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (this.field22033 != null) {
            var1.method00053(this.field22033);
         }
      }
   }

   @Subscribe
   private void method09743(HudRenderEvent var1) {
      if (this.field22029.method05999() && mc.player != null) {
         float var2 = field22049;
         float var3 = field22050;
         Vec3 var4 = mc.player.position();
         Vec3 var5 = mc.getEntityRenderDispatcher().camera.position();
         GuiGraphicsExtractor var6 = var1.method05424();
         float var7 = mc.getWindow().getGuiScaledWidth() / 2.0F;
         float var8 = mc.getWindow().getGuiScaledHeight() / 2.0F;
         String var9 = "Позиция игрока: x" + (int)var4.x() + " y" + (int)var4.y() + " z" + (int)var4.z();
         String var10 = "Позиция камеры: x" + (int)var5.x() + " y" + (int)var5.y() + " z" + (int)var5.z();
         Fonts.field00109.method09473(var6, var9, var7, var8 + var3, -1, var2);
         Fonts.field00109.method09473(var6, var10, var7, var8 + var3 * 2.0F, -1, var2);
      }
   }

   @Subscribe(4)
   private void method09744(PlayerInputEvent var1) {
      if (this.method09740()) {
         var1.method11168();
      } else {
         var1.method11159();
      }
   }

   @Subscribe
   private void method09745(WorldLoadEvent var1) {
      this.method03939(false);
   }

   private static float method09746(float var0, double var1, double var3) {
      if (var3 > 0.0) {
         return var0 + (var1 > 0.0 ? field22056 : field22057);
      } else {
         return var3 < 0.0 ? var0 + (var1 > 0.0 ? field22058 : field22059) : var0;
      }
   }
}
