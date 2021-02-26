package dev.thelecrafter.libraries.klooned;

import org.bukkit.Location;
import org.bukkit.util.Vector;

/**
 * An location handler for safe teleports.
 */
public class SafelyTeleport {

    /**
     * Get the safest location of a original location and an vector that should be added.
     * Will not teleport through blocks.
     *
     * @since Version 1.0.7
     *
     * @param location  The original location.
     * @param direction The vector that should be added.
     * @param distance  The distance of blocks that should be added.
     * @return          Returns the safest location.
     */
    public static Location getSafeLocation(Location location, Vector direction, int distance) {
        Location tpLocation = location.clone();
        for (int i = 1; i < distance; i++) {
            Location cache = location.add(direction.clone().clone().multiply(i));
            if (!cache.getBlock().isSolid() || !cache.clone().clone().add(0, 1, 0).getBlock().isSolid()) {
                tpLocation = cache;
            } else return cache;
        }
        return tpLocation;
    }

}
