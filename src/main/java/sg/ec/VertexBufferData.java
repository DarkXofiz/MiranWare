// Original binary: sg/ec/uvKKAGEpeerSjAEQ
package sg.ec;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.UUID;

// $VF: Compiled from s
public record VertexBufferData(ByteBuffer buffer) {
   private static final int MAX_STRING_BYTES = 16384;

   public int readInt() {
      return this.buffer.getInt();
   }

   public void writeInt(int var1) {
      this.buffer.putInt(var1);
   }

   public GlobalPlayer readPlayer() {
      return new GlobalPlayer(this.readString(), this.readString(), this.readString(), this.readString());
   }

   public String readString() {
      int var1 = this.readInt();
      if (var1 < 0 || var1 > 16384) {
         throw new IllegalArgumentException("Invalid string length: " + var1);
      }

      if (var1 > this.buffer.remaining()) {
         throw new IllegalArgumentException("String length exceeds remaining buffer: " + var1 + " > " + this.buffer.remaining());
      }

      byte[] var2 = new byte[var1];
      this.buffer.get(var2);
      return new String(var2, StandardCharsets.UTF_8);
   }

   public VertexBufferData(int var1) {
      this(ByteBuffer.allocate(var1));
   }

   public double readDouble() {
      return this.buffer.getDouble();
   }

   public void writeBytes(byte[] var1) {
      byte[] var2 = var1 == null ? new byte[0] : var1;
      this.writeInt(var2.length);
      this.buffer.put(var2);
   }

   public ByteBuffer getByteBuffer() {
      return this.buffer;
   }

   public void writeByte(byte var1) {
      this.buffer.put(var1);
   }

   public void writeVec3f(MutableVector3f var1) {
      this.buffer.putFloat(var1.method01656());
      this.buffer.putFloat(var1.method01647());
      this.buffer.putFloat(var1.method01651());
   }

   public MutableVector3f readVec3f() {
      return new MutableVector3f(this.readFloat(), this.readFloat(), this.readFloat());
   }

   public short readShort() {
      return this.buffer.getShort();
   }

   public void clear() {
      this.buffer.clear();
   }

   public void writePartyPlayer(PartyMember var1) {
      this.writeString(var1.method07586());
      this.writeString(var1.method07580());
      this.writeString(var1.method07590());
      this.writeString(var1.method07584() != null ? var1.method07584() : "UNKNOWN");
      this.writeString(var1.method05943().name());
   }

   public void writeLong(long var1) {
      this.buffer.putLong(var1);
   }

   public UUID readUUID() {
      long var1 = this.readLong();
      long var3 = this.readLong();
      return new UUID(var1, var3);
   }

   public void writeString(String var1) {
      String var2 = var1 == null ? "" : var1;
      byte[] var3 = var2.getBytes(StandardCharsets.UTF_8);
      if (var3.length > 16384) {
         throw new IllegalArgumentException("String is too large: " + var3.length + " bytes");
      }

      this.writeInt(var3.length);
      this.buffer.put(var3);
   }

   public void flip() {
      this.buffer.flip();
   }

   public long readLong() {
      return this.buffer.getLong();
   }

   public byte readByte() {
      return this.buffer.get();
   }

   public void writeDouble(double var1) {
      this.buffer.putDouble(var1);
   }

   public PartyMember readPartyPlayer() {
      String var1 = this.readString();
      String var2 = this.readString();
      String var3 = this.readString();
      String var4 = this.remaining() > 0 ? this.readString() : "UNKNOWN";
      PartyRole var5 = PartyRole.valueOf(this.readString());
      return new PartyMember(var1, var2, var3, var4, var5);
   }

   public float readFloat() {
      return this.buffer.getFloat();
   }

   public byte[] readBytes() {
      int var1 = this.readInt();
      if (var1 >= 0 && var1 <= 4194304 && var1 <= this.buffer.remaining()) {
         byte[] var2 = new byte[var1];
         this.buffer.get(var2);
         return var2;
      } else {
         throw new IllegalArgumentException("Invalid byte array length: " + var1);
      }
   }

   public byte[] array() {
      return this.buffer.array();
   }

   public boolean readBoolean() {
      return this.buffer.get() == 1;
   }

   public void writeUUID(UUID var1) {
      this.writeLong(var1.getMostSignificantBits());
      this.writeLong(var1.getLeastSignificantBits());
   }

   public void writePlayer(GlobalPlayer var1) {
      this.writeString(var1.method07586());
      this.writeString(var1.method07580());
      this.writeString(var1.method07590());
      this.writeString(var1.method07584() != null ? var1.method07584() : "UNKNOWN");
   }

   public void writeFloat(float var1) {
      this.buffer.putFloat(var1);
   }

   public int remaining() {
      return this.buffer.remaining();
   }

   public void writeShort(short var1) {
      this.buffer.putShort(var1);
   }

   public void writeVec3f(float var1, float var2, float var3) {
      this.buffer.putFloat(var1);
      this.buffer.putFloat(var2);
      this.buffer.putFloat(var3);
   }

   public void writeBoolean(boolean var1) {
      this.buffer.put((byte)(var1 ? 1 : 0));
   }
}
