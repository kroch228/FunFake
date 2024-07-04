package org.chesterirod.zxxc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;

public class taskS extends BukkitRunnable {
    public void run(){
        for (Player player : Bukkit.getOnlinePlayers()){
            ItemStack item = new ItemStack(player.getEquipment().getItemInOffHand());

            if (item.getType().equals(Material.PLAYER_HEAD)){
                ItemMeta meta = item.getItemMeta();
                    if (meta.hasDisplayName() && meta.getDisplayName().equals("§cТалисман скорости")) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,40,1));
                    }
                    if (meta.hasDisplayName() && meta.getDisplayName().equals("§cТалисман силы")) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE,40,1));
                    }
                    if (meta.hasDisplayName() && meta.getDisplayName().equals("§cТалисман огнейстойкости")) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE,40,1));
                    }
                    if (meta.hasDisplayName() && meta.getDisplayName().equals("§cТалисман невидимости")) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.INVISIBILITY,40,1));
                    }
                    if (meta.hasDisplayName() && meta.getDisplayName().equals("§cТалисман подводного дыхания")) {
                        player.addPotionEffect(new PotionEffect(PotionEffectType.WATER_BREATHING,40,1));
                    }
            }
        }
    }
}
