package Game.Character;

import Game.Character.Classes.Warrior;
import Game.Character.Classes.Hunter;
import Game.Character.Classes.Priest;
/**
 *
 * @author VincentE
 */
public class Player extends Character {
     public int apples;

     public Player(String characterName, String Champ){
        super(characterName, Champ);
        stats();
        this.curhealth = health;
    } 
     
     public String useApple(){
         if(apples >=1 ){
             this.setcurHealth(this.getcurhealth() + 25);
             apples--;
             System.out.println("You ate an apple!");
             return apples + " apples left.";
         }else{
             System.out.println("You dont have any apples left");
             return "You dont have any apples left.";
         }
     }
     public int getApples(){
         return apples;
     }
     public void setApples(){
         this.apples = apples;
     }
     
     public void stats(){
                switch(Champ){
                case "warrior":
                case "w":
                case "1":
                    Warrior war = new Warrior(characterName,"Warrior");
                    Champ = war.getChamp();
                    health = war.gethealth();
                    attackDamage = war.getattackDamage();
                    apples = war.getApples();
                    break;
                case "hunter":
                case "h":
                case "2":
                    Hunter hun = new Hunter(characterName,"Hunter");
                    Champ = hun.getChamp();
                    health = hun.gethealth();
                    attackDamage = hun.getattackDamage();
                    apples = hun.getApples();
                    break;
                case "priest":
                case "p":
                case "3":
                    Priest pri = new Priest(characterName,"Priest");
                    Champ = pri.getChamp();
                    health = pri.gethealth();
                    attackDamage = pri.getattackDamage();
                    apples = pri.getApples();
                    break;
         }
       }
     
     public String status(){
        return "*" + characterName + " has " + curhealth + " / " + health + " health. " + apples + " apples left. " + "(" + attackDamage + " max Attack Damage.)*";
    }

}



















