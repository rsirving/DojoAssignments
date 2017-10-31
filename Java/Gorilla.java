public class Gorilla extends Mammal {

    public void throwSomething(){
        System.out.println("The gorilla has thrown something.");
        this.energyLevel -= 5;
    }

    public void eatBanana(){
        System.out.println("The gorilla enjoys the banana.");
        this.energyLevel += 10;
    }

    public void climb(){
        System.out.println("The gorilla climbed a tree.");
        this.energyLevel -= 10;
    }

}