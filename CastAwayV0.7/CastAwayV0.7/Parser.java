import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.StringTokenizer;
import java.util.Scanner;

/**
 * 
 * 
 * with the help of "guillaume polet" and the stackoverflow.com forum: https://stackoverflow.com/questions/12669368/java-how-to-extend-inputstream-to-read-from-a-jtextfield
 * 
 * Gruppe: Max Mustermann, Mini Musterfrau, Willi Wichtig
 * Verantwortlich: Mini Musterfrau
 * Version: 1.x
 * Datum: xx.yy.zzzz
 */
class Parser implements java.io.Serializable
{

    private Befehlswoerter befehle;  // hält die gültigen Befehlswörter

    public Parser() 
    {
        befehle = new Befehlswoerter();
    }

    public Befehl liefereBefehl() 
    {
        Befehl returnBefehl = null;
        InputStream is = null;
        String eingabezeile = "";   
        String wort1;
        String wort2;

        Scanner scanner = new Scanner(Interface.read());
        
        if(scanner.hasNext())
            wort1 = scanner.next().toLowerCase();      // erstes Wort, Umwandlung in Kleinbuchstaben
        else
            wort1 = null;
        if(scanner.hasNext())
            wort2 = scanner.next().toLowerCase();      // zweites Wort, Umwandlung in Kleinbuchstaben
        else
            wort2 = null;
            
        if(befehle.istBefehl(wort1))
            return new Befehl(wort1, wort2);
        else
            return new Befehl(null, wort2);
            

        
        
    }

    /**
     * Gib eine Liste der bekannten Befehlswörter aus.
     */
    public void zeigeBefehle()
    {
        befehle.alleAusgeben();
    }
}
