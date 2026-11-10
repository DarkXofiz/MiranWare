// Original binary: hex/api/baritone/api/utils/BlockOptionalMeta
package hex.api.baritone.api.utils;

import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.common.collect.ImmutableMap.Builder;
import hex.api.baritone.api.utils.accessor.IItemStack;
import hex.api.baritone.api.utils.accessor.ILootTable;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ForkJoinPool;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import net.minecraft.client.Minecraft;
import net.minecraft.core.LayeredRegistryAccess;
import net.minecraft.core.RegistryAccess;
import net.minecraft.core.HolderLookup.RegistryLookup;
import net.minecraft.core.Registry.PendingTags;
import net.minecraft.resources.RegistryDataLoader;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.RegistryLayer;
import net.minecraft.server.ReloadableServerRegistries;
import net.minecraft.server.ReloadableServerRegistries.Holder;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.packs.PackType;
import net.minecraft.server.packs.VanillaPackResources;
import net.minecraft.server.packs.repository.ServerPacksSource;
import net.minecraft.server.packs.resources.CloseableResourceManager;
import net.minecraft.server.packs.resources.MultiPackResourceManager;
import net.minecraft.tags.TagLoader;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.CustomSpawner;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateHolder;
import net.minecraft.world.level.block.state.properties.Property;
import net.minecraft.world.level.dimension.LevelStem;
import net.minecraft.world.level.storage.ServerLevelData;
import net.minecraft.world.level.storage.LevelStorageSource.LevelStorageAccess;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.LootTable;
import net.minecraft.world.level.storage.loot.parameters.LootContextParamSets;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.NotNull;
import sun.misc.Unsafe;

// $VF: Compiled from s
public final class BlockOptionalMeta {
   private static final Pattern PATTERN = Pattern.compile(BlockOptionalMeta.А1Б);
   private final Block block;
   private final String propertiesDescription;
   private final Set<BlockState> blockstates;
   private final ImmutableSet<Integer> stateHashes;
   private final ImmutableSet<Integer> stackHashes;
   private static Map<Block, List<Item>> drops = new HashMap<>();
   private static Method getVanillaServerPack;
   private static final String А13 = "А13";
   private static final String А1Ь = "А1Ь";
   private static final String А11 = "А11";
   private static final String А1я = "А1я";
   private static final String А_1I = "А_1I";
   private static final String А1ы = "А1ы";
   private static final String А1у = "А1у";
   private static final String А1г = "А1г";
   private static final String А1ю = "А1ю";
   private static final String А14 = "А14";
   private static final String А1С = "А1С";
   private static final String А1ъ = "А1ъ";
   private static final String А1Б = "А1Б";

   public BlockOptionalMeta(@NotNull String var1) {
      Matcher var2 = PATTERN.matcher(var1);
      if (!var2.find()) {
         throw new IllegalArgumentException(А1Ь);
      }

      this.block = BlockUtils.stringToBlockRequired(var2.group(А11));
      String sx = var2.group(А1я);
      Map<Property<?>, ?> sxx = sx != null && !sx.equals("") ? parseProperties(this.block, sx) : Collections.emptyMap();
      this.propertiesDescription = sx == null ? А_1I : "{" + sx.replace(А1ы, А1у) + "}";
      this.blockstates = getStates(this.block, sxx);
      this.stateHashes = getStateHashes(this.blockstates);
      this.stackHashes = getStackHashes(this.blockstates);
   }

   public BlockOptionalMeta(@NotNull Block var1) {
      this.block = var1;
      this.propertiesDescription = А13;
      this.blockstates = getStates(var1, Collections.emptyMap());
      this.stateHashes = getStateHashes(this.blockstates);
      this.stackHashes = getStackHashes(this.blockstates);
   }

   private static ImmutableSet<Integer> getStackHashes(Set<BlockState> var0) {
      return ImmutableSet.copyOf(
         var0.stream()
            .flatMap(var0x -> drops(var0x.getBlock()).stream().map(var0xx -> new ItemStack(var0xx, 1)))
            .map(var0x -> ((IItemStack)(Object)var0x).getBaritoneHash())
            .toArray(Integer[]::new)
      );
   }

