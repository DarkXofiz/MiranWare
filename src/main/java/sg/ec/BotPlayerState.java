// Original binary: sg/ec/f5RENLVDzSJKycNC
package sg.ec;

import com.mojang.authlib.GameProfile;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.network.PacketProcessor;
import net.minecraft.network.protocol.game.ClientGamePacketListener;
import net.minecraft.network.protocol.game.ClientboundContainerSetContentPacket;
import net.minecraft.network.protocol.game.ClientboundContainerSetSlotPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerAbilitiesPacket;
import net.minecraft.network.protocol.game.ClientboundPlayerPositionPacket;
import net.minecraft.network.protocol.game.ClientboundSetCursorItemPacket;
import net.minecraft.network.protocol.game.ClientboundSetEntityDataPacket;
import net.minecraft.network.protocol.game.ClientboundSetExperiencePacket;
import net.minecraft.network.protocol.game.ClientboundSetHealthPacket;
import net.minecraft.network.protocol.game.ClientboundSetHeldSlotPacket;
import net.minecraft.network.protocol.game.ClientboundSetPlayerInventoryPacket;
import net.minecraft.network.syncher.SynchedEntityData.DataValue;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.PositionMoveRotation;
import net.minecraft.world.level.GameType;
import net.minecraft.world.phys.Vec3;
import sg.mx.LocalPlayerMixin_1170;

// $VF: Compiled from s
public final class BotPlayerState {
   private volatile GameProfile field18837;
   private volatile UUID field18838;
   private volatile int field18839 = -1;
   private volatile double field18840;
   private volatile double field18841;
   private volatile double field18842;
   private volatile float field18843;
   private volatile float field18844;
   private volatile boolean field18845;
   private volatile boolean field18846;
   private volatile float field18847;
   private volatile int field18848;
   private volatile float field18849;
   private volatile int field18850;
   private volatile float field18851;
   private volatile int field18852;
   private volatile int field18853;
   private volatile boolean field18854;
   private volatile boolean field18855;
   private volatile boolean field18856;
   private volatile boolean field18857;
   private volatile boolean field18858;
   private volatile boolean field18859;
   private final BotInputState field18860;
   private volatile double field18861;
   private volatile double field18862;
   private volatile double field18863;
   private volatile double field18864;
   private volatile double field18865;
   private volatile double field18866;
   private volatile float field18867;
   private volatile float field18868;
   private volatile boolean field18869;
   private volatile boolean field18870;
   private volatile int field18871;
   private volatile boolean field18872;
   private volatile boolean field18873;
   private volatile GameType field18874;
   private volatile ClientboundPlayerAbilitiesPacket field18875;
   private volatile ClientboundSetHealthPacket field18876;
   private volatile ClientboundSetExperiencePacket field18877;
   private volatile ClientboundSetHeldSlotPacket field18878;
   private volatile ClientboundContainerSetContentPacket field18879;
   private volatile int field18880;
   private final Map<Integer, ClientboundContainerSetSlotPacket> field18881;
   private final Map<Integer, ClientboundSetPlayerInventoryPacket> field18882;
   private volatile ClientboundSetCursorItemPacket field18883;
   private volatile List<DataValue<?>> field18884;
   private volatile boolean field18885;
   private volatile Object field18886;
   private static final float field18887 = 20.0F;
   private static final float field18888 = 20.0F;
   private static final float field18889 = -90.0F;
   private static final float field18890 = -90.0F;
   private static final float field18891 = 90.0F;
   private static final float field18892 = 90.0F;
   private static final float field18893 = -90.0F;
   private static final float field18894 = 90.0F;

   public boolean method07943() {
      return this.field18856;
   }

   public List<DataValue<?>> method07944(Object var1) {
      var var2 = this.field18884;
      if (var2 != null && (var1 != this.field18886 || this.field18885)) {
         this.field18886 = var1;
         this.field18885 = false;
         return var2;
      } else {
         return null;
      }
   }

   public float method07945() {
      return this.field18849;
   }

   public BotPlayerState() {
      this.field18847 = field18887;
      this.field18848 = 20;
      this.field18857 = true;
      this.field18860 = new BotInputState();
      this.field18869 = true;
      this.field18874 = GameType.SURVIVAL;
      this.field18881 = new LinkedHashMap<>();
      this.field18882 = new LinkedHashMap<>();
   }

   public int method07946() {
      return this.field18880;
   }

   public double method07947() {
      return this.field18862;
   }

