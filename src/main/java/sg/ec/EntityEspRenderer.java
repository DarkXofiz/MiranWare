// Original binary: sg/ec/rWUj42gPI7wlMOYA
package sg.ec;

import com.google.common.collect.Lists;
import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;
import net.minecraft.client.CameraType;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.core.Holder;
import net.minecraft.network.chat.Component;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.item.enchantment.ItemEnchantments;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;
import org.joml.Vector4f;

// $VF: Compiled from s
public final class EntityEspRenderer implements MinecraftAccess {
   private static final float field23249 = 6.0F;
   private static final float field23250 = 0;
   private static final float field23251 = 0;
   private static final float field23252 = 0;
   private static final float field23253 = 0;
   private static final float field23254 = 0;
   private static final float field23255 = 0;
   private static final float field23256 = 0;
   private static final float field23257 = 0;
   private static final float field23258 = 0;
   private static final int field23259 = ColorUtils.method04597(30, 30, 30, 100);
   private static final int field23260 = ColorUtils.method04597(50, 150, 50, 100);
   private static final String field23261 = ChatColorFormatter.method07520(120, 120, 120);
   private static final String field23262 = ChatColorFormatter.method07520(255, 100, 100);
   private static final String field23263 = field23261 + "[" + field23262;
   private static final String field23264 = field23261 + "]";
   private final Map<Integer, EntityEspRenderer.Nested297> field23265 = new HashMap<>();
   private final List<EntityEspRenderer.Nested297> field23266 = new ArrayList<>();
   private FontRenderer field23267;
   private EntityEspRenderer.Nested298 field23268;
   private final ElapsedTimer field23269 = new ElapsedTimer();
   private final GuiItemAtlasHooks field23270 = new GuiItemAtlasHooks(144);
   private final Vector2f field23271 = new Vector2f();
   private final Vector2f field23272 = new Vector2f();
   private final Vector2f field23273 = new Vector2f();
   private final Vector4f field23274 = new Vector4f();
   private static final String field23275 = "Друзья";
   private static final float field23276 = 2.5F;
   private static final float field23277 = 2.5F;
   private static final long field23278 = 1000L;
   private static final double field23279 = 250.0;
   private static final float field23280 = 0.85F;
   private static final float field23281 = 6.0F;
   private static final float field23282 = 6.0F;
   private static final float field23283 = 24.0F;
   private static final float field23284 = 11.7F;
   private static final float field23285 = 6.0F;
   private static final float field23286 = 0.85F;
   private static final float field23287 = 12.0F;
   private static final float field23288 = 2.5F;
   private static final float field23289 = 4.0F;
   private static final float field23290 = 3.0F;
   private static final float field23291 = 0.75F;
   private static final float field23292 = 6.5F;
   private static final float field23293 = 12.0F;
   private static final float field23294 = 13.0F;
   private static final float field23295 = 1.5F;
   private static final float field23296 = 13.0F;
   private static final float field23297 = 1.5F;
   private static final float field23298 = 7.0F;
   private static final float field23299 = 7.0F;
   private static final float field23300 = 5.5F;
   private static final float field23301 = 5.5F;
   private static final float field23302 = 1.5F;
   private static final float field23303 = -2.0F;
   private static final float field23304 = 3.0F;
   private static final float field23305 = 10.2F;
   private static final float field23306 = 1.5F;
   private static final float field23307 = -2.0F;
   private static final float field23308 = 6.7F;
   private static final float field23309 = -0.05F;
   private static final float field23310 = 11.0F;
   private static final float field23311 = 1.5F;
   private static final float field23312 = 0.5F;
   private static final float field23313 = 6.0F;
   private static final float field23314 = 10.2F;
   private static final float field23315 = 1.5F;
   private static final float field23316 = 1.5F;
   private static final float field23317 = 0.5F;
   private static final float field23318 = 4.0F;
   private static final float field23319 = 6.7F;
   private static final float field23320 = -0.05F;
   private static final float field23321 = Float.MAX_VALUE;
   private static final float field23322 = -Float.MAX_VALUE;
   private static final double field23323 = 0.2;
   private static final double field23324 = 0.1;
   private static final double field23325 = 2.0;
   private static final double field23326 = 2.0;
   private static final double field23327 = 2.0;
   private static final double field23328 = 2.0;
   private static final String field23329 = "hands";
   private static final String field23330 = "hands";
   private static final float field23331 = 6.7F;
   private static final float field23332 = -0.05F;
   private static final float field23333 = 6.7F;
   private static final float field23334 = -0.05F;
   private static final float field23335 = 5.5F;
   private static final float field23336 = 5.5F;
   private static final double field23337 = 0.1F;
   private static final String field23338 = " ";
   private static final String field23339 = "ground";
   private static final String field23340 = " ";
   private static final float field23341 = 10.0F;

