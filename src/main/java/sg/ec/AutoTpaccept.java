// Original binary: sg/ec/tJli7XVDQCBWbYMo
package sg.ec;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.network.protocol.game.ClientboundSystemChatPacket;

// $VF: Compiled from s
public class AutoTpaccept extends ClientModule {
   private final ToggleSetting field23855;
   private final ToggleSetting field23856;
   private static final long field23857 = 1500L;
   private static final int field23858 = 0;
   private static final String field23859 = "field23859";
   private static final String field23860 = "field23860";
   private static final Pattern field23861 = Pattern.compile(AutoTpaccept.field23886);
   private static final Pattern[] field23862 = new Pattern[]{
      Pattern.compile(AutoTpaccept.field23887, 66),
      Pattern.compile(AutoTpaccept.field23888, 66),
      Pattern.compile(AutoTpaccept.field23889, 66),
      Pattern.compile(AutoTpaccept.field23890, 66),
      Pattern.compile(AutoTpaccept.field23891, 66),
      Pattern.compile(AutoTpaccept.field23892, 66),
      Pattern.compile(AutoTpaccept.field23893, 66)
   };
   private final ElapsedTimer field23863;
   private static final String field23864 = "Только друзья";
   private static final String field23865 = "Принимать запрос, только если ник есть в списке друзей";
   private static final String field23866 = "Принимать по нику";
   private static final String field23867 = "Выключено — отправляет просто /tpaccept без ника";
   private static final String field23868 = "Auto Tpaccept";
   private static final long field23869 = 1500L;
   private static final String field23870 = "/tpaccept";
   private static final String field23871 = "вы отправили";
   private static final String field23872 = "вы запросили";
   private static final String field23873 = "вы телепорт";
   private static final String field23874 = "запрос отправлен";
   private static final String field23875 = "you sent";
   private static final String field23876 = "request sent";
   private static final String field23877 = "телепорт";
   private static final String field23878 = "teleport";
   private static final String field23879 = "/tpaccept";
   private static final String field23880 = "запрос";
   private static final String field23881 = "просит";
   private static final String field23882 = "хочет";
   private static final String field23883 = "к вам";
   private static final String field23884 = "к тебе";
   private static final String field23885 = "to you";
   private static final String field23886 = "§[0-9a-fk-orA-FK-OR]";
   private static final String field23887 = "(\\w{3,16})[\\s'\"«»\\[\\]()<>:,.\\-]{1,4}(?:просит|хочет|желает|запрашивает)[^\\n]{0,40}?телепорт";
   private static final String field23888 = "(\\w{3,16})[\\s'\"«»\\[\\]()<>:,.\\-]{1,4}отправил[^\\n]{0,30}?запрос[^\\n]{0,20}?телепорт";
   private static final String field23889 = "(\\w{3,16})[\\s'\"«»\\[\\]()<>:,.\\-]{1,4}(?:tpa|тпа)[\\s'\"«»\\[\\]()<>:,.\\-]{1,4}(?:к вам|к тебе|to you)";
   private static final String field23890 = "(\\w{3,16})[\\s'\"«»\\[\\]()<>:,.\\-]{1,4}(?:has\\s+)?request(?:ed|s)?[^\\n]{0,30}?teleport";
   private static final String field23891 = "(\\w{3,16})[\\s'\"«»\\[\\]()<>:,.\\-]{1,4}wants?[\\s'\"«»\\[\\]()<>:,.\\-]{1,4}to[\\s'\"«»\\[\\]()<>:,.\\-]{1,4}teleport";
   private static final String field23892 = "телепорт[^\\n]{0,40}?(?:от игрока|игрока|от)[\\s'\"«»\\[\\]()<>:,.\\-]{1,4}(\\w{3,16})";
   private static final String field23893 = "запрос[^\\n]{0,30}?телепорт[^\\n]{0,30}?от[\\s'\"«»\\[\\]()<>:,.\\-]{1,4}(\\w{3,16})";

   private String method10814(String var1) {
      for (Pattern var5 : field23862) {
         Matcher sx = var5.matcher(var1);
         if (sx.find()) {
            String sxx = sx.group(1);
            if (TextRenderUtils.method00673(sxx)) {
               return sxx;
            }
         }
      }

      return null;
   }

   private boolean method10815(String var1) {
      String var2 = var1.toLowerCase();
      return !var2.contains(field23877) && !var2.contains(field23878)
         ? false
         : var2.contains(field23879)
            || var2.contains(field23880)
            || var2.contains(field23881)
            || var2.contains(field23882)
            || var2.contains(field23883)
            || var2.contains(field23884)
            || var2.contains(field23885);
   }

   @Subscribe
   private void method10816(PacketEvent var1) {
      if (var1.method10904() && mc.player != null) {
         if (var1.method10897() instanceof ClientboundSystemChatPacket var2) {
            String var7 = field23861.matcher(var2.content().getString()).replaceAll("");
            if (!this.method10818(var7)) {
               String var4 = this.method10814(var7);
               if (var4 != null || this.method10815(var7)) {
                  if (var4 == null || !var4.equalsIgnoreCase(mc.player.getGameProfile().name())) {
                     boolean var5 = this.field23855.method05999();
                     if (!var5 || var4 != null && FriendManager.INSTANCE.method00175(var4) != null) {
                        if (this.field23863.method04699(field23869)) {
                           this.field23863.method04694();
                           boolean var6 = var4 != null && (var5 || this.field23856.method05999());
                           ChatTextUtils.method05093(var6 ? "/tpaccept " + var4 : field23870, null);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private boolean method10818(String var1) {
      String var2 = var1.toLowerCase();
      return var2.contains(field23871)
         || var2.contains(field23872)
         || var2.contains(field23873)
         || var2.contains(field23874)
         || var2.contains(field23875)
         || var2.contains(field23876);
   }

   public AutoTpaccept() {
      super(ModuleCategory.Misc, ModuleSubCategory.Servers);
      this.field23855 = new ToggleSetting(field23864).method03017(true).method03018(field23865).method03023(this);
      this.field23856 = new ToggleSetting(field23866)
         .method03017(true)
         .method03018(field23867)
         .method03025(() -> !this.field23855.method05999())
         .method03023(this);
      this.field23863 = new ElapsedTimer();
      this.method03935(field23868);
   }

   @Override
   public void method00245() {
      this.field23863.method04694();
      super.method00245();
   }
}
