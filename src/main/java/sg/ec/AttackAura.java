// Original binary: sg/ec/2KOR9HIUkN9bRJbq
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket;
import net.minecraft.network.protocol.game.ServerboundPlayerActionPacket.Action;
import net.minecraft.tags.ItemTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;
import sg.mx.LivingEntityMixin_1248;

// $VF: Compiled from s
public class AttackAura extends ClientModule {
   private static final String field00752 = "Здоровью";
   private static final String field00753 = "field00753";
   private static final String field00754 = "field00754";
   private static final String field00755 = "field00755";
   private static final String field00756 = "field00756";
   private static final float field00757 = 0;
   private static final int field00758 = 0;
   private static final int field00759 = 0;
   private static final float field00760 = 0;
   private static final float field00761 = 0;
   private static final float field00762 = 0;
   private static final float field00763 = 0;
   private final ModeSetting field00764;
   private final NumberSetting<Float> field00765;
   private final NumberSetting<Float> field00766;
   private final ModeSetting field00767;
   private final NumberSetting<Integer> field00768;
   private final MultiToggleSetting field00769;
   private final MultiToggleSetting field00770;
   private final ToggleSetting field00771;
   private final ToggleSetting field00772;
   private final MultiToggleSetting field00773;
   private final ModeSetting field00774;
   private final ModeSetting field00775;
   private final NumberSetting<Float> field00776;
   private final NumberSetting<Float> field00777;
   private final NumberSetting<Float> field00778;
   private final NumberSetting<Float> field00779;
   private final ToggleSetting field00780;
   private final NumberSetting<Float> field00781;
   private final NumberSetting<Float> field00782;
   private final NumberSetting<Float> field00783;
   private final AuraAimPointSelector field00784;
   public static LivingEntity field00785;
   public AuraAttackTiming field00786;
   public boolean field00787;
   public Vec3 field00788;
   private final AuraTargetPointTracker field00789;
   private final AuraRotationController field00790;
   private final AuraCriticalController field00791;
   private final OnnxRotationModel field00792;
   private final RotationModelRepository field00793;
   public boolean field00794;
   private int field00795;
   private int field00796;
   private boolean field00797;
   private int field00798;
   private int field00799;
   private int field00800;
   private boolean field00801;
   public int field00802;
   private int field00803;
   private boolean field00804;
   private int field00805;
   private int field00806;
   private boolean field00807;
   private boolean field00808;
   private boolean field00809;
   private int field00810;
   private final List<LivingEntity> field00811;
   private final SortableArrayList<AttackAura.Nested16> field00812;
   public double field00813;
   private static final String field00814 = "Тип";
   private static final String field00815 = "Grim";
   private static final String field00816 = "Matrix";
   private static final String field00817 = "MatrixSnap";
   private static final String field00818 = "Legit";
   private static final String field00819 = "Smooth";
   private static final String field00820 = "Universal";
   private static final String field00821 = "Matrix";
   private static final String field00822 = "Дистанция атаки";
   private static final float field00823 = 3.0F;
   private static final float field00824 = 6.0F;
   private static final float field00825 = 0.1F;
   private static final float field00826 = 3.0F;
   private static final String field00827 = "Дистанция радиуса";
   private static final float field00828 = 10.0F;
   private static final float field00829 = 0.5F;
   private static final String field00830 = "Стиль атаки";
   private static final String field00831 = "1.9";
   private static final String field00832 = "1.8";
   private static final String field00833 = "1.9";
   private static final String field00834 = "Частота кликов";
   private static final String field00835 = "Сортировать по";
   private static final String field00836 = "Здоровью";
   private static final String field00837 = "Дистанции";
   private static final String field00838 = "Броня";
   private static final String field00839 = "Поле зрению";
   private static final String field00840 = "Надета элитра";
   private static final String field00841 = "Таргеты";
   private static final String field00842 = "Игроки";
   private static final String field00843 = "Голые";
   private static final String field00844 = "Мобы";
   private static final String field00845 = "Животные";
   private static final String field00846 = "Жители";
   private static final String field00847 = "Друзья";
   private static final String field00848 = "Невидимые";
   private static final String field00849 = "Настройка выбора цели";
   private static final String field00850 = "Только в прыжке";
   private static final String field00851 = "Ускорять удары";
   private static final String field00852 = "Настройки";
   private static final String field00853 = "Выключать после смерти";
   private static final String field00854 = "Рандомизация ударов";
   private static final String field00855 = "Сбрасывать спринт";
   private static final String field00856 = "Не бить если ешь";
   private static final String field00857 = "Проверка наводки";
   private static final String field00858 = "Криты в воде";
   private static final String field00859 = "Только криты";
   private static final String field00860 = "Отжимать щит";
   private static final String field00861 = "Ломать щит";
   private static final String field00862 = "Тпс синх";
   private static final String field00863 = "Настройка выбора цели";
   private static final String field00864 = "Режим проверки стен";
   private static final String field00865 = "Игнорировать стены";
   private static final String field00866 = "Не бить через стены";
   private static final String field00867 = "Обход стен";
   private static final String field00868 = "Не бить через стены";
   private static final String field00869 = "Тип коррекции";
   private static final String field00870 = "Незаметный";
   private static final String field00871 = "Сфокусированный";
   private static final String field00872 = "Таргетированная";
   private static final String field00873 = "Незаметный";
   private static final String field00874 = "Скорость по yaw";
   private static final float field00875 = 20.0F;
   private static final float field00876 = 10.0F;
   private static final String field00877 = "Скорость по pitch";
   private static final float field00878 = 20.0F;
   private static final float field00879 = 10.0F;
   private static final String field00880 = "Скорость по yaw (Elytra)";
   private static final float field00881 = 20.0F;
   private static final float field00882 = 10.0F;
   private static final String field00883 = "Скорость по pitch (Elytra)";
   private static final float field00884 = 20.0F;
   private static final float field00885 = 10.0F;
   private static final String field00886 = "Аим Ассист";
   private static final String field00887 = "Помощь по yaw";
   private static final float field00888 = 100.0F;
   private static final float field00889 = 30.0F;
   private static final String field00890 = "Помощь по pitch";
   private static final float field00891 = 100.0F;
   private static final float field00892 = 30.0F;
   private static final String field00893 = "Помощь до удара (мс)";
   private static final float field00894 = 1000.0F;
   private static final float field00895 = 50.0F;
   private static final float field00896 = 350.0F;
   private static final int field00897 = Integer.MIN_VALUE;
   private static final int field00898 = Integer.MIN_VALUE;
   private static final int field00899 = Integer.MIN_VALUE;
   private static final String field00900 = "Attack Aura";
   private static final String field00901 = "Выключать после смерти";
   private static final String field00902 = "Таргетированная";
   private static final String field00903 = "Незаметный";
   private static final double field00904 = 3.0;
   private static final float field00905 = 6.0F;
   private static final float field00906 = 11.0F;
   private static final String field00907 = "От скорости";
   private static final String field00908 = "1.9";
   private static final String field00909 = "SPRINT_SYNC";
   private static final String field00910 = "AURA_CD";
   private static final String field00911 = "HAND";
   private static final String field00912 = "СТОП спринт-синх";
   private static final String field00913 = "СТОП рука";
   private static final String field00914 = "Рандомизация ударов";
   private static final String field00915 = "TIMER";
   private static final String field00916 = "CRIT";
   private static final String field00917 = "СТОП таймер";
   private static final String field00918 = "СТОП крит/радиус";
   private static final String field00919 = "AIM";
   private static final String field00920 = "СТОП наводка";
   private static final String field00921 = "MACE";
   private static final String field00922 = "СТОП булава";
   private static final String field00923 = "Не бить через стены";
   private static final String field00924 = "Проверка наводки";
   private static final String field00925 = "Дистанции";
   private static final String field00926 = "Здоровью";
   private static final String field00927 = "Броня";
   private static final String field00928 = "Поле зрению";
   private static final String field00929 = "Надета элитра";
   private static final float field00930 = 0.001F;
   private static final float field00931 = 0.001F;
   private static final String field00932 = "Не бить через стены";
   private static final String field00933 = "Проверка наводки";
   private static final String field00934 = "Universal";
   private static final String field00935 = "Neuro";
   private static final String field00936 = "NeuroNew";
   private static final String field00937 = "NeuroV6";
   private static final String field00938 = "NeuroV7";
   private static final String field00939 = "NeuroV8";
   private static final float field00940 = 100.0F;
   private static final float field00941 = 100.0F;
   private static final float field00942 = 1.5F;
   private static final float field00943 = 1.5F;
   private static final String field00944 = "Neuro";
   private static final String field00945 = "Neuro";
   private static final String field00946 = "Neuro";
   private static final String field00947 = "Neuro";
   private static final float field00948 = 50.0F;
   private static final float field00949 = 1000.0F;
   private static final float field00950 = 100.0F;
   private static final float field00951 = 100.0F;
   private static final float field00952 = 6.0F;
   private static final String field00953 = "Сбрасывать спринт";
   private static final float field00954 = 0.9F;
   private static final float field00955 = 0.52F;
   private static final float field00956 = 0.15F;
   private static final String field00957 = "HAND";
   private static final String field00958 = "СТОП лук";
   private static final String field00959 = "Отжимать щит";
   private static final String field00960 = "Не бить если ешь";
   private static final String field00961 = "HAND";
   private static final String field00962 = "СТОП еда";
   private static final String field00963 = "Легитный";
   private static final float field00964 = 9999.0F;
   private static final String field00965 = "Legit";
   private static final String field00966 = "Обход стен";
   private static final double field00967 = 0.001;
   private static final double field00968 = 0.5;
   private static final String field00969 = "ATTACK";
   private static final String field00970 = "УДАР";
   private static final String field00971 = "Ломать щит";
   private static final String field00972 = "1.8";
   private static final String field00973 = "1.8";
   private static final String field00974 = "Тпс синх";
   private static final float field00975 = 19.5F;
   private static final String field00976 = "1.8";
   private static final long field00977 = 50L;
   private static final long field00978 = 473L;
   private static final String field00979 = "1.8";
   private static final float field00980 = 0.05F;
   private static final float field00981 = 0.95F;
   private static final String field00982 = "Не бить через стены";
   private static final String field00983 = "Только криты";
   private static final float field00984 = 0.5F;
   private static final float field00985 = 0.9F;
   private static final String field00986 = "Только криты";
   private static final float field00987 = 0.5F;
   private static final String field00988 = "Друзья";
   private static final String field00989 = "Невидимые";
   private static final String field00990 = "Игроки";
   private static final String field00991 = "Голые";
   private static final String field00992 = "Животные";
   private static final String field00993 = "Жители";
   private static final String field00994 = "Мобы";
   private static final String field00995 = "Криты в воде";
   private static final String field00996 = "1.8";
   private static final String field00997 = "Только криты";
   private static final float field00998 = 0.5F;
   private static final float field00999 = 0.9F;
   private static final float field01000 = 50.0F;
   private static final String field01001 = "1.8";
   private static final float field01002 = 6.0F;
   private static final float field01003 = 20.0F;
   private static final float field01004 = 4.0F;
   private static final float field01005 = 3.0F;
   private static final float field01006 = 100.0F;
   private static final float field01007 = 100.0F;
   private static final float field01008 = 1.5F;
   private static final float field01009 = 1.5F;
   private static final String field01010 = "Legit";
   private static final String field01011 = "Legit";
   private static final String field01012 = "Legit";
   private static final String field01013 = "Legit";
   private static final String field01014 = "1.8";

