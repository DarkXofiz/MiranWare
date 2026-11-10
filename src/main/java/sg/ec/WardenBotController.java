// Original binary: sg/ec/8bqOlEpvIN6VYRvu
package sg.ec;

import hex.api.baritone.api.BaritoneAPI;
import hex.api.baritone.api.Settings;
import hex.api.baritone.api.pathing.goals.Goal;
import hex.api.baritone.api.pathing.goals.GoalBlock;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Consumer;
import java.util.function.Predicate;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Plane;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.monster.warden.Warden;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ArrowItem;
import net.minecraft.world.item.BannerItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.SmithingTemplateItem;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.alchemy.Potions;
import net.minecraft.world.item.component.CustomData;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.ChestType;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.shapes.VoxelShape;

// $VF: Compiled from s
public final class WardenBotController {
   private static final int field04695 = 200;
   private static final int field04696 = 0;
   private static final int field04697 = 0;
   private static final int field04698 = 0;
   private static final long field04699 = 0;
   private static final long field04700 = 0;
   private static final long field04701 = 0;
   private static final long field04702 = 0;
   private static final double field04703 = 0;
   private static final long field04704 = 0;
   private static final int field04705 = 0;
   private static final int field04706 = 0;
   private static final double field04707 = 0;
   private static final double field04708 = 0;
   private static final double field04709 = 0;
   private static final int field04710 = 0;
   private static final int field04711 = 0;
   private static final int field04712 = 0;
   private static final long field04713 = 0;
   private static final long field04714 = 0;
   private static final Set<Block> field04715 = Set.of(
      Blocks.WEEPING_VINES,
      Blocks.WEEPING_VINES_PLANT,
      Blocks.TWISTING_VINES,
      Blocks.TWISTING_VINES_PLANT,
      Blocks.CAVE_VINES,
      Blocks.CAVE_VINES_PLANT,
      Blocks.VINE
   );
   private static final long field04716 = 0;
   private static final long field04717 = 0;
   private static final double field04718 = 0;
   private static final int field04719 = 0;
   private static final String field04720 = "field04720";
   private static final String field04721 = "field04721";
   private static final String field04722 = "field04722";
   private static final String field04723 = "field04723";
   private static final int field04724 = 0;
   private static final int field04725 = 0;
   private static final int field04726 = 0;
   private static final long field04727 = 0;
   private static final long field04728 = 0;
   private static final int field04729 = 0;
   private static final long field04730 = 0;
   private static final long field04731 = 0;
   private static final int field04732 = 0;
   private static final int field04733 = 0;
   private static final long field04734 = 0;
   private static final long field04735 = 0;
   private static final int field04736 = 0;
   private static final double field04737 = 0;
   private static final int field04738 = 0;
   private static final int field04739 = 0;
   private static final double field04740 = 0;
   private static final Set<Item> field04741 = Set.of(Items.CHORUS_FRUIT, Items.PUFFERFISH, Items.DRIED_KELP);
   private static final int field04742 = 0;
   private static final long field04743 = 0;
   private static final int field04744 = 0;
   private static final double field04745 = 0;
   private static final double field04746 = 0;
   private static final double field04747 = 0;
   private static final int field04748 = 0;
   private static final int field04749 = 0;
   private static final int field04750 = 0;
   private static final int field04751 = 0;
   private static final long field04752 = 0;
   private static final int field04753 = 0;
   private static final long field04754 = 0;
   private static final long field04755 = 0;
   private static final long field04756 = 0;
   private static final double field04757 = 0;
   private static final long field04758 = 0;
   private static final long field04759 = 0;
   private static final long field04760 = 0;
   private static final long field04761 = 0;
   private static final double field04762 = 0;
   private static final double field04763 = 0;
   private static final float field04764 = 0;
   private static final double field04765 = 0;
   private static final int field04766 = 0;
   private static final long field04767 = 0;
   private static final long field04768 = 0;
   private static final long field04769 = 0;
   private static final double field04770 = 0;
   private static final double field04771 = 0;
   private static final double field04772 = 0;
   private static final int field04773 = 0;
   private static final int field04774 = 0;
   private static final double field04775 = 0;
   private static final int field04776 = 0;
   private static final long field04777 = 0;
   private static final long field04778 = 0;
   private static final double field04779 = 0;
   private static final Object field04780 = new Object();
   private static final Set<Block> field04781 = method02012();
   private static int field04782;
   private static boolean field04783;
   private static boolean field04784;
   private static boolean field04785;
   private static boolean field04786;
   private static boolean field04787;
   private static boolean field04788;
   private static long field04789;
   private static long field04790;
   private static long field04791;
   private static long field04792;
   private static int field04793;
   private static double field04794;
   private static double field04795;
   private static List<Block> field04796;
   private final BotTask field04797;
   private final List<Integer> field04798 = new ArrayList<>();
   private final Map<BlockPos, Integer> field04799 = new HashMap<>();
   private final Map<BlockPos, Integer> field04800 = new HashMap<>();
   private final Map<BlockPos, Long> field04801 = new HashMap<>();
   private final Map<BlockPos, Integer> field04802 = new HashMap<>();
   private final ElapsedTimer field04803 = new ElapsedTimer();
   private final ElapsedTimer field04804 = new ElapsedTimer();
   private final ElapsedTimer field04805 = new ElapsedTimer();
   private final ElapsedTimer field04806 = new ElapsedTimer();
   private long field04807;
   private boolean field04808;
   private BlockPos field04809;
   private final ElapsedTimer field04810 = new ElapsedTimer();
   private boolean field04811 = true;
   private int field04812;
   private final ElapsedTimer field04813 = new ElapsedTimer();
   private final ElapsedTimer field04814 = new ElapsedTimer();
   private final ElapsedTimer field04815 = new ElapsedTimer();
   private final ElapsedTimer field04816 = new ElapsedTimer();
   private final ElapsedTimer field04817 = new ElapsedTimer();
   private final ElapsedTimer field04818 = new ElapsedTimer();
   private final ElapsedTimer field04819 = new ElapsedTimer();
   private final ElapsedTimer field04820 = new ElapsedTimer();
   private final ElapsedTimer field04821 = new ElapsedTimer();
   private final ElapsedTimer field04822 = new ElapsedTimer();
   private final ElapsedTimer field04823 = new ElapsedTimer();
   private final ElapsedTimer field04824 = new ElapsedTimer();
   private final ElapsedTimer field04825 = new ElapsedTimer();
   private final Map<BlockPos, BlockPos> field04826 = new HashMap<>();
   private final Set<BlockPos> field04827 = new HashSet<>();
   private final Set<BlockPos> field04828 = new HashSet<>();
   private WardenBotController.Nested53 field04829 = WardenBotController.Nested53.SAVE;
   private WardenBotController.Nested55 field04830;
   private AABB field04831;
   private BlockPos field04832;
   private BlockPos field04833;
   private String field04834;
   private int field04835 = 1;
   private int field04836 = -1;
   private int field04837 = -1;
   private int field04838 = -1;
   private int field04839 = -1;
   private WardenBotController.Nested53 field04840 = WardenBotController.Nested53.SAVE;
   private boolean field04841;
   private int field04842;
   private int field04843 = -1;
   private Vec3 field04844;
   private int field04845;
   private LocalPlayer field04846;
   private int field04847;
   private int field04848;
   private int field04849;
   private Vec3 field04850;
   private boolean field04851;
   private boolean field04852;
   private boolean field04853;
   private boolean field04854;
   private BlockPos field04855;
   private BlockPos field04856;
   private BlockPos field04857;
   private int field04858 = -1;
   private int field04859 = -1;
   private int field04860;
   private boolean field04861;
   private int field04862;
   private BlockPos field04863 = BlockPos.ZERO;
   private int field04864;
   private int field04865;
   private int field04866;
   private int field04867;
   private int field04868;
   private Vec3 field04869;
   private int field04870;
   private int field04871;
   private int field04872;
   private static final int field04873 = Integer.MIN_VALUE;
   private static final int field04874 = Integer.MIN_VALUE;
   private static final long field04875 = 60L;
   private static final long field04876 = 150L;
   private static final long field04877 = 400L;
   private static final long field04878 = 700L;
   private static final long field04879 = 3000L;
   private static final double field04880 = 32.0;
   private static final long field04881 = 10000L;
   private static final double field04882 = 9.0;
   private static final long field04883 = 45000L;
   private static final String field04884 = "Простой без движения — перезапускаю маршрут";
   private static final double field04885 = 2.25;
   private static final long field04886 = 8000L;
   private static final double field04887 = 128.0;
   private static final String field04888 = "недостаточно средств";
   private static final String field04889 = "Помянем. Вы погибли";
   private static final String field04890 = "Вас убил";
   private static final double field04891 = 2.0;
   private static final String field04892 = "Вас убил ";
   private static final String field04893 = ",";
   private static final double field04894 = 3.0;
   private static final float field04895 = 3.0F;
   private static final float field04896 = 8.0F;
   private static final String field04897 = "хранилище не отвечает 30000 мс";
   private static final long field04898 = 3000L;
   private static final long field04899 = 20000L;
   private static final String field04900 = "hub";
   private static final String field04901 = "отложен";
   private static final String field04902 = "ок";
   private static final String field04903 = "отложено";
   private static final String field04904 = "ок";
   private static final long field04905 = 10000L;
   private static final long field04906 = 60000L;
   private static final long field04907 = 30000L;
   private static final String field04908 = "слишком частая смена анархий";
   private static final String field04909 = "Слишком частая смена анархий — фармлю тем, что есть";
   private static final long field04910 = 60000L;
   private static final long field04911 = 30000L;
   private static final long field04912 = 300000L;
   private static final double field04913 = 2.0;
   private static final double field04914 = -2166.0;
   private static final double field04915 = -1825.0;
   private static final double field04916 = -2172.0;
   private static final double field04917 = -1833.0;
   private static final long field04918 = 10000L;
   private static final String field04919 = "home";
   private static final String field04920 = "rtp warden_city";
   private static final String field04921 = "rtp warden_city";
   private static final double field04922 = 2304.0;
   private static final float field04923 = 3.0F;
   private static final float field04924 = 5.0F;
   private static final float field04925 = 3.0F;
   private static final float field04926 = 5.0F;
   private static final String field04927 = "sethome";
   private static final long field04928 = 25000L;
   private static final long field04929 = 45000L;
   private static final double field04930 = 576.0;
   private static final long field04931 = 20000L;
   private static final double field04932 = 14.0;
   private static final String field04933 = "Низкий";
   private static final double field04934 = 1.5;
   private static final String field04935 = "Высокий";
   private static final double field04936 = 0.8;
   private static final long field04937 = 25000L;
   private static final long field04938 = 1000L;
   private static final long field04939 = 1000L;
   private static final double field04940 = 7.0;
   private static final double field04941 = 20.0;
   private static final double field04942 = 10.0;
   private static final double field04943 = 2.25;
   private static final long field04944 = 6000L;
   private static final double field04945 = 4.3;
   private static final double field04946 = 1000.0;
   private static final long field04947 = 2500L;
   private static final long field04948 = 300L;
   private static final double field04949 = 2.4;
   private static final double field04950 = 5.0;
   private static final double field04951 = 12.0;
   private static final long field04952 = Long.MAX_VALUE;
   private static final double field04953 = Double.MAX_VALUE;
   private static final int field04954 = Integer.MAX_VALUE;
   private static final double field04955 = Double.MAX_VALUE;
   private static final double field04956 = 16.0;
   private static final double field04957 = 0.5;
   private static final double field04958 = 0.5;
   private static final double field04959 = 25.0;
   private static final long field04960 = 5000L;
   private static final double field04961 = 144.0;
   private static final double field04962 = 144.0;
   private static final long field04963 = 15000L;
   private static final double field04964 = 625.0;
   private static final double field04965 = 0.5;
   private static final double field04966 = Double.MAX_VALUE;
   private static final double field04967 = -0.4;
   private static final double field04968 = 0.4;
   private static final double field04969 = -0.4;
   private static final double field04970 = 0.4;
   private static final double field04971 = -0.4;
   private static final double field04972 = 0.4;
   private static final double field04973 = 0.4;
   private static final double field04974 = 0.4;
   private static final double field04975 = 0.4;
   private static final float field04976 = 0.31F;
   private static final double field04977 = 0.5;
   private static final float field04978 = 0.73F;
   private static final float field04979 = 1.1F;
   private static final double field04980 = 0.3;
   private static final float field04981 = 1.7F;
   private static final float field04982 = 2.6F;
   private static final double field04983 = 0.2;
   private static final double field04984 = 3.0;
   private static final float field04985 = -90.0F;
   private static final float field04986 = 90.0F;
   private static final float field04987 = 4.0F;
   private static final float field04988 = 120.0F;
   private static final double field04989 = 4.5;
   private static final long field04990 = 6000L;
   private static final double field04991 = 9.0;
   private static final double field04992 = -1.0;
   private static final double field04993 = 25.0;
   private static final double field04994 = 25.0;
   private static final double field04995 = Double.MAX_VALUE;
   private static final long field04996 = 4000L;
   private static final double field04997 = 0.0025;
   private static final double field04998 = 900.0;
   private static final double field04999 = 16.0;
   private static final double field05000 = 0.01;
   private static final double field05001 = 360.0;
   private static final double field05002 = 540.0;
   private static final double field05003 = 360.0;
   private static final double field05004 = 180.0;
   private static final double field05005 = 10.0;
   private static final double field05006 = 25.0;
   private static final double field05007 = 20.0;
   private static final double field05008 = -2070.0;
   private static final double field05009 = -1921.0;
   private static final double field05010 = -2076.0;
   private static final double field05011 = -1929.0;
   private static final double field05012 = -2070.0;
   private static final double field05013 = -2076.0;
   private static final double field05014 = -1921.0;
   private static final double field05015 = -1929.0;
   private static final double field05016 = 10.0;
   private static final double field05017 = 10.0;
   private static final double field05018 = 10.0;
   private static final double field05019 = 10.0;
   private static final String field05020 = "с воронкой";
   private static final String field05021 = "без воронки";
   private static final double field05022 = 20.0;
   private static final double field05023 = 64.0;
   private static final int field05024 = Integer.MAX_VALUE;
   private static final int field05025 = Integer.MIN_VALUE;
   private static final double field05026 = Double.MAX_VALUE;
   private static final double field05027 = 64.0;
   private static final long field05028 = 4000L;
   private static final long field05029 = 8000L;
   private static final String field05030 = "В сундуке нечего брать — работаю тем, что есть";
   private static final String field05031 = "Низкий";
   private static final String field05032 = "Высокий";
   private static final String field05033 = "potion-popper";
   private static final String field05034 = "PublicBukkitValues";
   private static final String field05035 = "minecraft:ftid";
   private static final double field05036 = Double.MAX_VALUE;
   private static final double field05037 = 20.0;
   private static final double field05038 = Double.MAX_VALUE;

