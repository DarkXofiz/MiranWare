// Original binary: sg/ec/GaOxpUoLKjmXcwSY
package sg.ec;

import ai.onnxruntime.NodeInfo;
import ai.onnxruntime.OnnxJavaType;
import ai.onnxruntime.OnnxTensor;
import ai.onnxruntime.OnnxValue;
import ai.onnxruntime.OrtEnvironment;
import ai.onnxruntime.OrtException;
import ai.onnxruntime.OrtSession;
import ai.onnxruntime.TensorInfo;
import ai.onnxruntime.OrtSession.Result;
import ai.onnxruntime.OrtSession.SessionOptions;
import ai.onnxruntime.OrtSession.SessionOptions.OptLevel;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.nio.FloatBuffer;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.Map.Entry;
import java.util.stream.Stream;
import net.minecraft.util.Mth;

// $VF: Compiled from s
public final class RotationModelRepository {
   private static final int field08069 = 70;
   private static final int field08070 = 0;
   private static final String field08071 = "field08071";
   private static final float field08072 = 0;
   private static final float field08073 = 0;
   private final ArrayDeque<float[]> field08074 = new ArrayDeque<>();
   private final ArrayDeque<RotationModelSnapshot> field08075 = new ArrayDeque<>();
   private OrtEnvironment field08076;
   private OrtSession field08077;
   private String field08078 = "";
   private String field08079 = "";
   private String field08080 = "";
   private String field08081 = "";
   private String field08082 = "";
   private int field08083 = 16;
   private int field08084 = 70;
   private long[] field08085;
   private float[] field08086;
   private long field08087;
   private boolean field08088;
   private static final long field08089 = Long.MIN_VALUE;
   private static final String field08090 = "Hex";
   private static final String field08091 = "mlRotation";
   private static final String field08092 = "models";
   private static final long field08093 = Long.MIN_VALUE;
   private static final String field08094 = "/assets/hex/models/slothOLD.onnx";
   private static final String field08095 = "slothOLD.onnx";
   private static final String field08096 = "slothOLD.onnx";
   private static final String field08097 = ".onnx";
   private static final String field08098 = "вход";
   private static final String field08099 = "state-вход";
   private static final long field08100 = Long.MIN_VALUE;
   private static final float field08101 = 0.08F;
   private static final float field08102 = 0.08F;
   private static final float field08103 = 0.05F;
   private static final float field08104 = 0.05F;
   private static final String field08105 = "input";
   private static final String field08106 = "input";
   private static final long field08107 = 70L;
   private static final String field08108 = "h0";
   private static final String field08109 = "h0";
   private static final String field08110 = "h0";
   private static final String field08111 = "mu";
   private static final String field08112 = "mu";
   private static final String field08113 = "output";
   private static final String field08114 = "output";
   private static final long field08115 = 2L;
   private static final String field08116 = "h_n";
   private static final String field08117 = "h_n";
   private static final long field08118 = 2147483647L;
   private static final String field08119 = "FuntimeModel: state-вход имеет пустую форму";
   private static final long field08120 = 2147483647L;
   private static final String field08121 = "window_size";
   private static final String field08122 = "window_size";
   private static final String field08123 = "snapshot_features";
   private static final String field08124 = "snapshot_features";
   private static final String field08125 = "input_name";
   private static final String field08126 = "input";
   private static final String field08127 = "output_mu_name";
   private static final String field08128 = "output_name";
   private static final String field08129 = "output";
   private static final String field08130 = "state_input_name";
   private static final String field08131 = "output_state_name";
   private static final float field08132 = 35.0F;
   private static final float field08133 = 28.0F;
   private static final float field08134 = 5.5F;
   private static final float field08135 = 5.0F;
   private static final float field08136 = 0.01F;
   private static final float field08137 = 9999.0F;
   private static final String field08138 = ".onnx";

