import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Combien de héros voulez-vous ?");
        int nbrHero = scanner.nextInt();

        System.out.println("1 - Hunter\n2 - Warrior\n3 - Mage\n4 - Healer");
        System.out.println("Quel type de héros souhaitez-vous ?");
        int typeHero = scanner.nextInt();

        Game game = new Game();
        game.generateCombat();
    }
}
