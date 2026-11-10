// Original binary: sg/ec/5MHN6231tIAT3uwy
package sg.ec;

import hex.script.api.Button;
import hex.script.api.Hotkey;
import hex.script.api.Script;
import hex.script.api.Setting;
import java.util.List;

// $VF: Compiled from s
public final class ScriptSettingsAdapter {
   private static final String field02231 = "settings";
   private static final String field02232 = "field02232";
   private static final String field02233 = "unknown";
   private static final String field02234 = "settings";
   private static final String field02235 = "#enabled";
   private static final String field02236 = "settings";
   private static final String field02237 = "#enabled";
   private static final String field02238 = "settings";
   private static final String field02239 = "settings";
   private static final String field02240 = "This is a utility class and cannot be instantiated";

   public static boolean method00971(Script var0, int var1) {
      boolean var2 = false;

      for (Setting sx : method00977(var0)) {
         if (sx instanceof Hotkey sxx && sxx.press(var1)) {
            var2 = true;
         }
      }

      return var2;
   }

   public static void method00972(Script var0, boolean var1) {
      ScriptDataStorage var2 = new ScriptDataStorage(method00973(var0), field02236);
      var2.method11792(field02237, String.valueOf(var1));
      var2.method11796();
   }

   public static String method00973(Object var0) {
      return var0 == null ? field02233 : ScriptDataStorage.method11795(var0.getClass().getName());
   }

   public static boolean method00974(Script var0) {
      return Boolean.parseBoolean(String.valueOf(new ScriptDataStorage(method00973(var0), field02234).method11801(field02235)));
   }

   public static List<Setting<?>> method00977(Script var0) {
      try {
         return var0.settings();
      } catch (Throwable var2) {
         return List.of();
      }
   }

   public static boolean method00979(Setting<?> var0, String var1) {
      if (var0 instanceof Button var3) {
         var3.press();
         return true;
      } else {
         String var2 = var0.write();
         method00980(() -> var0.read(var1));
         return !var2.equals(var0.write());
      }
   }

   private static void method00980(Runnable var0) {
      try {
         var0.run();
      } catch (Throwable var2) {
      }
   }

   public static Setting<?> method00981(Script var0, String var1) {
      for (Setting var3 : method00977(var0)) {
         if (var3.id().equalsIgnoreCase(var1) || var3.name().equalsIgnoreCase(var1)) {
            return var3;
         }
      }

      return null;
   }

   public static void method00982(Script var0) {
      var var1 = method00977(var0);
      if (!var1.isEmpty()) {
         ScriptDataStorage var2 = new ScriptDataStorage(method00973(var0), field02239);

         for (Setting var4 : var1) {
            if (!(var4 instanceof Button)) {
               method00980(() -> var2.method11792(var4.id(), var4.write()));
            }
         }

         var2.method11796();
      }
   }

   private ScriptSettingsAdapter() {
      throw new UnsupportedOperationException(field02240);
   }

   public static void method00983(Script var0) {
      var var1 = method00977(var0);
      if (!var1.isEmpty()) {
         ScriptDataStorage var2 = new ScriptDataStorage(method00973(var0), field02238);

         for (Setting var4 : var1) {
            String var5 = var2.method11801(var4.id());
            if (var5 != null) {
               method00980(() -> var4.read(var5));
            }
         }
      }
   }
}
