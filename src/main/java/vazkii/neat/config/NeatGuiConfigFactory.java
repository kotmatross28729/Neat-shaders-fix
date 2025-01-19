package vazkii.neat.config;

import com.gtnewhorizon.gtnhlib.config.SimpleGuiFactory;
import net.minecraft.client.gui.GuiScreen;

public class NeatGuiConfigFactory implements SimpleGuiFactory {
	@Override
	public Class<? extends GuiScreen> mainConfigGuiClass() {
		return NeatGuiConfig.class;
	}
}
