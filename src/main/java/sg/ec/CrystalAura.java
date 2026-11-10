// Original binary: sg/ec/dc5Mzd8X8BSzXY2Q
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.client.Camera;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.network.protocol.game.ClientboundBlockUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundSectionBlocksUpdatePacket;
import net.minecraft.network.protocol.game.ClientboundSetHealthPacket;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.entity.boss.enderdragon.EndCrystal;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

// $VF: Compiled from s
public class CrystalAura extends ClientModule {
   private final NumberSetting<Float> field18189;
   private final NumberSetting<Float> field18190;
   private final NumberSetting<Float> field18191;
   private final NumberSetting<Float> field18192;
   private final NumberSetting<Float> field18193;
   private final NumberSetting<Integer> field18194;
   private final NumberSetting<Integer> field18195;
   private final ToggleSetting field18196;
   private final ToggleSetting field18197;
   private final ToggleSetting field18198;
   private final ToggleSetting field18199;
   private final ToggleSetting field18200;
   private final ToggleSetting field18201;
   private final ToggleSetting field18202;
   private final ToggleSetting field18203;
   private final ToggleSetting field18204;
   private final ToggleSetting field18205;
   private final ToggleSetting field18206;
   private static final int field18207 = 6;
   private static final int field18208 = 0;
   private static final int field18209 = 0;
   private static final float field18210 = 0;
   private static final float field18211 = 0;
   private static final int field18212 = 0;
   private static final int field18213 = 0;
   private static final int field18214 = 0;
   private static final int field18215 = 0;
   private static final int field18216 = 0;
   private static final int field18217 = 0;
   private static final int field18218 = 0;
   private static final double field18219 = 0;
   private static final int field18220 = 0;
   private static final int field18221 = 0;
   private static final int field18222 = 0;
   private static final int field18223 = 0;
   private static final int field18224 = 0;
   private static final int field18225 = 0;
   private static final long field18226 = 0;
   private static final long field18227 = 0;
   private static final long field18228 = 0;
   private static final int field18229 = ColorUtils.method04604(45, 125, 255);
   private static final int field18230 = ColorUtils.method04604(180, 70, 255);
   private static final int field18231 = ColorUtils.method04604(255, 55, 55);
   private final ElapsedTimer field18232;
   private final HitResultConstraint field18233;
   private final BlockBreakManager field18234;
   private final Map<BlockPos, Integer> field18235;
   private final Map<BlockPos, Integer> field18236;
   private final Map<BlockPos, Integer> field18237;
   private int field18238;
   private int field18239;
   private final Map<BlockPos, Integer> field18240;
   private final Map<BlockPos, BlockState> field18241;
   private BlockPos field18242;
   private BlockPos field18243;
   private int field18244;
   private int field18245;
   private BlockPos field18246;
   private int field18247;
   private BlockPos field18248;
   private Item field18249;
   private ExplosionDamageUtils.Nested134 field18250;
   private int field18251;
   private int field18252;
   private BlockPos field18253;
   private int field18254;
   private int field18255;
   private int field18256;
   private BlockPos field18257;
   private final CrystalTargetMovementTracker field18258;
   private SimulatedPlayerInput field18259;
   private int field18260;
   private int field18261;
   private double field18262;
   private double field18263;
   private double field18264;
   private Vec3 field18265;
   private float field18266;
   private float field18267;
   private boolean field18268;
   private int field18269;
   private final Deque<CrystalAura.Nested222> field18270;
   private volatile int field18271;
   private int field18272;
   private final CrystalPlacementRenderer field18273;
   private BlockPos field18274;
   private BlockState field18275;
   private float field18276;
   private long field18277;
   private static final String field18278 = "Радиус цели";
   private static final float field18279 = 4.0F;
   private static final float field18280 = 12.0F;
   private static final float field18281 = 0.5F;
   private static final float field18282 = 8.0F;
   private static final String field18283 = "Дальность установки";
   private static final float field18284 = 3.0F;
   private static final float field18285 = 6.0F;
   private static final float field18286 = 0.1F;
   private static final float field18287 = 4.5F;
   private static final String field18288 = "Дальность взрыва";
   private static final float field18289 = 6.0F;
   private static final float field18290 = 0.1F;
   private static final float field18291 = 3.0F;
   private static final String field18292 = "Мин. урон врагу";
   private static final float field18293 = 20.0F;
   private static final float field18294 = 0.5F;
   private static final float field18295 = 3.0F;
   private static final String field18296 = "По Prot 4 незериту кристалл даёт ~4.5 урона — выше 3 аура перестанет находить точки";
   private static final String field18297 = "Макс. урон себе";
   private static final float field18298 = 20.0F;
   private static final float field18299 = 0.5F;
   private static final float field18300 = 8.0F;
   private static final String field18301 = "Задержка в тиках";
   private static final String field18302 = "Пинг 0-50: 0 | 50-100: 1-2 | 100-150: 2-3 | 150-200: 3-4 | 200+: 4-5";
   private static final String field18303 = "Предикт тиков";
   private static final String field18304 = "Ставить обсидиан";
   private static final String field18305 = "Легитный";
   private static final String field18306 = "Анти-суицид";
   private static final String field18307 = "Авто подкоп";
   private static final String field18308 = "Копать сквозь стены";
   private static final String field18309 = "Grim и Matrix видимость ломаемого блока не проверяют; без этого яма глубже одного блока недостижима";
   private static final String field18310 = "Ставить сквозь стены";
   private static final String field18311 = "Обсидиан и кристалл на опору, которую не видно. Matrix за это не отменяет (interact.vis/ray с нулевым VL), видимая грань всё равно в приоритете";
   private static final String field18312 = "Взрывать сквозь стены";
   private static final String field18313 = "Выкл — только кристаллы, видимые реальным лучом. Вкл — без Matrix луч сквозь блоки, под Matrix через высоты глаз 1.62/1.27/0.4";
   private static final String field18314 = "Обход Matrix";
   private static final String field18315 = "По исходникам Matrix: взрыв только видимых с его высот глаз кристаллов не дальше 5 блоков, копка сквозь стены с Efficiency IV+, поставка как без обхода, наводка как MatrixRotation";
   private static final String field18316 = "Визуализация";
   private static final String field18317 = "Сейвить себя";
   private static final String field18318 = "Эмуляция урона";
   private static final String field18319 = "Для серверов, где сложность мирная или лёгкая, а урон по игрокам идёт как обычно: аура считает урон кристалла как на нормальной сложности";
   private static final String field18320 = "Crystal Aura";
   private static final long field18321 = 50L;
   private static final String field18322 = "взрыв";
   private static final String field18323 = "апгрейд взрыва";
   private static final String field18324 = "план";
   private static final float field18325 = 1.5F;
   private static final double field18326 = 2.0;
   private static final double field18327 = 2.0;
   private static final double field18328 = 0.5;
   private static final float field18329 = Float.MAX_VALUE;
   private static final float field18330 = 8.0F;
   private static final double field18331 = 1.5;
   private static final String field18332 = "кристалл: луч не дошёл до опоры";
   private static final String field18333 = "кристалл ПОСТАВЛЕН";
   private static final String field18334 = "кристалл: useOn отклонён";
   private static final String field18335 = "блок ПОСТАВЛЕН";
   private static final String field18336 = "блок: useOn отклонён";
   private static final long field18337 = 140L;
   private static final long field18338 = 140L;
   private static final float field18339 = 160.0F;
   private static final float field18340 = 0.55F;
   private static final float field18341 = 0.45F;
   private static final float field18342 = 0.45F;
   private static final float field18343 = 0.4F;
   private static final float field18344 = 255.0F;
   private static final double field18345 = 0.5;
   private static final double field18346 = 0.5;
   private static final double field18347 = 0.5;
   private static final double field18348 = 0.5;
   private static final float field18349 = 0.05F;

