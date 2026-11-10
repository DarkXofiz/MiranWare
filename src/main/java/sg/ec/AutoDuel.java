// Original binary: sg/ec/8cHWWd6LxVzJCSZm
package sg.ec;

import com.google.common.collect.Lists;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.regex.Pattern;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.multiplayer.PlayerInfo;
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket;
import net.minecraft.world.inventory.ChestMenu;
import net.minecraft.world.inventory.ClickType;

// $VF: Compiled from s
public class AutoDuel extends ClientModule {
   private static final Pattern field05060 = Pattern.compile(AutoDuel.field05096);
   private final MultiToggleSetting field05061;
   private double field05062;
   private double field05063;
   private double field05064;
   private final List<String> field05065;
   private final ElapsedTimer field05066;
   private final ElapsedTimer field05067;
   private final ElapsedTimer field05068;
   private final ElapsedTimer field05069;
   private final Random field05070;
   private static final String field05071 = "Mode";
   private static final String field05072 = "Щит";
   private static final String field05073 = "Шипы 3";
   private static final String field05074 = "Лук";
   private static final String field05075 = "Тотемы";
   private static final String field05076 = "Nodebaff";
   private static final String field05077 = "Шары";
   private static final String field05078 = "Классик";
   private static final String field05079 = "Чит рай";
   private static final String field05080 = "Незеритка";
   private static final String field05081 = "Мега кит";
   private static final String field05082 = "Сильный полет";
   private static final String field05083 = "Выбор режимов";
   private static final String field05084 = "Auto Duel";
   private static final double field05085 = 500.0;
   private static final long field05086 = 800L;
   private static final long field05087 = 550L;
   private static final String field05088 = "Выбор набора (1/1)";
   private static final long field05089 = 150L;
   private static final String field05090 = "Настройка поединка";
   private static final long field05091 = 150L;
   private static final String field05092 = "начало";
   private static final String field05093 = "через";
   private static final String field05094 = "секунд!";
   private static final String field05095 = "дуэли » во время поединка запрещено использовать команды";
   private static final String field05096 = "^\\w{3,16}$";

   @Subscribe
   private void method02125(PacketEvent var1) {
      if (var1.method10904() && var1.method10897() instanceof ClientboundSystemChatPacket var3) {
         String sx = var3.content().getString().toLowerCase();
         if (sx.contains(field05092) && sx.contains(field05093) && sx.contains(field05094) || sx.equals(field05095)) {
            this.method00382();
         }
      }
   }

   public AutoDuel() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field05061 = new MultiToggleSetting(field05071)
         .method04517(NamedOption.method08077(field05072, true))
         .method04517(NamedOption.method08077(field05073, false))
         .method04517(NamedOption.method08077(field05074, false))
         .method04517(NamedOption.method08077(field05075, false))
         .method04517(NamedOption.method08077(field05076, false))
         .method04517(NamedOption.method08077(field05077, false))
         .method04517(NamedOption.method08077(field05078, false))
         .method04517(NamedOption.method08077(field05079, false))
         .method04517(NamedOption.method08077(field05080, false))
         .method04517(NamedOption.method08077(field05081, false))
         .method04517(NamedOption.method08077(field05082, false))
         .method03018(field05083)
         .method03023(this);
      this.field05065 = Lists.newArrayList();
      this.field05066 = new ElapsedTimer();
      this.field05067 = new ElapsedTimer();
      this.field05068 = new ElapsedTimer();
      this.field05069 = new ElapsedTimer();
      this.field05070 = new Random();
      this.method03935(field05084);
   }

   private List<String> method02126() {
      ArrayList var1 = new ArrayList();
      if (mc.player != null && mc.player.connection != null) {
         for (PlayerInfo var3 : mc.player.connection.getOnlinePlayers()) {
            String var4 = var3.getProfile().name();
            if (field05060.matcher(var4).matches()) {
               var1.add(var4);
            }
         }

         return var1;
      } else {
         return var1;
      }
   }

   @Subscribe
   private void method02127(PlayerUpdateEvent var1) {
      var var2 = this.method02126();
      double var3 = GuiHitTestUtils.method05620(this.field05062, this.field05063, this.field05064, mc.player.getX(), mc.player.getY(), mc.player.getZ());
      if (var3 > field05085) {
         this.method00382();
      }

      this.field05062 = mc.player.getX();
      this.field05063 = mc.player.getY();
      this.field05064 = mc.player.getZ();
      if (this.field05067.method04699(field05086 * var2.size())) {
         this.field05065.clear();
         this.field05067.method04694();
      }

      if (mc.gui.screen() == null) {
         for (String var6 : var2) {
            int var7 = this.field05070.nextInt(var2.size());
            String var8 = (String)var2.get(var7);
            if (!this.field05065.contains(var8) && !var8.equals(mc.getUser().getName()) && this.field05066.method04699(field05087)) {
               ChatTextUtils.method05080("/duel " + var8);
               this.field05065.add(var8);
               this.field05066.method04694();
            }
         }
      }

      if (mc.gui.screen() instanceof AbstractContainerScreen var11) {
         if (var11.getTitle().getString().contains(field05088)) {
            if (var11.getMenu() instanceof ChestMenu var13) {
               ArrayList var16 = new ArrayList();
               int var18 = 0;

               for (NamedOption var10 : this.field05061.method03022()) {
                  if ((Boolean)var10.method08074()) {
                     var16.add(var18);
                  }

                  var18++;
               }

               Collections.shuffle(var16, GuiHitTestUtils.field11989);
               if (var16.isEmpty()) {
                  return;
               }

               int var19 = (Integer)var16.getFirst();
               if (this.field05068.method04699(field05089)) {
                  mc.gameMode.handleContainerInput(var13.containerId, var19, 0, ClickType.PICKUP, mc.player);
                  this.field05068.method04694();
               }
            }
         } else if (var11.getTitle().getString().contains(field05090) && this.field05069.method04699(field05091) && var11.getMenu() instanceof ChestMenu var14) {
            mc.gameMode.handleContainerInput(var14.containerId, 0, 0, ClickType.PICKUP, mc.player);
            this.field05069.method04694();
         }
      }
   }
}
