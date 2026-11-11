// Original binary: sg/ec/3gsevT1A1iMJv5IU
package sg.ec;

import ai.onnxruntime.NodeInfo;
import ai.onnxruntime.OnnxModelMetadata;
import ai.onnxruntime.OnnxTensor;
import ai.onnxruntime.OnnxValue;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;
import ai.onnxruntime.TensorInfo;
import ai.onnxruntime.OrtSession.Result;
import ai.onnxruntime.OrtSession.SessionOptions;
import ai.onnxruntime.OrtSession.SessionOptions.OptLevel;
import java.io.IOException;
import java.nio.FloatBuffer;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.stream.Stream;

// $VF: Compiled from s
public final class OnnxRotationModel {
   private static final Path field01571 = Path.of(OnnxRotationModel.field01679, OnnxRotationModel.field01680, OnnxRotationModel.field01681);
   private static final int field01572 = 40;
   private final int field01573;
   private final String field01574;
   private final OrtEnvironment field01575 = safeEnvironment();

   private static OrtEnvironment safeEnvironment() {
      try {
         return OrtEnvironment.getEnvironment();
      } catch (Throwable var0) {
         System.err.println("[MiranWare] ONNX Runtime yuklenemedi, rotasyon modeli devre disi: " + var0);
         return null;
      }
   }
   private final ArrayDeque<float[]> field01576 = new ArrayDeque<>();
   private final Random field01577 = new Random();
   private final OnnxRotationModel.Nested20 field01578 = new OnnxRotationModel.Nested20();
   private final OnnxRotationModel.Nested19 field01579 = new OnnxRotationModel.Nested19();
   private float field01580;
   private float field01581;
   private float field01582;
   private boolean field01583;
   private float field01584;
   private float field01585;
   private float field01586;
   private float field01587;
   private float field01588;
   private float field01589;
   private float field01590;
   private boolean field01591;
   private float field01592;
   private float field01593;
   private boolean field01594;
   private boolean field01595;
   private float field01596;
   private float field01597;
   private boolean field01598;
   private int field01599;
   private float field01600;
   private float field01601;
   private OrtSession field01602;
   private String field01603;
   private int field01604;
   private int field01605;
   private int field01606;
   private String field01607;
   private int field01608;
   private float field01609;
   private float field01610;
   private static final float field01611 = 0.6F;
   private static final float field01612 = 0.55F;
   private static final float field01613 = 0.6F;
   private static final float field01614 = 0.4F;
   private static final float field01615 = 0.6F;
   private static final float field01616 = 8.0F;
   private static final float field01617 = 5.0F;
   private static final float field01618 = Float.MAX_VALUE;
   private static final float field01619 = Float.MAX_VALUE;
   private static final String field01620 = "delta_degrees";
   private static final double field01621 = 0.15;
   private static final double field01622 = 40.0;
   private static final String field01623 = "server";
   private static final String field01624 = ".onnx";
   private static final float field01625 = 180.0F;
   private static final float field01626 = 90.0F;
   private static final String field01627 = "gaussian";
   private static final String field01628 = "mdn";
   private static final String field01629 = "input";
   private static final String field01630 = "output";
   private static final float field01631 = 0.5F;
   private static final float field01632 = 0.5F;
   private static final String field01633 = "input";
   private static final String field01634 = "output";
   private static final String field01635 = "output";
   private static final String field01636 = "window_size";
   private static final String field01637 = "schema_id";
   private static final String field01638 = "output_format";
   private static final String field01639 = "delta_degrees";
   private static final String field01640 = "dots";
   private static final String field01641 = "label_units";
   private static final String field01642 = "mdn_components";
   private static final String field01643 = "log_std_min";
   private static final double field01644 = 0.15;
   private static final String field01645 = "log_std_max";
   private static final double field01646 = 40.0;
   private static final String field01647 = "noise_rho_yaw";
   private static final float field01648 = 0.6F;
   private static final String field01649 = "noise_rho_pitch";
   private static final float field01650 = 0.55F;
   private static final String field01651 = "noise_scale";
   private static final float field01652 = 0.6F;
   private static final String field01653 = "noise_state_conditioned";
   private static final float field01654 = 0.5F;
   private static final String field01655 = "noise_rho_ontarget";
   private static final float field01656 = 0.4F;
   private static final String field01657 = "noise_scale_ontarget";
   private static final float field01658 = 0.6F;
   private static final float field01659 = 0.001F;
   private static final String field01660 = "noise_engage_yaw_deg";
   private static final float field01661 = 8.0F;
   private static final float field01662 = 0.001F;
   private static final String field01663 = "noise_engage_pitch_deg";
   private static final float field01664 = 5.0F;
   private static final String field01665 = "hold_threshold";
   private static final String field01666 = "hold_max_err_deg";
   private static final float field01667 = Float.MAX_VALUE;
   private static final String field01668 = "hold_max_err_pitch_deg";
   private static final String field01669 = "hold_inside_box";
   private static final float field01670 = 0.5F;
   private static final String field01671 = "mdn_stick";
   private static final String field01672 = "pb_stick";
   private static final String field01673 = "carry_quantum";
   private static final float field01674 = 0.5F;
   private static final String field01675 = "mdn";
   private static final String field01676 = "gaussian";
   private static final String field01677 = "mdn";
   private static final String field01678 = ".onnx";
   private static final String field01679 = "Hex";
   private static final String field01680 = "mlRotation";
   private static final String field01681 = "models";