   private void method00373(ElytraTarget var1) {
      this.field00811.clear();

      for (Entity var3 : mc.level.entitiesForRendering()) {
         if (var3 instanceof LivingEntity sx && this.method00413(var1, sx)) {
            this.field00811.add(sx);
         }
      }

      if (this.field00811.isEmpty()) {
         field00785 = null;
      } else if (this.field00811.size() == 1) {
         field00785 = this.field00811.getFirst();
      } else {
         this.field00812.clear();
         boolean var21 = this.field00769.method04520(field00925);
         boolean sx = this.field00769.method04520(field00926);
         boolean sxx = this.field00769.method04520(field00927);
         boolean sxxx = this.field00769.method04520(field00928);
         boolean sxxxx = this.field00769.method04520(field00929);
         boolean sxxxxx = var21 || sx || sxx || sxxx || sxxxx;
         boolean sxxxxxx = var1.method03937();
         float sxxxxxxx = Math.max(var1.field11503.method03022(), field00930);
         float sxxxxxxxx = Math.max(this.method00403(), field00931);

         for (LivingEntity sxxxxxxxxx : this.field00811) {
            double sxxxxxxxxxx = this.method00419(sxxxxxxxxx) / (sxxxxxx ? sxxxxxxx : sxxxxxxxx);
            double sxxxxxxxxxxx = ItemUtils.method02582(sxxxxxxxxx);
            double sxxxxxxxxxxxx = ItemUtils.method02583(sxxxxxxxxx);
            double sxxxxxxxxxxxxx = -ItemUtils.method02584(sxxxxxxxxx);
            this.field00812
               .add(
                  new AttackAura.Nested16(
                     sxxxxxxxxx, !ItemUtils.method02579(sxxxxxxxxx), sxxxxxxxxxx, sxxxxxxxxxxx, sxxxxxxxxxxxx, sxxxxxxxxxxxxx
                  )
               );
         }

         this.field00812.method00235(var0 -> var0.entity().getId());
         if (sxx) {
            this.field00812.method00234(AttackAura.Nested16::armorScore);
         }

         if (sxxx) {
            this.field00812.method00234(AttackAura.Nested16::fovScore);
         }

         if (sx) {
            this.field00812.method00234(AttackAura.Nested16::healthScore);
         }

         if (var21 || !sxxxxx) {
            this.field00812.method00234(AttackAura.Nested16::distanceScore);
         }

         if (sxxxx) {
            this.field00812.method00235(var0 -> var0.elytraBias() ? 1 : 0);
         }

         field00785 = this.field00812.getFirst().entity();
      }
   }

