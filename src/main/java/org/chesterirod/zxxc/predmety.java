package org.chesterirod.zxxc;

import com.destroystokyo.paper.profile.PlayerProfile;
import com.destroystokyo.paper.profile.ProfileProperty;
import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;
import com.mojang.authlib.properties.PropertyMap;
import org.apache.commons.io.IOUtils;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.OfflinePlayer;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerItemHeldEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemFlag;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.PotionMeta;
import org.bukkit.inventory.meta.SkullMeta;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.scheduler.BukkitRunnable;
import org.checkerframework.checker.units.qual.A;
import org.stringtemplate.v4.compiler.STLexer;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Base64;
import java.util.HashMap;
import java.util.UUID;

public class predmety implements Listener {

    public static ItemStack createObsidianPickaxe() {
        ItemStack obsidianPickaxe = new ItemStack(Material.NETHERITE_PICKAXE);
        ItemMeta meta = obsidianPickaxe.getItemMeta();
        meta.setDisplayName("§5Обсидиановая кирка");
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        obsidianPickaxe.setItemMeta(meta);
        obsidianPickaxe.setDurability((short) 0);
        return obsidianPickaxe;
    }

    public static ItemStack ObsT() {
        ItemStack Topor = new ItemStack(Material.NETHERITE_AXE);
        ItemMeta meta = Topor.getItemMeta();
        meta.setDisplayName("§5Обсидиановый топор");
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        Topor.setItemMeta(meta);
        Topor.setDurability((short) 0);
        return Topor;
    }

    public static ItemStack ObsK() {
        ItemStack lop = new ItemStack(Material.NETHERITE_SHOVEL);
        ItemMeta meta = lop.getItemMeta();
        meta.setDisplayName("§5Обсидиановая лопата");
        meta.addEnchant(Enchantment.DIG_SPEED, 5, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_BLOCKS, 3, true);
        meta.setUnbreakable(true);
        meta.addItemFlags(ItemFlag.HIDE_ATTRIBUTES);
        lop.setItemMeta(meta);
        lop.setDurability((short) 0);
        return lop;
    }

