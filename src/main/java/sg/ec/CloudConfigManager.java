// Original binary: sg/ec/zp1FQK9kJDrXTsqm
package sg.ec;

import net.minecraft.network.chat.ClickEvent;
import net.minecraft.network.chat.ClickEvent.CopyToClipboard;

// $VF: Compiled from s
public final class CloudConfigManager {
   private static final String field27937 = "Cloud";
   private static final String field27938 = "Ключ скопирован в буфер обмена.";

   private CloudConfigManager() {
   }

   public static void method11762(ClickEvent var0) {
      if (var0 instanceof CopyToClipboard var1 && KnownCloudConfigKeys.INSTANCE.method03166(var1.value())) {
         ChatTextUtils.method05101(field27937, field27938);
      }
   }
}