   private void method00374(ElytraTarget var1, boolean var2) {
      if (!this.method00452()) {
         if (this.field00773.method04520(field00959) && mc.player.isBlocking()) {
            mc.gameMode.releaseUsingItem(mc.player);
         }

         if (!this.field00773.method04520(field00960) || !mc.player.isUsingItem()) {
            if (!this.method00411() && var1.field11510.method05600(field00963) && this.field00787) {
               Vector2f var3 = PlayerUtils.method11816(mc.player.getEyePosition(), field00785.getEyePosition());
               RotationManager.method06547(new Rotation(var3.x, var3.y), field00964, 100, this.field00764.method05600(field00965));
            }

            if (this.field00774.method05600(field00966)) {
               Vec3 var13 = mc.player.getEyePosition();
               Vec3 var4 = field00785.getEyePosition();
               Vec3 var5 = var4.subtract(var13);
               double var6 = var5.length();
               if (var6 < field00967) {
                  return;
               }

               Vec3 var8 = var5.normalize();

               for (double var9 = 0.0; var9 < var6; var9 += field00968) {
                  Vec3 var11 = var13.add(var8.scale(var9));
                  BlockPos var12 = BlockPos.containing(var11);
                  if (!mc.level.isEmptyBlock(var12)) {
                     mc.player.connection.send(new ServerboundPlayerActionPacket(Action.START_DESTROY_BLOCK, var12, Direction.UP));
                     mc.player.connection.send(new ServerboundPlayerActionPacket(Action.STOP_DESTROY_BLOCK, var12, Direction.UP));
                  }
               }
            }

            this.method00461(field00785);
            if (this.field00773.method04520(field00971) && field00785 instanceof Player var14 && var14.isBlocking()) {
               this.method00459(var14);
            }
         }
      }
   }

