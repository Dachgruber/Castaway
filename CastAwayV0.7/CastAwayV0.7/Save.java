
import java.io.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Serializable;
/**
 * The class Save loads and saves the current state of the game
 *
 * @author Cornelius Brütt
 * @version V0.3, implementation in V0.6 SaveTest
 */
public class Save implements java.io.Serializable
{
    
    
    
    //private static Items saveInventory;
    private static CastAway game;
    
    
    

    /**
     * Constructor for objects of class Save
     */
    public Save()
    {
   
    }

    public static boolean saveGame(CastAway game,String savename){
      try {
         
         FileOutputStream fileOut = 
         new FileOutputStream(new File("./saves/"+savename +".ser"));
         
         ObjectOutputStream out = new ObjectOutputStream(fileOut);
          out.writeObject(game);
         
         
         out.close();
         fileOut.close();
         
         System.out.printf("Serialized data is saved in /saves/"+savename+ ".ser");
      } catch (IOException i) {
         i.printStackTrace();
        }
      
      
      
      return true;
   }
   
    public static boolean loadGame(String loadName){
        CastAway game;
      try {
         FileInputStream fileIn = //loading the inventory
         new FileInputStream(new File("./saves/"+loadName+ ".ser"));
         ObjectInputStream in = new ObjectInputStream(fileIn);
         
         game = (CastAway) in.readObject();
         in.close();
         fileIn.close();
         
         game.playGame();
         
         return true;
         
      } 
      
      catch (IOException i) {
         i.printStackTrace();
         return false;
      } catch (ClassNotFoundException c) {
         System.out.println("Class was not found!");
         c.printStackTrace();
         return false;
         
         
      }
      
     }
}   
    

