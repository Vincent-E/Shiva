/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Commands;

/**
 *
 * @author VincentE
 */
public class Commands {
    private FirstWord firstWord;
    private String secondWord;
    
    public Commands(FirstWord firstWord, String secondWord){
        this.firstWord = firstWord;
        this.secondWord = secondWord;
    }
    public FirstWord getFirstWord(){
        return firstWord;
    }
    public String getSecondWord(){
        return secondWord;
    }
    public boolean uknown(){
        return(firstWord == null);
    }
    public boolean hasSecondWord(){
        return(secondWord != null);
    }
}


