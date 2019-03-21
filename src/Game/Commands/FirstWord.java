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
public enum FirstWord {
    GO("go"),
    QUIT("quit"),
    HELP("help"),
    OTHER("error"),
    STATS("stats"),
    EAT("eat");
    
    private String firstWordString;
    
    FirstWord(String firstWordString){
        this.firstWordString = firstWordString;
    }
    
    public String toString(){
        return firstWordString;
    }
}




