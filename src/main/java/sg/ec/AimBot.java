// Original binary: sg/ec/WNUrjxD9qvnFwYAH
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import com.mojang.blaze3d.vertex.VertexConsumer;
import com.mojang.math.Axis;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import net.minecraft.client.Camera;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.BowItem;
import net.minecraft.world.item.CrossbowItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TridentItem;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.ClipContext.Block;
import net.minecraft.world.level.ClipContext.Fluid;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.HitResult.Type;
import org.joml.Matrix4f;

// $VF: Compiled from s
public class AimBot extends ClientModule {
   private final ModeSetting field13576;
   private final MultiToggleSetting field13577;
   private final NumberSetting<Integer> field13578;
   private final MultiToggleSetting field13579;
   private final ToggleSetting field13580;
   private final NumberSetting<Integer> field13581;
   private final NumberSetting<Integer> field13582;
   private final NumberSetting<Float> field13583;
   private final NumberSetting<Float> field13584;
   private final ToggleSetting field13585;
   private final NumberSetting<Float> field13586;
   private LivingEntity field13587;
   private final SortableArrayList<LivingEntity> field13588;
   private AimBot.Nested181 field13589;
   private final EntityAimPointSampler field13590;
   private final ElapsedTimer field13591;
   private final Random field13592;
   private Integer field13593;
   private static final int field13594 = 2;
   private int field13595;
   private boolean field13596;
   private boolean field13597;
   private int field13598;
   private boolean field13599;
   private static final String field13600 = "Режим ротации";
   private static final String field13601 = "Плавная";
   private static final String field13602 = "Снап";
   private static final String field13603 = "Плавная";
   private static final String field13604 = "Оружие";
   private static final String field13605 = "Лук";
   private static final String field13606 = "Арбалет";
   private static final String field13607 = "Трезубец";
   private static final String field13608 = "Дистанция обнаружения";
   private static final String field13609 = "Таргеты";
   private static final String field13610 = "Игроки";
   private static final String field13611 = "Мобы";
   private static final String field13612 = "Друзья";
   private static final String field13613 = "Авто выстрел";
   private static final String field13614 = "Сколько тиков ждать";
   private static final String field13615 = "Рандом заряда";
   private static final String field13616 = "Пауза между выстрелами";
   private static final float field13617 = 5.0F;
   private static final float field13618 = 0.1F;
   private static final String field13619 = "Граница наводки";
   private static final float field13620 = 0.5F;
   private static final float field13621 = 4.0F;
   private static final float field13622 = 0.1F;
   private static final float field13623 = 1.5F;
   private static final String field13624 = "Требуется попадание";
   private static final String field13625 = "Скорость поворота";
   private static final float field13626 = 20.0F;
   private static final float field13627 = 10.0F;
   private static final int field13628 = Integer.MIN_VALUE;
   private static final String field13629 = "Aim Bot";
   private static final float field13630 = 0.2F;
   private static final float field13631 = 0.7F;
   private static final float field13632 = 0.7F;
   private static final float field13633 = 0.7F;
   private static final float field13634 = 0.7F;
   private static final float field13635 = 1500.0F;
   private static final float field13636 = -1500.0F;
   private static final float field13637 = -1500.0F;
   private static final float field13638 = 1500.0F;
   private static final float field13639 = -1.0F;
   private static final float field13640 = -1.0F;
   private static final String field13641 = "Лук";
   private static final String field13642 = "Арбалет";
   private static final String field13643 = "Трезубец";
   private static final float field13644 = 1000.0F;
   private static final float field13645 = 0.1F;
   private static final int field13646 = Integer.MIN_VALUE;
   private static final int field13647 = Integer.MIN_VALUE;
   private static final float field13648 = 9999.0F;
   private static final float field13649 = 100.0F;
   private static final float field13650 = 0.05F;
   private static final float field13651 = -90.0F;
   private static final float field13652 = 90.0F;
   private static final float field13653 = 0.05F;
   private static final float field13654 = 0.05F;
   private static final double field13655 = 0.05;
   private static final double field13656 = 2.0;
   private static final double field13657 = 1.0E-6;
   private static final double field13658 = 90.0;
   private static final double field13659 = Double.MAX_VALUE;
   private static final double field13660 = 0.99;
   private static final double field13661 = -0.05;
   private static final double field13662 = 4.0;
   private static final double field13663 = 0.5;
   private static final double field13664 = 0.5;
   private static final double field13665 = 0.99;
   private static final double field13666 = -0.05;
   private static final float field13667 = (float) (Math.PI / 180.0);
   private static final float field13668 = (float) (Math.PI / 180.0);
   private static final float field13669 = 0.05F;
   private static final double field13670 = 0.2;
   private static final double field13671 = 0.15;
   private static final String field13672 = "Друзья";
   private static final String field13673 = "Игроки";
   private static final String field13674 = "Мобы";
   private static final double field13675 = 0.5;
   private static final double field13676 = 0.5;
   private static final double field13677 = 0.15;
   private static final double field13678 = 2.0;

