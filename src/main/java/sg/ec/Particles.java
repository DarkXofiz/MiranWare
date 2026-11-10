// Original binary: sg/ec/GvjVbW5O34aeeOCg
package sg.ec;

import java.util.ArrayDeque;
import java.util.Collections;
import java.util.IdentityHashMap;
import java.util.Random;
import java.util.Set;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.projectile.arrow.Arrow;
import net.minecraft.world.entity.projectile.throwableitemprojectile.ThrownEnderpearl;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.phys.Vec3;

// $VF: Compiled from s
public class Particles extends ClientModule {
   private static final double field08173 = 0.07;
   private static final float field08174 = 0;
   private static final String field08175 = "field08175";
   private static final String field08176 = "field08176";
   private static final int field08177 = 0;
   private static final double field08178 = 0;
   private static final double field08179 = 0;
   private static final double field08180 = 0;
   private static final double field08181 = 0;
   private static final double field08182 = 0;
   private static final double field08183 = 0;
   private static final double field08184 = 0;
   private static final float field08185 = 0;
   private static final float field08186 = 0;
   private static final double field08187 = 0;
   private static final int field08188 = 0;
   private final MultiToggleSetting field08189;
   private final ModeSetting field08190;
   private final ModeSetting field08191;
   private final NumberSetting<Integer> field08192;
   private final NumberSetting<Integer> field08193;
   private final MultiToggleSetting field08194;
   private final ToggleSetting field08195;
   private final ArrayDeque<Entity> field08196;
   private final Random field08197;
   private final Set<Block> field08198;
   private int field08199;
   private boolean field08200;
   private static final String field08201 = "Спавнить при";
   private static final String field08202 = "Ударе";
   private static final String field08203 = "Поп тотема";
   private static final String field08204 = "Бездействие";
   private static final String field08205 = "Ходьбе";
   private static final String field08206 = "Эндер жемчуг";
   private static final String field08207 = "Стрела";
   private static final String field08208 = "Выбор условий спавна";
   private static final String field08209 = "Цвет";
   private static final String field08210 = "От темы";
   private static final String field08211 = "Радужные";
   private static final String field08212 = "Радужные";
   private static final String field08213 = "Физика удара";
   private static final String field08214 = "Отскок";
   private static final String field08215 = "Рикошет";
   private static final String field08216 = "Рикошет";
   private static final String field08217 = "Отскок — частицы упираются в блоки и докатываются; Рикошет — отражаются от граней и не тормозят";
   private static final String field08218 = "Спавнить при ударе";
   private static final String field08219 = "Спавнить в мире";
   private static final String field08220 = "Элементы";
   private static final String field08221 = "Орбиз";
   private static final String field08222 = "Звезды";
   private static final String field08223 = "Сердечки";
   private static final String field08224 = "Доллары";
   private static final String field08225 = "Снежинки";
   private static final String field08226 = "Короны";
   private static final String field08227 = "Молнии";
   private static final String field08228 = "Линии";
   private static final String field08229 = "Кругляши";
   private static final String field08230 = "Ромбы";
   private static final String field08231 = "Искры";
   private static final String field08232 = "Свечение";
   private static final String field08233 = "Particles";
   private static final float field08234 = 0.1F;
   private static final float field08235 = 0.225F;
   private static final float field08236 = 0.1F;
   private static final float field08237 = 0.225F;
   private static final double field08238 = 175.0;
   private static final float field08239 = 0.02F;
   private static final double field08240 = 0.07;
   private static final double field08241 = 0.07;
   private static final double field08242 = 0.07;
   private static final float field08243 = 0.98F;
   private static final String field08244 = "Ударе";
   private static final String field08245 = "Рикошет";
   private static final float field08246 = 0.5F;
   private static final float field08247 = 0.1F;
   private static final float field08248 = 0.15F;
   private static final double field08249 = 0.35;
   private static final float field08250 = -0.2F;
   private static final float field08251 = 0.15F;
   private static final double field08252 = 0.25;
   private static final double field08253 = 0.35;
   private static final double field08254 = -0.25;
   private static final double field08255 = 0.25;
   private static final double field08256 = 0.1;
   private static final double field08257 = -0.25;
   private static final double field08258 = 0.25;
   private static final float field08259 = 0.2F;
   private static final float field08260 = 0.9F;
   private static final double field08261 = 0.5;
   private static final double field08262 = 0.5;
   private static final double field08263 = 0.5;
   private static final double field08264 = 0.5;
   private static final double field08265 = 0.5;
   private static final double field08266 = 0.25;
   private static final double field08267 = 0.9;
   private static final double field08268 = 0.25;
   private static final double field08269 = 0.01;
   private static final double field08270 = 0.5;
   private static final double field08271 = 0.25;
   private static final double field08272 = 0.9;
   private static final float field08273 = 0.6F;
   private static final float field08274 = 0.6F;
   private static final double field08275 = 15.0;
   private static final float field08276 = 0.15F;
   private static final String field08277 = "Радужные";
   private static final String field08278 = "Бездействие";
   private static final String field08279 = "Эндер жемчуг";
   private static final String field08280 = "Стрела";
   private static final String field08281 = "Поп тотема";
   private static final double field08282 = 0.35F;
   private static final double field08283 = 8.0E-6F;
   private static final float field08284 = 0.1F;
   private static final float field08285 = 0.225F;
   private static final float field08286 = 3.0F;
   private static final float field08287 = 30.0F;
   private static final float field08288 = 360.0F;
   private static final float field08289 = -15.0F;
   private static final float field08290 = 15.0F;
   private static final float field08291 = -1.0F;
   private static final double field08292 = 8.0E-6F;
   private static final float field08293 = 0.1F;
   private static final float field08294 = 0.225F;
   private static final String field08295 = "Ходьбе";
   private static final float field08296 = -0.5F;
   private static final float field08297 = 0.5F;
   private static final float field08298 = -0.5F;
   private static final float field08299 = 0.5F;
   private static final float field08300 = -0.1F;
   private static final float field08301 = 0.1F;
   private static final float field08302 = -0.1F;
   private static final float field08303 = 0.1F;
   private static final double field08304 = 8.0E-6F;
   private static final float field08305 = 0.1F;
   private static final float field08306 = 0.225F;
   private static final float field08307 = 50.0F;
   private static final String field08308 = "Бездействие";
   private static final String field08309 = "Ударе";
   private static final String field08310 = "Ударе";

