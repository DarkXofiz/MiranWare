// Original binary: sg/ec/BJkfkYH9RbWdpHsT
package sg.ec;

import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public class ActionListSetting extends Setting<List<NamedOption<Runnable>>> {
   public ActionListSetting(String var1) {
      super(var1);
      this.method03014(new ArrayList<>());
   }

   public ActionListSetting method02723(String var1, Runnable var2) {
      this.method03022().add(NamedOption.method08077(var1, var2));
      return this;
   }
}
