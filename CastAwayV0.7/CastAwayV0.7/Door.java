 /**
 * Eine Tür verbindet zwei Räume.
 * Einige Türen benötigen einen Schlüssel, um geöffnet zu werden.
 * 
 */
public class Door implements java.io.Serializable
{
    private Room room1;
    private Room room2;
    private String direction1;
    private String direction2;
    private Item key;
    private boolean locked = false;
    
    /**
     * Erzeugt eine Tür zwischen zwei Räumen.
     * Es wird auch ein Schlüssel als Parameter übergeben, mit dem die Tür geöffnet werden kann.
     * Wird ein Schlüssel angegeben, ist die Tür mit diesem Schlüssel locked.
     */
    public Door(Room room1, String direction1, Room room2, String direction2, Item key)
    {
        this.room1 = room1;
        this.room2 = room2;
        this.direction1 = direction1;
        this.direction2 = direction2;
        room1.setDoor(direction1, this);
        room2.setDoor(direction2, this);
        this.key = key;
        lock(key);
    }
    
    /**
     * Versuche die Tür mit dem Schlüssel zu verschließen.
     * 
     * @return true, wenn die Tür erfolgreich locked wurde.
     */
    public boolean lock(Item key) 
    {
        if(this.key == key && key != null) {
            locked = true;  
        }
        return locked;
    }  
    
    /**
     * Versuche die Tür mit dem Schlüssel zu öffnen.
     * 
     * @return true , wenn die Tür erfolgreich aufgeschlossen wurde.
     */
    public boolean unlock(Item key) 
    {
        if(this.key == key && key != null) {
            locked = false;  
        } 
        return !locked;
    }  
    
    /**
     * Versuche, durch die Tür von einem Room in den anderen zu gehen.
     * 
     * @param fromRoom Der Room, von dessen Seite man die Tür öffnet.
     * @return Der Room auf der anderen Seite oder null, falls die Tür locked ist.
     */
    public Room open(Room fromRoom) 
    {
        if(locked) {
            return null;
        }   
        if(fromRoom == room1) {
            return room2;
        }
        else if (fromRoom == room2) {
            return room1;
        } 
        else {
            return null;
        }            
    }    
}
