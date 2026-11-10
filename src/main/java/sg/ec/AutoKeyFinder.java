// Original binary: sg/ec/vfoy6gNo2mkqjjHK
package sg.ec;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.Map.Entry;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Predicate;
import net.minecraft.client.gui.screens.inventory.ContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.core.Direction.Plane;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Abilities;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.vehicle.minecart.MinecartChest;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.EntityHitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

// $VF: Compiled from s
public class AutoKeyFinder extends ClientModule {
   private static final String field24719 = "AutoKeyFinder";
   private static final String[] field24720 = new String[]{AutoKeyFinder.field24951, AutoKeyFinder.field24952, AutoKeyFinder.field24953};
   private static final double field24721 = 0;
   private static final double field24722 = 0;
   private static final double[] field24723 = new double[]{AutoKeyFinder.field24954, AutoKeyFinder.field24955};
   private static final int field24724 = 0;
   private static final double field24725 = 0;
   private static final int field24726 = 0;
   private static final double field24727 = 0;
   private static final double field24728 = 0;
   private static final double field24729 = 0;
   private static final double field24730 = 0;
   private static final int field24731 = 0;
   private static final int field24732 = 0;
   private static final double field24733 = 0;
   private static final double field24734 = 0;
   private static final double field24735 = 0;
   private static final double field24736 = 0;
   private static final double field24737 = 0;
   private static final double field24738 = 0;
   private static final double field24739 = 0;
   private static final double field24740 = 0;
   private static final double field24741 = 0;
   private static final double field24742 = 0;
   private static final double field24743 = 0;
   private static final float field24744 = 0;
   private static final int field24745 = 0;
   private static final int field24746 = 0;
   private static final int field24747 = 0;
   private static final long field24748 = 0;
   private static final long field24749 = 0;
   private static final long field24750 = 0;
   private static final double field24751 = 0;
   private static final double field24752 = 0;
   private static final double field24753 = 0;
   private static final double field24754 = 0;
   private static final double field24755 = 0;
   private static final double field24756 = 0;
   private static final double field24757 = 0;
   private static final double field24758 = 0;
   private static final double field24759 = 0;
   private static final double field24760 = 0;
   private static final float field24761 = 0;
   private static final int field24762 = 0;
   private static final int field24763 = 0;
   private static final int field24764 = 0;
   private static final double field24765 = 0;
   private static final double field24766 = 0;
   private static final int field24767 = 0;
   private static final double field24768 = 0;
   private static final double field24769 = 0;
   private static final double field24770 = 0;
   private static final double field24771 = 0;
   private static final double field24772 = 0;
   private static final int field24773 = 0;
   private static final int field24774 = 0;
   private static final int field24775 = 0;
   private static final int field24776 = 0;
   private static final int field24777 = 0;
   private static final int field24778 = 0;
   private static final int field24779 = 0;
   private static final int field24780 = 0;
   private static final int field24781 = 0;
   private static final double field24782 = 0;
   private static final long field24783 = 0;
   private static final Set<Item> field24784 = Set.of(Items.NAME_TAG, Items.GOLDEN_APPLE, Items.ENCHANTED_GOLDEN_APPLE);
   private static final Predicate<ItemStack> field24785 = var0 -> field24784.contains(var0.getItem());
   private static final Set<KeyFinderPhase> field24786 = EnumSet.of(
      KeyFinderPhase.TAKE_OFF,
      KeyFinderPhase.TRAVEL,
      KeyFinderPhase.LAND,
      KeyFinderPhase.APPROACH,
      KeyFinderPhase.RETREAT,
      KeyFinderPhase.REGEN
   );
   private final NumberSetting<Integer> field24787;
   private final NumberSetting<Integer> field24788;
   private final NumberSetting<Integer> field24789;
   private final NumberSetting<Integer> field24790;
   private final NumberSetting<Integer> field24791;
   private final NumberSetting<Integer> field24792;
   private final ToggleSetting field24793;
   private final NumberSetting<Integer> field24794;
   private final NumberSetting<Integer> field24795;
   private final ToggleSetting field24796;
   private final Map<UUID, Vec3> field24797;
   private final Set<UUID> field24798;
   private final List<Vec3> field24799;
   private volatile int field24800;
   private final KeyFinderInventoryController field24801;
   private final ElapsedTimer field24802;
   private final KeyFinderState field24803;
   private final KeyFinderState field24804;
   private final KeyFinderState field24805;
   private KeyFinderPhase field24806;
   private UUID field24807;
   private Vec3 field24808;
   private MinecartChest field24809;
   private String field24810;
   private Vec3 field24811;
   private String field24812;
   private Vec3 field24813;
   private Vec3 field24814;
   private BlockPos field24815;
   private Vec3 field24816;
   private Level field24817;
   private boolean field24818;
   private boolean field24819;
   private boolean field24820;
   private Vec3 field24821;
   private Level field24822;
   private List<AutoKeyFinder.Nested318> field24823;
   private int field24824;
   private double field24825;
   private int field24826;
   private boolean field24827;
   private Vec3 field24828;
   private double field24829;
   private Vec3 field24830;
   private Vec3 field24831;
   private Vec3 field24832;
   private int field24833;
   private double field24834;
   private int field24835;
   private Vec3 field24836;
   private int field24837;
   private double field24838;
   private int field24839;
   private double field24840;
   private int field24841;
   private int field24842;
   private int field24843;
   private int field24844;
   private int field24845;
   private int field24846;
   private int field24847;
   private int field24848;
   private int field24849;
   private static final String field24850 = "Цель X";
   private static final String field24851 = "Цель Z";
   private static final String field24852 = "Высота полёта";
   private static final String field24853 = "Радиус поиска";
   private static final String field24854 = "Клик раз в N тиков";
   private static final String field24855 = "Удар раз в N тиков";
   private static final String field24856 = "Авто еда";
   private static final String field24857 = "Есть при голоде ниже";
   private static final String field24858 = "На спавн при HP ниже";
   private static final String field24859 = "AutoLeave от игроков";
   private static final long field24860 = 62000L;
   private static final long field24861 = 62000L;
   private static final long field24862 = 12000L;
   private static final String field24863 = "Auto Key Finder";
   private static final String field24864 = "spawn";
   private static final String field24865 = "fly";
   private static final double field24866 = 1.5;
   private static final double field24867 = 0.1;
   private static final double field24868 = 0.5;
   private static final double field24869 = Double.MAX_VALUE;
   private static final double field24870 = 0.5;
   private static final double field24871 = 0.5;
   private static final double field24872 = 4.0;
   private static final double field24873 = 0.6;
   private static final double field24874 = 16.0;
   private static final double field24875 = 1.5;
   private static final double field24876 = 12.0;
   private static final double field24877 = 96.0;
   private static final double field24878 = Math.PI;
   private static final double field24879 = -Math.PI;
   private static final double field24880 = 0.5;
   private static final double field24881 = 10.0;
   private static final double field24882 = 12.0;
   private static final double field24883 = 10.0;
   private static final double field24884 = 2.0;
   private static final double field24885 = Double.MAX_VALUE;
   private static final double field24886 = 3.0;
   private static final float field24887 = 90.0F;
   private static final float field24888 = 180.0F;
   private static final double field24889 = 4.0;
   private static final double field24890 = 1.5;
   private static final double field24891 = -1.5;
   private static final double field24892 = Double.MAX_VALUE;
   private static final double field24893 = 0.3;
   private static final double field24894 = 0.1;
   private static final double field24895 = 1.5;
   private static final double field24896 = 0.05;
   private static final double field24897 = 0.1;
   private static final int field24898 = Integer.MAX_VALUE;
   private static final double field24899 = 1.5;
   private static final double field24900 = 0.3;
   private static final double field24901 = 1.5;
   private static final double field24902 = 1.5;
   private static final double field24903 = Double.MAX_VALUE;
   private static final double field24904 = Double.MAX_VALUE;
   private static final double field24905 = 4.0;
   private static final double field24906 = 0.5;
   private static final double field24907 = 0.5;
   private static final double field24908 = Double.MAX_VALUE;
   private static final double field24909 = 0.5;
   private static final double field24910 = 0.3;
   private static final double field24911 = Math.PI * 2;
   private static final double field24912 = 8.0;
   private static final double field24913 = Double.MAX_VALUE;
   private static final double field24914 = 0.5;
   private static final double field24915 = 0.5;
   private static final double field24916 = 1.5;
   private static final double field24917 = 3.0;
   private static final double field24918 = 3.0;
   private static final double field24919 = 3.0;
   private static final double field24920 = 0.05;
   private static final double field24921 = Double.MAX_VALUE;
   private static final double field24922 = Double.MAX_VALUE;
   private static final double field24923 = 0.5;
   private static final double field24924 = 1.95;
   private static final double field24925 = 4.0;
   private static final double field24926 = 10.0;
   private static final double field24927 = 1.0E-4;
   private static final double field24928 = 2.5;
   private static final double field24929 = 2.5;
   private static final double field24930 = 2.5;
   private static final double field24931 = 0.3;
   private static final double field24932 = 0.3;
   private static final double field24933 = 4.0;
   private static final long field24934 = 3000L;
   private static final String field24935 = "spawn";
   private static final String field24936 = "ec 1";
   private static final String field24937 = "heal";
   private static final String field24938 = "rtpfar";
   private static final String field24939 = "rtpdefault";
   private static final double field24940 = 16.0;
   private static final float field24941 = 4.0F;
   private static final long field24942 = 3000L;
   private static final double field24943 = 6.0;
   private static final double field24944 = 0.5;
   private static final double field24945 = Double.MAX_VALUE;
   private static final double field24946 = 5.0;
   private static final double field24947 = 0.5;
   private static final double field24948 = 0.5;
   private static final float field24949 = 180.0F;
   private static final double field24950 = Double.MAX_VALUE;
   private static final String field24951 = "hata";
   private static final String field24952 = "toper";
   private static final String field24953 = "ezz";
   private static final double field24954 = 2.0;
   private static final double field24955 = 3.0;

