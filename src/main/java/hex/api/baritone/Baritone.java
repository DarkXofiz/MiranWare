// Original binary: hex/api/baritone/Baritone
package hex.api.baritone;

import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.Settings;
import hex.api.baritone.api.behavior.IBehavior;
import hex.api.baritone.api.event.listener.IEventBus;
import hex.api.baritone.api.process.IBaritoneProcess;
import hex.api.baritone.api.process.IElytraProcess;
import hex.api.baritone.api.utils.IPlayerContext;
import hex.api.baritone.behavior.InventoryBehavior;
import hex.api.baritone.behavior.LookBehavior;
import hex.api.baritone.behavior.PathingBehavior;
import hex.api.baritone.behavior.WaypointBehavior;
import hex.api.baritone.cache.WorldProvider;
import hex.api.baritone.command.manager.CommandManager;
import hex.api.baritone.event.GameEventHandler;
import hex.api.baritone.process.BackfillProcess;
import hex.api.baritone.process.BuilderProcess;
import hex.api.baritone.process.CustomGoalProcess;
import hex.api.baritone.process.ExploreProcess;
import hex.api.baritone.process.FarmProcess;
import hex.api.baritone.process.FollowProcess;
import hex.api.baritone.process.GetToBlockProcess;
import hex.api.baritone.process.InventoryPauserProcess;
import hex.api.baritone.process.MineProcess;
import hex.api.baritone.process.elytra.NullElytraProcess;
import hex.api.baritone.selection.SelectionManager;
import hex.api.baritone.utils.BlockStateInterface;
import hex.api.baritone.utils.GuiClick;
import hex.api.baritone.utils.InputOverrideHandler;
import hex.api.baritone.utils.PathingControlManager;
import hex.api.baritone.utils.player.BaritonePlayerContext;
import hex.api.baritone.utils.player.BotBaritonePlayerContext;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import net.minecraft.client.Minecraft;
import sg.ec.BotClient;

// $VF: Compiled from s
public class Baritone implements IBaritone {
   private static final ThreadPoolExecutor threadPool = new ThreadPoolExecutor(4, Baritone.Ао诶, Baritone.АоЫ, TimeUnit.SECONDS, new SynchronousQueue<>());
   private final Minecraft mc;
   private final Path directory;
   private final GameEventHandler gameEventHandler;
   private final PathingBehavior pathingBehavior;
   private final LookBehavior lookBehavior;
   private final InventoryBehavior inventoryBehavior;
   private final InputOverrideHandler inputOverrideHandler;
   private final FollowProcess followProcess;
   private final MineProcess mineProcess;
   private final GetToBlockProcess getToBlockProcess;
   private final CustomGoalProcess customGoalProcess;
   private final BuilderProcess builderProcess;
   private final ExploreProcess exploreProcess;
   private final FarmProcess farmProcess;
   private final InventoryPauserProcess inventoryPauserProcess;
   private final IElytraProcess elytraProcess;
   private final PathingControlManager pathingControlManager;
   private final SelectionManager selectionManager;
   private final CommandManager commandManager;
   private final IPlayerContext playerContext;
   private final WorldProvider worldProvider;
   private final BotClient bot;
   private BlockStateInterface bsi;
   private boolean bsiAvailable;
   private static final String Аоб = "baritone";
   private static final long АоА = 100L;
   private static final int Ао诶 = Integer.MAX_VALUE;
   private static final long АоЫ = 60L;

   public <T extends IBaritoneProcess> T registerProcess(Function<Baritone, T> var1) {
      T var2 = var1.apply(this);
      this.pathingControlManager.registerProcess(var2);
      return var2;
   }

   public void resetBsi(boolean var1) {
      this.bsi = null;
      this.bsiAvailable = var1;
   }

   @Override
   public IEventBus getGameEventHandler() {
      return this.gameEventHandler;
   }

   public PathingControlManager getPathingControlManager() {
      return this.pathingControlManager;
   }

   public InventoryPauserProcess getInventoryPauserProcess() {
      return this.inventoryPauserProcess;
   }

   @Override
   public IElytraProcess getElytraProcess() {
      return this.elytraProcess;
   }

   public MineProcess getMineProcess() {
      return this.mineProcess;
   }

