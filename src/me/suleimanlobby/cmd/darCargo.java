package me.repizelobby.cmd;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.nametagedit.plugin.NametagEdit;

import me.repizemysql.conexao.PlayersAPI;

public class darCargo implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String arg2, String[] args) {
		if (sender instanceof Player) {
			if (cmd.getName().equalsIgnoreCase("setcargo")) {
				Player p = (Player) sender;
				if (PlayersAPI.contains(p)) {

					if (PlayersAPI.getCargo(p).equalsIgnoreCase("§eDiretor") || p.isOp()
							|| PlayersAPI.getCargo(p).equalsIgnoreCase("§3Coder")) {

						// darcargo <player> <cargo>

						if (args.length < 2) {
							p.sendMessage(
									"§6§lREDE§f§lWISH §7» §cComando incorreto, utilize /darcargo <player> <cargo>");
							return true;
						} else {
							Player target = Bukkit.getPlayer(args[0]);
							if (target == null) {
								p.sendMessage("§6§lREDE§f§lWISH §7» §cJogador invalido ou offline.");
								return true;
							} else {
								String cargo = args[1];
								if (cargo.equalsIgnoreCase("diretor")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §6§lDIRETOR");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§6§lDIRETOR §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§6", "");
									NametagEdit.getApi().setPrefix(target, "§6Diretor§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§6Diretor");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§6Diretor");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("dev") || cargo.equalsIgnoreCase("coder")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §b§lDESENVOLVEDOR");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§b§lDEVELOPER §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§b", "");
									NametagEdit.getApi().setPrefix(target, "§bDeveloper§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§bDeveloper");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§bDeveloper");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("gerente")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §4§lGERENTE");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§4§lGERENTE §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§4", "");
									NametagEdit.getApi().setPrefix(target, "§4Gerente§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§4Gerente");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§4Gerente");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("admin")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §c§lADMINISTRADOR");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§c§lAdmin §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§c", "");
									NametagEdit.getApi().setPrefix(target, "§cAdmin§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§cAdmin");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§cAdmin");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("moderador")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §2§lMODERADOR");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§2§lModerador §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§2", "");
									NametagEdit.getApi().setPrefix(target, "§2Moderador§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§2Moderador");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§2Moderador");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("suporte")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §e§lSUPORTE");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§e§lSUPORTE §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§e", "");
									NametagEdit.getApi().setPrefix(target, "§eSuporte§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§eSuporte");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§eSuporte");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("yt")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §a§lYOUTUBER");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§a§lYOUTUBER §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§a", "");
									NametagEdit.getApi().setPrefix(target, "§aYOUTUBER§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§aYoutuber");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§aYoutuber");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("miniyt")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §a§lMINIYT");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§a§lMINIYT §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§a", "");
									NametagEdit.getApi().setPrefix(target, "§aMINIYT§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§aMiniYT");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§aMiniYT");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("wish")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §6§lWISH");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§6§lWISH §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§6", "");
									NametagEdit.getApi().setPrefix(target, "§6Wish§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§6Wish");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§6Wish");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("ultimate")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §d§lULTIMATE");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§d§lULTIMATE §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§d", "");
									NametagEdit.getApi().setPrefix(target, "§dUltimate§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§dUltimate");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§dUltimate");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("jade")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §1§lJADE");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§1§lJADE §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§1", "");
									NametagEdit.getApi().setPrefix(target, "§1Jade§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§1Jade");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§1Jade");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("light")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §a§lLIGHT");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§a§lLIGHT §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§a", "");
									NametagEdit.getApi().setPrefix(target, "§aLight§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§aLight");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§aLight");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
								if (cargo.equalsIgnoreCase("membro")) {
									Bukkit.broadcastMessage("");
									Bukkit.broadcastMessage("§e§lCHANGELOG §fO jogador §7" + target.getName()
											+ " \n§eTeve sua tag alterada para §7§lMEMBRO");
									Bukkit.broadcastMessage("");
									target.setDisplayName("§7§lMEMBRO §f" + target.getName());
									NametagEdit.getApi().setNametag(target, "§7", "");
									NametagEdit.getApi().setPrefix(target, "§7Membro§f ");
									if (PlayersAPI.contains(target)) {
										PlayersAPI.setCargo(target, "§7Membro");
									} else {
										PlayersAPI.addPlayer(target, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
										PlayersAPI.setCargo(target, "§7Membro");
									}
									return true;
								} else {
									p.sendMessage("§6§lREDE§f§lWISH §7» §cUtilize um formato correto.");
								}
							}
						}
					} else {
						p.sendMessage("§6§lREDE§f§lWISH §7» §cVoce nao tem permissao.");
						return true;
					}

				} else {
					PlayersAPI.addPlayer(p, 0.0, 0.0, "§7Membro", "§a[Zombie V]");
					return true;
				}

			}
		} else {
			return true;
		}
		return false;
	}

}
