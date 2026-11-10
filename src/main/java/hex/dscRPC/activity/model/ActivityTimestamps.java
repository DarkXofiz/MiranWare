// Original binary: hex/dscRPC/activity/model/ActivityTimestamps
package hex.dscRPC.activity.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

// $VF: Compiled from s
public class ActivityTimestamps {
   @JsonProperty("start")
   private final Long start;
   @JsonProperty("end")
   private final Long end;

   public static ActivityTimestamps from(Instant var0, Instant var1) {
      return var0 == null ? null : new ActivityTimestamps(var0.toEpochMilli(), var1 != null ? var1.toEpochMilli() : null);
   }

   @JsonCreator
   public ActivityTimestamps(@JsonProperty("start") long var1, @JsonProperty("end") Long var3) {
      this.start = var1;
      this.end = var3;
   }

   public static ActivityTimestamps indefiniteFromNow() {
      return indefiniteFrom(Instant.now());
   }

   public Long end() {
      return this.end;
   }

   public Long start() {
      return this.start;
   }

   public static ActivityTimestamps indefiniteFrom(Instant var0) {
      return from(var0, null);
   }
}
