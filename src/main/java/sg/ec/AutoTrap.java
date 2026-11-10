// Original binary: sg/ec/hr8BhS5KLGSaQOpg
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.tags.BlockTags;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

// $VF: Compiled from s
public class AutoTrap extends ClientModule {
   private final NumberSetting<Float> field19886;
   private final NumberSetting<Float> field19887;
   private final NumberSetting<Integer> field19888;
   private final NumberSetting<Integer> field19889;
   private final ToggleSetting field19890;
   private final ToggleSetting field19891;
   private final ToggleSetting field19892;
   private final ToggleSetting field19893;
   private final ToggleSetting field19894;
   private final ToggleSetting field19895;
   private final NumberSetting<Integer> field19896;
   private final ToggleSetting field19897;
   private static final int field19898 = 1;
   private static final int field19899 = 0;
   private static final int field19900 = 0;
   private static final double field19901 = 0;
   private static final long field19902 = 0;
   private static final int field19903 = ColorUtils.method04604(70, 200, 120);
   private static final long field19904 = 0;
   private final ElapsedTimer field19905;
   private final HitResultConstraint field19906;
   private int field19907;
   private BlockPos field19908;
   private int field19909;
   private BlockPos field19910;
   private Item field19911;
   private int field19912;
   private final List<AutoTrap.Nested243> field19913;
   private final List<BlockPos> field19914;
   private final List<BlockPos> field19915;
   private final List<BlockPos> field19916;
   private final Set<BlockPos> field19917;
   private static final String field19918 = "Радиус цели";
   private static final float field19919 = 4.0F;
   private static final float field19920 = 12.0F;
   private static final float field19921 = 0.5F;
   private static final float field19922 = 8.0F;
   private static final String field19923 = "Дальность установки";
   private static final float field19924 = 3.0F;
   private static final float field19925 = 6.0F;
   private static final float field19926 = 0.1F;
   private static final float field19927 = 4.5F;
   private static final String field19928 = "Предикт тиков";
   private static final String field19929 = "Задержка в тиках";
   private static final String field19930 = "Пинг 0-50: 0 | 50-100: 1-2 | 100-150: 2-3 | 150-200: 3-4 | 200+: 4-5";
   private static final String field19931 = "Закрывать сверху";
   private static final String field19932 = "Закрывать снизу";
   private static final String field19933 = "Обсидиан (крайний случай)";
   private static final String field19934 = "Земля (крайний случай)";
   private static final String field19935 = "Уступать Crystal/Anchor";
   private static final String field19936 = "Обход Matrix";
   private static final String field19937 = "Окно уступки";
   private static final String field19938 = "Визуализация";
   private static final String field19939 = "Auto Trap";
   private static final long field19940 = 50L;
   private static final double field19941 = Double.MAX_VALUE;
   private static final double field19942 = 0.001;
   private static final double field19943 = 0.001;
   private static final double field19944 = 0.001;
   private static final double field19945 = 0.001;
   private static final double field19946 = 0.001;
   private static final double field19947 = 0.001;
   private static final double field19948 = Double.MAX_VALUE;
   private static final float field19949 = 9999.0F;
   private static final float field19950 = 280.0F;
   private static final float field19951 = 0.5F;
   private static final float field19952 = 0.5F;
   private static final float field19953 = 200.0F;
   private static final double field19954 = 0.5;
   private static final double field19955 = 0.5;
   private static final double field19956 = 0.5;
   private static final double field19957 = 0.5;
   private static final float field19958 = 0.05F;

