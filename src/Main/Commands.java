package Main;

import net.dv8tion.jda.core.JDA;
import net.dv8tion.jda.core.entities.Message;
import net.dv8tion.jda.core.entities.MessageChannel;
import net.dv8tion.jda.core.entities.TextChannel;
import net.dv8tion.jda.core.events.message.MessageReceivedEvent;
import net.dv8tion.jda.core.hooks.ListenerAdapter;

public class Commands extends ListenerAdapter {

    public static JDA jda;

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
        String[] args = content.split("\\s+");
        // getContentRaw() is an atomic getter
        // getContentDisplay() is a lazy getter which modifies the content for e.g. console view (strip discord formatting)

        if(args[0].equalsIgnoreCase(main.prefix+"bork") || args[0].equalsIgnoreCase(main.prefix+"bark") || args[0].equalsIgnoreCase(main.prefix+"speak") || args[0].equalsIgnoreCase(main.prefix+"woof"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Whoo~~p~~f").complete();
        }

        if(args[0].equalsIgnoreCase(main.prefix+"Spaceship"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage(OKHAND).complete();
            channel.sendMessage(OO + OO + OO + OO + OO + OO).complete();
            channel.sendMessage(OKHAND).complete();
        }

        if(args[0].equalsIgnoreCase(main.prefix + "codehelp"))
        {
            MessageChannel channel = event.getChannel();
            for(int i = 1; i<24; i++)
            {channel.sendMessage("help " + i).complete();}
        }
        if(args[0].equalsIgnoreCase(main.prefix+"help"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("```" + main.prefix + "help - gives a list of commands \n" +
                    main.prefix + "bark - has reveille barks \n" +
                    main.prefix + "honor - recites the honor code \n" +
                    main.prefix + "howdy - greets the user and gives the link to the howdy site \n" +
                    main.prefix + "lost - gives the user the aggie map website to navigate \n" +
                    main.prefix + "12thman - gives the user a link to the tamu football website \n" +
                    main.prefix + "cafeteria help - gives the user a prompt of how to use the cafeteria command \n" +
                    main.prefix + "cafeteria [name] [day] - returns the time period(s) the dining hall is open for that day \n" +
                    main.prefix + "WhereIsRev - returns the last recorded position the Queen was at \n" +
                    main.prefix + "RevIsAt [location] - sets Reveille's location and pings the Rev Fan Club \n" +
                    "```").complete();
        }

        if(args[0].equalsIgnoreCase(main.prefix + "whereIsRev") || args[0].equalsIgnoreCase(main.prefix + "wir"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Rev was located at the **" + Fakebase.revLoc + "** as of **" + Fakebase.revTime + "**").complete();

        }

        if(args[0].equalsIgnoreCase(main.prefix + "setRevLoc") || args[0].equalsIgnoreCase(main.prefix + "revisat"))
        {
            Fakebase.revLoc = args[1];
            Fakebase.revTime = (message.getCreationTime().getHour()+7)%12 + ":" + message.getCreationTime().getMinute();
            event.getChannel().sendMessage("<@&620082494468915201> REV's LOCATION HAS BEEN UPDATED \n Rev was located at the **" + Fakebase.revLoc + "** as of **" + Fakebase.revTime + "**").queue();
            //Rev fan club role <@&620082494468915201>
        }
//////////////////////////////////////////////////////////////////////////////////////////////////////////////







        //Has revbot bark back when prompted by the user
        if(args[0].equalsIgnoreCase(main.prefix+"bark"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Woof!").complete();
        }

        //Has revbot recite the aggie honor code
        if(args[0].equalsIgnoreCase(main.prefix+"honor"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("An Aggie does not lie, cheat or steal or tolerate those who do.").complete();
        }

        //has revbot greet the user and give them a link to the howdy site
        if(args[0].equalsIgnoreCase(main.prefix+"howdy"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Howdy agg! (howdy.tamu.edu)").complete();
        }

        //Has revbot give the user a link to aggie maps
        if(args[0].equalsIgnoreCase(main.prefix+"lost"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("let revbot guide you to your destination (aggiemap.tamu.edu)").complete();
        }

        if(args[0].equalsIgnoreCase(main.prefix+"12thman"))
        {
            MessageChannel channel = event.getChannel();
            channel.sendMessage("Celebrate aggie cheer with revbot (12thman.com/schedule.aspx?schedule=293)").complete();
        }



        //Has revbot respond based on the location and day that is asked
        if(args[0].equalsIgnoreCase(main.prefix+"cafeteria")) {
            MessageChannel channel = event.getChannel();

            if(args.length >= 2) {
                if (args[1].equalsIgnoreCase("rev.help")) {
                    channel.sendMessage("select a cafeteria location: commons, duncan, or sbisa.").complete();
                    channel.sendMessage("Then add a day: M, TU, W,TH, F, SA, SU").complete();
                    channel.sendMessage("Finally put it in the format j/cafeteria [location] [day]").complete();
                }


                //verifies that the command requesting a cafeteria time meets the word count requirement
                if (args.length >= 3) {
                    if (args[1].equalsIgnoreCase("commons")) {
                        //give times for all days of the week
                        if (args[2].equalsIgnoreCase("M")) {
                            channel.sendMessage("7AM–3PM and 5PM-9PM").complete();
                        } else if (args[2].equalsIgnoreCase("Tu")) {
                            channel.sendMessage("7AM–3PM and 5PM-9PM").complete();
                        } else if (args[2].equalsIgnoreCase("W")) {
                            channel.sendMessage("7AM–3PM and 5PM-9PM").complete();
                        } else if (args[2].equalsIgnoreCase("Th")) {
                            channel.sendMessage("7AM–3PM and 5PM-9PM").complete();
                        } else if (args[2].equalsIgnoreCase("F")) {
                            channel.sendMessage("7AM–3PM and 5PM-8PM").complete();
                        } else if (args[2].equalsIgnoreCase("Sa")) {
                            channel.sendMessage("9AM–3PM and 5PM-8PM").complete();
                        } else if (args[2].equalsIgnoreCase("Su")) {
                            channel.sendMessage("10AM–3PM and 5PM-8PM").complete();
                        } else {
                            channel.sendMessage("use the format [name] [day] for a correct response.").complete();
                        }


                        //repeats the same process for duncan
                    } else if (args[1].equalsIgnoreCase("duncan")) {
                        if (args[2].equalsIgnoreCase("M")) {
                            channel.sendMessage("7AM–8AM, 11PM-1PM, and 5PM-8PM").complete();
                        } else if (args[2].equalsIgnoreCase("Tu")) {
                            channel.sendMessage("7AM–8AM, 11PM-1PM, and 7PM-8PM").complete();
                        } else if (args[2].equalsIgnoreCase("W")) {
                            channel.sendMessage("7AM–8AM, 11PM-1PM, and 5PM-8:30PM").complete();
                        } else if (args[2].equalsIgnoreCase("Th")) {
                            channel.sendMessage("7AM–8AM, 11PM-1PM, and 5PM-8PM").complete();
                        } else if (args[2].equalsIgnoreCase("F")) {
                            channel.sendMessage("7AM–8AM and 11AM-1PM").complete();
                        } else if (args[2].equalsIgnoreCase("Sa")) {
                            channel.sendMessage("Closed").complete();
                        } else if (args[2].equalsIgnoreCase("Su")) {
                            channel.sendMessage("5PM-8PM").complete();
                        } else {
                            channel.sendMessage("use the format [name] [day] for a correct response.").complete();
                        }

                    } else if (args[1].equalsIgnoreCase("sbisa")) {

                        if (args[2].equalsIgnoreCase("M")) {
                            channel.sendMessage("7AM–2PM, and 5PM-8PM").complete();
                        } else if (args[2].equalsIgnoreCase("Tu")) {
                            channel.sendMessage("7AM–2PM, and 5PM-8PM").complete();
                        } else if (args[2].equalsIgnoreCase("W")) {
                            channel.sendMessage("7AM-2PM, and 5PM-8PM").complete();
                        } else if (args[2].equalsIgnoreCase("Th")) {
                            channel.sendMessage("7AM–2PM, and 5PM-8PM").complete();
                        } else if (args[2].equalsIgnoreCase("F")) {
                            channel.sendMessage("7AM–2PM and 5PM-8PM").complete();
                        } else if (args[2].equalsIgnoreCase("Sa")) {
                            channel.sendMessage("10AM–2PM and 5–8PM").complete();
                        } else if (args[2].equalsIgnoreCase("Su")) {
                            channel.sendMessage("10:30AM–2:30PM and 5PM–8PM").complete();
                        } else {
                            channel.sendMessage("use the format [name] [day] for a correct response.").complete();
                        }

                    } else {
                        channel.sendMessage("use the format [name] [day] for a correct response.").complete();
                    }

                }
            }else {
                channel.sendMessage("use the format [name] [day] for a correct response.").complete();
            }


        }





    }
}
