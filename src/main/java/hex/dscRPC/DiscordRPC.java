// Original binary: hex/dscRPC/DiscordRPC
package hex.dscRPC;

import hex.dscRPC.activity.model.Activity;
import hex.dscRPC.exception.JDiscordIPCException;
import hex.dscRPC.modern.socket.ModernSystemSocketFactory;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

// $VF: Compiled from s
public final class DiscordRPC {
   private static final boolean DISABLED = false;
   private static final long CLIENT_ID = 1433582111310217276L;
   private static final BlockingQueue<Runnable> TASKS = new LinkedBlockingQueue<>();
   private static final AtomicInteger PENDING_UPDATES = new AtomicInteger();
   private static volatile Thread worker;
   private static JDiscordIPC ipc;
   private static final String бУС = "бУС";
   private static final long бУъ = 0;

   private DiscordRPC() {
   }

   public static void stop() {
      ensureWorker();
      TASKS.add(DiscordRPC::disconnect);
   }

   private static void connect() {
      if (ipc == null) {
         JDiscordIPC var0 = JDiscordIPC.builder(бУъ).systemSocketFactory(new ModernSystemSocketFactory()).build();

         try {
            var0.connect();
         } catch (JDiscordIPCException.DiscordClientUnavailableException sx) {
            return;
         }

         ipc = var0;
      }
   }

   public static void update(Activity var0) {
      ensureWorker();
      PENDING_UPDATES.incrementAndGet();
      TASKS.add(() -> {
         if (PENDING_UPDATES.decrementAndGet() <= 0) {
            if (ipc != null) {
               ipc.updateActivity(var0);
            }
         }
      });
   }


   private static void disconnect() {
      if (ipc != null) {
         ipc.updateActivity(null);
         ipc.disconnect();
         ipc = null;
      }
   }

   private static void runTasks() {
      while (true) {
         Runnable var0;
         try {
            var0 = TASKS.take();
         } catch (InterruptedException sx) {
            return;
         }

         try {
            var0.run();
         } catch (Throwable var2) {
         }
      }
   }

   private static synchronized void ensureWorker() {
      if (worker == null) {
         Thread var0 = new Thread(DiscordRPC::runTasks, бУС);
         var0.setDaemon(true);
         var0.start();
         worker = var0;
      }
   }

   public static void start() {
      ensureWorker();
      TASKS.add(DiscordRPC::connect);
   }
}
