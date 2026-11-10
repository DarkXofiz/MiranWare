// Original binary: sg/ec/ZQaOuDd8qGDe76dD
package sg.ec;

// $VF: Compiled from s
public enum KeyFinderPhase {
   IDLE,
   ENABLE_FLY(4000L),
   TAKE_OFF(40000L),
   TRAVEL,
   LAND(60000L),
   ALIGN(6000L),
   WAIT_SETHOME(1500L),
   APPROACH(90000L),
   REGEN,
   OPEN(4000L),
   LOOT(15000L),
   RETREAT(10000L),
   BREAK(15000L),
   WAIT_HOME(8000L),
   SPAWN(10000L),
   EC_OPEN(6000L),
   EC_DEPOSIT(15000L),
   HEAL(2000L),
   RTP(20000L),
   DONE;

   private final long field15476;

   KeyFinderPhase() {
      this(0L);
   }

   KeyFinderPhase(long var3) {
      this.field15476 = var3;
   }

   public boolean method06862() {
      return this.field15476 > 0L;
   }

   public long method06863() {
      return this.field15476;
   }
}
