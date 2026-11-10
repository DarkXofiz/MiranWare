// Original binary: sg/ec/CnCRyRTsaJon0uoO
package sg.ec;

import java.util.function.Supplier;

// $VF: Compiled from s
public abstract class Setting<T> {
   private final String field06833;
   private String field06834;
   private String field06835 = "";
   private SettingsContainer field06836;
   private T field06837;
   private T field06838;
   private Supplier<Boolean> field06839 = () -> true;

   public String method03008() {
      return this.field06834 != null && !this.field06834.isEmpty() ? this.field06834 : this.field06833;
   }

   public Setting(String var1) {
      this.field06836 = this.field06836;
      this.field06833 = var1;
   }

   public void method00869() {
      if (this.field06838 != null) {
         this.method03014(this.field06838);
      }
   }

   public String method03009() {
      return this.field06834;
   }

   protected void method03010(T var1) {
      this.field06838 = (T)(Object)var1;
   }

   public SettingsContainer method03011() {
      return this.field06836;
   }

   public String method03012() {
      return this.field06835;
   }

   public Supplier<Boolean> method03013() {
      return this.field06839;
   }

   public <S extends Setting<T>> S method03014(T var1) {
      if (var1 == null) {
         return (S)this;
      }

      this.method00870((T)(Object)var1);
      return (S)this;
   }

   public T method03015() {
      return this.field06838;
   }

   public <S extends Setting<T>> S method03016(String var1) {
      this.field06834 = var1;
      return (S)this;
   }

   protected void method00870(T var1) {
      this.field06837 = (T)(Object)var1;
   }

   public <S extends Setting<T>> S method03017(T var1) {
      if (var1 != null && this.field06838 == null) {
         this.method03010((T)(Object)var1);
         this.method00870((T)(Object)var1);
         return (S)this;
      } else {
         return (S)this;
      }
   }

   public <S extends Setting<T>> S method03018(String var1) {
      this.field06835 = var1;
      return (S)this;
   }

   public boolean method03019() {
      return this.field06839.get();
   }

   public void method03020(String var1) {
      this.field06834 = var1;
   }

   public T method03022() {
      return this.field06837;
   }

   public <S extends Setting<T>> S method03023(SettingsContainer var1) {
      if (var1 != null && this.field06836 == null) {
         this.field06836 = var1;
         this.field06836.method03026().add(this);
         return (S)this;
      } else {
         return (S)this;
      }
   }

   public String method03024() {
      return this.field06833;
   }

   public <S extends Setting<T>> S method03025(Supplier<Boolean> var1) {
      this.field06839 = var1;
      return (S)this;
   }
}
