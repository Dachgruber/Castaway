import java.util.Set;
import java.util.HashMap;
import java.util.Iterator;

/**
 * Diese Klasse modelliert Räume in der Welt von Kaki.
 * 
 * Ein "Raum" repräsentiert einen Ort in der virtuellen Landschaft des
 * Spiels. Ein Raum ist mit anderen Räumen über Ausgänge verbunden.
 * Für jeden existierenden Ausgang hält ein Raum eine Referenz auf 
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
     * hat anfangs keine Ausgänge.
     * @param beschreibung enthält eine Beschreibung in der Form
     *        "in einer Küche" oder "auf einem Sportplatz".
     */
    public Raum(String beschreibung) 
    {
        this.beschreibung = beschreibung;
        tueren = new HashMap<>();
        items = new Items();
    }

    /**
     * Definiere einen Ausgang für diesen Raum.
     * @param richtung die Richtung, in der der Ausgang liegen soll.
     * @param nachbar der Raum, der über diesen Ausgang erreicht wird.
     */
    public void setTuer(String richtung, Tuer tuer) 
    {
        tueren.put(richtung, tuer);
    }

    /**
     * Liefere die Beschreibung dieses Raums (die dem Konstruktor
     * übergeben wurde).
     */
    public String getKurzbeschreibung()
    {
        return beschreibung;
    }

    /**
     * Liefere eine lange Beschreibung dieses Raums, in der Form:
     *     Du bist im Flur.
     *     Ausgänge: Norden, Westen, Süden, Osten
     */
    public String getLangeBeschreibung()
    {
        return "Du bist " + beschreibung + ".\n" + getTuerenAlsString()+
        "\nItems im Raum: " + items.getLangeBeschreibung();
    }

    /**
     * Liefere eine Zeichenkette, die die Ausgänge dieses Raums
     * beschreibt, beispielsweise
     * "Ausgänge: Norden Westen".
     */
    private String getTuerenAlsString()
    {
        String ergebnis = "Ausgänge:";
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
     * Gibt das Item zurück, wenn es verfügbar ist, sonst null.
     */
    public Item getItem(String name) {
        return items.get(name);
    }    
    
    /**
     * Entfernt und gibt das Item zurück, wenn es verfügbar ist, sonst null.
     */
    public Item removeItem(String name) {
        return items.remove(name);
    }
}