   public AttackAura() {
      super(ModuleCategory.Combat, ModuleSubCategory.Combat);
      this.field00764 = new ModeSetting(field00814)
         .method05597(field00815, field00816, field00817, field00818, field00819, field00820)
         .method03017(field00821)
         .method03023(this);
      this.field00765 = new NumberSetting<Float>(field00822)
         .method10835(field00823)
         .method10838(field00824)
         .method10834(field00825)
         .method03017(field00826)
         .method03023(this);
      this.field00766 = new NumberSetting<Float>(field00827)
         .method10835(0.0F)
         .method10838(field00828)
         .method10834(field00829)
         .method03017(0.0F)
         .method03023(this);
      this.field00767 = new ModeSetting(field00830).method05597(field00831, field00832).method03017(field00833).method03023(this);
      this.field00768 = new NumberSetting<Integer>(field00834)
         .method10835(1)
         .method10838(5)
         .method10834(1)
         .method03017(1)
         .method03025(() -> this.field00767.method05600(field01014))
         .method03023(this);
      this.field00769 = new MultiToggleSetting(field00835)
         .method04517(NamedOption.method08077(field00836, true))
         .method04517(NamedOption.method08077(field00837, true))
         .method04517(NamedOption.method08077(field00838, false))
         .method04517(NamedOption.method08077(field00839, false))
         .method04517(NamedOption.method08077(field00840, false))
         .method04521(1)
         .method03023(this);
      this.field00770 = new MultiToggleSetting(field00841)
         .method04517(NamedOption.method08077(field00842, true))
         .method04517(NamedOption.method08077(field00843, true))
         .method04517(NamedOption.method08077(field00844, false))
         .method04517(NamedOption.method08077(field00845, false))
         .method04517(NamedOption.method08077(field00846, false))
         .method04517(NamedOption.method08077(field00847, false))
         .method04517(NamedOption.method08077(field00848, true))
         .method03018(field00849)
         .method03023(this);
      this.field00771 = new ToggleSetting(field00850).method03014(true).method03023(this);
      this.field00772 = new ToggleSetting(field00851).method03014(false).method03023(this);
      this.field00773 = new MultiToggleSetting(field00852)
         .method04517(NamedOption.method08077(field00853, true))
         .method04517(NamedOption.method08077(field00854, false))
         .method04517(NamedOption.method08077(field00855, true))
         .method04517(NamedOption.method08077(field00856, false))
         .method04517(NamedOption.method08077(field00857, true))
         .method04517(NamedOption.method08077(field00858, false))
         .method04517(NamedOption.method08077(field00859, true))
         .method04517(NamedOption.method08077(field00860, true))
         .method04517(NamedOption.method08077(field00861, true))
         .method04517(NamedOption.method08077(field00862, false))
         .method03018(field00863)
         .method03023(this);
      this.field00774 = new ModeSetting(field00864).method05597(field00865, field00866, field00867).method03017(field00868).method03023(this);
      this.field00775 = new ModeSetting(field00869).method05597(field00870, field00871, field00872).method03017(field00873).method03023(this);
      this.field00776 = new NumberSetting<Float>(field00874)
         .method10835(1.0F)
         .method10838(field00875)
         .method10834(1.0F)
         .method03017(field00876)
         .method03025(() -> this.field00764.method05600(field01013))
         .method03023(this);
      this.field00777 = new NumberSetting<Float>(field00877)
         .method10835(1.0F)
         .method10838(field00878)
         .method10834(1.0F)
         .method03017(field00879)
         .method03025(() -> this.field00764.method05600(field01012))
         .method03023(this);
      this.field00778 = new NumberSetting<Float>(field00880)
         .method10835(1.0F)
         .method10838(field00881)
         .method10834(1.0F)
         .method03017(field00882)
         .method03025(() -> this.field00764.method05600(field01011))
         .method03023(this);
      this.field00779 = new NumberSetting<Float>(field00883)
         .method10835(1.0F)
         .method10838(field00884)
         .method10834(1.0F)
         .method03017(field00885)
         .method03025(() -> this.field00764.method05600(field01010))
         .method03023(this);
      this.field00780 = new ToggleSetting(field00886).method03014(false);
      this.field00781 = new NumberSetting<Float>(field00887).method10835(0.0F).method10838(field00888).method10834(1.0F).method03017(field00889);
      this.field00782 = new NumberSetting<Float>(field00890).method10835(0.0F).method10838(field00891).method10834(1.0F).method03017(field00892);
      this.field00783 = new NumberSetting<Float>(field00893).method10835(0.0F).method10838(field00894).method10834(field00895).method03017(field00896);
      this.field00784 = new AuraAimPointSelector();
      this.field00786 = new AuraAttackTiming();
      this.field00788 = Vec3.ZERO;
      this.field00789 = new AuraTargetPointTracker();
      this.field00790 = new AuraRotationController(this);
      this.field00791 = new AuraCriticalController(this);
      this.field00792 = new OnnxRotationModel();
      this.field00793 = new RotationModelRepository();
      this.field00794 = false;
      this.field00795 = 0;
      this.field00796 = field00897;
      this.field00804 = false;
      this.field00805 = field00898;
      this.field00806 = field00899;
      this.field00811 = new ArrayList<>();
      this.field00812 = new SortableArrayList<>();
      this.field00813 = 0.0;
      this.method03935(field00900);
      this.field00793.method03648();
   }

   public boolean method00375() {
      boolean var1 = mc.player.onGround();
      boolean var2 = mc.options.keyJump.isDown() || !var1 || this.method00435();
      boolean var3 = this.field00773.method04520(field00986);
      boolean var4 = !var3
         || mc.player.getAbilities().flying
         || mc.player.isFallFlying()
         || this.method00470()
         || mc.player.onClimbable()
         || WorldCollisionUtils.method02821(mc.player.getBoundingBox(), Blocks.COBWEB);
      if (this.method00421()) {
         return true;
      }

      if (mc.player.isInLava()) {
         return true;
      }

      boolean var5 = this.method00462() || this.method00431();
      if (!var5 || !mc.player.isUnderWater() && this.method00381()) {
         boolean var6 = WorldCollisionUtils.method02831();
         if (!this.field00771.method03022() && !var2) {
            return true;
         }

         if (this.method00412(var6)) {
            return true;
         }

         if (var4) {
            return true;
         }

         boolean var7 = ModuleManager.INSTANCE.method08233().method08152();
         return this.method00377(var1, var5) || var7;
      } else {
         return true;
      }
   }

