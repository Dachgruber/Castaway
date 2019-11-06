import java.util.Iterator;

/**
 * This class represents entities inside the game
 */
public class Entity implements java.io.Serializable
{
    private String name;
    private Room currentRoom;
    private Items items = new Items();
    private double maxMass = 5;
    private double LP = 100; //LifePoints   
    private int moves = 0;
    
    private int maxMoves = 6;
    
    /**
     * Konstruktor für die Objekte der Klasse Entity.
     */
    public Entity(String name, Room startRoom)
    {
        this.name = name;
        this.currentRoom = startRoom;
    }

    /**
     * Geht durch die Tür eine gegebenen Richtung.
     * Im Erfolgsfall wird true zurückgegeben, wenn nicht false. False kann
     * bedeuten, dass dort keine Tür ist oder die Tür verschlossen ist und der Entity
     * keinen passenden Schlüssel hat.
     */
    
    public boolean goThrough(String richtung) {
        Door Door = currentRoom.getDoor(richtung);
        if(Door ==  null) {
            return false;
        }
        
        Room nextRoom = Door.open(currentRoom);
        if(nextRoom == null) {
            //war veschlossen - versuche aufzuschliessen.
            Iterator iter = items.itemIterator();
            while(iter.hasNext() && !Door.unlock((Item) iter.next()));      
        }
        
        //erneuter Versuch zu öffnen
        nextRoom = Door.open(currentRoom);
        if(nextRoom !=null)  {
            enterRoom(nextRoom);
            return true;
        } 
        else {
            return false;
        }
    }
    
    /**
     * Manages hunger and thirst, gives Damage when thist/hunger is 0. 
     */
    private void enterRoom(Room Room) {
       
       currentRoom = Room;
    }
    
    /**
     * 
     */
    public Room getCurrentRoom() {
        return currentRoom;
    }
    
    /**
     * 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gibt eine Zeichenkette zurück, die die Items beschreibt,
     * die der Entity trägt.
     */
    public String getItemsString() {
        return "You are holding " + items.getItemLongDescription() 
        + items.getFoodLongDescription();
    }
    
    /**
     * Gibt eine Zeichenkette zurück, die den aktuellen Room und die Items
     * des Players beinhaltet.
     */

    public String getLongDescription() {       
        String returnString = currentRoom.getLongDescription();
        returnString += "\n" + getItemsString();
        return returnString;
    }
    
    

    /**
     * Versucht das Item des aktuellen Rooms aufzunehmen. Im Erfolgsfall gibt
     * die Methode das aufgenommene Item zurück.
     */
    public Item pickUpItem(String itemName) {
        if(canPickItem(itemName)) {          
            Item item = currentRoom.removeItem(itemName);
            items.putItem(item.getName(), item);            
            return item;
            
        }         
        else {
            return null;
        }
    }   
    
    public Food pickUpFood(String itemName)
    {
            if (canPickFood(itemName)){
                     
            Food food = currentRoom.removeFood(itemName);
            items.putFood(food.getName(), food);            
            return food;
    
        }    
        
        else {
            return null;
        }
    }       
    
    public Drink pickUpDrink(String itemName)
    {
            if (canPickDrink(itemName)){
                     
            Drink drink = currentRoom.removeDrink(itemName);
            items.putDrink(drink.getName(), drink);            
            return drink;
    
        }    
        
        else {
            return null;
        }
    } 
    
    /**
     * Versucht ein Item im aktuellen Room abzulegen. Im Erfolgsfall gibt die
     * Methode das abgelegte Item zurück.
     */
    public Item dropItem(String itemName) {
        Item item = items.removeItem(itemName);
        if(item != null) {
            currentRoom.addItem(item);            
        }   
        return item;
    }
    
    public String examine(String itemName) {
           Item item    =items.getItem(itemName);
           Food food    =items.getFood(itemName);
           Drink drink  =items.getDrink(itemName);
           Source source=items.getSource(itemName);
           String output= null;
                if(item != null) 
                    {
                    output = item.getStory();
                    }
                     else if (food != null) 
                        {
                        output = food.getStory();
                        }
                        else if (drink != null) 
                            {
                            output = drink.getStory();
                             }
                            else if (source != null) 
                                {
                                output = source.getStory();
                                }
                            
                        
                    
    
           return output;
    } 
    
    
    
    /**
     * Prüft, ob das Item aufgenommen werden kann. Das hängt davon ab, ob sich das Item im
     * aktuellen Room befindet oder ob es nicht zu schwer ist.
     */
    private boolean canPickItem(String itemName) {
        boolean canPick = true;
        Item item = currentRoom.getItem(itemName);
        if(item == null) {
            canPick = false;
        }
        else {
        double gesamtmasse = items.getTotalMass() + item.getMass();
        if(gesamtmasse > maxMass) {
            canPick = false;
            
        }
    } 
        return canPick;         
    }
    
    private boolean canPickFood(String itemName) {
        boolean canPick = true;
        Food food = currentRoom.getFood(itemName);
        if(food == null) {
            canPick = false;
        }
        else {
        double gesamtmasse = items.getTotalMass() + food.getMass();
        if(gesamtmasse > maxMass) {
            canPick = false;
            
        }
    } 
        return canPick;         
    }
    
    private boolean canPickDrink(String itemName) {
        boolean canPick = true;
        Drink drink = currentRoom.getDrink(itemName);
        if(drink == null) {
            canPick = false;
        }
        else {
        double gesamtmasse = items.getTotalMass() + drink.getMass();
        if(gesamtmasse > maxMass) {
            canPick = false;
            
        }
    } 
        return canPick;         
    }
    
    
    
    public boolean hasItem(String itemName) {
        boolean status = true;
        if(items.getItem(itemName) == null) {
            status = false;
        }
        return status;         
    }
    
    /**
     * 
     */
    public void takeDamage(int Dmg)
    {   
    LP = LP - Dmg;    
    }
    
    /**
     * 
     */
    public boolean istDead() {
        return LP <= 0;
    }     
    
  
}
