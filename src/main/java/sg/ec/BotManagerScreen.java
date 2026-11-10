// Original binary: sg/ec/XTooW57WVyHpj8RF
package sg.ec;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.IntConsumer;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.util.Mth;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.phys.Vec2;

// $VF: Compiled from s
public class BotManagerScreen extends ClientScreen {
   private static final float field13954 = 362.5F;
   private static final float field13955 = 0;
   private static final float field13956 = 0;
   private static final float field13957 = 0;
   private static final float field13958 = 0;
   private static final float field13959 = 0;
   private static final float field13960 = 0;
   private static final float field13961 = 0;
   private static final float field13962 = 0;
   private static final float field13963 = 0;
   private static final float field13964 = 0;
   private static final float field13965 = 0;
   private static final float field13966 = 0;
   private static final float field13967 = 0;
   private static final float field13968 = 0;
   private static final float field13969 = 0;
   private static final float field13970 = 0;
   private static final float field13971 = 0;
   private static final float field13972 = 0;
   private static final float field13973 = 0;
   private static final float field13974 = 0;
   private static final float field13975 = 0;
   private static final float field13976 = 0;
   private static final float field13977 = 0;
   private static final float field13978 = 0;
   private static final float field13979 = 0;
   private static final float field13980 = 0;
   private static final float field13981 = 0;
   private static final float field13982 = 0;
   private static final float field13983 = 0;
   private static final float field13984 = 0;
   private static final float field13985 = 0;
   private static final float field13986 = 0;
   private static final float field13987 = 0;
   private static final float field13988 = 0;
   private static final float field13989 = 0;
   private static final float field13990 = 0;
   private static final float field13991 = 0;
   private static final float field13992 = 0;
   private static final float field13993 = 0;
   private static final float field13994 = 0;
   private static final float field13995 = 0;
   private static final float field13996 = 0;
   private static final float field13997 = 0;
   private static final float field13998 = 0;
   private static final float field13999 = 0;
   private static final float field14000 = 0;
   private static final float field14001 = 0;
   private static final float field14002 = 0;
   private static final int field14003 = 0;
   private static final float field14004 = 0;
   private static final float field14005 = 0;
   private static final int field14006 = 0;
   private static final int field14007 = 0;
   private static final int field14008 = 0;
   private static final int field14009 = 0;
   private static final int field14010 = 0;
   private static final int field14011 = 0;
   private static final float field14012 = 0;
   private static final float field14013 = 0;
   private static final int field14014 = 0;
   private static final int field14015 = 0;
   private static final int field14016 = 0;
   private static final String field14017 = "field14017";
   private static final String field14018 = "field14018";
   private static final String field14019 = "field14019";
   private static final String field14020 = "field14020";
   private static final String field14021 = "field14021";
   private static final String field14022 = "field14022";
   private static final String field14023 = "field14023";
   private static final String field14024 = "field14024";
   private static final String field14025 = "field14025";
   private static final String field14026 = "field14026";
   private static final String field14027 = "field14027";
   private static final String field14028 = "field14028";
   private static final String field14029 = "field14029";
   private static final String field14030 = "field14030";
   private static final String field14031 = "field14031";
   private static final String field14032 = "field14032";
   private static final String field14033 = "field14033";
   private static final String field14034 = "field14034";
   private static final String field14035 = "field14035";
   private static final String field14036 = "field14036";
   private static final String field14037 = "field14037";
   private static final String field14038 = "field14038";
   private static final String field14039 = "field14039";
   private static final String field14040 = "field14040";
   private static final String field14041 = "field14041";
   private static final String field14042 = "field14042";
   private static final String field14043 = "field14043";
   private static final String field14044 = "field14044";
   private static final String field14045 = "field14045";
   private static final String field14046 = "field14046";
   private static final int field14047 = 0;
   private static final String field14048 = "field14048";
   private static final String field14049 = "field14049";
   private static final String field14050 = "field14050";
   private static final String field14051 = "field14051";
   private static final String field14052 = "field14052";
   private static final String field14053 = "field14053";
   private static final String field14054 = "field14054";
   private static final String field14055 = "field14055";
   private static final String field14056 = "field14056";
   private static final String field14057 = "field14057";
   private static final String field14058 = "field14058";
   private static final String field14059 = "field14059";
   private static final String[] field14060 = new String[]{BotManagerScreen.field14539, BotManagerScreen.field14540, BotManagerScreen.field14541};
   private static final float field14061 = 0;
   private static final String field14062 = "field14062";
   private static final String field14063 = "field14063";
   private static final String field14064 = "field14064";
   private static final String field14065 = "field14065";
   private static final String field14066 = "field14066";
   private static final String field14067 = "field14067";
   private static final String field14068 = "field14068";
   private static final String field14069 = "field14069";
   private static final String field14070 = "field14070";
   private static final String field14071 = "field14071";
   private static final String field14072 = "field14072";
   private static final String field14073 = "field14073";
   private static final String field14074 = "field14074";
   private static final String field14075 = "field14075";
   private static final String field14076 = "field14076";
   private static final String field14077 = "field14077";
   private static final String field14078 = "field14078";
   private static final String field14079 = "field14079";
   private static final String field14080 = "field14080";
   private static final String field14081 = "field14081";
   private static final String field14082 = "field14082";
   private static final String field14083 = "field14083";
   private static final String field14084 = "field14084";
   private static final String field14085 = "field14085";
   private static final String field14086 = "field14086";
   private static final String field14087 = "field14087";
   private static final String field14088 = "field14088";
   private static final String field14089 = "field14089";
   private static final String field14090 = "field14090";
   private static final String field14091 = "field14091";
   private static final String field14092 = "field14092";
   private static final String field14093 = "field14093";
   private static final String field14094 = "field14094";
   private static final String field14095 = "field14095";
   private static final String field14096 = "field14096";
   private static final String field14097 = "field14097";
   private static final String field14098 = "field14098";
   private static final String field14099 = "field14099";
   private static final String field14100 = "field14100";
   private static final String[] field14101 = new String[]{BotManagerScreen.field14542, BotManagerScreen.field14543, BotManagerScreen.field14544};
   private final SmoothAnimation field14102 = new SmoothAnimation();
   private final Map<Object, SmoothAnimation> field14103 = new HashMap<>();
   private final Map<BotClient, SmoothAnimation> field14104 = new HashMap<>();
   private final Map<String, SmoothAnimation> field14105 = new HashMap<>();
   private final GuiClickRegions field14106 = new GuiClickRegions();
   private final GuiClickRegions field14107 = new GuiClickRegions();
   private final GuiClickRegions field14108 = new GuiClickRegions();
   private GuiClickRegions field14109 = this.field14106;
   private final List<BotClient> field14110 = new ArrayList<>();
   private final ScrollController field14111 = new ScrollController();
   private final ScrollController field14112 = new ScrollController();
   private final GuiBounds field14113 = new GuiBounds();
   private final BotInventorySnapshot field14114 = new BotInventorySnapshot();
   private final GuiBounds field14115 = new GuiBounds();
   private final TextInputWidget field14116;
   private final TextInputWidget field14117;
   private final TextInputWidget field14118;
   private final TextInputWidget field14119;
   private final TextInputWidget field14120;
   private final TextInputWidget field14121;
   private final TextInputWidget field14122;
   private final TextInputWidget field14123;
   private final TextInputWidget field14124;
   private final TextInputWidget field14125;
   private final TextInputWidget field14126;
   private final List<TextInputWidget> field14127;
   private final List<TextInputWidget> field14128;
   private final List<TextInputWidget> field14129;
   private final BotManagerScreen.Nested184 field14130;
   private final BotManagerScreen.Nested184 field14131;
   private final BotManagerScreen.Nested184 field14132;
   private final BotManagerScreen.Nested184 field14133;
   private final BotManagerScreen.Nested184 field14134;
   private final BotManagerScreen.Nested184 field14135;
   private final TooltipRenderer field14136;
   private final List<String> field14137;
   private final List<String> field14138;
   private List<String> field14139;
   private float field14140;
   private float field14141;
   private float field14142;
   private float field14143;
   private float field14144;
   private boolean field14145;
   private boolean field14146;
   private float field14147;
   private float field14148;
   private BotClient field14149;
   private BotManagerScreen.Nested184 field14150;
   private String field14151;
   private BotClient field14152;
   private BotManagerScreen.Nested185 field14153;
   private int field14154;
   private String field14155;
   private ProxyConfig.Nested114 field14156;
   private boolean field14157;
   private static final String field14158 = "Search";
   private static final String field14159 = "Сообщение";
   private static final String field14160 = "ip:port";
   private static final String field14161 = "Ник бота";
   private static final String field14162 = "ip:port";
   private static final String field14163 = "Имя прокси";
   private static final String field14164 = "ip:port";
   private static final String field14165 = "Логин";
   private static final String field14166 = "Пароль";
   private static final String field14167 = "авто";
   private static final String field14168 = "Версия";
   private static final String field14169 = "Прокси";
   private static final String field14170 = "Количество";
   private static final String field14171 = "Новый ботПрокси";
   private static final String field14172 = "Приоритет лута";
   private static final String field14173 = "Роль";
   private static final float field14174 = 6.5F;
   private static final float field14175 = 4.0F;
   private static final float field14176 = 181.25F;
   private static final float field14177 = 181.25F;
   private static final float field14178 = 125.0F;
   private static final float field14179 = 362.5F;
   private static final float field14180 = 250.0F;
   private static final float field14181 = 83.5F;
   private static final float field14182 = 35.25F;
   private static final float field14183 = 83.5F;
   private static final float field14184 = 279.0F;
   private static final float field14185 = 25.142857F;
   private static final float field14186 = 0.825F;
   private static final float field14187 = 362.5F;
   private static final float field14188 = 250.0F;
   private static final float field14189 = 8.0F;
   private static final float field14190 = 35.0F;
   private static final float field14191 = 362.5F;
   private static final float field14192 = 250.0F;
   private static final float field14193 = 8.0F;
   private static final float field14194 = 362.5F;
   private static final float field14195 = 250.0F;
   private static final float field14196 = 8.0F;
   private static final float field14197 = 15.0F;
   private static final float field14198 = 0.6F;
   private static final float field14199 = 0.05F;
   private static final float field14200 = 83.5F;
   private static final float field14201 = 1.5F;
   private static final float field14202 = 0.75F;
   private static final float field14203 = 247.0F;
   private static final float field14204 = 83.5F;
   private static final float field14205 = 0.75F;
   private static final float field14206 = 25.142857F;
   private static final float field14207 = 276.75F;
   private static final String field14208 = "Боты";
   private static final float field14209 = 9.0F;
   private static final float field14210 = 10.0F;
   private static final float field14211 = 9.0F;
   private static final float field14212 = 9.0F;
   private static final float field14213 = 22.0F;
   private static final float field14214 = 5.5F;
   private static final float field14215 = 9.0F;
   private static final float field14216 = 65.5F;
   private static final float field14217 = 250.0F;
   private static final float field14218 = 9.0F;
   private static final float field14219 = 17.0F;
   private static final float field14220 = 2.75F;
   private static final float field14221 = 17.0F;
   private static final float field14222 = 38.0F;
   private static final float field14223 = 2.75F;
   private static final String field14224 = "+ добавить";
   private static final String field14225 = "Настройки";
   private static final float field14226 = 19.75F;
   private static final float field14227 = 83.5F;
   private static final float field14228 = 17.0F;
   private static final float field14229 = 19.75F;
   private static final String field14230 = "ботов нет";
   private static final String field14231 = "ничего не найдено";
   private static final float field14232 = 3.0F;
   private static final float field14233 = 5.5F;
   private static final float field14234 = 17.0F;
   private static final float field14235 = 8.0F;
   private static final float field14236 = 8.5F;
   private static final float field14237 = 7.0F;
   private static final float field14238 = 6.5F;
   private static final float field14239 = 19.0F;
   private static final float field14240 = 15.0F;
   private static final float field14241 = 6.5F;
   private static final float field14242 = 17.0F;
   private static final float field14243 = 8.0F;
   private static final float field14244 = 6.5F;
   private static final float field14245 = 17.0F;
   private static final float field14246 = 17.0F;
   private static final float field14247 = 8.5F;
   private static final float field14248 = 6.5F;
   private static final float field14249 = 0.5F;
   private static final float field14250 = 12.571428F;
   private static final float field14251 = 83.5F;
   private static final float field14252 = 5.0F;
   private static final float field14253 = 7.25F;
   private static final float field14254 = 70.0F;
   private static final float field14255 = 14.5F;
   private static final String field14256 = "F";
   private static final float field14257 = 6.5F;
   private static final float field14258 = 0.2F;
   private static final String field14259 = "F";
   private static final float field14260 = 70.0F;
   private static final float field14261 = 5.0F;
   private static final float field14262 = 6.5F;
   private static final float field14263 = 0.5F;
   private static final float field14264 = 6.5F;
   private static final float field14265 = 0.2F;
   private static final float field14266 = 70.0F;
   private static final float field14267 = 6.0F;
   private static final float field14268 = 14.5F;
   private static final String field14269 = "Назад";
   private static final float field14270 = 6.5F;
   private static final float field14271 = 14.0F;
   private static final float field14272 = 362.5F;
   private static final float field14273 = 10.0F;
   private static final float field14274 = 7.5F;
   private static final String field14275 = "Назад";
   private static final float field14276 = 15.0F;
   private static final float field14277 = 15.0F;
   private static final String field14278 = "Назад";
   private static final float field14279 = 15.0F;
   private static final float field14280 = 3.0F;
   private static final float field14281 = 96.0F;
   private static final float field14282 = 96.0F;
   private static final float field14283 = 15.0F;
   private static final float field14284 = 6.5F;
   private static final float field14285 = 83.5F;
   private static final float field14286 = 8.5F;
   private static final float field14287 = 120.57143F;
   private static final float field14288 = 8.5F;
   private static final float field14289 = 25.142857F;
   private static final float field14290 = 6.0F;
   private static final float field14291 = 250.0F;
   private static final float field14292 = 6.0F;
   private static final float field14293 = 83.5F;
   private static final float field14294 = 278.0F;
   private static final float field14295 = 6.0F;
   private static final String field14296 = "Выбери бота в списке слева";
   private static final float field14297 = 6.5F;
   private static final float field14298 = 14.5F;
   private static final String field14299 = "Состояние";
   private static final float field14300 = 14.5F;
   private static final float field14301 = 6.5F;
   private static final float field14302 = 6.5F;
   private static final float field14303 = 110.57143F;
   private static final float field14304 = 4.0F;
   private static final float field14305 = 110.57143F;
   private static final String field14306 = "Причина";
   private static final float field14307 = 6.5F;
   private static final float field14308 = 4.0F;
   private static final String field14309 = "Причина";
   private static final float field14310 = 6.5F;
   private static final String field14311 = "Прокси";
   private static final String field14312 = "Здоровье";
   private static final float field14313 = 120.57143F;
   private static final float field14314 = 5.0F;
   private static final float field14315 = 46.0F;
   private static final float field14316 = 7.25F;
   private static final float field14317 = 1.75F;
   private static final float field14318 = 20.0F;
   private static final String field14319 = "Аптайм";
   private static final String field14320 = "—";
   private static final String field14321 = "Пинг";
   private static final String field14322 = "—";
   private static final String field14323 = "Версия";
   private static final String field14324 = "Анархия";
   private static final String field14325 = "Анархия";
   private static final String field14326 = "Сундук";
   private static final String field14327 = "Сундук";
   private static final String field14328 = "Роль";
   private static final String field14329 = "Скупка";
   private static final float field14330 = 6.5F;
   private static final float field14331 = 110.57143F;
   private static final String field14332 = "Скупка";
   private static final float field14333 = 6.5F;
   private static final float field14334 = 4.0F;
   private static final float field14335 = 14.5F;
   private static final float field14336 = 6.0F;
   private static final String field14337 = "Сервер";
   private static final String field14338 = "Сервер";
   private static final String field14339 = "Сервер";
   private static final float field14340 = 120.57143F;
   private static final float field14341 = 5.0F;
   private static final String field14342 = "—";
   private static final float field14343 = 6.5F;
   private static final float field14344 = 14.5F;
   private static final double field14345 = 0.2F;
   private static final float field14346 = 0.25F;
   private static final float field14347 = 1.75F;
   private static final float field14348 = 46.0F;
   private static final float field14349 = 3.5F;
   private static final float field14350 = 46.0F;
   private static final float field14351 = 0.5F;
   private static final float field14352 = 3.5F;
   private static final String field14353 = "Инвентарь";
   private static final float field14354 = 10.952381F;
   private static final float field14355 = 4.0F;
   private static final float field14356 = 6.0F;
   private static final float field14357 = 10.0F;
   private static final float field14358 = 0.55F;
   private static final float field14359 = 0.45F;
   private static final float field14360 = 5.0F;
   private static final float field14361 = 5.0F;
   private static final float field14362 = 16.0F;
   private static final float field14363 = 1.5F;
   private static final float field14364 = 1.5F;
   private static final float field14365 = 1.5F;
   private static final float field14366 = 0.5F;
   private static final float field14367 = 0.5F;
   private static final float field14368 = 10.0F;
   private static final float field14369 = 6.0F;
   private static final String field14370 = "Действия";
   private static final float field14371 = 58.0F;
   private static final String field14372 = "Подключён";
   private static final String field14373 = "Подключён";
   private static final String field14374 = "За мной";
   private static final String field14375 = "За мной";
   private static final String field14376 = "Сессия";
   private static final String field14377 = "Вернуться";
   private static final String field14378 = "Зайти";
   private static final String field14379 = "Удалить бота";
   private static final String field14380 = "X";
   private static final float field14381 = 58.0F;
   private static final float field14382 = 6.0F;
   private static final String field14383 = "Чат";
   private static final float field14384 = 57.0F;
   private static final float field14385 = 5.0F;
   private static final float field14386 = 110.57143F;
   private static final float field14387 = 5.0F;
   private static final float field14388 = 12.5F;
   private static final float field14389 = 12.5F;
   private static final float field14390 = 12.5F;
   private static final String field14391 = "От всех ботов";
   private static final String field14392 = "От всех ботов";
   private static final String field14393 = "Отправить";
   private static final float field14394 = 14.5F;
   private static final float field14395 = 5.0F;
   private static final float field14396 = 6.0F;
   private static final String field14397 = "Новый бот";
   private static final float field14398 = 5.5F;
   private static final float field14399 = 83.0F;
   private static final float field14400 = 5.0F;
   private static final String field14401 = "Ник";
   private static final String field14402 = "Ник";
   private static final String field14403 = "Адрес";
   private static final String field14404 = "Адрес";
   private static final String field14405 = "Количество";
   private static final String field14406 = "Прокси";
   private static final float field14407 = 19.5F;
   private static final String field14408 = "Создать";
   private static final float field14409 = 20.0F;
   private static final String field14410 = "Если ботов больше одного, к нику добавится номер";
   private static final float field14411 = 5.5F;
   private static final float field14412 = 110.57143F;
   private static final float field14413 = 5.0F;
   private static final float field14414 = 5.5F;
   private static final float field14415 = 6.0F;
   private static final String field14416 = "Подключение";
   private static final float field14417 = 79.0F;
   private static final String field14418 = "Задержка входа";
   private static final double field14419 = 100.0;
   private static final double field14420 = 3000.0;
   private static final double field14421 = 50.0;
   private static final String field14422 = "Прогрузка чанков";
   private static final double field14423 = 2.0;
   private static final double field14424 = 8.0;
   private static final String field14425 = "Автопереподключение";
   private static final String field14426 = "Автопереподключение";
   private static final String field14427 = "Авто-респавн";
   private static final String field14428 = "Авто-респавн";
   private static final float field14429 = 79.0F;
   private static final float field14430 = 6.0F;
   private static final String field14431 = "Авто варден";
   private static final float field14432 = 68.5F;
   private static final String field14433 = "Использовать скорость";
   private static final String field14434 = "Использовать скорость";
   private static final String field14435 = "Репортить обидчиков";
   private static final String field14436 = "Репортить обидчиков";
   private static final String field14437 = "Приоритет лута";
   private static final String field14438 = "Лута до ухода";
   private static final double field14439 = 16.0;
   private static final float field14440 = 68.5F;
   private static final float field14441 = 6.0F;
   private static final String field14442 = "Скупка ботами";
   private static final float field14443 = 50.0F;
   private static final String field14444 = "Одновременно скупают";
   private static final double field14445 = 8.0;
   private static final String field14446 = "Смена скупщиков";
   private static final double field14447 = 60.0;
   private static final double field14448 = 5.0;
   private static final float field14449 = 50.0F;
   private static final float field14450 = 6.0F;
   private static final String field14451 = "Отладка";
   private static final float field14452 = 29.0F;
   private static final String field14453 = "Отладка фарма";
   private static final String field14454 = "Отладка фарма";
   private static final String field14455 = "Аудит движения";
   private static final String field14456 = "Аудит движения";
   private static final float field14457 = 29.0F;
   private static final float field14458 = 6.0F;
   private static final String field14459 = "Все боты";
   private static final float field14460 = 29.0F;
   private static final String field14461 = "Запустить всех";
   private static final String field14462 = "Старт";
   private static final String field14463 = "Остановить всех";
   private static final String field14464 = "Стоп";
   private static final float field14465 = 29.0F;
   private static final float field14466 = 6.0F;
   private static final String field14467 = "Прокси";
   private static final float field14468 = 14.5F;
   private static final float field14469 = 5.0F;
   private static final float field14470 = 15.0F;
   private static final float field14471 = 5.0F;
   private static final String field14472 = "прокси нет";
   private static final float field14473 = 84.07143F;
   private static final float field14474 = 6.5F;
   private static final String field14475 = "X";
   private static final String field14476 = "Имя";
   private static final String field14477 = "Имя";
   private static final String field14478 = "Адрес";
   private static final String field14479 = "Адрес";
   private static final String field14480 = "Тип";
   private static final String field14481 = "Логин";
   private static final String field14482 = "Логин";
   private static final String field14483 = "Пароль";
   private static final String field14484 = "Пароль";
   private static final float field14485 = 19.5F;
   private static final String field14486 = "Добавить";
   private static final float field14487 = 6.0F;
   private static final float field14488 = 6.5F;
   private static final float field14489 = 5.0F;
   private static final float field14490 = 3.0F;
   private static final float field14491 = 6.0F;
   private static final float field14492 = 5.0F;
   private static final float field14493 = 6.0F;
   private static final float field14494 = 3.0F;
   private static final float field14495 = 6.5F;
   private static final float field14496 = 6.5F;
   private static final float field14497 = 1.25F;
   private static final float field14498 = 120.57143F;
   private static final float field14499 = 5.0F;
   private static final float field14500 = 110.57143F;
   private static final float field14501 = 15.0F;
   private static final float field14502 = 120.57143F;
   private static final float field14503 = 15.0F;
   private static final float field14504 = 14.5F;
   private static final float field14505 = 14.5F;
   private static final float field14506 = 120.57143F;
   private static final float field14507 = 120.57143F;
   private static final float field14508 = 120.57143F;
   private static final float field14509 = 120.57143F;
   private static final float field14510 = 0.45F;
   private static final float field14511 = 120.57143F;
   private static final float field14512 = 5.0F;
   private static final float field14513 = 10.5F;
   private static final float field14514 = 10.5F;
   private static final float field14515 = 0.6F;
   private static final float field14516 = 6.5F;
   private static final float field14517 = 10.5F;
   private static final float field14518 = 6.5F;
   private static final float field14519 = 120.57143F;
   private static final float field14520 = 120.57143F;
   private static final float field14521 = 10.5F;
   private static final float field14522 = 25.0F;
   private static final float field14523 = 25.0F;
   private static final long field14524 = 1000L;
   private static final long field14525 = 3600L;
   private static final long field14526 = 3600L;
   private static final long field14527 = 60L;
   private static final long field14528 = 60L;
   private static final String field14529 = "%d:%02d:%02d";
   private static final String field14530 = "%d:%02d";
   private static final String field14531 = "как у клиента";
   private static final String field14532 = "Без прокси";
   private static final String field14533 = "Без прокси";
   private static final double field14534 = 0.2F;
   private static final float field14535 = 0.999F;
   private static final float field14536 = 83.5F;
   private static final String field14537 = "без смен";
   private static final String field14538 = "все";
   private static final String field14539 = "Афк";
   private static final String field14540 = "Варден";
   private static final String field14541 = "Скупка";
   private static final String field14542 = "Низкий";
   private static final String field14543 = "Средний";
   private static final String field14544 = "Высокий";

