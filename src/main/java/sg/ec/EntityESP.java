// Original binary: sg/ec/kmGA4ju4JQzPLBmB
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import net.minecraft.client.gui.GuiGraphicsExtractor;
import net.minecraft.client.renderer.entity.EntityRenderDispatcher;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.npc.villager.Villager;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTrader;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;

// $VF: Compiled from s
public class EntityESP extends ClientModule {
   private static final int field20841 = -16777216;
   private static final float field20842 = 0;
   private static final float field20843 = 0;
   private static final float field20844 = 0;
   private static final float field20845 = 0;
   private static final int field20846 = 0;
   private final EntityEspStyle field20847;
   private final EntityEspStyle field20848;
   private final EntityEspStyle field20849;
   private final EntityEspStyle field20850;
   private final EntityEspStyle field20851;
   private final EntityEspStyle field20852;
   private final EntityEspStyle[] field20853;
   private final EntityEspStyle[] field20854;
   private final ActionSetting field20855;
   private final List<Setting<?>> field20856;
   private final EntityEspRenderer field20857;
   private final EntityEspRenderer.Nested300 field20858;
   private final Vec3 field20859;
   private int field20860;
   private int field20861;
   private static final String field20862 = "Себя";
   private static final String field20863 = "players_self";
   private static final String field20864 = "Все";
   private static final String field20865 = "players_all";
   private static final String field20866 = "Друзья";
   private static final String field20867 = "players_friends";
   private static final String field20868 = "Мобы";
   private static final String field20869 = "mobs";
   private static final String field20870 = "Жители";
   private static final String field20871 = "villagers";
   private static final String field20872 = "Предметы";
   private static final String field20873 = "items";
   private static final String field20874 = "Открыть настройки";
   private static final double field20875 = 150.0;
   private static final String field20876 = "Entity ESP";
   private static final float field20877 = (float) (Math.PI / 180.0);
   private static final float field20878 = (float) (Math.PI / 180.0);
   private static final float field20879 = 0.5F;
   private static final int field20880 = -16777216;
   private static final int field20881 = -16777216;
   private static final float field20882 = 0.5F;
   private static final float field20883 = 0.5F;
   private static final String field20884 = "Индивидуальный";
   private static final String field20885 = "Клиентский";
   private static final int field20886 = -16711936;
   private static final int field20887 = -65536;
   private static final float field20888 = 0.6F;
   private static final float field20889 = 0.5F;
   private static final int field20890 = 16777215;
   private static final float field20891 = 0.25F;
   private static final float field20892 = 0.25F;
   private static final float field20893 = 0.5F;
   private static final float field20894 = 0.25F;
   private static final float field20895 = 0.75F;
   private static final float field20896 = 0.5F;
   private static final float field20897 = 3.0F;
   private static final float field20898 = 0.75F;
   private static final float field20899 = 0.75F;
   private static final float field20900 = 1.5F;
   private static final float field20901 = 1.5F;
   private static final int field20902 = -16777216;
   private static final int field20903 = -16777216;
   private static final float field20904 = -2.0F;
   private static final int field20905 = 16777215;
   private static final float field20906 = 3.0F;
   private static final float field20907 = 1.0E-4F;
   private static final float field20908 = 1.0E-4F;

   private void method09203(
      GuiGraphicsExtractor var1,
      float var2,
      float var3,
      float var4,
      float var5,
      Entity var6,
      EntityEspStyle var7,
      int var8,
      int var9,
      float var10,
      float var11
   ) {
      boolean var12 = var10 < 1.0F;
      float sx = var2;
      if (var7.method07129()) {
         int sxx;
         int sxxx;
         if (var7.method07139()) {
            sxx = sxxx = var7.method07160().method11676();
         } else {
            sxx = var8;
            sxxx = var9;
         }

         if (var12) {
            sxx = this.method09213(sxx, var10);
            sxxx = this.method09213(sxxx, var10);
         }

         int sxxxx = var12 ? this.method09213(field20880, var10) : field20881;
         float sxxxxx = var4;
         if (var7.method07142()) {
            this.method09230(var1, sx, var3, sxxxxx, var5, sxxxx, sxxxx, field20882);
            this.method09230(var1, sx, var3, sxxxxx, var5, sxx, sxxx, 0.0F);
         } else {
            this.method09232(var1, sx, var3, sxxxxx, var5, sxxxx, sxxxx, field20883);
            this.method09232(var1, sx, var3, sxxxxx, var5, sxx, sxxx, 0.0F);
         }
      }

      if (var7.method07122() && var6 instanceof LivingEntity) {
         float sxx = var11;
         int sxxx;
         int sxxxx;
         if (var7.method07121().method05600(field20884)) {
            sxxx = var7.method07164().method11676();
            sxxxx = var7.method07116().method11676();
         } else if (var7.method07121().method05600(field20885)) {
            sxxx = var8;
            sxxxx = var9;
         } else {
            sxxx = ColorUtils.method04627(field20886, field20887, sxx);
            sxxxx = ColorUtils.method04596(sxxx, field20888);
         }

         if (var12) {
            sxxx = this.method09213(sxxx, var10);
            sxxxx = this.method09213(sxxxx, var10);
         }

         this.method09226(var1, sx, var3, var5, sxx, sxxx, sxxxx, var10);
      }
   }

