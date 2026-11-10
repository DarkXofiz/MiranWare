// Original binary: sg/ec/G3pcYf6IrzK6jXLl
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.multiplayer.MultiPlayerGameMode;
import net.minecraft.client.player.AbstractClientPlayer;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import org.joml.Matrix4f;

// $VF: Compiled from s
public enum ItemAnimationState implements MinecraftAccess {
   INSTANCE;

   public float field07831;
   public float field07832;
   public float field07833;
   public Item field07834 = Items.AIR;
   public Item field07835 = Items.AIR;
   public float field07836;
   public float field07837;
   public boolean field07838;
   public boolean field07839;
   private boolean field07840;
   private boolean field07841;
   public boolean field07842;
   public boolean field07843;
   public final Matrix4f field07844 = new Matrix4f();
   public final Matrix4f field07845 = new Matrix4f();
   public final List<ParticleAnimationConfig> field07846 = new ArrayList<>();
   private final ItemAnimationContext field07847 = new ItemAnimationContext();
   private final ItemAnimationContext field07848 = new ItemAnimationContext();

   ItemAnimationState() {
      this.field07847.field19861 = this.field07846;
      this.field07848.field19861 = this.field07846;
   }

   public ItemAnimationContext method03497(boolean var1) {
      return var1 ? this.field07847 : this.field07848;
   }

   public void method03498() {
      float var1 = (float)InputCompat.time();
      this.field07831 = var1 - this.field07832;
      this.field07832 = var1;
      if (mc.isPaused()) {
         this.field07831 = 0.0F;
      } else {
         this.field07831 = (float)Math.min(0.05, this.field07831);
      }

      LocalPlayer var2 = mc.player;
      boolean var3 = var2 != null && var2.swinging;
      InteractionHand var4 = var2 == null || !var2.swinging ? null : var2.swingingArm;
      boolean var5 = var3 && var4 == InteractionHand.MAIN_HAND;
      boolean var6 = var3 && var4 == InteractionHand.OFF_HAND;
      this.field07838 = var5 && !this.field07840;
      this.field07839 = var6 && !this.field07841;
      this.field07840 = var5;
      this.field07841 = var6;
   }

   public void method03499(
      ItemAnimationContext var1,
      AbstractClientPlayer var2,
      ItemStack var3,
      InteractionHand var4,
      boolean var5,
      boolean var6,
      int var7,
      float var8,
      float var9,
      float var10,
      float var11,
      PoseStack var12,
      SubmitNodeCollector var13,
      int var14
   ) {
      if (var1 != null && var2 != null && var3 != null) {
         var1.field19837 = var2;
         var1.field19838 = var3;
         var1.field19841 = var4;
         var1.field19842 = var5;
         var1.field19843 = var6;
         var1.field19844 = var7;
         var1.field19845 = var8;
         var1.field19846 = var9;
         var1.field19848 = var10;
         var1.field19849 = var11;
         var1.field19839 = var12;
         var1.field19840 = var13;
         var1.field19850 = var14;
         var1.field19847 = this.field07831;
         if (var5) {
            this.field07836 = var8;
         } else {
            this.field07837 = var8;
         }

         var1.field19851 = this.field07836;
         var1.field19852 = this.field07837;
         Item var15 = var3.getItem();
         if (var5) {
            this.field07842 = var15 != this.field07834;
         } else {
            this.field07843 = var15 != this.field07835;
         }

         var1.field19857 = this.field07842;
         var1.field19858 = this.field07843;
         var1.field19853 = this.field07838;
         var1.field19854 = this.field07839;
         var1.field19855 = this.field07838;
         var1.field19856 = this.field07839;
         boolean var16 = var2.isUsingItem();
         var1.field19859 = var16 && var2.getUsedItemHand() == var4;
         MultiPlayerGameMode var17 = mc.gameMode;
         var1.field19860 = var17 != null && var17.isDestroying();
      }
   }

   public void method03500(ItemAnimationContext var1) {
      Item var2 = var1.field19838.getItem();
      if (var1.field19842) {
         this.field07834 = var2;
      } else {
         this.field07835 = var2;
      }
   }
}
