package vazkii.neat.mixins.early.client.minecraft.client.renderer.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;
import vazkii.neat.HealthBarRenderer;

@Mixin(value = RendererLivingEntity.class, priority = 1002)
public abstract class MixinRendererLivingEntity extends Render {
    /**
     * @author kotmatross
     * @reason disable name tag rendering above the mob/player
     */
   @Overwrite
   protected boolean func_110813_b(EntityLivingBase targetEntity)
   {
       if(targetEntity instanceof EntityPlayer) {
           return Minecraft.isGuiEnabled() && targetEntity != this.renderManager.livingPlayer && !HealthBarRenderer.cancelNameTagRenderForPlayer && !targetEntity.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer) && targetEntity.riddenByEntity == null;
       } else {
           return Minecraft.isGuiEnabled() && targetEntity != this.renderManager.livingPlayer && !HealthBarRenderer.cancelNameTagRender && !targetEntity.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer) && targetEntity.riddenByEntity == null;
       }
   }
}
