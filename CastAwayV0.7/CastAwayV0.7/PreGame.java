import java.awt.event.*;
/**
 * This class manages all activites happening before the exec of the main game. 
 * As the main GUI the launcher interface is used.
 * 
 * @author Cornelius
 * @version V0.1 implemented in V0.6 SaveTest
 */
public class PreGame implements java.io.Serializable
{
    Launcher gui;
    
    public PreGame()
    {
    gui = new Launcher();   
    }
    
    public static void newGame(String newText)
    {
            
            //Launcher.launch.dispatchEvent(new WindowEvent(Launcher.launch, WindowEvent.WINDOW_CLOSING));
            Thread t = new Thread(new Runnable() {
                @Override
                public void run(){
            CastAway game = new CastAway("\""+newText+"\"");
            game.playGame();
        }
        
    });
    t.start();
    }
    
    public static void continueGame(String filename)
    {
          Thread t = new Thread(new Runnable() {
             @Override
            public void run(){
            Save.loadGame(filename);
            
        }
                
    });
    t.start();
    }
}
