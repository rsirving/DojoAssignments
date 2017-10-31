public class Project{
    String name;
    String description;

    // constructors
    
    public Project(){ }
    
    public Project(String name, String description){
        this.name = name;
        this.description = description;
    }

    public Project(String name){
        this.name = name;
    }

    // setters

    public void setName(String name){
        this.name = name;
    }

    public void setDescription(String description){
        this.description = description;
    }

    // getters
    
    public String getName(){
        return this.name;
    }

    public String getDescription(){
        return this.description;
    }

    public void elevatorPitch(){
        System.out.println(this.name + ": " + this.description);
    }
}