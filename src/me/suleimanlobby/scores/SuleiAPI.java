package me.suleimanlobby.scores;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.scoreboard.DisplaySlot;
import org.bukkit.scoreboard.Objective;
import org.bukkit.scoreboard.Score;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.Team;

public class SuleiAPI {

	private static Objective obj;
	private static Scoreboard sb;

	public SuleiAPI(String titulo) {
		sb = Bukkit.getScoreboardManager().getNewScoreboard();
		obj = sb.registerNewObjective("scoreboardutils", "suleimandev");
		obj.setDisplayName(titulo);
		obj.setDisplaySlot(DisplaySlot.SIDEBAR);
	}

	public static void addLinha(String text, int line) {
        Score s;

        text = (text.isEmpty() ? ChatColor.values()[line].toString() : text);

        int length = text.length();

        if(length <= 16) {
            s = obj.getScore(text);
        } else {
            Team team = sb.getTeam(String.valueOf(line));
            if(team == null) {
                team = sb.registerNewTeam(String.valueOf(line));
            }
            team.setPrefix(text.substring(0, 16));
            String entry;
            if(length < 32) {
                entry = text.substring(16);
            } else {
                entry = text.substring(16, 32);
                team.setSuffix(text.substring(32));
            }
            team.addEntry(entry);
            s = obj.getScore(entry);
        }
        s.setScore(line);
    }

	public Scoreboard getScoreboard() {
		return sb;
	}

	public void setScoreboard(Player p) {
		p.setScoreboard(sb);
	}

	public void setScoreboard(Player... p) {
		for (Player pl : p)
			pl.setScoreboard(sb);
	}
}