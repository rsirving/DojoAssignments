public class HumanTest{
    public static void main(String[] args) {
        Human attacker = new Human();
        Human victim = new Human();
        attacker.attack(victim);
        System.out.println(victim.health);
    }
}