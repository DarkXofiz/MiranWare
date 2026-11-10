// Original binary: sg/ec/e3t6Jqj500X9hfe3
package sg.ec;

import java.util.Objects;
import java.util.UUID;

// $VF: Compiled from s
public class GlobalPlayer {
   private String username;
   private String clientUsername;
   private String uuid;
   private String clientType;
   private final MutableVector3f position = new MutableVector3f(0.0F, 0.0F, 0.0F);
   private transient MutableVector3f prevPosition = new MutableVector3f(0.0F, 0.0F, 0.0F);
   private transient MutableVector3f targetPosition;
   private transient MutableVector3f lerpStartPosition;
   private transient boolean interpolationInitialized;
   private transient int lerpSteps;
   private transient int lerpStep;
   private transient String lastSentUsername;
   private transient String lastSentClientUsername;
   private transient String lastSentClientType;
   private transient float lastSentX;
   private transient float lastSentY;
   private transient float lastSentZ;
   private transient long lastSentPositionAt;
   private transient boolean lastSentInitialized;
   private static final String field18468 = "UNKNOWN";
   private static final String field18469 = "UNKNOWN";
   private static final String field18470 = "UNKNOWN";

   public String method07565() {
      return this.lastSentUsername;
   }

   public GlobalPlayer(String var1, String var2, String var3, String var4) {
      this.username = var1;
      this.clientUsername = var2;
      this.uuid = var3;
      this.clientType = var4;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof GlobalPlayer var2)) {
         return false;
      } else {
         if (!var2.method07598(this)) {
            return false;
         }

         String var3 = this.method07586();
         String var4 = var2.method07586();
         if (var3 == null ? var4 == null : var3.equals(var4)) {
            String var5 = this.method07580();
            String var6 = var2.method07580();
            if (var5 == null ? var6 == null : var5.equals(var6)) {
               String var7 = this.method07590();
               String var8 = var2.method07590();
               if (var7 == null ? var8 == null : var7.equals(var8)) {
                  String var9 = this.method07584();
                  String var10 = var2.method07584();
                  if (var9 == null ? var10 == null : var9.equals(var10)) {
                     MutableVector3f var11 = this.method07582();
                     MutableVector3f var12 = var2.method07582();
                     return var11 == null ? var12 == null : var11.equals(var12);
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         } else {
            return false;
         }
      }
   }

   public boolean method07566(GlobalPlayer var1) {
      return var1 != null && var1.method07590() != null && this.uuid != null ? this.uuid.equalsIgnoreCase(var1.method07590()) : false;
   }

   public void method07567(String var1) {
      this.clientUsername = var1;
   }

   public void method07568(String var1) {
      this.username = var1;
   }

   @Override
   public String toString() {
      return "Player(username="
         + this.method07586()
         + ", clientUsername="
         + this.method07580()
         + ", uuid="
         + this.method07590()
         + ", clientType="
         + this.method07584()
         + ", position="
         + this.method07582()
         + ", prevPosition="
         + this.method07607()
         + ", targetPosition="
         + this.method07579()
         + ", lerpStartPosition="
         + this.method07594()
         + ", interpolationInitialized="
         + this.method07609()
         + ", lerpSteps="
         + this.method07587()
         + ", lerpStep="
         + this.method07600()
         + ", lastSentUsername="
         + this.method07565()
         + ", lastSentClientUsername="
         + this.method07588()
         + ", lastSentClientType="
         + this.method07575()
         + ", lastSentX="
         + this.method07589()
         + ", lastSentY="
         + this.method07592()
         + ", lastSentZ="
         + this.method07574()
         + ", lastSentPositionAt="
         + this.method07602()
         + ", lastSentInitialized="
         + this.method07610()
         + ")";
   }

   public void method07569(long var1) {
      this.lastSentPositionAt = var1;
   }

   public boolean method07570() {
      return !this.lastSentInitialized
         ? true
         : this.position.field03984 != this.lastSentX || this.position.field03985 != this.lastSentY || this.position.field03986 != this.lastSentZ;
   }

   public void method07571(boolean var1) {
      this.interpolationInitialized = var1;
   }

   public void method07572(String var1) {
      this.lastSentUsername = var1;
   }

   public void method07573(float var1) {
      this.lastSentX = var1;
   }

   public float method07574() {
      return this.lastSentZ;
   }

   public String method07575() {
      return this.lastSentClientType;
   }

   public boolean method07576() {
      return !this.lastSentInitialized
         ? true
         : !Objects.equals(this.username, this.lastSentUsername)
            || !Objects.equals(this.clientUsername, this.lastSentClientUsername)
            || !Objects.equals(this.clientType, this.lastSentClientType);
   }

   public GlobalPlayer(String var1, String var2, String var3) {
      this(var1, var2, var3, field18469);
   }

   public void method07577(String var1) {
      this.clientType = var1;
   }

   public void method07578(int var1) {
      this.lerpStep = var1;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      int var2 = 1;
      String var3 = this.method07586();
      var2 = var2 * 59 + (var3 == null ? 43 : var3.hashCode());
      String var4 = this.method07580();
      var2 = var2 * 59 + (var4 == null ? 43 : var4.hashCode());
      String var5 = this.method07590();
      var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
      String var6 = this.method07584();
      var2 = var2 * 59 + (var6 == null ? 43 : var6.hashCode());
      MutableVector3f var7 = this.method07582();
      return var2 * 59 + (var7 == null ? 43 : var7.hashCode());
   }

   public MutableVector3f method07579() {
      return this.targetPosition;
   }

   public String method07580() {
      return this.clientUsername;
   }

   public void method07581(String var1) {
      this.lastSentClientType = var1;
   }

   public MutableVector3f method07582() {
      return this.position;
   }

   public void method07583(MutableVector3f var1) {
      this.lerpStartPosition = var1;
   }

   public String method07584() {
      return this.clientType;
   }

   public void method07585(float var1) {
      this.lastSentY = var1;
   }

   public String method07586() {
      return this.username;
   }

   public int method07587() {
      return this.lerpSteps;
   }

   public String method07588() {
      return this.lastSentClientUsername;
   }

   public GlobalPlayer(String var1) {
      this(var1, var1, UUID.randomUUID().toString(), field18468);
   }

   public float method07589() {
      return this.lastSentX;
   }

   public String method07590() {
      return this.uuid;
   }

   public GlobalPlayer(String var1, String var2) {
      this(var1, var2, UUID.randomUUID().toString(), field18470);
   }

   private static float method07591(float var0, float var1, float var2) {
      return var0 + (var1 - var0) * var2;
   }

   public float method07592() {
      return this.lastSentY;
   }

   public void method07593(String var1) {
      this.uuid = var1;
   }

   public MutableVector3f method07594() {
      return this.lerpStartPosition;
   }

   private void method07595() {
      if (this.prevPosition == null) {
         this.prevPosition = new MutableVector3f(0.0F, 0.0F, 0.0F);
      }

      if (this.targetPosition == null) {
         this.targetPosition = new MutableVector3f(this.position.field03984, this.position.field03985, this.position.field03986);
      }

      if (this.lerpStartPosition == null) {
         this.lerpStartPosition = new MutableVector3f(this.position.field03984, this.position.field03985, this.position.field03986);
      }
   }

   public void method07596() {
      this.method07595();
      this.prevPosition.field03984 = this.position.field03984;
      this.prevPosition.field03985 = this.position.field03985;
      this.prevPosition.field03986 = this.position.field03986;
      if (this.lerpSteps > 0) {
         this.lerpStep++;
         float var1 = (float)this.lerpStep / this.lerpSteps;
         this.position.field03984 = method07591(this.lerpStartPosition.field03984, this.targetPosition.field03984, var1);
         this.position.field03985 = method07591(this.lerpStartPosition.field03985, this.targetPosition.field03985, var1);
         this.position.field03986 = method07591(this.lerpStartPosition.field03986, this.targetPosition.field03986, var1);
         if (this.lerpStep >= this.lerpSteps) {
            this.position.field03984 = this.targetPosition.field03984;
            this.position.field03985 = this.targetPosition.field03985;
            this.position.field03986 = this.targetPosition.field03986;
            this.lerpSteps = 0;
            this.lerpStep = 0;
         }
      }
   }

   public void method07597(boolean var1, boolean var2) {
      if (var1) {
         this.lastSentUsername = this.username;
         this.lastSentClientUsername = this.clientUsername;
         this.lastSentClientType = this.clientType;
         this.lastSentInitialized = true;
      }

      if (var2) {
         this.lastSentX = this.position.field03984;
         this.lastSentY = this.position.field03985;
         this.lastSentZ = this.position.field03986;
         this.lastSentPositionAt = System.currentTimeMillis();
         this.lastSentInitialized = true;
      }
   }

   protected boolean method07598(Object var1) {
      return var1 instanceof GlobalPlayer;
   }

   public void method07599(MutableVector3f var1) {
      this.targetPosition = var1;
   }

   public int method07600() {
      return this.lerpStep;
   }

   public void method07601(String var1) {
      this.lastSentClientUsername = var1;
   }

   public long method07602() {
      return this.lastSentPositionAt;
   }

   public void method07603(int var1) {
      this.lerpSteps = var1;
   }

   public boolean method07604(long var1, float var3) {
      if (!this.lastSentInitialized) {
         return true;
      }

      float var4 = this.position.field03984 - this.lastSentX;
      float var5 = this.position.field03985 - this.lastSentY;
      float var6 = this.position.field03986 - this.lastSentZ;
      float var7 = var3 * var3;
      if (var4 * var4 + var5 * var5 + var6 * var6 < var7) {
         return false;
      }

      if (var1 <= 0L) {
         return true;
      }

      long var8 = System.currentTimeMillis() - this.lastSentPositionAt;
      return var8 >= var1;
   }

   public void method07605(float var1) {
      this.lastSentZ = var1;
   }

   public void method07606(boolean var1) {
      this.lastSentInitialized = var1;
   }

   public MutableVector3f method07607() {
      if (this.prevPosition == null) {
         this.prevPosition = new MutableVector3f(0.0F, 0.0F, 0.0F);
      }

      return this.prevPosition;
   }

   public void method07608(MutableVector3f var1) {
      this.prevPosition = var1;
   }

   public boolean method07609() {
      return this.interpolationInitialized;
   }

   public boolean method07610() {
      return this.lastSentInitialized;
   }

   public void method07611(float var1, float var2, float var3, int var4) {
      this.method07595();
      if (!this.interpolationInitialized) {
         this.position.field03984 = var1;
         this.position.field03985 = var2;
         this.position.field03986 = var3;
         this.prevPosition.field03984 = var1;
         this.prevPosition.field03985 = var2;
         this.prevPosition.field03986 = var3;
         this.targetPosition.field03984 = var1;
         this.targetPosition.field03985 = var2;
         this.targetPosition.field03986 = var3;
         this.lerpStartPosition.field03984 = var1;
         this.lerpStartPosition.field03985 = var2;
         this.lerpStartPosition.field03986 = var3;
         this.interpolationInitialized = true;
         this.lerpSteps = 0;
         this.lerpStep = 0;
      } else if (var4 <= 0) {
         this.position.field03984 = var1;
         this.position.field03985 = var2;
         this.position.field03986 = var3;
         this.prevPosition.field03984 = var1;
         this.prevPosition.field03985 = var2;
         this.prevPosition.field03986 = var3;
         this.targetPosition.field03984 = var1;
         this.targetPosition.field03985 = var2;
         this.targetPosition.field03986 = var3;
         this.lerpStartPosition.field03984 = var1;
         this.lerpStartPosition.field03985 = var2;
         this.lerpStartPosition.field03986 = var3;
         this.lerpSteps = 0;
         this.lerpStep = 0;
      } else {
         this.lerpStartPosition.field03984 = this.position.field03984;
         this.lerpStartPosition.field03985 = this.position.field03985;
         this.lerpStartPosition.field03986 = this.position.field03986;
         this.targetPosition.field03984 = var1;
         this.targetPosition.field03985 = var2;
         this.targetPosition.field03986 = var3;
         this.lerpSteps = var4;
         this.lerpStep = 0;
      }
   }
}
