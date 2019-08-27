/**
 * Class Item - 
 *
 * Einbringen von Gegenständen in das Spiel.
 * 
 * Jedes Item hat eine Beschreibung und eine Masse.
 * 
 *
 */
public class Item
{
    // Name eines Items
    private String name;
    // Beschreibung eines Items
    private String beschreibung;
    // Die Masse eines Items
    private double masse;
    
    /**
     * Neues Item erzeugen mit gegebener Beschreibung und Masse.
     */
    public Item(String name, String beschreibung, double masse)
    {
        this.name = name;
        this.beschreibung = beschreibung;
        this.masse = masse;
    }

    public double getMasse()
    {
        return masse;
    }
    
    public String getBeschreibung()
    {
        return beschreibung;
    }
    
    public String getName()
    {
        return name;
    }
}
