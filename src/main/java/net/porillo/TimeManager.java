package net.porillo;

import net.porillo.config.WorldConfiguration;
import org.bukkit.World;

import static net.porillo.types.Option.*;

public class TimeManager {

    public TimeManager(EntityManager em) {
        for (WorldConfiguration conf : em.getWorlds()) {
            if (conf.get(TIME)) {
                start(em, conf.getWorld(), conf.g(INTERVAL), conf.g(TARGET));
            }
        }
    }

    private void start(EntityManager em, String name, final long target, long every) {
        final World world = EntityManager.getInstance().getServer().getWorld(name);
        EntityManager.getInstance().getServer().getScheduler().scheduleSyncRepeatingTask(em, () -> world.setTime(target), every, every);
    }
}
