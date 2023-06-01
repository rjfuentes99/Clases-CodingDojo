public class Wizard extends Human{

    public Wizard() {
        super();
        setHealth(50);
        setIntelligence(8);
    }
    public void healSkill(Wizard otherHuman){
        int heal = otherHuman.getHealth();
        heal += getIntelligence();
        otherHuman.setHealth(heal);
        System.out.println("El mago cura a su compañero");


    }
    public void fireBallSkill(Human Slime){
        int health = Slime.getHealth();
        health -= this.getIntelligence() * 3;
        Slime.setHealth(health);
        System.out.println("El mago cura a su compañero");

    }
}