   private boolean method11020(BlockState var1) {
      return var1.isAir() || var1.is(Blocks.WATER);
   }

   private void method11021() {
      if (this.field24810 == null) {
         this.method11087();
      } else {
         this.method11072();
      }
   }

   @Subscribe
   private void method11022(PacketEvent var1) {
      if (var1.method10904() && var1.method10897() instanceof ClientboundPlayerPositionPacket) {
         this.field24800++;
      }
   }

   private void method11023(PlayerInputEvent var1) {
      var1.method11159();
      if (this.method11025()) {
         AbstractContainerMenu var2 = this.method11113();
         if (var2 != null) {
            this.method11041(var2);
            this.method11063(KeyFinderPhase.LOOT);
         } else {
            Vec3 var3 = this.field24809.getBoundingBox().getCenter();
            this.method11047(var3);
            if (this.field24846-- <= 0) {
               InteractionResult var4 = mc.gameMode.interact(mc.player, this.field24809, new EntityHitResult(this.field24809, var3), InteractionHand.MAIN_HAND);
               mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
               this.field24846 = 20;
            }
         }
      }
   }

   private void method11024() {
      if (this.field24810 == null && this.field24812 != null) {
         this.field24810 = this.field24812;
         this.field24811 = this.field24813;
      }

      if (this.field24810 == null) {
         this.field24818 = false;
         this.method11087();
      } else {
         this.field24848 = 0;
         this.method11072();
      }
   }

   private boolean method11025() {
      if (this.field24809 != null) {
         return true;
      }

      this.method11110();
      return false;
   }

   @Subscribe
   private void method11026(PlayerInputEvent var1) {
      if (mc.player != null && mc.level != null && mc.gameMode != null) {
         this.field24831 = null;
         this.field24840 = 0.0;
         if (this.field24806 == KeyFinderPhase.IDLE) {
            this.method11046();
         } else if (this.field24806 != KeyFinderPhase.DONE) {
            if (!this.field24818) {
               this.method11056();
               Player var2 = this.field24796.method05999() ? this.method11033() : null;
               if (var2 != null) {
                  this.method11059(var2);
                  return;
               }

               if (this.field24806 != KeyFinderPhase.REGEN && mc.player.getHealth() < this.method11075()) {
                  this.method11049();
                  return;
               }

               if (this.method11061(var1)) {
                  return;
               }
            }

            if (this.field24806.method06862() && this.field24802.method04699(this.field24806.method06863())) {
               this.method11034();
            } else {
               switch (this.field24806) {
                  case ENABLE_FLY:
                     var1.method11159();
                     this.method11096();
                     break;
                  case TAKE_OFF:
                     this.method11105(var1);
                     break;
                  case TRAVEL:
                     this.method11045(var1);
                     break;
                  case LAND:
                     this.method11086(var1);
                     break;
                  case ALIGN:
                     this.method11099(var1);
                     break;
                  case WAIT_SETHOME:
                  case HEAL:
                     var1.method11159();
                     break;
                  case APPROACH:
                     this.method11071(var1);
                     break;
                  case REGEN:
                     this.method11030(var1);
                     break;
                  case OPEN:
                     this.method11023(var1);
                     break;
                  case LOOT:
                     this.method11035(var1);
                     break;
                  case RETREAT:
                     this.method11043(var1);
                     break;
                  case BREAK:
                     this.method11100(var1);
                     break;
                  case WAIT_HOME:
                     this.method11039(var1);
                     break;
                  case SPAWN:
                     this.method11055(var1);
                     break;
                  case RTP:
                     this.method11117(var1);
                     break;
                  case EC_OPEN:
                     this.method11027(var1);
                     break;
                  case EC_DEPOSIT:
                     this.method11076(var1);
               }
            }
         }
      }
   }

