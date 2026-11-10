// Original binary: sg/ec/Ni5iI8RrTvXVPwgJ
package sg.ec;

import hex.script.api.Party;
import hex.script.api.Waypoints;
import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public final class ScriptSocialAdapter implements MinecraftAccess {
   private final Waypoints field10299 = new Waypoints(this::method04716, this::method04723, this::method04719);
   private final Party field10300 = new Party(this::method04718, this::method04721, this::method04720);
   private static final long field10301 = 50L;

   private String method04713(String var1) {
      return var1 == null ? "" : var1;
   }

   private sg.ec.Party method04714() {
      try {
         return MiranWare.getInstance().getClient() == null ? null : MiranWare.getInstance().getClient().getManager().method01805();
      } catch (Throwable var2) {
         return null;
      }
   }

   Waypoints method04715() {
      return this.field10299;
   }

   private void method04716(String var1, double var2, double var4, double var6, long var8) {
      if (var1 != null && !var1.isEmpty()) {
         if (var8 > 0L) {
            WaypointManager.INSTANCE.method09831((float)var2, (float)var4, (float)var6, var1, var8 * field10301);
         } else {
            WaypointManager.INSTANCE.method09832((float)var2, (float)var4, (float)var6, var1);
         }
      }
   }

   private void method04717(List<Object> var1, List<Waypoint> var2) {
      if (var2 != null) {
         for (Waypoint var4 : var2) {
            var1.add(var4.method11262());
            var1.add((double)var4.method11264());
            var1.add((double)var4.method11260());
            var1.add((double)var4.method11269());
            var1.add(!var4.method11268());
         }
      }
   }

   private boolean method04718(int var1) {
      if (var1 == 1) {
         return this.method04714() != null;
      }

      try {
         return MiranWare.getInstance().getClient() != null;
      } catch (Throwable var3) {
         return false;
      }
   }

   private Object[] method04719() {
      ArrayList var1 = new ArrayList();
      this.method04717(var1, WaypointManager.INSTANCE.method09837());
      this.method04717(var1, WaypointManager.INSTANCE.method09838());
      return var1.toArray();
   }

   private String[] method04720() {
      sg.ec.Party var1 = this.method04714();
      if (var1 == null) {
         return new String[0];
      }

      ArrayList var2 = new ArrayList();

      for (PartyMember var4 : var1.method10148()) {
         var2.add(this.method04713(var4.method07586()));
         var2.add(this.method04713(var4.method07580()));
         var2.add(var4.method05943() == null ? "" : String.valueOf(var4.method05943()));
      }

      return (String[]) var2.toArray(new String[0]);
   }

   private String method04721() {
      sg.ec.Party var1 = this.method04714();
      return var1 != null && var1.method10149() != null ? var1.method10149() : "";
   }

   Party method04722() {
      return this.field10300;
   }

   private int method04723(String var1) {
      return var1 != null && !var1.isEmpty() ? WaypointManager.INSTANCE.method09834(var1) : 0;
   }
}
