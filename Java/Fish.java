public class Fish extends Animal{
    
    public Fish(){

    }

    public Fish(String name, int numLegs, String species, String gender, String diet){
        super(name,numLegs,species,gender,diet);
    }
    public void eat(){
        System.out.println("FISH NOISES");
    }
}