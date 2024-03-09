package dev.potato.adventureapiexample.commands;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.TextComponent;
import net.kyori.adventure.text.event.ClickEvent;
import net.kyori.adventure.text.event.HoverEvent;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class PotatoCommand implements CommandExecutor {
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player p)) return true;

        // Text
        TextComponent component = Component.text("I like potatoes ", TextColor.color(6, 57, 112))
                .append(Component.text("and").decorate(TextDecoration.UNDERLINED))
                .append(Component.text(" I love dogs").color(NamedTextColor.GOLD)).decorate(TextDecoration.BOLD)
                .append(Component.text("!"));
        p.sendMessage(component);

        // Key binds
        TextComponent component2 = Component.text("You're a ").color(TextColor.color(0xA2644))
                .append(Component.text("Bunny", NamedTextColor.LIGHT_PURPLE))
                .append(Component.text("! Press "))
                .append(Component.keybind("key.jump").color(NamedTextColor.LIGHT_PURPLE).decoration(TextDecoration.BOLD, true))
                .append(Component.text(" to jump!"));
        Bukkit.broadcast(component2);

        // Clickable text
        Component component3 = Component.text("You're a ").color(TextColor.color(0xA2644))
                .append(Component.text("Bunny", NamedTextColor.LIGHT_PURPLE))
                .append(Component.text("! Click "))
                .append(Component.text("me", NamedTextColor.GOLD)).decorate(TextDecoration.BOLD, TextDecoration.UNDERLINED).clickEvent(ClickEvent.runCommand("/kill"))
                .append(Component.text(" to jump!"));
        Bukkit.broadcast(component3);

        // Hover text
        Component component4 = Component.text("You're a ").color(TextColor.color(0xA2644))
                .append(Component.text("Bunny", NamedTextColor.LIGHT_PURPLE))
                .append(Component.text("! Click "))
                .append(Component.text("me", NamedTextColor.GOLD)).decorate(TextDecoration.BOLD, TextDecoration.UNDERLINED)
                .hoverEvent(HoverEvent.showText(Component.text("My favorite flavor is cheese.")))
                .append(Component.text(" to jump!"));
        Bukkit.broadcast(component4);

        return true;
    }
}