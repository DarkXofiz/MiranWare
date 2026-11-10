// Original binary: sg/ec/5cGX03XlGtwK8rgS
package sg.ec;

import com.mojang.brigadier.arguments.ArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.List;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public abstract class AbstractCommand implements MinecraftAccess {
   private final CommandInfo field02515 = this.getClass().getAnnotation(CommandInfo.class);
   private static final String field02516 = "у этой команды отсутствует подсказки!";

   public abstract void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1);

   @Override
   public String toString() {
      return "AbstractCommand(info=" + this.method01189() + ")";
   }

   protected <T> RequiredArgumentBuilder<ClientSuggestionProvider, T> method01184(String var1, ArgumentType<T> var2) {
      return RequiredArgumentBuilder.argument(var1, var2);
   }

   public List<Component> method01185() {
      return List.of(Component.literal(field02516));
   }

   protected boolean method01186(Object var1) {
      return var1 instanceof AbstractCommand;
   }

   @Override
   public int hashCode() {
      byte var1 = 59;
      byte var2 = 1;
      CommandInfo var3 = this.method01189();
      return var2 * 59 + (var3 == null ? 43 : var3.hashCode());
   }

   public void method01187(String var1) {
      ChatTextUtils.method05098(Component.literal(var1));
   }

   protected LiteralArgumentBuilder<ClientSuggestionProvider> method01188(String var1) {
      return LiteralArgumentBuilder.literal(var1);
   }

   public CommandInfo method01189() {
      return this.field02515;
   }

   @Override
   public boolean equals(Object var1) {
      if (var1 == this) {
         return true;
      } else if (!(var1 instanceof AbstractCommand var2)) {
         return false;
      } else {
         if (!var2.method01186(this)) {
            return false;
         }

         CommandInfo var3 = this.method01189();
         CommandInfo var4 = var2.method01189();
         return var3 == null ? var4 == null : var3.equals(var4);
      }
   }
}
