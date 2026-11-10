// Original binary: sg/ec/Lw4QVSyentOcgmKl
package sg.ec;

import net.minecraft.client.CameraType;

// $VF: Compiled from s
public class FreeLook extends ClientModule {
   private static final String field09968 = "Toggle";
   private final ModeSetting field09969;
   private final KeyBindSetting field09970;
   private boolean field09971;
   private boolean field09972;
   private CameraType field09973;
   private static final String field09974 = "Режим включения";
   private static final String field09975 = "Hold";
   private static final String field09976 = "Toggle";
   private static final String field09977 = "Hold";
   private static final String field09978 = "Кнопка активации";
   private static final String field09979 = "Free Look";
   private static final String field09980 = "Toggle";

   @Override
   public void method00245() {
      this.field09971 = false;
      this.method04472();
      super.method00245();
   }

   private static boolean method04471() {
      AttackAura var0 = ModuleManager.INSTANCE.method08219();
      return var0 != null && var0.method03937();
   }

   private void method04472() {
      if (this.field09972) {
         this.field09972 = false;
         method04475();
         FreeLookController.method10132(false);
         FreeLookController.method10135(false, false);
         if (this.field09973 != null) {
            mc.options.setCameraType(this.field09973);
         }
      }
   }

   @Subscribe
   private void method04473(FrameUpdateEvent var1) {
      if (mc.player != null && this.field09971 && !method04471()) {
         this.method04476();
         mc.options.setCameraType(CameraType.THIRD_PERSON_BACK);
         FreeLookController.method10135(true, false);
      } else {
         this.method04472();
      }
   }

   @Subscribe
   private void method04474(MouseButtonEvent var1) {
      this.method04477(var1.method06914(), var1.method06919());
   }

   private static void method04475() {
      if (mc.player != null) {
         FreeLookController.method10125(mc.player.getYRot());
         FreeLookController.method10129(mc.player.getXRot());
      }
   }

   private void method04476() {
      if (!this.field09972) {
         this.field09972 = true;
         this.field09973 = mc.options.getCameraType();
         method04475();
         FreeLookController.method10132(true);
         FreeLookController.method10135(true, false);
      }
   }

   private void method04477(int var1, InputAction var2) {
      if (var1 == this.field09970.method03022().method05871()) {
         if (this.field09969.method05600(field09980)) {
            if (var2 == InputAction.PRESS) {
               this.field09971 = !this.field09971;
            }
         } else {
            if (var2 == InputAction.PRESS) {
               this.field09971 = true;
            }

            if (var2 == InputAction.RELEASE) {
               this.field09971 = false;
            }
         }
      }
   }

   @Subscribe
   private void method04478(KeyInputEvent var1) {
      this.method04477(var1.method05887(), var1.method05884());
   }

   public FreeLook() {
      super(ModuleCategory.Player, ModuleSubCategory.Other);
      this.field09969 = new ModeSetting(field09974).method05597(field09975, field09976).method03017(field09977).method03023(this);
      this.field09970 = new KeyBindSetting(field09978).method03017(new KeyBinding()).method03023(this);
      this.method03935(field09979);
   }
}
