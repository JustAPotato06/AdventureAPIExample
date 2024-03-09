package dev.potato.adventureapiexample;

import dev.potato.adventureapiexample.commands.PotatoCommand;
import org.bukkit.plugin.java.JavaPlugin;

public final class AdventureAPIExample extends JavaPlugin {
    @Override
    public void onEnable() {
        // Commands
        registerCommands();
    }

    private void registerCommands() {
        getCommand("potato").setExecutor(new PotatoCommand());
    }
}