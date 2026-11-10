// Original binary: sg/ec/ANGYhM68cH24RDbC
package sg.ec;

import by.bonenaut7.mediatransport4j.api.MediaSession;
import by.bonenaut7.mediatransport4j.api.MediaTransport;
import com.mojang.blaze3d.platform.NativeImage;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef.DWORD;
import com.sun.jna.platform.win32.WinDef.WORD;
import com.sun.jna.platform.win32.WinUser.INPUT;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.nio.ByteBuffer;
import java.security.MessageDigest;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import javax.imageio.ImageIO;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.DynamicTexture;
import net.minecraft.resources.Identifier;
import net.minecraft.util.Util;

// $VF: Compiled from s
public final class WindowsMediaManager {
   public static final Identifier field06028 = Identifier.fromNamespaceAndPath(WindowsMediaManager.field06073, WindowsMediaManager.field06074);
   public static volatile String field06029 = "";
   public static volatile String field06030 = "";
   public static volatile long field06031 = 0L;
   public static volatile long field06032 = 0L;
   private static volatile long field06033 = 0L;
   public static volatile Identifier field06034 = field06028;
   public static volatile boolean field06035 = false;
   public static volatile boolean field06036 = false;
   private static final long field06037 = 250L;
   private static final long field06038 = 0;
   private static final long field06039 = 0;
   private static final long field06040 = 0;
   private static final long field06041 = 0;
   private static final long field06042 = 0;
   private static final int field06043 = 0;
   private static final Map<String, Identifier> field06044 = new LinkedHashMap<String, Identifier>(16, WindowsMediaManager.field06075, true)   // $VF: Compiled from s
 {
      @Override
      protected boolean removeEldestEntry(Entry<String, Identifier> var1) {
         if (this.size() <= 32) {
            return false;
         }

         WindowsMediaManager.method02531((Identifier)var1.getValue());
         return true;
      }
   };
   private static final ScheduledExecutorService field06045 = Executors.newSingleThreadScheduledExecutor(var0 -> {
      Thread var1 = new Thread(var0, WindowsMediaManager.field06072);
      var1.setDaemon(true);
      return var1;
   });
   private static volatile boolean field06046 = false;
   private static volatile MediaSession field06047 = null;
   private static String field06048 = "";
   private static long field06049 = 0L;
   private static volatile long field06050 = 0L;
   private static volatile long field06051 = 0L;
   private static volatile long field06052 = 0L;
   private static volatile long field06053 = 0L;
   private static volatile long field06054 = 0L;
   private static long field06055 = 0L;
   private static final long field06056 = 250L;
   private static final long field06057 = 1500L;
   private static final long field06058 = 250L;
   private static final long field06059 = 1000L;
   private static final long field06060 = 30000L;
   private static final long field06061 = 3000L;
   private static final long field06062 = 1000L;
   private static final long field06063 = 200L;
   private static final String field06064 = "hex";
   private static final String field06065 = "MD5";
   private static final long field06066 = 100000000L;
   private static final long field06067 = 10000L;
   private static final long field06068 = 10000L;
   private static final long field06069 = 1000L;
   private static final String field06070 = "ki";
   private static final long field06071 = 2L;
   private static final String field06072 = "hex-media-poller";
   private static final String field06073 = "minecraft";
   private static final String field06074 = "textures/misc/unknown_server.png";
   private static final float field06075 = 0.75F;

   public static void method02511() {
      method02539();
      MediaSession var0 = field06047;
      if (var0 != null) {
         method02517(var0::switchToNext);
      } else {
         method02535(176);
      }
   }

   public static void method02514() {
      method02539();
      MediaSession var0 = field06047;
      if (var0 != null) {
         method02517(var0::switchToPrevious);
      } else {
         method02535(177);
      }
   }

   public static void method02515() {
      method02539();
      MediaSession var0 = field06047;
      if (var0 != null) {
         method02517(var0::stop);
      } else {
         method02535(178);
      }
   }

   private static void method02517(Runnable var0) {
      long var1 = System.currentTimeMillis();
      if (var1 - field06050 >= field06063) {
         field06050 = var1;
         Util.backgroundExecutor().execute(() -> {
            try {
               var0.run();
            } catch (Throwable var2) {
            }
         });
      }
   }

   private static void method02518() {
      try {
         long var0 = System.currentTimeMillis();
         if (var0 - field06051 > field06057) {
            if (field06035 || field06047 != null) {
               method02522();
            }

            return;
         }

         if (var0 < field06054) {
            return;
         }

         method02540();
         field06054 = var0 + (var0 < field06052 ? field06058 : field06059);
      } catch (Throwable var2) {
         method02521(var2);
      }
   }