    public static ItemStack Sila2() {
        ItemStack sila = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) sila.getItemMeta();
        if (meta == null) {
            // Handle the case where the meta is not a SkullMeta instance
            return sila;
        }

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        boolean hasTexture = propertyMap.containsKey("textures");
        if (!hasTexture) {
            propertyMap.put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTcxOTM4NzYzOTQ0MCwKICAicHJvZmlsZUlkIiA6ICIwNTU3YjFkZThmZTI0OTgyYjY5NmU5NTdmMzQwNTAwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJjYW1lcm9ub3JlbWFjMTAxIiwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2I5MGVlYjkyZjE5OGFmMTVhZmU3ODc0NDdjNjQ2MWFkZGVlM2RiOTZmMWMzMDQ1YzM4OTc5Njc0MWMyZDFmMGUiCiAgICB9CiAgfQp9"));
        }
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(); // Обработка исключения, связанного с отсутствием поля
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Обработка исключения, связанного с недоступностью поля
        }
        meta.setDisplayName("§cТалисман силы");
        sila.setItemMeta(meta);
        return sila;
    }

    public static ItemStack skorost2() {
        ItemStack skor = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) skor.getItemMeta();
        if (meta == null) {
            // Handle the case where the meta is not a SkullMeta instance
            return skor;
        }
        GameProfile profile = new GameProfile(UUID.randomUUID(), null);

        PropertyMap propertyMap = profile.getProperties();
        boolean hasTexture = propertyMap.containsKey("textures");
        if (!hasTexture) {
            propertyMap.put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTcxOTM4OTI5MzcxMiwKICAicHJvZmlsZUlkIiA6ICIwNTU3YjFkZThmZTI0OTgyYjY5NmU5NTdmMzQwNTAwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJjYW1lcm9ub3JlbWFjMTAxIiwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzI0YzIyYjhkZjBhODUzYTQ5Y2I4MmU5MGE2MThkNjUwMTIxMjIzNjFjODM5ODA2MmZjYmFmNzRkNTY5NmMyYTkiCiAgICB9CiAgfQp9"));
        }
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(); // Обработка исключения, связанного с отсутствием поля
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Обработка исключения, связанного с недоступностью поля
        }
        meta.setDisplayName("§cТалисман скорости");
        skor.setItemMeta(meta);
        return skor;
    }

    public static ItemStack ognestoi() {
        ItemStack ognestoi = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) ognestoi.getItemMeta();
        if (meta == null) {
            // Handle the case where the meta is not a SkullMeta instance
            return ognestoi;
        }

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        boolean hasTexture = propertyMap.containsKey("textures");
        if (!hasTexture) {
        propertyMap.put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTcxOTM4OTY4NzQyMiwKICAicHJvZmlsZUlkIiA6ICIwNTU3YjFkZThmZTI0OTgyYjY5NmU5NTdmMzQwNTAwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJjYW1lcm9ub3JlbWFjMTAxIiwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2YwZGY2YTQ0NGU5MDM1MTQyMDgxM2E3OGQ0YjRjOTM4NGQ3NmM0ZGM5MTgxZTFjMWVmYzZmNTYzZDM1MzY0MzgiCiAgICB9CiAgfQp9"));
        }
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(); // Обработка исключения, связанного с отсутствием поля
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Обработка исключения, связанного с недоступностью поля
        }
        meta.setDisplayName("§cТалисман огнейстойкости");
        ognestoi.setItemMeta(meta);
        return ognestoi;
    }

    public static ItemStack inviz() {
        ItemStack in = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) in.getItemMeta();
        if (meta == null) {
            // Handle the case where the meta is not a SkullMeta instance
            return in;
        }

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        boolean hasTexture = propertyMap.containsKey("textures");
        if (!hasTexture) {
            propertyMap.put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTcxOTM4OTk1ODQ4MCwKICAicHJvZmlsZUlkIiA6ICIwNTU3YjFkZThmZTI0OTgyYjY5NmU5NTdmMzQwNTAwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJjYW1lcm9ub3JlbWFjMTAxIiwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlLzNlMmQ4NGM5NzNkNTI3ZTQxODc0ZDJkYWRmOWMzOTFjNzA4ZjUyNDk4MWM1ODIwMzUxYmQxM2Q0NDU1ZWRkMTAiCiAgICB9CiAgfQp9"));
        }
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(); // Обработка исключения, связанного с отсутствием поля
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Обработка исключения, связанного с недоступностью поля
        }
        meta.setDisplayName("§cТалисман невидимости");
        in.setItemMeta(meta);
        return in;
    }

    public static ItemStack dish() {
        ItemStack d = new ItemStack(Material.PLAYER_HEAD);
        SkullMeta meta = (SkullMeta) d.getItemMeta();
        if (meta == null) {
            // Handle the case where the meta is not a SkullMeta instance
            return d;
        }

        GameProfile profile = new GameProfile(UUID.randomUUID(), null);
        PropertyMap propertyMap = profile.getProperties();
        boolean hasTexture = propertyMap.containsKey("textures");
//        if (!hasTexture) {
        propertyMap.put("textures", new Property("textures", "ewogICJ0aW1lc3RhbXAiIDogMTcxOTM5MDQwMTQ5MCwKICAicHJvZmlsZUlkIiA6ICIwNTU3YjFkZThmZTI0OTgyYjY5NmU5NTdmMzQwNTAwYSIsCiAgInByb2ZpbGVOYW1lIiA6ICJjYW1lcm9ub3JlbWFjMTAxIiwKICAidGV4dHVyZXMiIDogewogICAgIlNLSU4iIDogewogICAgICAidXJsIiA6ICJodHRwOi8vdGV4dHVyZXMubWluZWNyYWZ0Lm5ldC90ZXh0dXJlL2UyYjU3NzcxNDE0ZjhjMDc3M2ZjOTY1ZjdmNTFlOTRjZGMxMDc4NDM1NDk0MTQ0MDRkNjdkMzc5ZjFkZTM5MzEiCiAgICB9CiAgfQp9"));
//        }
        try {
            Field profileField = meta.getClass().getDeclaredField("profile");
            profileField.setAccessible(true);
            profileField.set(meta, profile);
        } catch (NoSuchFieldException e) {
            e.printStackTrace(); // Обработка исключения, связанного с отсутствием поля
        } catch (IllegalAccessException e) {
            e.printStackTrace(); // Обработка исключения, связанного с недоступностью поля
        }
        meta.setDisplayName("§cТалисман подводного дыхания");
        d.setItemMeta(meta);
        return d;
    }

    public static ItemStack createTrapka() {
        ItemStack trapka = new ItemStack(Material.NETHERITE_SCRAP);
        ItemMeta meta = trapka.getItemMeta();
        meta.setDisplayName("§c§l[★] §cТрапка");
        trapka.setItemMeta(meta);
        return trapka;
    }

    public static ItemStack createPNKR() {
        ItemStack PNKR = new ItemStack(Material.NETHERITE_LEGGINGS);
        ItemMeta meta = PNKR.getItemMeta();
        meta.setDisplayName("§4§kqq§4§l Поножи Крушителя §Kqq");
        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        PNKR.setItemMeta(meta);
        return PNKR;
    }

    public static ItemStack createBotKR() {
        ItemStack BotKR = new ItemStack(Material.NETHERITE_BOOTS);
        ItemMeta meta = BotKR.getItemMeta();
        meta.setDisplayName("§4§kqq§4§l Ботинки Крушителя §Kqq");
        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
        meta.addEnchant(Enchantment.DEPTH_STRIDER, 5, true);
        meta.addEnchant(Enchantment.PROTECTION_FALL, 4, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.addEnchant(Enchantment.SOUL_SPEED, 3, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        BotKR.setItemMeta(meta);
        return BotKR;
    }

    public static ItemStack createNagKR() {
        ItemStack NagKR = new ItemStack(Material.NETHERITE_CHESTPLATE);
        ItemMeta meta = NagKR.getItemMeta();
        meta.setDisplayName("§4§kqq§4§l Нагрудник Крушителя §Kqq");
        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        NagKR.setItemMeta(meta);
        return NagKR;
    }

    public static ItemStack createSHLEM() {
        ItemStack SHLEM = new ItemStack(Material.NETHERITE_HELMET);
        ItemMeta meta = SHLEM.getItemMeta();
        meta.setDisplayName("§4§kqq§4§l Шлем Крушителя §Kqq");
        meta.addEnchant(Enchantment.OXYGEN, 3, true);
        meta.addEnchant(Enchantment.PROTECTION_EXPLOSIONS, 5, true);
        meta.addEnchant(Enchantment.PROTECTION_FIRE, 5, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.PROTECTION_PROJECTILE, 5, true);
        meta.addEnchant(Enchantment.PROTECTION_ENVIRONMENTAL, 5, true);
        meta.addEnchant(Enchantment.WATER_WORKER, 1, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        SHLEM.setItemMeta(meta);
        return SHLEM;
    }

    public static ItemStack CreateMech() {
        ItemStack Mech = new ItemStack(Material.NETHERITE_SWORD);
        ItemMeta meta = Mech.getItemMeta();
        meta.setDisplayName("§4§kqq§4§l Меч Крушителя §Kqq");
        meta.addEnchant(Enchantment.DAMAGE_ARTHROPODS, 7, true);
        meta.addEnchant(Enchantment.FIRE_ASPECT, 2, true);
        meta.addEnchant(Enchantment.LOOT_BONUS_MOBS, 5, true);
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.DAMAGE_ALL, 7, true);
        meta.addEnchant(Enchantment.DAMAGE_UNDEAD, 7, true);
        meta.addEnchant(Enchantment.SWEEPING_EDGE, 3, true);
        meta.addEnchant(Enchantment.DURABILITY, 5, true);
        Mech.setItemMeta(meta);
        return Mech;
    }

    public static ItemStack createTalisman() {
        ItemStack talisman = new ItemStack(Material.TOTEM_OF_UNDYING);
        ItemMeta meta = talisman.getItemMeta();
        meta.setDisplayName("§4§kqq§4§l Талисман Крушителя §Kqq");
        AttributeModifier damageModifier = new AttributeModifier(UUID.randomUUID(), "Damage bonus", 4, AttributeModifier.Operation.ADD_NUMBER, org.bukkit.inventory.EquipmentSlot.OFF_HAND);
        AttributeModifier BRONYA = new AttributeModifier(UUID.randomUUID(), "bronya", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);
        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "Health reduction", 4, AttributeModifier.Operation.ADD_NUMBER, org.bukkit.inventory.EquipmentSlot.OFF_HAND);
        AttributeModifier TVBRONYA = new AttributeModifier(UUID.randomUUID(), "Tvbron", 3, AttributeModifier.Operation.ADD_NUMBER, EquipmentSlot.OFF_HAND);

        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, healthModifier);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, TVBRONYA);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, BRONYA);