   @Override
   public String toString() {
      return String.format(А1С, this.block, this.propertiesDescription);
   }

   private static synchronized List<Item> drops(Block var0) {
      return drops.computeIfAbsent(
         var0,
         var1 -> {
            var var2 = var1.getLootTable();
            if (var2.isEmpty()) {
               return Collections.emptyList();
            }

            List sx = new ArrayList<>();

            try {
               ServerLevel sxx = BlockOptionalMeta.ServerLevelStub.fastCreate();
               net.minecraft.world.level.storage.loot.LootParams.Builder sxxx = new net.minecraft.world.level.storage.loot.LootParams.Builder(sxx)
                  .withParameter(LootContextParams.ORIGIN, Vec3.ZERO)
                  .withParameter(LootContextParams.BLOCK_STATE, var0.defaultBlockState())
                  .withParameter(LootContextParams.TOOL, new ItemStack(Items.NETHERITE_PICKAXE, 1));
               getDrops(var1, sxxx).stream().map(ItemStack::getItem).forEach(sx::add);
            } catch (Throwable var6) {
            }

            return sx;
         }
      );
   }

   private static Set<BlockState> getStates(@NotNull Block var0, @NotNull Map<Property<?>, ?> var1) {
      return var0.getStateDefinition()
         .getPossibleStates()
         .stream()
         .filter(var1x -> var1.entrySet().stream().allMatch(var1xx -> var1x.getValue(var1xx.getKey()) == var1xx.getValue()))
         .collect(Collectors.toSet());
   }

   public Set<Integer> stackHashes() {
      return this.stackHashes;
   }

   private static VanillaPackResources getVanillaServerPack() {
      if (getVanillaServerPack == null) {
         getVanillaServerPack = Arrays.stream(ServerPacksSource.class.getDeclaredMethods())
            .filter(var0 -> var0.getReturnType() == VanillaPackResources.class)
            .findFirst()
            .orElseThrow();
         getVanillaServerPack.setAccessible(true);
      }

      try {
         return (VanillaPackResources)getVanillaServerPack.invoke(null);
      } catch (Exception var1) {
         return null;
      }
   }

   private static <C extends Comparable<C>, P extends Property<C>> P castToIProperty(Object var0) {
      return (P)var0;
   }

   private static ImmutableSet<Integer> getStateHashes(Set<BlockState> var0) {
      return ImmutableSet.copyOf(var0.stream().map(StateHolder::hashCode).toArray(Integer[]::new));
   }

   public boolean matches(@NotNull BlockState var1) {
      Block var2 = var1.getBlock();
      return var2 == this.block && this.stateHashes.contains(var1.hashCode());
   }

   public Set<BlockState> getAllBlockStates() {
      return this.blockstates;
   }

   private static Map<Property<?>, ?> parseProperties(Block var0, String var1) {
      Builder var2 = ImmutableMap.builder();

      for (String sx : var1.split(А1г)) {
         String[] sxx = sx.split(А1ю);
         if (sxx.length != 2) {
            throw new IllegalArgumentException(String.format(А14, sx));
         }

         String sxxx = sxx[0];
         String sxxxx = sxx[1];
         var sxxxxx = var0.getStateDefinition().getProperty(sxxx);
         Comparable sxxxxxx = (Comparable<?>)castToIProperty(sxxxxx)
            .getValue(sxxxx)
            .orElseThrow(() -> new IllegalArgumentException(String.format(А1ъ, sxxx, sxxxx, var0)));
         var2.put(sxxxxx, sxxxxxx);
      }

      return var2.build();
   }

   public boolean matches(@NotNull Block var1) {
      return var1 == this.block;
   }

