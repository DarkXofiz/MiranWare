// Original binary: sg/ec/GMBXXQilYjiGA6Zu
package sg.ec;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Pattern;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.GameType;
import net.minecraft.world.scores.PlayerTeam;

// $VF: Compiled from s
public class StaffListHud extends HudElement {
   private final MultiToggleSetting field07872;
   private final ToggleSetting field07873;
   private static final CornerRadii field07874 = new CornerRadii(StaffListHud.field07923);
   private final Identifier field07875;
   private final List<StaffListHud.Nested103> field07876;
   private static final Pattern field07877 = Pattern.compile(StaffListHud.field07924);
   private static final String[] field07878 = new String[]{
      StaffListHud.field07925,
      StaffListHud.field07926,
      StaffListHud.field07927,
      StaffListHud.field07928,
      StaffListHud.field07929,
      StaffListHud.field07930,
      StaffListHud.field07931,
      StaffListHud.field07932,
      StaffListHud.field07933,
      StaffListHud.field07934,
      StaffListHud.field07935,
      StaffListHud.field07936,
      StaffListHud.field07937,
      StaffListHud.field07938,
      StaffListHud.field07939,
      StaffListHud.field07940,
      StaffListHud.field07941,
      StaffListHud.field07942,
      StaffListHud.field07943,
      StaffListHud.field07944,
      StaffListHud.field07945,
      StaffListHud.field07946,
      StaffListHud.field07947,
      StaffListHud.field07948,
      StaffListHud.field07949,
      StaffListHud.field07950,
      StaffListHud.field07951,
      StaffListHud.field07952,
      StaffListHud.field07953,
      StaffListHud.field07954,
      StaffListHud.field07955,
      StaffListHud.field07956,
      StaffListHud.field07957,
      StaffListHud.field07958,
      StaffListHud.field07959,
      StaffListHud.field07960,
      StaffListHud.field07961
   };
   private final DraggableElement field07879;
   private final AnimationUtils field07880;
   private final List<PlayerTeam> field07881;
   private int field07882;
   private int field07883;
   private static final String field07884 = "StaffList";
   private static final String field07885 = "Отображать в нике";
   private static final String field07886 = "Prefix";
   private static final String field07887 = "Suffix";
   private static final String field07888 = "Отображать время";
   private static final String field07889 = "textures/entity/player/slim/steve.png";
   private static final long field07890 = 150L;
   private static final float field07891 = 12.0F;
   private static final float field07892 = 0.001F;
   private static final float field07893 = 11.0F;
   private static final float field07894 = 15.0F;
   private static final float field07895 = 70.0F;
   private static final float field07896 = 2.5F;
   private static final float field07897 = 5.0F;
   private static final String field07898 = "A";
   private static final float field07899 = 0.001F;
   private static final float field07900 = 5.0F;
   private static final float field07901 = 20.0F;
   private static final float field07902 = 11.0F;
   private static final float field07903 = 11.0F;
   private static final float field07904 = 9.0F;
   private static final float field07905 = 9.0F;
   private static final float field07906 = 5.0F;
   private static final float field07907 = 3.0F;
   private static final float field07908 = 11.0F;
   private static final float field07909 = 11.0F;
   private static final String field07910 = "Prefix";
   private static final String field07911 = "Suffix";
   private static final String field07912 = "Изменение статуса";
   private static final String field07913 = "Заход на сервер";
   private static final String field07914 = "Выход с сервера";
   private static final String field07915 = " Сменился статус на ";
   private static final long field07916 = 2000L;
   private static final String field07917 = "staffList";
   private static final String field07918 = "staffList";
   private static final String field07919 = " Зашел на сервер.";
   private static final long field07920 = 2000L;
   private static final String field07921 = " Вышел с сервера.";
   private static final long field07922 = 2000L;
   private static final float field07923 = 2.5F;
   private static final String field07924 = "^\\w{3,16}$";
   private static final String field07925 = "help";
   private static final String field07926 = "mod";
   private static final String field07927 = "der";
   private static final String field07928 = "adm";
   private static final String field07929 = "wne";
   private static final String field07930 = "мод";
   private static final String field07931 = "хелп";
   private static final String field07932 = "помо";
   private static final String field07933 = "адм";
   private static final String field07934 = "владе";
   private static final String field07935 = "отри";
   private static final String field07936 = "таф";
   private static final String field07937 = "taf";
   private static final String field07938 = "curat";
   private static final String field07939 = "курато";
   private static final String field07940 = "dev";
   private static final String field07941 = "раз";
   private static final String field07942 = "supp";
   private static final String field07943 = "сапп";
   private static final String field07944 = "yt";
   private static final String field07945 = "ютуб";
   private static final String field07946 = "сотр";
   private static final String field07947 = "ʏᴛ";
   private static final String field07948 = "ᴀᴅᴍ";
   private static final String field07949 = "ᴍᴏᴅ";
   private static final String field07950 = "ʜᴇʟᴘ";
   private static final String field07951 = "ꔉ";
   private static final String field07952 = "ꔓ";
   private static final String field07953 = "ꔗ";
   private static final String field07954 = "ꔡ";
   private static final String field07955 = "ꔥ";
   private static final String field07956 = "ꔩ";
   private static final String field07957 = "ꔂ";
   private static final String field07958 = "ꔳ";
   private static final String field07959 = "ꔷ";
   private static final String field07960 = "ꔅ";
   private static final String field07961 = "ꔁ";

