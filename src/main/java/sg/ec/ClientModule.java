// Original binary: sg/ec/ItXvYo9ZMFQVK3Ux
package sg.ec;

import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public class ClientModule implements ToggleableModule, MinecraftAccess {
   private final List<Setting<?>> field08768 = new ArrayList<>();
   private boolean field08769 = true;
   private boolean field08770 = true;
   private String field08771 = this.getClass().getSimpleName();
   private String field08772;
   private boolean field08773;
   private KeyBinding field08774;
   private ModuleSubCategory field08775;
   private final ModuleCategory field08776;
   private AnimationUtils field08777;
   private static final String field08778 = "У этого модуля отстутсвуют подсказки.";
   private static final long field08779 = 150L;

   @Override
   public void method00382() {
      this.method03941(!this.field08773);
      ToggleStateEvent.field15044
         .method06765(this, this.field08773 ? ToggleStateEvent.Nested198.ENABLE : ToggleStateEvent.Nested198.DISABLE, ToggleStateEvent.Nested197.MODULE);
   }

   @Override
   public void method03922(KeyBinding var1) {
      this.field08774 = var1;
   }

   protected boolean method03923(Object var1) {
      return var1 instanceof ClientModule;
   }

   public void method03924(ModuleSubCategory var1) {
      this.field08775 = var1;
   }

   @Override
   public String method03925() {
      return this.field08771;
   }

   @Override
   public String toString() {
      return "Module(settings="
         + this.method03026()
         + ", toggleble="
         + this.method03928()
         + ", bindable="
         + this.method03936()
         + ", name="
         + this.method03925()
         + ", desc="
         + this.method03926()
         + ", state="
         + this.method03937()
         + ", binding="
         + this.method03930()
         + ", subCategory="
         + this.method03940()
         + ", category="
         + this.method03938()
         + ", anim="
         + this.method03927()
         + ")";
   }

   @Override
   public List<Setting<?>> method03026() {
      return this.field08768;
   }

   public ClientModule(ModuleCategory var1, ModuleSubCategory var2) {
      this.field08772 = field08778;
      this.field08777 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field08779);
      this.field08776 = var1;
      this.field08775 = var2;
      this.field08774 = new KeyBinding();
   }

   public String method03926() {
      return this.field08772;
   }

   @Override
   public AnimationUtils method03927() {
      return this.field08777;
   }

   @Override
   public boolean method03928() {
      return this.field08769;
   }

   @Override
   public void method00276() {
      EventBus.method00263(this);
      this.field08777.method03375(1.0);
   }

   public void method03929(boolean var1) {
      this.field08769 = var1;
   }

   @Override
   public KeyBinding method03930() {
      return this.field08774;
   }

   public void method03931(String var1) {
      this.field08772 = var1;
   }

   @Override
   public List<Setting<?>> method03932() {
      return this.field08768;
   }

   @Override
   public void method00245() {
      EventBus.method00265(this);
      this.field08777.method03375(0.0);
   }

   public void method03933(boolean var1) {
      this.field08770 = var1;
   }

   public void method03934(AnimationUtils var1) {
      this.field08777 = var1;
   }

   public void method03935(String var1) {
      this.field08771 = var1;
   }

   @Override
   public boolean method03936() {
      return this.field08770;
   }

   @Override
   public boolean method03937() {
      return this.field08773;
   }

   @Override
   public ModuleCategory method03938() {
      return this.field08776;
   }

   @Override
   public final void method03939(boolean var1) {
      if (this.field08773 != var1) {
         try {
            this.method03941(var1);
         } catch (Exception var3) {
         }
      }
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof ClientModule var2)) {
         return false;
      } else {
         if (!var2.method03923(this)) {
            return false;
         }

         if (this.method03928() != var2.method03928()) {
            return false;
         }

         if (this.method03936() != var2.method03936()) {
            return false;
         }

         if (this.method03937() != var2.method03937()) {
            return false;
         }

         var var3 = this.method03026();
         var var4 = var2.method03026();
         if (var3 == null ? var4 == null : var3.equals(var4)) {
            String var5 = this.method03925();
            String var6 = var2.method03925();
            if (var5 == null ? var6 == null : var5.equals(var6)) {
               String var7 = this.method03926();
               String var8 = var2.method03926();
               if (var7 == null ? var8 == null : var7.equals(var8)) {
                  KeyBinding var9 = this.method03930();
                  KeyBinding var10 = var2.method03930();
                  if (var9 == null ? var10 == null : var9.equals(var10)) {
                     ModuleSubCategory var11 = this.method03940();
                     ModuleSubCategory var12 = var2.method03940();
                     if (var11 == null ? var12 == null : var11.equals(var12)) {
                        ModuleCategory var13 = this.method03938();
                        ModuleCategory var14 = var2.method03938();
                        if (var13 == null ? var14 == null : var13.equals(var14)) {
                           AnimationUtils var15 = this.method03927();
                           AnimationUtils var16 = var2.method03927();
                           return var15 == null ? var16 == null : var15.equals(var16);
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }

   @Override
   public ModuleSubCategory method03940() {
      return this.field08775;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + (this.method03928() ? 79 : 97);
      var2 = var2 * 59 + (this.method03936() ? 79 : 97);
      var2 = var2 * 59 + (this.method03937() ? 79 : 97);
      var var3 = this.method03026();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      String var4 = this.method03925();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      String var5 = this.method03926();
      var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
      KeyBinding var6 = this.method03930();
      var2 = var2 * 59 + (var6 == null ? 43 : var6.hashCode());
      ModuleSubCategory var7 = this.method03940();
      var2 = var2 * 59 + (var7 == null ? 43 : var7.hashCode());
      ModuleCategory var8 = this.method03938();
      var2 = var2 * 59 + (var8 == null ? 43 : var8.hashCode());
      AnimationUtils var9 = this.method03927();
      return var2 * 59 + (var9 == null ? 43 : var9.hashCode());
   }

   private void method03941(boolean var1) {
      this.field08773 = var1;
      if (var1) {
         this.method00276();
      } else {
         this.method00245();
      }
   }
}
