// Original binary: sg/ec/T4OLCxcS5v0i4bKM
package sg.ec;

import com.mojang.brigadier.arguments.StringArgumentType;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import com.mojang.brigadier.suggestion.Suggestions;
import com.mojang.brigadier.suggestion.SuggestionsBuilder;
import hex.script.api.Command;
import hex.script.api.CommandContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.CompletableFuture;
import net.minecraft.ChatFormatting;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.network.chat.Component;

// $VF: Compiled from s
public final class CommandLineParser {
   private static final Map<String, CommandLineParser.Nested171> field11981 = new LinkedHashMap<>();
   private static final String field11982 = "args";
   private static final String field11983 = "\\s+";
   private static final String field11984 = "This is a utility class and cannot be instantiated";
   private static final String field11985 = "args";

   private static int method05584(Object var0, Command var1, String var2, String var3) {
      List var4 = new ArrayList<>();

      for (String sx : var3.trim().split(field11983)) {
         if (!sx.isEmpty()) {
            var4.add(sx);
         }
      }

      ScriptSourceLoader sx = ScriptLifecycle.method03294(var0);

      try {
         var1.handler().run(new CommandContext(var2, var4, var1.usage(), CommandLineParser::method05595));
      } catch (Throwable sxx) {
         String sxxx = sxx.getMessage();
         method05595(var2, ChatFormatting.RED + (sxxx == null ? sxx.getClass().getSimpleName() : sxxx));
      } finally {
         ScriptLifecycle.method03293(sx);
      }

      return 1;
   }

   public static List<LiteralArgumentBuilder<ClientSuggestionProvider>> method05586() {
      ArrayList var0 = new ArrayList();

      for (var var2 : field11981.entrySet()) {
         var0.add(
            method05592(
               ((CommandLineParser.Nested171)var2.getValue()).field11986,
               (String)var2.getKey(),
               ((CommandLineParser.Nested171)var2.getValue()).field11987,
               (String)var2.getKey()
            )
         );
      }

      return var0;
   }

   public static List<String> method05587() {
      return List.copyOf(field11981.keySet());
   }

   public static void method05588(Object var0) {
      boolean var1 = false;
      var var2 = field11981.entrySet().iterator();

      while (var2.hasNext()) {
         if (((CommandLineParser.Nested171)((Entry)var2.next()).getValue()).field11986 == var0) {
            var2.remove();
            var1 = true;
         }
      }

      if (var1) {
         CommandManager.INSTANCE.method04644();
      }
   }

   private static boolean method05590(Object var0, String var1) {
      CommandLineParser.Nested171 var2 = field11981.get(var1);
      return var2 != null && var2.field11986 != var0 ? true : CommandManager.INSTANCE.method04654().getRoot().getChild(var1) != null && var2 == null;
   }

   private static LiteralArgumentBuilder<ClientSuggestionProvider> method05592(Object var0, String var1, Command var2, String var3) {
      LiteralArgumentBuilder var4 = LiteralArgumentBuilder.literal(var1);
      if (var2.handler() != null) {
         var4.executes(var3x -> method05584(var0, var2, var3, ""));
         var4.then(
            RequiredArgumentBuilder.argument(field11982, StringArgumentType.greedyString())
               .suggests((var1x, var2x) -> method05594(var2, var2x))
               .executes(var3x -> method05584(var0, var2, var3, (String)var3x.getArgument(field11985, String.class)))
         );
      }

      for (var var6 : var2.subs().entrySet()) {
         var4.then(method05592(var0, (String)var6.getKey(), (Command)var6.getValue(), var3 + " " + (String)var6.getKey()));
      }

      return var4;
   }

   public static void method05593(Object var0, Command var1) {
      if (var0 != null && var1 != null) {
         ArrayList var2 = new ArrayList();
         var2.add(var1.name());
         var2.addAll(var1.aliases());

         for (String var4 : (Iterable<String>) (Iterable) var2) {
            if (method05590(var0, var4)) {
               ChatTextUtils.method05098(Component.literal(ChatFormatting.RED + "[script] имя ." + var4 + " уже занято"));
               return;
            }
         }

         for (String var6 : (Iterable<String>) (Iterable) var2) {
            field11981.put(var6, new CommandLineParser.Nested171(var0, var1));
         }

         CommandManager.INSTANCE.method04644();
      }
   }

   private static CompletableFuture<Suggestions> method05594(Command var0, SuggestionsBuilder var1) {
      String var2 = var1.getRemaining();
      int var3 = 0;
      int var4 = 0;

      for (int var5 = 0; var5 < var2.length(); var5++) {
         if (var2.charAt(var5) == ' ') {
            var3++;
            var4 = var5 + 1;
         }
      }

      String var9 = var2.substring(var4).toLowerCase();
      SuggestionsBuilder var6 = var1.createOffset(var1.getStart() + var4);

      for (String var8 : var0.complete(var3)) {
         if (var8 != null && var8.toLowerCase().startsWith(var9)) {
            var6.suggest(var8);
         }
      }

      return var6.buildFuture();
   }

   private CommandLineParser() {
      throw new UnsupportedOperationException(field11984);
   }

   private static void method05595(String var0, String var1) {
      ChatTextUtils.method05098(Component.literal(ChatFormatting.GRAY + "[" + var0 + "] " + ChatFormatting.RESET + var1));
   }

   // $VF: Compiled from s
   private static final class Nested171 {
      private final Object field11986;
      private final Command field11987;

      private Nested171(Object var1, Command var2) {
         this.field11986 = var1;
         this.field11987 = var2;
      }
   }
}