   @Subscribe
   private void method06000(StopUsingItemEvent var1) {
      if (mc.player != null && mc.level != null && var1.method08030() == mc.player) {
         if (this.method06009(var1.method08033().getItem())) {
            if (this.field13599) {
               this.field13599 = false;
            } else if (this.field13596) {
               var1.method05695(true);
            } else {
               this.method06026();
               if (this.field13589 != null) {
                  this.method06020();
                  var1.method05695(true);
                  this.method06001(true);
               }
            }
         }
      }
   }

   private void method06001(boolean var1) {
      if (!this.field13596) {
         this.field13596 = true;
         this.field13597 = var1;
         this.field13598 = mc.player.tickCount;
         this.field13595 = Math.max(this.field13595, 2);
      }
   }

   private AimBot.Nested181 method06002(float var1) {
      return this.method06008(this.field13587, this.method06021(var1), var1);
   }

   @Subscribe
   private void method06003(ItemUseEvent var1) {
      if (mc.player != null && mc.level != null && var1.method02445() == InteractionHand.MAIN_HAND) {
         if (this.method06027() == AimBot.Nested183.CROSSBOW) {
            if (CrossbowItem.isCharged(mc.player.getMainHandItem())) {
               if (this.field13599) {
                  this.field13599 = false;
               } else if (this.field13596) {
                  var1.method05696();
               } else {
                  this.method06026();
                  if (this.field13589 != null) {
                     this.method06020();
                     var1.method05696();
                     this.method06001(false);
                  }
               }
            }
         }
      }
   }

   @Override
   public void method00245() {
      this.field13587 = null;
      this.field13589 = null;
      this.field13593 = null;
      this.field13595 = 0;
      this.method06004();
      super.method00245();
   }

   private void method06004() {
      this.field13596 = false;
      this.field13597 = false;
      this.field13598 = field13647;
      this.field13599 = false;
   }

   private static double method06005(boolean var0, int var1, boolean var2, int var3) {
      double var4 = 1.0;
      if (var0) {
         var4 *= 1.0 + field13670 * (var1 + 1);
      }

      if (var2) {
         var4 *= Math.max(0.0, 1.0 - field13671 * (var3 + 1));
      }

      return var4;
   }

   private boolean method06006(List<Vec3> var1, Vec3 var2, LivingEntity var3) {
      if (var1.size() < 2) {
         return false;
      }

      AABB var4 = var3.getBoundingBox();
      Vec3 var5 = var4.getCenter();
      AABB var6 = var4.move(var2.subtract(var5)).inflate(field13677);

      for (int var7 = 0; var7 < var1.size() - 1; var7++) {
         if (var6.clip((Vec3)var1.get(var7), (Vec3)var1.get(var7 + 1)).isPresent()) {
            return true;
         }
      }

      return false;
   }

   private float method06007(AimBot.Nested183 var1) {
      if (var1 != AimBot.Nested183.BOW) {
         return var1.field13679;
      }

      int var2 = mc.player.getTicksUsingItem();
      if (this.field13580.method03022()) {
         int var3 = this.field13581.method03022() + this.method06022();
         if (var3 > var2) {
            var2 = var3;
         }
      }

      float var4 = BowItem.getPowerForTime(var2);
      return Math.max(field13669, var4 * var1.field13679);
   }

