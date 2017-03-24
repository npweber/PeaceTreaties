package nathan.apes.pectr.command;

import org.bukkit.*;
import org.bukkit.command.*;
import org.bukkit.entity.Player;

public class CommandRefuse implements CommandExecutor{

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
		
		if(sender instanceof Player){
			
			Player player1 = CommandPeace.player1;
			
			Player player2 = CommandPeace.player2;
			
			boolean peace = CommandPeace.inPeace;
			
			if(peace == true && sender.getName().equals(player1.getPlayerListName())){
		
				player1.setInvulnerable(false);
				player2.setInvulnerable(false);
				
				player2.sendMessage("[" + ChatColor.RED + "PeaceTreaties" + ChatColor.RESET + "]" + ChatColor.AQUA + " You weren't lucky enough to be spared! " + ChatColor.RED + "RUN!");
				player1.sendMessage("[" + ChatColor.RED + "PeaceTreaties" + ChatColor.RESET + "]" + ChatColor.AQUA + " You refused their living! " + ChatColor.RED + "KILL! KILL! KILL!");
		
				CommandPeace.setInPeace(false);
				
			}
			
		}
		
		return true;
	}

}
