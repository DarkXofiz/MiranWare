// Original binary: hex/api/baritone/command/defaults/SelCommand
package hex.api.baritone.command.defaults;

import hex.api.baritone.Baritone;
import hex.api.baritone.api.IBaritone;
import hex.api.baritone.api.command.Command;
import hex.api.baritone.api.command.argument.IArgConsumer;
import hex.api.baritone.api.command.datatypes.ForAxis;
import hex.api.baritone.api.command.datatypes.ForBlockOptionalMeta;
import hex.api.baritone.api.command.datatypes.ForDirection;
import hex.api.baritone.api.command.datatypes.RelativeBlockPos;
import hex.api.baritone.api.command.exception.CommandException;
import hex.api.baritone.api.command.exception.CommandInvalidStateException;
import hex.api.baritone.api.command.exception.CommandInvalidTypeException;
import hex.api.baritone.api.command.helpers.TabCompleteHelper;
import hex.api.baritone.api.event.events.RenderEvent;
import hex.api.baritone.api.event.listener.AbstractGameEventListener;
import hex.api.baritone.api.schematic.CompositeSchematic;
import hex.api.baritone.api.schematic.FillSchematic;
import hex.api.baritone.api.schematic.ISchematic;
import hex.api.baritone.api.schematic.MaskSchematic;
import hex.api.baritone.api.schematic.ReplaceSchematic;
import hex.api.baritone.api.schematic.ShellSchematic;
import hex.api.baritone.api.schematic.WallsSchematic;
import hex.api.baritone.api.schematic.mask.shape.CylinderMask;
import hex.api.baritone.api.schematic.mask.shape.SphereMask;
import hex.api.baritone.api.selection.ISelection;
import hex.api.baritone.api.selection.ISelectionManager;
import hex.api.baritone.api.utils.BetterBlockPos;
import hex.api.baritone.api.utils.BlockOptionalMeta;
import hex.api.baritone.api.utils.BlockOptionalMetaLookup;
import hex.api.baritone.utils.BlockStateInterface;
import hex.api.baritone.utils.IRenderer;
import hex.api.baritone.utils.schematic.StaticSchematic;
import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Stream;
import net.minecraft.core.Direction;
import net.minecraft.core.Vec3i;
import net.minecraft.core.Direction.Axis;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import sg.ec.BaritoneVertexConsumerAccess;

// $VF: Compiled from s
public class SelCommand extends Command {
   private ISelectionManager manager = this.baritone.getSelectionManager();
   private BetterBlockPos pos1 = null;
   private ISchematic clipboard = null;
   private Vec3i clipboardOffset = null;
   private static final String бЖя = "бЖя";
   private static final String бЖI = "бЖI";
   private static final String бЖы = "бЖы";
   private static final String бЖу = "бЖу";
   private static final String бЖг = "бЖг";
   private static final String бЖю = "бЖю";
   private static final String бЖ4 = "бЖ4";
   private static final String бЖС = "бЖС";
   private static final String бЖъ = "бЖъ";
   private static final String бЖБ = "бЖБ";
   private static final String бЖв = "бЖв";
   private static final String бЖр = "бЖр";
   private static final String бЖй = "бЖй";
   private static final String бЖк = "бЖк";
   private static final String бЖп = "бЖп";
   private static final String бЖ2 = "бЖ2";
   private static final String бЖ西 = "бЖ西";
   private static final String бЖт = "бЖт";
   private static final String бЖд = "бЖд";
   private static final String бЖе = "бЖе";
   private static final String бЖ6 = "бЖ6";
   private static final String бЖl = "бЖl";
   private static final String бЖ必 = "бЖ必";
   private static final String бЖЗ = "бЖЗ";
   private static final String бЖн = "бЖн";
   private static final String бЖД = "бЖД";
   private static final String бЖН = "бЖН";
   private static final String бЖш = "бЖш";
   private static final String бЖл = "бЖл";
   private static final String бЖи = "бЖи";
   private static final String бЖщ = "бЖщ";
   private static final String боб = "боб";
   private static final String боА = "боА";
   private static final String бо诶 = "бо诶";
   private static final String боЫ = "боЫ";
   private static final String боз = "боз";
   private static final String боР = "боР";
   private static final String бох = "бох";
   private static final String боЦ = "боЦ";
   private static final String бо9 = "бо9";
   private static final String боЮ = "боЮ";
   private static final String боO = "боO";
   private static final String бо弟 = "бо弟";
   private static final String боВ = "боВ";
   private static final String бож = "бож";
   private static final String бо8 = "бо8";
   private static final String боТ = "боТ";