   public synchronized float[] method00690(float[] var1) {
      this.field01579.method00727(Math.abs(var1[0]) * field01625, Math.abs(var1[1]) * field01626, true, true, false);
      return this.method00694(var1, this.field01579);
   }

   public synchronized void method00691() {
      this.field01576.clear();
      this.field01598 = false;
      this.field01599 = -1;
      this.field01600 = 0.0F;
      this.field01601 = 0.0F;
      this.field01578.method00735();
   }

   private float[] method00692(float var1, float var2, float var3, float var4, OnnxRotationModel.Nested19 var5) {
      float var6 = (float)Math.exp(method00715(var3, this.field01609, this.field01610));
      float var7 = (float)Math.exp(method00715(var4, this.field01609, this.field01610));
      float[] var8 = this.method00717(var5);
      boolean var9 = this.method00712(var1, var5.field01682, var5.field01684, this.field01589);
      boolean var10 = this.method00712(var2, var5.field01683, var5.field01685, this.field01590);
      float var11 = var9 ? 0.0F : var1 + var6 * var8[0];
      float var12 = var10 ? 0.0F : var2 + var7 * var8[1];
      if (var9) {
         this.field01600 = 0.0F;
      }

      if (var10) {
         this.field01601 = 0.0F;
      }

      float var13 = var11;
      float var14 = var12;
      if (this.field01595) {
         float var15 = var11 + (this.field01594 ? this.field01600 : 0.0F);
         float var16 = var12 + (this.field01594 ? this.field01601 : 0.0F);
         var13 = (float)Math.floor(var15 + field01631);
         var14 = (float)Math.floor(var16 + field01632);
         this.field01600 = this.field01594 ? var15 - var13 : 0.0F;
         this.field01601 = this.field01594 ? var16 - var14 : 0.0F;
      }

      this.field01578.field01691 = var1;
      this.field01578.field01692 = var2;
      this.field01578.field01693 = var6;
      this.field01578.field01694 = var7;
      this.field01578.field01695 = var11;
      this.field01578.field01696 = var12;
      this.field01578.field01697 = this.field01600;
      this.field01578.field01698 = this.field01601;
      this.field01578.field01699 = var13;
      this.field01578.field01700 = var14;
      this.field01578.field01701 = var9;
      this.field01578.field01702 = var10;
      return new float[]{var13, var14};
   }

   public List<String> method00693() {
      ArrayList<String> var1 = new ArrayList<>();
      if (!Files.isDirectory(field01571)) {
         return var1;
      }

      try (Stream<Path> var2 = Files.list(field01571)) {
         var2.filter(var0 -> var0.toString().endsWith(field01678)).forEach(var1x -> var1.add(var1x.getFileName().toString()));
      } catch (IOException var7) {
      }

      return var1;
   }

