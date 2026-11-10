// Original binary: sg/ec/74DOSnBEnToxj3XE
package sg.ec;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import hex.script.api.Setting;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map.Entry;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.function.Supplier;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import net.minecraft.client.multiplayer.ServerData;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
final class ScriptMcpTools implements MinecraftAccess {
   private static final long field03760 = 15L;
   private static final int field03761 = 0;
   private static final int field03762 = 0;
   private static final int field03763 = 0;
   private static final String field03764 = "field03764";
   private static final String field03765 = "field03765";
   private final List<McpToolHandler> field03766 = new ArrayList<>();
   private static final String field03767 = "scripts_list";
   private static final String field03768 = "Список загруженных скриптов: имя, jar-файл, включён ли, упал ли, нужен ли перезапуск Minecraft для миксинов (restartRequired), описание, число настроек.";
   private static final String field03769 = "script_read";
   private static final String field03770 = "Исходники (java/ и mixin/) и список ресурсов скрипта. name — имя скрипта или jar без расширения.";
   private static final String field03771 = "name";
   private static final String field03772 = "string";
   private static final String field03773 = "Имя скрипта";
   private static final String field03774 = "name";
   private static final String field03775 = "script_write";
   private static final String field03776 = "Записать файлы в jar скрипта и сразу перезагрузить скрипты. Пути: java/pkg/Foo.java для исходников (или просто pkg/Foo.java), mixin/scriptmixin/<имя jar в нижнем регистре>/Foo.java для миксинов, resources/... для ресурсов. Остальное содержимое jar сохраняется. Миксины вшиваются только при запуске Minecraft: изменённые компилируются для проверки, а скрипт попадает в restartRequired. Возвращает ошибки компиляции и новые строки консоли. Нового скрипта ещё нет — jar создастся.";
   private static final String field03777 = "name";
   private static final String field03778 = "string";
   private static final String field03779 = "Имя скрипта или jar без расширения";
   private static final String field03780 = "files";
   private static final String field03781 = "object";
   private static final String field03782 = "Объект путь → содержимое файла (текст)";
   private static final String field03783 = "remove";
   private static final String field03784 = "Пути, которые удалить из jar";
   private static final String field03785 = "name";
   private static final String field03786 = "files";
   private static final String field03787 = "scripts_reload";
   private static final String field03788 = "Перезагрузить все скрипты из папки scripts. Возвращает число загруженных, проблемы компиляции и скрипты, которым нужен перезапуск Minecraft (restartRequired).";
   private static final String field03789 = "script_toggle";
   private static final String field03790 = "Включить или выключить скрипт.";
   private static final String field03791 = "name";
   private static final String field03792 = "string";
   private static final String field03793 = "Имя скрипта";
   private static final String field03794 = "enabled";
   private static final String field03795 = "boolean";
   private static final String field03796 = "true — включить";
   private static final String field03797 = "name";
   private static final String field03798 = "enabled";
   private static final String field03799 = "script_settings";
   private static final String field03800 = "Настройки скрипта: id, имя, тип, текущее значение, видимость.";
   private static final String field03801 = "name";
   private static final String field03802 = "string";
   private static final String field03803 = "Имя скрипта";
   private static final String field03804 = "name";
   private static final String field03805 = "script_setting_set";
   private static final String field03806 = "Задать значение настройки скрипта по id. Значение — строка в том виде, в каком его отдаёт script_settings.";
   private static final String field03807 = "name";
   private static final String field03808 = "string";
   private static final String field03809 = "Имя скрипта";
   private static final String field03810 = "id";
   private static final String field03811 = "string";
   private static final String field03812 = "id настройки";
   private static final String field03813 = "value";
   private static final String field03814 = "string";
   private static final String field03815 = "Новое значение";
   private static final String field03816 = "name";
   private static final String field03817 = "id";
   private static final String field03818 = "value";
   private static final String field03819 = "console_read";
   private static final String field03820 = "Журнал консоли скриптов. since — вернуть строки с seq больше указанного (для чтения «с места»), limit — не больше N последних, level — info|warn|error.";
   private static final String field03821 = "since";
   private static final String field03822 = "integer";
   private static final String field03823 = "Последний уже прочитанный seq";
   private static final String field03824 = "limit";
   private static final String field03825 = "integer";
   private static final String field03826 = "Максимум строк";
   private static final String field03827 = "level";
   private static final String field03828 = "string";
   private static final String field03829 = "Фильтр уровня";
   private static final String field03830 = "console_clear";
   private static final String field03831 = "Очистить консоль скриптов.";
   private static final String field03832 = "api_docs";
   private static final String field03833 = "Справка по API скриптов. Без path — гайд и список файлов исходников SDK; с path — текст файла (например hex/script/api/Script.java).";
   private static final String field03834 = "path";
   private static final String field03835 = "string";
   private static final String field03836 = "Путь внутри script-api-sources.jar";
   private static final String field03837 = "client_state";
   private static final String field03838 = "Состояние клиента: игрок, сервер, позиция, здоровье, открытый экран, активные скрипты.";
   private static final String field03839 = "name";
   private static final String field03840 = "file";
   private static final String field03841 = "enabled";
   private static final String field03842 = "failed";
   private static final String field03843 = "restartRequired";
   private static final String field03844 = "description";
   private static final String field03845 = "settings";
   private static final String field03846 = "scripts";
   private static final String field03847 = "folder";
   private static final String field03848 = "у скрипта нет jar (встроенный)";
   private static final String field03849 = ".java";
   private static final String field03850 = "name";
   private static final String field03851 = "file";
   private static final String field03852 = "sources";
   private static final String field03853 = "resources";
   private static final String field03854 = "name";
   private static final String field03855 = "files";
   private static final String field03856 = "files должен быть объектом путь → текст";
   private static final String field03857 = "remove";
   private static final String field03858 = "file";
   private static final String field03859 = "entries";
   private static final String field03860 = "console";
   private static final String field03861 = "loaded";
   private static final String field03862 = "problems";
   private static final String field03863 = "restartRequired";
   private static final String field03864 = "name";
   private static final String field03865 = "enabled";
   private static final String field03866 = "changed";
   private static final String field03867 = "failed";
   private static final String field03868 = "id";
   private static final String field03869 = "name";
   private static final String field03870 = "type";
   private static final String field03871 = "description";
   private static final String field03872 = "value";
   private static final String field03873 = "visible";
   private static final String field03874 = "name";
   private static final String field03875 = "settings";
   private static final String field03876 = "id";
   private static final String field03877 = "changed";
   private static final String field03878 = "value";
   private static final String field03879 = "since";
   private static final String field03880 = "since";
   private static final long field03881 = -1L;
   private static final String field03882 = "limit";
   private static final String field03883 = "limit";
   private static final String field03884 = "level";
   private static final int field03885 = Integer.MAX_VALUE;
   private static final String field03886 = "lines";
   private static final String field03887 = "last_seq";
   private static final String field03888 = "total";
   private static final String field03889 = "script-api-sources.jar";
   private static final String field03890 = "script-api-sources.jar не найден в scripts/.api";
   private static final String field03891 = "path";
   private static final String field03892 = "content";
   private static final String field03893 = ".java";
   private static final String field03894 = "guide";
   private static final String field03895 = "files";
   private static final String field03896 = "README.txt";
   private static final String field03897 = "server";
   private static final String field03898 = "screen";
   private static final String field03899 = "name";
   private static final String field03900 = "x";
   private static final String field03901 = "y";
   private static final String field03902 = "z";
   private static final String field03903 = "health";
   private static final String field03904 = "player";
   private static final String field03905 = "scripts_active";
   private static final String field03906 = "scripts_total";
   private static final String field03907 = ".jar";
   private static final String field03908 = ".jar";
   private static final String field03909 = ".jar";
   private static final String field03910 = ".jar";
   private static final String field03911 = "[A-Za-z0-9_\\-]+";
   private static final String field03912 = "имя нового скрипта: только латиница, цифры, _ и -";
   private static final String field03913 = "info";
   private static final String field03914 = "warn";
   private static final String field03915 = "error";
   private static final String field03916 = "level: info, warn или error";
   private static final String field03917 = "seq";
   private static final String field03918 = "time";
   private static final String field03919 = "level";
   private static final String field03920 = "source";
   private static final String field03921 = "text";
   private static final String field03922 = "ok";
   private static final long field03923 = 15L;
   private static final String field03924 = "__name";
   private static final String field03925 = "type";
   private static final String field03926 = "object";
   private static final String field03927 = "properties";
   private static final String field03928 = "required";
   private static final String field03929 = "__name";
   private static final String field03930 = "type";
   private static final String field03931 = "description";
   private static final String field03932 = "array";
   private static final String field03933 = "type";
   private static final String field03934 = "string";
   private static final String field03935 = "items";
   private static final String field03936 = "__name";
   private static final String field03937 = "path";
   private static final String field03938 = "name";
   private static final String field03939 = "id";
   private static final String field03940 = "value";
   private static final String field03941 = "name";
   private static final String field03942 = "name";
   private static final String field03943 = "enabled";
   private static final String field03944 = "name";