   public synchronized RotationModelRepository.Nested107 method03634(RotationModelSnapshot var1) {
      if (this.field08077 != null && this.field08076 != null) {
         if (this.field08087 != field08100 && this.field08087 != var1.sessionId()) {
            this.method03664();
         }

         this.field08087 = var1.sessionId();
         float[] var2 = var1.toFeatureVector();
         if (var2.length < 70) {
            return null;
         }

         RotationModelSnapshot var3 = this.field08075.peekFirst();
         if (var3 != null) {
            int var4 = var1.sampleTick() - var3.sampleTick();
            if (var4 != 1) {
               this.field08074.clear();
               this.field08075.clear();
               this.method03651();
               var3 = null;
            }
         }

         if (var3 != null) {
            this.method03663(var2, var1, var3);
         }

         this.field08074.addFirst(this.method03666(var2));
         this.field08075.addFirst(var1);

         while (this.field08074.size() > this.field08083) {
            this.field08074.removeLast();
         }

         while (this.field08075.size() > this.field08083) {
            this.field08075.removeLast();
         }

         float[] var27 = this.method03637();
         long[] var5 = new long[]{1L, this.field08083, this.field08084};
         LinkedHashMap var6 = new LinkedHashMap();

         RotationModelRepository.Nested107 var31;
         try {
            var6.put(this.field08078, OnnxTensor.createTensor(this.field08076, FloatBuffer.wrap(var27), var5));
            if (this.field08086 != null && this.field08085 != null && !this.field08080.isEmpty()) {
               var6.put(this.field08080, OnnxTensor.createTensor(this.field08076, FloatBuffer.wrap(this.field08086), this.field08085));
            }

            Result var7 = this.field08077.run(var6);

            label329: {
               label330: {
                  Object var28;
                  label331: {
                     Object var29;
                     label332: {
                        Object var11;
                        try {
                           if (var7.size() < 1) {
                              var28 = null;
                              break label331;
                           }

                           OnnxValue var8 = this.method03639(var7);
                           if (var8 == null) {
                              var29 = null;
                              break label332;
                           }

                           var29 = var8.getValue();
                           float[] var10 = method03655(var29);
                           if (var10 != null && var10.length >= 2) {
                              float var30 = var10[0];
                              float var12 = var10[1];
                              float var13 = Float.NaN;
                              float var14 = Float.NaN;
                              float var15 = Float.NaN;
                              float var16 = Float.NaN;
                              if (var10.length >= 6) {
                                 var13 = var10[2];
                                 var14 = var10[3];
                                 var15 = var10[4];
                                 var16 = var10[5];
                              } else if (var10.length >= 4) {
                                 var13 = var10[2];
                                 var14 = var10[3];
                              }

                              this.method03669(var7);
                              if (!Float.isFinite(var30) || !Float.isFinite(var12)) {
                                 var31 = null;
                                 break label329;
                              }

                              var31 = new RotationModelRepository.Nested107(
                                 var30,
                                 var12,
                                 Float.isFinite(var13) ? var13 : method03661(var30, true),
                                 Float.isFinite(var14) ? var14 : method03661(var12, false),
                                 Float.isFinite(var15) ? var15 : method03661(var30, true),
                                 Float.isFinite(var16) ? var16 : method03661(var12, false)
                              );
                              break label330;
                           }

                           var11 = null;
                        } catch (Throwable var24) {
                           if (var7 != null) {
                              try {
                                 var7.close();
                              } catch (Throwable var23) {
                                 var24.addSuppressed(var23);
                              }
                           }

                           throw var24;
                        }

                        if (var7 != null) {
                           var7.close();
                        }

                        return (RotationModelRepository.Nested107)var11;
                     }

                     if (var7 != null) {
                        var7.close();
                     }

                     return (RotationModelRepository.Nested107)var29;
                  }

                  if (var7 != null) {
                     var7.close();
                  }

                  return (RotationModelRepository.Nested107)var28;
               }

               if (var7 != null) {
                  var7.close();
               }

               return var31;
            }

            if (var7 != null) {
               var7.close();
            }
         } catch (Exception var25) {
            return null;
         } finally {
            OnnxValue.close(var6.values());
         }

         return var31;
      } else {
         return null;
      }
   }

