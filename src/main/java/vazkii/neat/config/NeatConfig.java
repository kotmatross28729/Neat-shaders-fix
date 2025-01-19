package vazkii.neat.config;

import com.gtnewhorizon.gtnhlib.config.Config;
import vazkii.neat.Neat;

import java.util.List;

@Config(modid = Neat.MOD_ID, category = "client", filename = "Neat")
public class NeatConfig {
	
	@Config.Comment("Minimum bar size in scaled resolution")
	@Config.DefaultDouble(0.026666672D)
    public static double minScale;
	@Config.Comment("Maximum bar size in scaled resolution")
	@Config.DefaultDouble(0.096666688D)
    public static double maxScale;
	@Config.Comment("Max Distance")
	@Config.DefaultInt(32)
	public static int maxDistance;
	@Config.Comment("Render with Interface Disabled (F1)")
	@Config.DefaultBoolean(false)
	public static boolean renderInF1;
	@Config.Comment("Height Above Mob")
	@Config.DefaultDouble(0.6D)
	public static double heightAbove;
	@Config.Comment("Draw Background")
	@Config.DefaultBoolean(true)
	public static boolean drawBackground;
	@Config.Comment("Background Padding")
	@Config.DefaultInt(2)
	public static int backgroundPadding;
	@Config.Comment("Background Height")
	@Config.DefaultInt(6)
	public static int backgroundHeight;
	@Config.Comment("Health Bar Height")
	@Config.DefaultInt(4)
	public static int barHeight;
	@Config.Comment("Health Bar RGB Colors Modifier, set to a value greater than 0 to apply")
	@Config.DefaultIntList({0,0,0})
	public static int[] barRGBColorsModifier;
	@Config.Comment("Health Bar RGB Colors for mob, requires colorByType")
	@Config.DefaultIntList({0,255,0})
	public static int[] barRGBColorsMob;
	@Config.Comment("Health Bar RGB Colors for hostile mob, requires colorByType")
	@Config.DefaultIntList({255,0,0})
	public static int[] barRGBColorsMonster;
	@Config.Comment("Health Bar RGB Colors for boss, requires colorByType")
	@Config.DefaultIntList({128,0,128})
	public static int[] barRGBColorsBoss;
	@Config.Comment("Plate Size")
	@Config.DefaultInt(25)
	public static int plateSize;
	@Config.Comment("Plate Size (Boss)")
	@Config.DefaultInt(50)
	public static int plateSizeBoss;
	@Config.Comment("Show Attributes")
	@Config.DefaultBoolean(true)
	public static boolean showAttributes;
	@Config.Comment("Show Armor")
	@Config.DefaultBoolean(true)
	public static boolean showArmor;
	@Config.Comment("Group Armor (condense 5 iron icons into 1 diamond icon)")
	@Config.DefaultBoolean(true)
	public static boolean groupArmor;
	@Config.Comment("Color Health Bar by Type (instead of health %)")
	@Config.DefaultBoolean(false)
	public static boolean colorByType;
	@Config.Comment("HP Text Height")
	@Config.DefaultInt(14)
	public static int hpTextHeight;
	@Config.Comment("Show Max HP")
	@Config.DefaultBoolean(true)
	public static boolean showMaxHP;
	@Config.Comment("Show Current HP")
	@Config.DefaultBoolean(true)
	public static boolean showCurrentHP;
	@Config.Comment("Show HP Percentage")
	@Config.DefaultBoolean(true)
	public static boolean showPercentage;
	@Config.Comment("Display on Players")
	@Config.DefaultBoolean(true)
	public static boolean showOnPlayers;
	@Config.Comment("Display on Bosses")
	@Config.DefaultBoolean(true)
	public static boolean showOnBosses;
	@Config.Comment("Only show the health bar for the entity looked at")
	@Config.DefaultBoolean(false)
	public static boolean showOnlyFocused;
	@Config.Comment("Set the max range for checking what entity is looked at")
	@Config.DefaultInt(40)
	public static int showOnlyFocusedRange;
	@Config.Comment("Darken the plates according to ambient brightness")
	@Config.DefaultBoolean(true)
	public static boolean darknessAdjustment;
	@Config.Comment("Should the text be shaded?")
	@Config.DefaultBoolean(false)
    public static boolean darknessAdjustmentText;
	@Config.Comment("Should hide the nametag above the mob?")
	@Config.DefaultBoolean(true)
    public static boolean hideNameTag;
	@Config.Comment("Should hide the name above the player?")
	@Config.DefaultBoolean(true)
    public static boolean hidePlayerName;
	@Config.Comment("Render bar from Neat only if armor from Hbm's Nuclear Tech Mod with \\\"Enemy HUD\\\" is equipped")
	@Config.DefaultBoolean(false)
    public static boolean HbmEnemyHUD;

    //magic numbers, yay
    //actually, 20/(GUI size) * this = 0.07 (def)
	@Config.Comment("Multiplier for the bar size divisor, calculation formula: distance / (1 * getScaleFactorSmall). To find the size of the bar at n distance from the entity, divide the number of blocks from the entity by 1 multiplied by this number, ideally it should be less than 1, around 0.01-0.09. The current number is calculated that at a distance of 20 blocks from the entity, the bar size will be 0.07")
	@Config.DefaultDouble(285.714285714285D)
    public static double getScaleFactorSmall;
	@Config.Comment("Multiplier for the bar size divisor, calculation formula: distance / (2 * getScaleFactorNormal). To find the size of the bar at n distance from the entity, divide the number of blocks from the entity by 2 multiplied by this number, ideally it should be less than 1, around 0.01-0.09. The current number is calculated that at a distance of 20 blocks from the entity, the bar size will be 0.07")
	@Config.DefaultDouble(142.8527142857142D)
    public static double getScaleFactorNormal;
	@Config.Comment("Multiplier for the bar size divisor, calculation formula: distance / (3 * getScaleFactorLarge). To find the size of the bar at n distance from the entity, divide the number of blocks from the entity by 3 multiplied by this number, ideally it should be less than 1, around 0.01-0.09. The current number is calculated that at a distance of 20 blocks from the entity, the bar size will be 0.07")
	@Config.DefaultDouble(95.238095238095D)
    public static double getScaleFactorLarge;
	@Config.Comment("Multiplier for the bar size divisor, calculation formula: distance / (4 * getScaleFactorAutoMax). To find the size of the bar at n distance from the entity, divide the number of blocks from the entity by 4 multiplied by this number, ideally it should be less than 1, around 0.01-0.09. The current number is calculated that at a distance of 20 blocks from the entity, the bar size will be 0.07")
	@Config.DefaultDouble(71.428571428D)
    public static double getScaleFactorAutoMax;
	
	@Config.Comment("Render bar bigger on bosses?")
	@Config.DefaultBoolean(true)
    public static boolean biggerOnBosses;
	
	@Config.Comment("How many times should bar be bigger on bosses?")
	@Config.DefaultDouble(2.0D)
    public static double biggerOnBossesMultiplier;
	
	@Config.Comment("Render bar bigger?")
	@Config.DefaultBoolean(false)
    public static boolean globalMultiplier;
	
	@Config.Comment("How many times should bar be bigger?")
	@Config.DefaultDouble(1.5D)
    public static double globalMultiplierValue;
	
	//TODO
	@Config.Ignore
	public static List<String> blacklist;
}