   private BlockPos method08700(BlockPos var1, Vec3 var2, boolean var3) {
      this.field19917.clear();
      this.field19915.clear();
      this.field19917.add(var1);
      this.field19915.add(var1);

      for (int var4 = 0; var4 < 2; var4++) {
         this.field19916.clear();
         BlockPos sx = null;
         double sxx = field19948;

         for (BlockPos sxxx : this.field19915) {
            for (Direction sxxxx : Direction.values()) {
               BlockPos sxxxxx = sxxx.relative(sxxxx);
               if (this.field19917.add(sxxxxx) && this.method08725(sxxxxx, var3) && this.method08718(sxxxxx, var2)) {
                  if (this.method08726(sxxxxx, var2) == null) {
                     this.field19916.add(sxxxxx);
                  } else {
                     double sxxxxxx = var2.distanceToSqr(Vec3.atCenterOf(sxxxxx));
                     if (sxxxxxx < sxx) {
                        sxx = sxxxxxx;
                        sx = sxxxxx;
                     }
                  }
               }
            }
         }

         if (sx != null) {
            return sx;
         }

         if (this.field19916.isEmpty()) {
            return null;
         }

         this.field19915.clear();
         this.field19915.addAll(this.field19916);
      }

      return null;
   }

   @Override
   public void method00245() {
      this.field19906.method02876();
      this.method08714();
      this.field19908 = null;
      this.field19913.clear();
      super.method00245();
   }

   private Player method08701() {
      Player var1 = null;
      double var2 = field19941;

      for (Player var5 : CombatTargetUtils.method03519(this.field19886.method03022())) {
         double var6 = var5.position().distanceToSqr(mc.player.position());
         if (var6 < var2) {
            var2 = var6;
            var1 = var5;
         }
      }

      return var1;
   }

   private boolean method08702(BlockPos var1, Vec3 var2, boolean var3) {
      if (!this.method08725(var1, var3)) {
         return false;
      } else {
         return !this.method08718(var1, var2) ? false : this.method08726(var1, var2) == null;
      }
   }

   @Subscribe
   private void method08703(PlayerInputEvent var1) {
      if (mc.player != null && this.field19907 == mc.player.tickCount) {
         RotationManager.field14787 = true;
      }
   }

   private boolean method08704(BlockPos var1) {
      return var1.equals(this.field19908) && mc.player.tickCount - this.field19909 < 2;
   }

   private boolean method08705(BlockPos var1, Vec3 var2, boolean var3) {
      if (!this.method08725(var1, var3)) {
         return false;
      } else {
         return !this.method08718(var1, var2) ? false : this.method08726(var1, var2) != null;
      }
   }

   private boolean method08706(BlockPos var1) {
      BlockPos var2 = mc.player.blockPosition();
      return !var1.equals(var2) && !var1.equals(var2.above()) ? mc.player.getBoundingBox().intersects(new AABB(var1)) : true;
   }

   public boolean method08707() {
      return this.field19895.method05999();
   }

   private boolean method08708(BlockPos var1, Item var2) {
      Vec3 var3 = mc.player.getEyePosition();
      ExplosionDamageUtils.Nested134 var4 = this.method08726(var1, var3);
      if (var4 == null) {
         return false;
      }

      int var5 = InventoryUtils.method06111(var2, true);
      if (var5 == -1) {
         return false;
      }

      int var6 = mc.player.getInventory().getSelectedSlot();
      mc.player.getInventory().setSelectedSlot(var5);
      this.field19906.method02874(var4.neighbor());
      boolean var7 = false;

      try {
         double var8 = var3.distanceTo(var4.aim()) + 1.0;
         if (mc.player.pick(var8, 1.0F, false) instanceof BlockHitResult var11
            && var11.getBlockPos().equals(var4.neighbor())
            && var11.getDirection() == var4.side()
            && var11.getBlockPos().relative(var11.getDirection()).equals(var1)
            && mc.gameMode.useItemOn(mc.player, InteractionHand.MAIN_HAND, var11) == InteractionResult.SUCCESS) {
            mc.player.swing(InteractionHand.MAIN_HAND, net.minecraft.world.item.component.SwingAnimation.DEFAULT, false);
            RotationChangeTracker.method02903();
            if (this.field19895.method05999()) {
               RotationManager.method06555();
            }

            var7 = true;
         }
      } finally {
         this.field19906.method02876();
         mc.player.getInventory().setSelectedSlot(var6);
      }

      if (var7) {
         this.field19908 = var1;
         this.field19909 = mc.player.tickCount;
      }

      return var7;
   }

