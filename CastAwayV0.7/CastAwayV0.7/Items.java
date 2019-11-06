import java.util.HashMap;
import java.util.Iterator;
import java.io.Serializable;

/**
 * Class to implement the objects into the game
 * 
 * 
 * 
 */
public class Items implements Serializable
{
    //decleration of different HashMaps for different types of items
    private HashMap<String, Item> items;
    
    private HashMap<String, Food> foods;
    
    private HashMap<String, Drink> drinks;
    
    private HashMap<String, Source> sources;
    
    /**
     * Hashmaps for every type of item.
     */
    public Items()
    {
        items = new HashMap<>();
        foods = new HashMap<>();
        drinks = new HashMap<>();
        sources = new HashMap<>();
    }
    
    
    
    /**
     * Iterator for every type of item.
     */
    public Iterator<Item> itemIterator()
    {
        return items.values().iterator();
    }

    public Iterator<Food> foodIterator()
    {
        return foods.values().iterator();
    }

    public Iterator<Drink> drinkIterator()
    {
        return drinks.values().iterator();
    }
    
    public Iterator<Source> sourceIterator()
    {
        return sources.values().iterator();
    }
    
    
    /**
     * Entferne das angegebene Item.
     */
    public Item removeItem(String name)
    {
        return items.remove(name);
    }
    
    public Food removeFood(String name)
    {
        return foods.remove(name);
    }
    
    public Drink removeDrink(String name)
    {
        return drinks.remove(name);
    }
    
    public Source removeSource(String name)
    {
        return sources.remove(name);
    } 
    
    
    
    /**
     * Lege das angegebene Item in die Liste.
     * @param name Der Name des Items.
     * @param value Das Item selbst.
     */

    public void putItem(String name, Item value)
    {
        items.put(name, value);
    }
    
    public void putFood(String name, Food value)
    {
        foods.put(name, value);
    }
    
    public void putDrink(String name, Drink value)
    {
        drinks.put(name, value);
    }
    
    public void putSource(String name,Source value)
    {
        sources.put(name, value);
    }
    
    
    
    /**
     * Gib das Item mit dem angegebenen Namen zurück.
     * @param name Der Name des zurückzugebeben Items.
     * @return Das genannte Item oder null, wenn es nicht in der Liste ist.
     */
    public Item getItem(String name)
    {
        return items.get(name);
    }
    
    public Food getFood(String name)
    {
        return foods.get(name);
    }
    
    public Drink getDrink(String name)
    {
        return drinks.get(name);
    }
    
    public Source getSource(String name)
    {
        return sources.get(name);
    }
    
    
    
    /**
     * Gibt einen String zurück, der die Beschreibungen der Items der Liste enthält.
     */
    public String getItemLongDescription()
    {
        String returnString = "";
        for(Iterator<Item> iter = items.values().iterator(); iter.hasNext(); )
            returnString += "\n " + iter.next().getDescription();
        
        return returnString;     
    }
    
    public String getFoodLongDescription()
    {
        String returnString = "";
        for(Iterator<Food> iter = foods.values().iterator(); iter.hasNext(); )
            returnString += "\n " + iter.next().getDescription();
        
        return returnString;     
    }    
    
    public String getDrinkLongDescription()
    {
        String returnString = "";
        for(Iterator<Drink> iter = drinks.values().iterator(); iter.hasNext(); )
            returnString += "\n " + iter.next().getDescription();
        
        return returnString;     
    }
    
    public String getSourceLongDescription()
    {
        String returnString = "";
        for(Iterator<Source> iter = sources.values().iterator(); iter.hasNext(); )
            returnString += "\n " + iter.next().getDescription();
        
        return returnString;     
    }
    
    
    
    /**
     * Gibt einen String zurück, der die Namen der Items der Liste enthält.
     * items in the list.
     */
    public String getItemNames()
    {
        String returnString = "a backpack";
        for(Iterator<Item> iter = items.values().iterator(); iter.hasNext(); )
            returnString += " and " + iter.next().getName();
        
        return returnString;     
    }
    
    public String getFoodNames()
    {
        String returnString = " ";
        for(Iterator<Food> iter = foods.values().iterator(); iter.hasNext(); )
            returnString += " and " + iter.next().getName();
        
        return returnString;     
    }
    
    public String getDrinkNames()
    {
        String returnString = " ";
        for(Iterator<Drink> iter = drinks.values().iterator(); iter.hasNext(); )
            returnString += " and " + iter.next().getName();
        
        return returnString;     
    }
    
    public String getSourceNames()
    {
        String returnString = " ";
        for(Iterator<Source> iter = sources.values().iterator(); iter.hasNext(); )
            returnString += " and " + iter.next().getName();
        
        return returnString;     
    }
    
    
    
    /**
     * Gibt die Gesamtmasse aller Items der Liste zurück.
     */
    public double getTotalMass()
    {
        double weight = 0;
        for(Iterator<Item> iter = items.values().iterator(); iter.hasNext(); ) {
            weight += iter.next().getMass();
        }
        for(Iterator<Food> iter = foods.values().iterator(); iter.hasNext(); ) {
            weight += iter.next().getMass();
        }
        for(Iterator<Drink> iter = drinks.values().iterator(); iter.hasNext(); ) {
            weight += iter.next().getMass();
        }
        //no implementation of sources as sources can't be picked up
        return weight;        
    }
}

