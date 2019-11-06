
/**
 * Creation of the survivalBook interface to be used in the gui class.
 * Used sources to gather further information:
 * https://docs.oracle.com/javase/tutorial/uiswing/
 * https://www.java-tutorial.org/jframe.html and affiliates
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_19_008.htm
 * 
 * This is the second interface class majorly based on my own experiences with the class "Interface"
 *
 * @author Cornelius Brütt
 * @version V0.1, implemented in CA V0.6 
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.border.*;

class SurvivalBook
{
    final static boolean shouldFill = true;
    private static String inputText = null;
    final static String newline = "\n";
    private static boolean newInput = false;
    
    private static String closePATH = "./images/close.png";
    private static String enterPATH = "./images/enter.png";
    
    Border lineborder;
    Border raisedborder;
    Border blackline;
    Border raisedtitle;
    
    JTabbedPane tabpane;
    JPanel front;
    JPanel crafting;
    JPanel help;
    
   
    
    
    
    
    
    public SurvivalBook()
    {
    try {
      SwingUtilities.invokeAndWait(new Runnable() {
        public void run() {
          makeGUI();
        }
      });
    } catch (Exception exc) {
      System.out.println("Can't create GUI because of " + exc);
    }    
    }
    
    private void makeGUI()
    {
    JFrame book= new JFrame();
    book.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    book.setTitle("Survival Booklet");
    book.setSize(600,450);
    
    book.setVisible(true);
    }
}
