// Original binary: sg/ec/Pf5emAibAbMkoWkZ
package sg.ec;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.client.gui.GuiGraphicsExtractor;

// $VF: Compiled from s
public class SchedulesHud extends HudElement {
   private static final long field11053 = 1000000000000L;
   private static final String field11054 = "field11054";
   private final ElapsedTimer field11055 = new ElapsedTimer();
   private final DraggableElement field11056 = this.method06449(this, 0.0F, 0.0F);
   private final AnimationUtils field11057;
   private final List<SchedulesHud.Nested151> field11058;
   private final Map<String, SchedulesHud.Nested151> field11059;
   private final MultiToggleSetting field11060;
   private final NumberSetting<Integer> field11061;
   private float field11062;
   private static final String field11063 = "Schedules";
   private static final long field11064 = 150L;
   private static final String field11065 = "Евенты";
   private static final String field11066 = "Маяк";
   private static final String field11067 = "Адская резня";
   private static final String field11068 = "Вулкан";
   private static final String field11069 = "Смертельный сундук";
   private static final String field11070 = "Метеоритный дождь";
   private static final String field11071 = "Аирдроп";
   private static final String field11072 = "Гейзер";
   private static final String field11073 = "Алтарь нежити";
   private static final String field11074 = "Мистик";
   private static final String field11075 = "До голосования";
   private static final String field11076 = "Макс. евентов";
   private static final long field11077 = -1L;
   private static final float field11078 = 78.0F;
   private static final float field11079 = 0.001F;
   private static final float field11080 = 11.0F;
   private static final float field11081 = 78.0F;
   private static final float field11082 = 2.5F;
   private static final float field11083 = 5.0F;
   private static final String field11084 = "d";
   private static final float field11085 = 3.0F;
   private static final float field11086 = 0.001F;
   private static final float field11087 = 20.0F;
   private static final float field11088 = 11.0F;
   private static final float field11089 = 11.0F;
   private static final float field11090 = 5.0F;
   private static final float field11091 = 11.0F;
   private static final float field11092 = 11.0F;
   private static final long field11093 = 250L;
   private static final float field11094 = 12.0F;
   private static final String field11095 = "До голосования";
   private static final long field11096 = 1000000000000L;
   private static final long field11097 = 1000L;

   private String method05041(long var1, String var3) {
      boolean var4 = var3 != null && !var3.equals(field11095);
      if (var1 > 0L) {
         String sx = TextRenderUtils.method00670(var1);
         return var4 ? var3 + " " + sx : sx;
      } else {
         return var4 ? var3 : TextRenderUtils.method00670(0L);
      }
   }

   private long method05042(AnarchyServerInfo var1) {
      long var2 = System.currentTimeMillis();
      long var4 = method05048(var1.method11206());
      long var6 = method05048(var1.method11215());
      if (var4 > var2) {
         return var4 - var2;
      } else {
         return var6 > var2 ? var6 - var2 : Math.max(var4, var6) - var2;
      }
   }

