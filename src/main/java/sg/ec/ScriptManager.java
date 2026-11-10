// Original binary: sg/ec/6AjowUK7auVqLNo2
package sg.ec;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Optional;
import java.util.stream.Stream;
import net.minecraft.SharedConstants;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackSelectionConfig;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PathPackResources;
import net.minecraft.server.packs.repository.Pack;
import net.minecraft.server.packs.repository.PackCompatibility;
import net.minecraft.server.packs.repository.PackRepository;
import net.minecraft.server.packs.repository.PackSource;
import net.minecraft.server.packs.repository.Pack.Metadata;
import net.minecraft.server.packs.repository.Pack.Position;
import net.minecraft.server.packs.repository.Pack.ResourcesSupplier;
import net.minecraft.world.flag.FeatureFlagSet;

// $VF: Compiled from s
public final class ScriptManager implements MinecraftAccess {
   public static final String field02745 = "script";
   private static final String field02746 = "field02746";
   private static final int field02747 = 0;
   private static final long field02748 = 0;
   private static boolean field02749;
   private static boolean field02750;
   private static long field02751;
   private static int field02752;
   private static long field02753;
   private static final String field02754 = "scripts";
   private static final String field02755 = "resources";
   private static final String field02756 = "assets/script";
   private static final String field02757 = "Hex";
   private static final String field02758 = "уже подключён";
   private static final String field02759 = "репозиторий паков ещё не готов";
   private static final String field02760 = "каталог не создаётся";
   private static final String field02761 = "miranware/scripts";
   private static final String field02762 = "miranware/scripts";
   private static final String field02763 = "miranware/scripts";
   private static final String field02764 = "подключён, файлов нет";
   private static final String field02765 = "miranware/scripts";
   private static final String field02766 = "Script resources";
   private static final String field02767 = "Файлы скриптов: текстуры, шрифты, шейдеры";
   private static final String field02768 = "script";
   private static final String field02769 = "shaders";
   private static final long field02770 = 1000L;
   private static final String field02771 = "miranware/scripts";
   private static final String field02772 = "пак не подключён";
   private static final String field02773 = "miranware/scripts";
   private static final String field02774 = "miranware/scripts";
   private static final String field02775 = "ресурсы перезагружены";
   private static final long field02776 = 1125899906842597L;
   private static final long field02777 = 31L;
   private static final long field02778 = 31L;
   private static final long field02779 = 31L;
   private static final String field02780 = "This is a utility class and cannot be instantiated";

   private static Pack method01279() {
      final Path var0 = method01286().toPath();
      PackLocationInfo sx = new PackLocationInfo(field02765, Component.literal(field02766), PackSource.BUILT_IN, Optional.empty());
      Metadata sxx = new Metadata(Component.literal(field02767), PackCompatibility.COMPATIBLE, FeatureFlagSet.of(), List.of());
      ResourcesSupplier sxxx = new ResourcesSupplier()      // $VF: Compiled from s
 {
         @Override
         public net.minecraft.server.packs.PackMetadataResources openMetadata(PackLocationInfo var1) {
            return new PathPackResources(var1, var0);
         }

         @Override
         public java.util.stream.Stream<PackResources> openResources(PackLocationInfo var1, Metadata var2) {
            return java.util.stream.Stream.of(new PathPackResources(var1, var0));
         }
      };
      return new Pack(sx, sxxx, sxx, new PackSelectionConfig(true, Position.TOP, true));
   }

   public static void method01280() {
      try {
         Files.createDirectories(method01289().toPath());
         Files.createDirectories(new File(method01286(), "assets/" + field02757.toLowerCase(Locale.ROOT) + "/fonts").toPath());
      } catch (IOException var1) {
      }
   }

   public static boolean method01282() {
      PackRepository var0 = mc.getResourcePackRepository();
      return var0 != null && var0.getSelectedIds().contains(field02771);
   }

   private static long method01284() {
      Path var0 = method01286().toPath();
      if (!Files.isDirectory(var0)) {
         return 0L;
      }

      long var1 = field02776;

      try (Stream<Path> var3 = Files.walk(var0)) {
         for (Path var5 : (Iterable<Path>) (Iterable) var3.filter(var0x -> Files.isRegularFile(var0x)).toList()) {
            var1 = var1 * field02777 + var5.toString().hashCode();
            var1 = var1 * field02778 + Files.getLastModifiedTime(var5).toMillis();
            var1 = var1 * field02779 + Files.size(var5);
         }

         return var1;
      } catch (IOException var8) {
         return var1;
      }
   }

