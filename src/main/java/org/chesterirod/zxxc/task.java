package org.chesterirod.zxxc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.bukkit.scheduler.BukkitTask;

public class task extends BukkitRunnable {


    public void run(){
         for (Player player : Bukkit.getOnlinePlayers()){
             ItemStack item = new ItemStack(player.getItemInHand());

             if (item.getType().equals(Material.NETHERITE_PICKAXE) && item.hasItemMeta() || item.getType().equals(Material.NETHERITE_AXE) || item.getType().equals(Material.NETHERITE_SHOVEL)){
                 ItemMeta meta = item.getItemMeta();
                 if (meta.hasDisplayName() && meta.getDisplayName().equals("§5Обсидиановая кирка") || meta.getDisplayName().equals("§5Обсидиановая лопата") || meta.getDisplayName().equals("§5Обсидиановый топор")) {
                     player.addPotionEffect(new PotionEffect(PotionEffectType.FAST_DIGGING, 40, 1));

                 }
             }
         }
    }
}
