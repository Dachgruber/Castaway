/**
 * This is the main class of "Castaway".
 * Castaway is a simple adventure based on textinput from the user.
 * The user can freely move around, interact with items, craft, eat and hunt.
 * The main goal is to escape from the main island. Further expansions 
 * to make the game area bigger and more interesting are planned

 * Please create an instance of the class "CastAway" to get started. Alternativly, execute the main method of "Starter" without inputting arguments.
 
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

import java.io.Serializable;
import java.util.Timer;

class CastAway implements java.io.Serializable
{
    private Parser parser;
    public Player player;
    private Story story;
    private Interface gui;
    private Room forest, pass, clearing, cave, cliffs, beach,   //MainIsland
                         i2, beach2;                            //SecondIsland
    //private Timer timer;                     
        
    /**
     starts the game
     */
    public CastAway(String playername) 
    {
        Room startRoom = createRooms();
        player = new Player(playername, startRoom);
        parser = new Parser();
        story = new Story();
        //timer = new Timer(true);
        
        
    }
    
    /**
     second constructor to test the game ONLY DEBUGGING
     */
    public CastAway() 
    {
        Room startRoom = createRooms();
        player = new Player("DEBUG", startRoom);
        parser = new Parser();
        story = new Story();
        //timer = new Timer(true);
        
        
    }
    
    /**
     * creation of every room, placement of the items and creation of doors + necessary keys.
     */
    private Room createRooms()
    {         
        // creates the Rooms. (You are)... 
        
        //MainIsland
        forest= new Room("in the forest","in a dense forest with many tall oaks. Many animals are whizzing through the woods. A gentle breeze wafts over your face");
        cave= new Room("inside the cave", "in a dark cave deep in the vulcano with tall, raw stone walls.Your bodyshivers, as the cold moist air creeps up your body. ");
        clearing= new Room("at the clearing", "in a windy open space. The ground is covered by lots of heather and small tufts of grass. It's kinda nice here warm sun on your skin");
        cliffs= new Room("at the cliffs", "on huge blank rocks that mark the coast of the island. The tremendous wind tries to blow you into the wildy splashing waves.");
        beach= new Room("on the beach","on a and sandy beach. It could be a pleasent place to stay, but lots of metal scrap and trashed plane equipment decorats the shoreline");
        pass= new Room("in the passage", "in some kind of narrow passage, limited by the volcano on one and trees on the other side. You can see the water shimmering between the plants.");
        
        //SecondIsland
        beach2= new Room("at the small beach", "a rather small rocky beach, with lots of pebbles and clams. It hurts" + "\n" + "to walk around with your trashed sneakers");
        i2= new Room("at the stone stack", "a rocky formation with a path leading up a small stack of large stones." + "\n" + "You see a person standing on the top");
       
        
        
        //creates items
        beach.addItem(new Item("leaf","palm leaf", "A big leaf of a palm tree. When fixed right, It can be used to catch the wind and act as a sail…", 0.1 ));
        beach.addItem(new Item("scrap", "metal scrap","A bunch of old unusable metal leftover from the planec crash. It's heavy as hell", 5.0 ));
        beach.addItem(new Item("sand", "sand","could use some of the sand to do stuff, but it won't be usefull I guess", 5.0 ));
        
        //starting food&drink
        beach.addFood(new Food("ration", "survival ration","tastless and hard as brick, but will keep me alive in such a pitty situation", 0.5, 20.0 ));
        beach.addDrink(new Drink("pepsi", "can of pepsi","tasty can of pepsi(tm) perfect for every survival situation", 0.5, 20.0 ));
        
        beach.addSource(new Source("ocean", "the vast ocean", "the salty, rough sea. Responisble for your current situation", 200.0,
                                   "Drink","saltwater","can of salty oceanwater","unsafe to drink, but surly better than dying I guess", 1.0, -20));
        
        
        
        cliffs.addItem(new Item("stone","stone","A good-sized rock usable for all sorts of things. It can be easily sharpened, I guess", 0.5 ));
        
        forest.addItem(new Item("wood","piece of hardwood","This is a good piece of hardwood. I can easily cut some parts out of it to fix a sail onto it. Then, It should be enough to get me safely of the island", 2.0 ));
        forest.addItem(new Item("branch","enourmous branch", "Some deadwood. Good as firewood, but I can't for the life of me move this thing", 10.0));
        forest.addFood(new Food("mushrooms","bunch of red mushrooms", "a couple of reddish mushrooms. I shouldn't eat something I don't know",1.0, 10));
        //forest.addItem(new Item("", )); NO ENTITY IMPLEMENTATION YEET
        
        pass.addItem(new Item("pebbles","bunch of small pebbels", "lots and lots of tiny stones. Could be useful as bullets, but I havn't got a gun", 0.2)); 
        
        clearing.addItem(new Item("stick","sturdy twick","A stick! I’m pretty sure I can use it to propel my boat of the island. If it just be a little bit longer…",0.5 ));
        clearing.addSource(new Source("bush", "blueberry bush" , "a spiky small shrubbery that provides these tasty little balls", 200.0, 
                            "Food", "berries","blueberries", "some really tasty blueberries. I should be careful with eating wild plantlife, but I know these for sure",0.2, 10));
        
        
        cave.addItem(new Item("rope","strong rope","I found a rope. Surely it will be useful at some point, maybe to secure my boat… ",1.0 ));
        cave.addItem(new Item("batteries", "pack of batteries","Weird. There are a bunch of batteries here but it seems like nothing to use their power", 0.2 ));
        cave.addFood(new Food("toadstools", "some wierd toadstools", "bunch of glowing mushrooms growing straight out of the rock. This doesn't seem right",0.5,1));
        //cave.addItem(new Item("", )); NO ENTITY IMPLEMENTATION YET
        
        
        //SecondIsland
        
        beach2.addItem(new Item("gravel", "gravel","lots and lots of tiny stones. Could be useful as bullets, but I havn't got a slingshot", 0.2 ));
        
        i2.addItem(new Item("phone", "sattelite phone","an old nokia phone unable to boot up. A nokia can't be broken, maybe it just needs some new batteries... ", 1.0 ));
        //i2.addItem(new Item("", ));NO ENTITY IMPLEMENTATION YET
        
        
        
        // implementation of key to the cave
        Item code = new Item("artifact","artifact","A strange stone with unreadable nonsense carved into it", 0.5 ); //
        //beach.addItem(code);
        
        // implementation of key to the second island
        Item plank = new Item("plank","piece of wodden plank","A oversized man-made plank that can be used for floating. I will die if I try to sail the open seas with that thing", 1.0 ); //
        //beach.addItem(plank);
        
        // die Ausgänge initialisieren
        // draussen.setAusgang("Norden", flur);
        // flur.setAusgang("Süden", draussen);
        
        new Door(beach, "north", pass, "east",null);
        new Door(cliffs, "east",beach ,"west",null);
        new Door(forest, "south",cliffs , "north",null);
        new Door(forest, "east",clearing , "west",null);
        new Door(clearing, "north",pass , "south",null);
        
        //MainIsland
        new Door(clearing, "east",cave , "west",code);
        
        //SecondIsland
        new Door(pass, "north",beach2 , "south",plank);
        new Door(i2, "east", beach2, "west",null);
       
        return beach;  // Spawnpoint of the player
    }

    /**

     */
    public void playGame() 
    {            
        gui =  new Interface();
        startStory();
                
        boolean beendet = false;
        while (! beendet) {
            if (Interface.getNewInput())
            {
            Interface.setNewInput(false);    
            Befehl befehl = parser.liefereBefehl();
            beendet = processCommand(befehl);
            }
            if(player.istDead()){
                printDeathEnding();
                beendet = true;
            }
            if(player.getCurrentRoom() ==beach&&player.hasItem("boat")){
                printEnding();
                beendet = true;
            }   
        }
       
    }
    
    private void printEnding()
    {
        gui.print(story.printEnding());
    }
    
    private void printDeathEnding()
    {
        gui.print(story.printDeathEnding());
    }
    
    /**
     * The start of the main story
     */
    private void startStory()
    {
        story.clearScreen();
        gui.print(story.printStart());
        gui.print(player.getLongDescription());
        gui.printInventory(player.getItemsString());
        gui.printFloor(player.getRoomItems());
    }
    
    
    /**
     * method of processing commands
     */
    private boolean processCommand(Befehl befehl) 
    {
        boolean close = false;
    
        if(befehl.istUnbekannt()) {
            gui.print("What do you mean?");
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
        else if (befehlswort.equals("drink")) 
            drink(befehl);
        else if (befehlswort.equals("examine")) 
            examine(befehl);
        else if (befehlswort.equals("gather")) 
             gather(befehl);
        else if (befehlswort.equals("sleep")) 
             sleep(befehl);      
             
        else if (befehlswort.equals("save")) 
             save(befehl);
        else if (befehlswort.equals("load")) 
             load(befehl);     
            
    
    
        return close;
    }

    // Implementierung der Benutzerbefehle:

    /**
     * if the player seeks some help, this method will show him a short version of the story, the main goal and every command he can use.
     */
    private void printHelp() 
    {
        gui.print(story.printHelp());
        parser.zeigeBefehle();
    }
    
    /**
     * changes the room of the player. Checks for vitals and needs aswell
     */
    private void changeRoom(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
            // is there a second word?...
            gui.print("Where do you want to go?");
            return;
        }

        String richtung = befehl.getZweitesWort();

        // Trying to leave the room
        Door Door = player.getCurrentRoom().getDoor(richtung);

        if (Door == null)
            gui.print("There isn't a way to go!");
        else {
            if(player.goThrough(richtung)) {
                gui.print(player.getLongDescription());
                gui.printInventory(player.getItemsString());
                gui.printFloor(player.getRoomItems());
                
                if(player.getCurrentRoom().getShortDescription() == "inside the cave") {player.setTempP(20);}
                
                double HP = player.getHP();
                double TP = player.getTP();
                double EP = player.getEP();
                double SP = player.getSP();
                double TempP = player.getTempP();
                
               
                 if(HP<20) gui.print("You are hungry! You should find something to eat!");
                 if(TP<20) gui.print("You are thirsty! You should find something to drink!");
                 if(EP<20) gui.print("You seem to be fatuiged. You should put yourself to rest!");
                 if(SP<20) gui.print("What was that? Voices? I think you're turning insane! ");
                 if(TempP<20) gui.print("You start to shiver! Seems little chilly in here!");
        
                 if(HP<1)   {player.takeDamage(20); gui.print("You are starving!");}
                 if(TP<1)   {player.takeDamage(20); gui.print("You are dehydrating!");}
                 if(EP<1)   {player.takeDamage(10); gui.print("You tripped because you are to sleepy!");}
                 if(TempP<1){player.takeDamage(20); gui.print("Your fingers and ears start to hurt. Warm yourself up!");}
                 
                 if(SP<1) {suicide(); }
                 
                 
            } 
            else {
                gui.print("This way is unpassable, but you can find an item to open it up");
            }                
                        
        }
    }

    /** 
     * Versuche ein Item aus dem aktuellen Room aufzunehmen.
     * 
     */
    private void get(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
            // Wenn kein zweites Wort da ist, ...
            gui.print("What item do you want to pick up? ");
            return;
        }

        String itemName = befehl.getZweitesWort();
        Item item = player.pickUpItem(itemName);
        Food food = player.pickUpFood(itemName);
        Drink drink = player.pickUpDrink(itemName);
        
        if(item == null && food == null && drink == null) {
            gui.print("It seems that you are unable to pick " + itemName + " up. What a bummer");
        } 
        else {
          if(food != null)  gui.print("You have aquired " + food.getDescription());
          else {
              if (item != null) gui.print("You have aquired " + item.getDescription()); 
                else {
                        if (drink != null)gui.print("You have aquired " + drink.getDescription()); 
                     }
                }
            }
        gui.printInventory(player.getItemsString());
        gui.printFloor(player.getRoomItems());
    }
    
     /** 
     * Versuche ein Item aus dem aktuellen Room aufzunehmen.
     * 
     */
    private void gather(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
            // Wenn kein zweites Wort da ist, ...
            gui.print("What do you want to gather? ");
            return;
        }

        String itemName = befehl.getZweitesWort();
        Source source = player.pickUpSource(itemName);
        
        if(source == null) {
            gui.print("It seems that you are unable to gather something from " + itemName + " up. What a bummer");
        } 
        else {
          
            }
        gui.printInventory(player.getItemsString());
        gui.printFloor(player.getRoomItems());
    }
    
    /** 
     * Lässt ein Item im aktuellen Room fallen.
     */
    private void drop(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
            // Wenn kein zweites Wort da ist, ...
            gui.print("What item do you want to drop?");
            return;
        }

        String itemName = befehl.getZweitesWort();
        Item item = player.dropItem(itemName);
        
        if(item == null) {
            gui.print("You aren't holding" + itemName);
        } 
        else {
            gui.print("You dropped " + item.getDescription() + " out of your inventory");
        }
        gui.printInventory(player.getItemsString());
        gui.printFloor(player.getRoomItems());
    }
    
    /**
     * Gib die Items aus, die der Player aktuell trägt.
     */
    private void printItems() 
    {
        gui.print(player.getItemsString());   
    }
    

    private void eat(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
            // if there is no second word, we don't know what to eat...
            gui.print("What do you want to eat? The dirt under your nails?");
            return;
        }
        String itemName = befehl.getZweitesWort();
        Food food = player.eat(itemName);
        if(food == null) {
            gui.print(itemName + " seems to be the opposite of delicious");            
        } 
        else {
            gui.print("You stuffed " + food.getDescription() + " into yourself. Yummy!");
        }
        gui.printInventory(player.getItemsString());
    }

    private void drink(Befehl befehl) 
    {
        if(!befehl.hatZweitesWort()) {
            // if there is no second word, we don't know what to drink...
            gui.print("You thirsty? Better find some clean water!");
            return;
        }
        String itemName = befehl.getZweitesWort();
        Drink item= player.drink(itemName);
        if(item == null) {
            gui.print(itemName + " seems to be too non-liquid to drink");            
        } 
        else {
            gui.print("You slurped " + item.getDescription() + ". Tasty!");
        }
        gui.printInventory(player.getItemsString());
    }

    private void examine(Befehl befehl)
    {
        if(!befehl.hatZweitesWort()) {
            // if there is no second word, we don't know what to examine...    
            gui.print("You looked at your hands. You concluded that they're made out of hands");
            return;
        }
        String itemName = befehl.getZweitesWort();
        String story = player.examine(itemName);
        
        if(story == null) gui.print("There is no " + itemName +  " can look at");
        else              gui.print(story);
        
        
    }
    
    private void sleep(Befehl befehl)
    {
        if(befehl.hatZweitesWort()) {
            gui.print("wait what?");
            return ;
        }     
      else 
      player.addEP(80);
      player.addMP(30);
        
    }
    
    private void suicide()
    {
     //currently abstract  
    }
    
    /**
     * "Beenden" wurde eingegeben. Überprüfe den Rest des Befehls,
     * ob das Spiel wirklich beendet werden soll. Liefere 'true',
     * wenn der Befehl das Spiel beendet, 'false' sonst.
     */
    private boolean quit(Befehl befehl) 
    {
        if(befehl.hatZweitesWort()) {
            gui.print("You want to quit? What?");
            return false;
        }
        else
            gui.print(story.printQuit());
            return true;  // quit the game
    }
    
    private void save(Befehl befehl)
    {
    if(!befehl.hatZweitesWort()) {
             // if there is no second word, we don't know what to save...
             gui.print("Where do you want to save?");
             return;     
    }
    String saveName = befehl.getZweitesWort();
    boolean saved = Save.saveGame(this,saveName);
        if (saved==true)
        {
            gui.print("Successfully saved!");
        }
        else
        {
            gui.print("There was an error during saving!");
        }
    } 
    
    private void load(Befehl befehl)
    {
    if(!befehl.hatZweitesWort()) {
             // if there is no second word, we don't know what to load...
             gui.print("Where do you want to save?");
             return;     
    }
    String loadName = befehl.getZweitesWort();
    boolean loaded = Save.loadGame(loadName);
    if (loaded == false)
    {
        gui.print("There was an error during loading");
        
    }
    else
    {
        gui.print("Successfully loaded");
        gui.printInventory(player.getItemsString());
    }
    
    }
    
    public Items getEricItems()
    {
    return player.getInventory();    
    }
}