   private JsonElement method01578(String var1) {
      LoadedScript var2 = method01580(var1);
      JsonArray var3 = new JsonArray();

      for (Setting var5 : ScriptSettingsAdapter.method00977(var2.method03393())) {
         JsonObject var6 = new JsonObject();
         var6.addProperty(field03868, var5.id());
         var6.addProperty(field03869, var5.name());
         var6.addProperty(field03870, var5.getClass().getSimpleName());
         var6.addProperty(field03871, var5.description());
         var6.addProperty(field03872, var5.write());
         var6.addProperty(field03873, var5.visible());
         var3.add(var6);
      }

      JsonObject var7 = new JsonObject();
      var7.addProperty(field03874, var2.method03400());
      var7.add(field03875, var3);
      return var7;
   }

   private static String method01579(LoadedScript var0) {
      ScriptSourceLoader var1 = ScriptLifecycle.method03298(var0.method03393());
      return var1 == null ? null : var1.method08403().getName();
   }

   private static LoadedScript method01580(String var0) {
      String var1 = var0.toLowerCase(Locale.ROOT);
      if (var1.endsWith(field03907)) {
         var1 = var1.substring(0, var1.length() - field03908.length());
      }

      for (LoadedScript var3 : ScriptRuntime.INSTANCE.method06229()) {
         if (var3.method03400().toLowerCase(Locale.ROOT).equals(var1)) {
            return var3;
         }

         String var4 = method01579(var3);
         if (var4 != null && var4.toLowerCase(Locale.ROOT).equals(var1 + ".jar")) {
            return var3;
         }
      }

      throw new McpToolHandler.Nested154("скрипт не найден: " + var0);
   }