   private String method05043(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         return this.field11060.method04523(var1).map(NamedOption::method08074).orElse(false) ? var1 : null;
      } else {
         return null;
      }
   }

   @Override
   public void method00024() {
      if (this.field11055.method04699(field11093)) {
         var var1 = GlobalConnectionManager.field08661;
         var var2 = new HashSet(var1.size());

         for (AnarchyServerInfo var4 : var1) {
            String var5 = this.method05047(var4);
            if (var5 != null) {
               long var6 = this.method05042(var4);
               if (var6 >= 0L) {
                  String var8 = this.method05049(var4);
                  var2.add(var8);
                  String var9 = this.method05046(var4);
                  String var10 = this.method05041(var6, var5);
                  SchedulesHud.Nested151 var11 = this.field11059.get(var8);
                  if (var11 == null) {
                     var11 = new SchedulesHud.Nested151(
                        var8,
                        var5,
                        var9,
                        field14601.method09478(var9, field14607, -field14608),
                        var10,
                        field14601.method09478(var10, field14607, -field14608),
                        var6
                     );
                     this.field11059.put(var8, var11);
                     this.field11058.add(var11);
                  } else {
                     if (!var9.equals(var11.method05056())) {
                        var11.method05066(var9);
                        var11.method05068(field14601.method09478(var9, field14607, -field14608));
                     }

                     if (!var10.equals(var11.method05062())) {
                        var11.method05060(var10);
                        var11.method05051(field14601.method09478(var10, field14607, -field14608));
                     }

                     var11.method05053(var5);
                     var11.method05057(var6);
                  }
               }
            }
         }

         this.field11058.sort(Comparator.comparingLong(SchedulesHud.Nested151::method05059));
         int var12 = this.field11061.method03022();
         int var13 = 0;
         float var14 = 0.0F;
         float var15 = 0.0F;

         for (SchedulesHud.Nested151 var16 : this.field11058) {
            boolean var17 = this.method05050(var16.method05054()) && var2.contains(var16.method05063());
            var16.method05064(var17);
            boolean var18 = var17 && var13 < var12;
            if (var18) {
               var13++;
               var14 = Math.max(var14, var16.method05058());
               var15 = Math.max(var15, var16.method05052() + 2.0F);
            }

            var16.method05067(var18);
         }

         this.field11062 = var14 + var15 + field11094;
         this.field11058.removeIf(var1x -> {
            if (!var1x.method05061() && var1x.method05065().method03384() == 0.0) {
               this.field11059.remove(var1x.method05063());
               return true;
            } else {
               return false;
            }
         });
         this.field11055.method04694();
      }

      super.method00024();
   }

   private static String method05045(String var0) {
      return var0 == null ? "" : var0;
   }

   public SchedulesHud() {
      super(field11063);
      this.field11057 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field11064);
      this.field11058 = new ArrayList<>();
      this.field11059 = new HashMap<>();
      this.field11060 = new MultiToggleSetting(field11065)
         .method04517(NamedOption.method08077(field11066, true))
         .method04517(NamedOption.method08077(field11067, true))
         .method04517(NamedOption.method08077(field11068, true))
         .method04517(NamedOption.method08077(field11069, true))
         .method04517(NamedOption.method08077(field11070, true))
         .method04517(NamedOption.method08077(field11071, true))
         .method04517(NamedOption.method08077(field11072, true))
         .method04517(NamedOption.method08077(field11073, true))
         .method04517(NamedOption.method08077(field11074, true))
         .method04517(NamedOption.method08077(field11075, false))
         .method03023(this);
      this.field11061 = new NumberSetting<Integer>(field11076).method10835(1).method10838(50).method10834(1).method03017(15).method03023(this);
      this.field11062 = field11078;
   }

   @Override
   public void method00027(GuiGraphicsExtractor var1) {
      super.method00027(var1);
      this.method06465(this.field11056.method02685());
      this.method06453(this.field11056.method02669());
      float var2 = 0.0F;

      for (SchedulesHud.Nested151 var4 : this.field11058) {
         AnimationUtils var5 = var4.method05065();
         var5.method03375(var4.method05055() ? 1.0 : 0.0);
         float var6 = var5.method03377();
         if (var6 > field11079) {
            var2 += var6 * field11080;
         }
      }

      this.field11057.method03375(Math.max(field11081, this.field11062));
      this.method06448(this.field11057.method03377());
      this.method06456(field14609 + Math.max(field11082, var2 + field11083));
      this.method06441(var1, field11084);
      float var12 = this.method06436();
      float var13 = var12 + this.method06458() - field11085;
      float var14 = this.method06464();
      int var15 = 0;

      for (SchedulesHud.Nested151 var8 : this.field11058) {
         float var9 = var8.method05065().method03377();
         if (!(var9 <= field11086)) {
            int var10 = ColorUtils.method04611(this.method06438(), var9);
            float var11 = var14 + field11087 + var9 * field11088 - field11089 + var15 * 11;
            field14601.method09490(var1, var8.method05056(), var12 + field11090, var11, var10, field14607, -field14608);
            field14601.method09490(var1, var8.method05062(), var13 - var8.method05052(), var11, var10, field14607, -field14608);
            var14 += field11091 * var9 - field11092;
            var15++;
         }
      }

      this.field11056.method02676(this.method06458());
      this.field11056.method02696(this.method06435());
   }

   private String method05046(AnarchyServerInfo var1) {
      String var2 = var1.method11218();
      if (var2 != null && !var2.isEmpty()) {
         return var2;
      }

      String var3 = var1.method11214();
      return var3 == null ? "" : var3;
   }

   private String method05047(AnarchyServerInfo var1) {
      String var2 = this.method05043(var1.method11222());
      return var2 != null ? var2 : this.method05043(var1.method11214());
   }

   private static long method05048(long var0) {
      if (var0 <= 0L) {
         return 0L;
      } else {
         return var0 < field11096 ? var0 * field11097 : var0;
      }
   }

   private String method05049(AnarchyServerInfo var1) {
      return method05045(var1.method11218())
         + "|"
         + method05045(var1.method11211())
         + "|"
         + method05045(var1.method11214())
         + "|"
         + method05045(var1.method11222());
   }

   private boolean method05050(String var1) {
      return var1 != null && !var1.isEmpty() ? this.field11060.method04523(var1).map(NamedOption::method08074).orElse(false) : false;
   }

   // $VF: Compiled from s
   public static class Nested151 {
      private final String field11098;
      private final AnimationUtils field11099;
      private String field11100;
      private String field11101;
      private float field11102;
      private String field11103;
      private float field11104;
      private long field11105;
      private boolean field11106;
      private boolean field11107;
      private static final long field11108 = 150L;

      public void method05051(float var1) {
         this.field11104 = var1;
      }

      public float method05052() {
         return this.field11104;
      }

      public void method05053(String var1) {
         this.field11100 = var1;
      }

      public String method05054() {
         return this.field11100;
      }

      public boolean method05055() {
         return this.field11107;
      }

      public String method05056() {
         return this.field11101;
      }

      public void method05057(long var1) {
         this.field11105 = var1;
      }

      public Nested151(String var1, String var2, String var3, float var4, String var5, float var6, long var7) {
         this.field11099 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field11108);
         this.field11098 = var1;
         this.field11100 = var2;
         this.field11101 = var3;
         this.field11102 = var4;
         this.field11103 = var5;
         this.field11104 = var6;
         this.field11105 = var7;
      }

      public float method05058() {
         return this.field11102;
      }

      public long method05059() {
         return this.field11105;
      }

      public void method05060(String var1) {
         this.field11103 = var1;
      }

      public boolean method05061() {
         return this.field11106;
      }

      public String method05062() {
         return this.field11103;
      }

      public String method05063() {
         return this.field11098;
      }

      public void method05064(boolean var1) {
         this.field11106 = var1;
      }

      public AnimationUtils method05065() {
         return this.field11099;
      }

      public void method05066(String var1) {
         this.field11101 = var1;
      }

      public void method05067(boolean var1) {
         this.field11107 = var1;
      }

      public void method05068(float var1) {
         this.field11102 = var1;
      }
   }
}
