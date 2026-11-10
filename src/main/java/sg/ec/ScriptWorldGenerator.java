// Original binary: sg/ec/XiEZJBEPX1y54pw5
package sg.ec;

import com.mojang.datafixers.util.Pair;
import hex.script.api.Box;
import hex.script.api.FoundStructure;
import hex.script.api.StructurePart;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import net.minecraft.core.Holder;
import net.minecraft.core.LayeredRegistryAccess;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.RegistryAccess.Frozen;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.RegistryLayer;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.ServerPacksSource;
import net.minecraft.server.packs.resources.CloseableResourceManager;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.minecraft.tags.TagLoader;
import net.minecraft.util.datafix.DataFixers;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.BiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSource;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterList;
import net.minecraft.world.level.biome.MultiNoiseBiomeSourceParameterLists;
import net.minecraft.world.level.biome.TheEndBiomeSource;
import net.minecraft.world.level.biome.Climate.ParameterList;
import net.minecraft.world.level.biome.Climate.ParameterPoint;
import net.minecraft.world.level.chunk.ChunkGenerator;
import net.minecraft.world.level.chunk.ChunkGeneratorStructureState;
import net.minecraft.world.level.dimension.BuiltinDimensionTypes;
import net.minecraft.world.level.dimension.DimensionType;
import net.minecraft.world.level.levelgen.LegacyRandomSource;
import net.minecraft.world.level.levelgen.NoiseBasedChunkGenerator;
import net.minecraft.world.level.levelgen.NoiseGeneratorSettings;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.BoundingBox;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructureSet;
import net.minecraft.world.level.levelgen.structure.StructureStart;
import net.minecraft.world.level.levelgen.structure.StructureSet.StructureSelectionEntry;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePieceSerializationContext;
import net.minecraft.world.level.levelgen.structure.placement.ConcentricRingsStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.RandomSpreadStructurePlacement;
import net.minecraft.world.level.levelgen.structure.placement.StructurePlacement;
import net.minecraft.world.level.levelgen.structure.templatesystem.StructureTemplateManager;
import net.minecraft.world.level.storage.LevelStorageSource;
import net.minecraft.world.level.storage.LevelStorageSource.LevelStorageAccess;

// $VF: Compiled from s
final class ScriptWorldGenerator implements AutoCloseable {
   private static final String field14657 = "worldgen";
   private static final String field14658 = "field14658";
   private static final int field14659 = 0;
   private final CloseableResourceManager field14660;
   private final Frozen field14661;
   private final LevelStorageAccess field14662;
   private final StructureTemplateManager field14663;
   private final StructurePieceSerializationContext field14664;
   private final Set<ResourceKey<Biome>> field14665;
   private final Map<ScriptWorldGenerator.Nested188, ScriptWorldGenerator.Nested189> field14666 = new EnumMap<>(ScriptWorldGenerator.Nested188.class);
   private static final String field14667 = "worldgen";

   private BiomeSource method06476(ScriptWorldGenerator.Nested188 var1) {
      RegistryLookup var2 = this.field14661.lookupOrThrow(Registries.BIOME);
      if (var1.field14672 == null) {
         return TheEndBiomeSource.create(var2);
      }

      ParameterList<Holder<Biome>> sx = this.field14661.lookupOrThrow(Registries.MULTI_NOISE_BIOME_SOURCE_PARAMETER_LIST).getOrThrow(var1.field14672).value().parameters();
      java.util.List<com.mojang.datafixers.util.Pair<ParameterPoint, Holder<Biome>>> sxx = new ArrayList<>(sx.values().size());

      for (var sxxx : sx.values()) {
         if (((Holder<Biome>)sxxx.getSecond()).unwrapKey().map(var1x -> !this.field14665.contains(var1x)).orElse(true)) {
            sxx.add(sxxx);
         }
      }

      return MultiNoiseBiomeSource.createFromList(new ParameterList<>(sxx));
   }

   private static Frozen method06477(CloseableResourceManager var0) {
      LayeredRegistryAccess var1 = RegistryLayer.createRegistryAccess();
      var var2 = TagLoader.loadTagsForExistingRegistries(var0, var1.getLayer(RegistryLayer.STATIC));
      var var3 = TagLoader.buildUpdatedLookups(var1.getAccessForLoading(RegistryLayer.WORLDGEN), var2);
      return RegistryDataLoader.load(var0, var3, RegistryDataLoader.WORLDGEN_REGISTRIES);
   }

   boolean method06478(Set<ResourceKey<Biome>> var1) {
      return this.field14665.equals(var1);
   }

