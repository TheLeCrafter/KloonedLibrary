package dev.thelecrafter.libraries.klooned.armorstands;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FollowingArmorstands {

    private static final Map<Player, ArmorStand> armorStandMap = new HashMap<>();
    private static final Set<BukkitTask> tasks = new HashSet<>();

    /**
     * Let an armor stand follow a given player.
     * @param player The player the armor stand will follow.
     * @param stand The armor stand that will follow the player.
     * @param plugin The plugin that is used to schedule tasks.
     * @param radius If the armor stand is outside of the radius, it will follow the player until its back in.
     * @return Returns if the method was successfully executed.
     */
    public static boolean addFollowingArmorStand(Player player, ArmorStand stand, Plugin plugin, int radius) {
        if (stand.isDead()) return false;
        BukkitTask task = new BukkitRunnable() {
            @Override
            public void run() {
                if (stand.isDead()) {
                    tasks.remove(this);
                    this.cancel();
                    return;
                }
                if (!player.isOnline()) {
                    tasks.remove(this);
                    this.cancel();
                    return;
                }
                if (player.getLocation().distance(stand.getLocation()) > radius) {
                    Vector direction = player.getLocation().subtract(stand.getLocation()).clone().toVector();
                    Location location = stand.getLocation().add(direction.clone().multiply(0.1));
                    location.setDirection(direction);
                    stand.teleport(location);
                }
            }
        }.runTaskTimer(plugin, 0, 1);
        tasks.add(task);
        return true;
    }

    /**
     * Remove an armor stand from following a player. The armor stand will not be deleted.
     * @param player The player the armor stand is currently following.
     * @return Returns if the method was successfully executed.
     */
    private static boolean removeFollowingArmorStand(Player player) {
        if (armorStandMap.get(player) == null) return false;
        return armorStandMap.remove(player, armorStandMap.get(player));
    }

}
