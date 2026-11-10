// Original binary: sg/ec/Py7DH0isLQyQxJGZ
package sg.ec;

import java.util.Locale;
import net.minecraft.core.component.DataComponents;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.network.protocol.game.ServerboundSetCarriedItemPacket;
import net.minecraft.network.protocol.game.ServerboundMovePlayerPacket.Rot;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerInput;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.alchemy.PotionContents;
import net.minecraft.world.item.component.CustomData;

// $VF: Compiled from s
public final class AutoBuyPotionController implements MinecraftAccess {
   private static final int field11162 = 60;
   private static final int field11163 = 0;
   private static final int field11164 = 0;
   private static final long field11165 = 0;
   private static final long field11166 = 0;
   private static final long field11167 = 0;
   private static final float field11168 = 0;
   private AutoBuyPotionController.Nested152 field11169 = AutoBuyPotionController.Nested152.IDLE;
   private int field11170 = -1;
   private int field11171 = -1;
   private int field11172 = -1;
   private boolean field11173;
   private boolean field11174;
   private boolean field11175;
   private long field11176;
   private long field11177;
   private long field11178;
   private static final long field11179 = 1000L;
   private static final long field11180 = 150L;
   private static final long field11181 = 150L;
   private static final long field11182 = 150L;
   private static final float field11183 = 90.0F;
   private static final long field11184 = 5000L;
   private static final long field11185 = 150L;
   private static final long field11186 = 150L;
   private static final long field11187 = 1000L;
   private static final long field11188 = 1000L;
   private static final int field11189 = Integer.MIN_VALUE;
   private static final int field11190 = 1000000;
   private static final int field11191 = 100000;
   private static final String field11192 = "custom_potion_effects";
   private static final String field11193 = "custom_potion_effects";
   private static final String field11194 = "id";
   private static final String field11195 = "invisibility";
   private static final String field11196 = "custom_potion_effects";
   private static final String field11197 = "custom_potion_effects";
   private static final String field11198 = "id";
   private static final String field11199 = "invisibility";
   private static final String field11200 = "duration";

   private static int method05103(ItemStack var0) {
      int var1 = 0;
      PotionContents sx = var0.get(DataComponents.POTION_CONTENTS);
      if (sx != null) {
         for (MobEffectInstance sxx : sx.getAllEffects()) {
            if (sxx.is(MobEffects.INVISIBILITY)) {
               var1 = Math.max(var1, sxx.getDuration());
            }
         }
      }

      CustomData sxx = var0.get(DataComponents.CUSTOM_DATA);
      if (sxx != null && sxx.copyTag().contains(field11196)) {
         ListTag sxxx = sxx.copyTag().getListOrEmpty(field11197);

         for (int sxxxx = 0; sxxxx < sxxx.size(); sxxxx++) {
            CompoundTag sxxxxx = sxxx.getCompoundOrEmpty(sxxxx);
            if (sxxxxx.getStringOr(field11198, "").toLowerCase(Locale.ROOT).contains(field11199)) {
               var1 = Math.max(var1, sxxxxx.getIntOr(field11200, 0));
            }
         }
      }

      return var1;
   }

   private void method05104() {
      this.method05128();
      this.field11169 = this.field11173 ? AutoBuyPotionController.Nested152.RESTORE_SWAP : AutoBuyPotionController.Nested152.RESTORE_SLOT;
   }

   private void method05105(long var1) {
      this.field11174 = false;
      this.method05104();
      this.field11178 = var1 + field11188;
   }

   private static boolean method05106(ItemStack var0) {
      if (var0 == null || var0.isEmpty()) {
         return false;
      }

      if (!var0.is(Items.POTION) && !var0.is(Items.SPLASH_POTION) && !var0.is(Items.LINGERING_POTION)) {
         return false;
      }

      boolean var1 = false;
      PotionContents var2 = var0.get(DataComponents.POTION_CONTENTS);
      if (var2 != null) {
         for (MobEffectInstance var4 : var2.getAllEffects()) {
            if (!var4.is(MobEffects.INVISIBILITY)) {
               return false;
            }

            var1 = true;
         }
      }

      CustomData var7 = var0.get(DataComponents.CUSTOM_DATA);
      if (var7 != null && var7.copyTag().contains(field11192)) {
         ListTag var8 = var7.copyTag().getListOrEmpty(field11193);

         for (int var5 = 0; var5 < var8.size(); var5++) {
            String var6 = var8.getCompoundOrEmpty(var5).getStringOr(field11194, "").toLowerCase(Locale.ROOT);
            if (!var6.isBlank()) {
               if (!var6.contains(field11195)) {
                  return false;
               }

               var1 = true;
            }
         }
      }

      return var1;
   }

