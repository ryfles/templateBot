package de.ryfle.templatebot.main;

import de.ryfle.templatebot.commands.CoinflipCommand;
import de.ryfle.templatebot.commands.customCommands;
import de.ryfle.templatebot.commands.PingCommand;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.entities.Activity;

import java.io.*;
import java.util.Properties;

public class Main {

    private static JDA jda;
    private static Properties prop;
    private static String line;

    public static void main(String[] args) throws InterruptedException, IOException {

        //configures the config file for your bot (in this case the file "config.properties"
        String configFilePath = "src/main/resources/config.properties";
        FileInputStream propsInput = new FileInputStream(configFilePath);
        prop = new Properties();
        prop.load(propsInput);

        //sets up the bot properly
        jda = JDABuilder.createDefault(configReader("token"))
                .setActivity(Activity.playing(configReader("activity")))
                .addEventListeners(new CoinflipCommand())
                .addEventListeners(new PingCommand())

                .build().awaitReady();

        //adds the custom commands to the bot
        customCommands.commands(jda);

        //registers the shutdown method
        shutdown();

    }

    //reads the config file and makes it easier to access from other classes
    public static String configReader(String key) {
        return prop.getProperty(key);
    }

    //a shutdown command so the bot can properly stop instead of crashing
    public static void shutdown() {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try{
            while((line = reader.readLine()) != null) {
                if(line.equalsIgnoreCase("stop")) {
                    if(jda != null) {
                        jda.shutdown();
                        sysout(configReader("name") + " is offline!");
                        System.exit(1);
                    }
                } else {
                    sysout("Unknown Command");
                }
            }
        } catch(IOException e) {
            e.printStackTrace();
        }
    }

    //creates the prefix for every system output from the bot itself
    public static void sysout(String output) {
        System.out.println(configReader("consolePrefix") + " " + output);
    }

}