   private boolean method01939() {
      if (!this.field04841) {
         return true;
      }

      if (!this.field04818.method04699(field04912)) {
         return false;
      }

      this.field04841 = false;
      this.field04827.clear();
      return true;
   }

   private boolean[] method01940() {
      WardenBotController.Nested54 var1 = new WardenBotController.Nested54();
      NonNullList<ItemStack> var2 = this.field04797.method01747().getInventory().getNonEquipmentItems();
      boolean[] var3 = new boolean[var2.size()];

      for (int var4 = 0; var4 < var2.size(); var4++) {
         ItemStack var5 = (ItemStack)var2.get(var4);
         var3[var4] = var5.isEmpty() || var1.method02112(var5);
      }

      return var3;
   }

   private boolean method01941() {
      return this.field04797.method01752().dimension() == Level.OVERWORLD
         && this.field04797.method01747().getX() >= field04914
         && this.field04797.method01747().getX() <= field04915
         && this.field04797.method01747().getZ() >= field04916
         && this.field04797.method01747().getZ() <= field04917;
   }

   private boolean method01942() {
      return this.method01946(MobEffects.DARKNESS);
   }

   private void method01943(AbstractContainerMenu var1, List<Slot> var2) {
      int var3 = 0;

      for (Slot var5 : var2) {
         if (var3++ >= 3) {
            return;
         }

         this.method02003(var1, var5, 0, ClickType.QUICK_MOVE);
      }
   }

   private boolean method01945() {
      if (this.method01942()) {
         return true;
      }

      if (!this.field04797.method02628()) {
         return false;
      }

      for (Entity var2 : this.field04797.method01752().entitiesForRendering()) {
         if (var2 instanceof Warden var3) {
            double var4 = this.field04797.method01747().distanceToSqr(var3);
            if (var4 < field04998 && this.method01961(var3) && (var4 < field04999 || this.method02008(var3))) {
               return true;
            }
         }
      }

      return false;
   }

   private boolean method01946(Holder<MobEffect> var1) {
      return this.method02086(var1) != null;
   }

   private long method01947() {
      return Math.min(field04948, Math.max(0L, this.field04797.method01756()));
   }

   private void method01948() {
      if (!this.method02098() && !this.field04797.method02627() && this.method02015()) {
         Vec3 var1 = this.field04797.method01747().position();
         if (this.field04850 == null || var1.distanceToSqr(this.field04850) > field04885) {
            this.field04850 = var1;
            this.field04805.method04694();
         } else if (this.field04805.method04699(field04886)) {
            this.field04850 = var1;
            this.field04805.method04694();
            this.method02016();
            this.field04832 = null;
            if (++this.field04849 >= 3) {
               this.field04849 = 0;
               this.field04836 = -1;
               this.field04799.clear();
               this.field04800.clear();
               this.field04801.clear();
               this.method01972();
            }
         }
      } else {
         this.field04850 = null;
         this.field04805.method04694();
      }
   }

   private void method01949() {
      int var1 = this.field04797.method01743();
      if (var1 >= 0 && !this.field04851 && this.field04836 == var1) {
         this.field04836 = -1;
      }
   }

   private BlockPos method01950() {
      BlockPos var1 = this.field04797.method01747().blockPosition();
      MutableBlockPos var2 = new MutableBlockPos();
      BlockPos var3 = null;
      double var4 = field05038;

      for (int var6 = -16; var6 <= 16; var6++) {
         for (int var7 = -6; var7 <= 6; var7++) {
            for (int var8 = -16; var8 <= 16; var8++) {
               var2.set(var1.getX() + var6, var1.getY() + var7, var1.getZ() + var8);
               if (this.field04797.method01752().getBlockState(var2).is(Blocks.CHEST)
                  && this.method02035(var2)
                  && this.field04797.method01752().getBlockState(var2.above()).isAir()) {
                  double var9 = this.field04797.method01747().distanceToSqr(Vec3.atCenterOf(var2));
                  if (!(var9 >= var4)) {
                     var4 = var9;
                     var3 = var2.immutable();
                  }
               }
            }
         }
      }

      return var3;
   }

   private long method01951(BlockPos var1) {
      double var2 = Math.sqrt(this.field04797.method01747().distanceToSqr(Vec3.atCenterOf(var1)));
      return Math.max(field04944, (long)(var2 / field04945 * field04946) + field04947);
   }

   private boolean method01952() {
      return !this.method02041() ? false : this.method02083() && (this.method02014() || this.method01964() && this.method01939());
   }

   private Vec3 method01953(Vec3 var1, BlockPos var2) {
      Vec3 var3 = Vec3.atCenterOf(var2);
      if (this.method02102(var1, var3).getBlockPos().equals(var2)) {
         return var3;
      }

      Vec3 var4 = null;
      double var5 = field04966;

      for (double var7 = field04967; var7 <= field04968; var7 += field04975) {
         for (double var9 = field04969; var9 <= field04970; var9 += field04974) {
            for (double var11 = field04971; var11 <= field04972; var11 += field04973) {
               Vec3 var13 = var3.add(var7, var9, var11);
               double var14 = var13.distanceToSqr(var3);
               if (!(var14 >= var5) && this.method02102(var1, var13).getBlockPos().equals(var2)) {
                  var5 = var14;
                  var4 = var13;
               }
            }
         }
      }

      return var4;
   }

   private BlockPos method01954(BlockPos var1) {
      int var2 = this.field04845 / 60;
      double var3 = var2 * field04949;
      double var5 = var2 % 2 == 0 ? field04950 : field04951;
      return new BlockPos(
         this.method02025(var1.getX() + (int)(Math.cos(var3) * var5)), var1.getY(), this.method01959(var1.getZ() + (int)(Math.sin(var3) * var5))
      );
   }

   private boolean method01955() {
      if (this.method01971()) {
         this.field04833 = null;
         return false;
      }

      BlockPos var1 = this.method01988();
      if (var1 == null) {
         this.field04833 = null;
         return false;
      }

      if (!var1.equals(this.field04833)) {
         this.field04833 = var1;
         this.field04814.method04694();
      }

      if (this.field04814.method04699(field04928)) {
         this.field04828.add(var1);
         this.field04833 = null;
         return true;
      } else {
         this.method02070(var1);
         return true;
      }
   }

   private void method01956() {
      int var1 = this.field04797.method01747().getBlockY();
      this.field04831 = new AABB(field05012, var1, field05013, field05014, var1, field05015);
   }

   private int method01957() {
      int var1 = 0;

      for (boolean var5 : this.method01940()) {
         if (!var5) {
            var1++;
         }
      }

      return var1;
   }

   private boolean method01958() {
      return this.field04797.method01752().dimension() == Level.OVERWORLD
         && this.field04797.method01747().getX() >= field05008
         && this.field04797.method01747().getX() <= field05009
         && this.field04797.method01747().getZ() >= field05010
         && this.field04797.method01747().getZ() <= field05011;
   }

   private int method01959(int var1) {
      return this.field04831 == null ? var1 : (int)GuiHitTestUtils.method05610(this.field04831.minZ + field05018, this.field04831.maxZ - field05019, var1);
   }

   private void method01960(int var1, boolean var2) {
      if (var1 < 0 || var1 == this.field04797.method01743()) {
         this.field04865 = -1;
      } else if (this.field04865 != var1 || this.field04824.method04699(field04905)) {
         if (var2 || this.field04820.method04699(field04906) || this.field04842 < 4) {
            if (this.field04819.method04699(field04907)) {
               this.field04819.method04694();
               this.field04842 = 0;
            }

            if (!var2 && ++this.field04842 > 4) {
               this.field04820.method04694();
               this.method02032(field04908);
               this.method02094();
               this.field04829 = WardenBotController.Nested53.COLLECTING;
            } else {
               this.field04865 = var1;
               this.field04824.method04694();
               this.field04797.method01751("an" + var1);
            }
         }
      }
   }