   public BuilderProcess getBuilderProcess() {
      return this.builderProcess;
   }

   public void registerBehavior(IBehavior var1) {
      this.gameEventHandler.registerEventListener(var1);
   }

   @Override
   public IPlayerContext getPlayerContext() {
      return this.playerContext;
   }

   public InputOverrideHandler getInputOverrideHandler() {
      return this.inputOverrideHandler;
   }

   public static Settings settings() {
      return BaritoneAPI.getSettings();
   }

   @Override
   public void openClick() {
      new Thread(() -> {
         try {
            Thread.sleep(АоА);
            this.mc.execute(() -> this.mc.gui.setScreen(new GuiClick()));
         } catch (Exception var2) {
         }
      }).start();
   }

   public BlockStateInterface bsi() {
      if (this.bsi == null && this.bsiAvailable) {
         try {
            this.bsi = new BlockStateInterface(this.playerContext, true);
         } catch (Exception var2) {
            this.bsiAvailable = false;
         }
      }

      return this.bsi;
   }

   public CustomGoalProcess getCustomGoalProcess() {
      return this.customGoalProcess;
   }

   public FollowProcess getFollowProcess() {
      return this.followProcess;
   }

   public GetToBlockProcess getGetToBlockProcess() {
      return this.getToBlockProcess;
   }

   public <T extends IBehavior> T registerBehavior(Function<Baritone, T> var1) {
      T var2 = var1.apply(this);
      this.registerBehavior(var2);
      return var2;
   }

   Baritone(Minecraft var1, BotClient var2) {
      this.mc = var1;
      this.bot = var2;
      this.gameEventHandler = new GameEventHandler(this);
      this.directory = var1.gameDirectory.toPath().resolve(Аоб);
      if (!Files.exists(this.directory)) {
         try {
            Files.createDirectories(this.directory);
         } catch (IOException var4) {
         }
      }

      this.playerContext = var2 == null ? new BaritonePlayerContext(this, var1) : new BotBaritonePlayerContext(this, var1, var2);
      this.lookBehavior = this.registerBehavior(LookBehavior::new);
      this.pathingBehavior = this.registerBehavior(PathingBehavior::new);
      this.inventoryBehavior = this.registerBehavior(InventoryBehavior::new);
      this.inputOverrideHandler = this.registerBehavior(InputOverrideHandler::new);
      this.registerBehavior(WaypointBehavior::new);
      this.pathingControlManager = new PathingControlManager(this);
      this.followProcess = this.registerProcess(FollowProcess::new);
      this.mineProcess = this.registerProcess(MineProcess::new);
      this.customGoalProcess = this.registerProcess(CustomGoalProcess::new);
      this.getToBlockProcess = this.registerProcess(GetToBlockProcess::new);
      this.builderProcess = this.registerProcess(BuilderProcess::new);
      this.exploreProcess = this.registerProcess(ExploreProcess::new);
      this.farmProcess = this.registerProcess(FarmProcess::new);
      this.inventoryPauserProcess = this.registerProcess(InventoryPauserProcess::new);
      this.elytraProcess = this.registerProcess(NullElytraProcess::new);
      this.registerProcess(BackfillProcess::new);
      this.worldProvider = new WorldProvider(this);
      this.selectionManager = new SelectionManager(this);
      this.commandManager = new CommandManager(this);
   }

   public WorldProvider getWorldProvider() {
      return this.worldProvider;
   }

   public InventoryBehavior getInventoryBehavior() {
      return this.inventoryBehavior;
   }

   public SelectionManager getSelectionManager() {
      return this.selectionManager;
   }

   public ExploreProcess getExploreProcess() {
      return this.exploreProcess;
   }

   public static Executor getExecutor() {
      return threadPool;
   }


   Baritone(Minecraft var1) {
      this(var1, null);
   }

   public LookBehavior getLookBehavior() {
      return this.lookBehavior;
   }

   public PathingBehavior getPathingBehavior() {
      return this.pathingBehavior;
   }

   public FarmProcess getFarmProcess() {
      return this.farmProcess;
   }

   public CommandManager getCommandManager() {
      return this.commandManager;
   }

   public Path getDirectory() {
      return this.directory;
   }
}
