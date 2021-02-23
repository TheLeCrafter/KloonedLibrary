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
        ChatColor[] colors = new ChatColor[]{ChatColor.RED,
                ChatColor.of("#FF7F00"),
                ChatColor.YELLOW,
                ChatColor.GREEN,
                ChatColor.BLUE,
                ChatColor.of("#9400D3"),
                ChatColor.of("#8B00FF")};

        int i = 0;
        StringBuilder rainbow = new StringBuilder();
        for (char c : original.toCharArray()) {
            if (c == ' ') continue;
            else {
                rainbow.append(colors[i]).append(c);
                i++;
                if (i == colors.length) {
                    i = 0;
                }
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

}
