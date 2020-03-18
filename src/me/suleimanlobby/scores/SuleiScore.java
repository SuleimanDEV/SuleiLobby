package me.suleimanlobby.scores;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import me.suleimanmysql.conexao.PlayersAPI;

public class SuleiScore {
	
	@SuppressWarnings("static-access")
	public static void updateScore(Player p) {
		
		SuleiAPI s = new SuleiAPI("     §6§lSULEIMAN     ");
		
		if(!PlayersAPI.contains(p)) {
			PlayersAPI.addPlayer(p, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
		}
		
		s.addLinha("         §7Lobby #1      ", 8);
		s.addLinha("§§§§§§", 7);
		s.addLinha("§fGrupo: §7" + PlayersAPI.getCargo(p) + "", 6);
		s.addLinha("§fOnlines: §e" + Bukkit.getOnlinePlayers().size(), 5);
		s.addLinha("§§§§", 4);
		s.addLinha("§e  Servidores:", 3);
		s.addLinha("§f•     R. Sulei: §a0", 2);
		s.addLinha("§§", 1);
		s.addLinha(" §6loja.suleiman.com", 0);
	
		s.setScoreboard(p);
	}
	
}
