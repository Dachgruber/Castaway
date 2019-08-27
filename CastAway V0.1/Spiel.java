/**
 * This is the main class of "Castaway".
 * Castaway is a simple adventure based on textinput from the user.
 * The user can freely move around, interact with items, craft, eat and hunt.
 * The main goal is to escape from the main island. Further expansions 
 * to make the game area bigger and more interesting are planned

 * Please create an instance of the class "Spiel" to get started.
 
 * This instance will intialise every room and item.
 * It will create the map, read the user input and process
 * the inputs for the parser
 
 * The code is usually marked with the topic are it belongs:
 * //MainIsland --> island and basic game
 * //SecondIsland --> alternate ending
 * //LandExpansion --> improved ending of the main game
 * //CaveExpansion --> simple dungeon-crawler to replace the basis cave
 
 * Team: Charlotta Höhle, Marcel Siefke, Tom Jark, Cornelius Brütt 
 * Responsible for code: Cornelius Brütt, xxxxx.xxxxx
 * Translation: Cornelius Brütt
 * Bugfixing: xxxxx.xxxxx
 * Version: 0.1
 * Datum: 27.08.2019
 */

class Spiel 
{
    private Parser parser;
    private Spieler spieler;
    private Raum forest, pass, clearing, cave, cliffs, beach,   //MainIsland
                         i2, beach2;                            //SecondIsland
        
    /**
     starts the game
     */
    public Spiel() 
    {
        Raum startRaum = createRooms();
        spieler = new Spieler("Willi", startRaum);
        parser = new Parser();
    }

    /**
     * creation of every room, placement of the items and creation of doors + necessary keys.
     */
    private Raum createRooms()
    {         
        // creates the Rooms. (You are)... 
        
        //MainIsland
        forest= new Raum("in a dense forest with many tall oaks. Many animals are whizzing through the woods. A gentle breeze wafts over your face");
        cave= new Raum("in a dark cave deep in the vulcano with tall, raw stone walls.Your body shivers, as the cold moist air creeps up your body. ");
        clearing= new Raum("in a windy open space. The ground is covered by lots of heather and small tufts of grass. It's kinda nice here warm sun on your skin");
        cliffs= new Raum("on huge blank rocks that mark the coast of the island. The tremendous wind tries to blow you into the wildy splashing waves.");
        beach= new Raum("on a and sandy beach. It could be a pleasent place to stay, but lots of metal scrap and trashed ship equipment decorats the shoreline");
        pass= new Raum("in some kind of narrow passage, limited by the volcano on one and trees on the other side. You can see the water shimmering between the plants.");
        
        //SecondIsland
        beach2= new Raum("a rather small rocky beach, with lots of pebbles and clams. It hurts to walk around with your trashed sneakers");
        i2= new Raum("a rocky formation with a path leading up a small stack of large stones. You see a person standing on the top");
       
        
        
        // creates items
        //beach.addItem(new Item("Artefact","A strange stone with unreadable nonsense carved into it", 0.5 )); redundant
        beach.addItem(new Item("leaf","palm leaf",0.2 ));
        beach.addItem(new Item("scrap", "metal scrap",5.0 ));
        
        cliffs.addItem(new Item("Stone","stone",0.5 ));
        
        forest.addItem(new Item("Wood","piece of hardwood", 2.0 ));
        //forest.addItem(new Item("", )); NO ENTITY IMPLEMENTATION YET
        
        //pass has no items
        
        clearing.addItem(new Item("Stick","sturdy twick",0.5 ));
        
        cave.addItem(new Item("Rope","strong rope",1.0 ));
        cave.addItem(new Item("Batteries", "pack of batteries",0.2 ));
        //cave.addItem(new Item("", )); NO ENTITY IMPLEMENTATION YET
        
        
        //SecondIsland
        
        //beach2 has no items
        
        i2.addItem(new Item("Phone", "sattelite phone", 1.0 ));
        //i2.addItem(new Item("", ));NO ENTITY IMPLEMENTATION YET
        
        
        
        // implementation of key to the cave
        Item code = new Item("Artifact","artifact", 0.5 );
        beach.addItem(code);
        
        // implementation of key to the second island
        Item plank = new Item("Plank","piece of wodden plank", 1.0 );
        beach.addItem(plank);
        
        // die Ausgänge initialisieren
        // draussen.setAusgang("Norden", flur);
        // flur.setAusgang("Süden", draussen);
        
        new Tuer(beach, "north", pass, "east",null);
        new Tuer(cliffs, "east",beach ,"west",null);
        new Tuer(forest, "south",cliffs , "north",null);
        new Tuer(forest, "east",clearing , "west",null);
        new Tuer(clearing, "north",pass , "south",null);
        
        //MainIsland
        new Tuer(clearing, "east",cave , "west",code);
        
        //SecondIsland
        new Tuer(pass, "north",beach2 , "south",plank);
        new Tuer(i2, "east", beach2, "west",null);
       
        return beach;  // Spawnpoint of the player
    }

