package dev.thelecrafter.libraries.klooned;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

    /**
     *
     * @param original The string you want to 'rainbowify'.
     * @return The 'rainbowified' string.
     */
    public static String rainbow(String original) {
        ChatColor[] colors = new ChatColor[]{
                ChatColor.RED, // RED
                ChatColor.of("#FF7F00"), // ORANGE
                ChatColor.YELLOW, // YELLOW
                ChatColor.GREEN, // GREEN
                ChatColor.BLUE, // BLUE
                ChatColor.of("#9400D3"), // INDIGO
                ChatColor.of("#8B00FF")}; // VIOLET
        int i = 0;
        StringBuilder rainbow = new StringBuilder();
        for (char c : original.toCharArray()) {
            if (c == ' ') {
                rainbow.append(c);
            }
            else {
                rainbow.append(colors[i]).append(c);
                i++;
                if (i == colors.length) i = 0;
            }
        }
        return rainbow.toString();
    }

    /**
     *
     * @param original The list of strings you want to 'rainbowify'.
     * @return The list of strings that have been 'rainbowified'.
     */
    public static List<String> rainbow(List<String> original) {
        List<String> rainbow = new ArrayList<>();
        for (String string : original) {
            rainbow.add(rainbow(string));
        }
        return rainbow;
    }

    /**
     *
     * @param original The array of strings you want to 'rainbowify'.
     * @return The array of strings that have been 'rainbowified'.
     */
    public static String[] rainbow(String[] original) {
        List<String> rainbow = new ArrayList<>();
        for (String string : original) {
            rainbow.add(rainbow(string));
        }
        return rainbow.toArray(new String[]{});
    }

    /**
     *
     * @param original The original string to colorize.
     * @param pattern The original string will be colorized with this pattern.
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
     *
     * @param original The original list of strings to colorize.
     * @param pattern The original list of strings will be colorized with this pattern.
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
     *
     * @param original The original string array to colorize.
     * @param pattern The original string array will be colorized with this pattern.
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