   List<McpToolHandler> method01582() {
      return this.field03766;
   }

   private static JsonObject method01583(String var0, String var1) {
      JsonObject var2 = method01610(var0, field03932, var1);
      JsonObject var3 = new JsonObject();
      var3.addProperty(field03933, field03934);
      var2.add(field03935, var3);
      return var2;
   }

   private JsonElement method01586(String var1, String var2, String var3) {
      LoadedScript var4 = method01580(var1);
      var var5 = ScriptSettingsAdapter.method00981(var4.method03393(), var2);
      if (var5 == null) {
         throw new McpToolHandler.Nested154("нет настройки с id " + var2);
      }

      boolean var6 = ScriptRuntime.INSTANCE.method06225(var4, var2, var3);
      JsonObject var7 = new JsonObject();
      var7.addProperty(field03876, var2);
      var7.addProperty(field03877, var6);
      var7.addProperty(field03878, var5.write());
      return var7;
   }

   private JsonElement method01587(JsonObject var1) throws Exception {
      String var2 = method01593(var1, field03854);
      JsonElement var3 = var1.get(field03855);
      if (var3 != null && var3.isJsonObject()) {
         LinkedHashMap var4 = new LinkedHashMap();

         for (var var6 : var3.getAsJsonObject().entrySet()) {
            var4.put((String)var6.getKey(), ((JsonElement)var6.getValue()).getAsString());
         }

         ArrayList var13 = new ArrayList();
         JsonElement var14 = var1.get(field03857);
         if (var14 != null && var14.isJsonArray()) {
            for (JsonElement var8 : var14.getAsJsonArray()) {
               var13.add(var8.getAsString());
            }
         }

         File var15 = method01615(() -> this.method01601(var2));

         List var16;
         try {
            var16 = ScriptSourcePaths.method09895(var15, var4, var13);
         } catch (IOException var12) {
            throw new McpToolHandler.Nested154("не удалось записать jar: " + var12.getMessage());
         }

         long var9 = ScriptLogManager.INSTANCE.method08087();
         JsonObject var11 = method01615(this::method01608).getAsJsonObject();
         var11.addProperty(field03858, var15.getName());
         var11.add(field03859, method01616(var16));
         var11.add(field03860, method01590(ScriptLogManager.INSTANCE.method08086(var9, 200)));
         return var11;
      } else {
         throw new McpToolHandler.Nested154(field03856);
      }
   }

