package Game.Character;

/**
 *
 * @author VincentE
 */
public class Character {
    
    public String characterName;
    public static String Champ;
    public int health;
    public int attackDamage;
    public int curhealth;
    
    public Character(String characterName, String Champ){
        this.characterName = characterName;
        this.Champ = Champ;
        
    }
    
    public String getCharacterName(){
        return characterName;
    }
    public void setCharacterName(String CharacterName){
        this.characterName = characterName;
    }
    
    public  String getChamp(){
        return Champ;
    }
    public void setChamp(String Champ){
        this.Champ = Champ;
    }
    
    public int gethealth(){
        return health;
    }
    
    public int getattackDamage(){
        return attackDamage;
    }
    
    public int getcurhealth(){
        return curhealth;
    }
    
    public void setcurHealth(int hp){
        if(hp >= health - curhealth){
            curhealth = health;
        }else{
            curhealth = hp;
        }
    }
}




















