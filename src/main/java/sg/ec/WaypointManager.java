// Original binary: sg/ec/oKxmttHDrvNBKcvC
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import org.joml.Vector2f;

// $VF: Compiled from s
public enum WaypointManager {
   INSTANCE;

   private static final byte field22152 = 7;
   private static final byte field22153 = 0;
   private static final long field22154 = 0;
   private final List<Waypoint> field22155 = new ArrayList<>();
   private FontRenderer field22156;

   public void method09830() {
      EventBus.method00263(this);
   }

   public void method09831(float var1, float var2, float var3, String var4, long var5) {
      this.method09840(var1, var2, var3, var4, var5, true);
   }

   public void method09832(float var1, float var2, float var3, String var4) {
      this.method09833(var1, var2, var3, var4, true);
   }

   public void method09833(float var1, float var2, float var3, String var4, boolean var5) {
      this.method09840(var1, var2, var3, var4, System.currentTimeMillis(), false);
      if (var5) {
         CustomResourceManager.INSTANCE.method02465("WayPoint");
      }
   }

   public int method09834(String var1) {
      if (var1 != null && !var1.isBlank()) {
         int var2 = 0;
         boolean var3 = false;
         var var4 = this.field22155.iterator();

         while (var4.hasNext()) {
            Waypoint var5 = (Waypoint)var4.next();
            String var6 = var5.method11262();
            if (var6 != null && var6.equalsIgnoreCase(var1)) {
               if (!var5.method11268()) {
                  var3 = true;
               }

               var4.remove();
               var2++;
            }
         }

         if (var3) {
            CustomResourceManager.INSTANCE.method02465("WayPoint");
         }

         return var2;
      } else {
         return 0;
      }
   }

   public int method09835() {
      if (this.field22155.isEmpty()) {
         return 0;
      }

      int var1 = this.field22155.size();
      boolean var2 = this.field22155.stream().anyMatch(var0 -> !var0.method11268());
      this.field22155.clear();
      if (var2) {
         CustomResourceManager.INSTANCE.method02465("WayPoint");
      }

      return var1;
   }

   public void method09836(boolean var1) {
      boolean var2 = this.field22155.removeIf(var0 -> !var0.method11268());
      if (var2 && var1) {
         CustomResourceManager.INSTANCE.method02465("WayPoint");
      }
   }

   public List<Waypoint> method09837() {
      return new ArrayList<>(this.field22155);
   }

   public List<Waypoint> method09838() {
      return this.field22155.stream().filter(var0 -> !var0.method11268()).toList();
   }

   public List<String> method09839() {
      ArrayList var1 = new ArrayList();
      HashSet var2 = new HashSet();

      for (Waypoint var4 : this.field22155) {
         String var5 = var4.method11262();
         if (var5 != null && !var5.isBlank()) {
            String var6 = var5.toLowerCase(Locale.ROOT);
            if (var2.add(var6)) {
               var1.add(var5);
            }
         }
      }

      return var1;
   }

   private void method09840(float var1, float var2, float var3, String var4, long var5, boolean var7) {
      if (var4 != null && !var4.isBlank()) {
         Waypoint var8 = new Waypoint(var1, var2, var3, var4, var5, var7);
         if (this.field22156 != null) {
            var8.method11271(this.field22156.method09486(var4, 7.0F));
         }

         this.field22155.add(var8);
      }
   }

   @Subscribe
   private void method09841(TickEvent var1) {
      long var2 = System.currentTimeMillis();
      this.field22155.removeIf(var2x -> var2x.method11268() && var2 - var2x.method11266() > 4500L && var2x.method11274().method03377() < 0.001F);
   }

   @Subscribe
   private void method09842(HudRenderEvent var1) {
      WorldProjectionUtils.method09450();
      if (this.field22156 == null) {
         this.field22156 = Fonts.field00109;
         if (this.field22156 == null) {
            return;
         }
      }

      if (!this.field22155.isEmpty()) {
         PoseStack var2 = var1.method05425();
         GuiGraphicsExtractor var3 = var1.method05424();
         long var4 = System.currentTimeMillis();
         FontRenderer.method09475();

         for (Waypoint var7 : this.field22155) {
            float var8 = var7.method11264();
            float var9 = var7.method11260();
            float var10 = var7.method11269();
            Vector2f var11 = WorldProjectionUtils.method09455(var2, var8, var9, var10);
            if (var11 != null) {
               AnimationUtils var12 = var7.method11274();
               boolean var13 = !var7.method11268() || var4 - var7.method11266() < 4500L;
               var12.method03375(var13 ? 1.0 : 0.0);
               float var14 = var12.method03377();
               if (!(var14 < 0.001F)) {
                  int var15 = ColorUtils.method04611(-1, var14);
                  if (MinecraftAccess.mc.player != null) {
                     int var16 = method09843(MinecraftAccess.mc.player.position().distanceToSqr(var8, var9, var10));
                     if (var7.method11270() == 0.0F) {
                        float var17 = this.field22156.method09486(var7.method11262(), 7.0F);
                        var7.method11271(var17);
                     }

                     String var20 = var16 + "m";
                     float var18 = var11.x;
                     float var19 = var11.y - 12.5F;
                     this.field22156.method09473(var3, var20, var18, var19 + 13.0F, var15, 7.0F);
                     this.field22156.method09480(var3, var7.method11262(), var18 - var7.method11270() / 2.0F, var19 + 13.0F + 7.0F + 2.0F, var15, 7.0F);
                     Fonts.field00107.method09480(var3, "W", var18 - 6.5F, var19, var15, 13.0F);
                  }
               }
            }
         }

         FontRenderer.method09484();
      }
   }

   private static int method09843(double var0) {
      return (int)Math.sqrt(var0);
   }
}
