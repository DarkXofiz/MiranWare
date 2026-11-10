// Original binary: sg/ec/MBVYMycCPZS5njUD
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.renderer.texture.TextureAtlas;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.resources.language.I18n;
import net.minecraft.data.AtlasIds;
import net.minecraft.resources.Identifier;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;

// $VF: Compiled from s
public class PotionsHud extends HudElement {
   private final List<PotionsHud.Nested136> field09994 = new ArrayList<>();
   private final DraggableElement field09995 = this.method06449(this, 0.0F, 0.0F);
   private final AnimationUtils field09996;
   private static final String field09997 = "Potions";
   private static final long field09998 = 150L;
   private static final float field09999 = 12.5F;
   private static final float field10000 = 0.001F;
   private static final float field10001 = 11.0F;
   private static final float field10002 = 15.0F;
   private static final float field10003 = 65.0F;
   private static final float field10004 = 2.5F;
   private static final float field10005 = 5.0F;
   private static final String field10006 = "Y";
   private static final float field10007 = 0.001F;
   private static final float field10008 = 20.0F;
   private static final float field10009 = 11.0F;
   private static final float field10010 = 11.0F;
   private static final float field10011 = 5.0F;
   private static final float field10012 = 0.5F;
   private static final float field10013 = 10.0F;
   private static final float field10014 = 10.0F;
   private static final float field10015 = 7.0F;
   private static final float field10016 = 5.0F;
   private static final float field10017 = 11.0F;
   private static final float field10018 = 11.0F;
   private static final float field10019 = 10.0F;
   private static final float field10020 = 0.5F;
   private static final float field10021 = 0.5F;
   private static final float field10022 = 10.0F;
   private static final double field10023 = Math.PI;
   private static final double field10024 = 2.0;
   private static final float field10025 = 0.001F;

   @Override
   public void method00027(GuiGraphics var1) {
      super.method00027(var1);
      this.method06465(this.field09995.method02685());
      this.method06453(this.field09995.method02669());
      float var2 = 0.0F;
      float sx = 0.0F;
      float sxx = field09999;

      for (PotionsHud.Nested136 sxxx : this.field09994) {
         AnimationUtils sxxxx = sxxx.method04497();
         sxxxx.method03375(sxxx.method04498() ? 0.0 : 1.0);
         float sxxxxx = sxxxx.method03377();
         if (!(sxxxxx <= field10000)) {
            sx += sxxxxx * field10001;
            var2 = Math.max(sxxx.method04513() + sxxx.method04492() + sxxx.method04499() + field10002 + sxx, var2);
         }
      }

      this.field09996.method03375(Math.max(field10003, var2));
      float sxxx = Math.max(field10004, sx + field10005);
      this.method06448(this.field09996.method03377());
      this.method06456(field14609 + sxxx);
      this.method06441(var1, field10006);
      TextureAtlas sxxxx = mc.getAtlasManager().getAtlasOrThrow(AtlasIds.GUI);
      float sxxxxx = this.method06464();
      int sxxxxxx = 0;

      for (PotionsHud.Nested136 sxxxxxxx : this.field09994) {
         float sxxxxxxxx = sxxxxxxx.method04497().method03377();
         if (!(sxxxxxxxx <= field10007)) {
            float sxxxxxxxxx = this.method04480(sxxxxxxxx, sxxxxxxx.method04488().getDuration());
            int sxxxxxxxxxx = ColorUtils.method04611(this.method06438(), sxxxxxxxxx);
            int sxxxxxxxxxxx = ColorUtils.method04611(ColorUtils.method04604(255, 100, 100), sxxxxxxxxx);
            float sxxxxxxxxxxxx = sxxxxx + field10008 + sxxxxxxxx * field10009 - field10010 + sxxxxxx * 11;
            float sxxxxxxxxxxxxx = this.method06436() + field10011;
            TextureAtlasSprite sxxxxxxxxxxxxxx = sxxxxxxx.method04511(sxxxx);
            float sxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxx.getU0();
            float sxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxx.getV0();
            float sxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxx.getU1() - sxxxxxxxxxxxxxxx;
            float sxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxx.getV1() - sxxxxxxxxxxxxxxxx;
            GuiTextureRenderer.method10253(
               var1,
               sxxxxxxxxxxxxxx.atlasLocation(),
               sxxxxxxxxxxxxxxx,
               sxxxxxxxxxxxxxxxx,
               sxxxxxxxxxxxxxxxxx,
               sxxxxxxxxxxxxxxxxxx,
               sxxxxxxxxxxxxx,
               sxxxxxxxxxxxx - field10012,
               field10013,
               field10014,
               CornerRadii.NO_ROUND,
               0.0F,
               new CornerColors(ColorUtils.method04611(-1, sxxxxxxxxx))
            );
            field14601.method09490(var1, sxxxxxxx.method04509(), sxxxxxxxxxxxxx + sxx, sxxxxxxxxxxxx, sxxxxxxxxxx, field14607, -field14608);
            field14601.method09490(
               var1,
               sxxxxxxx.method04496(),
               this.method06436() + sxxxxxxx.method04513() + field10015 + sxx,
               sxxxxxxxxxxxx,
               sxxxxxxxxxxx,
               field14607,
               -field14608
            );
            field14601.method09490(
               var1,
               sxxxxxxx.method04512(),
               this.method06436() + this.method06458() - sxxxxxxx.method04492() - field10016,
               sxxxxxxxxxxxx,
               sxxxxxxxxxx,
               field14607,
               -field14608
            );
            sxxxxx += field10017 * sxxxxxxxx - field10018;
            sxxxxxx++;
         }
      }

      this.field09995.method02676(this.method06458());
      this.field09995.method02696(this.method06435());
   }

