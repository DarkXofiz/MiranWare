// Original binary: sg/ec/WzWYhszHusT6LXtp
package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import java.util.List;
import net.minecraft.client.CameraType;
import net.minecraft.client.player.LocalPlayer;
import net.minecraft.client.renderer.culling.Frustum;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.util.Mth;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.phys.Vec3;
import org.joml.Matrix4f;
import org.joml.Quaternionf;
import org.joml.Vector3f;

// $VF: Compiled from s
public class Constellation extends ClientModule {
   private static final String field13733 = "Себя";
   private static final String field13734 = "field13734";
   private static final float field13735 = 0;
   private static final long field13736 = 0;
   private static final long field13737 = 0;
   private static final float field13738 = 0;
   private static final float field13739 = 0;
   private static final float field13740 = 0;
   private final MultiToggleSetting field13741;
   private final MultiToggleSetting field13742;
   private final NumberSetting<Integer> field13743;
   private final NumberSetting<Float> field13744;
   private final NumberSetting<Float> field13745;
   private final ModeSetting field13746;
   private final ToggleSetting field13747;
   private final ToggleSetting field13748;
   private final ToggleSetting field13749;
   private long field13750;
   private float[] field13751;
   private float[] field13752;
   private float[] field13753;
   private float[] field13754;
   private float[] field13755;
   private float[] field13756;
   private int[] field13757;
   private float[] field13758;
   private static final int field13759 = 0;
   private final BaritoneVertexConsumerAccess[] field13760;
   private final RenderType[] field13761;
   private RenderType field13762;
   private final Vector3f field13763;
   private final Vector3f field13764;
   private final Vector3f field13765;
   private final Vector3f field13766;
   private final Vector3f field13767;
   private final Vector3f field13768;
   private final Vector3f field13769;
   private final Quaternionf field13770;
   private static final String field13771 = "Отображать";
   private static final String field13772 = "Себя";
   private static final String field13773 = "Друзей";
   private static final String field13774 = "Элементы";
   private static final String field13775 = "Орбиз";
   private static final String field13776 = "Звезды";
   private static final String field13777 = "Сердечки";
   private static final String field13778 = "Доллары";
   private static final String field13779 = "Снежинки";
   private static final String field13780 = "Короны";
   private static final String field13781 = "Молнии";
   private static final String field13782 = "Линии";
   private static final String field13783 = "Кругляши";
   private static final String field13784 = "Ромбы";
   private static final String field13785 = "Искры";
   private static final String field13786 = "Звёзды";
   private static final String field13787 = "Радиус";
   private static final float field13788 = 0.8F;
   private static final float field13789 = 0.05F;
   private static final float field13790 = 1.2F;
   private static final String field13791 = "Скорость";
   private static final float field13792 = 0.2F;
   private static final float field13793 = 0.1F;
   private static final float field13794 = 0.8F;
   private static final String field13795 = "Цвет";
   private static final String field13796 = "От темы";
   private static final String field13797 = "Радужный";
   private static final String field13798 = "Белый";
   private static final String field13799 = "От темы";
   private static final String field13800 = "Свечение";
   private static final String field13801 = "Линии";
   private static final String field13802 = "Вспышка при ударе";
   private static final String field13803 = "Constellation";
   private static final String field13804 = "Созвездие из мерцающих звёзд вокруг игрока";
   private static final String field13805 = "Себя";
   private static final String field13806 = "Друзей";
   private static final long field13807 = 3600000L;
   private static final float field13808 = 1000.0F;
   private static final String field13809 = "Радужный";
   private static final String field13810 = "Белый";
   private static final float field13811 = 0.6F;
   private static final int field13812 = 65535;
   private static final float field13813 = 0.7137F;
   private static final float field13814 = 0.15F;
   private static final float field13815 = 0.6F;
   private static final float field13816 = 0.8F;
   private static final float field13817 = 0.35F;
   private static final float field13818 = (float) (Math.PI * 2);
   private static final float field13819 = 0.7F;
   private static final float field13820 = 0.6F;
   private static final float field13821 = 0.35F;
   private static final float field13822 = 0.5F;
   private static final float field13823 = 0.08F;
   private static final float field13824 = 1.7F;
   private static final float field13825 = 2.1F;
   private static final float field13826 = 0.5F;
   private static final float field13827 = 0.25F;
   private static final float field13828 = 0.7F;
   private static final float field13829 = 0.3F;
   private static final float field13830 = (float) (Math.PI * 2);
   private static final float field13831 = 0.5F;
   private static final float field13832 = 0.5F;
   private static final float field13833 = 0.8F;
   private static final float field13834 = 0.09F;
   private static final float field13835 = 0.07F;
   private static final float field13836 = 0.5F;
   private static final float field13837 = 0.4F;
   private static final float field13838 = 0.6F;
   private static final float field13839 = (float) (Math.PI * 2);
   private static final float field13840 = 0.9F;
   private static final float field13841 = 0.4F;
   private static final float field13842 = 0.35F;
   private static final float field13843 = 0.3F;
   private static final float field13844 = 2.4F;
   private static final float field13845 = 0.3F;
   private static final float field13846 = 0.4F;
   private static final float field13847 = 1.0E-4F;
   private static final float field13848 = 1.5F;
   private static final float field13849 = 1.5F;
   private static final float field13850 = 450.0F;
   private static final int field13851 = 374761393;
   private static final int field13852 = 668265263;
   private static final int field13853 = 1274126177;
   private static final int field13854 = 8388607;
   private static final float field13855 = 8388607.0F;