   @Subscribe
   private void method09204(EntityOutlineColorEvent var1) {
      int var2 = this.method09224(var1.method00863());
      if (var2 != 0) {
         var1.method00862(var2);
      }
   }

   private boolean method09205() {
      for (EntityEspStyle var4 : this.field20854) {
         if (var4 != this.field20847 && var4.method07154() && var4.method07125()) {
            return true;
         }
      }

      return false;
   }

   @Subscribe
   private void method09206(RenderTargetEvent var1) {
      if (EntityGlowRenderer.method07037(var1.method00003(), var1.method00005())) {
         var1.method05695(true);
      }
   }

   @Subscribe
   private void method09207(Render3DEvent var1) {
      if (mc.player != null && mc.level != null && this.method03937() && this.method09205()) {
         if (var1.method00985().method07407(EffectRenderPipelines.method05563()) instanceof BaritoneVertexConsumerAccess var3) {
            float var4 = var1.method00984().getGameTimeDeltaPartialTick(true);
            EntityRenderDispatcher var5 = mc.getEntityRenderDispatcher();
            Vec3 var6 = this.field20859.xRot(-var5.camera.xRot() * field20877).yRot(-var5.camera.yRot() * field20878);
            Vec3 var7 = var1.method00994().position();
            PoseStack var8 = var1.method00996();
            var8.pushPose();
            Matrix4f var9 = var8.last().pose();
            float var10 = (float)var6.x;
            float var11 = (float)var6.y;
            float var12 = (float)var6.z;
            int var13 = this.field20857.method10342();

            for (int var14 = 0; var14 < var13; var14++) {
               if (this.field20857.method10358(var14)) {
                  EntityEspStyle var15 = this.field20857.method10360(var14);
                  if (var15 != null && var15 != this.field20847 && var15.method07154() && var15.method07125()) {
                     Entity var16 = this.field20857.method10355(var14);
                     Vec3 var17 = var16.getPosition(var4);
                     float var18 = (float)(var17.x - var7.x);
                     float var19 = (float)(var17.y + var16.getBbHeight() * field20879 - var7.y);
                     float var20 = (float)(var17.z - var7.z);
                     float var21 = var18 - var10;
                     float var22 = var19 - var11;
                     float var23 = var20 - var12;
                     float var24 = method09228(var21, var22, var23);
                     if (var24 != 0.0F) {
                        var21 /= var24;
                        var22 /= var24;
                        var23 /= var24;
                     } else {
                        var21 = 0.0F;
                        var22 = 1.0F;
                        var23 = 0.0F;
                     }

                     int var25 = var15.method07157();
                     float var26 = var15.method07165();
                     var3.lineVertex(var9, var10, var11, var12, var25, var21, var22, var23, var26);
                     var3.lineVertex(var9, var18, var19, var20, var25, var21, var22, var23, var26);
                  }
               }
            }

            var8.popPose();
         }
      }
   }

   public List<Setting<?>> method09209(int var1, int var2) {
      return this.method09225(var1, var2).method07163();
   }

   public float method09210(int var1) {
      return this.field20854[var1].method07159();
   }

   public boolean method09211(int var1) {
      return this.method03937() && this.field20854[var1].method07154() && this.field20854[var1].method07158();
   }

   @Override
   public List<Setting<?>> method03932() {
      return this.field20856;
   }

   @Subscribe
   private void method09212(TickEvent var1) {
      this.field20857.method10343(this.field20858);
   }

   private int method09213(int var1, float var2) {
      int var3 = (int)((var1 >>> 24 & 0xFF) * var2 + field20889);
      return var1 & field20890 | var3 << 24;
   }

   private void method09214(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, CornerColors var6) {
      RoundedRectRenderer.method01275(var1, var2, var3, var4, var5, 0.0F, field20904, var6);
   }