   @Override
   public String getShortDesc() {
      return бЖ必;
   }


   @Override
   public void execute(String var1, IArgConsumer var2) throws CommandException {
      SelCommand.Action var3 = SelCommand.Action.getByName(var2.getString());
      if (var3 == null) {
         throw new CommandInvalidTypeException(var2.consumed(), бЖу);
      }

      if (var3 != SelCommand.Action.POS1 && var3 != SelCommand.Action.POS2) {
         if (var3 == SelCommand.Action.CLEAR) {
            var2.requireMax(0);
            this.pos1 = null;
            this.logDirect(String.format(бЖС, this.manager.removeAllSelections().length));
         } else if (var3 == SelCommand.Action.UNDO) {
            var2.requireMax(0);
            if (this.pos1 != null) {
               this.pos1 = null;
               this.logDirect(бЖъ);
            } else {
               ISelection[] sx = this.manager.getSelections();
               if (sx.length < 1) {
                  throw new CommandInvalidStateException(бЖБ);
               }

               this.pos1 = this.manager.removeSelection(sx[sx.length - 1]).pos1();
               this.logDirect(бЖв);
            }
         } else if (var3.isFillAction()) {
            BlockOptionalMeta sx = var3 == SelCommand.Action.CLEARAREA ? new BlockOptionalMeta(Blocks.AIR) : var2.getDatatypeFor(ForBlockOptionalMeta.INSTANCE);
            Axis sxx;
            BlockOptionalMetaLookup sxxx;
            if (var3 != SelCommand.Action.REPLACE) {
               if (var3 != SelCommand.Action.CYLINDER && var3 != SelCommand.Action.HCYLINDER) {
                  var2.requireMax(0);
                  sxxx = null;
                  sxx = null;
               } else {
                  var2.requireMax(1);
                  sxx = var2.hasAny() ? var2.getDatatypeFor(ForAxis.INSTANCE) : Axis.Y;
                  sxxx = null;
               }
            } else {
               var2.requireMin(1);
               List<BlockOptionalMeta> sxxxx = new ArrayList<>();
               sxxxx.add(sx);

               while (var2.has(2)) {
                  sxxxx.add(var2.getDatatypeFor(ForBlockOptionalMeta.INSTANCE));
               }

               sx = var2.getDatatypeFor(ForBlockOptionalMeta.INSTANCE);
               sxxx = new BlockOptionalMetaLookup(sxxxx.toArray(new BlockOptionalMeta[0]));
               sxx = null;
            }

            ISelection[] sxxxx = this.manager.getSelections();
            if (sxxxx.length == 0) {
               throw new CommandInvalidStateException(бЖр);
            }

            BetterBlockPos sxxxxx = sxxxx[0].min();
            CompositeSchematic sxxxxxx = new CompositeSchematic(0, 0, 0);

            for (ISelection sxxxxxxx : sxxxx) {
               BetterBlockPos sxxxxxxxx = sxxxxxxx.min();
               sxxxxx = new BetterBlockPos(Math.min(sxxxxx.x, sxxxxxxxx.x), Math.min(sxxxxx.y, sxxxxxxxx.y), Math.min(sxxxxx.z, sxxxxxxxx.z));
            }

            for (ISelection sxxxxxxx : sxxxx) {
               Vec3i sxxxxxxxx = sxxxxxxx.size();
               BetterBlockPos sxxxxxxxxx = sxxxxxxx.min();
               UnaryOperator<ISchematic> sxxxxxxxxxx = var3x -> {
                  int sxxxxxxxxxxx = var3x.widthX();
                  int sxxxxxxxxxxxx = var3x.heightY();
                  int sxxxxxxxxxxxxx = var3x.lengthZ();
                  switch (var3) {
                     case WALLS:
                        return (ISchematic) new WallsSchematic(var3x);
                     case SHELL:
                        return (ISchematic) new ShellSchematic(var3x);
                     case SPHERE:
                        return (ISchematic) MaskSchematic.create(var3x, new SphereMask(sxxxxxxxxxxx, sxxxxxxxxxxxx, sxxxxxxxxxxxxx, true).compute());
                     case HSPHERE:
                        return (ISchematic) MaskSchematic.create(var3x, new SphereMask(sxxxxxxxxxxx, sxxxxxxxxxxxx, sxxxxxxxxxxxxx, false).compute());
                     case CYLINDER:
                        return (ISchematic) MaskSchematic.create(var3x, new CylinderMask(sxxxxxxxxxxx, sxxxxxxxxxxxx, sxxxxxxxxxxxxx, true, sxx).compute());
                     case HCYLINDER:
                        return (ISchematic) MaskSchematic.create(var3x, new CylinderMask(sxxxxxxxxxxx, sxxxxxxxxxxxx, sxxxxxxxxxxxxx, false, sxx).compute());
                     case CLEARAREA:
                     default:
                        return var3x;
                     case REPLACE:
                        return new ReplaceSchematic(var3x, sxxx);
                  }
               };
               ISchematic sxxxxxxxxxxx = (ISchematic) sxxxxxxxxxx.apply(new FillSchematic(sxxxxxxxx.getX(), sxxxxxxxx.getY(), sxxxxxxxx.getZ(), sx));
               sxxxxxx.put(sxxxxxxxxxxx, sxxxxxxxxx.x - sxxxxx.x, sxxxxxxxxx.y - sxxxxx.y, sxxxxxxxxx.z - sxxxxx.z);
            }

            this.baritone.getBuilderProcess().build(бЖй, sxxxxxx, sxxxxx);
            this.logDirect(бЖк);
         } else if (var3 == SelCommand.Action.COPY) {
            BetterBlockPos sx = this.ctx.viewerPos();
            BetterBlockPos sxx = var2.hasAny() ? var2.getDatatypePost(RelativeBlockPos.INSTANCE, sx) : sx;
            var2.requireMax(0);
            ISelection[] sxxx = this.manager.getSelections();
            if (sxxx.length < 1) {
               throw new CommandInvalidStateException(бЖп);
            }

            BlockStateInterface sxxxx = new BlockStateInterface(this.ctx);
            BetterBlockPos sxxxxx = sxxx[0].min();
            CompositeSchematic sxxxxxx = new CompositeSchematic(0, 0, 0);

            for (ISelection sxxxxxxx : sxxx) {
               BetterBlockPos sxxxxxxxx = sxxxxxxx.min();
               sxxxxx = new BetterBlockPos(Math.min(sxxxxx.x, sxxxxxxxx.x), Math.min(sxxxxx.y, sxxxxxxxx.y), Math.min(sxxxxx.z, sxxxxxxxx.z));
            }

            for (ISelection sxxxxxxx : sxxx) {
               Vec3i sxxxxxxxx = sxxxxxxx.size();
               BetterBlockPos sxxxxxxxxx = sxxxxxxx.min();
               BlockState[][][] sxxxxxxxxxx = new BlockState[sxxxxxxxx.getX()][sxxxxxxxx.getZ()][sxxxxxxxx.getY()];

               for (int sxxxxxxxxxxx = 0; sxxxxxxxxxxx < sxxxxxxxx.getX(); sxxxxxxxxxxx++) {
                  for (int sxxxxxxxxxxxx = 0; sxxxxxxxxxxxx < sxxxxxxxx.getY(); sxxxxxxxxxxxx++) {
                     for (int sxxxxxxxxxxxxx = 0; sxxxxxxxxxxxxx < sxxxxxxxx.getZ(); sxxxxxxxxxxxxx++) {
                        sxxxxxxxxxx[sxxxxxxxxxxx][sxxxxxxxxxxxxx][sxxxxxxxxxxxx] = sxxxx.get0(
                           sxxxxxxxxx.x + sxxxxxxxxxxx, sxxxxxxxxx.y + sxxxxxxxxxxxx, sxxxxxxxxx.z + sxxxxxxxxxxxxx
                        );
                     }
                  }
               }

               ISchematic sxxxxxxxxxxx = new StaticSchematic(sxxxxxxxxxx);
               sxxxxxx.put(sxxxxxxxxxxx, sxxxxxxxxx.x - sxxxxx.x, sxxxxxxxxx.y - sxxxxx.y, sxxxxxxxxx.z - sxxxxx.z);
            }

            this.clipboard = sxxxxxx;
            this.clipboardOffset = sxxxxx.subtract(sxx);
            this.logDirect(бЖ2);
         } else if (var3 == SelCommand.Action.PASTE) {
            BetterBlockPos sx = this.ctx.viewerPos();
            BetterBlockPos sxx = var2.hasAny() ? var2.getDatatypePost(RelativeBlockPos.INSTANCE, sx) : sx;
            var2.requireMax(0);
            if (this.clipboard == null) {
               throw new CommandInvalidStateException(бЖ西);
            }

            this.baritone.getBuilderProcess().build(бЖт, this.clipboard, sxx.offset(this.clipboardOffset));
            this.logDirect(бЖд);
         } else if (var3 == SelCommand.Action.EXPAND || var3 == SelCommand.Action.CONTRACT || var3 == SelCommand.Action.SHIFT) {
            var2.requireExactly(3);
            SelCommand.TransformTarget sx = SelCommand.TransformTarget.getByName(var2.getString());
            if (sx == null) {
               throw new CommandInvalidStateException(бЖе);
            }

            Direction sxx = var2.getDatatypeFor(ForDirection.INSTANCE);
            int sxxx = var2.getAs(Integer.class);
            ISelection[] sxxxx = this.manager.getSelections();
            if (sxxxx.length < 1) {
               throw new CommandInvalidStateException(бЖ6);
            }

            sxxxx = sx.transform(sxxxx);

            for (ISelection sxxxxx : sxxxx) {
               if (var3 == SelCommand.Action.EXPAND) {
                  this.manager.expand(sxxxxx, sxx, sxxx);
               } else if (var3 == SelCommand.Action.CONTRACT) {
                  this.manager.contract(sxxxxx, sxx, sxxx);
               } else {
                  this.manager.shift(sxxxxx, sxx, sxxx);
               }
            }

            this.logDirect(String.format(бЖl, sxxxx.length));
         }
      } else {
         if (var3 == SelCommand.Action.POS2 && this.pos1 == null) {
            throw new CommandInvalidStateException(бЖг);
         }

         BetterBlockPos sx = this.ctx.viewerPos();
         BetterBlockPos sxx = var2.hasAny() ? var2.getDatatypePost(RelativeBlockPos.INSTANCE, sx) : sx;
         var2.requireMax(0);
         if (var3 == SelCommand.Action.POS1) {
            this.pos1 = sxx;
            this.logDirect(бЖю);
         } else {
            this.manager.addSelection(this.pos1, sxx);
            this.pos1 = null;
            this.logDirect(бЖ4);
         }
      }
   }