   private void method00376() {
      int var1 = TickEvent.method03209();
      if (this.field00805 != var1) {
         this.field00805 = var1;
         this.field00808 = false;
         this.field00809 = this.method00462();
         this.field00810 = -1;
         if (mc.player != null && mc.player.input != null) {
            SimulatedPlayerInput var2 = SimulatedPlayerInput.method08894(SimulatedPlayerInput.Nested248.fromClientPlayer(mc.player.input.keyPresses));

            for (int var3 = 0; var3 < 10; var3++) {
               var2.method08897();
               if (var2.field20232) {
                  this.field00809 = true;
               } else if (!var2.field20229 && var2.field20225 > 0.0F) {
                  this.field00808 = true;
                  if (this.field00810 < 0) {
                     this.field00810 = var3 + 1;
                  }
               }
            }
         }
      }
   }

   private boolean method00377(boolean var1, boolean var2) {
      Criticals var3 = ModuleManager.INSTANCE.method08233();
      return var3.method08150() ? var3.method08148() : !var1 && !var2 && mc.player.fallDistance > 0.0;
   }

   public boolean method00378() {
      return this.method00431();
   }

   private void method00379() {
      ElytraTarget var1 = ModuleManager.INSTANCE.method08186();
      if (field00785 == null || !this.method00413(var1, field00785)) {
         this.method00373(var1);
      }

      this.method00434(var1);
   }

   private boolean method00380() {
      return this.method00444() && AttackItemUtils.method05346(mc.player);
   }

   private boolean method00381() {
      return this.field00773.method04520(field00995) || this.field00772.method03022() || ModuleManager.INSTANCE.method08233().method08150();
   }

   @Override
   public void method00382() {
      if (mc.player != null && mc.level != null) {
         field00785 = null;
         this.field00789.method03329();
         this.field00788 = Vec3.ZERO;
         this.field00798 = 0;
         this.field00799 = 0;
         this.field00801 = false;
         this.field00790.method05311();
         this.field00791.method00903();
         super.method00382();
      }
   }

   public boolean method00383() {
      return this.method00469();
   }

