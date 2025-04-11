import java.util.ArrayList;
import java.util.List;

public class Achievement{
    List<String> unlockedAchievements = new ArrayList<>();
    public Achievement(String achievement) {
        this.unlockedAchievements = new ArrayList<>();
        System.out.println("Achievement Unlocked: " + achievement);
    }
    public void addAchievment(String achievement){
        unlockedAchievements.add(achievement);
    }
    public void printAchievements() {
        System.out.println("Unlocked Achievements: " + unlockedAchievements);
    }
}
