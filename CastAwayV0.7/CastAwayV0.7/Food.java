/**
 * Class Food - 
 *
 * Einbringen von Gegenständen in das Spiel.
 * 
 * Jedes Food hat eine Beschreibung und eine Masse.
 * 
 *
 */
import java.io.Serializable;
public class Food extends SuperItems implements java.io.Serializable
{
    // nutrition value of food item
    private double nutrition;
    
    /**
     * create a new item with name,description,the story text and the mass
     */
    public Food(String name, String description, String story, double mass, double nutrition) 
    {
        super(name, description, story, mass);
        this.nutrition = nutrition;
    }
    
    
    
    public double getNutrition()
    {
        return nutrition;
    }
}
