// Original binary: sg/ec/4hJ2yEvaYbHIKUZ7
package sg.ec;

// $VF: Compiled from s
public class Macro {
   private String field02061;
   private String field02062;
   private int field02063;

   public Macro(String var1, String var2, int var3) {
      this.field02061 = var1;
      this.field02062 = var2;
      this.field02063 = var3;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      var2 = var2 * 59 + this.method00882();
      String var3 = this.method00884();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      String var4 = this.method00879();
      return var2 * 59 + (var4 == null ? 43 : var4.hashCode());
   }

   public String method00879() {
      return this.field02062;
   }

   public void method00880(String var1) {
      this.field02061 = var1;
   }

   @Override
   public String toString() {
      return "Macro(name=" + this.method00884() + ", description=" + this.method00879() + ", key=" + this.method00882() + ")";
   }

   public void method00881(int var1) {
      this.field02063 = var1;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof Macro var2)) {
         return false;
      } else if (!var2.method00883(this)) {
         return false;
      } else if (this.method00882() != var2.method00882()) {
         return false;
      } else {
         String var3 = this.method00884();
         String var4 = var2.method00884();
         if (var3 == null ? var4 == null : var3.equals(var4)) {
            String var5 = this.method00879();
            String var6 = var2.method00879();
            return var5 == null ? var6 == null : var5.equals(var6);
         } else {
            return false;
         }
      }
   }

   public int method00882() {
      return this.field02063;
   }

   protected boolean method00883(Object var1) {
      return var1 instanceof Macro;
   }

   public String method00884() {
      return this.field02061;
   }

   public void method00885(String var1) {
      this.field02062 = var1;
   }
}
