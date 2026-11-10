// Original binary: sg/ec/zriSxvYjnwFw6nvh
package sg.ec;

import hex.script.api.ModuleInfo;
import hex.script.api.Render2D;
import hex.script.api.ScriptHost;
import java.util.Arrays;
import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public final class ScriptHostImpl {
   static final int field27942 = 30;
   private final ScriptRender2DAdapter field27943 = new ScriptRender2DAdapter();
   private final ScriptRender3DAdapter field27944 = new ScriptRender3DAdapter();
   private final ScriptEventNames field27945 = new ScriptEventNames();
   private final ScriptHookDispatcher field27946 = new ScriptHookDispatcher();
   private final ScriptServicesImpl field27947 = new ScriptServicesImpl();
   private final ScriptHost field27948 = new ScriptHost(
      this::method11774,
      this::method11763,
      this::method11769,
      this.field27945::method04787,
      this.field27945::method04783,
      this.field27945::method04793,
      this::method11768,
      this.field27945::method04794,
      this::method11773,
      this::method11766,
      this.field27947::method01576,
      this.field27946::method02166,
      this.field27946::method02168,
      this.field27946::method02169
   );
   private ModuleInfo[] field27949 = new ModuleInfo[0];
   private boolean field27950 = true;

   private void method11763(String var1) {
      if (var1 != null) {
         ChatTextUtils.method05098(Component.literal(var1));
      }
   }

   ScriptRender3DAdapter method11764() {
      return this.field27944;
   }

   ScriptRender2DAdapter method11765() {
      return this.field27943;
   }

   private ModuleInfo[] method11766() {
      if (!this.field27950) {
         return this.field27949;
      }

      this.field27950 = false;
      SortableArrayList var1 = ModuleManager.INSTANCE.method05138();
      int var2 = var1.size();
      if (this.field27949.length != var2) {
         this.field27949 = Arrays.copyOf(this.field27949, var2);
      }

      for (int var3 = 0; var3 < var2; var3++) {
         ToggleableModule var4 = (ToggleableModule)var1.get(var3);
         KeyBinding var5 = var4.method03930();
         AnimationUtils var6 = var4.method03927();
         var6.method03375(var4.method03937() ? 1.0 : 0.0);
         ModuleInfo var7 = this.field27949[var3];
         if (var7 == null) {
            var7 = new ModuleInfo();
            this.field27949[var3] = var7;
         }

         var7.set(
            var4.method03925(),
            KeyboardKey.method00360(var5.method05871()),
            var4.method03938().name(),
            var4.method03937(),
            var5.method05873() && var5.method05871() != -1,
            var6.method03377()
         );
      }

      return this.field27949;
   }

   ScriptServicesImpl method11767() {
      return this.field27947;
   }

   void method11768(Object var1) {
      this.field27945.method04792(var1);
      this.field27946.method02170(var1);
   }

   private Render2D method11769() {
      return this.field27943.method04312();
   }

   ScriptEventNames method11770() {
      return this.field27945;
   }

   void method11771() {
      this.field27950 = true;
   }

   ScriptHost method11772() {
      return this.field27948;
   }

   private Object method11773() {
      return AttackAura.method00456();
   }

   private int method11774() {
      return 30;
   }
}
