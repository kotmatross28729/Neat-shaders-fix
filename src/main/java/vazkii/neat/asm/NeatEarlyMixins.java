package vazkii.neat.asm;

import com.gtnewhorizon.gtnhmixins.IEarlyMixinLoader;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import cpw.mods.fml.relauncher.IFMLLoadingPlugin;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import vazkii.neat.NeatConfig;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

@IFMLLoadingPlugin.Name("NeatEarlyMixins")
@IFMLLoadingPlugin.MCVersion("1.7.10")
public class NeatEarlyMixins implements IFMLLoadingPlugin, IEarlyMixinLoader {
    @Override
    public String getMixinConfig() {
        return "mixins.Neat.early.json";
    }

    @Override
    public List<String> getMixins(Set<String> loadedCoreMods) {
        boolean client = FMLLaunchHandler.side().isClient();
        List<String> mixins = new ArrayList<>();
         Logger logger = LogManager.getLogger();
            if((NeatConfig.hideNameTag || (NeatConfig.hidePlayerName && NeatConfig.showOnPlayers)) && client) {
                logger.info("Integrating MixinRendererLivingEntity (name tag disabler)");
                mixins.add("client.minecraft.client.renderer.entity.MixinRendererLivingEntity");
            }
        return mixins;
    }

    @Override
    public String[] getASMTransformerClass() {
        return null;
    }

    @Override
    public String getModContainerClass() {
        return null;
    }

    @Override
    public String getSetupClass() {
        return null;
    }

    @Override
    public void injectData(Map<String, Object> data) {

    }

    @Override
    public String getAccessTransformerClass() {
        return null;
    }
}