   private void method11027(PlayerInputEvent var1) {
      var1.method11159();
      AbstractContainerMenu var2 = this.method11113();
      if (var2 != null) {
         this.method11041(var2);
         this.method11063(KeyFinderPhase.EC_DEPOSIT);
      } else {
         if (this.field24846-- == 0) {
            this.method11054(field24936);
         }
      }
   }

   private boolean method11028(Vec3 var1) {
      AABB var2 = mc.player.getBoundingBox().move(var1.subtract(mc.player.position()));
      return mc.level.noBlockCollision(mc.player, var2) && !WorldCollisionUtils.method02822(var2.inflate(field24931));
   }

   private double method11029(Vec3 var1, Vec3 var2) {
      int var3 = Math.max(1, (int)Math.ceil(Math.hypot(var2.x - var1.x, var2.z - var1.z)));
      double var4 = mc.level.getMinY();

      for (int var6 = 0; var6 <= var3; var6++) {
         double var7 = (double)var6 / var3;
         var4 = Math.max(var4, this.method11115(Mth.lerp(var7, var1.x, var2.x), Mth.lerp(var7, var1.z, var2.z)));
      }

      return var4;
   }

   private void method11030(PlayerInputEvent var1) {
      if (this.method11106()) {
         if (this.field24830 != null && mc.player.isInWall()) {
            NoClipMovementController.INSTANCE.method06468(var1, this.field24830);
         } else {
            var1.method11159();
            if (mc.player.getHealth() >= this.field24829) {
               this.method11073();
            } else if (this.field24803.method11549()) {
               this.method11070();
            }
         }
      }
   }

   private void method11031(double var1) {
      if (var1 < this.field24825 - field24907) {
         this.field24825 = var1;
         this.field24826 = 0;
      } else if (++this.field24826 >= 20) {
         this.field24826 = 0;
         this.field24825 = var1;
         this.field24827 = true;
      }
   }

   private boolean method11032(double var1) {
      if (var1 < this.field24834 - 1.0) {
         this.field24834 = var1;
         this.field24835 = 0;
         return false;
      }

      if (++this.field24835 < 40) {
         return false;
      }

      this.field24835 = 0;
      this.field24834 = var1;
      return true;
   }

   private Player method11033() {
      for (Player var2 : mc.level.players()) {
         if (var2 != mc.player) {
            return var2;
         }
      }

      return null;
   }

   private void method11034() {
      switch (this.field24806) {
         case ENABLE_FLY:
            this.method11074(this::method11087);
            break;
         case TAKE_OFF:
            this.method11063(KeyFinderPhase.TRAVEL);
            break;
         case TRAVEL:
         case REGEN:
         default:
            this.method11063(this.field24806);
            break;
         case LAND:
            this.method11091();
            break;
         case ALIGN:
            this.field24848++;
            if (this.field24848 >= 3) {
               this.method11091();
               return;
            }

            this.field24815 = null;
            this.method11063(KeyFinderPhase.LAND);
            break;
         case WAIT_SETHOME:
            this.field24812 = this.field24810;
            this.field24813 = this.field24811;
            this.method11091();
            break;
         case HEAL:
            this.method11024();
            break;
         case APPROACH:
         case BREAK:
            this.method11110();
            break;
         case OPEN:
            this.method11094();
            break;
         case LOOT:
            mc.player.closeContainer();
            this.method11094();
            break;
         case RETREAT:
            this.method11051();
            break;
         case WAIT_HOME:
            this.method11074(this::method11072);
            break;
         case SPAWN:
            this.field24848++;
            if (this.field24848 >= 3) {
               this.method11088();
               return;
            }

            this.method11054(field24864);
            this.method11063(KeyFinderPhase.SPAWN);
            break;
         case RTP:
            this.field24848++;
            if (this.field24848 >= 3) {
               this.method11107();
               return;
            }

            this.field24820 = false;
            this.method11063(KeyFinderPhase.RTP);
            break;
         case EC_OPEN:
            this.field24848++;
            if (this.field24848 >= 3) {
               this.method11103();
               return;
            }

            this.field24846 = 0;
            this.method11063(KeyFinderPhase.EC_OPEN);
            break;
         case EC_DEPOSIT:
            mc.player.closeContainer();
            this.method11103();
      }
   }

   private void method11035(PlayerInputEvent var1) {
      var1.method11159();
      AbstractContainerMenu var2 = this.method11113();
      if (var2 != null && var2.containerId == this.field24843) {
         if (this.field24846-- <= 0) {
            Slot var3 = this.method11082(var2, false, this::method11095);
            if (var3 == null) {
               mc.player.closeContainer();
               this.method11094();
            } else {
               if (!this.method11077(var3)) {
                  mc.player.closeContainer();
                  this.method11094();
               }
            }
         }
      } else {
         this.method11094();
      }
   }

   private void method11036() {
      this.field24848 = 0;
      this.field24820 = false;
      this.method11063(KeyFinderPhase.RTP);
   }

   private Vec3 method11038() {
      Vec3 var1 = mc.player.position();
      int var2 = Mth.floor(var1.y);
      int var3 = Mth.floor(var1.x);
      int var4 = Mth.floor(var1.z);
      Vec3 var5 = null;
      double var6 = field24869;

      for (int var8 = -12; var8 <= 12; var8++) {
         for (int var9 = -12; var9 <= 12; var9++) {
            double var10 = var3 + var8 + field24870;
            double var12 = var4 + var9 + field24871;
            double var14 = (var10 - var1.x) * (var10 - var1.x) + (var12 - var1.z) * (var12 - var1.z);
            if (!(var14 >= var6) && this.method11115(var10, var12) <= var2) {
               Vec3 var16 = new Vec3(var10, var1.y, var12);
               if (this.method11111(var1, var16).clear()) {
                  var5 = var16;
                  var6 = var14;
               }
            }
         }
      }

      return var5;
   }

   private void method11039(PlayerInputEvent var1) {
      var1.method11159();
      if (this.field24811 != null && !(mc.player.position().distanceTo(this.field24811) > field24933)) {
         this.field24848 = 0;
         this.field24818 = false;
         if (!this.field24797.isEmpty()) {
            this.method11091();
         } else {
            this.field24810 = null;
            this.field24811 = null;
            this.method11087();
         }
      }
   }

   private void method11040(String var1, KeyFinderState var2) {
      this.field24821 = mc.player.position();
      this.field24822 = mc.level;
      this.field24820 = true;
      var2.method11550();
      this.method11054(var1);
   }

   private void method11041(AbstractContainerMenu var1) {
      this.field24843 = var1.containerId;
      this.field24844 = -1;
      this.field24846 = 0;
      this.field24841 = -1;
   }

   @Subscribe
   private void method11042(ItemUseInputEvent var1) {
      this.field24801.method10326(var1);
   }

