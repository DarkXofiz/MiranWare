// Original binary: hex/api/baritone/api/Settings
package hex.api.baritone.api;

import hex.api.baritone.api.utils.Helper;
import hex.api.baritone.api.utils.NotificationHelper;
import hex.api.baritone.api.utils.SettingsUtil;
import hex.api.baritone.api.utils.TypeUtils;
import hex.api.baritone.api.utils.gui.BaritoneToast;
import java.awt.Color;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import java.util.function.BiConsumer;
import java.util.function.Consumer;
import net.minecraft.client.Minecraft;
import net.minecraft.client.multiplayer.chat.GuiMessageTag;
import net.minecraft.core.Vec3i;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;

// $VF: Compiled from s
public final class Settings {
   public final Settings.Setting<Boolean> allowBreak = new Settings.Setting<>(true);
   public final Settings.Setting<List<Block>> allowBreakAnyway = new Settings.Setting<>(new ArrayList<>());
   public final Settings.Setting<Boolean> allowSprint = new Settings.Setting<>(true);
   public final Settings.Setting<Boolean> allowPlace = new Settings.Setting<>(true);
   public final Settings.Setting<Boolean> allowPlaceInFluidsSource = new Settings.Setting<>(true);
   public final Settings.Setting<Boolean> allowPlaceInFluidsFlow = new Settings.Setting<>(true);
   public final Settings.Setting<Boolean> allowInventory = new Settings.Setting<>(false);
   public final Settings.Setting<Integer> ticksBetweenInventoryMoves = new Settings.Setting<>(1);
   public final Settings.Setting<Boolean> inventoryMoveOnlyIfStationary = new Settings.Setting<>(false);
   public final Settings.Setting<Boolean> assumeExternalAutoTool = new Settings.Setting<>(false);
   public final Settings.Setting<Boolean> autoTool = new Settings.Setting<>(true);
   public final Settings.Setting<Double> blockPlacementPenalty;
   public final Settings.Setting<Double> blockBreakAdditionalPenalty;
   public final Settings.Setting<Double> jumpPenalty;
   public final Settings.Setting<Double> walkOnWaterOnePenalty;
   public final Settings.Setting<Boolean> strictLiquidCheck;
   public final Settings.Setting<Boolean> allowWaterBucketFall;
   public final Settings.Setting<Boolean> assumeWalkOnWater;
   public final Settings.Setting<Boolean> assumeWalkOnLava;
   public final Settings.Setting<Boolean> assumeStep;
   public final Settings.Setting<Boolean> assumeSafeWalk;
   public final Settings.Setting<Boolean> allowJumpAtBuildLimit;
   @Settings.JavaOnly
   @Deprecated
   public final Settings.Setting<Boolean> allowJumpAt256;
   public final Settings.Setting<Boolean> allowParkourAscend;
   public final Settings.Setting<Boolean> allowDiagonalDescend;
   public final Settings.Setting<Boolean> allowDiagonalAscend;
   public final Settings.Setting<Boolean> allowDownward;
   public final Settings.Setting<List<Item>> acceptableThrowawayItems;
   public final Settings.Setting<List<Block>> blocksToAvoid;
   public final Settings.Setting<List<Block>> blocksToDisallowBreaking;
   public final Settings.Setting<List<Block>> blocksToAvoidBreaking;
   public final Settings.Setting<Double> avoidBreakingMultiplier;
   public final Settings.Setting<List<Block>> buildIgnoreBlocks;
   public final Settings.Setting<List<Block>> buildSkipBlocks;
   public final Settings.Setting<Map<Block, List<Block>>> buildValidSubstitutes;
   public final Settings.Setting<Map<Block, List<Block>>> buildSubstitutes;
   public final Settings.Setting<List<Block>> okIfAir;
   public final Settings.Setting<Boolean> buildIgnoreExisting;
   public final Settings.Setting<Boolean> buildIgnoreDirection;
   public final Settings.Setting<List<String>> buildIgnoreProperties;
   public final Settings.Setting<Boolean> avoidUpdatingFallingBlocks;
   public final Settings.Setting<Boolean> allowVines;
   public final Settings.Setting<Boolean> allowWalkOnBottomSlab;
   public final Settings.Setting<Boolean> allowParkour;
   public final Settings.Setting<Boolean> allowParkourPlace;
   public final Settings.Setting<Boolean> considerPotionEffects;
   public final Settings.Setting<Boolean> sprintAscends;
   public final Settings.Setting<Boolean> overshootTraverse;
   public final Settings.Setting<Boolean> pauseMiningForFallingBlocks;
   public final Settings.Setting<Integer> rightClickSpeed;
   public final Settings.Setting<Double> randomLooking113;
   public final Settings.Setting<Float> blockReachDistance;
   public final Settings.Setting<Integer> blockBreakSpeed;
   public final Settings.Setting<Double> randomLooking;
   public final Settings.Setting<Double> costHeuristic;
   public final Settings.Setting<Integer> pathingMaxChunkBorderFetch;
   public final Settings.Setting<Double> backtrackCostFavoringCoefficient;
   public final Settings.Setting<Boolean> avoidance;
   public final Settings.Setting<Double> mobSpawnerAvoidanceCoefficient;
   public final Settings.Setting<Integer> mobSpawnerAvoidanceRadius;
   public final Settings.Setting<Double> mobAvoidanceCoefficient;
   public final Settings.Setting<Integer> mobAvoidanceRadius;
   public final Settings.Setting<Boolean> rightClickContainerOnArrival;
   public final Settings.Setting<Boolean> enterPortal;
   public final Settings.Setting<Boolean> minimumImprovementRepropagation;
   public final Settings.Setting<Boolean> cutoffAtLoadBoundary;
   public final Settings.Setting<Double> maxCostIncrease;
   public final Settings.Setting<Integer> costVerificationLookahead;
   public final Settings.Setting<Double> pathCutoffFactor;
   public final Settings.Setting<Integer> pathCutoffMinimumLength;
   public final Settings.Setting<Integer> planningTickLookahead;
   public final Settings.Setting<Integer> pathingMapDefaultSize;
   public final Settings.Setting<Float> pathingMapLoadFactor;
   public final Settings.Setting<Integer> maxFallHeightNoWater;
   public final Settings.Setting<Integer> maxFallHeightBucket;
   public final Settings.Setting<Boolean> allowOvershootDiagonalDescend;
   public final Settings.Setting<Boolean> simplifyUnloadedYCoord;
   public final Settings.Setting<Boolean> repackOnAnyBlockChange;
   public final Settings.Setting<Integer> movementTimeoutTicks;
   public final Settings.Setting<Long> primaryTimeoutMS;
   public final Settings.Setting<Long> failureTimeoutMS;
   public final Settings.Setting<Long> planAheadPrimaryTimeoutMS;
   public final Settings.Setting<Long> planAheadFailureTimeoutMS;
   public final Settings.Setting<Boolean> slowPath;
   public final Settings.Setting<Long> slowPathTimeDelayMS;
   public final Settings.Setting<Long> slowPathTimeoutMS;
   public final Settings.Setting<Boolean> doBedWaypoints;
   public final Settings.Setting<Boolean> doDeathWaypoints;
   public final Settings.Setting<Boolean> chunkCaching;
   public final Settings.Setting<Boolean> pruneRegionsFromRAM;
   public final Settings.Setting<Integer> chunkPackerQueueMaxSize;
   public final Settings.Setting<Boolean> backfill;
   public final Settings.Setting<Boolean> logAsToast;
   public final Settings.Setting<Boolean> chatDebug;
   public final Settings.Setting<Boolean> renderPath;
   public final Settings.Setting<Boolean> renderPathAsLine;
   public final Settings.Setting<Boolean> renderGoal;
   public final Settings.Setting<Boolean> renderGoalAnimated;
   public final Settings.Setting<Boolean> renderSelectionBoxes;
   public final Settings.Setting<Boolean> renderGoalIgnoreDepth;
   public final Settings.Setting<Boolean> renderGoalXZBeacon;
   public final Settings.Setting<Boolean> renderSelectionBoxesIgnoreDepth;
   public final Settings.Setting<Boolean> renderPathIgnoreDepth;
   public final Settings.Setting<Float> pathRenderLineWidthPixels;
   public final Settings.Setting<Float> goalRenderLineWidthPixels;
   public final Settings.Setting<Boolean> fadePath;
   public final Settings.Setting<Boolean> freeLook;
   public final Settings.Setting<Boolean> blockFreeLook;
   public final Settings.Setting<Boolean> elytraFreeLook;
   public final Settings.Setting<Boolean> smoothLook;
   public final Settings.Setting<Boolean> elytraSmoothLook;
   public final Settings.Setting<Integer> smoothLookTicks;
   public final Settings.Setting<Boolean> remainWithExistingLookDirection;
   public final Settings.Setting<Boolean> antiCheatCompatibility;
   public final Settings.Setting<Boolean> pathThroughCachedOnly;
   public final Settings.Setting<Boolean> sprintInWater;
   public final Settings.Setting<Boolean> blacklistClosestOnFailure;
   public final Settings.Setting<Boolean> renderCachedChunks;
   public final Settings.Setting<Float> cachedChunksOpacity;
   public final Settings.Setting<Boolean> prefixControl;
   public final Settings.Setting<String> prefix;
   public final Settings.Setting<Boolean> shortBaritonePrefix;
   public final Settings.Setting<Boolean> useMessageTag;
   public final Settings.Setting<Boolean> echoCommands;
   public final Settings.Setting<Boolean> censorCoordinates;
   public final Settings.Setting<Boolean> censorRanCommands;
   public final Settings.Setting<Boolean> itemSaver;
   public final Settings.Setting<Integer> itemSaverThreshold;
   public final Settings.Setting<Boolean> preferSilkTouch;
   public final Settings.Setting<Boolean> walkWhileBreaking;
   public final Settings.Setting<Boolean> splicePath;
   public final Settings.Setting<Integer> maxPathHistoryLength;
   public final Settings.Setting<Integer> pathHistoryCutoffAmount;
   public final Settings.Setting<Integer> mineGoalUpdateInterval;
   public final Settings.Setting<Integer> maxCachedWorldScanCount;
   public final Settings.Setting<Integer> mineMaxOreLocationsCount;
   public final Settings.Setting<Integer> minYLevelWhileMining;
   public final Settings.Setting<Integer> maxYLevelWhileMining;
   public final Settings.Setting<Boolean> allowOnlyExposedOres;
   public final Settings.Setting<Integer> allowOnlyExposedOresDistance;
   public final Settings.Setting<Boolean> exploreForBlocks;
   public final Settings.Setting<Integer> worldExploringChunkOffset;
   public final Settings.Setting<Integer> exploreChunkSetMinimumSize;
   public final Settings.Setting<Integer> exploreMaintainY;
   public final Settings.Setting<Boolean> replantCrops;
   public final Settings.Setting<Boolean> replantNetherWart;
   public final Settings.Setting<Boolean> farmUsingSelection;
   public final Settings.Setting<Integer> farmMaxScanSize;
   public final Settings.Setting<Boolean> extendCacheOnThreshold;
   public final Settings.Setting<Boolean> buildInLayers;
   public final Settings.Setting<Boolean> layerOrder;
   public final Settings.Setting<Integer> layerHeight;
   public final Settings.Setting<Integer> startAtLayer;
   public final Settings.Setting<Boolean> skipFailedLayers;
   public final Settings.Setting<Boolean> buildOnlySelection;
   public final Settings.Setting<Vec3i> buildRepeat;
   public final Settings.Setting<Integer> buildRepeatCount;
   public final Settings.Setting<Boolean> buildRepeatSneaky;
   public final Settings.Setting<Boolean> breakFromAbove;
   public final Settings.Setting<Boolean> goalBreakFromAbove;
   public final Settings.Setting<Boolean> mapArtMode;
   public final Settings.Setting<Boolean> okIfWater;
   public final Settings.Setting<Integer> incorrectSize;
   public final Settings.Setting<Double> breakCorrectBlockPenaltyMultiplier;
   public final Settings.Setting<Double> placeIncorrectBlockPenaltyMultiplier;
   public final Settings.Setting<Boolean> schematicOrientationX;
   public final Settings.Setting<Boolean> schematicOrientationY;
   public final Settings.Setting<Boolean> schematicOrientationZ;
   public final Settings.Setting<Rotation> buildSchematicRotation;
   public final Settings.Setting<Mirror> buildSchematicMirror;
   public final Settings.Setting<String> schematicFallbackExtension;
   public final Settings.Setting<Integer> builderTickScanRadius;
   public final Settings.Setting<Boolean> mineScanDroppedItems;
   public final Settings.Setting<Long> mineDropLoiterDurationMSThanksLouca;
   public final Settings.Setting<Boolean> distanceTrim;
   public final Settings.Setting<Boolean> cancelOnGoalInvalidation;
   public final Settings.Setting<Integer> axisHeight;
   public final Settings.Setting<Boolean> disconnectOnArrival;
   public final Settings.Setting<Boolean> legitMine;
   public final Settings.Setting<Integer> legitMineYLevel;
   public final Settings.Setting<Boolean> legitMineIncludeDiagonals;
   public final Settings.Setting<Boolean> forceInternalMining;
   public final Settings.Setting<Boolean> internalMiningAirException;
   public final Settings.Setting<Double> followOffsetDistance;
   public final Settings.Setting<Float> followOffsetDirection;
   public final Settings.Setting<Integer> followRadius;
   public final Settings.Setting<Integer> followTargetMaxDistance;
   public final Settings.Setting<Boolean> disableCompletionCheck;
   public final Settings.Setting<Long> cachedChunksExpirySeconds;
   @Settings.JavaOnly
   public final Settings.Setting<Consumer<Component>> logger;
   @Settings.JavaOnly
   public final Settings.Setting<BiConsumer<String, Boolean>> notifier;
   @Settings.JavaOnly
   public final Settings.Setting<BiConsumer<Component, Component>> toaster;
   public final Settings.Setting<Boolean> verboseCommandExceptions;
   public final Settings.Setting<Double> yLevelBoxSize;
   public final Settings.Setting<Color> colorCurrentPath;
   public final Settings.Setting<Color> colorNextPath;
   public final Settings.Setting<Color> colorBlocksToBreak;
   public final Settings.Setting<Color> colorBlocksToPlace;
   public final Settings.Setting<Color> colorBlocksToWalkInto;
   public final Settings.Setting<Color> colorBestPathSoFar;
   public final Settings.Setting<Color> colorMostRecentConsidered;
   public final Settings.Setting<Color> colorGoalBox;
   public final Settings.Setting<Color> colorInvertedGoalBox;
   public final Settings.Setting<Color> colorSelection;
   public final Settings.Setting<Color> colorSelectionPos1;
   public final Settings.Setting<Color> colorSelectionPos2;
   public final Settings.Setting<Float> selectionOpacity;
   public final Settings.Setting<Float> selectionLineWidth;
   public final Settings.Setting<Boolean> renderSelection;
   public final Settings.Setting<Boolean> renderSelectionIgnoreDepth;
   public final Settings.Setting<Boolean> renderSelectionCorners;
   public final Settings.Setting<Boolean> useSwordToMine;
   public final Settings.Setting<Boolean> desktopNotifications;
   public final Settings.Setting<Boolean> notificationOnPathComplete;
   public final Settings.Setting<Boolean> notificationOnFarmFail;
   public final Settings.Setting<Boolean> notificationOnBuildFinished;
   public final Settings.Setting<Boolean> notificationOnExploreFinished;
   public final Settings.Setting<Boolean> notificationOnMineFail;
   public final Settings.Setting<Integer> elytraSimulationTicks;
   public final Settings.Setting<Integer> elytraPitchRange;
   public final Settings.Setting<Double> elytraFireworkSpeed;
   public final Settings.Setting<Integer> elytraFireworkSetbackUseDelay;
   public final Settings.Setting<Double> elytraMinimumAvoidance;
   public final Settings.Setting<Boolean> elytraConserveFireworks;
   public final Settings.Setting<Boolean> elytraRenderRaytraces;
   public final Settings.Setting<Boolean> elytraRenderHitboxRaytraces;
   public final Settings.Setting<Boolean> elytraRenderSimulation;
   public final Settings.Setting<Boolean> elytraAutoJump;
   public final Settings.Setting<Long> elytraNetherSeed;
   public final Settings.Setting<Boolean> elytraPredictTerrain;
   public final Settings.Setting<Boolean> elytraAutoSwap;
   public final Settings.Setting<Integer> elytraMinimumDurability;
   public final Settings.Setting<Integer> elytraMinFireworksBeforeLanding;
   public final Settings.Setting<Boolean> elytraAllowEmergencyLand;
   public final Settings.Setting<Long> elytraTimeBetweenCacheCullSecs;
   public final Settings.Setting<Integer> elytraCacheCullDistance;
   public final Settings.Setting<Boolean> elytraAllowLandOnNetherFortress;
   public final Settings.Setting<Boolean> elytraTermsAccepted;
   public final Settings.Setting<Boolean> elytraChatSpam;
   public final Settings.Setting<Boolean> elytraCustomAllocator;
   public final Settings.Setting<Boolean> elytraAllowTightSpaces;
   public final Settings.Setting<Boolean> elytraAllowAboveRoof;
   public final Settings.Setting<Boolean> elytraUseCache;
   public final Settings.Setting<Boolean> elytraAllowAboveBuildLimit;
   public final Settings.Setting<Integer> elytraLongDistanceThreshold;
   public final Settings.Setting<Boolean> allowWalkOnMagmaBlocks;
   public final Map<String, Settings.Setting<?>> byLowerName;
   public final List<Settings.Setting<?>> allSettings;
   public final Map<Settings.Setting<?>, Type> settingTypes;
   private static final double 诶弟Г = 0;
   private static final double 诶弟ф = 0;
   private static final double 诶弟Е = 0;
   private static final double 诶弟ч = 0;
   private static final double 诶弟衣 = 0;
   private static final double 诶弟ц = 0;
   private static final float 诶弟М = 0;
   private static final double 诶弟5 = 0;
   private static final double 诶弟Ж = 0;
   private static final double 诶弟о = 0;
   private static final double 诶弟К = 0;
   private static final double 诶弟Э = 0;
   private static final double 诶弟Ъ = 0;
   private static final double 诶弟Ч = 0;
   private static final float 诶弟Щ = 0;
   private static final long 诶弟м = 0;
   private static final long 诶弟Ф = 0;
   private static final long 诶弟3 = 0;
   private static final long 诶弟Ь = 0;
   private static final long 诶弟1 = 0;
   private static final long 诶弟я = 0;
   private static final float 诶弟I = 0;
   private static final float 诶弟ы = 0;
   private static final float 诶弟у = 0;
   private static final String 诶弟г = "诶弟г";
   private static final double 诶弟ю = 0;
   private static final double 诶弟4 = 0;
   private static final String 诶弟С = "诶弟С";
   private static final long 诶弟ъ = 0;
   private static final long 诶弟Б = 0;
   private static final double 诶弟в = 0;
   private static final float 诶弟р = 0;
   private static final double 诶弟й = 0;
   private static final double 诶弟к = 0;
   private static final long 诶弟п = 0;
   private static final long 诶弟2 = 0;
   private static final String 诶弟西 = "诶弟西";