   public static int method01285() {
      Path var0 = method01289().toPath();
      if (!Files.isDirectory(var0)) {
         return 0;
      }

      try (Stream<Path> var1 = Files.walk(var0)) {
         return (int)var1.filter(var0x -> Files.isRegularFile(var0x)).count();
      } catch (IOException var6) {
         return 0;
      }
   }

   public static File method01286() {
      return new File(new File(ClientEnvironment.field07577, field02754), field02755);
   }

   public static void method01287(PackRepository var0) {
      if (!field02750 && var0 != null) {
         try {
            method01280();
            var0.sources.add(var0x -> var0x.accept(method01279()));
            field02750 = true;
         } catch (Throwable var2) {
         }
      }
   }

   public static String method01288() {
      if (!field02749) {
         return field02772;
      }

      PackRepository var0 = mc.getResourcePackRepository();
      if (var0 != null && !var0.getSelectedIds().contains(field02773)) {
         var0.addPack(field02774);
      }

      try {
         mc.reloadResourcePacks();
         return field02775;
      } catch (Throwable var2) {
         return "перезагрузка упала: " + var2;
      }
   }

   public static File method01289() {
      return new File(method01286(), field02756);
   }

   private static void method01290(Path var0) throws IOException {
      try (Stream<Path> var1 = Files.walk(var0)) {
         for (Path var3 : (Iterable<Path>) (Iterable) var1.sorted(Comparator.reverseOrder()).toList()) {
            if (!var3.equals(var0) && !var3.startsWith(var0.resolve(field02769))) {
               Files.deleteIfExists(var3);
            }
         }
      }
   }

   public static String method01291() {
      return String.valueOf(SharedConstants.getCurrentVersion().packVersion(PackType.CLIENT_RESOURCES));
   }

   private static void method01292(List<Identifier> var0) {
      if (mc != null && mc.getTextureManager() != null) {
         for (Identifier var2 : var0) {
            try {
               mc.getTextureManager().release(var2);
            } catch (Throwable var4) {
            }
         }
      }
   }

   public static boolean method01293() {
      long var0 = method01284();
      if (var0 == field02751) {
         return false;
      }

      field02751 = var0;
      return true;
   }

   private ScriptManager() {
      throw new UnsupportedOperationException(field02780);
   }

   public static void method01295() {
      if (field02749) {
         boolean var0 = FontRegistry.method02891();
         boolean var1 = ScriptShaderManager.method10927();
         if (!var0 && !var1) {
            field02752 = 0;
         } else {
            long var2 = System.currentTimeMillis();
            if (field02752 < 3 && var2 - field02753 >= field02770) {
               field02752++;
               field02753 = var2;
               method01280();
               if (field02752 == 3) {
                  method01288();
               }
            }
         }
      }
   }

   public static String method01296() {
      if (field02749) {
         return field02758;
      }

      PackRepository var0 = mc.getResourcePackRepository();
      if (var0 == null) {
         return field02759;
      }

      boolean var1 = field02750;

      try {
         if (!var1) {
            method01287(var0);
            if (!field02750) {
               return field02760;
            }

            var0.reload();
         }

         if (!var0.getSelectedIds().contains(field02761)) {
            var0.addPack(field02762);
         }

         field02749 = true;
         field02751 = method01284();
         if (!var0.getSelectedIds().contains(field02763)) {
            return "пак не выбрался, доступные: " + var0.getAvailableIds();
         }

         if (method01285() == 0) {
            return field02764;
         }

         if (var1) {
            return "загружен вместе с игрой, файлов " + method01285();
         }

         mc.reloadResourcePacks();
         return "подключён и загружен, файлов " + method01285();
      } catch (Throwable var3) {
         return "не удалось подключить: " + var3;
      }
   }

   public static void method01297(List<ScriptSourceLoader> var0) {
      Path var1 = method01289().toPath();
      ArrayList var2 = new ArrayList();

      try {
         method01280();
         method01290(var1);

         for (ScriptSourceLoader var4 : var0) {
            for (String var6 : var4.method08394()) {
               byte[] var7 = var4.method08397(var6);
               if (var7 != null) {
                  Path var8 = var1.resolve(var4.method08400()).resolve(var6).normalize();
                  if (var8.startsWith(var1)) {
                     Files.createDirectories(var8.getParent());
                     Files.write(var8, var7);
                     var2.add(Identifier.fromNamespaceAndPath(field02768, var4.method08400() + "/" + var6));
                  }
               }
            }
         }
      } catch (IOException var9) {
      }

      method01292(var2);
   }
}
