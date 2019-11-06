import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/** 
 * This class creates the rooms within the game Castaway. 
 * 
 * The whole setting of this game is definied by the rooms and 
 * every rooms gives references to others by giving information 
 * about exits. 
 * Each room is connected to another through so called "doors". 
 * 
 * Team: Charlotta Höhle, Marcel Siefke, Tom Jark, Cornelius Brütt 
 * Responsible for code: Cornelius Brütt, xxxxx.xxxxx 
 * Translation: Cornelius Brütt, Charlotta Höhle 
 * Bugfixing: xxxxx.xxxxx 
 * Version: 0.3 
 * Datum: 16.09.2019 
 */


class Room implements java.io.Serializable
{
    private String description;
    private String story;
    private HashMap <String, Door> Doors;
    private Items items;
    private boolean firstEntry; 

/** 
 * Generates a room with the fitting description. 
 * A room doesn't have exits at first. 
 * @param description holds a description like 
 * "in a dense forest with many tall oaks. Many animals are whizzing" 
 */
    public Room(String description, String story) 
    {
        this.description = description;
        this.story  = story;
        Doors = new HashMap<>();
        items = new Items();
        firstEntry = true;
    }

    /** 
    * Defines an exit für this certain room. 
    * @param direction the direction, where the exit is located 
    * @param neighbour the room, you can reach through the exit 
    */
    public void setDoor(String richtung, Door Door) 
    {
        Doors.put(richtung, Door);
    }

    /**
     * Gives the descriptions of every room
     */
    public String getShortDescription()
    {
        return description;
    }
    
    /** 
    * Gives a long description of this room, like: 
    * You are ... 
    * You can find ... on the floor 
    * You could gather something from ... 
    */
    public String getLongDescription()
    {
        return "\nYou are " + printStory() + ".\n" + getDoorsAlsString()+
        "\nYou could gather something from " + items.getSourceLongDescription();
    }

    public String getItemDescription()
    {
        return items.getItemLongDescription() + "\n" +
        items.getFoodLongDescription() + "\n" + items.getDrinkLongDescription();
    }
    
    /** 
    * A string, which describes the exits of this room 
    * for example: "Exits:..." 
    */
    private String getDoorsAlsString()
    {
        String ergebnis = "You can catch a glimpse of a way out to the ";
        Set <String> keys = Doors.keySet();
        for(Iterator<String> iter = keys.iterator(); iter.hasNext(); )
            ergebnis += "\n" + iter.next();
        return ergebnis;
    }

    /** 
    * Shows the room, which we reach, when we go to a certain direction. 
    * Gives out 'null' when there is no valid exit. 
    * @param direction The way, where we are heading. 
    */
    public Door getDoor(String richtung) 
    {
        return (Door)Doors.get(richtung);
    }
    
    
       
    public void addItem(Item item) {
        items.putItem(item.getName(), item);
    }
    
    public void addFood(Food food) {
    items.putFood(food.getName(), food);
    }
    
    public void addDrink(Drink drink) {
    items.putDrink(drink.getName(), drink);
    }
    
    public void addSource(Source source) {
    items.putSource(source.getName(), source);
    }
    
    
   
    public Item getItem(String name) {
        return items.getItem(name);
    }    
    
    public Food getFood(String name) {
        return items.getFood(name);
    }
    
    public Drink getDrink(String name) {
        return items.getDrink(name);
    }
    
    public Source getSource(String name) {
        return items.getSource(name);
    }
    
    
    
    public Item removeItem(String name) {
        return items.removeItem(name);
    }
    
    public Food removeFood(String name) {
        return items.removeFood(name);
    }
    
    public Drink removeDrink(String name) {
        return items.removeDrink(name);
    }
    
    public Source removeSource(String name) {
        return items.getSource(name);
    }
    
    
    private boolean getEntry()
    {
    return firstEntry;    
    }
    
    private void setEntry(boolean entry)
    {
    this.firstEntry = entry;    
    }
    
    public String printStory()
    {
    if (firstEntry == true)
        {
         setEntry(false);
         return story;
        } 
    else return description;
    }   
    
}

