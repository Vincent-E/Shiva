package Game.Character.Classes;

import Game.Character.Player;



/**
 *
 * @author VincentE
 */
public class Priest extends Player{
    public Priest(String characterName,String Champ){
        super(characterName, Champ);
                    
    }
    
    @Override
    public int gethealth(){
        return 150;
    }
    @Override
    public int getattackDamage(){
        return 50;
    }
    @Override
    public int getApples(){
        return 2;
    }
    @Override
    public String getChamp(){
        return "Warrior";
    }
    
}     
   
    

























