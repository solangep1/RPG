import com.isep.rpg.Consumable;

public class Food implements Consumable {
    String consumName;
    int lifePointsAdded;

    Food(String consumName, int lifePointsAdded){
        this.consumName = consumName;
        this.lifePointsAdded = lifePointsAdded;
    }
}