   private AimBot.Nested181 method06008(LivingEntity var1, Vec3 var2, float var3) {
      AimBot.Nested183 var4 = this.method06027();
      if (var4 != null && var1 != null) {
         Vec3 var5 = mc.player.getEyePosition(var3);
         Vec3 var6 = this.method06011(var1);
         Vec3 var7 = this.method06015(var4);
         float var8 = this.method06007(var4);
         if (var8 < field13650) {
            return this.method06030(var5, var2);
         }

         int var9 = this.method06037(var4);
         Vec3 var10 = var2.add(var6.scale(var9));
         double[] var11 = this.method06029(var5, var10, var6, var7, var8);
         if (var11 == null) {
            return this.method06030(var5, var2);
         }

         float var12 = (float)var11[0];
         float var13 = (float)var11[1];

         for (int var14 = 0; var14 < 6; var14++) {
            AimBot.Nested182 var15 = this.method06039(var5, var12, var13, var8, var7, var10, var6);
            if (var15 == null) {
               break;
            }

            Rotation var16 = Rotation.method09438(var15.arrow().subtract(var5));
            Rotation var17 = Rotation.method09438(var15.target().subtract(var5));
            float var18 = Mth.wrapDegrees(var17.method09439() - var16.method09439());
            float var19 = Mth.wrapDegrees(var17.method09443() - var16.method09443());
            var12 = Mth.wrapDegrees(var12 + var18);
            var13 = Mth.clamp(var13 + var19, field13651, field13652);
            if (Math.abs(var18) < field13653 && Math.abs(var19) < field13654) {
               break;
            }
         }

         var var20 = this.method06016(var5, var12, var13, var8, var7);
         Vec3 var21 = var20.isEmpty() ? null : (Vec3)var20.getLast();
         AimBot.Nested182 var22 = this.method06039(var5, var12, var13, var8, var7, var10, var6);
         float var23 = var22 == null ? 0.0F : var9 + var22.ticks();
         if (var21 == null) {
            return null;
         }

         boolean var24 = var22 != null && this.method06006(var20, var22.target(), var1);
         return new AimBot.Nested181(var20, var21, new Rotation(var12, var13), var23, var24);
      } else {
         return null;
      }
   }

   private boolean method06009(Item var1) {
      return var1 instanceof BowItem || var1 instanceof TridentItem;
   }

   private boolean method06010() {
      if (mc.player != null && this.field13587 != null) {
         AimBot.Nested183 var1 = this.method06027();
         if (var1 == null) {
            return false;
         } else {
            return var1 == AimBot.Nested183.CROSSBOW
               ? CrossbowItem.isCharged(mc.player.getMainHandItem())
               : mc.player.isUsingItem() || mc.options.keyUse.isDown() || this.field13595 > 0;
         }
      } else {
         return false;
      }
   }

