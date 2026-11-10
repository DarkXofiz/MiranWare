// Original binary: hex/api/baritone/api/cache/ICachedRegion
package hex.api.baritone.api.cache;

// $VF: Compiled from s
public interface ICachedRegion extends IBlockTypeAccess {
   int getZ();

   int getX();

   boolean isCached(int var1, int var2);
}
