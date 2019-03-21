/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Game.Items;

/**
 *
 * @author VincentE
 */
public class Keys {
    boolean owned;
    String keyName;
    
    public Keys(String keyName){
        owned = false;
        this.keyName = keyName;
    }
    
    public boolean haveKey(){
        return owned;
    }
    
    public void getKey(){
        owned = true;
    }
    
    public String toString(){
        return keyName;
    }
}


