// Original binary: hex/api/baritone/utils/schematic/SchematicSystem
package hex.api.baritone.utils.schematic;

import hex.api.baritone.api.command.registry.Registry;
import hex.api.baritone.api.schematic.ISchematicSystem;
import hex.api.baritone.api.schematic.format.ISchematicFormat;
import hex.api.baritone.utils.schematic.format.DefaultSchematicFormats;
import java.io.File;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

// $VF: Compiled from s
public enum SchematicSystem implements ISchematicSystem {
   INSTANCE;

   private final Registry<ISchematicFormat> registry = new Registry<>();

   SchematicSystem() {
      Arrays.stream(DefaultSchematicFormats.values()).forEach(this.registry::register);
   }

   @Override
   public Registry<ISchematicFormat> getRegistry() {
      return this.registry;
   }

   @Override
   public Optional<ISchematicFormat> getByFile(File var1) {
      return this.registry.stream().filter(var1x -> var1x.isFileType(var1)).findFirst();
   }

   @Override
   public List<String> getFileExtensions() {
      return this.registry.stream().map(ISchematicFormat::getFileExtensions).flatMap(Collection::stream).toList();
   }
}
