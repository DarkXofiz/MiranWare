// Original binary: sg/mx/OmqPFQAcDGgs4OcL
package sg.mx;

import net.minecraft.client.multiplayer.chat.GuiMessage.Line;
import net.minecraft.network.chat.Component;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Unique;
import sg.ec.ChatTextMatchAccess;

// $VF: Compiled from s
@Mixin(Line.class)
public class GuiMessage$LineMixin_1197 implements ChatTextMatchAccess {
   @Unique
   private Component rawText;
   @Unique
   private boolean matchComputed;
   @Unique
   private boolean selfMatch;
   @Unique
   private boolean friendMatch;

   @Override
   public Component getRawText() {
      return this.rawText;
   }

   @Override
   public void setRawText(Component var1) {
      this.rawText = var1;
      this.matchComputed = false;
      this.selfMatch = false;
      this.friendMatch = false;
   }

   @Override
   public boolean isMatchComputed() {
      return this.matchComputed;
   }

   @Override
   public void setMatchComputed(boolean var1) {
      this.matchComputed = var1;
   }

   @Override
   public boolean isSelfMatch() {
      return this.selfMatch;
   }

   @Override
   public void setSelfMatch(boolean var1) {
      this.selfMatch = var1;
   }

   @Override
   public boolean isFriendMatch() {
      return this.friendMatch;
   }

   @Override
   public void setFriendMatch(boolean var1) {
      this.friendMatch = var1;
   }
}