   public AimBot() {
      super(ModuleCategory.Combat, ModuleSubCategory.Combat);
      this.field13576 = new ModeSetting(field13600).method05597(field13601, field13602).method03017(field13603).method03023(this);
      this.field13577 = new MultiToggleSetting(field13604)
         .method04517(NamedOption.method08077(field13605, true))
         .method04517(NamedOption.method08077(field13606, true))
         .method04517(NamedOption.method08077(field13607, false))
         .method03023(this);
      this.field13578 = new NumberSetting<Integer>(field13608).method10835(3).method10838(50).method10834(1).method03017(15).method03023(this);
      this.field13579 = new MultiToggleSetting(field13609)
         .method04517(NamedOption.method08077(field13610, true))
         .method04517(NamedOption.method08077(field13611, false))
         .method04517(NamedOption.method08077(field13612, false))
         .method03023(this);
      this.field13580 = new ToggleSetting(field13613).method03017(true).method03023(this);
      this.field13581 = new NumberSetting<Integer>(field13614)
         .method10835(3)
         .method10838(20)
         .method10834(1)
         .method03017(15)
         .method03025(this.field13580::method03022)
         .method03023(this);
      this.field13582 = new NumberSetting<Integer>(field13615)
         .method10835(0)
         .method10838(10)
         .method10834(1)
         .method03017(0)
         .method03025(this.field13580::method03022)
         .method03023(this);
      this.field13583 = new NumberSetting<Float>(field13616)
         .method10835(0.0F)
         .method10838(field13617)
         .method10834(field13618)
         .method03017(0.0F)
         .method03025(this.field13580::method03022)
         .method03023(this);
      this.field13584 = new NumberSetting<Float>(field13619)
         .method10835(field13620)
         .method10838(field13621)
         .method10834(field13622)
         .method03017(field13623)
         .method03025(this.field13580::method03022)
         .method03023(this);
      this.field13585 = new ToggleSetting(field13624).method03017(false).method03025(this.field13580::method03022).method03023(this);
      this.field13586 = new NumberSetting<Float>(field13625)
         .method10835(1.0F)
         .method10838(field13626)
         .method10834(1.0F)
         .method03017(field13627)
         .method03023(this);
      this.field13587 = null;
      this.field13588 = new SortableArrayList<>();
      this.field13589 = null;
      this.field13590 = new EntityAimPointSampler();
      this.field13591 = new ElapsedTimer();
      this.field13592 = new Random();
      this.field13593 = null;
      this.field13595 = 0;
      this.field13596 = false;
      this.field13597 = false;
      this.field13598 = field13628;
      this.field13599 = false;
      this.method03935(field13629);
   }

   private Vec3 method06011(LivingEntity var1) {
      Vec3 var2 = new Vec3(var1.getX() - var1.xo, var1.getY() - var1.yo, var1.getZ() - var1.zo);
      double var3 = this.method06028(var1);
      if (var3 != 1.0) {
         var2 = new Vec3(var2.x * var3, var2.y, var2.z * var3);
      }

      return var2;
   }

   private boolean method06012() {
      AimBot.Nested183 var1 = this.method06027();
      if (var1 == null) {
         return false;
      }

      ItemStack var2 = mc.player.getMainHandItem();

      return switch (var1) {
         case BOW -> mc.player.isUsingItem() && BowItem.getPowerForTime(mc.player.getTicksUsingItem()) > 0.0F;
         case CROSSBOW -> CrossbowItem.isCharged(var2);
         case TRIDENT -> mc.player.isUsingItem() && mc.player.getTicksUsingItem() >= 10;
      };
   }

   private void method06013() {
      if (this.field13580.method03022() && this.field13589 != null && mc.gameMode != null) {
         AimBot.Nested183 var1 = this.method06027();
         if (var1 != null) {
            if (!this.field13596) {
               if (this.field13591.method04699((long)(this.field13583.method03022() * field13644))) {
                  if (var1 != AimBot.Nested183.CROSSBOW) {
                     int var2 = this.field13581.method03022() + this.method06022();
                     if (mc.player.getTicksUsingItem() >= Math.max(0, var2)) {
                        if (!this.method06025()) {
                           float var3 = Math.abs(Mth.wrapDegrees(mc.player.getYRot() - this.field13589.rotation().method09439()));
                           float var4 = Math.abs(Mth.wrapDegrees(mc.player.getXRot() - this.field13589.rotation().method09443()));
                           float var5 = this.field13584.method03022();
                           if (var3 > var5 || var4 > var5) {
                              return;
                           }
                        }

                        if (!this.field13585.method03022() || this.field13589.reachable()) {
                           if (var1 == AimBot.Nested183.BOW) {
                              float var6 = BowItem.getPowerForTime(mc.player.getTicksUsingItem());
                              if (var6 < field13645) {
                                 return;
                              }
                           }

                           this.method06001(true);
                        }
                     }
                  } else if (!this.field13585.method03022() || this.field13589.reachable()) {
                     this.method06001(false);
                  }
               }
            }
         }
      }
   }

   @Subscribe
   private void method06014(PlayerInputEvent var1) {
      if (this.method06010() && this.method06018()) {
         RotationManager.field14787 = true;
      }
   }

