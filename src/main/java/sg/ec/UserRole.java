// Original binary: sg/ec/gt2jp4OsjuPjh4hD
package sg.ec;

import java.util.Locale;

// $VF: Compiled from s
public enum UserRole {
   USER(0, "User"),
   BETA(1, "Beta"),
   YOUTUBE(2, "YouTube"),
   ADMIN(3, "Administrator");

   private final int field19665;
   private final String field19666;

   UserRole(int var3, String var4) {
      this.field19665 = var3;
      this.field19666 = var4;
   }

   public boolean method08586(UserRole var1) {
      return var1 == null || this.field19665 >= var1.field19665;
   }

   public static UserRole method08587(String var0) {
      if (var0 == null) {
         return USER;
      } else {
         String var1 = var0.trim().toUpperCase(Locale.ROOT);
         if (var1.isEmpty()) {
            return USER;
         } else if (var1.startsWith("DEV") || var1.contains("ADMIN") || var1.contains("АДМИН")) {
            return ADMIN;
         } else if (var1.contains("YOU") || var1.contains("ЮТУБ")) {
            return YOUTUBE;
         } else {
            return !var1.contains("BETA") && !var1.contains("БЕТА") ? USER : BETA;
         }
      }
   }

   public int method08588() {
      return this.field19665;
   }

   public String method08589() {
      return this.field19666;
   }
}