   private void method08709(int var1, int var2, int var3, int var4, int var5) {
      for (int var6 = var1; var6 <= var2; var6++) {
         for (int var7 = var3; var7 <= var4; var7++) {
            this.field19914.add(new BlockPos(var6, var5, var7));
         }
      }
   }

   private AABB method08710(BlockPos var1, float var2) {
      double var3 = var1.getX() + field19954;
      double var5 = var1.getY() + field19955;
      double var7 = var1.getZ() + field19956;
      double var9 = field19957 * Mth.clamp(var2, field19958, 1.0F);
      return new AABB(var3 - var9, var5 - var9, var7 - var9, var3 + var9, var5 + var9, var7 + var9);
   }

   @Subscribe
   private void method08711(Render3DEvent var1) {
      if (mc.player != null && mc.level != null) {
         if (!this.field19897.method05999()) {
            this.field19913.clear();
         } else if (!this.field19913.isEmpty()) {
            PoseStack var2 = var1.method00996();
            Camera var3 = var1.method00994();
            Frustum var4 = var1.method00986();
            WorldVertexCollector var5 = var1.method00985();
            long var6 = System.currentTimeMillis();
            var var8 = this.field19913.iterator();

            while (var8.hasNext()) {
               AutoTrap.Nested243 var9 = (AutoTrap.Nested243)var8.next();
               float var10 = (float)(var6 - var9.field19960) / field19950;
               if (var10 >= 1.0F) {
                  var8.remove();
               } else {
                  float var11 = field19951 + field19952 * var10;
                  int var12 = (int)((1.0F - var10) * field19953);
                  WorldBoxRenderer.method06958(
                     this.method08710(var9.field19959, var11), var2, var3, var4, var5, ColorUtils.method04616(field19903, var12)
                  );
               }
            }
         }
      }
   }

   public AutoTrap() {
      super(ModuleCategory.Combat, ModuleSubCategory.Utility);
      this.field19886 = new NumberSetting<Float>(field19918)
         .method10835(field19919)
         .method10838(field19920)
         .method10834(field19921)
         .method03017(field19922)
         .method03023(this);
      this.field19887 = new NumberSetting<Float>(field19923)
         .method10835(field19924)
         .method10838(field19925)
         .method10834(field19926)
         .method03017(field19927)
         .method03023(this);
      this.field19888 = new NumberSetting<Integer>(field19928).method10835(0).method10838(4).method10834(1).method03017(1).method03023(this);
      this.field19889 = new NumberSetting<Integer>(field19929)
         .method10835(0)
         .method10838(5)
         .method10834(1)
         .method03017(0)
         .method03018(field19930)
         .method03023(this);
      this.field19890 = new ToggleSetting(field19931).method03017(true).method03023(this);
      this.field19891 = new ToggleSetting(field19932).method03017(true).method03023(this);
      this.field19892 = new ToggleSetting(field19933).method03017(true).method03023(this);
      this.field19893 = new ToggleSetting(field19934).method03017(true).method03023(this);
      this.field19894 = new ToggleSetting(field19935).method03017(true).method03023(this);
      this.field19895 = new ToggleSetting(field19936).method03017(false).method03023(this);
      this.field19896 = new NumberSetting<Integer>(field19937)
         .method10835(0)
         .method10838(5)
         .method10834(1)
         .method03017(1)
         .method03023(this)
         .method03025(this.field19894::method05999);
      this.field19897 = new ToggleSetting(field19938).method03017(true).method03023(this);
      this.field19905 = new ElapsedTimer();
      this.field19906 = new HitResultConstraint();
      this.field19907 = -1;
      this.field19909 = -100;
      this.field19912 = -100;
      this.field19913 = new ArrayList<>();
      this.field19914 = new ArrayList<>(24);
      this.field19915 = new ArrayList<>(32);
      this.field19916 = new ArrayList<>(32);
      this.field19917 = new HashSet<>();
      this.method03935(field19939);
   }

