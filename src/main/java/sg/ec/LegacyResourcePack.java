// Original binary: sg/ec/HGtuTlZKsOHO5uJe
package sg.ec;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.mojang.blaze3d.platform.NativeImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.charset.CharacterCodingException;
import java.nio.charset.CodingErrorAction;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.resources.Identifier;
import net.minecraft.server.packs.PackLocationInfo;
import net.minecraft.server.packs.PackResources;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.PackResources.ResourceOutput;
import net.minecraft.server.packs.metadata.MetadataSectionType;
import net.minecraft.server.packs.resources.IoSupplier;

// $VF: Compiled from s
public final class LegacyResourcePack implements PackResources {
   private static final String field08475 = "textures/entity/";
   private static final String field08476 = "field08476";
   private static final int field08477 = 0;
   private final PackResources field08478;
   private final Map<String, Map<String, byte[]>> field08479 = new ConcurrentHashMap<>();
   private final Map<Identifier, Boolean> field08480 = new ConcurrentHashMap<>();
   private static final String field08481 = ".png.mcmeta";
   private static final String field08482 = "textures/item/";
   private static final String field08483 = "textures/block/";
   private static final String field08484 = ".mcmeta";
   private static final String field08485 = "{\"animation\":{\"frametime\":1}}";
   private static final String field08486 = "textures/entity/";
   private static final String field08487 = "items";
   private static final String field08488 = "models/item";
   private static final String field08489 = "providers";
   private static final String field08490 = "type";
   private static final String field08491 = "reference";
   private static final String field08492 = "id";
   private static final String field08493 = "legacy_unicode";
   private static final String field08494 = "ttf";
   private static final String field08495 = "file";
   private static final String field08496 = "minecraft:include/unifont";
   private static final String field08497 = "minecraft:include/unifont";
   private static final String field08498 = "minecraft:include/unifont";
   private static final String field08499 = "minecraft:include/space";
   private static final String field08500 = "minecraft:include/default";
   private static final String field08501 = "minecraft:include/unifont";
   private static final String field08502 = "minecraft:include/unifont";
   private static final String field08503 = "providers";
   private static final String field08504 = "font/";
   private static final String field08505 = "type";
   private static final String field08506 = "reference";
   private static final String field08507 = "id";
   private static final String field08508 = "uniform";
   private static final String field08509 = "filter";
   private static final String field08510 = "minecraft";
   private static final String field08511 = "font/default.json";
   private static final String field08512 = "minecraft";
   private static final String field08513 = "font/uniform.json";
   private static final String field08514 = "unknown";
   private static final String field08515 = "models/";
   private static final String field08516 = ".json";
   private static final String field08517 = "font/";
   private static final String field08518 = ".json";
   private static final String field08519 = "shaders/post/";
   private static final String field08520 = ".json";
   private static final String field08521 = "vanilla";

   @Override
   public Set<String> getNamespaces(PackType var1) {
      try {
         return this.field08478.getNamespaces(var1);
      } catch (Throwable var3) {
         return Set.of();
      }
   }

   private void acceptLegacy(String var1, Identifier var2, IoSupplier<InputStream> var3, Set<Identifier> var4, ResourceOutput var5) {
      Identifier var6;
      try {
         var6 = LegacyResourcePaths.method02408(var2);
      } catch (Throwable var8) {
         return;
      }

      if (var6 != null && var6.getPath().startsWith(var1) && var4.add(var6)) {
         IoSupplier var7 = this.wrapPatchedJsonIfNeeded(PackType.CLIENT_RESOURCES, var6, var3);
         if (var7 != null) {
            this.emit(var5, var6, var7);
         }
      }
   }

   private boolean isDefaultMinecraftFont(Identifier var1) {
      return field08510.equals(var1.getNamespace()) && field08511.equals(var1.getPath());
   }

   private boolean isVanillaPack() {
      return field08521.equals(this.getPackId());
   }

