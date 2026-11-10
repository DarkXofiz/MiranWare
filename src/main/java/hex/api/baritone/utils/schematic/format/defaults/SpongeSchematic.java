// Original binary: hex/api/baritone/utils/schematic/format/defaults/SpongeSchematic
package hex.api.baritone.utils.schematic.format.defaults;

import hex.api.baritone.utils.schematic.StaticSchematic;
import hex.api.baritone.utils.type.VarInt;
import it.unimi.dsi.fastutil.ints.Int2ObjectArrayMap;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import net.minecraft.core.Holder.Reference;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;

// $VF: Compiled from s
public final class SpongeSchematic extends StaticSchematic {
   private static final String щщ = "щщ";
   private static final String ббб = "ббб";
   private static final String ббА = "ббА";
   private static final String бб诶 = "бб诶";
   private static final String ббЫ = "ббЫ";
   private static final String ббз = "ббз";
   private static final String ббР = "ббР";
   private static final String ббх = "ббх";


   public SpongeSchematic(CompoundTag var1) {
      this.x = var1.getInt(щщ).orElse(0);
      this.y = var1.getInt(ббб).orElse(0);
      this.z = var1.getInt(ббА).orElse(0);
      this.states = new BlockState[this.x][this.z][this.y];
      Int2ObjectArrayMap var2 = new Int2ObjectArrayMap();
      CompoundTag sx = var1.getCompound(бб诶).orElse(new CompoundTag());

      for (String sxx : sx.keySet()) {
         int sxxx = sx.getInt(sxx).orElse(0);
         SpongeSchematic.SerializedBlockState sxxxx = SpongeSchematic.SerializedBlockState.getFromString(sxx);
         if (sxxxx == null) {
            throw new IllegalArgumentException(ббЫ);
         }

         BlockState sxxxxx = sxxxx.deserialize();
         if (sxxxxx == null) {
            throw new IllegalArgumentException(ббз);
         }

         var2.put(sxxx, sxxxxx);
      }

      byte[] sxx = var1.getByteArray(ббР).orElseThrow();
      int[] sxxx = new int[this.x * this.y * this.z];
      int sxxxx = 0;

      for (int sxxxxx = 0; sxxxxx < sxxx.length; sxxxxx++) {
         if (sxxxx >= sxx.length) {
            throw new IllegalArgumentException(ббх);
         }

         VarInt sxxxxxx = VarInt.read(sxx, sxxxx);
         sxxx[sxxxxx] = sxxxxxx.getValue();
         sxxxx += sxxxxxx.getSize();
      }

      for (int sxxxxx = 0; sxxxxx < this.y; sxxxxx++) {
         for (int sxxxxxx = 0; sxxxxxx < this.z; sxxxxxx++) {
            for (int sxxxxxxx = 0; sxxxxxxx < this.x; sxxxxxxx++) {
               int sxxxxxxxx = (sxxxxx * this.z + sxxxxxx) * this.x + sxxxxxxx;
               BlockState sxxxxxxxxx = (BlockState)var2.get(sxxx[sxxxxxxxx]);
               if (sxxxxxxxxx == null) {
                  throw new IllegalArgumentException("Invalid Palette Index " + sxxxxxxxx);
               }

               this.states[sxxxxxxx][sxxxxxx][sxxxxx] = sxxxxxxxxx;
            }
         }
      }
   }

   // $VF: Compiled from s
   private static final class SerializedBlockState {
      private static final Pattern REGEX = Pattern.compile(SpongeSchematic.SerializedBlockState.Аа诶);
      private final Identifier identifier;
      private final Map<String, String> properties;
      private BlockState blockState;
      private static final String АШи = "АШи";
      private static final String АШщ = "АШщ";
      private static final String Ааб = "Ааб";
      private static final String АаА = "АаА";
      private static final String Аа诶 = "Аа诶";

      private BlockState deserialize() {
         if (this.blockState == null) {
            Block var1 = BuiltInRegistries.BLOCK.get(this.identifier).map(Reference::value).orElse(Blocks.AIR);
            this.blockState = var1.defaultBlockState();
            this.properties.keySet().stream().sorted(String::compareTo).forEachOrdered(var2 -> {
               var sx = var1.getStateDefinition().getProperty(var2);
               if (sx != null) {
                  this.blockState = setPropertyValue(this.blockState, sx, this.properties.get(var2));
               }
            });
         }

         return this.blockState;
      }

      private static SpongeSchematic.SerializedBlockState getFromString(String var0) {
         Matcher var1 = REGEX.matcher(var0);
         if (!var1.matches()) {
            return null;
         }

         try {
            String sx = var1.group(АШи);
            String sxx = var1.group(АШщ);
            Identifier sxxx = Identifier.parse(sx);
            Map sxxxx = new HashMap<>();
            if (sxx != null) {
               for (String sxxxxx : sxx.split(Ааб)) {
                  String[] sxxxxxx = sxxxxx.split(АаА);
                  sxxxx.put(sxxxxxx[0], sxxxxxx[1]);
               }
            }

            return new SpongeSchematic.SerializedBlockState(sxxx, sxxxx);
         } catch (Exception sx) {
            return null;
         }
      }

      private static <T extends Comparable<T>> BlockState setPropertyValue(BlockState var0, Property<T> var1, String var2) {
         var var3 = var1.getValue(var2);
         if (var3.isPresent()) {
            return var0.setValue(var1, var3.get());
         } else {
            throw new IllegalArgumentException("Invalid value for property " + var1);
         }
      }


      private SerializedBlockState(Identifier var1, Map<String, String> var2) {
         this.identifier = var1;
         this.properties = var2;
      }
   }
}