   private static int method05107(int var0) {
      return method05117(var0) ? 36 + var0 : var0;
   }

   private void method05108(long var1) {
      AbstractContainerMenu var3 = mc.player.containerMenu;
      if (var3 != null && mc.gameMode != null) {
         mc.gameMode.handleContainerInput(var3.containerId, method05107(this.field11170), this.field11171, ContainerInput.SWAP, mc.player);
         this.field11173 = false;
         this.field11176 = var1 + field11185;
         this.field11169 = AutoBuyPotionController.Nested152.WAIT_AFTER_RESTORE;
      } else {
         this.field11169 = AutoBuyPotionController.Nested152.RESTORE_SLOT;
      }
   }

   private void method05109(long var1) {
      switch (this.field11169) {
         case CLOSE_SCREEN:
            this.method05113(var1);
            break;
         case WAIT_AFTER_CLOSE:
            this.method05119(var1, AutoBuyPotionController.Nested152.PREPARE_SLOT);
            break;
         case PREPARE_SLOT:
            this.method05114(var1);
            break;
         case WAIT_AFTER_SWAP:
            this.method05119(var1, AutoBuyPotionController.Nested152.SELECT_SLOT);
            break;
         case SELECT_SLOT:
            this.method05127(var1);
            break;
         case DRINK:
            this.method05129(var1);
            break;
         case WAIT_EFFECT:
            this.method05120(var1);
            break;
         case RESTORE_SWAP:
            this.method05108(var1);
            break;
         case WAIT_AFTER_RESTORE:
            this.method05119(var1, AutoBuyPotionController.Nested152.RESTORE_SLOT);
            break;
         case RESTORE_SLOT:
            this.method05124(var1);
            break;
         case FINISH:
            this.method05110(var1);
      }
   }

   private void method05110(long var1) {
      if (this.field11169 != AutoBuyPotionController.Nested152.FINISH || var1 >= this.field11176) {
         if (!this.field11174) {
            this.field11178 = var1 + field11187;
         }

         this.method05112();
      }
   }

   private void method05111(int var1) {
      this.field11170 = var1;
      this.field11172 = mc.player.getInventory().getSelectedSlot();
      this.field11171 = -1;
      this.field11173 = false;
      this.field11174 = false;
      this.field11169 = AutoBuyPotionController.Nested152.CLOSE_SCREEN;
   }

   public void method05112() {
      this.method05128();
      this.field11169 = AutoBuyPotionController.Nested152.IDLE;
      this.field11170 = -1;
      this.field11171 = -1;
      this.field11172 = -1;
      this.field11173 = false;
      this.field11174 = false;
      this.field11176 = 0L;
      this.field11177 = 0L;
   }

   private void method05113(long var1) {
      if (AuctionContainerUtils.method02624()) {
         AuctionContainerUtils.method02623();
      } else {
         this.field11176 = var1 + field11180;
         this.field11169 = AutoBuyPotionController.Nested152.WAIT_AFTER_CLOSE;
      }
   }

   private void method05114(long var1) {
      Inventory var3 = mc.player.getInventory();
      if (this.field11170 < 0 || !method05106(var3.getItem(this.field11170))) {
         this.field11170 = this.method05123();
      }

      if (this.field11170 < 0) {
         this.method05105(var1);
      } else if (method05117(this.field11170)) {
         this.field11171 = this.field11170;
         this.field11169 = AutoBuyPotionController.Nested152.SELECT_SLOT;
      } else {
         AbstractContainerMenu var4 = mc.player.containerMenu;
         if (var4 != null && mc.gameMode != null) {
            this.field11171 = this.field11172;
            mc.gameMode.handleContainerInput(var4.containerId, method05107(this.field11170), this.field11171, ContainerInput.SWAP, mc.player);
            this.field11173 = true;
            this.field11176 = var1 + field11181;
            this.field11169 = AutoBuyPotionController.Nested152.WAIT_AFTER_SWAP;
         } else {
            this.method05105(var1);
         }
      }
   }

   private void method05115() {
      this.field11175 = true;
      if (mc.options != null) {
         mc.options.keyUse.setDown(true);
      }
   }

   private void method05116(float var1) {
      mc.player.connection.send(new Rot(mc.player.getYRot(), var1, mc.player.onGround(), mc.player.horizontalCollision));
   }

   private static boolean method05117(int var0) {
      return var0 >= 0 && var0 < 9;
   }

   private boolean method05118() {
      MobEffectInstance var1 = mc.player.getEffect(MobEffects.INVISIBILITY);
      return var1 != null && (var1.isInfiniteDuration() || var1.getDuration() > 60);
   }

