package sg.ec;

import com.mojang.blaze3d.vertex.PoseStack;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.world.entity.HumanoidArm;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemDisplayContext;
import net.minecraft.world.item.ItemStack;

public interface PlayerArmRenderAccess {
   void hmi$renderPlayerArm(PoseStack var1, SubmitNodeCollector var2, int var3, float var4, float var5, HumanoidArm var6);

   void hmi$renderMap(PoseStack var1, SubmitNodeCollector var2, int var3, ItemStack var4);

   void hmi$renderItem(LivingEntity var1, ItemStack var2, ItemDisplayContext var3, PoseStack var4, SubmitNodeCollector var5, int var6);
}
