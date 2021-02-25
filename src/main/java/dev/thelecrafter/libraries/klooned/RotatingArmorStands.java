package dev.thelecrafter.libraries.klooned;

import org.bukkit.Location;
import org.bukkit.entity.ArmorStand;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

import java.util.HashSet;
import java.util.Set;

public class RotatingArmorStands {

    /**
     * A set of all currently active rotating armor stands.
     */
    private static final Set<ArmorStand> ARMOR_STAND_SET = new HashSet<>();

    /**
     * A set of all currently active tasks that control rotating armor stands.
     */
    private static final Set<BukkitTask> TASKS = new HashSet<>();

    /**
     * Let an armor stand rotate.
     *
     * @param  stand The armor stand that should rotate.
     * @param  plugin The plugin that is used to schedule the tasks.
     * @param  partsPerRotation How many times should the circle be divided. Uses 360 / partsPerRotation. The higher
     *                          the value is, the slower and smoother the rotation will be.
     * @return Returns if the method was successfully executed.
     */
    public static boolean addRotatingArmorStand(ArmorStand stand, Plugin plugin, int partsPerRotation) {
        if (stand.isDead()) return false;
        ARMOR_STAND_SET.add(stand);
        BukkitTask task = new BukkitRunnable(){
            float yaw = 360 / partsPerRotation;
            @Override
            public void run() {
                if (stand.isDead()) {
                    TASKS.remove(this);
                    ARMOR_STAND_SET.remove(stand);
                    this.cancel();
                    return;
                }
                if (!ARMOR_STAND_SET.contains(stand)) {
                    TASKS.remove(this);
                    this.cancel();
                    return;
                }
                if (yaw > 360) yaw = yaw - 360;
                else {
                    yaw = yaw + (360 / partsPerRotation);
                    Location location = stand.getLocation().clone();
                    location.setYaw(yaw - 180);
                    stand.teleport(location);
                }
            }
        }.runTaskTimer(plugin, 0, 1);
        TASKS.add(task);
        return true;
    }

    /**
     * Remove an armor stand from being rotated.
     *
     * @param  stand The armor stand that should no longer rotate.
     * @return Returns if the method was executed correctly.
     */
    public static boolean removeRotatingArmorStand(ArmorStand stand) {
        if (!ARMOR_STAND_SET.contains(stand)) return false;
        return ARMOR_STAND_SET.remove(stand);
    }

}