   @Override
   public Stream<String> tabComplete(String var1, IArgConsumer var2) throws CommandException {
      if (var2.hasExactlyOne()) {
         return new TabCompleteHelper().append(SelCommand.Action.getAllNames()).filterPrefix(var2.getString()).sortAlphabetically().stream();
      }

      SelCommand.Action var3 = SelCommand.Action.getByName(var2.getString());
      if (var3 != null) {
         if (var3 != SelCommand.Action.POS1 && var3 != SelCommand.Action.POS2) {
            if (var3.isFillAction()) {
               if (var2.hasExactlyOne() || var3 == SelCommand.Action.REPLACE) {
                  while (var2.has(2)) {
                     var2.get();
                  }

                  return var2.tabCompleteDatatype(ForBlockOptionalMeta.INSTANCE);
               }

               if (var2.hasExactly(2) && (var3 == SelCommand.Action.CYLINDER || var3 == SelCommand.Action.HCYLINDER)) {
                  var2.get();
                  return var2.tabCompleteDatatype(ForAxis.INSTANCE);
               }
            } else if (var3 == SelCommand.Action.EXPAND || var3 == SelCommand.Action.CONTRACT || var3 == SelCommand.Action.SHIFT) {
               if (var2.hasExactlyOne()) {
                  return new TabCompleteHelper().append(SelCommand.TransformTarget.getAllNames()).filterPrefix(var2.getString()).sortAlphabetically().stream();
               }

               SelCommand.TransformTarget sx = SelCommand.TransformTarget.getByName(var2.getString());
               if (sx != null && var2.hasExactlyOne()) {
                  return var2.tabCompleteDatatype(ForDirection.INSTANCE);
               }
            }
         } else if (var2.hasAtMost(3)) {
            return var2.tabCompleteDatatype(RelativeBlockPos.INSTANCE);
         }
      }

      return Stream.empty();
   }

