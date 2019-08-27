/**
 * Objekte dieser Klasse halten Informationen über Befehle,
 * die der Benutzer eingegeben hat. Ein Befehl besteht momentan
 * aus zwei Zeichenketten: einem Befehlswort und einem zweiten
 * Wort. Beim Befehl "nimm karte" beispielsweise sind die beiden
 * Zeichenketten "nimm" und "karte".
 * 
 * Befehle werden von Benutzern dieser Klasse auf Gültigkeit
 * überprüft. Wenn ein Spieler einen ungültigen Befehl eingegeben
 * hat (ein unbekanntes Befehlswort), dann ist das Befehlswort <null>.
 *
 * Wenn der Befehl nur aus einem Wort bestand, dann ist das
 * zweite Wort <null>.
 * 
 * Gruppe: Max Mustermann, Mini Musterfrau, Willi Wichtig
 * Verantwortlich:Max Mustermann
 * Version: 1.x
 * Datum: xx.yy.zzzz
 */

class Befehl
{
    private String befehlswort;
    private String zweitesWort;

    /**
     * Erzeuge ein Befehlsobjekt. Beide Wörter müssen angegeben werden,
     * aber jedes oder beide dürfen 'null' sein. Das Befehlswort sollte
     * 'null' sein, wenn dieser Befehl als nicht vom Spiel erkannt
     * gekennzeichnet werden soll.
     */
    public Befehl(String erstesWort, String zweitesWort)
    {
        befehlswort = erstesWort;
        this.zweitesWort = zweitesWort;
    }

    /**
     * Liefere das Befehlswort (das erste Wort) dieses Befehls.
     * Wenn der Befehl nicht verstanden wurde, ist das Ergebnis
     * 'null'.
     */
    public String getBefehlswort()
    {
        return befehlswort;
    }

    /**
     * Liefere das zweite Wort dieses Befehls. Liefere 'null', wenn
     * es kein zweites Wort gab.
     */
    public String getZweitesWort()
    {
        return zweitesWort;
    }

    /**
     * Liefere 'true', wenn dieser Befehl nicht verstanden wurde.
     */
    public boolean istUnbekannt()
    {
        return (befehlswort == null);
    }

    /**
     * Liefere 'true', wenn dieser Befehl ein zweites Wort hat.
     */
    public boolean hatZweitesWort()
    {
        return (zweitesWort != null);
    }
}

