// Original binary: hex/api/baritone/command/CommandSystem
package hex.api.baritone.command;

import hex.api.baritone.api.command.ICommandSystem;
import hex.api.baritone.api.command.argparser.IArgParserManager;
import hex.api.baritone.command.argparser.ArgParserManager;

// $VF: Compiled from s
public enum CommandSystem implements ICommandSystem {
   INSTANCE;

   @Override
   public IArgParserManager getParserManager() {
      return ArgParserManager.INSTANCE;
   }
}