   @Override
   public void method00024() {
      if (mc.level != null && mc.player != null) {
         long var1 = System.currentTimeMillis();
         boolean sx = this.field07872.method04520(field07910);
         boolean sxx = this.field07872.method04520(field07911);
         boolean sxxx = this.field07873.method03022();
         ClientPacketListener sxxxx = mc.getConnection();
         NotificationHud sxxxxx = ModuleManager.INSTANCE.method08274().method04953().method00017(NotificationHud.class);
         boolean sxxxxxx = sxxxxx.method01423().method03022();
         boolean sxxxxxxx = sxxxxxx && sxxxxx.method01418().method04520(field07912);
         boolean sxxxxxxxx = sxxxxxx && sxxxxx.method01418().method04520(field07913);
         boolean sxxxxxxxxx = sxxxxxx && sxxxxx.method01418().method04520(field07914);
         var sxxxxxxxxxx = new HashMap(this.field07876.size());

         for (StaffListHud.Nested103 sxxxxxxxxxxx : this.field07876) {
            sxxxxxxxxxxx.method03574(false);
            sxxxxxxxxxx.put(sxxxxxxxxxxx.method03584(), sxxxxxxxxxxx);
         }

         Map sxxxxxxxxxxx = new HashMap<>();
         Set sxxxxxxxxxxxx = new HashSet<>();
         Set sxxxxxxxxxxxxx = new HashSet<>();

         for (PlayerInfo sxxxxxxxxxxxxxx : sxxxx.getOnlinePlayers()) {
            String sxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxx.getProfile().name();
            sxxxxxxxxxxx.put(sxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxx);
            if (sxxxxxxxxxxxxxx.getGameMode() == GameType.SPECTATOR) {
               sxxxxxxxxxxxx.add(sxxxxxxxxxxxxxxx);
            }

            if (sxxxxxxxxxxxxxx.getGameMode() == GameType.CREATIVE) {
               sxxxxxxxxxxxxx.add(sxxxxxxxxxxxxxxx);
            }
         }

         Set sxxxxxxxxxxxxxx = new HashSet<>();

         for (Player sxxxxxxxxxxxxxxx : mc.level.players()) {
            sxxxxxxxxxxxxxx.add(sxxxxxxxxxxxxxxx.getScoreboardName());
         }

         for (PlayerTeam sxxxxxxxxxxxxxxx : this.method03561()) {
            String sxxxxxxxxxxxxxxxx = PlayerUtils.method11829(sxxxxxxxxxxxxxxx);
            if (!sxxxxxxxxxxxxxxxx.isEmpty()) {
               PlayerInfo sxxxxxxxxxxxxxxxxx = (PlayerInfo) sxxxxxxxxxxx.get(sxxxxxxxxxxxxxxxx);
               boolean sxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxx == null;
               boolean sxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxx.contains(sxxxxxxxxxxxxxxxx);
               boolean sxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxx.contains(sxxxxxxxxxxxxxxxx);
               boolean sxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxx.contains(sxxxxxxxxxxxxxxxx);
               StaffListHud.Nested104 sxxxxxxxxxxxxxxxxxxxxxx = StaffListHud.Nested104.ACTIVE;
               if (sxxxxxxxxxxxxxxxxxx) {
                  sxxxxxxxxxxxxxxxxxxxxxx = StaffListHud.Nested104.VANISH;
               } else if (sxxxxxxxxxxxxxxxxxxxxx) {
                  sxxxxxxxxxxxxxxxxxxxxxx = StaffListHud.Nested104.NEAR;
               } else if (sxxxxxxxxxxxxxxxxxxx) {
                  sxxxxxxxxxxxxxxxxxxxxxx = StaffListHud.Nested104.GM3;
               } else if (sxxxxxxxxxxxxxxxxxxxx) {
                  sxxxxxxxxxxxxxxxxxxxxxx = StaffListHud.Nested104.GM1;
               }

               boolean sxxxxxxxxxxxxxxxxxxxxxxx = StaffManager.INSTANCE.method02175(sxxxxxxxxxxxxxxxx);
               boolean sxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxx && !PlayerUtils.method11821(sxxxxxxxxxxxxxxxx);
               String sxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxx.getPlayerPrefix() == null ? "" : sxxxxxxxxxxxxxxx.getPlayerPrefix().getString();
               boolean sxxxxxxxxxxxxxxxxxxxxxxxxxx = !sxxxxxxxxxxxxxxxxxxxxxxx && !sxxxxxxxxxxxxxxxxxxxxxxxx && this.method03560(sxxxxxxxxxxxxxxxxxxxxxxxxx);
               if (sxxxxxxxxxxxxxxxxxxxxxxx || sxxxxxxxxxxxxxxxxxxxxxxxx || sxxxxxxxxxxxxxxxxxxxxxxxxxx) {
                  Component sxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxx.getPlayerPrefix() != null ? sxxxxxxxxxxxxxxx.getPlayerPrefix() : Component.empty();
                  Identifier sxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxx != null ? sxxxxxxxxxxxxxxxxx.getSkin().body().texturePath() : this.field07875;
                  StaffListHud.Nested103 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = (StaffListHud.Nested103) sxxxxxxxxxx.get(sxxxxxxxxxxxxxxxx);
                  String sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = this.method03563(sxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxx, sx, sxx);
                  if (sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx != null) {
                     if (sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03586() != sxxxxxxxxxxxxxxxxxxxxxx) {
                        if (sxxxxxxx) {
                           MutableComponent sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03580() == null
                              ? Component.literal(sxxxxxxxxxxxxxxxx)
                              : sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03580().copy();
                           Component sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.append(field07915)
                              .append(
                                 Component.literal(sxxxxxxxxxxxxxxxxxxxxxx.method03593())
                                    .setStyle(Style.EMPTY.withColor(sxxxxxxxxxxxxxxxxxxxxxx.method03594()))
                              );
                           NotificationManager.method08619(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, field07916, NotificationType.WARNING);
                        }

                        if (sxxx) {
                           sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03569(var1);
                        }
                     }

                     if (!sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.equals(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03587())) {
                        Component sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = PlayerUtils.method11819(sxxxxxxxxxxxxxxx, sx, true, sxx);
                        OnlinePlayerState.INSTANCE.method09289(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, field07917);
                        String sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = FontRenderer.method09483(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                        sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03582(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                        sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03588(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                        sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03566(field14601.method09476(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, field14607, -field14608));
                        sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03577(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     }

                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03571(TextRenderUtils.method00670(var1 - sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03567()));
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03564(field14601.method09478(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03590(), field14607, -field14608));
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03574(true);
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03565(sxxxxxxxxxxxxxxxxxxxxxx);
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03592(field14601.method09478(sxxxxxxxxxxxxxxxxxxxxxx.method03593(), field14607, -field14608));
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03585(sxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03578(sxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                  } else if (field07877.matcher(sxxxxxxxxxxxxxxxx).matches()) {
                     Component sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = PlayerUtils.method11819(sxxxxxxxxxxxxxxx, sx, true, sxx);
                     OnlinePlayerState.INSTANCE.method09289(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, field07918);
                     String sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = FontRenderer.method09483(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     StaffListHud.Nested103 sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = new StaffListHud.Nested103(
                        sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxx
                     );
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03588(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03566(field14601.method09476(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, field14607, -field14608));
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03577(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03574(true);
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03565(sxxxxxxxxxxxxxxxxxxxxxx);
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03592(field14601.method09478(sxxxxxxxxxxxxxxxxxxxxxx.method03593(), field14607, -field14608));
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03564(
                        field14601.method09478(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03590(), field14607, -field14608)
                     );
                     sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03578(sxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     if (sxxx) {
                        sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.method03569(var1);
                     }

                     if (sxxxxxxxx) {
                        Component sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx = sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx.copy().append(field07919);
                        NotificationManager.method08619(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx, field07920, NotificationType.WARNING);
                     }

                     this.field07876.add(sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                     sxxxxxxxxxx.put(sxxxxxxxxxxxxxxxx, sxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx);
                  }
               }
            }
         }

         this.field07876.removeIf(var1x -> {
            boolean var2 = !var1x.method03570() && var1x.method03589().method03384() == 0.0;
            if (sxxxxxxxxx && var2) {
               MutableComponent var3x = var1x.method03580().copy().append(field07921);
               NotificationManager.method08619(var3x, field07922, NotificationType.WARNING);
            }

            return var2;
         });
         super.method00024();
      }
   }

   private boolean method03560(String var1) {
      if (var1 != null && !var1.isEmpty()) {
         String var2 = var1.toLowerCase();

         for (String var6 : field07878) {
            if (var2.contains(var6)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   private List<PlayerTeam> method03561() {
      var var1 = mc.level.getScoreboard().getPlayerTeams();
      int var2 = var1.size();
      int var3 = 1;

      for (PlayerTeam var5 : var1) {
         var3 = 31 * var3 + var5.getName().hashCode();
      }

      if (var2 != this.field07882 || var3 != this.field07883) {
         this.field07881.clear();
         this.field07881.addAll(var1);
         this.field07881.sort(Comparator.comparing(PlayerTeam::getName));
         this.field07882 = var2;
         this.field07883 = var3;
      }

      return this.field07881;
   }

   private String method03563(PlayerTeam var1, String var2, boolean var3, boolean var4) {
      String var5 = var1.getPlayerPrefix() == null ? "" : var1.getPlayerPrefix().getString();
      String var6 = var1.getPlayerSuffix() == null ? "" : var1.getPlayerSuffix().getString();
      return var2 + "|" + var5 + "|" + var6 + "|" + var3 + "|" + var4;
   }

   public StaffListHud() {
      super(field07884);
      this.field07872 = new MultiToggleSetting(field07885)
         .method04517(NamedOption.method08077(field07886, true))
         .method04517(NamedOption.method08077(field07887, true))
         .method03023(this);
      this.field07873 = new ToggleSetting(field07888).method03017(false).method03023(this);
      this.field07875 = Identifier.withDefaultNamespace(field07889);
      this.field07876 = new ArrayList<>();
      this.field07879 = this.method06449(this, 0.0F, 0.0F);
      this.field07880 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field07890);
      this.field07881 = new ArrayList<>();
      this.field07882 = -1;
      this.field07883 = 0;
   }

   @Override
   public void method00032(PacketEvent var1) {
      super.method00032(var1);
   }

   @Override
   public void method00027(GuiGraphics var1) {
      super.method00027(var1);
      this.method06465(this.field07879.method02685());
      this.method06453(this.field07879.method02669());
      float var2 = 0.0F;
      float var3 = 0.0F;
      boolean var4 = this.field07873.method03022();
      float var5 = 0.0F;
      if (var4) {
         for (StaffListHud.Nested103 var7 : this.field07876) {
            var5 = Math.max(var5, var7.method03579() + 2.0F);
         }
      }

      float var19 = field07891;

      for (StaffListHud.Nested103 var8 : this.field07876) {
         AnimationUtils var9 = var8.method03589();
         var9.method03375(var8.method03570() ? 1.0 : 0.0);
         float var10 = var9.method03377();
         if (!(var10 <= field07892)) {
            var3 += var10 * field07893;
            var2 = Math.max(var8.method03576() + var8.method03573() + var5 + var19 + field07894, var2);
         }
      }

      this.field07880.method03375(Math.max(field07895, var2));
      float var21 = Math.max(field07896, var3 + field07897);
      this.method06448(this.field07880.method03377());
      this.method06456(field14609 + var21);
      this.method06441(var1, field07898);
      float var22 = this.method06464();
      int var23 = 0;

      for (StaffListHud.Nested103 var11 : this.field07876) {
         float var12 = var11.method03589().method03377();
         if (!(var12 <= field07899)) {
            int var13 = ColorUtils.method04611(this.method06438(), var12);
            int var14 = ColorUtils.method04611(var11.method03586().method03594(), var12);
            float var15 = var11.method03573();
            float var16 = var4 ? var11.method03579() + 2.0F : 0.0F;
            float var17 = this.method06436() + field07900;
            float var18 = var22 + field07901 + var12 * field07902 - field07903 + var23 * 11;
            if (var11.method03572() != null) {
               GuiTextureRenderer.method10260(
                  var1,
                  var11.method03572(),
                  false,
                  var17,
                  var18,
                  field07904,
                  field07905,
                  field07874,
                  1.0F,
                  new CornerColors(ColorUtils.method04611(-1, var12))
               );
            }

            field14601.method09490(var1, var11.method03575(), var17 + var19, var18, var13, field14607, -field14608);
            field14601.method09490(
               var1,
               var11.method03586().method03593(),
               this.method06436() + this.method06458() - var15 - field07906 - var5,
               var18,
               var14,
               field14607,
               -field14608
            );
            if (var4) {
               field14601.method09490(
                  var1, var11.method03590(), this.method06436() + this.method06458() - field07907 - var16, var18, var13, field14607, -field14608
               );
            }

            var22 += field07908 * var12 - field07909;
            var23++;
         }
      }

      this.field07879.method02676(this.method06458());
      this.field07879.method02696(this.method06435());
   }

   // $VF: Compiled from s
   public static class Nested103 {
      private AnimationUtils field07962;
      private Component field07963;
      private String field07964;
      private long field07965 = System.currentTimeMillis();
      private String field07966;
      private Component field07967;
      private String field07968;
      private float field07969;
      private float field07970;
      private float field07971;
      private String field07972;
      private boolean field07973;
      private Identifier field07974;
      private StaffListHud.Nested104 field07975;
      private static final String field07976 = "0s";
      private static final long field07977 = 150L;

      public void method03564(float var1) {
         this.field07971 = var1;
      }

      public void method03565(StaffListHud.Nested104 var1) {
         this.field07975 = var1;
      }

      public void method03566(float var1) {
         this.field07969 = var1;
      }

      @Override
      public String toString() {
         return "StaffListElement.Staffs(animationUtils="
            + this.method03589()
            + ", prefix="
            + this.method03568()
            + ", name="
            + this.method03584()
            + ", updateTime="
            + this.method03567()
            + ", timeStr="
            + this.method03590()
            + ", displayName="
            + this.method03580()
            + ", renderText="
            + this.method03575()
            + ", widthRenderText="
            + this.method03576()
            + ", statusWidth="
            + this.method03573()
            + ", timeWidth="
            + this.method03579()
            + ", displayCacheKey="
            + this.method03587()
            + ", isOnServer="
            + this.method03570()
            + ", texture="
            + this.method03572()
            + ", status="
            + this.method03586()
            + ")";
      }

      public long method03567() {
         return this.field07965;
      }

      @Override
      public int hashCode() {
         byte var1 = 59;
         int var2 = 1;
         long var3 = this.method03567();
         var2 = var2 * 59 + (int)(var3 >>> 32 ^ var3);
         var2 = var2 * 59 + Float.floatToIntBits(this.method03576());
         var2 = var2 * 59 + Float.floatToIntBits(this.method03573());
         var2 = var2 * 59 + Float.floatToIntBits(this.method03579());
         var2 = var2 * 59 + (this.method03570() ? 79 : 97);
         AnimationUtils var5 = this.method03589();
         var2 = var2 * 59 + (var5 == null ? 43 : var5.hashCode());
         Component var6 = this.method03568();
         var2 = var2 * 59 + (var6 == null ? 43 : var6.hashCode());
         String var7 = this.method03584();
         var2 = var2 * 59 + (var7 == null ? 43 : var7.hashCode());
         String var8 = this.method03590();
         var2 = var2 * 59 + (var8 == null ? 43 : var8.hashCode());
         Component var9 = this.method03580();
         var2 = var2 * 59 + (var9 == null ? 43 : var9.hashCode());
         String var10 = this.method03575();
         var2 = var2 * 59 + (var10 == null ? 43 : var10.hashCode());
         String var11 = this.method03587();
         var2 = var2 * 59 + (var11 == null ? 43 : var11.hashCode());
         Identifier var12 = this.method03572();
         var2 = var2 * 59 + (var12 == null ? 43 : var12.hashCode());
         StaffListHud.Nested104 var13 = this.method03586();
         return var2 * 59 + (var13 == null ? 43 : var13.hashCode());
      }

      public Component method03568() {
         return this.field07963;
      }

      public void method03569(long var1) {
         this.field07965 = var1;
      }

      public boolean method03570() {
         return this.field07973;
      }

      public void method03571(String var1) {
         this.field07966 = var1;
      }

      public Identifier method03572() {
         return this.field07974;
      }

      public float method03573() {
         return this.field07970;
      }

      public void method03574(boolean var1) {
         this.field07973 = var1;
      }

      public String method03575() {
         return this.field07968;
      }

      public float method03576() {
         return this.field07969;
      }

      public void method03577(String var1) {
         this.field07972 = var1;
      }

      public void method03578(Identifier var1) {
         this.field07974 = var1;
      }

      public float method03579() {
         return this.field07971;
      }

      public Component method03580() {
         return this.field07967;
      }

      public void method03581(AnimationUtils var1) {
         this.field07962 = var1;
      }

      public void method03582(String var1) {
         this.field07968 = var1;
      }

      public void method03583(String var1) {
         this.field07964 = var1;
      }

      public String method03584() {
         return this.field07964;
      }

      public void method03585(Component var1) {
         this.field07963 = var1;
      }

      public StaffListHud.Nested104 method03586() {
         return this.field07975;
      }

      public String method03587() {
         return this.field07972;
      }

      public void method03588(Component var1) {
         this.field07967 = var1;
      }

      public AnimationUtils method03589() {
         return this.field07962;
      }

      public String method03590() {
         return this.field07966;
      }

      protected boolean method03591(Object var1) {
         return var1 instanceof StaffListHud.Nested103;
      }

      @Override
      public boolean equals(Object var1) {
         if (var1 == this) {
            return true;
         } else if (!(var1 instanceof StaffListHud.Nested103 var2)) {
            return false;
         } else {
            if (!var2.method03591(this)) {
               return false;
            }

            if (this.method03567() != var2.method03567()) {
               return false;
            }

            if (Float.compare(this.method03576(), var2.method03576()) != 0) {
               return false;
            }

            if (Float.compare(this.method03573(), var2.method03573()) != 0) {
               return false;
            }

            if (Float.compare(this.method03579(), var2.method03579()) != 0) {
               return false;
            }

            if (this.method03570() != var2.method03570()) {
               return false;
            }

            AnimationUtils var3 = this.method03589();
            AnimationUtils var4 = var2.method03589();
            if (var3 == null ? var4 == null : var3.equals(var4)) {
               Component var5 = this.method03568();
               Component var6 = var2.method03568();
               if (var5 == null ? var6 == null : var5.equals(var6)) {
                  String var7 = this.method03584();
                  String var8 = var2.method03584();
                  if (var7 == null ? var8 == null : var7.equals(var8)) {
                     String var9 = this.method03590();
                     String var10 = var2.method03590();
                     if (var9 == null ? var10 == null : var9.equals(var10)) {
                        Component var11 = this.method03580();
                        Component var12 = var2.method03580();
                        if (var11 == null ? var12 == null : var11.equals(var12)) {
                           String var13 = this.method03575();
                           String var14 = var2.method03575();
                           if (var13 == null ? var14 == null : var13.equals(var14)) {
                              String var15 = this.method03587();
                              String var16 = var2.method03587();
                              if (var15 == null ? var16 == null : var15.equals(var16)) {
                                 Identifier var17 = this.method03572();
                                 Identifier var18 = var2.method03572();
                                 if (var17 == null ? var18 == null : var17.equals(var18)) {
                                    StaffListHud.Nested104 var19 = this.method03586();
                                    StaffListHud.Nested104 var20 = var2.method03586();
                                    return var19 == null ? var20 == null : var19.equals(var20);
                                 } else {
                                    return false;
                                 }
                              } else {
                                 return false;
                              }
                           } else {
                              return false;
                           }
                        } else {
                           return false;
                        }
                     } else {
                        return false;
                     }
                  } else {
                     return false;
                  }
               } else {
                  return false;
               }
            } else {
               return false;
            }
         }
      }

      public Nested103(String var1, Component var2, String var3) {
         this.field07966 = field07976;
         this.field07972 = "";
         this.field07968 = var1;
         this.field07963 = var2;
         this.field07964 = var3;
         this.field07962 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field07977);
      }

      public void method03592(float var1) {
         this.field07970 = var1;
      }
   }

   // $VF: Compiled from s
   public enum Nested104 {
      VANISH("Vanish", ColorUtils.method04592(255, 68, 68, 255)),
      ACTIVE("Active", ColorUtils.method04592(171, 255, 97, 255)),
      NEAR("Near", ColorUtils.method04592(255, 242, 13, 255)),
      GM1("Gm1", ColorUtils.method04592(255, 136, 0, 255)),
      GM3("Gm3", ColorUtils.method04592(255, 136, 0, 255));

      public final String field07978;
      public final int field07979;

      Nested104(String var3, int var4) {
         this.field07978 = var3;
         this.field07979 = var4;
      }

      public String method03593() {
         return this.field07978;
      }

      public int method03594() {
         return this.field07979;
      }
   }
}
