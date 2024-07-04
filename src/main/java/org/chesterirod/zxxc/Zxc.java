package org.chesterirod.zxxc;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitTask;

public class Zxc extends JavaPlugin implements CommandExecutor {
//    TaskSfera sfa = new TaskSfera();
//    task ts = new task();

    public YamlConfiguration items;
    public static Zxc instance;
    private BukkitTask task;
    private BukkitTask TaskTal;
    private BukkitTask TaskSfera;
    private BukkitTask taskS;

    @Override
    public void onEnable() {
        instance = this; // Initialize the instance

        getServer().getPluginManager().registerEvents(new predmety(), this);
        getServer().getPluginManager().registerEvents(new MenuNastroyki(), this);
        getServer().getPluginManager().registerEvents(new trapkanastroyki(this), this);
        getServer().getPluginManager().registerEvents(new disor(this), this);
//        getServer().getPluginManager().registerEvents(new StackablePotions(), this); // Register the StackablePotions listener

        task = new task().runTaskTimer(this, 0, 20);
        taskS = new taskS().runTaskTimer(this,0,20);
//        TaskTal = new TaskTal(tal).runTaskTimer(this, 0, 20);
//        TaskSfera = new TaskSfera().runTaskTimer(this, 0,20);

        // Ensure the command is registered and set its executor
        if (getCommand("funfake") != null) {
            getCommand("funfake").setExecutor(this);
        } else {
            getLogger().severe("Command 'funfake' not found in plugin.yml");
        }
    }

    @Override
    public void onDisable() {
        // Add any necessary cleanup code here
    }

    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (sender instanceof Player) {
            if (sender.hasPermission("command.zxc")) {
                Player player = (Player) sender;
                MenuCreator.openMenu(player);
                return true;
            }  else {sender.sendMessage("У вас нет разрешения");}
        }
        return false;
    }

    public static Zxc getInstance() {
        return instance;
    }
}