   private static Box method06479(BoundingBox var0) {
      return new Box(var0.minX(), var0.minY(), var0.minZ(), var0.maxX(), var0.maxY(), var0.maxZ());
   }

   Optional<Reference<StructureSet>> method06480(Identifier var1) {
      return this.field14661.lookupOrThrow(Registries.STRUCTURE_SET).get(ResourceKey.create(Registries.STRUCTURE_SET, var1));
   }

   ScriptWorldGenerator.Nested189 method06481(long var1, ScriptWorldGenerator.Nested188 var3) {
      ScriptWorldGenerator.Nested189 var4 = this.field14666.get(var3);
      if (var4 == null || var4.field14673 != var1) {
         var4 = new ScriptWorldGenerator.Nested189(var1, var3);
         this.field14666.put(var3, var4);
      }

      return var4;
   }

   @Override
   public void close() throws IOException {
      this.field14666.clear();
      this.field14662.close();
      this.field14660.close();
   }

   ScriptWorldGenerator(Path var1, Set<ResourceKey<Biome>> var2) throws IOException {
      this.field14665 = Set.copyOf(var2);
      this.field14660 = new MultiPackResourceManager(PackType.SERVER_DATA, List.<net.minecraft.server.packs.PackResources>of(ServerPacksSource.createVanillaPackSource()));
      this.field14661 = method06477(this.field14660);
      this.field14662 = LevelStorageSource.createDefault(var1).createAccess(field14667);
      this.field14663 = new StructureTemplateManager(this.field14660, this.field14662, DataFixers.getDataFixer(), BuiltInRegistries.BLOCK);
      this.field14664 = new StructurePieceSerializationContext(this.field14660, this.field14661, this.field14663);
   }

   // $VF: Compiled from s
   enum Nested188 {
      OVERWORLD(
         "minecraft:overworld",
         Level.OVERWORLD,
         NoiseGeneratorSettings.OVERWORLD,
         BuiltinDimensionTypes.OVERWORLD,
         MultiNoiseBiomeSourceParameterLists.OVERWORLD
      ),
      NETHER("minecraft:the_nether", Level.NETHER, NoiseGeneratorSettings.NETHER, BuiltinDimensionTypes.NETHER, MultiNoiseBiomeSourceParameterLists.NETHER),
      END("minecraft:the_end", Level.END, NoiseGeneratorSettings.END, BuiltinDimensionTypes.END, null);

      private final String field14668;
      private final ResourceKey<Level> field14669;
      private final ResourceKey<NoiseGeneratorSettings> field14670;
      private final ResourceKey<DimensionType> field14671;
      private final ResourceKey<MultiNoiseBiomeSourceParameterList> field14672;

      Nested188(
         String var3,
         ResourceKey<Level> var4,
         ResourceKey<NoiseGeneratorSettings> var5,
         ResourceKey<DimensionType> var6,
         ResourceKey<MultiNoiseBiomeSourceParameterList> var7
      ) {
         this.field14668 = var3;
         this.field14669 = var4;
         this.field14670 = var5;
         this.field14671 = var6;
         this.field14672 = var7;
      }

      static ScriptWorldGenerator.Nested188 method06483(String var0) {
         for (ScriptWorldGenerator.Nested188 var4 : values()) {
            if (var4.field14668.equals(var0)) {
               return var4;
            }
         }

         return null;
      }
   }

   // $VF: Compiled from s
   final class Nested189 {
      private final long field14673;
      private final ScriptWorldGenerator.Nested188 field14674;
      private final RandomState field14675;
      private final ChunkGenerator field14676;
      private final ChunkGeneratorStructureState field14677;
      private final LevelHeightAccessor field14678;
      private static final String field14680 = "Template";

      private Nested189(long var2, ScriptWorldGenerator.Nested188 var4) {
         this.field14673 = var2;
         this.field14674 = var4;
         var var5 = ScriptWorldGenerator.this.field14661.lookupOrThrow(Registries.NOISE_SETTINGS).getOrThrow(var4.field14670);
         this.field14675 = RandomState.create(var5.value(), ScriptWorldGenerator.this.field14661.lookupOrThrow(net.minecraft.core.registries.Registries.NOISE), var2);
         this.field14676 = new NoiseBasedChunkGenerator(ScriptWorldGenerator.this.method06476(var4), var5);
         this.field14677 = this.field14676.createState(ScriptWorldGenerator.this.field14661.lookupOrThrow(Registries.STRUCTURE_SET), this.field14675, var2);
         DimensionType sx = ScriptWorldGenerator.this.field14661.lookupOrThrow(Registries.DIMENSION_TYPE).getOrThrow(var4.field14671).value();
         this.field14678 = LevelHeightAccessor.create(sx.minY(), sx.height());
      }

