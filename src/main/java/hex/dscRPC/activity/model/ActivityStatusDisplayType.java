// Original binary: hex/dscRPC/activity/model/ActivityStatusDisplayType
package hex.dscRPC.activity.model;

import com.fasterxml.jackson.annotation.JsonValue;

// $VF: Compiled from s
public enum ActivityStatusDisplayType {
   APPLICATION_NAME,
   STATE,
   DETAILS;

   @JsonValue
   public int getValue() {
      return this.ordinal();
   }
}
