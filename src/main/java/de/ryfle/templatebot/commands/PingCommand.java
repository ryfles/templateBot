package de.ryfle.templatebot.commands;

import de.ryfle.templatebot.embeds.embedCreator;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

public class PingCommand extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent e) {
        if(e.getName().equals("ping")) {
            e.replyEmbeds(embedCreator.defaultEmbed("Pong!!", "The bot has reacted to your command")).queue();
        }
    }

}