   private Item method08712() {
      Item var1 = null;
      Item var2 = null;
      Item var3 = null;
      int var4 = -1;
      int var5 = -1;
      int var6 = -1;

      for (int var7 = 0; var7 < 9; var7++) {
         ItemStack var8 = mc.player.getInventory().getItem(var7);
         if (!var8.isEmpty() && var8.getItem() instanceof BlockItem var9) {
            BlockState var12 = var9.getBlock().defaultBlockState();
            if (var12.isRedstoneConductor(mc.level, mc.player.blockPosition())) {
               int var11 = var8.getCount();
               if (var12.is(BlockTags.PLANKS)) {
                  if (var11 > var4) {
                     var4 = var11;
                     var1 = var8.getItem();
                  }
               } else if (!this.method08717(var12) && !this.method08716(var12)) {
                  if (var11 > var5) {
                     var5 = var11;
                     var2 = var8.getItem();
                  }
               } else if ((!this.method08717(var12) || this.field19892.method05999())
                  && (!this.method08716(var12) || this.field19893.method05999())
                  && var11 > var6) {
                  var6 = var11;
                  var3 = var8.getItem();
               }
            }
         }
      }

      if (var1 != null) {
         return var1;
      } else {
         return var2 != null ? var2 : var3;
      }
   }

   private static boolean method08713(float var0, float var1) {
      return var0 > 2.0F || var1 > 2.0F;
   }

   private void method08714() {
      this.field19910 = null;
      this.field19911 = null;
      this.field19912 = -100;
   }

   private void method08715(AABB var1) {
      this.field19914.clear();
      int var2 = Mth.floor(var1.minX + field19942);
      int var3 = Mth.floor(var1.maxX - field19943);
      int var4 = Mth.floor(var1.minZ + field19944);
      int var5 = Mth.floor(var1.maxZ - field19945);
      int var6 = Mth.floor(var1.minY + field19946);
      int var7 = Mth.floor(var1.maxY - field19947);

      for (int var8 = var6; var8 <= var7; var8++) {
         for (int var9 = var2; var9 <= var3; var9++) {
            for (int var10 = var4; var10 <= var5; var10++) {
               this.method08721(var9 - 1, var8, var10, var2, var3, var4, var5);
               this.method08721(var9 + 1, var8, var10, var2, var3, var4, var5);
               this.method08721(var9, var8, var10 - 1, var2, var3, var4, var5);
               this.method08721(var9, var8, var10 + 1, var2, var3, var4, var5);
            }
         }
      }

      if (this.field19890.method05999()) {
         this.method08709(var2, var3, var4, var5, var7 + 1);
      }

      if (this.field19891.method05999()) {
         this.method08709(var2, var3, var4, var5, var6 - 1);
      }
   }

   private boolean method08716(BlockState var1) {
      return var1.is(BlockTags.DIRT) || var1.getBlock() instanceof FallingBlock;
   }

   private boolean method08717(BlockState var1) {
      return var1.is(Blocks.OBSIDIAN) || var1.is(Blocks.CRYING_OBSIDIAN);
   }

   private boolean method08718(BlockPos var1, Vec3 var2) {
      return var2.distanceToSqr(Vec3.atCenterOf(var1)) <= this.field19887.method03022() * this.field19887.method03022();
   }

   @Subscribe
   private void method08719(PostPlayerInputEvent var1) {
      BlockPos var2 = this.field19910;
      Item var3 = this.field19911;
      int var4 = this.field19912;
      this.method08714();
      if (var2 != null && var3 != null) {
         if (mc.player != null && mc.level != null && mc.gameMode != null) {
            if (mc.player.tickCount == var4) {
               if (mc.level.getBlockState(var2).canBeReplaced()) {
                  if (this.method08708(var2, var3)) {
                     this.field19905.method04694();
                     if (this.field19897.method05999()) {
                        this.field19913.add(new AutoTrap.Nested243(var2, System.currentTimeMillis()));
                     }
                  }
               }
            }
         }
      }
   }

