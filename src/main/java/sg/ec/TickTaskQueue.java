// Original binary: sg/ec/s5p1TqGQv7rc1ylN
package sg.ec;

import java.util.function.BooleanSupplier;

// $VF: Compiled from s
public class TickTaskQueue {
   private final ElapsedTimer field23552 = new ElapsedTimer();
   private final SortableArrayList<TickTaskQueue.Nested309> field23553 = new SortableArrayList<>();
   private final SortableArrayList<TickTaskQueue.Nested305> field23554 = new SortableArrayList<>();
   private int field23555;
   private int field23556;
   private boolean field23557;
   private TickTaskQueue.Nested306 field23558 = new TickTaskQueue.Nested304(1);

   public int method10550() {
      return this.field23555;
   }

   public TickTaskQueue method10551(int var1, TickTaskQueue.Nested308 var2) {
      return this.method10561(var1, var2, () -> true, 0);
   }

   public SortableArrayList<TickTaskQueue.Nested305> method10552() {
      return this.field23554;
   }

   public void method10553() {
      if ((!this.field23553.isEmpty() || !this.field23554.isEmpty()) && !this.field23557) {
         this.method10572();
         this.method10564();
         this.field23555 = Math.min(this.field23555, this.field23553.size());
         this.field23556 = Math.min(this.field23556, this.field23554.size());
      }
   }

   public void method10555(int var1) {
      this.field23555 = var1;
   }

   public ElapsedTimer method10556() {
      return this.field23552;
   }

   public boolean method10557() {
      return this.field23553.isEmpty() && this.field23554.isEmpty()
         ? !this.field23557
         : this.field23555 >= this.field23553.size() && this.field23556 >= this.field23554.size() && !this.field23557 && this.field23558.method10583();
   }

   public TickTaskQueue method10560(int var1, TickTaskQueue.Nested308 var2, BooleanSupplier var3) {
      return this.method10561(var1, var2, var3, 0);
   }

   public TickTaskQueue method10561(int var1, TickTaskQueue.Nested308 var2, BooleanSupplier var3, int var4) {
      this.field23554.add(new TickTaskQueue.Nested305(var1, var2, var3, var4));
      this.field23554.method00235(var0 -> -var0.method10596());
      return this;
   }

   public boolean method10562() {
      return this.field23557;
   }

   public TickTaskQueue method10563(TickTaskQueue.Nested306 var1) {
      this.field23558 = var1;
      return this;
   }

   private void method10564() {
      if (this.field23556 < this.field23554.size()) {
         TickTaskQueue.Nested305 var1 = this.field23554.get(this.field23556);
         if (var1.method10585().getAsBoolean()) {
            if (var1.method10586() > 0) {
               var1.method10590();
            }

            if (var1.method10586() <= 0) {
               var1.method10588().method10597();
               this.field23556++;
               if (this.field23558.method10584(this.field23556, this.field23554.size())) {
                  this.method10578();
                  this.field23558.method10582();
               }
            }
         }
      }
   }

   public TickTaskQueue.Nested306 method10565() {
      return this.field23558;
   }

   public void method10566() {
      this.field23552.method04694();
   }

   public TickTaskQueue method10568(int var1, TickTaskQueue.Nested308 var2, int var3) {
      return this.method10575(var1, var2, () -> true, var3);
   }

   public TickTaskQueue method10569() {
      this.field23553.clear();
      this.field23554.clear();
      this.field23557 = false;
      this.method10566();
      this.method10578();
      return this;
   }

   public TickTaskQueue method10570(int var1, TickTaskQueue.Nested308 var2) {
      return this.method10575(var1, var2, () -> true, 0);
   }

   private void method10572() {
      if (this.field23555 < this.field23553.size()) {
         TickTaskQueue.Nested309 var1 = this.field23553.get(this.field23555);
         if (var1.method10599().getAsBoolean()) {
            if (this.field23552.method04690(var1.method10601())) {
               var1.method10598().method10597();
               this.field23555++;
               this.method10566();
               if (this.field23558.method10584(this.field23555, this.field23553.size())) {
                  this.method10578();
                  this.field23558.method10582();
               }
            }
         }
      }
   }

   public SortableArrayList<TickTaskQueue.Nested309> method10573() {
      return this.field23553;
   }

   public void method10574(int var1) {
      this.field23556 = var1;
   }

   public TickTaskQueue method10575(int var1, TickTaskQueue.Nested308 var2, BooleanSupplier var3, int var4) {
      this.field23553.add(new TickTaskQueue.Nested309(var1, var2, var3, var4));
      this.field23553.method00235(var0 -> -var0.method10603());
      return this;
   }

   public TickTaskQueue method10577(int var1, TickTaskQueue.Nested308 var2, int var3) {
      return this.method10561(var1, var2, () -> true, var3);
   }

