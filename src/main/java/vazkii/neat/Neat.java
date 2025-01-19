package vazkii.neat;

import com.gtnewhorizon.gtnhlib.config.ConfigException;
import com.gtnewhorizon.gtnhlib.config.ConfigurationManager;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.common.MinecraftForge;
import org.apache.logging.log4j.LogManager;
import vazkii.neat.config.NeatConfig;

@Mod(
		modid = Neat.MOD_ID,
		name = Neat.MOD_NAME,
		version = Neat.VERSION,
		guiFactory = "vazkii.neat.config.NeatGuiConfigFactory"
)
public class Neat {

	public static final String MOD_ID = "Neat";
	public static final String MOD_NAME = MOD_ID;
	public static final String VERSION = "1.0.3" + " kotmatross edition";
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		try {
			ConfigurationManager.registerConfig(NeatConfig.class);
		} catch (ConfigException e) {
			LogManager.getLogger().warn("Unable to register config", e);
		}
        boolean client = FMLLaunchHandler.side().isClient();
        if(client) {
            MinecraftForge.EVENT_BUS.register(new HealthBarRenderer());
        }
	}
	
	
}