   public static boolean method07430() {
      CrystalAura var0 = ModuleManager.INSTANCE.method08206();
      return var0 != null && var0.method03937();
   }

   private boolean method07431(Player var1) {
      if (!this.field18205.method05999()) {
         return false;
      }

      if (InventoryUtils.method06111(Items.OBSIDIAN, true) == -1) {
         return false;
      }

      double var2 = var1.getX() - mc.player.getX();
      double var4 = var1.getZ() - mc.player.getZ();
      if (Math.sqrt(var2 * var2 + var4 * var4) > this.field18190.method03022().floatValue() + field18331) {
         return false;
      }

      if (Math.abs(var1.getY() - mc.player.getY()) > 1.0) {
         return false;
      }

      Direction var6 = Math.abs(var2) > Math.abs(var4) ? (var2 > 0.0 ? Direction.EAST : Direction.WEST) : (var4 > 0.0 ? Direction.SOUTH : Direction.NORTH);
      BlockPos var7 = mc.player.blockPosition().relative(var6);
      if (!mc.level.getBlockState(var7).canBeReplaced()) {
         return false;
      }

      if (ExplosionDamageUtils.method04374(var7)) {
         return false;
      }

      this.method07477();
      this.method07500(var7, Items.OBSIDIAN);
      return true;
   }

   private BlockHitResult method07432(BlockPos var1, Direction var2, Vec3 var3) {
      if (this.field18203.method05999() && !this.field18201.method05999()) {
         return BlockPlacementManager.method07898(var1, var2);
      }

      this.field18233.method02874(var1);

      try {
         double var4 = Math.min(mc.player.getEyePosition().distanceTo(var3) + 1.0, mc.player.blockInteractionRange());
         return mc.player.pick(var4, 1.0F, false) instanceof BlockHitResult var7 && var7.getBlockPos().equals(var1) ? var7 : null;
      } finally {
         this.field18233.method02876();
      }
   }

   private void method07433(BlockPos var1, Item var2, ExplosionDamageUtils.Nested134 var3) {
      if (mc.player.tickCount != this.field18272) {
         int var4 = InventoryUtils.method06111(var2, true);
         if (var4 != -1) {
            BlockHitResult var5 = this.method07432(var3.neighbor(), var3.side(), var3.aim());
            if (var5 != null && var5.getBlockPos().relative(var5.getDirection()).equals(var1)) {
               int var6 = mc.player.getInventory().getSelectedSlot();
               mc.player.getInventory().setSelectedSlot(var4);

               boolean var7;
               try {
                  var7 = this.method07437(var5);
               } finally {
                  mc.player.getInventory().setSelectedSlot(var6);
               }

               if (!var7) {
                  ;
               }

               if (!var7) {
                  this.method07491(var1, false);
               }

               if (var7) {
                  CollisionBlockView.field25700.invalidate();
                  this.field18246 = var1;
                  this.field18247 = mc.player.tickCount;
                  if (var2 == Items.OBSIDIAN) {
                     this.field18236.put(var1.immutable(), mc.player.tickCount + 200);
                  }

                  if (this.field18204.method05999()) {
                     this.field18273.method09389(var1, mc.level.getBlockState(var1));
                  }
               }
            } else {
               if (var5 == null) {
                  String.valueOf("блок: луч не дошёл до грани " + var3.neighbor().toShortString());
               } else {
                  String.valueOf("блок: луч попал в " + var5.getBlockPos().toShortString() + "/" + var5.getDirection() + ", не в грань к цели");
               }

               this.method07491(var1, false);
            }
         }
      }
   }

   @Subscribe
   private void method07434(AttackEntityEvent var1) {
      if (mc.player != null && var1.method09434() instanceof Player var2) {
         if (var1.method09431() != AttackEntityEvent.Nested264.PRE) {
            Vec3 var10 = this.field18265;
            this.field18265 = null;
            if (var10 != null && !this.field18268 && method07443(var2)) {
               SimulatedPlayerInput var4 = SimulatedPlayerInput.method08886(var2, SimulatedPlayerInput.Nested248.guessInput(var2));
               Vec3 var5 = var4.field20219;
               var4.field20219 = CrystalDamageUtils.method07234(var2, var5, var4.field20229, var10, this.field18266, this.field18267);
               double var6 = var4.field20219.x - var5.x / field18326;
               double var8 = var4.field20219.z - var5.z / field18327;
               this.field18262 = Math.sqrt(var6 * var6 + var8 * var8);
               this.field18263 = this.field18262 > 0.0 ? var6 / this.field18262 : 0.0;
               this.field18264 = this.field18262 > 0.0 ? var8 / this.field18262 : 0.0;
               this.field18259 = var4;
               this.field18260 = mc.player.tickCount;
               this.field18261 = this.field18260;
            }
         } else {
            this.field18265 = mc.player.position();
            this.field18266 = mc.player.getYRot();
            this.field18267 = CrystalDamageUtils.method07238();
            this.field18268 = var2.hurtTime > 0 || var2.isBlocking();
         }
      }
   }