   private void method10333(GuiGraphics var1, EntityEspRenderer.Nested298 var2, float var3, float var4, float var5, int var6) {
      Entity var7 = var2.method10402();
      String sx = var2.method10394();
      if (sx != null) {
         float sxx = field23311;
         float sxxx = var2.method10384() + field23312;
         float sxxxx = var3 - sxxx / 2.0F;
         float sxxxxx = var4 - field23313;
         float sxxxxxx = field23314;
         if (var2.method10416().method07131() && var7 instanceof Player) {
            int sxxxxxxx = var2.method10404();
            if (sxxxxxxx != -1) {
               RoundedRectRenderer.method01272(var1, sxxxx - sxx * 2.0F, sxxxxx, field23315, sxxxxxx, 0.0F, 0.0F, ColorUtils.method04611(sxxxxxxx, var5));
               RoundedRectRenderer.method01272(
                  var1, var3 + sxxx / 2.0F + sxx, sxxxxx, field23316, sxxxxxx, 0.0F, 0.0F, ColorUtils.method04611(sxxxxxxx, var5)
               );
            }
         }

         RoundedRectRenderer.method01272(var1, sxxxx - sxx, sxxxxx, sxxx + sxx * 2.0F, sxxxxxx, 0.0F, 0.0F, var6);
         this.field23267.method09490(var1, sx, sxxxx + field23317, var4 - field23318, ColorUtils.method04611(-1, var5), field23319, field23320);
      }
   }

   private void method10334(EntityEspRenderer.Nested298 var1, Entity var2) {
      if (this.method10336(var1, var2)) {
         Component var3 = this.method10352(var1, var2);
         String var4 = var3 == null ? null : FontRenderer.method09483(var3);
         var1.method10390(var4);
         var1.method10395(var4 == null ? 0.0F : this.field23267.method09478(var4, field23333, field23334));
      }
   }

   private void method10335(GuiGraphics var1, EntityEspRenderer.Nested298 var2, float var3, float var4, float var5, int var6) {
      EntityEspRenderer.Nested294 var7 = var2.method10389();
      var var8 = var7.method10364();
      var var9 = var7.method10362();
      if (var8 != null && var9 != null && !var8.isEmpty()) {
         float var10 = 0.0F;

         for (int var11 = 0; var11 < var8.size(); var11++) {
            String var12 = (String)var8.get(var11);
            if (var12 != null) {
               float var13 = var11 < var9.size() ? (Float)var9.get(var11) : 0.0F;
               if (var13 != 0.0F) {
                  float var14 = var4 + var10;
                  float var15 = var3 - var13 / 2.0F - field23302;
                  RoundedRectRenderer.method01272(var1, var15, var14 + field23303 - 2.0F, var13 + field23304, field23305, 0.0F, 0.0F, var6);
                  this.field23267
                     .method09490(var1, var12, var15 + field23306, var14 + field23307, ColorUtils.method04611(-1, var5), field23308, field23309);
                  var10 += field23310;
               }
            }
         }
      }
   }

   private boolean method10336(EntityEspRenderer.Nested298 var1, Entity var2) {
      if (var2 instanceof LivingEntity var8) {
         int var9 = Math.round(PlayerUtils.method11820(var8) * field23341);
         String var10 = PlayerUtils.method11813(var8).getString();
         boolean var6 = var1.method10397() != var9
            || !Objects.equals(var1.method10410(), var10)
            || var1.method10379()
            || var1.method10382()
            || !Objects.equals(var1.method10401(), null)
            || var1.method10418() != 1;
         if (var6) {
            var1.method10381(var9);
            var1.method10383(var10);
            var1.method10399(false);
            var1.method10400(false);
            var1.method10385(null);
            var1.method10411(1);
         }

         return var6;
      } else if (!(var2 instanceof ItemEntity var3)) {
         boolean var7 = var1.method10418() != 3;
         if (var7) {
            var1.method10411(3);
         }

         return var7;
      } else {
         ItemStack var4 = var3.getItem();
         boolean var5 = var1.method10405() != var4.getItem()
            || var1.method10408() != var4.getCount()
            || var1.method10388() != System.identityHashCode(var4.getComponents())
            || var1.method10418() != 2;
         if (var5) {
            var1.method10391(var4.getItem());
            var1.method10415(var4.getCount());
            var1.method10409(System.identityHashCode(var4.getComponents()));
            var1.method10411(2);
         }

         return var5;
      }
   }

