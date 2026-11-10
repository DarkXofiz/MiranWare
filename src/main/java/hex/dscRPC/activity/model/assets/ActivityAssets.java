// Original binary: hex/dscRPC/activity/model/assets/ActivityAssets
package hex.dscRPC.activity.model.assets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

// $VF: Compiled from s
public class ActivityAssets {
   @JsonProperty("large_image")
   private final String largeImage;
   @JsonProperty("large_text")
   private final String largeText;
   @JsonProperty("small_image")
   private final String smallImage;
   @JsonProperty("small_text")
   private final String smallText;

   public static ActivityAssetsBuilder builder() {
      return new ActivityAssetsBuilder();
   }

   public ActivityAssets(String var1, String var2, String var3, String var4) {
      this.largeImage = var1;
      this.largeText = var2;
      this.smallImage = var3;
      this.smallText = var4;
   }

   @JsonCreator
   protected ActivityAssets() {
      this.largeImage = null;
      this.largeText = null;
      this.smallImage = null;
      this.smallText = null;
   }
}