      private StructurePart method06484(StructurePiece var1) {
         String var2 = var1.createTag(ScriptWorldGenerator.this.field14664).getStringOr(field14680, "");
         return new StructurePart(
            BuiltInRegistries.STRUCTURE_PIECE.getKey(var1.getType()).toString(), var2, ScriptWorldGenerator.method06479(var1.getBoundingBox())
         );
      }

      private Optional<FoundStructure> method06485(StructureSelectionEntry var1, StructureStart var2) {
         if (!var2.isValid()) {
            return Optional.empty();
         }

         var var3 = new ArrayList(var2.getPieces().size());

         for (StructurePiece var5 : var2.getPieces()) {
            var3.add(this.method06484(var5));
         }

         String var6 = var1.structure().unwrapKey().orElseThrow().identifier().toString();
         ChunkPos var7 = var2.getChunkPos();
         return Optional.of(new FoundStructure(var6, var7.x, var7.z, ScriptWorldGenerator.method06479(var2.getBoundingBox()), var3));
      }

      private static boolean method06486(ChunkPos var0, int var1, int var2, int var3) {
         return Math.abs(var0.x - var1) <= var3 && Math.abs(var0.z - var2) <= var3;
      }

      List<ChunkPos> method06487(Holder<StructureSet> var1, int var2, int var3, int var4) {
         if (!this.method06488(var1)) {
            return List.of();
         }

         StructurePlacement var5 = ((StructureSet)var1.value()).placement();
         ArrayList<ChunkPos> var6 = new ArrayList<>();
         if (var5 instanceof RandomSpreadStructurePlacement var7) {
            int var9 = var7.spacing();

            for (int var10 = Math.floorDiv(var2 - var4, var9); var10 <= Math.floorDiv(var2 + var4, var9); var10++) {
               for (int var11 = Math.floorDiv(var3 - var4, var9); var11 <= Math.floorDiv(var3 + var4, var9); var11++) {
                  ChunkPos var12 = var7.getPotentialStructureChunk(this.field14673, var10 * var9, var11 * var9);
                  if (method06486(var12, var2, var3, var4) && var5.isStructureChunk(this.field14677, var12.x, var12.z)) {
                     var6.add(var12);
                  }
               }
            }
         } else if (var5 instanceof ConcentricRingsStructurePlacement var8) {
            for (ChunkPos var14 : this.field14677.getRingPositionsFor(var8)) {
               if (method06486(var14, var2, var3, var4)) {
                  var6.add(var14);
               }
            }
         }

         return var6;
      }

      private boolean method06488(Holder<StructureSet> var1) {
         for (var var3 : this.field14677.possibleStructureSets()) {
            if (var3.value() == var1.value()) {
               return true;
            }
         }

         return false;
      }

      private StructureStart method06489(StructureSelectionEntry var1, ChunkPos var2) {
         Structure var3 = var1.structure().value();
         return var3.generate(
            var1.structure(),
            this.field14674.field14669,
            ScriptWorldGenerator.this.field14661,
            this.field14676,
            this.field14676.getBiomeSource(),
            this.field14675,
            ScriptWorldGenerator.this.field14663,
            this.field14673,
            var2,
            0,
            this.field14678,
            var3.biomes()::contains
         );
      }

      Optional<FoundStructure> method06490(Holder<StructureSet> var1, ChunkPos var2) {
         var var3 = new ArrayList<>(((StructureSet)var1.value()).structures());
         if (var3.size() == 1) {
            return this.method06485((StructureSelectionEntry)var3.get(0), this.method06489((StructureSelectionEntry)var3.get(0), var2));
         }

         WorldgenRandom var4 = new WorldgenRandom(new LegacyRandomSource(0L));
         var4.setLargeFeatureSeed(this.field14673, var2.x, var2.z);
         int var5 = 0;

         for (StructureSelectionEntry var7 : var3) {
            var5 += var7.weight();
         }

         while (!var3.isEmpty()) {
            int var10 = var4.nextInt(var5);
            int var11 = 0;

            for (StructureSelectionEntry var9 : var3) {
               var10 -= var9.weight();
               if (var10 < 0) {
                  break;
               }

               var11++;
            }

            StructureSelectionEntry var12 = (StructureSelectionEntry)var3.get(var11);
            StructureStart var13 = this.method06489(var12, var2);
            if (var13.isValid()) {
               return this.method06485(var12, var13);
            }

            var3.remove(var11);
            var5 -= var12.weight();
         }

         return Optional.empty();
      }
   }
}
