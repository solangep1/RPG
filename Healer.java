class Healer extends SpellCaster {
    Healer(){
        super.lifePoints=5;
        super.armor=5;
        super.weaponDamage=5;
        super.lembas.add(new Food("Apple",2));
        super.lembas.add(new Food("Banana",1));
        super.potions.add(new Potion("Blue",2));

    }
    void attack() {
        if (Enemy.lifePoints >0) {
            Enemy.lifePoints--;
            System.out.println("Attaque réussie ! Points de vie de l'ennemi : "+ Enemy.lifePoints);
        }
        else{
            System.out.println("Vous avez gagné !");
        }
    }

    void defend() {
        if (this.armor>0){
            this.armor--;
            System.out.println("Votre armure a été réduite. Armure : "+this.armor);
        }
        else{
            System.out.println("Votre armure est à 0, vous ne pouvez plus vous défendre.");
        }
    }
    void useConsumable(){
        if (consumable == "eat") {
            this.lifePoints = lifePoints + this.lembas.get(lembas.size() - 1).lifePointsAdded;
        }
        else if (consumable == "drink") {
            this.lifePoints = lifePoints + this.potions.get(potions.size() - 1).pointsAdded;
        }
    }
}
