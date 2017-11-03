public class Bird extends Animal{

    public Bird(){

    }

    public Bird(String name, int numLegs, String species, String gender, String diet){
        super(name,numLegs,species,gender,diet);
    }
    public void eat(){
        System.out.println("PECK PECK");
    }
}