   public synchronized float[] method00694(float[] var1, OnnxRotationModel.Nested19 var2) {
      long var3 = System.nanoTime();
      this.field01578.method00735();
      float[] var5 = this.method00699(var1);
      if (var5 == null) {
         this.field01578.field01703 = System.nanoTime() - var3;
         return new float[]{0.0F, 0.0F};
      }

      float[] var6;
      switch (this.field01607) {
         case field01627:
            var6 = this.method00716(var5, var2);
            break;
         case field01628:
            var6 = this.method00698(var5, var2);
            break;
         default:
            var6 = new float[]{var5[0], var5[1]};
            this.field01578.field01689 = this.field01578.field01691 = this.field01578.field01695 = this.field01578.field01699 = var5[0];
            this.field01578.field01690 = this.field01578.field01692 = this.field01578.field01696 = this.field01578.field01700 = var5[1];
      }

      this.field01578.field01703 = System.nanoTime() - var3;
      return var6;
   }

   public boolean method00696() {
      return this.field01595;
   }

   public OnnxRotationModel() {
      this(13, null);
   }

   private float[] method00698(float[] var1, OnnxRotationModel.Nested19 var2) {
      int var3 = this.field01608;
      float var4 = var2.field01686 ? this.field01593 : this.field01592;
      float var5 = Float.NEGATIVE_INFINITY;
      float var6 = Float.NEGATIVE_INFINITY;

      for (int var7 = 0; var7 < var3; var7++) {
         float var8 = var1[var7] + (var7 == this.field01599 ? var4 : 0.0F);
         if (var1[var7] > var5) {
            var5 = var1[var7];
         }

         if (var8 > var6) {
            var6 = var8;
         }
      }

      double var22 = 0.0;
      double var9 = 0.0;
      double[] var11 = new double[var3];
      double[] var12 = new double[var3];

      for (int var13 = 0; var13 < var3; var13++) {
         var11[var13] = Math.exp(var1[var13] + (var13 == this.field01599 ? var4 : 0.0F) - var6);
         var12[var13] = Math.exp(var1[var13] - var5);
         var22 += var11[var13];
         var9 += var12[var13];
      }

      double var23 = this.field01577.nextDouble() * var22;
      int var15 = var3 - 1;
      double var16 = 0.0;

      for (int var18 = 0; var18 < var3; var18++) {
         var16 += var11[var18];
         if (var23 <= var16) {
            var15 = var18;
            break;
         }
      }

      float var24 = 0.0F;
      float var19 = 0.0F;

      for (int var20 = 0; var20 < var3; var20++) {
         float var21 = (float)(var12[var20] / var9);
         var24 += var21 * var1[var3 + 2 * var20];
         var19 += var21 * var1[var3 + 2 * var20 + 1];
      }

      this.field01599 = var15;
      this.field01578.field01687 = var15;
      this.field01578.field01688 = (float)(var11[var15] / var22);
      this.field01578.field01689 = var24;
      this.field01578.field01690 = var19;
      return this.method00692(var1[var3 + 2 * var15], var1[var3 + 2 * var15 + 1], var1[3 * var3 + 2 * var15], var1[3 * var3 + 2 * var15 + 1], var2);
   }

   private float[] method00699(float[] var1) {
      if (this.field01602 == null) {
         return null;
      }

      this.field01576.addFirst((float[])var1.clone());

      while (this.field01576.size() > this.field01606) {
         this.field01576.removeLast();
      }

      float[] var2 = this.method00713();
      OnnxTensor var3 = null;

      try {
         var3 = OnnxTensor.createTensor(this.field01575, FloatBuffer.wrap(var2), new long[]{1L, this.field01606, this.field01604});
         HashMap var4 = new HashMap();
         var4.put(field01629, var3);

         try {
            Result var5 = this.field01602.run(var4);

            float[] var19;
            label185: {
               try {
                  OnnxValue var6 = (OnnxValue)var5.get(field01630).orElse(null);
                  if (var6 == null && var5.size() > 0) {
                     var6 = var5.get(0);
                  }

                  if (var6 == null) {
                     var19 = null;
                     break label185;
                  }

                  var19 = method00700(var6.getValue());
               } catch (Throwable var15) {
                  if (var5 != null) {
                     try {
                        var5.close();
                     } catch (Throwable var14) {
                        var15.addSuppressed(var14);
                     }
                  }

                  throw var15;
               }

               if (var5 != null) {
                  var5.close();
               }

               return (float[])var19;
            }

            if (var5 != null) {
               var5.close();
            }

            return (float[])var19;
         } catch (OrtException var16) {
            return null;
         }
      } catch (OrtException var17) {
         return null;
      } finally {
         if (var3 != null) {
            var3.close();
         }
      }
   }