   public boolean method10337(Entity var1) {
      if (var1 == null) {
         return false;
      }

      EntityEspRenderer.Nested297 var2 = this.field23265.get(var1.getId());
      return var2 != null && var2.method10376().method10387();
   }

   public void method10338() {
      if (!this.field23266.isEmpty()) {
         this.field23266.clear();
         this.field23265.clear();
      }
   }

   private void method10339(GuiGraphics var1, EntityEspRenderer.Nested298 var2, float var3, float var4, float var5, float var6) {
      EntityEspStyle var7 = var2.method10416();
      if (var7 != null) {
         float var8 = field23280 * var6;
         int var9 = ColorUtils.method04611(var2.method10406() ? field23260 : field23259, var8);
         if (var7.method07130()) {
            this.method10333(var1, var2, var3, var4 - field23281, var8, var9);
         }

         if (var7.method07166() == EntityEspStyle.Nested209.PLAYER) {
            float var10 = var4 - field23282 - field23283 + (var7.method07130() ? 0.0F : field23284);
            if (var7.method07161()) {
               this.method10357(var1, var2, var3, var10, var6, var9);
            }

            if (var7.method07144()) {
               this.method10335(var1, var2, var3, var5 + field23285, var8, var9);
            }
         }
      }
   }

   private Vec3 method10340(EntityEspRenderer.Nested298 var1, float var2) {
      Entity var3 = var1.method10402();
      return var3 instanceof Player && !var1.method10380() ? var3.position() : var3.getPosition(var2);
   }

   public boolean method10341() {
      return this.field23266.isEmpty();
   }

   public int method10342() {
      return this.field23266.size();
   }

   public void method10343(EntityEspRenderer.Nested300 var1) {
      if (mc.level != null && mc.player != null) {
         if (this.field23267 == null) {
            this.field23267 = Fonts.field00109;
         }

         for (EntityEspRenderer.Nested297 var3 : this.field23266) {
            EntityEspRenderer.Nested298 var4 = var3.method10376();
            var4.method10386(false);
            var4.method10398(false);
         }

         for (Entity var11 : mc.level.entitiesForRendering()) {
            int var13 = var11.getId();
            EntityEspRenderer.Nested297 var5 = this.field23265.get(var13);
            if (var5 != null) {
               var5.method10376().method10398(true);
            }

            EntityEspStyle var6 = var1.method10425(var11);
            if (var6 != null) {
               if (var5 == null) {
                  var5 = new EntityEspRenderer.Nested297(new EntityEspRenderer.Nested298(var11));
                  this.field23265.put(var13, var5);
                  this.field23266.add(var5);
               }

               EntityEspRenderer.Nested298 var7 = var5.method10376();
               var7.method10417(var11);
               var7.method10393(var6);
               var7.method10413(var11 instanceof ItemEntity);
               this.method10349(var7, var11);
               var7.method10392(
                  var11 instanceof Player var8
                     && !(var11 instanceof LocalPlayer)
                     && var6.method07166() == EntityEspStyle.Nested209.PLAYER
                     && this.method10351(var6)
               );
               var7.method10386(true);
               var7.method10398(true);
               if (var11 instanceof Player var15) {
                  this.method10345(var7, var15);
               }

               this.method10334(var7, var11);
            }
         }

         var var10 = this.field23266.iterator();

         while (var10.hasNext()) {
            EntityEspRenderer.Nested297 var12 = (EntityEspRenderer.Nested297)var10.next();
            EntityEspRenderer.Nested298 var14 = var12.method10376();
            if (!var14.method10387() && var14.method10412().method03384() == 0.0) {
               var10.remove();
               this.field23265.remove(var14.method10402().getId());
            }
         }
      } else {
         this.method10338();
      }
   }