   private JsonElement method01588() {
      JsonObject var1 = new JsonObject();
      ServerData var2 = mc.getCurrentServer();
      var1.addProperty(field03897, var2 == null ? null : var2.ip);
      String var3 = mc.screen == null ? null : mc.screen.getClass().getSimpleName();
      var1.addProperty(field03898, var3);
      if (mc.player != null) {
         Vec3 var4 = mc.player.position();
         JsonObject var5 = new JsonObject();
         var5.addProperty(field03899, mc.player.getName().getString());
         var5.addProperty(field03900, var4.x);
         var5.addProperty(field03901, var4.y);
         var5.addProperty(field03902, var4.z);
         var5.addProperty(field03903, mc.player.getHealth());
         var1.add(field03904, var5);
      }

      int var7 = 0;

      for (LoadedScript var6 : ScriptRuntime.INSTANCE.method06229()) {
         if (var6.method03392()) {
            var7++;
         }
      }

      var1.addProperty(field03905, var7);
      var1.addProperty(field03906, ScriptRuntime.INSTANCE.method06229().size());
      return var1;
   }

   private static JsonObject method01589() {
      JsonObject var0 = new JsonObject();
      var0.addProperty(field03922, true);
      return var0;
   }

   private static JsonArray method01590(List<ScriptLogManager.Nested233> var0) {
      JsonArray var1 = new JsonArray();

      for (ScriptLogManager.Nested233 var3 : var0) {
         JsonObject var4 = new JsonObject();
         var4.addProperty(field03917, var3.seq());
         var4.addProperty(field03918, var3.stamp());
         var4.addProperty(field03919, ScriptLogManager.method08100(var3.level()));
         var4.addProperty(field03920, var3.source());
         var4.addProperty(field03921, var3.text());
         var1.add(var4);
      }

      return var1;
   }

   private static String method01593(JsonObject var0, String var1) {
      String var2 = method01614(var0, var1);
      if (var2 != null && !var2.isBlank()) {
         return var2;
      } else {
         throw new McpToolHandler.Nested154("нужен аргумент " + var1);
      }
   }

