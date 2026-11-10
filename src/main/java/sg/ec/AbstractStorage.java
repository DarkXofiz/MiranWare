// Original binary: sg/ec/ErJOt335Hmv0FLqF
package sg.ec;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

// $VF: Compiled from s
public abstract class AbstractStorage implements StorageFile, MinecraftAccess {
   private final File field07221;

   protected boolean method03302(byte[] var1) {
      try (FileOutputStream var2 = new FileOutputStream(this.field07221)) {
         var2.write(CustomResourceManager.method02469(var1));
         return true;
      } catch (IOException var7) {
         return false;
      }
   }

   public AbstractStorage(File var1) {
      this.field07221 = var1;
   }

   public File method03303() {
      return this.field07221;
   }
}