   private static List<ItemStack> getDrops(Block var0, net.minecraft.world.level.storage.loot.LootParams.Builder var1) {
      var var2 = var0.getLootTable();
      if (var2.isEmpty()) {
         return Collections.emptyList();
      }

      try {
         LootParams sx = var1.withParameter(LootContextParams.BLOCK_STATE, var0.defaultBlockState()).create(LootContextParamSets.BLOCK);
         BlockOptionalMeta.ServerLevelStub sxx = (BlockOptionalMeta.ServerLevelStub)sx.getLevel();
         LootTable sxxx = sxx.holder().getLootTable(var2.get());
         return ((ILootTable)sxxx)
            .invokeGetRandomItems(new net.minecraft.world.level.storage.loot.LootContext.Builder(sx).withOptionalRandomSeed(1L).create(null));
      } catch (Throwable sx) {
         return Collections.emptyList();
      }
   }

   public Block getBlock() {
      return this.block;
   }


   public boolean matches(ItemStack var1) {
      int var2 = ((IItemStack)(Object)var1).getBaritoneHash();
      var2 -= var1.getDamageValue();
      return this.stackHashes.contains(var2);
   }

   public BlockState getAnyBlockState() {
      return this.blockstates.size() > 0 ? this.blockstates.iterator().next() : null;
   }

   // $VF: Compiled from s
   public static class ServerLevelStub extends ServerLevel {
      private static Minecraft client = Minecraft.getInstance();
      private static Unsafe unsafe = getUnsafe();
      private static CompletableFuture<RegistryAccess> registryAccess = load();
      private static final String бI6 = "theUnsafe";

      public static BlockOptionalMeta.ServerLevelStub fastCreate() {
         try {
            return (BlockOptionalMeta.ServerLevelStub)unsafe.allocateInstance(BlockOptionalMeta.ServerLevelStub.class);
         } catch (InstantiationException var1) {
            throw new RuntimeException(var1);
         }
      }

      public static RegistryAccess vanillaRegistryAccess() {
         return registryAccess.join();
      }

      public ServerLevelStub(
         MinecraftServer var1,
         Executor var2,
         LevelStorageAccess var3,
         ServerLevelData var4,
         ResourceKey<Level> var5,
         LevelStem var6,
         boolean var7,
         long var8,
         List<CustomSpawner> var10,
         boolean var11
      ) {
         super(var1, var2, var3, var4, var5, var6, var7, var8, var10, var11, null);
      }


      @Override
      public FeatureFlagSet enabledFeatures() {
         assert client.level != null;
         return client.level.enabledFeatures();
      }

      @Override
      public RegistryAccess registryAccess() {
         return client.level != null ? client.level.registryAccess() : registryAccess.join();
      }

      public Holder holder() {
         return new Holder(this.registryAccess().freeze());
      }

      public static CompletableFuture<RegistryAccess> load() {
         CloseableResourceManager var0 = new MultiPackResourceManager(PackType.SERVER_DATA, List.<net.minecraft.server.packs.PackResources>of(ServerPacksSource.createVanillaPackSource()));
         LayeredRegistryAccess<RegistryLayer> sx = RegistryLayer.createRegistryAccess();
         var sxx = TagLoader.loadTagsForExistingRegistries(var0, sx.getLayer(RegistryLayer.STATIC));
         var sxxx = TagLoader.buildUpdatedLookups(sx.getAccessForLoading(RegistryLayer.WORLDGEN), sxx);
         LayeredRegistryAccess<RegistryLayer> sxxxx = sx.replaceFrom(
            RegistryLayer.WORLDGEN, RegistryDataLoader.load(var0, sxxx, RegistryDataLoader.WORLDGEN_REGISTRIES)
         );
         return ReloadableServerRegistries.reload(sxxxx, sxx, var0, ForkJoinPool.commonPool()).thenApply(var0x -> var0x.layers().compositeAccess());
      }

      public static Unsafe getUnsafe() {
         try {
            Field var0 = Unsafe.class.getDeclaredField(бI6);
            var0.setAccessible(true);
            return (Unsafe)var0.get(null);
         } catch (Exception var1) {
            throw new RuntimeException(var1);
         }
      }
   }
}