   ScriptMcpTools() {
      this.field03766.add(new McpToolHandler(field03767, field03768, method01606(), var1 -> method01615(this::method01595)));
      this.field03766
         .add(
            new McpToolHandler(
               field03769,
               field03770,
               method01606(method01610(field03771, field03772, field03773), field03774),
               var1 -> method01615(() -> this.method01607(method01593(var1, field03944)))
            )
         );
      this.field03766
         .add(
            new McpToolHandler(
               field03775,
               field03776,
               method01606(
                  method01610(field03777, field03778, field03779),
                  method01610(field03780, field03781, field03782),
                  method01583(field03783, field03784),
                  field03785,
                  field03786
               ),
               this::method01587
            )
         );
      this.field03766.add(new McpToolHandler(field03787, field03788, method01606(), var1 -> method01615(this::method01608)));
      this.field03766
         .add(
            new McpToolHandler(
               field03789,
               field03790,
               method01606(method01610(field03791, field03792, field03793), method01610(field03794, field03795, field03796), field03797, field03798),
               var1 -> method01615(() -> this.method01597(method01593(var1, field03942), var1.get(field03943).getAsBoolean()))
            )
         );
      this.field03766
         .add(
            new McpToolHandler(
               field03799,
               field03800,
               method01606(method01610(field03801, field03802, field03803), field03804),
               var1 -> method01615(() -> this.method01578(method01593(var1, field03941)))
            )
         );
      this.field03766
         .add(
            new McpToolHandler(
               field03805,
               field03806,
               method01606(
                  method01610(field03807, field03808, field03809),
                  method01610(field03810, field03811, field03812),
                  method01610(field03813, field03814, field03815),
                  field03816,
                  field03817,
                  field03818
               ),
               var1 -> method01615(() -> this.method01586(method01593(var1, field03938), method01593(var1, field03939), method01593(var1, field03940)))
            )
         );
      this.field03766
         .add(
            new McpToolHandler(
               field03819,
               field03820,
               method01606(
                  method01610(field03821, field03822, field03823),
                  method01610(field03824, field03825, field03826),
                  method01610(field03827, field03828, field03829)
               ),
               var1 -> this.method01618(var1)
            )
         );
      this.field03766.add(new McpToolHandler(field03830, field03831, method01606(), var0 -> {
         ScriptLogManager.INSTANCE.method08089();
         return method01589();
      }));
      this.field03766
         .add(
            new McpToolHandler(
               field03832, field03833, method01606(method01610(field03834, field03835, field03836)), var1 -> this.method01603(method01614(var1, field03937))
            )
         );
      this.field03766.add(new McpToolHandler(field03837, field03838, method01606(), var1 -> method01615(this::method01588)));
   }

   private JsonElement method01595() {
      JsonArray var1 = new JsonArray();

      for (LoadedScript var3 : ScriptRuntime.INSTANCE.method06229()) {
         if (var3.method03398() != null) {
            JsonObject var4 = new JsonObject();
            var4.addProperty(field03839, var3.method03400());
            var4.addProperty(field03840, method01579(var3));
            var4.addProperty(field03841, var3.method03392());
            var4.addProperty(field03842, var3.method03391());
            var4.addProperty(field03843, ScriptRuntime.INSTANCE.method06178(var3));
            var4.addProperty(field03844, var3.method03398().method03926());
            var4.addProperty(field03845, ScriptSettingsAdapter.method00977(var3.method03393()).size());
            var1.add(var4);
         }
      }

      JsonObject var5 = new JsonObject();
      var5.add(field03846, var1);
      var5.addProperty(field03847, method01596().getAbsolutePath());
      return var5;
   }

   private static File method01596() {
      return ScriptRuntime.INSTANCE.method06231().method05737();
   }

