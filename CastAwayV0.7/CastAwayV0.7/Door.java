 /**
 * Eine T�r verbindet zwei R�ume.
 * Einige T�ren ben�tigen einen Schl�ssel, um ge�ffnet zu werden.
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
     * Erzeugt eine T�r zwischen zwei R�umen.
     * Es wird auch ein Schl�ssel als Parameter �bergeben, mit dem die T�r ge�ffnet werden kann.
     * Wird ein Schl�ssel angegeben, ist die T�r mit diesem Schl�ssel locked.
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
     * Versuche die T�r mit dem Schl�ssel zu verschlie�en.
     * 
     * @return true, wenn die T�r erfolgreich locked wurde.
     */
    public boolean lock(Item key) 
    {
        if(this.key == key && key != null) {
            locked = true;  
        }
        return locked;
    }  
    
    /**
     * Versuche die T�r mit dem Schl�ssel zu �ffnen.
     * 
     * @return true , wenn die T�r erfolgreich aufgeschlossen wurde.
     */
    public boolean unlock(Item key) 
    {
        if(this.key == key && key != null) {
            locked = false;  
        } 
        return !locked;
    }  
    
    /**
     * Versuche, durch die T�r von einem Room in den anderen zu gehen.
     * 
     * @param fromRoom Der Room, von dessen Seite man die T�r �ffnet.
     * @return Der Room auf der anderen Seite oder null, falls die T�r locked ist.
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