   private void method10344() {
      for (EntityEspRenderer.Nested297 var2 : this.field23266) {
         EntityEspRenderer.Nested298 var3 = var2.method10376();
         Entity var4 = var3.method10402();
         if (var4 instanceof LocalPlayer && mc.options.getCameraType() == CameraType.FIRST_PERSON && !ModuleManager.INSTANCE.method08258().method03937()) {
            var2.method10374(false);
         } else {
            boolean var5 = PlayerUtils.method11815(var4);
            boolean var6 = !var3.method10407() && var3.method10412().method03384() > 0.0;
            var2.method10374(var5 && (var3.method10387() || var6));
         }
      }
   }

   private void method10345(EntityEspRenderer.Nested298 var1, Player var2) {
      EntityEspStyle var3 = var1.method10416();
      if (var3.method07131() && !SimpleVoiceChatCompatibility.method09184(var2.getUUID())) {
         UUID var4 = var2.getUUID();
         if (SimpleVoiceChatCompatibility.method09185(var4)) {
            var1.method10396(ColorUtils.method04604(100, 255, 100));
         } else if (SimpleVoiceChatCompatibility.method09186(var4)) {
            var1.method10396(ColorUtils.method04604(250, 250, 50));
         } else {
            var1.method10396(ColorUtils.method04604(255, 30, 30));
         }
      } else {
         var1.method10396(-1);
      }

      if (var3.method07144()) {
         EntityEspRenderer.Nested294 var12 = var1.method10389();
         ItemStack var5 = PlayerUtils.method11803(var2);
         Component var6 = var5.isEmpty() ? null : var5.getStyledHoverName();
         Component var7 = var2.getOffhandItem().isEmpty() ? null : var2.getOffhandItem().getStyledHoverName();
         var var8 = Lists.newArrayList(new String[]{FontRenderer.method09483(var6), FontRenderer.method09483(var7)});
         if (!Objects.equals(var8, var12.method10364())) {
            OnlinePlayerState.INSTANCE.method09289(var6, field23329);
            OnlinePlayerState.INSTANCE.method09289(var7, field23330);
            var12.method10361(var8);
            var var9 = new ArrayList(var8.size());

            for (String var11 : var8) {
               var9.add(var11 == null ? 0.0F : this.field23267.method09478(var11, field23331, field23332));
            }

            var12.method10363(var9);
         }
      }

      if (var3.method07161()) {
         this.method10359(var1, var2);
      } else {
         var1.method10378().clear();
      }
   }

   private AABB method10346(Entity var1, Vec3 var2) {
      AABB var3 = var1.getBoundingBox();
      double var4 = var3.maxX - var3.minX;
      double var6 = var3.maxY - var3.minY;
      double var8 = var3.maxZ - var3.minZ;
      double var10 = field23323 - (var1.isShiftKeyDown() ? field23324 : 0.0);
      return new AABB(
         var2.x - var4 / field23325, var2.y, var2.z - var8 / field23326, var2.x + var4 / field23327, var2.y + var6 + var10, var2.z + var8 / field23328
      );
   }

   public EntityEspRenderer() {
      new ElapsedTimer();
   }

   private Vector4f method10347(EntityEspRenderer.Nested298 var1, float var2, PoseStack var3, float var4, float var5, float var6, float var7) {
      Entity var8 = var1.method10402();
      Vec3 var9 = this.method10340(var1, var2);
      AABB var10 = this.method10346(var8, var9);
      int var11 = WorldProjectionUtils.method09452(var3, var10, this.field23271, this.field23272, this.field23273, var4, var5, var6, var7);
      return var11 >= 2 && this.field23272.x != field23321 && this.field23273.x != field23322
         ? this.field23274.set(this.field23272.x, this.field23272.y, this.field23273.x, this.field23273.y)
         : null;
   }

