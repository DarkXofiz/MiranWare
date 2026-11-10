// Original binary: sg/ec/4XdFtW3obJaeWLUr
package sg.ec;

import net.minecraft.world.entity.Entity;

// $VF: Compiled from s
public class EntityOutlineColorEvent extends Event {
   public static final EntityOutlineColorEvent field02043 = new EntityOutlineColorEvent();
   private Entity field02044;
   private int field02045;

   public int method00859() {
      return this.field02045;
   }

   public void method00860(Entity var1) {
      this.field02044 = var1;
   }

   public int method00861(Entity var1, int var2) {
      this.field02044 = var1;
      this.field02045 = var2;
      super.method03208();
      return this.field02045;
   }

   public void method00862(int var1) {
      this.field02045 = var1;
   }

   public Entity method00863() {
      return this.field02044;
   }
}
