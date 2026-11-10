// Original binary: sg/ec/DX9yl8LtroRbtmFW
package sg.ec;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

// $VF: Compiled from s
public final class ScriptApiExporter {
   public static final String field06942 = "script-api.jar";
   public static final String field06943 = "field06943";
   public static final String field06944 = "field06944";
   public static final String field06945 = "field06945";
   private static final String field06946 = "field06946";
   private static final String field06947 = ".api";
   private static final String field06948 = "script-api.jar";
   private static final String field06949 = "script-api.jar";
   private static final String field06950 = "script-api-sources.jar";
   private static final String field06951 = "script-api-sources.jar";
   private static final String field06952 = "README.txt";
   private static final String field06953 = "классы SDK не распакованы";
   private static final String field06954 = "SDK с исходниками в scripts/.api";
   private static final String field06955 = "SDK без исходников в scripts/.api";
   private static final String field06956 = "Библиотека скриптов MiranWare.\n\nscript-api.jar          — классы, их и подключают как библиотеку\nscript-api-sources.jar  — исходники с javadoc, дают подсказки и имена параметров\n\nСкрипт — это .jar рядом с этой папкой:\n\n  MyScript.jar\n    java/       — исходники, пакеты как обычно\n    mixin/      — миксины в пакете scriptmixin.myscript (имя jar в нижнем регистре)\n    resources/  — свои картинки, шрифты, данные\n\nМиксины вшиваются только при запуске Minecraft: после их правки клиент\nпометит скрипт «Нужен перезапуск». Классы из java/ миксину не видны —\nсвязь через хуки: Hooks.fire(\"myscript:событие\") в миксине и\nhook(\"myscript:событие\", ...) в скрипте.\n\nМиксинам закрыты ресурсы клиента: паки и ResourceManager, текстуры и\nNativeImage, шейдеры, звуки, шрифты, чтение GPU и кадра, файлы, сеть,\nрефлексия и классы клиента. Миксин с таким обращением не вшивается,\nпричина пишется в консоль скриптов.\n\nПути к ресурсам короткие и всегда относительно своего resources:\ndrawImage(\"logo.png\") и fonts().register(\"main\", \"sf_regular\")\nищут внутри того jar, который сейчас выполняется.\n\nДжарник можно подменять прямо в игре: клиент читает его целиком и сразу\nзакрывает, а когда файл перестаёт меняться, сам перезагружает скрипты.\nВручную — .script reload.\n\nIntelliJ IDEA:\n  1. File — Project Structure — Libraries — плюс — Java — выбрать script-api.jar\n  2. в той же библиотеке плюс — выбрать script-api-sources.jar, отметить Sources\n  3. Sources Root поставить на java внутри своего проекта скрипта\n\nФайлы перезаписываются при каждом запуске клиента, править их смысла нет.\n";
   private static final String field06957 = "This is a utility class and cannot be instantiated";

   public static File method03129(File var0) {
      return new File(var0, field06947);
   }

   public static boolean method03130(File var0) {
      return method03134(field06948, method03131(var0, field06949));
   }

   public static File method03131(File var0, String var1) {
      return new File(method03129(var0), var1);
   }

   private ScriptApiExporter() {
      throw new UnsupportedOperationException(field06957);
   }

   public static String method03132(File var0) {
      boolean var1 = method03130(var0);
      boolean var2 = method03134(field06950, method03131(var0, field06951));
      method03133(method03131(var0, field06952));
      if (!var1) {
         return field06953;
      } else {
         return var2 ? field06954 : field06955;
      }
   }

   private static void method03133(File var0) {
      try {
         Files.writeString(var0.toPath(), field06956, StandardCharsets.UTF_8);
      } catch (IOException var2) {
      }
   }

   private static boolean method03134(String var0, File var1) {
      File var2 = var1.getParentFile();
      if (!var2.isDirectory() && !var2.mkdirs()) {
         return false;
      }

      try (InputStream var3 = ScriptApiExporter.class.getResourceAsStream("/" + var0)) {
         if (var3 == null) {
            return false;
         }

         Files.copy(var3, var1.toPath(), StandardCopyOption.REPLACE_EXISTING);
         return true;
      } catch (IOException var8) {
         return false;
      }
   }
}
