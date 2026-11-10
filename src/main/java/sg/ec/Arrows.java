// Original binary: sg/ec/MQwBvWkBJSp6y9El
package sg.ec;

import java.awt.Color;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix3x2fStack;

// $VF: Compiled from s
public class Arrows extends ClientModule {
   private final ModeSetting field10087;
   private final MultiToggleSetting field10088;
   private final MultiToggleSetting field10089;
   private final ColorSetting field10090;
   private final NumberSetting<Float> field10091;
   private final NumberSetting<Float> field10092;
   private final NumberSetting<Float> field10093;
   private final SmoothAnimation field10094;
   private final Map<String, Object> field10095;
   private Identifier field10096;
   private static final String field10097 = "Картинка стрелочки";
   private static final String field10098 = "1";
   private static final String field10099 = "2";
   private static final String field10100 = "3";
   private static final String field10101 = "4";
   private static final String field10102 = "5";
   private static final String field10103 = "1";
   private static final String field10104 = "Тип";
   private static final String field10105 = "Игроки";
   private static final String field10106 = "Голые";
   private static final String field10107 = "Друзья";
   private static final String field10108 = "Мобы";
   private static final String field10109 = "Предметы";
   private static final String field10110 = "Жители";
   private static final String field10111 = "Отображение";
   private static final String field10112 = "Ник";
   private static final String field10113 = "Дистанция";
   private static final String field10114 = "Цвет";
   private static final String field10115 = "Прозрачность";
   private static final float field10116 = 0.5F;
   private static final float field10117 = 0.01F;
   private static final String field10118 = "Смещение";
   private static final float field10119 = 20.0F;
   private static final float field10120 = 200.0F;
   private static final float field10121 = 70.0F;
   private static final String field10122 = "Размер";
   private static final float field10123 = 10.0F;
   private static final float field10124 = 40.0F;
   private static final float field10125 = 18.0F;
   private static final String field10126 = "Arrows";
   private static final double field10127 = 0.11F;
   private static final String field10128 = "Мобы";
   private static final String field10129 = "Предметы";
   private static final String field10130 = "Жители";
   private static final float field10131 = 3.0F;
   private static final float field10132 = 4.0F;
   private static final float field10133 = 12.0F;
   private static final float field10134 = 5.0F;
   private static final float field10135 = 18.0F;
   private static final float field10136 = 255.0F;
   private static final float field10137 = 90.0F;
   private static final float field10138 = (float) (Math.PI / 180.0);
   private static final String field10139 = "Ник";
   private static final String field10140 = "Дистанция";
   private static final float field10141 = 0.1F;
   private static final float field10142 = 0.1F;
   private static final String field10143 = "Друзья";
   private static final String field10144 = "Игроки";
   private static final String field10145 = "Голые";
   private static final String field10146 = "Друзья";
   private static final String field10147 = "Игроки";

