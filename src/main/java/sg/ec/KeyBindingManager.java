// Original binary: sg/ec/zaHfZa5WuBr8dNDJ
package sg.ec;

import java.util.ArrayList;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.List;
import java.util.Set;

// $VF: Compiled from s
public enum KeyBindingManager {
   INSTANCE;

   private ModuleRegistry field27908;
   private final List<ToggleableModule> field27909 = new ArrayList<>();
   private final List<ToggleSetting> field27910 = new ArrayList<>();
   private final Set<ToggleableModule> field27911 = Collections.newSetFromMap(new IdentityHashMap<>());

   public void method11745(ModuleRegistry var1) {
      this.field27908 = var1;
      EventBus.method00263(this);
      this.method11748();
   }

   public List<ToggleableModule> method11746() {
      return Collections.unmodifiableList(this.field27909);
   }

   public List<ToggleSetting> method11747() {
      return Collections.unmodifiableList(this.field27910);
   }

   public void method11748() {
      this.field27909.clear();
      this.field27910.clear();

      for (ToggleableModule var2 : this.field27908.method05138()) {
         if (var2.method03930().method05871() != -1) {
            this.field27909.add(var2);
         }

         for (Setting var4 : var2.method03026()) {
            if (var4 instanceof ToggleSetting var5 && var5.method05997().method05871() != -1) {
               this.field27910.add(var5);
            }
         }
      }
   }

   @Subscribe
   public void method11749(KeyInputEvent var1) {
      if (var1.method05884() == InputAction.PRESS) {
         this.method11751(var1.method05887());
      } else {
         this.method11752(var1.method05887());
      }
   }

   @Subscribe
   public void method11750(MouseButtonEvent var1) {
      if (var1.method06919() == InputAction.PRESS) {
         this.method11751(var1.method06914());
      } else {
         this.method11752(var1.method06914());
      }
   }

   private void method11751(int var1) {
      for (ToggleableModule var3 : this.field27909) {
         KeyBinding var4 = var3.method03930();
         if (var4.method05871() == var1) {
            if (var4.method05874() == KeyBindingMode.Hold) {
               if (this.field27911.add(var3) && !var3.method03937()) {
                  var3.method00382();
               }
            } else {
               var3.method00382();
            }
         }
      }

      for (ToggleSetting var6 : this.field27910) {
         if (var6.method05997().method05871() == var1) {
            var6.field13573.method03375(!var6.method03022() ? 1.0 : 0.0);
            var6.method05996();
         }
      }
   }

   private void method11752(int var1) {
      for (ToggleableModule var3 : this.field27909) {
         if (var3.method03930().method05871() == var1 && this.field27911.remove(var3) && var3.method03937()) {
            var3.method00382();
         }
      }
   }

   @Subscribe
   public void method11753(FrameUpdateEvent var1) {
      ClickGUI var2 = this.field27908.method05142(ClickGUI.class);
      if (var2 != null) {
         if (var2.method03937()) {
            var2.method03939(false);
         }
      }
   }
}