   @Override
   public void method00245() {
      super.method00245();
      this.method03735();
   }

   @Subscribe
   private void method03705(PreMovementPacketEvent var1) {
      if (this.field08189.method04520(field08295)) {
         if (mc.player != null) {
            if (var1.method07321() != var1.method07315() || var1.method07306() != var1.method07307() || var1.method07316() != var1.method07298()) {
               for (int var2 = 0; var2 < 2; var2++) {
                  float var3 = mc.player.getBbHeight() * this.field08197.nextFloat();
                  this.method03738(
                     new MutableVector4d(
                        var1.method07321() + this.field08197.nextFloat(field08296, field08297),
                        var1.method07306() + var3,
                        var1.method07316() + this.field08197.nextFloat(field08298, field08299)
                     ),
                     new MutableVector4d(
                           mc.player.getDeltaMovement().x + this.field08197.nextFloat(field08300, field08301),
                           0.0,
                           mc.player.getDeltaMovement().z + this.field08197.nextFloat(field08302, field08303)
                        )
                        .method11133(2.0F * (1.0F + this.field08197.nextFloat())),
                     field08304,
                     800,
                     this.method03728(ClientParticleManager.INSTANCE.method08830() * 50),
                     this.field08197.nextFloat(field08305, field08306),
                     true
                  );
               }
            }
         }
      }
   }

   public ToggleSetting method03706() {
      return this.field08195;
   }

   private static int method03707(int var0) {
      return Math.max(1, Math.round(var0 / field08307));
   }

   public NumberSetting<Integer> method03708() {
      return this.field08192;
   }

   private void method03709(LivingEntity var1) {
      int var2 = method03707(3000);
      int var3 = this.field08192.method03022();

      for (int var4 = 0; var4 < var3; var4++) {
         ClientParticle.Nested35 var5 = new ClientParticle.Nested35(
               var1.getX() + (this.field08197.nextDouble() - field08261) * field08262,
               var1.getY() + this.field08197.nextDouble() * var1.getBbHeight(),
               var1.getZ() + (this.field08197.nextDouble() - field08263) * field08264
            )
            .method01117(
               (this.field08197.nextDouble() * field08265 - field08266) * field08267,
               this.field08197.nextDouble() * field08268 * field08269,
               (this.field08197.nextDouble() * field08270 - field08271) * field08272
            )
            .method01129(ParticleCollisionMode.RICOCHET)
            .method01105(ParticleInterpolationMode.LINEAR)
            .method01112(1.0F)
            .method01109(true)
            .method01120(field08273, field08274)
            .method01127(var2)
            .method01097(field08275);
         ClientParticleManager.INSTANCE.method08834(var5, this.method03728(var4 * 30), field08276, var2);
      }
   }

