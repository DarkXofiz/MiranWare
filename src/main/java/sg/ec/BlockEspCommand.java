// Original binary: sg/ec/lkeKqLSUULKisExD
package sg.ec;

import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.builder.RequiredArgumentBuilder;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import net.minecraft.client.multiplayer.ClientSuggestionProvider;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
@CommandInfo(name = "blockesp", description = "")
public class BlockEspCommand extends AbstractCommand {
   private final List<String> field21389 = new ArrayList<>();
   private static final String field21390 = "BlockESP модуль не найден.";
   private static final String field21391 = "Default";
   private static final String field21392 = "add";
   private static final String field21393 = "name";
   private static final String field21394 = "color";
   private static final String field21395 = "addtile";
   private static final String field21396 = "name";
   private static final String field21397 = "color";
   private static final String field21398 = "addentity";
   private static final String field21399 = "name";
   private static final String field21400 = "color";
   private static final String field21401 = "remove";
   private static final String field21402 = "name";
   private static final String field21403 = "list";
   private static final String field21404 = "clear";
   private static final String field21405 = "BlockESP модуль не найден.";
   private static final String field21406 = "Список целей уже пуст.";
   private static final String field21407 = "Список целей был очищен.";
   private static final String field21408 = "BlockESP модуль не найден.";
   private static final String field21409 = "Список целей пуст.";
   private static final String field21410 = "Список целей:";
   private static final String field21411 = "name";
   private static final String field21412 = "BlockESP модуль не найден.";
   private static final String field21413 = "name";
   private static final String field21414 = "color";
   private static final String field21415 = "name";
   private static final String field21416 = "name";
   private static final String field21417 = "color";
   private static final String field21418 = "name";
   private static final String field21419 = "name";
   private static final String field21420 = "color";
   private static final String field21421 = "name";
   private static final String field21422 = "Default";

   private int method09404(BlockState var1, NamedColor var2) {
      Block var3 = var1.getBlock();
      return this.method09425(new BlockEspEntry(var3.defaultBlockState(), BlockNameUtils.method03812(var3), method09414(var2), 0, true, true), var2);
   }

   private int method09405(BlockEntityType<?> var1, NamedColor var2) {
      return this.method09425(BlockEspEntry.method03987(var1, method09414(var2), 0, true), var2);
   }

   @Override
   public void method00273(LiteralArgumentBuilder<ClientSuggestionProvider> var1) {
      var1.then(
         this.method01188(field21392)
            .then(
               ((RequiredArgumentBuilder)this.method01184(field21393, new BlockStateArgument())
                     .executes(var1x -> this.method09404((BlockState)var1x.getArgument(field21421, BlockState.class), NamedColor.WHITE)))
                  .then(
                     this.method01184(field21394, new ColorArgument())
                        .executes(
                           var1x -> this.method09404(
                              (BlockState)var1x.getArgument(field21419, BlockState.class),
                              (NamedColor)var1x.getArgument(field21420, NamedColor.class)
                           )
                        )
                  )
            )
      );
      var1.then(
         this.method01188(field21395)
            .then(
               ((RequiredArgumentBuilder)this.method01184(field21396, new BlockEntityTypeArgument())
                     .executes(var1x -> this.method09405((BlockEntityType<?>)var1x.getArgument(field21418, BlockEntityType.class), NamedColor.WHITE)))
                  .then(
                     this.method01184(field21397, new ColorArgument())
                        .executes(
                           var1x -> this.method09405(
                              (BlockEntityType<?>)var1x.getArgument(field21416, BlockEntityType.class),
                              (NamedColor)var1x.getArgument(field21417, NamedColor.class)
                           )
                        )
                  )
            )
      );
      var1.then(
         this.method01188(field21398)
            .then(
               ((RequiredArgumentBuilder)this.method01184(field21399, new EntityTypeArgument())
                     .executes(var1x -> this.method09411((EntityType<?>)var1x.getArgument(field21415, EntityType.class), NamedColor.WHITE)))
                  .then(
                     this.method01184(field21400, new ColorArgument())
                        .executes(
                           var1x -> this.method09411(
                              (EntityType<?>)var1x.getArgument(field21413, EntityType.class),
                              (NamedColor)var1x.getArgument(field21414, NamedColor.class)
                           )
                        )
                  )
            )
      );
      var1.then(this.method01188(field21401).then(this.method01184(field21402, new BlockEspTargetArgument()).executes(var1x -> {
         String var2 = (String)var1x.getArgument(field21411, String.class);
         BlockESP var3 = ModuleManager.INSTANCE.method08249();
         if (var3 == null) {
            this.method01187(field21412);
            return 1;
         }

         var var4 = this.method09423(var3);
         boolean var5 = false;

         for (BlockEspConfigCodec var7 : var4) {
            if (var7 != null) {
               var5 |= this.method09413(var7).removeIf(var1xx -> var1xx != null && var2.equals(var1xx.method03988()));
            }
         }

         if (!var5) {
            this.method01187("Цель с названием: " + var2 + " не найдена в списке.");
            return 1;
         } else {
            this.method09416(var3, var4);
            this.method01187("Цель с названием: " + var2 + " была удалена.");
            return 1;
         }
      })));
      var1.then(this.method01188(field21403).executes(var1x -> {
         BlockESP var2 = ModuleManager.INSTANCE.method08249();
         if (var2 == null) {
            this.method01187(field21408);
            return 1;
         }

         var var3 = this.method09410(this.method09423(var2)).filter(BlockEspEntry::method03984).toList();
         if (var3.isEmpty()) {
            this.method01187(field21409);
            return 1;
         }

         this.method01187(field21410);

         for (BlockEspEntry var5 : var3) {
            this.method01187(var5.method03988());
         }

         return 1;
      }));
      var1.then(this.method01188(field21404).executes(var1x -> {
         BlockESP var2 = ModuleManager.INSTANCE.method08249();
         if (var2 == null) {
            this.method01187(field21405);
            return 1;
         }

         var var3 = this.method09423(var2);
         if (this.method09410(var3).findAny().isEmpty()) {
            this.method01187(field21406);
            return 1;
         }

         for (BlockEspConfigCodec var5 : var3) {
            if (var5 != null) {
               this.method09413(var5).clear();
            }
         }

         this.method09416(var2, var3);
         this.method01187(field21407);
         return 1;
      }));
   }

