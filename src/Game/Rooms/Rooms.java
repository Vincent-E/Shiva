/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Rooms;
import Game.Items.Keys;
import java.util.HashMap;
import java.util.Set;
/**
 *
 * @author VincentE
 */
public class Rooms {
    private String description;
    private Keys key;
    private HashMap<String, Rooms> exit;
    private HashMap<String, String> exitLocks;
    
    public Rooms(String description){
        makeRoom(description, null);
    }
    
    public Rooms(String description, Keys key){
        makeRoom(description, key);
    }
    
    private void makeRoom(String description, Keys key){
        this.description = description;
        this.key = key;
        exit = new HashMap<String, Rooms>();
        exitLocks = new HashMap<String, String>();
    }
    
    public void addExit(String direction, Rooms nextRoom){
        addExit(direction, nextRoom,"ok");
    }
    
    public void addExit(String direction, Rooms nextRoom, Keys key){
        exitLocks.put(direction + "Key", key.toString());
        addExit(direction, nextRoom, "locked");
    }
    
    private String getExitString() {
        String returnString = "Exits: ";
        Set<String> keys = exit.keySet();
        for(String exit : keys) {
            returnString += " " + exit;
        }
        return returnString;
    }
    
    public String getLongDescription(){
        return "You are in room " + description + ".\n" + getExitString();
    }
    public String getShortDescription(){
        return description;
    }
    
    public Rooms getExit(String direction) {
        return exit.get(direction);
    }
    
    public String getExitKey(String direction){
        return exitLocks.get(direction + "Key");
    }
    
    public boolean hasKey(){
        if(this.key == null){
            return false;
        }
        return true;
    }
    
    public Keys getKey(){
        return key;
    }
    
    public String getKeyID() {
        return key.toString();
    }
    
    public void addExit(String direction, Rooms nextRoom, String state){
        exit.put(direction, nextRoom);
        exitLocks.put(direction + "State", state);
    }
    
    public String getState(String direction) {
        return exitLocks.get(direction + "State");
    }
    
    public void setState(String direction, String state) {
        exitLocks.put(direction + "State", state);
    }
}






