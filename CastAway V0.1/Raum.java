import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Diese Klasse modelliert R�ume in der Welt von Kaki.
 * 
 * Ein "Raum" repr�sentiert einen Ort in der virtuellen Landschaft des
 * Spiels. Ein Raum ist mit anderen R�umen �ber Ausg�nge verbunden.
 * F�r jeden existierenden Ausgang h�lt ein Raum eine Referenz auf 
 * den benachbarten Raum.
 * 
 * Gruppe: Max Mustermann, Mini Musterfrau, Willi Wichtig
 * Verantwortlich: Willi Wichtig
 * Version: 1.x
 * Datum: xx.yy.zzzz
 */


class Raum 
{
    private String beschreibung;
    private HashMap <String, Tuer> tueren;
    private Items items;

    /**
     * Erzeuge einen Raum mit einer Beschreibung. Ein Raum
     * hat anfangs keine Ausg�nge.
     * @param beschreibung enth�lt eine Beschreibung in der Form
     *        "in einer K�che" oder "auf einem Sportplatz".
     */
    public Raum(String beschreibung) 
    {
        this.beschreibung = beschreibung;
        tueren = new HashMap<>();
        items = new Items();
    }

    /**
     * Definiere einen Ausgang f�r diesen Raum.
     * @param richtung die Richtung, in der der Ausgang liegen soll.
     * @param nachbar der Raum, der �ber diesen Ausgang erreicht wird.
     */
    public void setTuer(String richtung, Tuer tuer) 
    {
        tueren.put(richtung, tuer);
    }

    /**
     * Liefere die Beschreibung dieses Raums (die dem Konstruktor
     * �bergeben wurde).
     */
    public String getKurzbeschreibung()
    {
        return beschreibung;
    }

    /**
     * Liefere eine lange Beschreibung dieses Raums, in der Form:
     *     Du bist im Flur.
     *     Ausg�nge: Norden, Westen, S�den, Osten
     */
    public String getLangeBeschreibung()
    {
        return "Du bist " + beschreibung + ".\n" + getTuerenAlsString()+
        "\nItems im Raum: " + items.getLangeBeschreibung();
    }

    /**
     * Liefere eine Zeichenkette, die die Ausg�nge dieses Raums
     * beschreibt, beispielsweise
     * "Ausg�nge: Norden Westen".
     */
    private String getTuerenAlsString()
    {
        String ergebnis = "Ausg�nge:";
        Set <String> keys = tueren.keySet();
        for(Iterator<String> iter = keys.iterator(); iter.hasNext(); )
            ergebnis += " " + iter.next();
        return ergebnis;
    }

    /**
     * Liefere den Raum, den wir erreichen, wenn wir aus diesem Raum
     * in die angegebene Richtung gehen. Liefere 'null', wenn in
     * dieser Richtung kein Ausgang ist.
     * @param richtung Die Richtung, in die gegangen werden soll.
     */
    public Tuer getTuer(String richtung) 
    {
        return (Tuer)tueren.get(richtung);
    }
    
    /**
     * Legt ein Item in diesen Raum.
     */
    public void addItem(Item item) {
        items.put(item.getName(), item);
    }
    
    /**
     * Gibt das Item zur�ck, wenn es verf�gbar ist, sonst null.
     */
    public Item getItem(String name) {
        return items.get(name);
    }    
    
    /**
     * Entfernt und gibt das Item zur�ck, wenn es verf�gbar ist, sonst null.
     */
    public Item removeItem(String name) {
        return items.remove(name);
    }
}

