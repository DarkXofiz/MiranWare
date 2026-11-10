// Original binary: sg/ec/VZQ5YJWx1witLq3R
package sg.ec;

import java.util.UUID;

// $VF: Compiled from s
public class PartyMember extends GlobalPlayer {
   private final PartyRole role;

   public PartyMember(String var1, PartyRole var2) {
      this(var1, var1, UUID.randomUUID().toString(), var2);
   }

   public PartyMember(String var1, String var2, PartyRole var3) {
      this(var1, var2, UUID.randomUUID().toString(), var3);
   }

   public PartyMember(String var1, String var2, String var3, PartyRole var4) {
      super(var1, var2, var3);
      this.role = var4;
   }

   public PartyMember(String var1, String var2, String var3, String var4, PartyRole var5) {
      super(var1, var2, var3, var4);
      this.role = var5;
   }

   public PartyRole method05943() {
      return this.role;
   }
}
