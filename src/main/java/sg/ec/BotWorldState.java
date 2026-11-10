// Original binary: sg/ec/eVywX2yx8YwWp8k7
package sg.ec;

import com.mojang.authlib.GameProfile;
import com.mojang.datafixers.util.Pair;
import java.nio.charset.StandardCharsets;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.function.Function;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.CommonListenerCookie;
import net.minecraft.client.multiplayer.LevelLoadTracker;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.telemetry.TelemetryEventSender;
import net.minecraft.client.telemetry.WorldSessionTelemetryManager;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.Registry;
import net.minecraft.core.SectionPos;
import net.minecraft.core.RegistryAccess.Frozen;
import net.minecraft.network.Connection;
import net.minecraft.network.PacketProcessor;
import net.minecraft.network.chat.Component;
import net.minecraft.network.protocol.Packet;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundBlockEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundBossEventPacket;
import net.minecraft.network.protocol.game.ClientboundChangeDifficultyPacket;
import net.minecraft.network.protocol.game.ClientboundCommandsPacket;
import net.minecraft.network.protocol.game.ClientboundCooldownPacket;
import net.minecraft.network.protocol.game.ClientboundForgetLevelChunkPacket;
import net.minecraft.network.protocol.game.ClientboundGameEventPacket;
import net.minecraft.network.protocol.game.ClientboundInitializeBorderPacket;
import net.minecraft.network.protocol.game.ClientboundLevelChunkWithLightPacket;
import net.minecraft.network.protocol.game.ClientboundLightUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundLoginPacket;
import net.minecraft.network.protocol.game.ClientboundMapItemDataPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoRemovePacket;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookAddPacket;
import net.minecraft.network.protocol.game.ClientboundRecipeBookSettingsPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveEntitiesPacket;
import net.minecraft.network.protocol.game.ClientboundRemoveMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundResetScorePacket;
import net.minecraft.network.protocol.game.ClientboundSectionBlocksUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundSelectAdvancementsTabPacket;
import net.minecraft.network.protocol.game.ClientboundServerDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderCenterPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderLerpSizePacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderSizePacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderWarningDelayPacket;
import net.minecraft.network.protocol.game.ClientboundSetBorderWarningDistancePacket;
import net.minecraft.network.protocol.game.ClientboundSetCameraPacket;
import net.minecraft.network.protocol.game.ClientboundSetChunkCacheCenterPacket;
import net.minecraft.network.protocol.game.ClientboundSetChunkCacheRadiusPacket;
import net.minecraft.network.protocol.game.ClientboundSetDefaultSpawnPositionPacket;
import net.minecraft.network.protocol.game.ClientboundSetDisplayObjectivePacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityLinkPacket;
import net.minecraft.network.protocol.game.ClientboundSetEquipmentPacket;
import net.minecraft.network.protocol.game.ClientboundSetObjectivePacket;
import net.minecraft.network.protocol.game.ClientboundSetPassengersPacket;
import net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket;
import net.minecraft.network.protocol.game.ClientboundSetScorePacket;
import net.minecraft.network.protocol.game.ClientboundSetSimulationDistancePacket;
import net.minecraft.network.protocol.game.ClientboundSetTimePacket;
import net.minecraft.network.protocol.game.ClientboundTabListPacket;
import net.minecraft.network.protocol.game.ClientboundTickingStatePacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAdvancementsPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateAttributesPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateMobEffectPacket;
import net.minecraft.network.protocol.game.ClientboundUpdateRecipesPacket;
import net.minecraft.network.protocol.game.CommonPlayerSpawnInfo;
import net.minecraft.network.protocol.game.ClientboundBossEventPacket.Handler;
import net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Action;
import net.minecraft.network.protocol.game.ClientboundUpdateAttributesPacket.AttributeSnapshot;
import net.minecraft.network.syncher.SynchedEntityData.DataValue;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.ServerLinks;
import net.minecraft.tags.TagNetworkSerialization.NetworkPayload;
import net.minecraft.world.BossEvent;
import net.minecraft.world.BossEvent.BossBarColor;
import net.minecraft.world.BossEvent.BossBarOverlay;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeInstance;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.flag.FeatureFlagSet;
import net.minecraft.world.flag.FeatureFlags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.saveddata.maps.MapDecoration;
import net.minecraft.world.level.saveddata.maps.MapId;
import net.minecraft.world.level.saveddata.maps.MapItemSavedData.MapPatch;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.scores.DisplaySlot;
import net.minecraft.world.scores.Objective;
import net.minecraft.world.scores.PlayerScoreEntry;
import net.minecraft.world.scores.ScoreAccess;
import net.minecraft.world.scores.ScoreHolder;
import net.minecraft.world.scores.Scoreboard;
import net.minecraft.world.scores.criteria.ObjectiveCriteria;
import sg.mx.ClientPacketListenerMixin;
import sg.mx.ClientboundSectionBlocksUpdatePacketMixin;