   private void method04541(GuiGraphics var1, Vec3 var2, String var3, boolean var4) {
      double var5 = var2.x - mc.getEntityRenderDispatcher().camera.position().x;
      double sx = var2.z - mc.getEntityRenderDispatcher().camera.position().z;
      double sxx = Math.toRadians(this.field10094.method06159());
      double sxxx = Math.cos(sxx);
      double sxxxx = Math.sin(sxx);
      double sxxxxx = var5 * sxxx + sx * sxxxx;
      double sxxxxxx = sx * sxxx - var5 * sxxxx;
      float sxxxxxxx = (float)Math.atan2(-sxxxxxx, -sxxxxx);
      float sxxxxxxxx = (float)Math.toDegrees(sxxxxxxx);
      double sxxxxxxxxx = mc.player.position().distanceTo(var2);
      float sxxxxxxxxxx = this.field10092.method03022();
      float sxxxxxxxxxxx = this.field10093.method03022();
      float sxxxxxxxxxxxx = mc.getWindow().getGuiScaledWidth() / 2.0F;
      float sxxxxxxxxxxxxx = mc.getWindow().getGuiScaledHeight() / 2.0F;
      float sxxxxxxxxxxxxxx = Mth.cos(sxxxxxxx);
      float sxxxxxxxxxxxxxxx = Mth.sin(sxxxxxxx);
      float sxxxxxxxxxxxxxxxx = sxxxxxxxxxxxx + sxxxxxxxxxx * sxxxxxxxxxxxxxx;
      float sxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxx + sxxxxxxxxxx * sxxxxxxxxxxxxxxx;
      sxxxxxxxxxxxxxxxx -= sxxxxxxxxxxxxxx * (sxxxxxxxxxxx / 2.0F);
      sxxxxxxxxxxxxxxxxx -= sxxxxxxxxxxxxxxx * (sxxxxxxxxxxx / 2.0F);
      float sxxxxxxxxxxxxxxxxxx = Mth.clamp(sxxxxxxxxxxx / field10131, field10132, field10133);
      float sxxxxxxxxxxxxxxxxxxx = field10134 * (sxxxxxxxxxxx / field10135);
      float sxxxxxxxxxxxxxxxxxxxx = Mth.clamp(this.field10091.method03022(), 0.0F, 1.0F);
      int sxxxxxxxxxxxxxxxxxxxxx = (int)(field10136 * sxxxxxxxxxxxxxxxxxxxx);
      CornerColors sxxxxxxxxxxxxxxxxxxxxxx = var4
         ? new CornerColors(ColorUtils.method04597(100, 255, 100, sxxxxxxxxxxxxxxxxxxxxx))
         : new CornerColors(ColorUtils.method04616(this.field10090.method11676(), sxxxxxxxxxxxxxxxxxxxxx));
      Matrix3x2fStack sxxxxxxxxxxxxxxxxxxxxxxx = var1.pose();
      sxxxxxxxxxxxxxxxxxxxxxxx.pushMatrix();
      sxxxxxxxxxxxxxxxxxxxxxxx.translate(sxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxx);
      sxxxxxxxxxxxxxxxxxxxxxxx.rotate((sxxxxxxxx + field10137) * field10138);
      GuiTextureRenderer.method10258(var1, this.field10096, -(sxxxxxxxxxxx / 2.0F), -(sxxxxxxxxxxx / 2.0F), sxxxxxxxxxxx, sxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxx);
      sxxxxxxxxxxxxxxxxxxxxxxx.popMatrix();
      boolean sxxxxxxxxxxxxxxxxxxxxxxxx = this.field10089.method04520(field10139);
      boolean sxxxxxxxxxxxxxxxxxxxxxxxxx = this.field10089.method04520(field10140);
      if (sxxxxxxxxxxxxxxxxxxxxxxxx) {
         Fonts.field00109
            .method09488(
               var1,
               StreamerNameUtils.method03481(var3),
               sxxxxxxxxxxxxxxxx,
               sxxxxxxxxxxxxxxxxx - sxxxxxxxxxxx / 2.0F - sxxxxxxxxxxxxxxxxxxx,
               -1,
               sxxxxxxxxxxxxxxxxxx,
               field10141
            );
      }

      if (sxxxxxxxxxxxxxxxxxxxxxxxxx) {
         String sxxxxxxxxxxxxxxxxxxxxxxxxxx = (int)sxxxxxxxxx + "m";
         Fonts.field00109
            .method09488(var1, sxxxxxxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxx + sxxxxxxxxxxx / 2.0F, -1, sxxxxxxxxxxxxxxxxxx, field10142);
      }
   }

   public ModeSetting method04542() {
      return this.field10087;
   }

   private void method04543(GuiGraphics var1, PartyMember var2, float var3) {
      Vec3 var4 = new Vec3(var2.method07607().field03984, var2.method07607().field03985, var2.method07607().field03986);
      Vec3 var5 = new Vec3(var2.method07582().field03984, var2.method07582().field03985, var2.method07582().field03986);
      Vec3 var6 = var4.add(var5.subtract(var4).scale(var3));
      this.method04541(var1, var6, var2.method07580(), Party.method10150(var2));
   }

   private boolean method04544(String var1) {
      boolean var2 = FriendManager.INSTANCE.method00171(var1);
      return var2 ? this.field10088.method04520(field10146) : this.field10088.method04520(field10147);
   }

   @Subscribe(1)
   public void method04546(HudRenderEvent var1) {
      if (!this.field10095.isEmpty()) {
         this.field10096 = ClientTextures.INSTANCE.method04562().get(this.field10087.method03022());
         FontRenderer.method09475();
         GuiTextureRenderer.method10262();
         float var2 = var1.method05421().getGameTimeDeltaPartialTick(true);
         this.field10094.method06162();
         this.field10094.method06168(FreeLookController.method10131(), field10127, Easings.field19397, true);

         for (Object var4 : this.field10095.values()) {
            if (var4 instanceof PartyMember var5) {
               this.method04543(var1.method05424(), var5, var2);
            } else if (var4 instanceof Player var6) {
               this.method04551(var1.method05424(), var6, var2);
            } else if (var4 instanceof Entity var7) {
               this.method04550(var1.method05424(), var7, var2);
            }
         }

         GuiTextureRenderer.method10261();
         FontRenderer.method09484();
      }
   }

   private boolean method04547(Player var1) {
      boolean var2 = FriendManager.INSTANCE.method00172(var1);
      if (var2) {
         return this.field10088.method04520(field10143);
      } else {
         return this.field10088.method04520(field10144) ? true : this.field10088.method04520(field10145) && var1.getArmorValue() == 0;
      }
   }

