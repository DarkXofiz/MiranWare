// Original binary: sg/ec/QmibWIcPK0vHwuAQ
package sg.ec;

// $VF: Compiled from s
public record VoiceAudioClip(String title, int sampleRate, int channels, int frames, byte[] peaks, byte[] audio) {
   public String duration() {
      int var1 = (this.durationMs() + 500) / 1000;
      return var1 / 60 + ":" + (var1 % 60 < 10 ? "0" : "") + var1 % 60;
   }

   public String quality() {
      return Math.round(this.sampleRate / 100.0F) / 10.0F + " кГц · " + (this.channels == 2 ? "стерео" : "моно");
   }

   public int durationMs() {
      return this.sampleRate <= 0 ? 0 : (int)(this.frames * 1000L / this.sampleRate);
   }
}