// $VF: Compiled from s
public final class BotWorldState {
   private static final int field18538 = 2048;
   private static final int field18539 = 0;
   private static final int field18540 = 0;
   private static final int field18541 = 0;
   private static final int field18542 = 0;
   private static final int field18543 = 0;
   private static final int field18544 = 0;
   private static final int field18545 = 0;
   private static final int field18546 = 0;
   private static final int field18547 = 0;
   private static final int field18548 = 0;
   private static final int field18549 = 0;
   private static final int field18550 = 0;
   private static final int field18551 = 0;
   private static final int field18552 = 0;
   private static final int field18553 = 0;
   private static final int field18554 = 0;
   private static final long field18555 = 0;
   private static final long field18556 = 0;
   private final Object field18557 = new Object();
   private final Map<Long, BotWorldState.Nested226> field18558 = new LinkedHashMap<>();
   private final Set<Long> field18559 = new LinkedHashSet<>();
   private volatile boolean field18560;
   private final Map<Integer, BotWorldState.Nested225> field18561 = new LinkedHashMap<>();
   private final ArrayDeque<ClientboundLevelChunkWithLightPacket> field18562 = new ArrayDeque<>();
   private final Map<UUID, ClientboundPlayerInfoUpdatePacket> field18563 = new LinkedHashMap<>();
   private final Map<UUID, Map<Action, ClientboundPlayerInfoUpdatePacket>> field18564 = new LinkedHashMap<>();
   private final Set<UUID> field18565 = new LinkedHashSet<>();
   private final ArrayDeque<ClientboundGameEventPacket> field18566 = new ArrayDeque<>();
   private final Map<String, List<ClientboundSetPlayerTeamPacket>> field18567 = new LinkedHashMap<>();
   private final Map<UUID, PlayerInfo> field18568 = new LinkedHashMap<>();
   private final Set<PlayerInfo> field18569 = new LinkedHashSet<>();
   private final Scoreboard field18570 = new Scoreboard();
   private final Map<UUID, MutableBossEvent> field18571 = new LinkedHashMap<>();
   private final Map<Integer, Map<Holder<MobEffect>, ClientboundUpdateMobEffectPacket>> field18572 = new LinkedHashMap<>();
   private final Map<Integer, Map<Holder<Attribute>, AttributeSnapshot>> field18573 = new LinkedHashMap<>();
   private final Map<Integer, ClientboundSetPassengersPacket> field18574 = new LinkedHashMap<>();
   private final Map<Integer, ClientboundSetEntityLinkPacket> field18575 = new LinkedHashMap<>();
   private final Map<BlockPos, ClientboundBlockEntityDataPacket> field18576 = new LinkedHashMap<>();
   private final Map<Identifier, ClientboundCooldownPacket> field18577 = new LinkedHashMap<>();
   private final Map<MapId, BotWorldState.Nested227> field18578 = new LinkedHashMap<>();
   private volatile ClientboundTabListPacket field18579;
   private volatile ClientboundUpdateRecipesPacket field18580;
   private volatile ClientboundRecipeBookAddPacket field18581;
   private volatile ClientboundRecipeBookSettingsPacket field18582;
   private volatile ClientboundUpdateAdvancementsPacket field18583;
   private volatile ClientboundSelectAdvancementsTabPacket field18584;
   private volatile ClientboundInitializeBorderPacket field18585;
   private volatile ClientboundSetBorderCenterPacket field18586;
   private volatile ClientboundSetBorderSizePacket field18587;
   private volatile ClientboundSetBorderLerpSizePacket field18588;
   private volatile ClientboundSetBorderWarningDelayPacket field18589;
   private volatile ClientboundSetBorderWarningDistancePacket field18590;
   private volatile ClientboundServerDataPacket field18591;
   private volatile ClientboundTickingStatePacket field18592;
   private volatile ClientboundSetCameraPacket field18593;
   private volatile ClientboundLoginPacket field18594;
   private volatile CommonPlayerSpawnInfo field18595;
   private volatile Frozen field18596;
   private volatile Map<ResourceKey<? extends Registry<?>>, NetworkPayload> field18597 = Map.of();
   private volatile FeatureFlagSet field18598 = FeatureFlags.DEFAULT_FLAGS;
   private volatile String field18599;
   private volatile String field18600 = "";
   private volatile boolean field18601 = true;
   private volatile boolean field18602 = true;
   private volatile boolean field18603 = true;
   private volatile GameProfile field18604;
   private volatile BotClientLevel field18605;
   private volatile BotLocalPlayer field18606;
   private volatile ClientPacketListener field18607;
   private volatile boolean field18608;
   private volatile BotClient field18609;
   private static final GameProfile field18610 = new GameProfile(
      UUID.nameUUIDFromBytes(BotWorldState.field18627.getBytes(StandardCharsets.UTF_8)), BotWorldState.field18628
   );
   private volatile ClientboundCommandsPacket field18611;
   private volatile ClientboundSetTimePacket field18612;
   private volatile ClientboundChangeDifficultyPacket field18613;
   private volatile ClientboundSetDefaultSpawnPositionPacket field18614;
   private volatile ClientboundSetChunkCacheCenterPacket field18615;
   private volatile ClientboundSetChunkCacheRadiusPacket field18616;
   private volatile ClientboundSetSimulationDistancePacket field18617;
   private int field18618;
   private int field18619;
   private final Handler field18620 = new Handler()   // $VF: Compiled from s
 {
      @Override
      public void remove(UUID var1) {
         synchronized (BotWorldState.this.field18557) {
            BotWorldState.this.field18571.remove(var1);
         }
      }

      @Override
      public void add(UUID var1, Component var2, float var3, BossBarColor var4, BossBarOverlay var5, boolean var6, boolean var7, boolean var8) {
         synchronized (BotWorldState.this.field18557) {
            MutableBossEvent var10 = new MutableBossEvent(var1, var2, var4, var5);
            var10.setProgress(var3);
            var10.setDarkenScreen(var6);
            var10.setPlayBossMusic(var7);
            var10.setCreateWorldFog(var8);
            BotWorldState.this.field18571.put(var1, var10);
         }
      }

      @Override
      public void updateStyle(UUID var1, BossBarColor var2, BossBarOverlay var3) {
         synchronized (BotWorldState.this.field18557) {
            MutableBossEvent var5 = BotWorldState.this.field18571.get(var1);
            if (var5 != null) {
               var5.setColor(var2);
               var5.setOverlay(var3);
            }
         }
      }

      @Override
      public void updateProperties(UUID var1, boolean var2, boolean var3, boolean var4) {
         synchronized (BotWorldState.this.field18557) {
            MutableBossEvent var6 = BotWorldState.this.field18571.get(var1);
            if (var6 != null) {
               var6.setDarkenScreen(var2);
               var6.setPlayBossMusic(var3);
               var6.setCreateWorldFog(var4);
            }
         }
      }

      @Override
      public void updateName(UUID var1, Component var2) {
         synchronized (BotWorldState.this.field18557) {
            MutableBossEvent var4 = BotWorldState.this.field18571.get(var1);
            if (var4 != null) {
               var4.setName(var2);
            }
         }
      }

      @Override
      public void updateProgress(UUID var1, float var2) {
         synchronized (BotWorldState.this.field18557) {
            MutableBossEvent var4 = BotWorldState.this.field18571.get(var1);
            if (var4 != null) {
               var4.setProgress(var2);
            }
         }
      }
   };
   private static final String field18621 = "мир не собрался";
   private static final String field18622 = "CHUNK";
   private static final String field18623 = "LEVEL";
   private static final long field18624 = 1099511627775L;
   private static final long field18625 = 1048575L;
   private static final long field18626 = 4294967295L;
   private static final String field18627 = "bot";
   private static final String field18628 = "bot";

   public BotClientLevel method07636() {
      return this.field18605;
   }

   public void method07637(ClientboundSetEntityLinkPacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            if (var1.getDestId() == 0) {
               this.field18575.remove(var1.getSourceId());
            } else {
               this.field18575.put(var1.getSourceId(), var1);
            }
         }
      }
   }

   public void method07638() {
      ClientboundLoginPacket var1 = this.field18594;
      Frozen var2 = this.field18596;
      if (var1 != null && var2 != null && this.field18619 <= 0) {
         BotClient var3 = this.field18609;
         Connection var4 = var3 == null ? null : var3.method00128();
         if (var4 != null) {
            try {
               Minecraft var5 = Minecraft.getInstance();
               WorldSessionTelemetryManager var6 = new WorldSessionTelemetryManager(
                  TelemetryEventSender.DISABLED, false, null, null, var3.method00070().method08001()
               );
               ClientPacketListener var7 = new ClientPacketListener(
                  var5,
                  var4,
                  new CommonListenerCookie(
                     new LevelLoadTracker(),
                     this.field18604 == null ? field18610 : this.field18604,
                     var6,
                     var2,
                     this.field18598,
                     this.field18599,
                     null,
                     null,
                     new HashMap<>(),
                     null,
                     Map.of(),
                     ServerLinks.EMPTY,
                     Map.of(),
                     false
                  )
               );
               ClientboundSetChunkCacheRadiusPacket var8 = this.field18616;
               int var9 = Math.max(var1.chunkRadius(), var8 == null ? 0 : var8.getRadius());
               CommonPlayerSpawnInfo var10 = this.field18595;
               if (var10 == null) {
                  var10 = var1.commonPlayerSpawnInfo();
               }

               ClientboundSetSimulationDistancePacket var11 = this.field18617;
               BotClientLevel var12 = new BotClientLevel(
                  var7, var1, var10, var9, var11 == null ? var1.simulationDistance() : var11.simulationDistance(), this.field18570
               );
               ((ClientPacketListenerMixin)(Object)var7).markClientLoaded(true);
               if (this.field18585 != null) {
                  var12.applyBorder(this.field18585);
               }

               if (this.field18586 != null) {
                  var12.applyBorderCenter(this.field18586);
               }

               if (this.field18587 != null) {
                  var12.applyBorderSize(this.field18587);
               }

               if (this.field18588 != null) {
                  var12.applyBorderLerp(this.field18588);
               }

               if (this.field18589 != null) {
                  var12.applyBorderWarningDelay(this.field18589);
               }

               if (this.field18590 != null) {
                  var12.applyBorderWarningDistance(this.field18590);
               }

               this.field18602 = true;
               this.field18603 = true;
               BotLocalPlayer var13 = new BotLocalPlayer(var5, var12, var7);
               var13.setId(var1.playerId());
               var13.seedSentBaseline(var3.method00070());
               var12.entityStore().method07259(var13);
               this.field18606 = var13;
               int var14 = SectionPos.blockToSectionCoord(var3.method00070().method08006());
               int var15 = SectionPos.blockToSectionCoord(var3.method00070().method08004());
               int var16 = Math.max(2, var9);
               var12.getChunkSource().updateViewCenter(var14, var15);
               synchronized (this.field18557) {
                  this.field18562.clear();

                  for (BotWorldState.Nested226 var19 : this.field18558.values()) {
                     if (var19.field18643 != null && method07755(var19, var14, var15, var16)) {
                        if (method07755(var19, var14, var15, 2)) {
                           var12.loadChunk(var19.field18643);
                        } else {
                           this.field18562.addLast(var19.field18643);
                        }
                     }
                  }

                  for (BotWorldState.Nested225 var26 : this.field18561.values()) {
                     if (var26.field18629 != null) {
                        try {
                           var12.entityStore().method07245(var26.field18629, this.method07714(var26.field18629.getUUID()));
                           ClientboundSetEntityDataPacket var20 = var26.method07818();
                           if (var20 != null) {
                              var12.entityStore().method07253(var20);
                           }

                           var12.entityStore()
                              .method07244(var26.field18629.getId(), var26.field18632, var26.field18633, var26.field18634, var26.field18635, var26.field18636);
                        } catch (Throwable var22) {
                           var12.entityStore().method07263(var26.field18629.getId());
                        }
                     }
                  }
               }

               this.field18607 = var7;
               this.field18605 = var12;
               this.method07735();
            } catch (Throwable var24) {
               this.method07754(field18621, var24);
            }
         }
      }
   }

   public void method07639(ClientboundMapItemDataPacket var1) {
      synchronized (this.field18557) {
         this.field18578.computeIfAbsent(var1.mapId(), var0 -> new BotWorldState.Nested227()).method07824(var1);
      }
   }

   public void method07640(int var1, float var2) {
      if (this.field18601) {
         synchronized (this.field18557) {
            BotWorldState.Nested225 var4 = this.field18561.get(var1);
            if (var4 != null) {
               var4.field18637 = var2;
               var4.field18638 = true;
               BotClientLevel var5 = this.field18605;
               if (var5 != null) {
                  var5.entityStore().method07257(var1, var2);
               }
            }
         }
      }
   }

   public void method07641(PacketProcessor var1, ClientGamePacketListener var2) {
      synchronized (this.field18557) {
         this.field18559.clear();
         this.field18560 = true;
      }

      method07800(var1, var2, this.method07678());
      synchronized (this.field18557) {
         for (var var5 : this.field18567.values()) {
            for (ClientboundSetPlayerTeamPacket var7 : (Iterable<ClientboundSetPlayerTeamPacket>) (Iterable) var5) {
               method07800(var1, var2, var7);
            }
         }
      }

      method07800(var1, var2, this.field18611);
      method07800(var1, var2, this.field18580);
      method07800(var1, var2, this.field18581);
      method07800(var1, var2, this.field18582);
      method07800(var1, var2, this.field18583);
      method07800(var1, var2, this.field18584);
      method07800(var1, var2, this.field18591);
      method07800(var1, var2, this.field18592);
      method07800(var1, var2, this.field18579);
      ClientboundSetChunkCacheCenterPacket var18 = this.method07769();
      int var19 = var18 == null ? -1 : this.method07657(var18.getX(), var18.getZ());
      method07800(var1, var2, var19 < 0 ? this.field18616 : new ClientboundSetChunkCacheRadiusPacket(var19));
      method07800(var1, var2, this.field18617);
      method07800(var1, var2, var18);
      method07800(var1, var2, this.field18613);
      method07800(var1, var2, this.field18614);
      method07800(var1, var2, this.field18612);
      method07800(var1, var2, this.field18585);
      method07800(var1, var2, this.field18586);
      method07800(var1, var2, this.field18587);
      method07800(var1, var2, this.field18588);
      method07800(var1, var2, this.field18589);
      method07800(var1, var2, this.field18590);
      synchronized (this.field18557) {
         var var21 = new LinkedHashSet<>(this.field18563.values());

         for (ClientboundPlayerInfoUpdatePacket var8 : var21) {
            method07800(var1, var2, var8);
         }

         LinkedHashSet var23 = new LinkedHashSet();

         for (var var9 : this.field18564.values()) {
            var23.addAll(var9.values());
         }

         var23.removeAll(var21);

         for (ClientboundPlayerInfoUpdatePacket var38 : (Iterable<ClientboundPlayerInfoUpdatePacket>) (Iterable) var23) {
            method07800(var1, var2, var38);
         }

         if (!this.field18565.isEmpty()) {
            method07800(var1, var2, new ClientboundPlayerInfoRemovePacket(new ArrayList<>(this.field18565)));
         }

         for (BotWorldState.Nested226 var39 : this.field18558.values()) {
            method07800(var1, var2, var39.field18643);
            method07800(var1, var2, var39.field18644);

            for (Packet var11 : var39.field18645) {
               method07800(var1, var2, var11);
            }
         }

         for (BotWorldState.Nested225 var40 : this.field18561.values()) {
            if (var40.field18629 != null) {
               method07800(var1, var2, var40.method07817());
               method07800(var1, var2, var40.method07818());
               method07800(var1, var2, var40.method07820());
            }
         }

         for (ClientboundBlockEntityDataPacket var41 : this.field18576.values()) {
            method07800(var1, var2, var41);
         }

         for (BotWorldState.Nested225 var42 : this.field18561.values()) {
            if (var42.field18629 != null) {
               method07800(var1, var2, this.field18574.get(var42.field18629.getId()));
               method07800(var1, var2, this.field18575.get(var42.field18629.getId()));
            }
         }

         for (var var43 : this.field18573.entrySet()) {
            method07800(var1, var2, method07676((Integer)var43.getKey(), ((Map)var43.getValue()).values()));
         }

         for (var var44 : this.field18572.values()) {
            for (ClientboundUpdateMobEffectPacket var54 : (Iterable<ClientboundUpdateMobEffectPacket>) (Iterable) var44.values()) {
               method07800(var1, var2, var54);
            }
         }

         for (Objective var45 : this.field18570.getObjectives()) {
            method07800(var1, var2, new ClientboundSetObjectivePacket(var45, 0));

            for (PlayerScoreEntry var55 : this.field18570.listPlayerScores(var45)) {
               method07800(
                  var1,
                  var2,
                  new ClientboundSetScorePacket(
                     var55.owner(), var45.getName(), var55.value(), Optional.ofNullable(var55.display()), Optional.ofNullable(var55.numberFormatOverride())
                  )
               );
            }
         }

         for (DisplaySlot var56 : DisplaySlot.values()) {
            Objective var12 = this.field18570.getDisplayObjective(var56);
            if (var12 != null) {
               method07800(var1, var2, new ClientboundSetDisplayObjectivePacket(var56, var12));
            }
         }

         for (MutableBossEvent var47 : this.field18571.values()) {
            method07800(var1, var2, ClientboundBossEventPacket.createAddPacket(var47));
         }

         for (ClientboundCooldownPacket var48 : this.field18577.values()) {
            method07800(var1, var2, var48);
         }

         for (var var49 : this.field18578.entrySet()) {
            method07800(var1, var2, ((BotWorldState.Nested227)var49.getValue()).method07822((MapId)var49.getKey()));
         }

         for (ClientboundGameEventPacket var50 : this.field18566) {
            method07800(var1, var2, var50);
         }

         method07800(var1, var2, this.field18593);
      }
   }

   public Map<UUID, Map<Action, ClientboundPlayerInfoUpdatePacket>> method07642() {
      return this.field18564;
   }

   public void method07643(ClientboundServerDataPacket var1) {
      this.field18591 = var1;
   }

   public Map<Long, BotWorldState.Nested226> method07644() {
      return this.field18558;
   }

   public ClientboundTickingStatePacket method07645() {
      return this.field18592;
   }

   public Set<UUID> method07647() {
      return this.field18565;
   }

   public void method07648(ClientboundLevelChunkWithLightPacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            BotWorldState.Nested226 var3 = this.method07699(var1.x(), var1.z(), true);
            var3.field18643 = var1;
            var3.field18644 = null;
            var3.field18645.clear();
            this.method07806(var3);
            this.method07660();
            BotClientLevel var4 = this.field18605;
            if (var4 != null) {
               try {
                  var4.loadChunk(var1);
               } catch (Throwable var7) {
                  this.method07754("чанк " + var1.x() + " " + var1.z() + " не разобран", var7);
               }
            }
         }
      }
   }

   public void method07649() {
      this.method07735();
      this.method07812();
      synchronized (this.field18557) {
         this.field18560 = false;
         this.field18559.clear();
         this.field18558.clear();
         this.field18561.clear();
         this.field18563.clear();
         this.field18564.clear();
         this.field18565.clear();
         this.field18566.clear();
         this.field18567.clear();
         this.field18568.clear();
         this.field18569.clear();
         this.method07807();
         this.field18571.clear();
         this.field18577.clear();
         this.field18576.clear();
         this.field18574.clear();
         this.field18575.clear();
         this.field18573.clear();
         this.field18572.clear();
      }

      this.method07658();
      this.field18593 = null;
      this.field18594 = null;
      this.field18611 = null;
      this.field18612 = null;
      this.field18613 = null;
      this.field18614 = null;
      this.field18615 = null;
      this.field18616 = null;
      this.field18617 = null;
      this.field18600 = "";
   }

   public void method07650(ClientboundSelectAdvancementsTabPacket var1) {
      this.field18584 = var1;
   }

   public ClientboundRecipeBookAddPacket method07651() {
      return this.field18581;
   }

   public ClientboundSetCameraPacket method07652() {
      return this.field18593;
   }

   public ClientboundSetBorderLerpSizePacket method07653() {
      return this.field18588;
   }

   private void method07654(UUID var1, GameProfile var2) {
      BotClientLevel var3 = this.field18605;
      if (var3 != null && var2 != null) {
         for (BotWorldState.Nested225 var5 : this.field18561.values()) {
            if (var5.field18629 != null && var5.field18629.getUUID().equals(var1) && var3.entityStore().method07261(var5.field18629.getId()) == null) {
               var3.entityStore().method07245(var5.method07817(), var2);
               ClientboundSetEntityDataPacket var6 = var5.method07818();
               if (var6 != null) {
                  var3.entityStore().method07253(var6);
               }

               ClientboundSetPassengersPacket var7 = this.field18574.get(var5.field18629.getId());
               if (var7 != null) {
                  var3.entityStore().method07247(var7);
               }

               return;
            }
         }
      }
   }

   public void method07655(ClientboundTabListPacket var1) {
      this.field18579 = var1;
   }

   public boolean method07656() {
      return this.field18560;
   }

   private int method07657(int var1, int var2) {
      int var3 = Math.max(this.field18616 == null ? 2 : this.field18616.getRadius(), Minecraft.getInstance().options.getEffectiveRenderDistance());
      synchronized (this.field18557) {
         for (BotWorldState.Nested226 var6 : this.field18558.values()) {
            var3 = Math.max(var3, Math.max(Math.abs(var6.field18641 - var1), Math.abs(var6.field18642 - var2)));
         }
      }

      return Math.min(var3, 32);
   }

   private void method07658() {
      this.field18579 = null;
      this.field18580 = null;
      this.field18581 = null;
      this.field18582 = null;
      this.field18583 = null;
      this.field18584 = null;
      this.field18585 = null;
      this.field18586 = null;
      this.field18587 = null;
      this.field18588 = null;
      this.field18589 = null;
      this.field18590 = null;
      this.field18591 = null;
      this.field18592 = null;
   }

   public ClientboundSetSimulationDistancePacket method07659() {
      return this.field18617;
   }

   private void method07660() {
      if (this.field18558.size() > 2048) {
         BotClient var1 = this.field18609;
         int var2 = var1 == null ? 0 : SectionPos.blockToSectionCoord(var1.method00070().method08006());
         int var3 = var1 == null ? 0 : SectionPos.blockToSectionCoord(var1.method00070().method08004());
         int var4 = this.field18558.size();
         long[] var5 = new long[var4];
         long[] var6 = new long[var4];
         int var7 = 0;

         for (var var9 : this.field18558.entrySet()) {
            BotWorldState.Nested226 var10 = (BotWorldState.Nested226)var9.getValue();
            long var11 = var10.field18641 - var2;
            long var13 = var10.field18642 - var3;
            long var15 = Math.min(var11 * var11 + var13 * var13, field18624);
            var5[var7] = (Long)var9.getKey();
            var6[var7] = var15 << 20 | var7;
            var7++;
         }

         Arrays.sort(var6);

         for (int var17 = 0; var17 < var4 - 1920; var17++) {
            this.field18558.remove(var5[(int)(var6[var4 - 1 - var17] & field18625)]);
         }
      }
   }

   public Map<Integer, Map<Holder<Attribute>, AttributeSnapshot>> method07661() {
      return this.field18573;
   }

   public void method07662(ClientboundSetEquipmentPacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            BotWorldState.Nested225 var3 = this.field18561.get(var1.getEntity());
            if (var3 != null) {
               for (var var5 : var1.getSlots()) {
                  var3.field18631.put((EquipmentSlot)var5.getFirst(), (ItemStack)var5.getSecond());
               }
            }
         }
      }
   }

   public void method07663(int var1, PositionMoveRotation var2, boolean var3) {
      if (this.field18601) {
         synchronized (this.field18557) {
            BotWorldState.Nested225 var5 = this.field18561.get(var1);
            if (var5 != null) {
               var5.field18632 = var2.position().x;
               var5.field18633 = var2.position().y;
               var5.field18634 = var2.position().z;
               var5.field18635 = var2.yRot();
               var5.field18636 = var2.xRot();
               var5.field18639 = var3;
               var5.field18638 = true;
               this.method07700(var1, var5);
            }
         }
      }
   }

   public ClientPacketListener method07664() {
      return this.field18607;
   }

   private void method07665(int var1) {
      BotClient var2 = this.field18609;
      if (var2 != null && var2.method00070().method07965() == var1) {
         var2.method00070().method08014();
      }
   }

   public Map<UUID, PlayerInfo> method07666() {
      return this.field18568;
   }

   public Set<Long> method07667() {
      return this.field18559;
   }

   public CommonPlayerSpawnInfo method07668() {
      return this.field18595;
   }

   public int method07669() {
      synchronized (this.field18557) {
         return this.field18558.size();
      }
   }

   public ClientboundSetTimePacket method07670() {
      return this.field18612;
   }

   public Map<Integer, ClientboundSetPassengersPacket> method07671() {
      return this.field18574;
   }

   public int method07672() {
      synchronized (this.field18557) {
         return this.field18570.getObjectives().size();
      }
   }

   public void method07673(ClientboundLightUpdatePacket var1) {
      synchronized (this.field18557) {
         BotClientLevel var3 = this.field18605;
         if (var3 != null) {
            var3.applyLight(var1.x(), var1.z(), var1.lightData());
         }

         if (this.field18601) {
            BotWorldState.Nested226 var4 = this.method07699(var1.x(), var1.z(), false);
            if (var4 != null) {
               var4.field18644 = var1;
               this.method07806(var4);
            }
         }
      }
   }

   public void method07674(BotClient var1) {
      this.field18609 = var1;
   }

   public ClientboundInitializeBorderPacket method07675() {
      return this.field18585;
   }

   private static ClientboundUpdateAttributesPacket method07676(int var0, Collection<AttributeSnapshot> var1) {
      ArrayList var2 = new ArrayList();

      for (AttributeSnapshot var4 : var1) {
         AttributeInstance var5 = new AttributeInstance(var4.attribute(), var0x -> {});
         var5.setBaseValue(var4.base());

         for (AttributeModifier var7 : var4.modifiers()) {
            var5.addTransientModifier(var7);
         }

         var2.add(var5);
      }

      return new ClientboundUpdateAttributesPacket(var0, var2);
   }

   public BotClient method07677() {
      return this.field18609;
   }

   private ClientboundLoginPacket method07678() {
      ClientboundLoginPacket var1 = this.field18594;
      CommonPlayerSpawnInfo var2 = this.field18595;
      return var1 != null && var2 != null && !var2.equals(var1.commonPlayerSpawnInfo())
         ? new ClientboundLoginPacket(
            var1.playerId(),
            var1.hardcore(),
            var1.levels(),
            var1.maxPlayers(),
            var1.chunkRadius(),
            var1.simulationDistance(),
            var1.reducedDebugInfo(),
            var1.showDeathScreen(),
            var1.doLimitedCrafting(),
            var2,
            var1.onlineMode(),
            var1.enforcesSecureChat()
         )
         : var1;
   }

   public void method07679(ClientboundSetScorePacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            Objective var3 = this.field18570.getObjective(var1.objectiveName());
            if (var3 != null) {
               ScoreAccess var4 = this.field18570.getOrCreatePlayerScore(ScoreHolder.forNameOnly(var1.owner()), var3, true);
               var4.set(var1.score());
               var4.display(var1.display().orElse(null));
               var4.numberFormatOverride(var1.numberFormat().orElse(null));
            }
         }
      }
   }

   public ClientboundSetBorderCenterPacket method07680() {
      return this.field18586;
   }

   public void method07681() {
      if (this.field18619 > 0) {
         this.field18619--;
      }

      this.method07747();
      BotClientLevel var1 = this.field18605;
      if (var1 != null) {
         this.method07728(32);
         var1.tickBookkeeping();
      }
   }

   public void method07682(ClientboundSetBorderWarningDistancePacket var1) {
      this.field18590 = var1;
      BotClientLevel var2 = this.field18605;
      if (var2 != null) {
         var2.applyBorderWarningDistance(var1);
      }
   }

   public boolean method07683() {
      return this.field18594 != null && this.field18596 != null;
   }

   public Map<ResourceKey<? extends Registry<?>>, NetworkPayload> method07684() {
      return this.field18597;
   }

   public Map<UUID, MutableBossEvent> method07685() {
      return this.field18571;
   }

   public int method07686() {
      int var1 = 0;
      synchronized (this.field18557) {
         for (DisplaySlot var6 : DisplaySlot.values()) {
            if (this.field18570.getDisplayObjective(var6) != null) {
               var1++;
            }
         }

         return var1;
      }
   }

   public void method07687(ClientboundRecipeBookSettingsPacket var1) {
      this.field18582 = var1;
   }

   public BotLocalPlayer method07688() {
      return this.field18606;
   }

   public int method07689() {
      return this.field18619;
   }

   public void method07690(ClientboundSetDisplayObjectivePacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            this.field18570.setDisplayObjective(var1.getSlot(), this.field18570.getObjective(var1.getObjectiveName()));
         }
      }
   }

   public ClientboundTabListPacket method07691() {
      return this.field18579;
   }

   public void method07692(ClientboundAddEntityPacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            BotWorldState.Nested225 var3 = this.field18561.computeIfAbsent(var1.getId(), var0 -> new BotWorldState.Nested225());
            var3.method07819(var1);
            this.method07763();
            BotClientLevel var4 = this.field18605;
            if (var4 != null) {
               try {
                  var4.entityStore().method07245(var1, this.method07714(var1.getUUID()));
               } catch (Throwable var7) {
                  var4.entityStore().method07263(var1.getId());
               }
            }
         }
      }
   }

   public GameProfile method07693() {
      return this.field18604;
   }

   public void method07694(ClientboundCooldownPacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            if (var1.duration() == 0) {
               this.field18577.remove(var1.cooldownGroup());
            } else {
               this.field18577.put(var1.cooldownGroup(), var1);
            }
         }
      }
   }

   private List<ClientboundUpdateMobEffectPacket> method07695(int var1) {
      synchronized (this.field18557) {
         var var3 = this.field18572.get(var1);
         return var3 != null && !var3.isEmpty() ? new ArrayList<>(var3.values()) : List.of();
      }
   }

   public void method07696(String var1) {
      this.field18600 = var1;
   }

   public Set<PlayerInfo> method07698() {
      synchronized (this.field18557) {
         return new LinkedHashSet<>(this.field18569);
      }
   }

   private BotWorldState.Nested226 method07699(int var1, int var2, boolean var3) {
      long var4 = method07705(var1, var2);
      BotWorldState.Nested226 var6 = this.field18558.get(var4);
      if (var6 == null && var3) {
         var6 = new BotWorldState.Nested226();
         var6.field18641 = var1;
         var6.field18642 = var2;
         this.field18558.put(var4, var6);
      }

      return var6;
   }

   private void method07700(int var1, BotWorldState.Nested225 var2) {
      BotClientLevel var3 = this.field18605;
      if (var3 != null) {
         var3.entityStore().method07260(var1, var2.field18632, var2.field18633, var2.field18634, var2.field18635, var2.field18636, var2.field18639);
      }
   }

   public boolean method07701() {
      return this.field18602;
   }

   public void method07702(ClientboundUpdateAdvancementsPacket var1) {
      this.field18583 = var1;
   }

   public void method07703(ClientboundRemoveMobEffectPacket var1) {
      synchronized (this.field18557) {
         var var3 = this.field18572.get(var1.entityId());
         if (var3 != null) {
            var3.remove(var1.effect());
         }
      }

      this.field18603 = this.field18603 | this.method07774(var1.entityId());
      this.method07665(var1.entityId());
   }

   public void method07704(ClientboundResetScorePacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            ScoreHolder var3 = ScoreHolder.forNameOnly(var1.owner());
            if (var1.objectiveName() == null) {
               this.field18570.resetAllPlayerScores(var3);
            } else {
               Objective var4 = this.field18570.getObjective(var1.objectiveName());
               if (var4 != null) {
                  this.field18570.resetSinglePlayerScore(var3, var4);
               }
            }
         }
      }
   }

   private static long method07705(int var0, int var1) {
      return (long)var0 << 32 | var1 & field18626;
   }

   public void method07706() {
      this.method07727();
      synchronized (this.field18557) {
         this.field18567.clear();
         this.field18563.clear();
         this.field18564.clear();
         this.field18565.clear();
         this.field18568.clear();
         this.field18569.clear();
         this.method07807();
         this.field18571.clear();
         this.field18577.clear();
      }

      this.method07658();
      this.field18611 = null;
      this.field18612 = null;
      this.field18613 = null;
      this.field18614 = null;
      this.field18616 = null;
      this.field18617 = null;
   }

   private static int method07707(ClientboundPlayerInfoUpdatePacket var0, UUID var1) {
      if (var0 == null) {
         return 0;
      }

      for (net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Entry var3 : var0.entries()) {
         if (var1.equals(var3.profileId())) {
            return var3.latency();
         }
      }

      return 0;
   }

   public ClientboundSetDefaultSpawnPositionPacket method07708() {
      return this.field18614;
   }

   public void method07709(ClientboundSectionBlocksUpdatePacket var1) {
      if (this.field18601) {
         SectionPos var2 = ((ClientboundSectionBlocksUpdatePacketMixin)(Object)var1).getSectionPos();
         synchronized (this.field18557) {
            BotWorldState.Nested226 var4 = this.method07699(var2.getX(), var2.getZ(), false);
            if (var4 != null) {
               var4.method07821(var1);
               this.method07806(var4);
            }

            BotClientLevel var5 = this.field18605;
            if (var5 != null) {
               var1.runUpdates(var5::applyBlock);
            }
         }
      }
   }

   public void method07710(ClientboundSetBorderLerpSizePacket var1) {
      this.field18588 = var1;
      this.field18587 = null;
      BotClientLevel var2 = this.field18605;
      if (var2 != null) {
         var2.applyBorderLerp(var1);
      }
   }

   public void method07711(CommonPlayerSpawnInfo var1) {
      this.field18595 = var1;
   }

   public void method07712() {
      synchronized (this.field18557) {
         this.field18578.clear();
      }
   }

   public ClientboundCommandsPacket method07713() {
      return this.field18611;
   }

   private GameProfile method07714(UUID var1) {
      ClientboundPlayerInfoUpdatePacket var2 = this.field18563.get(var1);
      if (var2 == null) {
         return null;
      }

      for (net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Entry var4 : var2.entries()) {
         if (var4.profileId().equals(var1)) {
            return var4.profile();
         }
      }

      return null;
   }

   public void method07715(ClientboundBlockEntityDataPacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            if (this.field18576.size() < 1024 || this.field18576.containsKey(var1.getPos())) {
               this.field18576.put(var1.getPos(), var1);
            }
         }
      }
   }

   public ClientboundLoginPacket method07716() {
      return this.field18594;
   }

   public ClientboundRecipeBookSettingsPacket method07717() {
      return this.field18582;
   }

   public Map<Integer, ClientboundSetEntityLinkPacket> method07718() {
      return this.field18575;
   }

   public void method07720(int var1, double var2, double var4, double var6, boolean var8, float var9, float var10, boolean var11, boolean var12) {
      if (this.field18601) {
         synchronized (this.field18557) {
            BotWorldState.Nested225 var14 = this.field18561.get(var1);
            if (var14 != null) {
               if (var8) {
                  var14.field18632 += var2;
                  var14.field18633 += var4;
                  var14.field18634 += var6;
               }

               if (var11) {
                  var14.field18635 = var9;
                  var14.field18636 = var10;
               }

               var14.field18639 = var12;
               var14.field18638 = true;
               this.method07700(var1, var14);
            }
         }
      }
   }

   public void method07721(ClientboundSetBorderSizePacket var1) {
      this.field18587 = var1;
      this.field18588 = null;
      BotClientLevel var2 = this.field18605;
      if (var2 != null) {
         var2.applyBorderSize(var1);
      }
   }

   private List<AttributeSnapshot> method07722(int var1) {
      synchronized (this.field18557) {
         var var3 = this.field18573.get(var1);
         return var3 == null ? null : new ArrayList<>(var3.values());
      }
   }

   public void method07723(ClientboundSetChunkCacheCenterPacket var1) {
      this.field18615 = var1;
      BotClientLevel var2 = this.field18605;
      if (var2 != null) {
         var2.getChunkSource().updateViewCenter(var1.getX(), var1.getZ());
      }
   }

   public Map<MapId, BotWorldState.Nested227> method07724() {
      return this.field18578;
   }

   public Map<BlockPos, ClientboundBlockEntityDataPacket> method07725() {
      return this.field18576;
   }

   public void method07726(Frozen var1) {
      this.field18596 = var1;
   }

   public void method07727() {
      this.method07735();
      this.method07812();
      synchronized (this.field18557) {
         this.field18560 = false;
         this.field18559.clear();
         this.field18558.clear();
         this.field18561.clear();
         this.field18566.clear();
         this.field18576.clear();
         this.field18574.clear();
         this.field18575.clear();
         this.field18573.clear();
         this.field18572.clear();
      }

      this.field18615 = null;
      this.field18593 = null;
   }

   public void method07728(int var1) {
      BotClientLevel var2 = this.field18605;
      if (var2 != null) {
         synchronized (this.field18557) {
            for (int var4 = 0; var4 < var1; var4++) {
               ClientboundLevelChunkWithLightPacket var5 = this.field18562.pollFirst();
               if (var5 == null) {
                  return;
               }

               try {
                  var2.loadChunk(var5);
               } catch (Throwable var8) {
                  String.valueOf("чанк " + var5.x() + " " + var5.z() + " не встал: " + var8);
                  this.field18558.remove(method07705(var5.x(), var5.z()));
               }
            }
         }
      }
   }

   public boolean method07729() {
      return this.field18601;
   }

   public ClientboundSetBorderSizePacket method07730() {
      return this.field18587;
   }

   public void method07731(ClientboundGameEventPacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            if (this.field18566.size() >= 16) {
               this.field18566.removeFirst();
            }

            this.field18566.addLast(var1);
         }
      }
   }

   public Map<String, List<ClientboundSetPlayerTeamPacket>> method07732() {
      return this.field18567;
   }

   public void method07733(boolean var1) {
      this.field18601 = var1;
   }

   public void method07734(Map<UUID, PlayerInfo> var1, Set<PlayerInfo> var2) {
      synchronized (this.field18557) {
         this.field18568.clear();
         this.field18568.putAll(var1);
         this.field18569.clear();
         this.field18569.addAll(var2);
      }
   }

   private void method07735() {
      this.field18608 = false;
      this.field18618 = 0;
      this.field18619 = 0;
   }

   public ClientboundSelectAdvancementsTabPacket method07736() {
      return this.field18584;
   }

   public ClientboundChangeDifficultyPacket method07737() {
      return this.field18613;
   }

   public void method07738(ClientboundSetPlayerTeamPacket var1) {
      if (this.field18601) {
         net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket.Action var2 = var1.getTeamAction();
         synchronized (this.field18557) {
            if (var2 == net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket.Action.REMOVE) {
               this.field18567.remove(var1.getName());
            } else if (var2 == net.minecraft.network.protocol.game.ClientboundSetPlayerTeamPacket.Action.ADD) {
               ArrayList var7 = new ArrayList();
               var7.add(var1);
               this.field18567.put(var1.getName(), var7);
            } else {
               var var4 = this.field18567.get(var1.getName());
               if (var4 != null && var4.size() < 16) {
                  var4.add(var1);
               }
            }
         }
      }
   }

   public ClientboundServerDataPacket method07739() {
      return this.field18591;
   }

   public void method07740(ClientboundInitializeBorderPacket var1) {
      this.field18585 = var1;
      this.field18586 = null;
      this.field18587 = null;
      this.field18588 = null;
      BotClientLevel var2 = this.field18605;
      if (var2 != null) {
         var2.applyBorder(var1);
      }

      this.field18589 = null;
      this.field18590 = null;
   }

   public void method07741(ClientboundRecipeBookAddPacket var1) {
      this.field18581 = var1;
   }

   public void method07742(PacketProcessor var1, ClientGamePacketListener var2) {
      synchronized (this.field18557) {
         this.field18560 = false;
         if (!this.field18559.isEmpty()) {
            for (long var5 : this.field18559) {
               BotWorldState.Nested226 var7 = this.field18558.get(var5);
               if (var7 != null && var7.field18643 != null) {
                  method07800(var1, var2, var7.field18643);
                  method07800(var1, var2, var7.field18644);

                  for (Packet var9 : var7.field18645) {
                     method07800(var1, var2, var9);
                  }
               }
            }

            this.field18559.clear();
         }
      }
   }

   public ClientboundSetChunkCacheRadiusPacket method07743() {
      return this.field18616;
   }

   public int method07745() {
      ClientboundLoginPacket var1 = this.field18594;
      return var1 == null ? -64 : var1.commonPlayerSpawnInfo().dimensionType().value().minY();
   }

   public void method07746(ClientboundLoginPacket var1) {
      this.field18594 = var1;
   }

   public void method07747() {
      if (this.field18605 == null) {
         this.method07638();
      }
   }

   public void method07748(ClientboundBossEventPacket var1) {
      if (this.field18601) {
         var1.dispatch(this.field18620);
      }
   }

   public List<AttributeSnapshot> method07749(int var1) {
      if (!this.field18602) {
         return null;
      }

      this.field18602 = false;
      return this.method07722(var1);
   }

   public void method07750(ClientboundSetCameraPacket var1) {
      this.field18593 = var1;
   }

   public void method07751(String var1) {
      this.field18599 = var1;
   }

   public String method07752() {
      return this.field18600;
   }

   public Map<Identifier, ClientboundCooldownPacket> method07753() {
      return this.field18577;
   }

   public void method07754(String var1, Throwable var2) {
      String.valueOf(var1 + (var2 == null ? "" : ": " + var2));
      this.field18618++;
      this.field18608 = true;
      this.field18619 = Math.min(20 * this.field18618, 200);
      this.method07812();
   }

   private static boolean method07755(BotWorldState.Nested226 var0, int var1, int var2, int var3) {
      return Math.abs(var0.field18641 - var1) <= var3 && Math.abs(var0.field18642 - var2) <= var3;
   }

   public Handler method07756() {
      return this.field18620;
   }

   public void method07757(ClientboundTickingStatePacket var1) {
      this.field18592 = var1;
   }

   public Frozen method07758() {
      return this.field18596;
   }

   public void method07759(FeatureFlagSet var1) {
      this.field18598 = var1;
   }

   public Map<Integer, Map<Holder<MobEffect>, ClientboundUpdateMobEffectPacket>> method07760() {
      return this.field18572;
   }

   public void method07761(BossEvent var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            MutableBossEvent var3 = new MutableBossEvent(var1.getId(), var1.getName(), var1.getColor(), var1.getOverlay());
            var3.setProgress(var1.getProgress());
            var3.setDarkenScreen(var1.shouldDarkenScreen());
            var3.setPlayBossMusic(var1.shouldPlayBossMusic());
            var3.setCreateWorldFog(var1.shouldCreateWorldFog());
            this.field18571.put(var1.getId(), var3);
         }
      }
   }

   public ArrayDeque<ClientboundLevelChunkWithLightPacket> method07762() {
      return this.field18562;
   }

   private void method07763() {
      var var1 = this.field18561.entrySet().iterator();

      while (this.field18561.size() > 4096 && var1.hasNext()) {
         var1.next();
         var1.remove();
      }
   }

   public int method07764() {
      BotClient var1 = this.field18609;
      UUID var2 = var1 == null ? null : var1.method00070().method08001();
      if (var2 == null) {
         return 0;
      }

      synchronized (this.field18557) {
         var var4 = this.field18564.get(var2);
         int var5 = var4 == null ? 0 : method07707((ClientboundPlayerInfoUpdatePacket)var4.get(Action.UPDATE_LATENCY), var2);
         return var5 > 0 ? var5 : method07707(this.field18563.get(var2), var2);
      }
   }

   public List<ClientboundUpdateMobEffectPacket> method07765(int var1) {
      if (!this.field18603) {
         return null;
      }

      this.field18603 = false;
      return this.method07695(var1);
   }

   public boolean method07767() {
      return this.field18603;
   }

   public void method07768(ClientboundUpdateMobEffectPacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            this.field18572.computeIfAbsent(var1.getEntityId(), var0 -> new LinkedHashMap<>()).put(var1.getEffect(), var1);
         }

         this.field18603 = this.field18603 | this.method07774(var1.getEntityId());
         this.method07665(var1.getEntityId());
      }
   }

   private ClientboundSetChunkCacheCenterPacket method07769() {
      BotClient var1 = this.field18609;
      if (var1 == null) {
         return this.field18615;
      }

      int var2 = SectionPos.blockToSectionCoord(var1.method00070().method08006());
      int var3 = SectionPos.blockToSectionCoord(var1.method00070().method08004());
      return new ClientboundSetChunkCacheCenterPacket(var2, var3);
   }

   public void method07770(ClientboundUpdateAttributesPacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            var var3 = this.field18573.computeIfAbsent(var1.getEntityId(), var0 -> new LinkedHashMap<>());

            for (AttributeSnapshot var5 : var1.getValues()) {
               var3.put(var5.attribute(), var5);
            }
         }

         this.field18602 = this.field18602 | this.method07774(var1.getEntityId());
         this.method07665(var1.getEntityId());
      }
   }

   public void method07771(ClientboundSetObjectivePacket var1) {
      if (this.field18601) {
         String var2 = var1.getObjectiveName();
         synchronized (this.field18557) {
            Objective var4 = this.field18570.getObjective(var2);
            if (var1.getMethod() == 0) {
               if (var4 == null) {
                  this.field18570
                     .addObjective(var2, ObjectiveCriteria.DUMMY, var1.getDisplayName(), var1.getRenderType(), false, var1.getNumberFormat().orElse(null));
               }
            } else {
               if (var4 == null) {
                  return;
               }

               if (var1.getMethod() == 1) {
                  this.field18570.removeObjective(var4);
               } else {
                  var4.setRenderType(var1.getRenderType());
                  var4.setDisplayName(var1.getDisplayName());
                  var4.setNumberFormat(var1.getNumberFormat().orElse(null));
               }
            }
         }
      }
   }

   public void method07773(ClientboundSetChunkCacheRadiusPacket var1) {
      this.field18616 = var1;
      BotClientLevel var2 = this.field18605;
      if (var2 != null) {
         var2.getChunkSource().updateViewRadius(var1.getRadius());
      }
   }

   private boolean method07774(int var1) {
      BotClient var2 = this.field18609;
      return var2 != null && var2.method00070().method07965() == var1;
   }

   public void method07775(ClientboundSetBorderCenterPacket var1) {
      this.field18586 = var1;
      BotClientLevel var2 = this.field18605;
      if (var2 != null) {
         var2.applyBorderCenter(var1);
      }
   }

   public void method07776(ClientboundPlayerInfoUpdatePacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            for (net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Entry var4 : var1.newEntries()) {
               if (this.field18563.size() < 512) {
                  this.field18563.put(var4.profileId(), var1);
                  this.field18565.remove(var4.profileId());
               }
            }

            for (net.minecraft.network.protocol.game.ClientboundPlayerInfoUpdatePacket.Entry var11 : var1.entries()) {
               if (this.field18563.containsKey(var11.profileId())) {
                  var var5 = this.field18564.computeIfAbsent(var11.profileId(), var0 -> new EnumMap<>(Action.class));

                  for (Action var7 : var1.actions()) {
                     var5.put(var7, var1);
                  }

                  this.method07654(var11.profileId(), var11.profile());
               }
            }
         }
      }
   }

   public ClientboundUpdateAdvancementsPacket method07777() {
      return this.field18583;
   }

   public Map<Integer, BotWorldState.Nested225> method07778() {
      return this.field18561;
   }

   public void method07779(ClientboundSetDefaultSpawnPositionPacket var1) {
      this.field18614 = var1;
   }

   public int method07780() {
      synchronized (this.field18557) {
         return this.field18561.size();
      }
   }

   public int method07781() {
      synchronized (this.field18557) {
         return this.field18563.size();
      }
   }

   public ClientboundSetBorderWarningDistancePacket method07782() {
      return this.field18590;
   }

   public ClientboundSetBorderWarningDelayPacket method07783() {
      return this.field18589;
   }

   public void method07784(ClientboundCommandsPacket var1) {
      this.field18611 = var1;
   }

   public void method07785(GameProfile var1) {
      this.field18604 = var1;
   }

   public Map<UUID, ClientboundPlayerInfoUpdatePacket> method07786() {
      return this.field18563;
   }

   public void method07787(ClientboundSetBorderWarningDelayPacket var1) {
      this.field18589 = var1;
      BotClientLevel var2 = this.field18605;
      if (var2 != null) {
         var2.applyBorderWarningDelay(var1);
      }
   }

   public void method07788(ClientboundSetSimulationDistancePacket var1) {
      this.field18617 = var1;
   }

   public ClientboundSetChunkCacheCenterPacket method07789() {
      return this.field18615;
   }

   public <T> T method07790(Function<Scoreboard, T> var1) {
      synchronized (this.field18557) {
         return (T)(Object)var1.apply(this.field18570);
      }
   }

   public void method07791(ClientboundRemoveEntitiesPacket var1) {
      synchronized (this.field18557) {
         BotClientLevel var3 = this.field18605;

         for (int var4 = 0; var4 < var1.entityIds().size(); var4++) {
            int var5 = var1.entityIds().getInt(var4);
            this.field18561.remove(var5);
            if (var3 != null) {
               var3.entityStore().method07263(var5);
            }
         }
      }
   }

   public boolean method07792() {
      return this.field18605 != null;
   }

   public Map<UUID, PlayerInfo> method07793() {
      synchronized (this.field18557) {
         return new LinkedHashMap<>(this.field18568);
      }
   }

   public ArrayDeque<ClientboundGameEventPacket> method07794() {
      return this.field18566;
   }

   public void method07795(ClientboundSetTimePacket var1) {
      this.field18612 = var1;
   }

   public Object method07796() {
      return this.field18557;
   }

   public void method07797(Map<ResourceKey<? extends Registry<?>>, NetworkPayload> var1) {
      this.field18597 = RegistryDataMerger.method08046(this.field18597, var1);
   }

   public void method07798(ClientboundPlayerInfoRemovePacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            for (UUID var4 : var1.profileIds()) {
               if (this.field18563.remove(var4) != null && this.field18565.size() < 1024) {
                  this.field18565.add(var4);
               }

               this.field18564.remove(var4);
            }
         }
      }
   }

   public int method07799() {
      return this.field18618;
   }

   static void method07800(PacketProcessor var0, ClientGamePacketListener var1, Packet<ClientGamePacketListener> var2) {
      if (var2 != null) {
         var0.scheduleIfPossible(var1, var2);
      }
   }

   public Set<PlayerInfo> method07801() {
      return this.field18569;
   }

   public void method07802(ClientboundUpdateRecipesPacket var1) {
      this.field18580 = var1;
   }

   public void method07803(ClientboundChangeDifficultyPacket var1) {
      this.field18613 = var1;
   }

   public void method07804(ClientboundForgetLevelChunkPacket var1) {
      int var2 = var1.pos().x();
      int var3 = var1.pos().z();
      synchronized (this.field18557) {
         long var5 = method07705(var2, var3);
         this.field18558.remove(var5);
         this.field18559.remove(var5);
         this.field18562.removeIf(var2x -> var2x.x() == var2 && var2x.z() == var3);
         BotClientLevel var7 = this.field18605;
         if (var7 != null) {
            var7.dropChunk(var2, var3);
         }
      }
   }

   public void method07805(ClientboundSetEntityDataPacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            BotWorldState.Nested225 var3 = this.field18561.get(var1.id());
            if (var3 != null) {
               for (DataValue var5 : var1.packedItems()) {
                  var3.field18630.put(var5.id(), var5);
               }
            }

            BotClientLevel var8 = this.field18605;
            if (var8 != null) {
               var8.entityStore().method07253(var1);
            }
         }
      }
   }

   private void method07806(BotWorldState.Nested226 var1) {
      if (this.field18560) {
         this.field18559.add(method07705(var1.field18641, var1.field18642));
      }
   }

   private void method07807() {
      for (DisplaySlot var4 : DisplaySlot.values()) {
         this.field18570.setDisplayObjective(var4, null);
      }

      for (Objective var6 : new ArrayList<>(this.field18570.getObjectives())) {
         this.field18570.removeObjective(var6);
      }
   }

   public boolean method07808() {
      return this.field18608;
   }

   public void method07809(ClientboundBlockUpdatePacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            BotWorldState.Nested226 var3 = this.method07699(var1.getPos().getX() >> 4, var1.getPos().getZ() >> 4, false);
            if (var3 != null) {
               var3.method07821(var1);
               this.method07806(var3);
            }

            BotClientLevel var4 = this.field18605;
            if (var4 != null) {
               var4.applyBlock(var1.getPos(), var1.getBlockState());
            }
         }
      }
   }

   public Scoreboard method07810() {
      return this.field18570;
   }

   public void method07812() {
      this.field18605 = null;
      this.field18606 = null;
      this.field18607 = null;
   }

   public ClientboundUpdateRecipesPacket method07813() {
      return this.field18580;
   }

   public void method07814(ClientboundSetPassengersPacket var1) {
      if (this.field18601) {
         synchronized (this.field18557) {
            if (var1.getPassengers().length == 0) {
               this.field18574.remove(var1.getVehicle());
            } else {
               this.field18574.put(var1.getVehicle(), var1);
            }

            BotClientLevel var3 = this.field18605;
            if (var3 != null) {
               var3.entityStore().method07247(var1);
            }
         }
      }
   }

   public String method07815() {
      return this.field18599;
   }

   public FeatureFlagSet method07816() {
      return this.field18598;
   }

   // $VF: Compiled from s
   private static final class Nested225 {
      private ClientboundAddEntityPacket field18629;
      private final Map<Integer, DataValue<?>> field18630 = new LinkedHashMap<>();
      private final EnumMap<EquipmentSlot, ItemStack> field18631 = new EnumMap<>(EquipmentSlot.class);
      private double field18632;
      private double field18633;
      private double field18634;
      private float field18635;
      private float field18636;
      private float field18637;
      private boolean field18638;
      private boolean field18639;

      private ClientboundAddEntityPacket method07817() {
         return !this.field18638
            ? this.field18629
            : new ClientboundAddEntityPacket(
               this.field18629.getId(),
               this.field18629.getUUID(),
               this.field18632,
               this.field18633,
               this.field18634,
               this.field18636,
               this.field18635,
               this.field18629.getType(),
               this.field18629.getData(),
               Vec3.ZERO,
               this.field18637
            );
      }

      private ClientboundSetEntityDataPacket method07818() {
         return this.field18629 != null && !this.field18630.isEmpty()
            ? new ClientboundSetEntityDataPacket(this.field18629.getId(), new ArrayList<>(this.field18630.values()))
            : null;
      }

      private void method07819(ClientboundAddEntityPacket var1) {
         this.field18629 = var1;
         this.field18630.clear();
         this.field18631.clear();
         this.field18632 = var1.getX();
         this.field18633 = var1.getY();
         this.field18634 = var1.getZ();
         this.field18635 = var1.getYRot();
         this.field18636 = var1.getXRot();
         this.field18637 = var1.getYHeadRot();
         this.field18638 = false;
         this.field18639 = false;
      }

      private ClientboundSetEquipmentPacket method07820() {
         if (this.field18629 != null && !this.field18631.isEmpty()) {
            ArrayList var1 = new ArrayList();

            for (var var3 : this.field18631.entrySet()) {
               var1.add(Pair.of((EquipmentSlot)var3.getKey(), (ItemStack)var3.getValue()));
            }

            return new ClientboundSetEquipmentPacket(this.field18629.getId(), var1);
         } else {
            return null;
         }
      }
   }

   // $VF: Compiled from s
   private static final class Nested226 {
      private int field18641;
      private int field18642;
      private ClientboundLevelChunkWithLightPacket field18643;
      private ClientboundLightUpdatePacket field18644;
      private final List<Packet<ClientGamePacketListener>> field18645 = new ArrayList<>();

      private void method07821(Packet<ClientGamePacketListener> var1) {
         if (this.field18645.size() >= 256) {
            this.field18645.removeFirst();
         }

         this.field18645.add(var1);
      }
   }

   // $VF: Compiled from s
   private static final class Nested227 {
      private static final int field18646 = 128;
      private final byte[] field18647 = new byte[16384];
      private byte field18648;
      private boolean field18649;
      private List<MapDecoration> field18650 = List.of();

      private ClientboundMapItemDataPacket method07822(MapId var1) {
         return new ClientboundMapItemDataPacket(
            var1,
            this.field18648,
            this.field18649,
            this.field18650.isEmpty() ? null : this.field18650,
            new MapPatch(0, 0, 128, 128, (byte[])this.field18647.clone())
         );
      }

      private void method07824(ClientboundMapItemDataPacket var1) {
         this.field18648 = var1.scale();
         this.field18649 = var1.locked();
         var1.decorations().ifPresent(var1x -> this.field18650 = List.copyOf((Collection<? extends MapDecoration>)var1x));
         var1.colorPatch().ifPresent(var1x -> {
            for (int var2 = 0; var2 < var1x.width(); var2++) {
               for (int var3 = 0; var3 < var1x.height(); var3++) {
                  this.field18647[var1x.startX() + var2 + (var1x.startY() + var3) * 128] = var1x.mapColors()[var2 + var3 * var1x.width()];
               }
            }
         });
      }
   }
}