   private boolean isCffFontProvider(String var1) {
      Identifier var2;
      try {
         var2 = Identifier.parse(var1);
      } catch (Exception var6) {
         return false;
      }

      LinkedHashSet var3 = new LinkedHashSet();
      if (var2.getPath().startsWith(field08504)) {
         var3.add(var2);
      } else {
         var3.add(Identifier.fromNamespaceAndPath(var2.getNamespace(), "font/" + var2.getPath()));
         var3.add(var2);
      }

      for (Identifier var5 : (Iterable<Identifier>) (Iterable) var3) {
         if (this.isCffFont(var5)) {
            return true;
         }
      }

      return false;
   }

   private IoSupplier<InputStream> resolveResource(PackType var1, Identifier var2) {
      IoSupplier var3 = this.wrapPatchedJsonIfNeeded(var1, var2, this.getDelegateResource(var1, var2));
      if (var1 != PackType.CLIENT_RESOURCES) {
         return var3;
      }

      if (var3 != null) {
         return this.hasVanillaShape(var2, var2, var3) ? var3 : null;
      }

      for (Identifier var5 : LegacyResourcePaths.method02417(var2)) {
         IoSupplier var6 = this.wrapPatchedJsonIfNeeded(var1, var2, this.getDelegateResource(var1, var5));
         if (var6 != null && this.hasVanillaShape(var2, var5, var6)) {
            return var6;
         }
      }

      IoSupplier var8 = this.sliceLegacySprite(var2);
      if (var8 != null) {
         return var8;
      }

      IoSupplier var9 = this.convertLegacyLanguage(var2);
      if (var9 != null) {
         return var9;
      }

      IoSupplier var10 = this.synthesizeLegacyAnimationMcmeta(var2);
      if (var10 != null) {
         return var10;
      }

      if (!ItemModelIndex.method04081(var2)) {
         return null;
      }

      Identifier var7 = ItemModelIndex.method04074(var2);
      return this.migrateItemDefinition(var7, this.getDelegateResource(var1, var7));
   }

   private JsonObject createReferenceProvider(String var1, boolean var2) {
      JsonObject var3 = new JsonObject();
      var3.addProperty(field08505, field08506);
      var3.addProperty(field08507, var1);
      if (var2) {
         JsonObject var4 = new JsonObject();
         var4.addProperty(field08508, false);
         var3.add(field08509, var4);
      }

      return var3;
   }

   private boolean readCffHeader(Identifier var1) {
      IoSupplier var2 = this.getDelegateResource(PackType.CLIENT_RESOURCES, var1);
      if (var2 == null) {
         return false;
      }

      try (InputStream var3 = (InputStream)var2.get()) {
         byte[] var4 = var3.readNBytes(4);
         return var4.length == 4 && var4[0] == 79 && var4[1] == 84 && var4[2] == 84 && var4[3] == 79;
      } catch (Throwable var8) {
         return false;
      }
   }

   private void addReferenceIfMissing(JsonArray var1, Set<String> var2, String var3, boolean var4) {
      if (!var2.contains(var3)) {
         var1.add(this.createReferenceProvider(var3, var4));
         var2.add(var3);
      }
   }

   private IoSupplier<InputStream> getDelegateResource(PackType var1, Identifier var2) {
      try {
         return this.field08478.getResource(var1, var2);
      } catch (Throwable var4) {
         return null;
      }
   }

   private IoSupplier<InputStream> wrapFontJson(Identifier var1, IoSupplier<InputStream> var2) {
      try (InputStream var3 = (InputStream)var2.get()) {
         byte[] var4 = var3.readAllBytes();
         String var5 = new String(var4, StandardCharsets.UTF_8);
         String var6 = this.patchLegacyFontJson(var1, var5);
         byte[] var7 = var6.equals(var5) ? var4 : var6.getBytes(StandardCharsets.UTF_8);
         return () -> new ByteArrayInputStream(var7);
      } catch (Throwable var11) {
         return var2;
      }
   }

   private void appendProviders(JsonArray var1, JsonArray var2) {
      for (JsonElement var4 : var2) {
         var1.add(var4);
      }
   }

