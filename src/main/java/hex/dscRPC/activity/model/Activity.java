// Original binary: hex/dscRPC/activity/model/Activity
package hex.dscRPC.activity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import hex.dscRPC.activity.model.assets.ActivityAssets;
import hex.dscRPC.activity.model.party.ActivityParty;
import java.util.List;

// $VF: Compiled from s
public class Activity {
   @JsonProperty("type")
   private final ActivityType type;
   @JsonProperty("details")
   private final String details;
   @JsonProperty("details_url")
   private final String detailsUrl;
   @JsonProperty("state")
   private final String state;
   @JsonProperty("state_url")
   private final String stateUrl;
   @JsonProperty("status_display_type")
   private final ActivityStatusDisplayType statusDisplayType;
   @JsonProperty("party")
   private final ActivityParty party;
   @JsonProperty("timestamps")
   private final ActivityTimestamps timestamps;
   @JsonProperty("assets")
   private final ActivityAssets assets;
   @JsonProperty("buttons")
   private final List<ActivityButton> buttons;

   public static ActivityBuilder builder() {
      return new ActivityBuilder();
   }

   @JsonCreator
   public Activity(
      @JsonProperty(value = "type", required = true) ActivityType var1,
      @JsonProperty("details") String var2,
      @JsonProperty("details_url") String var3,
      @JsonProperty("state") String var4,
      @JsonProperty("state_url") String var5,
      @JsonProperty("status_display_type") ActivityStatusDisplayType var6,
      @JsonProperty("party") ActivityParty var7,
      @JsonProperty("timestamps") ActivityTimestamps var8,
      @JsonProperty("assets") ActivityAssets var9,
      @JsonProperty("buttons") List<ActivityButton> var10
   ) {
      this.type = var1;
      this.details = var2;
      this.detailsUrl = var3;
      this.state = var4;
      this.stateUrl = var5;
      this.statusDisplayType = var6;
      this.party = var7;
      this.timestamps = var8;
      this.assets = var9;
      this.buttons = var10;
   }
}
