// Original binary: sg/ec/QR9YJwWIBbFYh56p
package sg.ec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.mojang.blaze3d.platform.Window;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.util.LinkedHashMap;

// $VF: Compiled from s
public enum DragManager implements MinecraftAccess {
   INSTANCE;

   public final LinkedHashMap<String, DraggableElement> field11288 = new LinkedHashMap<>();
   private final File field11289 = new File(mc.gameDirectory, "\\Hex\\drags." + "Hex".toLowerCase());
   private final Gson field11290 = new GsonBuilder().setPrettyPrinting().excludeFieldsWithoutExposeAnnotation().setPrettyPrinting().create();
   private float field11291;
   private float field11292;

   public void method05195() {
      EventBus.method00263(this);
      this.method05202();
   }

   @Subscribe(0)
   private void method05196(ChatMouseButtonEvent var1) {
      InputAction var2 = var1.method06511();
      float var3 = var1.method06510();
      float var4 = var1.method06505();
      int var5 = var1.method06509();
      if (var2 == InputAction.PRESS) {
         for (DraggableElement var7 : this.field11288.values()) {
            if (var7.method02705().method06457() && var7.method02665(var3, var4, var5)) {
               break;
            }
         }
      }

      if (var2 == InputAction.RELEASE) {
         for (DraggableElement var9 : this.field11288.values()) {
            if (var9.method02705().method06457()) {
               var9.method02686(var5);
            }
         }
      }
   }

   @Subscribe
   private void method05197(ChatClosedEvent var1) {
      for (DraggableElement var3 : this.field11288.values()) {
         if (var3.method02705().method06457()) {
            var3.method02686(0);
         }
      }
   }

   @Subscribe
   private void method05198(Render2DEvent var1) {
      Window var2 = var1.method03222();
      int var3 = var1.method03220();
      int var4 = var1.method03227();
      boolean var5 = false;

      for (DraggableElement var7 : this.field11288.values()) {
         if (var7.method02705().method06457()) {
            var7.method02690(var3, var4, var2);
            if (!var5 && GuiHitTestUtils.method05624(var3, var4, var7.method02685(), var7.method02669(), var7.method02687(), var7.method02681())) {
               var5 = true;
            }
         }
      }
   }

   public void method05199() {
   }

   public byte[] method05200() {
      try {
         return this.field11290.toJson(this.field11288.values()).getBytes(StandardCharsets.UTF_8);
      } catch (Exception var2) {
         return new byte[0];
      }
   }

   public void method05201(byte[] var1) {
      if (var1 != null && var1.length != 0) {
         try {
            DraggableElement[] var2 = (DraggableElement[])this.field11290.fromJson(new String(var1, StandardCharsets.UTF_8), DraggableElement[].class);
            if (var2 == null) {
               return;
            }

            for (DraggableElement var6 : var2) {
               if (var6 != null) {
                  DraggableElement var7 = this.field11288.get(var6.method02712());
                  if (var7 != null) {
                     var7.method02663(var6.method02668());
                     var7.method02689(var6.method02688());
                     this.field11288.put(var6.method02712(), var7);
                  }
               }
            }

            if (this.field11291 > 0.0F && this.field11292 > 0.0F) {
               this.method05206(this.field11291, this.field11292);
            }
         } catch (Exception var8) {
         }
      }
   }

   public void method05202() {
      if (this.field11289.exists()) {
         DraggableElement[] var1;
         try {
            var1 = (DraggableElement[])this.field11290.fromJson(Files.readString(this.field11289.toPath()), DraggableElement[].class);
         } catch (IOException var7) {
            return;
         }

         if (var1 != null) {
            for (DraggableElement var5 : var1) {
               if (var5 == null) {
                  return;
               }

               DraggableElement var6 = this.field11288.get(var5.method02712());
               if (var6 != null) {
                  var6.method02663(var5.method02668());
                  var6.method02689(var5.method02688());
                  this.field11288.put(var5.method02712(), var6);
               }
            }

            if (this.field11291 > 0.0F && this.field11292 > 0.0F) {
               this.method05206(this.field11291, this.field11292);
            }
         }
      }
   }

   public void method05203(Window var1) {
      if (var1 != null) {
         float var2 = this.method05207(var1, var1.getGuiScaledWidth());
         float var3 = this.method05207(var1, var1.getGuiScaledHeight());
         if (!(var2 <= 0.0F) && !(var3 <= 0.0F)) {
            float var4 = this.field11291;
            float var5 = this.field11292;
            if (!(var4 <= 0.0F) && !(var5 <= 0.0F)) {
               if (var4 != var2 || var5 != var3) {
                  this.method05206(var4, var5);
                  this.field11291 = var2;
                  this.field11292 = var3;
               }
            } else {
               this.field11291 = var2;
               this.field11292 = var3;
               this.method05206(var2, var3);
            }
         }
      }
   }

   public float method05204(Window var1) {
      if (this.field11291 <= 0.0F || this.field11292 <= 0.0F) {
         this.method05203(var1);
      }

      return this.field11291;
   }

   public float method05205(Window var1) {
      if (this.field11291 <= 0.0F || this.field11292 <= 0.0F) {
         this.method05203(var1);
      }

      return this.field11292;
   }

   private void method05206(float var1, float var2) {
      if (!(var1 <= 0.0F) && !(var2 <= 0.0F)) {
         for (DraggableElement var4 : this.field11288.values()) {
            var4.method02695(var1, var2);
         }
      }
   }

   private float method05207(Window var1, int var2) {
      return var2 * var1.getGuiScale() / 2;
   }
}
