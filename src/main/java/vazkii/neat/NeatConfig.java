package vazkii.neat;

import java.io.File;
import java.util.Arrays;
import java.util.List;

import net.minecraftforge.common.config.Configuration;
import net.minecraftforge.common.config.Property;

public class NeatConfig {
    public static double minScale = 0.026666672D;
    public static double maxScale = 0.096666688D;
//    public static double getScaleFactorMultiplier = 71.428571428D;
	public static int maxDistance = 32;
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
	public static boolean colorByType = false;
	public static int hpTextHeight = 14;
	public static boolean showMaxHP = true;
	public static boolean showCurrentHP = true;
	public static boolean showPercentage = true;
	public static boolean showOnPlayers = true;
	public static boolean showOnBosses = true;
	public static boolean showOnlyFocused = false;
	public static int showOnlyFocusedRange = 40;
	public static boolean darknessAdjustment = true;
    public static boolean darknessAdjustmentText = false;
    public static boolean hideNameTag = true;
    public static boolean hidePlayerName = true;
    public static boolean HbmEnemyHUD = false;

    //magic numbers, yay
    //actually, 20/(GUI size) * this = 0.07 (def)
    public static double getScaleFactorSmall = 285.714285714285;
    public static double getScaleFactorNormal = 142.8527142857142;
    public static double getScaleFactorLarge = 95.238095238095;
    public static double getScaleFactorAutoMax = 71.428571428D;

    public static boolean biggerOnBosses = true;

    public static double biggerOnBossesMultiplier = 2.0;

    public static boolean globalMultiplier = false;

    public static double globalMultiplierValue = 1.5;

	public static List<String> blacklist;

	private static Configuration config;

	public static void init(File f) {
		config = new Configuration(f);
		config.load();


        globalMultiplier = loadPropBool("Render bar bigger?", biggerOnBosses);
        globalMultiplierValue= loadPropDouble("How many times should bar be bigger?", biggerOnBossesMultiplier);

        biggerOnBosses = loadPropBool("Render bar bigger on bosses?", biggerOnBosses);
        biggerOnBossesMultiplier = loadPropDouble("How many times should bar be bigger on bosses?", biggerOnBossesMultiplier);

        HbmEnemyHUD = loadPropBool("Render bar from Neat only if armor from Hbm's Nuclear Tech Mod with bonus \"Enemy HUD\" is equipped", HbmEnemyHUD);
        hideNameTag = loadPropBool("Should hide the nametag above the mob?", hideNameTag);
        hidePlayerName = loadPropBool("Should hide the name above the player?", hidePlayerName);
        minScale = loadPropDouble("Minimum bar size in scaled resolution", minScale);
        maxScale = loadPropDouble("Maximum bar size in scaled resolution", maxScale);
        //getScaleFactorMultiplier = loadPropDouble("Multiplier for the bar size divisor, calculation formula: distance / (sr.getScaleFactor() * getScaleFactorMultiplier). sr.getScaleFactor() - size of the game window (taking into account the size of the GUI), the full-screen is 4, the smallest (with GUI) is 1. To find the size of the bar at n distance from the entity, divide the number of blocks from the entity by the size of the game window (from 1 to 4, it’s better to take 4) multiplied by this number, ideally it should be less than 1, around 0.01-0.09. The current number is calculated that at a distance of 20 blocks from the entity, in full screen mode (4) the bar size will be 0.07", getScaleFactorMultiplier);

        getScaleFactorSmall = loadPropDouble("Multiplier for the bar size divisor, calculation formula: distance / (1 * getScaleFactorSmall). To find the size of the bar at n distance from the entity, divide the number of blocks from the entity by 1 multiplied by this number, ideally it should be less than 1, around 0.01-0.09. The current number is calculated that at a distance of 20 blocks from the entity, the bar size will be 0.07", getScaleFactorSmall);
        getScaleFactorNormal = loadPropDouble("Multiplier for the bar size divisor, calculation formula: distance / (2 * getScaleFactorNormal). To find the size of the bar at n distance from the entity, divide the number of blocks from the entity by 2 multiplied by this number, ideally it should be less than 1, around 0.01-0.09. The current number is calculated that at a distance of 20 blocks from the entity, the bar size will be 0.07", getScaleFactorNormal);
        getScaleFactorLarge = loadPropDouble("Multiplier for the bar size divisor, calculation formula: distance / (3 * getScaleFactorLarge). To find the size of the bar at n distance from the entity, divide the number of blocks from the entity by 3 multiplied by this number, ideally it should be less than 1, around 0.01-0.09. The current number is calculated that at a distance of 20 blocks from the entity, the bar size will be 0.07", getScaleFactorLarge);
        getScaleFactorAutoMax = loadPropDouble("Multiplier for the bar size divisor, calculation formula: distance / (4 * getScaleFactorAutoMax). To find the size of the bar at n distance from the entity, divide the number of blocks from the entity by 4 multiplied by this number, ideally it should be less than 1, around 0.01-0.09. The current number is calculated that at a distance of 20 blocks from the entity, the bar size will be 0.07", getScaleFactorAutoMax);


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
        darknessAdjustmentText = loadPropBool("Should the text be shaded?", darknessAdjustmentText);

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
