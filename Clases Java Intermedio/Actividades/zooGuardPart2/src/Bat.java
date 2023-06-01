public class Bat extends Mammal {

    public void fly(){
        System.out.println("Fleeeew, zooooom");
        energyLevel -= 50;
    }
    public void eatHumans(){
        System.out.println("Bueno, no importa");
        energyLevel += 25;
    }
    public void attackTown(){
        System.out.println("Buuumm , crack ");
        energyLevel -= 100;
    }
}