   private void method06292(GuiGraphicsExtractor var1, String var2, boolean var3, boolean var4, float var5, float var6, float var7, Runnable var8) {
      GuiInputRenderer.method08827(this.field14115, var5, field14509, var6);
      float var9 = method06399(this.field14105, var2, var3);
      ToggleSwitchRenderer.method03323(var1, this.field14115, var9, var4 ? var7 : var7 * field14510);
      if (var4) {
         this.method06310(this.field14115.method02809(), this.field14115.method02808(), this.field14115.method02804(), this.field14115.method02802(), var8);
      }
   }

   private void method06293(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      float var5 = this.field14140 + field14285 + field14286;
      float var6 = var5 + field14287 + field14288;
      float var7 = this.field14141 + field14289 + field14290;
      float var8 = this.field14141 + field14291 - field14292 - var7;
      this.field14113.method02801(this.field14140 + field14293 + 1.0F);
      this.field14113.method02806(var7);
      this.field14113.method02803(field14294);
      this.field14113.method02798(var8);
      this.field14112.method01152(this.field14144 > var8);
      this.field14112.method01145();
      this.field14112.method01134(this.field14144, var8);
      float var9 = var7 + this.field14112.method01136();
      this.field14109 = this.field14107;
      var1.enableScissor(
         (int)this.field14113.method02809(),
         (int)var7,
         (int)Math.ceil(this.field14113.method02809() + this.field14113.method02804()),
         (int)Math.ceil(var7 + var8)
      );

      float var10 = switch (this.field14153) {
         case BOT -> this.method06332(var1, var5, var6, var9, var2, var3, var4);
         case CREATE -> this.method06305(var1, var5, var9, var2, var3, var4);
         case SETTINGS -> this.method06379(var1, var5, var6, var9, var2, var3, var4);
      };
      var1.disableScissor();
      this.field14109 = this.field14106;
      this.field14144 = var10 - var9 - field14295;
   }

