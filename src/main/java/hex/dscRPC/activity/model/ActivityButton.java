// Original binary: hex/dscRPC/activity/model/ActivityButton
package hex.dscRPC.activity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator.Mode;

// $VF: Compiled from s
public class ActivityButton {
   @JsonProperty("label")
   private final String label;
   @JsonProperty("url")
   private final String url;

   public ActivityButton(String var1, String var2) {
      this.label = var1;
      this.url = var2;
   }

   @JsonCreator(mode = Mode.DELEGATING)
   static ActivityButton fromLabel(String var0) {
      return new ActivityButton(var0, null);
   }
}
