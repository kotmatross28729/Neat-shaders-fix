package vazkii.neat.asm;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.MixinEnvironment;
import vazkii.neat.NeatConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static vazkii.neat.HealthBarRenderer.isHbmLoaded;

@LateMixin
public class NeatLateMixins implements ILateMixinLoader {
    @Override
    public String getMixinConfig() {
        return "mixins.Neat.late.json";
    }
    public static final MixinEnvironment.Side side = MixinEnvironment.getCurrentEnvironment().getSide();

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        //don't integrate mixins if there are no suitable mods
        if(!loadedMods.contains("hbm")) {
            NeatConfig.hideNameTag = false;
        }
        List<String> mixins = new ArrayList<>();
        Logger logger = LogManager.getLogger();

            if (side == MixinEnvironment.Side.CLIENT) {
                if((NeatConfig.hideNameTag || (NeatConfig.hidePlayerName && NeatConfig.showOnPlayers))) {
                    if(isHbmLoaded()) {
                        logger.info("Hbm detected, integrating MixinRenderOverhead (name tag disabler, but for hbm things)");
                        mixins.add("client.hbm.client.MixinRenderOverhead");
                    } else {
                        logger.info("Hbm not detected, skip integration");
                    }
                }
            }

        return mixins;
    }
}