   @Override
   protected void method01472(GuiGraphicsExtractor var1, int var2, int var3, float var4) {
      float var5 = this.method01470();
      Vec2 var6 = GuiScaleUtils.method06746(var2, var3);
      this.method06372();
      this.method06390();
      this.method06397(var6.x, var6.y);
      this.field14106.method03440();
      this.field14107.method03440();
      this.field14108.method03440();
      this.field14109 = this.field14106;
      this.method01467(var1, this.field14140 + field14176, this.field14141);
      this.method06318(var1, var5);
      this.method06368(var1, var6.x, var6.y, var5);
      this.method06371(var1, var6.x, var6.y, var5);
      this.method06293(var1, var6.x, var6.y, var5);
      if (this.field14150 != null) {
         this.field14150.method06422(var1, var6.x, var6.y, var5);
      }

      var1.pose().popMatrix();
   }

   private static int method06294(String var0) {
      var var1 = ProxyManager.INSTANCE.method05237();

      for (int var2 = 0; var2 < var1.size(); var2++) {
         if (((ProxyConfig)var1.get(var2)).method03913().equals(var0)) {
            return var2 + 1;
         }
      }

      return 0;
   }

   public BotManagerScreen() {
      this.field14116 = method06377(field14158);
      this.field14117 = method06377(field14159);
      this.field14118 = method06377(field14160);
      this.field14119 = method06377(field14161);
      this.field14120 = method06377(field14162);
      this.field14121 = method06377(field14163);
      this.field14122 = method06377(field14164);
      this.field14123 = method06377(field14165);
      this.field14124 = method06377(field14166);
      this.field14125 = method06321(String.valueOf(RandomIdUtils.method04150()));
      this.field14126 = method06321(field14167);
      this.field14127 = List.of(
         this.field14116,
         this.field14117,
         this.field14118,
         this.field14119,
         this.field14120,
         this.field14121,
         this.field14122,
         this.field14123,
         this.field14124,
         this.field14125,
         this.field14126
      );
      this.field14128 = List.of(this.field14125, this.field14126);
      this.field14129 = List.of(this.field14121, this.field14122, this.field14123, this.field14124);
      this.field14130 = new BotManagerScreen.Nested184(field14168);
      this.field14131 = new BotManagerScreen.Nested184(field14169);
      this.field14132 = new BotManagerScreen.Nested184(field14170);
      this.field14133 = new BotManagerScreen.Nested184(field14171);
      this.field14134 = new BotManagerScreen.Nested184(field14172);
      this.field14135 = new BotManagerScreen.Nested184(field14173);
      this.field14136 = new TooltipRenderer(field14060, 0);
      this.field14137 = method06300();
      this.field14138 = method06308();
      this.field14139 = List.of();
      this.field14153 = BotManagerScreen.Nested185.BOT;
      this.field14154 = 1;
      this.field14155 = "";
      this.field14156 = ProxyConfig.Nested114.SOCKS5;
      this.field14117.method06689(this::method06378);
      this.field14117.method06669(256);
      this.field14118.method06689(this::method06299);
      this.field14118.method06705(this::method06396);
      this.field14119.method06689(this::method06349);
      this.field14120.method06689(this::method06349);
      this.field14129.forEach(var1 -> var1.method06689(this::method06405));
      this.field14125.method06689(this::method06385);
      this.field14126.method06689(this::method06393);
   }

   private void method06297(GuiGraphicsExtractor var1, BotClient var2, float var3, float var4, float var5, float var6, float var7, float var8) {
      float var9 = Math.max(var4, this.field14142);
      float var10 = Math.min(var4 + field14234, this.field14143) - var9;
      boolean var11 = GuiHitTestUtils.method05625(var6, var7, var3, var9, var5, var10);
      float var12 = this.method06313(var2, var11);
      float var13 = method06399(this.field14104, var2, this.field14152 == var2 && this.field14153 == BotManagerScreen.Nested185.BOT);
      this.method06361(var1, var3, var4, var5, var13, var12, var8);
      method06330(var2.method00146())
         .method01190(var1, var3 + field14235, var4 + field14236, field14237, GuiThemeStyle.method01443(method06380(var2.method00146()), var8));
      String var14 = GuiThemeStyle.method01438(GuiThemeStyle.field03543, var2.method00137().method00491(), field14238, var5 - field14239);
      GuiThemeStyle.field03543.method09480(var1, var14, var3 + field14240, method06395(var4), method06304(var13, var8), field14241);
      this.method06310(var3, var9, var5, var10, () -> this.method06403(var2));
   }

   private void method06299() {
      String var1 = this.field14118.method06672();
      BotClient var2 = this.field14149;
      if (var2 != null && !var1.isEmpty()) {
         method06404(() -> var2.method00137().method00477(BotManager.method03087(var1)));
      }

      this.method06396();
   }

   private static List<String> method06300() {
      var var0 = new ArrayList(AutoBuyBotRole.values().length);

      for (AutoBuyBotRole var4 : AutoBuyBotRole.values()) {
         var0.add(var4.method04642());
      }

      return List.copyOf(var0);
   }

   private static String method06302(long var0) {
      long var2 = var0 / field14524;
      long var4 = var2 / field14525;
      long var6 = var2 % field14526 / field14527;
      long var8 = var2 % field14528;
      return var4 > 0L ? String.format(field14529, var4, var6, var8) : String.format(field14530, var6, var8);
   }

   private static int method06304(float var0, float var1) {
      return GuiThemeStyle.method01440(
         GuiThemeStyle.method01445(var1), GuiThemeStyle.method01443(GuiThemeStyle.method01441().method09800(), var1), var0
      );
   }

