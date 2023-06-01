package com.codingdojo.ricardo;

public class Ninja extends Human {

    public Ninja() {
        setStealth(15);
    }
    public void steal(Human Slime){
        int damage = Slime.getHealth();
        damage -= getStealth();

        int health = getHealth();
        health += getStealth();

        Slime.setHealth(damage);
        setHealth(health);
        System.out.println("El ninja corta al slime y absorbe su sangre");

    }
    public void runAway(Ninja Ninja){
        int damage = Ninja.getHealth();
        damage -= 20;
        Ninja.setHealth(damage);
        System.out.println("El ninja se ve en peligro y se esfuma en una cortina de humo");
    }
}
