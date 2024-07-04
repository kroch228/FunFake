package org.chesterirod.zxxc;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Particle;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.plugin.Plugin;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;

import java.util.*;

public class disor implements Listener {
    private final Map<UUID, Long> cooldowns = new HashMap<>();
    private final Plugin plugin;
    private final long COOLDOWN_TIME = 60 * 1000;
    public static void XER(Player player, String message){
       player.sendMessage(message);
    }

    public disor(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() == Material.ENDER_EYE && item.hasItemMeta() && item.getItemMeta().getDisplayName().equals("§b§l[★] §bДезореинтация")) {
            event.setCancelled(true); // Cancel the vanilla behavior

            if (isInCooldown(playerUUID)) {
                long timeLeft = (cooldowns.get(playerUUID) + COOLDOWN_TIME - System.currentTimeMillis()) / 1000;
                player.sendMessage("§c[⌚] §6Время до использовния: " + ChatColor.RED + timeLeft + " сек.");
                return;
            }

            applyDisorEffect(player);
            item.setAmount(item.getAmount() - 1);  // Уменьшаем количество предметов на 1
            cooldowns.put(playerUUID, System.currentTimeMillis());
        }
    }

    private boolean isInCooldown(UUID playerUUID) {
        return cooldowns.containsKey(playerUUID) && (System.currentTimeMillis() - cooldowns.get(playerUUID)) < COOLDOWN_TIME;
    }

    private void applyDisorEffect(Player player) {
        Location playerLocation = player.getLocation();
        for (int degree = 0; degree < 360; degree += 10) {
            double radians = Math.toRadians(degree);
            double x = playerLocation.getX() + Math.cos(radians) * 3;
            double z = playerLocation.getZ() + Math.sin(radians) * 3;
            Location particleLocation = new Location(player.getWorld(), x, playerLocation.getY(), z);
            player.getWorld().spawnParticle(Particle.CLOUD, particleLocation, 0, 0, 0, 0, 0.1);
        }

        // Проверяем всех игроков в радиусе 3 блоков
        for (Player nearbyPlayer : player.getWorld().getPlayers()) {
            if (nearbyPlayer != player && nearbyPlayer.getLocation().distance(player.getLocation()) <= 3) {
                nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.BLINDNESS, 60, 1));
                nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.WITHER, 100, 1)); // Иссушение на 5 секунд
                nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW_DIGGING, 60, 1)); // Утомление на 3 секунды
                nearbyPlayer.addPotionEffect(new PotionEffect(PotionEffectType.SLOW, 60, 1)); // Замедление на 3 секунды
            }
        }
    }
}
