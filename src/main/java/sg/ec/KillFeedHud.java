// Original binary: sg/ec/nhlLMEQQaB31MQmV
package sg.ec;

import java.util.ArrayList;
import java.util.List;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import org.joml.Vector4f;

// $VF: Compiled from s
public class KillFeedHud extends HudElement {
   private final NumberSetting<Long> field21979;
   private final List<KillFeedHud.Nested269> field21980;
   private final List<KillFeedHud.Nested271> field21981;
   private final List<KillFeedHud.Nested270> field21982;
   private static final byte field21983 = 7;
   private final List<Vector4f> field21984;
   private int field21985;
   private static final String field21986 = "KillFeed";
   private static final String field21987 = "Время жизни в секундах";
   private static final long field21988 = 10L;
   private static final long field21989 = 120L;
   private static final long field21990 = 30L;
   private static final long field21991 = 1000L;
   private static final long field21992 = 200L;
   private static final float field21993 = 10.0F;
   private static final float field21994 = 10.0F;
   private static final float field21995 = 15.0F;
   private static final float field21996 = 2.5F;
   private static final float field21997 = 8.0F;
   private static final float field21998 = 3.5F;
   private static final float field21999 = 0.5F;
   private static final float field22000 = 3.0F;
   private static final float field22001 = 3.0F;
   private static final float field22002 = 3.0F;
   private static final float field22003 = 0.5F;
   private static final float field22004 = 7.0F;
   private static final float field22005 = 0.25F;
   private static final float field22006 = 7.0F;
   private static final long field22007 = 1000L;
   private static final String field22008 = "Hits: ";
   private static final String field22009 = " Был убит: ";
   private static final String field22010 = " ";
   private static final float field22011 = 7.0F;
   private static final long field22012 = 30000L;
   private static final long field22013 = 30000L;

   public KillFeedHud() {
      super(field21986);
      this.field21979 = new NumberSetting<Long>(field21987)
         .method10835(field21988)
         .method10838(field21989)
         .method10834(1L)
         .method03017(field21990)
         .method03023(this);
      this.field21980 = new ArrayList<>();
      this.field21981 = new ArrayList<>();
      this.field21982 = new ArrayList<>();
      this.field21984 = new ArrayList<>();
   }

   @Override
   public void method00024() {
      super.method00024();
      long var1 = this.field21979.method03022() * field22007;
      long var3 = System.currentTimeMillis();
      this.field21980.removeIf(var4 -> var3 - var4.method09720() >= var1);
      this.field21981.removeIf(var2 -> var3 - var2.method09731() >= field22013);
      this.field21982.removeIf(var2 -> var3 - var2.method09727() >= field22012);
   }

   @Override
   public void method00027(GuiGraphics var1) {
      super.method00027(var1);
      if (!this.field21980.isEmpty()) {
         long var2 = System.currentTimeMillis();
         long var4 = this.field21979.method03022() * field21991 - field21992;
         float var6 = this.method06454() - field21993;
         float var7 = field21994;
         float var8 = field21995;
         float var9 = var8 + field21996;
         this.method06465(var6);
         this.method06453(var7);
         float var10 = 0.0F;
         int var11 = 0;
         float var12 = this.method06455();
         this.field21985 = 0;

         for (KillFeedHud.Nested269 var14 : this.field21980) {
            AnimationUtils var15 = var14.method09721();
            var15.method03375(var2 - var14.field22016 <= var4 ? 1.0 : 0.0);
            float var16 = field21997;
            float var17 = var15.method03377();
            float var18 = var14.method09719();
            float var19 = var6 - var18;
            float var20 = var7 + var11 * var9;
            float var21 = var19 - var16 / 2.0F;
            float var22 = var20 - field21998 - field21999;
            float var23 = var18 + var16;
            Vector4f var24;
            if (this.field21985 < this.field21984.size()) {
               var24 = this.field21984.get(this.field21985);
            } else {
               var24 = new Vector4f();
               this.field21984.add(var24);
            }

            var24.set(var21, var22, var23, var8);
            this.field21985++;
            this.method06439(var1, var21, var22, var23, var8, field22000, 1.0F, var17);
            RoundedRectRenderer.method01272(var1, var21, var22, var23, var8, field22001, 1.0F, ColorUtils.method04611(this.method06460(), var17 * var12));
            if (!this.method06447()) {
               GuiShadowRenderer.method10984(
                  var1, var21, var22, var23, var8, field22002, field22003, field22004, ColorUtils.method04611(this.method06460(), var17 * var12)
               );
            }

            field14601.method09480(var1, var14.method09718(), var19, var20 + field22005, ColorUtils.method04611(this.method06438(), var17), field22006);
            var11++;
            var7 += var15.method03377() * var9 - var9;
            var10 = Math.max(var10, var18 + var16);
         }

         this.method06448(var10);
         this.method06456(var11 * var8);
      }
   }

   private KillFeedHud.Nested270 method09713(LivingEntity var1) {
      for (KillFeedHud.Nested270 var3 : this.field21982) {
         LivingEntity var4 = var3.method09726();
         if (var4 != null && var4.getUUID().equals(var1.getUUID())) {
            return var3;
         }
      }

      return null;
   }