   private void method06069(int var1) {
      if (this.field13751.length < var1) {
         this.field13751 = new float[var1];
         this.field13752 = new float[var1];
         this.field13753 = new float[var1];
         this.field13754 = new float[var1];
         this.field13755 = new float[var1];
         this.field13756 = new float[var1];
         this.field13757 = new int[var1];
         this.field13758 = new float[var1];
      }
   }

   private float method06070(long var1) {
      if (!this.field13749.method03022()) {
         return 0.0F;
      }

      float var3 = (float)(var1 - this.field13750) / field13850;
      if (var3 >= 1.0F) {
         return 0.0F;
      }

      float var4 = 1.0F - var3;
      return var4 * var4;
   }

   @Subscribe
   private void method06071(Render3DEvent var1) {
      if (mc.level != null && mc.player != null) {
         boolean var2 = this.field13741.method04520(field13805);
         boolean var3 = this.field13741.method04520(field13806);
         if (var2 || var3) {
            boolean var4 = mc.options.getCameraType() == CameraType.FIRST_PERSON && !ModuleManager.INSTANCE.method08258().method03937();
            boolean var5 = var2 && !var4;
            if (var5 || var3) {
               int var6 = this.method06074(var1);
               if (var6 != 0) {
                  BaritoneVertexConsumerAccess var7 = null;
                  if (this.field13747.method03022()) {
                     if (this.field13762 == null) {
                        this.field13762 = EffectRenderPipelines.method05541(ClientTextures.INSTANCE.method04571());
                     }

                     if (var1.method00985().method07407(this.field13762) instanceof BaritoneVertexConsumerAccess var9) {
                        var7 = var9;
                     }
                  }

                  int var29 = this.field13743.method03022();
                  boolean var30 = this.field13748.method03022() && var29 >= 2;
                  BaritoneVertexConsumerAccess var10 = null;
                  if (var30 && var1.method00985().method07407(EffectRenderPipelines.method05519()) instanceof BaritoneVertexConsumerAccess var12) {
                     var10 = var12;
                  }

                  long var31 = System.currentTimeMillis();
                  float var13 = (float)(var31 % field13807) / field13808;
                  float var14 = this.method06070(var31);
                  float var15 = var1.method00984().getGameTimeDeltaPartialTick(true);
                  Frustum var16 = var1.method00986();
                  Vec3 var17 = var1.method00994().position();
                  Quaternionf var18 = var1.method00994().rotation();
                  this.field13763.set(1.0F, 0.0F, 0.0F);
                  this.field13764.set(0.0F, 1.0F, 0.0F);
                  var18.transform(this.field13763);
                  var18.transform(this.field13764);
                  this.field13763.cross(this.field13764, this.field13765).normalize();
                  this.method06069(var29);
                  PoseStack var19 = var1.method00996();
                  Matrix4f var20 = var19.last().pose();
                  var20.transformDirection(this.field13766.set(this.field13763));
                  var20.transformDirection(this.field13767.set(this.field13764));
                  float var21 = this.field13744.method03022();
                  float var22 = this.field13745.method03022();
                  int var23 = ColorUtils.Nested138.method04636();
                  int var24 = ColorUtils.Nested138.method04637();
                  int var25 = this.field13746.method05600(field13809) ? 1 : (this.field13746.method05600(field13810) ? 2 : 0);
                  LocalPlayer var26 = mc.player;

                  for (Player var28 : mc.level.players()) {
                     if ((var28 == var26 ? var5 : var3 && FriendManager.INSTANCE.method00172(var28))
                        && var28.isAlive()
                        && var16.isVisible(var28.getBoundingBox().inflate(var21))) {
                        this.method06079(var28, var29, var21, var22, var13, var14, var15, var17, var20, var7, var6, var10, var25, var23, var24);
                     }
                  }
               }
            }
         }
      }
   }