   private static int method03635(Object var0, float[] var1, int var2) {
      if (var2 >= var1.length || var0 == null) {
         return var2;
      } else if (var0 instanceof float[] var10) {
         int var12 = Math.min(var10.length, var1.length - var2);
         System.arraycopy(var10, 0, var1, var2, var12);
         return var2 + var12;
      } else if (var0 instanceof float[][] var9) {
         int var11 = var2;

         for (float[] var16 : var9) {
            var11 = method03635(var16, var1, var11);
            if (var11 >= var1.length) {
               break;
            }
         }

         return var11;
      } else if (!(var0 instanceof float[][][] var3)) {
         return var2;
      } else {
         int var4 = var2;

         for (float[][] var8 : var3) {
            var4 = method03635(var8, var1, var4);
            if (var4 >= var1.length) {
               break;
            }
         }

         return var4;
      }
   }

   private static int method03636(long[] var0, int var1, int var2, int var3) {
      if (var0.length > var1 && var0[var1] > 0L && var0[var1] <= field08118) {
         return (int)var0[var1];
      } else {
         return var2 > 0 ? var2 : var3;
      }
   }

   private float[] method03637() {
      return ModelHistoryFlattener.method03798(this.field08074, this.field08083, this.field08084);
   }

   private static String method03638(Map<String, NodeInfo> var0, String var1) {
      if (method03647(var0, var1)) {
         return var1;
      }

      if (var0.containsKey(field08111)) {
         return field08112;
      }

      if (var0.containsKey(field08113)) {
         return field08114;
      }

      for (var var3 : var0.entrySet()) {
         TensorInfo var4 = method03656((NodeInfo)var3.getValue());
         if (var4 != null && var4.type == OnnxJavaType.FLOAT) {
            long[] var5 = var4.getShape();
            if (var5.length >= 1 && (var5[var5.length - 1] == field08115 || var5[var5.length - 1] < 0L)) {
               return (String)var3.getKey();
            }
         }
      }

      return var0.keySet().stream().findFirst().orElse("");
   }

   private OnnxValue method03639(Result var1) {
      if (!this.field08079.isEmpty()) {
         var var2 = var1.get(this.field08079);
         if (var2.isPresent()) {
            return (OnnxValue)var2.get();
         }
      }

      return var1.size() > 0 ? var1.get(0) : null;
   }

   public String method03640() {
      return this.field08082;
   }

   private static String method03641(Map<String, NodeInfo> var0, String var1) {
      if (method03647(var0, var1)) {
         return var1;
      }

      if (var0.containsKey(field08116)) {
         return field08117;
      }

      for (var var3 : var0.entrySet()) {
         TensorInfo var4 = method03656((NodeInfo)var3.getValue());
         if (var4 != null && var4.type == OnnxJavaType.FLOAT && var4.getShape().length == 3) {
            return (String)var3.getKey();
         }
      }

      return "";
   }

   private static String method03643(Map<String, NodeInfo> var0, String var1, String var2) throws IOException {
      if (method03647(var0, var1)) {
         return var1;
      }

      if (var0.containsKey(field08105)) {
         return field08106;
      }

      for (var var4 : var0.entrySet()) {
         TensorInfo var5 = method03656((NodeInfo)var4.getValue());
         if (var5 != null && var5.type == OnnxJavaType.FLOAT) {
            long[] var6 = var5.getShape();
            if (var6.length >= 3 && (var6[0] != 1L || var6[2] <= field08107)) {
               return (String)var4.getKey();
            }
         }
      }

      return (String)var0.keySet().stream().findFirst().orElseThrow(() -> new IOException("FuntimeModel: нет входов в модели: " + var2));
   }

   private static float[] method03644(Object var0, int var1) {
      float[] var2 = new float[var1];
      int var3 = method03635(var0, var2, 0);
      return var3 > 0 ? var2 : null;
   }

   public synchronized List<String> method03645() {
      Path var1 = this.method03650();
      if (!Files.isDirectory(var1)) {
         return List.of();
      }

      try (Stream<Path> var2 = Files.list(var1)) {
         return var2.filter(var0 -> Files.isRegularFile(var0))
            .map(Path::getFileName)
            .map(Path::toString)
            .filter(var0 -> var0.toLowerCase(Locale.ROOT).endsWith(field08138))
            .sorted(Comparator.naturalOrder())
            .toList();
      } catch (IOException var7) {
         return List.of();
      }
   }

   public RotationModelRepository() {
      this.field08087 = field08089;
   }