   @Override
   public void method00029(EntityDeathEvent var1) {
      if (var1.method11303() instanceof LivingEntity var3) {
         KillFeedHud.Nested271 var4 = this.method09714(var3);
         KillFeedHud.Nested270 var5 = this.method09713(var3);
         if (var4 == null) {
            return;
         }

         ItemStack var6 = mc.player.getMainHandItem().copy();
         Component var7 = var6.getStyledHoverName();
         KillFeedHud.Nested269 var8 = new KillFeedHud.Nested269(var4, var5, System.currentTimeMillis());
         String var9 = field22008;
         String var10 = var9 + var8.method09717().method09732();
         boolean var11 = var8.method09723() != null;
         String var12 = var11 ? ", Попнул: " + var8.method09723().method09725() + " Тотем" : "";
         String var13 = field22009;
         MutableComponent var14 = Component.empty()
            .append(PlayerUtils.method11813(var3))
            .copy()
            .append(var13)
            .append(var7)
            .append(field22010)
            .append(var10);
         if (var11) {
            var14.append(var12);
         }

         var8.method09722(FontRenderer.method09483(var14));
         var8.method09724(field14601.method09489(var14, field22011));
         this.field21980.add(var8);
         this.field21981.remove(var4);
         this.field21982.remove(var5);
      }
   }

   private KillFeedHud.Nested271 method09714(LivingEntity var1) {
      for (KillFeedHud.Nested271 var3 : this.field21981) {
         LivingEntity var4 = var3.method09730();
         if (var4 != null && var4.getUUID().equals(var1.getUUID())) {
            return var3;
         }
      }

      return null;
   }

   @Override
   public void method00036(TotemPopEvent var1) {
      if (var1.method01501() instanceof LivingEntity var3) {
         KillFeedHud.Nested270 var4 = this.method09713(var3);
         if (var4 == null) {
            this.field21982.add(new KillFeedHud.Nested270(var3, 1, System.currentTimeMillis()));
            return;
         }

         var4.method09729(System.currentTimeMillis());
      }

      super.method00036(var1);
   }

   @Override
   public boolean method06444(float var1, float var2) {
      for (int var3 = 0; var3 < this.field21985; var3++) {
         Vector4f var4 = this.field21984.get(var3);
         if (GuiHitTestUtils.method05625(var1, var2, var4.x(), var4.y(), var4.z(), var4.w())) {
            this.method06465(var4.x());
            this.method06453(var4.y());
            this.method06448(var4.z());
            this.method06456(var4.w());
            return true;
         }
      }

      return false;
   }

   @Override
   public void method00026(AttackEntityEvent var1) {
      if (var1.method09434() instanceof LivingEntity var3) {
         KillFeedHud.Nested271 var4 = this.method09714(var3);
         KillFeedHud.Nested270 var5 = this.method09713(var3);
         if (var4 == null) {
            this.field21981.add(new KillFeedHud.Nested271(var3, 1, System.currentTimeMillis()));
            return;
         }

         if (var5 != null) {
            var5.method09728(System.currentTimeMillis());
         }

         var4.method09733(System.currentTimeMillis());
      }
   }

   // $VF: Compiled from s
   private static class Nested269 {
      private final KillFeedHud.Nested271 field22014;
      private final KillFeedHud.Nested270 field22015;
      private final long field22016;
      private final AnimationUtils field22017;
      private String field22018;
      private float field22019;
      private static final long field22020 = 200L;

      public KillFeedHud.Nested271 method09717() {
         return this.field22014;
      }

      public Nested269(KillFeedHud.Nested271 var1, KillFeedHud.Nested270 var2, long var3) {
         this.field22014 = var1;
         this.field22015 = var2;
         this.field22016 = var3;
         this.field22017 = new AnimationUtils(AnimationUtils.Nested95.LINEAR, field22020);
      }

      public String method09718() {
         return this.field22018;
      }

      public float method09719() {
         return this.field22019;
      }

      public long method09720() {
         return this.field22016;
      }

      public AnimationUtils method09721() {
         return this.field22017;
      }

      public void method09722(String var1) {
         this.field22018 = var1;
      }

      public KillFeedHud.Nested270 method09723() {
         return this.field22015;
      }

      public void method09724(float var1) {
         this.field22019 = var1;
      }
   }

   // $VF: Compiled from s
   private static class Nested270 {
      private final LivingEntity field22021;
      private int field22022;
      private long field22023;

      public Nested270(LivingEntity var1, int var2, long var3) {
         this.field22021 = var1;
         this.field22022 = var2;
         this.field22023 = var3;
      }

      public int method09725() {
         return this.field22022;
      }

      public LivingEntity method09726() {
         return this.field22021;
      }

      public long method09727() {
         return this.field22023;
      }

      private void method09728(long var1) {
         this.field22023 = var1;
      }

      private void method09729(long var1) {
         this.field22022++;
         this.method09728(var1);
      }
   }

   // $VF: Compiled from s
   private static class Nested271 {
      private final LivingEntity field22024;
      private int field22025;
      private long field22026;

      public LivingEntity method09730() {
         return this.field22024;
      }

      public long method09731() {
         return this.field22026;
      }

      public int method09732() {
         return this.field22025;
      }

      private void method09733(long var1) {
         this.field22025++;
         this.field22026 = var1;
      }

      public Nested271(LivingEntity var1, int var2, long var3) {
         this.field22024 = var1;
         this.field22025 = var2;
         this.field22026 = var3;
      }
   }
}
