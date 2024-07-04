package org.chesterirod.zxxc;

import net.md_5.bungee.api.ChatColor;
import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.UUID;

public class trapkanastroyki implements Listener {

    private final Map<UUID, Long> cooldowns = new HashMap<>();
    private final Plugin plugin;
    private final Map<Location, Material> originalBlocks = new HashMap<>();
    private final Set<Location> trapBlocks = new HashSet<>();
    private final Random random = new Random();

    public trapkanastroyki(Plugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerInteract(PlayerInteractEvent event) {
        Player player = event.getPlayer();
        UUID playerUUID = player.getUniqueId();

        // Only handle main-hand interactions
        if (event.getHand() != EquipmentSlot.HAND) {
            return;
        }

        // Only handle right-click actions
        switch (event.getAction()) {
            case RIGHT_CLICK_AIR:
            case RIGHT_CLICK_BLOCK:
                break;
            default:
                return;
        }

        ItemStack item = player.getInventory().getItemInMainHand();

        if (item.getType() == Material.NETHERITE_SCRAP && item.getItemMeta() != null && "§c§l[★] §cТрапка".equals(item.getItemMeta().getDisplayName())) {
            if (cooldowns.containsKey(playerUUID)) {
                long timeLeft = (cooldowns.get(playerUUID) / 1000 + 15) - (System.currentTimeMillis() / 1000);
                if (timeLeft > 0) {
                    player.sendMessage("§c[⌚] §6Время до использовния: " + ChatColor.RED + timeLeft + " сек.");
                    return;
                }
            }

            createTrap(player);
            item.setAmount(item.getAmount() - 1);  // Уменьшаем количество предметов на 1
            cooldowns.put(playerUUID, System.currentTimeMillis());
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location blockLocation = block.getLocation();

        // Проверка на то, что ломается блок трапки
        if (trapBlocks.contains(blockLocation)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        Player player = event.getPlayer();
        Block block = event.getBlock();
        Location blockLocation = block.getLocation();

        // Проверка на установку блока внутри или на трапку
        if (trapBlocks.contains(blockLocation) || isAdjacentToTrap(blockLocation)) {
            event.setCancelled(true);
        }
    }

    private boolean isAdjacentToTrap(Location location) {
        int[][] directions = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
        for (int[] direction : directions) {
            Location adjacentLocation = location.clone().add(direction[0], direction[1], direction[2]);
            if (trapBlocks.contains(adjacentLocation)) {
                return true;
            }
        }
        return false;
    }

    private void createTrap(Player player) {
        int x = player.getLocation().getBlockX();
        int y = player.getLocation().getBlockY() - 1; // One block below the player's current location
        int z = player.getLocation().getBlockZ();

        // Высота трапки установлена на 5 блоков (с крышей)
        int trapWidth = 5;
        int trapHeight = 5;

        Set<Location> newTrapBlocks = new HashSet<>();

        // Сохраняем исходные блоки и создаем трапку
        for (int dx = -(trapWidth / 2); dx <= trapWidth / 2; dx++) {
            for (int dz = -(trapWidth / 2); dz <= trapWidth / 2; dz++) {
                for (int dy = 0; dy < trapHeight; dy++) {
                    Location blockLocation = new Location(player.getWorld(), x + dx, y + dy, z + dz);
                    Block block = blockLocation.getBlock();

                    // Если блок уже является частью другой трапки, пропускаем его
                    if (trapBlocks.contains(blockLocation)) {
                        continue;
                    }

                    // Сохраняем исходный материал блока
                    originalBlocks.put(blockLocation, block.getType());
                    newTrapBlocks.add(blockLocation);

                    if (dy == trapHeight - 1) {
                        // Верхний слой, создаем крышу с отверстиями
                        if ((dx == -1 && dz == -1) || (dx == -1 && dz == 1) || (dx == 1 && dz == -1) || (dx == 1 && dz == 1)) {
                            block.setType(Material.AIR);
                        } else {
                            block.setType(random.nextBoolean() ? Material.OBSIDIAN : Material.CRYING_OBSIDIAN);
                        }
                    } else {
                        // Внутренность трапки должна быть пустой
                        if (dy != 0 && dy != trapHeight - 1 && dx > -(trapWidth / 2) && dx < (trapWidth / 2) && dz > -(trapWidth / 2) && dz < (trapWidth / 2)) {
                            continue;
                        }
                        // Ensure minimum spacing of crying obsidian
                        boolean placeCryingObsidian = random.nextBoolean();
                        if (placeCryingObsidian && (isAdjacentToCryingObsidian(x + dx, y + dy, z + dz))) {
                            placeCryingObsidian = false;
                        }
                        block.setType(placeCryingObsidian ? Material.CRYING_OBSIDIAN : Material.OBSIDIAN);
                    }
                }
            }
        }

        trapBlocks.addAll(newTrapBlocks);

        player.playSound(player.getLocation(), Sound.BLOCK_IRON_DOOR_OPEN, 1.0f, 1.0f);

        new BukkitRunnable() {
            @Override
            public void run() {
                // Удаляем трапку и восстанавливаем исходные блоки
                for (Location blockLocation : newTrapBlocks) {
                    Block block = blockLocation.getBlock();

                    // Восстанавливаем исходный материал блока
                    if (originalBlocks.containsKey(blockLocation)) {
                        block.setType(originalBlocks.get(blockLocation));
                        originalBlocks.remove(blockLocation);
                    } else {
                        block.setType(Material.AIR);
                    }
                    trapBlocks.remove(blockLocation);
                }
                newTrapBlocks.clear();
            }
        }.runTaskLater(plugin, 15 * 20L);
    }

    private boolean isAdjacentToCryingObsidian(int x, int y, int z) {
        int[][] directions = {{1, 0, 0}, {-1, 0, 0}, {0, 1, 0}, {0, -1, 0}, {0, 0, 1}, {0, 0, -1}};
        for (int[] direction : directions) {
            Location adjacentLocation = new Location(null, x + direction[0], y + direction[1], z + direction[2]);
            if (originalBlocks.containsKey(adjacentLocation) && originalBlocks.get(adjacentLocation) == Material.CRYING_OBSIDIAN) {
                return true;
            }
        }
        return false;
    }
}