   private Vec3 method06015(AimBot.Nested183 var1) {
      if (var1 == AimBot.Nested183.CROSSBOW) {
         return Vec3.ZERO;
      }

      Vec3 var2 = mc.player.getDeltaMovement();
      return new Vec3(var2.x, mc.player.onGround() ? 0.0 : var2.y, var2.z);
   }

   private List<Vec3> method06016(Vec3 var1, float var2, float var3, float var4, Vec3 var5) {
      ArrayList var6 = new ArrayList();
      Vec3 var7 = var1;
      Vec3 var8 = this.method06038(var2, var3).scale(var4).add(var5);

      for (int var9 = 0; var9 < 90; var9++) {
         var6.add(var7);
         Vec3 var10 = var7.add(var8);
         BlockHitResult var11 = mc.level.clip(new ClipContext(var7, var10, Block.COLLIDER, Fluid.NONE, mc.player));
         if (var11.getType() != Type.MISS) {
            var6.add(var11.getLocation());
            return var6;
         }

         var7 = var10;
         var8 = var8.scale(field13665).add(0.0, field13666, 0.0);
         if (var7.y < mc.level.getMinY()) {
            break;
         }
      }

      var6.add(var7);
      return var6;
   }

   private void method06017() {
      this.field13591.method04694();
      this.method06036();
      this.field13595 = Math.max(this.field13595, 2);
      this.field13596 = false;
      this.field13597 = false;
      this.field13598 = field13646;
   }

   private boolean method06018() {
      return !this.method06025() || this.field13595 > 0 || this.field13596 || this.field13599;
   }

   private boolean method06019(Vec3 var1, LivingEntity var2) {
      Vec3 var3 = new Vec3(var2.getX(), var2.getY() + var2.getBbHeight() * field13675, var2.getZ());
      AimBot.Nested181 var4 = this.method06008(var2, var3, 1.0F);
      return var4 != null && var4.reachable();
   }

   private void method06020() {
      if (this.field13589 != null) {
         float var1 = this.method06025() ? field13648 : this.field13586.method03022() * field13649;
         RotationManager.method06552(this.field13589.rotation(), var1, var1, 50, false);
      }
   }

   private Vec3 method06021(float var1) {
      Vec3 var2 = this.field13587.position().add(0.0, this.field13587.getBbHeight() * field13663, 0.0);
      if (GuiHitTestUtils.method05608(var2)) {
         return var2;
      }

      Vec3 var3 = this.field13590.method01266();
      return var3 != null ? var3 : this.field13587.getPosition(var1).add(0.0, this.field13587.getBbHeight() * field13664, 0.0);
   }

   private int method06022() {
      if (this.field13593 == null) {
         this.method06036();
      }

      return this.field13593 == null ? 0 : this.field13593;
   }

   private boolean method06023(LivingEntity var1) {
      if (!(var1 instanceof LocalPlayer) && !var1.isDeadOrDying() && var1.isAlive() && var1.tickCount >= 3) {
         if (mc.player.getEyePosition().distanceTo(var1.getEyePosition()) > this.field13578.method03022().intValue()) {
            return false;
         }

         if (var1 instanceof Player var2) {
            if (ModuleManager.INSTANCE.method08260().method00605(var2)) {
               return false;
            } else {
               return FriendManager.INSTANCE.method00172(var2) && !this.field13579.method04520(field13672)
                  ? false
                  : this.field13579.method04520(field13673);
            }
         } else {
            return var1 instanceof Mob ? this.field13579.method04520(field13674) : false;
         }
      } else {
         return false;
      }
   }

   private double method06024(Vec3 var1, Rotation var2, LivingEntity var3) {
      Vec3 var4 = new Vec3(var3.getX(), var3.getY() + var3.getBbHeight() * field13676, var3.getZ());
      Rotation var5 = Rotation.method09438(var4.subtract(var1));
      double var6 = Mth.wrapDegrees(var5.method09439() - var2.method09439());
      double var8 = var5.method09443() - var2.method09443();
      return var6 * var6 + var8 * var8;
   }

   private boolean method06025() {
      return this.method06033() || this.method06027() == AimBot.Nested183.CROSSBOW;
   }