   private void method07435(PoseStack var1, Camera var2, Frustum var3, WorldVertexCollector var4, long var5) {
      if (this.field18274 != null) {
         long var7 = var5 - this.field18277;
         float var9;
         if (var7 <= field18337) {
            var9 = 1.0F;
         } else {
            float var10 = (float)(var7 - field18338) / field18339;
            if (var10 >= 1.0F) {
               this.field18274 = null;
               return;
            }

            var9 = 1.0F - var10;
         }

         float var12 = field18340 + field18341 * this.field18276;
         int var11 = (int)((field18342 + field18343 * this.field18276) * var9 * field18344);
         WorldBoxRenderer.method06958(this.method07442(this.field18274, var12), var1, var2, var3, var4, ColorUtils.method04616(field18231, var11));
      }
   }

   private void method07436() {
      this.field18248 = null;
      this.field18249 = null;
      this.field18250 = null;
      this.field18251 = -100;
   }

   private boolean method07437(BlockHitResult var1) {
      if (mc.gameMode.useItemOn(mc.player, InteractionHand.MAIN_HAND, var1) != InteractionResult.SUCCESS) {
         return false;
      }

      mc.player.swing(InteractionHand.MAIN_HAND);
      RotationChangeTracker.method02903();
      this.field18272 = mc.player.tickCount;
      return true;
   }

   private boolean method07438(CrystalPlacementEvaluator.Nested85 var1, boolean var2) {
      if (!var2) {
         return false;
      }

      BlockPos var3 = var1.pos();
      if (this.method07465(var3)) {
         this.method07491(var3, false);
         return false;
      }

      if (var1.action() == CrystalPlacementEvaluator.Nested84.PLACE_CRYSTAL && this.method07441(var3)) {
         return false;
      }

      BlockPlacementTracker.method05652();
      BlockPlacementTracker.method05649(this, var3);
      BlockPlacementTracker.method05649(this, var3.above());
      boolean var4;
      if (var1.action() == CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN) {
         this.method07477();
         var4 = this.method07500(var3, Items.OBSIDIAN);
      } else {
         var4 = this.method07454(var3);
      }

      this.method07491(var3, var4);
      if (var4) {
         this.field18232.method04694();
      }

      return var4;
   }

   @Subscribe
   private void method07439(PlayerInputEvent var1) {
      ExplosionDamageUtils.method04409(this.field18206.method05999());
      if (mc.player != null && mc.level != null && mc.gameMode != null && !mc.player.isSpectator()) {
         if (this.field18204.method05999()) {
            this.field18273.method09398(this.field18189.method03022().floatValue(), true);
         } else {
            this.field18273.method09393();
         }

         if (!this.field18197.method05999()) {
            this.method07477();
         }

         this.method07490();
         this.method07463();
         this.method07471();
         var var2 = this.method07470();
         if (var2.isEmpty()) {
            this.field18258.method03802();
            this.field18259 = null;
            this.method07488();
         } else {
            Vec3 var3 = mc.player.getEyePosition();
            CrystalPlacementEvaluator.Nested86 var4 = this.method07462();
            boolean var5 = (this.field18259 != null || this.field18232.method04699(this.field18194.method03022().intValue() * field18321))
               && !this.field18234.method04908();
            Player var6 = null;
            AABB var7 = null;
            CrystalPlacementEvaluator.Nested80 var8 = null;
            CrystalPlacementEvaluator.Nested85 var9 = null;
            CrystalPlacementEvaluator.Nested85 var10 = null;
            int var11 = Math.min(var2.size(), 3);

            for (int var12 = 0; var12 < var11; var12++) {
               Player var13 = (Player)var2.get(var12);
               boolean var14 = this.field18258.method03800(var13);
               if (var14) {
                  this.field18258.method03799(var13);
               }

               AABB var15 = this.method07497(var13);
               CrystalPlacementEvaluator.Nested85 var16 = var5 ? CrystalPlacementEvaluator.method02906(var13, var15, var3, var4) : null;
               CrystalPlacementEvaluator.Nested80 var17 = var16 == null
                  ? this.method07466(var14 ? this.field18258.method03801() : 0.0F, !this.method07440(var13))
                  : null;
               CrystalPlacementEvaluator.Nested85 var18 = var17 == null ? null : CrystalPlacementEvaluator.method02920(var13, var15, var3, var4, var17);
               boolean var19 = var16 != null || var18 != null;
               if (var12 == 0 || var19) {
                  var6 = var13;
                  var7 = var15;
                  var9 = var16;
                  var10 = var18;
               }

               if (var19) {
                  break;
               }
            }

            if (!this.field18258.method03800(var6)) {
               this.field18258.method03799(var6);
            }

            if (var5) {
               if (var9 != null) {
                  var8 = this.method07466(this.field18258.method03801(), !this.method07440(var6));
                  var10 = CrystalPlacementEvaluator.method02920(var6, var7, var3, var4, var8);
                  if (this.method07444(var10, var9, var3)) {
                     this.field18255 = 0;
                     this.method07483();
                     if (this.method07438(var10, true)) {
                        return;
                     }
                  }

                  BlockPlacementTracker.method05652();
                  this.method07483();
                  this.method07469(var9.pos().below());
                  boolean var23 = this.method07447(var9.crystal());
                  var9.pos();
                  if (var23) {
                     this.field18232.method04694();
                  }

                  return;
               }

               if (this.method07446(var6, var7, var4)) {
                  BlockPlacementTracker.method05652();
                  this.method07483();
                  this.field18232.method04694();
                  return;
               }

               if (this.method07431(var6)) {
                  BlockPlacementTracker.method05652();
                  this.method07483();
                  this.field18232.method04694();
                  return;
               }
            }

            if (var10 == null) {
               this.method07493(var6);
            } else {
               if (var10.action() == CrystalPlacementEvaluator.Nested84.DIG) {
                  CrystalPlacementEvaluator.Nested85 var22 = this.method07484(var6, var3, var4);
                  if (var22 != null) {
                     this.field18255 = 0;
                     this.method07483();
                     this.method07477();
                     if (var22.action() == CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN) {
                        this.method07438(var22, var5);
                     }

                     return;
                  }
               }

               this.field18255 = 0;
               if (var10.action() == CrystalPlacementEvaluator.Nested84.AWAIT) {
                  this.field18238++;
                  this.field18239 = 0;
               } else if (++this.field18239 >= 20) {
                  this.field18238 = 0;
               }

               this.method07469(var10.base() != null ? var10.base() : var10.pos());
               if (var10.clears() != null) {
                  this.field18242 = var10.clears();
                  this.field18245 = mc.player.tickCount;
               } else if (var10.base() != null) {
                  this.field18242 = var10.base();
                  this.field18245 = mc.player.tickCount;
               }

               if (var10.action() == CrystalPlacementEvaluator.Nested84.DIG) {
                  this.method07477();
                  if (this.method07498(var10.pos())) {
                     this.method07474(var10.pos());
                  }
               } else {
                  this.method07483();
                  if (var10.action() == CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN || var10.action() == CrystalPlacementEvaluator.Nested84.PLACE_CRYSTAL) {
                     this.method07438(var10, var5);
                  }
               }
            }
         }
      } else {
         this.field18258.method03802();
         this.field18259 = null;
         this.method07488();
      }
   }

