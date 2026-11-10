// Original binary: sg/ec/EXXpCoRJIvof5GaF
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3x2fStack;
import org.joml.Vector2f;

// $VF: Compiled from s
public class Ambience extends ClientModule {
   private static final String field07084 = "Время суток";
   private static final String field07085 = "field07085";
   private static final String field07086 = "field07086";
   private static final String field07087 = "field07087";
   private static final String field07088 = "field07088";
   private static final String field07089 = "field07089";
   private static final String field07090 = "field07090";
   private final MultiToggleSetting field07091;
   private final NumberSetting<Long> field07092;
   private final NumberSetting<Float> field07093;
   private final NumberSetting<Float> field07094;
   private final ToggleSetting field07095;
   private final ColorSetting field07096;
   private final ColorSetting field07097;
   private final ColorSetting field07098;
   private final ColorSetting field07099;
   private final NumberSetting<Float> field07100;
   private final MultiToggleSetting field07101;
   private final ColorSetting field07102;
   private final NumberSetting<Float> field07103;
   private boolean field07104;
   private boolean field07105;
   private boolean field07106;
   private static final float field07107 = 0;
   private static final float field07108 = 0;
   private static final float field07109 = 0;
   private static final float field07110 = 0;
   private static final float field07111 = 0;
   private static final float field07112 = 0;
   private static final float field07113 = 0;
   private static final float field07114 = 0;
   private static final int field07115 = ColorUtils.method04604(255, 225, 60);
   private static final int field07116 = ColorUtils.method04604(255, 45, 45);
   private static final int field07117 = ColorUtils.method04597(25, 25, 25, 170);
   private final List<Ambience.Nested90> field07118;
   private static final String field07119 = "Что менять";
   private static final String field07120 = "Время суток";
   private static final String field07121 = "Туман";
   private static final String field07122 = "Небо";
   private static final String field07123 = "Облака";
   private static final String field07124 = "Партиклы хит дамага";
   private static final String field07125 = "Время";
   private static final long field07126 = 24000L;
   private static final long field07127 = 100L;
   private static final long field07128 = 5000L;
   private static final String field07129 = "Начало тумана";
   private static final float field07130 = 0.1F;
   private static final float field07131 = 2.5F;
   private static final float field07132 = 0.05F;
   private static final String field07133 = "Конец тумана";
   private static final float field07134 = 0.1F;
   private static final float field07135 = 2.5F;
   private static final float field07136 = 0.05F;
   private static final float field07137 = 1.2F;
   private static final String field07138 = "Менять цвет";
   private static final String field07139 = "Цвет тумана";
   private static final String field07140 = "Цвет неба";
   private static final String field07141 = "Цвет облаков";
   private static final String field07142 = "Цвет хила";
   private static final String field07143 = "Размер хит дамага";
   private static final float field07144 = 5.0F;
   private static final float field07145 = 0.1F;
   private static final float field07146 = 3.0F;
   private static final String field07147 = "Визуализация мира";
   private static final String field07148 = "Менять цвет";
   private static final String field07149 = "Менять насыщение";
   private static final String field07150 = "Цвет визуализации";
   private static final String field07151 = "Насыщение";
   private static final float field07152 = 0.5F;
   private static final float field07153 = 2.5F;
   private static final float field07154 = 0.05F;
   private static final float field07155 = 1.5F;
   private static final String field07156 = "Ambience";
   private static final String field07157 = "Время суток";
   private static final long field07158 = -1L;
   private static final String field07159 = "Менять цвет";
   private static final String field07160 = "Менять насыщение";
   private static final String field07161 = "Менять насыщение";
   private static final String field07162 = "Менять цвет";
   private static final float field07163 = 255.0F;
   private static final String field07164 = "Туман";
   private static final String field07165 = "Небо";
   private static final String field07166 = "Облака";
   private static final String field07167 = "Партиклы хит дамага";
   private static final float field07168 = 0.1F;
   private static final float field07169 = -0.3F;
   private static final float field07170 = 0.3F;
   private static final float field07171 = 0.15F;
   private static final float field07172 = 0.45F;
   private static final float field07173 = -0.3F;
   private static final float field07174 = 0.3F;
   private static final float field07175 = 0.4F;
   private static final float field07176 = 9.0F;
   private static final float field07177 = 0.65F;
   private static final float field07178 = 0.35000002F;
   private static final float field07179 = Float.MAX_VALUE;
   private static final float field07180 = 0.01F;
   private static final float field07181 = 9.0F;
   private static final float field07182 = 5.0F;
   private static final float field07183 = 5.0F;
   private static final float field07184 = 10.0F;
   private static final float field07185 = 10.0F;
   private static final float field07186 = 0.35F;
   private static final String field07187 = "Менять насыщение";
   private static final String field07188 = "Менять цвет";
   private static final String field07189 = "Партиклы хит дамага";
   private static final String field07190 = "Партиклы хит дамага";
   private static final String field07191 = "Облака";
   private static final String field07192 = "Небо";
   private static final String field07193 = "Туман";
   private static final String field07194 = "Туман";
   private static final String field07195 = "Туман";
   private static final String field07196 = "Туман";
   private static final String field07197 = "Время суток";

