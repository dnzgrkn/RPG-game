import java.util.ArrayList;

public class Party {
    private String partyName;
    private ArrayList<Character> members;
    private int powerBalance;
    private int reputation;

    public Party(ArrayList<Character> members,String partyName,int powerBalance, int reputation) {
        this.partyName=partyName;
        this.powerBalance=powerBalance;
        this.reputation=reputation;
        this.members=new ArrayList<>();
    }
    public ArrayList<Character> getMembers() {
        return members;
    }
    public int getPowerBalance() {
        return powerBalance;
    }

    public int getReputation() {
        return reputation;
    }

    public String getPartyName() {
        return partyName;
    }

    public void setMembers(ArrayList<Character> members) {
        this.members = members;
    }

    public void setPartyName(String partyName) {
        this.partyName = partyName;
    }

    public void setReputation(int reputation) {
        this.reputation = reputation;
    }

    public void setPowerBalance(int powerBalance) {
        this.powerBalance = powerBalance;
    }


    public void addMember(Character character){
        if (members.size()<10){
            members.add(character);
        } else {
            System.out.println("Party is full!");
        }
    }
    public void removeMember(Character character){
        members.remove(character);
    }
    public void calculatPowerBalance(){

        for (Character a: members) {
            setPowerBalance(getPowerBalance()+(int)a.calculateDamage());
        }
    }
    public void calculateReputation(){
        for (Character a: members) {
            setReputation((getReputation())+ a.getLevel());
        }

    }
    public void printPartyInfo(){
        System.out.println("***********");
        System.out.println("Party name: "+ partyName);
        System.out.print("Party members: ");
        for (Character a : members) {
            System.out.print(a.getName() + " ");
        }
        System.out.println(" ");
        System.out.println("Party Power Balance: "+ powerBalance);
        System.out.println("Party Total Reputation: "+ reputation);

    }
}