   private boolean method07440(Player var1) {
      SimulatedPlayerInput var2 = this.field18259;
      return var2 != null && var2.field20215 == var1;
   }

   private boolean method07441(BlockPos var1) {
      if (this.field18253 != null && this.field18253.equals(var1.above())) {
         int var2 = mc.player.tickCount - this.field18254;
         return var2 >= 0 && var2 < 4 && this.method07450(this.field18253) == null;
      } else {
         return false;
      }
   }

   private AABB method07442(BlockPos var1, float var2) {
      double var3 = var1.getX() + field18345;
      double var5 = var1.getY() + field18346;
      double var7 = var1.getZ() + field18347;
      double var9 = field18348 * Mth.clamp(var2, field18349, 1.0F);
      return new AABB(var3 - var9, var5 - var9, var7 - var9, var3 + var9, var5 + var9, var7 + var9);
   }

   private static boolean method07443(Player var0) {
      AttackAura var1 = ModuleManager.INSTANCE.method08219();
      return var1 != null && var1.method03937() && AttackAura.field00785 == var0;
   }

   private boolean method07444(CrystalPlacementEvaluator.Nested85 var1, CrystalPlacementEvaluator.Nested85 var2, Vec3 var3) {
      if (var1 != null && var1.action() == CrystalPlacementEvaluator.Nested84.PLACE_CRYSTAL) {
         float var4 = var1.enemyDamage() - var2.enemyDamage();
         if (!(var4 < 2.0F) && !(var1.enemyDamage() < var2.enemyDamage() * field18325)) {
            float var5 = this.field18191.method03022();
            return ExplosionDamageUtils.method04394(var3, ExplosionDamageUtils.method04377(var1.pos())) <= var5 * var5;
         } else {
            return false;
         }
      } else {
         return false;
      }
   }

   private static boolean method07445() {
      WebTrap var0 = ModuleManager.INSTANCE.method08261();
      AutoAnchor var1 = ModuleManager.INSTANCE.method08214();
      return var0 != null && var0.method03937() || var1 != null && var1.method03937();
   }

   private boolean method07446(Player var1, AABB var2, CrystalPlacementEvaluator.Nested86 var3) {
      if (this.field18253 == null) {
         return false;
      }

      if (mc.player.tickCount - this.field18254 > 20) {
         this.field18253 = null;
         return false;
      }

      EndCrystal var4 = this.method07450(this.field18253);
      if (var4 != null && !var4.isRemoved()) {
         float var9 = this.field18191.method03022();
         if (ExplosionDamageUtils.method04418(mc.player.getEyePosition(), var4.getBoundingBox()) > var9 * var9) {
            this.field18253 = null;
            return false;
         }

         float var6 = ExplosionDamageUtils.method04368(var4.position(), mc.player);
         float var7 = ExplosionDamageUtils.method04421(var4.position(), var1, var2);
         if (!CrystalPlacementEvaluator.method02907(var6, var7, var3, this.field18253.below())) {
            this.field18253 = null;
            return false;
         }

         boolean var8 = this.method07464(var4, var9);
         if (var8) {
            this.field18253 = null;
         }

         return var8;
      } else {
         int var5 = mc.player.tickCount - this.field18254;
         if (var5 < 0 || var5 >= 4) {
            this.field18253 = null;
         }

         return false;
      }
   }

   private boolean method07447(EndCrystal var1) {
      return this.method07464(var1, this.field18191.method03022());
   }

