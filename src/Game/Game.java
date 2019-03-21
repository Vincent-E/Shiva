/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game;

import Game.Commands.Parser;
import Game.Items.Keys;
import java.util.ArrayList;
import Game.Rooms.Rooms;
import Game.Commands.Commands;
import Game.Commands.FirstWord;
import java.util.Scanner;
import Game.Character.Player;
/**
 *
 * @author VincentE
 */
public class Game {
    private Parser parser;
    private ArrayList<Keys> keys;
    private Rooms curRoom;
    
    
    public static void main(String[] args) {
        Game game = new Game();
        game.playGame();
    } 







    public Game(){
        makeMap();
        
        keys = new ArrayList<Keys>();
        parser = new Parser();
    }
    
    
    public void playGame(){
        Scanner readname = new Scanner(System.in);
        System.out.println("Please enter your character's name: ");  //Onoma paikth
        String username = readname.nextLine();
        boolean keepRunning = true;
        
    loop:
        while(keepRunning){   
        Scanner readChamp = new Scanner(System.in);
        System.out.println("Please Choose your Champion: 1.Warrior - 2.Hunter - 3.Priest"); //To class tou paikth
        String champion = readChamp.nextLine();

        
        
        Player player = new Player(username, champion); //ftiaxnei to object tou paikth
        
        if("Warrior".equals(player.getChamp()) ||           //elegxos gia ta swsth epilogh champion
           "Hunter".equals(player.getChamp()) ||            //exei kalutero tropo alla dn ton vrika akoma)
           "Priest".equals(player.getChamp())){ 
                                                                                                                             
            System.out.println("\n" + player.status());
                
            helloWorld();   
        boolean finished = false;
        while (!finished){
            Commands command = parser.getCommand();
            finished = keepRunning(command,player);
        }
        System.out.println("Goodbye!");
    }else{
                System.out.println("Please insert a correct champ");
                continue loop;
                }
                
            }
    }
    
    private void helloWorld(){
        System.out.println(curRoom.getLongDescription());
    }
    
    public void makeMap(){
        
        
        Keys redKey = new Keys("Red");
        Keys blueKey = new Keys("Blue");
        
        Rooms black = new Rooms("1. Black Room.");
        Rooms white = new Rooms("2. White Room.");
        Rooms green = new Rooms("3. Green Room.", redKey);
        Rooms red = new Rooms("4. Red Room");
        Rooms pink = new Rooms("5. Pink Room",blueKey);
        Rooms blue = new Rooms("6. Blue Room");
        
        black.addExit("east", white);
        
        white.addExit("west", black);
        white.addExit("east", green);
        
        green.addExit("west", white);
        green.addExit("south", red, redKey);
        
        red.addExit("north", green);
        red.addExit("east",pink);
        red.addExit("west", blue, blueKey);
        
        pink.addExit("west",red);
        
        blue.addExit("east", red);
        
        curRoom = black;
    }
    
    private boolean keepRunning(Commands command,Player player){
        boolean quit = false;
        
        FirstWord firstWord = command.getFirstWord();
        
        switch (firstWord){
            case OTHER:
                System.out.println("Invalid command\n");
                return false;
            case GO:
                move(command);
                break;
            case HELP:
                printHelp();
                break;
            case STATS:
                System.out.println(player.status());
                break;
            case EAT:
                player.useApple();
                break;
            case QUIT:
                quit = quit(command);
                break;
        }
        return quit;
        }
            

    private boolean quit(Commands command){
        if(command.hasSecondWord()){
            System.out.println("next time try 'quit'\n");
            return false;
        }
        return true;
    }
    
    private void move(Commands command) {
        if(!command.hasSecondWord()) {
            System.out.println("Go -----?\n");
            return;
        }

        String direction = command.getSecondWord();

        Rooms nextRoom = curRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There's no available exit there\n");
            return;
        }
        if (curRoom.getState(direction) == "locked") {
            for (Keys key : keys) {
                if (key.toString().equals(curRoom.getExitKey(direction))) {
                    curRoom.setState(direction, "ok");
                    System.out.println("You unlocked the door!\n");
                    break;
                }
            }
        }
        
        switch (curRoom.getState(direction)) {
            case "locked":
                String keyID = curRoom.getExitKey(direction);
                System.out.println("Door locked! You need the: "+keyID);
                break;

            case "ok":
                curRoom = nextRoom;
                getRoomInfo();
                break;
            default:
                System.out.println("GODAMN");
                break;
        }
    }
    
    private void getRoomInfo() {
        System.out.println(curRoom.getLongDescription());
        if (curRoom.hasKey()) {
            for (Keys key : keys) {
                if (key.toString().equals(curRoom.getKeyID())) {
                    return;
                }
            }
            System.out.println("You found a key!");
            Keys key = curRoom.getKey();
            System.out.println("You now have the: " + key +" key!");
            key.getKey();
            keys.add(key);
        }
    }
    
    private void printHelp() {
        System.out.println("Commands:");
        parser.showAllCommands();
    }
    
}




