   private boolean isLegacyPostShaderJson(Identifier var1) {
      String var2 = var1.getPath();
      return var2.startsWith(field08519) && var2.endsWith(field08520);
   }

   private String patchLegacyFontJson(Identifier var1, String var2) {
      JsonElement var3;
      try {
         var3 = JsonParser.parseString(var2);
      } catch (Exception var15) {
         return var2;
      }

      if (!var3.isJsonObject()) {
         return var2;
      }

      JsonObject var4 = var3.getAsJsonObject();
      JsonArray var5 = var4.getAsJsonArray(field08489);
      if (var5 != null && !var5.isEmpty()) {
         JsonArray var6 = new JsonArray();
         HashSet var7 = new HashSet();
         boolean var8 = false;
         boolean var9 = false;

         for (JsonElement var11 : var5) {
            if (!var11.isJsonObject()) {
               var6.add(var11);
            } else {
               JsonObject var12 = var11.getAsJsonObject();
               String var13 = this.getString(var12, field08490);
               if (field08491.equals(var13)) {
                  String var14 = this.getString(var12, field08492);
                  if (var14 != null) {
                     var7.add(var14);
                  }
               }

               if (field08493.equals(var13)) {
                  var9 = true;
               } else {
                  if (field08494.equals(var13)) {
                     String var20 = this.getString(var12, field08495);
                     if (var20 != null && this.isCffFontProvider(var20)) {
                        var8 = true;
                        continue;
                     }
                  }

                  var6.add(var11);
               }
            }
         }

         boolean var16 = false;
         boolean var17 = false;
         if (var9 && !var7.contains(field08496)) {
            var6.add(this.createReferenceProvider(field08497, false));
            var7.add(field08498);
            var17 = true;
         }

         if ((var8 || var9) && this.isDefaultMinecraftFont(var1)) {
            JsonArray var18 = new JsonArray();
            this.addReferenceIfMissing(var18, var7, field08499, false);
            this.addReferenceIfMissing(var18, var7, field08500, true);
            this.addReferenceIfMissing(var18, var7, field08501, false);
            this.appendProviders(var18, var6);
            var6 = var18;
            var16 = true;
         }

         if ((var8 || var9) && this.isUniformMinecraftFont(var1)) {
            JsonArray var19 = new JsonArray();
            this.addReferenceIfMissing(var19, var7, field08502, false);
            this.appendProviders(var19, var6);
            var6 = var19;
            var16 = true;
         }

         if (!var8 && !var9 && !var17 && !var16) {
            return var2;
         }

         var4.add(field08503, var6);
         return var4.toString();
      } else {
         return var2;
      }
   }

   public LegacyResourcePack(PackResources var1) {
      this.field08478 = var1;
   }

   private IoSupplier<InputStream> wrapPatchedJsonIfNeeded(PackType var1, Identifier var2, IoSupplier<InputStream> var3) {
      try {
         return this.patchJson(var1, var2, var3);
      } catch (Throwable var5) {
         return var3;
      }
   }

   private IoSupplier<InputStream> synthesizeLegacyAnimationMcmeta(Identifier var1) {
      String var2 = var1.getPath();
      if (!var2.endsWith(field08481)) {
         return null;
      }

      if (!var2.startsWith(field08482) && !var2.startsWith(field08483)) {
         return null;
      }

      String var3 = var2.substring(0, var2.length() - field08484.length());
      Identifier var4 = this.identifierOrNull(var1.getNamespace(), var3);
      if (var4 == null) {
         return null;
      }

      IoSupplier var5 = this.getDelegateResource(PackType.CLIENT_RESOURCES, var4);
      if (var5 == null) {
         for (Identifier var7 : LegacyResourcePaths.method02417(var4)) {
            var5 = this.getDelegateResource(PackType.CLIENT_RESOURCES, var7);
            if (var5 != null) {
               break;
            }
         }
      }

      if (var5 == null) {
         return null;
      }

      int var14;
      int var15;
      try (InputStream var8 = (InputStream)var5.get()) {
         byte[] var9 = var8.readNBytes(24);
         if (var9.length < 24) {
            return null;
         }

         var14 = this.readInt(var9, 16);
         var15 = this.readInt(var9, 20);
      } catch (Throwable var13) {
         return null;
      }

      if (var14 > 0 && var15 > 0 && var15 != var14 && var15 % var14 == 0) {
         byte[] var16 = field08485.getBytes(StandardCharsets.UTF_8);
         return () -> new ByteArrayInputStream(var16);
      } else {
         return null;
      }
   }

