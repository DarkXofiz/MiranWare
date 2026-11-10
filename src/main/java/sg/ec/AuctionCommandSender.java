// Original binary: sg/ec/IaiQtpDeL05Gtnn7
package sg.ec;

import com.mojang.brigadier.CommandDispatcher;
import com.mojang.brigadier.StringReader;
import com.mojang.brigadier.suggestion.Suggestions;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ThreadLocalRandom;
import net.minecraft.client.gui.screens.ChatScreen;
import net.minecraft.client.multiplayer.ClientPacketListener;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;

// $VF: Compiled from s
public final class AuctionCommandSender implements MinecraftAccess {
   public static final AuctionCommandSender field08741 = new AuctionCommandSender();
   private static final int field08742 = 8;
   private static final long field08743 = 0;
   private static final long field08744 = 0;
   private static final long field08745 = 0;
   private final Deque<String> field08746 = new ArrayDeque<>();
   private AuctionCommandSender.Nested113 field08747 = AuctionCommandSender.Nested113.IDLE;
   private String field08748 = "";
   private CompletableFuture<Suggestions> field08749;
   private long field08750;
   private long field08751;
   private static final long field08752 = 1500L;
   private static final long field08753 = 45L;
   private static final long field08754 = 95L;
   private static final String field08755 = "/";

   public void method03889() {
      this.field08746.clear();
      this.field08747 = AuctionCommandSender.Nested113.IDLE;
      this.field08748 = "";
      this.field08749 = null;
   }

   private static CompletableFuture<Suggestions> method03890(String var0) {
      ClientPacketListener var1 = mc.player.connection;
      CommandDispatcher var2 = var1.getCommands();
      ClientSuggestionProvider var3 = var1.getSuggestionsProvider();
      CompletableFuture var4 = null;

      for (int var5 = 1; var5 <= var0.length(); var5++) {
         StringReader var6 = new StringReader(var0.substring(0, var5));
         var6.skip();
         var4 = var2.getCompletionSuggestions(var2.parse(var6, var3), var5);
      }

      return var4;
   }

   private void method03891(long var1) {
      if (!this.field08746.isEmpty() && (mc.gui == null || !(mc.gui.screen() instanceof ChatScreen))) {
         this.field08748 = method03896(this.field08746.pollFirst());
         this.field08749 = method03890("/" + this.field08748);
         this.field08747 = AuctionCommandSender.Nested113.SUGGEST;
         this.field08751 = var1 + field08752;
      }
   }

   public boolean method03892() {
      return this.field08747 != AuctionCommandSender.Nested113.IDLE;
   }

   public void method03893(String var1) {
      if (var1 != null && !var1.isBlank() && this.field08746.size() < 8) {
         this.field08746.addLast(var1.trim());
      }
   }

   private void method03894(long var1) {
      if (this.field08749 == null || this.field08749.isDone() || var1 >= this.field08751) {
         this.field08749 = null;
         this.field08747 = AuctionCommandSender.Nested113.SUBMIT;
         this.field08750 = var1 + method03897(field08753, field08754);
      }
   }

   public void method03895(long var1) {
      if (mc.player != null && mc.player.connection != null) {
         switch (this.field08747) {
            case IDLE:
               this.method03891(var1);
               break;
            case SUGGEST:
               this.method03894(var1);
               break;
            case SUBMIT:
               this.method03898(var1);
         }
      } else {
         this.method03889();
      }
   }

   private static String method03896(String var0) {
      return var0.startsWith(field08755) ? var0.substring(1) : var0;
   }

   private static long method03897(long var0, long var2) {
      return ThreadLocalRandom.current().nextLong(var0, var2 + 1L);
   }

   private void method03898(long var1) {
      if (var1 >= this.field08750) {
         mc.player.connection.sendCommand(this.field08748);
         this.field08748 = "";
         this.field08747 = AuctionCommandSender.Nested113.IDLE;
      }
   }

   private AuctionCommandSender() {
   }

   // $VF: Compiled from s
   private enum Nested113 {
      IDLE,
      SUGGEST,
      SUBMIT;
   }
}
