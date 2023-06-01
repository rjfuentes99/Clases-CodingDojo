public class Human{
    private int strength, stealth, intelligence, health;

    public Human() {
        this.strength = 3;
        this.stealth = 3;
        this.intelligence = 3;
        this.health = 100;
    }

    public int getStrength() {
        return strength;
    }
    public int getHealth() {
        return health;
    }
    public void setHealth(int health) {
        this.health = health;
    }

    public int getStealth() {
        return stealth;
    }

    public void setStealth(int stealth) {
        this.stealth = stealth;
    }

    public int getIntelligence() {
        return intelligence;
    }

    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }


    public void setStrength(int strength) {
        this.strength = strength;
    }
    public void atack(Human Slime){
        int damage = Slime.getHealth();
        damage -= getStrength();
        Slime.setHealth(damage);
        System.out.println("El humano ataca al mounstro(Slime)");
    }


}
