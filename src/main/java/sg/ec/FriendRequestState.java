// Original binary: sg/ec/Q2C8DYiXlUwQlLCZ
package sg.ec;

// $VF: Compiled from s
public final class FriendRequestState {
   public static final FriendRequestState field11201 = new FriendRequestState();
   public boolean field11202 = false;
   public boolean field11203 = true;
   public FriendRequestState.Nested155 field11204 = FriendRequestState.Nested155.ONLINE;
   public boolean field11205 = true;
   public boolean field11206 = true;
   public boolean field11207 = true;

   private FriendRequestState() {
   }

   // $VF: Compiled from s
   public enum Nested155 {
      ONLINE("Онлайн"),
      AFK("АФК"),
      OFFLINE("Оффлайн");

      public final String field11208;

      Nested155(String var3) {
         this.field11208 = var3;
      }
   }
}