   private float method06305(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = this.method06402(var1, field14397, GuiIcon.PLUS, var2, var3, var6);
      float var8 = GuiThemeStyle.field03545.method09485(field14398);
      float var9 = field14399 + var8 + field14400;
      this.method06359(var1, var2, var7, var9, var6);
      float var10 = var7;
      this.method06320(var1, field14401, var2, var10, var6);
      this.method06386(var1, this.field14119, field14402, var2, var10, var4, var6);
      var10 = this.method06341(var1, var2, var10, var6);
      this.method06320(var1, field14403, var2, var10, var6);
      this.method06386(var1, this.field14120, field14404, var2, var10, var4, var6);
      var10 = this.method06341(var1, var2, var10, var6);
      this.method06320(var1, field14405, var2, var10, var6);
      this.field14132
         .method06421(
            var1, String.valueOf(this.field14154), this.field14138, this.field14154 - 1, var1x -> this.field14154 = var1x + 1, var2, var10, var4, var5, var6
         );
      var10 = this.method06341(var1, var2, var10, var6);
      this.method06320(var1, field14406, var2, var10, var6);
      this.field14133
         .method06421(
            var1,
            method06360(this.field14155),
            method06338(),
            method06294(this.field14155),
            var1x -> this.field14155 = method06323(var1x),
            var2,
            var10,
            var4,
            var5,
            var6
         );
      var10 += field14407;
      boolean var11 = !this.field14119.method06685() && !this.field14120.method06685();
      this.method06325(var1, field14408, var11, var2, var10, var4, var5, var6, this::method06349);
      var10 += field14409;
      String var12 = GuiThemeStyle.method01438(GuiThemeStyle.field03545, field14410, field14411, field14412);
      GuiThemeStyle.field03545.method09480(var1, var12, var2 + field14413, var10, GuiThemeStyle.method01445(var6), field14414);
      return var7 + var9 + field14415;
   }

   private static List<String> method06308() {
      var var0 = new ArrayList(32);

      for (int var1 = 1; var1 <= 32; var1++) {
         var0.add(String.valueOf(var1));
      }

      return List.copyOf(var0);
   }

   private float method06309(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = this.method06402(var1, field14383, GuiIcon.COPY, var2, var3, var6);
      float var8 = field14384;
      this.method06359(var1, var2, var7, var8, var6);
      float var9 = var2 + field14385;
      float var10 = field14386;
      float var11 = var7 + field14387;
      this.method06343(var1, this.field14117, var9, var11, var10, field14388, var6);
      this.field14117.method06700(var9, var11, var10, field14389).method06670(var1, var4, var6);
      float var12 = var11 + field14390;
      this.method06320(var1, field14391, var2, var12, var6);
      this.method06292(var1, field14392, this.field14157, true, var2, var12, var6, () -> this.field14157 = !this.field14157);
      boolean var13 = !this.field14117.method06685() && (this.field14157 || this.field14152 != null);
      this.method06325(var1, field14393, var13, var2, var12 + field14394 + field14395, var4, var5, var6, this::method06378);
      return var7 + var8 + field14396;
   }

   private void method06310(float var1, float var2, float var3, float var4, Runnable var5) {
      this.field14109.method03442(var1, var2, var3, var4, var5);
   }

   @Override
   public boolean method01471() {
      return this.method06407() != null;
   }

   private float method06313(Object var1, boolean var2) {
      return method06399(this.field14103, var1, var2);
   }

   private void method06317() {
      if (this.field14152 != null) {
         BotManager.INSTANCE.method03072(this.field14152);
         this.field14152 = null;
      }
   }

   private void method06318(GuiGraphicsExtractor var1, float var2) {
      int var3 = GuiThemeStyle.method01443(GuiThemeStyle.method01441().field22119.method11676(), field14186 * var2);
      GuiClipStack.method00341(var1, this.field14140, this.field14141, field14187, field14188, field14189, 1.0F, field14190, var2);
      RoundedRectRenderer.method01272(var1, this.field14140, this.field14141, field14191, field14192, field14193, 1.0F, var3);
      GuiShadowRenderer.method10984(
         var1, this.field14140, this.field14141, field14194, field14195, field14196, 1.0F, field14197, GuiThemeStyle.method01443(var3, field14198)
      );
      int var4 = GuiThemeStyle.method01442(field14199 * var2);
      RoundedRectRenderer.method01272(var1, this.field14140 + field14200, this.field14141 + field14201, field14202, field14203, 0.0F, 0.0F, var4);
      RoundedRectRenderer.method01272(var1, this.field14140 + field14204 + field14205, this.field14141 + field14206, field14207, 1.0F, 0.0F, 0.0F, var4);
   }

   private void method06319(BotManagerScreen.Nested185 var1) {
      if (this.field14153 != var1) {
         this.field14153 = var1;
         this.field14150 = null;
         this.field14151 = null;
         this.method06396();
         this.field14112.method01144();
         if (var1 == BotManagerScreen.Nested185.CREATE) {
            this.field14119.method06692();
            this.field14120.method06675(BotManager.INSTANCE.method03086());
            this.field14119.method06716();
         }
      }
   }

   private void method06320(GuiGraphicsExtractor var1, String var2, float var3, float var4, float var5) {
      GuiInputRenderer.method08823(var1, var2, var3, var4, var5);
   }

   private static TextInputWidget method06321(String var0) {
      TextInputWidget var1 = method06377(var0);
      var1.method06669(3);
      return var1;
   }

   private static String method06323(int var0) {
      var var1 = ProxyManager.INSTANCE.method05237();
      return var0 > 0 && var0 <= var1.size() ? ((ProxyConfig)var1.get(var0 - 1)).method03913() : "";
   }

   private static void method06324(TextInputWidget var0, String var1) {
      if (!var0.method06726() && !var0.method06672().equals(var1)) {
         var0.method06675(var1);
      }
   }

   private void method06325(GuiGraphicsExtractor var1, String var2, boolean var3, float var4, float var5, float var6, float var7, float var8, Runnable var9) {
      float var10 = var4 + field14499;
      float var11 = field14500;
      float var12 = this.method06313(var2, var3 && GuiHitTestUtils.method05625(var6, var7, var10, var5, var11, field14501));
      GuiInputRenderer.method08822(var1, var2, var3, var4, field14502, var5, var12, var8);
      if (var3) {
         this.method06310(var10, var5, var11, field14503, var9);
      }
   }

   private float method06328(
      GuiGraphicsExtractor var1,
      String var2,
      double var3,
      double var5,
      double var7,
      double var9,
      DoubleFunction<String> var11,
      DoubleConsumer var12,
      float var13,
      float var14,
      float var15,
      float var16
   ) {
      double var17 = GuiListRenderer.method11179(
         var1, var2, var3, var5, var7, var9, var2.equals(this.field14151), var15, var11, var13, field14519, var14, var16
      );
      if (var17 != var9) {
         var12.accept(var17);
      }

      this.method06310(
         GuiListRenderer.method11181(var13),
         GuiListRenderer.method11182(var14),
         GuiListRenderer.method11180(field14520),
         field14521,
         () -> this.field14151 = var2
      );
      this.method06381(var1, var13, var14 + field14522, var16);
      return var14 + field14523;
   }

   private static GuiIcon method06330(BotConnectionState var0) {
      if (var0 == BotConnectionState.FAILED) {
         return GuiIcon.ALERT;
      } else if (var0.method05278()) {
         return GuiIcon.PLAY;
      } else {
         return var0.method05280() ? GuiIcon.RELOAD : GuiIcon.CHECK;
      }
   }

   private static int method06331(String var0) {
      for (int var1 = 0; var1 < field14101.length; var1++) {
         if (field14101[var1].equals(var0)) {
            return var1;
         }
      }

      return 1;
   }

   private float method06332(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      if (this.field14152 == null) {
         GuiThemeStyle.field03545.method09480(var1, field14296, var2, var4 + 2.0F, GuiThemeStyle.method01445(var7), field14297);
         return var4 + field14298;
      } else {
         BotClient var8 = this.field14152;
         float var9 = this.method06398(var1, var8, var2, this.method06344(var1, var8, var2, var4, var5, var6, var7), var7);
         float var10 = this.method06309(var1, var3, this.method06342(var1, var8, var3, var4, var5, var6, var7), var5, var6, var7);
         return Math.max(var9, var10);
      }
   }

   private float method06334(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      WardenBotSettings var5 = WardenBotSettings.INSTANCE;
      float var6 = this.method06402(var1, field14451, GuiIcon.GEAR, var2, var3, var4);
      this.method06359(var1, var2, var6, field14452, var4);
      float var7 = var6;
      this.method06320(var1, field14453, var2, var7, var4);
      this.method06292(var1, field14454, var5.method09330(), true, var2, var7, var4, () -> var5.method09324(!var5.method09330()));
      var7 = this.method06341(var1, var2, var7, var4);
      this.method06320(var1, field14455, var2, var7, var4);
      this.method06292(var1, field14456, false, true, var2, var7, var4, () -> {
         if (true) {
            boolean var10000 = true;
         } else {
            boolean var0 = false;
         }
      });
      return var6 + field14457 + field14458;
   }

   private void method06335(GuiGraphicsExtractor var1, String var2, float var3, float var4, int var5) {
      GuiInputRenderer.method08826(var1, var2, var3, field14507, var4, var5);
   }

   @Override
   public boolean method01477(double var1, double var3, int var5, boolean var6) {
      Vec2 var7 = GuiScaleUtils.method06746(var1, var3);
      double var8 = var7.x;
      double var10 = var7.y;
      TextInputWidget var12 = this.method06407();
      boolean var13 = this.field14113.method02799(var8, var10);
      boolean var14 = false;

      for (TextInputWidget var16 : this.field14127) {
         if (this.field14150 != null || var16 != this.field14116 && !var13) {
            if (var5 == 0) {
               var16.method06722();
            }
         } else {
            var14 |= var16.method06703(var8, var10, var5);
         }
      }

      if (this.field14149 != null && !this.field14118.method06726()) {
         this.method06396();
      }

      this.method06408(var12);
      if (var14 || var5 != 0 || this.method01470() < field14535) {
         return true;
      }

      if (this.field14150 != null) {
         if (!this.field14108.method03441(var8, var10)) {
            this.field14150 = null;
         }

         return true;
      } else {
         if (this.field14153 == BotManagerScreen.Nested185.BOT && this.field14152 != null && this.field14136.method02645(var8, var10)) {
            this.method06392(var8);
            return true;
         }

         if (this.field14106.method03441(var8, var10)) {
            return true;
         }

         if (this.field14113.method02799(var8, var10) && this.field14107.method03441(var8, var10)) {
            return true;
         }

         if (this.method06337(var8, var10)) {
            this.field14146 = true;
            this.field14147 = (float)var8 - this.field14140;
            this.field14148 = (float)var10 - this.field14141;
         }

         return true;
      }
   }

   private boolean method06337(double var1, double var3) {
      boolean var5 = GuiHitTestUtils.method05609(var1, var3, this.field14140, this.field14141, field14181, field14182);
      boolean var6 = GuiHitTestUtils.method05609(var1, var3, this.field14140 + field14183, this.field14141, field14184, field14185);
      return var5 || var6;
   }

