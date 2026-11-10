// Original binary: sg/ec/j07AwEzRvaSz5Ujh
package sg.ec;

import java.util.List;
import net.minecraft.client.renderer.state.MapRenderState.MapDecorationRenderState;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffects;

// $VF: Compiled from s
public class Removals extends ClientModule {
   private final MultiToggleSetting field20145;
   private final ToggleSetting field20146;
   private final MultiToggleSetting field20147;
   private final NumberSetting<Float> field20148;
   private static final int field20149 = 16;
   private static final int field20150 = 0;
   private boolean field20151;
   private boolean field20152;
   private boolean field20153;
   private boolean field20154;
   private boolean field20155;
   private boolean field20156;
   private boolean field20157;
   private boolean field20158;
   private boolean field20159;
   private boolean field20160;
   private boolean field20161;
   private static final String field20162 = "Типы";
   private static final String field20163 = "Огонь на экране";
   private static final String field20164 = "Тряска экрана";
   private static final String field20165 = "Ограничение от f5";
   private static final String field20166 = "Предметные Тайтлы";
   private static final String field20167 = "Скорборд";
   private static final String field20168 = "Оверлейное сообщение";
   private static final String field20169 = "Поп тотема";
   private static final String field20170 = "Список эффектов";
   private static final String field20171 = "Плохие эффекты";
   private static final String field20172 = "Затемнение в воде";
   private static final String field20173 = "Затемнение в лаве";
   private static final String field20174 = "Погода";
   private static final String field20175 = "Лаг Машина";
   private static final String field20176 = "Убрать звуки";
   private static final String field20177 = "Звуки";
   private static final String field20178 = "Течение воды";
   private static final String field20179 = "Капанье воды";
   private static final String field20180 = "Призыв визера";
   private static final String field20181 = "Призыв дракона";
   private static final String field20182 = "Запуск фейерверка";
   private static final String field20183 = "Бутылочка опыта";
   private static final String field20184 = "Сила заглушения";
   private static final float field20185 = 0.1F;
   private static final float field20186 = 0.5F;
   private static final String field20187 = "Removals";
   private static final String field20188 = "Поп тотема";
   private static final String field20189 = "Лаг Машина";
   private static final String field20190 = "Плохие эффекты";
   private static final String field20191 = "Тряска экрана";
   private static final String field20192 = "Огонь на экране";
   private static final String field20193 = "Ограничение от f5";
   private static final String field20194 = "Скорборд";
   private static final String field20195 = "Предметные Тайтлы";
   private static final String field20196 = "Оверлейное сообщение";
   private static final String field20197 = "Список эффектов";
   private static final String field20198 = "Затемнение в воде";
   private static final String field20199 = "Затемнение в лаве";
   private static final String field20200 = "Погода";
   private static final String field20201 = "Течение воды";
   private static final String field20202 = "Капанье воды";
   private static final String field20203 = "Призыв дракона";
   private static final String field20204 = "Призыв визера";
   private static final String field20205 = "Запуск фейерверка";
   private static final String field20206 = "Бутылочка опыта";

   @Subscribe
   private void method08862(VisualRemovalEvent var1) {
      boolean var2 = switch (var1.method08694()) {
         case FIRE -> this.field20152;
         case NOHURTCAM -> this.field20153;
         case F5_XUETA -> this.field20154;
         case SCOREBOARD -> this.field20155;
         case TOTEM -> this.field20145.method04520(field20188);
         case ITEM_TITLES -> this.field20156;
         case OVERLAY_MESSAGE -> this.field20157;
         case MINECRAFT_EFFECTS -> this.field20158;
         case WATER_FOG -> this.field20159;
         case LAVA_FOG -> this.field20160;
         case NIGHT_VISION_FOG -> false;
         case LAG_MACHINE -> this.method08870(var1.method08699());
      };
      if (var2) {
         var1.method05695(true);
      }
   }

   @Subscribe
   private void method08863(NauseaStrengthEvent var1) {
      if (this.field20151) {
         var1.method05695(true);
      }
   }

   @Subscribe
   private void method08864(MobEffectVisibilityEvent var1) {
      if (this.field20151) {
         MobEffect var2 = var1.method00609();
         if (var2 != null) {
            if (var2.equals(MobEffects.NAUSEA.value()) || var2.equals(MobEffects.DARKNESS.value())) {
               var1.method05695(true);
            }
         }
      }
   }

