package me.repizelobby.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import me.repizemysql.conexao.PlayersAPI;

public class Clearchat implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if(sender instanceof Player) {
			
			if(cmd.getName().equalsIgnoreCase("cc") || cmd.getName().equalsIgnoreCase("clearchat")) {
				Player p = (Player)sender;
				
				if (PlayersAPI.getCargo(p).equalsIgnoreCase("§eDiretor") || p.isOp() || PlayersAPI.getCargo(p).equalsIgnoreCase("§3Coder")) {
					
					for(int x = 0; x < 1000; x++) {
						Bukkit.broadcastMessage("");
					}
					Bukkit.broadcastMessage("§6§lREDE§f§lWISH §7» §aChat limpo por §c" + p.getDisplayName());
					
				} else {
					p.sendMessage("§6§lREDE§f§lWISH §7» §cVoce nao tem permissao.");
					return true;
				}
			}
			
		} else {
			return true;
		}
		return false;
	}

}
