package org.chesterirod.zxxc;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

public class MenuNastroyki implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        if (event.getView().getTitle().equals("Obsidian Pickaxe Menu")) {
            event.setCancelled(true);

            ItemStack clickedItem = event.getCurrentItem();
            if (clickedItem == null || clickedItem.getType() == Material.AIR) return;
            ItemMeta meta = clickedItem.getItemMeta();
            switch (clickedItem.getType()) {
                case NETHERITE_PICKAXE:
                    event.getWhoClicked().getInventory().addItem(predmety.createObsidianPickaxe());
                    break;
                case NETHERITE_AXE:
                    event.getWhoClicked().getInventory().addItem(predmety.ObsT());
                    break;
                case NETHERITE_SHOVEL:
                    event.getWhoClicked().getInventory().addItem(predmety.ObsK());
                    break;
                case NETHERITE_SCRAP:
                    event.getWhoClicked().getInventory().addItem(predmety.createTrapka());
                    break;
                case PLAYER_HEAD:
                    if(clickedItem.getType() == Material.PLAYER_HEAD && meta.getDisplayName().equals("§cТалисман подводного дыхания")){
                        event.getWhoClicked().getInventory().addItem(predmety.dish());
                    }
                    if(clickedItem.getType() == Material.PLAYER_HEAD && meta.getDisplayName().equals("§cТалисман невидимости")){
                        event.getWhoClicked().getInventory().addItem(predmety.inviz());
                    }
                    if(clickedItem.getType() == Material.PLAYER_HEAD && meta.getDisplayName().equals("§cТалисман огнейстойкости")){
                        event.getWhoClicked().getInventory().addItem(predmety.ognestoi());
                    }
                    if(clickedItem.getType() == Material.PLAYER_HEAD && meta.getDisplayName().equals("§cТалисман скорости")){
                        event.getWhoClicked().getInventory().addItem(predmety.skorost2());
                    }
                    if(clickedItem.getType() == Material.PLAYER_HEAD && meta.getDisplayName().equals("§cТалисман силы")){
                        event.getWhoClicked().getInventory().addItem(predmety.Sila2());
                    }
                    else if(clickedItem.getType() == Material.PLAYER_HEAD && meta.getDisplayName().equals("§c§l[★] §cСфера Афины")){
                        event.getWhoClicked().getInventory().addItem(predmety.createAthenaSphere());
                    }
                    break;
                case NETHERITE_LEGGINGS:
                    event.getWhoClicked().getInventory().addItem(predmety.createPNKR());
                    break;
                case NETHERITE_BOOTS:
                    event.getWhoClicked().getInventory().addItem(predmety.createBotKR());
                    break;
                case NETHERITE_CHESTPLATE:
                    event.getWhoClicked().getInventory().addItem(predmety.createNagKR());
                    break;
                case NETHERITE_HELMET:
                    event.getWhoClicked().getInventory().addItem(predmety.createSHLEM());
                    break;
                case NETHERITE_SWORD:
                    event.getWhoClicked().getInventory().addItem(predmety.CreateMech());
                    break;
                case ENDER_EYE:
                    event.getWhoClicked().getInventory().addItem(predmety.createDisor());
                    break;
                case POTION:
                    event.getWhoClicked().getInventory().addItem(predmety.createpot());
                    event.getWhoClicked().getInventory().addItem(predmety.createis());
                    break;
                case CROSSBOW:
                    event.getWhoClicked().getInventory().addItem(predmety.CreateAr());
                    break;
                case TOTEM_OF_UNDYING:
                    event.getWhoClicked().getInventory().addItem(predmety.createTalisman());
                    break;
            }
        }
    }
}
