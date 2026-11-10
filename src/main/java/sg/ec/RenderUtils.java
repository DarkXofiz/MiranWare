// Original binary: sg/ec/9MrVH5XG1HrYv8e2
package sg.ec;

import java.util.function.Supplier;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.multiplayer.ClientLevel;
import net.minecraft.client.player.RemotePlayer;
import net.minecraft.client.renderer.entity.EntityRenderer;
import net.minecraft.client.renderer.entity.state.EntityRenderState;
import net.minecraft.client.renderer.entity.state.LivingEntityRenderState;
import net.minecraft.core.HolderGetter;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import org.joml.Matrix3x2f;
import org.joml.Quaternionf;
import org.joml.Vector2f;
import org.joml.Vector3f;

// $VF: Compiled from s
public class RenderUtils implements MinecraftAccess {
   private static final float field05176 = 0.75F;
   private static final float field05177 = 0;
   private static final float field05178 = 0;
   private static final float field05179 = 0;
   private static final float field05180 = 0;
   private static final long field05181 = System.nanoTime();
   private Entity field05182;
   private ClientLevel field05183;
   private int field05184;
   private float field05185;
   private boolean field05186;
   private float field05187;
   private float field05188;
   private float field05189;
   private float field05190;
   private float field05191;
   private float field05192;
   private float field05193;
   private float field05194;
   private float field05195;
   private float field05196;
   private final Quaternionf field05197;
   private final Quaternionf field05198;
   private final Vector3f field05199;
   private EntityRenderState field05200;
   private static final int field05201 = Integer.MIN_VALUE;
   private static final float field05202 = 0.75F;
   private static final float field05203 = 0.9F;
   private static final float field05204 = 0.0625F;
   private static final float field05205 = 0.5F;
   private static final float field05206 = 0.1F;
   private static final float field05207 = (float) Math.PI;
   private static final float field05208 = (float) (Math.PI / 180.0);
   private static final float field05209 = 0.0625F;
   private static final double field05210 = 5.0E7;
   private static final float field05211 = 180.0F;

   public float method02199() {
      return this.field05195;
   }

   private boolean method02200(int var1, Supplier<Entity> var2) {
      if (mc.level != null && mc.player != null) {
         if (this.field05182 == null || this.field05184 != var1 || this.field05183 != mc.level) {
            this.field05183 = mc.level;
            this.field05184 = var1;
            this.field05182 = (Entity)var2.get();
            this.field05200 = null;
         }

         return this.field05182 != null;
      } else {
         this.field05182 = null;
         this.field05183 = null;
         this.field05200 = null;
         return false;
      }
   }

   public float method02201() {
      return this.field05193;
   }

   public boolean method02202(double var1, double var3, int var5) {
      if (var5 == 1 && GuiHitTestUtils.method05609(var1, var3, this.field05188, this.field05189, this.field05190, this.field05191)) {
         this.field05186 = true;
         this.field05187 = (float)var1;
         return true;
      } else {
         return false;
      }
   }

   public void method02203(int var1) {
      if (var1 == 1) {
         this.field05186 = false;
      }
   }

   public float method02204() {
      return this.field05194;
   }

   public Entity method02205() {
      return this.field05182;
   }

   public static RemotePlayer method02206() {
      if (mc.level != null && mc.player != null) {
         RemotePlayer var0 = new RemotePlayer(mc.level, mc.player.getGameProfile());
         var0.setPos(mc.player.getX(), mc.player.getY(), mc.player.getZ());
         method02209(var0);
         return var0;
      } else {
         return null;
      }
   }

   public RenderUtils() {
      this.field05184 = field05201;
      this.field05197 = new Quaternionf();
      this.field05198 = new Quaternionf();
      this.field05199 = new Vector3f();
   }

   private static ItemStack method02207(
      HolderGetter<Enchantment> var0, Item var1, ResourceKey<Enchantment> var2, int var3, ResourceKey<Enchantment> var4, int var5
   ) {
      ItemStack var6 = new ItemStack(var1);
      var6.enchant(var0.getOrThrow(var2), var3);
      var6.enchant(var0.getOrThrow(var4), var5);
      return var6;
   }

