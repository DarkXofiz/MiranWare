// Original binary: sg/ec/9eOznX6tMR2oPwc1
package sg.ec;

import java.util.Arrays;

// $VF: Compiled from s
public enum DeferredCloudDataLoader implements MinecraftAccess {
   INSTANCE;

   private volatile byte[] field05462;
   private volatile boolean field05463;

   public void method02274(byte[] var1) {
      if (var1 != null && var1.length != 0) {
         this.field05462 = var1;
         this.method02276();
      }
   }

   public boolean method02275() {
      return this.field05462 != null;
   }

   private synchronized void method02276() {
      if (!this.field05463) {
         EventBus.method00263(this);
         this.field05463 = true;
      }
   }

   @Subscribe
   private void method02277(TickEvent var1) {
      byte[] var2 = this.field05462;
      if (var2 != null) {
         this.field05462 = null;
         this.method02278(var2);
      }
   }

   private void method02278(byte[] var1) {
      try {
         ModuleConfigStorage.method04450(var1);
      } finally {
         Arrays.fill(var1, (byte)0);
      }
   }
}
