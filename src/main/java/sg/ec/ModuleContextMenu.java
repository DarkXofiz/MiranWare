// Original binary: sg/ec/nLeHUv28fWRJ7uxS
package sg.ec;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class ModuleContextMenu {
   private final List<FloatingWindow> field21942 = new CopyOnWriteArrayList<>();
   public static final Map<String, String> field21943 = new ConcurrentHashMap<>();
   private static final long field21944 = 100L;
   private static final String field21945 = "modules.settings";
   private static final String field21946 = "Settings";
   private static final String field21947 = "modules.binding";
   private static final String field21948 = "Binding";
   private static final String field21949 = "modules.bindlist";
   private static final String field21950 = "Bind List";
   private static final String field21951 = "menu.friends";
   private static final String field21952 = "Друзья";
   private static final String field21953 = "autobuy.settings";
   private static final String field21954 = "Настройки";
   private static final String field21955 = "autobuy.log";
   private static final String field21956 = "Журнал";

   public void method09649(GuiGraphicsExtractor var1, int var2, int var3, float var4, boolean var5, boolean var6) {
      for (FloatingWindow var8 : this.field21942) {
         if (var8.method01682() == var5) {
            var8.method09567(var6 && var8.method09559());
            var8.method00612(var1, var2, var3, var4);
         }
      }
   }

   public void method09650(double var1, double var3, double var5, double var7, double var9) {
      for (FloatingWindow var12 : this.field21942) {
         double var13 = var12.method01682() ? var5 : var1;
         double var15 = var12.method01682() ? var7 : var3;
         if (GuiHitTestUtils.method05609(var13, var15, var12.method09576(), var12.method09560(), var12.method09568(), var12.method09574())) {
            var12.method01685(var13, var15, var9);
         }
      }
   }

   public void method09651(double var1, double var3, double var5) {
      this.method09650(var1, var3, var1, var3, var5);
   }

   public void method09652(FloatingWindow var1, float var2, float var3) {
      if (this.method09669(var1.method09562()) == null) {
         var1.method09571(var2);
         var1.method09563(var3);
         var1.method09577(this);
         var1.method04220();
         this.field21942.add(var1);
         var1.method09572(true);
      }
   }

   public void method09653(double var1, double var3, int var5) {
      this.method09658(var1, var3, var1, var3, var5);
   }

   public void method09654(FloatingWindow var1) {
      var1.method09572(false);
   }

   public List<FloatingWindow> method09655() {
      return this.field21942;
   }

   public void method09658(double var1, double var3, double var5, double var7, int var9) {
      for (FloatingWindow var11 : this.field21942) {
         double var12 = var11.method01682() ? var5 : var1;
         double var14 = var11.method01682() ? var7 : var3;
         boolean var16 = GuiHitTestUtils.method05609(var12, var14, var11.method09576(), var11.method09560(), var11.method09568(), var11.method09574());
         boolean var17 = var11.method06786();
         if (var16 || var17) {
            var11.method00613(var12, var14, var9);
         }

         if (!var16 && !var17 && var9 != 7 && var11.method09569() && var11.method09558().method04699(field21944) && var11.method01686()) {
            this.method09654(var11);
         }
      }
   }

   public void method09659(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      for (FloatingWindow var6 : this.field21942) {
         var6.method00612(var1, var2, var3, var4);
      }
   }

   public boolean method09661(double var1, double var3, double var5, double var7) {
      return this.field21942.stream().anyMatch(var8 -> {
         double var9 = var8.method01682() ? var5 : var1;
         double var11 = var8.method01682() ? var7 : var3;
         return GuiHitTestUtils.method05609(var9, var11, var8.method09576(), var8.method09560(), var8.method09568(), var8.method09574());
      });
   }

   public void method09662(char var1, int var2) {
      for (FloatingWindow var4 : this.field21942) {
         var4.method01898(var1, var2);
      }
   }

   public void method09663(double var1, double var3, double var5, double var7, int var9) {
      for (FloatingWindow var11 : this.field21942) {
         double var12 = var11.method01682() ? var5 : var1;
         double var14 = var11.method01682() ? var7 : var3;
         var11.method01689(var12, var14, var9);
      }
   }

   static {
      field21943.put(field21945, field21946);
      field21943.put(field21947, field21948);
      field21943.put(field21949, field21950);
      field21943.put(field21951, field21952);
      field21943.put(field21953, field21954);
      field21943.put(field21955, field21956);
   }

   public void method09664(double var1, double var3, int var5) {
      this.method09663(var1, var3, var1, var3, var5);
   }

   public boolean method09665() {
      return this.field21942.stream().anyMatch(FloatingWindow::method09570);
   }

   public boolean method09666() {
      return this.field21942.stream().anyMatch(FloatingWindow::method06786);
   }

   public <T extends FloatingWindow> T method09667(Class<T> var1) {
      return (T)(Object)this.field21942.stream().filter(var1x -> var1x.getClass().equals(var1)).findFirst().orElse(null);
   }

   public boolean method09668(double var1, double var3) {
      return this.method09661(var1, var3, var1, var3);
   }

   public <T extends FloatingWindow> T method09669(String var1) {
      return (T)(Object)this.field21942.stream().filter(var1x -> var1x.method09562().equals(var1)).findFirst().orElse(null);
   }

   public void method09670(int var1, int var2, int var3) {
      for (FloatingWindow var5 : this.field21942) {
         var5.method00611(var1, var2, var3);
      }
   }
}
