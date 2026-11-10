// Original binary: sg/ec/9PI8KSjKmpMX45GD
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.client.multiplayer.chat.GuiMessage.Line;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.scores.PlayerTeam;

// $VF: Compiled from s
public class BetterChat extends ClientModule {
   private final Map<String, String> field05212 = new HashMap<>();
   private final MultiToggleSetting field05213;
   private final MultiToggleSetting field05214;
   private static final Pattern field05215 = Pattern.compile(BetterChat.field05371);
   private boolean field05216;
   private boolean field05217;
   private boolean field05218;
   private static final String field05219 = "Моды";
   private static final String field05220 = "Анти кириллица";
   private static final String field05221 = "Подсвечивать в чате";
   private static final String field05222 = "префикс при /pvp";
   private static final String field05223 = "Экономия места";
   private static final String field05224 = "Кого подсвечивать";
   private static final String field05225 = "Себя";
   private static final String field05226 = "Друзей";
   private static final String field05227 = "Better Chat";
   private static final String field05228 = "а";
   private static final String field05229 = "a";
   private static final String field05230 = "А";
   private static final String field05231 = "A";
   private static final String field05232 = "б";
   private static final String field05233 = "6";
   private static final String field05234 = "Б";
   private static final String field05235 = "6";
   private static final String field05236 = "в";
   private static final String field05237 = "B";
   private static final String field05238 = "В";
   private static final String field05239 = "B";
   private static final String field05240 = "г";
   private static final String field05241 = "r";
   private static final String field05242 = "Г";
   private static final String field05243 = "r";
   private static final String field05244 = "д";
   private static final String field05245 = "g";
   private static final String field05246 = "Д";
   private static final String field05247 = "g";
   private static final String field05248 = "е";
   private static final String field05249 = "e";
   private static final String field05250 = "Е";
   private static final String field05251 = "E";
   private static final String field05252 = "ё";
   private static final String field05253 = "e";
   private static final String field05254 = "Ё";
   private static final String field05255 = "E";
   private static final String field05256 = "ж";
   private static final String field05257 = ")I(";
   private static final String field05258 = "Ж";
   private static final String field05259 = ")I(";
   private static final String field05260 = "з";
   private static final String field05261 = "3";
   private static final String field05262 = "З";
   private static final String field05263 = "3";
   private static final String field05264 = "и";
   private static final String field05265 = "u";
   private static final String field05266 = "И";
   private static final String field05267 = "U";
   private static final String field05268 = "й";
   private static final String field05269 = "u";
   private static final String field05270 = "Й";
   private static final String field05271 = "U";
   private static final String field05272 = "к";
   private static final String field05273 = "k";
   private static final String field05274 = "К";
   private static final String field05275 = "K";
   private static final String field05276 = "л";
   private static final String field05277 = "JI";
   private static final String field05278 = "Л";
   private static final String field05279 = "JI";
   private static final String field05280 = "м";
   private static final String field05281 = "M";
   private static final String field05282 = "М";
   private static final String field05283 = "M";
   private static final String field05284 = "н";
   private static final String field05285 = "H";
   private static final String field05286 = "Н";
   private static final String field05287 = "H";
   private static final String field05288 = "о";
   private static final String field05289 = "o";
   private static final String field05290 = "О";
   private static final String field05291 = "O";
   private static final String field05292 = "п";
   private static final String field05293 = "n";
   private static final String field05294 = "П";
   private static final String field05295 = "n";
   private static final String field05296 = "р";
   private static final String field05297 = "p";
   private static final String field05298 = "Р";
   private static final String field05299 = "P";
   private static final String field05300 = "с";
   private static final String field05301 = "c";
   private static final String field05302 = "С";
   private static final String field05303 = "C";
   private static final String field05304 = "т";
   private static final String field05305 = "T";
   private static final String field05306 = "Т";
   private static final String field05307 = "T";
   private static final String field05308 = "у";
   private static final String field05309 = "y";
   private static final String field05310 = "У";
   private static final String field05311 = "Y";
   private static final String field05312 = "ф";
   private static final String field05313 = "qp";
   private static final String field05314 = "Ф";
   private static final String field05315 = "qp";
   private static final String field05316 = "х";
   private static final String field05317 = "x";
   private static final String field05318 = "Х";
   private static final String field05319 = "X";
   private static final String field05320 = "ц";
   private static final String field05321 = "u";
   private static final String field05322 = "Ц";
   private static final String field05323 = "U";
   private static final String field05324 = "ч";
   private static final String field05325 = "4";
   private static final String field05326 = "Ч";
   private static final String field05327 = "4";
   private static final String field05328 = "ш";
   private static final String field05329 = "w";
   private static final String field05330 = "Ш";
   private static final String field05331 = "W";
   private static final String field05332 = "щ";
   private static final String field05333 = "w";
   private static final String field05334 = "Щ";
   private static final String field05335 = "W";
   private static final String field05336 = "ъ";
   private static final String field05337 = "b";
   private static final String field05338 = "Ъ";
   private static final String field05339 = "b";
   private static final String field05340 = "ы";
   private static final String field05341 = "bI";
   private static final String field05342 = "Ы";
   private static final String field05343 = "bI";
   private static final String field05344 = "ь";
   private static final String field05345 = "b";
   private static final String field05346 = "Ь";
   private static final String field05347 = "b";
   private static final String field05348 = "э";
   private static final String field05349 = "e";
   private static final String field05350 = "Э";
   private static final String field05351 = "E";
   private static final String field05352 = "ю";
   private static final String field05353 = "IO";
   private static final String field05354 = "Ю";
   private static final String field05355 = "IO";
   private static final String field05356 = "я";
   private static final String field05357 = "9I";
   private static final String field05358 = "Я";
   private static final String field05359 = "9I";
   private static final String field05360 = "Экономия места";
   private static final String field05361 = "Анти кириллица";
   private static final String field05362 = ".";
   private static final String field05363 = "префикс при /pvp";
   private static final String field05364 = "ищет себе соперника! (/pvp)";
   private static final String field05365 = "Подсвечивать в чате";
   private static final String field05366 = "Себя";
   private static final String field05367 = "Друзей";
   private static final String field05368 = "Игрок ";
   private static final String field05369 = " ";
   private static final String field05370 = "Подсвечивать в чате";
   private static final String field05371 = "§.";