   private boolean method04548(Entity var1, boolean var2, boolean var3, boolean var4) {
      if (!var1.isAlive() || var1 instanceof Player || !ModuleManager.INSTANCE.method08260().method00605(var1)) {
         return false;
      } else if (var3 && var1 instanceof ItemEntity) {
         return true;
      } else {
         return var4 && this.method04549(var1) ? true : var2 && var1 instanceof Mob && !this.method04549(var1);
      }
   }

   public Arrows() {
      super(ModuleCategory.Render, ModuleSubCategory.Interface);
      this.field10087 = new ModeSetting(field10097)
         .method05597(field10098, field10099, field10100, field10101, field10102)
         .method03017(field10103)
         .method03023(this);
      this.field10088 = new MultiToggleSetting(field10104)
         .method04517(NamedOption.method08077(field10105, true))
         .method04517(NamedOption.method08077(field10106, false))
         .method04517(NamedOption.method08077(field10107, true))
         .method04517(NamedOption.method08077(field10108, false))
         .method04517(NamedOption.method08077(field10109, false))
         .method04517(NamedOption.method08077(field10110, false))
         .method03023(this);
      this.field10089 = new MultiToggleSetting(field10111)
         .method04517(NamedOption.method08077(field10112, true))
         .method04517(NamedOption.method08077(field10113, true))
         .method03023(this);
      this.field10090 = new ColorSetting(field10114).method11672(new Color(255, 255, 255)).method03023(this);
      this.field10091 = new NumberSetting<Float>(field10115)
         .method10835(field10116)
         .method10838(1.0F)
         .method10834(field10117)
         .method03017(1.0F)
         .method03023(this);
      this.field10092 = new NumberSetting<Float>(field10118)
         .method10835(field10119)
         .method10838(field10120)
         .method10834(1.0F)
         .method03017(field10121)
         .method03023(this);
      this.field10093 = new NumberSetting<Float>(field10122)
         .method10835(field10123)
         .method10838(field10124)
         .method10834(1.0F)
         .method03017(field10125)
         .method03023(this);
      this.field10094 = new SmoothAnimation();
      this.field10095 = new HashMap<>();
      this.method03935(field10126);
   }

   private boolean method04549(Entity var1) {
      return var1 instanceof Villager || var1 instanceof WanderingTrader;
   }

   private void method04550(GuiGraphics var1, Entity var2, float var3) {
      this.method04541(var1, var2.getPosition(var3), var2.getName().getString(), false);
   }

   private void method04551(GuiGraphics var1, Player var2, float var3) {
      this.method04541(var1, var2.getPosition(var3), var2.getName().getString(), FriendManager.INSTANCE.method00172(var2));
   }

   @Subscribe
   private void method04552(PlayerUpdateEvent var1) {
      if (mc.level != null && mc.player != null) {
         this.field10095.clear();
         var var2 = mc.level.players();

         for (AbstractClientPlayer var4 : var2) {
            if (!ModuleManager.INSTANCE.method08260().method00605(var4) && !(var4 instanceof LocalPlayer) && this.method04547(var4)) {
               this.field10095.put("player:" + var4.getName().getString(), var4);
            }
         }

         boolean var15 = this.field10088.method04520(field10128);
         boolean var16 = this.field10088.method04520(field10129);
         boolean var5 = this.field10088.method04520(field10130);
         if (var15 || var16 || var5) {
            for (Entity var7 : mc.level.entitiesForRendering()) {
               if (this.method04548(var7, var15, var16, var5)) {
                  this.field10095.put(var7.getStringUUID(), var7);
               }
            }
         }

         GlobalWebSocketClient var17 = MiranWare.getInit().getClient();
         if (var17 != null) {
            Party var18 = var17.getManager().method01805();
            if (var18 != null) {
               PartyMember var8 = var18.method10151(var1x -> var1x.method07566(var17.getClientPlayer()));
               if (var8 != null) {
                  for (PartyMember var10 : var18.method10148()) {
                     if (!var10.method07566(var17.getClientPlayer())) {
                        String var11 = var10.method07580().toLowerCase(Locale.ROOT);
                        boolean var12 = false;

                        for (AbstractClientPlayer var14 : var2) {
                           if (var14.getGameProfile().name().equalsIgnoreCase(var10.method07580())) {
                              var12 = true;
                              break;
                           }
                        }

                        if (!var12 && this.method04544(var10.method07580())) {
                           this.field10095.putIfAbsent("party:" + var11, var10);
                        }
                     }
                  }
               }
            }
         }
      }
   }
}
