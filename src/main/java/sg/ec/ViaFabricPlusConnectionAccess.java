// Original binary: sg/ec/10SwlxRB1zbt65nJ
package sg.ec;

import java.lang.reflect.Method;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.Connection;

// $VF: Compiled from s
public final class ViaFabricPlusConnectionAccess {
   private static final String field00424 = "viaFabricPlus$getUserConnection";
   private static final String field00425 = "field00425";
   private static final String field00426 = "field00426";
   private static final String field00427 = "field00427";
   private static final String field00428 = "field00428";
   private static final String field00429 = "field00429";
   private static final String field00430 = "field00430";
   private static volatile Method field00431;
   private static volatile Method field00432;
   private static volatile Method field00433;
   private static volatile Method field00434;
   private static volatile Method field00435;
   private static final String field00436 = "com.viaversion.viafabricplus.ViaFabricPlus";
   private static final String field00437 = "api";
   private static final String field00438 = "com.viaversion.viafabricplus.api.ViaFabricPlusAPI";
   private static final String field00439 = "userConnection";
   private static final String field00440 = "viaFabricPlus$getUserConnection";
   private static final String field00441 = "viaFabricPlus$getUserConnection";
   private static final String field00442 = "userconnection";
   private static final String field00443 = "via";
   private static final String field00444 = "via";
   private static final String field00445 = "sendToServer";
   private static final String field00446 = "scheduleSendToServer";
   private static final String field00447 = "sendToServer";
   private static final String field00448 = "scheduleSendToServer";
   private static final String field00449 = "lambda$";
   private static final String field00450 = "access$";

   public static boolean method00218(Object var0) {
      if (var0 instanceof LocalPlayer var1) {
         return !BotEntityUtils.method03835(var1) ? false : method00229(var0) == null;
      } else {
         return false;
      }
   }

   private static void method00219(Method var0) {
      try {
         var0.setAccessible(true);
      } catch (Throwable var2) {
      }
   }

   private static Object method00220(LocalPlayer var0) {
      ClientPacketListener var1 = var0.connection;
      if (var1 == null) {
         return null;
      }

      Connection var2 = var1.getConnection();
      if (var2 == null) {
         return null;
      }

      try {
         Method var3 = field00431;
         if (var3 == null || !var3.getDeclaringClass().isAssignableFrom(var2.getClass())) {
            var3 = method00224(var2.getClass());
            if (var3 == null) {
               return null;
            }

            try {
               var3.setAccessible(true);
            } catch (Throwable var5) {
            }

            field00431 = var3;
         }

         return var3.invoke(var2);
      } catch (Throwable var6) {
         return null;
      }
   }

   public static void method00221(Object var0, Object var1, Object var2) {
      if (var0 != null) {
         if (var2 instanceof LocalPlayer var3 && BotEntityUtils.method03835(var3)) {
            try {
               Method var4 = method00225(var0.getClass(), true);
               if (var4 != null) {
                  var4.invoke(var0, var1);
                  return;
               }
            } catch (Throwable var6) {
            }
         }

         try {
            Method var7 = method00225(var0.getClass(), false);
            if (var7 != null) {
               var7.invoke(var0, var1);
            }
         } catch (Throwable var5) {
         }
      }
   }

   private static void method00222(boolean var0, Method var1) {
      if (var0) {
         field00434 = var1;
      } else {
         field00435 = var1;
      }
   }

   private static Object method00223() {
      try {
         Method var0 = field00433;
         Method var1 = field00432;
         if (var0 == null || var1 == null) {
            var1 = Class.forName(field00436).getMethod(field00437);
            var0 = Class.forName(field00438).getMethod(field00439);
            field00432 = var1;
            field00433 = var0;
         }

         return var0.invoke(var1.invoke(null));
      } catch (Throwable var2) {
         return null;
      }
   }

   private static Method method00224(Class<?> var0) {
      try {
         Method var1 = var0.getMethod(field00440);
         if (var1.getParameterCount() == 0 && var1.getReturnType() != void.class) {
            return var1;
         }
      } catch (Throwable var6) {
      }

      for (Class var7 = var0; var7 != null && var7 != Object.class; var7 = var7.getSuperclass()) {
         for (Method var5 : var7.getDeclaredMethods()) {
            if (var5.getParameterCount() == 0 && var5.getReturnType() != void.class && method00226(var5)) {
               return var5;
            }
         }
      }

      return null;
   }

   private static Method method00225(Class<?> var0, boolean var1) {
      Method var2 = var1 ? field00434 : field00435;
      if (var2 != null && var2.getDeclaringClass().isAssignableFrom(var0)) {
         return var2;
      }

      String var3 = var1 ? field00445 : field00446;

      try {
         Method var4 = var0.getMethod(var3, Class.class);
         if (method00227(var4)) {
            method00222(var1, var4);
            return var4;
         }
      } catch (Throwable var9) {
      }

      for (Class var10 = var0; var10 != null && var10 != Object.class; var10 = var10.getSuperclass()) {
         for (Method var8 : var10.getDeclaredMethods()) {
            if (method00227(var8)) {
               if (var1) {
                  if (field00447.equals(var8.getName())) {
                     method00219(var8);
                     method00222(true, var8);
                     return var8;
                  }
               } else if (field00448.equals(var8.getName())) {
                  method00219(var8);
                  method00222(false, var8);
                  return var8;
               }
            }
         }
      }

      return method00228(var0, var1);
   }

   private static boolean method00226(Method var0) {
      String var1 = var0.getName();
      if (field00441.equals(var1)) {
         return true;
      } else {
         var var2 = var0.getReturnType();
         String var3 = var2.getName().toLowerCase();
         String var4 = var0.getDeclaringClass().getName().toLowerCase();
         if (var3.contains(field00442)) {
            return true;
         } else {
            return var3.contains(field00443) ? true : var4.contains(field00444) && !var2.isPrimitive();
         }
      }
   }

   private static boolean method00227(Method var0) {
      if (var0.getReturnType() != void.class) {
         return false;
      }

      Class[] var1 = var0.getParameterTypes();
      return var1.length != 1 ? false : var1[0] == Class.class;
   }

   private static Method method00228(Class<?> var0, boolean var1) {
      Method var2 = null;

      for (Class var3 = var0; var3 != null && var3 != Object.class; var3 = var3.getSuperclass()) {
         for (Method var7 : var3.getDeclaredMethods()) {
            if (method00227(var7)) {
               String var8 = var7.getName();
               if (!var8.startsWith(field00449) && !var8.startsWith(field00450) && var2 == null) {
                  var2 = var7;
               }
            }
         }
      }

      if (var2 != null) {
         method00219(var2);
         method00222(var1, var2);
      }

      return var2;
   }

   private ViaFabricPlusConnectionAccess() {
   }

   public static Object method00229(Object var0) {
      if (var0 instanceof LocalPlayer var1) {
         Object var2 = method00220(var1);
         if (var2 != null) {
            return var2;
         } else {
            return BotEntityUtils.method03835(var1) ? null : method00223();
         }
      } else {
         return method00223();
      }
   }
}
