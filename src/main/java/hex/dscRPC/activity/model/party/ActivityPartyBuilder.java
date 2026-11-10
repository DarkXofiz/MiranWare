// Original binary: hex/dscRPC/activity/model/party/ActivityPartyBuilder
package hex.dscRPC.activity.model.party;

// $VF: Compiled from s
public class ActivityPartyBuilder {
   private final String id;
   private final int currentSize;
   private int maximumSize;
   private ActivityPartyPrivacy privacy;

   public ActivityParty build() {
      return new ActivityParty(this.id, this.currentSize, this.maximumSize, this.privacy);
   }

   public ActivityPartyBuilder privacy(ActivityPartyPrivacy var1) {
      this.privacy = var1;
      return this;
   }

   public ActivityPartyBuilder maximumSize(int var1) {
      this.maximumSize = var1;
      return this;
   }

   public ActivityPartyBuilder(String var1, int var2) {
      this.id = var1;
      this.currentSize = var2;
      this.maximumSize = 0;
      this.privacy = ActivityPartyPrivacy.PRIVATE;
   }
}
