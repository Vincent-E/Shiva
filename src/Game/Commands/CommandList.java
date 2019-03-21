/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Commands;

import java.util.HashMap;

/**
 *
 * @author VincentE
 */
public class CommandList {
    private HashMap<String, FirstWord> allCommands;
    
    public CommandList(){
        allCommands = new HashMap<String, FirstWord>();
        for(FirstWord command : FirstWord.values()){
            if(command != FirstWord.OTHER){
                allCommands.put(command.toString(),command);
            }
        }
    }
    
    public FirstWord getFirstWord(String firstWord){
        FirstWord command = allCommands.get(firstWord);
        if(command == null){
            return FirstWord.OTHER;
        }
        return command;
    }
    
    public boolean correctCommand(String commandString){
        return allCommands.containsKey(commandString);
    }
    
    public void showCommands(){
        for(String command : allCommands.keySet()){
            System.out.print(command + "  ");
        }
        System.out.println();
    }
}