   @Subscribe
   private void method00384(FrameUpdateEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (field00785 != null) {
            if (this.method00411()) {
               return;
            }

            this.method00455(false, 50);
         }
      }
   }

   public float method00385() {
      return field00943;
   }

   @Subscribe
   private void method00386(AuraUpdateEvent var1) {
      this.field00790.method05317(false, 50, true);
   }

   public boolean method00387() {
      return this.field00764.method05600(field00944) ? this.field00780.method03022() : this.method00388().method05877();
   }

   private OnnxRotationSettingsCodec method00388() {
      OnnxRotationSettingsCodec var1 = CloudRotationRegistry.INSTANCE.method08498(this.field00764.method03022());
      return var1 == null ? OnnxRotationSettingsCodec.field12508 : var1;
   }

   private boolean method00389() {
      if (this.field00791.method00901() >= 0) {
         return true;
      }

      this.method00376();
      return this.field00808;
   }

   public RotationModelRepository method00390() {
      return this.field00793;
   }

   @Subscribe
   private void method00391(SprintSyncEvent var1) {
      this.field00801 = false;
   }

   private boolean method00392() {
      float var1 = ServerTickRateTracker.INSTANCE.method00347();
      return Float.isFinite(var1) && var1 <= field00975;
   }

   @Subscribe
   private void method00393(FrameDeltaEvent var1) {
      if (mc.player != null && mc.level != null && field00785 != null) {
         float var2 = var1.method09793();
         if (this.method00411() ? !(var2 > field00952) : var2 == 1.0F) {
            this.field00790.method05323(50);
         }
      }
   }

   private boolean method00394(SimulatedPlayerInput var1) {
      Vec3 var2 = var1.field20218.add(0.0, mc.player.getEyeHeight(), 0.0);
      AABB var3 = field00785.getBoundingBox().move(MovementUtils.method05718(field00785));
      Vector2f var4 = PlayerUtils.method11816(var2, var3.getCenter());
      return RaycastUtils.method09499(var2, var4.x, var4.y, this.method00403(), this.field00774.method05600(field00982), var3);
   }

   public boolean method00395(boolean var1, boolean var2) {
      boolean var3 = Math.abs(this.field00813) <= this.method00403();
      boolean var4 = this.field00773.method04520(field00983);
      float var5 = AttackCooldownUtils.method00008(mc.player, this.method00399());
      if (!var1 && (var2 || !(var5 < this.method00400()) && (!var4 || !(mc.player.getAttackStrengthScale(field00984) <= field00985)))) {
         return !var3 ? false : this.method00433();
      } else {
         return false;
      }
   }

   private static float method00397(float var0) {
      return Math.max(0.0F, Math.min(field01006, var0)) / field01007;
   }

   public boolean method00398() {
      return this.field00772.method03022();
   }

   private float method00399() {
      if (mc.player != null && !this.field00767.method05600(field00973)) {
         boolean var1 = this.field00773.method04520(field00974) && this.method00392();
         return method00460(var1, ServerTickRateTracker.INSTANCE.method00353());
      } else {
         return 0.0F;
      }
   }

   private float method00400() {
      return this.field00767.method05600(field00979) ? field00980 : field00981;
   }

   public MultiToggleSetting method00401() {
      return this.field00773;
   }

   private static float method00402(float var0) {
      return var0 < field01004 ? 0.0F : var0 - field01005;
   }

   public float method00403() {
      float var1 = this.field00765.method03022();
      return this.method00421() ? field01002 : var1;
   }

   @Subscribe
   public void method00404(PlayerInputEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (field00785 != null && !mc.player.isFallFlying()) {
            switch ((String)this.field00775.method03022()) {
               case field00902:
                  Vec3 var4 = MovementUtils.method05718(field00785).scale(field00904);
                  Vec3 var5 = field00785.position().add(var4);
                  MovementUtils.method05719(var1, Mth.wrapDegrees(mc.player.getYRot()), var5.x() - mc.player.getX(), var5.z() - mc.player.getZ());
                  break;
               case field00903:
                  RotationManager.field14787 = true;
            }
         }
      }
   }

   public float method00405() {
      return this.method00432(this.field00764.method05600(field00946) ? this.field00782.method03022() : this.method00388().method05880());
   }

   private void method00406(ElytraTarget var1, LivingEntity var2) {
      float var3 = (float)(var2.getX() - var2.xo);
      float var4 = (float)(var2.getY() - var2.yo);
      float var5 = (float)(var2.getZ() - var2.zo);
      float var6 = method00415(var3, var4, var5);
      if (var6 > var1.field11508.method03022().intValue()) {
         this.field00795 = 0;
         this.field00804 = false;
         this.field00794 = true;
      } else {
         this.field00795++;
         if (this.field00794) {
            this.field00804 = true;
         }

         if (this.field00795 >= 3) {
            this.field00794 = false;
            this.field00795 = 0;
            this.field00804 = false;
         } else {
            this.field00794 = this.field00804;
         }
      }
   }

   private boolean method00408() {
      if (this.method00462()) {
         return this.method00389();
      }

      if (!this.method00471(true)) {
         return false;
      }

      if (this.field00798 > 1) {
         return false;
      }

      if (ModuleManager.INSTANCE.method08233().method08148()) {
         return true;
      }

      int var1 = this.method00439();
      return var1 >= 0 && var1 <= 1;
   }

   public boolean method00409(boolean var1) {
      return this.method00395(var1, false);
   }

   public int method00410() {
      int var1 = this.field00767.method05600(field01001) ? 0 : AttackCooldownUtils.method00006(mc.player);
      return Math.max(var1, this.field00798);
   }

   public boolean method00411() {
      return this.field00764.method05600(field00934)
         || this.field00764.method05600(field00935)
         || this.field00764.method05600(field00936)
         || this.field00764.method05600(field00937)
         || this.field00764.method05600(field00938)
         || this.field00764.method05600(field00939)
         || CloudRotationRegistry.INSTANCE.method08499(this.field00764.method03022());
   }

   private boolean method00412(boolean var1) {
      return !var1 && WorldCollisionUtils.method02827();
   }

   private boolean method00413(ElytraTarget var1, LivingEntity var2) {
      if (var2 instanceof LocalPlayer) {
         return false;
      }

      if (var2.tickCount >= 3 && !var2.isDeadOrDying()) {
         if (this.method00419(var2) > this.method00457(var1)) {
            return false;
         }

         if (var2 instanceof Player var3) {
            if (ModuleManager.INSTANCE.method08260().method00605(var2)) {
               return false;
            }

            if (!this.field00770.method04520(field00988) && FriendManager.INSTANCE.method00172(var3)) {
               return false;
            }
         }

         if (!this.field00770.method04520(field00989) && var2.isInvisible()) {
            return false;
         }

         if (var2.isAlive()) {
            if (this.field00770.method04520(field00990) && var2 instanceof Player && var2.getArmorValue() > 0) {
               return true;
            }

            if (this.field00770.method04520(field00991) && var2 instanceof Player && var2.getArmorValue() == 0) {
               return true;
            }

            if (this.field00770.method04520(field00992) && var2 instanceof Animal) {
               return true;
            }

            if (this.field00770.method04520(field00993) && (var2 instanceof Villager || var2 instanceof WanderingTrader)) {
               return true;
            }

            if (this.field00770.method04520(field00994)
               && var2 instanceof Mob
               && !(var2 instanceof Animal)
               && !(var2 instanceof Villager)
               && !(var2 instanceof WanderingTrader)) {
               return true;
            }
         }

         return false;
      } else {
         return false;
      }
   }

   public float method00414() {
      return this.field00766.method03022();
   }

   private static float method00415(float var0, float var1, float var2) {
      return (float)Math.sqrt(var0 * var0 + var1 * var1 + var2 * var2) * field01003;
   }

   public float method00416() {
      return Mth.clamp(this.field00779.method03022(), 1.0F, field00951);
   }

   public float method00417() {
      return Mth.clamp(this.field00777.method03022(), 1.0F, field00941);
   }

   public boolean method00418(LivingEntity var1) {
      return mc.player != null && var1 != null
         ? this.method00421()
            || RaycastUtils.method09505(mc.player.getYRot(), mc.player.getXRot(), this.method00403(), var1, this.field00774.method05600(field00923))
            || !this.field00773.method04520(field00924)
         : false;
   }

   public double method00419(LivingEntity var1) {
      return ((EntityExtensionAccess)mc.player).getDistanceEyePos(var1);
   }

   private boolean method00421() {
      return PlayerVelocityTracker.INSTANCE.method02572();
   }

   @Subscribe
   private void method00422(SprintStateEvent var1) {
      if (this.method00469() || this.field00801) {
         var1.method03879(false);
      }
   }

   @Subscribe
   private void method00423(TickEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (this.field00798 > 0) {
            this.field00798--;
         }

         this.field00800 = mc.player.onGround() ? this.field00800 + 1 : 0;
         this.method00379();
         this.field00791.method00898();
      }
   }

   private void method00424(ElytraTarget var1) {
      if (!this.field00767.method05600(field00908)
         || !this.method00426()
         || this.method00462()
         || !this.field00801 && this.field00798 <= 0 && this.method00471(false)) {
         boolean var2 = false;
         if (this.field00773.method04520(field00914) && this.field00802 % this.field00803 == 0) {
            this.field00803 = 0;
            var2 = true;
         }

         boolean var3 = this.method00380();
         boolean var4 = this.field00786.method09854();
         boolean var5 = this.method00395(var2, var3);
         if ((!var4 || !var5) && !var2) {
            if (var4) {
               ;
            }

            if (var4) {
               ;
            }
         } else {
            boolean var6 = this.method00450();
            if (var6) {
               if (!this.method00463()) {
                  this.method00374(var1, var3);
               }
            }
         }
      } else {
         if (!this.field00801 && this.field00798 <= 0) {
            ;
         }

         if (!this.field00801) {
            if (this.field00798 > 0) {
               String.valueOf("СТОП кд ауры " + this.field00798);
            }
         }
      }
   }

   private boolean method00425() {
      this.method00376();
      return this.field00809 && !this.method00389();
   }

   private boolean method00426() {
      return this.field00773.method04520(field00953);
   }

   private void method00427(ElytraTarget var1) {
      float var2 = var1.field11509.method03022();
      float var3 = method00402(var2);

      Vec3 var4 = switch ((String)var1.field11507.method03022()) {
         case field00907 -> this.field00789.method03330(field00785, var2, var3);
         default -> this.field00789.method03326(field00785, var2 + 2.0F, var3);
      };
      this.field00788 = this.field00789.method03324();
      this.method00442(var4);
   }

   public boolean method00428() {
      return this.field00773.method04520(field00933);
   }

   public ModeSetting method00429() {
      return this.field00764;
   }

   private boolean method00431() {
      int var1 = TickEvent.method03209();
      if (this.field00806 != var1) {
         this.field00806 = var1;
         this.field00807 = WorldCollisionUtils.method02829(mc.player.getBoundingBox());
      }

      return this.field00807;
   }

   private float method00432(float var1) {
      return method00397(var1);
   }

   public boolean method00433() {
      return this.method00375() || this.method00425() || this.field00791.method00902();
   }

   private void method00434(ElytraTarget var1) {
      if (this.field00803 == 0) {
         this.field00803 = (int)GuiHitTestUtils.method05613(field00905, field00906);
      }

      if (field00785 != null) {
         if (this.method00469() && mc.player.isSprinting()) {
            mc.player.setSprinting(false);
            this.field00801 = true;
         }

         this.method00406(var1, field00785);
         this.method00427(var1);
         this.field00784.method01258(field00785);
         this.field00784.method01257(var1, this, field00785);
         this.field00790.method05312(50);
         this.method00424(var1);
      }
   }

   private boolean method00435() {
      return this.field00800 <= mc.player.getCurrentItemAttackStrengthDelay() * field00987;
   }

   private int method00436() {
      long var1 = this.field00786.method09850() - this.field00786.method09852().method04693();
      return var1 <= 0L ? 0 : Mth.ceil((float)var1 / field01000);
   }

   public boolean method00437() {
      return field00785 != null && this.method00444() && AttackItemUtils.method05346(mc.player);
   }

   public boolean method00438() {
      return this.field00772.method03022();
   }

   public int method00439() {
      int var1 = this.field00791.method00901();
      if (var1 >= 0) {
         return var1;
      }

      this.method00376();
      return this.field00810;
   }

   public boolean method00441() {
      return this.field00774.method05600(field00932);
   }

   private void method00442(Vec3 var1) {
      float var2 = (float)var1.distanceTo(mc.player.getEyePosition());
      float var3 = (float)this.method00419(field00785);
      this.field00813 = this.field00787 ? var2 : var3;
   }

   private boolean method00444() {
      if (mc.player == null) {
         return false;
      }

      if (AttackItemUtils.method05343()) {
         return true;
      }

      MaceHelper var1 = ModuleManager.INSTANCE.method08213();
      return var1 != null && var1.method00940();
   }

   public float method00445() {
      return this.method00432(this.field00764.method05600(field00945) ? this.field00781.method03022() : this.method00388().method05876());
   }

   public OnnxRotationModel method00446() {
      return this.field00792;
   }

   private long method00447() {
      return this.field00767.method05600(field00976) ? this.field00768.method03022().intValue() * field00977 : field00978;
   }

   public float method00448() {
      return Mth.clamp(this.field00776.method03022(), 1.0F, field00940);
   }

   public float method00449() {
      return Mth.clamp(this.field00778.method03022(), 1.0F, field00950);
   }

   public boolean method00450() {
      return this.method00418(field00785) || this.field00787;
   }

   public boolean method00451() {
      if (mc.player == null) {
         return false;
      } else {
         float var1 = mc.player.getCurrentItemAttackStrengthDelay();
         if (Float.isFinite(var1) && !(var1 <= 0.0F)) {
            float var2 = this.field00764.method05600(field00947) ? this.field00783.method03022() : this.method00388().method05879();
            return AttackCooldownUtils.method00006(mc.player) * field00948 <= Mth.clamp(var2, 0.0F, field00949);
         } else {
            return true;
         }
      }
   }

   private boolean method00452() {
      if (mc.player != null && mc.player.isUsingItem()) {
         ItemStack var1 = mc.player.getActiveItem();
         return var1.is(Items.BOW) || var1.is(Items.CROSSBOW);
      } else {
         return false;
      }
   }

   public Rotation method00453() {
      return this.field00790.method05316();
   }

   public float method00454() {
      return this.method00457(ModuleManager.INSTANCE.method08186());
   }

   private void method00455(boolean var1, int var2) {
      this.field00790.method05317(var1, var2, false);
   }

   public static LivingEntity method00456() {
      return field00785;
   }

   private float method00457(ElytraTarget var1) {
      float var2 = mc.player.isFallFlying() && var1.method03937() ? var1.field11503.method03022() : 0.0F;
      return this.method00403() + this.method00414() + var2;
   }

   private void method00459(Player var1) {
      Slot var2 = InventoryUtils.method06141();
      if (var1.getActiveItem().getItem() == Items.SHIELD && var2 != null) {
         int var3 = mc.player.getInventory().getSelectedSlot();
         int var4 = InventoryUtils.method06098(true);
         if (var4 != -1) {
            boolean var5 = var3 != var4;
            if (var5) {
               InventoryUtils.method06091(var4);
            }

            this.method00461(var1);
            if (var5) {
               InventoryUtils.method06091(var3);
            }
         }
      }
   }

   private static float method00460(boolean var0, float var1) {
      return var0 ? -var1 + field01008 : field01009;
   }

   private void method00461(LivingEntity var1) {
      mc.gameMode.attack(mc.player, var1);
      mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
      long var2 = this.method00447();
      this.field00786.method09851(var2);
      this.field00798 = this.field00767.method05600(field00972) ? this.field00768.method03022() : 10;
      this.field00799 = 0;
      this.field00802++;
   }

   private boolean method00462() {
      return mc.player.isInWater();
   }

   private boolean method00463() {
      if (mc.player == null || field00785 == null) {
         return false;
      }

      if (!this.method00444() || !AttackItemUtils.method05345()) {
         return false;
      }

      if (mc.player.onGround() || mc.player.isFallFlying() || this.method00462() || mc.player.fallDistance <= 0.0) {
         this.field00799 = 0;
         return false;
      }

      if (this.field00799 >= 100) {
         return false;
      }

      SimulatedPlayerInput var1 = SimulatedPlayerInput.method08931(1);
      if (!var1.field20229 && !var1.field20232) {
         if (var1.field20225 <= mc.player.fallDistance) {
            return false;
         }

         if (!this.method00394(var1)) {
            return false;
         }

         this.field00799++;
         return true;
      } else {
         return false;
      }
   }

   @Subscribe
   private void method00464(EntityDeathEvent var1) {
      if (this.field00773.method04520(field00901)) {
         if (var1.method11303() instanceof LocalPlayer) {
            this.method00382();
         }
      }
   }

   public int method00465() {
      if (mc.player == null) {
         return 0;
      }

      int var1 = Math.max(this.field00798, this.method00436());
      if (this.field00767.method05600(field00996)) {
         return var1;
      }

      var1 = Math.max(var1, AttackCooldownUtils.method00007(mc.player, this.method00399(), this.method00400()));
      if (this.field00773.method04520(field00997)) {
         var1 = Math.max(
            var1, AttackCooldownUtils.method00010(mc.player, field00998, field00999) - ((LivingEntityMixin_1248)(Object)mc.player).getAttackStrengthTicker()
         );
      }

      return var1;
   }

   public AuraAimPointSelector method00466() {
      return this.field00784;
   }

   public float method00467() {
      return field00942;
   }

   @Subscribe(3)
   private void method00468(PlayerInputEvent var1) {
      this.field00791.method00900(var1);
   }

   private boolean method00469() {
      if (mc.player != null && field00785 != null && this.method03937() && this.method00426()) {
         int var1 = TickEvent.method03209();
         if (this.field00796 == var1) {
            return this.field00797;
         }

         this.field00796 = var1;
         this.field00797 = this.method00408();
         return this.field00797;
      } else {
         return false;
      }
   }

   private boolean method00470() {
      return mc.player.hasEffect(MobEffects.BLINDNESS)
         || mc.player.hasEffect(MobEffects.LEVITATION)
         || mc.player.hasEffect(MobEffects.SLOW_FALLING) && !ModuleManager.INSTANCE.method08233().method08147();
   }

   private boolean method00471(boolean var1) {
      float var2 = 0.0F;
      ItemStack var3 = mc.player.getMainHandItem();
      if (var3.isEmpty()) {
         var2 = field00954;
      }

      if (var3.is(ItemTags.SWORDS)) {
         var2 = field00955;
      }

      if (var1) {
         var2 -= field00956;
      }

      return HandHeightTracker.mainHandHeight() > var2;
   }

   // $VF: Compiled from s
   private record Nested16(LivingEntity entity, boolean elytraBias, double distanceScore, double healthScore, double fovScore, double armorScore) {
   }
}