   private RotationModelRepository.Nested106 method03646(Path var1) {
      String var2 = var1.getFileName().toString();
      int var3 = var2.lastIndexOf(46);
      String var4 = var3 > 0 ? var2.substring(0, var3) : var2;
      Path var5 = var1.getParent().resolve(var4 + ".json");
      if (!Files.isRegularFile(var5)) {
         return RotationModelRepository.Nested106.defaults();
      }

      try (BufferedReader var6 = Files.newBufferedReader(var5, StandardCharsets.UTF_8)) {
         JsonObject var7 = JsonParser.parseReader(var6).getAsJsonObject();
         int var8 = var7.has(field08121) ? var7.get(field08122).getAsInt() : 16;
         int var9 = var7.has(field08123) ? var7.get(field08124).getAsInt() : 70;
         String var10 = method03667(var7, field08125, field08126);
         String var11 = method03667(var7, field08127, method03667(var7, field08128, field08129));
         String var12 = method03667(var7, field08130, "");
         String var13 = method03667(var7, field08131, "");
         return new RotationModelRepository.Nested106(var8, var9, var10, var11, var12, var13);
      } catch (Exception var17) {
         return RotationModelRepository.Nested106.defaults();
      }
   }

   private static boolean method03647(Map<String, NodeInfo> var0, String var1) {
      return var1 != null && !var1.isBlank() && var0.containsKey(var1);
   }

   public synchronized void method03648() {
      if (this.field08077 == null) {
         try {
            InputStream var1 = RotationModelRepository.class.getResourceAsStream(EncryptedAssetArchive.method10924(field08094));
            if (var1 == null) {
               return;
            }

            byte[] var2;
            try (InputStream var3 = EncryptedTextureUtils.method08943(var1)) {
               var2 = var3.readAllBytes();
            }

            if (this.field08076 == null) {
               this.field08076 = OrtEnvironment.getEnvironment();
            }

            SessionOptions var9 = new SessionOptions();
            var9.setOptimizationLevel(OptLevel.ALL_OPT);
            this.field08077 = this.field08076.createSession(var2, var9);
            this.method03659(this.field08077.getInputInfo(), this.field08077.getOutputInfo(), RotationModelRepository.Nested106.defaults(), field08095);
            this.field08082 = field08096;
            this.field08088 = false;
            this.method03664();
         } catch (Throwable var8) {
         }
      }
   }

   public Path method03650() {
      return Path.of(field08090, field08091, field08092);
   }

   private void method03651() {
      if (this.field08086 != null) {
         Arrays.fill(this.field08086, 0.0F);
      }
   }

   private RotationModelSnapshot method03652() {
      var var1 = this.field08075.iterator();
      if (!var1.hasNext()) {
         return null;
      }

      var1.next();
      return var1.hasNext() ? (RotationModelSnapshot)var1.next() : null;
   }

   public synchronized void method03653(Path var1) throws OrtException, IOException {
      Path var2 = var1.toAbsolutePath().normalize();
      if (!Files.isRegularFile(var2)) {
         throw new IOException("Файл модели не найден: " + var2);
      }

      Files.createDirectories(this.method03650());
      this.method03665();
      String var3 = var2.getFileName().toString().toLowerCase(Locale.ROOT);
      if (!var3.endsWith(field08097)) {
         throw new IOException("Неподдерживаемый формат Funtime модели: " + var2.getFileName());
      }

      if (this.field08076 == null) {
         this.field08076 = OrtEnvironment.getEnvironment();
      }

      SessionOptions var4 = new SessionOptions();
      var4.setOptimizationLevel(OptLevel.ALL_OPT);
      this.field08077 = this.field08076.createSession(var2.toString(), var4);
      RotationModelRepository.Nested106 var5 = this.method03646(var2);
      this.method03659(this.field08077.getInputInfo(), this.field08077.getOutputInfo(), var5, var2.getFileName().toString());
      this.field08082 = var2.getFileName().toString();
      this.field08088 = false;
      this.method03664();
   }

   public synchronized void method03654() {
      this.method03664();
   }

