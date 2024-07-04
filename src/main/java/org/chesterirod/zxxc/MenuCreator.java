package org.chesterirod.zxxc;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import java.util.Arrays;

public class MenuCreator {

    public static void openMenu(Player player) {
        Inventory menu = Bukkit.createInventory(null, 54, "Obsidian Pickaxe Menu");

        // Borders
        ItemStack blackGlass = createGlassPane(Material.BLACK_STAINED_GLASS_PANE);
        ItemStack whiteGlass = createGlassPane(Material.WHITE_STAINED_GLASS_PANE);

//        for (int i = 0; i < 54; i++) {
//            if (i < 9 || i >= 18 || i % 9 == 0 || i % 9 == 8) {
//                menu.setItem(i, blackGlass);
//            } else if (i % 9 == 1 || i % 9 == 7) {
//                menu.setItem(i, whiteGlass);
//            }
//        }

        // Obsidian Pickaxe
        ItemStack Sphere = predmety.createAthenaSphere();
        menu.setItem(0, Sphere);

        ItemStack disor = predmety.createDisor();
        menu.setItem(1, disor);

        ItemStack obsidianPickaxe = predmety.createObsidianPickaxe();
        menu.setItem(2, obsidianPickaxe);

        // Trapka
        ItemStack trapka = predmety.createTrapka();
        menu.setItem(3, trapka);

        // Talisman
        ItemStack talisman = predmety.createTalisman();
        menu.setItem(4, talisman);

        ItemStack PNKR = predmety.createPNKR();
        menu.setItem(5, PNKR);

        ItemStack BotKR = predmety.createBotKR();
        menu.setItem(6, BotKR);

        ItemStack NagKR = predmety.createNagKR();
        menu.setItem(7, NagKR);

        ItemStack SHLEM = predmety.createSHLEM();
        menu.setItem(8,SHLEM);

        ItemStack Mech = predmety.CreateMech();
        menu.setItem(9, Mech);

        ItemStack Pot = predmety.createpot();
        menu.setItem(10,Pot);

        ItemStack is = predmety.createis();
        menu.setItem(11, is);

        ItemStack ar = predmety.CreateAr();
        menu.setItem(12, ar);

        ItemStack sila = predmety.Sila2();
        menu.setItem(13, sila);

        ItemStack skor = predmety.skorost2();
        menu.setItem(14,skor);

        ItemStack ogn = predmety.ognestoi();
        menu.setItem(15,ogn);

        ItemStack inv = predmety.inviz();
        menu.setItem(16,inv);

        ItemStack nod = predmety.dish();
        menu.setItem(17,nod);

        ItemStack topor = predmety.ObsT();
        menu.setItem(18,topor);

        ItemStack lop = predmety.ObsK();
        menu.setItem(19,lop);


        player.openInventory(menu);
    }

    private static ItemStack createGlassPane(Material material) {
        ItemStack item = new ItemStack(material);
        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(" ");
        item.setItemMeta(meta);
        return item;
    }

}
