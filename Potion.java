import com.isep.rpg.Consumable;

public class Potion implements Consumable {
    String consumName;
    int pointsAdded;

    Potion(String consumName, int pointsAdded){
        this.consumName = consumName;
        this.pointsAdded = pointsAdded;
    }
}
