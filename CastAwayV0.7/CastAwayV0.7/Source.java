/**
 * Class Source - 
 *
 * Implementation of sources - infinite sources of one specific item.
 * 
 * every source has its own name, description, story and mass (set to very heavy as sources can`t be picked up) as well as
 * parameter for its specific item (name, description,story,mass,nutrition)
 * 
 *
 */
public class Source extends SuperItems implements java.io.Serializable
{
    
    private String itemtype;
    private String itemname;
    private String itemdescription;
    private String itemstory;
    private double itemmass;
    private double itemnutrition;
    private Item item;
    /**
     * create a new item with name,description,the story text and the mass
     */
    public Source(String name, String description, String story, double mass, 
                  String itemtype, String itemname, String itemdescription, String itemstory, 
                  double itemmass, double itemnutrition) 
    {
    super(name, description, story, mass);
    this.itemtype = itemtype;
    
    this.itemname = itemname;
    this.itemdescription = itemdescription;
    this.itemstory = itemstory;    
    this.itemmass = itemmass;
    this.itemnutrition = itemnutrition;
    
    //creates item of the type itemtype, which is specified upon creation of the source
         if(itemtype.equals("Drink")) {new Drink(itemname, itemdescription, itemstory, itemmass, itemnutrition);}
    else if(itemtype.equals("Food"))  {new Food (itemname, itemdescription, itemstory, itemmass, itemnutrition);}
    else if(itemtype.equals("Item"))  {item = new Item (itemname, itemdescription, itemstory, itemmass);} 
    }
    
    public Item getSourceItem()
    {
        return item;
    }
    
    public double getItemMass()
    {
        return itemmass;
    }
    
    public String getItemDescription()
    {
        return itemdescription;
    }
    
    public String getItemStory()
    {
        return itemstory;
    }    
    
    public String getItemName()
    {
        return itemname;
    }
        
        
        
}