   Settings() {
      this.blockPlacementPenalty = new Settings.Setting<>(诶弟Г);
      this.blockBreakAdditionalPenalty = new Settings.Setting<>(诶弟ф);
      this.jumpPenalty = new Settings.Setting<>(诶弟Е);
      this.walkOnWaterOnePenalty = new Settings.Setting<>(诶弟ч);
      this.strictLiquidCheck = new Settings.Setting<>(false);
      this.allowWaterBucketFall = new Settings.Setting<>(true);
      this.assumeWalkOnWater = new Settings.Setting<>(false);
      this.assumeWalkOnLava = new Settings.Setting<>(false);
      this.assumeStep = new Settings.Setting<>(false);
      this.assumeSafeWalk = new Settings.Setting<>(false);
      this.allowJumpAtBuildLimit = new Settings.Setting<>(false);
      this.allowJumpAt256 = new Settings.Setting<>(false);
      this.allowParkourAscend = new Settings.Setting<>(true);
      this.allowDiagonalDescend = new Settings.Setting<>(false);
      this.allowDiagonalAscend = new Settings.Setting<>(false);
      this.allowDownward = new Settings.Setting<>(true);
      this.acceptableThrowawayItems = new Settings.Setting<>(
         new ArrayList<>(Arrays.asList(Blocks.DIRT.asItem(), Blocks.COBBLESTONE.asItem(), Blocks.NETHERRACK.asItem(), Blocks.STONE.asItem()))
      );
      this.blocksToAvoid = new Settings.Setting<>(new ArrayList<>(List.of(Blocks.TRIPWIRE)));
      this.blocksToDisallowBreaking = new Settings.Setting<>(new ArrayList<>());
      this.blocksToAvoidBreaking = new Settings.Setting<>(
         new ArrayList<>(Arrays.asList(Blocks.CRAFTING_TABLE, Blocks.FURNACE, Blocks.CHEST, Blocks.TRAPPED_CHEST))
      );
      this.avoidBreakingMultiplier = new Settings.Setting<>(诶弟衣);
      this.buildIgnoreBlocks = new Settings.Setting<>(new ArrayList<>(Arrays.asList()));
      this.buildSkipBlocks = new Settings.Setting<>(new ArrayList<>(Arrays.asList()));
      this.buildValidSubstitutes = new Settings.Setting<>(new HashMap<>());
      this.buildSubstitutes = new Settings.Setting<>(new HashMap<>());
      this.okIfAir = new Settings.Setting<>(new ArrayList<>(Arrays.asList()));
      this.buildIgnoreExisting = new Settings.Setting<>(false);
      this.buildIgnoreDirection = new Settings.Setting<>(false);
      this.buildIgnoreProperties = new Settings.Setting<>(new ArrayList<>(Arrays.asList()));
      this.avoidUpdatingFallingBlocks = new Settings.Setting<>(true);
      this.allowVines = new Settings.Setting<>(false);
      this.allowWalkOnBottomSlab = new Settings.Setting<>(true);
      this.allowParkour = new Settings.Setting<>(false);
      this.allowParkourPlace = new Settings.Setting<>(false);
      this.considerPotionEffects = new Settings.Setting<>(true);
      this.sprintAscends = new Settings.Setting<>(true);
      this.overshootTraverse = new Settings.Setting<>(true);
      this.pauseMiningForFallingBlocks = new Settings.Setting<>(true);
      this.rightClickSpeed = new Settings.Setting<>(4);
      this.randomLooking113 = new Settings.Setting<>(诶弟ц);
      this.blockReachDistance = new Settings.Setting<>(诶弟М);
      this.blockBreakSpeed = new Settings.Setting<>(6);
      this.randomLooking = new Settings.Setting<>(诶弟5);
      this.costHeuristic = new Settings.Setting<>(诶弟Ж);
      this.pathingMaxChunkBorderFetch = new Settings.Setting<>(50);
      this.backtrackCostFavoringCoefficient = new Settings.Setting<>(诶弟о);
      this.avoidance = new Settings.Setting<>(false);
      this.mobSpawnerAvoidanceCoefficient = new Settings.Setting<>(诶弟К);
      this.mobSpawnerAvoidanceRadius = new Settings.Setting<>(16);
      this.mobAvoidanceCoefficient = new Settings.Setting<>(诶弟Э);
      this.mobAvoidanceRadius = new Settings.Setting<>(8);
      this.rightClickContainerOnArrival = new Settings.Setting<>(true);
      this.enterPortal = new Settings.Setting<>(true);
      this.minimumImprovementRepropagation = new Settings.Setting<>(true);
      this.cutoffAtLoadBoundary = new Settings.Setting<>(false);
      this.maxCostIncrease = new Settings.Setting<>(诶弟Ъ);
      this.costVerificationLookahead = new Settings.Setting<>(5);
      this.pathCutoffFactor = new Settings.Setting<>(诶弟Ч);
      this.pathCutoffMinimumLength = new Settings.Setting<>(30);
      this.planningTickLookahead = new Settings.Setting<>(150);
      this.pathingMapDefaultSize = new Settings.Setting<>(1024);
      this.pathingMapLoadFactor = new Settings.Setting<>(诶弟Щ);
      this.maxFallHeightNoWater = new Settings.Setting<>(3);
      this.maxFallHeightBucket = new Settings.Setting<>(20);
      this.allowOvershootDiagonalDescend = new Settings.Setting<>(true);
      this.simplifyUnloadedYCoord = new Settings.Setting<>(true);
      this.repackOnAnyBlockChange = new Settings.Setting<>(true);
      this.movementTimeoutTicks = new Settings.Setting<>(100);
      this.primaryTimeoutMS = new Settings.Setting<>(诶弟м);
      this.failureTimeoutMS = new Settings.Setting<>(诶弟Ф);
      this.planAheadPrimaryTimeoutMS = new Settings.Setting<>(诶弟3);
      this.planAheadFailureTimeoutMS = new Settings.Setting<>(诶弟Ь);
      this.slowPath = new Settings.Setting<>(false);
      this.slowPathTimeDelayMS = new Settings.Setting<>(诶弟1);
      this.slowPathTimeoutMS = new Settings.Setting<>(诶弟я);
      this.doBedWaypoints = new Settings.Setting<>(true);
      this.doDeathWaypoints = new Settings.Setting<>(true);
      this.chunkCaching = new Settings.Setting<>(true);
      this.pruneRegionsFromRAM = new Settings.Setting<>(true);
      this.chunkPackerQueueMaxSize = new Settings.Setting<>(2000);
      this.backfill = new Settings.Setting<>(false);
      this.logAsToast = new Settings.Setting<>(false);
      this.chatDebug = new Settings.Setting<>(false);
      this.renderPath = new Settings.Setting<>(true);
      this.renderPathAsLine = new Settings.Setting<>(false);
      this.renderGoal = new Settings.Setting<>(true);
      this.renderGoalAnimated = new Settings.Setting<>(true);
      this.renderSelectionBoxes = new Settings.Setting<>(true);
      this.renderGoalIgnoreDepth = new Settings.Setting<>(true);
      this.renderGoalXZBeacon = new Settings.Setting<>(false);
      this.renderSelectionBoxesIgnoreDepth = new Settings.Setting<>(true);
      this.renderPathIgnoreDepth = new Settings.Setting<>(true);
      this.pathRenderLineWidthPixels = new Settings.Setting<>(诶弟I);
      this.goalRenderLineWidthPixels = new Settings.Setting<>(诶弟ы);
      this.fadePath = new Settings.Setting<>(false);
      this.freeLook = new Settings.Setting<>(true);
      this.blockFreeLook = new Settings.Setting<>(false);
      this.elytraFreeLook = new Settings.Setting<>(true);
      this.smoothLook = new Settings.Setting<>(false);
      this.elytraSmoothLook = new Settings.Setting<>(false);
      this.smoothLookTicks = new Settings.Setting<>(5);
      this.remainWithExistingLookDirection = new Settings.Setting<>(true);
      this.antiCheatCompatibility = new Settings.Setting<>(true);
      this.pathThroughCachedOnly = new Settings.Setting<>(false);
      this.sprintInWater = new Settings.Setting<>(true);
      this.blacklistClosestOnFailure = new Settings.Setting<>(true);
      this.renderCachedChunks = new Settings.Setting<>(false);
      this.cachedChunksOpacity = new Settings.Setting<>(诶弟у);
      this.prefixControl = new Settings.Setting<>(true);
      this.prefix = new Settings.Setting<>(诶弟г);
      this.shortBaritonePrefix = new Settings.Setting<>(false);
      this.useMessageTag = new Settings.Setting<>(false);
      this.echoCommands = new Settings.Setting<>(true);
      this.censorCoordinates = new Settings.Setting<>(false);
      this.censorRanCommands = new Settings.Setting<>(false);
      this.itemSaver = new Settings.Setting<>(false);
      this.itemSaverThreshold = new Settings.Setting<>(10);
      this.preferSilkTouch = new Settings.Setting<>(false);
      this.walkWhileBreaking = new Settings.Setting<>(true);
      this.splicePath = new Settings.Setting<>(true);
      this.maxPathHistoryLength = new Settings.Setting<>(300);
      this.pathHistoryCutoffAmount = new Settings.Setting<>(50);
      this.mineGoalUpdateInterval = new Settings.Setting<>(5);
      this.maxCachedWorldScanCount = new Settings.Setting<>(10);
      this.mineMaxOreLocationsCount = new Settings.Setting<>(64);
      this.minYLevelWhileMining = new Settings.Setting<>(0);
      this.maxYLevelWhileMining = new Settings.Setting<>(2031);
      this.allowOnlyExposedOres = new Settings.Setting<>(false);
      this.allowOnlyExposedOresDistance = new Settings.Setting<>(1);
      this.exploreForBlocks = new Settings.Setting<>(true);
      this.worldExploringChunkOffset = new Settings.Setting<>(0);
      this.exploreChunkSetMinimumSize = new Settings.Setting<>(10);
      this.exploreMaintainY = new Settings.Setting<>(64);
      this.replantCrops = new Settings.Setting<>(true);
      this.replantNetherWart = new Settings.Setting<>(false);
      this.farmUsingSelection = new Settings.Setting<>(false);
      this.farmMaxScanSize = new Settings.Setting<>(256);
      this.extendCacheOnThreshold = new Settings.Setting<>(false);
      this.buildInLayers = new Settings.Setting<>(false);
      this.layerOrder = new Settings.Setting<>(false);
      this.layerHeight = new Settings.Setting<>(1);
      this.startAtLayer = new Settings.Setting<>(0);
      this.skipFailedLayers = new Settings.Setting<>(false);
      this.buildOnlySelection = new Settings.Setting<>(false);
      this.buildRepeat = new Settings.Setting<>(new Vec3i(0, 0, 0));
      this.buildRepeatCount = new Settings.Setting<>(-1);
      this.buildRepeatSneaky = new Settings.Setting<>(true);
      this.breakFromAbove = new Settings.Setting<>(false);
      this.goalBreakFromAbove = new Settings.Setting<>(false);
      this.mapArtMode = new Settings.Setting<>(false);
      this.okIfWater = new Settings.Setting<>(false);
      this.incorrectSize = new Settings.Setting<>(100);
      this.breakCorrectBlockPenaltyMultiplier = new Settings.Setting<>(诶弟ю);
      this.placeIncorrectBlockPenaltyMultiplier = new Settings.Setting<>(诶弟4);
      this.schematicOrientationX = new Settings.Setting<>(false);
      this.schematicOrientationY = new Settings.Setting<>(false);
      this.schematicOrientationZ = new Settings.Setting<>(false);
      this.buildSchematicRotation = new Settings.Setting<>(Rotation.NONE);
      this.buildSchematicMirror = new Settings.Setting<>(Mirror.NONE);
      this.schematicFallbackExtension = new Settings.Setting<>(诶弟С);
      this.builderTickScanRadius = new Settings.Setting<>(5);
      this.mineScanDroppedItems = new Settings.Setting<>(true);
      this.mineDropLoiterDurationMSThanksLouca = new Settings.Setting<>(诶弟ъ);
      this.distanceTrim = new Settings.Setting<>(true);
      this.cancelOnGoalInvalidation = new Settings.Setting<>(true);
      this.axisHeight = new Settings.Setting<>(120);
      this.disconnectOnArrival = new Settings.Setting<>(false);
      this.legitMine = new Settings.Setting<>(false);
      this.legitMineYLevel = new Settings.Setting<>(-59);
      this.legitMineIncludeDiagonals = new Settings.Setting<>(false);
      this.forceInternalMining = new Settings.Setting<>(true);
      this.internalMiningAirException = new Settings.Setting<>(true);
      this.followOffsetDistance = new Settings.Setting<>(0.0);
      this.followOffsetDirection = new Settings.Setting<>(0.0F);
      this.followRadius = new Settings.Setting<>(3);
      this.followTargetMaxDistance = new Settings.Setting<>(0);
      this.disableCompletionCheck = new Settings.Setting<>(false);
      this.cachedChunksExpirySeconds = new Settings.Setting<>(诶弟Б);
      this.logger = new Settings.Setting<>(var1x -> {
         try {
            GuiMessageTag var2 = this.useMessageTag.value ? Helper.MESSAGE_TAG : null;
            Minecraft.getInstance().gui.hud.getChat().addPlayerMessage(var1x, null, var2);
         } catch (Throwable var3x) {
         }
      });
      this.notifier = new Settings.Setting<>(NotificationHelper::notify);
      this.toaster = new Settings.Setting<>(BaritoneToast::addOrUpdate);
      this.verboseCommandExceptions = new Settings.Setting<>(false);
      this.yLevelBoxSize = new Settings.Setting<>(诶弟в);
      this.colorCurrentPath = new Settings.Setting<>(Color.RED);
      this.colorNextPath = new Settings.Setting<>(Color.MAGENTA);
      this.colorBlocksToBreak = new Settings.Setting<>(Color.RED);
      this.colorBlocksToPlace = new Settings.Setting<>(Color.GREEN);
      this.colorBlocksToWalkInto = new Settings.Setting<>(Color.MAGENTA);
      this.colorBestPathSoFar = new Settings.Setting<>(Color.BLUE);
      this.colorMostRecentConsidered = new Settings.Setting<>(Color.CYAN);
      this.colorGoalBox = new Settings.Setting<>(Color.GREEN);
      this.colorInvertedGoalBox = new Settings.Setting<>(Color.RED);
      this.colorSelection = new Settings.Setting<>(Color.CYAN);
      this.colorSelectionPos1 = new Settings.Setting<>(Color.BLACK);
      this.colorSelectionPos2 = new Settings.Setting<>(Color.ORANGE);
      this.selectionOpacity = new Settings.Setting<>(诶弟р);
      this.selectionLineWidth = new Settings.Setting<>(2.0F);
      this.renderSelection = new Settings.Setting<>(true);
      this.renderSelectionIgnoreDepth = new Settings.Setting<>(true);
      this.renderSelectionCorners = new Settings.Setting<>(true);
      this.useSwordToMine = new Settings.Setting<>(true);
      this.desktopNotifications = new Settings.Setting<>(false);
      this.notificationOnPathComplete = new Settings.Setting<>(true);
      this.notificationOnFarmFail = new Settings.Setting<>(true);
      this.notificationOnBuildFinished = new Settings.Setting<>(true);
      this.notificationOnExploreFinished = new Settings.Setting<>(true);
      this.notificationOnMineFail = new Settings.Setting<>(true);
      this.elytraSimulationTicks = new Settings.Setting<>(20);
      this.elytraPitchRange = new Settings.Setting<>(25);
      this.elytraFireworkSpeed = new Settings.Setting<>(诶弟й);
      this.elytraFireworkSetbackUseDelay = new Settings.Setting<>(15);
      this.elytraMinimumAvoidance = new Settings.Setting<>(诶弟к);
      this.elytraConserveFireworks = new Settings.Setting<>(false);
      this.elytraRenderRaytraces = new Settings.Setting<>(false);
      this.elytraRenderHitboxRaytraces = new Settings.Setting<>(false);
      this.elytraRenderSimulation = new Settings.Setting<>(true);
      this.elytraAutoJump = new Settings.Setting<>(false);
      this.elytraNetherSeed = new Settings.Setting<>(诶弟п);
      this.elytraPredictTerrain = new Settings.Setting<>(false);
      this.elytraAutoSwap = new Settings.Setting<>(true);
      this.elytraMinimumDurability = new Settings.Setting<>(5);
      this.elytraMinFireworksBeforeLanding = new Settings.Setting<>(5);
      this.elytraAllowEmergencyLand = new Settings.Setting<>(true);
      this.elytraTimeBetweenCacheCullSecs = new Settings.Setting<>(TimeUnit.MINUTES.toSeconds(诶弟2));
      this.elytraCacheCullDistance = new Settings.Setting<>(5000);
      this.elytraAllowLandOnNetherFortress = new Settings.Setting<>(false);
      this.elytraTermsAccepted = new Settings.Setting<>(false);
      this.elytraChatSpam = new Settings.Setting<>(false);
      this.elytraCustomAllocator = new Settings.Setting<>(true);
      this.elytraAllowTightSpaces = new Settings.Setting<>(false);
      this.elytraAllowAboveRoof = new Settings.Setting<>(false);
      this.elytraUseCache = new Settings.Setting<>(true);
      this.elytraAllowAboveBuildLimit = new Settings.Setting<>(true);
      this.elytraLongDistanceThreshold = new Settings.Setting<>(500);
      this.allowWalkOnMagmaBlocks = new Settings.Setting<>(false);
      Field[] var1 = this.getClass().getFields();
      Map sx = new HashMap<>();
      List sxx = new ArrayList<>();
      Map sxxx = new HashMap<>();

      try {
         for (Field sxxxx : var1) {
            if (sxxxx.getType().equals(Settings.Setting.class)) {
               var sxxxxx = (Settings.Setting<?>)sxxxx.get(this);
               String sxxxxxx = sxxxx.getName();
               sxxxxx.name = sxxxxxx;
               sxxxxx.javaOnly = sxxxx.isAnnotationPresent(Settings.JavaOnly.class);
               sxxxxxx = sxxxxxx.toLowerCase();
               if (sx.containsKey(sxxxxxx)) {
                  throw new IllegalStateException(诶弟西);
               }

               sx.put(sxxxxxx, sxxxxx);
               sxx.add(sxxxxx);
               sxxx.put(sxxxxx, ((ParameterizedType)sxxxx.getGenericType()).getActualTypeArguments()[0]);
            }
         }
      } catch (IllegalAccessException sxxxx) {
         throw new IllegalStateException(sxxxx);
      }

      this.byLowerName = Collections.unmodifiableMap(sx);
      this.allSettings = Collections.unmodifiableList(sxx);
      this.settingTypes = Collections.unmodifiableMap(sxxx);
   }