   private static List<String> method06338() {
      var var0 = ProxyManager.INSTANCE.method05237();
      var var1 = new ArrayList(var0.size() + 1);
      var1.add(field14533);

      for (ProxyConfig var3 : var0) {
         var1.add(var3.method03914());
      }

      return var1;
   }

   private void method06340(
      GuiGraphicsExtractor var1, String var2, boolean var3, float var4, float var5, float var6, float var7, float var8, float var9, Runnable var10
   ) {
      float var11 = this.method06313(var2, GuiHitTestUtils.method05625(var7, var8, var4, var5, var6, field14242));
      float var12 = method06399(this.field14105, var2, var3);
      this.method06361(var1, var4, var5, var6, var12, var11, var9);
      GuiThemeStyle.field03543.method09480(var1, var2, var4 + field14243, method06395(var5), method06304(var12, var9), field14244);
      this.method06310(var4, var5, var6, field14245, var10);
   }

   private float method06341(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      this.method06381(var1, var2, var3 + field14504, var4);
      return var3 + field14505;
   }

   private float method06342(GuiGraphicsExtractor var1, BotClient var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = this.method06402(var1, field14370, GuiIcon.PLAY, var3, var4, var7);
      this.method06359(var1, var3, var8, field14371, var7);
      BotSessionManager var9 = BotSessionManager.INSTANCE;
      BotConnectionState var10 = var2.method00146();
      boolean var11 = var9.method08762() == var2;
      boolean var12 = var10.method05278() || var10.method05280();
      float var13 = var8;
      this.method06320(var1, field14372, var3, var13, var7);
      this.method06292(var1, field14373, var12, !var11, var3, var13, var7, var12 ? var2::method00103 : var2::method00151);
      var13 = this.method06341(var1, var3, var13, var7);
      boolean var14 = BotFollowManager.INSTANCE.method02181();
      this.method06320(var1, field14374, var3, var13, var7);
      this.method06292(
         var1,
         field14375,
         var14,
         var10.method05278() || var14,
         var3,
         var13,
         var7,
         var14 ? BotFollowManager.INSTANCE::method02185 : () -> BotFollowManager.INSTANCE.method02183(var9.method08734())
      );
      var13 = this.method06341(var1, var3, var13, var7);
      this.method06320(var1, field14376, var3, var13, var7);
      boolean var15 = var11 || BotSessionTransfer.method02475(var2);
      this.method06364(
         var1,
         var11 ? field14377 : field14378,
         var15 ? GuiThemeStyle.Nested40.NORMAL : GuiThemeStyle.Nested40.DISABLED,
         var3,
         var13,
         var5,
         var6,
         var7,
         var11 ? var9::method08741 : () -> var9.method08739(var2)
      );
      var13 = this.method06341(var1, var3, var13, var7);
      this.method06320(var1, field14379, var3, var13, var7);
      this.method06364(var1, field14380, GuiThemeStyle.Nested40.DANGER, var3, var13, var5, var6, var7, this::method06317);
      return var8 + field14381 + field14382;
   }

   private void method06343(GuiGraphicsExtractor var1, TextInputWidget var2, float var3, float var4, float var5, float var6, float var7) {
      GuiInputRenderer.method08816(var1, var3, var4, var5, var6, this.method06313(var2, var2.method06726()), var7);
   }

   private float method06344(GuiGraphicsExtractor var1, BotClient var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = this.method06402(var1, field14299, GuiIcon.CHECK, var3, var4, var7);
      BotConnectionState var9 = var2.method00146();
      String var10 = var9 == BotConnectionState.FAILED ? var2.method00159() : "";
      boolean var11 = var10 != null && !var10.isEmpty();
      boolean var12 = ViaFabricPlusProtocolAccess.method11193();
      AutoBuyBotState var13 = var2.method00137();
      boolean var14 = var13.method00475() == AutoBuyBotStatus.WARDEN;
      boolean var15 = var13.method00475() == AutoBuyBotStatus.AUTOBUY;
      int var16 = 6 + (var11 ? 1 : 0) + (var12 ? 1 : 0) + (var14 ? 2 : 0) + (var15 ? 2 : 0);
      this.method06359(var1, var3, var8, field14300 * var16, var7);
      boolean var17 = var9.method05278();
      float var18 = var8;
      float var19 = GuiThemeStyle.field03544.method09486(var9.method05279(), field14301);
      this.method06320(
         var1,
         GuiThemeStyle.method01438(GuiThemeStyle.field03544, var13.method00491(), field14302, field14303 - var19 - field14304),
         var3,
         var18,
         var7
      );
      this.method06335(
         var1,
         var9.method05279(),
         var3,
         var18,
         var11 ? GuiThemeStyle.method01443(GuiThemeStyle.field03548, var7) : GuiThemeStyle.method01445(var7)
      );
      var18 = this.method06341(var1, var3, var18, var7);
      if (var11) {
         float var20 = field14305 - GuiThemeStyle.field03544.method09486(field14306, field14307) - field14308;
         this.method06320(var1, field14309, var3, var18, var7);
         this.method06335(
            var1,
            GuiThemeStyle.method01438(GuiThemeStyle.field03544, var10, field14310, var20),
            var3,
            var18,
            GuiThemeStyle.method01443(GuiThemeStyle.field03548, var7)
         );
         var18 = this.method06341(var1, var3, var18, var7);
      }

      this.method06351(var1, var2, var3, var18, var5, var7);
      var18 = this.method06341(var1, var3, var18, var7);
      this.method06320(var1, field14311, var3, var18, var7);
      this.field14131
         .method06421(
            var1,
            method06360(var13.method00490()),
            method06338(),
            method06294(var13.method00490()),
            var1x -> method06404(() -> var13.method00495(method06323(var1x))),
            var3,
            var18,
            var5,
            var6,
            var7
         );
      var18 = this.method06341(var1, var3, var18, var7);
      float var32 = var17 ? var2.method00070().method07951() : 0.0F;
      this.method06320(var1, field14312, var3, var18, var7);
      this.method06375(var1, var3 + field14313 - field14314 - field14315, var18 + field14316 - field14317, var32 / field14318, var7);
      var18 = this.method06341(var1, var3, var18, var7);
      this.method06320(var1, field14319, var3, var18, var7);
      this.method06347(var1, var17 ? method06302(var2.method00105()) : field14320, var3, var18, var7);
      var18 = this.method06341(var1, var3, var18, var7);
      this.method06320(var1, field14321, var3, var18, var7);
      this.method06347(var1, var17 ? var2.method00090().method07764() + " мс" : field14322, var3, var18, var7);
      if (var12) {
         var18 = this.method06341(var1, var3, var18, var7);
         this.method06320(var1, field14323, var3, var18, var7);
         String var21 = var13.method00492();
         String var22 = var21.isEmpty() ? "как у клиента · " + ViaFabricPlusProtocolAccess.method11192() : var21;
         int var23 = var21.isEmpty() ? 0 : ViaFabricPlusProtocolAccess.method11194().indexOf(var21) + 1;
         this.field14130.method06421(var1, var22, this.method06352(), var23, var2x -> this.method06406(var13, var2x), var3, var18, var5, var6, var7);
      }

      if (var14) {
         float var29 = this.method06341(var1, var3, var18, var7);
         this.method06320(var1, field14324, var3, var29, var7);
         method06324(this.field14125, String.valueOf(var13.method00487()));
         this.method06386(var1, this.field14125, field14325, var3, var29, var5, var7);
         var18 = this.method06341(var1, var3, var29, var7);
         this.method06320(var1, field14326, var3, var18, var7);
         int var33 = var13.method00482();
         method06324(this.field14126, var33 < 0 ? "" : String.valueOf(var33));
         this.method06386(var1, this.field14126, field14327, var3, var18, var5, var7);
      }

      if (var15) {
         var18 = this.method06341(var1, var3, var18, var7);
         this.method06320(var1, field14328, var3, var18, var7);
         AutoBuyBotRole var34 = var13.method00498();
         this.field14135
            .method06421(
               var1,
               var34.method04642(),
               this.field14137,
               var34.ordinal(),
               var1x -> method06404(() -> var13.method00480(AutoBuyBotRole.values()[var1x])),
               var3,
               var18,
               var5,
               var6,
               var7
            );
         var18 = this.method06341(var1, var3, var18, var7);
         this.method06320(var1, field14329, var3, var18, var7);
         String var35 = BotStatusManager.INSTANCE.method02732(var2);
         this.method06347(
            var1,
            GuiThemeStyle.method01438(
               GuiThemeStyle.field03544, var35, field14330, field14331 - GuiThemeStyle.field03544.method09486(field14332, field14333) - field14334
            ),
            var3,
            var18,
            var7
         );
      }

      return var8 + field14335 * var16 + field14336;
   }

   private void method06347(GuiGraphicsExtractor var1, String var2, float var3, float var4, float var5) {
      this.method06335(var1, var2, var3, var4, GuiThemeStyle.method01445(var5));
   }

   @Override
   public boolean method01464(int var1, int var2, int var3) {
      TextInputWidget var4 = this.method06407();
      if (var4 == null) {
         if (this.field14150 != null && var1 == 256) {
            this.field14150 = null;
            return true;
         } else {
            return false;
         }
      } else {
         return var4.method06733(var1) || var1 != 256;
      }
   }

   private void method06349() {
      String var1 = this.field14119.method06672();
      String var2 = this.field14120.method06672();
      if (!var1.isEmpty() && !var2.isEmpty()) {
         BotClient var3;
         if (this.field14154 > 1) {
            var var4 = BotManager.INSTANCE.method03071(var1, this.field14154, var2, this.field14155);
            var3 = var4.isEmpty() ? null : (BotClient)var4.getFirst();
         } else {
            var3 = BotManager.INSTANCE.method03067(var1, var2, this.field14155);
         }

         if (var3 != null) {
            this.field14119.method06692();
            this.method06403(var3);
         }
      }
   }

   private static List<String> method06350(String var0, List<String> var1) {
      var var2 = new ArrayList(var1.size() + 1);
      var2.add(var0);
      var2.addAll(var1);
      return List.copyOf(var2);
   }

   @Override
   public boolean method01476(char var1, int var2) {
      TextInputWidget var3 = this.method06407();
      if (var3 == null) {
         return false;
      } else {
         return this.field14128.contains(var3) && !Character.isDigit(var1) ? true : var3.method06730(var1);
      }
   }

   private void method06351(GuiGraphicsExtractor var1, BotClient var2, float var3, float var4, float var5, float var6) {
      this.method06320(var1, field14337, var3, var4, var6);
      if (this.field14149 == var2) {
         this.method06386(var1, this.field14118, field14338, var3, var4, var5, var6);
      } else {
         float var7 = method06382(field14339, var3);
         float var8 = var3 + field14340 - field14341 - var7;
         String var9 = var2.method00137().method00486();
         this.method06347(
            var1,
            GuiThemeStyle.method01438(GuiThemeStyle.field03544, var9 != null && !var9.isEmpty() ? var9 : field14342, field14343, var8),
            var3,
            var4,
            var6
         );
         this.method06310(var7, var4, var8, field14344, () -> this.method06353(var2));
      }
   }

