// Original binary: sg/ec/u5xxX9nJM7go2dqb
package sg.ec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;

// $VF: Compiled from s
public class KillMessage extends ClientModule {
   private static final String field24210 = "KillMessage.json";
   private static final Gson field24211 = new GsonBuilder().setPrettyPrinting().disableHtmlEscaping().create();
   private static final String field24212 = "field24212";
   private final ModeSetting field24213;
   private final ActionSetting field24214;
   private final ToggleSetting field24215;
   private final String[] field24216;
   LivingEntity field24217;
   private static final String field24218 = "Стиль сообщения";
   private static final String field24219 = "Клиентские";
   private static final String field24220 = "Свои";
   private static final String field24221 = "Клиентские";
   private static final String field24222 = "Открыть файл";
   private static final String field24223 = "Булинг в сообщении";
   private static final String field24224 = "АХАХАХА, Ебать ты олух сдох как ез";
   private static final String field24225 = "Бля чел купи норм чит сосешь как дышишь";
   private static final String field24226 = "Сосать плюс лежать";
   private static final String field24227 = "воч дэмо воч дэмо,снова в калени упал";
   private static final String field24228 = "мамут рахал";
   private static final String field24229 = "ало норм чит дада пошел нахуй";
   private static final String field24230 = "от тебя уже даже глисты уходят помойся";
   private static final String field24231 = "Твои криты звучат как пердеж на ветру.";
   private static final String field24232 = "Твои попытки попасть по мне — это новый вид промаха.";
   private static final String field24233 = "Иди купи себе премиум-чит, может, перестанешь сосать.";
   private static final String field24234 = "Твоя тактика — это бежать и плакать в голосовой чат.";
   private static final String field24235 = "Из тебя бы вышел хороший тренировочный манекен.";
   private static final String field24236 = "Даже новый игрок с гайдом из 2012 года уделает тебя.";
   private static final String field24237 = "Ты думал, у тебя имба? Нет, братан, твой чит — хуйня, гетай MiranWare.";
   private static final String field24238 = "снова в калени упал сын пабледухи";
   private static final String field24239 = "суицид не выход)))";
   private static final String field24240 = "мамкин гуленок умер";
   private static final String field24241 = "Сейчас сделаю из тебя фри-фолл без элитр.";
   private static final String field24242 = "ну ты и бичара,я снова посадил тебя на дик(";
   private static final String field24243 = "Ну ты прям король лохов, я опять сделал тебе подлянку";
   private static final String field24244 = "Снова упал, как лось на льду";
   private static final String field24245 = "Я кличку твоей маме придумал чехол для члена скажи слово если норм кличка";
   private static final String field24246 = "Ну ты и лох, опять упал как недоумок";
   private static final String field24247 = "Ты такой бездарный, что даже боты лучше тебя играют!";
   private static final String field24248 = "ты топ 1 по сливанию ресурсов";
   private static final String field24249 = "Обмылок, все твои попытки  ничто, иди на хуй, лузер!";
   private static final String field24250 = "Элитры для сильных, а ты  слабак, который не может их освоить!";
   private static final String field24251 = "Ты как будто специально стараешься выглядеть глупым";
   private static final String field24252 = "Твои попытки летать на элитрах  это просто смешно, иди на улицу!";
   private static final String field24253 = "ахахахахах,пидрила снова уебался в мой жирный хуй своим ебалом.иди просписьсвиномать";
   private static final String field24254 = "Купи себе мозги, а то бестолочь полная";
   private static final String field24255 = "ты слишком тупой. Хвх  это игра умов";
   private static final String field24256 = "что скажешь на это? уебок!";
   private static final String field24257 = "инвалид без рук дереться лучше";
   private static final String field24258 = "люблю убивать таких как ты";
   private static final String field24259 = "с тебя выпало мало ресурсов мне надо больше!";
   private static final String field24260 = "ты похож на ансофтера, если конечно, это для тебя оскорбление";
   private static final String field24261 = "кто теперь ez хахаха";
   private static final String field24262 = "крокодил не птичка, скибиди яичко";
   private static final String field24263 = "Атца ебал";
   private static final String field24264 = "написал ez оказался на спавне";
   private static final String field24265 = "Выйди с игры, раз сосешь за за считанные секунды";
   private static final String field24266 = "бичуган сдох";
   private static final String field24267 = "Хуй знает, не противник";
   private static final String field24268 = "Изи, сын шлюхи";
   private static final String field24269 = "Пойди найди себе парня под мейн, пидорас";
   private static final String field24270 = "Кряк не забустил, хуесос?";
   private static final String field24271 = "Че ты тут делаешь, в бравлстарсе же абнова вышла, новова перса дабавили, беги быстрее!!!!!";
   private static final String field24272 = "Ау, сочняра, паблик лузаешь, ссаный пидор";
   private static final String field24273 = "Пиздец, на каком ты дне валяешься, сын твари";
   private static final String field24274 = "Пидорас, ты из тех людей которые занимают третье место, играя 1v1";
   private static final String field24275 = "Ты причина легализации абортов";
   private static final String field24276 = "АБУЗ СКИТА? НЕТ БЛЯТЬ КРЯКА!";
   private static final String field24277 = "ez";
   private static final String field24278 = "too fucking easy";
   private static final String field24279 = "effortless";
   private static final String field24280 = "easiest kill of my life";
   private static final String field24281 = "retard blasted";
   private static final String field24282 = "cleans?";
   private static final String field24283 = "nice memesense retard";
   private static final String field24284 = "hello mind explaining what happened there";
   private static final String field24285 = "а вы че клины???";
   private static final String field24286 = "обоссал мемюзера лол";
   private static final String field24287 = "сразу видно юид иссуе хуле тут";
   private static final String field24288 = "у мамки что кфг иссуе была шо тебя родила";
   private static final String field24289 = "а ты и в жизни ньюкамыч????";
   private static final String field24290 = "сука не позорься и ливни лол";
   private static final String field24291 = "юид полиция подьехала открывай дверь уебыч";
   private static final String field24292 = "набутылирован лол";
   private static final String field24293 = "tranny holzed";
   private static final String field24294 = "але ты там из хрущевки выеди а потом вырыгивай блять";
   private static final String field24295 = "как там с мамкой комнату разделять АХАХАХХАХА как ты на акк накопил блять";
   private static final String field24296 = "найс 0.5х0.5м комната блять ХАХАХАХА ТЫ ТАМ ЖЕ ДАЖЕ ПОВЕСИТЬСЯ НЕ МОЖЕШЬ МЕСТА НЕТ ПХПХПХППХ";
   private static final String field24297 = "better buy the superior hack!";
   private static final String field24298 = "на мыло и веревку то деньги есть нищ????";
   private static final String field24299 = "whatcha shootin at retard";
   private static final String field24300 = "опущены стяги, легион и.. А БЛЯТЬ ТЫЖ ТУТ ОПУЩ НАХУЙ ПХГАХААХАХАХАХА)))))))";
   private static final String field24301 = "але какая с юидом ситуация)))";
   private static final String field24302 = "бля че тут эта нищая собака заскулила";
   private static final String field24303 = "не хотелось даже руки об тебя марать нищ сука";
   private static final String field24304 = "ебать ты красиво на бутылку упал";
   private static final String field24305 = "прости что без смазки)))";
   private static final String field24306 = "алло это скорая? тут такая ситуация нищ упал))) ОЙ А ВЫ НИЩАМ ТО НЕ ПОМОГАЕТЕ?? ПОНЯТНО Я ПОЙДУ ТОГДА))))))))";
   private static final String field24307 = "вырыгнись из окна нахуй боберхук юзер";
   private static final String field24308 = "тяжело с мемсенсом наверно????";
   private static final String field24309 = "imagine losing at video games couldn't ever be me";
   private static final String field24310 = "але а противники то где???";
   private static final String field24311 = "nice chromosome count you sell??";
   private static final String field24312 = "как ты на пк накопил даже не знаю )))))))))";
   private static final String field24313 = "iq больше двух будет пмнешь ок????";
   private static final String field24314 = "НИХУЯ ТАМ НЬЮКАМЫЧА ОРОШИЛИ СТРУЕЙ МОЧИ АХАХХАХАХАХАХАХАХА";
   private static final String field24315 = "дал юид за щеку проверяй";
   private static final String field24316 = "nn4ik shat on";
   private static final String field24317 = "хуя тебя опустили манька))))";
   private static final String field24318 = "а у вас походу умирать это семейное)";
   private static final String field24319 = "нахуя пидораса убил?";
   private static final String field24320 = "чао персик дозревай";
   private static final String field24321 = "уважаемый в тюрьме вы будете водолазом";
   private static final String field24322 = "говори буду плохо говорить буду сосать, буду плохо сосать буду пересасывать";
   private static final String field24323 = "долбаеб иди башмачки в сундучок школьный собирай";
   private static final String field24324 = "ботинок ебаный чо слетел";
   private static final String field24325 = "братик маме привет передай";
   private static final String field24326 = "не противник";
   private static final String field24327 = "DEAD пофикси нищ";
   private static final String field24328 = "сразу видно юид иссуе хуле тут";
   private static final String field24329 = "у мамки что кфг иссуе была шо тебя родила";
   private static final String field24330 = "а ты и в жизни ньюкамыч????";
   private static final String field24331 = "сука не позорься и ливни лол";
   private static final String field24332 = "юид полиция подьехала открывай дверь уебыч";
   private static final String field24333 = "набутылирован лол";
   private static final String field24334 = "tranny holzed";
   private static final String field24335 = "але ты там из хрущевки выеди а потом вырыгивай блять";
   private static final String field24336 = "как там с мамкой комнату разделять АХАХАХХАХА как ты на акк накопил блять";
   private static final String field24337 = "найс 0.5х0.5м комната блять ХАХАХАХА ТЫ ТАМ ЖЕ ДАЖЕ ПОВЕСИТЬСЯ НЕ МОЖЕШЬ МЕСТА НЕТ ПХПХПХППХ";
   private static final String field24338 = "better buy the superior hack!";
   private static final String field24339 = "на мыло и веревку то деньги есть нищ????";
   private static final String field24340 = "whatcha shootin at retard";
   private static final String field24341 = "опущены стяги, легион и.. А БЛЯТЬ ТЫЖ ТУТ ОПУЩ НАХУЙ ПХГАХААХАХАХАХА)))))))";
   private static final String field24342 = "але какая с юидом ситуация)))";
   private static final String field24343 = "бля че тут эта нищая собака заскулила";
   private static final String field24344 = "не хотелось даже руки об тебя марать нищ сука";
   private static final String field24345 = "ебать ты красиво на бутылку упал";
   private static final String field24346 = "прости что без смазки)))";
   private static final String field24347 = "алло это скорая? тут такая ситуация нищ упал))) ОЙ А ВЫ НИЩАМ ТО НЕ ПОМОГАЕТЕ?? ПОНЯТНО Я ПОЙДУ ТОГДА))))))))";
   private static final String field24348 = "вырыгнись из окна нахуй боберхук юзер";
   private static final String field24349 = "тяжело с мемсенсом наверно????";
   private static final String field24350 = "imagine losing at video games couldn't ever be me";
   private static final String field24351 = "але а противники то где???";
   private static final String field24352 = "nice chromosome count you sell??";
   private static final String field24353 = "как ты на пк накопил даже не знаю )))))))))";
   private static final String field24354 = "iq больше двух будет пмнешь ок????";
   private static final String field24355 = "НИХУЯ ТАМ НЬЮКАМЫЧА ОРОШИЛИ СТРУЕЙ МОЧИ АХАХХАХАХАХАХАХАХА";
   private static final String field24356 = "дал юид за щеку проверяй";
   private static final String field24357 = "nn4ik shat on";
   private static final String field24358 = "хуя тебя опустили манька))))";
   private static final String field24359 = "а у вас походу умирать это семейное)";
   private static final String field24360 = "нахуя пидораса убил?";
   private static final String field24361 = "чао персик дозревай";
   private static final String field24362 = "уважаемый в тюрьме вы будете водолазом";
   private static final String field24363 = "говори буду плохо говорить буду сосать, буду плохо сосать буду пересасывать";
   private static final String field24364 = "долбаеб иди башмачки в сундучок школьный собирай";
   private static final String field24365 = "ботинок ебаный чо слетел";
   private static final String field24366 = "братик маме привет передай";
   private static final String field24367 = "не противник";
   private static final String field24368 = "а ты че клоун???";
   private static final String field24369 = "я обоссал тебя (";
   private static final String field24370 = "ты че там отлетел то?";
   private static final String field24371 = "упал хуета ебаная , но в боди забрал да похуй все равно упал";
   private static final String field24372 = "DEAD ливай с хвх (";
   private static final String field24373 = "до связи башмак";
   private static final String field24374 = "нищета глупейшая играть учись";
   private static final String field24375 = "опущен сын твари";
   private static final String field24376 = "нищий улетел";
   private static final String field24377 = "DEAD пофикси нищ";
   private static final String field24378 = "сразу видно кфг иссуе мб конфиг у меня прикупишь ?";
   private static final String field24379 = "животное аддон скачай а то падаешь";
   private static final String field24380 = "оттарабанен армянская королева";
   private static final String field24381 = "сука не позорься и ливни";
   private static final String field24382 = "улетел тапочек ебаный";
   private static final String field24383 = "единицей свалился фуфлыжник";
   private static final String field24384 = "зачем ты играешь тут безмозглый";
   private static final String field24385 = "иди кумыса попей очередняра";
   private static final String field24386 = "откисай сочняра";
   private static final String field24387 = "на мыло и веревку то деньги есть????";
   private static final String field24388 = "свежий кабанчик";
   private static final String field24389 = "до связи на подскоке кабанчик";
   private static final String field24390 = "скажи маме сухарики купить долбаеб";
   private static final String field24391 = "ебать ты красиво на бутылку присел , тебе дать альт ?";
   private static final String field24392 = "прости что без смазки)";
   private static final String field24393 = "алло это скорая? тут такая ситуация пареню который упал нужна скорая)";
   private static final String field24394 = "ало ты мапу лузаешь дура очнись";
   private static final String field24395 = "тяжело с кряком????";
   private static final String field24396 = "ЕБУЧЕСТЬ ВТОРОГО РАЗРЯДА ВЫДВИЖЕНЕЦ ОТКИС";
   private static final String field24397 = "але а противники то где???";
   private static final String field24398 = "ты по легиту играешь ?";
   private static final String field24399 = "ХУЕПРЫГАЛО ТУСОВОЧНОЕ КУДА ПОЛЕТЕЛО";
   private static final String field24400 = "ты куда жертва козьего аборта";
   private static final String field24401 = "iq?";
   private static final String field24402 = "ты то куда лезешь сын фантомного стационарного спец изолированого металлформовочного механизма";
   private static final String field24403 = "nice antiaim, you sell?";
   private static final String field24404 = "you pay for that?";
   private static final String field24405 = "consider suicide";
   private static final String field24406 = "bro are u clean?";
   private static final String field24407 = "another retard blasted";
   private static final String field24408 = "paster abandoned the match and received a 7 day competitive matchmaking cooldown";
   private static final String field24409 = "бля эт пиздец че какие то там нищи с мемсенсом рыгают блять";
   private static final String field24410 = "на завод иди";
   private static final String field24411 = "JAJAJAJJAJA NICE RAINBOWPASTE ROFL";
   private static final String field24412 = "140er????";
   private static final String field24413 = "get good get MiranWare";
   private static final String field24414 = "1 but all you need to fix your problems is a rope and a chair you ugly shit";
   private static final String field24415 = "who (kto) are you (nn4ik) wattafak mens???????";
   private static final String field24416 = "must be an uid issue";
   private static final String field24417 = "ебать тебя унесло";
   private static final String field24418 = "рефандни пожалуйста";
   private static final String field24419 = "на бутылку русак";
   private static final String field24420 = "a вы (you) сэр собственно кто (who)?";
   private static final String field24421 = "бля пиздос может рефнешь???";
   private static final String field24422 = "как там жизнь с рупастой??????";
   private static final String field24423 = "stop spending your lunch money on shitpastes retard";
   private static final String field24424 = "бля я рядом только прошел а ты уже упал АУУ НИЩ С ТОБОЙ ВСЕ ХОРОШО??????????))))))";
   private static final String field24425 = "ой нищий упал щас скорую вызовем";
   private static final String field24426 = "ой а кто (who) ты (you) такой вотзефак мен))))))";
   private static final String field24427 = "thats going in my media compilation right there get shamed retard rofl";
   private static final String field24428 = "imagine the only thing you eat being bullets man being a thirdworlder must suck rofl";
   private static final String field24429 = "so fucking ez";
   private static final String field24430 = "botkick";
   private static final String field24431 = "where the enemies at????";
   private static final String field24432 = "але найс упал нищ ЛОООООООЛ";
   private static final String field24433 = "с тобой там все хорошо????????????? а да ты нищ нахуя я спрашиваю ПХАХАХАХАХХА";
   private static final String field24434 = "жаль конечно что против нищей играть надо)))";
   private static final String field24435 = "тебе даже спин не поможет блять, нахуй ты вообще живешь";
   private static final String field24436 = "ты можешь заселлить лишнюю хромосому???";
   private static final String field24437 = "научи потом как так сосать на хвх";
   private static final String field24438 = "когда не накопил на гормоны и чулки)))))))))))))";
   private static final String field24439 = "как там жизнь на мамкину пенсию???????";
   private static final String field24440 = "але я боткик в консоль вроде прописал а вас там не кикнуло эт че баг??)))))))))";
   private static final String field24441 = "крякоюзер down, на завод нахуй";
   private static final String field24442 = "я не понял ты такой жирный потомучто дошики каждый день жрешь???? нормальную работу найди может на еду денег хватит))))))))))))";
   private static final String field24443 = "насрал тебе в ротешник проверяй";
   private static final String field24444 = "нихуя ты там как самолет отлетел ХАХАХХАХАХАХАХХХААХАА";
   private static final String field24445 = "БЛЯ НИЩ ХУЯК ХУЯК И ТЕБЯ НЕТ КАК МОЖНО ТАКИМ БЫТЬ?????? ОБЬЯСНИСЬ БЛЯТЬ";
   private static final String field24446 = "держи зонтик, тебя обоссали";
   private static final String field24447 = "Держи пенис и взлети нахуй!";
   private static final String field24448 = "слишком сочный для Djamic.technologies";
   private static final String field24449 = "сьебался нахуй таракан усатый";
   private static final String field24450 = "мать твою ебал";
   private static final String field24451 = "нахуй ты упал иди вставай и на завод";
   private static final String field24452 = "не по сезону шуршишь фраер";
   private static final String field24453 = "ИЗИ ЧМО ЕБАНОЕ";
   private static final String field24454 = "ливай блять не позорься";
   private static final String field24455 = "AХАХ ПИДОР УПАЛ С ВАНВЕЯ ХАХАХА ОНЛИ БАИМ В БОДИ ПОТЕЕТ НА ФД АХА";
   private static final String field24456 = "АХАХА УЛЕТЕЛ ЧМОШНИК";
   private static final String field24457 = "1 МАТЬ ЖАЛЬ";
   private static final String field24458 = "на завод иди";
   private static final String field24459 = "не не он опять упал на конлени";
   private static final String field24460 = "вставай заебал , завтра в школу";
   private static final String field24461 = "гет гуд гет иди нахуй";
   private static final String field24462 = "by SANCHEZj hvh boss";
   private static final String field24463 = "ну нет почему он ложится когда я прохожу";
   private static final String field24464 = "у тебя ник нейм адео?";
   private static final String field24465 = "парень тебе ник придумать?";
   private static final String field24466 = "такой тупой (((";
   private static final String field24467 = "хватит получать хс, лучше возьми свою руку и иди дрочи";
   private static final String field24468 = "нет нет этот крякер такой смешной";
   private static final String field24469 = "1 сын шлюхи";
   private static final String field24470 = "1 мать твою ебал";
   private static final String field24471 = "преобрети мой кфг клоун";
   private static final String field24472 = "об кафель голову разбил?";
   private static final String field24473 = "мать твою ебал";
   private static final String field24474 = "хуесос дальше адайся ко мне";
   private static final String field24475 = "ещё раз позови к себе на бекап";
   private static final String field24476 = "не противник";
   private static final String field24477 = "ник нейм дориан(";
   private static final String field24478 = "iq ?";
   private static final String field24479 = "упал = минус мать";
   private static final String field24480 = "не пиши мне";
   private static final String field24481 = "жаль конечно что против тебя играю, но куда деваться";
   private static final String field24482 = "адиничкой упал";
   private static final String field24483 = "сынок зачем тебе это ?";
   private static final String field24484 = "давно в рот берёшь?";
   private static final String field24485 = "мне можно";
   private static final String field24486 = "ты меня так заебал , ливни уже";
   private static final String field24487 = "ничему жизнь не учит (";
   private static final String field24488 = "я не понял, ты такой жирный потомучто дошики каждый день жрешь?";
   private static final String field24489 = "толстяк даже пройти спокойно не может";
   private static final String field24490 = "а ты че клоун???";
   private static final String field24491 = "я обоссал тебя (";
   private static final String field24492 = "ты че там отлетел то?";
   private static final String field24493 = "упал хуета ебаная , но в боди забрал да похуй все равно упал";
   private static final String field24494 = "DEAD ливай с хвх (";
   private static final String field24495 = "до связи башмак";
   private static final String field24496 = "нищета глупейшая играть учись";
   private static final String field24497 = "опущен сын твари";
   private static final String field24498 = "нищий улетел";
   private static final String field24499 = "take the cooldown and let your team surr retard";
   private static final String field24500 = "go take some estrogen tranny";
   private static final String field24501 = "uid police here present your user identification number right now";
   private static final String field24502 = "нищий улетел";
   private static final String field24503 = "ты че там отлетел то";
   private static final String field24504 = "lmao ur so ugly irl like bro doesnt it hurt to live like that, btw you know you can just end it all";
   private static final String field24505 = "Хули ты падаешь то? Иди у кисляши кфг прикупи на кряк";
   private static final String field24506 = "Я ТВОЕЙ МАТЕРИ ЗУБЫ ВЫБИЛ ХУЕСОС";
   private static final String field24507 = "Некоторым  платят за оральный ceкc, но ты делаешь это бесплатно";
   private static final String field24508 = "Дружище, с таким уровнем игры иди убейся об стену, прям как твой батя";
   private static final String field24509 = "Унижен, сын ссаной собаки";
   private static final String field24510 = "Сын пидораса, матуху твою зарезал";
   private static final String field24511 = "получил хуём по носу";
   private static final String field24512 = "на колени на колени";
   private static final String field24513 = "был тряхнут в 0";
   private static final String field24514 = "как ты умер??)";
   private static final String field24515 = "твой батек китаец";
   private static final String field24516 = "ну кто тебя убил братишка?)";
   private static final String field24517 = "забери опять у бабки пенсию чтоб задонатить в кубы";
   private static final String field24518 = "твой отец был слаб как и ты";
   private static final String field24519 = "Чувства нет сильнее лени  на колени на колени";
   private static final String field24520 = "с вами приятно иметь деда!";
   private static final String field24521 = "ХАХФАХФА ну ты чел фрик канеш сдох без шансов";
   private static final String field24522 = "Чо бабке в хуй, сдох как олух";
   private static final String field24523 = "Посасал смачной хуяки";
   private static final String field24524 = "Минус любитель сосать писюны";
   private static final String field24525 = "Лох ебаный, слился как бездарь";
   private static final String field24526 = "Бля чел, выйди с игры";
   private static final String field24527 = "начинай оправдываться";
   private static final String field24528 = "че ты голый, я не хотел с тобой пвп";
   private static final String field24529 = "наверное это все изза пинга, так ты скажешь?";
   private static final String field24530 = "позови модера пусть забанит меня(((";
   private static final String field24531 = "не впадай в депрессию только";
   private static final String field24532 = "впервый раз залетел, и всосал";
   private static final String field24533 = "Что с лицом???";
   private static final String field24534 = "Опа сломался ебальничек";
   private static final String field24535 = "Отбил все яйца в клотча";
   private static final String field24536 = "блядь ну ты и еблан конечно конченый ХАХХАХАХА";
   private static final String field24537 = "Сука гетни норм чит и не соси как шлюха";
   private static final String field24538 = "Бля, читер ты, как ты вообще живешь без читов? Ублюдок без мозгов!";
   private static final String field24539 = "Kill Message";
   private static final String field24540 = "KillMessage.json";
   private static final String field24541 = "{\n  \"instruction\": [\n    \"Что-бы добавить свое сообщение напишите через строку так\",\n    \"\",\n    \"Пример 'name' как так можно просто!,\",\n    \"Пример привет 'name' я тебя убил,\",\n    \"\",\n    \"Следущее сообщение и так через запятую\"\n  ],\n  \"messages\": [\n    \"Пример 'name' как так можно просто!\",\n    \"Пример привет 'name' я тебя убил\"\n  ]\n}\n";
   private static final String field24542 = "instruction";
   private static final String field24543 = "\r\n";
   private static final String field24544 = "\n";
   private static final String field24545 = "\n";
   private static final String field24546 = "instruction";
   private static final String field24547 = "\\u0027";
   private static final String field24548 = "'name'";
   private static final String field24549 = "{name}";
   private static final String field24550 = "messages";
   private static final String field24551 = "Свои";
   private static final String field24552 = "Клиентские";
   private static final String field24553 = "Свои";
   private static final String field24554 = "notepad.exe";

