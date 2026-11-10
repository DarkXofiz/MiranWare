// Original binary: sg/ec/LclImQpiJGpmOWUc
package sg.ec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.awt.Color;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;

// $VF: Compiled from s
public class ModuleConfigStorage extends AbstractStorage {
   private static volatile boolean field09902 = false;
   private static final String field09903 = "Modules";
   private static final String field09904 = "HudElements";
   private static final String field09905 = "Modules";
   private static final String field09906 = "HudElements";
   private static final String field09907 = "Modules";
   private static final String field09908 = "HudElements";
   private static final String field09909 = "Modules";
   private static final String field09910 = "HudElements";
   private static final String field09911 = "Modules";
   private static final String field09912 = "isEnabled";
   private static final String field09913 = "isEnabled";
   private static final String field09914 = "keyBind";
   private static final String field09915 = "keyBind";
   private static final String field09916 = "keyBindType";
   private static final String field09917 = "keyBindType";
   private static final String field09918 = "Modules";
   private static final String field09919 = "HudElements";
   private static final String field09920 = "isEnabled";
   private static final String field09921 = "keyBind";
   private static final String field09922 = "keyBindType";
   private static final String field09923 = "input";
   private static final String field09924 = "type";
   private static final String field09925 = "visible";
   private static final String field09926 = "value";
   private static final String field09927 = "bind";
   private static final String field09928 = "value";
   private static final String field09929 = "bind";
   private static final String field09930 = "name";
   private static final String field09931 = "value";
   private static final String field09932 = "item";
   private static final String field09933 = "skin";
   private static final String field09934 = "name";
   private static final String field09935 = "input";
   private static final String field09936 = "input";
   private static final String field09937 = "type";
   private static final String field09938 = "type";
   private static final String field09939 = "visible";
   private static final String field09940 = "visible";
   private static final String field09941 = "value";
   private static final String field09942 = "value";
   private static final String field09943 = "bind";
   private static final String field09944 = "bind";
   private static final String field09945 = "value";
   private static final String field09946 = "value";
   private static final String field09947 = "bind";
   private static final String field09948 = "bind";
   private static final String field09949 = "name";
   private static final String field09950 = "name";
   private static final String field09951 = "value";
   private static final String field09952 = "value";
   private static final String field09953 = "item";
   private static final String field09954 = "skin";
   private static final String field09955 = "name";
   private static final String field09956 = "HudElements";

   private static void method04437(Object var0) {
      for (Class var1 = var0.getClass(); var1 != null && var1 != Object.class; var1 = var1.getSuperclass()) {
         for (Field sx : var1.getDeclaredFields()) {
            Priority sxx = sx.getAnnotation(Priority.class);
            if (sxx != null) {
               try {
                  sx.setAccessible(true);
                  if (sx.get(var0) instanceof Setting sxxx) {
                     sxxx.method03020(sxx.value());
                  }
               } catch (Exception var9) {
               }
            }
         }
      }
   }

   private static String method04438(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && var2.isJsonPrimitive() ? var2.getAsString() : null;
   }

   private static void method04439() {
      if (!field09902) {
         synchronized (ModuleConfigStorage.class) {
            if (!field09902) {
               for (ToggleableModule var2 : ModuleManager.INSTANCE.method05138()) {
                  method04437(var2);
               }

               for (HudElement var6 : ModuleManager.INSTANCE.method08274().method04953().method00028()) {
                  method04437(var6);
               }

               field09902 = true;
            }
         }
      }
   }

   private static boolean method04440(JsonObject var0) {
      try {
         method04439();
         JsonObject var1 = var0.getAsJsonObject(field09956);
         if (var1 == null) {
            return true;
         }

         for (HudElement var3 : ModuleManager.INSTANCE.method08274().method04953().method00028()) {
            JsonObject var4 = var1.getAsJsonObject(var3.method06462().toLowerCase());
            if (var4 != null) {
               for (Setting var6 : var3.method03026()) {
                  method04446(var4, var6);
               }
            }
         }

         return true;
      } catch (Exception var7) {
         return false;
      }
   }

