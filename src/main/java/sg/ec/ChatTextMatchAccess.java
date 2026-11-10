// Original binary: sg/ec/fwk9EPJcrF8Af67B
package sg.ec;

import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public interface ChatTextMatchAccess {
   void setFriendMatch(boolean var1);

   Component getRawText();

   boolean isMatchComputed();

   boolean isFriendMatch();

   void setRawText(Component var1);

   void setMatchComputed(boolean var1);

   void setSelfMatch(boolean var1);

   boolean isSelfMatch();
}
