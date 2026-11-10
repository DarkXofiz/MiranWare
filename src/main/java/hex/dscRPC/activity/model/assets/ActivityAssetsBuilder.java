// Original binary: hex/dscRPC/activity/model/assets/ActivityAssetsBuilder
package hex.dscRPC.activity.model.assets;

// $VF: Compiled from s
public class ActivityAssetsBuilder {
   private String largeImage = null;
   private String largeText = null;
   private String smallImage = null;
   private String smallText = null;

   public ActivityAssets build() {
      return new ActivityAssets(this.largeImage, this.largeText, this.smallImage, this.smallText);
   }

   public ActivityAssetsBuilder largeImage(String var1, String var2) {
      this.largeImage = var1;
      this.largeText = var2;
      return this;
   }

   public ActivityAssetsBuilder smallImage(String var1, String var2) {
      this.smallImage = var1;
      this.smallText = var2;
      return this;
   }

   public ActivityAssetsBuilder largeImage(String var1) {
      this.largeImage = var1;
      return this;
   }

   public ActivityAssetsBuilder smallImage(String var1) {
      this.smallImage = var1;
      return this;
   }
}