   @Subscribe
   private void method08720(PlayerUpdateEvent var1) {
      if (mc.player != null && mc.level != null && mc.gameMode != null && !mc.player.isSpectator()) {
         boolean var2 = this.field19894.method05999();
         if (!var2 || !BlockPlacementTracker.method05647(this.field19896.method03022()) && !BlockTrapController.method11570()) {
            if (this.field19905.method04699(this.field19889.method03022().intValue() * field19940)) {
               if (!RotationManager.method06562(1)) {
                  Vec3 var3 = mc.player.getEyePosition();
                  Player var4 = this.method08701();
                  if (var4 != null) {
                     Item var5 = this.method08712();
                     if (var5 != null) {
                        this.method08715(this.method08723(var4));

                        for (BlockPos var7 : this.field19914) {
                           if (this.method08705(var7, var3, var2) && this.method08724(var7, var5, var3)) {
                              return;
                           }
                        }

                        for (BlockPos var10 : this.field19914) {
                           if (this.method08702(var10, var3, var2)) {
                              BlockPos var8 = this.method08700(var10, var3, var2);
                              if (var8 != null && this.method08724(var8, var5, var3)) {
                                 return;
                              }
                           }
                        }
                     }
                  }
               }
            }
         }
      }
   }

   private void method08721(int var1, int var2, int var3, int var4, int var5, int var6, int var7) {
      if (var1 < var4 || var1 > var5 || var3 < var6 || var3 > var7) {
         BlockPos var8 = new BlockPos(var1, var2, var3);
         if (!this.field19914.contains(var8)) {
            this.field19914.add(var8);
         }
      }
   }

   @Subscribe
   private void method08722(HitResultEvent var1) {
      this.field19906.method02875(var1);
   }

   private AABB method08723(Player var1) {
      AABB var2 = var1.getBoundingBox();
      int var3 = this.field19888.method03022();
      if (var3 <= 0) {
         return var2;
      }

      SimulatedPlayerInput var4 = SimulatedPlayerInput.method08903(var1, var3);
      return var4.field20218 == null ? var2 : var2.move(var4.field20218.subtract(var1.position()));
   }

   private boolean method08724(BlockPos var1, Item var2, Vec3 var3) {
      ExplosionDamageUtils.Nested134 var4 = this.method08726(var1, var3);
      if (var4 == null) {
         return false;
      }

      if (InventoryUtils.method06111(var2, true) == -1) {
         return false;
      }

      Vector2f var5 = PlayerUtils.method11816(var3, var4.aim());
      if (this.field19895.method05999()) {
         BlockPlacementManager.method07910(var5);
      }

      RotationManager.method06547(new Rotation(var5.x, var5.y), field19949, 1, false);
      float var6 = Math.abs(Mth.wrapDegrees(var5.x - mc.player.getYRot()));
      float var7 = Math.abs(var5.y - mc.player.getXRot());
      if (method08713(var6, var7)) {
         return false;
      }

      this.field19907 = mc.player.tickCount;
      this.field19910 = var1;
      this.field19911 = var2;
      this.field19912 = mc.player.tickCount;
      return true;
   }

   private boolean method08725(BlockPos var1, boolean var2) {
      BlockState var3 = mc.level.getBlockState(var1);
      if (!var3.canBeReplaced()) {
         return false;
      } else if (this.method08706(var1)) {
         return false;
      } else {
         return ExplosionDamageUtils.method04374(var1) ? false : !var2 || !BlockPlacementTracker.method05650(var1);
      }
   }

   private ExplosionDamageUtils.Nested134 method08726(BlockPos var1, Vec3 var2) {
      ExplosionDamageUtils.Nested134 var3 = ExplosionDamageUtils.method04420(var1, var2, this.field19887.method03022());
      if (var3 == null) {
         return null;
      } else {
         return this.method08704(var3.neighbor()) ? null : var3;
      }
   }

   // $VF: Compiled from s
   private static final class Nested243 {
      private final BlockPos field19959;
      private final long field19960;

      private Nested243(BlockPos var1, long var2) {
         this.field19959 = var1;
         this.field19960 = var2;
      }
   }
}
