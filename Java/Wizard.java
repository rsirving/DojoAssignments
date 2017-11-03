public class Wizard extends Human {
    int health = 50;
    int intelligence = 8;

    public void heal(Human target){
        target.health += this.intelligence;
    }

    public void fireball(Human target){
        target.health -= this.intelligence * 3;
    }
}