// Original binary: hex/dscRPC/activity/model/party/ActivityPartyPrivacy
package hex.dscRPC.activity.model.party;

import com.fasterxml.jackson.annotation.JsonValue;

// $VF: Compiled from s
public enum ActivityPartyPrivacy {
   PRIVATE,
   PUBLIC;

   @JsonValue
   public int toValue() {
      return this.ordinal();
   }
}