   private void method11043(PlayerInputEvent var1) {
      if (this.method11025() && this.method11106()) {
         if (mc.player.position().distanceTo(this.field24814) <= field24932) {
            var1.method11159();
            this.method11051();
         } else {
            NoClipMovementController.INSTANCE.method06468(var1, this.field24814);
         }
      }
   }

   private double method11044(List<AutoKeyFinder.Nested318> var1) {
      if (var1 == null) {
         return field24921;
      }

      double var2 = 0.0;

      for (AutoKeyFinder.Nested318 var5 : var1) {
         if (!var5.passable() || this.method11064(var5.point())) {
            return field24922;
         }

         var2 += var5.wall();
      }

      return var2;
   }

   private void method11045(PlayerInputEvent var1) {
      if (!this.field24797.isEmpty()) {
         var1.method11159();
         if (this.field24810 != null) {
            this.method11091();
         } else {
            this.field24815 = null;
            this.field24842 = 0;
            this.method11063(KeyFinderPhase.LAND);
         }
      } else {
         Vec3 var2 = mc.player.position();
         double var3 = this.field24787.method03022().intValue() - var2.x;
         double var5 = this.field24788.method03022().intValue() - var2.z;
         double var7 = Math.sqrt(var3 * var3 + var5 * var5);
         if (var7 <= field24874) {
            this.method11108();
         } else if (mc.player.getY() < this.method11069() - field24875 && this.method11114()) {
            this.method11109();
         } else if (this.field24836 == null || !this.method11093(var1)) {
            if (this.method11032(var7)) {
               this.method11057();
            } else {
               this.method11101(var1);
            }
         }
      }
   }

   private void method11046() {
      this.field24797.clear();
      this.field24798.clear();
      this.field24848 = 0;
      this.field24818 = false;
      this.field24819 = false;
      this.field24812 = null;
      this.field24813 = null;
      this.method11087();
   }

   private void method11047(Vec3 var1) {
      Vector2f var2 = PlayerUtils.method11816(mc.player.getEyePosition(), var1);
      RotationManager.method06547(new Rotation(var2.x, var2.y), field24949, 999, false);
   }

   @Subscribe(4)
   private void method11048(DragonTravelEvent var1) {
      if (this.field24831 != null) {
         var1.method07277(this.field24831);
      } else if (this.field24840 != 0.0) {
         var1.method07277(new Vec3(var1.method07275().x, this.field24840, var1.method07275().z));
      }
   }

   private void method11049() {
      if (this.field24803.method11549() && mc.player.isInWall()) {
         this.method11068();
      } else if (this.field24803.method11549()) {
         this.method11070();
      } else {
         NotificationManager.method08597(
            "AutoKeyFinder: мало HP (" + Math.round(mc.player.getHealth()) + "), /heal на кд ещё " + this.field24803.method11548() + " с",
            field24942,
            NotificationType.WARNING
         );
         this.method11052(Math.min(this.field24795.method03022().intValue() + field24943, mc.player.getMaxHealth() - field24944));
      }
   }

   private void method11050(PlayerInputEvent var1, Vec3 var2) {
      if (mc.player.position().distanceTo(var2) > field24872) {
         this.method11090(var1, var2);
      } else {
         this.method11079(var1, var2, field24873);
      }
   }

   private void method11051() {
      this.field24849 = 0;
      this.field24846 = 2;
      this.method11063(KeyFinderPhase.BREAK);
   }

   private void method11052(double var1) {
      if (this.method11113() != null) {
         mc.player.closeContainer();
      }

      this.field24801.method10332();
      this.field24829 = var1;
      this.field24823 = null;
      this.field24830 = mc.player.isInWall() ? this.method11062() : null;
      this.method11063(KeyFinderPhase.REGEN);
   }

   private Vec3 method11053() {
      Vec3 var1 = mc.player.position().subtract(this.field24808).multiply(1.0, 0.0, 1.0);
      Vec3 var2 = this.field24808.add((var1.lengthSqr() > field24927 ? var1.normalize() : new Vec3(1.0, 0.0, 0.0)).scale(field24928));
      if (this.method11028(var2)) {
         return var2;
      }

      for (Direction var4 : Plane.HORIZONTAL) {
         Vec3 var5 = this.field24808.add(var4.getStepX() * field24929, 0.0, var4.getStepZ() * field24930);
         if (this.method11028(var5)) {
            return var5;
         }
      }

      return var2;
   }

   private void method11054(String var1) {
      mc.player.connection.sendCommand(var1);
   }

   private void method11055(PlayerInputEvent var1) {
      var1.method11159();
      if (this.method11060(this.field24816, this.field24817)) {
         this.method11088();
      }
   }

   private void method11056() {
      double var1 = this.field24790.method03022() * this.field24790.method03022();
      MinecartChest var3 = null;

      for (Entity var5 : mc.level.entitiesForRendering()) {
         if (var5 instanceof MinecartChest var6 && var6.isAlive()) {
            UUID var7 = var6.getUUID();
            if (var7.equals(this.field24807)) {
               var3 = var6;
            }

            if (!this.field24798.contains(var7) && !(mc.player.distanceToSqr(var6) > var1)) {
               Vec3 var8 = this.method11065(var6);
               if (this.field24797.put(var7, var8) == null) {
                  ;
               }
            }
         }
      }

      this.field24809 = var3;
      if (var3 != null) {
         this.field24808 = this.method11065(var3);
      }
   }

   private void method11057() {
      this.field24839++;
      this.field24838 = Math.min(this.field24838 + field24876, field24877);
      Vec3 var1 = mc.player.position();
      double var2 = Math.atan2(this.field24788.method03022().intValue() - var1.z, this.field24787.method03022().intValue() - var1.x)
         + (this.field24839 % 2 == 0 ? field24878 : field24879) * field24880;
      this.field24836 = new Vec3(var1.x + Math.cos(var2) * field24881, var1.y + field24882, var1.z + Math.sin(var2) * field24883);
      this.field24837 = 0;
   }

   private List<AutoKeyFinder.Nested318> method11058(Vec3 var1) {
      ArrayList var2 = new ArrayList();
      this.method11098(var2, var1, this.field24808);
      double var3 = this.method11044(var2);

      for (double var8 : field24723) {
         for (int var10 = 0; var10 < 8; var10++) {
            double var11 = field24911 * var10 / field24912;
            ArrayList var13 = new ArrayList();
            this.method11098(var13, var1, this.field24808.add(Math.cos(var11) * var8, 0.0, Math.sin(var11) * var8));
            this.method11098(var13, var1, this.field24808);
            double var14 = this.method11044(var13);
            if (!(var14 >= var3)) {
               var2 = var13;
               var3 = var14;
            }
         }
      }

      return var2;
   }

   private void method11059(Player var1) {
      this.field24819 = true;
      this.method11092("игрок " + var1.getGameProfile().name() + " в " + Math.round(mc.player.distanceTo(var1)) + " бл., ливаю на спавн");
   }

