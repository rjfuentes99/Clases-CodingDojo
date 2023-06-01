package com.codingdojo.ricardo.herencia;

public class Bicicleta extends Vehiculo implements ManejarVehiculo{
    

    
    public Bicicleta(int año, String marca, String modelo, String color, int ruedas) {
        super(año, marca, modelo, color, ruedas);
    }
    public void acelerar(){
        System.out.println("Voy a pedalear mas rapido!");
        velocidad += 1;
        System.out.println("Mi velocidad es de: "+velocidad);
    }
    public void desacelerar(){
        System.out.println("Voy a apretar el freno");
        velocidad -= 1;
        System.out.println("Mi velocidad es de: "+velocidad);
    }
}
