// Original binary: sg/ec/aXuvKUi37YsuhJi9
package sg.ec;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import net.minecraft.ChatFormatting;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;

// $VF: Compiled from s
@CommandInfo(name = "party", description = "")
public class PartyCommand extends AbstractCommand {
   private static final String field15640 = "create";
   private static final String field15641 = "name";
   private static final String field15642 = "invite";
   private static final String field15643 = "name";
   private static final String field15644 = "chat";
   private static final String field15645 = "message";
   private static final String field15646 = "kick";
   private static final String field15647 = "name";
   private static final String field15648 = "reason";
   private static final String field15649 = "info";
   private static final String field15650 = "leave";
   private static final String field15651 = "back";
   private static final String field15652 = "disband";
   private static final String field15653 = "accept";
   private static final String field15654 = "name";
   private static final String field15655 = "deny";
   private static final String field15656 = "name";
   private static final String field15657 = "name";
   private static final String field15658 = "name";
   private static final String field15659 = "Вы не состоите в Party.";
   private static final String field15660 = "Вы не состоите в Party.";
   private static final String field15661 = "Вы не состоите в Party.";
   private static final String field15662 = "Вы не состоите в Party.";
   private static final String field15663 = "name";
   private static final String field15664 = "reason";
   private static final String field15665 = "Вы не состоите в Party.";
   private static final String field15666 = "message";
   private static final String field15667 = "Вы не состоите в Party.";
   private static final String field15668 = "name";
   private static final String field15669 = "name";

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      var1.then(this.method01188(field15640).then(this.method01184(field15641, StringArgumentType.string()).executes(var0 -> {
         if (MiranWare.getInstance().getClient() == null) {
            return 1;
         }

         GlobalConnectionManager.method03852(new PartyCreateC2SPacket(GlobalConnectionManager.method03858(), StringArgumentType.getString(var0, field15669)));
         return 1;
      })));
      var1.then(
         this.method01188(field15642)
            .then(
               this.method01184(field15643, StringArgumentType.word())
                  .executes(
                     var1x -> {
                        if (MiranWare.getInstance().getClient() == null) {
                           return 1;
                        } else {
                           Party var2 = MiranWare.getInstance().getClient().getManager().method01805();
                           if (var2 == null) {
                              this.method01187(field15667);
                              return 1;
                           } else {
                              PartyMember var3 = var2.method10151(var0 -> var0.method05943() == PartyRole.OWNER);
                              if (var3 == null) {
                                 return 1;
                              } else if (var3.method07586().equalsIgnoreCase(MiranWare.getInstance().getClient().getClientPlayer().method07586())
                                 && var3.method07590().equals(MiranWare.getInstance().getClient().getClientPlayer().method07590())) {
                                 GlobalConnectionManager.method03852(
                                    new PartyInviteC2SPacket(var3, StringArgumentType.getString(var1x, field15668), var2.method10149())
                                 );
                                 return 1;
                              } else {
                                 return 1;
                              }
                           }
                        }
                     }
                  )
            )
      );
      var1.then(
         this.method01188(field15644)
            .then(
               this.method01184(field15645, StringArgumentType.greedyString())
                  .executes(
                     var1x -> {
                        if (MiranWare.getInstance().getClient() == null) {
                           return 1;
                        }

                        Party var2 = MiranWare.getInstance().getClient().getManager().method01805();
                        if (var2 == null) {
                           this.method01187(field15665);
                           return 1;
                        }

                        PartyMember var3 = var2.method10151(var0 -> var0.method07566(MiranWare.getInstance().getClient().getClientPlayer()));
                        if (var3 == null) {
                           return 1;
                        }

                        GlobalConnectionManager.method03852(
                           new PartyCommandC2SPacket(
                              GlobalConnectionManager.method03858(),
                              var2.method10149(),
                              PartyCommandC2SPacket.Nested301.Chat,
                              StringArgumentType.getString(var1x, field15666)
                           )
                        );
                        return 1;
                     }
                  )
            )
      );
      var1.then(
         this.method01188(field15646)
            .then(
               this.method01184(field15647, new PartyMemberArgument(false))
                  .then(
                     this.method01184(field15648, StringArgumentType.greedyString())
                        .executes(
                           var1x -> {
                              if (MiranWare.getInstance().getClient() == null) {
                                 return 1;
                              }

                              Party var2 = MiranWare.getInstance().getClient().getManager().method01805();
                              if (var2 == null) {
                                 this.method01187(field15662);
                                 return 1;
                              }

                              PartyMember var3 = var2.method10151(var0 -> var0.method05943() == PartyRole.OWNER);
                              if (var3 == null) {
                                 return 1;
                              }

                              if (var3.method07586().equalsIgnoreCase(MiranWare.getInstance().getClient().getClientPlayer().method07586())
                                 && var3.method07590().equals(MiranWare.getInstance().getClient().getClientPlayer().method07590())) {
                                 PartyMember var4 = (PartyMember)var1x.getArgument(field15663, PartyMember.class);
                                 PartyMember var5 = var2.method10151(
                                    var1xx -> var1xx.method05943() != PartyRole.OWNER && var1xx.method07586().equalsIgnoreCase(var4.method07586())
                                 );
                                 if (var5 == null) {
                                    return 1;
                                 }

                                 GlobalConnectionManager.method03852(
                                    new PartyKickC2SPacket(var3, var5, var2.method10149(), StringArgumentType.getString(var1x, field15664))
                                 );
                                 return 1;
                              } else {
                                 return 1;
                              }
                           }
                        )
                  )
            )
      );
      var1.then(
         this.method01188(field15649)
            .executes(
               var1x -> {
                  if (MiranWare.getInstance().getClient() == null) {
                     return 1;
                  }

                  Party var2 = MiranWare.getInstance().getClient().getManager().method01805();
                  if (var2 == null) {
                     this.method01187(field15661);
                     return 1;
                  }

                  this.method01187(
                     ChatFormatting.GRAY
                        + "Название команды '"
                        + ChatFormatting.GREEN
                        + var2.method10149()
                        + ChatFormatting.GRAY
                        + "'"
                        + ChatFormatting.RESET
                        + ":"
                  );

                  for (PartyMember var4 : var2.method10148()) {
                     String var5 = ChatFormatting.GRAY + "[" + var4.method07584() + "] " + ChatFormatting.RESET;
                     this.method01187(var5 + var4.method07586() + ChatFormatting.GRAY + " Роль: \"" + var4.method05943().name() + "\"");
                  }

                  return 1;
               }
            )
      );
      var1.then(this.method01188(field15650).executes(var1x -> {
         if (MiranWare.getInstance().getClient() == null) {
            return 1;
         }

         Party var2 = MiranWare.getInstance().getClient().getManager().method01805();
         if (var2 == null) {
            this.method01187(field15660);
            return 1;
         }

         PartyMember var3 = var2.method10151(var0 -> var0.method07566(MiranWare.getInstance().getClient().getClientPlayer()));
         if (var3 == null) {
            return 1;
         }

         GlobalConnectionManager.method03852(new PartyLeaveC2SPacket(var3));
         return 1;
      }));
      var1.then(this.method01188(field15651).executes(var0 -> {
         if (MiranWare.getInstance().getClient() == null) {
            return 1;
         }

         Party var1x = MiranWare.getInstance().getClient().getManager().method01805();
         if (var1x != null) {
            return 1;
         }

         GlobalConnectionManager.method03852(new PartyCommandC2SPacket(GlobalConnectionManager.method03858(), "", PartyCommandC2SPacket.Nested301.Back));
         return 1;
      }));
      var1.then(this.method01188(field15652).executes(var1x -> {
         if (MiranWare.getInstance().getClient() == null) {
            return 1;
         }

         Party var2 = MiranWare.getInstance().getClient().getManager().method01805();
         if (var2 == null) {
            this.method01187(field15659);
            return 1;
         }

         PartyMember var3 = var2.method10151(var0 -> var0.method07566(MiranWare.getInstance().getClient().getClientPlayer()));
         if (var3 == null) {
            return 1;
         }

         GlobalConnectionManager.method03852(new PartyDisbandC2SPacket(var3, var2.method10149()));
         return 1;
      }));
      var1.then(
         this.method01188(field15653)
            .then(
               this.method01184(field15654, StringArgumentType.greedyString())
                  .executes(
                     var0 -> {
                        if (MiranWare.getInstance().getClient() == null) {
                           return 1;
                        }

                        Party var1x = MiranWare.getInstance().getClient().getManager().method01805();
                        if (var1x != null) {
                           return 1;
                        }

                        GlobalConnectionManager.method03852(
                           new PartyCommandC2SPacket(
                              GlobalConnectionManager.method03858(), StringArgumentType.getString(var0, field15658), PartyCommandC2SPacket.Nested301.Accept
                           )
                        );
                        return 1;
                     }
                  )
            )
      );
      var1.then(
         this.method01188(field15655)
            .then(
               this.method01184(field15656, StringArgumentType.greedyString())
                  .executes(
                     var0 -> {
                        if (MiranWare.getInstance().getClient() == null) {
                           return 1;
                        }

                        Party var1x = MiranWare.getInstance().getClient().getManager().method01805();
                        if (var1x != null) {
                           return 1;
                        }

                        GlobalConnectionManager.method03852(
                           new PartyCommandC2SPacket(
                              GlobalConnectionManager.method03858(), StringArgumentType.getString(var0, field15657), PartyCommandC2SPacket.Nested301.Deny
                           )
                        );
                        return 1;
                     }
                  )
            )
      );
   }
}
