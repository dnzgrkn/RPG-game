import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Battle {
    private Party team1;
    private Party team2;
    private List<Character> characters1;
    private List<Character> characters2;

    public Battle(Party team1, Party team2, List<Character> characters1,List<Character> characters2){
        this.team1=team1;
        this.team2=team2;
        this.characters1=characters1;
        this.characters2=characters2;

    }
    public void formTeams(){
        Collections.shuffle(team1.getMembers());
        Collections.shuffle(team2.getMembers());
        characters1.add(team1.getMembers().get(0));
        characters1.add(team1.getMembers().get(1));
        characters1.add(team1.getMembers().get(2));
        characters2.add(team2.getMembers().get(0));
        characters2.add(team2.getMembers().get(1));
        characters2.add(team2.getMembers().get(2));

    }
    public void startBattle(){
        while(!characters1.isEmpty()&&!characters2.isEmpty()){
            Character attacker;
            Character defender;
            if (decideAttacker()==true){
                attacker = characters1.get(0);
                defender = characters2.get(0);

            } else {
                defender = characters1.get(0);
                attacker = characters2.get(0);
            }

            double damageDiff = attack(attacker, defender);
            System.out.println(attacker.getName() + " attacks " + defender.getName() + "!");
            System.out.println("Damage dealt: " + attacker.calculateDamage());
            System.out.println("Remaining hitpoints of " + defender.getName() + ": " + defender.getHitpoint());

            if (defender.getHitpoint() <= 0) {
                System.out.println(defender.getName() + " has fallen in battle!");

                if (characters1.contains(defender)) {
                    characters1.remove(defender);
                    System.out.println(defender.getName() + " has been removed from Party 1.");
                } else {
                    characters2.remove(defender);
                    System.out.println(defender.getName() + " has been removed from Party 2.");
                }
            }
        }
        declareWinner();
    }

    public double attack(Character attacker, Character defender) {
        defender.getHitpoint();
        attacker.calculateDamage();
        double difference = defender.getHitpoint()-attacker.calculateDamage();
        defender.setHitpoint(defender.getHitpoint()-attacker.calculateDamage());
        if (defender.getHitpoint() <= 0) {
            System.out.println(defender.getName() + " has fallen!");
        }
        return difference;
    }

    public boolean decideAttacker(){
        Random r =new Random();
        int a = r.nextInt(100);
        if (a%2==0){
            return true;
        }
        return false;
    }
    private void declareWinner() {
        if (characters1.isEmpty()) {
            System.out.println("Party 2 Wins!");
        } else if (characters2.isEmpty()) {
            System.out.println("Party 1 Wins!");
        }
    }

}