   private EntityEspStyle method09215(Entity var1) {
      if (var1 instanceof ItemEntity) {
         return this.field20852;
      }

      if (var1 instanceof Player var2) {
         if (var1 == mc.player) {
            return this.field20847;
         } else if (ModuleManager.INSTANCE.method08260().method00605(var2)) {
            return null;
         } else {
            return FriendManager.INSTANCE.method00172(var2) ? this.field20849 : this.field20848;
         }
      } else if (!(var1 instanceof LivingEntity)) {
         return null;
      } else if (!(var1 instanceof Villager) && !(var1 instanceof WanderingTrader)) {
         return var1 instanceof Mob ? this.field20850 : null;
      } else {
         return this.field20851;
      }
   }

   private void method09216(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, int var6) {
      this.method09214(var1, var2, var3, var4, var5, new CornerColors(var6));
   }

   public int method09217(Entity var1) {
      if (!this.method03937()) {
         return -1;
      }

      EntityEspStyle var2 = this.method09215(var1);
      if (var2 != null && var2.method07154() && var2.method07158()) {
         for (int var3 = 0; var3 < this.field20854.length; var3++) {
            if (this.field20854[var3] == var2) {
               return var3;
            }
         }

         return -1;
      } else {
         return -1;
      }
   }

   public void method09218(GuiGraphicsExtractor var1, Entity var2, EntityEspStyle var3, float var4, float var5, float var6, float var7, float var8) {
      int var9 = ColorUtils.Nested138.method04638(80);
      int var10 = ColorUtils.Nested138.method04638(260);
      float var11 = 1.0F;
      if (var2 instanceof LivingEntity var12) {
         var11 = Math.max(0.0F, Math.min(1.0F, var12.getHealth() / Math.max(1.0F, var12.getMaxHealth())));
      }

      this.method09203(var1, var4, var5, var6, var7, var2, var3, var9, var10, var8, var11);
   }