   public CrystalAura() {
      super(ModuleCategory.Combat, ModuleSubCategory.Utility);
      this.field18189 = new NumberSetting<Float>(field18278)
         .method10835(field18279)
         .method10838(field18280)
         .method10834(field18281)
         .method03017(field18282)
         .method03023(this);
      this.field18190 = new NumberSetting<Float>(field18283)
         .method10835(field18284)
         .method10838(field18285)
         .method10834(field18286)
         .method03017(field18287)
         .method03023(this);
      this.field18191 = new NumberSetting<Float>(field18288)
         .method10835(1.0F)
         .method10838(field18289)
         .method10834(field18290)
         .method03017(field18291)
         .method03023(this);
      this.field18192 = new NumberSetting<Float>(field18292)
         .method10835(1.0F)
         .method10838(field18293)
         .method10834(field18294)
         .method03017(field18295)
         .method03018(field18296)
         .method03023(this);
      this.field18193 = new NumberSetting<Float>(field18297)
         .method10835(0.0F)
         .method10838(field18298)
         .method10834(field18299)
         .method03017(field18300)
         .method03023(this);
      this.field18194 = new NumberSetting<Integer>(field18301)
         .method10835(0)
         .method10838(5)
         .method10834(1)
         .method03017(0)
         .method03018(field18302)
         .method03023(this);
      this.field18195 = new NumberSetting<Integer>(field18303).method10835(0).method10838(4).method10834(1).method03017(2).method03023(this);
      this.field18196 = new ToggleSetting(field18304).method03017(true).method03023(this);
      this.field18197 = new ToggleSetting(field18305).method03017(false).method03023(this);
      this.field18198 = new ToggleSetting(field18306).method03017(true).method03023(this);
      this.field18199 = new ToggleSetting(field18307).method03017(true).method03023(this);
      this.field18200 = new ToggleSetting(field18308).method03017(true).method03018(field18309).method03023(this);
      this.field18201 = new ToggleSetting(field18310).method03017(true).method03018(field18311).method03023(this);
      this.field18202 = new ToggleSetting(field18312).method03017(true).method03018(field18313).method03023(this);
      this.field18203 = new ToggleSetting(field18314).method03017(false).method03018(field18315).method03023(this);
      this.field18204 = new ToggleSetting(field18316).method03017(true).method03023(this);
      this.field18205 = new ToggleSetting(field18317).method03017(false).method03023(this);
      this.field18206 = new ToggleSetting(field18318).method03017(false).method03018(field18319).method03023(this);
      this.field18232 = new ElapsedTimer();
      this.field18233 = new HitResultConstraint();
      this.field18234 = BlockBreakManager.INSTANCE;
      this.field18235 = new HashMap<>();
      this.field18236 = new HashMap<>();
      this.field18237 = new HashMap<>();
      this.field18240 = new ConcurrentHashMap<>();
      this.field18241 = new ConcurrentHashMap<>();
      this.field18245 = -100;
      this.field18247 = -100;
      this.field18251 = -100;
      this.field18252 = -1;
      this.field18254 = -100;
      this.field18258 = new CrystalTargetMovementTracker();
      this.field18269 = -100;
      this.field18270 = new ArrayDeque<>();
      this.field18271 = -100;
      this.field18272 = -100;
      this.field18273 = new CrystalPlacementRenderer();
      Object var10001 = null;
      var10001 = null;
      this.method03935(field18320);
   }

   private boolean method07448() {
      if (!this.field18234.method04906(this)) {
         return false;
      }

      BlockPos var1 = this.field18234.method04912();
      if (var1 == null || this.method07482(var1)) {
         return false;
      }

      if (ExplosionDamageUtils.method04366(mc.level.getBlockState(var1)) && !ExplosionDamageUtils.method04367(var1)) {
         float var2 = this.field18190.method03022();
         if (ExplosionDamageUtils.method04381(mc.player.getEyePosition(), var1) > var2 * var2) {
            return false;
         }

         this.method07474(var1);
         return true;
      } else {
         return false;
      }
   }

   private EndCrystal method07450(BlockPos var1) {
      var var2 = mc.level.getEntitiesOfClass(EndCrystal.class, ExplosionDamageUtils.method04396(var1), var0 -> true);
      return var2.isEmpty() ? null : (EndCrystal)var2.get(0);
   }

   @Subscribe
   private void method07452(PacketEvent var1) {
      if (var1.method10904()) {
         if (var1.method10897() instanceof ClientboundSetHealthPacket) {
            this.field18271 = mc.player == null ? -100 : mc.player.tickCount;
         } else if (!this.field18240.isEmpty() || this.field18234.method04912() != null) {
            if (var1.method10897() instanceof ClientboundBlockUpdatePacket var2) {
               this.method07481(var2.getPos(), var2.getBlockState());
            } else if (var1.method10897() instanceof ClientboundSectionBlocksUpdatePacket var3) {
               var3.runUpdates(this::method07481);
            }
         }
      }
   }

   private void method07453(float var1) {
      if (var1 > 0.0F) {
         this.field18270.add(new CrystalAura.Nested222(mc.player.tickCount, var1));
      }
   }

   private boolean method07454(BlockPos var1) {
      if (InventoryUtils.method06111(Items.END_CRYSTAL, true) == -1) {
         return false;
      } else if (this.method07456(var1)) {
         return false;
      } else {
         Vector2f var2 = this.field18203.method05999()
            ? BlockPlacementManager.method07903(var1, this.field18190.method03022().floatValue(), this.field18201.method05999())
            : this.method07487(var1);
         if (var2 != null && BlockActionQueue.method11512(this, var2)) {
            this.method07496(var1, Items.END_CRYSTAL, null);
            return true;
         } else {
            return false;
         }
      }
   }

   private Vector2f method07455(EndCrystal var1, float var2) {
      Vec3 var3 = mc.player.getEyePosition();
      if (this.field18203.method05999()) {
         Vec3 var5 = ExplosionDamageUtils.method04371(var1, var3, var2, true);
         return var5 == null ? null : BlockPlacementManager.method07908(var1, var5, var2);
      } else {
         Vec3 var4 = this.field18202.method05999() ? ExplosionDamageUtils.method04404(var1, var3, var2) : ExplosionDamageUtils.method04364(var1, var3, var2);
         return var4 == null ? null : this.method07480(var3, var4);
      }
   }

   private boolean method07456(BlockPos var1) {
      return var1.equals(this.field18246) && mc.player.tickCount - this.field18247 < 1;
   }

   @Subscribe
   private void method07457(PostPlayerInputEvent var1) {
      if (this.field18249 != null) {
         BlockPos var2 = this.field18248;
         Item var3 = this.field18249;
         ExplosionDamageUtils.Nested134 var4 = this.field18250;
         int var5 = this.field18251;
         this.method07436();
         if (mc.player != null && mc.level != null && mc.gameMode != null) {
            if (mc.player.tickCount == var5) {
               if (var4 == null) {
                  this.method07476(var2);
               } else {
                  this.method07433(var2, var3, var4);
               }
            }
         }
      }
   }

   public boolean method07458() {
      return this.field18203.method05999();
   }

   @Subscribe
   private void method07461(HudRenderEvent var1) {
   }

