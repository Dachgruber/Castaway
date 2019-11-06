/**
 * Class Drink - 
 *
 * Einbringen von Gegenständen in das Spiel.
 * 
 * Jedes Drink hat eine Beschreibung und eine Masse.
 * 
 *
 */
import java.io.Serializable;
public class Drink extends SuperItems implements Serializable
{
    // nutrition value of food item
    private double nutrition;
    
    /**
     * create a new item with name,description,the story text and the mass
     */
    public Drink(String name, String description, String story, double mass, double nutrition) 
    {
        super(name, description, story, mass);
        this.nutrition = nutrition;
    }
    
    
    
    public double getNutrition()
    {
        return nutrition;
    }
}
