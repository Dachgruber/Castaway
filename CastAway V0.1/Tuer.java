/**
 * Eine T�r verbindet zwei R�ume.
 * Einige T�ren ben�tigen einen Schl�ssel, um ge�ffnet zu werden.
 * 
 */
public class Tuer
{
    private Raum raum1;
    private Raum raum2;
    private String richtung1;
    private String richtung2;
    private Item schluessel;
    private boolean verschlossen = false;
    
    /**
     * Erzeugt eine T�r zwischen zwei R�umen.
     * Es wird auch ein Schl�ssel als Parameter �bergeben, mit dem die T�r ge�ffnet werden kann.
     * Wird ein Schl�ssel angegeben, ist die T�r mit diesem Schl�ssel verschlossen.
     */
    public Tuer(Raum raum1, String richtung1, Raum raum2, String richtung2, Item schluessel)
    {
        this.raum1 = raum1;
        this.raum2 = raum2;
        this.richtung1 = richtung1;
        this.richtung2 = richtung2;
        raum1.setTuer(richtung1, this);
        raum2.setTuer(richtung2, this);
        this.schluessel = schluessel;
        verschliessen(schluessel);
    }
    
    /**
     * Versuche die T�r mit dem Schl�ssel zu verschlie�en.
     * 
     * @return true, wenn die T�r erfolgreich verschlossen wurde.
     */
    public boolean verschliessen(Item schluessel) 
    {
        if(this.schluessel == schluessel && schluessel != null) {
            verschlossen = true;  
        }
        return verschlossen;
    }  
    
    /**
     * Versuche die T�r mit dem Schl�ssel zu �ffnen.
     * 
     * @return true , wenn die T�r erfolgreich aufgeschlossen wurde.
     */
    public boolean aufschliessen(Item schluessel) 
    {
        if(this.schluessel == schluessel && schluessel != null) {
            verschlossen = false;  
        } 
        return !verschlossen;
    }  
    
    /**
     * Versuche, durch die T�r von einem Raum in den anderen zu gehen.
     * 
     * @param fromRaum Der Raum, von dessen Seite man die T�r �ffnet.
     * @return Der Raum auf der anderen Seite oder null, falls die T�r verschlossen ist.
     */
    public Raum oeffnen(Raum fromRaum) 
    {
        if(verschlossen) {
            return null;
        }   
        if(fromRaum == raum1) {
            return raum2;
        }
        else if (fromRaum == raum2) {
            return raum1;
        } 
        else {
            return null;
        }            
    }    
}