   private IoSupplier<InputStream> convertLegacyLanguage(Identifier var1) {
      if (!TranslationLoader.method03597(var1)) {
         return null;
      }

      for (Identifier var3 : TranslationLoader.method03598(var1)) {
         IoSupplier var4 = this.getDelegateResource(PackType.CLIENT_RESOURCES, var3);
         if (var4 != null) {
            try (InputStream var5 = (InputStream)var4.get()) {
               String var6 = TranslationLoader.method03596(new String(var5.readAllBytes(), StandardCharsets.UTF_8));
               if (var6 != null) {
                  byte[] var7 = var6.getBytes(StandardCharsets.UTF_8);
                  return () -> new ByteArrayInputStream(var7);
               }
            } catch (Throwable var11) {
            }
         }
      }

      return null;
   }

   private String getPackId() {
      PackLocationInfo var1 = this.field08478.location();
      return var1 == null ? field08514 : var1.id();
   }

   private boolean isUniformMinecraftFont(Identifier var1) {
      return field08512.equals(var1.getNamespace()) && field08513.equals(var1.getPath());
   }

   private String decodeUtf8(byte[] var1) {
      try {
         return StandardCharsets.UTF_8
            .newDecoder()
            .onMalformedInput(CodingErrorAction.REPORT)
            .onUnmappableCharacter(CodingErrorAction.REPORT)
            .decode(ByteBuffer.wrap(var1))
            .toString();
      } catch (CharacterCodingException var3) {
         return null;
      }
   }

   private IoSupplier<InputStream> wrapItemDefinition(Identifier var1, IoSupplier<InputStream> var2) {
      try (InputStream var3 = (InputStream)var2.get()) {
         byte[] var4 = var3.readAllBytes();
         String var5 = new String(var4, StandardCharsets.UTF_8);
         String var6 = ItemModelTransformer.method03796(var5);
         if (var6.equals(var5)) {
            return () -> new ByteArrayInputStream(var4);
         }

         byte[] var7 = var6.getBytes(StandardCharsets.UTF_8);
         return () -> new ByteArrayInputStream(var7);
      } catch (Throwable var11) {
         return var2;
      }
   }

   private void listMigratedItemDefinitions(PackType var1, String var2, Set<Identifier> var3, ResourceOutput var4) {
      this.field08478.listResources(var1, var2, field08488, (var3x, var4x) -> {
         Identifier var5 = ItemModelIndex.method04080(var3x);
         if (var5 != null && var3.add(var5)) {
            IoSupplier var6 = this.migrateItemDefinition(var3x, var4x);
            if (var6 != null) {
               this.emit(var4, var5, var6);
            }
         }
      });
   }

   private boolean hasVanillaShape(Identifier var1, Identifier var2, IoSupplier<InputStream> var3) {
      if (!var1.getPath().startsWith(field08486)) {
         return true;
      }

      Identifier var4 = this.identifierOrNull(var2.getNamespace(), var2.getPath() + ".mcmeta");
      if (var4 != null && this.getDelegateResource(PackType.CLIENT_RESOURCES, var4) != null) {
         return true;
      }

      try (InputStream var5 = (InputStream)var3.get()) {
         byte[] var6 = var5.readNBytes(24);
         return var6.length < 24 ? true : EntityTextureAliases.method06989(var1.getPath(), this.readInt(var6, 16), this.readInt(var6, 20));
      } catch (Throwable var10) {
         return true;
      }
   }

