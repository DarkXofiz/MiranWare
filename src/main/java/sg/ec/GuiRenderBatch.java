// Original binary: sg/ec/QR0mlSxQQMxqHzMS
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.renderer.state.gui.GuiElementRenderState;
import net.minecraft.client.renderer.state.gui.GuiRenderState;

// $VF: Compiled from s
public class GuiRenderBatch {
   private static boolean field11275 = false;
   private static final List<GuiElementRenderState> field11276 = new ArrayList<>();
   private static final int field11277 = 0;
   private static final int field11278 = 0;
   private static final int field11279 = 0;
   private static final int field11280 = 0;
   private static final int field11281 = 0;
   private static final int field11282 = 0;
   private static final List<GuiElementRenderState> field11283 = new ArrayList<>();
   private static final List<GuiElementRenderState> field11284 = new ArrayList<>();
   private static final List<GuiElementRenderState>[] field11285 = new List[]{
      new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList(), new ArrayList()
   };
   private static GuiRenderState field11286 = null;
   private static boolean field11287 = false;

   public static void method05181() {
      if (field11275) {
         field11275 = false;
         if (!field11276.isEmpty() && field11286 != null) {
            method05189();
            field11286.nextStratum();
         }

         field11276.clear();
         field11286 = null;
         field11287 = false;
      }
   }

   private static void method05182() {
      for (GuiElementRenderState var1 : field11276) {
         field11285[method05192(var1)].add(var1);
      }

      field11276.clear();
      boolean var6 = false;

      for (int sx = 0; sx < 5; sx++) {
         var sxx = field11285[sx];
         if (!sxx.isEmpty()) {
            if (var6) {
               field11286.nextStratum();
            }

            GuiNodeAccess sxxx = (GuiNodeAccess)((GuiRenderStateAccess)field11286).getCurrentLayer();

            for (GuiElementRenderState sxxxx : sxx) {
               sxxx.IaddSimpleElement(sxxxx);
            }

            sxx.clear();
            var6 = true;
         }
      }
   }

   public static void method05183() {
      if (field11275) {
         if (!field11276.isEmpty() && field11286 != null) {
            method05189();
            field11286.nextStratum();
         }

         ItemRenderUtils.method08411();
      }
   }

   public static void method05184() {
      if (field11275 && field11286 != null) {
         field11286.nextStratum();
      }
   }

   public static void method05185() {
      if (field11275 && field11286 != null && !field11276.isEmpty()) {
         GuiNodeAccess var0 = (GuiNodeAccess)((GuiRenderStateAccess)field11286).getCurrentLayer();
         var var1 = field11283;
         var1.clear();

         for (GuiElementRenderState var3 : field11276) {
            if (var3 instanceof RoundedOutlineRenderState) {
               var0.IaddSimpleElement(var3);
            } else {
               var1.add(var3);
            }
         }

         field11276.clear();
         field11276.addAll(var1);
         var1.clear();
      }
   }

   public static void method05186(GuiRenderState var0, GuiElementRenderState var1) {
      if (field11275) {
         if (field11286 == null) {
            field11286 = var0;
         }

         field11276.add(var1);
      } else {
         ((GuiNodeAccess)((GuiRenderStateAccess)var0).getCurrentLayer()).IaddSimpleElement(var1);
      }
   }

   public static void method05187(GuiRenderState var0, GuiElementRenderState var1) {
      if (field11275 && field11286 != null && !field11276.isEmpty()) {
         method05189();
      }

      var0.nextStratum();
      ((GuiNodeAccess)((GuiRenderStateAccess)var0).getCurrentLayer()).IaddSimpleElement(var1);
      var0.nextStratum();
   }

   public static void method05188(boolean var0) {
      field11275 = true;
      field11287 = var0;
      field11276.clear();
      field11286 = null;
   }

   private static void method05189() {
      if (field11287) {
         method05182();
      } else {
         method05193();
      }
   }

   public static void method05190(GuiRenderState var0) {
      if (field11275) {
         method05183();
      } else {
         if (var0 != null) {
            var0.nextStratum();
         }

         ItemRenderUtils.method08411();
      }
   }

   public static boolean method05191() {
      return field11275;
   }

   private static int method05192(GuiElementRenderState var0) {
      if (var0 instanceof ClipGuiRenderState) {
         return 0;
      } else if (var0 instanceof FontTextRenderState) {
         return 4;
      } else if (!(var0 instanceof RoundedRectRenderState) && !(var0 instanceof RoundedBorderRenderState) && !(var0 instanceof GuiShadowRenderState)) {
         return var0.pipeline() == ScriptDrawCommandDispatcher.field21437 ? 3 : 2;
      } else {
         return 1;
      }
   }

   private static void method05193() {
      var var0 = field11283;
      var var1 = field11284;
      var0.clear();
      var1.clear();

      for (GuiElementRenderState var3 : field11276) {
         if (var3 instanceof ClipGuiRenderState) {
            var0.add(var3);
         } else {
            var1.add(var3);
         }
      }

      GuiNodeAccess var5 = (GuiNodeAccess)((GuiRenderStateAccess)field11286).getCurrentLayer();
      if (!var0.isEmpty()) {
         for (GuiElementRenderState var4 : var0) {
            var5.IaddSimpleElement(var4);
         }

         if (!var1.isEmpty()) {
            field11286.nextStratum();
            var5 = (GuiNodeAccess)((GuiRenderStateAccess)field11286).getCurrentLayer();
         }
      }

      for (GuiElementRenderState var8 : var1) {
         var5.IaddSimpleElement(var8);
      }

      field11276.clear();
      var0.clear();
      var1.clear();
   }

   public static void method05194() {
      method05188(false);
   }
}
