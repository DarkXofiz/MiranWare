// Original binary: sg/ec/XVTjshxMsCJXkEM4
package sg.ec;

// $VF: Compiled from s
public class ClientFeaturePolicyEvent extends Event {
   public static final ClientFeaturePolicyEvent field14592 = new ClientFeaturePolicyEvent();
   private ClientFeaturePolicyEvent.Nested186 field14593;

   public ClientFeaturePolicyEvent.Nested186 method06425() {
      return this.field14593;
   }

   public boolean method06426(ClientFeaturePolicyEvent.Nested186 var1) {
      this.field14593 = var1;
      super.method03208();
      return this.method05694();
   }

   public void method06427(ClientFeaturePolicyEvent.Nested186 var1) {
      this.field14593 = var1;
   }

   // $VF: Compiled from s
   public enum Nested186 {
      INVENTORY_BUTTON,
      CHAT_COMMAND,
      CLIENT_MESSAGE,
      MAIN_MENU,
      CLIENT_CAPE,
      CHEST_SEARCH;
   }
}
