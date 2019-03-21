package Game.Character.Classes;
import Game.Character.Player;

/**
 *
 * @author VincentE
 */
public class Hunter extends Player{
    public Hunter(String characterName,String Champ){
        super(characterName, Champ);
                 
    }
    @Override
    public int gethealth(){
        return 100;
    }
    @Override
    public int getattackDamage(){
        return 90;
    }
    @Override
    public int getApples(){
        return 2;
    }
    
    @Override
    public String getChamp(){
        return "Hunter";
    }

}     
   
    























