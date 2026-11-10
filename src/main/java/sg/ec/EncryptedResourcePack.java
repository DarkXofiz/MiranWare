// Original binary: sg/ec/E9ueCYMo1WajFJBj
package sg.ec;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Set;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PackResources.ResourceOutput;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.server.packs.resources.IoSupplier;

// $VF: Compiled from s
public final class EncryptedResourcePack implements PackResources {
   private final PackResources field07039;
   private static final String field07040 = "hex";
   private static final String field07041 = "0.bin";
   private static final String field07042 = "/";

   private Identifier resolve(PackType var1, Identifier var2) {
      if (var1 != PackType.CLIENT_RESOURCES) {
         return null;
      }

      String var3 = EncryptedAssetArchive.method10926(var2.getNamespace(), var2.getPath());
      return var3 == null ? null : Identifier.fromNamespaceAndPath(var2.getNamespace(), var3);
   }

   @Override
   public void close() {
      this.field07039.close();
   }

   @Override
   public PackLocationInfo location() {
      return this.field07039.location();
   }

   @Override
   public Set<String> getNamespaces(PackType var1) {
      return this.field07039.getNamespaces(var1);
   }

   @Override
   public IoSupplier<InputStream> getResource(PackType var1, Identifier var2) {
      Identifier var3 = this.resolve(var1, var2);
      if (var3 != null) {
         IoSupplier var4 = this.field07039.getResource(var1, var3);
         if (var4 != null) {
            return var4;
         }
      }

      return this.field07039.getResource(var1, var2);
   }

   public static boolean shouldWrap(PackResources var0) {
      if (var0 != null && !(var0 instanceof EncryptedResourcePack) && EncryptedAssetArchive.method10917()) {
         try {
            Identifier var1 = Identifier.fromNamespaceAndPath(field07040, field07041);
            return var0.getResource(PackType.CLIENT_RESOURCES, var1) != null;
         } catch (Throwable var2) {
            return false;
         }
      } else {
         return false;
      }
   }

   @Override
   public void listResources(PackType var1, String var2, String var3, ResourceOutput var4) {
      this.field07039.listResources(var1, var2, var3, (var1x, var2x) -> {
         if (!EncryptedAssetArchive.method10918(var1x.getNamespace(), var1x.getPath())) {
            var4.accept(var1x, var2x);
         }
      });
      if (var1 == PackType.CLIENT_RESOURCES) {
         String var5 = !var3.isEmpty() && !var3.endsWith(field07042) ? var3 + "/" : var3;
         var var6 = EncryptedAssetArchive.method10921();

         for (int var7 = 0; var7 < var6.size(); var7++) {
            String[] var8 = (String[])var6.get(var7);
            if (var8[0].equals(var2) && var8[1].startsWith(var5)) {
               Identifier var9 = Identifier.fromNamespaceAndPath(var8[0], var8[2]);
               IoSupplier var10 = this.field07039.getResource(var1, var9);
               if (var10 != null) {
                  var4.accept(Identifier.fromNamespaceAndPath(var8[0], var8[1]), var10);
               }
            }
         }
      }
   }

   public EncryptedResourcePack(PackResources var1) {
      this.field07039 = var1;
   }

   @Override
   public <T> T getMetadataSection(MetadataSectionType<T> var1) throws IOException {
      return this.field07039.getMetadataSection(var1);
   }

   @Override
   public IoSupplier<InputStream> getRootResource(String... var1) {
      return this.field07039.getRootResource(var1);
   }
}