    /**

     */
    public void playGame() 
    {            
       startStory();
                
        boolean beendet = false;
        while (! beendet) {
            Befehl befehl = parser.liefereBefehl();
            beendet = verarbeiteBefehl(befehl);
            if(spieler.istTot()){
                printDeathEnding();
                beendet = true;
            }
            if(spieler.getAktuellerRaum() ==beach&&spieler.hatItem("crafted boat")){
                printEnding();
                beendet = true;
            }   
        }
        //JUST THE MAIN ENDING TEXT!
       
    }
    
    private void printEnding()
    {
        System.out.println("The boat seems finished. While it’s just a log with some sticks stuck into it, It will be enough to get ");
        System.out.println("my away from this place.");
        System.out.println("As I pushed the construct into the ocean, I felt cold water splashing up my legs. My whole body ");
        System.out.println("shivered, but I kept going as a fear for my live. Behind me, the volcano started to grumble violently, ");
        System.out.println("as a huge cloud shot out of the shaft. The boat shook heavily from one side to the other, but as ");
        System.out.println("soon as the sail catched the wind, I could stop paddling and let the nature do my work. I");
        System.out.println("succeeded. I escaped the island. Now, I have to find a way to save myself and get back to ");
        System.out.println("civilisation…");
        System.out.println();
        System.out.println("A couple hours into my ride I encounter a large cruise ship. They stopped, saved me and gotten ");
        System.out.println("me food and some water to drink. The captain managed to organize a rescue mission with a ");
        System.out.println("nearby rescue helicopter, so I can go to the nearest hospital on the coast as soon as possible.");
        System.out.println();
        System.out.println("I did it! I saved my life out of this horrible situation. I managed to build a ship out of basically ");
        System.out.println("nothing and outplayed the nature.");    
    }
    
    private void printDeathEnding()
    {
        System.out.println("***DEATH_PLACEHOLDER***");
    }
    
    /**
     * The start of the main story
     */
    private void startStory()
    {
        System.out.println("");
        System.out.println("A gentle breeze stroked my sandy face as I slowly stood up. My eyes were burning ");
        System.out.println("from the saltwater and my clothes were totally trashed. I looked at the sun. Distant calls of seagulls ");
        System.out.println("mixed with the gentle whispering of the sea lead to a peaceful, quite atmosphere. The last thing I ");
        System.out.println("remembered is the fact that I had taken my plane to Sydney. And it was night. I was very tired, as I ");
        System.out.println("needed to wait in Japan for a couple of hours until my connecting flight takes off.  And now, I am ");
        System.out.println("stranded. Alone. F*cking miles away from any civilisation.");
        System.out.println();
        System.out.println("*looks around* It looks like a lonely island with a huge mountain. On the left side the path leads ");
        System.out.println("upwards to something that looks like a cliff, on the right side the beach leads on around a corner, ");
        System.out.println("probably something like a passage.");
        System.out.println();
        System.out.println("EARTHQUAKE");
        System.out.println();
        System.out.println("Oh sh*t. *looks at the mountain – thick black smoke rises from the top* The mountain isn’t just an ");
        System.out.println("ordinary mountain – it’s a f*cking volcano. And it seems active as well. I need to find a way to leave ");
        System.out.println("this place as soon as possible. Maybe I can build something that floats... something like a boat...");
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println(spieler.getLangeBeschreibung());
    }
    
    
    /**
     * method of processing commands
     */
    private boolean verarbeiteBefehl(Befehl befehl) 
    {
        boolean close = false;

        if(befehl.istUnbekannt()) {
            System.out.println("What do you mean?");
            return false;
        }

        String befehlswort = befehl.getBefehlswort();
        if (befehlswort.equals("help"))
            printHelp();
        else if (befehlswort.equals("go"))
            changeRoom(befehl);
        else if (befehlswort.equals("quit")) 
            close = quit(befehl);
        else if (befehlswort.equals("get")) 
            get(befehl);
        else if (befehlswort.equals("drop")) 
            drop(befehl);
        else if (befehlswort.equals("eat")) 
            eat(befehl);  
        
        return close;
    }

