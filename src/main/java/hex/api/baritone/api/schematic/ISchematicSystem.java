// Original binary: hex/api/baritone/api/schematic/ISchematicSystem
package hex.api.baritone.api.schematic;

import hex.api.baritone.api.command.registry.Registry;
import hex.api.baritone.api.schematic.format.ISchematicFormat;
import java.io.File;
import java.util.List;
import java.util.Optional;

// $VF: Compiled from s
public interface ISchematicSystem {
   Registry<ISchematicFormat> getRegistry();

   Optional<ISchematicFormat> getByFile(File var1);

   List<String> getFileExtensions();
}
