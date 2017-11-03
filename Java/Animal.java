public abstract class Animal {
    private String species;
    private String name;
    private int numLegs;
    private String gender;
    private String diet;

    // public Animal(){
        
    // }

    // public Animal(String name, int numLegs, String species, String gender, String diet){
    //     this.name = name;
    //     this.numLegs = numLegs;
    //     this.species = species;
    //     this.gender = gender;
    //     this.diet = diet;
    // }

    // public Animal(String name, int numLegs){
    //     this.name = name;
    //     this.numLegs = numlegs;
    // }

    abstract void walk();
    abstract void sleep();
    abstract void eat();
    public static void main(String[] args){

    }
}