   private static float[] method00700(Object var0) {
      if (var0 instanceof float[][][] var1 && var1.length > 0 && var1[0].length > 0) {
         float[][] var2 = var1[0];
         return var2[var2.length - 1];
      } else if (var0 instanceof float[][] var3 && var3.length > 0) {
         return var3[var3.length - 1];
      } else {
         return var0 instanceof float[] var4 ? var4 : null;
      }
   }

   public synchronized void method00701(byte[] var1, String var2) throws OrtException {
      if (this.field01575 == null) {
         throw new OrtException(OrtException.OrtErrorCode.ORT_FAIL, "ONNX Runtime yuklenemedi");
      }

      this.method00708();
      SessionOptions var3 = new SessionOptions();
      var3.setOptimizationLevel(OptLevel.ALL_OPT);
      var3.setIntraOpNumThreads(1);
      var3.setInterOpNumThreads(1);
      this.field01602 = this.field01575.createSession(var1, var3);
      this.field01603 = var2 != null && !var2.isBlank() ? var2 : field01623;

      try {
         this.method00702();
         this.method00714();
      } catch (OrtException var5) {
         this.method00708();
         throw var5;
      } catch (RuntimeException var6) {
         this.method00708();
         throw var6;
      }

      this.method00691();
   }

   private void method00702() throws OrtException {
      var var1 = this.field01602.getInputInfo();
      long[] var2 = ((TensorInfo)((NodeInfo)var1.get(field01633)).getInfo()).getShape();
      this.field01604 = (int)var2[var2.length - 1];
      int var3 = var2.length >= 2 ? (int)var2[var2.length - 2] : 0;
      this.field01606 = var3 > 0 ? var3 : 40;
      if (this.field01604 != this.field01573) {
         throw new IllegalStateException(
            "Neuro model feature_count=" + this.field01604 + " does not match the expected " + this.field01573 + " -- refusing to load an incompatible model."
         );
      }

      this.field01605 = 0;
      var var4 = this.field01602.getOutputInfo();
      NodeInfo var5 = var4.containsKey(field01634) ? (NodeInfo)var4.get(field01635) : (NodeInfo)var4.values().stream().findFirst().orElse(null);
      if (var5 != null && var5.getInfo() instanceof TensorInfo var6) {
         long[] var8 = var6.getShape();
         if (var8.length > 0) {
            this.field01605 = (int)var8[var8.length - 1];
         }
      }
   }

   public int method00703() {
      return this.field01606;
   }

   public int method00704() {
      return this.field01604;
   }

   private static float method00705(Map<String, String> var0, String var1, float var2) {
      String var3 = (String)var0.get(var1);
      if (var3 == null) {
         return var2;
      }

      try {
         return Float.parseFloat(var3);
      } catch (NumberFormatException var5) {
         return var2;
      }
   }

   public Path method00706(String var1) {
      String var2 = var1.endsWith(field01624) ? var1 : var1 + ".onnx";
      return field01571.resolve(var2);
   }

   public OnnxRotationModel.Nested20 method00707() {
      return this.field01578;
   }

   public synchronized void method00708() {
      if (this.field01602 != null) {
         try {
            this.field01602.close();
         } catch (OrtException var2) {
         }

         this.field01602 = null;
      }

      this.field01603 = null;
      this.field01576.clear();
   }

   public int method00709() {
      return this.field01576.size();
   }

   public synchronized boolean method00710() {
      return this.field01602 != null;
   }

   public OnnxRotationModel(int var1, String var2) {
      this.field01580 = field01611;
      this.field01581 = field01612;
      this.field01582 = field01613;
      this.field01584 = field01614;
      this.field01585 = field01615;
      this.field01586 = field01616;
      this.field01587 = field01617;
      this.field01589 = field01618;
      this.field01590 = field01619;
      this.field01599 = -1;
      this.field01606 = 40;
      this.field01607 = field01620;
      this.field01609 = (float)Math.log(field01621);
      this.field01610 = (float)Math.log(field01622);
      this.field01573 = var1;
      this.field01574 = var2;
   }

   public String method00711() {
      return this.field01603;
   }