   private JsonElement method01597(String var1, boolean var2) {
      LoadedScript var3 = method01580(var1);
      boolean var4 = var2 ? ScriptRuntime.INSTANCE.method06184(var3) : ScriptRuntime.INSTANCE.method06185(var3);
      if (var3.method03398() != null && var3.method03398().method03937() != var3.method03392()) {
         var3.method03398().method03939(var3.method03392());
      }

      JsonObject var5 = new JsonObject();
      var5.addProperty(field03864, var3.method03400());
      var5.addProperty(field03865, var3.method03392());
      var5.addProperty(field03866, var4);
      var5.addProperty(field03867, var3.method03391());
      return var5;
   }

   private File method01601(String var1) {
      try {
         ScriptSourceLoader var2 = ScriptLifecycle.method03298(method01580(var1).method03393());
         if (var2 != null) {
            return var2.method08403();
         }
      } catch (McpToolHandler.Nested154 var3) {
      }

      String var4 = var1.endsWith(field03909) ? var1.substring(0, var1.length() - field03910.length()) : var1;
      if (!var4.isBlank() && var4.matches(field03911)) {
         return new File(method01596(), var4 + ".jar");
      } else {
         throw new McpToolHandler.Nested154(field03912);
      }
   }

   private JsonElement method01603(String var1) {
      File var2 = ScriptApiExporter.method03131(method01596(), field03889);
      if (!var2.isFile()) {
         throw new McpToolHandler.Nested154(field03890);
      }

      JsonObject var3 = new JsonObject();

      try (JarFile var4 = new JarFile(var2)) {
         if (var1 != null && !var1.isBlank()) {
            JarEntry var14 = var4.getJarEntry(var1.replace('\\', '/'));
            if (var14 == null) {
               throw new McpToolHandler.Nested154("нет файла " + var1);
            }

            try (InputStream var15 = var4.getInputStream(var14)) {
               var3.addProperty(field03891, var1);
               var3.addProperty(field03892, new String(var15.readAllBytes(), StandardCharsets.UTF_8));
            }

            return var3;
         } else {
            JsonArray var5 = new JsonArray();

            for (JarEntry var7 : var4.stream().toList()) {
               if (!var7.isDirectory() && var7.getName().endsWith(field03893)) {
                  var5.add(var7.getName());
               }
            }

            var3.addProperty(field03894, this.method01612());
            var3.add(field03895, var5);
            return var3;
         }
      } catch (IOException var13) {
         throw new McpToolHandler.Nested154("SDK не читается: " + var13.getMessage());
      }
   }

   McpToolHandler method01604(String var1) {
      for (McpToolHandler var3 : this.field03766) {
         if (var3.name().equals(var1)) {
            return var3;
         }
      }

      return null;
   }

   private static JsonObject method01605(JsonObject var0) {
      JsonObject var1 = var0.deepCopy();
      var1.remove(field03936);
      return var1;
   }

   private static JsonObject method01606(Object... var0) {
      JsonObject var1 = new JsonObject();
      JsonArray var2 = new JsonArray();

      for (Object var6 : var0) {
         if (var6 instanceof JsonObject var7) {
            var1.add(var7.get(field03924).getAsString(), method01605(var7));
         } else {
            var2.add(var6.toString());
         }
      }

      JsonObject var8 = new JsonObject();
      var8.addProperty(field03925, field03926);
      var8.add(field03927, var1);
      if (!var2.isEmpty()) {
         var8.add(field03928, var2);
      }

      return var8;
   }

   private JsonElement method01607(String var1) {
      LoadedScript var2 = method01580(var1);
      ScriptSourceLoader var3 = ScriptLifecycle.method03298(var2.method03393());
      if (var3 == null) {
         throw new McpToolHandler.Nested154(field03848);
      }

      JsonObject var4 = new JsonObject();
      JsonArray var5 = new JsonArray();

      try (JarFile var6 = new JarFile(var3.method08403())) {
         for (JarEntry var8 : var6.stream().toList()) {
            if (!var8.isDirectory()) {
               String var9 = var8.getName().replace('\\', '/');
               if (var9.endsWith(field03849) && ScriptSourceType.method02857(var9) != null) {
                  try (InputStream var10 = var6.getInputStream(var8)) {
                     var4.addProperty(var9, new String(var10.readAllBytes(), StandardCharsets.UTF_8));
                  }
               } else {
                  var5.add(var9);
               }
            }
         }
      } catch (IOException var17) {
         throw new McpToolHandler.Nested154("jar не читается: " + var17.getMessage());
      }

      JsonObject var18 = new JsonObject();
      var18.addProperty(field03850, var2.method03400());
      var18.addProperty(field03851, var3.method08403().getName());
      var18.add(field03852, var4);
      var18.add(field03853, var5);
      return var18;
   }

