// Original binary: sg/ec/HgSsNVVgtA95Z3Jh
package sg.ec;

import java.util.List;
import net.minecraft.client.multiplayer.PlayerInfo;

// $VF: Compiled from s
public class PlayerListRowColorEvent extends Event {
   public static final PlayerListRowColorEvent field08574 = new PlayerListRowColorEvent();
   private List<PlayerInfo> field08575;
   private int field08576;
   private int field08577;

   public void method03803(int var1) {
      this.field08577 = var1;
   }

   public int method03804() {
      return this.field08577;
   }

   public int method03805(List<PlayerInfo> var1, int var2, int var3) {
      this.field08575 = var1;
      this.field08576 = var2;
      this.field08577 = var3;
      super.method03208();
      return this.method05694() ? this.field08576 : var2;
   }

   public List<PlayerInfo> method03806() {
      return this.field08575;
   }

   public void method03807(int var1) {
      this.field08576 = var1;
   }

   public int method03808() {
      return this.field08576;
   }

   public void method03809(List<PlayerInfo> var1) {
      this.field08575 = var1;
   }
}