   private static boolean method02520(String var0) {
      if (var0 == null) {
         return false;
      }

      for (int var1 = 0; var1 < var0.length(); var1++) {
         if (!Character.isWhitespace(var0.charAt(var1))) {
            return true;
         }
      }

      return false;
   }

   private static void method02521(Throwable var0) {
      long var1 = System.currentTimeMillis();
      if (var1 - field06055 > field06060) {
         field06055 = var1;
      }
   }

   private static void method02522() {
      field06047 = null;
      field06048 = "";
      field06029 = "";
      field06030 = "";
      field06031 = 0L;
      field06032 = 0L;
      field06033 = 0L;
      field06034 = field06028;
      field06036 = false;
      field06035 = false;
   }

   private static byte[] method02523(ByteBuffer var0) {
      ByteBuffer var1 = var0.asReadOnlyBuffer();
      var1.rewind();
      byte[] var2 = new byte[var1.remaining()];
      var1.get(var2);
      return var2;
   }

   private static NativeImage method02524(ByteBuffer var0) {
      try {
         byte[] var1 = method02523(var0);
         BufferedImage var2 = ImageIO.read(new ByteArrayInputStream(var1));
         return var2 == null ? null : method02525(var2);
      } catch (Throwable var3) {
         return null;
      }
   }

   private static NativeImage method02525(BufferedImage var0) {
      int var1 = var0.getWidth();
      int var2 = var0.getHeight();
      int[] var3 = var0.getRGB(0, 0, var1, var2, null, 0, var1);
      NativeImage var4 = new NativeImage(var1, var2, false);

      for (int var5 = 0; var5 < var2; var5++) {
         int var6 = var5 * var1;

         for (int var7 = 0; var7 < var1; var7++) {
            var4.setPixel(var7, var5, var3[var6 + var7]);
         }
      }

      return var4;
   }

   private WindowsMediaManager() {
   }

   private static Identifier method02527(String var0, NativeImage var1) {
      Identifier var2 = Identifier.fromNamespaceAndPath(field06064, "media/" + var0);
      Minecraft var3 = Minecraft.getInstance();
      if (var3 != null) {
         var3.execute(() -> {
            try {
               String var4 = "texture_" + var0;
               DynamicTexture var5 = new DynamicTexture(() -> var4, var1);
               var3.getTextureManager().register(var2, var5);
            } catch (Throwable var6) {
            }
         });
      } else {
         var1.close();
      }

      return var2;
   }

   public static void method02528() {
      method02539();
      MediaSession var0 = field06047;
      if (var0 != null) {
         method02517(var0::togglePlay);
      } else {
         method02535(179);
      }
   }

   public static void method02529() {
      field06051 = System.currentTimeMillis();
      if (!field06046) {
         synchronized (WindowsMediaManager.class) {
            if (!field06046) {
               field06046 = true;

               try {
                  MediaTransport.init();
               } catch (Throwable var3) {
                  return;
               }

               field06045.scheduleAtFixedRate(WindowsMediaManager::method02518, 0L, field06056, TimeUnit.MILLISECONDS);
            }
         }
      }
   }

   private static String method02530(String var0) {
      return var0 == null ? "" : var0;
   }

   private static void method02531(Identifier var0) {
      if (var0 != null && !field06028.equals(var0)) {
         Minecraft var1 = Minecraft.getInstance();
         if (var1 != null) {
            var1.execute(() -> var1.getTextureManager().release(var0));
         }
      }
   }

   public static boolean method02533(long var0) {
      if (field06035 && field06031 > 0L) {
         MediaSession var2 = field06047;
         if (var2 == null) {
            return false;
         }

         long var3 = field06033;
         if (var3 <= 0L) {
            return false;
         }

         method02539();
         float var5 = Math.max(0.0F, Math.min(1.0F, (float)var0 / (float)field06031));
         long var6 = (long)(var5 * (float)var3);
         Util.backgroundExecutor().execute(() -> {
            try {
               var2.getClass().getMethod("seekTo", long.class).invoke(var2, var6);
            } catch (Throwable var4) {
            }
         });
         return true;
      } else {
         return false;
      }
   }

