
/**
 * Class for printing story-related text to the terminal window
 * 
 * Team: Charlotta Höhle, Marcel Siefke, Tom Jark, Cornelius Brütt 
 * Responsible for code: Cornelius Brütt, Charlotta Höhle
 * Translation: Cornelius Brütt
 * Bugfixing: xxxxx.xxxxx
 * Version: 0.2
 * Datum: 27.08.2019
 */
public class Story implements java.io.Serializable
{
    public static final String NEWLINE = "\n" ; 
    public static final String VERSION = "V0.7 pre-alpha";
    public Story()
    {
    //empty
    }

        public static void clearScreen() 
        {  
        System.out.print ('\f');  
        }
        
        
        public static String printLauncher()
        {
        String returnString = 
        "Welcome to the world of CastAway! You play as the role of a plane crash survivor, who "
        + "is stranding onto a deserted island. Escape is your only option as the elements "
        + "slowly creep up to kill you. Eat, drink, loot, craft, find and most importantly: survive!"
        + NEWLINE
        + NEWLINE
        + "To get things started, enter your name below and click on the start button. If this isn't "
        + "your first time playing, select the continue game option and enter your filename. If you "
        + "want to know worked onto this small game project you can meet the developer team by pressing"
        + "the button for the credits "
        + NEWLINE
        + "Despite way to many many cups of coffee and long nights, please expect general issues and bugs as you play " 
        + "the pre-alpha " + VERSION + " version of the game. Feel free to report any unusual occurances!"
        
        
        ;
        
        return returnString;
        }
        
        public static String printStart()
        {
        String returnString =
        "Welcome! Let me be your gamemaster for tonight! As we start and continue with our adventure, you will be able to save your progress by typing" 
        + " 'save' + your desired filename. If you were happen to forget why you are here and what you should do, consider typing 'help' to get some usefull tips from me. " 
        + "You understood that? Great, so now we can begin with the adventure!"
        + NEWLINE
        + NEWLINE
        + NEWLINE
        + printStartGame();
        return returnString;
        }
        
        public static String printStartGame()
        {
        String returnString =  
        "A gentle breeze stroked your sandy face as you slowly stood up. Your eyes were burning" 
        + "from the saltwater and my clothes were totally trashed. You looked at the sun. Distant calls of seagulls "
        +"mixed with the gentle whispering of the sea lead to a peaceful, quite atmosphere. The last thing you "
        +"remembered is the fact that you had taken your plane to Sydney. And it was night. You were very tired, as your "
        +"needed to wait in Japan for a couple of hours until my connecting flight takes off.  And now, you are "
        +"stranded. Alone. F*cking miles away from any civilisation.\n"
        + NEWLINE
        +"*looks around* It looks like a lonely island with a huge mountain. On the left side the path leads "
        +"upwards to something that looks like a cliff, on the right side the beach leads on around a corner, "
        +"probably something like a passage.\n"
        + NEWLINE
        +"EARTHQUAKE\n"
        + NEWLINE
        +"Oh sh*t. You look at the mountain – thick black smoke rises from the top. The mountain isn’t just an "
        +"ordinary mountain – it’s a volcano. And it seems active as well. You need to find a way to leave "
        +"this place as soon as possible. Maybe you can build something that floats... something like a boat...\n"
        
        ;
        return returnString;
        }
        
        public static String printHelp()
        {
        String returnString =
           NEWLINE +"You are stranded onto this deserted island. Your only chance of survival is to find a way"
         +"of escaping. A boat or something should come in handy in trying of leaving this place.\n"
        
         +"You can move and interact with the following commands:\n";
         return returnString;
        }
        
        public static String printNight()
        {
        String returnString =
         "As you look up in the sky you see the first star sparkling in sky. The enviroment darkens around you as the day bleeds into nightfall.";
         return returnString;
        }
        
        public static String printDay()
        {
        String returnString =
         "As the sky brightens up the sun climbs slowly over the horizon. Right as the birds start singing around you a new day had just arrived.";
         return returnString;
        }
        
        public static String printEnding()
        {
         String returnString =   
          "The boat seems finished. While it’s just a log with some sticks stuck into it, It will be enough to get "
        +"you away from this place.\n"
        +"As you pushed the construct into the ocean, you felt cold water splashing up my legs. Your whole body "
        +"shivered, but I kept going as a fear for my live. Behind me, the volcano started to grumble violently, "
        +"as a huge cloud shot out of the shaft. The boat shook heavily from one side to the other, but as "
        +"soon as the sail catched the wind, you could stop paddling and let the nature do my work. You"
        +"succeeded. You escaped the island. Now, you have to find a way to save my,self and get back to "
        +"civilisation…\n"
        + NEWLINE
        +"A couple hours into my ride you encountered a large cruise ship. They stopped, saved you and got "
        +"you some food and some water to drink. The captain managed to organize a rescue mission with a "
        +"nearby rescue helicopter, so you can go to the nearest hospital on the coast as soon as possible.\n"
        + NEWLINE
        +"You did it! You saved your life out of this horrible situation. You managed to build a ship out of basically "
        +"nothing and outplayed the nature.\n";
         return returnString;
        }
        
        public static String printDeathEnding()
        {
        String returnString =
        "\nIt's bright.\n"
        + "But not bright like the sun.\n"
        + "This bright is more of a white light,\n"
        + "at the same time not blinding.\n"
        + NEWLINE
        + "Then you notice the silence.\n"
        + "There are no sounds.\n"
        + "No birds chirping of birds\n"
        + "or waves breaking on the beach.\n"
        + NEWLINE
        + "You feel nothing.\n"
        + "Not light, not heavy.\n"
        + "Just nothing.\n"
        + NEWLINE
        + "The white brightness turns into darkness.\n"
        + "Is getting darker and darker\n"
        + "until everything around you is black.\n"
        + NEWLINE
        + NEWLINE
        + NEWLINE
        + NEWLINE
        
        + "Then you open your eyes...\n";
        
        return returnString;
        }    
        
        public static String printQuit()
        {
         String returnString =
         NEWLINE
         + "\n-------------------------------------------------------------------------------------------------------"
         + "\n                                        THANK YOU FOR PLAYING!";
        
         return returnString;
        }
        
}
