package dev.thelecrafter.libraries.klooned;

import org.bukkit.entity.ArmorStand;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class ArmorStandInPlayerDirection {

    /**
     * A map of all currently active armor stands.
     */
    private static final Map<Player, ArmorStand> ARMOR_STAND_MAP = new HashMap<>();
    /**
     * A set of all currently active tasks that control the armor stands in front of the player.
     */
    private static final Set<BukkitTask> TASKS = new HashSet<>();

    /**
     * Let an armor stand follow the player in front of the direction of the player.
     *
     * @param  player The player the armor stand will follow.
     * @param  stand The stand that will follow the player.
     * @param  plugin The plugin that is used to schedule tasks.
     * @param  offset The offset of the player and the armor stand.
     * @return Returns if the method was successfully executed.
     */
    public static boolean addArmorStandInPlayerDirection(Player player, ArmorStand stand, Plugin plugin, int offset) {
        if (stand.isDead()) return false;
        ARMOR_STAND_MAP.put(player, stand);
        BukkitTask task = new BukkitRunnable(){
            @Override
            public void run() {
                if (stand.isDead() || !player.isOnline()) {
                    TASKS.remove(this);
                    ARMOR_STAND_MAP.remove(player);
                    this.cancel();
                    return;
                }
                if (ARMOR_STAND_MAP.get(player) == null) {
                    TASKS.remove(this);
                    this.cancel();
                    return;
                }
                stand.teleport(player.getLocation().add(player.getLocation().getDirection().clone().multiply(offset)));
            }
        }.runTaskTimer(plugin, 0, 1);
        TASKS.add(task);
        return true;
    }

    /**
     * Remove an armor stand from teleporting in front of the player.
     *
     * @param  player The player the armor stand is currently following.
     * @return Returns if the method was successfully executed.
     */
    public static boolean removeArmorStandInPlayerDirection(Player player) {
        if (ARMOR_STAND_MAP.get(player) == null) return false;
        return ARMOR_STAND_MAP.remove(player, ARMOR_STAND_MAP.get(player));
    }

}