   public <T> List<Settings.Setting<T>> getAllValuesByType(Class<T> var1) {
      List var2 = new ArrayList<>();

      for (Settings.Setting sx : this.allSettings) {
         if (sx.getValueClass().equals(var1)) {
            var2.add((Settings.Setting<T>)sx);
         }
      }

      return var2;
   }


   // $VF: Compiled from s
   @Target(ElementType.FIELD)
   @Retention(RetentionPolicy.RUNTIME)
   private @interface JavaOnly {
   }

   // $VF: Compiled from s
   public final class Setting<T> {
      public T value;
      public final T defaultValue;
      private String name;
      private boolean javaOnly;
      private static final String 诶Ыч = "诶Ыч";

      public final Type getType() {
         return Settings.this.settingTypes.get(this);
      }

      public final String getName() {
         return this.name;
      }

      private Setting(T var2) {
         if (var2 == null) {
            throw new IllegalArgumentException(诶Ыч);
         }

         this.value = var2;
         this.defaultValue = var2;
         this.javaOnly = false;
      }

      public boolean isJavaOnly() {
         return this.javaOnly;
      }

      public Class<T> getValueClass() {
         return (Class<T>)TypeUtils.resolveBaseClass(this.getType());
      }

      @Deprecated
      public final T get() {
         return this.value;
      }

      public void reset() {
         this.value = this.defaultValue;
      }


      @Override
      public String toString() {
         return SettingsUtil.settingToString(this);
      }
   }
}