   public EntityESP() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field20847 = new EntityEspStyle(
         this, field20862, field20863, EntityEspStyle.Nested209.PLAYER, SimpleVoiceChatCompatibility.method09182(), false, false
      );
      this.field20848 = new EntityEspStyle(this, field20864, field20865, EntityEspStyle.Nested209.PLAYER, SimpleVoiceChatCompatibility.method09182(), true, true);
      this.field20849 = new EntityEspStyle(this, field20866, field20867, EntityEspStyle.Nested209.PLAYER, SimpleVoiceChatCompatibility.method09182(), true, true);
      this.field20850 = new EntityEspStyle(this, field20868, field20869, EntityEspStyle.Nested209.LIVING, false, false, true);
      this.field20851 = new EntityEspStyle(this, field20870, field20871, EntityEspStyle.Nested209.LIVING, false, false, true);
      this.field20852 = new EntityEspStyle(this, field20872, field20873, EntityEspStyle.Nested209.ITEM, false, true, true);
      this.field20853 = new EntityEspStyle[]{this.field20847, this.field20848, this.field20849};
      this.field20854 = new EntityEspStyle[]{this.field20847, this.field20848, this.field20849, this.field20850, this.field20851, this.field20852};
      this.field20855 = new ActionSetting(field20874).method03017(() -> MiranWare.getInstance().getMenuScreen().method10012());
      this.field20856 = List.of(this.field20855);
      this.field20857 = new EntityEspRenderer();
      this.field20858 = this::method09223;
      this.field20859 = new Vec3(0.0, 0.0, field20875);
      this.method03935(field20876);
   }

   public int method09219() {
      return this.field20854.length;
   }

   private void method09220(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, int var6, int var7, float var8) {
      this.method09214(var1, var2 - var8, var3 - var8, var4 + var8 * 2.0F, var5 + var8 * 2.0F, new CornerColors(var6, var7, var7, var6));
   }

   public float method09221(int var1) {
      return this.field20854[var1].method07167();
   }

   public boolean method09222() {
      if (!this.method03937()) {
         return false;
      }

      for (EntityEspStyle var4 : this.field20854) {
         if (var4.method07154() && var4.method07158()) {
            return true;
         }
      }

      return false;
   }

   private EntityEspStyle method09223(Entity var1) {
      if (var1 != null && var1.isAlive()) {
         EntityEspStyle var2 = this.method09215(var1);
         if (var2 == null || !var2.method07154()) {
            return null;
         } else {
            return !var2.method07119() && !var2.method07129() && !var2.method07122() ? null : var2;
         }
      } else {
         return null;
      }
   }

   public int method09224(Entity var1) {
      int var2 = this.method09217(var1);
      if (var2 < 0) {
         return 0;
      }

      EntityEspStyle var3 = this.field20854[var2];
      boolean var4 = var3.method07146();
      return EspColorUtils.method09876(var2, var4, var4 ? field20905 : var3.method07148().method11676());
   }

   public EntityEspStyle method09225(int var1, int var2) {
      return switch (var1) {
         case 1 -> this.field20850;
         case 2 -> this.field20851;
         case 3 -> this.field20852;
         default -> this.field20853[Math.max(0, Math.min(this.field20853.length - 1, var2))];
      };
   }

   private void method09226(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, int var6, int var7, float var8) {
      float var9 = var2 - field20897;
      float var10 = var3;
      float var11 = Math.max(1.0F, var4 - var3);
      float var12 = Math.max(1.0F, var11 * var5);
      float var13 = var10 + (var11 - var12);
      this.method09216(
         var1, var9 - field20898, var10 - field20899, field20900, var11 + field20901, var8 < 1.0F ? this.method09213(field20902, var8) : field20903
      );
      this.method09214(var1, var9, var13, 0.0F, var12, new CornerColors(var6, var7, var7, var6));
   }

   @Subscribe(0)
   private void method09227(HudRenderEvent var1) {
      if (mc.player != null && mc.level != null) {
         GuiGraphicsExtractor var2 = var1.method05424();
         PoseStack var3 = var1.method05425();
         float var4 = var1.method05421().getGameTimeDeltaPartialTick(true);
         this.field20860 = ColorUtils.Nested138.method04638(80);
         this.field20861 = ColorUtils.Nested138.method04638(260);
         this.field20857.method10348(var2, var3, var4, this::method09238);
      }
   }

   static float method09228(float var0, float var1, float var2) {
      float var3 = Mth.sqrt(var0 * var0 + var1 * var1 + var2 * var2);
      return var3 > field20907 ? var3 : 0.0F;
   }

   public void method09229(GuiGraphicsExtractor var1, Entity var2, EntityEspStyle var3, float var4, float var5, float var6, float var7) {
      this.field20857.method10354(var1, var2, var3, var4, var5, var6, var7);
   }

   @Override
   public void method00245() {
      super.method00245();
      this.field20857.method10338();
   }

   private void method09230(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, int var6, int var7, float var8) {
      float var9 = var4 - var2;
      float var10 = var5 - var3;
      if (!(var9 < 2.0F) && !(var10 < 2.0F)) {
         float var11 = var9 * field20891;
         float var12 = var10 * field20892;
         float var13 = field20893;
         int var14 = ColorUtils.method04627(var7, var6, field20894);
         int var15 = ColorUtils.method04627(var7, var6, field20895);
         this.method09220(var1, var2, var3, var11, var13, var6, var6, var8);
         this.method09220(var1, var2, var3, var13, var12, var6, var14, var8);
         this.method09220(var1, var4 - var11, var3, var11, var13, var6, var6, var8);
         this.method09220(var1, var4 - var13, var3, var13, var12, var6, var14, var8);
         this.method09220(var1, var2, var5 - var13, var11, var13, var7, var7, var8);
         this.method09220(var1, var2, var5 - var12, var13, var12, var15, var7, var8);
         this.method09220(var1, var4 - var11, var5 - var13, var11, var13, var7, var7, var8);
         this.method09220(var1, var4 - var13, var5 - var12, var13, var12, var15, var7, var8);
      }
   }

   static float method09231(float var0, float var1) {
      float var2 = Mth.sqrt(var0 * var0 + var1 * var1);
      return var2 > field20908 ? var2 : 0.0F;
   }

   private void method09232(GuiGraphicsExtractor var1, float var2, float var3, float var4, float var5, int var6, int var7, float var8) {
      float var9 = var4 - var2;
      float var10 = var5 - var3;
      if (!(var9 < 2.0F) && !(var10 < 2.0F)) {
         float var11 = field20896;
         this.method09220(var1, var2, var3, var9, var11, var6, var6, var8);
         this.method09220(var1, var2, var5 - var11, var9, var11, var7, var7, var8);
         this.method09220(var1, var2, var3, var11, var10, var6, var7, var8);
         this.method09220(var1, var4 - var11, var3, var11, var10, var6, var7, var8);
      }
   }

   public EntityEspStyle[] method09233() {
      return this.field20853;
   }

   public float method09234(int var1) {
      EntityEspStyle var2 = this.field20854[var1];
      return var2.method07138() ? var2.method07136() : var2.method07167() + field20906;
   }

   @Subscribe
   private void method09235(NameTagRenderEvent var1) {
      if (this.field20857.method10337(var1.method02158())) {
         var1.method05695(true);
      }
   }

   public boolean method09236(int var1) {
      return this.field20854[var1].method07146();
   }

   public boolean method09237(int var1) {
      return this.field20854[var1].method07138();
   }

   private void method09238(
      GuiGraphicsExtractor var1, Entity var2, EntityEspStyle var3, float var4, float var5, float var6, float var7, float var8, float var9
   ) {
      if (var3.method07129() || var3.method07122()) {
         this.method09203(var1, var4, var5, var6, var7, var2, var3, this.field20860, this.field20861, var8, var9);
      }
   }
}
