// Original binary: hex/dscRPC/activity/model/ActivityType
package hex.dscRPC.activity.model;

import com.fasterxml.jackson.annotation.JsonValue;

// $VF: Compiled from s
public enum ActivityType {
   PLAYING(0),
   LISTENING(2),
   WATCHING(3),
   COMPETING(5);

   private final int value;

   ActivityType(int var3) {
      this.value = var3;
   }

   @JsonValue
   public int toValue() {
      return this.value;
   }
}
