// Original binary: sg/ec/D94XBZSyguKr6xH8
package sg.ec;

// $VF: Compiled from s
public record StoredContent(StorageCategory category, String name, byte[] content) {
   public StoredContent(StorageCategory category, String name, byte[] content) {
      name = name == null ? "" : name;
      content = content == null ? new byte[0] : content;
      this.category = category;
      this.name = name;
      this.content = content;
   }
}