   private static float method06072(Matrix4f var0, float var1, float var2, float var3) {
      return var0.m02() * var1 + var0.m12() * var2 + var0.m22() * var3 + var0.m32();
   }

   private static float method06073(int var0, int var1) {
      int var2 = var0 * field13851 + var1 * field13852;
      var2 = (var2 ^ var2 >>> 13) * field13853;
      var2 ^= var2 >>> 16;
      return (var2 & field13854) / field13855;
   }

   private int method06074(Render3DEvent var1) {
      int var2 = 0;
      var var3 = this.field13742.method03022();

      for (int var4 = 0; var4 < var3.size() && var4 < 11; var4++) {
         if (Boolean.TRUE.equals(((NamedOption)var3.get(var4)).method08074())) {
            RenderType var5 = this.field13761[var4];
            if (var5 == null) {
               var5 = this.field13761[var4] = EffectRenderPipelines.method05541(ClientTextures.INSTANCE.method04560(var4));
            }

            if (var1.method00985().method07407(var5) instanceof BaritoneVertexConsumerAccess var7) {
               this.field13760[var2] = var7;
               var2++;
            }
         }
      }

      return var2;
   }

   @Subscribe
   private void method06075(AttackEntityEvent var1) {
      if (var1.method09431() != AttackEntityEvent.Nested264.POST) {
         this.field13750 = System.currentTimeMillis();
      }
   }

   private static float method06076(Matrix4f var0, float var1, float var2, float var3) {
      return var0.m00() * var1 + var0.m10() * var2 + var0.m20() * var3 + var0.m30();
   }

   private void method06077(BaritoneVertexConsumerAccess var1, float var2, float var3, float var4, float var5, Vector3f var6, Vector3f var7, int var8) {
      float var9 = var6.x * var5;
      float var10 = var6.y * var5;
      float var11 = var6.z * var5;
      float var12 = var7.x * var5;
      float var13 = var7.y * var5;
      float var14 = var7.z * var5;
      var1.texturedVertexPre(var2 - var9 - var12, var3 - var10 - var13, var4 - var11 - var14, 0.0F, 0.0F, var8);
      var1.texturedVertexPre(var2 + var9 - var12, var3 + var10 - var13, var4 + var11 - var14, 0.0F, 1.0F, var8);
      var1.texturedVertexPre(var2 + var9 + var12, var3 + var10 + var13, var4 + var11 + var14, 1.0F, 1.0F, var8);
      var1.texturedVertexPre(var2 - var9 + var12, var3 - var10 + var13, var4 - var11 + var14, 1.0F, 0.0F, var8);
   }

   private static float method06078(Matrix4f var0, float var1, float var2, float var3) {
      return var0.m01() * var1 + var0.m11() * var2 + var0.m21() * var3 + var0.m31();
   }