   private void listSlicedSprites(String var1, String var2, Set<Identifier> var3, ResourceOutput var4) {
      for (String var6 : CrosshairRenderHooks.method03753(var2)) {
         Identifier var7 = this.identifierOrNull(var1, var6);
         if (var7 != null && var3.add(var7)) {
            IoSupplier var8 = this.sliceLegacySprite(var7);
            if (var8 != null) {
               this.emit(var4, var7, var8);
            }
         }
      }
   }

   private Identifier identifierOrNull(String var1, String var2) {
      try {
         return Identifier.fromNamespaceAndPath(var1, var2);
      } catch (Exception var4) {
         return null;
      }
   }

   private boolean isFontJson(Identifier var1) {
      String var2 = var1.getPath();
      return var2.startsWith(field08517) && var2.endsWith(field08518);
   }

   private String getString(JsonObject var1, String var2) {
      return var1.has(var2) && var1.get(var2).isJsonPrimitive() && var1.get(var2).getAsJsonPrimitive().isString() ? var1.get(var2).getAsString() : null;
   }

   private IoSupplier<InputStream> sliceLegacySprite(Identifier var1) {
      CrosshairRenderHooks.Nested110 var2 = CrosshairRenderHooks.method03759(var1);
      if (var2 == null) {
         return null;
      }

      byte[] var3 = this.field08479
         .computeIfAbsent(var1.getNamespace() + "|" + var2.method03761(), var3x -> this.sliceSheet(var1.getNamespace(), var2.method03761()))
         .get(var1.getPath());
      return var3 == null ? null : () -> new ByteArrayInputStream(var3);
   }

   @Override
   public void listResources(PackType var1, String var2, String var3, ResourceOutput var4) {
      HashSet var5 = new HashSet();

      try {
         this.field08478.listResources(var1, var2, var3, (var4x, var5x) -> this.acceptDirect(var1, var4x, var5x, var5, var4));
      } catch (Throwable var11) {
      }

      if (var1 == PackType.CLIENT_RESOURCES) {
         for (String var7 : LegacyResourcePaths.method02407(var3)) {
            try {
               this.field08478.listResources(var1, var2, var7, (var4x, var5x) -> this.acceptLegacy(var3, var4x, var5x, var5, var4));
            } catch (Throwable var10) {
            }
         }

         try {
            if (field08487.equals(var3)) {
               this.listMigratedItemDefinitions(var1, var2, var5, var4);
            }

            if (CrosshairRenderHooks.field08342.contains(var3)) {
               this.listSlicedSprites(var2, var3, var5, var4);
            }
         } catch (Throwable var9) {
         }
      }
   }

   @Override
   public IoSupplier<InputStream> getRootResource(String... var1) {
      try {
         return this.field08478.getRootResource(var1);
      } catch (Throwable var3) {
         return null;
      }
   }

   private void emit(ResourceOutput var1, Identifier var2, IoSupplier<InputStream> var3) {
      try {
         var1.accept(var2, var3);
      } catch (Throwable var5) {
      }
   }

   private IoSupplier<InputStream> patchJson(PackType var1, Identifier var2, IoSupplier<InputStream> var3) {
      if (var3 == null || var1 != PackType.CLIENT_RESOURCES) {
         return var3;
      } else if (ItemModelIndex.method04081(var2)) {
         return this.wrapItemDefinition(var2, var3);
      } else {
         boolean var4 = this.isModelJson(var2);
         boolean var5 = this.isFontJson(var2);
         boolean var6 = this.isLegacyPostShaderJson(var2);
         if (!var4 && !var5 && !var6) {
            return var3;
         } else if (var6 && !this.isVanillaPack()) {
            return null;
         } else if (var5) {
            return this.wrapFontJson(var2, var3);
         } else {
            return !var4 ? var3 : () -> {
               try (InputStream var2x = (InputStream)var3.get()) {
                  byte[] var3x = var2x.readAllBytes();
                  String var4x = this.decodeUtf8(var3x);
                  if (var4x == null) {
                     return new ByteArrayInputStream(var3x);
                  }

                  String var5x = LegacyResourcePaths.method02410(var4x);
                  return new ByteArrayInputStream(var5x.equals(var4x) ? var3x : var5x.getBytes(StandardCharsets.UTF_8));
               }
            };
         }
      }
   }

