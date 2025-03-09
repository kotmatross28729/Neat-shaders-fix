package vazkii.neat.asm;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.spongepowered.asm.mixin.MixinEnvironment;

import com.gtnewhorizon.gtnhmixins.ILateMixinLoader;
import com.gtnewhorizon.gtnhmixins.LateMixin;

@LateMixin
public class NeatLateMixins implements ILateMixinLoader {

    @Override
    public String getMixinConfig() {
        return "mixins.Neat.late.json";
    }

    public static final MixinEnvironment.Side side = MixinEnvironment.getCurrentEnvironment()
        .getSide();

    @Override
    public List<String> getMixins(Set<String> loadedMods) {
        List<String> mixins = new ArrayList<>();
        Logger logger = LogManager.getLogger();

        if (side == MixinEnvironment.Side.CLIENT) {
            if (loadedMods.contains("hbm")) {
                logger.info("Hbm detected, integrating MixinRenderOverhead (name tag disabler, but for hbm things)");
                mixins.add("client.hbm.client.MixinRenderOverhead");
            } else {
                logger.info("Hbm not detected, skip integration");
            }
        }

        return mixins;
    }
}
