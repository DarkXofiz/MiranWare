// Original binary: hex/api/baritone/utils/schematic/format/DefaultSchematicFormats
package hex.api.baritone.utils.schematic.format;

import hex.api.baritone.api.schematic.IStaticSchematic;
import hex.api.baritone.api.schematic.format.ISchematicFormat;
import hex.api.baritone.utils.schematic.format.defaults.LitematicaSchematic;
import hex.api.baritone.utils.schematic.format.defaults.MCEditSchematic;
import hex.api.baritone.utils.schematic.format.defaults.SpongeSchematic;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.NbtAccounter;
import net.minecraft.nbt.NbtIo;
import org.apache.commons.io.FilenameUtils;

// $VF: Compiled from s
public enum DefaultSchematicFormats implements ISchematicFormat {
   MCEDIT("schematic")   // $VF: Compiled from s
 {
      @Override
      public IStaticSchematic parse(InputStream var1) throws IOException {
         return new MCEditSchematic(NbtIo.readCompressed(var1, NbtAccounter.unlimitedHeap()));
      }
   },
   SPONGE("schem")   // $VF: Compiled from s
 {
      private static final String А7М = "А7М";
      private static final String А75 = "А75";

      @Override
      public IStaticSchematic parse(InputStream var1) throws IOException {
         CompoundTag var2 = NbtIo.readCompressed(var1, NbtAccounter.unlimitedHeap());
         int sx = var2.getInt(А7М).orElse(-1);
         switch (sx) {
            case 1:
            case 2:
               return new SpongeSchematic(var2);
            default:
               throw new UnsupportedOperationException(А75);
         }
      }

   },
   LITEMATICA("litematic")   // $VF: Compiled from s
 {
      private static final String бЦх = "бЦх";
      private static final String бЦЦ = "бЦЦ";
      private static final String бЦ9 = "бЦ9";
      private static final String бЦЮ = "бЦЮ";

      @Override
      public IStaticSchematic parse(InputStream var1) throws IOException {
         CompoundTag var2 = NbtIo.readCompressed(var1, NbtAccounter.unlimitedHeap());
         int sx = var2.getInt(бЦх).orElse(-1);
         switch (sx) {
            case 4:
            case 5:
               throw new UnsupportedOperationException(бЦЦ);
            case 6:
               throw new UnsupportedOperationException(бЦ9);
            case 7:
               return new LitematicaSchematic(var2);
            default:
               throw new UnsupportedOperationException(бЦЮ);
         }
      }

   };

   private final String extension;

   DefaultSchematicFormats(String var3) {
      this.extension = var3;
   }

   @Override
   public boolean isFileType(File var1) {
      return this.extension.equalsIgnoreCase(FilenameUtils.getExtension(var1.getAbsolutePath()));
   }

   @Override
   public List<String> getFileExtensions() {
      return Collections.singletonList(this.extension);
   }
}