   private void method04479(PotionsHud.Nested136 var1) {
      String var2 = var1.method04509();
      String var3 = TextRenderUtils.method00667(var1.method04488(), 1.0F);
      String var4 = var1.method04488().getAmplifier() > 0 ? String.valueOf(var1.method04488().getAmplifier() + 1) : "";
      if (!var2.equals(var1.method04485())) {
         var1.method04505(var2);
         var1.method04491(field14601.method09478(var2, field14607, -field14608));
      }

      if (!var3.equals(var1.method04512())) {
         var1.method04490(var3);
         var1.method04489(field14601.method09478(var3, field14607, -field14608));
      }

      if (!var4.equals(var1.method04496())) {
         var1.method04510(var4);
         var1.method04504(field14601.method09478(var4, field14607, -field14608));
      }
   }

   private float method04480(float var1, int var2) {
      return var2 < 200 ? method04483(var1, var2, mc.getDeltaTracker().getRealtimeDeltaTicks()) : var1;
   }

   private PotionsHud.Nested136 method04481(MobEffectInstance var1) {
      MobEffect var2 = var1.getEffect().value();
      int var3 = var1.getAmplifier();

      for (PotionsHud.Nested136 var5 : this.field09994) {
         MobEffectInstance var6 = var5.method04488();
         if (var6 == var1) {
            return var5;
         }

         if (!var5.method04498() && var6.getEffect().value() == var2 && var6.getAmplifier() == var3) {
            return var5;
         }
      }

      return null;
   }

