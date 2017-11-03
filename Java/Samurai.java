public class Samurai extends Human {
    int health = 200;

    public static int counter;

    public Samurai(){
        counter++;
    }

    public void deathBlow(Human target){
        target.health = 0;
        this.health /= 2;
    }

    public void meditate(){
        this.health *= 1.5;
    }

    public int howMany(){
        return counter;
    }
}