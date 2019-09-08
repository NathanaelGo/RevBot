package Main;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.JDABuilder;
import net.dv8tion.jda.core.OnlineStatus;
import net.dv8tion.jda.core.entities.Game;

import javax.security.auth.login.LoginException;

public class main
{
    public static JDA jda;
    public static String prefix = "rev.";
    private static String token = "NjE5OTI3OTkyOTY1MjY3NTA2.XXUc5Q.pvbWY3dTp7o6U85Ng6Q4-gK4qog";

    public static void main(String[] args) throws LoginException {
/*
        JDABuilder builder = new JDABuilder();
        builder.setToken(token);
        builder.setStatus(OnlineStatus.ONLINE);
        builder.setGame(Game.playing("Overwatch"));

        builder.addEventListener(new Commands());

        builder.build();
*/
        JDA jda = new JDABuilder(token).build();
        jda.addEventListener(new Commands());
        //jda.addEventListener(new test());


        jda.getPresence().setGame(Game.playing("Overwatch"));
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
    }

}
