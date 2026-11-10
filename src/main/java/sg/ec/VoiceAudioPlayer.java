// Original binary: sg/ec/9qLeTn9lKRqQAimz
package sg.ec;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.SourceDataLine;

// $VF: Compiled from s
public enum VoiceAudioPlayer {
   INSTANCE;

   public static final int field05737 = 1;
   public static final int field05738 = 0;
   public static final int field05739 = 0;
   private static final int field05740 = 0;
   private static final int field05741 = 0;
   private static final long field05742 = 0;
   private final AtomicInteger field05743 = new AtomicInteger();
   private final AtomicInteger field05744 = new AtomicInteger();
   private final BlockingQueue<short[]> field05745 = new ArrayBlockingQueue<>(64);
   private volatile String field05746 = "";
   private volatile VoiceAudioClip field05747;
   private volatile short[] field05748;
   private volatile int field05749;
   private volatile int field05750 = -1;
   private volatile float field05751 = 1.0F;
   private volatile boolean field05752;
   private volatile int field05753;
   private volatile int field05754;

   public void method02382(String var1, VoiceAudioClip var2, int var3) {
      this.method02388();
      if (var2 != null && var2.frames() > 0) {
         this.method02389(var3);
         this.field05746 = var1 == null ? "" : var1;
         this.field05747 = var2;
         this.field05749 = var2.frames();
         this.field05748 = null;
         this.field05744.set(0);
         this.method02383(0);
      }
   }

   public void method02383(int var1) {
      VoiceAudioClip var2 = this.field05747;
      if (var2 != null) {
         this.field05743.incrementAndGet();
         this.field05744.set(Math.max(0, Math.min(var1, var2.frames())));
         this.field05750 = -1;
         this.field05752 = true;
         int var3 = this.field05743.get();
         Thread var4 = new Thread(() -> this.method02397(var3, var2), "Hex-Voice");
         var4.setDaemon(true);
         var4.start();
      }
   }

   public void method02384(int var1, int var2, int var3) {
      this.method02388();
      if (VoiceAudioCodec.method09195(var1) && var2 >= 1 && var2 <= 2) {
         this.method02389(var3);
         this.field05753 = var1;
         this.field05754 = var2;
         this.field05752 = true;
         int var4 = this.field05743.incrementAndGet();
         Thread var5 = new Thread(() -> this.method02398(var4, var1, var2), "Hex-VoiceStream");
         var5.setDaemon(true);
         var5.start();
      }
   }

   public void method02385(byte[] var1) {
      int var2 = this.field05754;
      if (this.field05752 && var1 != null && var1.length != 0 && var2 > 0) {
         int var3 = var1.length / VoiceAudioCodec.method09199(var2);
         if (var3 > 0) {
            short[] var4 = VoiceAudioCodec.method09187(var1, 0, var3, var2, 0);
            if (var4.length > 0 && !this.field05745.offer(var4)) {
               this.field05745.poll();
               this.field05745.offer(var4);
            }
         }
      }
   }

   public void method02386() {
      this.field05745.clear();
   }

   public void method02387() {
      this.field05743.incrementAndGet();
      this.field05752 = false;
   }

   public void method02388() {
      this.field05743.incrementAndGet();
      this.field05752 = false;
      this.field05746 = "";
      this.field05747 = null;
      this.field05748 = null;
      this.field05749 = 0;
      this.field05754 = 0;
      this.field05744.set(0);
      this.field05745.clear();
   }

   public void method02389(int var1) {
      this.field05751 = Math.max(1, Math.min(300, var1)) / 100.0F;
   }

   public boolean method02390(String var1) {
      return this.field05747 != null && this.field05746.equals(var1);
   }

   public boolean method02391() {
      return this.field05752;
   }

   public boolean method02392(String var1) {
      return this.field05752 && this.field05746.equals(var1);
   }

   public int method02393() {
      return this.field05749;
   }

   public int method02394() {
      return this.field05744.get();
   }