   private boolean method00712(float var1, float var2, boolean var3, float var4) {
      boolean var5 = Math.abs(var2) <= var4 && (!this.field01591 || var3);
      return var5 && Math.abs(var1) < this.field01588;
   }

   private float[] method00713() {
      return ModelHistoryFlattener.method03798(this.field01576, this.field01606, this.field01604);
   }

   private void method00714() throws OrtException {
      OnnxModelMetadata var1 = this.field01602.getMetadata();
      var var2 = var1.getCustomMetadata();
      int var3 = (int)method00705(var2, field01636, 0.0F);
      if (var3 > 0 && this.field01606 <= 0) {
         this.field01606 = var3;
      }

      if (this.field01574 != null) {
         String var4 = var2.getOrDefault(field01637, "");
         if (!this.field01574.equals(var4)) {
            throw new IllegalStateException(
               "Neuro model schema_id=\""
                  + var4
                  + "\" does not match the expected \""
                  + this.field01574
                  + "\" -- refusing to load a model built for another feature schema."
            );
         }
      }

      this.field01607 = var2.getOrDefault(field01638, field01639);
      this.field01595 = field01640.equals(var2.getOrDefault(field01641, ""));
      this.field01608 = (int)method00705(var2, field01642, 0.0F);
      this.field01609 = method00705(var2, field01643, (float)Math.log(field01644));
      this.field01610 = method00705(var2, field01645, (float)Math.log(field01646));
      this.field01580 = method00705(var2, field01647, field01648);
      this.field01581 = method00705(var2, field01649, field01650);
      this.field01582 = method00705(var2, field01651, field01652);
      this.field01583 = method00705(var2, field01653, 0.0F) > field01654;
      this.field01584 = method00705(var2, field01655, field01656);
      this.field01585 = method00705(var2, field01657, field01658);
      this.field01586 = Math.max(field01659, method00705(var2, field01660, field01661));
      this.field01587 = Math.max(field01662, method00705(var2, field01663, field01664));
      this.field01588 = Math.max(0.0F, method00705(var2, field01665, 0.0F));
      this.field01589 = method00705(var2, field01666, field01667);
      this.field01590 = method00705(var2, field01668, this.field01589);
      this.field01591 = method00705(var2, field01669, 0.0F) > field01670;
      this.field01592 = method00705(var2, field01671, 0.0F);
      this.field01593 = method00705(var2, field01672, 0.0F);
      this.field01594 = method00705(var2, field01673, 0.0F) > field01674;
      if (field01675.equals(this.field01607) && this.field01608 <= 0) {
         throw new IllegalStateException(
            "Neuro model declares output_format=mdn with mdn_components=" + this.field01608 + " -- refusing to load a model with an inconsistent head."
         );
      }

      int var7 = switch (this.field01607) {
         case field01676 -> 4;
         case field01677 -> 5 * this.field01608;
         default -> 2;
      };
      if (this.field01605 > 0 && this.field01605 < var7) {
         throw new IllegalStateException(
            "Neuro model output width "
               + this.field01605
               + " is smaller than the "
               + var7
               + " required by output_format="
               + this.field01607
               + " -- refusing to load a model with an inconsistent head."
         );
      }
   }

   private static float method00715(float var0, float var1, float var2) {
      return var0 < var1 ? var1 : (var0 > var2 ? var2 : var0);
   }

   private float[] method00716(float[] var1, OnnxRotationModel.Nested19 var2) {
      this.field01578.field01687 = 0;
      this.field01578.field01688 = 1.0F;
      this.field01578.field01689 = var1[0];
      this.field01578.field01690 = var1[1];
      return this.method00692(var1[0], var1[1], var1[2], var1[3], var2);
   }

   private float[] method00717(OnnxRotationModel.Nested19 var1) {
      float var2 = (float)this.field01577.nextGaussian();
      float var3 = (float)this.field01577.nextGaussian();
      float var4 = this.field01580;
      float var5 = this.field01581;
      float var6 = this.field01582;
      float var7 = this.field01582;
      if (this.field01583) {
         float var8 = Math.min(1.0F, Math.abs(var1.field01682) / this.field01586);
         float var9 = Math.min(1.0F, Math.abs(var1.field01683) / this.field01587);
         var4 = this.field01584 + (this.field01580 - this.field01584) * var8;
         var5 = this.field01584 + (this.field01581 - this.field01584) * var9;
         var6 = this.field01585 + (this.field01582 - this.field01585) * var8;
         var7 = this.field01585 + (this.field01582 - this.field01585) * var9;
      }

      if (this.field01598) {
         this.field01596 = var4 * this.field01596 + (float)Math.sqrt(1.0 - var4 * var4) * var2;
         this.field01597 = var5 * this.field01597 + (float)Math.sqrt(1.0 - var5 * var5) * var3;
      } else {
         this.field01596 = var2;
         this.field01597 = var3;
         this.field01598 = true;
      }

      return new float[]{this.field01596 * var6, this.field01597 * var7};
   }

