// Original binary: sg/ec/puOawXgJ4tdefVwx
package sg.ec;

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.function.Predicate;

// $VF: Compiled from s
public class Party {
   private final String name;
   private final Set<PartyMember> players = new CopyOnWriteArraySet<>();

   public Set<PartyMember> method10148() {
      return this.players;
   }

   public String method10149() {
      return this.name;
   }

   public Party(String var1) {
      this.name = var1;
   }

   public static boolean method10150(PartyMember var0) {
      return SocialStateUtils.method10613(var0);
   }

   public PartyMember method10151(Predicate<PartyMember> var1) {
      for (PartyMember var3 : this.players) {
         if (var1.test(var3)) {
            return var3;
         }
      }

      return null;
   }

   public static boolean method10152(PartyMember var0) {
      if (var0 == null) {
         return false;
      } else {
         return MiranWare.getInit().getClient() != null && var0.method07566(MiranWare.getInit().getClient().getClientPlayer()) ? true : method10150(var0);
      }
   }
}
