import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {

    public static void main(String[] args) {
        Player player1 = new Player("Deniz", "12345", new ArrayList<>());
        Player player2 = new Player("Beste", "1907", new ArrayList<>());

        player1.getCharacters().add(new Mage("Gandalf", 100, "Male", 5, 0));
        player1.getCharacters().add(new Warrior("Aragorn", 150, "Male", 5, 0, 30, 20));

        player2.getCharacters().add(new Mage("Lagertha", 90, "Female", 4, 0));
        player2.getCharacters().add(new Warrior("Ragnar", 140.0, "Male", 4, 0, 25, 25));

        System.out.println("Before Actions:");
        player1.printPlayerInfo();
        player2.printPlayerInfo();

        player1.getCharacters().get(0).attack();
        player2.getCharacters().get(1).attack();

        System.out.println("\nAfter Actions:");
        player1.printPlayerInfo();
        player2.printPlayerInfo();

        Party party1 = new Party(new ArrayList<>(), "team1", 0, 0);
        Party party2 = new Party(new ArrayList<>(), "team2", 0, 0);

        party1.addMember(player1.getCharacters().get(0));
        party1.addMember(player1.getCharacters().get(1));
        party2.addMember(player2.getCharacters().get(0));
        party2.addMember(player2.getCharacters().get(1));


        Battle battle = new Battle(party1, party2, party1.getMembers(), party2.getMembers());
        battle.startBattle();
        ArrayList<Player> players = new ArrayList<>();
        players.add(player1);
        players.add(player2);

        printPlayerWithHighestDamage(players);

    }

    public static double calculateTotalDamage(Player player) {
        double totalDamage = 0;
        for (Character character : player.getCharacters()) {
            totalDamage += character.calculateDamage();
        }
        return totalDamage;
    }

    public static void printPlayerWithHighestDamage(ArrayList<Player> players) {
        Player playerWithHighestDamage = null;
        double highestDamage = -1;

        for (Player player : players) {
            double totalDamage = calculateTotalDamage(player);

            if (totalDamage > highestDamage) {
                highestDamage = totalDamage;
                playerWithHighestDamage = player;
            }
        }

        if (playerWithHighestDamage != null) {
            System.out.println("Player with the highest total damage: " + playerWithHighestDamage.getName());
        }
    }
}
