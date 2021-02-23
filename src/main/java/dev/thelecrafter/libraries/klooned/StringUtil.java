package dev.thelecrafter.libraries.klooned;

import net.md_5.bungee.api.ChatColor;

public class StringUtil {

    public String rainbow(String original) {
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

}
