// Original binary: sg/ec/dDNqy2heZt4A7jSi
package sg.ec;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.HugeMushroomBlock;
import net.minecraft.world.level.block.LeavesBlock;
import net.minecraft.world.level.block.MangroveRootsBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.Heightmap.Types;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;

// $VF: Compiled from s
public class PearlTarget extends ClientModule {
   private final ModeSetting field17864;
   private final KeyBindSetting field17865;
   private final ModeSetting field17866;
   private final ModeSetting field17867;
   private final NumberSetting<Integer> field17868;
   private final NumberSetting<Integer> field17869;
   private final ToggleSetting field17870;
   private final ToggleSetting field17871;
   private static final double field17872 = 0.03;
   private static final double field17873 = 0;
   private static final double field17874 = 0;
   private static final double field17875 = 0;
   private static final double field17876 = 0;
   private static final int field17877 = 0;
   private static final double field17878 = 0;
   private static final long field17879 = 0;
   private static final long field17880 = 0;
   private static final long field17881 = 0;
   private static final long field17882 = 0;
   private static final long field17883 = 0;
   private static final double field17884 = 0;
   private static final double field17885 = 0;
   private static final double field17886 = 0;
   private static final double field17887 = 0;
   private static final double field17888 = 0;
   private static final double field17889 = 0;
   private static final double field17890 = 0;
   private static final double field17891 = 0;
   private static final double field17892 = 0;
   private static final double field17893 = 0;
   private static final int field17894 = 0;
   private static final double field17895 = 0;
   private static final double field17896 = 0;
   private static final double field17897 = 0;
   private static final double field17898 = 0;
   private static final double field17899 = 0;
   private static final double field17900 = 0;
   private static final int field17901 = 0;
   private static final int field17902 = 0;
   private static final float field17903 = 0;
   private static final float field17904 = 0;
   private static final float field17905 = 0;
   private static final float field17906 = 0;
   private static final float field17907 = 0;
   private static final int field17908 = 0;
   private static final float field17909 = 0;
   private static final float[] field17910 = new float[]{
      PearlTarget.field18066, PearlTarget.field18067, PearlTarget.field18068, PearlTarget.field18069
   };
   private static final float[] field17911 = new float[]{1.0F, PearlTarget.field18070, PearlTarget.field18071, PearlTarget.field18072};
   private static final float[] field17912 = new float[]{
      0.0F,
      PearlTarget.field18073,
      PearlTarget.field18074,
      PearlTarget.field18075,
      PearlTarget.field18076,
      PearlTarget.field18077,
      PearlTarget.field18078,
      PearlTarget.field18079,
      PearlTarget.field18080
   };
   private final PearlTrajectoryAimer field17913;
   private final Map<ThrownEnderpearl, PearlTarget.Nested216> field17914;
   private final List<Entity> field17915;
   private final List<Entity> field17916;
   private final List<Entity> field17917;
   private Entity field17918;
   private int field17919;
   private long field17920;
   private Entity field17921;
   private long field17922;
   private long field17923;
   private int field17924;
   private boolean field17925;
   private boolean field17926;
   private int field17927;
   private boolean field17928;
   private float field17929;
   private ThrownEnderpearl field17930;
   private Vec3 field17931;
   private int field17932;
   private int field17933;
   private int field17934;
   private float[] field17935;
   private boolean field17936;
   private double field17937;
   private double field17938;
   private boolean field17939;
   private boolean field17940;
   private boolean field17941;
   private float field17942;
   private float field17943;
   private float field17944;
   private float field17945;
   private float field17946;
   private float field17947;
   private double field17948;
   private double field17949;
   private double field17950;
   private static final String field17951 = "Mode";
   private static final String field17952 = "Always";
   private static final String field17953 = "Bind";
   private static final String field17954 = "Always";
   private static final String field17955 = "Throw";
   private static final String field17956 = "Алгоритм";
   private static final String field17957 = "Default";
   private static final String field17958 = "RW";
   private static final String field17959 = "Default";
   private static final String field17960 = "Target";
   private static final String field17961 = "Aura";
   private static final String field17962 = "All";
   private static final String field17963 = "Aura";
   private static final String field17964 = "Кулдаун броска";
   private static final String field17965 = "Мин дистанция";
   private static final String field17966 = "Прыжок для дальних";
   private static final String field17967 = "Догон (макс дальность)";
   private static final double field17968 = 0.7;
   private static final double field17969 = 1.19;
   private static final double field17970 = Double.MAX_VALUE;
   private static final double field17971 = Double.MAX_VALUE;
   private static final double field17972 = Double.MAX_VALUE;
   private static final String field17973 = "Pearl Target";
   private static final String field17974 = "RW";
   private static final String field17975 = "RW";
   private static final long field17976 = 1100L;
   private static final String field17977 = "Bind";
   private static final String field17978 = "Aura";
   private static final double field17979 = Double.MAX_VALUE;
   private static final long field17980 = 400L;
   private static final double field17981 = 160.0;
   private static final double field17982 = 0.36;
   private static final long field17983 = 10000L;
   private static final double field17984 = 0.7;
   private static final double field17985 = 0.02;
   private static final double field17986 = 2.2;
   private static final double field17987 = 1.7;
   private static final double field17988 = Double.MAX_VALUE;
   private static final double field17989 = Double.MAX_VALUE;
   private static final double field17990 = Double.MAX_VALUE;
   private static final float field17991 = 0.5F;
   private static final float field17992 = 6.0F;
   private static final float field17993 = 0.5F;
   private static final float field17994 = 70.0F;
   private static final float field17995 = -80.0F;
   private static final float field17996 = 3.0F;
   private static final float field17997 = -80.0F;
   private static final float field17998 = 70.0F;
   private static final double field17999 = 1.0E-6;
   private static final double field18000 = Double.MAX_VALUE;
   private static final float field18001 = 70.0F;
   private static final float field18002 = 70.0F;
   private static final float field18003 = -80.0F;
   private static final float field18004 = 0.5F;
   private static final float field18005 = 0.5F;
   private static final double field18006 = 1.5;
   private static final double field18007 = 1.0E-6;
   private static final double field18008 = 98.99999999999991;
   private static final double field18009 = 0.010000000000000009;
   private static final double field18010 = 0.99;
   private static final double field18011 = 0.99;
   private static final double field18012 = 180.0;
   private static final double field18013 = 0.010000000000000009;
   private static final double field18014 = -1.5;
   private static final double field18015 = 0.029699999999999997;
   private static final long field18016 = 2000000L;
   private static final double field18017 = 0.15;
   private static final double field18018 = 0.15;
   private static final double field18019 = 0.6;
   private static final double field18020 = 12.0;
   private static final double field18021 = 12.0;
   private static final double field18022 = Double.MAX_VALUE;
   private static final double field18023 = 90.0;
   private static final double field18024 = Double.MAX_VALUE;
   private static final double field18025 = 0.35;
   private static final double field18026 = 0.35;
   private static final double field18027 = 6.0;
   private static final double field18028 = 6.0;
   private static final int field18029 = Integer.MIN_VALUE;
   private static final double field18030 = 4.0;
   private static final double field18031 = 2.0;
   private static final double field18032 = 20.0;
   private static final double field18033 = 0.3;
   private static final double field18034 = 1.0E-6;
   private static final double field18035 = 1.0E-4;
   private static final int field18036 = Integer.MIN_VALUE;
   private static final double field18037 = 0.03;
   private static final double field18038 = 0.99;
   private static final int field18039 = Integer.MIN_VALUE;
   private static final double field18040 = 0.001;
   private static final double field18041 = 0.3;
   private static final double field18042 = 0.3;
   private static final double field18043 = 0.3;
   private static final double field18044 = 1.8;
   private static final double field18045 = 0.3;
   private static final double field18046 = 6.5;
   private static final double field18047 = 0.2126;
   private static final double field18048 = 36.0;
   private static final double field18049 = 0.8;
   private static final double field18050 = 0.99;
   private static final double field18051 = 0.03;
   private static final double field18052 = 0.1;
   private static final double field18053 = 1.5;
   private static final long field18054 = 50L;
   private static final double field18055 = 160.0;
   private static final double field18056 = 160.0;
   private static final double field18057 = 8.988465674311579E307;
   private static final String field18058 = "-";
   private static final double field18059 = 100.0;
   private static final double field18060 = 100.0;
   private static final double field18061 = 6.0;
   private static final String field18062 = "Default";
   private static final String field18063 = "Default";
   private static final String field18064 = "RW";
   private static final String field18065 = "Bind";
   private static final float field18066 = 0.25F;
   private static final float field18067 = -0.25F;
   private static final float field18068 = 0.125F;
   private static final float field18069 = -0.125F;
   private static final float field18070 = -1.0F;
   private static final float field18071 = 0.5F;
   private static final float field18072 = -0.5F;
   private static final float field18073 = 3.0F;
   private static final float field18074 = -3.0F;
   private static final float field18075 = 6.0F;
   private static final float field18076 = -6.0F;
   private static final float field18077 = 9.0F;
   private static final float field18078 = -9.0F;
   private static final float field18079 = 12.0F;
   private static final float field18080 = -12.0F;

