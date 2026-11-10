// Original binary: sg/ec/Yh81SNQcGSLmTaPS
package sg.ec;

import hex.script.api.Control;
import hex.script.api.Keys;
import net.minecraft.client.CameraType;

// $VF: Compiled from s
public final class ScriptInputAdapter implements MinecraftAccess {
   private final Keys field14901 = new Keys(
      this::method06626, this::method06635, this::method06632, KeyboardKey::method00360, KeyboardKey::method00361
   );
   private final Control field14902 = new Control(this::method06634, this::method06630, this::method06633, this::method06628);
   private Boolean field14903;
   private Boolean field14904;
   private boolean field14905;
   private boolean field14906;
   private double field14907;
   private double field14908;
   private double field14909;
   private static final double field14910 = 2.0;
   private static final double field14911 = 0.5;

   private boolean method06626(int var1, int var2) {
      return switch (var1) {
         case 1 -> mc.getWindow() != null && InputCompat.isMouseDown(var2);
         case 2 -> mc.mouseHandler.isMouseGrabbed();
         case 3 -> mc.gui.screen() != null || ClientScreenManager.INSTANCE.method08316();
         default -> KeyboardKey.method00362(var2);
      };
   }

   @Subscribe(3)
   private void method06627(PlayerInputEvent var1) {
      if (this.field14903 != null) {
         var1.method11169(this.field14903);
         this.field14903 = null;
      }

      if (this.field14904 != null) {
         var1.method11174(this.field14904);
         this.field14904 = null;
      }

      if (this.field14905) {
         var1.method11173(true);
         this.field14905 = false;
      }

      this.method06638();
   }

   private void method06628(double var1, double var3, double var5) {
      this.field14907 = var1;
      this.field14908 = var3;
      this.field14909 = var5;
      this.field14906 = true;
   }

   Control method06629() {
      return this.field14902;
   }

   private boolean method06630() {
      if (mc.player != null && mc.player.onGround()) {
         this.field14905 = true;
         return true;
      } else {
         return false;
      }
   }

   private double method06631(double var1, boolean var3) {
      if (mc.options == null) {
         return 0.0;
      }

      if (var3) {
         mc.options.setCameraType(switch ((int)var1) {
            case 1 -> CameraType.THIRD_PERSON_BACK;
            case 2 -> CameraType.THIRD_PERSON_FRONT;
            default -> CameraType.FIRST_PERSON;
         });
      }
      return switch (mc.options.getCameraType()) {
         case THIRD_PERSON_BACK -> 1.0;
         case THIRD_PERSON_FRONT -> field14910;
         default -> 0.0;
      };
   }

   private void method06632(boolean var1) {
      if (var1) {
         mc.mouseHandler.grabMouse();
      } else {
         mc.mouseHandler.releaseMouse();
      }
   }

   private double method06633(int var1, double var2, boolean var4) {
      return switch (var1) {
         case 1 -> this.method06636(var2, var4);
         case 2 -> mc.getWindow() == null ? 1.0 : mc.getWindow().getGuiScale();
         default -> this.method06631(var2, var4);
      };
   }

   private boolean method06634(int var1, boolean var2, boolean var3) {
      if (mc.player == null) {
         return false;
      }

      boolean var4 = var1 == 1;
      if (!var3) {
         return var4 ? mc.player.isShiftKeyDown() : mc.player.isSprinting();
      }

      if (var4) {
         this.field14903 = var2;
      } else {
         this.field14904 = var2;
      }

      return var2;
   }

   private float method06635(int var1) {
      return (float)(var1 == 1 ? mc.mouseHandler.ypos() : mc.mouseHandler.xpos());
   }

   private double method06636(double var1, boolean var3) {
      if (mc.options == null) {
         return field14911;
      }

      if (var3) {
         mc.options.sensitivity().set(Math.max(0.0, Math.min(1.0, var1)));
      }

      return mc.options.sensitivity().get();
   }

   Keys method06637() {
      return this.field14901;
   }

   private void method06638() {
      if (this.field14906) {
         this.field14906 = false;
         if (mc.player != null) {
            mc.player.setDeltaMovement(this.field14907, this.field14908, this.field14909);
         }
      }
   }
}
