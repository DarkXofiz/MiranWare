// Original binary: sg/ec/xdXUTx2YaYaQqdXz
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.TextColor;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.item.alchemy.PotionContents;

// $VF: Compiled from s
public final class PotionItemData {
   private static final int field26027 = ColorUtils.method04604(255, 0, 0);
   private static final int field26028 = ColorUtils.method04604(255, 102, 0);
   private static final TextColor field26029 = TextColor.fromRgb(field26027);
   private static final TextColor field26030 = TextColor.fromRgb(field26028);
   public static final Component field26031 = Component.empty()
      .append(
         Component.literal(PotionItemData.field26273)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26272)).withBold(true).withItalic(false).withObfuscated(true))
      )
      .append(
         Component.literal(PotionItemData.field26274)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26271)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26275)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26270)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26276)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26269)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26277)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26268)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26278)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26267)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26279)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26266)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26280)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26265)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26281)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26264)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26282)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26263)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26283)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26262)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26284)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26261)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26285)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26260)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26286)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26259)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26287)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26258)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26288)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26257)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26289)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26256)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26290)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26255)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26291)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26254)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26292)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26253)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26293)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26252)).withBold(true).withItalic(false).withObfuscated(true))
      );
   public static final Component field26032 = Component.empty()
      .append(
         Component.literal(PotionItemData.field26294)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26251)).withBold(true).withItalic(false).withObfuscated(true))
      )
      .append(
         Component.literal(PotionItemData.field26295)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26250)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26296)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26249)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26297)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26248)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26298)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26247)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26299)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26246)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26300)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26245)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26301)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26244)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26302)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26243)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26303)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26242)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26304)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26241)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26305)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26240)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26306)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26239)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26307)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26238)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26308)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26237)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26309)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26236)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26310)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26235)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26311)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26234)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26312)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26233)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26313)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26232)).withBold(true).withItalic(false))
      )
      .append(
         Component.literal(PotionItemData.field26314)
            .withStyle(var0 -> var0.withColor(TextColor.fromRgb(PotionItemData.field26231)).withBold(true).withItalic(false).withObfuscated(true))
      );
   public static final Component field26033 = Component.empty()
      .append(Component.literal(PotionItemData.field26315).withStyle(var0 -> var0.withColor(field26029)))
      .append(Component.literal(PotionItemData.field26316).withStyle(var0 -> var0.withColor(field26030).withItalic(false)));
   public static final Component field26034 = Component.empty()
      .append(Component.literal(PotionItemData.field26317).withStyle(var0 -> var0.withColor(field26029)))
      .append(Component.literal(PotionItemData.field26318).withStyle(var0 -> var0.withColor(field26030).withItalic(false)));
   public static final Component field26035 = Component.empty()
      .append(Component.literal(PotionItemData.field26319).withStyle(var0 -> var0.withColor(field26029)))
      .append(Component.literal(PotionItemData.field26320).withStyle(var0 -> var0.withColor(field26030).withItalic(false)));
   public static final Component field26036 = Component.empty()
      .append(Component.literal(PotionItemData.field26321).withStyle(var0 -> var0.withColor(field26029)))
      .append(Component.literal(PotionItemData.field26322).withStyle(var0 -> var0.withColor(field26030).withItalic(false)));
   public static final Component field26037 = Component.empty()
      .append(Component.literal(PotionItemData.field26323).withStyle(var0 -> var0.withColor(field26029)))
      .append(Component.literal(PotionItemData.field26324).withStyle(var0 -> var0.withColor(field26030).withItalic(false)));
   public static final Component field26038 = Component.empty()
      .append(Component.literal(PotionItemData.field26325).withStyle(var0 -> var0.withColor(field26029)))
      .append(Component.literal(PotionItemData.field26326).withStyle(var0 -> var0.withColor(field26030).withItalic(false)));
   public static final int field26039 = 3329330;
   public static final int field26040 = 0;
   public static final int field26041 = 0;
   public static final int field26042 = 0;
   public static final int field26043 = 0;
   public static final int field26044 = 0;
   private static final Map<Integer, PotionContents> field26045 = new HashMap<>();
   private static final Map<Integer, Component> field26046 = new HashMap<>();
   private static final int field26047 = 3329330;
   private static final int field26048 = 3329330;
   private static final int field26049 = 3329330;
   private static final int field26050 = 3355443;
   private static final int field26051 = 3355443;
   private static final int field26052 = 3355443;
   private static final int field26053 = 16777215;
   private static final int field26054 = 16777215;
   private static final int field26055 = 16777215;
   private static final int field26056 = 65535;
   private static final int field26057 = 65535;
   private static final int field26058 = 65535;
   private static final int field26059 = 16738740;
   private static final int field26060 = 16738740;
   private static final int field26061 = 16738740;
   private static final String field26062 = "[★]";
   private static final String field26063 = " ";
   private static final String field26064 = "З";
   private static final String field26065 = "е";
   private static final String field26066 = "л";
   private static final String field26067 = "ь";
   private static final String field26068 = "е";
   private static final String field26069 = " ";
   private static final String field26070 = "Р";
   private static final String field26071 = "а";
   private static final String field26072 = "д";
   private static final String field26073 = "и";
   private static final String field26074 = "а";
   private static final String field26075 = "ц";
   private static final String field26076 = "и";
   private static final String field26077 = "и";
   private static final String field26078 = "[★]";
   private static final String field26079 = " ";
   private static final String field26080 = "З";
   private static final String field26081 = "е";
   private static final String field26082 = "л";
   private static final String field26083 = "ь";
   private static final String field26084 = "е";
   private static final String field26085 = " ";
   private static final String field26086 = "А";
   private static final String field26087 = "с";
   private static final String field26088 = "с";
   private static final String field26089 = "а";
   private static final String field26090 = "с";
   private static final String field26091 = "и";
   private static final String field26092 = "н";
   private static final String field26093 = "а";
   private static final String field26094 = "[★]";
   private static final String field26095 = " ";
   private static final String field26096 = "С";
   private static final String field26097 = "в";
   private static final String field26098 = "я";
   private static final String field26099 = "т";
   private static final String field26100 = "а";
   private static final String field26101 = "я";
   private static final String field26102 = " ";
   private static final String field26103 = "в";
   private static final String field26104 = "о";
   private static final String field26105 = "д";
   private static final String field26106 = "а";
   private static final String field26107 = "[★]";
   private static final String field26108 = " ";
   private static final String field26109 = "С";
   private static final String field26110 = "н";
   private static final String field26111 = "о";
   private static final String field26112 = "т";
   private static final String field26113 = "в";
   private static final String field26114 = "о";
   private static final String field26115 = "р";
   private static final String field26116 = "н";
   private static final String field26117 = "о";
   private static final String field26118 = "е";
   private static final String field26119 = "[★]";
   private static final String field26120 = " ";
   private static final String field26121 = "З";
   private static final String field26122 = "е";
   private static final String field26123 = "л";
   private static final String field26124 = "ь";
   private static final String field26125 = "е";
   private static final String field26126 = " ";
   private static final String field26127 = "П";
   private static final String field26128 = "а";
   private static final String field26129 = "л";
   private static final String field26130 = "л";
   private static final String field26131 = "а";
   private static final String field26132 = "д";
   private static final String field26133 = "и";
   private static final String field26134 = "н";
   private static final String field26135 = "а";
   private static final String field26136 = "[★]";
   private static final String field26137 = " ";
   private static final String field26138 = "Х";
   private static final String field26139 = "л";
   private static final String field26140 = "о";
   private static final String field26141 = "п";
   private static final String field26142 = "у";
   private static final String field26143 = "ш";
   private static final String field26144 = "к";
   private static final String field26145 = "а";
   private static final String field26146 = "This is a utility class and cannot be instantiated";
   private static final int field26147 = 65484;
   private static final int field26148 = 4846994;
   private static final int field26149 = 9628759;
   private static final int field26150 = 14410269;
   private static final int field26151 = 16760076;
   private static final int field26152 = 16743972;
   private static final int field26153 = 16727869;
   private static final int field26154 = 16711765;
   private static final int field26155 = 16777215;
   private static final int field26156 = 16716947;
   private static final int field26157 = 13762395;
   private static final int field26158 = 14090092;
   private static final int field26159 = 14417789;
   private static final int field26160 = 14745486;
   private static final int field26161 = 15007648;
   private static final int field26162 = 15335345;
   private static final int field26163 = 15663042;
   private static final int field26164 = 15990739;
   private static final int field26165 = 15663042;
   private static final int field26166 = 15335345;
   private static final int field26167 = 15007648;
   private static final int field26168 = 14745486;
   private static final int field26169 = 14417789;
   private static final int field26170 = 14090092;
   private static final int field26171 = 13762395;
   private static final int field26172 = 16777215;
   private static final int field26173 = 13762395;
   private static final int field26174 = 6918889;
   private static final int field26175 = 5408733;
   private static final int field26176 = 3833041;
   private static final int field26177 = 2322884;
   private static final int field26178 = 812728;
   private static final int field26179 = 481455;
   private static final int field26180 = 1394090;
   private static final int field26181 = 2306725;
   private static final int field26182 = 3219615;
   private static final int field26183 = 4132250;
   private static final int field26184 = 16777215;
   private static final int field26185 = 4132250;
   private static final int field26186 = 16776754;
   private static final int field26187 = 16776769;
   private static final int field26188 = 16776785;
   private static final int field26189 = 16776800;
   private static final int field26190 = 16776815;
   private static final int field26191 = 16777087;
   private static final int field26192 = 16777102;
   private static final int field26193 = 16777117;
   private static final int field26194 = 16777132;
   private static final int field26195 = 16777148;
   private static final int field26196 = 16777163;
   private static final int field26197 = 16777215;
   private static final int field26198 = 16777163;
   private static final int field26199 = 8388608;
   private static final int field26200 = 8062213;
   private static final int field26201 = 7735819;
   private static final int field26202 = 7409424;
   private static final int field26203 = 7148821;
   private static final int field26204 = 6822427;
   private static final int field26205 = 6496032;
   private static final int field26206 = 6169637;
   private static final int field26207 = 5843242;
   private static final int field26208 = 5516848;
   private static final int field26209 = 5256245;
   private static final int field26210 = 4929850;
   private static final int field26211 = 4603456;
   private static final int field26212 = 4277061;
   private static final int field26213 = 16777215;
   private static final int field26214 = 4277061;
   private static final int field26215 = 9699134;
   private static final int field26216 = 10222676;
   private static final int field26217 = 10746217;
   private static final int field26218 = 11269759;
   private static final int field26219 = 11858836;
   private static final int field26220 = 12382378;
   private static final int field26221 = 12905919;
   private static final int field26222 = 13429951;
   private static final int field26223 = 14020265;
   private static final int field26224 = 14545043;
   private static final int field26225 = 15135100;
   private static final int field26226 = 15659878;
   private static final int field26227 = 16250192;
   private static final int field26228 = 16774970;
   private static final int field26229 = 16777215;
   private static final int field26230 = 16774970;
   private static final int field26231 = 1014730;
   private static final int field26232 = 1014730;
   private static final int field26233 = 2126283;
   private static final int field26234 = 3303628;
   private static final int field26235 = 4415182;
   private static final int field26236 = 5592527;
   private static final int field26237 = 6704080;
   private static final int field26238 = 7881425;
   private static final int field26239 = 8992979;
   private static final int field26240 = 10170324;
   private static final int field26241 = 11281877;
   private static final int field26242 = 11281087;
   private static final int field26243 = 11214760;
   private static final int field26244 = 11213970;
   private static final int field26245 = 11147643;
   private static final int field26246 = 11147109;
   private static final int field26247 = 11080782;
   private static final int field26248 = 11079992;
   private static final int field26249 = 11013665;
   private static final int field26250 = 11012875;
   private static final int field26251 = 11012875;
   private static final int field26252 = 9240576;
   private static final int field26253 = 9240576;
   private static final int field26254 = 10027008;
   private static final int field26255 = 10813440;
   private static final int field26256 = 11599872;
   private static final int field26257 = 12386304;
   private static final int field26258 = 13172736;
   private static final int field26259 = 13959168;
   private static final int field26260 = 14745600;
   private static final int field26261 = 15532032;
   private static final int field26262 = 16318464;
   private static final int field26263 = 15532032;
   private static final int field26264 = 14745600;
   private static final int field26265 = 13959168;
   private static final int field26266 = 13172736;
   private static final int field26267 = 12386304;
   private static final int field26268 = 11599872;
   private static final int field26269 = 10813440;
   private static final int field26270 = 10027008;
   private static final int field26271 = 9240576;
   private static final int field26272 = 9240576;
   private static final String field26273 = "xxx";
   private static final String field26274 = " ";
   private static final String field26275 = "Т";
   private static final String field26276 = "а";
   private static final String field26277 = "л";
   private static final String field26278 = "и";
   private static final String field26279 = "с";
   private static final String field26280 = "м";
   private static final String field26281 = "а";
   private static final String field26282 = "н";
   private static final String field26283 = " К";
   private static final String field26284 = "р";
   private static final String field26285 = "у";
   private static final String field26286 = "ш";
   private static final String field26287 = "и";
   private static final String field26288 = "т";
   private static final String field26289 = "е";
   private static final String field26290 = "л";
   private static final String field26291 = "я";
   private static final String field26292 = " ";
   private static final String field26293 = "xxx";
   private static final String field26294 = "xxx";
   private static final String field26295 = " ";
   private static final String field26296 = "Т";
   private static final String field26297 = "а";
   private static final String field26298 = "л";
   private static final String field26299 = "и";
   private static final String field26300 = "с";
   private static final String field26301 = "м";
   private static final String field26302 = "а";
   private static final String field26303 = "н";
   private static final String field26304 = " ";
   private static final String field26305 = "К";
   private static final String field26306 = "а";
   private static final String field26307 = "р";
   private static final String field26308 = "а";
   private static final String field26309 = "т";
   private static final String field26310 = "е";
   private static final String field26311 = "л";
   private static final String field26312 = "я";
   private static final String field26313 = " ";
   private static final String field26314 = "xxx";
   private static final String field26315 = "[★] ";
   private static final String field26316 = "Талисман Мрака";
   private static final String field26317 = "[★] ";
   private static final String field26318 = "Талисман Демона";
   private static final String field26319 = "[★] ";
   private static final String field26320 = "Талисман Вихря";
   private static final String field26321 = "[★] ";
   private static final String field26322 = "Талисман Раздора";
   private static final String field26323 = "[★] ";
   private static final String field26324 = "Талисман Тирана";
   private static final String field26325 = "[★] ";
   private static final String field26326 = "Талисман Ярости";

   private static Component method11367() {
      return Component.empty()
         .append(Component.literal(field26119).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26173)).withBold(true).withItalic(false)))
         .append(Component.literal(field26120).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26172)).withBold(true).withItalic(false)))
         .append(Component.literal(field26121).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26171)).withBold(true).withItalic(false)))
         .append(Component.literal(field26122).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26170)).withBold(true).withItalic(false)))
         .append(Component.literal(field26123).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26169)).withBold(true).withItalic(false)))
         .append(Component.literal(field26124).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26168)).withBold(true).withItalic(false)))
         .append(Component.literal(field26125).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26167)).withBold(true).withItalic(false)))
         .append(Component.literal(field26126).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26166)).withBold(true).withItalic(false)))
         .append(Component.literal(field26127).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26165)).withBold(true).withItalic(false)))
         .append(Component.literal(field26128).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26164)).withBold(true).withItalic(false)))
         .append(Component.literal(field26129).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26163)).withBold(true).withItalic(false)))
         .append(Component.literal(field26130).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26162)).withBold(true).withItalic(false)))
         .append(Component.literal(field26131).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26161)).withBold(true).withItalic(false)))
         .append(Component.literal(field26132).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26160)).withBold(true).withItalic(false)))
         .append(Component.literal(field26133).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26159)).withBold(true).withItalic(false)))
         .append(Component.literal(field26134).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26158)).withBold(true).withItalic(false)))
         .append(Component.literal(field26135).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26157)).withBold(true).withItalic(false)));
   }

   private static List<MobEffectInstance> method11390() {
      ArrayList var0 = new ArrayList();
      var0.add(new MobEffectInstance(MobEffects.STRENGTH, 1200, 3));
      var0.add(new MobEffectInstance(MobEffects.SPEED, 6000, 2));
      var0.add(new MobEffectInstance(MobEffects.HASTE, 1200, 0));
      var0.add(new MobEffectInstance(MobEffects.INSTANT_DAMAGE, 0, 1));
      return var0;
   }

   private static Component method11404() {
      return Component.empty()
         .append(Component.literal(field26062).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26230)).withBold(true).withItalic(false)))
         .append(Component.literal(field26063).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26229)).withBold(true).withItalic(false)))
         .append(Component.literal(field26064).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26228)).withBold(true).withItalic(false)))
         .append(Component.literal(field26065).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26227)).withBold(true).withItalic(false)))
         .append(Component.literal(field26066).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26226)).withBold(true).withItalic(false)))
         .append(Component.literal(field26067).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26225)).withBold(true).withItalic(false)))
         .append(Component.literal(field26068).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26224)).withBold(true).withItalic(false)))
         .append(Component.literal(field26069).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26223)).withBold(true).withItalic(false)))
         .append(Component.literal(field26070).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26222)).withBold(true).withItalic(false)))
         .append(Component.literal(field26071).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26221)).withBold(true).withItalic(false)))
         .append(Component.literal(field26072).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26220)).withBold(true).withItalic(false)))
         .append(Component.literal(field26073).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26219)).withBold(true).withItalic(false)))
         .append(Component.literal(field26074).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26218)).withBold(true).withItalic(false)))
         .append(Component.literal(field26075).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26217)).withBold(true).withItalic(false)))
         .append(Component.literal(field26076).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26216)).withBold(true).withItalic(false)))
         .append(Component.literal(field26077).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26215)).withBold(true).withItalic(false)));
   }

   private static List<MobEffectInstance> method11405() {
      ArrayList var0 = new ArrayList();
      var0.add(new MobEffectInstance(MobEffects.SLOWNESS, 200, 9));
      var0.add(new MobEffectInstance(MobEffects.SPEED, 400, 4));
      var0.add(new MobEffectInstance(MobEffects.BLINDNESS, 100, 9));
      var0.add(new MobEffectInstance(MobEffects.GLOWING, 3600, 0));
      return var0;
   }

   private static List<MobEffectInstance> method11408() {
      ArrayList var0 = new ArrayList();
      var0.add(new MobEffectInstance(MobEffects.REGENERATION, 900, 1));
      var0.add(new MobEffectInstance(MobEffects.INVISIBILITY, 12000, 1));
      var0.add(new MobEffectInstance(MobEffects.INSTANT_HEALTH, 0, 1));
      return var0;
   }

   public static PotionContents method11411(int var0) {
      return field26045.get(var0);
   }

   private PotionItemData() {
      throw new UnsupportedOperationException(field26146);
   }

   public static void method11423() {
      PotionContents var0 = new PotionContents(Optional.empty(), Optional.of(field26047), method11468(), Optional.empty());
      field26045.put(field26048, var0);
      field26046.put(field26049, method11404());
      PotionContents var1 = new PotionContents(Optional.empty(), Optional.of(field26050), method11390(), Optional.empty());
      field26045.put(field26051, var1);
      field26046.put(field26052, method11477());
      PotionContents var2 = new PotionContents(Optional.empty(), Optional.of(field26053), method11408(), Optional.empty());
      field26045.put(field26054, var2);
      field26046.put(field26055, method11462());
      PotionContents var3 = new PotionContents(Optional.empty(), Optional.of(255), method11498(), Optional.empty());
      field26045.put(255, var3);
      field26046.put(255, method11426());
      PotionContents var4 = new PotionContents(Optional.empty(), Optional.of(field26056), method11503(), Optional.empty());
      field26045.put(field26057, var4);
      field26046.put(field26058, method11367());
      PotionContents var5 = new PotionContents(Optional.empty(), Optional.of(field26059), method11405(), Optional.empty());
      field26045.put(field26060, var5);
      field26046.put(field26061, method11457());
   }

   private static Component method11426() {
      return Component.empty()
         .append(Component.literal(field26107).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26185)).withBold(true).withItalic(false)))
         .append(Component.literal(field26108).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26184)).withBold(true).withItalic(false)))
         .append(Component.literal(field26109).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26183)).withBold(true).withItalic(false)))
         .append(Component.literal(field26110).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26182)).withBold(true).withItalic(false)))
         .append(Component.literal(field26111).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26181)).withBold(true).withItalic(false)))
         .append(Component.literal(field26112).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26180)).withBold(true).withItalic(false)))
         .append(Component.literal(field26113).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26179)).withBold(true).withItalic(false)))
         .append(Component.literal(field26114).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26178)).withBold(true).withItalic(false)))
         .append(Component.literal(field26115).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26177)).withBold(true).withItalic(false)))
         .append(Component.literal(field26116).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26176)).withBold(true).withItalic(false)))
         .append(Component.literal(field26117).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26175)).withBold(true).withItalic(false)))
         .append(Component.literal(field26118).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26174)).withBold(true).withItalic(false)));
   }

   private static Component method11457() {
      return Component.empty()
         .append(Component.literal(field26136).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26156)).withBold(true).withItalic(false)))
         .append(Component.literal(field26137).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26155)).withBold(true).withItalic(false)))
         .append(Component.literal(field26138).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26154)).withBold(true).withItalic(false)))
         .append(Component.literal(field26139).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26153)).withBold(true).withItalic(false)))
         .append(Component.literal(field26140).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26152)).withBold(true).withItalic(false)))
         .append(Component.literal(field26141).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26151)).withBold(true).withItalic(false)))
         .append(Component.literal(field26142).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26150)).withBold(true).withItalic(false)))
         .append(Component.literal(field26143).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26149)).withBold(true).withItalic(false)))
         .append(Component.literal(field26144).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26148)).withBold(true).withItalic(false)))
         .append(Component.literal(field26145).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26147)).withBold(true).withItalic(false)));
   }

   private static Component method11462() {
      return Component.empty()
         .append(Component.literal(field26094).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26198)).withBold(true).withItalic(false)))
         .append(Component.literal(field26095).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26197)).withBold(true).withItalic(false)))
         .append(Component.literal(field26096).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26196)).withBold(true).withItalic(false)))
         .append(Component.literal(field26097).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26195)).withBold(true).withItalic(false)))
         .append(Component.literal(field26098).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26194)).withBold(true).withItalic(false)))
         .append(Component.literal(field26099).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26193)).withBold(true).withItalic(false)))
         .append(Component.literal(field26100).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26192)).withBold(true).withItalic(false)))
         .append(Component.literal(field26101).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26191)).withBold(true).withItalic(false)))
         .append(Component.literal(field26102).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26190)).withBold(true).withItalic(false)))
         .append(Component.literal(field26103).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26189)).withBold(true).withItalic(false)))
         .append(Component.literal(field26104).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26188)).withBold(true).withItalic(false)))
         .append(Component.literal(field26105).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26187)).withBold(true).withItalic(false)))
         .append(Component.literal(field26106).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26186)).withBold(true).withItalic(false)));
   }

   private static List<MobEffectInstance> method11468() {
      ArrayList var0 = new ArrayList();
      var0.add(new MobEffectInstance(MobEffects.POISON, 1200, 1));
      var0.add(new MobEffectInstance(MobEffects.WITHER, 1200, 1));
      var0.add(new MobEffectInstance(MobEffects.SLOWNESS, 1800, 2));
      var0.add(new MobEffectInstance(MobEffects.HUNGER, 1200, 4));
      var0.add(new MobEffectInstance(MobEffects.GLOWING, 2400, 0));
      return var0;
   }

   private static Component method11477() {
      return Component.empty()
         .append(Component.literal(field26078).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26214)).withBold(true).withItalic(false)))
         .append(Component.literal(field26079).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26213)).withBold(true).withItalic(false)))
         .append(Component.literal(field26080).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26212)).withBold(true).withItalic(false)))
         .append(Component.literal(field26081).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26211)).withBold(true).withItalic(false)))
         .append(Component.literal(field26082).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26210)).withBold(true).withItalic(false)))
         .append(Component.literal(field26083).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26209)).withBold(true).withItalic(false)))
         .append(Component.literal(field26084).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26208)).withBold(true).withItalic(false)))
         .append(Component.literal(field26085).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26207)).withBold(true).withItalic(false)))
         .append(Component.literal(field26086).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26206)).withBold(true).withItalic(false)))
         .append(Component.literal(field26087).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26205)).withBold(true).withItalic(false)))
         .append(Component.literal(field26088).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26204)).withBold(true).withItalic(false)))
         .append(Component.literal(field26089).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26203)).withBold(true).withItalic(false)))
         .append(Component.literal(field26090).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26202)).withBold(true).withItalic(false)))
         .append(Component.literal(field26091).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26201)).withBold(true).withItalic(false)))
         .append(Component.literal(field26092).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26200)).withBold(true).withItalic(false)))
         .append(Component.literal(field26093).withStyle(var0 -> var0.withColor(TextColor.fromRgb(field26199)).withBold(true).withItalic(false)));
   }

   public static Component method11489(int var0) {
      return field26046.get(var0);
   }

   private static List<MobEffectInstance> method11498() {
      ArrayList var0 = new ArrayList();
      var0.add(new MobEffectInstance(MobEffects.WEAKNESS, 1800, 1));
      var0.add(new MobEffectInstance(MobEffects.MINING_FATIGUE, 200, 1));
      var0.add(new MobEffectInstance(MobEffects.WITHER, 1800, 2));
      var0.add(new MobEffectInstance(MobEffects.BLINDNESS, 200, 0));
      return var0;
   }

   private static List<MobEffectInstance> method11503() {
      ArrayList var0 = new ArrayList();
      var0.add(new MobEffectInstance(MobEffects.RESISTANCE, 12000, 0));
      var0.add(new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 12000, 0));
      var0.add(new MobEffectInstance(MobEffects.HEALTH_BOOST, 1200, 2));
      var0.add(new MobEffectInstance(MobEffects.INVISIBILITY, 18000, 0));
      return var0;
   }
}
