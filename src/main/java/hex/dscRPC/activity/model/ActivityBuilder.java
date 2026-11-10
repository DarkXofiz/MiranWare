// Original binary: hex/dscRPC/activity/model/ActivityBuilder
package hex.dscRPC.activity.model;

import hex.dscRPC.activity.model.assets.ActivityAssets;
import hex.dscRPC.activity.model.assets.ActivityAssetsBuilder;
import hex.dscRPC.activity.model.party.ActivityParty;
import hex.dscRPC.activity.model.party.ActivityPartyBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

// $VF: Compiled from s
public class ActivityBuilder {
   private ActivityType type = ActivityType.PLAYING;
   private String details;
   private String detailsUrl;
   private String state;
   private String stateUrl;
   private ActivityStatusDisplayType statusDisplayType;
   private ActivityParty party;
   private ActivityTimestamps timestamps;
   private ActivityAssets assets;
   private List<ActivityButton> buttons;

   public ActivityBuilder assets(ActivityAssets var1) {
      this.assets = var1;
      return this;
   }

   public ActivityBuilder party(String var1, int var2, Consumer<ActivityPartyBuilder> var3) {
      ActivityPartyBuilder var4 = ActivityParty.builder(var1, var2);
      var3.accept(var4);
      this.party = var4.build();
      return this;
   }

   public ActivityBuilder button(String var1, String var2) {
      if (this.buttons == null) {
         this.buttons = new ArrayList<>();
      }

      this.buttons.add(new ActivityButton(var1, var2));
      return this;
   }

   public ActivityBuilder assets(Consumer<ActivityAssetsBuilder> var1) {
      ActivityAssetsBuilder var2 = ActivityAssets.builder();
      var1.accept(var2);
      this.assets = var2.build();
      return this;
   }

   public ActivityBuilder details(String var1, String var2) {
      this.details = var1;
      this.detailsUrl = var2;
      return this;
   }

   public ActivityBuilder state(String var1, String var2) {
      this.state = var1;
      this.stateUrl = var2;
      return this;
   }

   public ActivityBuilder timestamps(ActivityTimestamps var1) {
      this.timestamps = var1;
      return this;
   }

   public ActivityBuilder statusDisplayType(ActivityStatusDisplayType var1) {
      this.statusDisplayType = var1;
      return this;
   }

   public ActivityBuilder details(String var1) {
      this.details = var1;
      return this;
   }

   public ActivityBuilder type(ActivityType var1) {
      this.type = var1;
      return this;
   }

   public ActivityBuilder state(String var1) {
      this.state = var1;
      return this;
   }

   public ActivityBuilder party(ActivityParty var1) {
      this.party = var1;
      return this;
   }

   public Activity build() {
      return new Activity(
         this.type, this.details, this.detailsUrl, this.state, this.stateUrl, this.statusDisplayType, this.party, this.timestamps, this.assets, this.buttons
      );
   }
}
