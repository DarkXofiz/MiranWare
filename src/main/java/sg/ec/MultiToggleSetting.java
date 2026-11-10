// Original binary: sg/ec/MEOzoJQACGBd7zpj
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

// $VF: Compiled from s
public class MultiToggleSetting extends Setting<List<NamedOption<Boolean>>> {
   private int field10041 = 0;
   private final Map<String, NamedOption<Boolean>> field10042 = new HashMap<>();

   @Override
   public void method00869() {
      for (NamedOption var2 : this.method03022()) {
         var2.method08078();
      }
   }

   public int method04514() {
      int var1 = 0;

      for (NamedOption var3 : this.method03022()) {
         if (Boolean.TRUE.equals(var3.method08074())) {
            var1++;
         }
      }

      return var1;
   }

   public Map<String, NamedOption<Boolean>> method04515() {
      return this.field10042;
   }

   public <S extends Setting<List<NamedOption<Boolean>>>> S method04516(List<NamedOption<Boolean>> var1) {
      if (this.method03015() == null && this.method03022() == null) {
         return super.method03017(var1);
      } else {
         throw new UnsupportedOperationException("Default value not supported for MultiSelecting (" + this.getClass().getName() + ")");
      }
   }

   public MultiToggleSetting method04517(NamedOption<Boolean> var1) {
      this.method03022().add(var1);
      this.field10042.put(var1.method08080(), var1);
      return this;
   }

   public <S extends Setting<List<NamedOption<Boolean>>>> S method04518(List<NamedOption<Boolean>> var1) {
      if (this.method03022() != null) {
         throw new UnsupportedOperationException("Setting the value is not supported for not supported for MultiSelecting (" + this.getClass().getName() + ")");
      } else {
         return super.method03014(var1);
      }
   }

   public boolean method04519(String var1, boolean var2) {
      NamedOption var3 = this.field10042.get(var1);
      if (var3 == null) {
         return false;
      }

      var3.method08073(var2);
      return true;
   }

   public MultiToggleSetting(String var1) {
      super(var1);
      this.method04518(new ArrayList<>());
   }

   public boolean method04520(String var1) {
      NamedOption var2 = this.field10042.get(var1);
      return var2 == null ? false : Boolean.TRUE.equals(var2.method08074());
   }

   public MultiToggleSetting method04521(int var1) {
      this.field10041 = Math.max(0, var1);
      return this;
   }

   public int method04522() {
      return this.field10041;
   }

   public Optional<NamedOption<Boolean>> method04523(String var1) {
      return Optional.ofNullable(this.field10042.get(var1));
   }
}
