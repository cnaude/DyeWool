package nl.robinvandervliet.DyeWool;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;

public class DyeWoolPlayerListener implements Listener {

    public static DyeWool plugin;

    public DyeWoolPlayerListener(DyeWool instance) {
        plugin = instance;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        if (!event.isCancelled() && event.getItem() != null) {
            if (event.getPlayer().hasPermission("dyewool.dyewool")) {
                if (event.getAction().equals(Action.RIGHT_CLICK_BLOCK) && event.getClickedBlock() != null) {
                    if (event.getClickedBlock().getTypeId() == 35 && event.getItem().getTypeId() == 351) {
                        if (event.getItem() != null) {
                            if ((15 - event.getItem().getDurability()) != event.getClickedBlock().getData()) {
                                event.getClickedBlock().setData((byte) (15 - event.getItem().getDurability()));

                                if (event.getItem().getAmount() == 1) {
                                    event.getPlayer().getInventory().remove(event.getItem());
                                } else {
                                    event.getItem().setAmount(event.getItem().getAmount() - 1);
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}