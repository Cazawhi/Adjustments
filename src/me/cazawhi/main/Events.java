package me.cazawhi.main;

import java.io.IOException;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.Plugin;
	
public class Events implements Listener {
		 
  public static Plugin plugin;
  public Events(Plugin plugin){
    this.plugin = plugin;
  }
  
  /* Chat Formatting */
  
  @EventHandler
  public void chatFormat(AsyncPlayerChatEvent event){
    Player p = event.getPlayer();
    if(p.hasPermission("adjustments.admin")){
      event.setFormat(ChatColor.WHITE + "[" + ChatColor.BOLD + ChatColor.DARK_PURPLE + p.getDisplayName() + ChatColor.RESET + ChatColor.WHITE + "] [" + ChatColor.RED + "Admin" + ChatColor.WHITE + "] " + event.getMessage());
    }else if(p.hasPermission("adjustments.moderator")){
    	event.setFormat(ChatColor.WHITE + "[" + ChatColor.BOLD + ChatColor.DARK_PURPLE + p.getDisplayName() + ChatColor.RESET + ChatColor.WHITE + "] [" + ChatColor.BLUE + "Mod" + ChatColor.WHITE + "] " + event.getMessage());
    }else if(p.hasPermission("adjustments.member")){
    	event.setFormat(ChatColor.WHITE + "[" + ChatColor.BOLD + ChatColor.DARK_PURPLE + p.getDisplayName() + ChatColor.RESET + ChatColor.WHITE + "] [" + ChatColor.GREEN + "Member" + ChatColor.WHITE + "] " + event.getMessage());
    }else{
    	event.setFormat(ChatColor.WHITE + "[" + ChatColor.BOLD + ChatColor.DARK_PURPLE + p.getDisplayName() + ChatColor.RESET + ChatColor.WHITE + "] [" + ChatColor.GREEN + "Guest" + ChatColor.WHITE + "] " + event.getMessage());
    }
  }
  
  @EventHandler
  public void onJoin(PlayerJoinEvent event) throws IOException { //Joining Message
    Player player = (Player)event.getPlayer();
    event.setJoinMessage(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "Yggdrasil" + ChatColor.WHITE + "] " + ChatColor.BOLD + ChatColor.DARK_PURPLE + player.getDisplayName() + ChatColor.RESET + ChatColor.WHITE + " joined the game.");
  }
  
  @EventHandler
  public void onQuit(PlayerQuitEvent event) throws IOException { //Leaving Message
    Player player = (Player)event.getPlayer();
    event.setQuitMessage(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "Yggdrasil" + ChatColor.WHITE + "] " + ChatColor.BOLD + ChatColor.DARK_PURPLE + player.getDisplayName() + ChatColor.RESET + ChatColor.WHITE + " has left the game.");
  }

  @EventHandler //Death Message
  public void onDeath(PlayerDeathEvent event) {
	  event.setDeathMessage(ChatColor.WHITE + "[" + ChatColor.DARK_GREEN + "Yggdrasil" + ChatColor.WHITE + "] " + ChatColor.BOLD + ChatColor.DARK_PURPLE + event.getEntity().getDisplayName() + ChatColor.RESET + ChatColor.WHITE + " has fallen.");
  }
  
/* Guest handling */
  
 @EventHandler
 public void onBlockPlace(BlockPlaceEvent event) { //Block Place
	 Player player = (Player)event.getPlayer();
	 if(!player.hasPermission("adjustments.build")) {
		 event.setCancelled(true);
		 player.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Adjustments-Return" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + "You are a guest.");
	 }
 }
 
 @EventHandler
 public void onBlockBreak(BlockBreakEvent event) { //Block Break
	 Player player = (Player)event.getPlayer();
	 if(!player.hasPermission("adjustments.build")) {
		 event.setCancelled(true);
		 player.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Adjustments-Return" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + "You are a guest.");
	 }
 }
 
 @EventHandler
 public void onInteract(PlayerInteractEvent event) { //Player Interact
	 Player player = (Player)event.getPlayer();
	 if(!player.hasPermission("adjustments.build")) {
		 event.setCancelled(true);
		 player.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Adjustments-Return" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + "You are a guest.");
	 }
 }
 
 @EventHandler
 public void onEntityDamage(EntityDamageByEntityEvent event) { //EntityDamageByEntity
	 Player Damager = (Player) event.getDamager();
	 if(Damager instanceof Player) {
		 if(!Damager.hasPermission("adjustments.build")) {
			 event.setCancelled(true);
			 Damager.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Adjustments-Return" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + "You are a guest.");
		 }
	 }
 }
 
 @EventHandler
 public void onPlayerSuffocatesDamage(EntityDamageEvent event) {
	 Entity entity = event.getEntity();
	 if(entity instanceof Player) {
		 if(!entity.hasPermission("adjustments.build")) {
			 event.setCancelled(true);
			 entity.sendMessage(ChatColor.WHITE + "[" + ChatColor.DARK_RED + "Adjustments-Return" + ChatColor.WHITE + "] " + ChatColor.DARK_RED + "You are a guest.");
		 }
	 }
 }
}