   public PotionsHud() {
      super(field09997);
      this.field09996 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field09998);
   }

   @Override
   public void method00012(MobEffectEvent var1) {
      super.method00012(var1);
      MobEffectInstance var2 = var1.method08685();
      MobEffectEvent.Nested241 var3 = var1.method08688();
      PotionsHud.Nested136 var4 = this.method04481(var2);
      if (var3 == MobEffectEvent.Nested241.ADD) {
         if (var4 == null || var4.method04498()) {
            PotionsHud.Nested136 var10 = new PotionsHud.Nested136(I18n.get(var2.getDescriptionId()), var2);
            var10.method04502(Gui.getMobEffectSprite(var10.field10026.getEffect()));
            this.method04479(var10);
            this.field09994.add(var10);
         }
      } else {
         if (var3 == MobEffectEvent.Nested241.REMOVE) {
            boolean var5 = false;

            for (PotionsHud.Nested136 var7 : this.field09994) {
               if (var7.method04488() == var2) {
                  var7.method04500(true);
                  var5 = true;
               }
            }

            if (!var5) {
               MobEffect var11 = var2.getEffect().value();

               for (PotionsHud.Nested136 var8 : this.field09994) {
                  MobEffectInstance var9 = var8.method04488();
                  if (var9.getEffect().value() == var11) {
                     var8.method04500(true);
                  }
               }
            }
         }
      }
   }

   private static float method04483(float var0, int var1, float var2) {
      float var3 = (var1 + var2) % field10019;
      float var4 = field10020 + field10021 * (float)Math.cos(var3 / field10022 * field10023 * field10024);
      return var0 * var4;
   }

   @Override
   public void method00024() {
      this.field09994.removeIf(var0 -> var0.method04498() && var0.method04497().method03377() <= field10025);
      var var1 = new ArrayList<>(mc.player.getActiveEffects());

      for (PotionsHud.Nested136 var3 : this.field09994) {
         if (!var3.method04498()) {
            MobEffectInstance var4 = var3.method04488();
            int var5 = this.method04484(var1, var4.getEffect().value());
            if (var5 == -1) {
               var3.method04500(true);
            } else {
               MobEffectInstance var6 = (MobEffectInstance)var1.remove(var5);
               if (var6 != var4) {
                  var3.method04506(var6);
                  this.method04479(var3);
               }

               this.method04479(var3);
            }
         }
      }

      for (MobEffectInstance var8 : var1) {
         if (this.method04481(var8) == null) {
            PotionsHud.Nested136 var9 = new PotionsHud.Nested136(I18n.get(var8.getDescriptionId()), var8);
            var9.method04502(Gui.getMobEffectSprite(var9.field10026.getEffect()));
            this.method04479(var9);
            this.field09994.add(var9);
         }
      }
   }

   private int method04484(List<MobEffectInstance> var1, MobEffect var2) {
      for (int var3 = 0; var3 < var1.size(); var3++) {
         MobEffectInstance var4 = (MobEffectInstance)var1.get(var3);
         if (var4.getEffect().value() == var2) {
            return var3;
         }
      }

      return -1;
   }

   // $VF: Compiled from s
   public static final class Nested136 {
      private MobEffectInstance field10026;
      private String field10027;
      private AnimationUtils field10028;
      private boolean field10029;
      private String field10030;
      private String field10031;
      private String field10032;
      private Identifier field10033;
      private TextureAtlasSprite field10034;
      private TextureAtlas field10035;
      private Identifier field10036;
      private float field10037;
      private float field10038;
      private float field10039;
      private static final long field10040 = 150L;

      public String method04485() {
         return this.field10030;
      }

      public Identifier method04486() {
         return this.field10033;
      }

      public TextureAtlas method04487() {
         return this.field10035;
      }

      public MobEffectInstance method04488() {
         return this.field10026;
      }

      public void method04489(float var1) {
         this.field10038 = var1;
      }

      public void method04490(String var1) {
         this.field10031 = var1;
      }

      public void method04491(float var1) {
         this.field10037 = var1;
      }

      public float method04492() {
         return this.field10038;
      }

      Nested136(String var1, MobEffectInstance var2) {
         this.field10028 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field10040);
         this.field10030 = "";
         this.field10031 = "";
         this.field10032 = "";
         this.field10027 = var1;
         this.field10026 = var2;
      }

      public void method04493(String var1) {
         this.field10027 = var1;
      }

      public void method04494(TextureAtlasSprite var1) {
         this.field10034 = var1;
      }

      public void method04495(TextureAtlas var1) {
         this.field10035 = var1;
      }

      public String method04496() {
         return this.field10032;
      }

      public AnimationUtils method04497() {
         return this.field10028;
      }

      public boolean method04498() {
         return this.field10029;
      }

      public float method04499() {
         return this.field10039;
      }

      public void method04500(boolean var1) {
         this.field10029 = var1;
      }

      public void method04501(AnimationUtils var1) {
         this.field10028 = var1;
      }

      public void method04502(Identifier var1) {
         this.field10033 = var1;
      }

      public void method04503(Identifier var1) {
         this.field10036 = var1;
      }

      public void method04504(float var1) {
         this.field10039 = var1;
      }

      public void method04505(String var1) {
         this.field10030 = var1;
      }

      public void method04506(MobEffectInstance var1) {
         this.field10026 = var1;
      }

      public Identifier method04507() {
         return this.field10036;
      }

      public TextureAtlasSprite method04508() {
         return this.field10034;
      }

      public String method04509() {
         return this.field10027;
      }

      public void method04510(String var1) {
         this.field10032 = var1;
      }

      TextureAtlasSprite method04511(TextureAtlas var1) {
         if (this.field10034 == null || this.field10035 != var1 || this.field10036 != this.field10033) {
            this.field10034 = var1.getSprite(this.field10033);
            this.field10035 = var1;
            this.field10036 = this.field10033;
         }

         return this.field10034;
      }

      public String method04512() {
         return this.field10031;
      }

      public float method04513() {
         return this.field10037;
      }
   }
}
