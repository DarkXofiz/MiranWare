package sg.ec;

/** 1.21.11: 26.x'teki FirstPersonHandsAndItems.mainHandHeight yerine, ItemInHandRenderer tick'inde guncellenen deger. */
public final class HandHeightTracker {
   private static volatile float mainHandHeight = 1.0F;

   private HandHeightTracker() {
   }

   public static float mainHandHeight() {
      return mainHandHeight;
   }

   public static void update(float value) {
      mainHandHeight = value;
   }
}