   public double method07948() {
      return this.field18863;
   }

   public int method07949() {
      return this.field18871;
   }

   public GameType method07950() {
      return this.field18874;
   }

   public float method07951() {
      return this.field18847;
   }

   public boolean method07952() {
      return this.field18885;
   }

   public void method07953(boolean var1) {
      this.field18859 = var1;
   }

   public int method07954() {
      return this.field18848;
   }

   public ClientboundContainerSetContentPacket method07955() {
      return this.field18879;
   }

   public void method07956(int var1) {
      this.field18839 = var1;
   }

   public void method07957(PacketProcessor var1, ClientGamePacketListener var2) {
      BotWorldState.method07800(var1, var2, this.field18875);
      BotWorldState.method07800(var1, var2, this.field18876);
      BotWorldState.method07800(var1, var2, this.field18877);
      BotWorldState.method07800(var1, var2, this.field18878);
      BotWorldState.method07800(var1, var2, this.field18879);
      synchronized (this.field18881) {
         for (ClientboundContainerSetSlotPacket var5 : this.field18881.values()) {
            BotWorldState.method07800(var1, var2, var5);
         }

         for (ClientboundSetPlayerInventoryPacket var10 : this.field18882.values()) {
            BotWorldState.method07800(var1, var2, var10);
         }
      }

      BotWorldState.method07800(var1, var2, this.field18883);
      var var8 = this.field18884;
      if (var8 != null && !var8.isEmpty() && this.field18839 >= 0) {
         BotWorldState.method07800(var1, var2, new ClientboundSetEntityDataPacket(this.field18839, var8));
      }
   }

   public BotInputState method07958() {
      return this.field18860;
   }

   public void method07959(UUID var1) {
      this.field18838 = var1;
   }

   public ClientboundSetHeldSlotPacket method07960() {
      return this.field18878;
   }

   public ClientboundPlayerAbilitiesPacket method07961() {
      return this.field18875;
   }

   public List<DataValue<?>> method07962() {
      return this.field18884;
   }

   public ClientboundPlayerPositionPacket method07963() {
      return new ClientboundPlayerPositionPacket(this.field18853, this.method08027(), Set.of());
   }

   public List<ClientboundContainerSetSlotPacket> method07964() {
      synchronized (this.field18881) {
         return new ArrayList<>(this.field18881.values());
      }
   }

   public int method07965() {
      return this.field18839;
   }

   public void method07966(GameType var1) {
      this.field18874 = var1;
   }

   public Object method07967() {
      return this.field18886;
   }

   public void method07968(ClientboundSetHealthPacket var1) {
      this.field18876 = var1;
      this.field18847 = var1.getHealth();
      this.field18848 = var1.getFood();
      this.field18849 = var1.getSaturation();
      this.field18857 = true;
   }

   public boolean method07969() {
      return this.field18873;
   }

   public ClientboundSetCursorItemPacket method07970() {
      return this.field18883;
   }

   public boolean method07971() {
      boolean var1 = this.field18855;
      this.field18855 = false;
      return var1;
   }

   public void method07972(ClientboundContainerSetContentPacket var1) {
      if (var1.containerId() == 0) {
         this.field18879 = var1;
         this.field18880 = var1.stateId();
         this.field18857 = true;
         synchronized (this.field18881) {
            this.field18881.clear();
            this.field18882.clear();
         }
      }
   }

   public void method07973(ClientboundSetCursorItemPacket var1) {
      this.field18883 = var1;
   }

   public int method07974() {
      return this.field18850;
   }

   public void method07975(List<DataValue<?>> var1) {
      this.field18884 = var1;
      this.field18885 = true;
   }

   public float method07976() {
      return this.field18868;
   }

   public void method07977(double var1, double var3, double var5, double var7, double var9, double var11, boolean var13, boolean var14) {
      this.field18840 = var1;
      this.field18841 = var3;
      this.field18842 = var5;
      this.field18861 = var7;
      this.field18862 = var9;
      this.field18863 = var11;
      this.field18845 = var13;
      this.field18846 = var14;
   }

   public boolean method07978() {
      return this.field18870;
   }

   public void method07979(int var1) {
      this.field18852 = var1;
      this.field18857 = true;
   }

