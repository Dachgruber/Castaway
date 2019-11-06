
/**
 * Creation of the main interface to be used in the gui class.
 * Used sources to gather further information:
 * https://docs.oracle.com/javase/tutorial/uiswing/
 * https://www.java-tutorial.org/jframe.html and affiliates
 * http://openbook.rheinwerk-verlag.de/javainsel9/javainsel_19_008.htm
 *
 * @author Cornelius Brütt
 * @version V0.3, implemented in CA V0.3 GUI-Test
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.border.*;

class Interface extends JPanel implements ActionListener,java.io.Serializable

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
    
    JButton buttonSend;
    JButton buttonClose;
    
    JLabel label;
    JPanel panel;
    JPanel textpanel;
    JPanel rootpanel;
    JPanel miscpanel;
    JPanel invpanel;
    JPanel floorpanel;
    JPanel needpanel;
    
    JTextArea text;
    JTextArea inventory;
    JTextArea floor;
    JTextField input;
    
    /**
     * Constructor of the class "Interface",  prints error message in java system console if detects an exception
     */
    
    public Interface ()
    {
    try { SwingUtilities.invokeAndWait(
      new Runnable() {
        public void run() {
          makeGUI();
        }
      });
    } catch (Exception exc) {
      System.out.println("Can't create GUI because of " + exc);
    }    
    }
    
    /**
     * procedure that models and creates the panel of the interface, then adds it to the frame 
     */
    private void makeGUI()   
       {
        JFrame gui = new JFrame();
        gui.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        gui.setTitle("CastAway " + Story.VERSION);
        gui.setSize(950,1000); 
        
        lineborder = BorderFactory.createLineBorder(Color.black);
        raisedborder = BorderFactory.createRaisedBevelBorder();
        raisedtitle = BorderFactory.createTitledBorder(raisedborder, "UserInput");
        
        
        rootpanel = new JPanel(new BorderLayout());
        miscpanel = new JPanel (new GridLayout(3,1));
        
        panel = new JPanel(new GridBagLayout());
        textpanel = new JPanel(new GridBagLayout());
        invpanel = new JPanel(new GridBagLayout());
        floorpanel= new JPanel(new GridBagLayout());
        needpanel= new JPanel(new GridBagLayout());
        
        GridBagConstraints c = new GridBagConstraints();
        if (shouldFill) {
                //natural height, maximum width
                c.fill = GridBagConstraints.HORIZONTAL;
        }

        //send button for UserInput
        Icon enterIcon = new ImageIcon(enterPATH);
        buttonSend = new JButton ("enter", enterIcon);
        c.fill = GridBagConstraints.HORIZONTAL; 
        //c.weightx = 0.2;
        c.gridx = 6;
        c.gridy = 4;
        
        //c.anchor = GridBagConstraints.FIRST_LINE_START;
        panel.add(buttonSend, c);
        
        
        //creation of textField for UserInput
        input = new JTextField(40);
        c.fill = GridBagConstraints.HORIZONTAL;
        c.weightx = 0.5;
        c.gridwidth = 5;
        c.gridx = 0;
        c.gridy = 4;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(10,10,10,10);
        panel.add(input, c);
        
        //close button for closing the game
        Icon closeIcon = new ImageIcon(closePATH);
        buttonClose = new JButton("close", closeIcon);
        //c.ipady = 0;       //reset to default
        c.weighty = 1.0;   //request any extra vertical space
        c.weightx = 1.0;
        c.anchor = GridBagConstraints.LAST_LINE_END; //bottom of interface
        c.insets = new Insets(10,0,0,0);  //top padding
        //c.gridwidth = 1;
        c.gridx = 12;
        c.gridy = 6;       
        panel.add(buttonClose, c); 
       
        
        //text area to display the game
        text = new JTextArea(40,40);
        c.fill = GridBagConstraints.BOTH;
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.insets = new Insets(10,10,10,10);
        c.weightx = 0.5;
        c.gridwidth = 5;
        c.gridheight = 3;
        c.gridx = 0; 
        c.gridy = 0;
        
        textpanel.add(text, c);
        text.setLineWrap(true);
        text.setWrapStyleWord(true);
        Font f = new Font(Font.SANS_SERIF,3,15);
        text.setFont(f);
        text.setEditable(false);
        
        JScrollPane scrollPane= new JScrollPane(text); //Needs futher inspection
        c.fill = GridBagConstraints.BOTH;
        c.weightx = 0.5;
        c.gridx = 4;
        c.gridy = 0;
        textpanel.add(scrollPane, c);
        
        
        //textarea to show inventory
        
        inventory = new JTextArea(25,25);
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10,10,10,10);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        
        c.gridx = 0; 
        c.gridy = 1;
        inventory.setFont(f);
        inventory.setLineWrap(true);
        inventory.setWrapStyleWord(true);
        inventory.setEditable(false);
        invpanel.add(inventory, c);
        
        
        //textarea to show components on floor
        floor = new JTextArea(25,25);
        c.anchor = GridBagConstraints.FIRST_LINE_START;
        c.fill = GridBagConstraints.BOTH;
        c.insets = new Insets(10,10,10,10);
        
        c.gridx = 0; 
        c.gridy = 4;
        floor.setFont(f);
        floor.setLineWrap(true);
        floor.setWrapStyleWord(true);
        floor.setEditable(false);
        floorpanel.add(floor, c);
        
        
        //textarea to show images when needed
        
        //registration listener
        buttonSend.addActionListener(this);
        buttonClose.addActionListener(this);
        input.addActionListener(this);
        
        
        panel.setBackground(Color.LIGHT_GRAY);
        panel.setBorder(raisedborder);
        invpanel.setBorder(BorderFactory.createTitledBorder(lineborder, "Inventory"));
        floorpanel.setBorder(BorderFactory.createTitledBorder(lineborder, "Items on the floor"));
        
        miscpanel.add(invpanel);
        miscpanel.add(floorpanel);
        rootpanel.add(panel, BorderLayout.PAGE_END);
        rootpanel.add(textpanel, BorderLayout.LINE_START);
        rootpanel.add(miscpanel, BorderLayout.LINE_END);
        gui.add(rootpanel);
        gui.setVisible(true);
    }
    
    /**
     * reads out the ActionListener and performs the affirmative action
     */
    
    public void actionPerformed (ActionEvent ae){
            if(ae.getSource() == this.buttonSend){
            inputText = input.getText();
            newInput = true;
            print(input.getText());
            input.setText(null);
            
        }
        else if(ae.getSource() == this.buttonClose){
            newInput = true;
            inputText = "quit";
        }
        else if(ae.getSource() == this.input){
            buttonSend.doClick();
               
        }
    } 
    
    /**
     * reads out the newInput variable
     */
    
    public static boolean getNewInput(){
    return newInput;    
    }
    
    public static void setNewInput(boolean input){
    newInput = input;    
    }    
    
    /**
     * writes the String parameter into the JTextArea text
     */
    
    public void printInventory(String string){
    inventory.setText(string + newline);    
    }
    
    /**
     * writes the String parameter into the JTextArea text
     */
    
    public void printFloor(String string){
    floor.setText(string + newline);    
    }
    
    /**
     * writes the String parameter into the JTextArea text
     */
    
    public void print(String string){
    text.append(string + newline);    
    }
    
    /**
     * reads the input of the text area
     */
    
    public static String read(){
        return inputText;
    }
}