   @Override
   public boolean method01463(double var1, double var3, double var5, double var7) {
      Vec2 var9 = GuiScaleUtils.method06746(var1, var3);
      if (this.field14150 != null && this.field14150.field14547.method02799(var9.x, var9.y)) {
         this.field14150.field14548.method01133(var7);
      } else if (GuiHitTestUtils.method05625(var9.x, var9.y, this.field14140, this.field14142, field14536, this.field14143 - this.field14142)) {
         this.field14111.method01133(var7);
      } else if (this.field14113.method02799(var9.x, var9.y)) {
         this.field14112.method01133(var7);
      }

      return true;
   }

   private List<String> method06352() {
      if (this.field14139.isEmpty()) {
         this.field14139 = method06350(field14531, ViaFabricPlusProtocolAccess.method11194());
      }

      return this.field14139;
   }

   private void method06353(BotClient var1) {
      this.field14149 = var1;
      this.field14118.method06675(var1.method00137().method00486());
      this.field14118.method06716();
   }

   private static void method06354(
      GuiGraphicsExtractor var0, String var1, GuiThemeStyle.Nested40 var2, float var3, float var4, float var5, float var6, float var7
   ) {
      int var8 = switch (var2) {
         case NORMAL -> GuiPanelRenderer.method00762(var6, var7);
         case DANGER -> GuiPanelRenderer.method00768(GuiThemeStyle.field03548, (1.0F + 1.0F * var6) * var7);
         case DISABLED -> GuiPanelRenderer.method00762(0.0F, var7);
      };

      int var9 = switch (var2) {
         case NORMAL -> GuiPanelRenderer.method00763(var6, var7);
         case DANGER -> GuiThemeStyle.method01443(GuiThemeStyle.field03548, var7);
         case DISABLED -> GuiThemeStyle.method01445(field14515 * var7);
      };
      String var10 = GuiThemeStyle.method01438(GuiThemeStyle.field03544, var1, field14516, var5);
      GuiPanelRenderer.method00760(var0, GuiThemeStyle.field03544, var3, var4, var5, field14517, var10, field14518, var8, var9);
   }

   private static float method06356(float var0) {
      return GuiInputRenderer.method08815(var0);
   }

   private void method06359(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5) {
      GuiPanelRenderer.method00765(var1, var2, var3, field14498, var4, 0.0F, var5);
   }

   private static String method06360(String var0) {
      ProxyConfig var1 = ProxyManager.INSTANCE.method05225(var0);
      return var1 == null ? field14532 : var1.method03914();
   }

   private void method06361(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      GuiPanelRenderer.method00765(var1, var2, var3, var4, field14246, Math.max(var6, var5), var7);
   }

   private float method06363(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5) {
      AutoBuySettings var6 = AutoBuySettings.field19624;
      float var7 = this.method06402(var1, field14442, GuiIcon.CART, var2, var3, var5);
      this.method06359(var1, var2, var7, field14443, var5);
      float var8 = this.method06328(
         var1,
         field14444,
         0.0,
         field14445,
         1.0,
         var6.method08548(),
         var0 -> var0 <= 0.0 ? field14538 : String.valueOf((int)var0),
         var1x -> method06400(() -> var6.method08572((int)var1x)),
         var2,
         var7,
         var4,
         var5
      );
      this.method06328(
         var1,
         field14446,
         0.0,
         field14447,
         field14448,
         var6.method08585(),
         var0 -> var0 <= 0.0 ? field14537 : (int)var0 + " мин",
         var1x -> method06400(() -> var6.method08575((int)var1x)),
         var2,
         var8,
         var4,
         var5
      );
      return var7 + field14449 + field14450;
   }

   @Override
   protected void method01474() {
      this.field14153 = BotManagerScreen.Nested185.BOT;
      this.field14116.method06702();
      this.method06396();
      this.field14150 = null;
      this.field14151 = null;
      this.field14111.method01144();
      this.field14112.method01144();
   }

   private void method06364(
      GuiGraphicsExtractor var1, String var2, GuiThemeStyle.Nested40 var3, float var4, float var5, float var6, float var7, float var8, Runnable var9
   ) {
      float var10 = GuiInputRenderer.method08819(var2);
      float var11 = var4 + field14511 - field14512 - var10;
      float var12 = GuiInputRenderer.method08814(var5);
      boolean var13 = var3 != GuiThemeStyle.Nested40.DISABLED;
      float var14 = this.method06313(var2, var13 && GuiHitTestUtils.method05625(var6, var7, var11, var12, var10, field14513));
      method06354(var1, var2, var3, var11, var12, var10, var14, var8);
      if (var13) {
         this.method06310(var11, var12, var10, field14514, var9);
      }
   }

   private void method06368(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      GuiThemeStyle.field03543
         .method09480(var1, field14208, this.field14140 + field14209, this.field14141 + field14210, GuiThemeStyle.method01437(var4), field14211);
      String var5 = BotManager.INSTANCE.method03078() + " в сети · " + BotManager.INSTANCE.method03092().size() + " всего";
      GuiThemeStyle.field03545
         .method09480(var1, var5, this.field14140 + field14212, this.field14141 + field14213, GuiThemeStyle.method01445(var4), field14214);
      float var6 = this.field14140 + field14215;
      float var7 = field14216;
      float var8 = this.field14141 + field14217 - field14218 - field14219;
      float var9 = var8 - field14220 - field14221;
      this.field14142 = this.field14141 + field14222;
      this.field14143 = var9 - field14223;
      this.method06374(var1, var6, var7, var2, var3, var4);
      this.method06340(
         var1,
         field14224,
         this.field14153 == BotManagerScreen.Nested185.CREATE,
         var6,
         var9,
         var7,
         var2,
         var3,
         var4,
         () -> this.method06319(BotManagerScreen.Nested185.CREATE)
      );
      this.method06340(
         var1,
         field14225,
         this.field14153 == BotManagerScreen.Nested185.SETTINGS,
         var6,
         var8,
         var7,
         var2,
         var3,
         var4,
         () -> this.method06319(BotManagerScreen.Nested185.SETTINGS)
      );
   }

   private void method06370(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      GuiBounds var5 = this.field14136.method02647();
      var5.method02801(var2 - field14281);
      var5.method02806(var3);
      var5.method02803(field14282);
      var5.method02798(field14283);
      this.field14136.method02646(var1, GuiThemeStyle.field03544, field14284, this.field14152.method00137().method00475().ordinal(), var4);
   }

   private void method06371(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      float var5 = this.field14141 + field14250;
      float var6 = this.field14140 + field14251 + field14252;
      float var7 = var5 - field14253;
      this.method06343(var1, this.field14116, var6, var7, field14254, field14255, var4);
      float var8 = Fonts.field00107.method09478(field14256, field14257, field14258);
      Fonts.field00107
         .method09490(
            var1,
            field14259,
            var6 + field14260 - field14261 - var8,
            var5 - Fonts.field00107.method09485(field14262) / 2.0F + field14263,
            GuiThemeStyle.method01445(var4),
            field14264,
            field14265
         );
      this.field14116.method06700(var6, var7, field14266 - var8 - field14267, field14268).method06670(var1, var2, var4);
      float var9 = GuiThemeStyle.field03544.method09486(field14269, field14270) + field14271;
      float var10 = this.field14140 + field14272 - field14273 - var9;
      float var11 = var5 - field14274;
      float var12 = this.method06313(field14275, GuiHitTestUtils.method05625(var2, var3, var10, var11, var9, field14276));
      GuiThemeStyle.method01444(var1, var10, var11, var9, field14277, field14278, var12, GuiThemeStyle.Nested40.NORMAL, var4);
      this.method06310(var10, var11, var9, field14279, ClientScreenManager.INSTANCE::method08321);
      if (this.field14153 == BotManagerScreen.Nested185.BOT && this.field14152 != null) {
         this.method06370(var1, var10 - field14280, var11, var4);
      }
   }

   private void method06372() {
      this.field14110.clear();
      String var1 = this.field14116.method06672().toLowerCase(Locale.ROOT);

      for (BotClient var3 : BotManager.INSTANCE.method03092()) {
         if (var1.isEmpty() || var3.method00137().method00491().toLowerCase(Locale.ROOT).contains(var1)) {
            this.field14110.add(var3);
         }
      }
   }

   private float method06373(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6) {
      WardenBotSettings var7 = WardenBotSettings.INSTANCE;
      float var8 = this.method06402(var1, field14431, GuiIcon.ALERT, var2, var3, var6);
      this.method06359(var1, var2, var8, field14432, var6);
      float var9 = var8;
      this.method06320(var1, field14433, var2, var9, var6);
      this.method06292(var1, field14434, var7.method09328(), true, var2, var9, var6, () -> var7.method09322(!var7.method09328()));
      var9 = this.method06341(var1, var2, var9, var6);
      this.method06320(var1, field14435, var2, var9, var6);
      this.method06292(var1, field14436, var7.method09329(), true, var2, var9, var6, () -> var7.method09323(!var7.method09329()));
      var9 = this.method06341(var1, var2, var9, var6);
      this.method06320(var1, field14437, var2, var9, var6);
      int var10 = method06331(var7.method09331());
      this.field14134
         .method06421(var1, field14101[var10], List.of(field14101), var10, var1x -> var7.method09325(field14101[var1x]), var2, var9, var4, var5, var6);
      var9 = this.method06341(var1, var2, var9, var6);
      this.method06328(
         var1, field14438, 1.0, field14439, 1.0, var7.method09332(), var0 -> (int)var0 + " шт.", var1x -> var7.method09326((int)var1x), var2, var9, var4, var6
      );
      return var8 + field14440 + field14441;
   }

   private void method06374(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = this.field14110.size() * field14226;
      float var8 = this.field14143 - this.field14142;
      this.field14111.method01152(var7 > var8);
      this.field14111.method01145();
      this.field14111.method01134(var7, var8);
      var1.enableScissor((int)this.field14140, (int)this.field14142, (int)Math.ceil(this.field14140 + field14227), (int)Math.ceil(this.field14143));
      float var9 = this.field14142 + this.field14111.method01136();

      for (BotClient var11 : this.field14110) {
         if (var9 + field14228 >= this.field14142 && var9 <= this.field14143) {
            this.method06297(var1, var11, var2, var9, var3, var4, var5, var6);
         }

         var9 += field14229;
      }

      if (this.field14110.isEmpty()) {
         String var12 = BotManager.INSTANCE.method03092().isEmpty() ? field14230 : field14231;
         GuiThemeStyle.field03545.method09480(var1, var12, var2 + 2.0F, this.field14142 + field14232, GuiThemeStyle.method01445(var6), field14233);
      }

      var1.disableScissor();
   }

