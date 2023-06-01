package com.codingdojo.ricardo.herencia;

public class Auto extends Vehiculo implements ManejarVehiculo{
    
    private String placas;

    public Auto(int año, String marca, String modelo, String color, int ruedas, String placas) {
        super(año, marca, modelo, color, ruedas);
        this.placas = placas;
    }

    public String getPlacas() {
        return placas;
    }
    public void setPlacas(String placas) {
        this.placas = placas;
    }

    //Polimofirmo : el tener el mismo metodo con las mismas clases pero con distintos comportamientos

    public void imprimir(){
        //System.out.println("El auto es del año: "+this.getAño()+" Marca:"+this.getMarca()+" Modelo:"+this.getModelo());
        super.imprimir();
        System.out.println("Placas: "+this.getPlacas());
    }
    public void acelerar(){
        System.out.println("Voy a acelerar!");
        velocidad += aumento;
        System.out.println("Mi velocidad es de: "+velocidad);
    }
    public void desacelerar(){
        System.out.println("Voy a desacelerar!");
        velocidad -= aumento;
        System.out.println("Mi velocidad es de: "+velocidad);
    }
}
