// Original binary: sg/ec/tD6jmBAxrNR3yth5
package sg.ec;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import net.minecraft.server.packs.OverlayMetadataSection;
import net.minecraft.server.packs.OverlayMetadataSection.OverlayEntry;
import net.minecraft.server.packs.metadata.pack.PackFormat;
import net.minecraft.util.InclusiveRange;

// $VF: Compiled from s
public final class PackOverlayMetadata {
   private static final Pattern field23841 = Pattern.compile(PackOverlayMetadata.field23854);
   private static final int field23842 = 256;
   private static final String field23843 = "overlays";
   private static final String field23844 = "entries";
   private static final String field23845 = "directory";
   private static final String field23846 = "min_format";
   private static final String field23847 = "max_format";
   private static final String field23848 = "formats";
   private static final String field23849 = "min_inclusive";
   private static final String field23850 = "max_inclusive";
   private static final int field23851 = Integer.MAX_VALUE;
   private static final int field23852 = Integer.MAX_VALUE;
   private static final String field23853 = "This is a utility class and cannot be instantiated";
   private static final String field23854 = "[-_a-zA-Z0-9.]+";

   private static InclusiveRange<PackFormat> method10808(int var0, int var1) {
      return var0 <= var1 ? new InclusiveRange<>(PackFormat.of(var0), PackFormat.of(var1, field23851)) : null;
   }

   private PackOverlayMetadata() {
      throw new UnsupportedOperationException(field23853);
   }

   private static InclusiveRange<PackFormat> method10809(JsonObject var0) {
      PackFormat var1 = method10810(var0.get(field23846), false);
      PackFormat var2 = method10810(var0.get(field23847), true);
      if (var1 != null && var2 != null) {
         return var1.compareTo(var2) <= 0 ? new InclusiveRange<>(var1, var2) : null;
      }

      JsonElement var3 = var0.get(field23848);
      if (var3 == null) {
         return null;
      }

      if (var3.isJsonPrimitive() && var3.getAsJsonPrimitive().isNumber()) {
         return method10808(var3.getAsInt(), var3.getAsInt());
      }

      if (var3.isJsonArray() && var3.getAsJsonArray().size() == 2) {
         JsonArray var7 = var3.getAsJsonArray();
         return method10808(var7.get(0).getAsInt(), var7.get(1).getAsInt());
      }

      if (var3.isJsonObject()) {
         JsonObject var4 = var3.getAsJsonObject();
         JsonElement var5 = var4.get(field23849);
         JsonElement var6 = var4.get(field23850);
         if (var5 != null && var6 != null) {
            return method10808(var5.getAsInt(), var6.getAsInt());
         }
      }

      return null;
   }

   private static PackFormat method10810(JsonElement var0, boolean var1) {
      if (var0 == null) {
         return null;
      } else if (var0.isJsonPrimitive() && var0.getAsJsonPrimitive().isNumber()) {
         return var1 ? PackFormat.of(var0.getAsInt(), field23852) : PackFormat.of(var0.getAsInt());
      } else if (var0.isJsonArray() && var0.getAsJsonArray().size() == 2) {
         JsonArray var2 = var0.getAsJsonArray();
         return PackFormat.of(var2.get(0).getAsInt(), var2.get(1).getAsInt());
      } else {
         return null;
      }
   }

   public static OverlayMetadataSection method10811(String var0) {
      JsonArray var1 = method10813(var0);
      if (var1 == null) {
         return null;
      }

      ArrayList var2 = new ArrayList();

      for (JsonElement var4 : var1) {
         if (var2.size() >= 256) {
            break;
         }

         OverlayEntry var5 = method10812(var4);
         if (var5 != null) {
            var2.add(var5);
         }
      }

      return var2.isEmpty() ? null : new OverlayMetadataSection(List.copyOf(var2));
   }

   private static OverlayEntry method10812(JsonElement var0) {
      if (!var0.isJsonObject()) {
         return null;
      }

      JsonObject var1 = var0.getAsJsonObject();
      JsonElement var2 = var1.get(field23845);
      if (var2 != null && var2.isJsonPrimitive()) {
         String var3 = var2.getAsString();
         if (!field23841.matcher(var3).matches()) {
            return null;
         }

         InclusiveRange var4 = method10809(var1);
         return var4 == null ? null : new OverlayEntry(var4, var3);
      } else {
         return null;
      }
   }

   private static JsonArray method10813(String var0) {
      JsonElement var1;
      try {
         var1 = JsonParser.parseString(var0);
      } catch (Exception var3) {
         return null;
      }

      if (!var1.isJsonObject()) {
         return null;
      }

      JsonObject var2 = var1.getAsJsonObject().getAsJsonObject(field23843);
      return var2 == null ? null : var2.getAsJsonArray(field23844);
   }
}
