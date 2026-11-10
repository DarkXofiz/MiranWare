// Original binary: sg/ec/b4sOmxtR2OEXwTtB
package sg.ec;

import java.io.File;
import java.io.FileInputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

// $VF: Compiled from s
public class NoTraceStorage extends AbstractStorage {
   private static final char field16902 = '\t';
   private boolean field16903;
   private static final String field16904 = "\n";
   private static final String field16905 = "\n";
   private static final long field16906 = -1L;
   private static final long field16907 = -1L;

   public static boolean method07078(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         var var1 = method07085(method07083(CustomResourceManager.method02470(var0)), true);
         if (var1 == null) {
            var1 = method07085(method07083(var0), false);
         }

         if (var1 == null) {
            return false;
         }

         var sx = FriendManager.INSTANCE.method00184();
         sx.clear();

         for (Friend sxx : var1) {
            sx.put(sxx.method03787(), sxx);
         }

         return true;
      } else {
         return false;
      }
   }

   private String method07079(byte[] var1) {
      return var1 == null ? null : new String(var1, StandardCharsets.UTF_8);
   }

   public NoTraceStorage(File var1) {
      super(var1);
   }

   @Override
   public boolean method00298() {
      try (FileInputStream var1 = new FileInputStream(this.method03303())) {
         byte[] var2 = var1.readAllBytes();
         var var3 = this.method07084(this.method07079(CustomResourceManager.method02470(var2)), true);
         if (var3 == null) {
            var3 = this.method07084(this.method07079(var2), false);
         }

         if (var3 == null) {
            return false;
         }

         var var4 = FriendManager.INSTANCE.method00184();
         var4.clear();

         for (Friend var6 : var3) {
            var4.put(var6.method03787(), var6);
         }

         if (this.field16903) {
            this.method00296();
         }

         return true;
      } catch (Exception var9) {
         return false;
      }
   }

   @Override
   public boolean method00296() {
      return this.method03302(method07081());
   }

   public static byte[] method07080() {
      try {
         return CustomResourceManager.method02469(method07081());
      } catch (Exception var1) {
         return new byte[0];
      }
   }

   private static byte[] method07081() {
      StringBuilder var0 = new StringBuilder();

      for (Friend var2 : FriendManager.INSTANCE.method00184().values()) {
         var0.append(var2.method03787()).append('\t').append(var2.method03785());
         if (var2.method03786()) {
            var0.append('\t').append(var2.method03788());
         }

         var0.append('\n');
      }

      return var0.toString().getBytes(StandardCharsets.UTF_8);
   }

   private static long method07082(String var0) {
      if (var0.isEmpty()) {
         return field16906;
      }

      try {
         return Long.parseLong(var0);
      } catch (NumberFormatException var2) {
         return field16907;
      }
   }

   private static String method07083(byte[] var0) {
      return var0 == null ? null : new String(var0, StandardCharsets.UTF_8);
   }

   private List<Friend> method07084(String var1, boolean var2) {
      if (var1 == null) {
         return null;
      }

      this.field16903 = false;
      long var3 = System.currentTimeMillis();
      ArrayList var5 = new ArrayList();
      HashSet var6 = new HashSet();

      for (String var10 : var1.split(field16905, -1)) {
         String var11 = var10.trim();
         if (!var11.isEmpty()) {
            int var12 = var11.indexOf(9);
            String var13 = (var12 < 0 ? var11 : var11.substring(0, var12)).trim();
            if (!TextRenderUtils.method00673(var13)) {
               if (var2) {
                  return null;
               }
            } else if (var6.add(var13)) {
               long var14 = var3;
               String var16 = null;
               if (var12 < 0) {
                  this.field16903 = true;
               } else {
                  String var17 = var11.substring(var12 + 1);
                  int var18 = var17.indexOf(9);
                  long var19 = method07082((var18 < 0 ? var17 : var17.substring(0, var18)).trim());
                  if (var19 > 0L) {
                     var14 = var19;
                  } else {
                     this.field16903 = true;
                  }

                  if (var18 >= 0) {
                     String var21 = var17.substring(var18 + 1).trim();
                     if (!var21.isEmpty()) {
                        var16 = var21;
                     }
                  }
               }

               var5.add(new Friend(var13, var16, var14));
            }
         }
      }

      return var5;
   }

   private static List<Friend> method07085(String var0, boolean var1) {
      if (var0 == null) {
         return null;
      }

      long var2 = System.currentTimeMillis();
      ArrayList var4 = new ArrayList();
      HashSet var5 = new HashSet();

      for (String var9 : var0.split(field16904, -1)) {
         String var10 = var9.trim();
         if (!var10.isEmpty()) {
            int var11 = var10.indexOf(9);
            String var12 = (var11 < 0 ? var10 : var10.substring(0, var11)).trim();
            if (!TextRenderUtils.method00673(var12)) {
               if (var1) {
                  return null;
               }
            } else if (var5.add(var12)) {
               long var13 = var2;
               String var15 = null;
               if (var11 >= 0) {
                  String var16 = var10.substring(var11 + 1);
                  int var17 = var16.indexOf(9);
                  long var18 = method07082((var17 < 0 ? var16 : var16.substring(0, var17)).trim());
                  if (var18 > 0L) {
                     var13 = var18;
                  }

                  if (var17 >= 0) {
                     String var20 = var16.substring(var17 + 1).trim();
                     if (!var20.isEmpty()) {
                        var15 = var20;
                     }
                  }
               }

               var4.add(new Friend(var12, var15, var13));
            }
         }
      }

      return var4;
   }
}