//        meta.setLore(Arrays.asList("§7+4 здоровья", "§7+3 урона", "§7+4 брони", "§7+4 твёрдости брони", "§7(Только в левой руке)"));
        talisman.setItemMeta(meta);
        return talisman;
    }

    public static ItemStack createDisor() {
        ItemStack disor = new ItemStack(Material.ENDER_EYE);
        ItemMeta meta = disor.getItemMeta();
        meta.setDisplayName("§b§l[★] §bДезореинтация");
        disor.setItemMeta(meta);
        return disor;
    }

    public static ItemStack createpot() {
        ItemStack customPotion = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) customPotion.getItemMeta();
        meta.addCustomEffect(new PotionEffect(PotionEffectType.INCREASE_DAMAGE, 3 * 60 * 20, 2), true);
        meta.addCustomEffect(new PotionEffect(PotionEffectType.SPEED, 3 * 60 * 20, 2), true);
        customPotion.setAmount(16);
        meta.addCustomEffect(new PotionEffect(PotionEffectType.FIRE_RESISTANCE, 8 * 60 * 20, 0), true);
        meta.setDisplayName("Жёсткое зелье");
        customPotion.setItemMeta(meta);
        return customPotion;
    }

    public static ItemStack createis() {
        ItemStack is = new ItemStack(Material.POTION);
        PotionMeta meta = (PotionMeta) is.getItemMeta();
        meta.addCustomEffect(new PotionEffect(PotionEffectType.HEALTH_BOOST, 0, 1), true);
        meta.setDisplayName("ПИТЬЕВЫЕ ИСЦЕЛЫ-ААХАХАХАХА");
        is.setAmount(32);
        is.setItemMeta(meta);
        return is;
    }

    public static ItemStack CreateAr() {
        ItemStack ar = new ItemStack(Material.CROSSBOW);
        ItemMeta meta = ar.getItemMeta();
        meta.setDisplayName("§4§kqq§4§l Арбалет Крушителя §Kqq");
        meta.addEnchant(Enchantment.MENDING, 1, true);
        meta.addEnchant(Enchantment.MULTISHOT, 1, true);
        meta.addEnchant(Enchantment.PIERCING, 5, true);
        meta.addEnchant(Enchantment.QUICK_CHARGE, 3, true);
        meta.addEnchant(Enchantment.DURABILITY, 3, true);
        ar.setItemMeta(meta);
        return ar;


    }

    public static ItemStack createAthenaSphere() {
        ItemStack athenaSphere = new ItemStack(Material.PLAYER_HEAD, 1);
        SkullMeta meta = (SkullMeta) athenaSphere.getItemMeta();
        OfflinePlayer owner = Bukkit.getOfflinePlayer("cameronoremac101");
        meta.setOwningPlayer(owner);
        meta.setDisplayName("§c§l[★] §cСфера Афины");
        meta.addEnchant(Enchantment.VANISHING_CURSE, 1, true);
//        meta.setLore(Arrays.asList("§9+15% Скорости", "§с-2 Максимальное здоровье ", "§9+15% Скорость атаки", "§9+3 урона", "§7(Только в левой руке)"));
        AttributeModifier speedModifier = new AttributeModifier(UUID.randomUUID(), "Speed bonus", 0.15, AttributeModifier.Operation.ADD_SCALAR, org.bukkit.inventory.EquipmentSlot.OFF_HAND);
        AttributeModifier healthModifier = new AttributeModifier(UUID.randomUUID(), "Health reduction", -2, AttributeModifier.Operation.ADD_NUMBER, org.bukkit.inventory.EquipmentSlot.OFF_HAND);
        AttributeModifier attackSpeedModifier = new AttributeModifier(UUID.randomUUID(), "Attack speed bonus", 0.15, AttributeModifier.Operation.ADD_SCALAR, org.bukkit.inventory.EquipmentSlot.OFF_HAND);
        AttributeModifier damageModifier = new AttributeModifier(UUID.randomUUID(), "Damage bonus", 3, AttributeModifier.Operation.ADD_NUMBER, org.bukkit.inventory.EquipmentSlot.OFF_HAND);

        meta.addAttributeModifier(Attribute.GENERIC_MOVEMENT_SPEED, speedModifier);
        meta.addAttributeModifier(Attribute.GENERIC_MAX_HEALTH, healthModifier);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_SPEED, attackSpeedModifier);
        meta.addAttributeModifier(Attribute.GENERIC_ATTACK_DAMAGE, damageModifier);
        athenaSphere.setItemMeta(meta);
        return athenaSphere;
    }


    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        ItemStack item = event.getItemInHand();
        if (item != null && item.getType() == Material.PLAYER_HEAD && item.hasItemMeta()) {
            ItemMeta meta = item.getItemMeta();
            if (meta.hasDisplayName() && meta.getDisplayName().equals("§c§l[★] §cСфера Афины") || meta.getDisplayName().equals("§cТалисман подводного дыхания") || meta.getDisplayName().equals("§cТалисман скорости") || meta.getDisplayName().equals("§cТалисман огнейстойкости") || meta.getDisplayName().equals("§cТалисман невидимости") || meta.getDisplayName().equals("§cТалисман силы")) {
                event.setCancelled(true);
            }
        }
    }
}