   private boolean method11060(Vec3 var1, Level var2) {
      return mc.level != var2 || mc.player.position().distanceTo(var1) > field24940;
   }

   private boolean method11061(PlayerInputEvent var1) {
      if (!this.field24801.method10323() && !this.method11116()) {
         return false;
      }

      this.field24801.method10328();
      var1.method11159();
      this.field24802.method04694();
      return true;
   }

   private Vec3 method11062() {
      BlockPos var1 = mc.player.blockPosition();
      Vec3 var2 = null;
      double var3 = field24945;

      for (int var5 = -5; var5 <= 5; var5++) {
         for (int var6 = -5; var6 <= 5; var6++) {
            for (int var7 = -5; var7 <= 5; var7++) {
               Vec3 var8 = Vec3.atBottomCenterOf(var1.offset(var5, var6, var7));
               double var9 = var5 * var5 + var7 * var7 + 100 * var6 * var6;
               if (!(var9 >= var3) && this.method11028(var8)) {
                  var2 = var8;
                  var3 = var9;
               }
            }
         }
      }

      return var2 != null ? var2 : mc.player.position().add(0.0, field24946, 0.0);
   }

   private void method11063(KeyFinderPhase var1) {
      this.field24806 = var1;
      this.field24802.method04694();
      if (var1 == KeyFinderPhase.TRAVEL) {
         this.field24834 = field24950;
         this.field24835 = 0;
         this.field24836 = null;
      }
   }

   private boolean method11064(Vec3 var1) {
      for (Vec3 var3 : this.field24799) {
         if (var3.distanceTo(var1) < field24901) {
            return true;
         }
      }

      return false;
   }

   private Vec3 method11065(Entity var1) {
      AABB var2 = var1.getBoundingBox();
      return new Vec3((var2.minX + var2.maxX) * field24947, var2.minY, (var2.minZ + var2.maxZ) * field24948);
   }

   private boolean method11066(double var1, double var3) {
      for (Vec3 var6 : this.field24799) {
         if (Math.hypot(var6.x - var1, var6.z - var3) < field24902) {
            return true;
         }
      }

      return false;
   }

   private boolean method11067(MutableBlockPos var1) {
      for (int var2 = var1.getY(); var2 >= mc.level.getMinY(); var2--) {
         if (!this.method11020(mc.level.getBlockState(var1.setY(var2)))) {
            return true;
         }
      }

      return false;
   }

   private void method11068() {
      this.field24819 = false;
      this.method11092("мало HP (" + Math.round(mc.player.getHealth()) + "), ухожу на спавн");
   }

   private double method11069() {
      return Math.min(this.field24789.method03022().intValue() + this.field24838, mc.level.getMaxY() - field24886);
   }

   private void method11070() {
      this.method11054(field24937);
      this.field24803.method11550();
   }

   private void method11071(PlayerInputEvent var1) {
      if (this.method11106()) {
         if (this.field24809 != null) {
            this.field24847 = 0;
         }

         if (this.field24823 == null || this.field24809 != null && this.field24828.distanceTo(this.field24808) > field24899) {
            if (this.field24823 != null) {
               ;
            }

            if (!this.method11112()) {
               return;
            }
         }

         if (this.field24800 > 5) {
            this.method11081();
         } else if (this.field24824 >= this.field24823.size()) {
            this.method11085(var1);
         } else {
            AutoKeyFinder.Nested318 var2 = this.field24823.get(this.field24824);
            double var3 = mc.player.position().distanceTo(var2.point());
            if (var3 <= field24900) {
               var1.method11159();
               this.field24824++;
               this.method11097();
            } else {
               this.method11031(var3);
               boolean var5 = var2.clear() && !this.field24827;
               if (var5) {
                  this.method11050(var1, var2.point());
               } else {
                  NoClipMovementController.INSTANCE.method06468(var1, var2.point());
               }
            }
         }
      }
   }

   private void method11072() {
      if (this.method11113() != null) {
         mc.player.closeContainer();
      }

      this.method11054("home " + this.field24810);
      this.method11063(KeyFinderPhase.WAIT_HOME);
   }

   private void method11073() {
      this.field24848 = 0;
      this.field24823 = null;
      if (this.field24807 != null) {
         this.method11063(KeyFinderPhase.APPROACH);
      } else if (!this.field24797.isEmpty()) {
         this.method11091();
      } else {
         this.method11087();
      }
   }

   private void method11074(Runnable var1) {
      this.field24848++;
      if (this.field24848 >= 3) {
         this.method03939(false);
      } else {
         var1.run();
      }
   }

   private float method11075() {
      return this.field24806 == KeyFinderPhase.APPROACH && this.field24823 != null ? field24941 : this.field24795.method03022().intValue();
   }

   private void method11076(PlayerInputEvent var1) {
      var1.method11159();
      AbstractContainerMenu var2 = this.method11113();
      if (var2 == null || var2.containerId != this.field24843) {
         this.method11103();
      } else if (this.field24841 >= 0) {
         if (this.field24841-- <= 0) {
            mc.player.closeContainer();
            this.method11103();
         }
      } else if (this.field24846-- <= 0) {
         Slot var3 = this.method11082(var2, true, field24785);
         if (var3 == null || !this.method11077(var3)) {
            if (var3 == null) {
               boolean var10001 = true;
            } else {
               boolean var5 = false;
            }

            this.field24841 = 10;
         }
      }
   }

   private boolean method11077(Slot var1) {
      ItemStack var2 = var1.getItem();
      if (var1.index == this.field24844 && var2.getCount() == this.field24845) {
         return false;
      }

      this.field24844 = var1.index;
      this.field24845 = var2.getCount();
      InventoryUtils.method06137(this.field24843, var1.index, 0, ContainerInput.QUICK_MOVE, mc.player);
      this.field24846 = this.field24791.method03022() - 1;
      return true;
   }

   private List<AutoKeyFinder.Nested318> method11078(Vec3 var1) {
      int var2 = Mth.floor(this.field24808.x);
      int var3 = Mth.floor(this.field24808.z);
      Vec3 var4 = null;
      double var5 = field24913;

      for (int var7 = -8; var7 <= 8; var7++) {
         for (int var8 = -8; var8 <= 8; var8++) {
            double var9 = var2 + var7 + field24914;
            double var11 = var3 + var8 + field24915;
            if (!(Math.hypot(var9 - this.field24808.x, var11 - this.field24808.z) < field24916) && !this.method11066(var9, var11)) {
               Vec3 var13 = new Vec3(var9, this.method11115(var9, var11) + field24917, var11);
               Vec3 var14 = new Vec3(var9, this.field24808.y, var11);
               double var15 = this.method11080(var13, var14) + this.method11080(var14, this.field24808);
               if (!(var15 >= var5) && this.method11111(var13, var14).passable() && this.method11111(var14, this.field24808).passable()) {
                  var5 = var15;
                  var4 = var13;
               }
            }
         }
      }

      if (var4 == null) {
         return null;
      }

      int var17 = this.method11115(var1.x, var1.z);
      Vec3 var18 = var1.y >= var17 ? var1 : new Vec3(var1.x, var17 + field24918, var1.z);
      double var19 = Math.max(Math.max(var18.y, var4.y), this.method11029(var18, var4) + field24919);
      ArrayList var20 = new ArrayList();
      this.method11098(var20, var1, var18);
      this.method11098(var20, var1, new Vec3(var18.x, var19, var18.z));
      this.method11098(var20, var1, new Vec3(var4.x, var19, var4.z));
      this.method11098(var20, var1, new Vec3(var4.x, this.field24808.y, var4.z));
      this.method11098(var20, var1, this.field24808);
      return var20;
   }

