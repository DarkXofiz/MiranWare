// Original binary: sg/ec/fIWUAkqNiQ1jihaT
package sg.ec;

import hex.api.baritone.api.utils.BlockOptionalMeta;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Stream;
import net.minecraft.client.multiplayer.ClientRegistryLayer;
import net.minecraft.core.Holder;
import net.minecraft.core.LayeredRegistryAccess;
import net.minecraft.core.Registry;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.RegistrySynchronization;
import net.minecraft.core.HolderLookup.Provider;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.HolderLookup.RegistryLookup.Delegate;
import net.minecraft.core.HolderSet.Named;
import net.minecraft.core.Registry.PendingTags;
import net.minecraft.core.RegistryAccess.Frozen;
import net.minecraft.core.RegistryAccess.ImmutableRegistryAccess;
import net.minecraft.core.RegistryAccess.RegistryEntry;
import net.minecraft.core.RegistrySynchronization.PackedRegistryEntry;
import net.minecraft.core.component.DataComponentMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.RegistryDataLoader.NetworkedRegistryData;
import net.minecraft.server.RegistryLayer;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.repository.ServerPacksSource;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.minecraft.server.packs.resources.ResourceProvider;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.FluidTags;
import net.minecraft.tags.TagKey;
import net.minecraft.tags.TagLoader;
import net.minecraft.tags.TagNetworkSerialization.NetworkPayload;
import net.minecraft.util.Util;
import net.minecraft.world.item.Items;

// $VF: Compiled from s
public final class RegistryDataMerger {
   private static final Set<ResourceKey<? extends Registry<?>>> field18901 = Set.of(Registries.ENCHANTMENT, Registries.ENCHANTMENT_PROVIDER);
   private static final int field18902 = 3;
   private static volatile boolean field18903;
   private static volatile int field18904;
   private static volatile boolean field18905;
   private static volatile boolean field18906;
   private static volatile RegistryAccess field18907;

   private static <T> void method08035(RegistryAccess var0, ResourceKey<? extends Registry<?>> var1, NetworkPayload var2) {
      if (!var2.isEmpty()) {
         try {
            Registry var3 = var0.lookupOrThrow((ResourceKey<? extends Registry<? extends T>>)var1);
            var3.prepareTagReload(var2.resolve(var3)).apply();
         } catch (Throwable var4) {
         }
      }
   }

   private static Frozen method08036(Frozen var0) {
      if (var0.registries().noneMatch(RegistryDataMerger::method08068)) {
         return var0;
      }

      RegistryAccess var1 = method08067();
      return var1 == null ? var0 : new ImmutableRegistryAccess(var0.registries().map(var1x -> method08059((RegistryEntry<?>)var1x, var1)).toList()).freeze();
   }

   public static void method08039() {
      if (!field18905) {
         method08041();
         method08065(field18907);
         if (!field18905) {
            method08065(method08067());
         }
      }
   }

   private static synchronized void method08040() {
      if (!field18903) {
         if (method08050()) {
            field18903 = true;
         } else {
            try (MultiPackResourceManager var0 = new MultiPackResourceManager(PackType.SERVER_DATA, List.<net.minecraft.server.packs.PackResources>of(ServerPacksSource.createVanillaPackSource()))) {
               Frozen var1 = RegistryLayer.createRegistryAccess().getLayer(RegistryLayer.STATIC);

               for (PendingTags var3 : TagLoader.loadTagsForExistingRegistries(var0, var1)) {
                  var3.apply();
               }

               field18903 = true;
            } catch (Throwable var6) {
               field18903 = ++field18904 >= 3;
            }
         }
      }
   }

   private static synchronized void method08041() {
      if (!field18906) {
         field18906 = true;
         CompletableFuture.runAsync(() -> {
            try {
               field18907 = BlockOptionalMeta.ServerLevelStub.vanillaRegistryAccess();
            } catch (Throwable var1) {
            }
         }, Util.ioPool());
      }
   }

   public static Frozen method08042(Frozen var0) {
      if (var0 == null) {
         return null;
      }

      method08048(var0);
      field18905 = true;
      return var0;
   }

   private static <T> RegistryLookup<T> method08043(final Registry<T> var0, NetworkPayload var1) {
      final ConcurrentHashMap<TagKey<T>, Named<T>> var2 = new ConcurrentHashMap<>();
      if (var1 != null) {
         var1.resolve(var0).tags().forEach((var2x, var3) -> var2.put(var2x, method08057(var0, (TagKey<T>)var2x, (List<Holder<T>>)var3)));
      }

      return new Delegate<T>()      // $VF: Compiled from s
 {
         @Override
         public Optional<Named<T>> get(TagKey<T> var1) {
            return Optional.of(
               var2.computeIfAbsent(
                  var1, var1x -> var0.get((TagKey<T>)var1x).orElseGet(() -> RegistryDataMerger.method08057(var0, (TagKey<T>)var1x, List.of()))
               )
            );
         }

         @Override
         public RegistryLookup<T> parent() {
            return var0;
         }

         @Override
         public Stream<Named<T>> listTags() {
            return var2.values().stream();
         }
      };
   }

   public static Map<ResourceKey<? extends Registry<?>>, NetworkPayload> method08046(
      Map<ResourceKey<? extends Registry<?>>, NetworkPayload> var0, Map<ResourceKey<? extends Registry<?>>, NetworkPayload> var1
   ) {
      if (var1 != null && !var1.isEmpty()) {
         var var2 = new HashMap<>(var0);
         var2.putAll(var1);
         return Map.copyOf(var2);
      } else {
         return var0;
      }
   }