   public boolean method03239() {
      return this.field07101.method04520(field07159) || this.field07101.method04520(field07160);
   }

   @Subscribe
   private void method03242(FogColorEvent var1) {
      if (this.field07104) {
         if (this.field07095.method05999()) {
            var1.method00572(this.field07096.method11676());
         }

         var1.method00574(this.field07093.method03022());
         var1.method00576(this.field07094.method03022());
         var1.method05695(true);
      }
   }

   public long method03244() {
      return this.field07091.method04520(field07157) ? this.field07092.method03022() : field07158;
   }

   @Subscribe
   private void method03245(TickEvent var1) {
      if (mc.player != null && mc.level != null) {
         boolean var2 = this.field07091.method04520(field07167);
         if (!var2) {
            this.field07118.clear();
         } else {
            this.field07118.removeIf(var0 -> var0.method03267());
         }

         for (Player var4 : mc.level.players()) {
            LastHealthAccess var5 = (LastHealthAccess)var4;
            float var6 = PlayerUtils.method11820(var4);
            float var7 = var5.lastHealth();
            var5.setLastHealth(var6);
            if (var2 && !(var7 <= 0.0F) && !var4.isDeadOrDying()) {
               float var8 = var7 - var6;
               if (!(Math.abs(var8) < field07168)) {
                  Vec3 var9 = var4.position()
                     .add(
                        GuiHitTestUtils.method05613(field07169, field07170),
                        var4.getBbHeight() + GuiHitTestUtils.method05613(field07171, field07172),
                        GuiHitTestUtils.method05613(field07173, field07174)
                     );
                  this.field07118.add(new Ambience.Nested90(var9, var8, 30 + GuiHitTestUtils.field11989.nextInt(21)));
               }
            }
         }
      }
   }

   public float method03248() {
      return this.field07101.method04520(field07162) ? this.field07102.method03022().getAlpha() / field07163 : 0.0F;
   }

