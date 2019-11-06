
/**
 * Superclass of item, food and other item-related classes.
 */
public class SuperItems implements java.io.Serializable
{
   // name of item
    protected String name;
    // short description of items
    protected String description;
    // short story-related description of item
    protected String story;
    // mass of item
   protected double mass;

    /**
     * Constructor for objects of class SuperItems
     */
    
    public SuperItems(){};
    
    public SuperItems(String name, String description, String story, double mass)
    {
        this.name = name;
        this.description = description;
        this.story = story;
        this.mass = mass;
    }

    public double getMass()
    {
        return mass;
    }
    
    public String getDescription()
    {
        return description;
    }
    
    public String getStory()
    {
        return story;
    }    
    
    public String getName()
    {
        return name;
    }
    
}

