// Original binary: sg/mx/HCdDEcGD44PcNXE3
package sg.mx;

import net.minecraft.client.Minecraft;
import net.minecraft.client.User;
import net.minecraft.network.Connection;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Mutable;
import org.spongepowered.asm.mixin.gen.Accessor;
import sg.ec.MinecraftInteractionAccess;

// $VF: Compiled from s
@Mixin(Minecraft.class)
public interface MinecraftMixin extends MinecraftInteractionAccess {
   @Accessor("rightClickDelay")
   @Override
   void setitemUseCooldown(int var1);

   @Mutable
   @Accessor("user")
   void setSession(User var1);

   @Accessor("pendingConnection")
   void setPendingConnection(Connection var1);

   @Accessor("pendingConnection")
   Connection getPendingConnection();
}
