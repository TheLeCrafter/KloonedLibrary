package dev.thelecrafter.libraries.klooned;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class StringUtil {

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
            rainbow.append(colors[i]).append(c);
            i++;
            if (i == colors.length) {
                i = 0;
            }
        }
        return rainbow.toString();
    }

    public static List<String> rainbow(List<String> original) {
        List<String> rainbow = new ArrayList<>();
        for (String string : original) {
            rainbow.add(rainbow(string));
        }
        return rainbow;
    }

    public static String[] rainbow(String[] original) {
        List<String> rainbow = new ArrayList<>();
        for (String string : original) {
            rainbow.add(rainbow(string));
        }
        return rainbow.toArray(new String[]{});
    }

}
