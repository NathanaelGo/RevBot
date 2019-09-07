package Main;

import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {


    public static final String OKHAND = "\uD83D\uDC4C";
    public static final String SIX = ":six:";
    public static final String SIXSTAR = "🔯";
    public static final String OO = ":regional_indicator_o:";


    @Override
    public void onMessageReceived(MessageReceivedEvent event)
    {
        if (event.getAuthor().isBot()) return;
        Message message = event.getMessage();
        String content = message.getContentRaw();
        String[] args = content.split("//s+");
        // getContentRaw() is an atomic getter
        // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)

        if(args[0].equalsIgnoreCase(main.prefix+"Spaceship"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage(OKHAND).complete();
            channel.sendMessage(OO + OO + OO + OO + OO + OO).complete();
            channel.sendMessage(OKHAND).complete();
        }


    }
}