   public float method02395() {
      int var1 = this.field05749;
      return var1 <= 0 ? 0.0F : Math.min(1.0F, (float)this.field05744.get() / var1);
   }

   public void method02396(float var1) {
      int var2 = this.field05749;
      if (var2 > 0) {
         int var3 = (int)(Math.max(0.0F, Math.min(1.0F, var1)) * var2);
         if (this.field05752) {
            this.field05750 = var3;
         } else {
            this.field05744.set(var3);
         }
      }
   }

   private void method02397(int var1, VoiceAudioClip var2) {
      int var3 = var2.channels();
      short[] var4 = this.field05748;
      if (var4 == null) {
         var4 = VoiceAudioCodec.method09201(var2.audio(), var2.frames(), var3);
         if (this.field05747 == var2) {
            this.field05748 = var4;
         }
      }

      if (this.field05743.get() != var1) {
         this.method02402(var1);
      } else {
         int var5 = var4.length / var3;
         SourceDataLine var6 = this.method02400(var2.sampleRate(), var3);
         if (var6 == null) {
            this.method02402(var1);
         } else {
            try {
               byte[] var7 = new byte[1024 * var3 * 2];

               while (this.field05743.get() == var1) {
                  int var8 = this.field05750;
                  if (var8 >= 0) {
                     this.field05750 = -1;
                     this.field05744.set(Math.min(var8, var5));
                     var6.flush();
                  }

                  int var9 = this.field05744.get();
                  if (var9 >= var5) {
                     break;
                  }

                  int var10 = Math.min(1024, var5 - var9);
                  this.method02399(var6, var7, var4, var9 * var3, var10 * var3);
                  this.field05744.addAndGet(var10);
               }

               if (this.field05743.get() == var1) {
                  var6.drain();
               }
            } catch (Exception var14) {
            } finally {
               this.method02401(var6);
               this.method02402(var1);
            }
         }
      }
   }

   private void method02398(int var1, int var2, int var3) {
      SourceDataLine var4 = this.method02400(var2, var3);
      if (var4 == null) {
         this.method02402(var1);
      } else {
         try {
            byte[] var5 = new byte[1024 * var3 * 2];

            while (this.field05743.get() == var1) {
               short[] var6 = this.field05745.poll(5L, TimeUnit.SECONDS);
               if (var6 == null) {
                  break;
               }

               for (int var7 = 0; var7 < var6.length && this.field05743.get() == var1; var7 += var5.length / 2) {
                  this.method02399(var4, var5, var6, var7, Math.min(var5.length / 2, var6.length - var7));
               }
            }
         } catch (InterruptedException var12) {
            Thread.currentThread().interrupt();
         } catch (Exception var13) {
         } finally {
            this.method02401(var4);
            this.method02402(var1);
         }
      }
   }

   private void method02399(SourceDataLine var1, byte[] var2, short[] var3, int var4, int var5) {
      float var6 = this.field05751;

      for (int var7 = 0; var7 < var5; var7++) {
         short var8 = var6 == 1.0F ? var3[var4 + var7] : VoiceAudioCodec.method09196(Math.round(var3[var4 + var7] * var6));
         var2[var7 * 2] = (byte)var8;
         var2[var7 * 2 + 1] = (byte)(var8 >> 8);
      }

      var1.write(var2, 0, var5 * 2);
   }

   private SourceDataLine method02400(int var1, int var2) {
      try {
         AudioFormat var3 = new AudioFormat(var1, 16, var2, true, false);
         SourceDataLine var4 = AudioSystem.getSourceDataLine(var3);
         var4.open(var3, 1024 * var2 * 8);
         var4.start();
         return var4;
      } catch (Exception var5) {
         return null;
      }
   }

   private void method02401(SourceDataLine var1) {
      if (var1 != null) {
         try {
            var1.stop();
            var1.close();
         } catch (Exception var3) {
         }
      }
   }

   private void method02402(int var1) {
      if (this.field05743.compareAndSet(var1, var1 + 1)) {
         this.field05752 = false;
         this.field05744.set(this.field05749);
         this.field05745.clear();
      }
   }
}
