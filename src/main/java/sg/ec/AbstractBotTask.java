// Original binary: sg/ec/CNrDn5B6Z1XLRVkh
package sg.ec;

import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

// $VF: Compiled from s
public abstract class AbstractBotTask implements BotTask {
   private static final long field06807 = 5000L;
   private final ElapsedTimer field06808 = new ElapsedTimer();
   private final Set<Integer> field06809 = ConcurrentHashMap.newKeySet();
   private volatile boolean field06810;
   private static final long field06811 = 5000L;

   @Override
   public boolean method01768(int var1) {
      return this.field06809.contains(var1);
   }

   @Override
   public boolean method02628() {
      return this.field06810 && !this.field06808.method04699(field06811);
   }

   @Override
   public void method01753(int var1) {
      this.field06809.remove(var1);
   }

   @Override
   public void method02631() {
      this.field06808.method04694();
      this.field06810 = true;
   }

   @Override
   public void method01754(int var1) {
      if (var1 >= 0) {
         this.field06809.add(var1);
      }
   }

   @Override
   public void method01763() {
      this.field06810 = false;
      this.method01757(false);
      this.method01770(0);
   }
}