   private static float[] method03655(Object var0) {
      if (var0 instanceof float[] var3) {
         return var3;
      } else if (var0 instanceof float[][] var1 && var1.length > 0) {
         return var1[0];
      } else {
         return var0 instanceof float[][][] var2 && var2.length > 0 && var2[0].length > 0 ? var2[0][0] : null;
      }
   }

   private static TensorInfo method03656(NodeInfo var0) {
      return var0 != null && var0.getInfo() instanceof TensorInfo var1 ? var1 : null;
   }

   public boolean method03657() {
      return this.field08077 != null;
   }

   private static String method03658(Map<String, NodeInfo> var0, String var1, String var2) {
      if (method03647(var0, var1) && !var1.equals(var2)) {
         return var1;
      }

      if (var0.containsKey(field08108) && !field08109.equals(var2)) {
         return field08110;
      }

      for (var var4 : var0.entrySet()) {
         if (!((String)var4.getKey()).equals(var2)) {
            TensorInfo var5 = method03656((NodeInfo)var4.getValue());
            if (var5 != null && var5.type == OnnxJavaType.FLOAT && var5.getShape().length == 3) {
               return (String)var4.getKey();
            }
         }
      }

      return "";
   }

   private void method03659(Map<String, NodeInfo> var1, Map<String, NodeInfo> var2, RotationModelRepository.Nested106 var3, String var4) throws IOException {
      this.field08078 = method03643(var1, var3.inputName(), var4);
      TensorInfo var5 = method03662((NodeInfo)var1.get(this.field08078), field08098, this.field08078);
      long[] var6 = var5.getShape();
      this.field08083 = method03636(var6, 1, var3.windowSize(), 16);
      this.field08084 = method03636(var6, 2, var3.snapshotFeatures(), 70);
      this.field08079 = method03638(var2, var3.outputName());
      this.field08080 = method03658(var1, var3.stateInputName(), this.field08078);
      this.field08081 = "";
      this.field08085 = null;
      this.field08086 = null;
      if (!this.field08080.isEmpty()) {
         TensorInfo var7 = method03662((NodeInfo)var1.get(this.field08080), field08099, this.field08080);
         this.field08085 = method03660(var7.getShape());
         this.field08086 = new float[method03668(this.field08085)];
         this.field08081 = method03641(var2, var3.stateOutputName());
      }
   }

   private static long[] method03660(long[] var0) throws IOException {
      if (var0.length == 0) {
         throw new IOException(field08119);
      }

      long[] var1 = (long[])var0.clone();

      for (int var2 = 0; var2 < var1.length; var2++) {
         if (var2 == 1) {
            var1[var2] = 1L;
         } else if (var1[var2] <= 0L) {
            var1[var2] = 1L;
         }
      }

      return var1;
   }

   private static float method03661(float var0, boolean var1) {
      float var2 = Math.abs(var0);
      float var3 = var1 ? field08132 : field08133;
      float var4 = var1 ? field08134 : field08135;
      return Mth.clamp(var3 + var2 * var4, field08136, field08137);
   }

   private static TensorInfo method03662(NodeInfo var0, String var1, String var2) throws IOException {
      TensorInfo var3 = method03656(var0);
      if (var3 != null && var3.type == OnnxJavaType.FLOAT) {
         return var3;
      } else {
         throw new IOException("FuntimeModel ONNX " + var1 + " должен быть float tensor: " + var2);
      }
   }