   private boolean method01961(Warden var1) {
      double var2 = Math.toDegrees(Math.atan2(-(this.field04797.method01747().getX() - var1.getX()), this.field04797.method01747().getZ() - var1.getZ()));
      return Math.abs(((var1.yBodyRot - var2) % field05001 + field05002) % field05003 - field05004) < field05005;
   }

   private int method01963() {
      int var1 = 0;

      for (ItemStack var3 : this.field04797.method01747().getInventory().getNonEquipmentItems()) {
         if (this.method02087(var3)) {
            var1++;
         }
      }

      return var1;
   }

   private boolean method01964() {
      return this.method01963() < 1 || this.method01965(Items.GOLDEN_CARROT) < 3 || this.method02100().useSpeed() && this.method02057(this::method01995) < 0;
   }

   private int method01965(Item var1) {
      int var2 = 0;

      for (ItemStack var4 : this.field04797.method01747().getInventory().getNonEquipmentItems()) {
         if (var4.is(var1)) {
            var2 += var4.getCount();
         }
      }

      return var2;
   }

   private void method01966() {
      this.field04797.method01757(this.field04830 != null && this.field04830.method02119());
   }

   private void method01967() {
      boolean var1 = this.method01993() == null
         && (
            this.method02101()
               || !this.method01945()
                  && this.field04829 == WardenBotController.Nested53.COLLECTING
                  && this.method01958()
                  && !this.field04797.method02627()
                  && !this.method01991()
                  && !this.method02098()
                  && !this.method01992()
                  && this.method02042()
         );
      this.field04860 = var1 ? this.field04860 + 1 : 0;
      this.field04861 = this.field04860 >= 20;
   }

   private void method01968(boolean var1) {
      if (!var1 && this.field04797.method01743() >= 0) {
         if (++this.field04812 >= 40) {
            this.field04811 = true;
         }
      } else {
         this.field04812 = 0;
      }
   }

   private BlockPos method01969(boolean var1) {
      BlockPos var2 = this.field04797.method01747().blockPosition();
      MutableBlockPos var3 = new MutableBlockPos();
      BlockPos var4 = null;
      double var5 = field05036;

      for (int var7 = -4; var7 <= 4; var7++) {
         for (int var8 = -4; var8 <= 4; var8++) {
            for (int var9 = -4; var9 <= 4; var9++) {
               var3.set(var2.getX() + var7, var2.getY() + var8, var2.getZ() + var9);
               double var10 = this.field04797.method01747().getEyePosition().distanceToSqr(Vec3.atCenterOf(var3));
               if (!(var10 > field05037)
                  && !(var10 >= var5)
                  && this.method02081(var3, var1)
                  && this.method02102(this.field04797.method01747().getEyePosition(), Vec3.atCenterOf(var3)).getBlockPos().equals(var3)) {
                  var5 = var10;
                  var4 = var3.immutable();
               }
            }
         }
      }

      return var4;
   }

   private void method01970() {
      this.method01967();
      if (this.method02046() && this.field04797.method01747().getMainHandItem().isEmpty() && !this.method02107(field04894)) {
         this.field04797.method01770(this.field04845 % 10 <= GuiHitTestUtils.method05613(field04895, field04896) ? -1 : 1);
      } else {
         this.field04797.method01770(0);
      }
   }

   private boolean method01971() {
      return this.method01945()
         || this.field04813.method04699(field04929)
         || this.method01957() >= this.method02100().lootLimit() * 2
         || this.field04797.method01747().getFoodData().getFoodLevel() < 8;
   }

   private void method01972() {
      int var1 = this.field04797.method01743();
      if (var1 >= 0) {
         if (!this.field04852 && this.method01941()) {
            this.method02039(this.method02104());
         } else if (this.field04839 < 0) {
            if (this.field04836 != var1 || this.field04804.method04699(field04918)) {
               if (this.field04867 >= 3) {
                  this.method02039(this.method02104());
               } else {
                  this.field04867++;
                  if (this.field04836 == var1 && this.field04851 && ++this.field04868 >= 2) {
                     this.field04868 = 0;
                     this.field04797.method01753(var1);
                  }

                  this.field04851 = this.field04797.method01768(var1);
                  this.field04836 = var1;
                  this.field04804.method04694();
                  if (this.field04851) {
                     this.field04797.method01751(field04919);
                  } else {
                     this.field04797.method01751(field04920);
                     this.field04839 = this.field04845 + 20;
                  }
               }
            }
         }
      }
   }

   private boolean method01973() {
      return this.field04847 <= 0 && !this.field04797.method01778() && !this.method01991() && !this.method01992();
   }

   private boolean method01974() {
      if (!this.field04797.method02627()) {
         this.field04856 = null;
         return true;
      }

      if (this.method01998()) {
         return false;
      }

      if (!this.method02109()) {
         this.field04848 = 0;
      } else {
         if (this.field04848 < 6) {
            if (this.method01975()) {
               this.field04848++;
            }

            return false;
         }

         if (this.method02006()) {
            return false;
         }
      }

      if (!this.method01973()) {
         return false;
      }

      this.field04847 = 2;
      this.field04797.method01759(() -> {
         if (this.field04797.method01765() != null && !this.method01991()) {
            this.field04797.method01771();
         }
      });
      return false;
   }

   private boolean method01975() {
      return this.method01987(var1 -> {
         ItemStack var2 = var1.getCarried();
         if (!var2.isEmpty()) {
            Predicate<ItemStack> var3 = var1x -> var1x.isEmpty() || ItemStack.isSameItemSameComponents(var1x, var2);
            Slot var4 = this.method02007(var1, false, var3);
            this.method02003(var1, var4 != null ? var4 : this.method02007(var1, true, var3), 0, ClickType.PICKUP);
         }
      });
   }

   private int method01976(int var1) {
      AbstractContainerMenu var2 = this.field04797.method01765();
      if (var2 == null) {
         return var1;
      }

      for (Slot var4 : var2.slots) {
         if (var4.container == this.field04797.method01747().getInventory() && var4.getContainerSlot() == var1) {
            return var4.index;
         }
      }

      return -1;
   }

   private static Predicate<ItemStack> method01977(ItemStack var0) {
      return var1 -> var1.isEmpty() || ItemStack.isSameItemSameComponents(var1, var0);
   }

   private BlockPos method01978(BlockPos var1, boolean var2) {
      ArrayList var3 = new ArrayList();
      MutableBlockPos var4 = new MutableBlockPos();
      int var5 = var2 ? field05024 : field05025;

      for (int var6 = -24; var6 <= 24; var6++) {
         for (int var7 = -24; var7 <= 24; var7++) {
            for (int var8 = -8; var8 <= 8; var8++) {
               var4.set(var1.getX() + var6, var1.getY() + var8, var1.getZ() + var7);
               if (!this.field04827.contains(var4) && this.method02081(var4, var2)) {
                  var3.add(var4.immutable());
                  var5 = var2 ? Math.min(var5, var4.getY()) : Math.max(var5, var4.getY());
               }
            }
         }
      }

      BlockPos var14 = null;
      double var15 = field05026;

      for (BlockPos var10 : (Iterable<BlockPos>) (Iterable) var3) {
         int var11 = var2 ? var10.getY() - var5 : var5 - var10.getY();
         double var12 = this.field04797.method01747().distanceToSqr(Vec3.atCenterOf(var10)) + field05027 * var11 * var11;
         if (!(var12 >= var15) && this.method02080(var10)) {
            var15 = var12;
            var14 = var10;
         }
      }

      return var14;
   }

   private boolean method01979(double var1) {
      for (Player var4 : this.field04797.method01752().players()) {
         if (var4 != this.field04797.method01747() && this.field04797.method01747().distanceToSqr(var4) < var1 * var1) {
            return true;
         }
      }

      return false;
   }

   private boolean method01981(BlockPos var1, double var2) {
      for (Player var5 : this.field04797.method01752().players()) {
         if (var5 != this.field04797.method01747() && var5.position().distanceToSqr(Vec3.atCenterOf(var1)) < var2 * var2) {
            return true;
         }
      }

      return false;
   }

   private boolean method01982(BlockPos var1) {
      for (Player var3 : this.field04797.method01752().players()) {
         if (var3 != this.field04797.method01747() && !(var3.position().distanceToSqr(Vec3.atCenterOf(var1)) >= field05007) && method02111(var3)) {
            return true;
         }
      }

      return false;
   }

   private void method01983() {
      AbstractContainerMenu var1 = this.field04797.method01765();
      if (var1 != null) {
         this.method02079(var1);
      } else {
         BlockPos var2 = this.method02069();
         if (var2 == null) {
            var2 = this.method02031();
         }

         boolean var3 = var2 != null
            && this.field04832 != null
            && !var2.equals(this.field04832)
            && this.field04797.method01766().method05349(this.field04832) > field04937;
         if (!var3) {
            this.field04803.method04694();
         }

         if (!var3 || this.field04803.method04699(field04938)) {
            this.field04832 = var2;
         }

         if (this.field04832 == null) {
            if (this.field04845 % 40 == 0) {
               if (++this.field04872 < 5) {
                  this.method02038();
               } else {
                  this.field04872 = 0;
                  this.field04836 = -1;
                  this.field04799.clear();
                  this.field04800.clear();
                  this.field04801.clear();
                  this.method01972();
               }
            }
         } else {
            this.field04872 = 0;
            this.method02070(this.field04832);
         }
      }
   }

   private String method01985() {
      StringBuilder var1 = new StringBuilder();

      for (MobEffectInstance var3 : this.field04797.method01747().getActiveEffects()) {
         if (!var1.isEmpty()) {
            var1.append(',');
         }

         var1.append(var3.getEffect().getRegisteredName()).append('x').append(var3.getDuration());
      }

      return "мозг state="
         + this.field04829
         + " anarchy="
         + this.field04797.method01743()
         + " rejoinTarget="
         + this.field04837
         + " контейнер="
         + this.field04797.method02627()
         + " эффекты=["
         + var1
         + "] задача="
         + this.method02098()
         + " лут="
         + this.method01957()
         + " банк="
         + (this.field04853 ? field04901 : field04902)
         + " пополнение="
         + (this.field04841 ? field04903 : field04904)
         + " хранилище="
         + this.field04855
         + " клик="
         + this.method02050();
   }

   private void method01986(int var1) {
      if (var1 >= 0 && this.field04830 == null) {
         if (var1 <= 8 || !this.field04797.method02627()) {
            if (!this.field04797.method01778()) {
               this.field04830 = new WardenBotController.Nested55(var1);
            }
         }
      }
   }

   private boolean method01987(final Consumer<AbstractContainerMenu> var1) {
      if (!this.method01973()) {
         return false;
      }

      this.field04847 = 2;
      this.field04797.method01759(new Runnable()      // $VF: Compiled from s
 {
         @Override
         public void run() {
            AbstractContainerMenu var1x = WardenBotController.this.field04797.method01765();
            if (var1x != null) {
               if (WardenBotController.this.method01991()) {
                  WardenBotController.this.field04797.method01759(this);
               } else {
                  var1.accept(var1x);
               }
            }
         }
      });
      return true;
   }

   private BlockPos method01988() {
      BlockPos var1 = null;
      double var2 = field04930;

      for (BlockPos var5 : this.field04797
         .method01766()
         .method05348(this.field04797.method01752(), this.field04797.method01747(), this.field04797.method01743())) {
         if (!this.field04828.contains(var5) && this.method02080(var5) && !this.method02090(var5) && !this.method01982(var5)) {
            long var6 = this.field04797.method01766().method05349(var5);
            if (var6 <= field04931 && (var6 >= 0L || this.field04799.getOrDefault(var5, 0) < 3)) {
               double var8 = this.field04797.method01747().distanceToSqr(Vec3.atCenterOf(var5));
               if (!(var8 >= var2)) {
                  var2 = var8;
                  var1 = var5;
               }
            }
         }
      }

      return var1;
   }

