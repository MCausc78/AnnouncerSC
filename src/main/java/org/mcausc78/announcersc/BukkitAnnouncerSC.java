package org.mcausc78.announcersc;

import me.clip.placeholderapi.PlaceholderAPI;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;

public class BukkitAnnouncerSC extends JavaPlugin {
	protected FileConfiguration config;
	public void onEnable() {
        if (Bukkit.getPluginManager().getPlugin("PlaceholderAPI") != null) {
        	config = getConfig();
    		System.out.println(" §r");
    		System.out.println(" §aA§a§nN§a§nN§a§oO§aU§a§nN§cC§eE§rR§6§lS§e§lC");
    		System.out.println(" §bRunning on Bukkit - §3" + getServer().getVersion());
    		System.out.println(" §r");
    		System.out.println(" §a§lENABLED.");
    		getLogger().info("Hooked into PlaceholderAPI.");
    		saveDefaultConfig();
        }
        else {
            getLogger().warning("Could not find PlaceholderAPI! This plugin is required. Disabling.");
            Bukkit.getPluginManager().disablePlugin(this);
        }
		// ANNOUNCERSC
	}
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		if (cmd.getName().equalsIgnoreCase("announcersc")) {
			if (args.length > 0) {
				if (args[0].equalsIgnoreCase("reboot")) {
					String args_ = "";
					for(int i = 0; i < args.length; i++) {
						String arg = args[i] + " ";
						args_ = args_ + arg;
					}
					String PLUGIN_REBOOTED_STRING = this.getConfig().getString("plugin-rebooted", "&aAnnouncerSC successfully restarted!")
							.replace("&", "§")
							.replace("$username", sender.getName())
							.replace("$servername", getServer().getServerName())
							.replace("$serverversion", getServer().getVersion())
							.replace("$command", cmd.getName())
							.replace("$label", label)
							.replace("$args", args_);
					String PLUGIN_REBOOTED_WITH_PLACEHOLDERS = PlaceholderAPI.setPlaceholders(getServer().getPlayer(sender.getName()), PLUGIN_REBOOTED_STRING);
					String PLUGIN_REBOOT_PERMISSION = "announcersc.admin.reboot";
					String NO_PERMISSION_STRING = this.getConfig().getString("no-perms", "&cYou don't have permissions.")
							.replace("&", "§")
							.replace("$username", sender.getName())
							.replace("$servername", getServer().getServerName())
							.replace("$serverversion", getServer().getVersion())
							.replace("$command", cmd.getName())
							.replace("$label", label)
							.replace("$perm", PLUGIN_REBOOT_PERMISSION);
					String NO_PERMISSION_WITH_PLACEHOLDERS = PlaceholderAPI.setPlaceholders(getServer().getPlayer(sender.getName()), NO_PERMISSION_STRING);
					if(sender.hasPermission(PLUGIN_REBOOT_PERMISSION)) {
						Bukkit.getPluginManager().disablePlugin(this);
						Bukkit.getPluginManager().enablePlugin(this);
						sender.sendMessage(PLUGIN_REBOOTED_WITH_PLACEHOLDERS);
					}
					else sender.sendMessage(NO_PERMISSION_WITH_PLACEHOLDERS);
					return true;
				}
				if (args[0].equalsIgnoreCase("reload")) {
					String args____ = "";
					for(int i = 0; i < args.length; i++) {
						String arg = args[i] + " ";
						args____ = args____ + arg;
					}
					String PLUGIN_RELOADED_STRING = this.getConfig().getString("plugin-reloaded", "&aAnnouncerSC successfully reloaded!")
							.replace("&", "§")
							.replace("$username", sender.getName())
							.replace("$servername", getServer().getServerName())
							.replace("$serverversion", getServer().getVersion())
							.replace("$command", cmd.getName())
							.replace("$label", label)
							.replace("$args", args____);
					String PLUGIN_RELOADED_WITH_PLACEHOLDERS = PlaceholderAPI.setPlaceholders(getServer().getPlayer(sender.getName()), PLUGIN_RELOADED_STRING);
					String PLUGIN_RELOAD_PERMISSION = "announcersc.admin.reload";
					String NO_PERMISSION_STRING = this.getConfig().getString("no-perms", "&cYou don't have permissions.")
							.replace("&", "§")
							.replace("$username", sender.getName())
							.replace("$servername", getServer().getServerName())
							.replace("$serverversion", getServer().getVersion())
							.replace("$command", cmd.getName())
							.replace("$label", label)
							.replace("$perm", PLUGIN_RELOAD_PERMISSION);
					String NO_PERMISSION_WITH_PLACEHOLDERS = PlaceholderAPI.setPlaceholders(getServer().getPlayer(sender.getName()), NO_PERMISSION_STRING);
					if(sender.hasPermission(PLUGIN_RELOAD_PERMISSION)) {
						reloadConfig();
						sender.sendMessage(PLUGIN_RELOADED_WITH_PLACEHOLDERS);
					}
					else sender.sendMessage(NO_PERMISSION_WITH_PLACEHOLDERS);
					return true;
				}
				if(args[0].equalsIgnoreCase("help")) {
					String COMMAND_USAGE_STRING = this.getConfig().getString("command-usage", "&a&lAnnouncer&6&lS&e&lC&r &7- &cBroadcaster plugin\n&r\n&3> &b/$label help &7- &aDisplays this\n&3> &b/$label reload &7- &aReload the plugin\n&3> &b/$label reboot &7- &aRestart the plugin")
							.replace("&", "§")
							.replace("$username", sender.getName())
							.replace("$servername", getServer().getServerName())
							.replace("$serverversion", getServer().getVersion())
							.replace("$command", cmd.getName())
							.replace("$label", label);
					String COMMAND_USAGE_WITH_PLACEHOLDERS = PlaceholderAPI.setPlaceholders(getServer().getPlayer(sender.getName()), COMMAND_USAGE_STRING);
					String COMMAND_USAGE_PERMISSION = "announcersc.help";
					String NO_PERMISSION_STRING = this.getConfig().getString("no-perms", "&cYou don't have permissions.")
							.replace("&", "§")
							.replace("$username", sender.getName())
							.replace("$servername", getServer().getServerName())
							.replace("$serverversion", getServer().getVersion())
							.replace("$command", cmd.getName())
							.replace("$label", label)
							.replace("$perm", COMMAND_USAGE_PERMISSION);
					String NO_PERMISSION_WITH_PLACEHOLDERS = PlaceholderAPI.setPlaceholders(getServer().getPlayer(sender.getName()), NO_PERMISSION_STRING);
					if(sender.hasPermission(COMMAND_USAGE_PERMISSION)) sender.sendMessage(COMMAND_USAGE_WITH_PLACEHOLDERS);
					else sender.sendMessage(NO_PERMISSION_WITH_PLACEHOLDERS);
					return true;
				}
			}
			else {
				String args___ = "";
				for(int i = 0; i < args.length; i++) {
					String arg = args[i] + " ";
					args___ = args___ + arg;
				}
				String INVAILD_COMMAND_STRING = this.getConfig().getString("invaild-command", "&cInvaild command /$label. Type /$label help")
						.replace("&", "§")
						.replace("$username", sender.getName())
						.replace("$servername", getServer().getServerName())
						.replace("$serverversion", getServer().getVersion())
						.replace("$command", cmd.getName())
						.replace("$label", label)
						.replace("$args", args___);
				String INVAILD_COMMAND_WITH_PLACEHOLDERS = PlaceholderAPI.setPlaceholders(getServer().getPlayer(sender.getName()), INVAILD_COMMAND_STRING);;
				sender.sendMessage(INVAILD_COMMAND_WITH_PLACEHOLDERS);
				return true;					
			}
		}
		if (cmd.getName().equalsIgnoreCase("announce")) {
			if (args.length > 0) {
				String msg = "";
				for(int i = 0; i < args.length; i++) {
				    String arg = args[i] + " ";
				    msg = msg + arg;
				}
				String ANNOUNCE_FORMAT_STRING = this.getConfig().getString("announce-format", "&a$username&r &7>> &d$message")
						.replace("&", "§")
						.replace("$username", sender.getName())
						.replace("$servername", getServer().getServerName())
						.replace("$serverversion", getServer().getVersion())
						.replace("$command", cmd.getName())
						.replace("$label", label);
				String ANNOUNCE_FORMAT_WITH_PLACEHOLDERS = PlaceholderAPI.setPlaceholders(getServer().getPlayer(sender.getName()), ANNOUNCE_FORMAT_STRING);
				String ANNOUNCE_FORMAT_REPAIRED = ANNOUNCE_FORMAT_WITH_PLACEHOLDERS.replace("$message", msg);
				String ANNOUNCE_PERMISSION = "announcersc.announce.use";
				String ANNOUNCE_COLORS_PERMISSION = "announcersc.announce.colors";
				String NO_PERMISSION_STRING = this.getConfig().getString("no-perms", "&cYou don't have permissions.")
						.replace("&", "§")
						.replace("$username", sender.getName())
						.replace("$servername", getServer().getServerName())
						.replace("$serverversion", getServer().getVersion())
						.replace("$command", cmd.getName())
						.replace("$label", label)
						.replace("$perm", ANNOUNCE_PERMISSION);
				String NO_PERMISSION_WITH_PLACEHOLDERS = PlaceholderAPI.setPlaceholders(getServer().getPlayer(sender.getName()), NO_PERMISSION_STRING);
				if(sender.hasPermission(ANNOUNCE_PERMISSION)) {
					if(sender.hasPermission(ANNOUNCE_COLORS_PERMISSION)) {
						getServer().broadcastMessage(ANNOUNCE_FORMAT_REPAIRED.replace("&", "§"));
					}
					else getServer().broadcastMessage(ANNOUNCE_FORMAT_REPAIRED);
				}
				else sender.sendMessage(NO_PERMISSION_WITH_PLACEHOLDERS);
				return true;
			}
			else {
				String args__ = "";
				for(int i = 0; i < args.length; i++) {
				    String arg = args[i] + " ";
				    args__ = args__ + arg;
				}
				String BROADCAST_USAGE_STRING = this.getConfig().getString("broadcast-usage", "&cUsage: /$label <text>")
						.replace("&", "§")
						.replace("$username", sender.getName())
						.replace("$servername", getServer().getServerName())
						.replace("$serverversion", getServer().getVersion())
						.replace("$command", cmd.getName())
						.replace("$label", label)
						.replace("$args", args__);
				String BROADCAST_USAGE_WITH_PLACEHOLDERS = PlaceholderAPI.setPlaceholders(getServer().getPlayer(sender.getName()), BROADCAST_USAGE_STRING);
				sender.sendMessage(BROADCAST_USAGE_WITH_PLACEHOLDERS);
				return true;
			}
		}
		return false; 
	}
}
