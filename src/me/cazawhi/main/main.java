package me.cazawhi.main;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class main extends JavaPlugin implements Listener {
	
  private static final Runnable Runnable = null;
	
  @Override
  public void onEnable() {
	Bukkit.getPluginManager().registerEvents(new Events(this), this);
    System.out.println("[Adjustments] Plugin up and running!");
  }
	
  @Override 
  public void onDisable() {
    System.out.println("[Adjustments] Shutted down Plugin.");		
  }
  
  @Override
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
	  
	  	/* Broadcast */
	  
		if (cmd.getName().equalsIgnoreCase("broadcast")) {
			if(sender.hasPermission("adjustments.broadcast")) {
				if (args.length != 0) {
					String message = "";
					for (String part : args) {
						if (message != "") message += " ";
						message += part;
					}
					Bukkit.getServer().broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "Yggdrasil" + ChatColor.WHITE + "] " + ChatColor.BOLD + ChatColor.DARK_PURPLE + message);
					return true;
				}
				return false;
			}
			sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Adjustments-Return" + ChatColor.WHITE + "] " + ChatColor.BOLD + ChatColor.DARK_RED + "You have no permission to make a broadcast.");
		}
		
		
		/* Close for Maintenance */
		
		if (cmd.getName().equalsIgnoreCase("close")) {
			if(sender.hasPermission("adjustments.close")) {
				for (Player player : Bukkit.getOnlinePlayers()) {
					if (player.hasPermission("adjustments.bypass")) continue;
					player.kickPlayer("Yggdrasil is now down for maintenance.");
				}
				getServer().dispatchCommand(getServer().getConsoleSender(), "whitelist on");
				Bukkit.getServer().broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "Yggdrasil" + ChatColor.WHITE + "] " + ChatColor.BOLD + ChatColor.DARK_PURPLE + "Server is now in maintenance mode.");
				return true;
			}
			sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Adjustments-Return" + ChatColor.WHITE + "] " + ChatColor.BOLD + ChatColor.DARK_RED + "You have no permission to close the server.");
		}
		
		
		/* Open after Maintenance */
		
		if (cmd.getName().equalsIgnoreCase("open")) {
			if(Bukkit.getServer().hasWhitelist() == true) {
				if(sender.hasPermission("adjustments.close")) {
					getServer().dispatchCommand(getServer().getConsoleSender(), "whitelist off");
					Bukkit.getServer().broadcastMessage(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "Yggdrasil" + ChatColor.WHITE + "] " + ChatColor.BOLD + ChatColor.DARK_PURPLE + "Server maintenance mode is now disabled.");
				}
			}
			sender.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Adjustments-Return" + ChatColor.WHITE + "] " + ChatColor.BOLD + ChatColor.DARK_RED + "You have no permission to execute this command.");
			
		}
		
		return true;
	}

  
}
  