   private void method06026() {
      if (this.field13587 == null || !this.field13587.isAlive()) {
         this.method06032();
         if (this.field13587 != null) {
            this.field13590.method01268(this.field13587);
         }
      }

      this.field13589 = this.field13587 != null ? this.method06002(1.0F) : null;
   }

   private AimBot.Nested183 method06027() {
      if (mc.player == null) {
         return null;
      } else {
         Item var1 = mc.player.getMainHandItem().getItem();
         if (var1 instanceof BowItem) {
            return this.field13577.method04520(field13641) ? AimBot.Nested183.BOW : null;
         } else if (var1 instanceof CrossbowItem) {
            return this.field13577.method04520(field13642) ? AimBot.Nested183.CROSSBOW : null;
         } else if (var1 instanceof TridentItem) {
            return this.field13577.method04520(field13643) ? AimBot.Nested183.TRIDENT : null;
         } else {
            return null;
         }
      }
   }

   private double method06028(LivingEntity var1) {
      boolean var2 = var1.hasEffect(MobEffects.SPEED);
      int var3 = var2 ? var1.getEffect(MobEffects.SPEED).getAmplifier() : 0;
      boolean var4 = var1.hasEffect(MobEffects.SLOWNESS);
      int var5 = var4 ? var1.getEffect(MobEffects.SLOWNESS).getAmplifier() : 0;
      return method06005(var2, var3, var4, var5);
   }

   private double[] method06029(Vec3 var1, Vec3 var2, Vec3 var3, Vec3 var4, float var5) {
      Vec3 var6 = var3.subtract(var4);
      double var7 = var5 * var5;
      double var9 = field13655;
      double var11 = var1.distanceTo(var2) / var5;
      float var13 = 0.0F;
      float var14 = 0.0F;

      for (int var15 = 0; var15 < 6; var15++) {
         Vec3 var16 = var2.add(var6.scale(var11));
         Vec3 var17 = var16.subtract(var1);
         double var18 = Math.hypot(var17.x, var17.z);
         double var20 = var7 * var7 - var9 * (var9 * var18 * var18 + field13656 * var17.y * var7);
         if (var20 < 0.0) {
            return null;
         }

         double var22 = Math.sqrt(var20);
         double var24 = Math.atan2(var7 - var22, var9 * var18);
         double var26 = Math.cos(var24);
         if (Math.abs(var26) < field13657) {
            return null;
         }

         var14 = (float)(-Math.toDegrees(var24));
         var13 = (float)(Math.toDegrees(Math.atan2(var17.z, var17.x)) - field13658);
         var11 = var18 / (var5 * var26);
      }

      return new double[]{var13, var14};
   }

   private AimBot.Nested181 method06030(Vec3 var1, Vec3 var2) {
      Rotation var3 = Rotation.method09438(var2.subtract(var1));
      BlockHitResult var4 = mc.level.clip(new ClipContext(var1, var2, Block.COLLIDER, Fluid.NONE, mc.player));
      boolean var5 = var4.getType() != Type.MISS;
      Vec3 var6 = var5 ? var4.getLocation() : var2;
      var var7 = new ArrayList(2);
      var7.add(var1);
      var7.add(var6);
      return new AimBot.Nested181(var7, var6, var3, 0.0F, !var5);
   }

