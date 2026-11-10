// Original binary: sg/ec/tyFBSlHqnvKf1fi0
package sg.ec;

import java.util.EnumSet;
import java.util.Set;

// $VF: Compiled from s
public interface AuraRotationStrategy extends MinecraftAccess {
   void method02266(AuraRotationController.Nested160 var1, AuraRotationController.Nested161 var2);

   default Set<AuraRotationUpdateMode> method02264() {
      return EnumSet.of(AuraRotationUpdateMode.RENDER);
   }

   default Rotation method02265(AttackAura var1) {
      return null;
   }

   default void method07070(boolean var1) {
   }

   default void method02268() {
   }

   default void method07066() {
   }

   String method02258();
}