   private CrystalPlacementEvaluator.Nested86 method07462() {
      this.method07489();
      float var1 = this.field18198.method05999()
         ? Math.max(0.0F, mc.player.getHealth() + mc.player.getAbsorptionAmount() - 1.0F - this.method07495())
         : field18329;
      boolean var2 = InventoryUtils.method06111(Items.END_CRYSTAL, true) != -1;
      boolean var3 = this.field18196.method05999() && InventoryUtils.method06111(Items.OBSIDIAN, true) != -1;
      return new CrystalPlacementEvaluator.Nested86(
         this.field18190.method03022(),
         this.field18191.method03022(),
         this.field18192.method03022(),
         this.field18193.method03022(),
         var1,
         var2,
         var3,
         this.field18201.method05999(),
         this.method07467(),
         this.field18202.method05999(),
         CombatTargetUtils.method03521(this.field18189.method03022() + field18330),
         this.field18203.method05999(),
         this.method07494(),
         this
      );
   }

   private void method07463() {
      if (this.field18234.method04906(this) && this.field18234.method04914() == BlockBreakManager.Nested148.BROKEN) {
         BlockPos var1 = this.field18234.method04912().immutable();
         this.field18234.method04904(this);
         if (this.field18204.method05999() && var1.equals(this.field18274)) {
            this.field18273.method09402(var1, this.field18275);
            this.field18274 = null;
         }

         BlockState var2 = this.field18241.remove(var1);
         if (var2 == null || ExplosionDamageUtils.method04366(var2)) {
            Object var10002 = null;
            this.field18240.put(var1, mc.player.tickCount);
            if (var2 != null) {
               this.field18241.put(var1, var2);
            }
         }
      }

      if (!this.field18240.isEmpty()) {
         int var7 = mc.player.tickCount;
         var var8 = this.field18240.entrySet().iterator();

         while (var8.hasNext()) {
            Entry var3 = (Entry)var8.next();
            BlockPos var4 = (BlockPos)var3.getKey();
            BlockState var5 = this.field18241.remove(var4);
            if (var5 == null) {
               var5 = this.method07475(var4, var7);
            }

            int var6 = var7 - (Integer)var3.getValue();
            if (var5 != null || var6 < 0 || var6 > 20) {
               var8.remove();
               this.field18237.remove(var4);
               if (var5 != null && ExplosionDamageUtils.method04366(var5)) {
                  this.method07472(var4);
               }
            }
         }
      }
   }

   private boolean method07464(EndCrystal var1, float var2) {
      if (var1 == null || var1.isRemoved()) {
         return false;
      }

      if (mc.player.tickCount == this.field18269) {
         return false;
      }

      if (this.method07468(var1)) {
         return false;
      }

      Vector2f var3 = this.method07455(var1, var2);
      if (var3 == null || !BlockActionQueue.method11512(this, var3)) {
         return false;
      }

      if (!this.method07486(var1, var2)) {
         return false;
      }

      if (this.field18197.method05999()) {
         this.method07501();
      }

      mc.gameMode.attack(mc.player, var1);
      mc.player.swing(InteractionHand.MAIN_HAND);
      this.field18269 = mc.player.tickCount;
      this.method07453(ExplosionDamageUtils.method04368(var1.position(), mc.player));
      if (this.field18203.method05999()) {
         RotationManager.method06555();
      }

      return true;
   }

   private boolean method07465(BlockPos var1) {
      return this.field18240.containsKey(var1) || this.field18240.containsKey(var1.above());
   }

   private CrystalPlacementEvaluator.Nested80 method07466(float var1, boolean var2) {
      boolean var3 = this.field18234.method04906(this);
      return new CrystalPlacementEvaluator.Nested80(
         var2 && this.field18199.method05999(),
         this.field18235.keySet(),
         this.field18236.keySet(),
         var3 ? this.field18234.method04912() : null,
         var3 ? this.field18234.method04913() : 0.0F,
         var1,
         this.method07494(),
         this.field18240.keySet(),
         this.field18238
      );
   }

   private boolean method07467() {
      return this.field18200.method05999() && (!this.field18203.method05999() || BlockPlacementManager.method07897());
   }

   private boolean method07468(EndCrystal var1) {
      return AutoTotem.method08643() && ExplosionDamageUtils.method04368(var1.position(), mc.player) > 0.0F;
   }

   private void method07469(BlockPos var1) {
      if (var1 != null && method07445()) {
         BlockPlacementTracker.method05649(this, var1);
         BlockPlacementTracker.method05649(this, var1.above());
      }
   }

   private List<Player> method07470() {
      EntityExtensionAccess var1 = (EntityExtensionAccess)mc.player;
      var var2 = CombatTargetUtils.method03519(this.field18189.method03022());
      var2.sort((var1x, var2x) -> Double.compare(var1.getDistanceEyePos(var1x), var1.getDistanceEyePos(var2x)));
      return var2;
   }

   private void method07471() {
      SimulatedPlayerInput var1 = this.field18259;
      if (var1 != null) {
         int var2 = mc.player.tickCount;
         int var3 = var2 - this.field18260;
         if (var3 < 0 || var3 > 10 || var1.field20215.isRemoved()) {
            this.field18259 = null;
         } else if (var2 != this.field18261) {
            this.field18261 = var2;
            Player var4 = var1.field20215;
            double var5 = (var4.getX() - var4.xo) * this.field18263 + (var4.getZ() - var4.zo) * this.field18264;
            if (!(var5 >= this.field18262 * field18328) && (var3 <= 1 || !var1.field20229)) {
               var1.method08897();
            } else {
               this.field18259 = null;
            }
         }
      }
   }

   private void method07472(BlockPos var1) {
      if (var1 != null && mc.player != null) {
         this.field18235.put(var1.immutable(), mc.player.tickCount + 40);
      }
   }

   public boolean method07473() {
      return this.field18200.method05999();
   }

   private void method07474(BlockPos var1) {
      BlockPlacementTracker.method05652();
      BlockPlacementTracker.method05649(this, var1);
      if (this.field18234.method04891(this, var1)) {
         BlockBreakManager.Nested148 var2 = this.field18234.method04914();
         if (var2 == BlockBreakManager.Nested148.STUCK) {
            String.valueOf("копка " + var1.toShortString() + " STUCK: чёрный список на 40");
            this.method07472(var1);
            this.field18234.method04904(this);
         } else {
            if (var2 == BlockBreakManager.Nested148.MINING && this.field18204.method05999()) {
               this.field18274 = var1;
               this.field18275 = mc.level.getBlockState(var1);
               this.field18276 = this.field18234.method04913();
               this.field18277 = System.currentTimeMillis();
            }
         }
      }
   }

