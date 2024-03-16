package vazkii.neat;

import cpw.mods.fml.relauncher.FMLLaunchHandler;
import net.minecraftforge.common.MinecraftForge;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Neat.MOD_ID, name = Neat.MOD_NAME, version = Neat.VERSION)
public class Neat {

	public static final String MOD_ID = "Neat";
	public static final String MOD_NAME = MOD_ID;
	public static final String BUILD = "GRADLE:BUILD";
	public static final String VERSION = "GRADLE:VERSION-" + BUILD;

	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		NeatConfig.init(event.getSuggestedConfigurationFile());
        boolean client = FMLLaunchHandler.side().isClient();
        if(client) {
            MinecraftForge.EVENT_BUS.register(new HealthBarRenderer());
        }
	}
}