   private void method11079(PlayerInputEvent var1, Vec3 var2, double var3) {
      var1.method11159();
      Vec3 var5 = var2.subtract(mc.player.position());
      double var6 = var5.length();
      this.field24831 = var6 > var3 ? var5.scale(var3 / var6) : var5;
      mc.player.setDeltaMovement(this.field24831);
   }

   private double method11080(Vec3 var1, Vec3 var2) {
      double var3 = var1.distanceTo(var2);
      int var5 = Math.max(1, (int)Math.ceil(var3 / field24923));
      double var6 = mc.player.getEyeHeight();
      MutableBlockPos var8 = new MutableBlockPos();
      int var9 = 0;

      for (int var10 = 1; var10 <= var5; var10++) {
         double var11 = (double)var10 / var5;
         var8.set(Mth.floor(Mth.lerp(var11, var1.x, var2.x)), Mth.floor(Mth.lerp(var11, var1.y, var2.y) + var6), Mth.floor(Mth.lerp(var11, var1.z, var2.z)));
         if (mc.level.getBlockState(var8).isSuffocating(mc.level, var8)) {
            var9++;
         }
      }

      return var3 * var9 / var5;
   }

   private void method11081() {
      boolean var1 = this.field24824 >= this.field24823.size() - 1;
      Vec3 var2 = this.field24823.get(Math.min(this.field24824, this.field24823.size() - 1)).point();
      if (!var1) {
         this.field24799.add(var2);
      }

      this.field24823 = null;
      this.field24800 = 0;
   }

   private Slot method11082(AbstractContainerMenu var1, boolean var2, Predicate<ItemStack> var3) {
      for (Slot var5 : var1.slots) {
         if (var5.container == mc.player.getInventory() == var2 && var3.test(var5.getItem())) {
            return var5;
         }
      }

      return null;
   }

   private double method11083(double var1) {
      return var1 / field24924 * field24925 / field24926;
   }

   private boolean method11084(BlockPos var1) {
      BlockState var2 = mc.level.getBlockState(var1);
      if (var2.isCollisionShapeFullBlock(mc.level, var1) && !var2.is(BlockTags.LEAVES)) {
         return this.method11020(mc.level.getBlockState(var1.above())) && this.method11020(mc.level.getBlockState(var1.above(2)))
            ? !WorldCollisionUtils.method02822(new AABB(var1.above()).expandTowards(0.0, 1.0, 0.0).inflate(1.0))
            : false;
      } else {
         return false;
      }
   }

   private void method11085(PlayerInputEvent var1) {
      var1.method11159();
      if (this.field24809 == null) {
         if (++this.field24847 >= 40) {
            this.method11110();
         }
      } else {
         this.field24846 = 2;
         this.method11063(KeyFinderPhase.OPEN);
      }
   }

   private void method11086(PlayerInputEvent var1) {
      var1.method11159();
      if (this.field24815 != null && !this.method11084(this.field24815)) {
         this.field24815 = null;
      }

      if (this.field24815 == null && this.field24842-- <= 0) {
         this.field24842 = 10;
         this.field24815 = this.method11104();
      }

      if (this.field24815 == null) {
         this.method11101(var1);
      } else if (this.method11106()) {
         Vec3 var2 = Vec3.atBottomCenterOf(this.field24815.above());
         Vec3 var3 = mc.player.position();
         double var4 = Math.hypot(var2.x - var3.x, var2.z - var3.z);
         if (!(var4 > field24893)) {
            if (var3.y - var2.y > field24895) {
               this.method11102(Math.min(1.0, var3.y - var2.y - 1.0));
               double var10001 = var3.y - var2.y;
            } else {
               this.method11063(KeyFinderPhase.ALIGN);
            }
         } else {
            Vec3 var6 = new Vec3(var2.x, var3.y, var2.z);
            if (mc.player.getBlockX() == this.field24815.getX() && mc.player.getBlockZ() == this.field24815.getZ()) {
               this.method11079(var1, var6, field24894);
            } else {
               this.method11050(var1, var6);
            }
         }
      }
   }

   private void method11087() {
      if (mc.player.getAbilities().mayfly) {
         this.method11109();
      } else {
         this.method11054(field24865);
         this.method11063(KeyFinderPhase.ENABLE_FLY);
      }
   }

   private void method11088() {
      this.field24848 = 0;
      this.field24846 = 20;
      this.method11063(KeyFinderPhase.EC_OPEN);
   }

   private AABB method11089() {
      return mc.player.getBoundingBox().move(mc.player.position().reverse());
   }

   private void method11090(PlayerInputEvent var1, Vec3 var2) {
      Vec3 var3 = mc.player.position();
      float var4 = (float)Math.toDegrees(Math.atan2(var2.z - var3.z, var2.x - var3.x)) - field24887;
      RotationManager.method06547(new Rotation(var4, 0.0F), field24888, 1, false);
      double var5 = var2.y - var3.y;
      boolean var7 = Math.hypot(var2.x - var3.x, var2.z - var3.z) > field24889;
      boolean var8 = mc.player.horizontalCollision;
      var1.method11167(var7 ? 1.0F : 0.0F);
      var1.method11158(0.0F);
      var1.method11174(var7);
      var1.method11173(var8 || var5 > field24890);
      var1.method11169(false);
      if (!var8 && var5 < field24891) {
         this.method11102(Math.min(1.0, -var5));
      }
   }

   private void method11091() {
      Vec3 var1 = mc.player.position();
      UUID var2 = null;
      double var3 = field24892;

      for (var var6 : this.field24797.entrySet()) {
         double var7 = ((Vec3)var6.getValue()).distanceToSqr(var1);
         if (!(var7 >= var3)) {
            var2 = (UUID)var6.getKey();
            var3 = var7;
         }
      }

      if (var2 == null) {
         this.method11021();
      } else {
         this.field24807 = var2;
         this.field24808 = this.field24797.get(var2);
         this.field24809 = null;
         this.field24823 = null;
         this.field24799.clear();
         this.field24847 = 0;
         this.field24848 = 0;
         Math.sqrt(var3);
         this.method11063(KeyFinderPhase.APPROACH);
      }
   }