   @Subscribe
   private void method06031(Render3DEvent var1) {
      if (this.method06010()) {
         PoseStack var2 = var1.method00996();
         Camera var3 = mc.getEntityRenderDispatcher().camera;
         Vec3 var4 = var3.position();
         Vec3 var5 = this.field13589 != null && this.field13589.hitPos() != null
            ? this.field13589.hitPos()
            : this.field13587.position().add(0.0, this.field13587.getBbHeight() / 2.0F, 0.0);
         float var6 = field13630;
         float var7 = (float)(-var4.x() + var5.x());
         float var8 = (float)(-var4.y() + var5.y());
         float var9 = (float)(-var4.z() + var5.z());
         CornerColors var10 = new CornerColors(
            ColorUtils.method04627(ColorUtils.Nested138.method04636(), -1, field13631),
            ColorUtils.method04627(ColorUtils.Nested138.method04637(), -1, field13632),
            ColorUtils.method04627(ColorUtils.Nested138.method04638(180), -1, field13633),
            ColorUtils.method04627(ColorUtils.Nested138.method04638(270), -1, field13634)
         );
         short var11 = 5500;
         float var12 = (float)(System.currentTimeMillis() % var11);
         float var13 = var12 / var11 * 2.0F - 1.0F;
         float var15 = var11 / 2.0F;
         float var16 = Math.abs((var12 - var15) / var15);
         float var14 = field13635 * var13 + field13636 * var13 * var16;
         var14 = Math.max(field13637, Math.min(field13638, var14));
         VertexConsumer var17 = var1.method00985().method07407(EffectRenderPipelines.method05532(ClientTextures.INSTANCE.method04570()));
         var2.pushPose();
         var2.translate(var7, var8, var9);
         var2.mulPose(var3.rotation());
         var2.mulPose(Axis.ZP.rotationDegrees(var14));
         Matrix4f var18 = var2.last().pose();
         if (var17 instanceof BaritoneVertexConsumerAccess var19) {
            var19.texturedVertex(var18, -var6, -var6, 0.0F, 0.0F, 0.0F, var10.color1());
            var19.texturedVertex(var18, -var6, var6, 0.0F, 0.0F, 1.0F, var10.color2());
            var19.texturedVertex(var18, var6, var6, 0.0F, 1.0F, 1.0F, var10.color3());
            var19.texturedVertex(var18, var6, -var6, 0.0F, 1.0F, 0.0F, var10.color4());
         }

         var2.popPose();
         if (this.field13589 != null
            && this.field13589.points().size() > 1
            && var1.method00985().method07407(EffectRenderPipelines.method05563()) instanceof BaritoneVertexConsumerAccess var20) {
            Matrix4f var21 = var2.last().pose();
            int var22 = ColorUtils.method04616(ColorUtils.Nested138.method04636(), 200);

            for (int var23 = 0; var23 < this.field13589.points().size() - 1; var23++) {
               Vec3 var24 = this.field13589.points().get(var23);
               Vec3 var25 = this.field13589.points().get(var23 + 1);
               var20.lineVertex(
                  var21, (float)(var24.x - var4.x()), (float)(var24.y - var4.y()), (float)(var24.z - var4.z()), var22, 0.0F, field13639, 0.0F, 2.0F
               );
               var20.lineVertex(
                  var21, (float)(var25.x - var4.x()), (float)(var25.y - var4.y()), (float)(var25.z - var4.z()), var22, 0.0F, field13640, 0.0F, 2.0F
               );
            }
         }
      }
   }

   private void method06032() {
      this.field13587 = null;
      this.field13588.clear();

      for (LivingEntity var2 : mc.level
         .getEntitiesOfClass(LivingEntity.class, mc.player.getBoundingBox().inflate(this.field13578.method03022().intValue()), var0 -> true)) {
         if (this.method06023(var2)) {
            this.field13588.add(var2);
         }
      }

      if (!this.field13588.isEmpty()) {
         Vec3 var5 = mc.player.getEyePosition();
         Rotation var6 = Rotation.method09442();
         this.field13588.method00234(var3x -> this.method06024(var5, var6, var3x));

         for (int var3 = 0; var3 < this.field13588.size(); var3++) {
            LivingEntity var4 = this.field13588.get(var3);
            if (this.method06019(var5, var4)) {
               this.field13587 = var4;
               return;
            }
         }
      }
   }

   private boolean method06033() {
      var var1 = this.field13576.method05598();
      return var1.size() > 1 && this.field13576.method05600((String)var1.get(1));
   }

   @Subscribe
   private void method06034(PlayerUpdateEvent var1) {
      if (mc.player == null || mc.level == null) {
         this.field13587 = null;
         this.field13589 = null;
      } else if (!this.method06012()) {
         this.field13587 = null;
         this.field13589 = null;
         if (this.field13595 > 0) {
            this.field13595--;
         }

         this.method06041();
      } else {
         this.method06032();
         if (this.method06010()) {
            this.field13590.method01268(this.field13587);
            this.field13589 = this.method06002(1.0F);
            if (this.field13589 != null) {
               if (this.method06018()) {
                  this.method06020();
               }

               this.method06013();
            }
         } else {
            this.field13589 = null;
         }

         if (this.field13595 > 0) {
            this.field13595--;
         }

         this.method06041();
      }
   }

