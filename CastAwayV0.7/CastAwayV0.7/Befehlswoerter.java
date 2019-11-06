/**
 * Diese Klasse h�lt eine Aufz�hlung aller Befehlsw�rter, die dem
 * Spiel bekannt sind. Mit ihrer Hilfe werden eingetippte Befehle
 * erkannt.
 *
 * Team: Charlotta H�hle, Marcel Siefke, Tom Jark, Cornelius Br�tt 
 * Responsible for code: xxxxx.xxxxx, xxxxx.xxxxx
 * Translation:xxxxx.xxxxx
 * Bugfixing: xxxxx.xxxxx
 * Version: 0.1
 * Datum: 27.08.2019
 */

class Befehlswoerter implements java.io.Serializable
{
    // ein konstantes Array mit den g�ltigen Befehlsw�rtern
    private static final String gueltigeBefehle[] = {
        "go","quit","help","get", "drop","eat","drink", "gather", "examine", "save", "load"
    };

    /**
     * Konstruktor - initialisiere die Befehlsw�rter.
     */
    public Befehlswoerter()
    {
        // nichts zu tun momentan...
    }

    /**
     * Pr�fe, ob eine gegebene Zeichenkette ein g�ltiger
     * Befehl ist.
     * Liefere 'true', wenn das der Fall ist, 'false' sonst.
     */
    public boolean istBefehl(String eingabe)
    {
        for(int i = 0; i < gueltigeBefehle.length; i++) {
            if(gueltigeBefehle[i].equals(eingabe))
                return true;
        }
        // Wenn wir hierher gelangen, wurde die Eingabe nicht
        // in den Befehlsw�rter gefunden.
        return false;
    }

    /*
     * Gib alle g�ltigen Befehlsw�rter auf die Konsole aus.
     */
    public void alleAusgeben() 
    {
        for(int i = 0; i < gueltigeBefehle.length; i++) {
            System.out.print(gueltigeBefehle[i] + "  ");
        }
        System.out.println();
    }
}
