// Original binary: sg/ec/D2pn7r9A86XuXx4e
package sg.ec;

// $VF: Compiled from s
public final class ActiveConfigTracker {
   public static final ActiveConfigTracker field06857 = new ActiveConfigTracker();
   private static final String field06858 = "Default";
   private volatile String field06859 = "";
   private volatile boolean field06860;
   private static final String field06861 = "Default";

   private ActiveConfigTracker() {
   }

   public boolean method03059(String var1) {
      return var1 != null && !this.field06859.isEmpty() && this.field06859.equalsIgnoreCase(var1);
   }

   public String method03060() {
      return this.field06859;
   }

   public void method03061() {
      this.field06859 = "";
   }

   public void method03062(String var1) {
      this.field06859 = var1 == null ? "" : var1;
      if (this.field06859.equalsIgnoreCase(field06861)) {
         this.field06860 = true;
      }
   }

   public boolean method03063() {
      return this.field06860;
   }
}