   private EntityRenderState method02208() {
      EntityRenderer var1 = mc.getEntityRenderDispatcher().getRenderer(this.field05182);
      EntityRenderState var2 = var1.createRenderState(this.field05182, 1.0F);
      var2.shadowPieces.clear();
      var2.outlineColor = 0;
      var2.nameTag = null;
      var2.scoreText = null;
      var2.ageInTicks = (float)((System.nanoTime() - field05181) / field05210);
      if (var2 instanceof LivingEntityRenderState var3) {
         var3.bodyRot = field05211 + this.field05185;
         var3.yRot = 0.0F;
         var3.xRot = 0.0F;
         var3.boundingBoxWidth = var3.boundingBoxWidth / var3.scale;
         var3.boundingBoxHeight = var3.boundingBoxHeight / var3.scale;
         var3.scale = 1.0F;
      }

      return var2;
   }

   private static void method02209(RemotePlayer var0) {
      if (mc.level != null) {
         Registry var1 = mc.level.registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
         var0.setItemSlot(EquipmentSlot.HEAD, method02207(var1, Items.NETHERITE_HELMET, Enchantments.PROTECTION, 4, Enchantments.UNBREAKING, 3));
         var0.setItemSlot(EquipmentSlot.CHEST, method02207(var1, Items.NETHERITE_CHESTPLATE, Enchantments.PROTECTION, 4, Enchantments.MENDING, 1));
         var0.setItemSlot(EquipmentSlot.LEGS, method02207(var1, Items.NETHERITE_LEGGINGS, Enchantments.PROTECTION, 4, Enchantments.UNBREAKING, 3));
         var0.setItemSlot(EquipmentSlot.FEET, method02207(var1, Items.NETHERITE_BOOTS, Enchantments.FEATHER_FALLING, 4, Enchantments.PROTECTION, 4));
         var0.setItemSlot(EquipmentSlot.MAINHAND, method02207(var1, Items.NETHERITE_SWORD, Enchantments.SHARPNESS, 5, Enchantments.UNBREAKING, 3));
         var0.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(Items.TOTEM_OF_UNDYING));
      }
   }

   public float method02210() {
      return this.field05196;
   }

   private void method02211(float var1) {
      if (this.field05186) {
         this.field05185 = this.field05185 - (var1 - this.field05187) * 2.0F;
         this.field05187 = var1;
      }
   }

   public void method02212(
      GuiGraphicsExtractor var1, int var2, Supplier<Entity> var3, float var4, float var5, float var6, float var7, float var8, float var9, float var10
   ) {
      this.field05188 = var4;
      this.field05189 = var5;
      this.field05190 = var6;
      this.field05191 = var7;
      if (this.method02200(var2, var3)) {
         this.method02211(var8);
         Matrix3x2f var11 = new Matrix3x2f(var1.pose());
         Vector2f var12 = var11.transformPosition(var4, var5, new Vector2f());
         Vector2f var13 = var11.transformPosition(var4 + var6, var5 + var7, new Vector2f());
         float var14 = var7 <= 0.0F ? 1.0F : (var13.y - var12.y) / var7;
         int var15 = Math.round(var12.x);
         int var16 = Math.round(var12.y);
         int var17 = Math.round(var13.x);
         int var18 = Math.round(var13.y);
         this.field05200 = this.method02208();
         float var19 = this.field05200.boundingBoxHeight;
         float var20 = var7 * field05202 * var9 / Math.max(var19, field05203);
         float var21 = var20 * var14;
         this.field05195 = var20;
         this.field05192 = var4 + var6 / 2.0F;
         this.field05194 = var5 + var7 / 2.0F + (var19 / 2.0F + field05204) * var20;
         this.field05193 = this.field05194 - var19 * var20;
         this.field05196 = Math.max(this.field05182.getBbWidth() * field05205, field05206) * var20;
         this.field05197.identity().rotateZ(field05207);
         if (!(this.field05200 instanceof LivingEntityRenderState)) {
            this.field05197.rotateY(this.field05185 * field05208);
         }

         this.field05199.set(0.0F, var19 / 2.0F + field05209, 0.0F);
         var1.entity(this.field05200, var21, this.field05199, this.field05197, this.field05198, var15, var16, var17, var18);
         PictureInPictureRendererHooks.method07563(this.field05200, var10, false);
      }
   }

   public float method02213() {
      return this.field05192;
   }
}