   private void method02214(MutableComponent var1, StringBuilder var2, Style var3) {
      if (!var2.isEmpty()) {
         var1.append(Component.literal(var2.toString()).setStyle(var3 == null ? Style.EMPTY : var3));
         var2.setLength(0);
      }
   }

   private void method02218(Map<String, PlayerInfo> var1, String var2, PlayerInfo var3) {
      if (var2 != null) {
         String var4 = field05215.matcher(var2).replaceAll("");
         if (!var4.isEmpty()) {
            var1.putIfAbsent(var4, var3);
         }
      }
   }

   public MultiToggleSetting method02219() {
      return this.field05214;
   }

   private void method02220(Map<String, PlayerInfo> var1, PlayerInfo var2) {
      if (mc.level != null) {
         Player var3 = mc.level.getPlayerByUUID(var2.getProfile().id());
         if (var3 != null) {
            Component var4 = var3.getCustomName();
            if (var4 != null) {
               this.method02218(var1, RawTextScope.method04525(var4::getString), var2);
            }

            Component var5 = var3.getDisplayName();
            if (var5 != null) {
               this.method02218(var1, RawTextScope.method04525(var5::getString), var2);
            }
         }
      }
   }

   public boolean method02221() {
      return this.method03937() && this.field05213.method04520(field05360);
   }

   private void method02222(MutableComponent var1, Component var2, int var3, int var4) {
      if (var3 < var4) {
         int[] var5 = new int[]{0};
         RawTextScope.method04525(() -> {
            StringBuilder var6 = new StringBuilder();
            Style[] var7 = new Style[]{null};
            var2.getVisualOrderText().accept((var7x, var8, var9) -> {
               if (var5[0] >= var4) {
                  return false;
               }

               if (var5[0] >= var3) {
                  if (!Objects.equals(var7[0], var8)) {
                     this.method02214(var1, var6, var7[0]);
                     var7[0] = var8;
                  }

                  var6.append(Character.toChars(var9));
               }

               var5[0]++;
               return true;
            });
            this.method02214(var1, var6, var7[0]);
            return null;
         });
      }
   }

