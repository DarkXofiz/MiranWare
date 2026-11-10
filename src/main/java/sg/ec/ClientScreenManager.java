// Original binary: sg/ec/fo3qiIhmd2gMOCHL
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public enum ClientScreenManager implements MinecraftAccess {
   INSTANCE;

   private final List<ClientScreen> field19172 = new ArrayList<>();
   private ClientScreen field19173;
   private int field19174;
   private int field19175;

   public boolean method08316() {
      return this.field19173 != null;
   }

   public boolean method08317(ClientScreen var1) {
      return this.field19173 != null && this.field19173 == var1;
   }

   public boolean method08318() {
      return this.field19173 != null || !this.field19172.isEmpty();
   }

   public void method08319(ClientScreen var1) {
      if (var1 != null && this.field19173 != var1) {
         this.method08331();
         this.method08330(var1, null);
      }
   }

   public void method08320(ClientScreen var1) {
      if (var1 != null && this.field19173 != var1) {
         ClientScreen var2 = this.field19173;
         this.method08331();
         this.method08330(var1, var2);
      }
   }

   public void method08321() {
      if (this.field19173 != null) {
         ClientScreen var1 = this.field19173.method01468();
         this.method08331();
         if (var1 != null) {
            this.method08330(var1, var1.method01468());
         } else if (mc.gui.screen() == null) {
            mc.mouseHandler.grabMouse();
         }
      }
   }

   public void method08322() {
      if (this.field19173 != null) {
         mc.mouseHandler.releaseMouse();
      }
   }

   public void method08323(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      for (int var5 = this.field19172.size() - 1; var5 >= 0; var5--) {
         if (!this.field19172.get(var5).method01473()) {
            this.field19172.remove(var5);
         }
      }

      if (this.method08318()) {
         this.method08332(false);
         GuiBlurBarrierHooks.method03410(var1.guiRenderState);

         for (int var6 = 0; var6 < this.field19172.size(); var6++) {
            this.field19172.get(var6).method01478(var1, var2, var3, var4);
         }

         if (this.field19173 != null) {
            this.field19173.method01478(var1, var2, var3, var4);
         }
      }
   }

   public boolean method08324(double var1, double var3, int var5, boolean var6) {
      if (this.field19173 == null) {
         return false;
      }

      this.field19173.method01477(var1, var3, var5, var6);
      return true;
   }

   public boolean method08325(double var1, double var3, int var5) {
      if (this.field19173 == null) {
         return false;
      }

      this.field19173.method01465(var1, var3, var5);
      return true;
   }

   public boolean method08326(double var1, double var3, double var5, double var7) {
      if (this.field19173 == null) {
         return false;
      }

      this.field19173.method01463(var1, var3, var5, var7);
      return true;
   }

   public boolean method08327(int var1, int var2, int var3) {
      if (this.field19173 == null) {
         return false;
      }

      if (!this.field19173.method01464(var1, var2, var3) && var1 == 256) {
         this.method08321();
      }

      return true;
   }

   public boolean method08328(char var1, int var2) {
      if (this.field19173 == null) {
         return false;
      }

      this.field19173.method01476(var1, var2);
      return true;
   }

   public boolean method08329() {
      return this.field19173 != null && this.field19173.method01471();
   }

   private void method08330(ClientScreen var1, ClientScreen var2) {
      this.field19172.remove(var1);
      this.field19173 = var1;
      this.method08332(true);
      var1.method01469(var2);
      KeyMapping.releaseAll();
      mc.mouseHandler.releaseMouse();
   }

   private void method08331() {
      ClientScreen var1 = this.field19173;
      if (var1 != null) {
         this.field19173 = null;
         var1.method01475();
         this.field19172.add(var1);
      }
   }

   private void method08332(boolean var1) {
      int var2 = mc.getWindow().getGuiScaledWidth();
      int var3 = mc.getWindow().getGuiScaledHeight();
      boolean var4 = var2 != this.field19174 || var3 != this.field19175;
      this.field19174 = var2;
      this.field19175 = var3;
      if (var4) {
         for (ClientScreen var6 : this.field19172) {
            var6.method01479(var2, var3);
         }
      }

      if ((var4 || var1) && this.field19173 != null) {
         this.field19173.method01479(var2, var3);
      }
   }
}
