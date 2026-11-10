// Original binary: hex/api/baritone/command/defaults/FollowCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.KeepName;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.EntityClassById;
import hex.api.baritone.api.command.datatypes.IDatatypeFor;
import hex.api.baritone.api.command.datatypes.NearbyPlayer;
import hex.api.baritone.api.command.exception.CommandErrorMessageException;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;

// $VF: Compiled from s
public class FollowCommand extends Command {
   private static final String За = "За";
   private static final String З7 = "З7";
   private static final String ЗУ = "ЗУ";
   private static final String З0 = "З0";
   private static final String ЗГ = "ЗГ";
   private static final String Зф = "Зф";
   private static final String ЗЕ = "ЗЕ";
   private static final String Зч = "Зч";
   private static final String З衣 = "З衣";
   private static final String Зц = "Зц";
   private static final String ЗМ = "ЗМ";

   public FollowCommand(IBaritone var1) {
      super(var1, За);
   }

   @Override
   public String getShortDesc() {
      return ЗГ;
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      if (var2.hasExactlyOne()) {
         return new TabCompleteHelper().append(FollowCommand.FollowGroup.class).append(FollowCommand.FollowList.class).filterPrefix(var2.getString()).stream();
      }

      IDatatypeFor var3;
      try {
         var3 = var2.getEnum(FollowCommand.FollowList.class).datatype;
      } catch (NullPointerException sx) {
         return Stream.empty();
      }

      while (var2.has(2)) {
         if (var2.peekDatatypeOrNull(var3) == null) {
            return Stream.empty();
         }

         var2.get();
      }

      return var2.tabCompleteDatatype(var3);
   }


   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(Зф, "", ЗЕ, Зч, З衣, Зц, ЗМ);
   }

   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      var2.requireMin(1);
      List<Entity> var5 = new ArrayList<>();
      List<EntityType<?>> sx = new ArrayList<>();
      FollowCommand.FollowGroup sxx;
      if (var2.hasExactlyOne()) {
         this.baritone.getFollowProcess().follow((sxx = var2.getEnum(FollowCommand.FollowGroup.class)).filter);
      } else {
         var2.requireMin(2);
         sxx = null;
         FollowCommand.FollowList sxxx = var2.getEnum(FollowCommand.FollowList.class);

         while (var2.hasAny()) {
            Object sxxxx = var2.getDatatypeFor(sxxx.datatype);
            if (sxxxx instanceof EntityType) {
               sx.add((EntityType<?>)sxxxx);
            } else if (sxxxx != null) {
               var5.add((Entity)sxxxx);
            }
         }

         this.baritone.getFollowProcess().follow(sx.isEmpty() ? var5::contains : var1x -> sx.stream().anyMatch(var1xx -> var1x.getType().equals(var1xx)));
      }

      if (sxx != null) {
         this.logDirect(String.format(З7, sxx.name().toLowerCase(Locale.US)));
      } else if (sx.isEmpty()) {
         if (var5.isEmpty()) {
            throw new FollowCommand.NoEntitiesException();
         }

         this.logDirect(ЗУ);
         var5.stream().map(Entity::toString).forEach(this::logDirect);
      } else {
         this.logDirect(З0);
         sx.stream().map(BuiltInRegistries.ENTITY_TYPE::getKey).map(Objects::requireNonNull).map(Identifier::toString).forEach(this::logDirect);
      }
   }

   // $VF: Compiled from s
   @KeepName
   private enum FollowGroup {
      ENTITIES(LivingEntity.class::isInstance),
      PLAYERS(Player.class::isInstance);

      final Predicate<Entity> filter;

      FollowGroup(Predicate<Entity> var3) {
         this.filter = var3;
      }
   }

   // $VF: Compiled from s
   @KeepName
   private enum FollowList {
      ENTITY(EntityClassById.INSTANCE),
      PLAYER(NearbyPlayer.INSTANCE);

      final IDatatypeFor datatype;

      FollowList(IDatatypeFor var3) {
         this.datatype = var3;
      }
   }

   // $VF: Compiled from s
   public static class NoEntitiesException extends CommandErrorMessageException {
      private static final String бд3 = "бд3";


      protected NoEntitiesException() {
         super(бд3);
      }
   }
}
