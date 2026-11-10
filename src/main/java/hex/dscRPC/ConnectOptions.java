// Original binary: hex/dscRPC/ConnectOptions
package hex.dscRPC;

import java.nio.file.Path;

// $VF: Compiled from s
public class ConnectOptions {
   private final Integer socketIndex;
   private final Path temporaryDirectory;

   public Path temporaryDirectory() {
      return this.temporaryDirectory;
   }

   public static ConnectOptions.Builder builder() {
      return new ConnectOptions.Builder();
   }

   public ConnectOptions(Integer var1, Path var2) {
      this.socketIndex = var1;
      this.temporaryDirectory = var2;
   }

   public Integer socketIndex() {
      return this.socketIndex;
   }

   // $VF: Compiled from s
   public static class Builder {
      private Integer socketIndex = null;
      private Path temporaryDirectory = null;

      public ConnectOptions.Builder socketIndex(Integer var1) {
         this.socketIndex = var1;
         return this;
      }

      public ConnectOptions build() {
         return new ConnectOptions(this.socketIndex, this.temporaryDirectory);
      }

      private Builder() {
      }

      public ConnectOptions.Builder temporaryDirectory(Path var1) {
         this.temporaryDirectory = var1;
         return this;
      }
   }
}
