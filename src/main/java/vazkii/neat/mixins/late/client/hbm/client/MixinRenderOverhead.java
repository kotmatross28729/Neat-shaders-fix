package vazkii.neat.mixins.late.client.hbm.client;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Overwrite;

import com.hbm.render.util.RenderOverhead;

import vazkii.neat.HealthBarRenderer;

@Mixin(value = RenderOverhead.class, priority = 999)
public class MixinRenderOverhead {

    /**
     * @author kotmatross
     * @reason disable name tag rendering above the mob/player, but for hbm
     */
    @Overwrite(remap = false)
    public static boolean shouldRenderTag(EntityLivingBase p_110813_1_) {
        if (p_110813_1_ instanceof EntityPlayer) {
            return Minecraft.isGuiEnabled() && p_110813_1_ != RenderManager.instance.livingPlayer
                && !HealthBarRenderer.cancelNameTagRenderForPlayer
                && !p_110813_1_.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer)
                && p_110813_1_.riddenByEntity == null;
        } else {
            return Minecraft.isGuiEnabled() && p_110813_1_ != RenderManager.instance.livingPlayer
                && !HealthBarRenderer.cancelNameTagRender
                && !p_110813_1_.isInvisibleToPlayer(Minecraft.getMinecraft().thePlayer)
                && p_110813_1_.riddenByEntity == null;
        }
    }
}
