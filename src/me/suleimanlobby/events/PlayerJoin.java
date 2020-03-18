package me.suleimanlobby.events;

import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

import me.suleimanmysql.conexao.PlayersAPI;

public class PlayerJoin implements Listener {

	@EventHandler
	private void join(PlayerJoinEvent e) {
		Player p = e.getPlayer();
		e.setJoinMessage(null);
		p.teleport(p.getWorld().getSpawnLocation());
		p.playSound(p.getLocation(), Sound.LEVEL_UP, 2.0f, 2.0f);
		if (!PlayersAPI.contains(p)) {
			PlayersAPI.addPlayer(p, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
		} else {
			for (Player ps : Bukkit.getOnlinePlayers()) {
				for (int x = 0; x < 1000; x++) {
					ps.sendMessage(" ");
					p.sendMessage("");
				}
			}
			if(PlayersAPI.getCargo(p).equalsIgnoreCase("§6Diretor") || p.isOp()) {
				p.sendMessage("§6§lREDE§f§lWISH §7» §aSeja bem-vindo(a) " + p.getDisplayName() + "§a.");
				Bukkit.broadcastMessage("§6Diretor §f" + p.getName() + " §7entrou no servidor.");
			} else {
				p.getInventory().clear();
				p.getActivePotionEffects().clear();
			}
		}
	}

}