   private void method03710() {
      Vec3 var1 = mc.gameRenderer.mainCamera().position();
      double var2 = var1.x();
      double var4 = var1.y();
      double var6 = var1.z();
      float var8 = field08286;
      if (this.field08199 % 15 == 0) {
         int var9 = this.field08193.method03022() * 10;

         for (int var10 = 0; var10 < var9; var10++) {
            double var11 = this.field08197.nextFloat(1.0F, field08287);
            double var13 = Math.toRadians(this.field08197.nextFloat(0.0F, field08288));
            double var15 = -Math.sin(var13) * var11;
            double var17 = Math.cos(var13) * var11;
            this.method03738(
               new MutableVector4d(var2 + var15, var4 + this.field08197.nextFloat(field08289, field08290), var6 + var17),
               new MutableVector4d(
                  this.field08197.nextFloat(-var8, var8), this.field08197.nextFloat(field08291, 1.0F), this.field08197.nextFloat(-var8, var8)
               ),
               field08292,
               2500,
               this.method03728(ClientParticleManager.INSTANCE.method08830() * 50),
               this.field08197.nextFloat(field08293, field08294),
               true
            );
         }

         this.field08199 = 0;
      }
   }

   private void method03711(Entity var1) {
      if (!(MovementUtils.method05729(var1) < field08282)) {
         Vec3 var2 = var1.position();
         Vec3 var3 = var1.getDeltaMovement();
         double var4 = var2.x();
         double var6 = var2.y();
         double var8 = var2.z();
         double var10 = var3.x();
         double var12 = var3.y();
         double var14 = var3.z();

         for (int var16 = 0; var16 < 5; var16++) {
            float var17 = this.field08197.nextFloat();
            this.method03738(
               new MutableVector4d(var4, var6, var8),
               new MutableVector4d(
                  this.field08197.nextFloat(-var17, var17) + var10,
                  this.field08197.nextFloat(-var17, var17) + var12,
                  this.field08197.nextFloat(-var17, var17) + var14
               ),
               field08283,
               1000,
               this.method03728(ClientParticleManager.INSTANCE.method08830() * 50),
               this.field08197.nextFloat(field08284, field08285),
               true
            );
         }
      }
   }

   public ModeSetting method03712() {
      return this.field08191;
   }

   public Random method03713() {
      return this.field08197;
   }

   private void method03714(MutableVector4d var1, MutableVector4d var2, double var3, int var5, int var6, float var7, boolean var8, int var9) {
      this.method03736(var1, var2, var3, var5, 300, var6, var7, var8, var9);
   }

   public boolean method03715() {
      return this.field08200;
   }

   public ModeSetting method03716() {
      return this.field08190;
   }

   private void method03717(MutableVector4d var1, MutableVector4d var2, double var3, int var5, int var6, int var7, float var8, boolean var9) {
      this.method03736(var1, var2, var3, var5, var6, var7, var8, var9, 0);
   }

   @Subscribe
   private void method03718(TickEvent var1) {
      this.field08200 = this.field08190.method05600(field08277);
      if (mc.level == null) {
         this.method03735();
      } else {
         this.field08199++;
         boolean var2 = this.field08189.method04520(field08278);
         boolean var3 = this.field08189.method04520(field08279);
         boolean var4 = this.field08189.method04520(field08280);
         boolean var5 = this.field08189.method04520(field08281);
         this.method03723(var5);
         if (var2) {
            this.method03710();
         }

         this.method03737(var3, var4);
      }
   }