   private void method05119(long var1, AutoBuyPotionController.Nested152 var3) {
      if (var1 >= this.field11176) {
         this.field11169 = var3;
      }
   }

   private void method05120(long var1) {
      if (this.field11175) {
         mc.options.keyUse.setDown(true);
      }

      if (this.method05118()) {
         this.field11174 = true;
         this.method05104();
      } else {
         if (var1 >= this.field11177) {
            this.method05105(var1);
         }
      }
   }

   private void method05121(int var1) {
      if (method05117(var1) && mc.player.getInventory().getSelectedSlot() != var1) {
         mc.player.getInventory().setSelectedSlot(var1);
         mc.player.connection.send(new ServerboundSetCarriedItemPacket(var1));
      }
   }

   private boolean method05122() {
      MobEffectInstance var1 = mc.player.getEffect(MobEffects.INVISIBILITY);
      return var1 == null || !var1.isInfiniteDuration() && var1.getDuration() <= 60;
   }

   private int method05123() {
      Inventory var1 = mc.player.getInventory();
      int var2 = -1;
      int var3 = field11189;

      for (int var4 = 0; var4 <= 35; var4++) {
         ItemStack var5 = var1.getItem(var4);
         if (method05106(var5)) {
            int var6 = (!var5.is(Items.SPLASH_POTION) && !var5.is(Items.LINGERING_POTION) ? 0 : field11190)
               + (method05117(var4) ? field11191 : 0)
               + method05103(var5);
            if (var6 > var3) {
               var3 = var6;
               var2 = var4;
            }
         }
      }

      return var2;
   }

   private void method05124(long var1) {
      this.method05121(this.field11172);
      this.field11176 = var1 + field11186;
      this.field11169 = AutoBuyPotionController.Nested152.FINISH;
   }

   public boolean method05125() {
      return this.field11169 != AutoBuyPotionController.Nested152.IDLE;
   }

   public void method05126(long var1) {
      if (mc.player != null && mc.player.connection != null) {
         boolean var3 = AutoBuySettings.field19624.method08551() && AutoBuyItemRegistry.INSTANCE.method10998().method06434();
         if (!var3) {
            if (this.field11169 != AutoBuyPotionController.Nested152.IDLE) {
               this.method05110(var1);
            }
         } else {
            if (this.field11169 == AutoBuyPotionController.Nested152.IDLE) {
               if (var1 < this.field11178 || !this.method05122()) {
                  return;
               }

               int var4 = this.method05123();
               if (var4 < 0) {
                  this.field11178 = var1 + field11179;
                  return;
               }

               this.method05111(var4);
            }

            this.method05109(var1);
         }
      } else {
         this.method05112();
      }
   }

   private void method05127(long var1) {
      if (method05117(this.field11171) && method05106(mc.player.getInventory().getItem(this.field11171))) {
         this.method05121(this.field11171);
         this.field11176 = var1 + field11182;
         this.field11169 = AutoBuyPotionController.Nested152.DRINK;
      } else {
         this.method05105(var1);
      }
   }

   private void method05128() {
      if (this.field11175) {
         this.field11175 = false;
         if (mc.options != null) {
            mc.options.keyUse.setDown(false);
         }
      }
   }

   private void method05129(long var1) {
      if (var1 >= this.field11176 && !mc.player.isUsingItem()) {
         ItemStack var3 = mc.player.getInventory().getItem(this.field11171);
         if (method05106(var3) && mc.gameMode != null) {
            boolean var4 = var3.is(Items.SPLASH_POTION) || var3.is(Items.LINGERING_POTION);
            if (var4) {
               this.method05116(field11183);
            } else {
               this.method05115();
            }

            InteractionResult var5 = mc.gameMode.useItem(mc.player, InteractionHand.MAIN_HAND);
            if (var4) {
               this.method05116(mc.player.getXRot());
            }

            if (!var5.consumesAction()) {
               this.method05105(var1);
            } else {
               this.field11177 = var1 + field11184;
               this.field11169 = AutoBuyPotionController.Nested152.WAIT_EFFECT;
            }
         } else {
            this.method05105(var1);
         }
      }
   }

   // $VF: Compiled from s
   private enum Nested152 {
      IDLE,
      CLOSE_SCREEN,
      WAIT_AFTER_CLOSE,
      PREPARE_SLOT,
      WAIT_AFTER_SWAP,
      SELECT_SLOT,
      DRINK,
      WAIT_EFFECT,
      RESTORE_SWAP,
      WAIT_AFTER_RESTORE,
      RESTORE_SLOT,
      FINISH;
   }
}
