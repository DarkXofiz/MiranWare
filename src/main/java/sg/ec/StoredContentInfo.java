// Original binary: sg/ec/de1M2uMox1ahcAhi
package sg.ec;

// $VF: Compiled from s
public record StoredContentInfo(StorageCategory category, String name, long size, long modified, boolean locked) {
   public StoredContentInfo(StorageCategory var1, String var2, long var3, long var5) {
      this(var1, var2, var3, var5, false);
   }

   public StoredContentInfo(StorageCategory category, String name, long size, long modified, boolean locked) {
      name = name == null ? "" : name;
      this.category = category;
      this.name = name;
      this.size = size;
      this.modified = modified;
      this.locked = locked;
   }
}
