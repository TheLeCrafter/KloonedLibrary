package dev.thelecrafter.libraries.klooned;

import net.md_5.bungee.api.ChatColor;

/**
 * An builder for colored strings.
 */
public class ColoredStringBuilder {

    private final String original;
    private ChatColor[] pattern = new ChatColor[]{};

    /**
     * A builder for colorized strings.
     * @param original The original string you want to colorize with the builder.
     */
    public ColoredStringBuilder(String original) {
        this.original = original;
    }

    /**
     * Set the pattern of the string (only net.md_5.bungee.api.ChatColor).
     * @param pattern The pattern of the builder.
     * @return        Returns the updated ColoredStringBuilder
     */
    public ColoredStringBuilder setPattern(ChatColor[] pattern) {
        this.pattern = pattern.clone();
        return this;
    }

    /**
     * Set the pattern of the string (only net.md_5.bungee.api.ChatColor).
     * @param pattern The pattern of the builder.
     * @return        Returns the updated ColoredStringBuilder
     */
    public ColoredStringBuilder setPattern(ChatColor pattern) {
        this.pattern = new ChatColor[]{pattern};
        return this;
    }

    /**
     * Get the pattern of the string. Returns an empty array if no pattern was given.
     * @return Returns the pattern of the string.
     */
    public ChatColor[] getPattern() {
        return pattern.clone();
    }

    /**
     * Colorize the string.
     * @return Returns the colorized string.
     */
    public String colorize() {
        return StringUtil.colorizeWithPattern(original, pattern);
    }

    /**
     * Colorize the string with the rainbow pattern.
     * @param  isExtendedRainbow The extended rainbow pattern is more detailed.
     * @return Returns the colorized string.
     */
    public String colorizeRainbow(boolean isExtendedRainbow) {
        if (isExtendedRainbow) return StringUtil.extendedRainbow(original);
        else return StringUtil.rainbow(original);
    }

}
