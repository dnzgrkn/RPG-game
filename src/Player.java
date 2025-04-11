import java.util.ArrayList;

public class Player {
    private String name;
    private String password;
    private ArrayList<Character> characters;


    public Player(String name, String password, ArrayList<Character> characters) {
        this.name = name;
        this.password = password;
        this.characters = new ArrayList<>();

    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setCharacters(ArrayList<Character> characters) {
        this.characters = characters;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public ArrayList<Character> getCharacters() {
        return characters;
    }

    public void printPlayerInfo() {
        System.out.println("Name: " + name);
        System.out.println("Password: " + "*********");
        for (Character a : characters) {
            a.printInfo();
        }
    }

    public void totalDamage(Player player) {
        double total = 0.0;
        for (int i = 0; i < player.characters.size(); i++) {
            total += player.characters.get(i).calculateDamage();
        }
    }
}