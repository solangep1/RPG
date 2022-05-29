import utils.InputParser;

import java.util.ArrayList;
import java.util.Random;

public class Game {
    ArrayList<Hero> heroes = new ArrayList<>();
    int playTurn;
    InputParser inputParser = new InputParser();

    ArrayList<Hero> heroChoice(){
        int heroNumber = inputParser.scanHeroNumber();
        String heroName = "";
        Hero h;
        for (int i = 0; i<heroNumber; i++){
          heroName = inputParser.scanHeroName();

            if (heroName.equals("Hunter")){
                h = new Hunter();
                heroes.add(h);
            }
            else if (heroName.equals("Mage")){
                h = new Mage();
                heroes.add(h);
            }
            else if (heroName.equals("Healer")){
                h = new Healer();
                heroes.add(h);
            }
            else {
                h = new Warrior();
                heroes.add(h);
            }
        }
        return heroes;
    }
    //public Game(){}
    //public static void playGame(){}
    public static Enemy generateEnemy(){
        Random rand = new Random();
        int randNumber = rand.nextInt(2);
        Enemy e;

        switch (randNumber){
            case 0:{
                e=new Boss();
                break;
            }
            default:{
                e=new BasicEnemy();
                break;
            }
        }
        return e;
    }
    public void generateCombat(){
        ArrayList<Hero> h = heroChoice();
        String action;
        Enemy enemy = generateEnemy();

        for(int i=0; i<h.size();i++){
            Hero hero = h.get(i);
            while (hero.lifePoints<0){
                status(hero, enemy);
                action = inputParser.scanAction();
                switch (action){
                    case "Attack":{
                        hero.attack();
                        break;
                    }
                    case "Defend":{
                        hero.defend();
                        break;
                    }
                    case "Eat":{
                        if (hero.lembas.size()>0){
                            hero.useConsumable();
                        }
                        else{
                            System.out.println("Vous n'avez plus de nourriture");
                        }
                        break;
                    }
                    case "Drink":{
                        if (hero.potions.size()>0){
                            hero.useConsumable();
                        }
                        else{
                            System.out.println("Vous n'avez plus de potion");
                        }
                        break;
                    }
                }
                System.out.println(Hero.class.getName()+" a perdu !");
            }
        }
    }

    public static void status(Hero h, Enemy enemy){
        System.out.println("Voici votre état :\n"+ "Armure : "+h.armor+"\n Points de vie :"+h.lifePoints+"\n Puissance d'arme"+h.weaponDamage);
        System.out.println("Consomables :\n");
        for (Food food: h.lembas){
            System.out.println("Nourriture"+food.consumName+" ajoute "+food.lifePointsAdded+"points de vie");
        }
        for (Potion potion: h.potions){
            System.out.println("Potion"+potion.consumName+" ajoute"+potion.pointsAdded+" points de vie");
        }
        System.out.println("Votre ennemi est "+enemy.getClass().getSimpleName()+" et a"+enemy.lifePoints+" points de vie");
    }


}
