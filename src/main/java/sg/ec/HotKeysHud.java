// Original binary: sg/ec/JkqwKKo5y5w1cn5j
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class HotKeysHud extends HudElement {
   public DraggableElement field09300 = this.method06449(this, 0.0F, 0.0F);
   private final AnimationUtils field09301;
   private final List<HotKeysHud.Nested124> field09302;
   private final Map<String, HotKeysHud.Nested124> field09303;
   private final Set<String> field09304;
   private static final String field09305 = "HotKeys";
   private static final long field09306 = 150L;
   private static final String field09307 = "ClickGUI";
   private static final double field09308 = 0.01F;
   private static final double field09309 = 0.01F;
   private static final float field09310 = 0.01F;
   private static final float field09311 = 11.0F;
   private static final float field09312 = 15.0F;
   private static final float field09313 = 70.0F;
   private static final float field09314 = 2.5F;
   private static final float field09315 = 5.0F;
   private static final String field09316 = "X";
   private static final float field09317 = 20.0F;
   private static final float field09318 = 11.0F;
   private static final float field09319 = 11.0F;
   private static final float field09320 = 5.0F;
   private static final float field09321 = 5.0F;
   private static final float field09322 = 11.0F;
   private static final float field09323 = 11.0F;

   private void method04099() {
      for (int var1 = this.field09302.size() - 1; var1 >= 0; var1--) {
         HotKeysHud.Nested124 sx = this.field09302.get(var1);
         if (!this.field09304.contains(sx.method04103())) {
            this.field09302.remove(var1);
            this.field09303.remove(sx.method04103());
         }
      }
   }

   @Override
   public void method00027(GuiGraphicsExtractor var1) {
      super.method00027(var1);
      this.field09304.clear();

      for (ToggleableModule var3 : KeyBindingManager.INSTANCE.method11746()) {
         if (!var3.method03925().equalsIgnoreCase(field09307) && var3.method03930().method05873()) {
            var3.method03927().method03375(var3.method03937() ? 1.0 : 0.0);
            if (var3.method03927().method03384() > field09308) {
               this.method04100(var3.method03925(), var3.method03930().method05871(), var3.method03937(), var3.method03927());
            }
         }
      }

      for (ToggleSetting var15 : KeyBindingManager.INSTANCE.method11747()) {
         if (var15.method05997().method05873()) {
            var15.method05998().method03375(var15.method03022() ? 1.0 : 0.0);
            if (var15.method05998().method03384() > field09309) {
               this.method04100(var15.method03024(), var15.method05997().method05871(), var15.method05999(), var15.method05998());
            }
         }
      }

      this.method04099();
      this.method06465(this.field09300.method02685());
      this.method06453(this.field09300.method02669());
      float var14 = 0.0F;
      float var16 = 0.0F;
      var var4 = new ArrayList(this.field09302.size());

      for (HotKeysHud.Nested124 var6 : this.field09302) {
         if (var6.method04107() != -1) {
            AnimationUtils var7 = var6.method04101();
            String var8 = var6.method04103();
            String var9 = var6.method04106();
            var7.method03375(var6.method04102() ? 1.0 : 0.0);
            float var10 = var7.method03377();
            float var11 = var6.method04104();
            float var12 = var6.method04105();
            if (var6.method04102() || var10 > field09310) {
               var16 += var10 * field09311;
               var14 = Math.max(var11 + var12 + field09312, var14);
               var4.add(new HotKeysHud.Nested123(var8, var9, var12, var10));
            }
         }
      }

      this.field09301.method03375(Math.max(field09313, var14));
      float var17 = Math.max(field09314, var16 + field09315);
      this.method06448(this.field09301.method03377());
      this.method06456(field14609 + var17);
      this.method06441(var1, field09316);
      float var18 = this.method06464();
      int var19 = 0;

      for (HotKeysHud.Nested123 var21 : (Iterable<HotKeysHud.Nested123>) (Iterable) var4) {
         int var22 = ColorUtils.method04611(this.method06438(), var21.anim);
         float var23 = var18 + field09317 + var21.anim * field09318 - field09319 + var19 * 11;
         field14601.method09490(var1, var21.name, this.method06436() + field09320, var23, var22, field14607, -field14608);
         field14601.method09490(var1, var21.bind, this.method06436() + this.method06458() - var21.bindWidth - field09321, var23, var22, field14607, -field14608);
         var18 += field09322 * var21.anim - field09323;
         var19++;
      }

      this.field09300.method02676(this.method06458());
      this.field09300.method02696(this.method06435());
   }

   private void method04100(String var1, int var2, boolean var3, AnimationUtils var4) {
      this.field09304.add(var1);
      HotKeysHud.Nested124 var5 = this.field09303.get(var1);
      String var6 = "[" + KeyboardKey.method00360(var2) + "]";
      if (var5 == null) {
         HotKeysHud.Nested124 var7 = new HotKeysHud.Nested124(
            var1, var2, var6, field14601.method09478(var1, field14607, -field14608), field14601.method09478(var6, field14607, -field14608), var3, var4
         );
         this.field09303.put(var1, var7);
         this.field09302.add(var7);
      } else {
         if (!Objects.equals(var5.field09324, var1)) {
            var5.field09324 = var1;
            var5.field09327 = field14601.method09478(var1, field14607, -field14608);
         }

         if (!Objects.equals(var5.field09326, var6)) {
            var5.field09326 = var6;
            var5.field09328 = field14601.method09478(var6, field14607, -field14608);
         }

         var5.field09325 = var2;
         var5.field09329 = var3;
         var5.field09330 = var4;
      }
   }

   public HotKeysHud() {
      super(field09305);
      this.field09301 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field09306);
      this.field09302 = new ArrayList<>();
      this.field09303 = new HashMap<>();
      this.field09304 = new HashSet<>();
   }

   // $VF: Compiled from s
   private record Nested123(String name, String bind, float bindWidth, float anim) {
   }

   // $VF: Compiled from s
   public static class Nested124 {
      private String field09324;
      private int field09325;
      private String field09326;
      private float field09327;
      private float field09328;
      private boolean field09329;
      private AnimationUtils field09330;

      public AnimationUtils method04101() {
         return this.field09330;
      }

      public boolean method04102() {
         return this.field09329;
      }

      public String method04103() {
         return this.field09324;
      }

      public float method04104() {
         return this.field09327;
      }

      public float method04105() {
         return this.field09328;
      }

      public String method04106() {
         return this.field09326;
      }

      public Nested124(String var1, int var2, String var3, float var4, float var5, boolean var6, AnimationUtils var7) {
         this.field09324 = var1;
         this.field09325 = var2;
         this.field09326 = var3;
         this.field09327 = var4;
         this.field09328 = var5;
         this.field09329 = var6;
         this.field09330 = var7;
      }

      public int method04107() {
         return this.field09325;
      }
   }
}