   private void method11092(String var1) {
      NotificationManager.method08597("AutoKeyFinder: " + var1, field24934, NotificationType.WARNING);
      if (this.method11113() != null) {
         mc.player.closeContainer();
      }

      this.field24801.method10332();
      this.field24818 = true;
      this.field24816 = mc.player.position();
      this.field24817 = mc.level;
      this.field24848 = 0;
      this.method11054(field24935);
      this.method11063(KeyFinderPhase.SPAWN);
   }

   private boolean method11093(PlayerInputEvent var1) {
      if (mc.player.position().distanceTo(this.field24836) <= field24884 || ++this.field24837 > 100) {
         this.field24836 = null;
         this.field24834 = field24885;
         this.field24835 = 0;
         return false;
      }

      if (!this.method11106()) {
         return true;
      }

      this.method11050(var1, this.field24836);
      return true;
   }

   @Override
   public void method00245() {
      if (mc.player != null) {
         this.field24801.method10332();
      }

      this.field24806 = KeyFinderPhase.IDLE;
      this.field24807 = null;
      this.field24808 = null;
      this.field24809 = null;
      this.field24810 = null;
      this.field24811 = null;
      this.field24815 = null;
      this.field24823 = null;
      this.field24818 = false;
      this.field24819 = false;
      super.method00245();
   }

   private void method11094() {
      if (this.method11025()) {
         this.field24814 = this.method11053();
         this.method11063(KeyFinderPhase.RETREAT);
      }
   }

   private boolean method11095(ItemStack var1) {
      Item var2 = var1.getItem();
      return var2 == Items.NAME_TAG || var2 == Items.ENCHANTED_GOLDEN_APPLE || var2 == Items.GOLDEN_APPLE || KeyFinderInventoryController.method10324(var1);
   }

   private void method11096() {
      if (mc.player.getAbilities().mayfly) {
         this.field24848 = 0;
         this.method11109();
      }
   }

   private void method11097() {
      this.field24825 = field24908;
      this.field24826 = 0;
      this.field24827 = false;
   }

   private void method11098(List<AutoKeyFinder.Nested318> var1, Vec3 var2, Vec3 var3) {
      Vec3 var4 = var1.isEmpty() ? var2 : ((AutoKeyFinder.Nested318)var1.getLast()).point();
      if (!(var4.distanceTo(var3) < field24920)) {
         var1.add(this.method11111(var4, var3));
      }
   }

   private void method11099(PlayerInputEvent var1) {
      if (this.field24815 != null && this.method11084(this.field24815)) {
         Vec3 var2 = Vec3.atBottomCenterOf(this.field24815.above());
         double var3 = mc.player.position().distanceTo(var2);
         if (!(var3 > field24896)) {
            var1.method11159();
            Abilities var5 = mc.player.getAbilities();
            if (var5.flying) {
               mc.player.setDeltaMovement(Vec3.ZERO);
               var5.flying = false;
               mc.player.onUpdateAbilities();
            } else if (mc.player.onGround()) {
               this.field24810 = field24720[ThreadLocalRandom.current().nextInt(field24720.length)];
               this.field24811 = mc.player.position();
               this.method11054("sethome " + this.field24810);
               this.method11063(KeyFinderPhase.WAIT_SETHOME);
            }
         } else if (this.method11106()) {
            this.method11079(var1, var2, field24897);
         }
      } else {
         this.field24815 = null;
         this.method11063(KeyFinderPhase.LAND);
      }
   }

   private void method11100(PlayerInputEvent var1) {
      var1.method11159();
      if (this.field24809 == null) {
         this.method11110();
      } else {
         Vec3 var2 = this.field24809.getBoundingBox().getCenter();
         this.method11047(var2);
         if (this.field24846-- <= 0) {
            mc.gameMode.attack(mc.player, this.field24809);
            mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
            this.field24849++;
            this.field24846 = this.field24792.method03022() - 1;
         }
      }
   }

   private void method11101(PlayerInputEvent var1) {
      if (this.method11106()) {
         this.method11090(var1, new Vec3(this.field24787.method03022().intValue(), this.method11069(), this.field24788.method03022().intValue()));
      }
   }

   private void method11102(double var1) {
      this.field24840 = -var1;
      Vec3 var3 = mc.player.getDeltaMovement();
      mc.player.setDeltaMovement(var3.x, this.field24840, var3.z);
   }

   private void method11103() {
      if (this.field24819) {
         this.method11036();
      } else {
         this.method11070();
         this.method11063(KeyFinderPhase.HEAL);
      }
   }

   private BlockPos method11104() {
      BlockPos var1 = mc.player.blockPosition();
      MutableBlockPos var2 = new MutableBlockPos();
      BlockPos var3 = null;
      int var4 = field24898;

      for (int var5 = -6; var5 <= 6; var5++) {
         for (int var6 = -6; var6 <= 6; var6++) {
            int var7 = var5 * var5 + var6 * var6;
            if (var7 < var4) {
               var2.set(var1.getX() + var5, var1.getY(), var1.getZ() + var6);
               if (this.method11067(var2) && this.method11084(var2)) {
                  var3 = var2.immutable();
                  var4 = var7;
               }
            }
         }
      }

      return var3;
   }

   private void method11105(PlayerInputEvent var1) {
      if (this.method11106()) {
         var1.method11159();
         if (mc.player.getY() >= this.field24789.method03022().intValue() - field24866) {
            this.method11063(KeyFinderPhase.TRAVEL);
         } else {
            if (this.field24832 == null && this.method11114()) {
               if (this.field24833-- <= 0) {
                  this.field24833 = 10;
                  this.field24832 = this.method11038();
               }

               if (this.field24832 == null) {
                  this.method11090(var1, new Vec3(this.field24787.method03022().intValue(), mc.player.getY(), this.field24788.method03022().intValue()));
                  return;
               }
            }

            if (this.field24832 == null) {
               var1.method11173(true);
            } else {
               Vec3 var2 = mc.player.position();
               Vec3 var3 = new Vec3(this.field24832.x, var2.y, this.field24832.z);
               if (Math.hypot(var3.x - var2.x, var3.z - var2.z) > field24867) {
                  this.method11050(var1, var3);
               } else if (this.method11114()) {
                  this.field24832 = null;
               } else {
                  var1.method11173(true);
               }
            }
         }
      }
   }

   private boolean method11106() {
      Abilities var1 = mc.player.getAbilities();
      if (!var1.mayfly) {
         this.method11087();
         return false;
      }

      if (!var1.flying) {
         var1.flying = true;
         mc.player.onUpdateAbilities();
      }

      return true;
   }

   private void method11107() {
      this.field24819 = false;
      this.field24818 = false;
      this.field24848 = 0;
      this.field24797.clear();
      this.field24807 = null;
      this.field24808 = null;
      this.field24809 = null;
      this.field24823 = null;
      this.field24810 = null;
      this.field24811 = null;
      this.field24812 = null;
      this.field24813 = null;
      this.method11087();
   }

