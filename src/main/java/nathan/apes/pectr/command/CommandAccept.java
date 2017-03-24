package nathan.apes.pectr.command;

import nathan.apes.pectr.main.Main;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

public class CommandAccept implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player){
			
			Main main = Main.main;
			
			FileConfiguration config = main.config;
			
			Player player1 = CommandPeace.player2;
			
			Player player2 = CommandPeace.player1;
			
			boolean peace = CommandPeace.inPeace;
			
			if(peace == true && sender.getName() == player1.getPlayerListName()){
			
				player2.performCommand("pay " + player1.getPlayerListName() + " " + config.getInt("termsmoney"));
			
				int x = config.getInt("spawncordX");
				int y = config.getInt("spawncordY");
				int z = config.getInt("spawncordZ");
		
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp " + player1.getPlayerListName() + " " + x + " " + y + " " + z);
				Bukkit.dispatchCommand(Bukkit.getConsoleSender(), "tp " + player2.getPlayerListName() + " " + x + " " + y + " " + z);
		
				player1.setInvulnerable(false);
				player2.setInvulnerable(false);
			
				player1.sendMessage("[" + ChatColor.RED + "PeaceTreaties" + ChatColor.RESET + "]" + ChatColor.AQUA + " You accepted their terms and recieved their loss. Happy looting!");
	
				player2.sendMessage("[" + ChatColor.RED + "PeaceTreaties" + ChatColor.RESET + "]" + ChatColor.AQUA + " You got away! Happy living!");
			
				CommandPeace.setInPeace(false);
				
			}
			
		}
		
		return true;
	}

}
