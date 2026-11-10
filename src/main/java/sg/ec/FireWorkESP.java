// Original binary: sg/ec/zsG2mJ083CXH2V7K
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.network.protocol.game.ClientboundSoundPacket;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.projectile.FireworkRocketEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.phys.Vec3;
import org.joml.Vector2f;

// $VF: Compiled from s
public class FireWorkESP extends ClientModule {
   private final NumberSetting<Long> field27951;
   private final ToggleSetting field27952;
   private final List<FireWorkESP.Nested334> field27953;
   private static final String field27954 = "Время жизни";
   private static final long field27955 = 1000L;
   private static final long field27956 = 5000L;
   private static final long field27957 = 100L;
   private static final long field27958 = 2500L;
   private static final String field27959 = "Отображать количество";
   private static final String field27960 = "FireWork ESP";
   private static final float field27961 = 18.0F;
   private static final float field27962 = 7.0F;
   private static final float field27963 = 10.0F;
   private static final float field27964 = 6.5F;
   private static final float field27965 = 1.5F;
   private static final float field27966 = 1.5F;
   private static final float field27967 = 0.9F;
   private static final float field27968 = 0.01F;

   public FireWorkESP() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field27951 = new NumberSetting<Long>(field27954)
         .method10835(field27955)
         .method10838(field27956)
         .method10834(field27957)
         .method03017(field27958)
         .method03023(this);
      this.field27952 = new ToggleSetting(field27959).method03017(false).method03023(this);
      this.field27953 = new CopyOnWriteArrayList<>();
      this.method03935(field27960);
   }

   @Subscribe
   private void method11776(PacketEvent var1) {
      if (var1.method10904()) {
         if (var1.method10897() instanceof ClientboundSoundPacket var3) {
            long var4 = System.currentTimeMillis();
            if (var3.getSound().value() == SoundEvents.FIREWORK_ROCKET_LAUNCH) {
               this.field27953
                  .add(new FireWorkESP.Nested334(new Vec3(var3.getX(), var3.getY(), var3.getZ()), new ItemStack(Items.FIREWORK_ROCKET), var4));
            }
         }
      }
   }

   @Subscribe(1)
   private void method11777(HudRenderEvent var1) {
      long var2 = System.currentTimeMillis();
      float var4 = field27961;
      float var5 = field27962;
      int var6 = ColorUtils.method04597(30, 30, 30, 150);
      float var7 = (float)this.field27951.method03022().longValue();
      boolean var8 = this.field27952.method03022();
      GuiGraphicsExtractor var9 = var1.method05424();
      PoseStack var10 = var1.method05425();
      ItemRenderUtils.method08410();
      GuiRenderBatch.method05194();

      for (FireWorkESP.Nested334 var12 : this.field27953) {
         ItemStack var13 = var12.method11789();
         AnimationUtils var14 = var12.method11786();
         var14.method03375((float)(var2 - var12.method11779()) < var7 ? 1.0 : 0.0);
         if (var12.method11787()) {
            float var15 = var14.method03377();
            Vector2f var16 = WorldProjectionUtils.method09460(var10, var12.method11784());
            float var17 = var16.x;
            float var18 = var16.y;
            RoundedRectRenderer.method01272(var9, var17, var18, var4, var4, var5, 1.0F, ColorUtils.method04611(var6, var15));
            if (var8) {
               int var19 = var13.getCount();
               Fonts.field00109
                  .method09473(var9, var19 + "", var17 + var4 / 2.0F, var18 + field27963, ColorUtils.method04611(-1, var15), field27964);
            }

            ItemRenderUtils.method08415(var9, var13, var17 + field27965, var18 + field27966, 1.0F, var15, field27967);
         }
      }

      GuiRenderBatch.method05181();
      RoundedRectRenderer.method01278();
      ItemRenderUtils.method08420();
   }

   @Subscribe
   private void method11778(PlayerUpdateEvent var1) {
      long var2 = System.currentTimeMillis();
      this.field27953.removeIf(var3 -> var2 - var3.method11779() > this.field27951.method03022() && var3.method11786().method03377() < field27968);
      PoseStack var4 = new PoseStack();
      int var5 = mc.getWindow().getGuiScaledWidth();
      int var6 = mc.getWindow().getGuiScaledHeight();

      for (FireWorkESP.Nested334 var8 : this.field27953) {
         Vec3 var9 = var8.method11784();
         Vector2f var10 = WorldProjectionUtils.method09460(var4, var9);
         boolean var11 = var10.x >= 0.0F && var10.x <= var5 && var10.y >= 0.0F && var10.y <= var6;
         var8.method11780(var11);
      }

      if (mc.player.tickCount % 2 == 0) {
         for (Entity var14 : mc.level.entitiesForRendering()) {
            if (var14 instanceof FireworkRocketEntity var15) {
               Vec3 var16 = var15.position().add(0.0, var15.getBbHeight() / 2.0F, 0.0);
               int var17 = var15.getId();
               FireWorkESP.Nested334 var12 = new FireWorkESP.Nested334(var16, var15.getItem(), var2);
               var12.method11781(var17);
               this.field27953.add(var12);
            }
         }
      }
   }

   // $VF: Compiled from s
   private static class Nested334 {
      private Vec3 field27969;
      private AnimationUtils field27970;
      private ItemStack field27971;
      private boolean field27972;
      private long field27973;
      private int field27974 = -1;
      private static final long field27975 = 300L;

      public long method11779() {
         return this.field27973;
      }

      public void method11780(boolean var1) {
         this.field27972 = var1;
      }

      public void method11781(int var1) {
         this.field27974 = var1;
      }

      public void method11782(ItemStack var1) {
         this.field27971 = var1;
      }

      public int method11783() {
         return this.field27974;
      }

      public Vec3 method11784() {
         return this.field27969;
      }

      public void method11785(AnimationUtils var1) {
         this.field27970 = var1;
      }

      public AnimationUtils method11786() {
         return this.field27970;
      }

      public boolean method11787() {
         return this.field27972;
      }

      public void method11788(Vec3 var1) {
         this.field27969 = var1;
      }

      public ItemStack method11789() {
         return this.field27971;
      }

      public void method11790(long var1) {
         this.field27973 = var1;
      }

      public Nested334(Vec3 var1, ItemStack var2, long var3) {
         this.field27969 = var1;
         this.field27971 = var2;
         this.field27973 = var3;
         this.field27970 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field27975);
      }
   }
}
