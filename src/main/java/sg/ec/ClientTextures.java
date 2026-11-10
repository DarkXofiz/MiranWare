// Original binary: sg/ec/MUkfJHSOg0z16o9X
package sg.ec;

import com.mojang.blaze3d.platform.NativeImage;
import java.util.HashMap;
import java.util.Map;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public enum ClientTextures {
   INSTANCE;

   private final Map<String, Identifier> field10148 = new HashMap<>();
   private final Map<String, Identifier> field10149 = new HashMap<>();
   private Identifier field10150;
   private Identifier field10151;
   private Identifier field10152;
   private Identifier field10153;
   private Identifier field10154;
   private Identifier field10155;
   private Identifier field10156;
   private Identifier field10157;
   private Identifier field10158;
   private Identifier field10159;
   private Identifier field10160;
   private Identifier field10161;
   private Identifier field10162;
   private Identifier field10163;
   private Identifier field10164;
   private Identifier field10165;
   private Identifier field10166;
   private Identifier field10167;
   private Identifier field10168;

   public void method04553() {
      EventBus.method00263(this);
      this.method04555();
      this.method04558();
   }

   private void method04554() {
      this.field10148.put("1", TextureLoader.method07218("Hex".toLowerCase(), "pictures/arrows/arrows.png"));
      this.field10148.put("2", TextureLoader.method07218("Hex".toLowerCase(), "pictures/arrows/arrows1.png"));
      this.field10148.put("3", TextureLoader.method07218("Hex".toLowerCase(), "pictures/arrows/arrows2.png"));
      this.field10148.put("4", TextureLoader.method07218("Hex".toLowerCase(), "pictures/arrows/arrows3.png"));
      this.field10148.put("5", TextureLoader.method07218("Hex".toLowerCase(), "pictures/arrows/arrows4.png"));
   }

   private void method04555() {
      this.method04554();
      this.method04556();
      this.field10150 = TextureLoader.method07218("Hex".toLowerCase(), "pictures/halo.png");
      this.field10151 = TextureLoader.method07218("Hex".toLowerCase(), "icons/gui/gear.png");
      this.field10152 = TextureLoader.method07218("Hex".toLowerCase(), "icons/gui/bin.png");
      this.field10153 = TextureLoader.method07218("Hex".toLowerCase(), "icons/gui/copy.png");
      this.field10154 = TextureLoader.method07218("Hex".toLowerCase(), "icons/colorpicker/color.png");
      this.field10155 = TextureLoader.method07218("Hex".toLowerCase(), "icons/colorpicker/opacity.png");
   }

   private void method04556() {
      for (String var4 : new String[]{"holyworld", "spookytime", "funtime", "reallyworld"}) {
         this.field10149.put(var4, TextureLoader.method07218("Hex".toLowerCase(), "pictures/autobuy/" + var4 + ".png"));
      }
   }

   public Identifier method04557(String var1) {
      return this.field10149.get(var1);
   }

   private void method04558() {
      this.field10156 = TextureLoader.method07218("Hex".toLowerCase(), "pictures/kvadrat.png");
      this.field10157 = TextureLoader.method07218("Hex".toLowerCase(), "particles/orbiznew.png");
      this.field10158 = TextureLoader.method07218("Hex".toLowerCase(), "particles/star.png");
      this.field10159 = TextureLoader.method07218("Hex".toLowerCase(), "particles/heart.png");
      this.field10160 = TextureLoader.method07218("Hex".toLowerCase(), "particles/dollar.png");
      this.field10161 = TextureLoader.method07218("Hex".toLowerCase(), "particles/snowflake.png");
      this.field10167 = TextureLoader.method07218("Hex".toLowerCase(), "particles/spark.png");
      this.field10162 = TextureLoader.method07218("Hex".toLowerCase(), "particles/crown.png");
      this.field10164 = TextureLoader.method07218("Hex".toLowerCase(), "particles/line.png");
      this.field10163 = TextureLoader.method07218("Hex".toLowerCase(), "particles/lightning.png");
      this.field10167 = TextureLoader.method07218("Hex".toLowerCase(), "particles/spark.png");
      this.field10166 = TextureLoader.method07218("Hex".toLowerCase(), "particles/rhombus.png");
      this.field10165 = TextureLoader.method07218("Hex".toLowerCase(), "particles/point.png");
      this.field10168 = TextureLoader.method07218("Hex".toLowerCase(), "pictures/circle.png");
   }

   @Subscribe
   private void method04559(GameStartedEvent var1) {
      this.method04555();
      this.method04558();
   }

   public Identifier method04560(int var1) {
      return switch (var1) {
         case 1 -> this.field10158;
         case 2 -> this.field10159;
         case 3 -> this.field10160;
         case 4 -> this.field10161;
         case 5 -> this.field10162;
         case 6 -> this.field10163;
         case 7 -> this.field10164;
         case 8 -> this.field10165;
         case 9 -> this.field10166;
         case 10 -> this.field10167;
         default -> this.field10157;
      };
   }

   public NativeImage method04561(int var1) {
      Identifier var2 = this.method04560(var1);
      if (var2 == null) {
         return null;
      } else {
         return Minecraft.getInstance().getTextureManager().getTexture(var2) instanceof DynamicTexture var4 ? var4.getPixels() : null;
      }
   }

   public Map<String, Identifier> method04562() {
      return this.field10148;
   }

   public Map<String, Identifier> method04563() {
      return this.field10149;
   }

   public Identifier method04564() {
      return this.field10150;
   }

   public Identifier method04565() {
      return this.field10151;
   }

   public Identifier method04566() {
      return this.field10152;
   }

   public Identifier method04567() {
      return this.field10153;
   }

   public Identifier method04568() {
      return this.field10154;
   }

   public Identifier method04569() {
      return this.field10155;
   }

   public Identifier method04570() {
      return this.field10156;
   }

   public Identifier method04571() {
      return this.field10157;
   }

   public Identifier method04572() {
      return this.field10158;
   }

   public Identifier method04573() {
      return this.field10159;
   }

   public Identifier method04574() {
      return this.field10160;
   }

   public Identifier method04575() {
      return this.field10161;
   }

   public Identifier method04576() {
      return this.field10162;
   }

   public Identifier method04577() {
      return this.field10163;
   }

   public Identifier method04578() {
      return this.field10164;
   }

   public Identifier method04579() {
      return this.field10165;
   }

   public Identifier method04580() {
      return this.field10166;
   }

   public Identifier method04581() {
      return this.field10167;
   }

   public Identifier method04582() {
      return this.field10168;
   }
}