   @Subscribe
   private void method08865(WorldSoundEvent var1) {
      if (this.field20146.method05999()) {
         var1.method08881(this.field20148.method03022());

         boolean var2 = switch (var1.method08872()) {
            case WATER -> this.field20147.method04520(field20201);
            case WATER_DRIP -> this.field20147.method04520(field20202);
            case DRAGON_SUMMON -> this.field20147.method04520(field20203);
            case WITHER_RELEASED -> this.field20147.method04520(field20204);
            case FIREWORK -> this.field20147.method04520(field20205);
            case EXPERIENCE_BOTTLE -> this.field20147.method04520(field20206);
         };
         if (var2) {
            var1.method05696();
         }
      }
   }

   @Subscribe
   private void method08867(TickEvent var1) {
      this.field20151 = this.field20145.method04520(field20190);
      this.field20153 = this.field20145.method04520(field20191);
      this.field20152 = this.field20145.method04520(field20192);
      this.field20154 = this.field20145.method04520(field20193);
      this.field20155 = this.field20145.method04520(field20194);
      this.field20156 = this.field20145.method04520(field20195);
      this.field20157 = this.field20145.method04520(field20196);
      this.field20158 = this.field20145.method04520(field20197);
      this.field20159 = this.field20145.method04520(field20198);
      this.field20160 = this.field20145.method04520(field20199);
      this.field20161 = this.field20145.method04520(field20200);
   }

   @Subscribe
   private void method08868(WeatherStateEvent var1) {
      if (this.field20161) {
         var1.method05695(true);
      }
   }

   public Removals() {
      super(ModuleCategory.Render, ModuleSubCategory.Other);
      this.field20145 = new MultiToggleSetting(field20162)
         .method04517(NamedOption.method08077(field20163, true))
         .method04517(NamedOption.method08077(field20164, true))
         .method04517(NamedOption.method08077(field20165, true))
         .method04517(NamedOption.method08077(field20166, false))
         .method04517(NamedOption.method08077(field20167, false))
         .method04517(NamedOption.method08077(field20168, false))
         .method04517(NamedOption.method08077(field20169, false))
         .method04517(NamedOption.method08077(field20170, false))
         .method04517(NamedOption.method08077(field20171, true))
         .method04517(NamedOption.method08077(field20172, false))
         .method04517(NamedOption.method08077(field20173, false))
         .method04517(NamedOption.method08077(field20174, false))
         .method04517(NamedOption.method08077(field20175, true))
         .method03023(this);
      this.field20146 = new ToggleSetting(field20176).method03014(false).method03023(this);
      this.field20147 = new MultiToggleSetting(field20177)
         .method04517(NamedOption.method08077(field20178, false))
         .method04517(NamedOption.method08077(field20179, false))
         .method04517(NamedOption.method08077(field20180, false))
         .method04517(NamedOption.method08077(field20181, true))
         .method04517(NamedOption.method08077(field20182, false))
         .method04517(NamedOption.method08077(field20183, false))
         .method03025(() -> this.field20146.method05999())
         .method03023(this);
      this.field20148 = new NumberSetting<Float>(field20184)
         .method10835(0.0F)
         .method10838(1.0F)
         .method10834(field20185)
         .method03017(field20186)
         .method03025(() -> this.field20146.method05999())
         .method03023(this);
      this.field20151 = false;
      this.field20152 = false;
      this.field20153 = false;
      this.field20154 = false;
      this.field20155 = false;
      this.field20156 = false;
      this.field20157 = false;
      this.field20158 = false;
      this.field20159 = false;
      this.field20160 = false;
      this.field20161 = false;
      this.method03935(field20187);
   }

   private boolean method08870(List<?> var1) {
      if (this.field20145.method04520(field20189) && var1 != null) {
         if (var1.size() > 16) {
            var1.subList(16, var1.size()).clear();
         }

         for (Object var3 : var1) {
            MapDecorationRenderState var4 = (MapDecorationRenderState)var3;
            if (var4.name != null && var4.name.getString(33).length() > 32) {
               var4.name = null;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   @Subscribe
   private void method08871(NightVisionEvent var1) {
      if (this.field20151) {
         var1.method05695(true);
      }
   }
}