   private static String method02534(ByteBuffer var0) {
      try {
         MessageDigest var1 = MessageDigest.getInstance(field06065);
         ByteBuffer var2 = var0.asReadOnlyBuffer();
         var2.rewind();
         var1.update(var2);
         byte[] var3 = var1.digest();
         StringBuilder var4 = new StringBuilder(var3.length * 2);

         for (byte var8 : var3) {
            var4.append(Character.forDigit(var8 >> 4 & 15, 16));
            var4.append(Character.forDigit(var8 & 15, 16));
         }

         return var4.toString();
      } catch (Throwable var9) {
         return "";
      }
   }

   private static void method02535(int var0) {
      User32 var1 = User32.INSTANCE;
      INPUT[] var2 = new INPUT[]{new INPUT()};
      var2[0].type = new DWORD(1L);
      var2[0].input.setType(field06070);
      var2[0].input.ki.wVk = new WORD(var0);
      var1.SendInput(new DWORD(1L), var2, var2[0].size());
      var2[0].input.ki.dwFlags = new DWORD(field06071);
      var1.SendInput(new DWORD(1L), var2, var2[0].size());
   }

   public static float method02536() {
      long var0 = field06031;
      return var0 <= 0L ? 0.0F : Math.min(1.0F, Math.max(0.0F, (float)method02541() / (float)var0));
   }

   private static int method02537(long var0) {
      if (var0 > field06066) {
         return 1;
      } else {
         return var0 > 0L && var0 < field06067 ? 2 : 0;
      }
   }

   private static long method02538(long var0, int var2) {
      if (var0 <= 0L) {
         return 0L;
      } else if (var2 == 1) {
         return var0 / field06068;
      } else {
         return var2 == 2 ? var0 * field06069 : var0;
      }
   }

   private static void method02539() {
      field06052 = System.currentTimeMillis() + field06061;
   }

   private static void method02540() {
      try {
         var var0 = MediaTransport.getMediaSessions();
         if (var0 == null || var0.isEmpty()) {
            method02522();
            return;
         }

         MediaSession var1 = method02542(var0);
         if (var1 == null) {
            method02522();
            return;
         }

         field06047 = var1;
         String var2 = method02530(var1.getTitle());
         String var3 = method02530(var1.getArtist());
         boolean var4 = !var2.equals(field06029) || !var3.equals(field06030);
         ByteBuffer var5 = var1.getThumbnail();
         if (var5 != null && var5.capacity() > 0) {
            long var6 = System.currentTimeMillis();
            if (var4 || field06048.isEmpty() || var6 - field06049 > field06062) {
               String var8 = method02534(var5);
               field06049 = var6;
               if (!var8.isEmpty() && !var8.equals(field06048)) {
                  Identifier var9 = field06044.get(var8);
                  if (var9 == null) {
                     NativeImage var10 = method02524(var5);
                     if (var10 != null) {
                        var9 = method02527(var8, var10);
                        field06044.put(var8, var9);
                     }
                  }

                  if (var9 != null) {
                     field06034 = var9;
                  }

                  field06048 = var8;
               }
            }
         } else {
            field06048 = "";
            field06034 = field06028;
         }

         boolean var15 = var1.isPlaying();
         if (var4 || var15 != field06036) {
            method02539();
         }

         long var7 = var1.getDuration();
         long var16 = var1.getPosition();
         int var11 = method02537(var7);
         field06033 = var7;
         field06029 = var2;
         field06030 = var3;
         field06031 = Math.max(0L, method02538(var7, var11));
         long var12 = Math.max(0L, method02538(var16, var11));
         if (var12 != field06032) {
            field06032 = var12;
            field06053 = System.currentTimeMillis();
         }

         field06036 = var15;
         field06035 = true;
      } catch (Throwable var14) {
         method02521(var14);
      }
   }

   public static long method02541() {
      long var0 = field06032;
      if (field06036 && field06031 > 0L) {
         long var2 = System.currentTimeMillis() - field06053;
         if (var2 < 0L) {
            var2 = 0L;
         }

         return Math.min(field06031, var0 + var2);
      } else {
         return var0;
      }
   }

   private static MediaSession method02542(List<MediaSession> var0) {
      for (MediaSession var2 : var0) {
         if (var2 != null && var2.isPlaying()) {
            return var2;
         }
      }

      for (MediaSession var5 : var0) {
         if (var5 != null && (method02520(var5.getTitle()) || method02520(var5.getArtist()))) {
            return var5;
         }
      }

      for (MediaSession var6 : var0) {
         if (var6 != null) {
            return var6;
         }
      }

      return null;
   }
}