   public void method07980() {
      this.field18839 = -1;
      this.field18840 = 0.0;
      this.field18841 = 0.0;
      this.field18842 = 0.0;
      this.field18843 = 0.0F;
      this.field18844 = 0.0F;
      this.field18845 = false;
      this.field18846 = false;
      this.field18847 = field18888;
      this.field18848 = 20;
      this.field18849 = 0.0F;
      this.field18850 = 0;
      this.field18851 = 0.0F;
      this.field18852 = 0;
      this.field18853 = 0;
      this.field18854 = false;
      this.field18855 = true;
      this.field18861 = 0.0;
      this.field18862 = 0.0;
      this.field18863 = 0.0;
      this.field18864 = 0.0;
      this.field18865 = 0.0;
      this.field18866 = 0.0;
      this.field18867 = 0.0F;
      this.field18868 = 0.0F;
      this.field18869 = true;
      this.field18870 = false;
      this.field18871 = 0;
      this.field18872 = false;
      this.field18873 = false;
      this.field18874 = GameType.SURVIVAL;
      this.field18875 = null;
      this.field18876 = null;
      this.field18877 = null;
      this.field18878 = null;
      this.field18879 = null;
      this.field18880 = 0;
      this.field18883 = null;
      synchronized (this.field18881) {
         this.field18881.clear();
         this.field18882.clear();
      }

      this.field18884 = null;
      this.field18885 = false;
      this.field18886 = null;
   }

   public double method07981() {
      return this.field18841;
   }

   public void method07982(ClientboundSetHeldSlotPacket var1) {
      this.field18878 = var1;
      this.field18852 = var1.slot();
      this.field18857 = true;
   }

   public void method07983(float var1, boolean var2, float var3, boolean var4) {
      this.field18843 = var2 ? this.field18843 + var1 : var1;
      this.field18844 = Mth.clamp(var4 ? this.field18844 + var3 : var3, field18893, field18894);
      this.field18856 = true;
   }

   public void method07984(boolean var1) {
      this.field18858 = var1;
   }

   public void method07985(ClientboundSetExperiencePacket var1) {
      this.field18877 = var1;
      this.field18850 = var1.getExperienceLevel();
      this.field18851 = var1.getExperienceProgress();
   }

   public boolean method07986() {
      return this.field18846;
   }

   public int method07987() {
      return this.field18852;
   }

   public boolean method07988() {
      return this.field18854;
   }

   public ClientboundSetExperiencePacket method07989() {
      return this.field18877;
   }

   public boolean method07990() {
      return this.field18857;
   }

   public boolean method07991() {
      return this.field18845;
   }

   public float method07992() {
      return this.field18867;
   }

   public void method07993(float var1, float var2) {
      this.field18843 = var1;
      this.field18844 = var2 < field18889 ? field18890 : (var2 > field18891 ? field18892 : var2);
      this.field18856 = true;
   }

   public double method07994() {
      return this.field18861;
   }

   public boolean method07995() {
      return this.field18872;
   }

   public boolean method07996() {
      boolean var1 = this.field18856;
      this.field18856 = false;
      return var1;
   }

   public boolean method07997() {
      return this.field18869;
   }

   public void method07998(double var1, double var3, double var5) {
      this.field18861 = var1;
      this.field18862 = var3;
      this.field18863 = var5;
      this.field18855 = true;
   }

   public boolean method07999() {
      return this.field18855;
   }

   public void method08000(PositionMoveRotation var1, int var2) {
      this.field18853 = var2;
      this.method08026(var1);
      this.field18854 = true;
   }

   public UUID method08001() {
      return this.field18838;
   }

   public void method08002(ClientboundContainerSetSlotPacket var1) {
      if (var1.getContainerId() == 0) {
         synchronized (this.field18881) {
            this.field18881.put(var1.getSlot(), var1);
         }

         this.field18880 = var1.getStateId();
         this.field18857 = true;
      }
   }

   public float method08003() {
      return this.field18844;
   }

   public double method08004() {
      return this.field18842;
   }

   public Map<Integer, ClientboundSetPlayerInventoryPacket> method08005() {
      return this.field18882;
   }

   public double method08006() {
      return this.field18840;
   }

   public List<ClientboundSetPlayerInventoryPacket> method08007() {
      synchronized (this.field18881) {
         return new ArrayList<>(this.field18882.values());
      }
   }

   public float method08008() {
      return this.field18843;
   }

   public float method08009() {
      return this.field18851;
   }

   public void method08010(ClientboundPlayerAbilitiesPacket var1) {
      this.field18875 = var1;
      this.field18857 = true;
   }

   public boolean method08011() {
      boolean var1 = this.field18857;
      this.field18857 = false;
      return var1;
   }

