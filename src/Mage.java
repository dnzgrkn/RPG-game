import java.util.Random;

public class Mage extends Character{
    private int mana;
    private double criticalChance;
    public Mage(String name,double hitpoint,String gender,int  level,int experience,int mana,double criticalChance){
        super(name, hitpoint, gender, level, experience);
        this.mana=10;
        this.criticalChance=0.1;
    }

    public Mage(String name, double hitpoint, String gender, int level, int experience) {
        super(name, hitpoint, gender, level, experience);
        mana=10;
        criticalChance=0.1;
    }
    public boolean isCritical(){
        Random r = new Random();
        int isCrit=r.nextInt(10);
        if (isCrit==5){
            return true;
        }
        else {
            return false;
        }
    }
    private void drinkPotion(){
        mana+=10;
        System.out.println("New mana: "+ mana);
    }
    @Override
    public double calculateDamage(){
        return getHitpoint()*0.8;
    }
    @Override
    public void attack(){
        if (mana<5){
            System.out.println("Not enough mana. Drink Potion first.");
        } else{
            mana-=10;
            super.attack();
            System.out.println("Remaining energy: "+ mana);
        }
        System.out.println("Attacking... Damage is: "+calculateDamage());
        gainExperience(20);
    }
    @Override
    public void regeneratePower(){
        System.out.println("Regenerating Power...");
        drinkPotion();
    }
    @Override
    public void printInfo(){
        super.printInfo();
        System.out.println("Character mana: "+ mana);
        System.out.println("Character critical chance: "+ criticalChance);
        System.out.println("*****************");
    }
}