   private void method03663(float[] var1, RotationModelSnapshot var2, RotationModelSnapshot var3) {
      var1[6] = RotationModelFeatures.method01549(Mth.wrapDegrees(var3.deltaYaw()));
      var1[7] = RotationModelFeatures.method01551(var3.deltaPitch());
      var1[8] = RotationModelFeatures.method01549(Mth.wrapDegrees(var2.deltaYaw() - var3.deltaYaw()));
      var1[9] = RotationModelFeatures.method01551(var2.deltaPitch() - var3.deltaPitch());
      var1[10] = RotationModelFeatures.method01549(Mth.wrapDegrees(var2.currentYaw() - var3.currentYaw()));
      var1[11] = RotationModelFeatures.method01551(var2.currentPitch() - var3.currentPitch());
      RotationModelSnapshot var4 = this.method03652();
      if (var4 != null && var3.sampleTick() - var4.sampleTick() == 1) {
         float var5 = Mth.wrapDegrees(var2.currentYaw() - var3.currentYaw());
         float var6 = Mth.wrapDegrees(var3.currentYaw() - var4.currentYaw());
         float var7 = var2.currentPitch() - var3.currentPitch();
         float var8 = var3.currentPitch() - var4.currentPitch();
         var1[42] = RotationModelFeatures.method01549(Mth.wrapDegrees(var5 - var6));
         var1[43] = RotationModelFeatures.method01551(var7 - var8);
         var1[44] = var5 * var6 < 0.0F && Math.abs(var5) > field08101 && Math.abs(var6) > field08102 ? 1.0F : 0.0F;
         var1[45] = var7 * var8 < 0.0F && Math.abs(var7) > field08103 && Math.abs(var8) > field08104 ? 1.0F : 0.0F;
      }

      var1[62] = RotationModelFeatures.method01549(Mth.wrapDegrees(var2.targetYaw() - var3.targetYaw()));
      var1[63] = RotationModelFeatures.method01551(var2.targetPitch() - var3.targetPitch());
      float var9 = Mth.wrapDegrees(var2.currentYaw() - var2.targetYaw());
      float var10 = Mth.wrapDegrees(var3.currentYaw() - var3.targetYaw());
      var1[38] = RotationModelFeatures.method01549(Mth.wrapDegrees(var9 - var10));
      float var11 = var2.currentPitch() - var2.targetPitch();
      float var12 = var3.currentPitch() - var3.targetPitch();
      var1[39] = RotationModelFeatures.method01551(var11 - var12);
   }

   public synchronized void method03664() {
      this.field08074.clear();
      this.field08075.clear();
      this.field08087 = field08093;
      this.method03651();
   }

   public synchronized void method03665() {
      this.method03664();
      this.field08082 = "";
      this.field08083 = 16;
      this.field08084 = 70;
      this.field08078 = "";
      this.field08079 = "";
      this.field08080 = "";
      this.field08081 = "";
      this.field08085 = null;
      this.field08086 = null;
      this.field08088 = false;
      if (this.field08077 != null) {
         try {
            this.field08077.close();
         } catch (OrtException var5) {
         } finally {
            this.field08077 = null;
         }
      }
   }

   private float[] method03666(float[] var1) {
      if (var1.length == this.field08084) {
         return var1;
      }

      float[] var2 = new float[this.field08084];
      System.arraycopy(var1, 0, var2, 0, Math.min(var1.length, this.field08084));
      if (!this.field08088) {
         this.field08088 = true;
      }

      return var2;
   }

   private static String method03667(JsonObject var0, String var1, String var2) {
      if (var0.has(var1) && var0.get(var1).isJsonPrimitive()) {
         String var3 = var0.get(var1).getAsString();
         return var3 != null && !var3.isBlank() ? var3 : var2;
      } else {
         return var2;
      }
   }

   private static int method03668(long[] var0) throws IOException {
      long var1 = 1L;

      for (long var6 : var0) {
         var1 = Math.multiplyExact(var1, var6);
         if (var1 > field08120) {
            throw new IOException("FuntimeModel: state-вход слишком большой: " + Arrays.toString(var0));
         }
      }

      return (int)var1;
   }

   private void method03669(Result var1) throws OrtException {
      if (this.field08086 != null && !this.field08081.isEmpty()) {
         var var2 = var1.get(this.field08081);
         if (!var2.isEmpty()) {
            float[] var3 = method03644(((OnnxValue)var2.get()).getValue(), this.field08086.length);
            if (var3 != null) {
               System.arraycopy(var3, 0, this.field08086, 0, this.field08086.length);
            }
         }
      }
   }

   // $VF: Compiled from s
   private record Nested106(int windowSize, int snapshotFeatures, String inputName, String outputName, String stateInputName, String stateOutputName) {
      static RotationModelRepository.Nested106 defaults() {
         return new RotationModelRepository.Nested106(16, 70, "", "", "", "");
      }
   }

   // $VF: Compiled from s
   public record Nested107(float yawStep, float pitchStep, float turnSpeedYaw, float turnSpeedPitch, float reverbSpeedYaw, float reverbSpeedPitch) {
   }
}