   public Particles() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field08189 = new MultiToggleSetting(field08201)
         .method04517(NamedOption.method08077(field08202, true))
         .method04517(NamedOption.method08077(field08203, true))
         .method04517(NamedOption.method08077(field08204, false))
         .method04517(NamedOption.method08077(field08205, true))
         .method04517(NamedOption.method08077(field08206, false))
         .method04517(NamedOption.method08077(field08207, false))
         .method03018(field08208)
         .method03023(this);
      this.field08190 = new ModeSetting(field08209).method05597(field08210, field08211).method03017(field08212).method03023(this);
      this.field08191 = new ModeSetting(field08213)
         .method05597(field08214, field08215)
         .method03017(field08216)
         .method03018(field08217)
         .method03025(() -> this.field08189.method04520(field08310))
         .method03023(this);
      this.field08192 = new NumberSetting<Integer>(field08218)
         .method10835(5)
         .method10838(50)
         .method10834(1)
         .method03017(15)
         .method03025(() -> this.field08189.method04520(field08309))
         .method03023(this);
      this.field08193 = new NumberSetting<Integer>(field08219)
         .method10835(3)
         .method10838(50)
         .method10834(1)
         .method03017(20)
         .method03025(() -> this.field08189.method04520(field08308))
         .method03023(this);
      this.field08194 = new MultiToggleSetting(field08220)
         .method04517(NamedOption.method08077(field08221, true))
         .method04517(NamedOption.method08077(field08222, false))
         .method04517(NamedOption.method08077(field08223, false))
         .method04517(NamedOption.method08077(field08224, false))
         .method04517(NamedOption.method08077(field08225, false))
         .method04517(NamedOption.method08077(field08226, false))
         .method04517(NamedOption.method08077(field08227, false))
         .method04517(NamedOption.method08077(field08228, false))
         .method04517(NamedOption.method08077(field08229, false))
         .method04517(NamedOption.method08077(field08230, false))
         .method04517(NamedOption.method08077(field08231, false))
         .method04521(1)
         .method03023(this);
      this.field08195 = new ToggleSetting(field08232).method03014(false).method03023(this);
      this.field08196 = new ArrayDeque<>();
      this.field08197 = new Random();
      this.field08198 = Collections.newSetFromMap(new IdentityHashMap<>());
      this.field08200 = false;
      this.method03935(field08233);
      this.method03720();
   }

   private void method03720() {
      this.field08198.add(Blocks.AIR);
      this.field08198.add(Blocks.CAVE_AIR);
      this.field08198.add(Blocks.VOID_AIR);
      this.field08198.add(Blocks.WATER);
      this.field08198.add(Blocks.LAVA);
      this.field08198.add(Blocks.GRASS_BLOCK);
      this.field08198.add(Blocks.TALL_GRASS);
      this.field08198.add(Blocks.FERN);
      this.field08198.add(Blocks.LARGE_FERN);
      this.field08198.add(Blocks.DEAD_BUSH);
      this.field08198.add(Blocks.SEAGRASS);
      this.field08198.add(Blocks.TALL_SEAGRASS);
      this.field08198.add(Blocks.VINE);
      this.field08198.add(Blocks.GLOW_LICHEN);
      this.field08198.add(Blocks.SUGAR_CANE);
      this.field08198.add(Blocks.CACTUS);
      this.field08198.add(Blocks.SNOW);
      this.field08198.add(Blocks.COBWEB);
      this.field08198.add(Blocks.ICE);
      this.field08198.add(Blocks.PACKED_ICE);
      this.field08198.add(Blocks.BLUE_ICE);
      this.field08198.add(Blocks.FROSTED_ICE);
      this.field08198.add(Blocks.SLIME_BLOCK);
      this.field08198.add(Blocks.HONEY_BLOCK);
   }

   public MultiToggleSetting method03721() {
      return this.field08189;
   }

   @Subscribe
   private void method03722(AttackEntityEvent var1) {
      if (var1.method09431() != AttackEntityEvent.Nested264.POST) {
         if (mc.player != null && mc.level != null) {
            if (this.field08189.method04520(field08244)) {
               if (var1.method09434() instanceof LivingEntity var2) {
                  if (this.field08191.method05600(field08245)) {
                     this.method03709(var2);
                  } else {
                     this.method03733(var2);
                  }
               }
            }
         }
      }
   }

   private void method03723(boolean var1) {
      if (!this.field08196.isEmpty()) {
         if (!var1) {
            this.field08196.clear();
         } else {
            Entity var2;
            while ((var2 = this.field08196.pollFirst()) != null) {
               ClientParticleManager.INSTANCE.method08838(var2, 30);
            }
         }
      }
   }

   private void method03724(Arrow var1) {
      this.method03711(var1);
   }

   private void method03725(MutableVector4d var1, MutableVector4d var2, double var3, int var5, int var6) {
      this.method03717(var1, var2, var3, var5, 300, var6, this.field08197.nextFloat(field08234, field08235), false);
   }

   public MultiToggleSetting method03726() {
      return this.field08194;
   }

   private void method03727(ThrownEnderpearl var1) {
      this.method03711(var1);
   }

   public int method03728(int var1) {
      return this.field08200 ? ColorUtils.method04600(1, this.field08197.nextInt(), 1.0F, 1.0F, 1.0F) : ColorUtils.Nested138.method04638(var1);
   }

   public NumberSetting<Integer> method03729() {
      return this.field08193;
   }

   @Override
   public void method00276() {
      super.method00276();
      this.method03735();
   }

   public ArrayDeque<Entity> method03731() {
      return this.field08196;
   }

   private void method03732(MutableVector4d var1, MutableVector4d var2, double var3, int var5, int var6, int var7) {
      this.method03717(var1, var2, var3, var5, var6, var7, this.field08197.nextFloat(field08236, field08237), false);
   }

   private void method03733(LivingEntity var1) {
      float var2 = field08246;
      Vec3 var3 = var1.getDeltaMovement();

      for (int var4 = 0; var4 < this.field08192.method03022(); var4++) {
         float var5 = this.field08197.nextFloat(field08247, field08248);
         int var6 = this.field08197.nextInt(40, 60);
         int var7 = Math.max(12, var6 / 2);
         double var8 = this.field08197.nextFloat(-var2, var2) + var3.x * field08249;
         double var10 = this.field08197.nextFloat(field08250, field08251) + Math.max(0.0, var3.y) * field08252;
         double var12 = this.field08197.nextFloat(-var2, var2) + var3.z * field08253;
         ClientParticle.Nested35 var14 = new ClientParticle.Nested35(
               var1.getX() + this.field08197.nextDouble(field08254, field08255),
               var1.getY() + this.field08197.nextDouble(field08256, var1.getBbHeight()),
               var1.getZ() + this.field08197.nextDouble(field08257, field08258)
            )
            .method01117(var8, var10, var12)
            .method01112(field08259)
            .method01113(true)
            .method01110(field08260)
            .method01100(2.0F)
            .method01109(true)
            .method01120(var5, var5)
            .method01127(var6)
            .method01115(this.field08197.nextInt(1, 3));
         ClientParticleManager.INSTANCE.method08834(var14, this.method03728(this.field08197.nextInt()), var5, var7);
      }
   }

   public Set<Block> method03734() {
      return this.field08198;
   }

   private void method03735() {
      this.field08196.clear();
      this.field08199 = 0;
   }

   private void method03736(MutableVector4d var1, MutableVector4d var2, double var3, int var5, int var6, int var7, float var8, boolean var9, int var10) {
      if (mc.level != null) {
         Block var11 = mc.level.getBlockState(BlockPos.containing(var1.field24957, var1.field24958, var1.field24959)).getBlock();
         if (this.field08198.contains(var11)) {
            int var12 = method03707(var5);
            int var13 = method03707(var6);
            float var14 = (float)Math.max(0.0, var3 * field08238);
            float var15 = Math.max(field08239, var8);
            ClientParticle.Nested35 var16 = new ClientParticle.Nested35(var1.field24957, var1.field24958, var1.field24959)
               .method01117(var2.field24957 * field08240, var2.field24958 * field08241, var2.field24959 * field08242)
               .method01112(var14)
               .method01127(var12)
               .method01110(field08243)
               .method01109(!var9)
               .method01120(var15, var15)
               .method01115(var10);
            ClientParticleManager.INSTANCE.method08834(var16, var7, var8, var13);
         }
      }
   }

   private void method03737(boolean var1, boolean var2) {
      if (mc.level != null) {
         for (Entity var4 : mc.level.entitiesForRendering()) {
            if (var1 && var4 instanceof ThrownEnderpearl var5) {
               this.method03727(var5);
            }

            if (var2 && var4 instanceof Arrow var6) {
               this.method03724(var6);
            }
         }
      }
   }

   private void method03738(MutableVector4d var1, MutableVector4d var2, double var3, int var5, int var6, float var7, boolean var8) {
      this.method03717(var1, var2, var3, var5, 300, var6, var7, var8);
   }

   public int method03739() {
      return this.field08199;
   }

   @Subscribe
   private void method03740(TotemPopEvent var1) {
      Entity var2 = var1.method01501();
      if (var2 != null) {
         this.field08196.addLast(var2);
      }
   }
}
