// Original binary: sg/ec/URVZih5BtamZXYV1
package sg.ec;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;

// $VF: Compiled from s
public final class OnnxRotationSettingsCodec {
   @Deprecated
   public static final OnnxRotationSettingsCodec field12508 = new OnnxRotationSettingsCodec();
   private volatile boolean field12509 = true;
   private volatile float field12510;
   private volatile float field12511;
   private volatile float field12512;
   private static final float field12513 = 30.0F;
   private static final float field12514 = 30.0F;
   private static final float field12515 = 350.0F;
   private static final String field12516 = "aimAssist";
   private static final String field12517 = "aimAssist";
   private static final String field12518 = "assistYaw";
   private static final String field12519 = "assistYaw";
   private static final String field12520 = "assistPitch";
   private static final String field12521 = "assistPitch";
   private static final String field12522 = "assistWindow";
   private static final String field12523 = "assistWindow";
   private static final String field12524 = "Neuro-Model-Load";
   private static final String field12525 = "server";

   public float method05876() {
      return this.field12510;
   }

   public boolean method05877() {
      return this.field12509;
   }

   public void method05878(byte[] var1) {
      try {
         JsonObject var2 = JsonParser.parseString(new String(var1, StandardCharsets.UTF_8)).getAsJsonObject();
         if (var2.has(field12516)) {
            this.field12509 = var2.get(field12517).getAsBoolean();
         }

         if (var2.has(field12518)) {
            this.field12510 = var2.get(field12519).getAsFloat();
         }

         if (var2.has(field12520)) {
            this.field12511 = var2.get(field12521).getAsFloat();
         }

         if (var2.has(field12522)) {
            this.field12512 = var2.get(field12523).getAsFloat();
         }
      } catch (Exception var3) {
      }
   }

   public float method05879() {
      return this.field12512;
   }

   public float method05880() {
      return this.field12511;
   }

   @Deprecated
   public void method05881(byte[] var1) {
      if (var1 != null && var1.length > 0) {
         this.method05878(var1);
      }
   }

   public OnnxRotationSettingsCodec() {
      this.field12510 = field12513;
      this.field12511 = field12514;
      this.field12512 = field12515;
   }

   static void method05883(String var0, byte[] var1, Supplier<OnnxRotationModel> var2) {
      Thread var3 = new Thread(() -> {
         OnnxRotationModel var3x = (OnnxRotationModel)var2.get();
         if (var3x != null) {
            try {
               var3x.method00701(var1, var0 != null && !var0.isBlank() ? var0 : field12525);
            } catch (Exception var5) {
            }
         }
      }, field12524);
      var3.setDaemon(true);
      var3.start();
   }
}
