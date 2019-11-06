
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
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.border.*;

public class Launcher extends Frame implements ActionListener,ItemListener,java.io.Serializable

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
    JPanel textpanel;
    JPanel rootpanel;
    JPanel savepanel;
    JPanel boxpanel;
    JPanel headerpanel;
    JPanel cards;
    
    JButton newButton;
    JButton conButton;
    
    JTextField conText;
    JTextField newText;
    
    static JFrame launch;
    
    private int playerchoice = 0; //0 = nothing
                                  //1 = new game
                                  //2 = continue game
    
    final static String NEWGAME = "start a new Adventure!";
    final static String LOADGAME = "return to your past undertaking!";
   
    
    
    
    
    
    public Launcher(){
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
    launch= new JFrame();
    launch.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    launch.setTitle("CastAway - Launcher");
    launch.setSize(600,450);
    
    
    rootpanel = new JPanel(new BorderLayout());
    savepanel = new JPanel(new BorderLayout());
    cards = new JPanel(new CardLayout());
    boxpanel = new JPanel();
    
    headerpanel = new JPanel();
    JLabel header = new JLabel("Hi there!");
    Font hf = new Font(Font.SANS_SERIF,5,24);
    header.setFont(hf);
    
    headerpanel.add(header);
    
    
    textpanel = new JPanel();
    JTextArea text = new JTextArea(Story.printLauncher(), 40,40);
    text.setLineWrap(true);
    text.setWrapStyleWord(true);
    Font f = new Font(Font.SANS_SERIF,3,15);
    text.setFont(f);
    textpanel.add(text);
    
    String comboBoxItems[] = {NEWGAME, LOADGAME};
    JComboBox cb = new JComboBox(comboBoxItems);
    cb.setEditable(false);
    cb.addItemListener(this);
    boxpanel.add(cb);
    
    JPanel cardNew = new JPanel();
    newButton = new JButton("new Game");
    newText = new JTextField("enter your adventure's name!", 20);
    cardNew.add(newButton);
    cardNew.add(newText);
    
    JPanel cardLoad = new JPanel();
    conButton = new JButton("continue Game");
    conText = new JTextField("enter the name of your savegame!", 20);
    cardLoad.add(conButton);
    cardLoad.add(conText);
    
    cards.add(cardNew, NEWGAME);
    cards.add(cardLoad, LOADGAME);
    
    newButton.addActionListener(this);
    conButton.addActionListener(this);
    
    
    savepanel.add(cards, BorderLayout.CENTER);
    savepanel.add(boxpanel, BorderLayout.PAGE_START);
    rootpanel.add(headerpanel,BorderLayout.PAGE_START);
    rootpanel.add(savepanel,BorderLayout.PAGE_END);
    rootpanel.add(textpanel,BorderLayout.CENTER);
    launch.add(rootpanel);
    launch.setVisible(true);
    }
    
    public void itemStateChanged(ItemEvent evt) {
    CardLayout cl = (CardLayout)(cards.getLayout());
    cl.show(cards, (String)evt.getItem());
    }
    
    /**
     * reads out the ActionListener and performs the affirmative action
     */
    
    public void actionPerformed (ActionEvent ae){
            if(ae.getSource() == this.newButton){
            PreGame.newGame(newText.getText());
           
            }
        else if(ae.getSource() == this.conButton){
            PreGame.continueGame(conText.getText());
            System.out.println("Second Button");
            
            }
    }
    
    public static boolean getNewInput(){
    return newInput;    
    }
    
    public static void setNewInput(boolean input){
    newInput = input;    
    } 
    
    public int getPlayerChoice()
    {
    return playerchoice;    
    }
    
    public String readNewText()
    {
    return newText.getText();    
    }
    
    public String readConText()
    {
    return conText.getText();    
    }
}
