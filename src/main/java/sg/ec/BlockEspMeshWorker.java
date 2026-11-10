// Original binary: sg/ec/0H2pOr2WG63jhVSF
package sg.ec;

import it.unimi.dsi.fastutil.longs.Long2IntOpenHashMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

// $VF: Compiled from s
public final class BlockEspMeshWorker {
   private static final ExecutorService field00095 = Executors.newSingleThreadExecutor(var0 -> {
      Thread var1 = new Thread(var0, BlockEspMeshWorker.field00099);
      var1.setDaemon(true);
      var1.setPriority(1);
      return var1;
   });
   private static final AtomicBoolean field00096 = new AtomicBoolean();
   private static final AtomicInteger field00097 = new AtomicInteger();
   private static final AtomicReference<BlockEspMesh> field00098 = new AtomicReference<>();
   private static final String field00099 = "hex-blockesp-mesh";

   public static boolean method00048(Long2IntOpenHashMap var0, double var1, double var3, double var5) {
      if (!field00096.compareAndSet(false, true)) {
         return false;
      }

      int var7 = field00097.get();
      field00095.execute(() -> {
         try {
            BlockEspMesh var8 = BlockEspMeshBuilder.method10268(var0, var1, var3, var5);
            if (var7 == field00097.get()) {
               field00098.set(var8);
            }
         } finally {
            field00096.set(false);
         }
      });
      return true;
   }

   public static BlockEspMesh method00050() {
      return field00098.getAndSet(null);
   }

   private BlockEspMeshWorker() {
   }

   public static void method00051() {
      field00097.incrementAndGet();
      field00098.set(null);
   }

   public static boolean method00052() {
      return field00098.get() != null;
   }
}
