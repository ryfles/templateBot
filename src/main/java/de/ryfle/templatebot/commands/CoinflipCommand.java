package your.project.bot.commands;

import your.project.bot.embeds.embedCreator;
import net.dv8tion.jda.api.events.interaction.command.SlashCommandInteractionEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;

import java.util.Random;

//here are some variables that one can change on the fly
private int diceSides = 6;
public int result;
public string embedHeader = "The result of your dice roll is...";
public string embedBody = "You rolled a " + result + "!";S

//command classes have to extend ListernerAdapter to be registered as such
public class DiceRollCommand extends ListenerAdapter {

    //void function onSlashCommandInteraction is more common these day 
    public void onSlashCommandInteraction(SlashCommandInteractionEvent e) {
        if(e.getName().equals("DiceRoll")) {
            //the two following rows generate the output of the dice roll
            Random r = new Random();
            int result = r.nextInt(diceSides) + 1; //the dice roll has to be counted +1 since if diceSides is set to 6 the result could be from 0 to 5. the functions always starts with 0 as its first number
            e.replyEmbeds(embedCreator.defaultEmbed(embedHeader, embedBody)).queue();
        }
    }
}