   public void method10578() {
      this.field23555 = 0;
      this.field23556 = 0;
      this.field23554.forEach(TickTaskQueue.Nested305::method10593);
   }

   public TickTaskQueue() {
      this.method10569();
   }

   public int method10579() {
      return this.field23556;
   }

   public void method10580(boolean var1) {
      this.field23557 = var1;
   }

   public TickTaskQueue method10581(int var1, TickTaskQueue.Nested308 var2, BooleanSupplier var3) {
      return this.method10575(var1, var2, var3, 0);
   }

   // $VF: Compiled from s
   public static class Nested304 implements TickTaskQueue.Nested306 {
      private final int field23559;
      private int field23560;

      @Override
      public void method10582() {
         this.field23560++;
      }

      @Override
      public boolean method10583() {
         return this.field23560 >= this.field23559;
      }

      @Override
      public boolean method10584(int var1, int var2) {
         return var1 >= var2 && this.field23560 < this.field23559;
      }

      public Nested304(int var1) {
         this.field23559 = var1 - 1;
      }
   }

   // $VF: Compiled from s
   public static final class Nested305 implements Comparable<TickTaskQueue.Nested305> {
      private final int field23561;
      private int field23562;
      private TickTaskQueue.Nested308 field23563;
      private BooleanSupplier field23564;
      private int field23565;

      public BooleanSupplier method10585() {
         return this.field23564;
      }

      public int method10586() {
         return this.field23562;
      }

      @Override
      public int compareTo(TickTaskQueue.Nested305 var1) {
         return this.method10587(var1);
      }

      public int method10587(TickTaskQueue.Nested305 var1) {
         return Integer.compare(var1.method10596(), this.method10596());
      }

      public TickTaskQueue.Nested308 method10588() {
         return this.field23563;
      }

      public TickTaskQueue.Nested305 method10589(BooleanSupplier var1) {
         this.field23564 = var1;
         return this;
      }

      public void method10590() {
         this.field23562--;
      }

      public Nested305(int var1, TickTaskQueue.Nested308 var2, BooleanSupplier var3, int var4) {
         this.field23561 = Math.max(0, var1);
         this.field23562 = this.field23561;
         this.field23563 = var2;
         this.field23564 = var3;
         this.field23565 = var4;
      }

      public TickTaskQueue.Nested305 method10591(TickTaskQueue.Nested308 var1) {
         this.field23563 = var1;
         return this;
      }

      public TickTaskQueue.Nested305 method10592(int var1) {
         this.field23565 = var1;
         return this;
      }

      public void method10593() {
         this.field23562 = this.field23561;
      }

      public int method10594() {
         return this.field23561;
      }

      public TickTaskQueue.Nested305 method10595(int var1) {
         this.field23562 = var1;
         return this;
      }

      public int method10596() {
         return this.field23565;
      }
   }

   // $VF: Compiled from s
   public interface Nested306 {
      boolean method10584(int var1, int var2);

      void method10582();

      boolean method10583();
   }

   // $VF: Compiled from s
   public static class Nested307 implements TickTaskQueue.Nested306 {
      @Override
      public void method10582() {
      }

      @Override
      public boolean method10583() {
         return false;
      }

      @Override
      public boolean method10584(int var1, int var2) {
         return var1 >= var2;
      }
   }

   // $VF: Compiled from s
   @FunctionalInterface
   public interface Nested308 {
      void method10597();
   }

   // $VF: Compiled from s
   public static final class Nested309 implements Comparable<TickTaskQueue.Nested309> {
      private int field23566;
      private TickTaskQueue.Nested308 field23567;
      private BooleanSupplier field23568;
      private int field23569;

      public TickTaskQueue.Nested308 method10598() {
         return this.field23567;
      }

      public BooleanSupplier method10599() {
         return this.field23568;
      }

      public TickTaskQueue.Nested309 method10600(TickTaskQueue.Nested308 var1) {
         this.field23567 = var1;
         return this;
      }

      public int method10601() {
         return this.field23566;
      }

      @Override
      public int compareTo(TickTaskQueue.Nested309 var1) {
         return this.method10602(var1);
      }

      public int method10602(TickTaskQueue.Nested309 var1) {
         return Integer.compare(var1.method10603(), this.method10603());
      }

      public int method10603() {
         return this.field23569;
      }

      public TickTaskQueue.Nested309 method10604(int var1) {
         this.field23566 = var1;
         return this;
      }

      public TickTaskQueue.Nested309 method10605(int var1) {
         this.field23569 = var1;
         return this;
      }

      public TickTaskQueue.Nested309 method10606(BooleanSupplier var1) {
         this.field23568 = var1;
         return this;
      }

      public Nested309(int var1, TickTaskQueue.Nested308 var2, BooleanSupplier var3, int var4) {
         this.field23566 = var1;
         this.field23567 = var2;
         this.field23568 = var3;
         this.field23569 = var4;
      }
   }
}
