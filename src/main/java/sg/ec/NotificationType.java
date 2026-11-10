// Original binary: sg/ec/Q5kCT9Ytx9PJFkF4
package sg.ec;

// $VF: Compiled from s
public enum NotificationType {
   ERROR(ColorUtils.method04604(255, 50, 50), "]"),
   WARNING(ColorUtils.method04604(255, 242, 0), "a"),
   BREAK_SHIELD(ColorUtils.method04604(255, 127, 0), "`"),
   NAVIGATE("Q"),
   INFO("["),
   KILLED(ColorUtils.method04604(255, 50, 50), "b"),
   ENABLE("^"),
   DISABLE("_");

   private final String field11212;
   private final int field11213;

   NotificationType(int var3, String var4) {
      this.field11213 = var3;
      this.field11212 = var4;
   }

   NotificationType(String var3) {
      this.field11212 = var3;
      this.field11213 = -1;
   }

   public String method05135() {
      return this.field11212;
   }

   public int method05136() {
      return this.field11213;
   }
}
