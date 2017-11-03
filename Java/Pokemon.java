public class Pokemon{
    String name;
    int health;
    String type;
    private static int count = 0;

    public String getName(){
        return this.name;
    }
    public void setName(String name){
        this.name = name;
    }
    public int getHealth(){
        return this.health;
    }
    public void setHealth(int health){
        this.health = health;
    }
    public String getType(){
        return this.type;
    }
    public void setType(String type){
        this.type = type;
    }

    public Pokemon(String name, int health, String type){
        this.name = name;
        this.health = health;
        this.type = type;
        count++;
    }
}