public class ProjectTest {
    public static void main(String[] args) {

        ProjectClass projectone = new ProjectClass("Portafolio");
        projectone.setName("Proyecto 1");
        projectone.setDescription("Esta es la descripcion del proyecto 1");
        System.out.println("Nombre del proyecto uno: "+projectone.elevatorPitch());
        ProjectClass projecttwo = new ProjectClass("Proyecto 2");
        projecttwo.setDescription("Esta es la descripcion del proyecto 2");
        System.out.println("Nombre del proyecto dos: "+projecttwo.elevatorPitch());
        ProjectClass projectthre = new ProjectClass("Project 3", "Esta es la descripcion del proyecto 3");
        System.out.println("Nombre del proyecto tres: "+projectthre.elevatorPitch());
    }
    
}
