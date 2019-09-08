
import javax.security.auth.login.LoginException;

import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;

public class main
{
    public static JDA jda;
    public static String prefix = "rev.";
    private static String token = "NjE5OTI3OTkyOTY1MjY3NTA2.XXQjLw.d5E8o07gTNTQ-fAIddtwGXTBbuI";

    public static void main(String[] args) throws LoginException 
    {
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


        //jda.getPresence().setGame(Game.playing("Overwatch"));
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
    }

}
