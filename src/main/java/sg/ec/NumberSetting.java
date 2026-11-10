// Original binary: sg/ec/tSsS5BX2t10g9Uv6
package sg.ec;

// $VF: Compiled from s
public class NumberSetting<T extends Number> extends Setting<T> {
   private T field23972;
   private T field23973;
   private T field23974;
   private boolean field23975 = true;

   public NumberSetting<T> method10834(T var1) {
      if (this.field23974 == null) {
         this.field23974 = var1;
      }

      return this;
   }

   public NumberSetting<T> method10835(T var1) {
      if (this.field23972 == null) {
         this.field23972 = (T)(Object)var1;
      }

      return this;
   }

   public T method10836() {
      return this.field23972;
   }

   public void method10837(float var1) {
      if (this.method03015() instanceof Integer) {
         this.method03014((T)(Object)Math.round(var1));
      } else if (this.method03015() instanceof Double) {
         this.method03014((T)(Object)((double)var1));
      } else if (this.method03015() instanceof Float) {
         this.method03014((T)(Object)var1);
      } else {
         if (!(this.method03015() instanceof Long)) {
            throw new UnsupportedOperationException("Тип " + this.method03015().getClass() + " не поддерживается.");
         }

         this.method03014((T)(Object)((long)var1));
      }
   }

   public NumberSetting(String var1) {
      super(var1);
   }

   public NumberSetting<T> method10838(T var1) {
      if (this.field23973 == null) {
         this.field23973 = (T)(Object)var1;
      }

      return this;
   }

   public NumberSetting<T> method10839(boolean var1) {
      this.field23975 = var1;
      return this;
   }

   public boolean method10840() {
      return this.field23975;
   }

   public T method10841() {
      return this.field23974;
   }

   public T method10842() {
      return this.field23973;
   }
}
