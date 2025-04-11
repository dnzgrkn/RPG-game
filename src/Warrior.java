public class Warrior extends Character {
    private int energy;
    private int defense;

    public Warrior(String name, double hitpoint, String gender, int level, int experience, int energy, int defense) {
        super(name, hitpoint, gender, level, experience);
        this.energy = 20;
        this.defense = 5;
    }

    private void rest() {
        System.out.println("Energy: " + energy + " resting.....");
        energy += 20;
        System.out.println("Rested!" + " new energy: " + energy);
    }

    @Override
    public double calculateDamage() {
        return getHitpoint() * 1.2;
    }

    @Override
    public void attack() {
        if (energy < 10) {
            System.out.println("Not enough energy! Rest first.");
        } else {
            energy -= 10;
            super.attack();
            System.out.println("Remaining energy: " + energy);
        }
        System.out.println("Attacking... Damage is: " + calculateDamage());
        gainExperience(20);
    }

    @Override
    public void regeneratePower() {
        System.out.println("Regenerating Power...");
        rest();
    }

    @Override
    public void printInfo() {
        super.printInfo();
        System.out.println("Character energy: " + energy);
        System.out.println("Character defense: " + defense);
        System.out.println("*****************");
    }
}
