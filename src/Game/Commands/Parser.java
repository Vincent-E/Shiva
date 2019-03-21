/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Commands;

import java.util.Scanner;

/**
 *
 * @author VincentE
 */
public class Parser {
    private CommandList commands;
    private Scanner reader;
    
    public Parser(){
        commands = new CommandList();
        reader = new Scanner(System.in);
    }
    
    public Commands getCommand(){
        String input;
        String firstword = null;
        String secondword = null;
        
        System.out.print("- ");
        input = reader.nextLine();
        
        Scanner tokenizer = new Scanner(input);
        if(tokenizer.hasNext()){
            firstword = tokenizer.next();
            if(tokenizer.hasNext()){
                secondword = tokenizer.next();
            }
        }
    return new Commands(commands.getFirstWord(firstword),secondword);
    }
    
    public void showAllCommands(){
        commands.showCommands();
    }
}