   @Subscribe(1)
   private void method03251(HudRenderEvent var1) {
      if (!this.field07118.isEmpty()) {
         GuiGraphics var2 = var1.method05424();
         PoseStack var3 = var1.method05425();
         float var4 = var1.method05421().getGameTimeDeltaPartialTick(false);
         float var5 = this.field07100.method03022() * field07175;
         Objects.requireNonNull(mc.font);
         float var6 = field07176 * var5;
         int var7 = this.field07099.method11676();
         GuiRenderBatch.method05194();

         for (Ambience.Nested90 var9 : this.field07118) {
            float var10 = var9.method03279(var4);
            float var11 = var10 < field07177 ? 1.0F : (1.0F - var10) / field07178;
            Vector2f var12 = WorldProjectionUtils.method09460(var3, var9.method03277());
            var9.method03270(var12.x != field07179 && var11 > field07180);
            if (var9.method03266()) {
               var9.method03274(var12.x);
               var9.method03264(var12.y);
               var9.method03265(var11);
               var9.method03271(var9.method03278() ? var7 : ColorUtils.method04583(field07115, field07116, (var9.method03269() - 1.0F) / field07181));
               float var13 = mc.font.width(var9.method03273()) * var5 + field07182;
               float var14 = var6 + field07183;
               float var15 = var12.x - var13 / 2.0F;
               float var16 = var12.y - var14 / 2.0F;
               float var17 = field07184;
               RoundedRectRenderer.method01272(
                  var2,
                  var15 - var17 / 2.0F,
                  var16 - var17 / 2.0F,
                  var13 + var17,
                  var14 + var17,
                  field07185,
                  var17,
                  ColorUtils.method04611(var9.method03261(), var11 * field07186)
               );
            }
         }

         GuiRenderBatch.method05181();
         Matrix3x2fStack var18 = var2.pose();

         for (Ambience.Nested90 var20 : this.field07118) {
            if (var20.method03266()) {
               var18.pushMatrix();
               var18.translate(var20.method03263(), var20.method03276());
               var18.scale(var5, var5);
               var2.drawCenteredString(mc.font, var20.method03273(), 0, -9 / 2, ColorUtils.method04611(var20.method03261(), var20.method03275()));
               var18.popMatrix();
            }
         }
      }
   }

   public int method03252() {
      return this.field07102.method11676();
   }

   @Override
   public void method00276() {
      super.method00276();
      this.field07118.clear();
      if (mc.level != null) {
         for (Player var2 : mc.level.players()) {
            ((LastHealthAccess)var2).setLastHealth(PlayerUtils.method11820(var2));
         }
      }
   }

   @Subscribe
   private void method03254(TickEvent var1) {
      this.field07104 = this.field07091.method04520(field07164);
      this.field07105 = this.field07091.method04520(field07165);
      this.field07106 = this.field07091.method04520(field07166);
   }

   @Override
   public void method00245() {
      super.method00245();
      this.field07118.clear();
   }

   public float method03258() {
      return this.field07101.method04520(field07161) ? this.field07103.method03022() : 1.0F;
   }

   @Subscribe
   private void method03259(WorldColorEvent var1) {
      switch (var1.method01253()) {
         case SKY:
            if (this.field07105) {
               var1.method01254(this.field07097.method11676());
            }
            break;
         case CLOUD:
            if (this.field07106) {
               var1.method01254(this.field07098.method11676());
            }
      }
   }