   private static byte[] method04441() {
      JsonObject var0 = new JsonObject();
      var0.add(field09903, method04443());
      var0.add(field09904, method04448());
      Gson var1 = new GsonBuilder().setPrettyPrinting().create();
      return var1.toJson(var0).getBytes();
   }

   private static boolean method04442(JsonObject var0) {
      try {
         method04439();
         JsonObject var1 = var0.getAsJsonObject(field09911);
         if (var1 == null) {
            return false;
         }

         for (ToggleableModule var3 : ModuleManager.INSTANCE.method05138()) {
            String var4 = var3.method03925().toLowerCase();
            JsonObject var5 = var1.getAsJsonObject(var4);
            if (var5 != null) {
               if (var5.has(field09912)) {
                  var3.method03939(var5.get(field09913).getAsBoolean());
               }

               if (var5.has(field09914)) {
                  JsonElement var6 = var5.get(field09915);
                  if (var6.isJsonPrimitive()) {
                     if (var6.getAsJsonPrimitive().isString()) {
                        var3.method03930().method05872(KeyboardKey.method00361(var6.getAsString()));
                     } else if (var6.getAsJsonPrimitive().isNumber()) {
                        var3.method03930().method05872(var6.getAsInt());
                     }
                  }
               }

               if (var5.has(field09916)) {
                  try {
                     var3.method03930().method05870(KeyBindingMode.valueOf(var5.get(field09917).getAsString()));
                  } catch (Exception var8) {
                  }
               }

               for (Setting var7 : var3.method03026()) {
                  method04446(var5, var7);
               }
            }
         }

         return true;
      } catch (Exception var9) {
         return false;
      }
   }

   private static JsonObject method04443() {
      method04439();
      JsonObject var0 = new JsonObject();

      for (ToggleableModule var2 : ModuleManager.INSTANCE.method05138()) {
         JsonObject var3 = new JsonObject();
         var3.addProperty(field09920, var2.method03937());
         var3.addProperty(field09921, KeyboardKey.method00360(var2.method03930().method05871()));
         var3.addProperty(field09922, var2.method03930().method05874().name());

         for (Setting var5 : var2.method03026()) {
            method04445(var3, var5);
         }

         var0.add(var2.method03925().toLowerCase(), var3);
      }

      return var0;
   }

   public static byte[] method04444() {
      try {
         JsonObject var0 = new JsonObject();
         var0.add(field09918, new JsonObject());
         var0.add(field09919, new JsonObject());
         return CustomResourceManager.method02469(new GsonBuilder().setPrettyPrinting().create().toJson(var0).getBytes());
      } catch (Exception var1) {
         return new byte[0];
      }
   }

   private static void method04445(JsonObject var0, Setting<?> var1) {
      if (var1 instanceof KeyBindSetting var2) {
         KeyBinding var11 = var2.method03022();
         JsonObject var12 = new JsonObject();
         var12.addProperty(field09923, KeyboardKey.method00360(var11.method05871()));
         var12.addProperty(field09924, var11.method05874().name());
         var12.addProperty(field09925, var11.method05873());
         var0.add(var1.method03008(), var12);
      } else if (var1 instanceof ColorSetting var3) {
         var0.addProperty(var1.method03008(), var3.method03022().getRGB());
      } else if (var1 instanceof ModeSetting var4) {
         var0.addProperty(var1.method03008(), var4.method03022());
      } else if (var1 instanceof NumberSetting var5) {
         var0.addProperty(var1.method03008(), (Number)var5.method03022());
      } else if (var1 instanceof SliderSetting var6) {
         var0.addProperty(var1.method03008(), var6.method03022());
      } else if (var1 instanceof ToggleSetting var7) {
         JsonObject var15 = new JsonObject();
         var15.addProperty(field09926, var7.method05999());
         var15.addProperty(field09927, var7.field13574.method05871());
         var0.add(var1.method03008(), var15);
      } else if (var1 instanceof BooleanSetting var8) {
         JsonObject var16 = new JsonObject();
         var16.addProperty(field09928, var8.method04706());
         var16.addProperty(field09929, var8.field10290.method05871());
         var0.add(var1.method03008(), var16);
      } else if (var1 instanceof MultiToggleSetting var9) {
         JsonArray var17 = new JsonArray();

         for (NamedOption var13 : var9.method03022()) {
            JsonObject var14 = new JsonObject();
            var14.addProperty(field09930, var13.method08080());
            var14.addProperty(field09931, (Boolean)var13.method08074());
            var17.add(var14);
         }

         var0.add(var1.method03008(), var17);
      } else if (var1 instanceof ItemFilterSetting var10) {
         JsonObject var18 = new JsonObject();
         ItemFilterSetting.Nested29 var20 = var10.method03022();
         if (var20 != null) {
            var18.addProperty(field09932, var20.itemId());
            var18.addProperty(field09933, var20.skin());
            var18.addProperty(field09934, var20.name());
         }

         var0.add(var1.method03008(), var18);
      }
   }