   private void method06079(
      Player var1,
      int var2,
      float var3,
      float var4,
      float var5,
      float var6,
      float var7,
      Vec3 var8,
      Matrix4f var9,
      BaritoneVertexConsumerAccess var10,
      int var11,
      BaritoneVertexConsumerAccess var12,
      int var13,
      int var14,
      int var15
   ) {
      Vec3 var16 = var1.getPosition(var7);
      float var17 = var1.getBbHeight();
      float var18 = var17 * field13811;
      float var19 = (var1.getId() & field13812) * field13813;
      float var20 = var5 * field13814 + var19;
      float var21 = Mth.sin(var20);
      float var22 = Mth.cos(var20);
      float var23 = (float)(var16.x - var8.x);
      float var24 = (float)(var16.y - var8.y);
      float var25 = (float)(var16.z - var8.z);
      float var26 = var5 * field13815;

      for (int var27 = 0; var27 < var2; var27++) {
         float var28 = var3 * (field13816 + field13817 * method06073(var27, 3));
         float var29 = var27 * (field13818 / var2) + var19 + var5 * var4 * (field13819 + field13820 * method06073(var27, 4));
         float var30 = field13821 + (method06073(var27, 1) - field13822);
         float var31 = Mth.cos(var29) * var28;
         float var32 = Mth.sin(var29) * var28;
         float var33 = Mth.sin(var30);
         float var34 = Mth.cos(var30);
         float var35 = -var33 * var32;
         float var36 = var34 * var32;
         float var37 = field13823 * Mth.sin(var5 * field13824 + var27 * field13825);
         float var38 = var22 * var31 + var21 * var36;
         float var39 = var18 + var35 + (method06073(var27, 2) - field13826) * var17 * field13827 + var37;
         float var40 = -var21 * var31 + var22 * var36;
         this.field13751[var27] = var38;
         this.field13752[var27] = var39;
         this.field13753[var27] = var40;
         this.field13754[var27] = var23 + var38;
         this.field13755[var27] = var24 + var39;
         this.field13756[var27] = var25 + var40;
         this.field13758[var27] = field13828 + field13829 * Mth.sin(var5 * (2.0F + 2.0F * method06073(var27, 5)) + method06073(var27, 6) * field13830);

         this.field13757[var27] = switch (var13) {
            case 1 -> ColorUtils.method04600(2, var27 * 25, 1.0F, 1.0F, 1.0F);
            case 2 -> ColorUtils.field10169;
            default -> ColorUtils.method04583(var14, var15, field13831 + field13832 * Mth.sin(var26 + var27 * field13833));
         };
      }

      boolean var41 = var10 != null;

      for (int var42 = 0; var42 < var2; var42++) {
         float var44 = (field13834 + field13835 * method06073(var42, 7)) * (1.0F + field13836 * var6);
         float var46 = var5 * (field13837 + field13838 * method06073(var42, 8)) + method06073(var42, 9) * field13839;
         this.field13770.setAngleAxis(var46, this.field13765.x, this.field13765.y, this.field13765.z);
         this.field13770.transform(this.field13768.set(this.field13763));
         this.field13770.transform(this.field13769.set(this.field13764));
         var9.transformDirection(this.field13768);
         var9.transformDirection(this.field13769);
         float var48 = method06076(var9, this.field13754[var42], this.field13755[var42], this.field13756[var42]);
         float var50 = method06078(var9, this.field13754[var42], this.field13755[var42], this.field13756[var42]);
         float var52 = method06072(var9, this.field13754[var42], this.field13755[var42], this.field13756[var42]);
         float var54 = this.field13758[var42];
         int var56 = this.field13757[var42];
         int var58 = ClientParticleRenderer.method10534(ColorUtils.method04611(var56, Math.min(1.0F, field13840 * var54 + field13841 * var6)));
         if (var41) {
            int var60 = ClientParticleRenderer.method10534(ColorUtils.method04611(var56, field13842 * var54 + field13843 * var6));
            this.method06077(var10, var48, var50, var52, var44 * field13844, this.field13766, this.field13767, var60);
         }

         this.method06077(this.field13760[var42 % var11], var48, var50, var52, var44, this.field13768, this.field13769, var58);
      }

      if (var12 != null) {
         float var43 = field13845 + field13846 * var6;

         for (int var45 = 0; var45 < var2; var45++) {
            int var47 = (var45 + 1) % var2;
            float var49 = this.field13751[var47] - this.field13751[var45];
            float var51 = this.field13752[var47] - this.field13752[var45];
            float var53 = this.field13753[var47] - this.field13753[var45];
            float var55 = Mth.sqrt(var49 * var49 + var51 * var51 + var53 * var53);
            float var57 = var55 > field13847 ? 1.0F / var55 : 0.0F;
            float var59 = var57 != 0.0F ? var49 * var57 : 0.0F;
            float var61 = var57 != 0.0F ? var51 * var57 : 1.0F;
            float var62 = var57 != 0.0F ? var53 * var57 : 0.0F;
            var12.lineVertex(
               var9,
               this.field13754[var45],
               this.field13755[var45],
               this.field13756[var45],
               ColorUtils.method04611(this.field13757[var45], var43 * this.field13758[var45]),
               var59,
               var61,
               var62,
               field13848
            );
            var12.lineVertex(
               var9,
               this.field13754[var47],
               this.field13755[var47],
               this.field13756[var47],
               ColorUtils.method04611(this.field13757[var47], var43 * this.field13758[var47]),
               var59,
               var61,
               var62,
               field13849
            );
         }
      }
   }