   private boolean method01989() {
      return this.field04817.method04699(field04911);
   }

   private boolean method01990() {
      BlockPos var1 = this.method01993();
      if (var1 == null) {
         this.field04816.method04694();
         return false;
      }

      if (this.field04816.method04699(field04996)) {
         this.field04816.method04694();
         this.method02005(false);
      }

      this.method02005(false);
      return true;
   }

   private boolean method01991() {
      LocalPlayer var1 = this.field04797.method01747();
      double var2 = var1.getX() - var1.xo;
      double var4 = var1.getZ() - var1.zo;
      return var2 * var2 + var4 * var4 > field04997;
   }

   private boolean method01992() {
      return this.field04797.method01775().getPathingBehavior().hasPath();
   }

   private BlockPos method01993() {
      BlockPos var1 = this.field04797.method01747().blockPosition();
      if (this.method02047(var1)) {
         return var1;
      } else if (this.method02047(var1.above())) {
         return var1.above();
      } else {
         return this.method02047(var1.below()) ? var1.below() : null;
      }
   }

   private boolean method01994(BlockPos var1) {
      if (this.field04797.method01766().method05349(var1) > this.method01947()) {
         this.field04801.remove(var1);
         return false;
      } else {
         Long var2 = this.field04801.get(var1);
         if (var2 == null) {
            this.field04801.put(var1, System.currentTimeMillis());
            return false;
         } else {
            return System.currentTimeMillis() - var2 >= 0L;
         }
      }
   }

   private boolean method01995(ItemStack var1) {
      if (!var1.is(Items.POTION)) {
         return false;
      }

      for (MobEffectInstance var3 : var1.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY).getAllEffects()) {
         if (var3.getEffect().is(MobEffects.SPEED.unwrapKey().orElseThrow())) {
            return true;
         }
      }

