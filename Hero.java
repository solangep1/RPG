import utils.InputParser;

import java.util.ArrayList;

abstract class Hero {
    String consumable;
    int lifePoints;
    int armor;
    int weaponDamage;
    ArrayList<Potion> potions = new ArrayList<>();
    ArrayList<Food> lembas = new ArrayList<>();
    InputParser inputParser;
    abstract void attack();
    abstract void defend();
    abstract void useConsumable();
}
