// Original binary: hex/api/baritone/api/utils/PathCalculationResult
package hex.api.baritone.api.utils;

import hex.api.baritone.api.pathing.calc.IPath;
import java.util.Objects;
import java.util.Optional;

// $VF: Compiled from s
public class PathCalculationResult {
   private final IPath path;
   private final PathCalculationResult.Type type;

   public PathCalculationResult(PathCalculationResult.Type var1, IPath var2) {
      Objects.requireNonNull(var1);
      this.path = var2;
      this.type = var1;
   }

   public final PathCalculationResult.Type getType() {
      return this.type;
   }

   public final Optional<IPath> getPath() {
      return Optional.ofNullable(this.path);
   }

   public PathCalculationResult(PathCalculationResult.Type var1) {
      this(var1, null);
   }

   // $VF: Compiled from s
   public enum Type {
      SUCCESS_TO_GOAL,
      SUCCESS_SEGMENT,
      FAILURE,
      CANCELLATION,
      EXCEPTION;
   }
}
