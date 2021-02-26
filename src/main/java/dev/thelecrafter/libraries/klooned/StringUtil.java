package dev.thelecrafter.libraries.klooned;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

/**
 * An easy to use utility class for colored strings.
 */
public class StringUtil {

    /**
     * The pattern of the rainbow method.
     */
    public static final ChatColor[] RAINBOW_PATTERN = new ChatColor[]{
            ChatColor.RED, // RED
            ChatColor.of("#FF7F00"), // ORANGE
            ChatColor.YELLOW, // YELLOW
            ChatColor.GREEN, // GREEN
            ChatColor.BLUE, // BLUE
            ChatColor.of("#9400D3"), // INDIGO
            ChatColor.of("#8B00FF")}; // VIOLET
    /**
     * The pattern of the extended rainbow method.
     */
    public static final ChatColor[] EXTENDED_RAINBOW_PATTERN = new ChatColor[]{
            ChatColor.of("#ff0000"),
            ChatColor.of("#ff4000"),
            ChatColor.of("#ff8000"),
            ChatColor.of("#ffbf00"),
            ChatColor.of("#ffff00"),
            ChatColor.of("#bfff00"),
            ChatColor.of("#80ff00"),
            ChatColor.of("#40ff00"),
            ChatColor.of("#00ff00"),
            ChatColor.of("#00ff40"),
            ChatColor.of("#00ff80"),
            ChatColor.of("#00ffbf"),
            ChatColor.of("#00ffff"),
            ChatColor.of("#00bfff"),
            ChatColor.of("#0080ff"),
            ChatColor.of("#0040ff"),
            ChatColor.of("#0000ff"),
            ChatColor.of("#4000ff"),
            ChatColor.of("#8000ff"),
            ChatColor.of("#bf00ff"),
            ChatColor.of("#ff00ff"),
            ChatColor.of("#ff00bf"),
            ChatColor.of("#ff0080"),
            ChatColor.of("#ff0040")};

    /**
     * Colorize your string in rainbow colors.
     *
     * @param  original The string you want to colorize.
     * @return The colorized string.
     */
    public static String rainbow(String original) {
        int i = 0;
        StringBuilder rainbow = new StringBuilder();
        for (char c : original.toCharArray()) {
            if (c == ' ') {
                rainbow.append(c);
            }
            else {
                rainbow.append(RAINBOW_PATTERN[i]).append(c);
                i++;
                if (i == RAINBOW_PATTERN.length) i = 0;
            }
        }
        return rainbow.toString();
    }

    /**
     * Colorize your list of strings in rainbow colors.
     *
     * @see    #rainbow(String)
     * @param  original The list of strings you want to colorize.
     * @return The list of strings that have been colorized.
     */
    public static List<String> rainbow(List<String> original) {
        List<String> rainbow = new ArrayList<>();
        for (String string : original) {
            rainbow.add(rainbow(string));
        }
        return rainbow;
    }

    /**
     * Colorize an array of strings in rainbow colors.
     *
     * @see    #rainbow(String)
     * @param  original The array of strings you want to colorize.
     * @return The array of strings that have been colorized.
     */
    public static String[] rainbow(String[] original) {
        List<String> rainbow = new ArrayList<>();
        for (String string : original) {
            rainbow.add(rainbow(string));
        }
        return rainbow.toArray(new String[]{});
    }

    /**
     * The extended version of the rainbow colorizer (more detailed colors).
     *
     * @param  original The string you want to colorize.
     * @return The string that has been colorized.
     */
    public static String extendedRainbow(String original) {
        int i = 0;
        StringBuilder rainbow = new StringBuilder();
        for (char c : original.toCharArray()) {
            if (c == ' ') {
                rainbow.append(c);
            } else {
                rainbow.append(EXTENDED_RAINBOW_PATTERN[i]).append(c);
                i++;
                if (i == EXTENDED_RAINBOW_PATTERN.length) {
                    i = 0;
                }
            }
        }
        return rainbow.toString();
    }

    /**
     * The extended version of the rainbow colorizer (more detailed colors).
     *
     * @see    #extendedRainbow(String)
     * @param  original The list of strings you want to colorize.
     * @return The list of strings that have been colorized.
     */
    public static List<String> extendedRainbow(List<String> original) {
        List<String> rainbow = new ArrayList<>();
        for (String string : original) {
            rainbow.add(extendedRainbow(string));
        }
        return rainbow;
    }

    /**
     * The extended version of the rainbow colorizer (more detailed colors).
     *
     * @see    #extendedRainbow(String)
     * @param  original The array of strings you want to colorize.
     * @return The array of strings that have been colorized.
     */
    public static String[] extendedRainbow(String[] original) {
        List<String> rainbow = new ArrayList<>();
        for (String string : original) {
            rainbow.add(extendedRainbow(string));
        }
        return rainbow.toArray(new String[]{});
    }

    /**
     * Colorize an string with an given pattern.
     *
     * @param  original The original string to colorize.
     * @param  pattern The original string will be colorized with this pattern.
     * @return Returns the colorized string. If pattern.length is 0, returns the original string.
     */
    public static String colorizeWithPattern(String original, ChatColor[] pattern) {
        if (pattern.length > 0) {
            int i = 0;
            StringBuilder colorized = new StringBuilder();
            for (char c : original.toCharArray()) {
                if (c == ' ') {
                    colorized.append(c);
                }
                else {
                    colorized.append(pattern[i]).append(c);
                    i++;
                    if (i == pattern.length) i = 0;
                }
            }
            return colorized.toString();
        } else return original;
    }

    /**
     * Colorize an list of strings with an given pattern.
     *
     * @see    #colorizeWithPattern(String, ChatColor[])
     * @param  original The original list of strings to colorize.
     * @param  pattern The original list of strings will be colorized with this pattern.
     * @return Returns the colorized string. If pattern.length is 0, returns the original list of strings.
     */
    public static List<String> colorizeWithPattern(List<String> original, ChatColor[] pattern) {
        if (pattern.length > 0) {
            List<String> colorized = new ArrayList<>();
            for (String string : original) {
                colorized.add(colorizeWithPattern(string, pattern));
            }
            return colorized;
        } else return original;
    }

    /**
     * Colorize an array of strings with an given pattern.
     *
     * @see    #colorizeWithPattern(String, ChatColor[])
     * @param  original The original string array to colorize.
     * @param  pattern The original string array will be colorized with this pattern.
     * @return Returns the colorized string array. If pattern.length is 0, returns the original string array.
     */
    public static String[] colorizeWithPattern(String[] original, ChatColor[] pattern) {
        if (pattern.length > 0) {
            List<String> colorized = new ArrayList<>();
            for (String string : original) {
                colorized.add(colorizeWithPattern(string, pattern));
            }
            return colorized.toArray(new String[]{});
        } else return original;
    }

}
