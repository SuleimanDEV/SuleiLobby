package me.suleimanlobby;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import me.suleimanlobby.cmd.Clearchat;
import me.suleimanlobby.cmd.darCargo;
import me.suleimanlobby.events.PlayerJoin;
import me.suleimanlobby.npc.setNPC;
import me.suleimanlobby.scores.SuleiScore;

public class Main extends JavaPlugin {
	
	public static Main instance;
	public static Main getInstance() {
		return instance;
	}
	
	@Override
	public void onEnable() {
		instance = this;
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
		getCommand("setcargo").setExecutor(new darCargo());
		getCommand("setnpc").setExecutor(new setNPC());
		getCommand("cc").setExecutor(new Clearchat());
		getCommand("clearchat").setExecutor(new Clearchat());
		saveDefaultConfig();
		new BukkitRunnable() {
			
			@Override
			public void run() {
				for(Player p : Bukkit.getOnlinePlayers()) {
					SuleiScore.updateScore(p);
				}
			}
		}.runTaskTimer(this, 0L, 20);
	}
	
	@Override
	public void onDisable() {
		instance = null;
	}
}