   @Override
   public boolean method00296() {
      try (FileOutputStream var1 = new FileOutputStream(this.method03303())) {
         var1.write(CustomResourceManager.method02469(method04441()));
         return true;
      } catch (IOException var6) {
         return false;
      }
   }

   private static void method04446(JsonObject var0, Setting<?> var1) {
      JsonElement var2 = var0.get(var1.method03008());
      if (var2 != null && !var2.isJsonNull()) {
         if (var1 instanceof NumberSetting var3 && var2.isJsonPrimitive()) {
            var3.method10837(var2.getAsFloat());
         } else if (var1 instanceof SliderSetting var4 && var2.isJsonPrimitive()) {
            var4.method03014(var2.getAsFloat());
         } else if (var1 instanceof ColorSetting var5 && var2.isJsonPrimitive()) {
            var5.method11672(new Color(var2.getAsInt()));
         } else if (var1 instanceof ModeSetting var6 && var2.isJsonPrimitive()) {
            var6.method05603(var2.getAsString());
         } else if (var1 instanceof KeyBindSetting var7) {
            KeyBinding var12 = var7.method03022();
            if (var2.isJsonObject()) {
               JsonObject var13 = var2.getAsJsonObject();
               if (var13.has(field09935)) {
                  JsonElement var14 = var13.get(field09936);
                  if (var14.isJsonPrimitive() && var14.getAsJsonPrimitive().isString()) {
                     var12.method05872(KeyboardKey.method00361(var14.getAsString()));
                  } else if (var14.isJsonPrimitive() && var14.getAsJsonPrimitive().isNumber()) {
                     var12.method05872(var14.getAsInt());
                  }
               }

               if (var13.has(field09937)) {
                  try {
                     var12.method05870(KeyBindingMode.valueOf(var13.get(field09938).getAsString()));
                  } catch (Exception var18) {
                  }
               }

               if (var13.has(field09939)) {
                  var12.method05875(var13.get(field09940).getAsBoolean());
               }
            } else if (var2.isJsonPrimitive()) {
               if (var2.getAsJsonPrimitive().isString()) {
                  var12.method05872(KeyboardKey.method00361(var2.getAsString()));
               } else if (var2.getAsJsonPrimitive().isNumber()) {
                  var12.method05872(var2.getAsInt());
               }
            }
         } else if (var1 instanceof ToggleSetting var8) {
            if (var2.isJsonObject() && var2.getAsJsonObject().has(field09941)) {
               var8.method03014(var2.getAsJsonObject().get(field09942).getAsBoolean());
            } else if (var2.isJsonPrimitive()) {
               var8.method03014(var2.getAsBoolean());
            }

            if (var2.isJsonObject() && var2.getAsJsonObject().has(field09943)) {
               var8.method05997().method05872(var2.getAsJsonObject().get(field09944).getAsInt());
            }
         } else if (var1 instanceof BooleanSetting var9) {
            if (var2.isJsonObject() && var2.getAsJsonObject().has(field09945)) {
               var9.method03014(var2.getAsJsonObject().get(field09946).getAsBoolean());
            } else if (var2.isJsonPrimitive()) {
               var9.method03014(var2.getAsBoolean());
            }

            if (var2.isJsonObject() && var2.getAsJsonObject().has(field09947)) {
               var9.method04704().method05872(var2.getAsJsonObject().get(field09948).getAsInt());
            }
         } else if (var1 instanceof MultiToggleSetting var10) {
            JsonElement var19 = var0.get(var1.method03008());
            if (var19 == null || var19.isJsonNull()) {
               return;
            }

            if (var19.isJsonArray()) {
               for (JsonElement var23 : var19.getAsJsonArray()) {
                  if (var23.isJsonObject()) {
                     JsonObject var15 = var23.getAsJsonObject();
                     if (var15.has(field09949)) {
                        String var16 = var15.get(field09950).getAsString();
                        boolean var17 = var15.has(field09951) && var15.get(field09952).getAsBoolean();
                        var10.method04519(var16, var17);
                     }
                  }
               }
            } else if (var19.isJsonObject()) {
               JsonObject var22 = var19.getAsJsonObject();

               for (String var25 : var22.keySet()) {
                  JsonElement var26 = var22.get(var25);
                  if (var26 != null && var26.isJsonPrimitive()) {
                     var10.method04519(var25, var26.getAsBoolean());
                  }
               }
            }
         } else if (var1 instanceof ItemFilterSetting var11 && var2.isJsonObject()) {
            JsonObject var20 = var2.getAsJsonObject();
            var11.method00871(ItemFilterSetting.Nested29.parse(method04438(var20, field09953), method04438(var20, field09954), method04438(var20, field09955)));
         }
      }
   }

