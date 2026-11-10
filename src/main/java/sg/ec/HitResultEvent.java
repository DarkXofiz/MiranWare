// Original binary: sg/ec/EcEXysi552InjC3j
package sg.ec;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.block.state.BlockState;

// $VF: Compiled from s
public class HitResultEvent extends Event {
   public static final HitResultEvent field07211 = new HitResultEvent();
   private Entity field07212;
   private BlockPos field07213;
   private BlockState field07214;
   private HitResultEvent.Nested91 field07215;
   private boolean field07216;

   public void method03281(BlockState var1) {
      this.field07214 = var1;
   }

   public BlockPos method03282() {
      return this.field07213;
   }

   public BlockState method03283() {
      return this.field07214;
   }

   public void method03284(BlockPos var1) {
      this.field07213 = var1;
   }

   public void method03285(HitResultEvent.Nested91 var1) {
      this.field07215 = var1;
   }

   public Entity method03286() {
      return this.field07212;
   }

   public boolean method03287(Entity var1, BlockPos var2, BlockState var3) {
      if (!this.method05698()) {
         this.field07216 = false;
         return true;
      } else {
         this.method05695(false);
         this.field07216 = false;
         this.field07215 = HitResultEvent.Nested91.BLOCK;
         this.field07212 = var1;
         this.field07213 = var2;
         this.field07214 = var3;
         super.method03208();
         if (this.method05694()) {
            this.field07216 = false;
            return false;
         } else {
            this.field07216 = false;
            return true;
         }
      }
   }

   public void method03288(Entity var1) {
      this.field07212 = var1;
   }

   public HitResultEvent.Nested91 method03289() {
      return this.field07215;
   }

   public boolean method03290() {
      return this.field07216;
   }

   public boolean method03291(Entity var1) {
      if (!this.method05698()) {
         return false;
      }

      this.method05695(false);
      this.field07216 = false;
      this.field07215 = HitResultEvent.Nested91.ENTITY;
      this.field07212 = var1;
      super.method03208();
      return this.method05694();
   }

   public void method03292(boolean var1) {
      this.field07216 = var1;
   }

   // $VF: Compiled from s
   public enum Nested91 {
      ENTITY,
      BLOCK;
   }
}