   public void method10348(GuiGraphics var1, PoseStack var2, float var3, EntityEspRenderer.Nested296 var4) {
      if (!this.field23266.isEmpty()) {
         if (this.field23267 == null) {
            this.field23267 = Fonts.field00109;
         }

         if (this.field23270.method06043()) {
            this.method10344();
         }

         float var5 = mc.getWindow().getGuiScaledWidth();
         float var6 = mc.getWindow().getGuiScaledHeight();
         float var7 = var5 * field23276;
         float var8 = var6 * field23277;
         FontRenderer.method09475();
         RoundedRectRenderer.method01277();
         ItemRenderUtils.method08410();

         for (EntityEspRenderer.Nested297 var10 : this.field23266) {
            EntityEspRenderer.Nested298 var11 = var10.method10376();
            boolean var12 = var11.method10387();
            boolean var13 = var11.method10407();
            AnimationUtils var14 = var11.method10412();
            if (var13) {
               var14.method03368(0L);
               var14.method03375(var12 ? 1.0 : 0.0);
            } else {
               var14.method03368(var12 ? 0L : field23278);
               var14.method03375(var12 ? 1.0 : 0.0);
            }

            if (var10.method10377()) {
               float var15 = var13 ? 1.0F : var14.method03377();
               Vector4f var16 = this.method10347(var11, var3, var2, var5, var6, var7, var8);
               if (var16 != null) {
                  var4.method10373(var1, var11.method10402(), var11.method10416(), var16.x(), var16.y(), var16.z(), var16.w(), var15, var11.method10403());
                  float var17 = var16.x() + (var16.z() - var16.x()) / 2.0F;
                  this.method10339(var1, var11, var17, var16.y(), var16.w(), var15);
               }
            }
         }

         GuiRenderBatch.method05184();
         GuiRenderBatch.method05185();
         GuiRenderBatch.method05184();
         ItemRenderUtils.method08420();
         GuiRenderBatch.method05181();
      }
   }

   private void method10349(EntityEspRenderer.Nested298 var1, Entity var2) {
      if (var2 instanceof LivingEntity var3) {
         float var4 = Math.max(1.0F, var3.getMaxHealth());
         var1.method10414(Math.max(0.0F, Math.min(1.0F, var3.getHealth() / var4)));
      }
   }

   private List<EntityEspRenderer.Nested299> method10350(ItemStack var1) {
      ArrayList var2 = new ArrayList();
      if (var1 != null && !var1.isEmpty() && var1.isEnchanted()) {
         ItemEnchantments var3 = var1.getEnchantments();

         for (var var5 : var3.keySet()) {
            int var6 = var3.getLevel(var5);
            if (var6 >= 1) {
               String var7 = var5.getRegisteredName();
               String var8 = null;
               int var9 = -1;
               if (var7.contains(Enchantments.UNBREAKING.identifier().toString())) {
                  var8 = "Un" + var6;
               } else if (var7.contains(Enchantments.SHARPNESS.identifier().toString())) {
                  var8 = "Sh" + var6;
                  if (var6 >= 6) {
                     var9 = ColorUtils.method04604(255, 150, 150);
                  }
               } else if (var7.contains(Enchantments.PROTECTION.identifier().toString())) {
                  var8 = "Pr" + var6;
                  if (var6 >= 5) {
                     var9 = ColorUtils.method04604(255, 150, 150);
                  }
               } else if (var7.contains(Enchantments.MENDING.identifier().toString())) {
                  var8 = "Me" + var6;
               } else if (var7.contains(Enchantments.DEPTH_STRIDER.identifier().toString())) {
                  var8 = "DS" + var6;
               } else if (var7.contains(Enchantments.RESPIRATION.identifier().toString())) {
                  var8 = "Re" + var6;
               } else if (var7.contains(Enchantments.EFFICIENCY.identifier().toString())) {
                  var8 = "Ef" + var6;
               } else if (var7.contains(Enchantments.FEATHER_FALLING.identifier().toString())) {
                  var8 = "FF" + var6;
               } else if (var7.contains(Enchantments.AQUA_AFFINITY.identifier().toString())) {
                  var8 = "AA" + var6;
               }

               if (var8 != null) {
                  EntityEspRenderer.Nested299 var10 = new EntityEspRenderer.Nested299();
                  var10.method10422(var8);
                  var10.method10421(this.field23267.method09486(var8, field23336));
                  var10.method10420(var9);
                  var2.add(var10);
               }
            }
         }

         return var2;
      } else {
         return var2;
      }
   }

   private boolean method10351(EntityEspStyle var1) {
      return var1.method07123().equals(field23275);
   }

