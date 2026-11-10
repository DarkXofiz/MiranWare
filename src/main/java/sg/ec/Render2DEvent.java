// Original binary: sg/ec/EJGbGzQYZzG9v6sV
package sg.ec;

import com.mojang.blaze3d.platform.Window;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class Render2DEvent extends Event {
   public static final Render2DEvent field07060 = new Render2DEvent();
   private GuiGraphicsExtractor field07061;
   private Window field07062;
   private int field07063;
   private int field07064;

   public void method03219(int var1) {
      this.field07064 = var1;
   }

   public int method03220() {
      return this.field07063;
   }

   public void method03221(int var1) {
      this.field07063 = var1;
   }

   public Window method03222() {
      return this.field07062;
   }

   public void method03223(GuiGraphicsExtractor var1, Window var2, int var3, int var4) {
      this.field07061 = var1;
      this.field07062 = var2;
      this.field07063 = var3;
      this.field07064 = var4;
      super.method03208();
   }

   public void method03224(GuiGraphicsExtractor var1) {
      this.field07061 = var1;
   }

   public void method03225(Window var1) {
      this.field07062 = var1;
   }

   public GuiGraphicsExtractor method03226() {
      return this.field07061;
   }

   public int method03227() {
      return this.field07064;
   }
}