   private void method02223(Line var1, ChatTextMatchAccess var2) {
      var2.setMatchComputed(true);
      var2.setSelfMatch(false);
      var2.setFriendMatch(false);
      Component var3 = var2.getRawText();
      if (var3 == null && var1.parent() != null) {
         var3 = var1.parent().content();
      }

      if (var3 != null) {
         Component var4 = var3;
         String var5 = RawTextScope.method04525(var4::getString);
         if (var5 != null && !var5.isEmpty()) {
            var var6 = this.method02236();
            if (!var6.isEmpty()) {
               this.method02234(var5, var6, var2);
            }
         }
      }
   }

   private void method02224(Set<String> var1, String var2) {
      if (var2 != null) {
         String var3 = field05215.matcher(var2).replaceAll("").trim();
         if (!var3.isEmpty()) {
            var1.add(var3);
         }
      }
   }

   private MutableComponent method02226(Component var1, String var2) {
      String var3 = field05368;
      int var4 = var2.indexOf(var3);
      if (var4 < 0) {
         return null;
      }

      int var5 = var4 + var3.length();
      int var6 = var2.indexOf(32, var5);
      if (var6 <= var5) {
         return null;
      }

      String var7 = var2.substring(var5, var6);
      PlayerTeam var8 = mc.level != null ? mc.level.getScoreboard().getPlayersTeam(var7) : null;
      Component var9 = var8 != null ? var8.getPlayerPrefix() : Component.empty();
      if (var9 == null) {
         var9 = Component.empty();
      }

      String var10 = RawTextScope.method04525(var9::getString);
      if (var10.isEmpty()) {
         return null;
      }

      boolean var11 = method02228(var10);
      Style var12 = this.method02238(var1, var5);
      MutableComponent var13 = Component.empty();
      this.method02222(var13, var1, 0, var4);
      var13.append(var9);
      if (var11) {
         var13.append(Component.literal("").setStyle(var12));
      }

      this.method02222(var13, var1, var5, var6);
      this.method02222(var13, var1, var6, var2.length());
      return var13;
   }

   private static boolean method02228(String var0) {
      return !var0.isEmpty() && !var0.endsWith(field05369);
   }

