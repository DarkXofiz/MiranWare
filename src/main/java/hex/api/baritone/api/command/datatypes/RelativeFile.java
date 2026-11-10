// Original binary: hex/api/baritone/api/command/datatypes/RelativeFile
package hex.api.baritone.api.command.datatypes;

import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.utils.Helper;
import java.io.File;
import java.io.IOException;
import java.io.UncheckedIOException;
import java.nio.file.FileSystems;
import java.nio.file.InvalidPathException;
import java.nio.file.Path;
import java.util.Locale;
import java.util.Objects;
import java.util.stream.Stream;
import net.minecraft.client.Minecraft;

// $VF: Compiled from s
public enum RelativeFile implements IDatatypePost<File, File> {
   INSTANCE;

   public File apply(IDatatypeContext var1, File var2) throws CommandException {
      if (var2 == null) {
         var2 = new File("./");
      }

      Path var3;
      try {
         var3 = FileSystems.getDefault().getPath(var1.getConsumer().getString());
      } catch (InvalidPathException sx) {
         throw new IllegalArgumentException("invalid path");
      }

      return getCanonicalFileUnchecked(var2.toPath().resolve(var3).toFile());
   }

   @Override
   public Stream<String> tabComplete(IDatatypeContext var1) {
      return Stream.empty();
   }

   private static File getCanonicalFileUnchecked(File var0) {
      try {
         return var0.getCanonicalFile();
      } catch (IOException var2) {
         throw new UncheckedIOException(var2);
      }
   }

   public static Stream<String> tabComplete(IArgConsumer var0, File var1) throws CommandException {
      File var2 = getCanonicalFileUnchecked(var1);
      String sx = var0.getString();
      Path sxx = FileSystems.getDefault().getPath(sx);
      Path sxxx = sxx.isAbsolute() ? sxx.getRoot() : var2.toPath();
      boolean sxxxx = !sx.isEmpty() && !sx.endsWith(File.separator);
      File sxxxxx = sxx.isAbsolute() ? sxx.toFile() : new File(var2, sx);
      return Stream.of(Objects.requireNonNull(getCanonicalFileUnchecked(sxxxx ? sxxxxx.getParentFile() : sxxxxx).listFiles()))
         .map(var2x -> (sxx.isAbsolute() ? var2x : sxxx.relativize(var2x.toPath()).toString()) + (var2x.isDirectory() ? File.separator : ""))
         .filter(var1x -> var1x.toLowerCase(Locale.US).startsWith(sx.toLowerCase(Locale.US)))
         .filter(var0x -> !var0x.contains(" "));
   }

   @Deprecated
   public static File gameDir() {
      return gameDir(Helper.mc);
   }

   public static File gameDir(Minecraft var0) {
      File var1 = var0.gameDirectory.getAbsoluteFile();
      return var1.getName().equals(".") ? var1.getParentFile() : var1;
   }
}
