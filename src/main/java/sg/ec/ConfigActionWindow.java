// Original binary: sg/ec/mfRnybcwgs4NvwF2
package sg.ec;

// $VF: Compiled from s
abstract class ConfigActionWindow extends SettingsListWindow {
   @Override
   public void method00611(int var1, int var2, int var3) {
      if (var1 == 256) {
         this.method09550();
      } else {
         super.method00611(var1, var2, var3);
      }
   }

   @Override
   public boolean method01682() {
      return false;
   }

   protected ConfigActionWindow(String var1, String var2, float var3, float var4) {
      super(var1, var2, var3, var4);
   }

   protected void method09550() {
      if (this.method09580() != null) {
         this.method09580().method09654(this);
      }
   }
}