   private Stream<BlockEspEntry> method09410(List<BlockEspConfigCodec> var1) {
      return var1 == null
         ? Stream.empty()
         : var1.stream().filter(var0 -> var0 != null).flatMap(var1x -> this.method09413(var1x).stream()).filter(var0 -> var0 != null && var0.method03982());
   }

   private int method09411(EntityType<?> var1, NamedColor var2) {
      return this.method09425(BlockEspEntry.method03992(var1, method09414(var2), 0, true), var2);
   }

   private List<BlockEspEntry> method09413(BlockEspConfigCodec var1) {
      var var2 = var1.method10512();
      if (var2 == null) {
         var2 = new ArrayList();
         var1.method10510(var2);
      }

      return var2;
   }

   private static RgbColor method09414(NamedColor var0) {
      int var1 = var0.method10139();
      return new RgbColor(ColorUtils.method04588(var1), ColorUtils.method04589(var1), ColorUtils.method04587(var1));
   }

   private void method09416(BlockESP var1, List<BlockEspConfigCodec> var2) {
      var1.method03405(var2);
      this.method09422(var2);
      BlockEspWorldIndex.method09026();
   }

   private void method09422(List<BlockEspConfigCodec> var1) {
      this.field21389.clear();
      this.method09410(var1).forEach(var1x -> {
         if (!this.field21389.contains(var1x.method03988())) {
            this.field21389.add(var1x.method03988());
         }
      });
   }

   private List<BlockEspConfigCodec> method09423(BlockESP var1) {
      var var2 = var1.method03403();
      if (var2 == null) {
         var2 = new ArrayList();
         var1.method03405(var2);
      }

      return var2;
   }

   private int method09425(BlockEspEntry var1, NamedColor var2) {
      BlockESP var3 = ModuleManager.INSTANCE.method08249();
      if (var3 == null) {
         this.method01187(field21390);
         return 1;
      }

      var var4 = this.method09423(var3);
      if (this.method09410(var4).anyMatch(var1x -> var1x.method03988().equals(var1.method03988()))) {
         this.method01187("Цель с названием: " + var1.method03988() + " уже добавлена.");
         return 1;
      }

      BlockEspConfigCodec var5 = var4.stream().filter(var0 -> var0 != null && field21422.equals(var0.method10511())).findFirst().orElse(null);
      if (var5 == null) {
         var5 = new BlockEspConfigCodec(field21391, new ArrayList<>(), 0, true);
         var4.add(var5);
      }

      var var6 = this.method09413(var5);
      var1.method03985(var6.size());
      var6.add(var1);
      this.method09416(var3, var4);
      this.method01187("Цель с названием: " + var1.method03988() + " была добавлена (" + var2.name() + ").");
      return 1;
   }

   public List<String> method09429() {
      BlockESP var1 = ModuleManager.INSTANCE.method08249();
      this.method09422(var1 != null ? var1.method03403() : BlockEspConfigManager.method03030().method03036());
      return this.field21389;
   }
}