   private BlockState method07475(BlockPos var1, int var2) {
      BlockState var3 = mc.level.getBlockState(var1);
      if (!ExplosionDamageUtils.method04366(var3)) {
         this.field18237.remove(var1);
         return null;
      } else {
         int var4 = this.field18237.computeIfAbsent(var1, var1x -> var2);
         return var2 - var4 >= 2 ? var3 : null;
      }
   }

   private void method07476(BlockPos var1) {
      if (mc.player.tickCount != this.field18272) {
         if (InventoryUtils.method06111(Items.END_CRYSTAL, true) != -1) {
            BlockHitResult var2 = this.method07432(var1, null, Vec3.atCenterOf(var1));
            if (var2 != null) {
               boolean var3 = this.field18197.method05999();
               int var4 = mc.player.getInventory().getSelectedSlot();
               if (var3) {
                  this.method07501();
               } else {
                  mc.player.getInventory().setSelectedSlot(InventoryUtils.method06111(Items.END_CRYSTAL, true));
               }

               boolean var5;
               try {
                  var5 = this.method07437(var2);
               } finally {
                  if (!var3) {
                     mc.player.getInventory().setSelectedSlot(var4);
                  }
               }

               if (!var5) {
                  ;
               }

               if (var5) {
                  this.field18253 = var1.above();
                  if (var1.equals(this.field18242)) {
                     this.field18242 = null;
                  }

                  this.field18254 = mc.player.tickCount;
               }
            }
         }
      }
   }

   private void method07477() {
      if (this.field18252 != -1) {
         if (mc.player != null) {
            mc.player.getInventory().setSelectedSlot(this.field18252);
         }

         this.field18252 = -1;
      }
   }

   private int method07478() {
      return Math.max(this.field18195.method03022(), 3);
   }

   private CrystalAura.Nested223 method07479(BlockPos var1) {
      float var2 = this.field18190.method03022();
      if (this.field18203.method05999()) {
         BlockPlacementManager.Nested232 var5 = BlockPlacementManager.method07905(var1, var2, this.field18201.method05999());
         return var5 == null
            ? null
            : new CrystalAura.Nested223(var5.rotation(), new ExplosionDamageUtils.Nested134(var5.neighbor(), var5.side(), var5.aim()));
      } else {
         Vec3 var3 = mc.player.getEyePosition();
         ExplosionDamageUtils.Nested134 var4 = ExplosionDamageUtils.method04385(var1, var3, var2, this.field18201.method05999());
         return var4 == null ? null : new CrystalAura.Nested223(this.method07480(var3, var4.aim()), var4);
      }
   }

   private Vector2f method07480(Vec3 var1, Vec3 var2) {
      Vector2f var3 = PlayerUtils.method11816(var1, var2);
      return this.field18203.method05999() ? BlockPlacementManager.method07910(var3) : var3;
   }

   private void method07481(BlockPos var1, BlockState var2) {
      if (this.field18240.containsKey(var1) || var1.equals(this.field18234.method04912())) {
         this.field18241.put(var1.immutable(), var2);
      }
   }

   private boolean method07482(BlockPos var1) {
      Integer var2 = this.field18235.get(var1);
      if (var2 == null) {
         return false;
      }

      if (mc.player != null && mc.player.tickCount <= var2) {
         return true;
      }

      this.field18235.remove(var1);
      return false;
   }

   private void method07483() {
      this.field18256 = 0;
      this.field18257 = null;
      if (this.field18234.method04906(this)) {
         boolean var1 = this.field18234.method04900();
         this.field18234.method04912();
         if (var1) {
            this.field18234.method04903(this);
         } else {
            this.field18234.method04904(this);
         }
      }
   }

   private CrystalPlacementEvaluator.Nested85 method07484(Player var1, Vec3 var2, CrystalPlacementEvaluator.Nested86 var3) {
      if (method07443(var1) && !var1.isBlocking() && !this.method07440(var1)) {
         AttackAura var4 = ModuleManager.INSTANCE.method08219();
         if (((EntityExtensionAccess)mc.player).getDistanceEyePos(var1) > var4.method00403()) {
            return null;
         }

         if (WorldCollisionUtils.method02821(var1.getBoundingBox(), Blocks.COBWEB)) {
            return null;
         }

         Vec3 var5 = mc.player.position();
         SimulatedPlayerInput var6 = SimulatedPlayerInput.method08886(var1, SimulatedPlayerInput.Nested248.guessInput(var1));
         var6.field20219 = CrystalDamageUtils.method07234(
            var1, var6.field20219, var6.field20229, var5, CrystalDamageUtils.method07233(var5, var1), CrystalDamageUtils.method07239(mc.player.isSprinting())
         );
         int var7 = this.method07478();

         for (int var8 = 0; var8 < var7; var8++) {
            var6.method08897();
         }

         if (var6.field20220 == null) {
            return null;
         }

         CrystalPlacementEvaluator.Nested85 var10 = CrystalPlacementEvaluator.method02920(var1, var6.field20220, var2, var3, this.method07466(0.0F, false));
         if (var10 == null) {
            return null;
         }

         CrystalPlacementEvaluator.Nested84 var9 = var10.action();
         return var9 != CrystalPlacementEvaluator.Nested84.PLACE_CRYSTAL && var9 != CrystalPlacementEvaluator.Nested84.PLACE_OBSIDIAN ? null : var10;
      } else {
         return null;
      }
   }

   @Subscribe
   private void method07485(Render3DEvent var1) {
      if (mc.player != null && mc.level != null && mc.gameMode != null) {
         if (!this.field18204.method05999()) {
            this.field18274 = null;
         } else {
            this.field18273.method09399(var1, field18230, field18229);
            this.method07435(var1.method00996(), var1.method00994(), var1.method00986(), var1.method00985(), System.currentTimeMillis());
         }
      }
   }

