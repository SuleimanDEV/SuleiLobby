package me.suleimanlobby.npc;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class setNPC implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (sender instanceof Player) {

			if (cmd.getName().equalsIgnoreCase("setnpc")) {
				Player p = (Player) sender;
				p.sendMessage("§6§lREDE§f§lWISH §7» §cEste comando esta bloqueado temporariamente por causa de bugs.");
				return true;
			}

		} else {
			return true;
		}
		return false;
	}

}