   private Component method10352(EntityEspRenderer.Nested298 var1, Entity var2) {
      if (var2 instanceof LivingEntity var7) {
         double var8 = GuiHitTestUtils.method05606(PlayerUtils.method11820(var7), field23337);
         return false
            ? null
            : PlayerUtils.method11813(var7).copy().append(field23338).append(field23263).append(Double.toString(var8)).append(field23264);
      } else if (var2 instanceof ItemEntity var3) {
         ItemStack var4 = var3.getItem();
         Component var5 = var4.getStyledHoverName();
         OnlinePlayerState.INSTANCE.method09289(var5, field23339);
         if (var5 != null && var5.getString().length() > 32) {
            var5 = var4.getItemName();
         }

         int var6 = var4.getCount();
         return var6 <= 1 ? var5 : var5.copy().append(field23340).append(field23263).append(Integer.toString(var6)).append(field23264);
      } else {
         return null;
      }
   }

   private void method10353(List<EntityEspRenderer.Nested295> var1, ItemStack var2) {
      if (!var2.isEmpty()) {
         EntityEspRenderer.Nested295 var3 = new EntityEspRenderer.Nested295();
         ItemStack var4 = var2.copy();
         var3.method10366(var4);
         var3.method10372(var4.getCount());
         var3.method10365(this.field23267.method09486(var4.getCount() + "", field23335));
         var1.add(var3);
      }
   }

   public void method10354(GuiGraphics var1, Entity var2, EntityEspStyle var3, float var4, float var5, float var6, float var7) {
      if (this.field23267 == null) {
         this.field23267 = Fonts.field00109;
      }

      if (this.field23268 == null || this.field23268.method10402() != var2) {
         this.field23268 = new EntityEspRenderer.Nested298(var2);
         this.field23268.method10413(var2 instanceof ItemEntity);
         this.field23269.method04694();
         this.field23268.method10393(var3);
         this.method10356(var2);
      }

      this.field23268.method10393(var3);
      if (this.field23269.method04698(field23279)) {
         this.method10356(var2);
      }

      this.method10339(var1, this.field23268, var4, var5, var6, var7);
   }

   public Entity method10355(int var1) {
      return this.field23266.get(var1).method10376().method10402();
   }

   private void method10356(Entity var1) {
      if (var1 instanceof Player var2) {
         this.method10345(this.field23268, var2);
         if (this.field23268.method10416().method07131() && this.field23268.method10404() == -1) {
            this.field23268.method10396(ColorUtils.method04604(100, 255, 100));
         }
      }

      this.method10334(this.field23268, var1);
   }

   private void method10357(GuiGraphics var1, EntityEspRenderer.Nested298 var2, float var3, float var4, float var5, int var6) {
      float var7 = field23286 * var5;
      var var8 = var2.method10378();
      if (var8 != null && !var8.isEmpty()) {
         float var9 = field23287;
         float var10 = field23288;
         float var11 = field23289;
         float var12 = var9 + var10;
         float var13 = var8.size() * (var12 + var11) - var11;
         float var14 = var3 - var13 / 2.0F;
         boolean var15 = var2.method10416().method07132();

         for (int var16 = 0; var16 < var8.size(); var16++) {
            EntityEspRenderer.Nested295 var17 = (EntityEspRenderer.Nested295)var8.get(var16);
            ItemStack var18 = var17.method10368();
            if (var18 != null && !var18.isEmpty()) {
               float var19 = var14 + var16 * (var12 + var11);
               RoundedRectRenderer.method01272(var1, var19, var4, var12, var12, field23290, 1.0F, var6);
               ItemRenderUtils.method08415(var1, var18, var19 + var10 / 2.0F, var4 + var10 / 2.0F, 1.0F, var5, field23291);
               float var20 = field23292;
               float var21 = var18.getMaxDamage();
               float var22 = var18.getDamageValue();
               if (var18.isDamaged()) {
                  float var23 = field23293;
                  float var24 = var23 * Mth.clamp(var22 / var21, 0.0F, 1.0F);
                  RoundedRectRenderer.method01272(
                     var1,
                     var19 + 1.0F,
                     var4 + field23294,
                     var23,
                     field23295,
                     0.0F,
                     0.0F,
                     ColorUtils.method04611(ColorUtils.method04604(30, 30, 30), var7)
                  );
                  RoundedRectRenderer.method01272(
                     var1,
                     var19 + 1.0F,
                     var4 + field23296,
                     var23 - var24,
                     field23297,
                     0.0F,
                     0.0F,
                     ColorUtils.method04611(ColorUtils.method04601(var22, var21, true), var7)
                  );
               }

               int var31 = var17.method10370();
               float var32 = var17.method10371();
               if (var31 > 1) {
                  this.field23267
                     .method09480(var1, var31 + "", var19 + field23298 - var32 / 2.0F, var4 + field23299, ColorUtils.method04611(-1, var7), var20);
               }

               if (var15) {
                  var var25 = var17.method10367();
                  if (var25 != null && !var25.isEmpty()) {
                     float var26 = var4 - 1.0F;
                     float var27 = var19 + var12 / 2.0F;

                     for (EntityEspRenderer.Nested299 var29 : var25) {
                        var26 -= field23300;
                        float var30 = var29.method10424();
                        this.field23267
                           .method09480(
                              var1, var29.method10423(), var27 - var30 / 2.0F, var26, ColorUtils.method04611(var29.method10419(), var7), field23301
                           );
                     }
                  }
               }
            }
         }
      }
   }

