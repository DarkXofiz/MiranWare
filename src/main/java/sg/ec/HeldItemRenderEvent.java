// Original binary: sg/ec/1cz0guW7p2LVUCcD
package sg.ec;

import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class HeldItemRenderEvent extends Event {
   public static final HeldItemRenderEvent field00682 = new HeldItemRenderEvent();
   private HeldItemRenderEvent.Nested13 field00683;
   private int field00684;
   private int field00685;
   private Player field00686;
   private LivingEntity field00687;
   private HumanoidArm field00688;
   private ItemStack field00689;
   private ItemStack field00690;

   public ItemStack method00308(LivingEntity var1, HumanoidArm var2, ItemStack var3) {
      if (!this.method05698()) {
         return var3 == null ? ItemStack.EMPTY : var3;
      }

      this.field00683 = HeldItemRenderEvent.Nested13.STACK_IN_ARM;
      this.field00686 = null;
      this.field00687 = var1;
      this.field00688 = var2;
      this.field00689 = var3 == null ? ItemStack.EMPTY : var3;
      this.field00690 = this.field00689;
      super.method03208();
      return this.field00690;
   }

   public int method00309(int var1) {
      if (!this.method05698()) {
         return var1;
      }

      this.field00683 = HeldItemRenderEvent.Nested13.SELECTED_SLOT;
      this.field00684 = var1;
      this.field00685 = var1;
      this.field00689 = ItemStack.EMPTY;
      this.field00690 = ItemStack.EMPTY;
      super.method03208();
      return this.field00685;
   }

   public void method00310(ItemStack var1) {
      this.field00689 = var1;
   }

   public void method00311(Player var1) {
      this.field00686 = var1;
   }

   public LivingEntity method00312() {
      return this.field00687;
   }

   public HumanoidArm method00313() {
      return this.field00688;
   }

   public ItemStack method00314() {
      return this.field00689;
   }

   public int method00315() {
      return this.field00685;
   }

   public ItemStack method00316(Player var1, ItemStack var2) {
      if (!this.method05698()) {
         return var2 == null ? ItemStack.EMPTY : var2;
      }

      this.field00683 = HeldItemRenderEvent.Nested13.MAIN_HAND_STACK;
      this.field00686 = var1;
      this.field00689 = var2 == null ? ItemStack.EMPTY : var2;
      this.field00690 = this.field00689;
      super.method03208();
      return this.field00690;
   }

   public void method00317(HumanoidArm var1) {
      this.field00688 = var1;
   }

   public void method00318(HeldItemRenderEvent.Nested13 var1) {
      this.field00683 = var1;
   }

   public HeldItemRenderEvent.Nested13 method00319() {
      return this.field00683;
   }

   public void method00320(ItemStack var1) {
      this.field00690 = var1;
   }

   public void method00321(int var1) {
      this.field00684 = var1;
   }

   public void method00322(LivingEntity var1) {
      this.field00687 = var1;
   }

   public Player method00323() {
      return this.field00686;
   }

   public int method00324() {
      return this.field00684;
   }

   public void method00325(int var1) {
      this.field00685 = var1;
   }

   public ItemStack method00326() {
      return this.field00690;
   }

   // $VF: Compiled from s
   public enum Nested13 {
      SELECTED_SLOT,
      MAIN_HAND_STACK,
      STACK_IN_ARM;
   }
}