   public Ambience() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field07091 = new MultiToggleSetting(field07119)
         .method04517(NamedOption.method08077(field07120, false))
         .method04517(NamedOption.method08077(field07121, false))
         .method04517(NamedOption.method08077(field07122, false))
         .method04517(NamedOption.method08077(field07123, false))
         .method04517(NamedOption.method08077(field07124, false))
         .method03023(this);
      this.field07092 = new NumberSetting<Long>(field07125)
         .method10835(0L)
         .method10838(field07126)
         .method10834(field07127)
         .method03017(field07128)
         .method03025(() -> this.field07091.method04520(field07197))
         .method03023(this);
      this.field07093 = new NumberSetting<Float>(field07129)
         .method10835(field07130)
         .method10838(field07131)
         .method10834(field07132)
         .method03017(1.0F)
         .method03025(() -> this.field07091.method04520(field07196))
         .method03023(this);
      this.field07094 = new NumberSetting<Float>(field07133)
         .method10835(field07134)
         .method10838(field07135)
         .method10834(field07136)
         .method03017(field07137)
         .method03025(() -> this.field07091.method04520(field07195))
         .method03023(this);
      this.field07095 = new ToggleSetting(field07138).method03017(false).method03025(() -> this.field07091.method04520(field07194)).method03023(this);
      this.field07096 = new ColorSetting(field07139)
         .method11666(1.0F)
         .method11683(1.0F)
         .method11669(1.0F)
         .method11674(1.0F)
         .method03017(new Color(-1))
         .method03025(() -> this.field07091.method04520(field07193) && this.field07095.method05999())
         .method03023(this);
      this.field07097 = new ColorSetting(field07140)
         .method11666(1.0F)
         .method11683(1.0F)
         .method11669(1.0F)
         .method11674(1.0F)
         .method03017(new Color(-1))
         .method03025(() -> this.field07091.method04520(field07192))
         .method03023(this);
      this.field07098 = new ColorSetting(field07141)
         .method11666(1.0F)
         .method11683(1.0F)
         .method11669(1.0F)
         .method11674(1.0F)
         .method03017(new Color(-1))
         .method03025(() -> this.field07091.method04520(field07191))
         .method03023(this);
      this.field07099 = new ColorSetting(field07142)
         .method03017(new Color(70, 230, 110))
         .method03025(() -> this.field07091.method04520(field07190))
         .method03023(this);
      this.field07100 = new NumberSetting<Float>(field07143)
         .method10835(1.0F)
         .method10838(field07144)
         .method10834(field07145)
         .method03017(field07146)
         .method03025(() -> this.field07091.method04520(field07189))
         .method03023(this);
      this.field07101 = new MultiToggleSetting(field07147)
         .method04517(NamedOption.method08077(field07148, false))
         .method04517(NamedOption.method08077(field07149, false))
         .method03023(this);
      this.field07102 = new ColorSetting(field07150)
         .method11666(1.0F)
         .method11683(1.0F)
         .method11669(1.0F)
         .method11674(1.0F)
         .method03017(new Color(0, 200, 90, 150))
         .method03025(() -> this.field07101.method04520(field07188))
         .method03023(this);
      this.field07103 = new NumberSetting<Float>(field07151)
         .method10835(field07152)
         .method10838(field07153)
         .method10834(field07154)
         .method03017(field07155)
         .method03025(() -> this.field07101.method04520(field07187))
         .method03023(this);
      this.field07104 = false;
      this.field07105 = false;
      this.field07106 = false;
      this.field07118 = new ArrayList<>();
      this.method03935(field07156);
   }

   // $VF: Compiled from s
   private static class Nested90 {
      private final Vec3 field07198;
      private final String field07199;
      private final boolean field07200;
      private final float field07201;
      private int field07202;
      private int field07203;
      private final int field07204;
      private float field07205;
      private float field07206;
      private float field07207;
      private boolean field07208;
      private static final float field07209 = 10.0F;

      public int method03261() {
         return this.field07202;
      }

      public Nested90(Vec3 var1, float var2, int var3) {
         this.field07198 = var1;
         this.field07204 = var3;
         this.field07200 = var2 < 0.0F;
         this.field07201 = Math.abs(var2);
         int var4 = Math.round(this.field07201 * field07209);
         this.field07199 = var4 / 10 + "," + var4 % 10;
      }

      public void method03262(int var1) {
         this.field07203 = var1;
      }

      public float method03263() {
         return this.field07205;
      }

      public void method03264(float var1) {
         this.field07206 = var1;
      }

      public void method03265(float var1) {
         this.field07207 = var1;
      }

      public boolean method03266() {
         return this.field07208;
      }

      public boolean method03267() {
         return ++this.field07203 >= this.field07204;
      }

      public int method03268() {
         return this.field07204;
      }

      public float method03269() {
         return this.field07201;
      }

      public void method03270(boolean var1) {
         this.field07208 = var1;
      }

      public void method03271(int var1) {
         this.field07202 = var1;
      }

      public int method03272() {
         return this.field07203;
      }

      public String method03273() {
         return this.field07199;
      }

      public void method03274(float var1) {
         this.field07205 = var1;
      }

      public float method03275() {
         return this.field07207;
      }

      public float method03276() {
         return this.field07206;
      }

      public Vec3 method03277() {
         return this.field07198;
      }

      public boolean method03278() {
         return this.field07200;
      }

      public float method03279(float var1) {
         return Math.min(1.0F, (this.field07203 + var1) / this.field07204);
      }
   }
}
