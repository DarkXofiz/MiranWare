// Original binary: sg/ec/jb8qZTuN0SBKzySz
package sg.ec;

import net.minecraft.network.chat.Component;
import net.minecraft.server.packs.metadata.pack.PackFormat;
import net.minecraft.server.packs.metadata.pack.PackMetadataSection;
import net.minecraft.util.InclusiveRange;

// $VF: Compiled from s
public final class PackFormatCompatibility {
   public static final int field20479 = 6;
   private static volatile boolean field20480 = true;
   private static final String field20481 = "This is a utility class and cannot be instantiated";

   public static PackMetadataSection method09020(PackFormat var0, Component var1) {
      PackFormat var2 = PackFormat.of(6);
      PackFormat sx = var0.compareTo(var2) < 0 ? var2 : var0;
      return new PackMetadataSection(var1, new InclusiveRange<>(var2, sx));
   }

   private PackFormatCompatibility() {
      throw new UnsupportedOperationException(field20481);
   }

   public static boolean method09021() {
      return field20480;
   }

   public static void method09022(boolean var0) {
      field20480 = var0;
   }

   public static PackMetadataSection method09023(PackMetadataSection var0, PackFormat var1) {
      InclusiveRange var2 = var0.supportedFormats();
      InclusiveRange var3 = method09024(var2, var1);
      return var3.equals(var2) ? var0 : new PackMetadataSection(var0.description(), var3);
   }

   public static InclusiveRange<PackFormat> method09024(InclusiveRange<PackFormat> var0, PackFormat var1) {
      return field20480 && ((PackFormat)var0.minInclusive()).compareTo(var1) <= 0 && ((PackFormat)var0.maxInclusive()).compareTo(var1) < 0
         ? new InclusiveRange<>((PackFormat)var0.minInclusive(), var1)
         : var0;
   }
}
