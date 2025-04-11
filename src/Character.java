public class Character {
    private String name;
    private double hitpoint;
    private String gender;
    private int level;
    private int experience;

    public Character(String name,double hitpoint,String gender,int level,int experience){
        this.name=name;
        this.hitpoint=hitpoint;
        this.gender=gender;
        this.level=1;
        this.experience=0;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setHitpoint(double hitpoint) {
        this.hitpoint = hitpoint;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getName() {
        return name;
    }

    public double getHitpoint() {
        return hitpoint;
    }

    public int getLevel() {
        return level;
    }

    public int getExperience() {
        return experience;
    }

    public String getGender() {
        return gender;
    }
    public double calculateDamage(){
        return hitpoint;
    }
    public void attack(){
        System.out.println("Attacking... Damage is: "+calculateDamage());
        gainExperience(20);
    }
    public void regeneratePower(){
        System.out.println("Regenerating Power...");
    }
    public void gainExperience(int xp){
        experience+=xp;
        if (experience>=100){
            levelUp();
            experience-=100;
        }
    }
    public void levelUp(){
        level++;
    }
    public void printInfo(){
        System.out.println("*****************");
        System.out.println("Character Name: "+ name );
        System.out.println("Character hitpoint damage: "+ hitpoint);
        System.out.println("Character gender: " +gender);
        System.out.println("Character level: " + level);
        System.out.println("Character exp: "+ experience);

    }

}