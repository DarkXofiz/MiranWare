// Original binary: sg/ec/iTkYtgc09JAQ02so
package sg.ec;

import net.minecraft.world.item.ItemStack;

// $VF: Compiled from s
public class Notification {
   private String field20050;
   private ItemStack field20051;
   private AnimationUtils field20052;
   private long field20053;
   private long field20054;
   private NotificationType field20055;
   private float field20056 = 0.0F;
   private volatile boolean field20057 = false;
   private static final long field20058 = 200L;
   private static final long field20059 = 200L;

   public void method08795(float var1) {
      this.field20056 = var1;
   }

   public void method08796(AnimationUtils var1) {
      this.field20052 = var1;
   }

   public ItemStack method08797() {
      return this.field20051;
   }

   public boolean method08798(long var1) {
      return !this.field20057 && var1 - this.field20054 < this.field20053;
   }

   public void method08799(ItemStack var1) {
      this.field20051 = var1;
   }

   public Notification(String var1, long var2, NotificationType var4) {
      this.field20050 = var1;
      this.field20053 = var2;
      this.field20055 = var4;
      this.field20054 = System.currentTimeMillis();
      this.field20052 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field20058);
   }

   public String method08800() {
      return this.field20050;
   }

   public AnimationUtils method08801() {
      return this.field20052;
   }

   public void method08802(long var1) {
      this.field20054 = var1;
   }

   public void method08803(String var1) {
      this.field20050 = var1;
   }

   public float method08804() {
      return this.field20056;
   }

   public void method08805(boolean var1) {
      this.field20057 = var1;
   }

   public void method08806(long var1) {
      this.field20053 = var1;
   }

   public Notification(String var1, long var2, ItemStack var4) {
      this.field20050 = var1;
      this.field20053 = var2;
      this.field20051 = var4;
      this.field20054 = System.currentTimeMillis();
      this.field20052 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field20059);
   }

   public long method08807() {
      return this.field20053;
   }

   public void method08808(NotificationType var1) {
      this.field20055 = var1;
   }

   public long method08809() {
      return this.field20054;
   }

   public boolean method08810(long var1) {
      return this.field20057 || var1 - this.field20054 > this.field20053;
   }

   public NotificationType method08811() {
      return this.field20055;
   }

   public boolean method08812() {
      return this.field20057;
   }
}