   private void method06375(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5) {
      this.field14102.method06162();
      this.field14102.method06158(Mth.clamp(var4, 0.0F, 1.0F), field14345, Easings.field19400);
      int var6 = GuiThemeStyle.method01443(ColorUtils.Nested138.method04638(0), var5);
      int var7 = GuiThemeStyle.method01443(ColorUtils.Nested138.method04638(90), var5);
      int var8 = GuiThemeStyle.method01443(var7, field14346);
      float var9 = field14347;
      RoundedRectRenderer.method01272(var1, var2, var3, field14348, field14349, var9, 1.0F, var8);
      float var10 = field14350 * this.field14102.method06173();
      if (var10 > field14351) {
         RoundedRectRenderer.method01275(var1, var2, var3, var10, field14352, var9, 1.0F, new CornerColors(var6, var6, var7, var7));
      }
   }

   private float method06376(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6) {
      float var7 = this.method06402(var1, field14459, GuiIcon.SHARE, var2, var3, var6);
      this.method06359(var1, var2, var7, field14460, var6);
      float var8 = var7;
      this.method06320(var1, field14461, var2, var8, var6);
      this.method06364(var1, field14462, GuiThemeStyle.Nested40.NORMAL, var2, var8, var4, var5, var6, BotManager.INSTANCE::method03075);
      var8 = this.method06341(var1, var2, var8, var6);
      this.method06320(var1, field14463, var2, var8, var6);
      this.method06364(var1, field14464, GuiThemeStyle.Nested40.NORMAL, var2, var8, var4, var5, var6, BotManager.INSTANCE::method03076);
      return var7 + field14465 + field14466;
   }

   private static TextInputWidget method06377(String var0) {
      TextInputWidget var1 = new TextInputWidget().method06678(GuiThemeStyle.field03544, field14174);
      var1.method06717(var0);
      var1.method06734(field14175);
      return var1;
   }

   private void method06378() {
      String var1 = this.field14117.method06672();
      if (!var1.isEmpty()) {
         if (this.field14157) {
            BotManager.INSTANCE.method03077(var1);
         } else {
            if (this.field14152 == null) {
               return;
            }

            this.field14152.method00144(var1);
         }

         this.field14117.method06692();
      }
   }

   private float method06379(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6, float var7) {
      float var8 = this.method06384(var1, var2, var4, var5, var6, var7);
      var8 = this.method06373(var1, var2, var8, var5, var6, var7);
      var8 = this.method06363(var1, var2, var8, var5, var7);
      if (false) {
         var8 = this.method06334(var1, var2, var8, var7);
      }

      float var9 = this.method06376(var1, var3, var4, var5, var6, var7);
      var9 = this.method06401(var1, var3, var9, var5, var6, var7);
      return Math.max(var8, var9);
   }

   private static int method06380(BotConnectionState var0) {
      return switch (var0) {
         case PLAYING -> GuiThemeStyle.field03546;
         case FAILED -> GuiThemeStyle.field03548;
         case CONTROLLED -> GuiThemeStyle.method01441().field22113.method11676();
         default -> var0.method05280() ? GuiThemeStyle.method01441().field22109.method11676() : GuiThemeStyle.method01441().field22110.method11676();
      };
   }

   private void method06381(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
      GuiInputRenderer.method08825(var1, var2, field14506, var3, var4);
   }

   private static float method06382(String var0, float var1) {
      return GuiInputRenderer.method08818(var0, var1);
   }

   private static int method06383(String var0) {
      try {
         return RandomIdUtils.method04147(Integer.parseInt(var0));
      } catch (NumberFormatException var2) {
         return -1;
      }
   }

   private float method06384(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6) {
      BotManager var7 = BotManager.INSTANCE;
      float var8 = this.method06402(var1, field14416, GuiIcon.RELOAD, var2, var3, var6);
      this.method06359(var1, var2, var8, field14417, var6);
      float var9 = this.method06328(
         var1,
         field14418,
         field14419,
         field14420,
         field14421,
         var7.method03095(),
         var0 -> (int)var0 + " мс",
         var1x -> var7.method03099((long)var1x),
         var2,
         var8,
         var4,
         var6
      );
      var9 = this.method06328(
         var1,
         field14422,
         field14423,
         field14424,
         1.0,
         var7.method03096(),
         var0 -> (int)var0 + " чанк.",
         var1x -> var7.method03100((int)var1x),
         var2,
         var9,
         var4,
         var6
      );
      this.method06320(var1, field14425, var2, var9, var6);
      this.method06292(var1, field14426, var7.method03097(), true, var2, var9, var6, () -> var7.method03101(!var7.method03097()));
      var9 = this.method06341(var1, var2, var9, var6);
      this.method06320(var1, field14427, var2, var9, var6);
      this.method06292(var1, field14428, var7.method03098(), true, var2, var9, var6, () -> var7.method03102(!var7.method03098()));
      return var8 + field14429 + field14430;
   }

   private void method06385() {
      int var1 = method06383(this.field14125.method06672());
      if (this.field14152 != null && var1 >= 0) {
         AutoBuyBotState var2 = this.field14152.method00137();
         method06404(() -> var2.method00493(var1));
      }

      this.field14125.method06722();
   }

   private void method06386(GuiGraphicsExtractor var1, TextInputWidget var2, String var3, float var4, float var5, float var6, float var7) {
      GuiInputRenderer.method08821(var1, var2, var3, var4, field14508, var5, var6, this.method06313(var2, var2.method06726()), var7);
   }

   private void method06390() {
      var var1 = BotManager.INSTANCE.method03092();
      if (this.field14152 == null || !var1.contains(this.field14152)) {
         this.field14152 = var1.isEmpty() ? null : (BotClient)var1.get(0);
      }
   }

   private void method06392(double var1) {
      AutoBuyBotState var3 = this.field14152.method00137();
      AutoBuyBotStatus var4 = AutoBuyBotStatus.values()[this.field14136.method02648(var1)];
      if (var4 != var3.method00475()) {
         method06404(() -> var3.method00483(var4));
      }
   }

   private void method06393() {
      String var1 = this.field14126.method06672();
      int var2 = var1.isEmpty() ? -1 : method06383(var1);
      if (this.field14152 != null && (var2 >= 0 || var1.isEmpty())) {
         AutoBuyBotState var3 = this.field14152.method00137();
         method06404(() -> var3.method00488(var2));
      }

      this.field14126.method06722();
   }

   @Override
   public boolean method01465(double var1, double var3, int var5) {
      Vec2 var6 = GuiScaleUtils.method06746(var1, var3);

      for (TextInputWidget var8 : this.field14127) {
         var8.method06673(var6.x, var6.y, var5);
      }

      if (var5 == 0) {
         this.field14146 = false;
         this.field14151 = null;
      }

      return true;
   }

   private static float method06395(float var0) {
      return var0 + field14247 - GuiThemeStyle.field03543.method09485(field14248) / 2.0F - field14249;
   }

   private void method06396() {
      this.field14149 = null;
      this.field14118.method06722();
   }

   @Override
   protected void method01466() {
      this.field14127.forEach(TextInputWidget::method06722);
      this.field14146 = false;
      this.field14151 = null;
   }

   private void method06397(float var1, float var2) {
      float var3 = GuiScaleUtils.method06753();
      float var4 = GuiScaleUtils.method06754();
      if (!this.field14145) {
         this.field14140 = var3 / 2.0F - field14177;
         this.field14141 = var4 / 2.0F - field14178;
         this.field14145 = true;
      }

      if (this.field14146) {
         this.field14140 = var1 - this.field14147;
         this.field14141 = var2 - this.field14148;
      }

      this.field14140 = Mth.clamp(this.field14140, 0.0F, Math.max(0.0F, var3 - field14179));
      this.field14141 = Mth.clamp(this.field14141, 0.0F, Math.max(0.0F, var4 - field14180));
   }

   private float method06398(GuiGraphicsExtractor var1, BotClient var2, float var3, float var4, float var5) {
      float var6 = this.method06402(var1, field14353, GuiIcon.FOLDER, var3, var4, var5);
      float var7 = field14354;
      float var8 = field14355 * var7 + field14356;
      this.method06359(var1, var3, var6, var8 + field14357, var5);
      this.field14114.method02160(var2);
      int var9 = Mth.clamp(var2.method00070().method07987(), 0, 8);
      int var10 = GuiThemeStyle.method01443(GuiThemeStyle.method01441().field22120.method11676(), field14358 * var5);
      int var11 = GuiThemeStyle.method01446(field14359 * var5);
      float var12 = var3 + field14360;
      float var13 = var6 + field14361;
      float var14 = (var7 - 1.0F) / field14362;

      for (int var15 = 0; var15 < 4; var15++) {
         boolean var16 = var15 == 3;
         float var17 = var13 + var15 * (var7 + field14363) + (var16 ? field14364 : 0.0F);

         for (int var18 = 0; var18 < 9; var18++) {
            float var19 = var12 + var18 * (var7 + field14365);
            int var20 = var16 ? var18 : 9 + var15 * 9 + var18;
            boolean var21 = var16 && var18 == var9;
            RoundedRectRenderer.method01272(var1, var19, var17, var7, var7, 2.0F, 1.0F, var21 ? var11 : var10);
            ItemStack var22 = this.field14114.method02164(var20);
            if (!var22.isEmpty()) {
               ItemRenderUtils.method08416(var1, var22, var19 + field14366, var17 + field14367, var14, var5);
            }
         }
      }

      return var6 + var8 + field14368 + field14369;
   }

   private static <K> float method06399(Map<K, SmoothAnimation> var0, K var1, boolean var2) {
      SmoothAnimation var3 = var0.computeIfAbsent(var1, var0x -> new SmoothAnimation());
      var3.method06162();
      var3.method06158(var2 ? 1.0 : 0.0, field14534, Easings.field19400);
      return var3.method06173();
   }

   private static void method06400(Runnable var0) {
      var0.run();
      AutoBuyItemRegistry.INSTANCE.method10994();
   }