   @Override
   public void method00276() {
      this.field13587 = null;
      this.field13589 = null;
      this.field13593 = null;
      this.field13595 = 0;
      this.method06004();
      this.field13591.method04694();
      super.method00276();
   }

   @Subscribe
   private void method06035(FrameUpdateEvent var1) {
      if (mc.player == null || mc.level == null) {
         ;
      }
   }

   private void method06036() {
      int var1 = this.field13582.method03022();
      if (var1 <= 0) {
         this.field13593 = 0;
      } else {
         int var2 = (int)Math.round(this.field13592.nextGaussian() * (var1 / field13678));
         this.field13593 = Mth.clamp(var2, -var1, var1);
      }
   }

   private int method06037(AimBot.Nested183 var1) {
      if (var1 == AimBot.Nested183.BOW && this.field13580.method03022()) {
         int var2 = this.field13581.method03022() + this.method06022();
         return Math.max(0, var2 - mc.player.getTicksUsingItem());
      } else {
         return 0;
      }
   }

   private Vec3 method06038(float var1, float var2) {
      float var3 = var1 * field13667;
      float var4 = var2 * field13668;
      float var5 = Mth.cos(var4);
      float var6 = Mth.sin(var4);
      float var7 = Mth.cos(var3);
      float var8 = Mth.sin(var3);
      return new Vec3(-var8 * var5, -var6, var7 * var5).normalize();
   }

   private AimBot.Nested182 method06039(Vec3 var1, float var2, float var3, float var4, Vec3 var5, Vec3 var6, Vec3 var7) {
      Vec3 var8 = var1;
      Vec3 var9 = this.method06038(var2, var3).scale(var4).add(var5);
      double var10 = field13659;
      Vec3 var12 = null;
      Vec3 var13 = null;
      int var14 = 0;

      for (int var15 = 0; var15 <= 120; var15++) {
         var8 = var8.add(var9);
         var9 = var9.scale(field13660).add(0.0, field13661, 0.0);
         Vec3 var16 = var6.add(var7.scale(var15 + 1));
         double var17 = var8.distanceToSqr(var16);
         if (var17 < var10) {
            var10 = var17;
            var12 = var8;
            var13 = var16;
            var14 = var15 + 1;
         } else if (var12 != null && var17 > var10 * field13662) {
            break;
         }

         if (var8.y < mc.level.getMinY()) {
            break;
         }
      }

      return var12 == null ? null : new AimBot.Nested182(var12, var13, var14);
   }

   private void method06041() {
      if (this.field13596) {
         if (mc.player != null && mc.gameMode != null) {
            ItemStack var1 = mc.player.getMainHandItem();
            boolean var2 = this.field13597 ? this.method06009(var1.getItem()) : var1.getItem() instanceof CrossbowItem && CrossbowItem.isCharged(var1);
            if (!var2) {
               this.method06004();
            } else if (mc.player.tickCount < this.field13598 + 2) {
               if (this.field13589 != null) {
                  this.method06020();
               }
            } else {
               if (this.field13589 != null) {
                  this.method06020();
               }

               this.field13599 = true;
               if (this.field13597) {
                  mc.gameMode.releaseUsingItem(mc.player);
               } else {
                  mc.gameMode.useItem(mc.player, InteractionHand.MAIN_HAND);
               }

               this.field13599 = false;
               this.method06017();
            }
         }
      }
   }

   // $VF: Compiled from s
   private record Nested181(List<Vec3> points, Vec3 hitPos, Rotation rotation, float time, boolean reachable) {
   }

   // $VF: Compiled from s
   private record Nested182(Vec3 arrow, Vec3 target, int ticks) {
   }

   // $VF: Compiled from s
   private enum Nested183 {
      BOW(3.0F),
      CROSSBOW(3.15F),
      TRIDENT(2.5F);

      private final float field13679;

      Nested183(float var3) {
         this.field13679 = var3;
      }
   }
}
