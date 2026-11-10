// Original binary: sg/ec/CqMovZOkmE2FjmNR
package sg.ec;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

// $VF: Compiled from s
public class BlockEspConfigManager {
   private static BlockEspConfigManager field06840;
   private final BlockEspTargets field06841 = new BlockEspTargets();
   private List<BlockEspConfigCodec> field06842 = this.method03034();

   private Gson method03027() {
      return new GsonBuilder()
         .registerTypeAdapter(BlockEspEntry.class, new BlockEspEntry.Nested116())
         .registerTypeAdapter(BlockEspConfigCodec.class, new BlockEspConfigCodec.Nested303())
         .setPrettyPrinting()
         .create();
   }

   private void method03028(List<BlockEspConfigCodec> var1) {
      this.field06841.method11176(var1);
   }

   public static boolean method03029(byte[] var0) {
      if (var0 == null) {
         return false;
      }

      BlockEspConfigManager var1 = method03030();
      if (var0.length == 0) {
         var1.method03035(var1.method03034());
         return true;
      }

      var var2 = var1.method03031(CustomResourceManager.method02470(var0));
      if (var2 == null) {
         var2 = var1.method03031(var0);
      }

      var1.method03035(var2 != null ? var2 : var1.method03034());
      return true;
   }

   public static BlockEspConfigManager method03030() {
      if (field06840 == null) {
         field06840 = new BlockEspConfigManager();
      }

      return field06840;
   }

   private List<BlockEspConfigCodec> method03031(byte[] var1) {
      try {
         Type var2 = (new TypeToken<List<BlockEspConfigCodec>>()         // $VF: Compiled from s
 {}).getType();
         return (List<BlockEspConfigCodec>)this.method03027().fromJson(new String(var1, StandardCharsets.UTF_8), var2);
      } catch (Exception var3) {
         return null;
      }
   }

   public BlockEspTargets method03032() {
      return this.field06841;
   }

   public static byte[] method03033() {
      try {
         BlockEspConfigManager var0 = method03030();
         byte[] var1 = var0.method03027().toJson(var0.method03036()).getBytes(StandardCharsets.UTF_8);
         return CustomResourceManager.method02469(var1);
      } catch (Exception var2) {
         return new byte[0];
      }
   }

   private List<BlockEspConfigCodec> method03034() {
      return new ArrayList<>();
   }

   public void method03035(List<BlockEspConfigCodec> var1) {
      this.field06842 = var1 == null ? this.method03034() : var1;
      this.method03028(this.field06842);
   }

   public List<BlockEspConfigCodec> method03036() {
      if (this.field06842 == null) {
         this.field06842 = this.method03034();
      }

      return this.field06842;
   }

   private BlockEspConfigManager() {
      this.method03028(this.field06842);
   }

   public void method03037() {
      this.method03028(this.method03036());
   }
}