   private float method06401(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, float var6) {
      var var7 = ProxyManager.INSTANCE.method05237();
      float var8 = this.method06402(var1, field14467, GuiIcon.PIN, var2, var3, var6);
      int var9 = Math.max(1, var7.size());
      float var10 = field14468 * (var9 + 5) + field14469 + field14470 + field14471;
      this.method06359(var1, var2, var8, var10, var6);
      float var11 = var8;
      if (var7.isEmpty()) {
         this.method06347(var1, field14472, var2, var11, var6);
         var11 = this.method06341(var1, var2, var11, var6);
      }

      for (ProxyConfig var13 : var7) {
         float var14 = field14473;
         String var15 = var13.method03914() + " · " + var13.method03901().method03921();
         this.method06320(var1, GuiThemeStyle.method01438(GuiThemeStyle.field03544, var15, field14474, var14), var2, var11, var6);
         this.method06364(
            var1,
            field14475,
            GuiThemeStyle.Nested40.DANGER,
            var2,
            var11,
            var4,
            var5,
            var6,
            () -> ProxyManager.INSTANCE.method05224(var13.method03913())
         );
         var11 = this.method06341(var1, var2, var11, var6);
      }

      this.method06320(var1, field14476, var2, var11, var6);
      this.method06386(var1, this.field14121, field14477, var2, var11, var4, var6);
      var11 = this.method06341(var1, var2, var11, var6);
      this.method06320(var1, field14478, var2, var11, var6);
      this.method06386(var1, this.field14122, field14479, var2, var11, var4, var6);
      var11 = this.method06341(var1, var2, var11, var6);
      this.method06320(var1, field14480, var2, var11, var6);
      this.method06364(
         var1,
         this.field14156.method03921(),
         GuiThemeStyle.Nested40.NORMAL,
         var2,
         var11,
         var4,
         var5,
         var6,
         () -> this.field14156 = this.field14156.method03920()
      );
      var11 = this.method06341(var1, var2, var11, var6);
      this.method06320(var1, field14481, var2, var11, var6);
      this.method06386(var1, this.field14123, field14482, var2, var11, var4, var6);
      var11 = this.method06341(var1, var2, var11, var6);
      this.method06320(var1, field14483, var2, var11, var6);
      this.method06386(var1, this.field14124, field14484, var2, var11, var4, var6);
      var11 += field14485;
      this.method06325(var1, field14486, method06417(this.field14122.method06672()), var2, var11, var4, var5, var6, this::method06405);
      return var8 + var10 + field14487;
   }

   private float method06402(GuiGraphicsExtractor var1, String var2, GuiIcon var3, float var4, float var5, float var6) {
      float var7 = GuiThemeStyle.field03543.method09485(field14488);
      float var8 = var5 + var7 / 2.0F;
      var3.method01190(var1, var4 + field14489 + field14490, var8, field14491, GuiThemeStyle.method01445(var6));
      GuiThemeStyle.field03544
         .method09480(
            var1,
            var2,
            var4 + field14492 + field14493 + field14494,
            var8 - GuiThemeStyle.field03544.method09485(field14495) / 2.0F,
            GuiThemeStyle.method01437(var6),
            field14496
         );
      return var5 + var7 + field14497;
   }

   private void method06403(BotClient var1) {
      this.field14152 = var1;
      this.method06319(BotManagerScreen.Nested185.BOT);
   }

   private static void method06404(Runnable var0) {
      var0.run();
      BotManager.INSTANCE.method03088();
   }

   private void method06405() {
      ProxyConfig var1 = ProxyConfig.method03905(
         this.field14121.method06672(), this.field14122.method06672(), this.field14156, this.field14123.method06672(), this.field14124.method06672()
      );
      if (var1 != null && ProxyManager.INSTANCE.method05222(var1) != null) {
         this.field14129.forEach(TextInputWidget::method06702);
      }
   }

   private void method06406(AutoBuyBotState var1, int var2) {
      method06404(() -> var1.method00485(var2 == 0 ? "" : ViaFabricPlusProtocolAccess.method11194().get(var2 - 1)));
   }

   private TextInputWidget method06407() {
      for (TextInputWidget var2 : this.field14127) {
         if (var2.method06726() && var2.method06711()) {
            return var2;
         }
      }

      return null;
   }

   private void method06408(TextInputWidget var1) {
      if (var1 != null && !var1.method06726()) {
         if (var1 == this.field14125) {
            this.method06385();
         } else if (var1 == this.field14126) {
            this.method06393();
         }
      }
   }

   private static boolean method06417(String var0) {
      int var1 = var0.lastIndexOf(58);
      return var1 > 0 && var1 < var0.length() - 1 && ProxyConfig.method03911(var0.substring(var1 + 1)) > 0;
   }

   // $VF: Compiled from s
   private final class Nested184 {
      private final String field14545;
      private final GuiBounds field14546 = new GuiBounds();
      private final GuiBounds field14547 = new GuiBounds();
      private final ScrollController field14548 = new ScrollController();
      private List<String> field14549 = List.of();
      private int field14550;
      private IntConsumer field14551;
      private static final float field14553 = 6.5F;
      private static final float field14554 = 6.5F;
      private static final float field14555 = 110.57143F;
      private static final float field14556 = 6.0F;
      private static final float field14557 = 6.5F;
      private static final float field14558 = 6.5F;
      private static final float field14559 = 120.57143F;
      private static final float field14560 = 5.0F;
      private static final float field14561 = 7.25F;
      private static final float field14562 = 6.5F;
      private static final float field14563 = 12.0F;
      private static final float field14564 = 6.0F;
      private static final float field14565 = 84.0F;
      private static final float field14566 = 250.0F;
      private static final float field14567 = 5.0F;
      private static final float field14568 = 84.0F;
      private static final float field14569 = 12.0F;
      private static final float field14570 = 6.0F;
      private static final float field14571 = 84.0F;
      private static final float field14572 = 3.0F;
      private static final float field14573 = 3.0F;
      private static final float field14574 = 84.0F;
      private static final float field14575 = 12.0F;
      private static final float field14576 = 12.0F;
      private static final float field14577 = 12.0F;
      private static final float field14578 = 84.0F;
      private static final float field14579 = 3.0F;
      private static final float field14580 = 78.0F;
      private static final float field14581 = 12.0F;
      private static final float field14582 = 6.5F;
      private static final float field14583 = 72.0F;
      private static final float field14584 = 6.0F;
      private static final float field14585 = 6.0F;
      private static final float field14586 = 6.5F;
      private static final float field14587 = 0.5F;
      private static final float field14588 = 6.5F;
      private static final float field14589 = 84.0F;

      private void method06418() {
         BotManagerScreen.this.field14150 = this.method06424() ? null : this;
         this.field14548.method01144();
      }

      private void method06419(GuiGraphicsExtractor var1, int var2, float var3, float var4, float var5, float var6, float var7, float var8, float var9) {
         float var10 = Math.max(var4, var5);
         float var11 = Math.min(var4 + field14577, var5 + var6) - var10;
         String var12 = this.field14549.get(var2);
         float var13 = BotManagerScreen.this.method06313(var12, GuiHitTestUtils.method05625(var7, var8, var3, var10, field14578, var11));
         GuiThemeStyle.method01448(var1, var3 + field14579, var4, field14580, field14581, 2.0F, var13, var9);
         int var14 = var2 == this.field14550
            ? GuiThemeStyle.method01446(var9)
            : GuiThemeStyle.method01440(GuiThemeStyle.method01445(var9), GuiThemeStyle.method01437(var9), var13);
         GuiThemeStyle.field03544
            .method09480(
               var1,
               GuiThemeStyle.method01438(GuiThemeStyle.field03544, var12, field14582, field14583),
               var3 + field14584,
               var4 + field14585 - GuiThemeStyle.field03544.method09485(field14586) / 2.0F - field14587,
               var14,
               field14588
            );
         BotManagerScreen.this.field14108.method03442(var3, var10, field14589, var11, () -> this.method06423(var2));
      }

      private Nested184(String var2) {
         this.field14545 = var2;
      }

      void method06421(
         GuiGraphicsExtractor var1, String var2, List<String> var3, int var4, IntConsumer var5, float var6, float var7, float var8, float var9, float var10
      ) {
         this.field14549 = var3;
         this.field14550 = var4;
         this.field14551 = var5;
         float var11 = GuiThemeStyle.field03544.method09486(this.field14545, field14553);
         String var12 = GuiThemeStyle.method01438(GuiThemeStyle.field03544, var2, field14554, field14555 - var11 - field14556);
         float var13 = KeyLabelRenderer.method02576(GuiThemeStyle.field03544, var12, field14557);
         float var14 = KeyLabelRenderer.method02577(GuiThemeStyle.field03544, field14558);
         this.field14546.method02801(var6 + field14559 - field14560 - var13);
         this.field14546.method02806(var7 + field14561 - var14 / 2.0F);
         this.field14546.method02803(var13);
         this.field14546.method02798(var14);
         float var15 = BotManagerScreen.method06399(BotManagerScreen.this.field14105, this.field14545, this.method06424());
         float var16 = BotManagerScreen.this.method06313(this.field14545, this.field14546.method02799(var8, var9));
         float var17 = Math.max(var15, var16);
         GuiPanelRenderer.method00760(
            var1,
            GuiThemeStyle.field03544,
            this.field14546.method02809(),
            this.field14546.method02808(),
            var13,
            var14,
            var12,
            field14562,
            GuiPanelRenderer.method00762(var17, var10),
            GuiPanelRenderer.method00763(var17, var10)
         );
         BotManagerScreen.this.method06310(this.field14546.method02809(), this.field14546.method02808(), var13, var14, this::method06418);
      }

      void method06422(GuiGraphicsExtractor var1, float var2, float var3, float var4) {
         int var5 = this.field14549.size();
         int var6 = Math.min(var5, 8);
         float var7 = var6 * field14563 + field14564;
         float var8 = this.field14546.method02809() + this.field14546.method02804() - field14565;
         float var9 = this.field14546.method02808() + this.field14546.method02802() + 2.0F;
         float var10 = var9 + var7 <= BotManagerScreen.this.field14141 + field14566 - field14567 ? var9 : this.field14546.method02808() - 2.0F - var7;
         this.field14547.method02801(var8);
         this.field14547.method02806(var10);
         this.field14547.method02803(field14568);
         this.field14547.method02798(var7);
         float var11 = var5 * field14569;
         float var12 = var7 - field14570;
         this.field14548.method01152(var11 > var12);
         this.field14548.method01145();
         this.field14548.method01134(var11, var12);
         GuiRenderBatch.method05183();
         WindowFrameRenderer.method03055(var1, var8, var10, field14571, var7, field14572, var4);
         float var13 = var10 + field14573;
         var1.enableScissor((int)var8, (int)var13, (int)Math.ceil(var8 + field14574), (int)Math.ceil(var13 + var12));
         float var14 = var13 + this.field14548.method01136();

         for (int var15 = 0; var15 < var5; var15++) {
            if (var14 + field14575 >= var13 && var14 <= var13 + var12) {
               this.method06419(var1, var15, var8, var14, var13, var12, var2, var3, var4);
            }

            var14 += field14576;
         }

         var1.disableScissor();
      }

      private void method06423(int var1) {
         this.field14551.accept(var1);
         BotManagerScreen.this.field14150 = null;
      }

      private boolean method06424() {
         return BotManagerScreen.this.field14150 == this;
      }
   }

   // $VF: Compiled from s
   private enum Nested185 {
      BOT,
      CREATE,
      SETTINGS;
   }
}
