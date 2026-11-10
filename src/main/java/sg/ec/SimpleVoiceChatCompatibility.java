// Original binary: sg/ec/kfNh0dKmkrnTSsxl
package sg.ec;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.UUID;

// $VF: Compiled from s
public final class SimpleVoiceChatCompatibility {
   public static boolean field20803;
   private static Field field20804;
   private static Method field20805;
   private static Method field20806;
   private static Method field20807;
   private static Method field20808;
   private static Method field20809;
   private static Method field20810;
   private static final String field20811 = "This is a utility class and cannot be instantiated";
   private static final String field20812 = "de.maxhenkel.voicechat.voice.client.ClientManager";
   private static final String field20813 = "de.maxhenkel.voicechat.voice.client.ClientManager";
   private static final String field20814 = "instance";
   private static final String field20815 = "playerStateManager";
   private static final String field20816 = "isPlayerDisabled";
   private static final String field20817 = "isPlayerDisconnected";
   private static final String field20818 = "getClient";
   private static final String field20819 = "getTalkCache";
   private static final String field20820 = "isTalking";

   static {
      boolean var0 = false;

      try {
         Class.forName(field20812);
         var0 = true;
      } catch (ClassNotFoundException var6) {
      }

      field20803 = var0;
      if (field20803) {
         try {
            var sx = Class.forName(field20813);
            field20807 = sx.getMethod(field20814);
            field20804 = sx.getDeclaredField(field20815);
            field20804.setAccessible(true);
            var sxx = field20804.getType();
            field20805 = sxx.getMethod(field20816, UUID.class);
            field20806 = sxx.getMethod(field20817, UUID.class);
            field20808 = sx.getDeclaredMethod(field20818);
            var sxxx = field20808.getReturnType();
            field20809 = sxxx.getDeclaredMethod(field20819);
            var sxxxx = field20809.getReturnType();
            field20810 = sxxxx.getDeclaredMethod(field20820, UUID.class);
         } catch (Exception sx) {
            field20803 = false;
         }
      }
   }

   public static boolean method09182() {
      return field20803
         && field20807 != null
         && field20804 != null
         && field20805 != null
         && field20806 != null
         && field20808 != null
         && field20809 != null
         && field20810 != null;
   }

   private static Object method09183() {
      try {
         Object var0 = field20807.invoke(null);
         return var0 == null ? null : field20804.get(var0);
      } catch (Exception var1) {
         return null;
      }
   }

   public static boolean method09184(UUID var0) {
      if (!method09182()) {
         return false;
      }

      try {
         Object var1 = method09183();
         return var1 == null ? false : (Boolean)field20806.invoke(var1, var0);
      } catch (Exception var2) {
         return false;
      }
   }

   private SimpleVoiceChatCompatibility() {
      throw new UnsupportedOperationException(field20811);
   }

   public static boolean method09185(UUID var0) {
      if (!method09182()) {
         return false;
      }

      try {
         Object var1 = field20807.invoke(null);
         if (var1 == null) {
            return false;
         }

         Object var2 = field20808.invoke(var1);
         if (var2 == null) {
            return false;
         }

         Object var3 = field20809.invoke(var2);
         return var3 == null ? false : (Boolean)field20810.invoke(var3, var0);
      } catch (Exception var4) {
         return false;
      }
   }

   public static boolean method09186(UUID var0) {
      if (!method09182()) {
         return false;
      }

      try {
         Object var1 = method09183();
         return var1 == null ? false : (Boolean)field20805.invoke(var1, var0);
      } catch (Exception var2) {
         return false;
      }
   }
}
