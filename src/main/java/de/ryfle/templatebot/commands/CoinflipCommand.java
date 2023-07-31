package de.ryfle.templatebot.commands;

import de.ryfle.templatebot.embeds.embedCreator;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

public class CoinflipCommand extends ListenerAdapter {

    public void onSlashCommandInteraction(SlashCommandInteractionEvent e) {
        if(e.getName().equals("coinflip")) {
            //gives out a either 1 or 0, if 0 the coin says heads, if 1 the coin says tails
            Random r = new Random();
            int result = r.nextInt(2);
            if(result == 0) {
                e.replyEmbeds(embedCreator.defaultEmbed("The result of the coinflip is...", "You got heads!")).queue();
            } else {
                e.replyEmbeds(embedCreator.defaultEmbed("The result of the coinflip is...", "You got tails!")).queue();
            }
        }
    }

}
