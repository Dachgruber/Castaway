import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Dieser Parser liest Benutzereingaben und wandelt sie in
 * Befehle f�r das Adventure-Game um. Bei jedem Aufruf
 * liest er eine Zeile von der Konsole und versucht, diese als
 * einen Befehl aus bis zu zwei W�rtern zu interpretieren. Er
 * liefert den Befehl als ein Objekt der Klasse Befehl zur�ck.
 * 
 * Der Parser verf�gt �ber einen Satz an bekannten Befehlen. Er
 * vergleicht die Eingabe mit diesen Befehlen. Wenn die Eingabe
 * keinen bekannten Befehl enth�lt, dann liefert der Parser ein als 
 * unbekannter Befehl gekennzeichnetes Objekt zur�ck.
 * 
 * Gruppe: Max Mustermann, Mini Musterfrau, Willi Wichtig
 * Verantwortlich: Mini Musterfrau
 * Version: 1.x
 * Datum: xx.yy.zzzz
 */
class Parser 
{

    private Befehlswoerter befehle;  // h�lt die g�ltigen Befehlsw�rter

    public Parser() 
    {
        befehle = new Befehlswoerter();
    }

    public Befehl liefereBefehl() 
    {
        String eingabezeile = "";   // f�r die gesamte Eingabezeile
        String wort1;
        String wort2;

        System.out.print("> ");     // Eingabeaufforderung

        BufferedReader eingabe = 
            new BufferedReader(new InputStreamReader(System.in));
        try {
            eingabezeile = eingabe.readLine();
        }
        catch(java.io.IOException exc) {
            System.out.println ("There was an error during reading: "
                                + exc.getMessage());
        }

        StringTokenizer tokenizer = new StringTokenizer(eingabezeile);

        if(tokenizer.hasMoreTokens())
            wort1 = tokenizer.nextToken().toLowerCase();      // erstes Wort, Umwandlung in Kleinbuchstaben
        else
            wort1 = null;
        if(tokenizer.hasMoreTokens())
            wort2 = tokenizer.nextToken().toLowerCase();      // zweites Wort, Umwandlung in Kleinbuchstaben
        else
            wort2 = null;

        // Hinweis: Wir ignorieren den Rest der Zeile einfach.

        // Jetzt pr�fen, ob der Befehl bekannt ist. Wenn ja, erzeugen
        // wir das passende Befehl-Objekt. Wenn nicht, erzeugen wir
        // einen unbekannten Befehl mit 'null'.

        if(befehle.istBefehl(wort1))
            return new Befehl(wort1, wort2);
        else
            return new Befehl(null, wort2);
    }

    /**
     * Gib eine Liste der bekannten Befehlsw�rter aus.
     */
    public void zeigeBefehle()
    {
        befehle.alleAusgeben();
    }
}
