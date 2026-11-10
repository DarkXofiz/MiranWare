// Original binary: hex/api/baritone/api/command/helpers/Paginator
package hex.api.baritone.api.command.helpers;

import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidTypeException;
import hex.api.baritone.api.utils.Helper;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.ClickEvent.RunCommand;
import net.minecraft.network.chat.HoverEvent.ShowText;

// $VF: Compiled from s
public class Paginator<E> implements Helper {
   public final List<E> entries;
   public int pageSize = 8;
   public int page = 1;
   private static final String бпп = "бпп";
   private static final String бп2 = "бп2";
   private static final String бп西 = "бп西";
   private static final String бпт = "бпт";
   private static final String бпд = "бпд";
   private static final String бпе = "бпе";
   private static final String бп6 = "бп6";
   private static final String бпl = "бпl";
   private static final String бп必 = "бп必";
   private static final String бпЗ = "бпЗ";

   public Paginator<E> skipPages(int var1) {
      this.page += var1;
      return this;
   }

   public static <T> void paginate(IArgConsumer var0, Paginator<T> var1, Function<T, Component> var2) throws CommandException {
      paginate(var0, var1, null, var2, null);
   }

   public static <T> void paginate(IArgConsumer var0, List<T> var1, Runnable var2, Function<T, Component> var3) throws CommandException {
      paginate(var0, new Paginator<>(var1), var2, var3, null);
   }


   public void display(Function<E, Component> var1, String var2) {
      int var3 = (this.page - 1) * this.pageSize;

      for (int sx = var3; sx < var3 + this.pageSize; sx++) {
         if (sx < this.entries.size()) {
            this.logDirect(var1.apply(this.entries.get(sx)));
         } else {
            this.logDirect(бпп, ChatFormatting.DARK_GRAY);
         }
      }

      boolean sx = var2 != null && this.validPage(this.page - 1);
      boolean sxx = var2 != null && this.validPage(this.page + 1);
      MutableComponent sxxx = Component.literal(бп2);
      if (sx) {
         sxxx.setStyle(
            sxxx.getStyle().withClickEvent(new RunCommand(String.format(бп西, var2, this.page - 1))).withHoverEvent(new ShowText(Component.literal(бпт)))
         );
      } else {
         sxxx.setStyle(sxxx.getStyle().withColor(ChatFormatting.DARK_GRAY));
      }

      MutableComponent sxxxx = Component.literal(бпд);
      if (sxx) {
         sxxxx.setStyle(
            sxxxx.getStyle().withClickEvent(new RunCommand(String.format(бпе, var2, this.page + 1))).withHoverEvent(new ShowText(Component.literal(бп6)))
         );
      } else {
         sxxxx.setStyle(sxxxx.getStyle().withColor(ChatFormatting.DARK_GRAY));
      }

      MutableComponent sxxxxx = Component.literal("");
      sxxxxx.setStyle(sxxxxx.getStyle().withColor(ChatFormatting.GRAY));
      sxxxxx.append(sxxx);
      sxxxxx.append(бпl);
      sxxxxx.append(sxxxx);
      sxxxxx.append(String.format(бп必, this.page, this.getMaxPage()));
      this.logDirect(sxxxxx);
   }

   public static <T> void paginate(IArgConsumer var0, T[] var1, Runnable var2, Function<T, Component> var3) throws CommandException {
      paginate(var0, Arrays.asList(var1), var2, var3, null);
   }

   public static <T> void paginate(IArgConsumer var0, Paginator<T> var1, Function<T, Component> var2, String var3) throws CommandException {
      paginate(var0, var1, null, var2, var3);
   }

   public Paginator(E... var1) {
      this.entries = Arrays.asList(var1);
   }

   public static <T> void paginate(IArgConsumer var0, T[] var1, Function<T, Component> var2, String var3) throws CommandException {
      paginate(var0, Arrays.asList(var1), null, var2, var3);
   }

   public static <T> void paginate(IArgConsumer var0, T[] var1, Function<T, Component> var2) throws CommandException {
      paginate(var0, Arrays.asList(var1), null, var2, null);
   }

   public static <T> void paginate(IArgConsumer var0, List<T> var1, Function<T, Component> var2) throws CommandException {
      paginate(var0, new Paginator<>(var1), null, var2, null);
   }

   public static <T> void paginate(IArgConsumer var0, Paginator<T> var1, Runnable var2, Function<T, Component> var3, String var4) throws CommandException {
      int var5 = 1;
      var0.requireMax(1);
      if (var0.hasAny()) {
         var5 = var0.getAs(Integer.class);
         if (!var1.validPage(var5)) {
            throw new CommandInvalidTypeException(var0.consumed(), String.format(бпЗ, var1.getMaxPage()), var0.consumed().getValue());
         }
      }

      var1.skipPages(var5 - var1.page);
      if (var2 != null) {
         var2.run();
      }

      var1.display(var3, var4);
   }

   public static <T> void paginate(IArgConsumer var0, Paginator<T> var1, Runnable var2, Function<T, Component> var3) throws CommandException {
      paginate(var0, var1, var2, var3, null);
   }

   public void display(Function<E, Component> var1) {
      this.display(var1, null);
   }

   public static <T> void paginate(IArgConsumer var0, T[] var1, Runnable var2, Function<T, Component> var3, String var4) throws CommandException {
      paginate(var0, Arrays.asList(var1), var2, var3, var4);
   }

   public Paginator(List<E> var1) {
      this.entries = var1;
   }

   public Paginator<E> setPageSize(int var1) {
      this.pageSize = var1;
      return this;
   }

   public int getMaxPage() {
      return (this.entries.size() - 1) / this.pageSize + 1;
   }

   public boolean validPage(int var1) {
      return var1 > 0 && var1 <= this.getMaxPage();
   }

   public static <T> void paginate(IArgConsumer var0, List<T> var1, Runnable var2, Function<T, Component> var3, String var4) throws CommandException {
      paginate(var0, new Paginator<>(var1), var2, var3, var4);
   }

   public static <T> void paginate(IArgConsumer var0, List<T> var1, Function<T, Component> var2, String var3) throws CommandException {
      paginate(var0, new Paginator<>(var1), null, var2, var3);
   }
}