   public ModuleConfigStorage(File var1) {
      super(var1);
   }

   @Override
   public boolean method00298() {
      if (!this.method03303().exists()) {
         return false;
      }

      try (FileInputStream var1 = new FileInputStream(this.method03303())) {
         byte[] var2 = var1.readAllBytes();
         byte[] var3 = CustomResourceManager.method02470(var2);
         if (var3 != null && var3.length > 0) {
            JsonElement var4 = JsonParser.parseString(new String(var3));
            if (var4 != null && var4.isJsonObject()) {
               JsonObject var5 = var4.getAsJsonObject();
               boolean var6 = true;
               if (var5.has(field09905)) {
                  var6 = method04442(var5);
               }

               boolean var7 = !var5.has(field09906) || method04440(var5);
               return var6 && var7;
            }
         }
      } catch (Exception var14) {
      }

      try (FileReader var15 = new FileReader(this.method03303())) {
         JsonElement var16 = JsonParser.parseReader(var15);
         if (var16 != null && var16.isJsonObject()) {
            JsonObject var17 = var16.getAsJsonObject();
            boolean var18 = true;
            if (var17.has(field09907)) {
               var18 = method04442(var17);
            }

            boolean var19 = !var17.has(field09908) || method04440(var17);
            return var18 && var19;
         }
      } catch (Exception var12) {
      }

      return false;
   }

   public static byte[] method04447() {
      try {
         return CustomResourceManager.method02469(method04441());
      } catch (Exception var1) {
         return new byte[0];
      }
   }

   private static JsonObject method04448() {
      method04439();
      JsonObject var0 = new JsonObject();

      for (HudElement var2 : ModuleManager.INSTANCE.method08274().method04953().method00028()) {
         JsonObject var3 = new JsonObject();

         for (Setting var5 : var2.method03026()) {
            method04445(var3, var5);
         }

         var0.add(var2.method06462().toLowerCase(), var3);
      }

      return var0;
   }

   private static JsonObject method04449(byte[] var0) {
      if (var0 != null && var0.length != 0) {
         try {
            byte[] var1 = CustomResourceManager.method02470(var0);
            if (var1 != null && var1.length > 0) {
               JsonElement var2 = JsonParser.parseString(new String(var1));
               if (var2 != null && var2.isJsonObject()) {
                  return var2.getAsJsonObject();
               }
            }
         } catch (Exception var4) {
         }

         try {
            JsonElement var5 = JsonParser.parseString(new String(var0, StandardCharsets.UTF_8));
            if (var5 != null && var5.isJsonObject()) {
               return var5.getAsJsonObject();
            }
         } catch (Exception var3) {
         }

         return null;
      } else {
         return null;
      }
   }

   public static boolean method04450(byte[] var0) {
      JsonObject var1 = method04449(var0);
      if (var1 == null) {
         return false;
      }

      boolean var2 = !var1.has(field09909) || method04442(var1);
      boolean var3 = !var1.has(field09910) || method04440(var1);
      return var2 && var3;
   }
}