   private JsonElement method01608() {
      int var1 = ScriptRuntime.INSTANCE.method06177();
      JsonObject var2 = new JsonObject();
      var2.addProperty(field03861, var1);
      var2.add(field03862, method01616(ScriptRuntime.INSTANCE.method06231().method05743()));
      var2.add(field03863, method01616(new ArrayList<>(ScriptRuntime.INSTANCE.method06231().method05735())));
      return var2;
   }

   private static JsonObject method01610(String var0, String var1, String var2) {
      JsonObject var3 = new JsonObject();
      var3.addProperty(field03929, var0);
      var3.addProperty(field03930, var1);
      var3.addProperty(field03931, var2);
      return var3;
   }

   private String method01612() {
      File var1 = ScriptApiExporter.method03131(method01596(), field03896);

      try {
         return var1.isFile() ? Files.readString(var1.toPath(), StandardCharsets.UTF_8) : "";
      } catch (IOException var3) {
         return "";
      }
   }

   private static String method01614(JsonObject var0, String var1) {
      JsonElement var2 = var0.get(var1);
      return var2 != null && !var2.isJsonNull() ? var2.getAsString() : null;
   }

   private static <T> T method01615(Supplier<T> var0) throws Exception {
      try {
         return mc.<T>submit(var0).get(field03923, TimeUnit.SECONDS);
      } catch (ExecutionException var4) {
         Throwable var2 = var4.getCause() == null ? var4 : var4.getCause();
         if (var2 instanceof McpToolHandler.Nested154 var3) {
            throw var3;
         } else {
            throw new McpToolHandler.Nested154(var2.getClass().getSimpleName() + ": " + var2.getMessage());
         }
      }
   }

   private static JsonArray method01616(List<String> var0) {
      JsonArray var1 = new JsonArray();

      for (String var3 : var0) {
         var1.add(var3);
      }

      return var1;
   }

   private static int method01617(String var0) {
      if (var0 != null && !var0.isBlank()) {
         return switch (var0.toLowerCase(Locale.ROOT)) {
            case field03913 -> 0;
            case field03914 -> 1;
            case field03915 -> 2;
            default -> throw new McpToolHandler.Nested154(field03916);
         };
      } else {
         return -1;
      }
   }

   private JsonElement method01618(JsonObject var1) {
      long var2 = var1.has(field03879) ? var1.get(field03880).getAsLong() : field03881;
      int var4 = var1.has(field03882) ? Math.min(1000, Math.max(1, var1.get(field03883).getAsInt())) : 100;
      int var5 = method01617(method01614(var1, field03884));
      var var6 = ScriptLogManager.INSTANCE.method08086(var2, field03885);
      List var7 = new ArrayList();

      for (ScriptLogManager.Nested233 var9 : var6) {
         if (var5 < 0 || var9.level() == var5) {
            var7.add(var9);
         }
      }

      int var10 = var7.size() - var4;
      if (var10 > 0) {
         var7 = var7.subList(var10, var7.size());
      }

      JsonObject var11 = new JsonObject();
      var11.add(field03886, method01590(var7));
      var11.addProperty(field03887, ScriptLogManager.INSTANCE.method08087());
      var11.addProperty(field03888, ScriptLogManager.INSTANCE.method08085());
      return var11;
   }
}
