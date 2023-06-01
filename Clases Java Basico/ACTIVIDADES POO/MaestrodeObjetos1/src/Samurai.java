public class Samurai extends Human{

    public Samurai(){
        setHealth(200);
    }

    public void deathBlow(Human Slime){
        int health = Slime.getHealth();
        health -= Slime.getHealth();
        Slime.setHealth(health);
        System.out.println("El samurai usa su habilidad especial contra el slime");
    }
    public void meditate(Samurai Samurai){
        int heal = Samurai.getHealth();
        heal += (getHealth()/2);
        Samurai.setHealth(heal);
        System.out.println("El samurai se pone a meditar para recuperar su vida");
    }
}