      return false;
   }

   private void method01997() {
      if (this.field04830 != null) {
         if (this.field04845 > 40) {
            if (this.field04830.method02115()) {
               this.field04830 = null;
            }
         }
      }
   }

   private boolean method01998() {
      if (!this.field04797.method01773()) {
         return false;
      }

      AbstractContainerMenu var1 = this.field04797.method01765();
      return var1 == null ? false : var1.containerId == 0 || this.field04856 == null && this.field04845 > this.field04859;
   }

   public List<Integer> method01999() {
      return this.field04798;
   }

   private static void method02001() {
      synchronized (field04780) {
         if (field04782++ <= 0) {
            Settings var1 = BaritoneAPI.getSettings();
            field04785 = var1.allowBreak.value;
            field04786 = var1.allowPlace.value;
            field04789 = var1.primaryTimeoutMS.value;
            field04790 = var1.failureTimeoutMS.value;
            field04791 = var1.planAheadPrimaryTimeoutMS.value;
            field04792 = var1.planAheadFailureTimeoutMS.value;
            field04783 = var1.avoidance.value;
            field04787 = var1.allowDiagonalAscend.value;
            field04788 = var1.allowDiagonalDescend.value;
            field04793 = var1.maxFallHeightNoWater.value;
            field04784 = var1.blockFreeLook.value;
            field04794 = var1.randomLooking.value;
            field04795 = var1.randomLooking113.value;
            field04796 = var1.blocksToAvoid.value;
            var1.allowBreak.value = false;
            var1.allowPlace.value = false;
            var1.avoidance.value = true;
            var1.allowDiagonalAscend.value = true;
            var1.allowDiagonalDescend.value = true;
            var1.maxFallHeightNoWater.value = 256;
            var1.primaryTimeoutMS.value = field04875;
            var1.failureTimeoutMS.value = field04876;
            var1.planAheadPrimaryTimeoutMS.value = field04877;
            var1.planAheadFailureTimeoutMS.value = field04878;
            var1.blockFreeLook.value = true;
            var1.randomLooking.value = 0.0;
            var1.randomLooking113.value = 0.0;
            var var2 = new ArrayList(field04796);

            for (Block var4 : field04781) {
               if (!var2.contains(var4)) {
                  var2.add(var4);
               }
            }

            var1.blocksToAvoid.value = var2;
         }
      }
   }

   private boolean method02002() {
      return this.field04831 != null
         && this.field04797.method01747().getX() >= this.field04831.minX
         && this.field04797.method01747().getX() <= this.field04831.maxX
         && this.field04797.method01747().getZ() >= this.field04831.minZ
         && this.field04797.method01747().getZ() <= this.field04831.maxZ;
   }

   private void method02003(AbstractContainerMenu var1, Slot var2, int var3, ClickType var4) {
      if (var2 != null) {
         this.field04797.method01776(var2.index, var3, var4);
      }
   }

   private List<Slot> method02004(AbstractContainerMenu var1) {
      boolean[] var2 = this.method01940();
      ArrayList var3 = new ArrayList();

      for (Slot var5 : var1.slots) {
         if (var5.container == this.field04797.method01747().getInventory() && !var5.getItem().isEmpty()) {
            int var6 = var5.getContainerSlot();
            if (var6 < var2.length && !var2[var6]) {
               var3.add(var5);
            }
         }
      }

      return var3;
   }

   private void method02005(boolean var1) {
      if (this.method01974()) {
         this.method02096();
         if (this.field04809 != null
            && !this.field04810.method04699(field04990)
            && this.field04797.method01747().position().distanceToSqr(Vec3.atCenterOf(this.field04809)) > field04991) {
            this.method02039(this.field04809);
         } else {
            BlockPos var2 = null;
            double var3 = field04992;
            int var5 = this.field04797.method01747().getBlockY();

            for (byte var6 = 0; var6 < 360; var6 += 30) {
               int var7 = this.method02025((int)(this.field04797.method01747().getX() + Math.cos(Math.toRadians(var6)) * field04993));
               int var8 = this.method01959((int)(this.field04797.method01747().getZ() + Math.sin(Math.toRadians(var6)) * field04994));
               double var9 = this.method02028(var7, var8, var1);
               if (!(var9 <= var3)) {
                  var3 = var9;
                  var2 = new BlockPos(var7, var5, var8);
               }
            }

            this.field04809 = var2;
            this.field04810.method04694();
            this.method02039(var2);
         }
      }
   }

   private boolean method02006() {
      return this.method01987(var1 -> {
         if (!var1.getCarried().isEmpty()) {
            this.field04797.method01776(-999, 0, ClickType.PICKUP);
         }
      });
   }

   private Slot method02007(AbstractContainerMenu var1, boolean var2, Predicate<ItemStack> var3) {
      for (Slot var5 : var1.slots) {
         if (var5.container == this.field04797.method01747().getInventory() == var2 && var3.test(var5.getItem())) {
            return var5;
         }
      }

      return null;
   }

   private boolean method02008(Warden var1) {
      return (this.field04797.method01747().getX() - var1.getX()) * (var1.getX() - var1.xOld)
            + (this.field04797.method01747().getZ() - var1.getZ()) * (var1.getZ() - var1.zOld)
         > field05000;
   }

   private boolean method02009(BlockPos var1, int var2) {
      if (var1 != null && !this.field04797.method02627()) {
         Vec3 var3 = this.field04797.method01747().getEyePosition();
         Vec3 var4 = this.method01953(var3, var1);
         if (var4 == null) {
            return false;
         }

         Rotation var5 = Rotation.method09438(var4.subtract(var3));
         float var6 = this.field04845;
         float var7 = (float)(
            (
                  Math.sin(var6 * field04976) * field04977
                     + Math.sin(var6 * field04978 + field04979) * field04980
                     + Math.sin(var6 * field04981 + field04982) * field04983
               )
               * field04984
         );
         this.field04797
            .method01772(
               new Rotation(var5.method09439() + var7, GuiHitTestUtils.method05615(field04985, field04986, var5.method09443() + var7 / field04987)),
               field04988
            );
         if (var2 > 0 && this.field04845 % var2 == 0 && this.field04845 >= this.field04862) {
            BlockHitResult var8 = this.method02102(var3, var3.add(method02052(this.field04797.method01762()).scale(field04989)));
            if (!var8.getBlockPos().equals(var1)) {
               return false;
            }

            this.field04797.method01750(var8);
            this.field04797.method01748();
            this.field04856 = var1;
            this.field04859 = this.field04845 + 20;
            this.field04862 = this.field04845 + 6;
            return true;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private int method02010() {
      int var1 = 0;

      for (ItemStack var3 : this.field04797.method01747().getInventory().getNonEquipmentItems()) {
         if (!var3.isEmpty()) {
            var1++;
         }
      }

      return var1;
   }

   private List<Slot> method02011(AbstractContainerMenu var1, boolean var2, Predicate<ItemStack> var3) {
      ArrayList var4 = new ArrayList();

      for (Slot var6 : var1.slots) {
         if (var6.container == this.field04797.method01747().getInventory() == var2 && var3.test(var6.getItem())) {
            var4.add(var6);
         }
      }

      return var4;
   }

   private static Set<Block> method02012() {
      HashSet var0 = new HashSet();

      for (Block var2 : BuiltInRegistries.BLOCK) {
         if (var2.defaultBlockState().is(BlockTags.CANDLES) || field04715.contains(var2)) {
            var0.add(var2);
         }
      }

      return var0;
   }

   private boolean method02014() {
      return this.method01957() > 0;
   }

   private boolean method02015() {
      Goal var1 = this.field04797.method01775().getCustomGoalProcess().getGoal();
      return var1 != null && !var1.isInGoal(this.field04797.method01747().blockPosition());
   }

   private boolean method02016() {
      this.field04797.method01775().getCustomGoalProcess().setGoal(null);
      return this.field04797.method01775().getPathingBehavior().cancelEverything();
   }

   private BlockPos method02017(boolean var1) {
      BlockPos var2 = this.field04797.method01747().blockPosition();
      if (this.field04855 != null
         && var1 == this.field04854
         && this.field04845 - this.field04864 < 40
         && var2.distSqr(this.field04863) < field05023
         && this.method02081(this.field04855, var1)) {
         return this.field04855;
      }

      this.field04854 = var1;
      this.field04864 = this.field04845;
      this.field04863 = var2;
      this.field04855 = this.method01978(var2, var1);
      return this.field04855;
   }

   private void method02018() {
      if (this.method01989()) {
         if (this.field04855 != null) {
            this.field04827.add(this.field04855);
         }

         this.field04855 = null;
         if (this.method01974()) {
            this.method02032(field04897);
            this.method02094();
            this.field04829 = WardenBotController.Nested53.COLLECTING;
         }
      } else if (!this.method01952()) {
         if (this.method01974()) {
            this.field04829 = WardenBotController.Nested53.COLLECTING;
         }
      } else if (this.method02091() >= 0
         && this.field04797.method01743() != this.method02091()
         && !this.field04797.method01777()
         && this.field04845 % 5 == 0
         && this.method02099()) {
         this.method02066(this.method02091());
      } else if (this.method02089() && !this.method02098()) {
         this.method02096();
         this.method02049(this.method02014(), true, WardenBotController.Nested53.TAKE);
      }
   }

   private boolean method02019(ItemStack var1) {
      Item var2 = var1.getItem();
      return new ItemStack(var2).is(net.minecraft.tags.ItemTags.SHOVELS)
         || new ItemStack(var2).is(net.minecraft.tags.ItemTags.AXES)
         || var2 instanceof BannerItem
         || var2 instanceof SmithingTemplateItem && !var1.is(Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE)
         || var1.is(Items.BLAZE_ROD)
         || var1.is(Items.ENCHANTED_BOOK)
         || var1.is(Items.TRIDENT)
         || var1.is(Items.NAME_TAG)
         || var1.is(Items.SCULK)
         || var1.is(Items.SCULK_SENSOR)
         || var1.is(Items.ENDER_CHEST)
         || var1.is(Items.REINFORCED_DEEPSLATE)
         || var1.is(Items.PUFFERFISH)
         || var1.is(Items.HONEY_BOTTLE)
         || var1.is(Items.FERMENTED_SPIDER_EYE)
         || var1.is(Items.ANVIL)
         || var1.is(Items.COOKED_PORKCHOP);
   }

   private void method02020() {
      if (this.field04797.method01747().getFoodData().getFoodLevel() < 18) {
         this.method01986(
            this.method02057(var0 -> var0.has(DataComponents.FOOD) && !var0.has(DataComponents.CUSTOM_NAME) && !field04741.contains(var0.getItem()))
         );
      }
   }

   public boolean method02021() {
      return this.field04797.method01747() != null && this.field04797.method01752() != null && this.method02017(true) != null;
   }

   private BlockPos method02022() {
      BlockPos var1 = this.field04797.method01747().blockPosition();
      if (this.field04797.method01752().getBlockState(var1).is(BlockTags.CANDLES)) {
         return var1;
      }

      BlockPos var2 = var1.below();
      return this.field04797.method01752().getBlockState(var2).is(BlockTags.CANDLES) ? var2 : null;
   }

   private boolean method02023() {
      return this.method02056() && this.method02057(this::method01995) < 0;
   }

   private int method02024() {
      int var1 = 0;

      for (int var3 : this.field04799.values()) {
         if (var3 >= 2) {
            var1++;
         }
      }

      return var1;
   }

   private int method02025(int var1) {
      return this.field04831 == null ? var1 : (int)GuiHitTestUtils.method05610(this.field04831.minX + field05016, this.field04831.maxX - field05017, var1);
   }

   private boolean method02026(BlockPos var1, BlockPos var2) {
      return this.method01953(Vec3.atCenterOf(var1).add(0.0, this.field04797.method01747().getEyeHeight() - field04965, 0.0), var2) != null;
   }

   private boolean method02027(ItemStack var1, String var2) {
      CustomData var3 = var1.get(DataComponents.CUSTOM_DATA);
      return var3 != null && var2.equals(var3.copyTag().getCompoundOrEmpty(field05034).getStringOr(field05035, ""));
   }

   private double method02028(int var1, int var2, boolean var3) {
      double var4 = field04995;

      for (Entity var7 : this.field04797.method01752().entitiesForRendering()) {
         if (var7 != this.field04797.method01747() && (var7 instanceof Player || var3 && var7 instanceof Warden)) {
            var4 = Math.min(var4, Math.hypot(var7.getX() - var1, var7.getZ() - var2));
         }
      }

      return var4;
   }

   private void method02029() {
      if (this.method01945()) {
         if (!this.method01942() || !this.method02061()) {
            this.method02005(true);
         }
      } else if (this.method02083() && this.method02089() && this.method01952()) {
         this.field04829 = WardenBotController.Nested53.SAVE;
      } else if (this.field04797.method02627()) {
         this.method01983();
      } else if (!this.method01955()) {
         if (!this.field04797.method01777()) {
            this.field04829 = this.method01952() ? WardenBotController.Nested53.SAVE : WardenBotController.Nested53.COLLECTING;
         } else {
            BlockPos var1 = this.method02069();
            int var2 = this.field04797.method01745();
            if (this.method02010() < 23 && !this.method01979(field04913) && (var2 < 0 || var2 > 16) && var1 != null) {
               this.method01983();
            } else {
               this.method02005(true);
            }
         }
      }
   }

   private boolean method02030() {
      if (this.method01942()) {
         this.method02038();
         return true;
      }

      boolean var1 = this.method01945();
      boolean var2 = this.field04845 % 30 == 0 && this.method02024() >= 3;
      if (this.field04845 <= 100
         || !var1 && this.method02010() <= this.method02106(20) && this.field04797.method01747().getFoodData().getFoodLevel() >= 8 && !var2) {
         if (this.method02099() && this.method02083() && !this.field04797.method01777() && this.method01957() >= this.method02085()) {
            this.method02038();
            return true;
         } else {
            int var3 = this.field04797.method01745();
            if (var3 >= 0 && var3 < 7 && !this.method01979(field04932) && this.method01957() >= Math.max(1, this.method02085() - 1)) {
               this.method02038();
               return true;
            } else {
               return false;
            }
         }
      } else {
         if (var1) {
            this.field04852 = true;
         }

         this.method02038();
         return true;
      }
   }

   private BlockPos method02031() {
      BlockPos var1 = null;
      long var2 = field04952;
      double var4 = field04953;

      for (BlockPos var7 : this.field04797
         .method01766()
         .method05348(this.field04797.method01752(), this.field04797.method01747(), this.field04797.method01743())) {
         if (this.method02080(var7) && !this.method02090(var7) && !this.method01982(var7)) {
            long var8 = Math.max(0L, this.field04797.method01766().method05349(var7));
            double var10 = this.field04797.method01747().distanceToSqr(Vec3.atCenterOf(var7));
            if (var8 <= var2 && (var8 != var2 || !(var10 >= var4))) {
               var2 = var8;
               var4 = var10;
               var1 = var7;
            }
         }
      }

      return var1;
   }

   private void method02032(String var1) {
      this.field04797.method01755("банк отложен: " + var1 + " | " + this.method01985());
      this.field04853 = true;
      this.field04825.method04694();
   }

   private void method02033() {
      MobEffectInstance var1 = this.method02086(MobEffects.INVISIBILITY);
      boolean var2 = this.method01946(MobEffects.GLOWING) || var1 != null && var1.getDuration() >= 400;
      if (!this.method02083() || !this.method01939() || this.field04797.method01777() || (var2 || this.method01963() >= 1) && !this.method02023()) {
         if (!var2) {
            this.method01986(this.method02057(this::method02087));
         }

         if (!this.method01958()) {
            if (this.method01952()) {
               this.method02038();
            } else {
               this.method01972();
            }
         } else if (var2 || !this.method02098() && this.method01963() <= 0) {
            int var3 = this.method02056() ? this.method02057(this::method01995) : -1;
            if (var3 < 0) {
               this.method01983();
            } else {
               this.method01986(var3);
            }
         }
      } else {
         this.method02038();
      }
   }

   private boolean method02034(ItemStack var1) {
      Item var2 = var1.getItem();
      return var2 instanceof ArrowItem
         || new ItemStack(var2).is(net.minecraft.tags.ItemTags.AXES)
         || var1.is(ItemTags.PICKAXES)
         || var1.is(Items.CHORUS_FRUIT)
         || var1.is(Items.DISC_FRAGMENT_5)
         || var1.is(Items.NAUTILUS_SHELL)
         || var1.is(Items.BOOKSHELF)
         || var1.is(Items.COOKED_MUTTON)
         || var1.is(Items.SKELETON_SPAWN_EGG)
         || var1.is(Items.CREEPER_SPAWN_EGG)
         || var1.is(Items.ZOMBIE_SPAWN_EGG)
         || var1.is(Items.VINDICATOR_SPAWN_EGG)
         || var1.is(Items.PIGLIN_SPAWN_EGG)
         || var1.is(Items.FIRE_CHARGE)
         || var1.is(Items.LEATHER)
         || var1.is(Items.SHULKER_SHELL)
         || var1.is(Items.EXPERIENCE_BOTTLE)
         || var1.is(Items.WITHER_ROSE)
         || var1.is(Items.EMERALD)
         || var1.is(Items.SUGAR)
         || var1.has(DataComponents.JUKEBOX_PLAYABLE)
         || var1.is(Items.GHAST_TEAR)
         || var1.is(Items.DRAGON_BREATH)
         || var1.is(Items.VEX_SPAWN_EGG)
         || var1.is(Items.ENDERMITE_SPAWN_EGG)
         || var1.is(Items.CAT_SPAWN_EGG)
         || var1.is(Items.ENCHANTING_TABLE)
         || var1.is(Items.DIAMOND_HELMET)
         || var1.is(Items.DIAMOND_CHESTPLATE)
         || var1.is(Items.DIAMOND_LEGGINGS)
         || var1.is(Items.DIAMOND_BOOTS)
         || this.method02027(var1, field05033);
   }

   public WardenBotController(BotTask var1) {
      this.field04864 = field04873;
      this.field04865 = -1;
      this.field04866 = -1;
      this.field04870 = -1;
      this.field04871 = -1;
      this.field04797 = var1;
   }

   private boolean method02035(BlockPos var1) {
      if (this.field04797.method01752().getBlockState(var1.below()).is(Blocks.HOPPER)) {
         return true;
      }

      BlockState var2 = this.field04797.method01752().getBlockState(var1);
      if (!var2.hasProperty(BlockStateProperties.CHEST_TYPE)) {
         return false;
      }

      if (var2.getValue(BlockStateProperties.CHEST_TYPE) == ChestType.SINGLE) {
         return false;
      }

      for (Direction var4 : Plane.HORIZONTAL) {
         BlockPos var5 = var1.relative(var4);
         BlockState var6 = this.field04797.method01752().getBlockState(var5);
         if (var6.is(Blocks.CHEST)
            && var6.getValue(BlockStateProperties.CHEST_TYPE) != ChestType.SINGLE
            && var6.getValue(BlockStateProperties.CHEST_TYPE) != var2.getValue(BlockStateProperties.CHEST_TYPE)
            && var6.getValue(BlockStateProperties.HORIZONTAL_FACING) == var2.getValue(BlockStateProperties.HORIZONTAL_FACING)
            && this.field04797.method01752().getBlockState(var5.below()).is(Blocks.HOPPER)) {
            return true;
         }
      }

      return false;
   }

   private void method02036(boolean var1) {
      BlockPos var2 = this.method02017(var1);
      if (var2 == null) {
         if (this.field04845 % 100 == 0) {
            this.field04797.method01755("хранилище " + (var1 ? field05020 : field05021) + " не найдено в радиусе 24");
         }
      } else if (this.field04797.method01747().getEyePosition().distanceToSqr(Vec3.atCenterOf(var2)) <= field05022) {
         this.method02016();
         this.method02009(var2, 2);
      } else {
         this.method02039(this.method02093(var2));
      }
   }

   private void method02037() {
      int var1 = this.field04797.method01743();
      if (var1 >= 0 && this.field04838 < 0 && !this.field04797.method01768(var1)) {
         this.field04838 = this.field04845 + Math.round(GuiHitTestUtils.method05613(field04923, field04924));
      }
   }

   private void method02038() {
      if (this.field04829 != WardenBotController.Nested53.ESCAPE) {
         this.field04829 = WardenBotController.Nested53.ESCAPE;
         this.field04813.method04694();
         this.field04814.method04694();
         this.field04828.clear();
         this.field04833 = null;
      }
   }

   private void method02039(BlockPos var1) {
      if (var1 != null) {
         if (this.field04845 % 10 == 0 || !this.method01991() && this.field04845 % 5 == 0) {
            this.field04797.method01775().getCustomGoalProcess().setGoalAndPath(new GoalBlock(var1));
         }
      }
   }

   private int method02040(ItemStack var1) {
      if (this.method02019(var1)) {
         return 2;
      } else {
         return this.method02034(var1) ? 1 : 0;
      }
   }

   private boolean method02041() {
      if (!this.field04853) {
         return true;
      }

      if (!this.field04825.method04699(field04910)) {
         return false;
      }

      this.field04853 = false;
      this.field04827.clear();
      return true;
   }

   private boolean method02042() {
      AABB var1 = this.field04797.method01747().getBoundingBox();

      for (BlockPos var3 : BlockPos.betweenClosed(BlockPos.containing(var1.minX, var1.minY, var1.minZ), BlockPos.containing(var1.maxX, var1.maxY, var1.maxZ))) {
         VoxelShape var4 = this.field04797.method01752().getBlockState(var3).getCollisionShape(this.field04797.method01752(), var3);
         if (!var4.isEmpty() && var4.bounds().move(var3).intersects(var1)) {
            return true;
         }
      }

      return false;
   }

   public void method02043() {
      this.field04829 = WardenBotController.Nested53.COLLECTING;
      this.field04840 = WardenBotController.Nested53.COLLECTING;
      this.field04817.method04694();
      this.field04821.method04694();
      this.field04871 = -1;
      this.method02075();
      method02001();
   }

   private boolean method02044(ItemStack var1) {
      return this.method02100().priorityIs(field05031) ? false : this.method02019(var1) || this.method02100().priorityIs(field05032) && this.method02034(var1);
   }

   private void method02045() {
      int var1 = this.field04797.method01743();
      if (this.field04851) {
         this.field04797.method01754(var1);
      }

      this.field04868 = 0;
      this.field04867 = 0;
      this.field04872 = 0;
      if (!this.field04851 && this.field04838 < 0 && this.field04843 < 0) {
         this.field04838 = this.field04845 + Math.round(GuiHitTestUtils.method05613(field04925, field04926));
      }

      this.field04839 = -1;
      this.field04843 = -1;
      this.field04844 = null;
      this.field04836 = -1;
   }

   private boolean method02046() {
      return this.field04861;
   }

   private boolean method02047(BlockPos var1) {
      return field04715.contains(this.field04797.method01752().getBlockState(var1).getBlock());
   }

   private void method02049(boolean var1, boolean var2, WardenBotController.Nested53 var3) {
      if (!var1) {
         if (this.method01974()) {
            this.field04829 = var3;
         }
      } else {
         AbstractContainerMenu var4 = this.field04797.method01765();
         if (var4 != null) {
            if (var2) {
               this.method02058(var4);
            } else {
               this.method02060(var4);
            }
         } else {
            BlockPos var5 = this.method01969(var2);
            if (var5 != null) {
               this.method02016();
               this.method02009(var5, 2);
            } else {
               this.method02036(var2);
            }
         }
      }
   }

   private String method02050() {
      return "delay=" + this.field04847 + "/busy=" + this.field04797.method01778() + "/moving=" + this.method01991() + "/pathing=" + this.method01992();
   }

   private void method02051() {
      Vec3 var1 = this.field04797.method01747().position();
      if (this.field04869 == null || var1.distanceToSqr(this.field04869) > field04882 || this.field04797.method02627()) {
         this.field04869 = var1;
         this.field04822.method04694();
      } else if (this.field04822.method04699(field04883)) {
         this.field04869 = var1;
         this.field04822.method04694();
         this.method02016();
         this.field04830 = null;
         this.field04832 = null;
         this.field04833 = null;
         this.field04799.clear();
         this.field04800.clear();
         this.field04801.clear();
         this.field04826.clear();
         this.field04855 = null;
         this.field04829 = WardenBotController.Nested53.COLLECTING;
         this.field04836 = -1;
      }
   }

   private static Vec3 method02052(Rotation var0) {
      float var1 = (float)Math.toRadians(var0.method09439());
      float var2 = (float)Math.toRadians(var0.method09443());
      double var3 = Math.cos(var2);
      return new Vec3(-Math.sin(var1) * var3, -Math.sin(var2), Math.cos(var1) * var3);
   }

   private static void method02053() {
      synchronized (field04780) {
         if (field04782 != 0 && --field04782 <= 0) {
            Settings var1 = BaritoneAPI.getSettings();
            var1.allowBreak.value = field04785;
            var1.allowPlace.value = field04786;
            var1.primaryTimeoutMS.value = field04789;
            var1.failureTimeoutMS.value = field04790;
            var1.planAheadPrimaryTimeoutMS.value = field04791;
            var1.planAheadFailureTimeoutMS.value = field04792;
            var1.avoidance.value = field04783;
            var1.allowDiagonalAscend.value = field04787;
            var1.allowDiagonalDescend.value = field04788;
            var1.maxFallHeightNoWater.value = field04793;
            var1.blockFreeLook.value = field04784;
            var1.randomLooking.value = field04794;
            var1.randomLooking113.value = field04795;
            var1.blocksToAvoid.value = field04796;
         }
      }
   }

   public void method02054() {
      if (this.field04797.method02629()) {
         LocalPlayer var1 = this.field04797.method01747();
         if (var1 != this.field04846) {
            this.field04846 = var1;
            this.field04845 = 0;
            this.field04838 = -1;
            this.field04839 = -1;
            this.field04843 = -1;
            this.field04866 = -1;
         }

         this.field04845++;
         this.field04826.clear();
         if (this.field04845 % 100 == 0) {
            this.field04797.method01755(this.method01985());
         }

         boolean var2 = this.method01942();
         if (var2 && !this.field04808) {
            this.field04797.method01755("тьма замечена: " + this.method01985());
         }

         this.field04808 = var2;
         this.method01968(var2);
         if (!var2 || !this.method02061()) {
            if (this.field04797.method02627()) {
               if (this.field04856 != null && !this.field04856.equals(this.field04857)) {
                  this.field04857 = this.field04856;
                  this.field04800.remove(this.field04856);
                  this.field04799.merge(this.field04856, 1, Integer::sum);
               }
            } else if (this.field04845 > this.field04859) {
               this.field04856 = null;
               this.field04857 = null;
               this.field04858 = -1;
            }

            if (this.method01998()) {
               this.method02016();
               this.field04797.method01770(0);
               this.field04797.method01757(false);
            } else {
               int var3 = this.field04797.method01743();
               if (var3 != this.field04871) {
                  this.field04871 = var3;
                  this.field04821.method04694();
                  if (var3 == this.field04865) {
                     this.field04865 = -1;
                  }
               }

               if (this.method02100().debug() && this.field04845 % 20 == 0) {
                  ;
               }

               if (this.field04829 != this.field04840) {
                  this.field04840 = this.field04829;
                  this.field04817.method04694();
               }

               this.method01966();
               this.method01970();
               this.method02097();
               this.method02074();
               if (this.field04847 > 0) {
                  this.field04847--;
               }

               this.method01997();
               this.method02055();
               if (this.field04834 != null) {
                  if (this.field04866 < 0) {
                     this.field04866 = this.field04845 + 20;
                  }

                  if (this.field04845 >= this.field04866) {
                     this.field04797.method01751("report " + this.field04834 + " чит");
                     this.field04834 = null;
                     this.field04866 = -1;
                  }
               } else if (this.field04845 < 5) {
                  this.field04799.clear();
                  this.field04800.clear();
                  this.field04801.clear();
               } else if (this.field04797.method01743() < 0) {
                  if (this.field04806.method04699(field04879) && this.method02099()) {
                     if (this.field04837 >= 0) {
                        this.method01960(this.field04837, true);
                     } else if (this.method02091() >= 0) {
                        this.method02066(this.method02091());
                     }
                  }
               } else {
                  this.field04806.method04694();
                  if (this.field04837 == this.field04797.method01743()) {
                     this.field04837 = -1;
                  }

                  if (this.method01958()) {
                     if (this.field04836 >= 0) {
                        this.method02045();
                     } else {
                        this.method02037();
                     }

                     if (this.field04845 % 100 == 0 && (this.field04831 == null || !this.method02002())) {
                        this.method01956();
                     }
                  }

                  if (this.method01946(MobEffects.GLOWING) && this.method01979(field04880) && !this.field04817.method04699(field04881)) {
                     this.method02020();
                     this.method02005(false);
                  } else if (!this.method01990()) {
                     switch (this.field04829) {
                        case SAVE:
                           this.method02018();
                           break;
                        case TAKE:
                           this.method02110();
                           break;
                        case COLLECTING:
                           this.method02064();
                           break;
                        case ESCAPE:
                           this.method02029();
                     }

                     this.method02082();
                     this.method01948();
                     this.method02051();
                  }
               }
            }
         }
      }
   }

   private void method02055() {
      for (Warden var2 : this.field04797.method01752().getEntitiesOfClass(Warden.class, this.field04797.method01747().getBoundingBox().inflate(field04887))) {
         this.field04802.put(var2.blockPosition(), this.field04845 + 100);
      }

      this.field04802.values().removeIf(var1 -> this.field04845 > var1);
   }

   private boolean method02056() {
      return this.method02100().useSpeed() && this.method02086(MobEffects.SPEED) == null;
   }

   private int method02057(Predicate<ItemStack> var1) {
      for (int var2 = 0; var2 < 36; var2++) {
         if (var1.test(this.field04797.method01747().getInventory().getItem(var2))) {
            return var2;
         }
      }

      return -1;
   }

   private void method02058(AbstractContainerMenu var1) {
      int var2 = this.method01957();
      var var3 = this.method02004(var1);
      if (var3.isEmpty()) {
         this.method02032("в открытом меню нет наших слотов с лутом, слотов=" + var1.slots.size());
      } else if (this.field04870 >= 0 && var2 >= this.field04870 && this.field04817.method04699(field05029)) {
         this.method02032("лут не уходит в сундук, к сдаче=" + var3.size());
      } else {
         if (this.field04870 < 0 || var2 < this.field04870) {
            this.field04870 = var2;
            this.field04817.method04694();
         }

         if (!this.method01987(var1x -> this.method01943(var1x, this.method02004(var1x))) && this.field04845 % 40 == 0) {
            this.field04797.method01755("сдача лута ждёт: " + this.method02050());
         }
      }
   }

   private void method02059(AbstractContainerMenu var1, Slot var2) {
      ItemStack var3 = var1.getCarried();
      if (!var3.isEmpty()) {
         var var4 = method01977(var3);
         Slot var5 = var2 != null && var4.test(var2.getItem()) ? var2 : this.method02007(var1, false, var4);
         this.method02003(var1, var5 != null ? var5 : this.method02007(var1, true, var4), 0, ClickType.PICKUP);
      }
   }

   private void method02060(AbstractContainerMenu var1) {
      if (!this.method02109() && this.method02007(var1, false, this::method02067) == null) {
         this.method02094();
      } else {
         this.method01987(var1x -> {
            Slot var2 = null;
            if (var1x.getCarried().isEmpty()) {
               var2 = this.method02007(var1x, false, this::method02067);
               if (var2 == null) {
                  return;
               }

               this.method02003(var1x, var2, 0, ClickType.PICKUP);
            }

            this.method02071(var1x);
            this.method02059(var1x, var2);
         });
      }
   }

   private boolean method02061() {
      int var1 = this.field04797.method01743();
      if (var1 >= 0 && this.field04811 && !this.field04797.method01777()) {
         long var2 = System.currentTimeMillis();
         if (var2 - this.field04807 < field04899) {
            return false;
         }

         if (this.field04797.method02627()) {
            this.field04797.method01771();
         }

         this.field04807 = var2;
         this.field04811 = false;
         this.field04821.method04694();
         this.field04837 = var1;
         this.method02016();
         String.valueOf("Тьма — выхожу в хаб и перезахожу на анархию " + var1);
         this.field04797.method01751(field04900);
         return true;
      } else {
         return false;
      }
   }

   private static int method02062(long var0, double var2) {
      if (var0 < 0L && var2 <= field04959) {
         return 0;
      } else if (var0 >= 0L && var0 <= field04960 && var2 <= field04961) {
         return 1;
      } else if (var0 < 0L && var2 <= field04962) {
         return 2;
      } else if (var0 >= 0L && var0 <= field04963 && var2 <= field04964) {
         return 3;
      } else {
         return var0 < 0L ? 4 : -1;
      }
   }

   public void method02063(int var1) {
      if (var1 >= 0) {
         this.field04798.remove(Integer.valueOf(var1));
         this.field04798.addFirst(var1);
      }
   }

   private void method02064() {
      if (!this.method01964()) {
         this.field04841 = false;
      }

      if (!this.method02030()) {
         this.method02020();
         if (!this.method02098()) {
            if (this.field04798.isEmpty()) {
               if (this.field04797.method01743() < 0) {
                  return;
               }

               this.method02072(this.field04797.method01743());
            }

            if (this.field04835 >= this.field04798.size()) {
               this.field04835 = this.field04798.size() - 1;
            }

            int var1 = this.field04798.get(this.field04835);
            if (this.field04797.method01743() != var1) {
               if (this.field04845 % 10 == 0 && this.method02099()) {
                  this.method02066(var1);
               }
            } else {
               if (this.field04845 > 5) {
                  this.method02033();
               }
            }
         }
      }
   }

   private void method02065(BlockPos var1) {
      BlockPos var2 = this.method02093(var1);
      if (var2 == null) {
         this.method02039(this.method01954(var1));
      } else {
         double var3 = this.field04797.method01747().distanceToSqr(Vec3.atCenterOf(var2));
         if (var3 > field04943) {
            this.method02039(var2);
         } else if (var3 <= 1.0) {
            this.method02016();
         }
      }
   }

   private void method02066(int var1) {
      this.method01960(var1, false);
   }

   private boolean method02067(ItemStack var1) {
      if (var1.isEmpty()) {
         return false;
      } else if (this.method02087(var1) && this.method01963() < 1) {
         return true;
      } else {
         return var1.is(Items.GOLDEN_CARROT) && this.method01965(Items.GOLDEN_CARROT) < 3
            ? true
            : this.method02100().useSpeed() && this.method01995(var1) && this.method02057(this::method01995) < 0;
      }
   }

   public void method02068() {
      this.method02016();
      this.method02075();
      this.field04846 = null;
      this.field04845 = 0;
      this.field04797.method01757(false);
      this.field04797.method01770(0);
      method02053();
   }

   private BlockPos method02069() {
      BlockPos var1 = null;
      int var2 = field04954;
      double var3 = field04955;

      for (BlockPos var6 : this.field04797
         .method01766()
         .method05348(this.field04797.method01752(), this.field04797.method01747(), this.field04797.method01743())) {
         if (this.method02080(var6) && !this.method01982(var6)) {
            double var7 = this.field04797.method01747().getEyePosition().distanceToSqr(Vec3.atCenterOf(var6));
            long var9 = this.field04797.method01766().method05349(var6);
            if ((!this.method02090(var6) || var9 < 0L && !(var7 > field04956)) && (var9 >= 0L || this.field04799.getOrDefault(var6, 0) < 3)) {
               int var11 = method02062(var9, var7);
               if (var11 >= 0) {
                  double var12 = Vec3.atCenterOf(var6).y - this.field04797.method01747().getEyeY();
                  double var14 = var6.getX() + field04957 - this.field04797.method01747().getX();
                  double var16 = var6.getZ() + field04958 - this.field04797.method01747().getZ();
                  double var18 = var14 * var14 + var16 * var16 + (var12 > 0.0 ? 2 : 1) * var12 * var12;
                  if (var11 <= var2 && (var11 != var2 || !(var18 >= var3))) {
                     var2 = var11;
                     var3 = var18;
                     var1 = var6;
                  }
               }
            }
         }
      }

      return var1;
   }

   private void method02070(BlockPos var1) {
      long var2 = this.field04797.method01766().method05349(var1);
      if ((var2 <= field04939 || !this.method01981(var1, field04940)) && var2 <= this.method01951(var1)) {
         double var4 = this.field04797.method01747().getEyePosition().distanceToSqr(Vec3.atCenterOf(var1));
         if (!(var4 <= field04941)) {
            if (var4 > field04942) {
               this.method02096();
            }

            this.method02039(this.method02093(var1));
         } else {
            this.method02016();
            boolean var6 = this.method01994(var1) && this.field04799.getOrDefault(var1, 0) < 3;
            if (var6 && this.field04800.getOrDefault(var1, 0) >= 20) {
               this.field04800.remove(var1);
               this.field04799.put(var1, 3);
               this.field04832 = null;
            } else {
               if (this.method02009(var1, var6 ? 1 : 0)) {
                  this.field04800.merge(var1, 1, Integer::sum);
               }
            }
         }
      } else {
         this.method02065(var1);
      }
   }

   private void method02071(AbstractContainerMenu var1) {
      while (!var1.getCarried().isEmpty() && this.method02067(var1.getCarried())) {
         ItemStack var2 = var1.getCarried();
         int var3 = var2.getCount();
         Slot var4 = this.method02007(var1, true, method01977(var2));
         if (var4 == null) {
            return;
         }

         this.method02003(var1, var4, 1, ClickType.PICKUP);
         if (var1.getCarried().getCount() >= var3) {
            return;
         }
      }
   }

   public void method02072(int var1) {
      this.field04798.remove(Integer.valueOf(var1));
      this.field04798.add(var1);
      this.field04835 = this.field04798.size() - 1;
   }

   private List<Slot> method02073(AbstractContainerMenu var1) {
      ArrayList var2 = new ArrayList();

      for (int var3 = 0; var3 <= 2; var3++) {
         for (Slot var5 : var1.slots) {
            if (var5.container != this.field04797.method01747().getInventory()) {
               ItemStack var6 = var5.getItem();
               if (this.method02088(var6) && this.method02040(var6) == var3) {
                  var2.add(var5);
               }
            }
         }
      }

      return var2;
   }

   private void method02074() {
      if (this.field04838 >= 0 && this.field04845 >= this.field04838) {
         this.field04838 = -1;
         this.field04797.method01751(field04927);
         this.field04797.method01754(this.field04797.method01743());
      }
   }

   private void method02075() {
      this.field04802.clear();
      this.field04828.clear();
      this.field04799.clear();
      this.field04800.clear();
      this.field04801.clear();
      this.field04826.clear();
      this.field04827.clear();
      this.field04855 = null;
      this.field04864 = field04874;
      this.field04856 = null;
      this.field04857 = null;
      this.field04858 = -1;
      this.field04859 = -1;
      this.field04831 = null;
      this.field04830 = null;
      this.field04832 = null;
      this.field04833 = null;
      this.field04834 = null;
      this.field04866 = -1;
      this.field04850 = null;
      this.field04849 = 0;
      this.field04848 = 0;
      this.field04847 = 0;
      this.field04844 = null;
      this.field04867 = 0;
      this.field04868 = 0;
      this.field04872 = 0;
      this.field04869 = null;
      this.field04838 = -1;
      this.field04839 = -1;
      this.field04843 = -1;
      this.field04865 = -1;
      this.field04836 = -1;
      this.field04851 = false;
      this.field04852 = false;
      this.field04870 = -1;
      this.field04811 = true;
      this.field04812 = 0;
      this.field04809 = null;
   }

   private void method02077() {
      if (this.field04843 >= 0) {
         if (this.field04845 > this.field04843) {
            this.field04843 = -1;
            this.field04844 = null;
         } else if (this.field04844 != null && !(this.field04797.method01747().position().distanceToSqr(this.field04844) < field04922)) {
            this.field04843 = -1;
            this.field04844 = null;
            this.field04838 = this.field04845 + 20;
         }
      }
   }

   private void method02079(AbstractContainerMenu var1) {
      var var2 = this.method02073(var1);
      if (var2.isEmpty()) {
         this.method01974();
      } else {
         if (this.field04858 >= 0 && var2.size() >= this.field04858) {
            if (this.field04823.method04699(field05028)) {
               this.method01974();
               return;
            }
         } else {
            this.field04858 = var2.size();
            this.field04823.method04694();
         }

         if (this.method01991()) {
            this.method02016();
         } else {
            this.method01987(var1x -> this.method01943(var1x, this.method02073(var1x)));
         }
      }
   }

   private boolean method02080(BlockPos var1) {
      return this.method02093(var1) != null;
   }

   private boolean method02081(BlockPos var1, boolean var2) {
      BlockState var3 = this.field04797.method01752().getBlockState(var1);
      if (!var3.is(Blocks.BARREL)) {
         if (!var3.is(Blocks.CHEST)) {
            return false;
         }

         if (this.method02035(var1) != var2) {
            return false;
         }

         BlockPos var4 = var1.above();
         return !this.field04797.method01752().getBlockState(var4).isRedstoneConductor(this.field04797.method01752(), var4);
      } else {
         return !var2 && !this.method02035(var1);
      }
   }

   private void method02082() {
      if (this.method02046()) {
         if (this.field04845 % 15 == 0) {
            this.method02016();
         }
      }
   }

   private boolean method02083() {
      return this.field04798.size() > 1 && this.field04835 < this.field04798.size()
         ? !this.field04798.getFirst().equals(this.field04798.get(this.field04835))
         : false;
   }

   public void method02084(int var1, int var2) {
      this.field04798.clear();
      this.method02063(var1);
      this.method02072(var2);
   }

   private int method02085() {
      return Math.max(1, this.method02106(this.method02100().lootLimit()));
   }

   private MobEffectInstance method02086(Holder<MobEffect> var1) {
      LocalPlayer var2 = this.field04797.method01747();
      if (var2 == null) {
         return null;
      }

      ResourceKey var3 = (ResourceKey)var1.unwrapKey().orElse(null);
      if (var3 == null) {
         return null;
      }

      for (MobEffectInstance var5 : var2.getActiveEffects()) {
         if (var5.getEffect().is(var3)) {
            return var5;
         }
      }

      return null;
   }

   private boolean method02087(ItemStack var1) {
      return var1.getOrDefault(DataComponents.POTION_CONTENTS, PotionContents.EMPTY)
         .potion()
         .filter(var0 -> var0.equals(Potions.INVISIBILITY) || var0.equals(Potions.LONG_INVISIBILITY))
         .isPresent();
   }

   private boolean method02088(ItemStack var1) {
      return !var1.isEmpty() && !this.method02044(var1);
   }

   private boolean method02089() {
      return this.method02091() >= 0 && this.method02091() == this.field04797.method01743();
   }

   private boolean method02090(BlockPos var1) {
      for (BlockPos var3 : this.field04802.keySet()) {
         if (var3.distSqr(var1) < field05006) {
            return true;
         }
      }

      return false;
   }

   private int method02091() {
      return this.field04798.isEmpty() ? -1 : this.field04798.getFirst();
   }

   private BlockPos method02092(BlockPos var1) {
      for (int var2 = -1; var2 <= 1; var2++) {
         for (int var3 = -1; var3 <= 1; var3++) {
            if (var2 != 0 || var3 != 0) {
               BlockPos var4 = var1.offset(var2, 0, var3);
               if (this.field04797.method01752().getBlockState(var4).isAir()
                  && this.field04797.method01752().getBlockState(var4.above()).isAir()
                  && !this.field04797.method01752().getBlockState(var4.below()).isAir()
                  && this.method02026(var4, var1)) {
                  return var4;
               }
            }
         }
      }

      BlockPos var5 = var1.above();
      return this.field04797.method01752().getBlockState(var5).isAir()
            && this.field04797.method01752().getBlockState(var5.above()).isAir()
            && this.method02026(var5, var1)
         ? var5
         : null;
   }

   private BlockPos method02093(BlockPos var1) {
      BlockPos var2 = this.field04826.get(var1);
      if (var2 != null) {
         return var2 == BlockPos.ZERO ? null : var2;
      }

      BlockPos var3 = this.method02092(var1);
      this.field04826.put(var1, var3 == null ? BlockPos.ZERO : var3);
      return var3;
   }

   private void method02094() {
      this.field04841 = true;
      this.field04818.method04694();
   }

   private void method02096() {
      if (!this.field04797.method01747().getMainHandItem().isEmpty()) {
         for (int var1 = 0; var1 < 9; var1++) {
            if (this.field04797.method01747().getInventory().getItem(var1).isEmpty()) {
               this.field04797.method01760(var1);
               return;
            }
         }

         for (int var3 = 9; var3 < 36; var3++) {
            if (this.field04797.method01747().getInventory().getItem(var3).isEmpty()) {
               int var2 = var3;
               this.method01987(var2x -> {
                  int var3x = this.method01976(var2);
                  if (var3x >= 0) {
                     this.field04797.method01776(var3x, this.field04797.method01747().getInventory().getSelectedSlot(), ClickType.SWAP);
                  }
               });
               return;
            }
         }
      }
   }

   private void method02097() {
      this.method02077();
      if (this.field04839 >= 0 && this.field04845 >= this.field04839) {
         this.field04839 = -1;
         if (!this.method01958()) {
            this.field04797.method01751(field04921);
            this.field04804.method04694();
            this.field04844 = this.field04797.method01747().position();
            this.field04843 = this.field04845 + 200;
         }
      }
   }

   private boolean method02098() {
      return this.field04830 != null;
   }

   private boolean method02099() {
      return this.field04821.method04699(field04898) && this.field04797.method02630();
   }

   private WardenBotOptions method02100() {
      return this.field04797.method01764();
   }

   private boolean method02101() {
      return this.method02022() != null;
   }

   private BlockHitResult method02102(Vec3 var1, Vec3 var2) {
      return this.field04797
         .method01752()
         .clip(new ClipContext(var1, var2, net.minecraft.world.level.ClipContext.Block.COLLIDER, Fluid.NONE, this.field04797.method01747()));
   }

   public void method02103() {
      this.field04799.clear();
      this.field04800.clear();
      this.field04801.clear();
      this.field04802.clear();
      this.field04828.clear();
      this.field04798.clear();
      this.field04831 = null;
   }

   private BlockPos method02104() {
      return new BlockPos(-1995, this.field04797.method01747().getBlockY(), -2002);
   }

   private int method02106(int var1) {
      if (this.method02100().priorityIs(field04933)) {
         return (int)(var1 * field04934);
      } else {
         return this.method02100().priorityIs(field04935) ? (int)(var1 * field04936) : var1;
      }
   }

   private boolean method02107(double var1) {
      for (BlockPos var4 : this.field04797
         .method01766()
         .method05348(this.field04797.method01752(), this.field04797.method01747(), this.field04797.method01743())) {
         if (this.field04797.method01747().distanceToSqr(Vec3.atCenterOf(var4)) <= var1 * var1) {
            return true;
         }
      }

      return false;
   }

   public void method02108(String var1) {
      if (this.field04797.method02629()) {
         if (var1.contains(field04888)) {
            this.method01949();
         } else if (var1.contains(field04889)) {
            this.field04852 = true;
            this.field04868 = 0;
            if (this.method02100().reportKillers() && this.field04797.method01747() != null && var1.contains(field04890)) {
               if (!this.method01946(MobEffects.GLOWING) && !this.method02107(field04891)) {
                  this.field04834 = var1.split(field04892)[1].split(field04893)[0].trim();
               }
            }
         }
      }
   }

   private boolean method02109() {
      AbstractContainerMenu var1 = this.field04797.method01765();
      return var1 != null && !var1.getCarried().isEmpty();
   }

   private void method02110() {
      if (this.method01989()) {
         if (this.field04855 != null) {
            this.field04827.add(this.field04855);
         }

         this.field04855 = null;
         this.method02094();
         this.field04829 = WardenBotController.Nested53.COLLECTING;
      } else if (this.method02091() < 0) {
         this.field04829 = WardenBotController.Nested53.COLLECTING;
      } else if (this.field04797.method01743() != this.method02091() && !this.field04797.method01777() && this.field04845 % 5 == 0 && this.method02099()) {
         this.method02066(this.method02091());
      } else {
         if (this.field04852 && this.field04798.size() > 1) {
            if (++this.field04835 >= this.field04798.size()) {
               this.field04835 = 1;
            }

            this.field04852 = false;
         }

         this.field04799.clear();
         this.field04800.clear();
         this.field04801.clear();
         if (this.field04845 % 200 == 0 && !this.method02109()) {
            this.method01974();
         }

         if (!this.method02098()) {
            if (this.method02089()) {
               this.method02049(this.method01964() && this.method01939() || this.method02109(), false, WardenBotController.Nested53.COLLECTING);
            }
         }
      }
   }

   private static boolean method02111(Player var0) {
      return !var0.getItemBySlot(EquipmentSlot.HEAD).isEmpty()
         || !var0.getItemBySlot(EquipmentSlot.CHEST).isEmpty()
         || !var0.getItemBySlot(EquipmentSlot.LEGS).isEmpty()
         || !var0.getItemBySlot(EquipmentSlot.FEET).isEmpty();
   }

   // $VF: Compiled from s
   private enum Nested53 {
      SAVE,
      TAKE,
      COLLECTING,
      ESCAPE;
   }

   // $VF: Compiled from s
   private final class Nested54 {
      private int field05041;
      private int field05042;
      private int field05043;

      private boolean method02112(ItemStack var1) {
         if (this.field05041 < 1 && WardenBotController.this.method02087(var1)) {
            this.field05041 = this.field05041 + var1.getCount();
            return true;
         } else if (this.field05042 < 3 && var1.is(Items.GOLDEN_CARROT)) {
            this.field05042 = this.field05042 + var1.getCount();
            return true;
         } else if (this.field05043 < 1 && WardenBotController.this.method02100().useSpeed() && WardenBotController.this.method01995(var1)) {
            this.field05043 = this.field05043 + var1.getCount();
            return true;
         } else {
            return false;
         }
      }
   }

   // $VF: Compiled from s
   private final class Nested55 {
      private static final int field05045 = 40;
      private static final int field05046 = 0;
      private static final int field05047 = 0;
      private static final int field05048 = 0;
      private static final int field05049 = 0;
      private static final int field05050 = 0;
      private final int field05051 = WardenBotController.this.field04797.method01747().getInventory().getSelectedSlot();
      private final int field05052;
      private final Item field05053;
      private WardenBotController.Nested55.Nested56 field05054 = WardenBotController.Nested55.Nested56.SWAP;
      private int field05055;
      private int field05056;
      private boolean field05057;
      private boolean field05058;

      private boolean method02113() {
         if (!this.method02117()) {
            WardenBotController.this.field04797.method01760(this.field05051);
            return true;
         }

         if (!WardenBotController.this.method01973()) {
            if (this.field05055 == 1) {
               WardenBotController.this.method02016();
            }

            if (this.field05055 <= 200) {
               return false;
            }

            WardenBotController.this.field04797.method01760(this.field05051);
            return true;
         } else {
            WardenBotController.this.field04847 = 2;
            this.method02121();
            return true;
         }
      }

      private boolean method02114() {
         if (!this.field05057) {
            if (!this.method02117()) {
               WardenBotController.this.field04797.method01760(this.field05052);
            } else {
               if (!WardenBotController.this.method01973()) {
                  if (this.field05055 == 1) {
                     WardenBotController.this.method02016();
                  }

                  return this.field05055 > 40;
               }

               this.method02121();
            }

            this.field05057 = true;
            return false;
         } else {
            if (WardenBotController.this.field04797.method01778()) {
               return false;
            }

            this.method02120(WardenBotController.Nested55.Nested56.ARM);
            return false;
         }
      }

      private boolean method02115() {
         this.field05055++;

         return switch (this.field05054) {
            case SWAP -> this.method02114();
            case ARM -> this.method02123();
            case USE -> this.method02124();
            case RESTORE -> this.method02118();
         };
      }

      private boolean method02116() {
         return WardenBotController.this.field04797.method01747().getMainHandItem().is(this.field05053);
      }

      private Nested55(int var2) {
         this.field05052 = var2;
         this.field05053 = WardenBotController.this.field04797.method01747().getInventory().getItem(var2).getItem();
      }

      private boolean method02117() {
         return this.field05052 > 8;
      }

      private boolean method02118() {
         return WardenBotController.this.field04797.method01747().isUsingItem() && this.field05055 <= 20 ? false : this.method02113();
      }

      private boolean method02119() {
         return this.field05054 == WardenBotController.Nested55.Nested56.USE;
      }

      private void method02120(WardenBotController.Nested55.Nested56 var1) {
         this.field05054 = var1;
         this.field05055 = 0;
      }

      private void method02121() {
         WardenBotController.this.field04797
            .method01759(
               () -> {
                  int var1 = WardenBotController.this.method01976(this.field05052);
                  if (var1 >= 0) {
                     WardenBotController.this.field04797
                        .method01776(var1, WardenBotController.this.field04797.method01747().getInventory().getSelectedSlot(), ClickType.SWAP);
                  }
               }
            );
      }

      private boolean method02123() {
         if (!this.method02116()) {
            this.method02120(WardenBotController.Nested55.Nested56.RESTORE);
            return false;
         }

         if (this.field05055 < 2) {
            return false;
         }

         this.field05056 = WardenBotController.this.field04797.method01747().getMainHandItem().getCount();
         this.method02120(WardenBotController.Nested55.Nested56.USE);
         return false;
      }

      private boolean method02124() {
         if (this.method02116() && WardenBotController.this.field04797.method01747().getMainHandItem().getCount() >= this.field05056) {
            if (this.field05055 == 1) {
               WardenBotController.this.field04797.method01761();
            }

            if (WardenBotController.this.field04797.method01747().isUsingItem()) {
               this.field05058 = true;
               if (this.field05055 > 80) {
                  this.method02120(WardenBotController.Nested55.Nested56.RESTORE);
               }

               return false;
            } else {
               if (this.field05058 || this.field05055 > 20) {
                  this.method02120(WardenBotController.Nested55.Nested56.RESTORE);
               }

               return false;
            }
         } else {
            this.method02120(WardenBotController.Nested55.Nested56.RESTORE);
            return false;
         }
      }

      // $VF: Compiled from s
      private enum Nested56 {
         SWAP,
         ARM,
         USE,
         RESTORE;
      }
   }
}