   @Override
   public List<String> getLongDesc() {
      return Arrays.asList(
         бЖЗ, "", бЖн, "", бЖД, "", бЖН, бЖш, бЖл, бЖи, бЖщ, "", боб, боА, бо诶, боЫ, боз, боР, бох, боЦ, бо9, боЮ, боO, бо弟, боВ, "", бож, бо8, боТ
      );
   }

   public SelCommand(IBaritone var1) {
      super(var1, бЖя, бЖI, бЖы);
      var1.getGameEventHandler().registerEventListener(new AbstractGameEventListener()      // $VF: Compiled from s
 {
         @Override
         public void onRenderPass(RenderEvent var1) {
            if (Baritone.settings().renderSelectionCorners.value && SelCommand.this.pos1 != null) {
               Color var2 = Baritone.settings().colorSelectionPos1.value;
               float sx = Baritone.settings().selectionOpacity.value;
               float sxx = Baritone.settings().selectionLineWidth.value;
               boolean sxxx = Baritone.settings().renderSelectionIgnoreDepth.value;
               BaritoneVertexConsumerAccess sxxxx = IRenderer.startLines(var2, sx);
               IRenderer.emitAABB(sxxxx, var1.getModelViewStack(), new AABB(SelCommand.this.pos1), sxx);
               IRenderer.endLines(sxxxx, sxxx);
            }
         }
      });
   }

