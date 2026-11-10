// Original binary: sg/ec/yFvUqpC3f2hrIbkG
package sg.ec;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.client.model.geom.PartPose;
import net.minecraft.client.model.geom.builders.CubeDeformation;
import net.minecraft.client.model.geom.builders.CubeListBuilder;
import net.minecraft.client.model.geom.builders.LayerDefinition;
import net.minecraft.client.model.geom.builders.MeshDefinition;
import net.minecraft.client.model.geom.builders.PartDefinition;
import net.minecraft.client.model.object.skull.SkullModel;
import net.minecraft.client.model.object.skull.SkullModelBase;
import net.minecraft.client.renderer.rendertype.RenderType;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public enum SkullTextureAtlas implements MinecraftAccess {
   INSTANCE;

   private static final int field26443 = 64;
   private static final int field26444 = 0;
   private static final int field26445 = 0;
   private static final int field26446 = 0;
   private static final int field26447 = 0;
   private static final int field26448 = 0;
   private static final int field26449 = 0;
   private static final int field26450 = 0;
   private static final int field26451 = 0;
   private static final int field26452 = 0;
   private static final Identifier field26453 = Identifier.fromNamespaceAndPath("Hex".toLowerCase(), "dynamic/skull_atlas");
   private final Object2IntOpenHashMap<Identifier> field26454 = new Object2IntOpenHashMap();
   private final Identifier[] field26455 = new Identifier[256];
   private final long[] field26456 = new long[256];
   private final SkullModelBase[] field26457 = new SkullModelBase[256];
   private DynamicTexture field26458;
   private NativeImage field26459;
   private RenderType field26460;
   private long field26461;
   private int field26462;

   SkullTextureAtlas() {
      this.field26454.defaultReturnValue(-1);
   }

   public RenderType method11601() {
      return this.field26460;
   }

   public SkullModelBase method11602(int var1) {
      SkullModelBase var2 = this.field26457[var1];
      if (var2 == null) {
         var2 = new SkullModel(method11607(var1).bakeRoot());
         this.field26457[var1] = var2;
      }

      return var2;
   }

   public boolean method11603(int var1, Identifier var2) {
      if (this.field26455[var1] != var2) {
         return false;
      }

      this.field26456[var1] = ++this.field26461;
      return true;
   }

   public int method11604(Identifier var1) {
      int var2 = this.field26454.getInt(var1);
      if (var2 >= 0) {
         this.field26456[var2] = ++this.field26461;
         return var2;
      }

      if (var2 != -2 && this.method11609()) {
         var2 = this.method11608();
         if (var2 < 0) {
            return -1;
         }

         if (!TexturePixelReader.method09639(var1, this::method11610)) {
            this.field26454.put(var1, -2);
            return -1;
         }

         if (this.field26455[var2] == null) {
            this.field26462++;
         } else {
            this.field26454.removeInt(this.field26455[var2]);
         }

         this.field26455[var2] = var1;
         this.field26456[var2] = ++this.field26461;
         this.field26454.put(var1, var2);
         RenderSystem.getDevice()
            .createCommandEncoder()
            .writeToTexture(this.field26458.getTexture(), this.field26459, 0, 0, method11605(var2), method11606(var2));
         return var2;
      } else {
         return -1;
      }
   }

   private static int method11605(int var0) {
      return var0 % 8 * 64;
   }

   private static int method11606(int var0) {
      return var0 / 8 * 16;
   }

   private static LayerDefinition method11607(int var0) {
      int var1 = method11605(var0);
      int var2 = method11606(var0);
      MeshDefinition var3 = new MeshDefinition();
      PartDefinition var4 = var3.getRoot()
         .addOrReplaceChild("head", CubeListBuilder.create().texOffs(var1, var2).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F), PartPose.ZERO);
      var4.addOrReplaceChild(
         "hat", CubeListBuilder.create().texOffs(var1 + 32, var2).addBox(-4.0F, -8.0F, -4.0F, 8.0F, 8.0F, 8.0F, new CubeDeformation(0.25F)), PartPose.ZERO
      );
      return LayerDefinition.create(var3, 512, 512);
   }

   private int method11608() {
      if (this.field26462 < 256) {
         return this.field26462;
      }

      int var1 = 0;

      for (int var2 = 1; var2 < 256; var2++) {
         if (this.field26456[var2] < this.field26456[var1]) {
            var1 = var2;
         }
      }

      return this.field26461 - this.field26456[var1] < 256L ? -1 : var1;
   }

   private boolean method11609() {
      if (this.field26458 != null) {
         return true;
      }

      if (!RenderSystem.isOnRenderThread()) {
         return false;
      }

      this.field26458 = new DynamicTexture(() -> "hex skull atlas", 512, 512, true);
      this.field26458.upload();
      mc.getTextureManager().register(field26453, this.field26458);
      this.field26459 = new NativeImage(64, 16, false);
      this.field26460 = RenderTypes.entityTranslucent(field26453);
      return true;
   }

   private boolean method11610(NativeImage var1) {
      if (var1.getWidth() == 64 && var1.getHeight() == 64 && var1.format() == this.field26459.format()) {
         for (int var2 = 0; var2 < 16; var2++) {
            for (int var3 = 0; var3 < 64; var3++) {
               this.field26459.setPixel(var3, var2, var1.getPixel(var3, var2));
            }
         }

         return true;
      } else {
         return false;
      }
   }
}