   public boolean method10358(int var1) {
      return this.field23266.get(var1).method10376().method10387();
   }

   private void method10359(EntityEspRenderer.Nested298 var1, Player var2) {
      var var3 = var1.method10378();
      var3.clear();
      this.method10353(var3, var2.getOffhandItem());
      this.method10353(var3, PlayerUtils.method11803(var2));

      for (EquipmentSlot var7 : new EquipmentSlot[]{EquipmentSlot.HEAD, EquipmentSlot.CHEST, EquipmentSlot.LEGS, EquipmentSlot.FEET}) {
         this.method10353(var3, var2.getItemBySlot(var7));
      }

      if (var1.method10416().method07132()) {
         for (EntityEspRenderer.Nested295 var9 : var3) {
            var9.method10369(this.method10350(var9.method10368()));
         }
      }
   }

   public EntityEspStyle method10360(int var1) {
      return this.field23266.get(var1).method10376().method10416();
   }

   // $VF: Compiled from s
   private static final class Nested294 {
      private List<String> field23342 = new ArrayList<>();
      private List<Float> field23343 = new ArrayList<>();

      public void method10361(List<String> var1) {
         this.field23342 = var1;
      }

      public List<Float> method10362() {
         return this.field23343;
      }

      public void method10363(List<Float> var1) {
         this.field23343 = var1;
      }

      public List<String> method10364() {
         return this.field23342;
      }
   }

   // $VF: Compiled from s
   private static final class Nested295 {
      private ItemStack field23344;
      private int field23345;
      private float field23346;
      private List<EntityEspRenderer.Nested299> field23347 = new ArrayList<>();

      public void method10365(float var1) {
         this.field23346 = var1;
      }

      public void method10366(ItemStack var1) {
         this.field23344 = var1;
      }

      public List<EntityEspRenderer.Nested299> method10367() {
         return this.field23347;
      }

      public ItemStack method10368() {
         return this.field23344;
      }

      public void method10369(List<EntityEspRenderer.Nested299> var1) {
         this.field23347 = var1;
      }

      public int method10370() {
         return this.field23345;
      }

      public float method10371() {
         return this.field23346;
      }

      public void method10372(int var1) {
         this.field23345 = var1;
      }
   }

   // $VF: Compiled from s
   public interface Nested296 {
      void method10373(GuiGraphics var1, Entity var2, EntityEspStyle var3, float var4, float var5, float var6, float var7, float var8, float var9);
   }

   // $VF: Compiled from s
   private static final class Nested297 {
      private EntityEspRenderer.Nested298 field23348;
      private boolean field23349;

      public void method10374(boolean var1) {
         this.field23349 = var1;
      }

      public void method10375(EntityEspRenderer.Nested298 var1) {
         this.field23348 = var1;
      }

      Nested297(EntityEspRenderer.Nested298 var1) {
         this.field23348 = var1;
      }

      public EntityEspRenderer.Nested298 method10376() {
         return this.field23348;
      }

      public boolean method10377() {
         return this.field23349;
      }
   }