   private void method11108() {
      this.method11063(KeyFinderPhase.DONE);
      this.method03939(false);
   }

   private void method11109() {
      this.field24832 = null;
      this.field24833 = 0;
      this.field24838 = 0.0;
      this.method11063(KeyFinderPhase.TAKE_OFF);
   }

   private void method11110() {
      if (this.method11113() != null) {
         mc.player.closeContainer();
      }

      if (this.field24807 != null) {
         this.field24797.remove(this.field24807);
         this.field24798.add(this.field24807);
      }

      this.field24807 = null;
      this.field24808 = null;
      this.field24809 = null;
      this.field24823 = null;
      this.method11091();
   }

   private AutoKeyFinder.Nested318 method11111(Vec3 var1, Vec3 var2) {
      double var3 = var1.distanceTo(var2);
      int var5 = Math.max(1, (int)Math.ceil(var3 / field24909));
      boolean var6 = Math.abs(var2.y - var1.y) > Math.hypot(var2.x - var1.x, var2.z - var1.z);
      AABB var7 = this.method11089();
      AABB var8 = var7.inflate(field24910);
      double var9 = mc.player.getEyeHeight();
      MutableBlockPos var11 = new MutableBlockPos();
      boolean var12 = !mc.level.noBlockCollision(mc.player, var7.move(var1));
      boolean var13 = !var12;
      boolean var14 = false;
      boolean var15 = false;
      int var16 = 0;

      for (int var17 = 1; var17 <= var5; var17++) {
         Vec3 var18 = var1.lerp(var2, (double)var17 / var5);
         AABB var19 = var7.move(var18);
         boolean var20 = !mc.level.noBlockCollision(mc.player, var19);
         if (var20 || WorldCollisionUtils.method02821(var19, Blocks.COBWEB)) {
            var13 = false;
         }

         if (var6 && var12 && !var20) {
            var15 = true;
         }

         var12 = var20;
         if (!var14 && WorldCollisionUtils.method02822(var8.move(var18))) {
            var14 = true;
         }

         var11.set(Mth.floor(var18.x), Mth.floor(var18.y + var9), Mth.floor(var18.z));
         if (mc.level.getBlockState(var11).isSuffocating(mc.level, var11)) {
            var16++;
         }
      }

      return new AutoKeyFinder.Nested318(var2, var3 * var16 / var5, var13, var14, var15);
   }

   private boolean method11112() {
      this.field24800 = 0;
      Vec3 var1 = mc.player.position();
      var var2 = this.method11058(var1);
      var var3 = this.method11078(var1);
      double var4 = this.method11044(var2);
      double var6 = this.method11044(var3);
      if (var4 == field24903 && var6 == field24904) {
         this.method11110();
         return false;
      }

      boolean var8 = var6 < var4;
      var var9 = var8 ? var3 : var2;
      double var10 = this.method11083(Math.min(var4, var6));
      if (!mc.player.isInWall()) {
         double var12 = Math.min(var10 + field24905, mc.player.getMaxHealth() - field24906);
         if (mc.player.getHealth() < var12) {
            this.method11052(var12);
            return false;
         }
      }

      this.field24823 = var9;
      this.field24824 = 0;
      this.field24828 = this.field24808;
      this.method11097();
      return true;
   }

   private AbstractContainerMenu method11113() {
      return mc.gui.screen() instanceof ContainerScreen var1 ? var1.getMenu() : null;
   }

   private boolean method11114() {
      return !mc.level.noBlockCollision(mc.player, mc.player.getBoundingBox().move(0.0, field24868, 0.0));
   }

   private int method11115(double var1, double var3) {
      return mc.level.getHeight(Types.MOTION_BLOCKING, Mth.floor(var1), Mth.floor(var3));
   }

   private boolean method11116() {
      if (!this.field24793.method05999() || !field24786.contains(this.field24806) || mc.player.isInWall()) {
         return false;
      } else if (this.field24806 != KeyFinderPhase.REGEN) {
         return this.field24801.method10330(this.field24794.method03022());
      } else {
         return mc.player.getHealth() < this.field24795.method03022().intValue() && this.field24801.method10327() ? true : this.field24801.method10330(19);
      }
   }

   public AutoKeyFinder() {
      super(ModuleCategory.Misc, ModuleSubCategory.Utility);
      this.field24787 = new NumberSetting<Integer>(field24850)
         .method10835(-30000)
         .method10838(30000)
         .method10834(100)
         .method03017(15000)
         .method03023(this);
      this.field24788 = new NumberSetting<Integer>(field24851)
         .method10835(-30000)
         .method10838(30000)
         .method10834(100)
         .method03017(15000)
         .method03023(this);
      this.field24789 = new NumberSetting<Integer>(field24852).method10835(64).method10838(300).method10834(1).method03017(120).method03023(this);
      this.field24790 = new NumberSetting<Integer>(field24853).method10835(16).method10838(128).method10834(1).method03017(96).method03023(this);
      this.field24791 = new NumberSetting<Integer>(field24854).method10835(1).method10838(10).method10834(1).method03017(3).method03023(this);
      this.field24792 = new NumberSetting<Integer>(field24855).method10835(1).method10838(10).method10834(1).method03017(1).method03023(this);
      this.field24793 = new ToggleSetting(field24856).method03014(true).method03023(this);
      this.field24794 = new NumberSetting<Integer>(field24857)
         .method10835(1)
         .method10838(19)
         .method10834(1)
         .method03017(14)
         .method03025(this.field24793::method05999)
         .method03023(this);
      this.field24795 = new NumberSetting<Integer>(field24858).method10835(2).method10838(20).method10834(1).method03017(12).method03023(this);
      this.field24796 = new ToggleSetting(field24859).method03014(false).method03023(this);
      Object var10001 = null;
      this.field24797 = new LinkedHashMap<>();
      this.field24798 = new HashSet<>();
      this.field24799 = new ArrayList<>();
      this.field24801 = new KeyFinderInventoryController();
      this.field24802 = new ElapsedTimer();
      this.field24803 = new KeyFinderState(field24860);
      this.field24804 = new KeyFinderState(field24861);
      this.field24805 = new KeyFinderState(field24862);
      var10001 = null;
      this.field24806 = KeyFinderPhase.IDLE;
      this.method03935(field24863);
   }

   private void method11117(PlayerInputEvent var1) {
      var1.method11159();
      if (this.field24820) {
         if (this.method11060(this.field24821, this.field24822)) {
            this.method11107();
         }
      } else {
         this.field24802.method04694();
         if (this.field24804.method11549()) {
            this.method11040(field24938, this.field24804);
         } else if (this.field24805.method11549()) {
            this.method11040(field24939, this.field24805);
         }
      }
   }

   // $VF: Compiled from s
   private record Nested318(Vec3 point, double wall, boolean clear, boolean lava, boolean verticalExit) {
      boolean passable() {
         return !this.lava && !this.verticalExit;
      }
   }
}
