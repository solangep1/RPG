class Warrior extends Hero{
    public Warrior(){
        super.lifePoints=4;
        super.armor=7;
        super.weaponDamage=5;
        super.lembas.add(new Food("Orange",2));
        super.lembas.add(new Food("Nuts",3));
        super.potions.add(new Potion("Green",1));
        super.potions.add(new Potion("Dark",2));

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