   private boolean method07486(EndCrystal var1, float var2) {
      return this.field18203.method05999()
         ? BlockPlacementManager.method07909(var1, var2)
         : RaycastUtils.method09505(mc.player.getYRot(), mc.player.getXRot(), var2, var1, !this.field18202.method05999());
   }

   private Vector2f method07487(BlockPos var1) {
      Vec3 var2 = mc.player.getEyePosition();
      if (this.field18201.method05999()) {
         return this.method07480(var2, ExplosionDamageUtils.method04412(var1, var2));
      }

      Vec3 var3 = ExplosionDamageUtils.method04384(var1, var2, this.field18190.method03022());
      return var3 == null ? null : this.method07480(var2, var3);
   }

   private void method07488() {
      this.field18255 = 0;
      this.field18256 = 0;
      this.method07477();
      this.field18234.method04904(this);
   }

   private void method07489() {
      if (!this.field18270.isEmpty()) {
         int var1 = mc.player.tickCount;
         int var2 = ServerLatencyTracker.INSTANCE.method01667();
         this.field18270.removeIf(var3 -> this.field18271 > var3.tick() + var2 || var1 - var3.tick() > var2 + 5);
      }
   }

   private void method07490() {
      if (mc.player != null) {
         int var1 = mc.player.tickCount;
         this.field18235.values().removeIf(var1x -> var1 > var1x);
         this.field18236.values().removeIf(var1x -> var1 > var1x);
      }
   }

   private void method07491(BlockPos var1, boolean var2) {
      if (!var2 && var1.equals(this.field18243)) {
         if (++this.field18244 >= 5) {
            String.valueOf("постановка " + var1.toShortString() + " ЗАСТРЯЛА " + this.field18244 + " тиков: чёрный список на 40");
            this.method07472(var1);
            if (var1.equals(this.field18242)) {
               this.field18242 = null;
            }

            this.field18243 = null;
            this.field18244 = 0;
         }
      } else {
         this.field18243 = var2 ? null : var1;
         this.field18244 = var2 ? 0 : 1;
      }
   }

   @Subscribe
   private void method07492(HitResultEvent var1) {
      this.field18233.method02875(var1);
   }

   private void method07493(Player var1) {
      this.field18255++;
      if (this.field18255 <= 6 && !this.method07440(var1)) {
         if (this.method07448()) {
            return;
         }

         if (this.field18234.method04906(this)
            && this.field18234.method04912() != null
            && ExplosionDamageUtils.method04366(mc.level.getBlockState(this.field18234.method04912()))) {
            this.field18234.method04903(this);
            return;
         }
      }

      this.method07488();
   }

   private BlockPos method07494() {
      return mc.player.tickCount - this.field18245 > 40 ? null : this.field18242;
   }

   private float method07495() {
      float var1 = 0.0F;

      for (CrystalAura.Nested222 var3 : this.field18270) {
         var1 += var3.damage();
      }

      return var1;
   }

   private void method07496(BlockPos var1, Item var2, ExplosionDamageUtils.Nested134 var3) {
      this.field18248 = var1;
      this.field18249 = var2;
      this.field18250 = var3;
      this.field18251 = mc.player.tickCount;
   }

   private AABB method07497(Player var1) {
      int var2 = this.field18195.method03022();
      if (WorldCollisionUtils.method02821(var1.getBoundingBox(), Blocks.COBWEB)) {
         return var1.getBoundingBox();
      }

      SimulatedPlayerInput var3 = this.field18259;
      if (var3 != null && var3.field20215 == var1) {
         SimulatedPlayerInput var7 = var3.method08888();
         int var5 = this.method07478();

         for (int var6 = 0; var6 < var5; var6++) {
            var7.method08897();
         }

         return var7.field20220 != null ? var7.field20220 : var1.getBoundingBox();
      } else {
         if (var2 <= 0) {
            return var1.getBoundingBox();
         }

         SimulatedPlayerInput var4 = SimulatedPlayerInput.method08903(var1, var2);
         return var4.field20220 != null ? var4.field20220 : var1.getBoundingBox();
      }
   }

   private boolean method07498(BlockPos var1) {
      if (this.field18234.method04906(this)) {
         return true;
      }

      if (!var1.equals(this.field18257)) {
         this.field18257 = var1;
         this.field18256 = 1;
      } else {
         this.field18256++;
      }

      return this.field18256 >= 2;
   }

   private boolean method07500(BlockPos var1, Item var2) {
      if (InventoryUtils.method06111(var2, true) == -1) {
         return false;
      } else {
         CrystalAura.Nested223 var3 = this.method07479(var1);
         if (var3 != null && BlockActionQueue.method11512(this, var3.rotation())) {
            this.method07496(var1, var2, var3.face());
            return true;
         } else {
            return false;
         }
      }
   }

   @Override
   public void method00245() {
      ExplosionDamageUtils.method04409(false);
      this.method07477();
      this.field18234.method04904(this);
      this.field18233.method02876();
      BlockActionQueue.method11514(this);
      this.field18273.method09393();
      this.field18274 = null;
      this.field18275 = null;
      this.field18253 = null;
      this.method07436();
      this.field18258.method03802();
      this.field18259 = null;
      this.field18265 = null;
      this.field18255 = 0;
      this.field18256 = 0;
      this.field18235.clear();
      this.field18236.clear();
      this.field18237.clear();
      this.field18238 = 0;
      this.field18240.clear();
      this.field18241.clear();
      this.field18270.clear();
      this.field18242 = null;
      this.field18243 = null;
      this.field18244 = 0;
      super.method00245();
   }

   private void method07501() {
      int var1 = InventoryUtils.method06111(Items.END_CRYSTAL, true);
      if (var1 != -1) {
         this.field18234.method04904(this);
         if (this.field18252 == -1) {
            this.field18252 = mc.player.getInventory().getSelectedSlot();
         }

         if (mc.player.getInventory().getSelectedSlot() != var1) {
            mc.player.getInventory().setSelectedSlot(var1);
         }
      }
   }

   // $VF: Compiled from s
   private record Nested222(int tick, float damage) {
   }

   // $VF: Compiled from s
   private record Nested223(Vector2f rotation, ExplosionDamageUtils.Nested134 face) {
   }
}
