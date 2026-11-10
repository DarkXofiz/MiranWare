// Original binary: hex/api/baritone/api/command/IBaritoneChatControl
package hex.api.baritone.api.command;

import java.util.UUID;

// $VF: Compiled from s
public interface IBaritoneChatControl {
   String FORCE_COMMAND_PREFIX = String.format("<<%s>>", UUID.randomUUID().toString());
}
