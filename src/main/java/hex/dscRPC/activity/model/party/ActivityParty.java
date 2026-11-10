// Original binary: hex/dscRPC/activity/model/party/ActivityParty
package hex.dscRPC.activity.model.party;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// $VF: Compiled from s
public class ActivityParty {
   @JsonProperty("id")
   private final String id;
   @JsonProperty("size")
   private final int[] size;
   @JsonProperty("privacy")
   private final ActivityPartyPrivacy privacy;

   @JsonCreator
   protected ActivityParty(@JsonProperty(value = "id", required = true) String var1, @JsonProperty(value = "size", required = true) int[] var2) {
      this.id = var1;
      this.size = var2;
      this.privacy = ActivityPartyPrivacy.PRIVATE;
   }

   public ActivityParty(String var1, int var2, int var3, ActivityPartyPrivacy var4) {
      this.id = var1;
      this.size = new int[]{var2, var3};
      this.privacy = var4;
   }

   public static ActivityPartyBuilder builder(String var0, int var1) {
      return new ActivityPartyBuilder(var0, var1);
   }
}
