// Original binary: sg/ec/lKckBPEE3EUv7Ykc
package sg.ec;

import hex.script.api.FoundStructure;
import hex.script.api.StructureSearch;
import hex.script.api.Worldgen;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.levelgen.structure.StructureSet;

// $VF: Compiled from s
final class ScriptWorldgenTools implements MinecraftAccess {
   private static final String field21287 = "Script worldgen";
   private static final String field21288 = "field21288";
   private static final int field21289 = 0;
   private static final Set<ResourceKey<Biome>> field21290 = Set.of(
      ResourceKey.create(Registries.BIOME, Identifier.withDefaultNamespace(ScriptWorldgenTools.field21299))
   );
   private final Worldgen field21291 = new Worldgen(this::method09364);
   private final ExecutorService field21292 = Executors.newSingleThreadExecutor(ScriptWorldgenTools::method09368);
   private final Map<ScriptWorldgenTools.Nested261, ScriptWorldgenTools.Nested260> field21293 = new ConcurrentHashMap<>();
   private final Map<ScriptWorldgenTools.Nested259, Optional<FoundStructure>> field21294 = new HashMap<>();
   private ScriptWorldGenerator field21295;
   private long field21296;
   private static final String field21297 = "worldgen";
   private static final String field21298 = "Script worldgen";
   private static final String field21299 = "sulfur_caves";

   private void method09360(ScriptWorldgenTools.Nested260 var1) {
      if (!var1.method09370()) {
         try {
            ScriptWorldGenerator var2 = this.method09362(var1.field21304);
            var sx = var2.method06480(var1.field21300.set());
            if (sx.isEmpty()) {
               var1.method09376("нет набора структур " + var1.field21300.set());
               return;
            }

            this.method09363(var1.field21300.seed());
            ScriptWorldGenerator.Nested189 sxx = var2.method06481(var1.field21300.seed(), var1.field21300.preset());
            var sxxx = sxx.method06487(sx.get(), var1.field21301, var1.field21302, var1.field21303);
            var1.method09375(sxxx.size());

            for (ChunkPos sxxxx : sxxx) {
               if (var1.method09370()) {
                  return;
               }

               ScriptWorldgenTools.Nested259 sxxxxx = new ScriptWorldgenTools.Nested259(var1.field21300, sxxxx.x, sxxxx.z);
               var sxxxxxx = this.field21294.get(sxxxxx);
               if (sxxxxxx == null) {
                  sxxxxxx = sxx.method06490(sx.get(), sxxxx);
                  this.field21294.put(sxxxxx, sxxxxxx);
               }

               var1.method09371(sxxxxxx.orElse(null));
            }

            var1.method09372();
         } catch (Throwable var10) {
            String sx = var10.getClass().getSimpleName() + (var10.getMessage() == null ? "" : ": " + var10.getMessage());
            var1.method09376(sx);
            mc.execute(() -> ScriptLogManager.INSTANCE.method08091(2, "[worldgen] " + sx));
         }
      }
   }

   private static StructureSearch method09361(String var0) {
      return new StructureSearch(List.of(), true, 1.0F, var0);
   }

   private ScriptWorldGenerator method09362(Set<ResourceKey<Biome>> var1) throws IOException {
      if (this.field21295 == null || !this.field21295.method06478(var1)) {
         if (this.field21295 != null) {
            this.field21295.close();
         }

         this.field21294.clear();
         this.field21295 = new ScriptWorldGenerator(ClientEnvironment.field07577.toPath().resolve(field21297), var1);
      }

      return this.field21295;
   }

   private void method09363(long var1) {
      if (this.field21296 != var1 || this.field21294.size() > 20000) {
         this.field21294.clear();
         this.field21296 = var1;
      }
   }

   private StructureSearch method09364(long var1, String var3, String var4, int var5, int var6, int var7) {
      ScriptWorldGenerator.Nested188 var8 = ScriptWorldGenerator.Nested188.method06483(var3);
      if (var8 == null) {
         return method09361("в измерении " + var3 + " генерации структур нет");
      }

      Identifier var9 = Identifier.tryParse(var4);
      if (var9 == null) {
         return method09361("неверный id набора " + var4);
      }

      ScriptWorldgenTools.Nested261 var10 = new ScriptWorldgenTools.Nested261(var1, var8, var9);
      int var11 = Math.max(0, var7);
      ScriptWorldgenTools.Nested260 var12 = this.field21293.get(var10);
      if (var12 == null || !var12.method09374(var5, var6, var11)) {
         if (var12 != null) {
            var12.method09377();
         }

         ScriptWorldgenTools.Nested260 var13 = new ScriptWorldgenTools.Nested260(var10, var5, var6, var11, this.method09369());
         this.field21293.put(var10, var13);
         this.field21292.execute(() -> this.method09360(var13));
         var12 = var13;
      }

      return var12.method09373();
   }

   Worldgen method09366() {
      return this.field21291;
   }

   private static Thread method09368(Runnable var0) {
      Thread var1 = new Thread(var0, field21298);
      var1.setDaemon(true);
      return var1;
   }

   private Set<ResourceKey<Biome>> method09369() {
      return ViaFabricPlusProtocolAccess.method11195() ? field21290 : Set.of();
   }

   // $VF: Compiled from s
   private record Nested259(ScriptWorldgenTools.Nested261 search, int chunkX, int chunkZ) {
   }

   // $VF: Compiled from s
   private static final class Nested260 {
      private final ScriptWorldgenTools.Nested261 field21300;
      private final int field21301;
      private final int field21302;
      private final int field21303;
      private final Set<ResourceKey<Biome>> field21304;
      private final List<FoundStructure> field21305 = new ArrayList<>();
      private volatile boolean field21306;
      private int field21307;
      private int field21308;
      private boolean field21309;
      private String field21310 = "";
      private boolean field21311 = true;
      private StructureSearch field21312;

      private boolean method09370() {
         return this.field21306;
      }

      private synchronized void method09371(FoundStructure var1) {
         this.field21308++;
         if (var1 != null) {
            this.field21305.add(var1);
         }

         this.field21311 = true;
      }

      private synchronized void method09372() {
         this.field21309 = true;
         this.field21311 = true;
      }

      private synchronized StructureSearch method09373() {
         if (this.field21311) {
            float var1 = this.field21307 == 0 ? (this.field21309 ? 1.0F : 0.0F) : (float)this.field21308 / this.field21307;
            this.field21312 = new StructureSearch(this.field21305, this.field21309, var1, this.field21310);
            this.field21311 = false;
         }

         return this.field21312;
      }

      private boolean method09374(int var1, int var2, int var3) {
         return this.field21301 == var1 && this.field21302 == var2 && this.field21303 == var3;
      }

      private synchronized void method09375(int var1) {
         this.field21307 = var1;
         this.field21311 = true;
      }

      private synchronized void method09376(String var1) {
         this.field21310 = var1;
         this.field21309 = true;
         this.field21311 = true;
      }

      private Nested260(ScriptWorldgenTools.Nested261 var1, int var2, int var3, int var4, Set<ResourceKey<Biome>> var5) {
         this.field21300 = var1;
         this.field21301 = var2;
         this.field21302 = var3;
         this.field21303 = var4;
         this.field21304 = var5;
      }

      private void method09377() {
         this.field21306 = true;
      }
   }

   // $VF: Compiled from s
   private record Nested261(long seed, ScriptWorldGenerator.Nested188 preset, Identifier set) {
   }
}
