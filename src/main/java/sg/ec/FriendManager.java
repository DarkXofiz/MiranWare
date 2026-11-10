// Original binary: sg/ec/0gxb8Bns1WpUQ4sG
package sg.ec;

import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import net.minecraft.world.entity.player.Player;

// $VF: Compiled from s
public enum FriendManager {
   INSTANCE;

   private final Map<String, Friend> field00263 = new LinkedHashMap<>();
   private static final int field00264 = 1;

   public boolean method00171(String var1) {
      return this.field00263.containsKey(var1);
   }

   public boolean method00172(Player var1) {
      String var2 = var1.getGameProfile().name();
      if (this.field00263.containsKey(var2)) {
         return true;
      }

      Party var3 = SocialStateUtils.method10614();
      if (var3 == null) {
         return false;
      }

      PartyMember var4 = var3.method10151(var1x -> var1x.method07586().equalsIgnoreCase(var1.getName().getString()));
      return var4 != null && this.field00263.containsKey(var4.method07580());
   }

   public Set<String> method00173() {
      return this.field00263.keySet();
   }

   public Friend method00174(String var1) {
      return this.field00263.get(var1);
   }

   public Friend method00175(String var1) {
      if (var1 == null) {
         return null;
      }

      Friend var2 = this.field00263.get(var1);
      if (var2 != null) {
         return var2;
      }

      for (Friend var4 : this.field00263.values()) {
         if (var1.equalsIgnoreCase(var4.method03787()) || var4.method03786() && var1.equalsIgnoreCase(var4.method03788())) {
            return var4;
         }
      }

      return null;
   }

   public Friend method00176(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         for (Friend var3 : this.field00263.values()) {
            if (method00181(var1, var3.method03787())) {
               return var3;
            }

            if (var3.method03786() && method00181(var1, var3.method03788())) {
               return var3;
            }
         }

         return null;
      } else {
         return null;
      }
   }

   public boolean method00177(String var1) {
      return this.method00178(var1, null);
   }

   public boolean method00178(String var1, String var2) {
      String var3 = var2 != null && !var2.isEmpty() ? var2 : null;
      Friend var4 = this.field00263.get(var1);
      if (var4 != null) {
         if (var3 != null) {
            var4.method03784(var3);
         }

         CustomResourceManager.INSTANCE.method02465("Friend");
         return true;
      } else if (this.method00176(var1) == null && (var3 == null || this.method00176(var3) == null)) {
         this.field00263.put(var1, new Friend(var1, var3, System.currentTimeMillis()));
         CustomResourceManager.INSTANCE.method02465("Friend");
         return true;
      } else {
         return false;
      }
   }

   public void method00179(String var1, String var2) {
      Friend var3 = this.field00263.get(var1);
      if (var3 != null) {
         var3.method03784(var2 != null && !var2.isEmpty() ? var2 : null);
         CustomResourceManager.INSTANCE.method02465("Friend");
      }
   }

   public void method00180(String var1) {
      Friend var2 = this.method00175(var1);
      if (var2 != null && this.field00263.remove(var2.method03787()) != null) {
         CustomResourceManager.INSTANCE.method02465("Friend");
      }
   }

   public static boolean method00181(String var0, String var1) {
      if (var0 == null || var1 == null) {
         return false;
      } else {
         return var0.equalsIgnoreCase(var1) ? true : method00182(var0.toLowerCase(Locale.ROOT), var1.toLowerCase(Locale.ROOT)) <= 1;
      }
   }

   private static int method00182(String var0, String var1) {
      int var2 = var0.length();
      int var3 = var1.length();
      if (Math.abs(var2 - var3) > 1) {
         return 2;
      }

      if (var2 == 0) {
         return var3;
      }

      if (var3 == 0) {
         return var2;
      }

      int[] var4 = new int[var3 + 1];
      int[] var5 = new int[var3 + 1];
      int var6 = 0;

      while (var6 <= var3) {
         var4[var6] = var6++;
      }

      for (int var10 = 1; var10 <= var2; var10++) {
         var5[0] = var10;
         char var7 = var0.charAt(var10 - 1);

         for (int var8 = 1; var8 <= var3; var8++) {
            int var9 = var7 == var1.charAt(var8 - 1) ? 0 : 1;
            var5[var8] = Math.min(Math.min(var4[var8] + 1, var5[var8 - 1] + 1), var4[var8 - 1] + var9);
         }

         int[] var11 = var4;
         var4 = var5;
         var5 = var11;
      }

      return var4[var3];
   }

   public void method00183() {
      this.field00263.clear();
      CustomResourceManager.INSTANCE.method02465("Friend");
   }

   public Map<String, Friend> method00184() {
      return this.field00263;
   }
}