   public Constellation() {
      super(ModuleCategory.Render, ModuleSubCategory.World);
      this.field13741 = new MultiToggleSetting(field13771)
         .method04517(NamedOption.method08077(field13772, true))
         .method04517(NamedOption.method08077(field13773, false))
         .method03023(this);
      this.field13742 = new MultiToggleSetting(field13774)
         .method04517(NamedOption.method08077(field13775, false))
         .method04517(NamedOption.method08077(field13776, true))
         .method04517(NamedOption.method08077(field13777, false))
         .method04517(NamedOption.method08077(field13778, false))
         .method04517(NamedOption.method08077(field13779, false))
         .method04517(NamedOption.method08077(field13780, false))
         .method04517(NamedOption.method08077(field13781, false))
         .method04517(NamedOption.method08077(field13782, false))
         .method04517(NamedOption.method08077(field13783, false))
         .method04517(NamedOption.method08077(field13784, false))
         .method04517(NamedOption.method08077(field13785, false))
         .method04521(1)
         .method03023(this);
      this.field13743 = new NumberSetting<Integer>(field13786).method10835(4).method10838(14).method10834(1).method03017(8).method03023(this);
      this.field13744 = new NumberSetting<Float>(field13787)
         .method10835(field13788)
         .method10838(2.0F)
         .method10834(field13789)
         .method03017(field13790)
         .method03023(this);
      this.field13745 = new NumberSetting<Float>(field13791)
         .method10835(field13792)
         .method10838(2.0F)
         .method10834(field13793)
         .method03017(field13794)
         .method03023(this);
      this.field13746 = new ModeSetting(field13795).method05597(field13796, field13797, field13798).method03017(field13799).method03023(this);
      this.field13747 = new ToggleSetting(field13800).method03017(true).method03023(this);
      this.field13748 = new ToggleSetting(field13801).method03017(true).method03023(this);
      this.field13749 = new ToggleSetting(field13802).method03017(true).method03023(this);
      this.field13751 = new float[0];
      this.field13752 = new float[0];
      this.field13753 = new float[0];
      this.field13754 = new float[0];
      this.field13755 = new float[0];
      this.field13756 = new float[0];
      this.field13757 = new int[0];
      this.field13758 = new float[0];
      this.field13760 = new BaritoneVertexConsumerAccess[11];
      this.field13761 = new RenderType[11];
      this.field13763 = new Vector3f();
      this.field13764 = new Vector3f();
      this.field13765 = new Vector3f();
      this.field13766 = new Vector3f();
      this.field13767 = new Vector3f();
      this.field13768 = new Vector3f();
      this.field13769 = new Vector3f();
      this.field13770 = new Quaternionf();
      this.method03935(field13803);
      this.method03931(field13804);
   }
}