   // $VF: Compiled from s
   enum Action {
      POS1("pos1", "p1", "1"),
      POS2("pos2", "p2", "2"),
      CLEAR("clear", "c"),
      UNDO("undo", "u"),
      SET("set", "fill", "s", "f"),
      WALLS("walls", "w"),
      SHELL("shell", "shl"),
      SPHERE("sphere", "sph"),
      HSPHERE("hsphere", "hsph"),
      CYLINDER("cylinder", "cyl"),
      HCYLINDER("hcylinder", "hcyl"),
      CLEARAREA("cleararea", "ca"),
      REPLACE("replace", "r"),
      EXPAND("expand", "ex"),
      COPY("copy", "cp"),
      PASTE("paste", "p"),
      CONTRACT("contract", "ct"),
      SHIFT("shift", "sh");

      private final String[] names;

      Action(String... var3) {
         this.names = var3;
      }

      public static SelCommand.Action getByName(String var0) {
         for (SelCommand.Action var4 : values()) {
            for (String sx : var4.names) {
               if (sx.equalsIgnoreCase(var0)) {
                  return var4;
               }
            }
         }

         return null;
      }

      public static String[] getAllNames() {
         Set var0 = new HashSet<>();

         for (SelCommand.Action sx : values()) {
            var0.addAll(Arrays.asList(sx.names));
         }

         return (String[]) var0.toArray(new String[0]);
      }

      public final boolean isFillAction() {
         return this == SET
            || this == WALLS
            || this == SHELL
            || this == SPHERE
            || this == HSPHERE
            || this == CYLINDER
            || this == HCYLINDER
            || this == CLEARAREA
            || this == REPLACE;
      }
   }

   // $VF: Compiled from s
   enum TransformTarget {
      ALL(var0 -> var0, "all", "a"),
      NEWEST(var0 -> new ISelection[]{var0[var0.length - 1]}, "newest", "n"),
      OLDEST(var0 -> new ISelection[]{var0[0]}, "oldest", "o");

      private final Function<ISelection[], ISelection[]> transform;
      private final String[] names;

      TransformTarget(Function<ISelection[], ISelection[]> var3, String... var4) {
         this.transform = var3;
         this.names = var4;
      }

      public ISelection[] transform(ISelection[] var1) {
         return this.transform.apply(var1);
      }

      public static SelCommand.TransformTarget getByName(String var0) {
         for (SelCommand.TransformTarget var4 : values()) {
            for (String sx : var4.names) {
               if (sx.equalsIgnoreCase(var0)) {
                  return var4;
               }
            }
         }

         return null;
      }

      public static String[] getAllNames() {
         Set var0 = new HashSet<>();

         for (SelCommand.TransformTarget sx : values()) {
            var0.addAll(Arrays.asList(sx.names));
         }

         return (String[]) var0.toArray(new String[0]);
      }
   }
}
