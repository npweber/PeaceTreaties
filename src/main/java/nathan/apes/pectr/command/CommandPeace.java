package nathan.apes.pectr.command;

import java.util.ArrayList;

import nathan.apes.pectr.main.Main;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandPeace implements CommandExecutor{
	
	public static boolean inPeace = false;
	
	public static Player player1;
	
	public static Player player2;
	
	public static void setInPeace(boolean b){ inPeace = b; }
	
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player){
			
			if(args.length == 1 && inPeace == false){
			
				Main main = Main.main;
			
				FileConfiguration config = main.config;
			
				OfflinePlayer[] players = Bukkit.getOfflinePlayers();
			
				ArrayList<Player> onplayers = new ArrayList<Player>();

				String playerign = null;
				
				for(int i = 0; i < players.length; i++){
				
					OfflinePlayer testpl1 = players[i];
				
					if(testpl1.isOnline()){ onplayers.add((Player) testpl1); }
			
				}
			
				for(int i = 0; i < onplayers.size(); i++){
				
					playerign = onplayers.get(i).getPlayerListName();
			
					if(args[0].equals(playerign)){
					
						inPeace = true;
					
						player1 = (Player) sender;
					
						player2 = Bukkit.getPlayer(args[0]);
				
						player1.setInvulnerable(true);
						player2.setInvulnerable(true);
					
						player2.sendMessage("[" + ChatColor.RED + "PeaceTreaties" + ChatColor.RESET + "]" + ChatColor.AQUA + " Player '" + player1.getPlayerListName() + "' is requesting peace for terms of " + ChatColor.GREEN + "$" + config.getInt("termsmoney") + ChatColor.AQUA + ". Tell " + player1.getPlayerListName() + " how you think this should end...");
			
						player1.sendMessage("[" + ChatColor.RED + "PeaceTreaties" + ChatColor.RESET + "]" + ChatColor.AQUA + " Peace treaty sent. You may negotiate within safe measures now...");
					
					}
					
				}
				
			}
				
		}
		
		return true;
	}

}
