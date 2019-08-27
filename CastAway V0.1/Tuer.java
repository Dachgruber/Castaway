/**
 * Eine Tür verbindet zwei Räume.
 * Einige Türen benötigen einen Schlüssel, um geöffnet zu werden.
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
     * Erzeugt eine Tür zwischen zwei Räumen.
     * Es wird auch ein Schlüssel als Parameter übergeben, mit dem die Tür geöffnet werden kann.
     * Wird ein Schlüssel angegeben, ist die Tür mit diesem Schlüssel verschlossen.
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
     * Versuche die Tür mit dem Schlüssel zu verschließen.
     * 
     * @return true, wenn die Tür erfolgreich verschlossen wurde.
     */
    public boolean verschliessen(Item schluessel) 
    {
        if(this.schluessel == schluessel && schluessel != null) {
            verschlossen = true;  
        }
        return verschlossen;
    }  
    
    /**
     * Versuche die Tür mit dem Schlüssel zu öffnen.
     * 
     * @return true , wenn die Tür erfolgreich aufgeschlossen wurde.
     */
    public boolean aufschliessen(Item schluessel) 
    {
        if(this.schluessel == schluessel && schluessel != null) {
            verschlossen = false;  
        } 
        return !verschlossen;
    }  
    
    /**
     * Versuche, durch die Tür von einem Raum in den anderen zu gehen.
     * 
     * @param fromRaum Der Raum, von dessen Seite man die Tür öffnet.
     * @return Der Raum auf der anderen Seite oder null, falls die Tür verschlossen ist.
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
