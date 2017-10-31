public class ProjectTest {
    public static void main(String[] args){
        Project project = new Project();
        project.setName("Project.java");
        project.setDescription("A Java class for storing projects and descriptions.");
        project.elevatorPitch();
        Project project1 = new Project("The Second Test");
        project1.setDescription("The first one worked, but how about the second?");
        project1.elevatorPitch();
    }
}