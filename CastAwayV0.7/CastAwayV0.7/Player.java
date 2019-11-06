import java.util.Iterator;


/**
 * This class represents the player inside the game
 * 
 * 
 * 
 */
public class Player implements java.io.Serializable
{
    private String name;
    private static Room currentRoom;
    private static Items items = new Items();
    private double maxMass = 5;
    private double LP = 100; //LifePoints
    private double HP = 100; //HungerPoints
    private double TP = 100; //ThirstPoints
    private double EP = 100; //EnergyPoints (Sleep)
    private double MP = 50; //MoodPoints (Happiness)
    private double SP = 100; //SanityPoints
    private double TempP = 100; //TemperaturPoints (Sleep)
    private int moves = 0;
    
    
    private int maxMoves = 6;
    
    /**
     * Konstruktor für die Objekte der Klasse Player.
     */
    public Player(String name, Room startRoom)
    {
        this.name = name;
        this.currentRoom = startRoom;
    }

    /**
     * Geht durch die Tür eine gegebenen Richtung.
     * Im Erfolgsfall wird true zurückgegeben, wenn nicht false. False kann
     * bedeuten, dass dort keine Tür ist oder die Tür verschlossen ist und der Player
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
     * Manages hunger and thirst 
     */
    private void enterRoom(Room Room) {
        takeHunger(10);
        takeThirst(25);
        takeEnergy(5);
        
        currentRoom = Room;
    }
    
    
    public void takeDamage(int Dmg)
    {
    System.out.println("Ouch that hurt!");   
    LP = LP - Dmg;    
    }
    
    public void takeHunger(int Hng)
    {   
    HP = HP - Hng;    
    }
    
    public void takeThirst(int Ths)
    {
    TP = TP - Ths;    
    }
    
    public void takeEnergy(int Egy)
    {
    EP = EP - Egy;    
    }
    
    public void takeHappiness(int Hap)
    {   
    MP = MP - Hap;    
    }
    
    public void takeSanity(int San)
    {
    SP = SP - San;    
    }
    
    public void takeTemperatur(int Temp)
    {
    TempP = TempP - Temp;    
    }
    
    
    public void addLP(int addLP)
    {
    LP = LP + addLP;
    } 
    
    public void addHP(int addHP)
    {
    HP = HP + addHP;
    } 
    
    public void addTP(int addTP)
    {
    TP = TP + addTP;
    } 
    
    public void addMP(int addMP)
    {
    MP = MP + addMP;
    } 
    
    public void addSP(int addSP)
    {
    SP = SP + addSP;
    } 
    
    public void addTempP(int addTempP)
    {
    TempP = TempP + addTempP;
    } 
    
    public void addEP(int addEP)
    {
    EP = EP + addEP;
    } 
    
    
    public double getLP(){
    return LP;
    }
    
    public double getHP(){
    return HP;
    }
    
    public double getTP(){
    return TP;
    }
    
    public double getEP(){
    return EP;
    }
    
    public double getMP(){
    return MP;
    }
    
    public double getSP(){
    return TP;
    }
    
    public double getTempP(){
    return TempP;
    } 
    
    
    public void setLP(double newLP){
    LP = newLP;
    }
    
    public void setHP(double newHP){
    HP = newHP;
    }
    
    public void setTP(double newTP){
    TP = newTP;
    }
    
    public void setEP(double newEP){
    TP = newEP;
    }
    
    public void setMP(double newMP){
    MP = newMP;
    }
    
    public void setSP(double newSP){
    SP = newSP;
    }
    
    public void setTempP(double newTempP){
    TempP = newTempP;
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
     * die der Player trägt.
     */
    public String getItemsString() {
        return items.getItemLongDescription() 
        + items.getFoodLongDescription() +  items.getDrinkLongDescription();
    }
    
    public String getRoomItems() {
     return currentRoom.getItemDescription(); 
    }
    
    /**
     * Gibt eine Zeichenkette zurück, die den aktuellen Room und die Items
     * des Players beinhaltet.
     */

    public String getLongDescription() {       
        String returnString = currentRoom.getLongDescription();
        returnString += "\n";
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
    
    public Source pickUpSource(String itemName)
    {
            if (canPickSource(itemName)){
            Source source = currentRoom.getSource(itemName);
            Item sourceItem = new Item(source.getItemName(),source.getItemDescription(),source.getItemStory(),source.getItemMass());
            items.putItem(sourceItem.getName(), sourceItem);            
            return source;
    
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
    * Eat and drink if possible.
    */
    public Food eat(String itemName) {
        {    
            Food food = items.getFood(itemName);
            if(food == null) { 
                food = currentRoom.removeFood(itemName);
            }
            else if(food != null) {
                HP += food.getNutrition();
                return food;    
            }
        }    return null;    
    }
    
    public Drink drink(String itemName) {
        {
            
            Drink drink = items.getDrink(itemName);
           
            if(drink == null) { 
                drink = currentRoom.removeDrink(itemName);
            }
            if(drink != null) {
                TP += drink.getNutrition();
                return drink;    
            }
        }   return null;
        
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
    
    private boolean canPickSource(String itemName) {
        boolean canPick = true;
        Source source  = currentRoom.getSource(itemName);
        if(source == null) {
            canPick = false;
        }
        else {
        double gesamtmasse = items.getTotalMass() + source.getItemMass();
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
    public boolean istDead() {
        return LP <= 0;
    }     
    
    public static Items getInventory(){
        return items;
    }
        
    public static void setInventory(Items newItems){
       items = newItems;
       System.out.println("loaded the items");
       
    }
}