   public static void method08047(Frozen var0, Map<ResourceKey<? extends Registry<?>>, NetworkPayload> var1) {
      if (var0 != null) {
         var1.forEach(
            (var1x, var2) -> {
               if (RegistrySynchronization.isNetworkable((ResourceKey<? extends Registry<?>>)var1x)
                  && !method08060(var0, (ResourceKey<? extends Registry<?>>)var1x)) {
                  method08035(var0, (ResourceKey<? extends Registry<?>>)var1x, var2);
               }
            }
         );
      }
   }

   private static void method08048(Provider var0) {
      // 1.21.11: varsayilan component'ler kayit sirasinda baglanir, ayrica uygulamaya gerek yok.
   }

   private static boolean method08050() {
      return BuiltInRegistries.BLOCK.getTagOrEmpty(BlockTags.MINEABLE_WITH_PICKAXE).iterator().hasNext()
         && BuiltInRegistries.FLUID.getTagOrEmpty(FluidTags.WATER).iterator().hasNext();
   }

   public static Frozen method08051() {
      return ClientRegistryLayer.createRegistryAccess().compositeAccess();
   }

   public static void method08053() {
      method08041();
      if (!field18903) {
         method08040();
      }

      if (!field18905) {
         method08065(field18907);
      }
   }

   private static Map<ResourceKey<? extends Registry<?>>, NetworkedRegistryData> method08054(
      Map<ResourceKey<? extends Registry<?>>, List<PackedRegistryEntry>> var0, Map<ResourceKey<? extends Registry<?>>, NetworkPayload> var1
   ) {
      HashMap var2 = new HashMap();
      var0.forEach((var1x, var2x) -> var2.put(var1x, new NetworkedRegistryData((List<PackedRegistryEntry>)var2x, NetworkPayload.EMPTY)));
      var1.forEach((var2x, var3) -> {
         if (!var3.isEmpty() && RegistrySynchronization.isNetworkable((ResourceKey<? extends Registry<?>>)var2x)) {
            var2.put(var2x, new NetworkedRegistryData(var0.getOrDefault(var2x, List.of()), var3));
         }
      });
      return var2;
   }

   private static <T> Named<T> method08057(Registry<T> var0, TagKey<T> var1, List<Holder<T>> var2) {
      Named var3 = new Named<>(var0, var1);
      var3.bind(var2);
      return var3;
   }

   private RegistryDataMerger() {
   }

   private static <T> Registry<T> method08059(RegistryEntry<T> var0, RegistryAccess var1) {
      return !method08068(var0) ? var0.value() : var1.<T>lookup(var0.key()).filter(var0x -> var0x.size() > 0).orElse(var0.value());
   }

   private static boolean method08060(RegistryAccess var0, ResourceKey<? extends Registry<?>> var1) {
      RegistryAccess var2 = field18907;
      return field18901.contains(var1) && var2 != null && var2.lookup(var1).equals(var0.lookup(var1));
   }

   public static Frozen method08062(
      Map<ResourceKey<? extends Registry<?>>, List<PackedRegistryEntry>> var0, Map<ResourceKey<? extends Registry<?>>, NetworkPayload> var1
   ) {
      method08039();
      LayeredRegistryAccess var2 = ClientRegistryLayer.createRegistryAccess();
      Frozen var3 = RegistryDataLoader.load(
            method08054(var0, var1),
            ResourceProvider.EMPTY,
            method08063(var2.getAccessForLoading(ClientRegistryLayer.REMOTE), var1),
            RegistryDataLoader.SYNCHRONIZED_REGISTRIES,
            Util.backgroundExecutor()
         )
         .join();
      // TODO(port 1.21.11): bindComponents 1.21.11'de yok
      return method08036(var2.replaceFrom(ClientRegistryLayer.REMOTE, var3).compositeAccess());
   }

   private static List<RegistryLookup<?>> method08063(Frozen var0, Map<ResourceKey<? extends Registry<?>>, NetworkPayload> var1) {
      return var0.registries().<RegistryLookup<?>>map(var1x -> method08043(var1x.value(), (NetworkPayload)var1.get(var1x.key()))).toList();
   }

   private static synchronized void method08065(RegistryAccess var0) {
      if (!field18905) {
         if (true) {
            field18905 = true;
         } else if (var0 != null) {
            try {
               method08048(var0);
            } catch (Throwable var2) {
               return;
            }

            field18905 = true;
         }
      }
   }

   public static void method08066(Map<ResourceKey<? extends Registry<?>>, NetworkPayload> var0) {
      if (var0 != null && !var0.isEmpty()) {
         Frozen var1 = method08051();
         var0.forEach((var1x, var2) -> {
            if (!RegistrySynchronization.isNetworkable((ResourceKey<? extends Registry<?>>)var1x)) {
               method08035(var1, (ResourceKey<? extends Registry<?>>)var1x, var2);
            }
         });
         field18903 = true;
      }
   }

   private static RegistryAccess method08067() {
      RegistryAccess var0 = field18907;
      if (var0 != null) {
         return var0;
      }

      try {
         var0 = BlockOptionalMeta.ServerLevelStub.vanillaRegistryAccess();
      } catch (Throwable var2) {
         return null;
      }

      field18907 = var0;
      return var0;
   }

   private static boolean method08068(RegistryEntry<?> var0) {
      return field18901.contains(var0.key()) && var0.value().size() == 0;
   }
}