   public GameProfile method08012() {
      return this.field18837;
   }

   public ClientboundSetHealthPacket method08013() {
      return this.field18876;
   }

   public void method08014() {
      this.field18857 = true;
   }

   public void method08015(GameProfile var1) {
      this.field18837 = var1;
   }

   public void method08016(float var1, float var2) {
      this.field18843 = var1;
      this.field18844 = var2;
   }

   public double method08017() {
      return this.field18865;
   }

   public double method08018() {
      return this.field18864;
   }

   public void method08019(LocalPlayer var1, GameType var2) {
      this.field18854 = true;
      this.field18855 = true;
      this.field18839 = var1.getId();
      this.field18840 = var1.getX();
      this.field18841 = var1.getY();
      this.field18842 = var1.getZ();
      this.field18843 = var1.getYRot();
      this.field18844 = var1.getXRot();
      this.field18845 = var1.onGround();
      this.field18846 = var1.horizontalCollision;
      this.field18861 = var1.getDeltaMovement().x;
      this.field18862 = var1.getDeltaMovement().y;
      this.field18863 = var1.getDeltaMovement().z;
      this.field18853 = 0;
      LocalPlayerMixin_1170 var3 = (LocalPlayerMixin_1170)(Object)var1;
      this.field18864 = var3.lastX();
      this.field18865 = var3.lastY();
      this.field18866 = var3.lastZ();
      this.field18867 = var3.lastYRot();
      this.field18868 = var3.lastXRot();
      this.field18869 = var3.lastOnGround();
      this.field18870 = var3.lastHorizontalCollision();
      this.field18871 = var3.positionReminder();
      this.field18873 = var3.wasSprinting();
      this.field18872 = true;
      this.field18874 = var2;
      this.field18847 = var1.getHealth();
      this.field18848 = var1.getFoodData().getFoodLevel();
      this.field18849 = var1.getFoodData().getSaturationLevel();
      this.field18850 = var1.experienceLevel;
      this.field18851 = var1.experienceProgress;
      this.field18852 = var1.getInventory().getSelectedSlot();
      this.field18876 = new ClientboundSetHealthPacket(this.field18847, this.field18848, this.field18849);
      this.field18877 = new ClientboundSetExperiencePacket(this.field18851, var1.totalExperience, this.field18850);
      this.field18878 = new ClientboundSetHeldSlotPacket(this.field18852);
      this.field18875 = new ClientboundPlayerAbilitiesPacket(var1.getAbilities());
      this.field18880 = var1.inventoryMenu.getStateId();
      this.field18879 = new ClientboundContainerSetContentPacket(
         0, var1.inventoryMenu.getStateId(), var1.inventoryMenu.getItems(), var1.inventoryMenu.getCarried()
      );
      this.field18883 = new ClientboundSetCursorItemPacket(var1.inventoryMenu.getCarried().copy());
      this.field18857 = true;
      var var4 = var1.getEntityData().getNonDefaultValues();
      if (var4 != null && !var4.isEmpty()) {
         this.method07975(var4);
      }

      synchronized (this.field18881) {
         this.field18881.clear();
         this.field18882.clear();
      }
   }

   public double method08020() {
      return this.field18866;
   }

   public boolean method08021() {
      return this.field18859;
   }

   public void method08022(ClientboundSetPlayerInventoryPacket var1) {
      synchronized (this.field18881) {
         this.field18882.put(var1.slot(), var1);
      }

      this.field18857 = true;
   }

   public Map<Integer, ClientboundContainerSetSlotPacket> method08023() {
      return this.field18881;
   }

   public int method08024() {
      return this.field18853;
   }

   public boolean method08025() {
      return this.field18858;
   }

   public void method08026(PositionMoveRotation var1) {
      this.field18855 = true;
      this.field18840 = var1.position().x;
      this.field18841 = var1.position().y;
      this.field18842 = var1.position().z;
      this.field18843 = var1.yRot();
      this.field18844 = var1.xRot();
      this.field18861 = var1.deltaMovement().x;
      this.field18862 = var1.deltaMovement().y;
      this.field18863 = var1.deltaMovement().z;
   }

   public PositionMoveRotation method08027() {
      return new PositionMoveRotation(
         new Vec3(this.field18840, this.field18841, this.field18842),
         new Vec3(this.field18861, this.field18862, this.field18863),
         this.field18843,
         this.field18844
      );
   }
}
