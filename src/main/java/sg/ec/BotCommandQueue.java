// Original binary: sg/ec/8HDUO1uqhLBrnqNS
package sg.ec;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.network.protocol.game.ServerboundCommandSuggestionPacket;

// $VF: Compiled from s
final class BotCommandQueue {
   private static final int field04562 = 8;
   private static final int field04563 = 0;
   private static final long field04564 = 0;
   private static final long field04565 = 0;
   private static final long field04566 = 0;
   private static final long field04567 = 0;
   private final BotClient field04568;
   private final Deque<String> field04569 = new ArrayDeque<>();
   private String field04570;
   private int field04571;
   private int field04572;
   private long field04573;
   private static final String field04574 = "/";
   private static final long field04575 = 15L;
   private static final long field04576 = 45L;
   private static final long field04577 = 45L;
   private static final long field04578 = 95L;

   boolean method01886() {
      return this.field04570 != null;
   }

   private static long method01887(long var0, long var2) {
      return ThreadLocalRandom.current().nextLong(var0, var2 + 1L);
   }

   void method01888() {
      this.field04569.clear();
      this.field04570 = null;
   }

   void method01889(long var1) {
      if (this.field04570 == null) {
         this.field04570 = this.field04569.pollFirst();
         if (this.field04570 == null) {
            return;
         }

         this.field04571 = 2;
         this.field04573 = var1;
      }

      if (var1 >= this.field04573) {
         String var3 = "/" + this.field04570;
         if (this.field04571 <= var3.length()) {
            this.field04568.method00164(new ServerboundCommandSuggestionPacket(++this.field04572, var3.substring(0, this.field04571)));
            this.field04571++;
            this.field04573 = var1 + method01887(field04575, field04576);
         } else if (this.field04571 == var3.length() + 1) {
            this.field04571++;
            this.field04573 = var1 + method01887(field04577, field04578);
         } else {
            this.field04568.method00144(var3);
            this.field04570 = null;
         }
      }
   }

   BotCommandQueue(BotClient var1) {
      this.field04568 = var1;
   }

   void method01890(String var1) {
      if (var1 != null && !var1.isBlank() && this.field04569.size() < 8) {
         String var2 = var1.trim();
         this.field04569.addLast(var2.startsWith(field04574) ? var2.substring(1) : var2);
      }
   }
}