   private void acceptDirect(PackType var1, Identifier var2, IoSupplier<InputStream> var3, Set<Identifier> var4, ResourceOutput var5) {
      if (var4.add(var2)) {
         IoSupplier var6 = this.wrapPatchedJsonIfNeeded(var1, var2, var3);
         if (var6 != null && (var1 != PackType.CLIENT_RESOURCES || this.hasVanillaShape(var2, var2, var6))) {
            this.emit(var5, var2, var6);
         }
      }
   }

   @Override
   public PackLocationInfo location() {
      return this.field08478.location();
   }

   private int readInt(byte[] var1, int var2) {
      return (var1[var2] & 0xFF) << 24 | (var1[var2 + 1] & 0xFF) << 16 | (var1[var2 + 2] & 0xFF) << 8 | var1[var2 + 3] & 0xFF;
   }

   @Override
   public <T> T getMetadataSection(MetadataSectionType<T> var1) throws IOException {
      return this.field08478.getMetadataSection(var1);
   }

   @Override
   public void close() {
      this.field08479.clear();
      this.field08480.clear();

      try {
         this.field08478.close();
      } catch (Throwable var2) {
      }
   }

   private boolean isModelJson(Identifier var1) {
      String var2 = var1.getPath();
      return var2.startsWith(field08515) && var2.endsWith(field08516);
   }

   @Override
   public IoSupplier<InputStream> getResource(PackType var1, Identifier var2) {
      try {
         return this.resolveResource(var1, var2);
      } catch (Throwable var4) {
         return this.getDelegateResource(var1, var2);
      }
   }

   private Map<String, byte[]> sliceSheet(String var1, String var2) {
      HashMap var3 = new HashMap();
      Identifier var4 = this.identifierOrNull(var1, var2);
      IoSupplier var5 = var4 == null ? null : this.getDelegateResource(PackType.CLIENT_RESOURCES, var4);
      if (var5 == null) {
         return var3;
      }

      try (
         InputStream var6 = (InputStream)var5.get();
         NativeImage var7 = CrosshairRenderHooks.method03756(var6);
      ) {
         if (var7 != null) {
            for (String var9 : CrosshairRenderHooks.field08342) {
               for (String var11 : CrosshairRenderHooks.method03753(var9)) {
                  Identifier var12 = this.identifierOrNull(var1, var11);
                  CrosshairRenderHooks.Nested110 var13 = var12 == null ? null : CrosshairRenderHooks.method03759(var12);
                  if (var13 != null && var13.method03761().equals(var2)) {
                     byte[] var14 = CrosshairRenderHooks.method03755(var7, var13);
                     if (var14 != null) {
                        var3.put(var11, var14);
                     }
                  }
               }
            }

            return var3;
         } else {
            return var3;
         }
      } catch (Throwable var19) {
         var3.clear();
         return var3;
      }
   }

   private IoSupplier<InputStream> migrateItemDefinition(Identifier var1, IoSupplier<InputStream> var2) {
      if (var2 == null) {
         return null;
      }

      String var3;
      try (InputStream var4 = (InputStream)var2.get()) {
         var3 = ItemModelIndex.method04076(var1, new String(var4.readAllBytes(), StandardCharsets.UTF_8));
      } catch (Throwable var9) {
         return null;
      }

      if (var3 == null) {
         return null;
      }

      byte[] var10 = var3.getBytes(StandardCharsets.UTF_8);
      return () -> new ByteArrayInputStream(var10);
   }

   private boolean isCffFont(Identifier var1) {
      return this.field08480.computeIfAbsent(var1, this::readCffHeader);
   }
}
