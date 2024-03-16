package vazkii.neat;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class NeatConfig {
    public static double minScale = 0.026666672D;
    public static double getScaleFactorMultiplier = 71.428571428D;
	public static int maxDistance = 24;
	public static boolean renderInF1 = false;
	public static double heightAbove = 0.6;
	public static boolean drawBackground = true;
	public static int backgroundPadding = 2;
	public static int backgroundHeight = 6;
	public static int barHeight = 4;
	public static int plateSize = 25;
	public static int plateSizeBoss = 50;
	public static boolean showAttributes = true;
	public static boolean showArmor = true;
	public static boolean groupArmor = true;
	public static boolean colorByType = true;
	public static int hpTextHeight = 14;
	public static boolean showMaxHP = true;
	public static boolean showCurrentHP = true;
	public static boolean showPercentage = true;
	public static boolean showOnPlayers = true;
	public static boolean showOnBosses = true;
	public static boolean showOnlyFocused = true;
	public static int showOnlyFocusedRange = 40;
	public static boolean darknessAdjustment = false;
    public static boolean hideNameTag = true;
    public static boolean hidePlayerName = true;
    public static boolean HbmEnemyHUD = false;

	public static List<String> blacklist;

	private static Configuration config;

	public static void init(File f) {
		config = new Configuration(f);
		config.load();

        HbmEnemyHUD = loadPropBool("Render bar from Neat only if armor from Hbm's Nuclear Tech Mod with bonus \"Enemy HUD\" is equipped", HbmEnemyHUD);
        hideNameTag = loadPropBool("Should hide the nametag above the mob?", hideNameTag);
        hidePlayerName = loadPropBool("Should hide the name above the player?", hidePlayerName);
        minScale = loadPropDouble("Minimum bar size in scaled resolution", minScale);
        getScaleFactorMultiplier = loadPropDouble("Multiplier for the bar size divisor, calculation formula: distance / (sr.getScaleFactor() * getScaleFactorMultiplier). sr.getScaleFactor() - size of the game window (taking into account the size of the GUI), the full-screen is 4, the smallest (with GUI) is 1. To find the size of the bar at n distance from the entity, divide the number of blocks from the entity by the size of the game window (from 1 to 4, it’s better to take 4) multiplied by this number, ideally it should be less than 1, around 0.01-0.09. The current number is calculated that at a distance of 20 blocks from the entity, in full screen mode (4) the strip size will be 0.07", getScaleFactorMultiplier);
		maxDistance = loadPropInt("Max Distance", maxDistance);
		renderInF1 = loadPropBool("Render with Interface Disabled (F1)", renderInF1);
		heightAbove = loadPropDouble("Height Above Mob", heightAbove);
		drawBackground = loadPropBool("Draw Background", drawBackground);
		backgroundPadding = loadPropInt("Background Padding", backgroundPadding);
		backgroundHeight = loadPropInt("Background Height", backgroundHeight);
		barHeight = loadPropInt("Health Bar Height", barHeight);
		plateSize = loadPropInt("Plate Size", plateSize);
		plateSizeBoss = loadPropInt("Plate Size (Boss)", plateSizeBoss);
		showAttributes = loadPropBool("Show Attributes", showAttributes);
		showArmor = loadPropBool("Show Armor", showArmor);
		groupArmor = loadPropBool("Group Armor (condense 5 iron icons into 1 diamond icon)", groupArmor);
		colorByType = loadPropBool("Color Health Bar by Type (instead of health %)", colorByType);
		hpTextHeight = loadPropInt("HP Text Height", hpTextHeight);
		showMaxHP = loadPropBool("Show Max HP", showMaxHP);
		showCurrentHP = loadPropBool("Show Current HP", showCurrentHP);
		showPercentage = loadPropBool("Show HP Percentage", showPercentage);
		showOnPlayers = loadPropBool("Display on Players", showOnPlayers);
		showOnBosses = loadPropBool("Display on Bosses", showOnBosses);
		showOnlyFocused = loadPropBool("Only show the health bar for the entity looked at", showOnlyFocused);
		showOnlyFocusedRange = loadPropInt("Set the max range for checking what entity is looked at", showOnlyFocusedRange);
		darknessAdjustment = loadPropBool("Darken the plates according to ambient brightness", darknessAdjustment);

		Property prop = config.get(Configuration.CATEGORY_GENERAL, "Blacklist", new String[] {"shulker", "armor_stand"});
		blacklist = Arrays.asList(prop.getStringList());

		if(config.hasChanged())
			config.save();
	}

	public static int loadPropInt(String propName, int default_) {
		Property prop = config.get(Configuration.CATEGORY_GENERAL, propName, default_);
		return prop.getInt(default_);
	}

	public static double loadPropDouble(String propName, double default_) {
		Property prop = config.get(Configuration.CATEGORY_GENERAL, propName, default_);
		return prop.getDouble(default_);
	}

	public static boolean loadPropBool(String propName, boolean default_) {
		Property prop = config.get(Configuration.CATEGORY_GENERAL, propName, default_);
		return prop.getBoolean(default_);
	}
}
