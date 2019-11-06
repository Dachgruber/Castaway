/**
 * Class Item - 
 *
 * Einbringen von Gegenständen in das Spiel.
 * 
 * Jedes Item hat eine Beschreibung und eine Masse.
 * 
 *
 */


public class Item extends SuperItems implements java.io.Serializable
{
    //emptyness
    
    /**
     * create a new item with name,description,the story text and the mass
     */
    
    public Item(){};
    
    public Item(String name, String description, String story, double mass) 
    {
    super(name, description, story, mass);
    }
    {
        
        
    }    
}
