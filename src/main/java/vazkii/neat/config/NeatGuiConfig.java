package vazkii.neat.config;

import com.gtnewhorizon.gtnhlib.config.ConfigException;
import com.gtnewhorizon.gtnhlib.config.SimpleGuiConfig;
import net.minecraft.client.gui.GuiScreen;

public class NeatGuiConfig extends SimpleGuiConfig {
	public NeatGuiConfig(GuiScreen parent) throws ConfigException {
		super(parent, NeatConfig.class, "Neat", "Neat");
	}
}
