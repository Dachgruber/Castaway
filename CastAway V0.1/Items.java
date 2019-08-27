import java.util.HashMap;
import java.util.Iterator;

/**
 * Eine Liste von Items
 * 
 * 
 * 
 */
public class Items
{
    // A map of item names to items.
    private HashMap<String, Item> items;
    
    /**
     * Erzeuge eine neue Itemliste.
     */
    public Items()
    {
        items = new HashMap<>();
    }
    
    /**
     * Gibt einen Iterator über alle Item zurück.
     */
    public Iterator<Item> iterator()
    {
        return items.values().iterator();
    }

    /**
     * Entferne das angegebene Item.
     */
    public Item remove(String name)
    {
        return items.remove(name);
    }
    
    /**
     * Lege das angegebene Item in die Liste.
     * @param name Der Name des Items.
     * @param value Das Item selbst.
     */

    public void put(String name, Item value)
    {
        items.put(name, value);
    }
    
    /**
     * Gib das Item mit dem angegebenen Namen zurück.
     * @param name Der Name des zurückzugebeben Items.
     * @return Das genannte Item oder null, wenn es nicht in der Liste ist.
     */
    public Item get(String name)
    {
        return items.get(name);
    }
    
    /**
     * Gibt einen String zurück, der die Beschreibungen der Items der Liste enthält.
     */
    public String getLangeBeschreibung()
    {
        String returnString = "";
        for(Iterator<Item> iter = items.values().iterator(); iter.hasNext(); )
            returnString += "  " + iter.next().getBeschreibung();
        
        return returnString;     
    }
    
    /**
     * Gibt einen String zurück, der die Namen der Items der Liste enthält.
     * items in the list.
     */
    public String getKurzbeschreibung()
    {
        String returnString = "";
        for(Iterator<Item> iter = items.values().iterator(); iter.hasNext(); )
            returnString += " " + iter.next().getName();
        
        return returnString;     
    }
    
    /**
     * Gibt die Gesamtmasse aller Items der Liste zurück.
     */
    public double getGesamtmasse()
    {
        double weight = 0;
        for(Iterator<Item> iter = items.values().iterator(); iter.hasNext(); ) {
            weight += iter.next().getMasse();
        }
        return weight;        
    }
}