   public synchronized void method00718(Path var1) throws OrtException {
      if (this.field01575 == null) {
         throw new OrtException(OrtException.OrtErrorCode.ORT_FAIL, "ONNX Runtime yuklenemedi");
      }

      this.method00708();
      SessionOptions var2 = new SessionOptions();
      var2.setOptimizationLevel(OptLevel.ALL_OPT);
      var2.setIntraOpNumThreads(1);
      var2.setInterOpNumThreads(1);
      this.field01602 = this.field01575.createSession(var1.toString(), var2);
      this.field01603 = var1.getFileName().toString();

      try {
         this.method00702();
         this.method00714();
      } catch (OrtException var4) {
         this.method00708();
         throw var4;
      } catch (RuntimeException var5) {
         this.method00708();
         throw var5;
      }

      this.method00691();
   }

   // $VF: Compiled from s
   public static final class Nested19 {
      private float field01682;
      private float field01683;
      private boolean field01684 = true;
      private boolean field01685 = true;
      private boolean field01686;

      public boolean method00719() {
         return this.field01686;
      }

      public boolean method00720() {
         return this.field01685;
      }

      public void method00721(boolean var1) {
         this.field01684 = var1;
      }

      public boolean method00722() {
         return this.field01684;
      }

      public float method00723() {
         return this.field01683;
      }

      public void method00724(float var1) {
         this.field01682 = var1;
      }

      public void method00725(float var1) {
         this.field01683 = var1;
      }

      public void method00726(boolean var1) {
         this.field01685 = var1;
      }

      public OnnxRotationModel.Nested19 method00727(float var1, float var2, boolean var3, boolean var4, boolean var5) {
         this.field01682 = var1;
         this.field01683 = var2;
         this.field01684 = var3;
         this.field01685 = var4;
         this.field01686 = var5;
         return this;
      }

      public void method00728(boolean var1) {
         this.field01686 = var1;
      }

      public float method00729() {
         return this.field01682;
      }
   }

   // $VF: Compiled from s
   public static final class Nested20 {
      private int field01687 = -1;
      private float field01688;
      private float field01689;
      private float field01690;
      private float field01691;
      private float field01692;
      private float field01693;
      private float field01694;
      private float field01695;
      private float field01696;
      private float field01697;
      private float field01698;
      private float field01699;
      private float field01700;
      private boolean field01701;
      private boolean field01702;
      private long field01703;

      public boolean method00730() {
         return this.field01702;
      }

      public float method00731() {
         return this.field01697;
      }

      public float method00732() {
         return this.field01693;
      }

      public float method00733() {
         return this.field01688;
      }

      public boolean method00734() {
         return this.field01701;
      }

      private void method00735() {
         this.field01687 = -1;
         this.field01688 = 0.0F;
         this.field01689 = this.field01690 = this.field01691 = this.field01692 = this.field01693 = this.field01694 = 0.0F;
         this.field01695 = this.field01696 = this.field01697 = this.field01698 = this.field01699 = this.field01700 = 0.0F;
         this.field01701 = this.field01702 = false;
      }

      public float method00736() {
         return this.field01690;
      }

      public float method00737() {
         return this.field01691;
      }

      public float method00738() {
         return this.field01700;
      }

      public float method00739() {
         return this.field01689;
      }

      public float method00740() {
         return this.field01699;
      }

      public int method00741() {
         return this.field01687;
      }

      public float method00742() {
         return this.field01695;
      }

      public long method00743() {
         return this.field01703;
      }

      public float method00744() {
         return this.field01696;
      }

      public float method00745() {
         return this.field01698;
      }

      public float method00746() {
         return this.field01694;
      }

      public float method00747() {
         return this.field01692;
      }
   }
}
