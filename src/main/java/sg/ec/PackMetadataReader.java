// Original binary: sg/ec/DwWtQjPBZUV9BQHs
package sg.ec;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.mojang.serialization.JsonOps;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.ComponentSerialization;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.server.packs.metadata.pack.PackFormat;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.server.packs.resources.IoSupplier;

// $VF: Compiled from s
public final class PackMetadataReader {
   private static final String field06997 = "pack.mcmeta";
   private static final String field06998 = "<missing pack.mcmeta>";
   private static final String field06999 = "pack.mcmeta";
   private static final String field07000 = "pack";
   private static final String field07001 = "description";

   private PackMetadataReader() {
   }

   private static Component method03183(net.minecraft.server.packs.PackMetadataResources var0, PackLocationInfo var1) {
      IoSupplier var2 = var0.getRootResource(field06999);
      if (var2 == null) {
         return var1.title();
      }

      try (InputStream var3 = (InputStream)var2.get()) {
         JsonElement var4 = JsonParser.parseString(new String(var3.readAllBytes(), StandardCharsets.UTF_8));
         JsonObject var5 = var4.getAsJsonObject().getAsJsonObject(field07000);
         JsonElement var6 = var5 == null ? null : var5.get(field07001);
         return var6 == null ? var1.title() : ComponentSerialization.CODEC.parse(JsonOps.INSTANCE, var6).result().orElse(var1.title());
      } catch (Exception var10) {
         return var1.title();
      }
   }

   public static PackResources method03184(PackResources var0) {
      if (var0 == null || var0 instanceof LegacyResourcePack || var0 instanceof EncryptedResourcePack) {
         return var0;
      } else {
         return EncryptedResourcePack.shouldWrap(var0) ? new EncryptedResourcePack(var0) : new LegacyResourcePack(var0);
      }
   }

   public static Object method03185(net.minecraft.server.packs.PackMetadataResources var0, MetadataSectionType<?> var1, Operation<Object> var2, PackLocationInfo var3, PackFormat var4) {
      try {
         PackMetadataSection var5 = (PackMetadataSection)var2.call(new Object[]{var0, var1});
         if (var5 != null) {
            return PackFormatCompatibility.method09023(var5, var4);
         }
      } catch (Exception var6) {
      }

      return PackFormatCompatibility.method09020(var4, method03183(var0, var3));
   }

   public static Object method03186(net.minecraft.server.packs.PackMetadataResources var0, MetadataSectionType<?> var1, Operation<Object> var2) {
      try {
         return var2.call(new Object[]{var0, var1});
      } catch (Exception var4) {
         return PackOverlayMetadata.method10811(method03187(var0));
      }
   }

   private static String method03187(net.minecraft.server.packs.PackMetadataResources var0) {
      IoSupplier var1 = var0.getRootResource(field06997);
      if (var1 == null) {
         return field06998;
      }

      try (InputStream var2 = (InputStream)var1.get()) {
         return new String(var2.readAllBytes(), StandardCharsets.UTF_8);
      } catch (Exception var7) {
         return "<unreadable: " + var7 + ">";
      }
   }

   public static Object method03188(net.minecraft.server.packs.PackMetadataResources var0, MetadataSectionType<?> var1, Operation<Object> var2) {
      try {
         return var2.call(new Object[]{var0, var1});
      } catch (Exception var4) {
         return null;
      }
   }
}
