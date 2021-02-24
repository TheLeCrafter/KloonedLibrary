package dev.thelecrafter.libraries.klooned;

import net.md_5.bungee.api.ChatColor;

public class ColoredStringBuilder {

    private final String original;
    private ChatColor[] pattern;

    public ColoredStringBuilder(String original) {
        this.original = original;
    }

    public void setPattern(ChatColor[] pattern) {
        this.pattern = pattern;
    }

    public void setPattern(ChatColor pattern) {
        this.pattern = new ChatColor[]{pattern};
    }

    public ChatColor[] getPattern() {
        return pattern;
    }

    public String colorize(boolean isRainbow) {
        if (isRainbow) return StringUtil.rainbow(original);
        else return StringUtil.colorizeWithPattern(original, pattern);
    }

}
