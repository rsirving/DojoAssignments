public class Dragon extends Mammal {
    int energyLevel = 300;

    public void fly(){
        System.out.println("FWOOOSH");
        this.energyLevel -= 50;
    }

    public void eatHumans(){
        System.out.println("CRUNCH");
        this.energyLevel += 25;
    }

    public void attackTown(){
        System.out.println("BURNING SOUNDS");
        this.energyLevel -= 100;
    }
}