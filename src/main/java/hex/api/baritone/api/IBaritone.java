// Original binary: hex/api/baritone/api/IBaritone
package hex.api.baritone.api;

import hex.api.baritone.api.behavior.ILookBehavior;
import hex.api.baritone.api.behavior.IPathingBehavior;
import hex.api.baritone.api.cache.IWorldProvider;
import hex.api.baritone.api.command.manager.ICommandManager;
import hex.api.baritone.api.event.listener.IEventBus;
import hex.api.baritone.api.pathing.calc.IPathingControlManager;
import hex.api.baritone.api.process.IBuilderProcess;
import hex.api.baritone.api.process.ICustomGoalProcess;
import hex.api.baritone.api.process.IElytraProcess;
import hex.api.baritone.api.process.IExploreProcess;
import hex.api.baritone.api.process.IFarmProcess;
import hex.api.baritone.api.process.IFollowProcess;
import hex.api.baritone.api.process.IGetToBlockProcess;
import hex.api.baritone.api.process.IMineProcess;
import hex.api.baritone.api.selection.ISelectionManager;
import hex.api.baritone.api.utils.IInputOverrideHandler;
import hex.api.baritone.api.utils.IPlayerContext;

// $VF: Compiled from s
public interface IBaritone {
   IPathingBehavior getPathingBehavior();

   ISelectionManager getSelectionManager();

   IFarmProcess getFarmProcess();

   IPathingControlManager getPathingControlManager();

   void openClick();

   IGetToBlockProcess getGetToBlockProcess();

   IPlayerContext getPlayerContext();

   ICommandManager getCommandManager();

   ILookBehavior getLookBehavior();

   IElytraProcess getElytraProcess();

   ICustomGoalProcess getCustomGoalProcess();

   IFollowProcess getFollowProcess();

   IWorldProvider getWorldProvider();

   IMineProcess getMineProcess();

   IInputOverrideHandler getInputOverrideHandler();

   IEventBus getGameEventHandler();

   IExploreProcess getExploreProcess();

   IBuilderProcess getBuilderProcess();
}
