import java.util.Iterator;

/**
 * Die Klasse repr�sentiert den Spieler.
 * 
 * 
 * 
 */
public class Spieler
{
    private String name;
    private Raum aktuellerRaum;
    private Items items = new Items();
    private double maxMasse = 1;
    private int moves = 0;
    private int maxMoves = 6;
    private Raum beamTarget;
    
    /**
     * Konstruktor f�r die Objekte der Klasse Spieler.
     */
    public Spieler(String name, Raum startRaum)
    {
        this.name = name;
        this.aktuellerRaum = startRaum;
    }

    /**
     * Geht durch die T�r eine gegebenen Richtung.
     * Im Erfolgsfall wird true zur�ckgegeben, wenn nicht false. False kann
     * bedeuten, dass dort keine T�r ist oder die T�r verschlossen ist und der Spieler
     * keinen passenden Schl�ssel hat.
     */
    
    public boolean geheDurch(String richtung) {
        Tuer tuer = aktuellerRaum.getTuer(richtung);
        if(tuer ==  null) {
            return false;
        }
        
        Raum nextRaum = tuer.oeffnen(aktuellerRaum);
        if(nextRaum == null) {
            //war veschlossen - versuche aufzuschliessen.
            Iterator iter = items.iterator();
            while(iter.hasNext() && !tuer.aufschliessen((Item) iter.next()));      
        }
        
        //erneuter Versuch zu �ffnen
        nextRaum = tuer.oeffnen(aktuellerRaum);
        if(nextRaum !=null)  {
            enterRaum(nextRaum);
            return true;
        } 
        else {
            return false;
        }
    }
    
    /**
     * 
     */
    private void enterRaum(Raum raum) {
        moves++;
        aktuellerRaum = raum;
    }
    
    /**
     * 
     */
    public Raum getAktuellerRaum() {
        return aktuellerRaum;
    }
    
    /**
     * 
     */
    public String getName() {
        return name;
    }
    
    /**
     * Gibt eine Zeichenkette zur�ck, die die Items beschreibt,
     * die der Spieler tr�gt.
     */
    public String getItemsString() {
        return "Du tr�gst: " + items.getLangeBeschreibung();
    }
    
    /**
     * Gibt eine Zeichenkette zur�ck, die den aktuellen Raum und die Items
     * des Spielers beinhaltet.
     */

    public String getLangeBeschreibung() {       
        String returnString = aktuellerRaum.getLangeBeschreibung();
        returnString += "\n" + getItemsString();
        return returnString;
    }
    

    /**
     * Versucht das Item des aktuellen Raums aufzunehmen. Im Erfolgsfall gibt
     * die Methode das aufgenommene Item zur�ck.
     */
    public Item pickUpItem(String itemName) {
        if(canPickItem(itemName)) {
            Item item = aktuellerRaum.removeItem(itemName);
            items.put(item.getName(), item);            
            return item;
        } else {
            return null;
        }
    }
    
    /**
     * Versucht ein Item im aktuellen Raum abzulegen. Im Erfolgsfall gibt die
     * Methode das abgelegte Item zur�ck.
     */
    public Item dropItem(String itemName) {
        Item item = items.remove(itemName);
        if(item != null) {
            aktuellerRaum.addItem(item);            
        }
        return item;
    }
    
    /**
     * Spieler isst das Item, wenn m�glich. Die maximale Tragmasse wird erh�ht.
     */
    public Item essen(String itemName) {
        if(itemName.equals("keks")) {
            //Nachsehen, ob ein Keks im Inventar ist.
            Item cookie = items.get(itemName);
            //Dann schauen, ob ein Keks im Raum ist.
            if(cookie == null) { 
                cookie = aktuellerRaum.removeItem(itemName);
            }
            if(cookie != null) {
                maxMasse += 1;
                return cookie;    
            }
        }
        return null;
    }
    
    /**
     * Pr�ft, ob das Item aufgenommen werden kann. Das h�ngt davon ab, ob sich das Item im
     * aktuellen Raum befindet oder ob es nicht zu schwer ist.
     */
    private boolean canPickItem(String itemName) {
        boolean canPick = true;
        Item item = aktuellerRaum.getItem(itemName);
        if(item == null) {
            canPick = false;
        }
        else {
        double gesamtmasse = items.getGesamtmasse() + item.getMasse();
        if(gesamtmasse > maxMasse) {
            canPick = false;
        }
    }
        return canPick;         
    }
    
    public boolean hatItem(String itemName) {
        boolean status = true;
        if(items.get(itemName) == null) {
            status = false;
        }
        return status;         
    }
    
    /**
     * Pr�ft, ob der Spieler gestorben ist. Der Spieler stirbt, wenn er eine bestimmte 
     * Anzahl an Z�gen gemacht hat.
     */
    public boolean istTot() {
        return moves > maxMoves;
    }     
    
    /**
     * Lade den Beamer f�r den aktuellen Raum
     */
    public void ladeBeamer() {
        beamTarget = aktuellerRaum;
    }
    
    /**
     * Feuert den Beamer
     */
    public boolean feuerBeamer() {
        if(beamTarget != null) {
            enterRaum(beamTarget);
            return true;
        }
        return false;
    }    
}