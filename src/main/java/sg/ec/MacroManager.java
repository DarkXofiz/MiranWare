// Original binary: sg/ec/apPz9x8xd3LZ5CNh
package sg.ec;

import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public enum MacroManager {
   INSTANCE;

   private final List<Macro> field16766 = new ArrayList<>();

   public void method07022() {
      EventBus.method00263(this);
   }

   public void method07023(String var1, String var2, int var3) {
      this.field16766.add(new Macro(var1, var2, var3));
      CustomResourceManager.INSTANCE.method02465("Macro");
   }

   public void method07024(String var1) {
      this.field16766.removeIf(var1x -> var1x.method00884().equals(var1));
      CustomResourceManager.INSTANCE.method02465("Macro");
   }

   public void method07025() {
      this.field16766.clear();
      CustomResourceManager.INSTANCE.method02465("Macro");
   }

   @Subscribe
   private void method07026(KeyInputEvent var1) {
      if (var1.method05884() != InputAction.RELEASE) {
         this.method07028(var1.method05887());
      }
   }

   @Subscribe
   private void method07027(MouseButtonEvent var1) {
      if (var1.method06919() != InputAction.RELEASE) {
         this.method07028(var1.method06914());
      }
   }

   private void method07028(int var1) {
      this.field16766
         .stream()
         .filter(var1x -> var1x.method00882() == var1)
         .map(var0 -> var0.method00879().trim())
         .forEach(var0 -> ChatTextUtils.method05080(var0));
   }

   public List<Macro> method07029() {
      return this.field16766;
   }
}
