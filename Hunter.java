class Hunter extends Hero{
    Hunter(){
        int arrows=10;
        super.lifePoints = 3;
        super.armor = 4;
        super.weaponDamage = 10;
        super.lembas.add(new Food("Bread",2));
        super.potions.add(new Potion("Red",2));
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
            System.out.println("Votre armure est a 0, vous ne pouvez plus vous défendre.");
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
