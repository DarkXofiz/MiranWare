// Original binary: sg/ec/h8xOvKVHoPiCOZtC
package sg.ec;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Holder;
import net.minecraft.core.NonNullList;
import net.minecraft.core.BlockPos.MutableBlockPos;
import net.minecraft.network.protocol.game.ClientboundAddEntityPacket;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetContentPacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.network.protocol.game.ClientboundDamageEventPacket;
import net.minecraft.network.protocol.game.ClientboundSetHealthPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.attribute.EnvironmentAttributes;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.item.PrimedTnt;
import net.minecraft.world.entity.vehicle.minecart.MinecartTNT;
import net.minecraft.world.inventory.ClickType;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RespawnAnchorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class AutoTotem extends ClientModule {
   private static final String field19713 = "Золотые сердца";
   private static final String field19714 = "field19714";
   private static final String field19715 = "field19715";
   private static final String field19716 = "field19716";
   private static final String field19717 = "field19717";
   private static final String field19718 = "field19718";
   private static final String field19719 = "field19719";
   private static final int field19720 = 0;
   private static final float field19721 = 0;
   private static final float field19722 = 0;
   private static final int field19723 = 0;
   private static final int field19724 = 0;
   private static final int field19725 = 0;
   private static final int field19726 = 0;
   private static final int field19727 = 0;
   private static final int field19728 = 0;
   private static final int field19729 = 0;
   private static final int field19730 = 0;
   private static final int field19731 = 0;
   private final MultiToggleSetting field19732;
   private final NumberSetting<Float> field19733;
   private final NumberSetting<Float> field19734;
   private final ToggleSetting field19735;
   private final NumberSetting<Integer> field19736;
   private final ToggleSetting field19737;
   private final NumberSetting<Float> field19738;
   private final ToggleSetting field19739;
   private final ToggleSetting field19740;
   private final NumberSetting<Float> field19741;
   private final NumberSetting<Float> field19742;
   private final NumberSetting<Float> field19743;
   private final NumberSetting<Float> field19744;
   private final BlockingQueue<AutoTotem.Nested240> field19745;
   private final MutableBlockPos field19746;
   private ItemStack field19747;
   private int field19748;
   private int field19749;
   private int field19750;
   private int field19751;
   private int field19752;
   private boolean field19753;
   private volatile int field19754;
   private volatile long field19755;
   private volatile ItemStack field19756;
   private int field19757;
   private InventoryActionSequence field19758;
   private boolean field19759;
   private int field19760;
   private boolean field19761;
   private volatile float field19762;
   private volatile boolean field19763;
   private static final String field19764 = "Проверки на";
   private static final String field19765 = "Золотые сердца";
   private static final String field19766 = "Кристаллы";
   private static final String field19767 = "Якорь";
   private static final String field19768 = "Обсидиан";
   private static final String field19769 = "Падение";
   private static final String field19770 = "Обычный тнт";
   private static final String field19771 = "Вагонетка с тнт";
   private static final String field19772 = "Уровень здоровья";
   private static final float field19773 = 20.0F;
   private static final float field19774 = 0.5F;
   private static final float field19775 = 4.0F;
   private static final String field19776 = "Здоровье на элитре";
   private static final float field19777 = 20.0F;
   private static final float field19778 = 0.5F;
   private static final float field19779 = 10.0F;
   private static final String field19780 = "Возвращать предмет";
   private static final String field19781 = "Скорость Обратного свапа";
   private static final String field19782 = "Не менять шар";
   private static final String field19783 = "Ур. здоровья с шаром";
   private static final float field19784 = 20.0F;
   private static final float field19785 = 0.5F;
   private static final float field19786 = 12.0F;
   private static final String field19787 = "Отменять использование предмета";
   private static final String field19788 = "Сохранять зачарованный";
   private static final String field19789 = "Дистанция от кристалла";
   private static final float field19790 = 8.0F;
   private static final float field19791 = 0.5F;
   private static final float field19792 = 8.0F;
   private static final String field19793 = "Дистанция до якоря";
   private static final float field19794 = 10.0F;
   private static final float field19795 = 0.5F;
   private static final float field19796 = 6.0F;
   private static final String field19797 = "Дистанция до вагонетки";
   private static final float field19798 = 10.0F;
   private static final float field19799 = 0.5F;
   private static final float field19800 = 6.0F;
   private static final String field19801 = "Дистанция до тнт";
   private static final float field19802 = 3.0F;
   private static final float field19803 = 50.0F;
   private static final float field19804 = 10.0F;
   private static final float field19805 = Float.MAX_VALUE;
   private static final String field19806 = "Auto Totem";
   private static final String field19807 = "Якорь";
   private static final double field19808 = 0.5;
   private static final double field19809 = 0.5;
   private static final double field19810 = 0.5;
   private static final String field19811 = "Кристаллы";
   private static final String field19812 = "Обычный тнт";
   private static final String field19813 = "Вагонетка с тнт";
   private static final String field19814 = "Вагонетка с тнт";
   private static final String field19815 = "Обычный тнт";
   private static final String field19816 = "Кристаллы";
   private static final String field19817 = "Якорь";
   private static final float field19818 = -1.0F;
   private static final double field19819 = 10.0;
   private static final String field19820 = "Обсидиан";
   private static final double field19821 = 0.03;
   private static final String field19822 = "Падение";
   private static final double field19823 = 10.0;
   private static final String field19824 = "Падение";
   private static final double field19825 = 5.0;
   private static final String field19826 = "Золотые сердца";
   private static final String field19827 = "request";
   private static final String field19828 = "restore";
   private static final float field19829 = Float.MAX_VALUE;
   private static final String field19830 = "Обычный тнт";
   private static final String field19831 = "Вагонетка с тнт";
   private static final String field19832 = "Якорь";
   private static final String field19833 = "Кристаллы";

   private boolean method08630() {
      return mc.screen instanceof AbstractContainerScreen;
   }

   private boolean method08631() {
      float var1 = mc.player.isFallFlying() ? this.field19734.method03022() : this.field19733.method03022();
      return this.method08635() <= var1;
   }

   private boolean method08632() {
      return mc.player.getOffhandItem().getItem() == Items.TOTEM_OF_UNDYING;
   }

   @Subscribe(0)
   private void method08633(TickEvent var1) {
      if (mc.player != null && mc.level != null && mc.player.isAlive()) {
         this.method08678();
         this.method08650();
         this.field19761 = this.method08656() || this.method08644();
         boolean var2 = this.field19763;
         this.field19763 = false;
         if (var2) {
            this.field19750 = 100;
         } else if (this.field19761) {
            this.field19750 = Math.max(this.field19750, 20);
         } else if (this.field19750 > 0) {
            this.field19750--;
         }

         if (this.field19761) {
            this.field19749 = -1;
            if (this.method08632() || this.method08666() || this.method08665()) {
               return;
            }
         }

         if (!this.method08648()) {
            if (this.field19735.method05999()) {
               this.method08638();
            } else {
               this.method08652();
            }
         }
      } else {
         this.method08645();
      }
   }

   private void method08634(int var1) {
      if (this.field19758 != null) {
         this.field19758.method07548(45, var1);
      }

      InventoryUtils.method06137(mc.player.containerMenu.containerId, var1, 40, ClickType.SWAP, mc.player);
   }

   private float method08635() {
      float var1 = Math.min(mc.player.getHealth(), this.field19762);
      if (this.field19732.method04520(field19826) && mc.player.hasEffect(MobEffects.ABSORPTION)) {
         var1 += mc.player.getAbsorptionAmount();
      }

      return var1;
   }

   private void method08636() {
      if (mc.player != null && !this.method08632()) {
         Slot var1 = this.method08662();
         if (var1 != null) {
            this.method08634(var1.index);
            this.method08669(var1.index);
         }
      }
   }

   private void method08637() {
      if (mc.player != null
         && !this.field19761
         && this.field19745.isEmpty()
         && !this.field19747.isEmpty()
         && !this.method08676()
         && !this.method08641()
         && !this.method08630()) {
         int var1 = this.method08674();
         if (var1 != -1) {
            this.field19752++;
            this.method08634(var1);
            this.field19757 = var1;
            this.field19753 = true;
         }
      }
   }

   private void method08638() {
      if (!this.field19747.isEmpty() && !this.method08630()) {
         if (this.field19753) {
            this.field19753 = false;
            if (!this.method08667()) {
               this.method08652();
               return;
            }
         }

         if (this.method08676()) {
            this.method08652();
         } else if (!this.method08641() && this.method08649()) {
            this.field19751 = 0;
            if (this.method08674() != -1 && this.field19750 <= 0) {
               if (this.field19749 < 0) {
                  this.field19749 = Math.max(0, 10 - this.field19736.method03022());
               }

               if (this.field19749 > 0) {
                  this.field19749--;
               } else {
                  this.field19749 = Math.min(100, 2 << Math.min(this.field19752, 6));
                  this.method08663(InventoryActionManager.INSTANCE.method10471(this::method08637, 1, this.method08673()).method07543(), false);
                  if (false) {
                     ;
                  }
               }
            }
         } else {
            if (++this.field19751 > 20) {
               this.method08652();
            }
         }
      }
   }

   private boolean method08640() {
      if (!this.field19732.method04520(field19820)) {
         return false;
      }

      AABB var1 = mc.player.getBoundingBox();
      int var2 = Mth.floor(var1.minY - field19821);

      for (int var3 = Mth.floor(var1.minX); var3 <= Mth.floor(var1.maxX); var3++) {
         for (int var4 = Mth.floor(var1.minZ); var4 <= Mth.floor(var1.maxZ); var4++) {
            for (int var5 = var2; var5 > var2 - 2; var5--) {
               if (mc.level.getBlockState(this.field19746.set(var3, var5, var4)).is(Blocks.OBSIDIAN)) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   private boolean method08641() {
      ItemStack var1 = mc.player.getOffhandItem();
      return !var1.isEmpty() && var1.getItem() != Items.TOTEM_OF_UNDYING;
   }

   private boolean method08642() {
      if (!this.field19732.method04520(field19817)) {
         return false;
      }

      float var1 = this.field19742.method03022();
      double var2 = var1 * var1;
      int var4 = Mth.ceil(var1);
      Vec3 var5 = mc.player.getEyePosition();
      AABB var6 = mc.player.getBoundingBox();
      BlockPos var7 = mc.player.blockPosition();

      for (int var8 = -var4; var8 <= var4; var8++) {
         for (int var9 = -var4; var9 <= var4; var9++) {
            for (int var10 = -var4; var10 <= var4; var10++) {
               MutableBlockPos var11 = this.field19746.set(var7.getX() + var8, var7.getY() + var9, var7.getZ() + var10);
               BlockState var12 = mc.level.getBlockState(var11);
               if (var12.is(Blocks.RESPAWN_ANCHOR)
                  && var12.getValue(RespawnAnchorBlock.CHARGE) != 0
                  && !(ExplosionDamageUtils.method04381(var5, var11) > var2)
                  && this.method08658(var11)
                  && ExplosionDamageUtils.method04416(Vec3.atCenterOf(var11), mc.player, var6, field19818, field19819) > 0.0F) {
                  return true;
               }
            }
         }
      }

      return false;
   }

   public static boolean method08643() {
      AutoTotem var0 = ModuleManager.INSTANCE.method08227();
      return var0 != null && var0.method08668();
   }

   private boolean method08644() {
      return this.method08646()
         ? this.method08631()
         : this.method08631()
            || this.method08647()
            || this.method08642()
            || this.method08640()
            || this.field19732.method04520(field19814) && WorldCollisionUtils.method02826(MinecartTNT.class, this.field19743.method03022().floatValue())
            || this.field19732.method04520(field19815) && WorldCollisionUtils.method02826(PrimedTnt.class, this.field19744.method03022().floatValue())
            || this.method08675();
   }

   private void method08645() {
      this.field19758 = null;
      this.field19759 = false;
      this.field19760 = 0;
      this.field19761 = false;
      this.field19762 = field19829;
      this.field19763 = false;
      this.field19754 = -1;
      this.field19755 = 0L;
      this.field19756 = null;
      this.field19757 = -1;
      this.field19745.clear();
      this.method08652();
   }

   private boolean method08646() {
      if (!this.field19737.method05999() || mc.player.getOffhandItem().getItem() != Items.PLAYER_HEAD) {
         return false;
      } else {
         return this.field19732.method04520(field19824) && mc.player.fallDistance > field19825 ? false : this.method08635() > this.field19738.method03022();
      }
   }

   private boolean method08647() {
      return this.field19732.method04520(field19816) && WorldCollisionUtils.method02826(EndCrystal.class, this.field19741.method03022().floatValue());
   }

   public AutoTotem() {
      super(ModuleCategory.Combat, ModuleSubCategory.Other);
      this.field19732 = new MultiToggleSetting(field19764)
         .method04517(NamedOption.method08077(field19765, true))
         .method04517(NamedOption.method08077(field19766, true))
         .method04517(NamedOption.method08077(field19767, true))
         .method04517(NamedOption.method08077(field19768, false))
         .method04517(NamedOption.method08077(field19769, false))
         .method04517(NamedOption.method08077(field19770, false))
         .method04517(NamedOption.method08077(field19771, false))
         .method03023(this);
      this.field19733 = new NumberSetting<Float>(field19772)
         .method10835(1.0F)
         .method10838(field19773)
         .method10834(field19774)
         .method03017(field19775)
         .method03023(this);
      this.field19734 = new NumberSetting<Float>(field19776)
         .method10835(1.0F)
         .method10838(field19777)
         .method10834(field19778)
         .method03017(field19779)
         .method03023(this);
      this.field19735 = new ToggleSetting(field19780).method03017(false).method03023(this);
      this.field19736 = new NumberSetting<Integer>(field19781)
         .method10835(1)
         .method10838(10)
         .method10834(1)
         .method03017(6)
         .method03025(this.field19735::method05999)
         .method03023(this);
      this.field19737 = new ToggleSetting(field19782).method03017(false).method03023(this);
      this.field19738 = new NumberSetting<Float>(field19783)
         .method10835(1.0F)
         .method10838(field19784)
         .method10834(field19785)
         .method03017(field19786)
         .method03025(this.field19737::method05999)
         .method03023(this);
      this.field19739 = new ToggleSetting(field19787).method03017(false).method03023(this);
      this.field19740 = new ToggleSetting(field19788).method03017(false).method03023(this);
      this.field19741 = new NumberSetting<Float>(field19789)
         .method10835(1.0F)
         .method10838(field19790)
         .method10834(field19791)
         .method03017(field19792)
         .method03025(() -> this.field19732.method04520(field19833))
         .method03023(this);
      this.field19742 = new NumberSetting<Float>(field19793)
         .method10835(1.0F)
         .method10838(field19794)
         .method10834(field19795)
         .method03017(field19796)
         .method03025(() -> this.field19732.method04520(field19832))
         .method03023(this);
      this.field19743 = new NumberSetting<Float>(field19797)
         .method10835(1.0F)
         .method10838(field19798)
         .method10834(field19799)
         .method03017(field19800)
         .method03025(() -> this.field19732.method04520(field19831))
         .method03023(this);
      this.field19744 = new NumberSetting<Float>(field19801)
         .method10835(field19802)
         .method10838(field19803)
         .method10834(1.0F)
         .method03017(field19804)
         .method03025(() -> this.field19732.method04520(field19830))
         .method03023(this);
      Object var10001 = null;
      this.field19745 = new ArrayBlockingQueue<>(32);
      this.field19746 = new MutableBlockPos();
      this.field19747 = ItemStack.EMPTY;
      this.field19748 = -1;
      this.field19749 = -1;
      this.field19754 = -1;
      this.field19757 = -1;
      this.field19762 = field19805;
      this.method03935(field19806);
   }

   private boolean method08648() {
      return this.field19758 != null && this.field19758.method07549() && this.field19760 <= 20;
   }

   private boolean method08649() {
      return this.method08670(false, true) != -1;
   }

   private void method08650() {
      if (this.field19755 != 0L) {
         if (System.currentTimeMillis() > this.field19755) {
            this.field19755 = 0L;
            this.field19754 = -1;
            this.field19756 = null;
         } else {
            ItemStack var1 = this.field19756;
            if (var1 != null) {
               this.field19756 = null;
               this.method08657(var1);
            }
         }
      }
   }

   @Subscribe(0)
   private void method08651(PacketEvent var1) {
      if (var1.method10904()) {
         if (var1.method10897() instanceof ClientboundSetHealthPacket var8) {
            this.field19762 = var8.getHealth();
         } else if (var1.method10897() instanceof ClientboundDamageEventPacket var7) {
            if (mc.player != null && var7.entityId() == mc.player.getId() && method08655(var7.sourceType())) {
               this.field19763 = true;
            }
         } else if (var1.method10897() instanceof ClientboundContainerSetContentPacket var6) {
            if (var6.containerId() == 0 && this.field19754 >= 0 && this.field19754 < var6.items().size()) {
               this.method08664(var6.items().get(this.field19754));
            }
         } else if (var1.method10897() instanceof ClientboundContainerSetSlotPacket var5) {
            if (var5.getContainerId() == 0 && var5.getSlot() == this.field19754) {
               this.method08664(var5.getItem());
            }
         } else if (var1.method10897() instanceof ClientboundBlockUpdatePacket var4) {
            BlockPos var15 = var4.getPos();
            if (this.field19732.method04520(field19807) && var4.getBlockState().is(Blocks.RESPAWN_ANCHOR) && this.method08658(var15)) {
               this.field19745
                  .offer(
                     new AutoTotem.Nested240(
                        var15.getX() + field19808, var15.getY() + field19809, var15.getZ() + field19810, this.field19742.method03022()
                     )
                  );
            }
         } else if (var1.method10897() instanceof ClientboundAddEntityPacket var2) {
            float var14 = this.method08653(var2.getType());
            if (var14 > 0.0F) {
               this.field19745.offer(new AutoTotem.Nested240(var2.getX(), var2.getY(), var2.getZ(), var14));
            }
         }
      }
   }

   private void method08652() {
      this.field19747 = ItemStack.EMPTY;
      this.field19750 = 0;
      this.field19748 = -1;
      this.field19749 = -1;
      this.field19751 = 0;
      this.field19752 = 0;
      this.field19753 = false;
   }

   private float method08653(EntityType<?> var1) {
      if (var1 == EntityType.END_CRYSTAL) {
         return this.field19732.method04520(field19811) ? this.field19741.method03022() : 0.0F;
      } else if (var1 == EntityType.TNT) {
         return this.field19732.method04520(field19812) ? this.field19744.method03022() : 0.0F;
      } else if (var1 == EntityType.TNT_MINECART) {
         return this.field19732.method04520(field19813) ? this.field19743.method03022() : 0.0F;
      } else {
         return 0.0F;
      }
   }

   private boolean method08654(ItemStack var1, boolean var2) {
      return !var1.isEmpty() && var1.getItem() == this.field19747.getItem() ? !var2 || ItemStack.isSameItemSameComponents(var1, this.field19747) : false;
   }

   private static boolean method08655(Holder<DamageType> var0) {
      return var0.is(DamageTypes.EXPLOSION) || var0.is(DamageTypes.PLAYER_EXPLOSION) || var0.is(DamageTypes.BAD_RESPAWN_POINT);
   }

   private boolean method08656() {
      boolean var1 = false;

      AutoTotem.Nested240 var2;
      while ((var2 = this.field19745.poll()) != null) {
         var1 |= mc.player.distanceToSqr(var2.field19834(), var2.field19835(), var2.field19836()) <= var2.range() * var2.range();
      }

      return var1 && !this.method08646();
   }

   private void method08657(ItemStack var1) {
      if (var1.getItem() != Items.TOTEM_OF_UNDYING) {
         if (var1.isEmpty()) {
            if (this.field19748 == this.field19754) {
               this.method08652();
            }
         } else {
            this.field19747 = var1.copy();
            this.field19748 = this.field19754;
            this.field19751 = 0;
            this.field19752 = 0;
            this.field19753 = false;
            this.field19749 = -1;
         }
      }
   }

   private boolean method08658(BlockPos var1) {
      return mc.level != null && !mc.level.environmentAttributes().getValue(EnvironmentAttributes.RESPAWN_ANCHOR_WORKS, var1);
   }

   private boolean method08659(Slot var1) {
      return var1.container == mc.player.getInventory() && var1.getContainerSlot() != 40;
   }

   private Slot method08662() {
      boolean var1 = this.field19740.method05999();
      Slot var2 = null;

      for (Slot var4 : mc.player.containerMenu.slots) {
         if (this.method08659(var4)) {
            ItemStack var5 = var4.getItem();
            if (var5.getItem() == Items.TOTEM_OF_UNDYING) {
               if (!var1 || !InventoryUtils.method06120(var5)) {
                  return var4;
               }

               if (var2 == null) {
                  var2 = var4;
               }
            }
         }
      }

      return var2;
   }

   private void method08663(InventoryActionSequence var1, boolean var2) {
      this.field19758 = var1;
      this.field19759 = var2;
      this.field19760 = 0;
   }

   private void method08664(ItemStack var1) {
      if (System.currentTimeMillis() <= this.field19755 && mc.player != null) {
         NonNullList<Slot> var2 = mc.player.containerMenu.slots;
         int var3 = this.field19754;
         if (var3 >= 0 && var3 < var2.size() && !ItemStack.isSameItem(var1, ((Slot)var2.get(var3)).getItem())) {
            this.field19756 = var1.copy();
         }
      }
   }

   private boolean method08665() {
      Slot var1 = this.method08662();
      if (var1 == null) {
         return false;
      }

      if (this.field19739.method05999() && mc.player.isUsingItem()) {
         mc.gameMode.releaseUsingItem(mc.player);
      }

      this.method08663(InventoryActionManager.INSTANCE.method10472(this::method08636, 1, this.method08673()).method07543().method07535(), true);
      if (false) {
         ;
      }

      return true;
   }

   private boolean method08666() {
      return this.field19759 && this.method08648();
   }

   private boolean method08667() {
      Slot var1 = this.method08671(this.field19757);
      return var1 != null && this.method08654(var1.getItem(), false) && this.method08632();
   }

   public boolean method08668() {
      if (!this.method03937() || mc.player == null || mc.level == null) {
         return false;
      } else {
         return this.method08648() ? true : this.field19761 && !this.method08632() && this.method08662() != null;
      }
   }

   @Override
   public void method00245() {
      this.method08645();
      super.method00245();
   }

   private void method08669(int var1) {
      if (this.field19735.method05999()) {
         this.field19756 = null;
         this.field19754 = var1;
         this.field19755 = System.currentTimeMillis() + InventoryActionManager.INSTANCE.method10498();
         Slot var2 = this.method08671(var1);
         if (var2 != null) {
            this.method08657(var2.getItem());
         }
      }
   }

   private int method08670(boolean var1, boolean var2) {
      int var3 = mc.player.getInventory().getSelectedSlot();

      for (Slot var5 : mc.player.containerMenu.slots) {
         if (this.method08659(var5) && (var2 || var5.getContainerSlot() != var3) && this.method08654(var5.getItem(), var1)) {
            return var5.index;
         }
      }

      return -1;
   }

   private Slot method08671(int var1) {
      if (var1 < 0) {
         return null;
      }

      NonNullList<Slot> var2 = mc.player.containerMenu.slots;
      if (var1 >= var2.size()) {
         return null;
      }

      Slot var3 = (Slot)var2.get(var1);
      return this.method08659(var3) ? var3 : null;
   }

   private boolean method08673() {
      return mc.player.containerMenu == mc.player.inventoryMenu;
   }

   private int method08674() {
      Slot var1 = this.method08671(this.field19748);
      if (var1 != null && this.method08654(var1.getItem(), true)) {
         return this.field19748;
      }

      int var2 = this.method08670(true, false);
      if (var2 == -1) {
         var2 = this.method08670(false, false);
      }

      if (var2 != -1) {
         this.field19748 = var2;
      }

      return var2;
   }

   private boolean method08675() {
      return this.field19732.method04520(field19822) && !mc.player.isInWater() && mc.player.fallDistance > field19823;
   }

   private boolean method08676() {
      return this.method08654(mc.player.getOffhandItem(), false);
   }

   @Subscribe
   private void method08677(WorldLoadEvent var1) {
      this.method08645();
   }

   private void method08678() {
      if (this.field19758 != null) {
         if (!this.field19758.method07549() || ++this.field19760 > 20) {
            this.field19758 = null;
            this.field19760 = 0;
         }
      }
   }

   // $VF: Compiled from s
   private record Nested240(double field19834, double field19835, double field19836, float range) {
   }
}
