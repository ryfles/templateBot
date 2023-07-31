package de.ryfle.templatebot.commands;

import de.ryfle.templatebot.main.Main;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.interactions.commands.build.Commands;

public class customCommands {

    public static void commands(JDA jda) {

        //says in the console that the bot is online
        Main.sysout(Main.configReader("name") + " is online!");


        //manages the slash commands your bot has
        jda.updateCommands().addCommands(Commands.slash("ping", "test if the bot reacts"),
                Commands.slash("coinflip", "throws a coin")).queue();
    }
}