   private boolean method07325() {
      return this.field17867.method05600(field17978);
   }

   private boolean method07326(ThrownEnderpearl var1) {
      Entity var2 = var1.getOwner();
      return var2 != null && var2.getId() == mc.player.getId();
   }

   private void method07327(PreMovementPacketEvent var1) {
      if (this.field17930 != null) {
         if (this.field17926 && this.field17927 > 0 && mc.player.onGround()) {
            this.field17927--;
         } else if (this.field17936) {
            if (!this.field17939 || !this.method07389(var1, this.field17942, this.field17943, "strict err=" + method07335(this.field17948))) {
               if (this.field17936) {
                  boolean var2 = !this.field17940 || this.field17949 > this.field17937 + field18019;
                  if (var2 && this.field17870.method03022() && mc.player.onGround() && !this.field17926) {
                     this.field17926 = true;
                     double var3 = this.method07355();
                     if (var3 <= this.field17938 || this.field17871.method03022() && var3 <= field18020) {
                        this.field17925 = true;
                        this.field17927 = 6;
                        return;
                     }
                  }

                  if (!this.field17940 || !this.method07389(var1, this.field17944, this.field17945, "relaxed err=" + method07335(this.field17949))) {
                     if (this.field17936) {
                        if (!this.field17871.method03022()
                           || !this.field17941
                           || !(this.field17950 <= field18021)
                           || !this.method07389(var1, this.field17946, this.field17947, "chase err=" + method07335(this.field17950))) {
                           if (this.field17936) {
                              this.field17924 = this.field17930.getId();
                              this.method07362();
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private long method07329() {
      return this.field17866.method05600(field17975) ? this.field17868.method03022().intValue() : field17976;
   }

   private void method07330(float var1, float var2) {
      PearlTarget.Nested217 var3 = this.method07377(var1, var2);
      if (var3 != null) {
         if (!this.method07381(var3)) {
            if (!this.method07378(var1, var2)) {
               double var4 = var3.pos().distanceTo(this.field17931);
               if (!this.field17941 || var4 < this.field17950) {
                  this.field17941 = true;
                  this.field17950 = var4;
                  this.field17946 = var1;
                  this.field17947 = var2;
               }

               if (!(var4 > this.field17938)) {
                  if (!this.field17940 || var4 < this.field17949) {
                     this.field17940 = true;
                     this.field17949 = var4;
                     this.field17944 = var1;
                     this.field17945 = var2;
                  }

                  if (var4 <= this.field17937 && this.method07350(var4, var2)) {
                     this.field17939 = true;
                     this.field17948 = var4;
                     this.field17942 = var1;
                     this.field17943 = var2;
                  }
               }
            }
         }
      }
   }

   private float[] method07331(double var1) {
      return this.method07353(this.method07340(var1));
   }

   @Override
   public void method00245() {
      super.method00245();
      this.method07362();
      this.field17914.clear();
      this.field17915.clear();
      this.field17916.clear();
      this.field17917.clear();
      this.field17921 = null;
      this.field17924 = -1;
      this.field17913.method01934();
   }

   private boolean method07333(BlockPos var1) {
      return method07349(mc.level.getBlockState(var1));
   }

   private static String method07334(Vec3 var0) {
      return "(" + method07335(var0.x) + ", " + method07335(var0.y) + ", " + method07335(var0.z) + ")";
   }

   private static String method07335(double var0) {
      return var0 >= field18057 ? field18058 : String.valueOf(Math.round(var0 * field18059) / field18060);
   }

   private boolean method07336(ThrownEnderpearl var1, Entity var2) {
      Entity var3 = var1.getOwner();
      return var2 != null && var3 != null && var3.getId() == var2.getId();
   }

   private PearlTarget.Nested216 method07337(ThrownEnderpearl var1) {
      Vec3 var2 = var1.position();
      Vec3 var3 = var1.getDeltaMovement();
      if (var3.lengthSqr() < field18035) {
         return null;
      }

      double var4 = mc.level.getMinY();
      long var6 = System.currentTimeMillis();
      int var8 = field18036;

      for (int var9 = 0; var9 < 180; var9++) {
         var3 = this.method07358(var3, var2);
         Vec3 var10 = var2.add(var3);
         BlockPos var11 = BlockPos.containing(var10);
         if (!mc.level.isLoaded(var11)) {
            return this.method07368(var2, var3, var9, var8);
         }

         var8 = mc.level.getHeight(Types.MOTION_BLOCKING, var11.getX(), var11.getZ());
         BlockHitResult var12 = mc.level.clip(new ClipContext(var2, var10, Block.COLLIDER, Fluid.NONE, mc.player));
         if (var12.getType() == Type.BLOCK) {
            return new PearlTarget.Nested216(var12.getLocation(), var9 + 1, false, var6);
         }

         var2 = var10;
         if (var2.y < var4) {
            return new PearlTarget.Nested216(new Vec3(var2.x, var4, var2.z), var9 + 1, false, var6);
         }
      }

      return null;
   }

   private boolean method07338(Vec3 var1) {
      BlockPos var2 = BlockPos.containing(var1.x, var1.y, var1.z);
      return !mc.level.getFluidState(var2).isEmpty() || mc.level.getBlockState(var2).is(Blocks.WATER);
   }

   private float[] method07340(double var1) {
      Vec3 var3 = this.method07374();
      double var4 = this.field17931.x - var3.x;
      double var6 = this.field17931.z - var3.z;
      double var8 = Math.sqrt(var4 * var4 + var6 * var6);
      Vec3 var10 = mc.player.getDeltaMovement();
      double var11 = var8 < field17999 ? 0.0 : (var10.x * var4 + var10.z * var6) / var8;
      return method07371(var8, this.field17931.y - var3.y, var11, var1);
   }

   private float method07341(float var1) {
      return Mth.clamp(var1, field17997, field17998);
   }

   private double method07342(Vec3 var1, int var2) {
      int var3 = Mth.floor(var1.x);
      int var4 = Mth.floor(var1.z);
      int var5 = var3 >> 4;
      int var6 = var4 >> 4;
      int var7 = mc.player.getBlockY();

      for (int var8 = 1; var8 <= 8; var8++) {
         for (int var9 = -var8; var9 <= var8; var9++) {
            for (int var10 = -var8; var10 <= var8; var10++) {
               if (Math.max(Math.abs(var9), Math.abs(var10)) == var8) {
                  int var11 = var5 + var9;
                  int var12 = var6 + var10;
                  int var13 = Mth.clamp(var3, var11 << 4, (var11 << 4) + 15);
                  int var14 = Mth.clamp(var4, var12 << 4, (var12 << 4) + 15);
                  if (mc.level.isLoaded(new BlockPos(var13, var7, var14))) {
                     return mc.level.getHeight(Types.MOTION_BLOCKING, var13, var14);
                  }
               }
            }
         }
      }

      return var2 != field18039 ? var2 : mc.player.getY();
   }

   private static double method07343(double var0, double var2, double var4, double var6) {
      double var8 = var2 + var0 * var4;
      return var8 < var2 ? var2 : Math.min(var8, var6);
   }

   static double method07344(float var0, double var1, double var3, double var5, double var7) {
      double var9 = Math.toRadians(var0);
      double var11 = field18006 * Math.cos(var9) + var5;
      if (var11 <= field18007) {
         return Double.NaN;
      }

      double var13 = var1 / var11;
      double var15 = field18008;
      if (var13 >= var15) {
         return Double.NaN;
      }

      double var17 = Math.log(1.0 - var13 * field18009 / field18010) / Math.log(field18011);
      if (var17 > field18012) {
         return Double.NaN;
      }

      double var19 = (var17 - var13) / field18013;
      double var21 = field18014 * Math.sin(var9) + var7;
      return var21 * var13 - field18015 * var19 - var3;
   }

   private boolean method07345() {
      if (!this.field17864.method05600(field17977)) {
         return true;
      } else {
         int var1 = this.field17865.method03022().method05871();
         if (var1 == -1) {
            return false;
         } else {
            return var1 <= -100 ? KeyboardKey.method00363(var1) : KeyboardKey.method00362(var1);
         }
      }
   }

   private boolean method07346() {
      for (Entity var2 : this.method07380()) {
         if (var2 instanceof ThrownEnderpearl var3 && var3.isAlive() && this.method07326(var3)) {
            return true;
         }
      }

      return false;
   }

   private void method07348() {
      this.field17916.clear();
      if (this.field17931 != null) {
         Vec3 var1 = this.method07374();
         double var2 = Math.hypot(this.field17931.x - var1.x, this.field17931.z - var1.z);
         double var4 = field18046 + var2 * field18047;
         AABB var6 = new AABB(var1, this.field17931).inflate(var4).expandTowards(0.0, field18048, 0.0);
         this.field17916.addAll(mc.level.getEntities(mc.player, var6, this::method07366));

         for (Entity var8 : this.field17917) {
            if (var8.isAlive() && !this.field17916.contains(var8)) {
               this.field17916.add(var8);
            }
         }
      }
   }

   private static boolean method07349(BlockState var0) {
      return var0.getBlock() instanceof LeavesBlock
         || var0.getBlock() instanceof MangroveRootsBlock
         || var0.getBlock() instanceof HugeMushroomBlock
         || var0.is(BlockTags.LEAVES)
         || var0.is(BlockTags.LOGS)
         || var0.is(BlockTags.WART_BLOCKS);
   }

   private boolean method07350(double var1, float var3) {
      if (!this.field17939) {
         return true;
      } else if (var1 < this.field17948 - field18017) {
         return true;
      } else {
         return var1 > this.field17948 + field18018 ? false : var3 > this.field17943 || var3 == this.field17943 && var1 < this.field17948;
      }
   }

   private boolean method07351(float var1, float var2, boolean var3) {
      Vec3 var4 = this.method07374();
      Vec3 var5 = this.method07365(var1, var2);
      double var6 = mc.level.getMinY();

      for (int var8 = 0; var8 < 180; var8++) {
         var5 = this.method07358(var5, var4);
         Vec3 var9 = var4.add(var5);
         BlockHitResult var10 = mc.level.clip(new ClipContext(var4, var9, Block.COLLIDER, Fluid.NONE, mc.player));
         Vec3 var11 = var10.getType() == Type.BLOCK ? var10.getLocation() : var9;
         if (this.method07384(var4, var11, var8, var3)) {
            return true;
         }

         if (var10.getType() == Type.BLOCK) {
            return false;
         }

         var4 = var9;
         if (var4.y < var6) {
            return false;
         }
      }

      return false;
   }

   private void method07352() {
      if (!this.field17936 && this.field17931 != null) {
         this.method07348();
         float var1 = this.method07369();
         long var2 = System.nanoTime();

         while (this.field17933 < field17912.length) {
            float var4 = var1 + field17912[this.field17933];

            while (this.field17934 < this.field17935.length) {
               float var5 = this.field17935[this.field17934];
               this.field17934++;
               this.method07330(var4, var5);
               if (System.nanoTime() - var2 > field18016) {
                  return;
               }
            }

            this.field17934 = 0;
            this.field17933++;
            if (this.field17939) {
               break;
            }
         }

         this.method07373();
         this.field17936 = true;
      }
   }

   private float[] method07353(float[] var1) {
      LinkedHashSet var2 = new LinkedHashSet();

      for (float var6 : var1) {
         var2.add(this.method07341(var6));

         for (float var7 = field17991; var7 <= field17992; var7 += field17993) {
            var2.add(this.method07341(var6 - var7));
            var2.add(this.method07341(var6 + var7));
         }
      }

      for (float var8 = field17994; var8 >= field17995; var8 -= field17996) {
         var2.add(var8);
      }

      float[] var9 = new float[var2.size()];
      int var10 = 0;

      for (float var12 : (Iterable<Float>) (Iterable) var2) {
         var9[var10++] = var12;
      }

      return var9;
   }

   private double method07354() {
      return mc.player != null && this.field17931 != null ? mc.player.position().distanceTo(this.field17931) : field18022;
   }

   private double method07355() {
      float var1 = this.method07369();
      float var2 = Float.NaN;
      double var3 = field18024;

      for (float var8 : this.method07331(field18025)) {
         PearlTarget.Nested217 var9 = this.method07370(this.method07379(var1, var8, field18026));
         if (var9 != null && !this.method07381(var9)) {
            double var10 = var9.pos().distanceTo(this.field17931);
            if (var10 < var3) {
               var3 = var10;
               var2 = var8;
            }
         }
      }

      if (!Float.isNaN(var2)) {
         this.field17929 = var2;
      }

      return var3;
   }

   private void method07356() {
      var var1 = mc.level.players();

      for (ThrownEnderpearl var3 : mc.level.getEntitiesOfClass(ThrownEnderpearl.class, mc.player.getBoundingBox().inflate(field18056), var0 -> true)) {
         if (var3.getOwner() == null) {
            var1.stream()
               .filter(var1x -> var1x.getEyePosition().distanceTo(var3.position()) <= field18061)
               .min(Comparator.comparingDouble(var1x -> var1x.distanceTo(var3)))
               .ifPresent(var3::setOwner);
         }
      }
   }

   @Subscribe
   private void method07357(PreMovementPacketEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (!mc.player.isFallFlying() && !mc.player.isUnderWater() && !mc.player.isInLava()) {
            this.method07356();
            if (System.currentTimeMillis() - this.field17923 >= this.method07329()) {
               if (this.method07345()) {
                  Slot var2 = InventoryUtils.method06136(Items.ENDER_PEARL);
                  if (var2 != null && !var2.getItem().isEmpty()) {
                     if (!mc.player.getCooldowns().isOnCooldown(var2.getItem())) {
                        if (this.method07346()) {
                           this.method07362();
                        } else if (this.field17866.method05600(field17974)) {
                           this.method07375(var1);
                        } else if (this.method07361()) {
                           this.method07352();
                           this.method07327(var1);
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private Vec3 method07358(Vec3 var1, Vec3 var2) {
      double var3 = this.method07338(var2) ? field18049 : field18050;
      return var1.subtract(0.0, field18051, 0.0).scale(var3);
   }

   public static boolean method07359(Vec3 var0) {
      if (method07349(mc.level.getBlockState(BlockPos.containing(var0.x, var0.y - field18040, var0.z)))) {
         return true;
      }

      AABB var1 = new AABB(var0.x - field18041, var0.y, var0.z - field18042, var0.x + field18043, var0.y + field18044, var0.z + field18045);
      MutableBlockPos var2 = new MutableBlockPos();

      for (int var3 = Mth.floor(var1.minX); var3 <= Mth.floor(var1.maxX); var3++) {
         for (int var4 = Mth.floor(var1.minY); var4 <= Mth.floor(var1.maxY); var4++) {
            for (int var5 = Mth.floor(var1.minZ); var5 <= Mth.floor(var1.maxZ); var5++) {
               var2.set(var3, var4, var5);
               if (method07349(mc.level.getBlockState(var2)) && new AABB(var2).intersects(var1)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private void method07360() {
      this.method07363();
      this.field17925 = false;
      this.field17926 = false;
      this.field17927 = 0;
      this.field17929 = Float.NaN;
      this.field17919 = 0;
      this.field17917.clear();
      this.field17918 = null;
   }

   private boolean method07361() {
      if (this.field17924 != -1) {
         Entity var1 = mc.level.getEntity(this.field17924);
         if (var1 == null || !var1.isAlive()) {
            this.field17924 = -1;
         }
      }

      Entity var19 = this.method07388();
      if (this.method07325() && var19 == null) {
         this.method07362();
         return false;
      }

      var var2 = this.method07380();
      double var3 = this.field17869.method03022().doubleValue();
      Vec3 var5 = mc.player.position();
      long var6 = System.currentTimeMillis();
      ThrownEnderpearl var8 = null;
      PearlTarget.Nested216 var9 = null;
      double var10 = field17979;
      int var12 = 0;

      for (Entity var14 : var2) {
         if (var14 instanceof ThrownEnderpearl var15
            && var15.isAlive()
            && var15.getId() != this.field17924
            && !this.method07326(var15)
            && (!this.method07325() || this.method07336(var15, var19))) {
            var12++;
            PearlTarget.Nested216 var16 = this.field17914.get(var15);
            if (var16 == null || var16.estimated() || var6 - var16.time() > field17980) {
               var16 = this.method07337(var15);
               if (var16 == null) {
                  this.field17914.remove(var15);
                  continue;
               }

               this.field17914.put(var15, var16);
            }

            double var17 = var5.distanceTo(var16.landing());
            if (!(var17 < var3) && !(var17 > field17981) && var17 < var10) {
               var10 = var17;
               var8 = var15;
               var9 = var16;
            }
         }
      }

      if (var8 == null) {
         this.method07362();
         return false;
      }

      if (var8 != this.field17930
         || this.field17931 == null
         || this.field17931.distanceToSqr(var9.landing()) > field17982
         || this.field17928 != mc.player.onGround()) {
         this.method07386(var8, var9);
      }

      return true;
   }

   private void method07362() {
      this.field17930 = null;
      this.field17931 = null;
      this.method07360();
   }

   private void method07363() {
      this.field17933 = 0;
      this.field17934 = 0;
      this.field17936 = false;
      this.field17939 = false;
      this.field17940 = false;
      this.field17941 = false;
      this.field17948 = field17988;
      this.field17949 = field17989;
      this.field17950 = field17990;
   }

   private static float method07364(float var0, float var1, double var2, double var4, double var6, double var8, double var10) {
      boolean var12 = var2 <= 0.0;

      for (int var13 = 0; var13 < 14; var13++) {
         float var14 = (var0 + var1) * field18004;
         double var15 = method07344(var14, var4, var6, var8, var10);
         if (Double.isNaN(var15)) {
            return var1;
         }

         if (var15 <= 0.0 == var12) {
            var0 = var14;
         } else {
            var1 = var14;
         }
      }

      return (var0 + var1) * field18005;
   }

   private Vec3 method07365(float var1, float var2) {
      return this.method07379(var1, var2, mc.player.onGround() ? 0.0 : mc.player.getDeltaMovement().y);
   }

   private boolean method07366(Entity var1) {
      return var1 != mc.player && var1.canBeHitByProjectile();
   }

   private PearlTarget.Nested216 method07368(Vec3 var1, Vec3 var2, int var3, int var4) {
      double var5 = this.method07342(var1, var4);
      double var7 = mc.level.getMinY();
      long var9 = System.currentTimeMillis();
      Vec3 var11 = var1;
      Vec3 var12 = var2;

      for (int var13 = var3; var13 < 180; var13++) {
         var12 = var12.subtract(0.0, field18037, 0.0).scale(field18038);
         var11 = var11.add(var12);
         if (var11.y <= var5) {
            return new PearlTarget.Nested216(new Vec3(var11.x, var5, var11.z), var13 + 1, true, var9);
         }

         if (var11.y < var7) {
            return new PearlTarget.Nested216(new Vec3(var11.x, var7, var11.z), var13 + 1, true, var9);
         }
      }

      return new PearlTarget.Nested216(new Vec3(var11.x, var5, var11.z), 180, true, var9);
   }

   private float method07369() {
      Vec3 var1 = this.method07374();
      double var2 = this.field17931.x - var1.x;
      double var4 = this.field17931.z - var1.z;
      return method07390(var2, var4);
   }

   private PearlTarget.Nested217 method07370(Vec3 var1) {
      Vec3 var2 = this.method07374();
      double var3 = mc.level.getMinY();
      double var5 = Math.min(var2.y, this.field17931.y) - field18027;
      double var7 = this.field17931.x - var2.x;
      double var9 = this.field17931.z - var2.z;
      double var11 = Math.sqrt(var7 * var7 + var9 * var9) + field18028;
      double var13 = var11 * var11;

      for (int var15 = 0; var15 < 180; var15++) {
         var1 = this.method07358(var1, var2);
         Vec3 var16 = var2.add(var1);
         if (!mc.level.isLoaded(BlockPos.containing(var16))) {
            PearlTarget.Nested216 var22 = this.method07368(var2, var1, var15, field18029);
            return var22 == null ? null : new PearlTarget.Nested217(var22.landing(), null);
         }

         BlockHitResult var17 = mc.level.clip(new ClipContext(var2, var16, Block.COLLIDER, Fluid.NONE, mc.player));
         if (var17.getType() == Type.BLOCK) {
            return new PearlTarget.Nested217(var17.getLocation(), var17.getBlockPos());
         }

         var2 = var16;
         if (var2.y < var3) {
            return null;
         }

         if (var2.y < var5) {
            return null;
         }

         double var18 = var2.x - (this.field17931.x - var7);
         double var20 = var2.z - (this.field17931.z - var9);
         if (var18 * var18 + var20 * var20 > var13) {
            return null;
         }
      }

      return null;
   }

   static float[] method07371(double var0, double var2, double var4, double var6) {
      var var8 = new ArrayList(2);
      double var9 = field18000;
      float var11 = Float.NaN;
      double var12 = Double.NaN;
      float var14 = field18001;

      for (float var15 = field18002; var15 >= field18003; var14 = var15--) {
         double var16 = method07344(var15, var0, var2, var4, var6);
         if (!Double.isNaN(var16)) {
            if (!Double.isNaN(var12) && var16 <= 0.0 != var12 <= 0.0) {
               var8.add(method07364(var14, var15, var12, var0, var2, var4, var6));
            }

            if (Math.abs(var16) < var9) {
               var9 = Math.abs(var16);
               var11 = var15;
            }
         }

         var12 = var16;
      }

      if (var8.isEmpty() && !Float.isNaN(var11)) {
         var8.add(var11);
      }

      float[] var18 = new float[var8.size()];

      for (int var19 = 0; var19 < var8.size(); var19++) {
         var18[var19] = (Float)var8.get(var19);
      }

      return var18;
   }

   protected boolean method07372(PreMovementPacketEvent var1, float var2, float var3) {
      return ModuleManager.INSTANCE.method08217().method03438(var1, var2, var3);
   }

   private void method07373() {
      if (this.field17939) {
         for (int var1 = 0; var1 < 2; var1++) {
            float var2 = this.field17942;
            float var3 = this.field17943;

            for (float var7 : field17910) {
               this.method07330(var2, this.method07341(var3 + var7));
            }

            for (float var11 : field17911) {
               this.method07330(var2 + var11, var3);
            }

            if (this.field17942 == var2 && this.field17943 == var3) {
               return;
            }
         }
      }
   }

   public PearlTarget() {
      super(ModuleCategory.Combat, ModuleSubCategory.Combat);
      this.field17864 = new ModeSetting(field17951).method05597(field17952, field17953).method03017(field17954).method03023(this);
      this.field17865 = new KeyBindSetting(field17955)
         .method03017(new KeyBinding())
         .method03025(() -> this.field17864.method05600(field18065))
         .method03023(this);
      this.field17866 = new ModeSetting(field17956).method05597(field17957, field17958).method03017(field17959).method03023(this);
      this.field17867 = new ModeSetting(field17960).method05597(field17961, field17962).method03017(field17963).method03023(this);
      this.field17868 = new NumberSetting<Integer>(field17964)
         .method10835(500)
         .method10838(5000)
         .method10834(50)
         .method03017(2000)
         .method03025(() -> this.field17866.method05600(field18064))
         .method03023(this);
      this.field17869 = new NumberSetting<Integer>(field17965).method10835(8).method10838(20).method10834(1).method03017(10).method03023(this);
      this.field17870 = new ToggleSetting(field17966).method03017(true).method03025(() -> this.field17866.method05600(field18063)).method03023(this);
      this.field17871 = new ToggleSetting(field17967).method03017(true).method03025(() -> this.field17866.method05600(field18062)).method03023(this);
      this.field17913 = new PearlTrajectoryAimer();
      this.field17914 = new HashMap<>();
      this.field17915 = new ArrayList<>(64);
      this.field17916 = new ArrayList<>(16);
      this.field17917 = new ArrayList<>(4);
      this.field17918 = null;
      this.field17919 = 0;
      this.field17920 = 0L;
      this.field17921 = null;
      this.field17922 = 0L;
      this.field17923 = 0L;
      this.field17924 = -1;
      this.field17925 = false;
      this.field17926 = false;
      this.field17927 = 0;
      this.field17928 = true;
      this.field17929 = Float.NaN;
      this.field17930 = null;
      this.field17931 = null;
      this.field17932 = 0;
      this.field17933 = 0;
      this.field17934 = 0;
      this.field17935 = new float[0];
      this.field17936 = false;
      this.field17937 = field17968;
      this.field17938 = field17969;
      this.field17939 = false;
      this.field17940 = false;
      this.field17941 = false;
      this.field17948 = field17970;
      this.field17949 = field17971;
      this.field17950 = field17972;
      this.method03935(field17973);
   }

   private Vec3 method07374() {
      return new Vec3(mc.player.getX(), mc.player.getEyeY() - field18052, mc.player.getZ());
   }

   private void method07375(PreMovementPacketEvent var1) {
      PearlTrajectoryAimer.Nested52 var2 = this.field17913.method01927(this.field17869.method03022().doubleValue(), this.method07325());
      if (var2 != null) {
         if (!this.method07351(var2.yaw(), var2.pitch(), true)) {
            if (ModuleManager.INSTANCE.method08217().method03438(var1, var2.yaw(), var2.pitch())) {
               this.field17923 = System.currentTimeMillis();
               this.field17913.method01938();
            }
         }
      }
   }

   private PearlTarget.Nested217 method07377(float var1, float var2) {
      return this.method07370(this.method07365(var1, var2));
   }

   private boolean method07378(float var1, float var2) {
      return this.field17916.isEmpty() ? false : this.method07351(var1, var2, false);
   }

   private Vec3 method07379(float var1, float var2, double var3) {
      double var5 = Math.toRadians(var1);
      double var7 = Math.toRadians(var2);
      double var9 = Math.cos(var7);
      Vec3 var11 = new Vec3(-Math.sin(var5) * var9, -Math.sin(var7), Math.cos(var5) * var9).scale(field18053);
      Vec3 var12 = mc.player.getDeltaMovement();
      return var11.add(var12.x, var3, var12.z);
   }

   private List<Entity> method07380() {
      long var1 = System.currentTimeMillis();
      if (var1 - this.field17920 < field18054 && !this.field17915.isEmpty()) {
         return this.field17915;
      }

      this.field17920 = var1;
      this.field17915.clear();
      this.field17915.addAll(mc.level.getEntities(mc.player, mc.player.getBoundingBox().inflate(field18055)));
      return this.field17915;
   }

   private boolean method07381(PearlTarget.Nested217 var1) {
      return var1.block() != null && this.method07333(var1.block()) ? true : method07359(var1.pos());
   }

   @Subscribe
   private void method07382(PlayerInputEvent var1) {
      if (this.field17925 && mc.player != null) {
         if (mc.player.onGround() && !var1.method11162()) {
            var1.method11173(true);
         }

         this.field17925 = false;
      }
   }

   private boolean method07384(Vec3 var1, Vec3 var2, int var3, boolean var4) {
      double var5 = this.method07385(var3);
      if (var4) {
         AABB var10 = new AABB(var1, var2).inflate(var5 + field18030);

         for (Entity var9 : mc.level.getEntities(mc.player, var10, this::method07366)) {
            if (this.method07387(var9, var3, var5).clip(var1, var2).isPresent()) {
               this.field17918 = var9;
               return true;
            }
         }

         return false;
      } else {
         for (Entity var8 : this.field17916) {
            if (this.method07387(var8, var3, var5).clip(var1, var2).isPresent()) {
               return true;
            }
         }

         return false;
      }
   }

   private double method07385(int var1) {
      return Mth.clamp((var1 - field18031) / field18032, 0.0, field18033);
   }

   private void method07386(ThrownEnderpearl var1, PearlTarget.Nested216 var2) {
      this.field17930 = var1;
      this.field17931 = var2.landing();
      this.field17932 = var2.ticks();
      Vec3 var3 = this.method07374();
      double var4 = this.field17931.x - var3.x;
      double var6 = this.field17931.z - var3.z;
      double var8 = Math.sqrt(var4 * var4 + var6 * var6);
      this.field17937 = method07343(var8, field17984, field17985, field17986);
      this.field17938 = this.field17937 * field17987;
      if (!mc.player.onGround() && !Float.isNaN(this.field17929)) {
         this.field17935 = this.method07353(new float[]{this.field17929});
      } else {
         this.field17935 = this.method07331(mc.player.onGround() ? 0.0 : mc.player.getDeltaMovement().y);
      }

      this.method07360();
      this.field17928 = mc.player.onGround();
   }

   private AABB method07387(Entity var1, int var2, double var3) {
      AABB var5 = var1.getBoundingBox().inflate(var3);
      Vec3 var6 = MovementUtils.method05718(var1);
      if (var6.lengthSqr() < field18034) {
         return var5;
      }

      double var7 = Math.min(var2 + 1, 10);
      return var5.expandTowards(var6.x * var7, var6.y * var7, var6.z * var7);
   }

   private Entity method07388() {
      if (!this.method07325()) {
         return null;
      }

      LivingEntity var1 = AttackAura.method00456();
      long var2 = System.currentTimeMillis();
      if (var1 != null && var1.isAlive()) {
         this.field17921 = var1;
         this.field17922 = var2;
         return var1;
      }

      if (this.field17921 != null) {
         if (this.field17921.isAlive() && !this.field17921.isRemoved() && var2 - this.field17922 < field17983) {
            return this.field17921;
         }

         this.field17921 = null;
         return null;
      } else {
         return null;
      }
   }

   private boolean method07389(PreMovementPacketEvent var1, float var2, float var3, String var4) {
      this.field17918 = null;
      if (this.method07351(var2, var3, true)) {
         if (this.field17918 != null && this.field17919 < 3) {
            this.field17919++;
            if (!this.field17917.contains(this.field17918)) {
               this.field17917.add(this.field17918);
            }

            this.method07363();
         }

         return false;
      } else {
         int var5 = this.field17930 != null ? this.field17930.getId() : -1;
         boolean var6 = this.method07372(var1, var2, var3);
         if (var6) {
            this.field17923 = System.currentTimeMillis();
            this.field17924 = var5;
            this.method07362();
            return true;
         } else {
            return false;
         }
      }
   }

   private static float method07390(double var0, double var2) {
      return (float)(Math.toDegrees(Math.atan2(var2, var0)) - field18023);
   }

   // $VF: Compiled from s
   private record Nested216(Vec3 landing, int ticks, boolean estimated, long time) {
   }

   // $VF: Compiled from s
   private record Nested217(Vec3 pos, BlockPos block) {
   }
}
