public class ProjectClass {
    private static String name;
    private static String description;
    private static double initialCost;

    public ProjectClass(){
        name = "";
        description = "";
        initialCost = 0;
    }

    public ProjectClass(String name){
        this.name = name;
    }

    public ProjectClass(String name,String description){
        this.name = name;
        this.description = description;
    }

    public ProjectClass(String name,String description, double initialCost){
        this.name = name;
        this.description = description;
        this.initialCost = initialCost;
    }

    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public double getInitialCost(){
        return this.initialCost;
    }

    public void setInitialCost(double initialCost){
        this.initialCost = initialCost;
    }

    public String getDescription(){
        return description;
    }
    public void setDescription(String description){
        this.description = description;
    }
    
    public String elevatorPitch() {
        return getName() +":"+ getDescription() +" : " + getInitialCost()  ;
    }
}