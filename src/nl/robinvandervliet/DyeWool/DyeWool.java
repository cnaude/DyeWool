package nl.robinvandervliet.DyeWool;

import java.util.logging.Logger;
import org.bukkit.plugin.java.JavaPlugin;

/**
 * DyeWool for Bukkit
 *
 * @author robin0van0der0v
 */
public class DyeWool extends JavaPlugin {

    public static final Logger log = Logger.getLogger("Minecraft");
    private final DyeWoolPlayerListener playerListener = new DyeWoolPlayerListener(this);

    @Override
    public void onEnable() {        
        getServer().getPluginManager().registerEvents(playerListener, this);        
    }

}