   // $VF: Compiled from s
   private static final class Nested298 {
      private Entity field23350;
      private EntityEspStyle field23351;
      private boolean field23352;
      private final AnimationUtils field23353;
      private boolean field23354;
      private boolean field23355;
      private float field23356;
      private boolean field23357;
      private String field23358;
      private float field23359;
      private int field23360;
      private final EntityEspRenderer.Nested294 field23361;
      private final List<EntityEspRenderer.Nested295> field23362;
      private int field23363;
      private int field23364;
      private String field23365;
      private boolean field23366;
      private boolean field23367;
      private String field23368;
      private Item field23369;
      private int field23370;
      private int field23371;
      private static final long field23372 = 1000L;
      private static final int field23373 = Integer.MIN_VALUE;
      private static final int field23374 = Integer.MIN_VALUE;
      private static final int field23375 = Integer.MIN_VALUE;

      public List<EntityEspRenderer.Nested295> method10378() {
         return this.field23362;
      }

      public boolean method10379() {
         return this.field23366;
      }

      public boolean method10380() {
         return this.field23355;
      }

      public void method10381(int var1) {
         this.field23364 = var1;
      }

      public boolean method10382() {
         return this.field23367;
      }

      public void method10383(String var1) {
         this.field23365 = var1;
      }

      public float method10384() {
         return this.field23356;
      }

      public void method10385(String var1) {
         this.field23368 = var1;
      }

      public void method10386(boolean var1) {
         this.field23354 = var1;
      }

      public boolean method10387() {
         return this.field23354;
      }

      public int method10388() {
         return this.field23371;
      }

      public EntityEspRenderer.Nested294 method10389() {
         return this.field23361;
      }

      public void method10390(String var1) {
         this.field23358 = var1;
      }

      public void method10391(Item var1) {
         this.field23369 = var1;
      }

      Nested298(Entity var1) {
         String var10001 = "";
         this.field23353 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field23372);
         this.field23359 = 1.0F;
         this.field23360 = -1;
         this.field23361 = new EntityEspRenderer.Nested294();
         this.field23362 = new ArrayList<>();
         this.field23364 = field23373;
         this.field23370 = field23374;
         this.field23371 = field23375;
         this.field23350 = var1;
      }

      public void method10392(boolean var1) {
         this.field23357 = var1;
      }

      public void method10393(EntityEspStyle var1) {
         this.field23351 = var1;
      }

      public String method10394() {
         return this.field23358;
      }

      public void method10395(float var1) {
         this.field23356 = var1;
      }

      public void method10396(int var1) {
         this.field23360 = var1;
      }

      public int method10397() {
         return this.field23364;
      }

      public void method10398(boolean var1) {
         this.field23355 = var1;
      }

      public void method10399(boolean var1) {
         this.field23366 = var1;
      }

      public void method10400(boolean var1) {
         this.field23367 = var1;
      }

      public String method10401() {
         return this.field23368;
      }

      public Entity method10402() {
         return this.field23350;
      }

      public float method10403() {
         return this.field23359;
      }

      public int method10404() {
         return this.field23360;
      }

      public Item method10405() {
         return this.field23369;
      }

      public boolean method10406() {
         return this.field23357;
      }

      public boolean method10407() {
         return this.field23352;
      }

      public int method10408() {
         return this.field23370;
      }

      public void method10409(int var1) {
         this.field23371 = var1;
      }

      public String method10410() {
         return this.field23365;
      }

      public void method10411(int var1) {
         this.field23363 = var1;
      }

      public AnimationUtils method10412() {
         return this.field23353;
      }

      public void method10413(boolean var1) {
         this.field23352 = var1;
      }

      public void method10414(float var1) {
         this.field23359 = var1;
      }

      public void method10415(int var1) {
         this.field23370 = var1;
      }

      public EntityEspStyle method10416() {
         return this.field23351;
      }

      public void method10417(Entity var1) {
         this.field23350 = var1;
      }

      public int method10418() {
         return this.field23363;
      }
   }

   // $VF: Compiled from s
   private static final class Nested299 {
      private String field23376;
      private float field23377;
      private int field23378 = -1;

      public int method10419() {
         return this.field23378;
      }

      public void method10420(int var1) {
         this.field23378 = var1;
      }

      public void method10421(float var1) {
         this.field23377 = var1;
      }

      public void method10422(String var1) {
         this.field23376 = var1;
      }

      public String method10423() {
         return this.field23376;
      }

      public float method10424() {
         return this.field23377;
      }
   }

   // $VF: Compiled from s
   public interface Nested300 {
      EntityEspStyle method10425(Entity var1);
   }
}
