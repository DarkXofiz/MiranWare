// Original binary: sg/ec/IE4vZ7hos3b3dU7c
package sg.ec;

// $VF: Compiled from s
public abstract class ParticleEmitter {
   private boolean field08677;

   protected abstract void method03743(ClientParticleManager var1);

   public final boolean method03861() {
      return !this.field08677;
   }

   public final void method03862(ClientParticleManager var1) {
      if (!this.field08677 && var1 != null) {
         try {
            this.method03743(var1);
         } catch (Throwable var3) {
            this.method03863();
         }
      }
   }

   public final void method03863() {
      this.field08677 = true;
   }
}
