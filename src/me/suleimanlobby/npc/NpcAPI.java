package me.suleimanlobby.npc;

import java.util.UUID;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.craftbukkit.v1_8_R3.CraftServer;
import org.bukkit.craftbukkit.v1_8_R3.CraftWorld;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import com.mojang.authlib.GameProfile;
import com.mojang.authlib.properties.Property;

import me.suleimanlobby.Main;
import net.minecraft.server.v1_8_R3.EntityPlayer;
import net.minecraft.server.v1_8_R3.MinecraftServer;
import net.minecraft.server.v1_8_R3.PacketPlayOutNamedEntitySpawn;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerInfo;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import net.minecraft.server.v1_8_R3.PlayerInteractManager;
import net.minecraft.server.v1_8_R3.WorldServer;

public class NpcAPI {
	
	public static void spawnNPC(Player p, String name) {
		MinecraftServer nmsServer = ((CraftServer) Bukkit.getServer()).getServer();
		WorldServer nmsWorld = ((CraftWorld) p.getWorld()).getHandle();
		GameProfile gameProfile = new GameProfile(
				UUID.fromString("52c85ff7-0bf1-47af-a453-addd16f6d7a0"), "§e" + name);
		changeSkin(gameProfile);
		
		EntityPlayer npc = new EntityPlayer(nmsServer, nmsWorld, gameProfile,
				new PlayerInteractManager(nmsWorld));
		Player npcPlayer = npc.getBukkitEntity().getPlayer();
		npcPlayer.setPlayerListName("");
		
		Location loc = p.getLocation();
		
		npc.setLocation(loc.getX(), loc.getY(), loc.getZ(), loc.getYaw(), loc.getPitch());
		
		PlayerConnection connection = ((CraftPlayer)p).getHandle().playerConnection;
		connection.sendPacket(new PacketPlayOutPlayerInfo(PacketPlayOutPlayerInfo.EnumPlayerInfoAction.ADD_PLAYER, npc));
		connection.sendPacket(new PacketPlayOutNamedEntitySpawn(npc));
	}
	
	public static void changeSkin(GameProfile profile) {
		
		String texture = Main.getInstance().getConfig().getString("Texture");
		String signature = Main.getInstance().getConfig().getString("Signature");
		
		profile.getProperties().put("textures", new Property("textures", texture, signature));
		
	}
	
}
