// Original binary: sg/mx/NXDdPB4pdL8i73Eh
package sg.mx;

import com.llamalad7.mixinextras.injector.ModifyReturnValue;
import com.llamalad7.mixinextras.injector.wrapoperation.Operation;
import com.llamalad7.mixinextras.injector.wrapoperation.WrapOperation;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.server.packs.metadata.pack.PackFormat;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.Pack.ResourcesSupplier;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import sg.ec.PackMetadataReader;

// $VF: Compiled from s
@Mixin(Pack.class)
public abstract class PackMixin {
   @ModifyReturnValue(method = "open", at = @At("RETURN"))
   private java.util.stream.Stream<PackResources> wrapForLegacyPaths(java.util.stream.Stream<PackResources> var1) {
      return var1.map(PackMetadataReader::method03184);
   }

   @WrapOperation(
      method = "readPackMetadata",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/server/packs/PackMetadataResources;getMetadataSection(Lnet/minecraft/server/packs/metadata/MetadataSectionType;)Ljava/lang/Object;",
         ordinal = 0
      )
   )
   private static Object patchPackMetadata(
      net.minecraft.server.packs.PackMetadataResources var0, MetadataSectionType<?> var1, Operation<Object> var2, PackLocationInfo var3, ResourcesSupplier var4, PackFormat var5, PackType var6
   ) {
      return PackMetadataReader.method03185(var0, var1, var2, var3, var5);
   }

   @WrapOperation(
      method = "readPackMetadata",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/server/packs/PackMetadataResources;getMetadataSection(Lnet/minecraft/server/packs/metadata/MetadataSectionType;)Ljava/lang/Object;",
         ordinal = 2
      )
   )
   private static Object patchFeatureFlagsMetadata(
      net.minecraft.server.packs.PackMetadataResources var0, MetadataSectionType<?> var1, Operation<Object> var2, PackLocationInfo var3, ResourcesSupplier var4, PackFormat var5, PackType var6
   ) {
      return PackMetadataReader.method03188(var0, var1, var2);
   }

   @WrapOperation(
      method = "readPackMetadata",
      at = @At(
         value = "INVOKE",
         target = "Lnet/minecraft/server/packs/PackMetadataResources;getMetadataSection(Lnet/minecraft/server/packs/metadata/MetadataSectionType;)Ljava/lang/Object;",
         ordinal = 3
      )
   )
   private static Object patchOverlayMetadata(
      net.minecraft.server.packs.PackMetadataResources var0, MetadataSectionType<?> var1, Operation<Object> var2, PackLocationInfo var3, ResourcesSupplier var4, PackFormat var5, PackType var6
   ) {
      return PackMetadataReader.method03186(var0, var1, var2);
   }
}
