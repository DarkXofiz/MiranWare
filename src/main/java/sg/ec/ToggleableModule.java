// Original binary: sg/ec/NGAvdou3m286fZDp
package sg.ec;

import java.util.List;

// $VF: Compiled from s
public interface ToggleableModule extends SettingsContainer {
   void method00276();

   boolean method03937();

   default void method04700() {
      this.method03939(true);
   }

   ModuleCategory method03938();

   AnimationUtils method03927();

   default void method04701(boolean var1) {
      this.method03939(var1);
   }

   default void method04702() {
      this.method03939(false);
   }

   ModuleSubCategory method03940();

   List<Setting<?>> method03932();

   boolean method03936();

   String method03925();

   void method03939(boolean var1);

   boolean method03928();

   void method00382();

   default boolean method04703() {
      return this.method03937();
   }

   void method00245();

   KeyBinding method03930();

   void method03922(KeyBinding var1);
}
