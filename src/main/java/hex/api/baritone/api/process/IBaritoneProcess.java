// Original binary: hex/api/baritone/api/process/IBaritoneProcess
package hex.api.baritone.api.process;

// $VF: Compiled from s
public interface IBaritoneProcess {
   double DEFAULT_PRIORITY = -1.0;

   boolean isTemporary();

   String displayName0();

   default String displayName() {
      return !this.isActive() ? "INACTIVE" : this.displayName0();
   }

   boolean isActive();

   default double priority() {
      return -1.0;
   }

   PathingCommand onTick(boolean var1, boolean var2);

   void onLostControl();
}
