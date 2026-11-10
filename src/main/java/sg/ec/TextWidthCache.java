// Original binary: sg/ec/yoJF4Z3993TSyDkM
package sg.ec;

import java.util.LinkedHashMap;
import java.util.Map.Entry;

// $VF: Compiled from s
public final class TextWidthCache extends LinkedHashMap<String, Float> {
   private final int field26517;
   private static final float field26518 = 0.75F;

   @Override
   protected boolean removeEldestEntry(Entry<String, Float> var1) {
      return this.size() > this.field26517;
   }

   public TextWidthCache(int var1) {
      super(512, field26518, true);
      this.field26517 = var1;
   }
}
