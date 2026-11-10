// Original binary: sg/ec/TwoAR2kbhzKkF77Y
package sg.ec;

// $VF: Compiled from s
public abstract class Event {
   private boolean field12064 = false;
   public EventBus.Nested10 field12065;

   public void method03208() {
      EventListener[] var1 = EventBus.method00259(this);

      for (int sx = 0; sx < var1.length; sx++) {
         var1[sx].fire(this);
      }
   }

   protected boolean method05694() {
      if (!this.field12064) {
         return false;
      }

      this.field12064 = false;
      return true;
   }

   public void method05695(boolean var1) {
      this.field12064 = var1;
   }

   public void method05696() {
      this.field12064 = true;
   }

   public boolean method05697() {
      return this.field12064;
   }

   public final boolean method05698() {
      return EventBus.method00259(this).length != 0;
   }
}