    // Implementierung der Benutzerbefehle:

    /**
     * if the player seeks some help, this method will show him a short version of the story, the main goal and every command he can use.
     */
    private void printHelp() 
    {
        System.out.println("You are stranded onto this deserted island. Your only chance of survival is to find a way");
        System.out.println("of escaping. A boat or something should come in handy in trying of leaving this place.");
        System.out.println();
        System.out.println("You can move and interact with the following commands:");
        parser.zeigeBefehle();
    }

    /**
     * Versuche, den Raum zu wechseln. Wenn es einen Ausgang gibt,
     * wechsele in den neuen Raum, ansonsten gib eine Fehlermeldung
     * aus.
     */
    private void changeRoom(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
            // gett es kein zweites Wort, wissen wir nicht, wohin...
            System.out.println("Where do you want to go?");
            return;
        }

        String richtung = befehl.getZweitesWort();

        // Wir versuchen den Raum zu verlassen.
        Tuer tuer = spieler.getAktuellerRaum().getTuer(richtung);

        if (tuer == null)
            System.out.println("There isn't a way to go!");
        else {
            if(spieler.geheDurch(richtung)) {
                System.out.println(spieler.getLangeBeschreibung());
            } 
            else {
                System.out.println("This way is unpassable, but you can find an item to open it up");
            }                
                        
        }
    }

    /** 
     * Versuche ein Item aus dem aktuellen Raum aufzunehmen.
     * 
     */
    private void get(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
            // Wenn kein zweites Wort da ist, ...
            System.out.println("What item do you want to pick up? ");
            return;
        }

        String itemName = befehl.getZweitesWort();
        Item item = spieler.pickUpItem(itemName);
        
        if(item == null) {
            System.out.println("It seems that you are unable to pick " + itemName + " up. What a bummer");
        } 
        else {
            System.out.println("You have aquired " + item.getBeschreibung());
        }
    }
    
    
    /** 
     * Lässt ein Item im aktuellen Raum fallen.
     */
    private void drop(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
            // Wenn kein zweites Wort da ist, ...
            System.out.println("What item do you want to drop?");
            return;
        }

        String itemName = befehl.getZweitesWort();
        Item item = spieler.dropItem(itemName);
        
        if(item == null) {
            System.out.println("You aren't holding" + itemName);
        } 
        else {
            System.out.println("You dropped " + item.getBeschreibung() + " out of your inventory");
        }
    }
    
    /**
     * Gib die Items aus, die der Spieler aktuell trägt.
     */
    private void printItems() 
    {
        System.out.println(spieler.getItemsString());   
    }
    

    private void eat(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
            // if there is no second word, we don't know what to eat...
            System.out.println("What do you want to eat? The dirt under your nails?");
            return;
        }
        String itemName = befehl.getZweitesWort();
        Item item = spieler.essen(itemName);
        if(item == null) {
            System.out.println(itemName + " seems to be the opposite of delicious");            
        } 
        else {
            System.out.println("You stuffed" + item.getBeschreibung() + " into yourself. Enjoy!");
        }
    }
    
    
    /**
     * "Beenden" wurde eingegeben. Überprüfe den Rest des Befehls,
     * ob das Spiel wirklich beendet werden soll. Liefere 'true',
     * wenn der Befehl das Spiel beendet, 'false' sonst.
     */
    private boolean quit(Befehl befehl) 
    {
        if(befehl.hatZweitesWort()) {
            System.out.println("You want to quit? What?");
            return false;
        }
        else
            return true;  // Das Spiel soll beendet werden.
    }
    
    
/**  BEAMER ERSTMAL NICHT MIT IMPLEMENTIERT ------ MÖGLICHES SPEICHERN? 
 * 
 * private void laden(Befehl befehl) 
    {
        spieler.ladeBeamer();
        System.out.println("Beamer geladen.");
    }
    
    
    private void feuern(Befehl befehl) 
    {
        if(spieler.feuerBeamer()) {
            System.out.println("Beamer gefeuert.");
            System.out.println(spieler.getLangeBeschreibung());
        }
        else {
            System.out.println("Beamer ist nicht geladen.");
        }
    }
 */   
}
