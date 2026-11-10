// Original binary: hex/api/baritone/api/schematic/format/ISchematicFormat
package hex.api.baritone.api.schematic.format;

import hex.api.baritone.api.schematic.IStaticSchematic;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

// $VF: Compiled from s
public interface ISchematicFormat {
   List<String> getFileExtensions();

   boolean isFileType(File var1);

   IStaticSchematic parse(InputStream var1) throws IOException;
}
