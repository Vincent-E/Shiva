/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Rooms;

import Game.Items.Keys;

/**
 *
 * @author VincentE
 */
public class CreateWorld {
    
    private static Rooms curRoom;
    
    public static void makeMap(){
        
        
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
        
        blue.addExit("east", red);
        
        curRoom = black;
    }
    
    
}