   private String method10905(String var1) {
      String[] var2 = this.method10911();
      if (var2.length == 0) {
         return "";
      }

      String sx = var2[RandomUtils.method10453(var2.length)];
      return method10913(sx, var1);
   }

   public KillMessage() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field24213 = new ModeSetting(field24218).method05597(field24219, field24220).method03017(field24221).method03023(this);
      this.field24214 = new ActionSetting(field24222).method03017(() -> {
         try {
            this.method10908();
            Runtime.getRuntime().exec(new String[]{field24554, this.method10909().toAbsolutePath().toString()});
         } catch (IOException var2) {
         }
      }).method03025(() -> this.field24213.method05600(field24553)).method03023(this);
      this.field24215 = new ToggleSetting(field24223).method03014(false).method03025(() -> this.field24213.method05600(field24552)).method03023(this);
      this.field24216 = new String[]{
         field24224,
         field24225,
         field24226,
         field24227,
         field24228,
         field24229,
         field24230,
         field24231,
         field24232,
         field24233,
         field24234,
         field24235,
         field24236,
         field24237,
         field24238,
         field24239,
         field24240,
         field24241,
         field24242,
         field24243,
         field24244,
         field24245,
         field24246,
         field24247,
         field24248,
         field24249,
         field24250,
         field24251,
         field24252,
         field24253,
         field24254,
         field24255,
         field24256,
         field24257,
         field24258,
         field24259,
         field24260,
         field24261,
         field24262,
         field24263,
         field24264,
         field24265,
         field24266,
         field24267,
         field24268,
         field24269,
         field24270,
         field24271,
         field24272,
         field24273,
         field24274,
         field24275,
         field24276,
         field24277,
         field24278,
         field24279,
         field24280,
         field24281,
         field24282,
         field24283,
         field24284,
         field24285,
         field24286,
         field24287,
         field24288,
         field24289,
         field24290,
         field24291,
         field24292,
         field24293,
         field24294,
         field24295,
         field24296,
         field24297,
         field24298,
         field24299,
         field24300,
         field24301,
         field24302,
         field24303,
         field24304,
         field24305,
         field24306,
         field24307,
         field24308,
         field24309,
         field24310,
         field24311,
         field24312,
         field24313,
         field24314,
         field24315,
         field24316,
         field24317,
         field24318,
         field24319,
         field24320,
         field24321,
         field24322,
         field24323,
         field24324,
         field24325,
         field24326,
         field24327,
         field24328,
         field24329,
         field24330,
         field24331,
         field24332,
         field24333,
         field24334,
         field24335,
         field24336,
         field24337,
         field24338,
         field24339,
         field24340,
         field24341,
         field24342,
         field24343,
         field24344,
         field24345,
         field24346,
         field24347,
         field24348,
         field24349,
         field24350,
         field24351,
         field24352,
         field24353,
         field24354,
         field24355,
         field24356,
         field24357,
         field24358,
         field24359,
         field24360,
         field24361,
         field24362,
         field24363,
         field24364,
         field24365,
         field24366,
         field24367,
         field24368,
         field24369,
         field24370,
         field24371,
         field24372,
         field24373,
         field24374,
         field24375,
         field24376,
         field24377,
         field24378,
         field24379,
         field24380,
         field24381,
         field24382,
         field24383,
         field24384,
         field24385,
         field24386,
         field24387,
         field24388,
         field24389,
         field24390,
         field24391,
         field24392,
         field24393,
         field24394,
         field24395,
         field24396,
         field24397,
         field24398,
         field24399,
         field24400,
         field24401,
         field24402,
         field24403,
         field24404,
         field24405,
         field24406,
         field24407,
         field24408,
         field24409,
         field24410,
         field24411,
         field24412,
         field24413,
         field24414,
         field24415,
         field24416,
         field24417,
         field24418,
         field24419,
         field24420,
         field24421,
         field24422,
         field24423,
         field24424,
         field24425,
         field24426,
         field24427,
         field24428,
         field24429,
         field24430,
         field24431,
         field24432,
         field24433,
         field24434,
         field24435,
         field24436,
         field24437,
         field24438,
         field24439,
         field24440,
         field24441,
         field24442,
         field24443,
         field24444,
         field24445,
         field24446,
         field24447,
         field24448,
         field24449,
         field24450,
         field24451,
         field24452,
         field24453,
         field24454,
         field24455,
         field24456,
         field24457,
         field24458,
         field24459,
         field24460,
         field24461,
         field24462,
         field24463,
         field24464,
         field24465,
         field24466,
         field24467,
         field24468,
         field24469,
         field24470,
         field24471,
         field24472,
         field24473,
         field24474,
         field24475,
         field24476,
         field24477,
         field24478,
         field24479,
         field24480,
         field24481,
         field24482,
         field24483,
         field24484,
         field24485,
         field24486,
         field24487,
         field24488,
         field24489,
         field24490,
         field24491,
         field24492,
         field24493,
         field24494,
         field24495,
         field24496,
         field24497,
         field24498,
         field24499,
         field24500,
         field24501,
         field24502,
         field24503,
         field24504,
         field24505,
         field24506,
         field24507,
         field24508,
         field24509,
         field24510,
         field24511,
         field24512,
         field24513,
         field24514,
         field24515,
         field24516,
         field24517,
         field24518,
         field24519,
         field24520,
         field24521,
         field24522,
         field24523,
         field24524,
         field24525,
         field24526,
         field24527,
         field24528,
         field24529,
         field24530,
         field24531,
         field24532,
         field24533,
         field24534,
         field24535,
         field24536,
         field24537,
         field24538
      };
      this.field24217 = null;
      this.method03935(field24539);
   }

   @Subscribe
   public void method10906(PlayerUpdateEvent var1) {
      if (AttackAura.field00785 != null) {
         this.field24217 = AttackAura.field00785;
      }
   }

   private void method10908() throws IOException {
      Path var1 = this.method10909();
      Files.createDirectories(var1.getParent());
      if (Files.notExists(var1)) {
         Files.writeString(var1, field24541, StandardCharsets.UTF_8);
      } else {
         this.method10912(var1);
         this.method10914(var1);
      }
   }

   private Path method10909() {
      return new File(ClientEnvironment.field07577, field24540).toPath();
   }

   private String[] method10911() {
      try {
         this.method10908();
         String var1 = Files.readString(this.method10909(), StandardCharsets.UTF_8);
         JsonElement var2 = JsonParser.parseString(var1);
         if (!var2.isJsonObject()) {
            return new String[0];
         }

         JsonArray var3 = var2.getAsJsonObject().getAsJsonArray(field24550);
         if (var3 == null) {
            return new String[0];
         }

         ArrayList var4 = new ArrayList();

         for (JsonElement var6 : var3) {
            if (var6.isJsonPrimitive() && var6.getAsJsonPrimitive().isString()) {
               String var7 = var6.getAsString().trim();
               if (!var7.isEmpty()) {
                  var4.add(var7);
               }
            }
         }

         return (String[]) var4.toArray(new String[0]);
      } catch (Exception var8) {
         return new String[0];
      }
   }

   private void method10912(Path var1) {
      try {
         String var2 = Files.readString(var1, StandardCharsets.UTF_8);
         JsonElement var3 = JsonParser.parseString(var2);
         if (!var3.isJsonObject()) {
            return;
         }

         JsonObject var4 = var3.getAsJsonObject();
         JsonElement var5 = var4.get(field24542);
         if (var5 == null || !var5.isJsonPrimitive() || !var5.getAsJsonPrimitive().isString()) {
            return;
         }

         String var6 = var5.getAsString().replace(field24543, field24544);
         JsonArray var7 = new JsonArray();

         for (String var11 : var6.split(field24545, -1)) {
            var7.add(var11);
         }

         var4.add(field24546, var7);
         Files.writeString(var1, field24211.toJson(var4), StandardCharsets.UTF_8);
      } catch (Exception var12) {
      }
   }

   private static String method10913(String var0, String var1) {
      return var0.replace(field24548, var1).replace(field24549, var1);
   }

   private void method10914(Path var1) {
      try {
         String var2 = Files.readString(var1, StandardCharsets.UTF_8);
         if (!var2.contains(field24547)) {
            return;
         }

         JsonElement var3 = JsonParser.parseString(var2);
         Files.writeString(var1, field24211.toJson(var3), StandardCharsets.UTF_8);
      } catch (Exception var4) {
      }
   }

   @Subscribe
   private void method10915(EntityDeathEvent var1) {
      Entity var2 = var1.method11303();
      if (!(var2 instanceof LocalPlayer)) {
         if (mc.player != null && mc.level != null) {
            if (this.field24217 != null && var2 == this.field24217) {
               this.field24217 = null;
               String var3 = var2.getName().getString();
               String var4;
               if (this.field24213.method05600(field24551)) {
                  var4 = this.method10905(var3);
               } else if (this.field24215.method03022()) {
                  var4 = "-ezz " + var3 + " " + this.field24216[RandomUtils.method10453(this.field24216.length)];
               } else {
                  var4 = "-ezz " + var3;
               }

               ChatTextUtils.method05080(("! " + var4).trim());
            }
         }
      }
   }
}