   public BetterChat() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field05213 = new MultiToggleSetting(field05219)
         .method04517(NamedOption.method08077(field05220, false))
         .method04517(NamedOption.method08077(field05221, false))
         .method04517(NamedOption.method08077(field05222, false))
         .method04517(NamedOption.method08077(field05223, false));
      this.field05214 = new MultiToggleSetting(field05224)
         .method04517(NamedOption.method08077(field05225, true))
         .method04517(NamedOption.method08077(field05226, false))
         .method03025(() -> this.field05213.method04520(field05370));
      this.method02231();
      this.field05213.method03023(this);
      this.field05214.method03023(this);
      this.method03935(field05227);
   }

   @Subscribe
   private void method02229(ChatLineEvent var1) {
      if (this.field05216) {
         Line var2 = var1.method05655();
         if (var2 != null) {
            ChatTextMatchAccess var3 = (ChatTextMatchAccess)(Object)var2;
            if (!var3.isMatchComputed()) {
               this.method02223(var2, var3);
            }

            boolean var4 = this.field05217 && var3.isSelfMatch();
            boolean var5 = this.field05218 && var3.isFriendMatch();
            if (var4 || var5) {
               int var6 = ColorUtils.method04625(var1.method05657());
               var1.method05658(var4 ? ColorUtils.method04597(100, 255, 255, var6) : ColorUtils.method04597(100, 255, 100, var6));
               var1.method05695(true);
            }
         }
      }
   }

   private static boolean method02230(int var0) {
      return Character.isLetterOrDigit(var0) || var0 == 95 || Character.getNumericValue(var0) != -1;
   }

   private void method02231() {
      this.field05212.put(field05228, field05229);
      this.field05212.put(field05230, field05231);
      this.field05212.put(field05232, field05233);
      this.field05212.put(field05234, field05235);
      this.field05212.put(field05236, field05237);
      this.field05212.put(field05238, field05239);
      this.field05212.put(field05240, field05241);
      this.field05212.put(field05242, field05243);
      this.field05212.put(field05244, field05245);
      this.field05212.put(field05246, field05247);
      this.field05212.put(field05248, field05249);
      this.field05212.put(field05250, field05251);
      this.field05212.put(field05252, field05253);
      this.field05212.put(field05254, field05255);
      this.field05212.put(field05256, field05257);
      this.field05212.put(field05258, field05259);
      this.field05212.put(field05260, field05261);
      this.field05212.put(field05262, field05263);
      this.field05212.put(field05264, field05265);
      this.field05212.put(field05266, field05267);
      this.field05212.put(field05268, field05269);
      this.field05212.put(field05270, field05271);
      this.field05212.put(field05272, field05273);
      this.field05212.put(field05274, field05275);
      this.field05212.put(field05276, field05277);
      this.field05212.put(field05278, field05279);
      this.field05212.put(field05280, field05281);
      this.field05212.put(field05282, field05283);
      this.field05212.put(field05284, field05285);
      this.field05212.put(field05286, field05287);
      this.field05212.put(field05288, field05289);
      this.field05212.put(field05290, field05291);
      this.field05212.put(field05292, field05293);
      this.field05212.put(field05294, field05295);
      this.field05212.put(field05296, field05297);
      this.field05212.put(field05298, field05299);
      this.field05212.put(field05300, field05301);
      this.field05212.put(field05302, field05303);
      this.field05212.put(field05304, field05305);
      this.field05212.put(field05306, field05307);
      this.field05212.put(field05308, field05309);
      this.field05212.put(field05310, field05311);
      this.field05212.put(field05312, field05313);
      this.field05212.put(field05314, field05315);
      this.field05212.put(field05316, field05317);
      this.field05212.put(field05318, field05319);
      this.field05212.put(field05320, field05321);
      this.field05212.put(field05322, field05323);
      this.field05212.put(field05324, field05325);
      this.field05212.put(field05326, field05327);
      this.field05212.put(field05328, field05329);
      this.field05212.put(field05330, field05331);
      this.field05212.put(field05332, field05333);
      this.field05212.put(field05334, field05335);
      this.field05212.put(field05336, field05337);
      this.field05212.put(field05338, field05339);
      this.field05212.put(field05340, field05341);
      this.field05212.put(field05342, field05343);
      this.field05212.put(field05344, field05345);
      this.field05212.put(field05346, field05347);
      this.field05212.put(field05348, field05349);
      this.field05212.put(field05350, field05351);
      this.field05212.put(field05352, field05353);
      this.field05212.put(field05354, field05355);
      this.field05212.put(field05356, field05357);
      this.field05212.put(field05358, field05359);
   }

   private Set<String> method02232() {
      HashSet var1 = new HashSet();
      if (mc != null && mc.getGameProfile() != null) {
         String var2 = mc.getGameProfile().name();
         if (var2 != null && !var2.isEmpty()) {
            var1.add(var2);
         }

         if (mc.getConnection() != null) {
            PlayerInfo var3 = mc.getConnection().getPlayerInfo(mc.getGameProfile().id());
            if (var3 != null) {
               Component var4 = var3.getTabListDisplayName();
               if (var4 != null) {
                  this.method02224(var1, RawTextScope.method04525(var4::getString));
               }
            }
         }

         if (mc.player != null) {
            Component var5 = mc.player.getCustomName();
            if (var5 != null) {
               this.method02224(var1, RawTextScope.method04525(var5::getString));
            }

            Component var6 = mc.player.getDisplayName();
            if (var6 != null) {
               this.method02224(var1, RawTextScope.method04525(var6::getString));
            }
         }

         return var1;
      } else {
         return var1;
      }
   }

   @Subscribe
   private void method02233(ChatSendEvent var1) {
      if (this.field05213.method04520(field05361)) {
         String var2 = var1.method11711();
         if (var2 != null && !var2.isEmpty()) {
            if (!var2.startsWith(field05362)) {
               StringBuilder var3 = new StringBuilder();

               for (char var7 : var2.toCharArray()) {
                  String var8 = String.valueOf(var7);
                  String var9 = this.field05212.get(var8);
                  if (var9 != null) {
                     var3.append(var9);
                  } else {
                     var3.append(var7);
                  }
               }

               var1.method11712(var3.toString());
            }
         }
      }
   }

   private void method02234(String var1, Map<String, Boolean> var2, ChatTextMatchAccess var3) {
      HashMap<Integer, List<String>> var4 = new HashMap<>();

      for (String var6 : var2.keySet()) {
         var4.computeIfAbsent(var6.codePointAt(0), var0 -> new ArrayList<>()).add(var6);
      }

      boolean var16 = false;
      boolean var17 = false;
      boolean var7 = false;
      int[] var8 = var1.codePoints().toArray();

      for (int var9 = 0; var9 < var8.length; var9++) {
         int var10 = var8[var9];
         if (!var7 || !method02230(var10)) {
            for (String var12 : var4.getOrDefault(var10, List.of())) {
               int[] var13 = var12.codePoints().toArray();
               if (var9 + var13.length - 1 < var8.length) {
                  boolean var14 = method02230(var13[var13.length - 1]);
                  boolean var15 = var9 + var13.length < var8.length && method02230(var8[var9 + var13.length]);
                  if ((!var14 || !var15) && method02240(var8, var9, var13)) {
                     if (Boolean.TRUE.equals(var2.get(var12))) {
                        var16 = true;
                     } else {
                        var17 = true;
                     }
                  }
               }
            }

            var7 = method02230(var10);
            if (var16 && var17) {
               break;
            }
         }
      }

      var3.setSelfMatch(var16);
      var3.setFriendMatch(var17);
   }

   @Subscribe
   private void method02235(PlayerUpdateEvent var1) {
      this.field05216 = this.field05213.method04520(field05365);
      this.field05217 = this.field05214.method04520(field05366);
      this.field05218 = this.field05214.method04520(field05367);
   }

   private Map<String, Boolean> method02236() {
      HashMap var1 = new HashMap();
      var var2 = this.method02232();
      HashSet var3 = new HashSet();

      for (String var5 : SocialStateUtils.method10612()) {
         if (var5 != null && !var5.isEmpty()) {
            var3.add(var5.toLowerCase(Locale.ROOT));
         }
      }

      if (!var3.isEmpty()) {
         HashMap<String, PlayerInfo> var9 = new HashMap<>();
         this.method02242(var9);

         for (var var6 : var9.entrySet()) {
            PlayerInfo var7 = (PlayerInfo)var6.getValue();
            if (var7 != null && var7.getProfile() != null) {
               String var8 = var7.getProfile().name();
               if (var8 != null && !var8.isEmpty() && !var2.contains(var6.getKey()) && var3.contains(var8.toLowerCase(Locale.ROOT))) {
                  var1.putIfAbsent((String)var6.getKey(), Boolean.FALSE);
               }
            }
         }

         for (String var14 : SocialStateUtils.method10612()) {
            if (var14 != null && !var14.isEmpty() && !var2.contains(var14)) {
               var1.putIfAbsent(var14, Boolean.FALSE);
            }
         }
      }

      for (String var13 : var2) {
         var1.put(var13, Boolean.TRUE);
      }

      return var1;
   }

   @Subscribe
   private void method02237(PacketEvent var1) {
      if (var1.method10897() instanceof ClientboundSystemChatPacket var3) {
         Component var4 = var3.content();
         String var5 = RawTextScope.method04525(var4::getString);
         if (this.field05213.method04520(field05363) && var5.contains(field05364)) {
            MutableComponent var6 = this.method02226(var4, var5);
            if (var6 == null) {
               return;
            }

            var1.method05696();
            mc.execute(() -> mc.gui.hud.getChat().addClientSystemMessage(var6));
         }
      }
   }

   private Style method02238(Component var1, int var2) {
      Style[] var3 = new Style[]{Style.EMPTY};
      int[] var4 = new int[]{0};
      RawTextScope.method04525(() -> {
         var1.getVisualOrderText().accept((var3xx, var4x, var5) -> {
            if (var4[0] == var2) {
               var3[0] = var4x;
               return false;
            } else {
               var4[0]++;
               return true;
            }
         });
         return null;
      });
      return var3[0];
   }

   private static boolean method02240(int[] var0, int var1, int[] var2) {
      for (int var3 = 0; var3 < var2.length; var3++) {
         if (var0[var1 + var3] != var2[var3]) {
            return false;
         }
      }

      return true;
   }

   private void method02242(Map<String, PlayerInfo> var1) {
      if (mc != null && mc.getConnection() != null) {
         for (PlayerInfo var3 : mc.getConnection().getOnlinePlayers()) {
            if (var3 != null && var3.getProfile() != null) {
               this.method02218(var1, var3.getProfile().name(), var3);
               Component var4 = var3.getTabListDisplayName();
               if (var4 != null) {
                  this.method02218(var1, RawTextScope.method04525(var4::getString), var3);
               }

               this.method02220(var1, var3);
            }
         }
      }
   }
}
