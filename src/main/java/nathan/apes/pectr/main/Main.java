package nathan.apes.pectr.main;

import nathan.apes.pectr.command.*;

import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.configuration.file.FileConfiguration;

public class Main extends JavaPlugin{

	public static Main main;

	public FileConfiguration config;
	
	public void onEnable(){
		
		config = getConfig();
		
		config.addDefault("spawncordX", 0);
		config.addDefault("spawncordY", 0);
		config.addDefault("spawncordZ", 0);
		config.addDefault("spawnworld", "world");
		
		config.addDefault("termsmoney", 0);
		
		config.options().copyDefaults(true);
		saveConfig();
		
		this.getCommand("pec").setExecutor(new CommandPeace());
		this.getCommand("accept").setExecutor(new CommandAccept());
		this.getCommand("refuse").setExecutor(new CommandRefuse());
		
		this.getLogger().info("Enabling PeaceTreaties...");
		
	}
	
	public void onDisable(){
		
		this.getLogger().info("Disabling PeaceTreaties...");
		
	}
	
}
