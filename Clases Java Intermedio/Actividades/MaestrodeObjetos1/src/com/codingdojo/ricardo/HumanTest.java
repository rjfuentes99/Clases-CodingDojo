package com.codingdojo.ricardo;

import com.codingdojo.ricardo.Human;

public class HumanTest {
    public static void main(String[] args) {
        Human human = new Human();
        Human slime = new Human();
        Wizard wizard = new Wizard();
        Wizard otherHuman = new Wizard();
        Ninja ninja = new Ninja();
        Samurai samurai = new Samurai();

        human.atack(slime);
        System.out.println("El humano ha golpeado al Slime y su vida ahora es: "+slime.getHealth());
        human.atack(slime);
        human.atack(slime);
        System.out.println("El humano ha golpeado al Slime y su vida ahora es: "+slime.getHealth());

        // Segunda actividad
        // Mago
        wizard.healSkill(otherHuman);
        System.out.println("La skill afecto a su compañero y le curo: "+otherHuman.getIntelligence()+" puntos de vida");

        wizard.fireBallSkill(slime);
        System.out.println("El mago ha lanzado un hechizo al Slime y su vida ahora es: "+slime.getHealth());

        // com.codingdojo.ricardo.Ninja
        ninja.steal(slime);
        System.out.println("El ninja recupera "+ninja.getStealth()+" puntos de vida");
        ninja.runAway(ninja);
        System.out.println("El ninja desaparece una cortina de humo invocada con su sangre y su vida queda en : "+ninja.getHealth()+" puntos de vida");

        // com.codingdojo.ricardo.Samurai
        samurai.deathBlow(slime);
        System.out.println("El samurai usa hace un corte potente contra el slime y la vida del slime queda en: "+slime.getHealth());
        samurai.meditate(samurai);
        System.out.println("El samurai recupera su vida despues de meditar en un aura extraña y su vida queda en: "+samurai.getHealth());
    }
}