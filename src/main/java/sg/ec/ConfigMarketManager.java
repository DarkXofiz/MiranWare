// Original binary: sg/ec/Mqbaq2SdoEmNLttt
package sg.ec;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import net.minecraft.util.Util;

// $VF: Compiled from s
public final class ConfigMarketManager {
   private static final SimpleDateFormat field10225 = new SimpleDateFormat(ConfigMarketManager.field10237);
   private static final String field10226 = "Market";
   private static final String field10227 = "Свободных ключей нет.";
   private static final String field10228 = "keys";
   private static final String field10229 = "Market";
   private static final String field10230 = "Не удалось создать папку для ключей.";
   private static final String field10231 = "Market";
   private static final String field10232 = "Не удалось записать ключи в файл.";
   private static final String field10233 = "Market";
   private static final String field10234 = "[^\\p{L}\\p{N}_.-]";
   private static final String field10235 = "_";
   private static final String field10236 = "keys";
   private static final String field10237 = "dd-MM-yy_HH-mm-ss";

   public static void method04673(String var0, List<String> var1) {
      if (var1 != null && !var1.isEmpty()) {
         File var2 = new File(ClientEnvironment.field07577, field10228);
         if (!var2.isDirectory() && !var2.mkdirs()) {
            ChatTextUtils.method05101(field10229, field10230);
         } else {
            File sx = new File(var2, method04674(var0) + "_" + field10225.format(new Date()) + ".txt");

            try {
               Files.write(sx.toPath(), var1, StandardCharsets.UTF_8);
            } catch (IOException sxx) {
               ChatTextUtils.method05101(field10231, field10232);
               return;
            }

            com.mojang.blaze3d.Blaze3D.openPath(sx.toPath());
            ChatTextUtils.method05101(field10233, "Ключей выгружено: " + var1.size());
         }
      } else {
         ChatTextUtils.method05101(field10226, field10227);
      }
   }

   private static String method04674(String var0) {
      String var1 = var0 == null ? "" : var0.replaceAll(field10234, field10235);
      return var1.isEmpty() ? field10236 : var1;
   }

   private ConfigMarketManager() {
   }
}
