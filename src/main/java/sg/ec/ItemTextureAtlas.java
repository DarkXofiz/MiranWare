// Original binary: sg/ec/XPPycIOzYXPRVZ96
package sg.ec;

import com.mojang.blaze3d.platform.NativeImage;
import com.mojang.blaze3d.systems.RenderSystem;
import it.unimi.dsi.fastutil.objects.Object2IntOpenHashMap;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.Identifier;

// $VF: Compiled from s
public enum ItemTextureAtlas implements MinecraftAccess {
   INSTANCE;

   private static final int field13935 = 8;
   private static final int field13936 = 0;
   private static final int field13937 = 0;
   private static final int field13938 = 0;
   private static final int field13939 = 0;
   private static final int field13940 = 0;
   private static final int field13941 = 0;
   private static final int field13942 = 0;
   private static final int field13943 = 0;
   public static final float field13944 = 0;
   public static final float field13945 = 0;
   private static final Identifier field13946 = Identifier.fromNamespaceAndPath("Hex".toLowerCase(), "dynamic/head_atlas");
   private final Object2IntOpenHashMap<Identifier> field13947 = new Object2IntOpenHashMap();
   private final Identifier[] field13948 = new Identifier[512];
   private final long[] field13949 = new long[512];
   private DynamicTexture field13950;
   private NativeImage field13951;
   private long field13952;
   private int field13953;

   ItemTextureAtlas() {
      this.field13947.defaultReturnValue(-1);
   }

   public Identifier method06284() {
      return field13946;
   }

   public float method06285(int var1, boolean var2) {
      return (var1 % 16 * 16 + (var2 ? 8 : 0)) / 256.0F;
   }

   public float method06286(int var1) {
      return var1 / 16 * 8 / 256.0F;
   }

   public int method06287(Identifier var1) {
      int var2 = this.field13947.getInt(var1);
      if (var2 >= 0) {
         this.field13949[var2] = ++this.field13952;
         return var2;
      }

      if (var2 != -2 && this.method06289()) {
         var2 = this.method06288();
         if (var2 < 0) {
            return -1;
         }

         if (!TexturePixelReader.method09639(var1, this::method06290)) {
            this.field13947.put(var1, -2);
            return -1;
         }

         if (this.field13948[var2] == null) {
            this.field13953++;
         } else {
            this.field13947.removeInt(this.field13948[var2]);
         }

         this.field13948[var2] = var1;
         this.field13949[var2] = ++this.field13952;
         this.field13947.put(var1, var2);
         RenderSystem.getDevice().createCommandEncoder().writeToTexture(this.field13950.getTexture(), this.field13951, 0, 0, var2 % 16 * 16, var2 / 16 * 8, this.field13951.getWidth(), this.field13951.getHeight(), 0, 0);
         return var2;
      } else {
         return -1;
      }
   }

   private int method06288() {
      if (this.field13953 < 512) {
         return this.field13953;
      }

      int var1 = 0;

      for (int var2 = 1; var2 < 512; var2++) {
         if (this.field13949[var2] < this.field13949[var1]) {
            var1 = var2;
         }
      }

      return this.field13952 - this.field13949[var1] < 512L ? -1 : var1;
   }

   private boolean method06289() {
      if (this.field13950 != null) {
         return true;
      }

      if (!RenderSystem.isOnRenderThread()) {
         return false;
      }

      this.field13950 = new DynamicTexture(() -> "hex head atlas", 256, 256, true);
      this.field13950.upload();
      mc.getTextureManager().register(field13946, this.field13950);
      this.field13951 = new NativeImage(16, 8, false);
      return true;
   }

   private boolean method06290(NativeImage var1) {
      if (var1.getWidth() == 64 && var1.getHeight() == 64 && var1.format() == this.field13951.format()) {
         for (int var2 = 0; var2 < 8; var2++) {
            for (int var3 = 0; var3 < 8; var3++) {
               this.field13951.setPixel(var3, var2, var1.getPixel(8 + var3, 8 + var2));
               this.field13951.setPixel(8 + var3, var2, var1.getPixel(40 + var3, 8 + var2));
            }
         }

         return true;
      } else {
         return false;
      }
   }
}
